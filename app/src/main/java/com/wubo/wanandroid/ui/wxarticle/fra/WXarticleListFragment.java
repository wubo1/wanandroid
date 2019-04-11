package com.wubo.wanandroid.ui.wxarticle.fra;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.databinding.FragmentWxarticleListBinding;
import com.wubo.wanandroid.ui.wxarticle.vm.WXarticleListVm;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.bus.Messenger;

/**
 * Author: wubo
 * Create on: 2019/3/28 11:50
 * Description:
 */
public class WXarticleListFragment extends BaseFragment<FragmentWxarticleListBinding,WXarticleListVm> {

    String id;

    public static WXarticleListFragment newInstance(String id){
        Bundle bundle =new Bundle();
        WXarticleListFragment projectListFragment=new WXarticleListFragment();
        bundle.putString("id",id);
        projectListFragment.setArguments(bundle);
        return projectListFragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return R.layout.fragment_wxarticle_list;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Messenger.getDefault().register(this, ConstantConfig.TOKEN_LOGOUT_LOGIN, new BindingAction() {
            @Override
            public void call() {
                binding.wxarticleListRefresh.autoRefresh();
            }
        });

        Messenger.getDefault().register(this, ConstantConfig.SEARCHKEY, new BindingAction() {
            @Override
            public void call() {
                binding.wxarticleListRefresh.autoRefresh();
            }
        });
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        id=getArguments().getString("id");
        viewModel.cid.set(id);
        binding.wxarticleListRefresh.autoRefresh();
    }
}
