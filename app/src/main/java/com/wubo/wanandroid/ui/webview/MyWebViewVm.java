package com.wubo.wanandroid.ui.webview;

import android.app.Application;
import android.support.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Author: wubo
 * Create on: 2019/3/26 17:59
 * Description:
 */
public class MyWebViewVm extends BaseViewModel {

    public MyWebViewVm(@NonNull Application application) {
        super(application);
    }

    public BindingCommand finishCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });
}
