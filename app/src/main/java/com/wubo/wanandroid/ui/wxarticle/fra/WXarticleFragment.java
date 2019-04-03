package com.wubo.wanandroid.ui.wxarticle.fra;

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
import com.wubo.wanandroid.bean.WXarticleBean;
import com.wubo.wanandroid.databinding.FragmentWxartcleBinding;
import com.wubo.wanandroid.ui.projects.fra.ProjectsFragment;
import com.wubo.wanandroid.ui.wxarticle.vm.WXarticleVm;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Author: wubo
 * Create on: 2019/3/28 15:47
 * Description:
 */
public class WXarticleFragment extends BaseFragment<FragmentWxartcleBinding,WXarticleVm> {

    private List<BaseFragment> mFragments;
    private WXarticleAdapter wXarticleAdapter;

    public static WXarticleFragment newInstance(){
        Bundle bundle=new Bundle();
        WXarticleFragment wXarticleFragment=new WXarticleFragment();
        wXarticleFragment.setArguments(bundle);
        return wXarticleFragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return R.layout.fragment_wxartcle;
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
        binding.topLl.setTitle("公众号");
        binding.topLl.leftImage.setVisibility(View.GONE);

        viewModel.uiChangeObservable.tabBean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {

            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                wXarticleAdapter=new WXarticleAdapter(getChildFragmentManager());
                mFragments =new ArrayList<>();
                List<WXarticleBean.DataBean> dataBean=new ArrayList<>();
                dataBean=viewModel.uiChangeObservable.tabBean.get().getData();
                if (dataBean.size()>0){
                    for (int i = 0; i < dataBean.size(); i++) {
                        mFragments.add(WXarticleListFragment.newInstance(String.valueOf(dataBean.get(i).getId())));
                    }
                }

                wXarticleAdapter.setFragments(mFragments);
                binding.wxarticleViewpager.setAdapter(wXarticleAdapter);
                binding.pagerTab.setViewPager(binding.wxarticleViewpager);
                binding.wxarticleViewpager.setCurrentItem(0);
            }
        });

    }

    public class WXarticleAdapter extends FragmentPagerAdapter {
        private List<BaseFragment> mFragments=new ArrayList<>();

        public WXarticleAdapter(FragmentManager fm) {
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
