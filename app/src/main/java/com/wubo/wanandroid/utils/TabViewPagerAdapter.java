package com.wubo.wanandroid.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by 80711 on 2018/5/16.
 */

public class TabViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] tabList;
    private List<String> tabs;
    private List<BaseFragment> viewList;

    public TabViewPagerAdapter(FragmentManager fm, String[] tabList, List<BaseFragment> viewList) {
        super(fm);
        this.tabList = tabList;
        this.viewList = viewList;
    }

    public TabViewPagerAdapter(FragmentManager fm, List<String> tabList, List<BaseFragment> viewList){
        super(fm);
        this.tabs = tabList;
        this.viewList = viewList;
    }

    @Override
    public Fragment getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList == null ? tabs.get(position) : tabList[position];
    }






}
