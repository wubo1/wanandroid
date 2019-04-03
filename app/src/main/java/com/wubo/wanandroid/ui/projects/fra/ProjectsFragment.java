package com.wubo.wanandroid.ui.projects.fra;

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
import com.wubo.wanandroid.bean.ProjectTabBean;
import com.wubo.wanandroid.databinding.FragmentProjectsBinding;
import com.wubo.wanandroid.ui.personalcenter.fra.PersonalCenterFragment;
import com.wubo.wanandroid.ui.projects.vm.ProjectsVm;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Author: wubo
 * Create on: 2019/3/28 09:46
 * Description:
 */
public class ProjectsFragment extends BaseFragment<FragmentProjectsBinding,ProjectsVm> {

    private List<BaseFragment> mFragments;
    private ProjectAdapter projectAdapter;

    public static ProjectsFragment newInstance(){
        Bundle bundle=new Bundle();
        ProjectsFragment projectsFragment =new ProjectsFragment();
        projectsFragment.setArguments(bundle);
        return projectsFragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return R.layout.fragment_projects;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        initTopTab();
    }



    private void initTopTab() {
        binding.topLl.setTitle("项目");
        binding.topLl.leftImage.setVisibility(View.GONE);

        viewModel.uiChangeObservable.tabBean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {

            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                projectAdapter=new ProjectAdapter(getChildFragmentManager());
                mFragments =new ArrayList<>();
                List<ProjectTabBean.DataBean> dataBean=new ArrayList<>();
                dataBean=viewModel.uiChangeObservable.tabBean.get().getData();
                if (dataBean.size()>0){
                    for (int i = 0; i < dataBean.size(); i++) {
                        mFragments.add(ProjectListFragment.newInstance(String.valueOf(dataBean.get(i).getId())));
                    }
                }

                projectAdapter.setFragments(mFragments);
                binding.projectViewpager.setAdapter(projectAdapter);
                binding.pagerTab.setViewPager(binding.projectViewpager);
                binding.projectViewpager.setCurrentItem(0);
            }
        });

    }

    public class ProjectAdapter extends FragmentPagerAdapter {
        private List<BaseFragment> mFragments=new ArrayList<>();

        public ProjectAdapter(FragmentManager fm) {
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
