package com.wubo.wanandroid.ui.wxarticle.vm;

import android.app.Application;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.wubo.wanandroid.bean.ProjectTabBean;
import com.wubo.wanandroid.bean.WXarticleBean;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.config.NetConstant;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.ui.projects.vm.ProjectsVm;
import com.wubo.wanandroid.ui.wxarticle.fra.WXarticleFragment;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.utils.SPUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Author: wubo
 * Create on: 2019/3/28 15:49
 * Description:
 */
public class WXarticleVm extends BaseViewModel {

    public WXarticleVm(@NonNull Application application) {
        super(application);
    }

    public UIChangeObservable uiChangeObservable=new UIChangeObservable();

    public class UIChangeObservable {
        public ObservableField<WXarticleBean> tabBean=new ObservableField<>();
    }

    public ObservableField<String> searchContent=new ObservableField<>();

    public BindingCommand clearContent = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            searchContent.set("");
        }
    });

    public BindingCommand searchImg = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            WXarticleFragment.searchKey=searchContent.get();
            Messenger.getDefault().sendNoMsg(ConstantConfig.SEARCHKEY);
        }
    });

    @Override
    public void onStart() {
        super.onStart();
        requestProjectTabData();
    }

    private void requestProjectTabData() {
        NetRequest.wxarticleTab(getLifecycleProvider(), new BaseNetObserver<WXarticleBean>() {
            @Override
            public void onSuccess(WXarticleBean data) {
                if (data.getData().size()>0){
                    uiChangeObservable.tabBean.set(data);
                }
            }

            @Override
            public void onFail(Throwable t) {

            }
        });
    }
}
