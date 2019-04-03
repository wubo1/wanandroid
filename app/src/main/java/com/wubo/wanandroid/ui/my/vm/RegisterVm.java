package com.wubo.wanandroid.ui.my.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.wubo.wanandroid.bean.RegisterBean;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Author: wubo
 * Create on: 2019/3/29 14:39
 * Description:
 */
public class RegisterVm extends BaseViewModel {

    public ObservableField<String> userNameR=new ObservableField<>();

    public ObservableField<String> passwordR =new ObservableField<>();

    public ObservableField<String> repasswordR =new ObservableField<>();

    public RegisterVm(@NonNull Application application) {
        super(application);
    }

    public BindingCommand gotoRegist =new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (userNameR.get().length()<=6||passwordR.get().length()<=6||repasswordR.get()
                    .length()<=6){
                ToastUtils.showShort("账号或者密码长度必须大于6位！");
                return;
            }
            if (!passwordR.get().equals(repasswordR.get())){
                ToastUtils.showShort("两次密码需保持一致！");
                return;
            }
            requestRegisterData();
        }
    });

    private void requestRegisterData() {
        NetRequest.register(userNameR.get(), passwordR.get(), repasswordR.get(),
                getLifecycleProvider(), new BaseNetObserver<RegisterBean>() {

            @Override
            public void onSuccess(RegisterBean data) {
                ToastUtils.showShort("注册成功！");
                finish();
            }

            @Override
            public void onFail(Throwable t) {

            }
        });
    }
}
