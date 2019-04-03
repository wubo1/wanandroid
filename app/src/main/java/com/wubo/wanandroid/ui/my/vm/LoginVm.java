package com.wubo.wanandroid.ui.my.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.config.NetConstant;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.ui.my.act.RegisterActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.utils.SPUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Author: wubo
 * Create on: 2019/3/29 11:12
 * Description:
 */
public class LoginVm extends BaseViewModel {

    public ObservableField<String> userName=new ObservableField<>();

    public ObservableField<String> password =new ObservableField<>();

    public LoginVm(@NonNull Application application) {
        super(application);
    }

    public BindingCommand gotoLogin =new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (userName.get().length()<=6||password.get().length()<=6){
                ToastUtils.showShort("账号或者密码长度必须大于6位！");
                return;
            }
            gotoLoginData();
        }
    });

    private void gotoLoginData() {
        NetRequest.login(userName.get(), password.get(), getLifecycleProvider(), new BaseNetObserver<BaseBean>() {

            @Override
            public void onSuccess(BaseBean data) {
                SPUtils.getInstance().put(NetConstant.USERNAME, userName.get() );
                SPUtils.getInstance().put(NetConstant.ISLOGIN,true);
                Messenger.getDefault().sendNoMsg(ConstantConfig.TOKEN_LOGOUT_LOGIN);
                finish();
            }

            @Override
            public void onFail(Throwable t) {

            }
        });
    }

    public BindingCommand gotoRegistView =new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(RegisterActivity.class);
        }
    });

}
