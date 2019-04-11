package com.wubo.wanandroid.ui.wxarticle.fra;

import android.content.Context;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.bean.WXarticleBean;
import com.wubo.wanandroid.config.NetConstant;
import com.wubo.wanandroid.databinding.FragmentWxartcleBinding;
import com.wubo.wanandroid.ui.home.act.SearchActivity;
import com.wubo.wanandroid.ui.projects.fra.ProjectsFragment;
import com.wubo.wanandroid.ui.wxarticle.vm.WXarticleVm;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.SPUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Author: wubo
 * Create on: 2019/3/28 15:47
 * Description:
 */
public class WXarticleFragment extends BaseFragment<FragmentWxartcleBinding,WXarticleVm> {

    private List<BaseFragment> mFragments;
    private WXarticleAdapter wXarticleAdapter;
    public static String searchKey="";

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
        binding.pagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                binding.searchText.setText(WXarticleFragment.searchKey);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        binding.searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    ((InputMethodManager) binding.searchText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    // 搜索，进行自己要的操作...
                    viewModel.searchContent.set(binding.searchText.getText().toString());
                    viewModel.searchImg.execute();
                    return true;
                }
                return false;
            }
        });

        binding.searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (binding.searchText.getText().toString().length() > 0) {
                    binding.searchClear.setVisibility(View.VISIBLE);
                } else {
                    binding.searchClear.setVisibility(View.GONE);
                }
                viewModel.searchContent.set(binding.searchText.getText().toString());
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
