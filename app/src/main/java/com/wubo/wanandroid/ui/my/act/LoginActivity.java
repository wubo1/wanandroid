package com.wubo.wanandroid.ui.my.act;

import android.os.Bundle;
import android.view.View;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.databinding.ActivityLoginBinding;
import com.wubo.wanandroid.ui.my.vm.LoginVm;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * Author: wubo
 * Create on: 2019/3/29 11:11
 * Description:
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginVm> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        binding.topLl.setTitle("登录");
        binding.topLl.leftImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
