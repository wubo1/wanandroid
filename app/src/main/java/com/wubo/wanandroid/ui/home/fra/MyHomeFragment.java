package com.wubo.wanandroid.ui.home.fra;

import android.databinding.Observable;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.wanandroid.R;
import com.wubo.wanandroid.bean.ArticleBean;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.databinding.FragmentMyHomeBinding;
import com.wubo.wanandroid.ui.home.vm.MyHomeVm;
import com.wubo.wanandroid.ui.webview.MyWebViewActivity;
import com.wubo.wanandroid.utils.CommonUtils;
import com.wubo.wanandroid.utils.GlideImageLoader;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnBannerListener;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.bus.Messenger;

/**
 * Author: wubo
 * Create on: 2019/3/25 14:06
 * Description:
 */
public class MyHomeFragment extends BaseFragment<FragmentMyHomeBinding,MyHomeVm> {

    public static MyHomeFragment newInstance(){
        Bundle bundle =new Bundle();
        MyHomeFragment myHomeFragment=new MyHomeFragment();
        myHomeFragment.setArguments(bundle);
        return myHomeFragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_my_home;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Messenger.getDefault().register(this, ConstantConfig.TOKEN_LOGOUT_LOGIN, new BindingAction() {
            @Override
            public void call() {
                binding.homeRefresh.autoRefresh();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        binding.homeRefresh.autoRefresh();
        int height = (int)(CommonUtils.getScreenWidth(getContext()) * 5 / 9);
        ViewGroup.LayoutParams para = binding.homeBanner.getLayoutParams();
        para.height = height;
        para.width = CommonUtils.getScreenWidth(getContext());
        binding.homeBanner.setLayoutParams(para);

        viewModel.uiChangeObservable.bannerData.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {

                binding.homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                //设置图片加载器
                binding.homeBanner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                binding.homeBanner.setImages(viewModel.imagePaths);
                //设置banner动画效果
                binding.homeBanner.setBannerAnimation(Transformer.DepthPage);
                //设置标题集合（当banner样式有显示title时）
                binding.homeBanner.setBannerTitles(viewModel.titles);
                //设置自动轮播，默认为true
                binding.homeBanner.isAutoPlay(true);
                //设置轮播时间
                binding.homeBanner.setDelayTime(3000);
                //设置指示器位置（当banner模式中有指示器时）
                binding.homeBanner.setIndicatorGravity(BannerConfig.RIGHT);
                //banner设置方法全部调用完毕时最后调用
                binding.homeBanner.start();
                binding.homeBanner.setOnBannerClickListener(new OnBannerClickListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Bundle bundle = new Bundle();
                        bundle.putString("url" , viewModel.uiChangeObservable.bannerData.get()
                                .getData().get(position-1).getUrl());
                        startActivity(MyWebViewActivity.class , bundle);
                    }
                });
                /*binding.homeBanner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {

                    }
                });*/
            }
        });

    }
}
