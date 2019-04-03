package com.wubo.wanandroid.ui.my.act;

import android.os.Bundle;
import android.view.View;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.databinding.ActivityRegisterBinding;
import com.wubo.wanandroid.ui.my.vm.RegisterVm;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * Author: wubo
 * Create on: 2019/3/29 14:38
 * Description:
 */
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding,RegisterVm> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_register;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        binding.topLl.setTitle("注册");
        binding.topLl.leftImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
