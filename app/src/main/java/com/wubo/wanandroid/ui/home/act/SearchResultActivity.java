package com.wubo.wanandroid.ui.home.act;

import android.os.Bundle;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.databinding.ActivitySearchResultBinding;
import com.wubo.wanandroid.ui.home.vm.SearchResultVm;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * Author: wubo
 * Create on: 2019/4/9 10:59
 * Description:
 */
public class SearchResultActivity extends BaseActivity <ActivitySearchResultBinding, SearchResultVm>{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_search_result;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        String key=getIntent().getStringExtra("search");
        viewModel.key.set(key);
        binding.searchResultRefresh.autoRefresh();

    }
}
