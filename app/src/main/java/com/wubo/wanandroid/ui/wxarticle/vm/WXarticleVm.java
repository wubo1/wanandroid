package com.wubo.wanandroid.ui.wxarticle.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.wubo.wanandroid.bean.ProjectTabBean;
import com.wubo.wanandroid.bean.WXarticleBean;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.ui.projects.vm.ProjectsVm;

import me.goldze.mvvmhabit.base.BaseViewModel;

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
