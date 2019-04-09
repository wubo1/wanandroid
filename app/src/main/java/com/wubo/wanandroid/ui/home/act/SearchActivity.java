package com.wubo.wanandroid.ui.home.act;

import android.content.Context;
import android.content.Intent;
import android.databinding.Observable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.bean.HotKeyBean;
import com.wubo.wanandroid.databinding.ActivitySearchBinding;
import com.wubo.wanandroid.ui.home.vm.SearchVm;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Author: wubo
 * Create on: 2019/4/8 14:11
 * Description:
 */
public class SearchActivity extends BaseActivity<ActivitySearchBinding, SearchVm> {

    private TagAdapter tagAdapter;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_search;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        binding.searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    ((InputMethodManager) binding.searchText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(SearchActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    // 搜索，进行自己要的操作...
                    if (binding.searchText.getText().toString().length() > 0) {
                        viewModel.searchContent.set(binding.searchText.getText().toString());
                        viewModel.toSearchResult.execute();
                    } else {
                        ToastUtils.showShort("请输入搜索内容");
                    }
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
            }
        });

        viewModel.uc.hotKeyBean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                final LayoutInflater mInflater = LayoutInflater.from(SearchActivity.this);
                tagAdapter =
                        new TagAdapter<HotKeyBean.DataBean>(viewModel.uc.hotKeyBean.get().getData()) {
                    @Override
                    public View getView(FlowLayout parent, int position,
                                        HotKeyBean.DataBean dataBean) {
                        TextView tv = (TextView) mInflater.inflate(R.layout.search_items,
                                binding.tagflowlayout, false);
                        tv.setText(dataBean.getName());
                        return tv;
                    }

                };
                binding.tagflowlayout.setAdapter(tagAdapter);
                binding.tagflowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                    @Override
                    public boolean onTagClick(View view, int position, FlowLayout parent) {
                        viewModel.searchContent.set(viewModel.uc.hotKeyBean.get().getData().get(position).getName());
                        viewModel.toSearchResult.execute();
                        return true;
                    }
                });
            }
        });

        viewModel.hotKey();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initdata(intent);
    }

    private void initdata(Intent intent) {
        String search = intent.getStringExtra("search");
        viewModel.searchContent.set(search);
        if (null != search && !search.isEmpty()) {
            binding.searchText.setSelection(search.length());
        }
    }

}
