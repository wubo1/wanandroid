package com.wubo.wanandroid.ui.home.vm;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.bean.HotKeyBean;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.ui.home.act.SearchResultActivity;
import com.wubo.wanandroid.utils.OnItemClickListener;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Author: wubo
 * Create on: 2019/4/8 14:14
 * Description:
 */
public class SearchVm extends BaseViewModel {

    public ObservableField<String> searchContent=new ObservableField();
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable{
        public ObservableArrayList<HotKeyBean.DataBean> items=new ObservableArrayList<>();
    }

    public SearchVm(@NonNull Application application) {
        super(application);
    }

    public BindingCommand cancel= new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });

    public BindingCommand clearContent=new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            searchContent.set("");
        }
    });

    public BindingCommand toSearchResult= new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Bundle bundle=new Bundle();
            bundle.putString("search",searchContent.get());
            startActivity(SearchResultActivity.class,bundle);
        }
    });

}
