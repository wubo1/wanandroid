package com.wubo.wanandroid.ui.architecture.fra;

import android.databinding.Observable;
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
import com.wubo.wanandroid.databinding.FragmentArchitectureBinding;
import com.wubo.wanandroid.ui.architecture.vm.ArchitectureVm;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Author: wubo
 * Create on: 2019/3/28 15:47
 * Description:
 */
public class ArchitectureFragment extends BaseFragment<FragmentArchitectureBinding,
        ArchitectureVm> {

    private List<BaseFragment> mFragments;
    private ArchitectureAdapter architectureAdapter;

    public static ArchitectureFragment newInstance() {
        Bundle bundle = new Bundle();
        ArchitectureFragment wXarticleFragment = new ArchitectureFragment();
        wXarticleFragment.setArguments(bundle);
        return wXarticleFragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return R.layout.fragment_architecture;
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
        binding.topLl.setTitle("体系");
        binding.topLl.leftImage.setVisibility(View.GONE);

        viewModel.uiChangeObservable.tabBean.addOnPropertyChangedCallback(new Observable
                .OnPropertyChangedCallback() {

            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                architectureAdapter = new ArchitectureAdapter(getChildFragmentManager());
                mFragments = new ArrayList<>();
                List<ArchitectureBean.DataBean> dataBean = new ArrayList<>();
                dataBean = viewModel.uiChangeObservable.tabBean.get().getData();
                if (dataBean.size() > 0) {
                    for (int i = 0; i < dataBean.size(); i++) {
                        mFragments.add(ArchitectureListFragment.newInstance(dataBean.get(i).getChildren()));
                    }
                }
                architectureAdapter.setFragments(mFragments);
                binding.architectureViewpager.setAdapter(architectureAdapter);
                binding.pagerTab.setViewPager(binding.architectureViewpager);
                binding.architectureViewpager.setCurrentItem(0);
            }
        });

    }

    public class ArchitectureAdapter extends FragmentPagerAdapter {
        private List<BaseFragment> mFragments = new ArrayList<>();

        public ArchitectureAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return viewModel.uiChangeObservable.tabBean.get().getData().get(position).getName();
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
