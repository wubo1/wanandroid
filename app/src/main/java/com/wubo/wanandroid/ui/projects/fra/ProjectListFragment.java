package com.wubo.wanandroid.ui.projects.fra;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.databinding.FragmentProjectListBinding;
import com.wubo.wanandroid.ui.projects.vm.ProjectListVm;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.bus.Messenger;

/**
 * Author: wubo
 * Create on: 2019/3/28 11:50
 * Description:
 */
public class ProjectListFragment extends BaseFragment<FragmentProjectListBinding,ProjectListVm> {

    String cid;

    public static ProjectListFragment newInstance(String cid){
        Bundle bundle =new Bundle();
        ProjectListFragment projectListFragment=new ProjectListFragment();
        bundle.putString("cid",cid);
        projectListFragment.setArguments(bundle);
        return projectListFragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return R.layout.fragment_project_list;
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
                binding.projectListRefresh.autoRefresh();
            }
        });
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        cid=getArguments().getString("cid");
        viewModel.cid.set(cid);
        binding.projectListRefresh.autoRefresh();
    }
}
