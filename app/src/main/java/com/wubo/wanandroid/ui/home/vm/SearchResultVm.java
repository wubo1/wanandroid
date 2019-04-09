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
import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.bean.CollectListBean;
import com.wubo.wanandroid.bean.ProjectListBean;
import com.wubo.wanandroid.bean.SearchResultBean;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.ui.home.act.SearchActivity;
import com.wubo.wanandroid.ui.webview.MyWebViewActivity;
import com.wubo.wanandroid.utils.CommonUtils;
import com.wubo.wanandroid.utils.OnItemClickListener;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Author: wubo
 * Create on: 2019/4/9 11:00
 * Description:
 */
public class SearchResultVm extends BaseViewModel {

    public int page =0;
    public ObservableField<String> key=new ObservableField<>();
    public ObservableInt status=new ObservableInt(0);
    public ObservableField<String> username=new ObservableField<>();
    public ObservableBoolean isOver= new ObservableBoolean(false);
    public ObservableList<SearchResultBean.DataBean.DatasBean> items = new ObservableArrayList();

    public ItemBinding itemBinding = ItemBinding.of(BR.item, R.layout.search_result_item)
            .bindExtra(BR.listener, new OnItemClickListener<SearchResultBean.DataBean.DatasBean>() {
                @Override
                public void onItemClick(int viewId, SearchResultBean.DataBean.DatasBean datasBean) {
                    switch (viewId){
                        case R.id.article_item:
                            if (!"".equals(datasBean.getLink())){
                                Bundle bundle = new Bundle();
                                bundle.putString("url" ,datasBean.getLink());
                                startActivity(MyWebViewActivity.class , bundle);
                            }
                            break;
                        case R.id.article_item_favorite:
                            if (CommonUtils.isLogin()){
                                collect(datasBean.getId(), datasBean.isCollect());
                            }else{
                                ToastUtils.showShort("你还未登录,请先登录");
                            }
                            break;
                    }

                }
            });
    public OnRefreshLoadMoreListener refresh=new OnRefreshLoadMoreListener() {
        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            if (isOver.get()){
                refreshLayout.setNoMoreData(true);
            }else{
                page++;
                requestSearchList(page,key.get(),refreshLayout);
            }

        }

        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            requestSearchList(page,key.get(),refreshLayout);
        }
    };

    public BindingCommand back=new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });

    public BindingCommand toSearchResult= new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Bundle bundle=new Bundle();
            bundle.putString("search",key.get());
            startActivity(SearchActivity.class,bundle);
        }
    });

    private void requestSearchList(final int page, String key, final RefreshLayout refreshLayout) {
        NetRequest.search(String.valueOf(page), key, getLifecycleProvider(),
                new BaseNetObserver<SearchResultBean>() {
            @Override
            public void onSuccess(SearchResultBean data) {
                if (page == 0) {
                    items.clear();
                }
                if (data.getData()!=null){
                    isOver.set(data.getData().isOver());
                    items.addAll(data.getData().getDatas());
                }
                if (items.size()==0){
                    status.set(0);
                }else{
                    status.set(1);
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

    public SearchResultVm(@NonNull Application application) {
        super(application);
    }


}
