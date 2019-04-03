package com.wubo.wanandroid.ui.architecture.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.wubo.wanandroid.bean.ArchitectureBean;
import com.wubo.wanandroid.bean.WXarticleBean;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.ui.wxarticle.vm.WXarticleVm;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Author: wubo
 * Create on: 2019/3/28 17:06
 * Description:
 */
public class ArchitectureVm extends BaseViewModel {

    public ArchitectureVm(@NonNull Application application) {
        super(application);
    }

    public UIChangeObservable uiChangeObservable=new UIChangeObservable();

    public class UIChangeObservable {
        public ObservableField<ArchitectureBean> tabBean=new ObservableField<>();
    }

    @Override
    public void onStart() {
        super.onStart();
        requestProjectTabData();
    }

    private void requestProjectTabData() {
        NetRequest.architecture(getLifecycleProvider(), new BaseNetObserver<ArchitectureBean>() {
            @Override
            public void onSuccess(ArchitectureBean data) {
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
