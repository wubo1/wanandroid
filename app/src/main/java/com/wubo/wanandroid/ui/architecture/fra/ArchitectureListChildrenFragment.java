package com.wubo.wanandroid.ui.architecture.fra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.databinding.FragmentArchitectureListChildrenBinding;
import com.wubo.wanandroid.ui.architecture.vm.ArchitectureListChildrenVm;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.bus.Messenger;

/**
 * Author: wubo
 * Create on: 2019/3/28 15:47
 * Description:
 */
public class ArchitectureListChildrenFragment extends
        BaseFragment<FragmentArchitectureListChildrenBinding, ArchitectureListChildrenVm> {

    private String cid;

    public static ArchitectureListChildrenFragment newInstance(String cid) {
        Bundle bundle = new Bundle();
        ArchitectureListChildrenFragment architectureListChildrenFragment = new
                ArchitectureListChildrenFragment();
        bundle.putString("cid", cid);
        architectureListChildrenFragment.setArguments(bundle);
        return architectureListChildrenFragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return R.layout.fragment_architecture_list_children;
    }

    @Override
    public int initVariableId() {
        binding.architectureListChildrenRefresh.autoRefresh();
        return BR.viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Messenger.getDefault().register(this, ConstantConfig.TOKEN_LOGOUT_LOGIN, new BindingAction() {
            @Override
            public void call() {
                binding.architectureListChildrenRefresh.autoRefresh();
            }
        });
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        cid = getArguments().getString("cid");
        viewModel.cid.set(cid);

    }

}
