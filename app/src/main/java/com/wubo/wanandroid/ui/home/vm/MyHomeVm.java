package com.wubo.wanandroid.ui.home.vm;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.bean.ArticleBean;
import com.wubo.wanandroid.bean.BannerBean;
import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.bean.TopArticleBean;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.ui.home.act.SearchActivity;
import com.wubo.wanandroid.ui.webview.MyWebViewActivity;
import com.wubo.wanandroid.utils.CommonUtils;
import com.wubo.wanandroid.utils.OnItemClickListener;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Author: wubo
 * Create on: 2019/3/25 14:10
 * Description:
 */
public class MyHomeVm extends BaseViewModel {

    public MyHomeVm(@NonNull Application application) {
        super(application);
    }

    public int page;

    public ObservableList<String> imagePaths = new ObservableArrayList<>();
    public ObservableList<String> titles = new ObservableArrayList<>();
    public ObservableInt dataStatus = new ObservableInt(0);
    public ObservableBoolean isOver = new ObservableBoolean(false);
    public ObservableList<ArticleBean.DataBean.DatasBean> items = new ObservableArrayList();
    public ItemBinding itemBinding = ItemBinding.of(BR.item, R.layout.home_article_items)
            .bindExtra(BR.listener, new OnItemClickListener<ArticleBean.DataBean.DatasBean>() {
                @Override
                public void onItemClick(int viewId, ArticleBean.DataBean.DatasBean data) {
                    switch (viewId) {
                        case R.id.article_item:
                            if (!"".equals(data.getLink())) {
                                Bundle bundle = new Bundle();
                                bundle.putString("url", data.getLink());
                                startActivity(MyWebViewActivity.class, bundle);
                            }
                            break;
                        case R.id.article_item_favorite:
                            if (CommonUtils.isLogin()){
                                collect(data.getId(), data.isCollect());
                            }else{
                                ToastUtils.showShort("你还未登录,请先登录");
                            }
                            break;
                    }

                }
            });
    public OnRefreshLoadMoreListener refreshLoadMoreListener = new OnRefreshLoadMoreListener() {
        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            if (isOver.get()) {
                refreshLayout.setNoMoreData(true);
            } else {
                page++;
                requestHomeActicle(page, refreshLayout);
            }

        }

        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            page = 0;
            requestBannerData(refreshLayout);
            requestHomtTopActicle(page, refreshLayout);
        }
    };

    public BindingCommand gotoSearch= new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(SearchActivity.class);
        }
    });

    public UIChangeObservable uiChangeObservable = new UIChangeObservable();

    public class UIChangeObservable {
        public ObservableField<BannerBean> bannerData = new ObservableField<>();
    }

    public void requestBannerData(final RefreshLayout refreshLayout) {
        NetRequest.banner(getLifecycleProvider(), new BaseNetObserver<BannerBean>() {
            @Override
            public void onSuccess(BannerBean data) {


                imagePaths.clear();
                titles.clear();

                for (int i = 0; i < data.getData().size(); i++) {
                    imagePaths.add(data.getData().get(i).getImagePath());
                    titles.add(data.getData().get(i).getTitle());
                }

                uiChangeObservable.bannerData.set(data);
                if (refreshLayout != null) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onFail(Throwable t) {
                if (refreshLayout != null) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    public void requestHomtTopActicle(final int pages, final RefreshLayout refreshLayout){
        NetRequest.topArticle(getLifecycleProvider(), new BaseNetObserver<TopArticleBean>() {
            @Override
            public void onSuccess(TopArticleBean data) {
                if (page == 0) {
                    items.clear();
                }
                if (data != null && data.getData() != null) {
                    items.addAll(data.getData());
                }

                requestHomeActicle(pages,refreshLayout);
            }

            @Override
            public void onFail(Throwable t) {

            }
        });
    }

    public void requestHomeActicle(final int pages, final RefreshLayout refreshLayout) {
        NetRequest.homeArticle(String.valueOf(pages), getLifecycleProvider(), new
                BaseNetObserver<ArticleBean>() {
                    @Override
                    public void onSuccess(ArticleBean data) {
                        if (data != null && data.getData().getDatas() != null) {
                            items.addAll(data.getData().getDatas());
                        }
                        if (items.size() == 0) {
                            dataStatus.set(0);
                        } else {
                            dataStatus.set(1);
                        }

                        if (refreshLayout != null) {
                            refreshLayout.finishRefresh();
                            refreshLayout.finishLoadMore();
                        }
                    }

                    @Override
                    public void onFail(Throwable t) {
                        if (refreshLayout != null) {
                            refreshLayout.finishRefresh();
                            refreshLayout.finishLoadMore();
                        }
                    }
                });
    }

    private void collect(final int id, boolean isCollect) {
        if (isCollect) {
            NetRequest.unCollect(id, getLifecycleProvider(), new BaseNetObserver<BaseBean>() {
                @Override
                public void onSuccess(BaseBean data) {
                    ToastUtils.showShort("取消收藏");
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).getId() == id) {
                            items.get(i).setCollect(false);
                            break;
                        }
                    }
                }

                @Override
                public void onFail(Throwable t) {

                }
            });
        } else {
            NetRequest.collect(id, getLifecycleProvider(), new BaseNetObserver<BaseBean>() {
                @Override
                public void onSuccess(BaseBean data) {
                    ToastUtils.showShort("收藏成功");
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).getId() == id) {
                            items.get(i).setCollect(true);
                            break;
                        }
                    }

                }

                @Override
                public void onFail(Throwable t) {

                }
            });
        }

    }

}
