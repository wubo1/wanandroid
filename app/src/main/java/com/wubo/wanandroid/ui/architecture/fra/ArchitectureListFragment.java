package com.wubo.wanandroid.ui.architecture.fra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.bean.ArchitectureBean;
import com.wubo.wanandroid.databinding.FragmentArchitectureListBinding;
import com.wubo.wanandroid.ui.architecture.vm.ArchitectureListVm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Author: wubo
 * Create on: 2019/3/28 15:47
 * Description:
 */
public class ArchitectureListFragment extends BaseFragment<FragmentArchitectureListBinding,
        ArchitectureListVm> {

    private List<BaseFragment> mFragments;
    private ArchitectureListAdapter architectureListAdapter;
    private List<ArchitectureBean.DataBean.ChildrenBean> childrenBeans = new ArrayList<>();

    public static ArchitectureListFragment newInstance(List<ArchitectureBean.DataBean
            .ChildrenBean> bean) {
        Bundle bundle = new Bundle();
        ArchitectureListFragment wXarticleFragment = new ArchitectureListFragment();
        bundle.putSerializable("children", (Serializable) bean);
        wXarticleFragment.setArguments(bundle);
        return wXarticleFragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return R.layout.fragment_architecture_list;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        initTopTab();
    }


    private void initTopTab() {
        childrenBeans = (List<ArchitectureBean.DataBean.ChildrenBean>) getArguments()
                .getSerializable("children");
        architectureListAdapter = new ArchitectureListAdapter(getChildFragmentManager());
        mFragments = new ArrayList<>();
        if (childrenBeans.size() > 0) {
            for (int i = 0; i < childrenBeans.size(); i++) {
                mFragments.add(ArchitectureListChildrenFragment.newInstance(String.valueOf(childrenBeans.get(i).getId())));
            }
        }

        architectureListAdapter.setFragments(mFragments);
        binding.architectureListViewpager.setAdapter(architectureListAdapter);
        binding.pagerTab.setViewPager(binding.architectureListViewpager);
        binding.architectureListViewpager.setCurrentItem(0);

    }

    public class ArchitectureListAdapter extends FragmentPagerAdapter {
        private List<BaseFragment> mFragments = new ArrayList<>();

        public ArchitectureListAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return childrenBeans.get(position).getName();
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void setFragments(List<BaseFragment> mFragments) {
            this.mFragments = mFragments;
        }
    }
}
