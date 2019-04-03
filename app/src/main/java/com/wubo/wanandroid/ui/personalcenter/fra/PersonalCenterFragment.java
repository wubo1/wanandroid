package com.wubo.wanandroid.ui.personalcenter.fra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.wanandroid.R;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.config.NetConstant;
import com.wubo.wanandroid.databinding.FragmentPersonalCenterBinding;
import com.wubo.wanandroid.ui.personalcenter.vm.PersonalCenterVm;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.utils.SPUtils;


/**
 * Author: wubo
 * Create on: 2019/3/25 14:38
 * Description:
 */
public class PersonalCenterFragment extends BaseFragment<FragmentPersonalCenterBinding,PersonalCenterVm> {

    public static PersonalCenterFragment newInstance(){
        Bundle bundle=new Bundle();
        PersonalCenterFragment personalCenterFragment =new PersonalCenterFragment();
        personalCenterFragment.setArguments(bundle);
        return personalCenterFragment;
    }
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_personal_center;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onStart() {
        super.onStart();
        binding.personalCenterRefresh.autoRefresh();
        viewModel.refreshLoginData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Messenger.getDefault().register(this, ConstantConfig.TOKEN_LOGOUT_LOGIN, new BindingAction() {
            @Override
            public void call() {
                binding.personalCenterRefresh.autoRefresh();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
    }
}
