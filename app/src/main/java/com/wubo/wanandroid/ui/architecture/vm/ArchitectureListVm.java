package com.wubo.wanandroid.ui.architecture.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.wubo.wanandroid.bean.ArchitectureBean;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Author: wubo
 * Create on: 2019/3/28 17:06
 * Description:
 */
public class ArchitectureListVm extends BaseViewModel {

    public ArchitectureListVm(@NonNull Application application) {
        super(application);
    }

}
