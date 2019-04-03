package com.wubo.wanandroid.ui.projects.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.wubo.wanandroid.bean.ProjectTabBean;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Author: wubo
 * Create on: 2019/3/28 09:45
 * Description:
 */
public class ProjectsVm extends BaseViewModel {

    public ProjectsVm(@NonNull Application application) {
        super(application);
    }

    public UIChangeObservable uiChangeObservable=new UIChangeObservable();

    public class UIChangeObservable {
        public ObservableField<ProjectTabBean> tabBean=new ObservableField<>();
    }

    @Override
    public void onStart() {
        super.onStart();
        requestProjectTabData();
    }

    private void requestProjectTabData() {
        NetRequest.projectTab(getLifecycleProvider(), new BaseNetObserver<ProjectTabBean>() {
            @Override
            public void onSuccess(ProjectTabBean data) {
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
