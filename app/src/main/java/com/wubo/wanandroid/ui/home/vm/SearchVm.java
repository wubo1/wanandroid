package com.wubo.wanandroid.ui.home.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.wubo.wanandroid.bean.FriendBean;
import com.wubo.wanandroid.bean.HotKeyBean;
import com.wubo.wanandroid.bean.SearchResultBean;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.ui.home.act.SearchResultActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Author: wubo
 * Create on: 2019/4/8 14:14
 * Description:
 */
public class SearchVm extends BaseViewModel {

    public ObservableField<String> searchContent = new ObservableField();
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        public ObservableField<HotKeyBean> hotKeyBean = new ObservableField<>();
        public ObservableField<FriendBean> friendBean = new ObservableField<>();
    }

    public SearchVm(@NonNull Application application) {
        super(application);
    }

    public BindingCommand cancel = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });

    public BindingCommand searchImg = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (searchContent.get() != null && searchContent.get().length() > 0) {
                gotoSearchResult();
            } else {
                ToastUtils.showShort("请输入搜索内容");
            }
        }
    });

    public BindingCommand clearContent = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            searchContent.set("");
        }
    });

    public BindingCommand toSearchResult = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            gotoSearchResult();
        }
    });

    private void gotoSearchResult() {
        Bundle bundle = new Bundle();
        bundle.putString("search", searchContent.get());
        startActivity(SearchResultActivity.class, bundle);
    }

    public void search() {
        NetRequest.hotKey(getLifecycleProvider(), new BaseNetObserver<HotKeyBean>() {
            @Override
            public void onSuccess(HotKeyBean data) {
                uc.hotKeyBean.set(data);
            }

            @Override
            public void onFail(Throwable t) {

            }
        });
        NetRequest.friend(getLifecycleProvider(), new BaseNetObserver<FriendBean>() {
            @Override
            public void onSuccess(FriendBean data) {
                uc.friendBean.set(data);
            }

            @Override
            public void onFail(Throwable t) {

            }
        });
    }
}
