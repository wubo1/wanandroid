package com.wubo.wanandroid.ui.main;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.wubo.wanandroid.R;
import com.wubo.wanandroid.databinding.ActivityMainBinding;
import com.wubo.wanandroid.ui.architecture.fra.ArchitectureFragment;
import com.wubo.wanandroid.ui.home.fra.MyHomeFragment;
import com.wubo.wanandroid.ui.personalcenter.fra.PersonalCenterFragment;
import com.wubo.wanandroid.ui.projects.fra.ProjectsFragment;
import com.wubo.wanandroid.ui.wxarticle.fra.WXarticleFragment;
import com.wubo.wanandroid.utils.TabViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.majiajie.pagerbottomtabstrip.NavigationController;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    private List<BaseFragment> mFragments;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        initFramgent();
        initBottomTab();
    }

    private void initBottomTab() {
        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.drawable.ic_home ,"首页",ContextCompat.getColor(this, R.color.black))
                .addItem(R.drawable.ic_project ,"项目",ContextCompat.getColor(this, R.color.black))
                .addItem(R.drawable.ic_wechat ,"公众号",ContextCompat.getColor(this, R.color.black))
                .addItem(R.drawable.ic_architecture , "体系",ContextCompat.getColor(this, R.color.black))
                .addItem(R.drawable.ic_user , "我的",ContextCompat.getColor(this, R.color.black))
                .setDefaultColor(ContextCompat.getColor(this, R.color.gray))
                .build();
        //底部按钮的点击事件监听
        navigationController.setupWithViewPager(binding.frameLayout);
    }

    private void initFramgent() {
        mFragments= new ArrayList<>();
        mFragments.add(MyHomeFragment.newInstance());
        mFragments.add(ProjectsFragment.newInstance());
        mFragments.add(WXarticleFragment.newInstance());
        mFragments.add(ArchitectureFragment.newInstance());
        mFragments.add(PersonalCenterFragment.newInstance());
        titles = new ArrayList<>();
        titles.add("首页");
        titles.add("项目");
        titles.add("公众号");
        titles.add("体系");
        titles.add("我的");

        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager() , titles ,
                mFragments);

        binding.frameLayout.setAdapter(adapter);
        binding.frameLayout.setOffscreenPageLimit(6);
    }
}
