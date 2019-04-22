package com.wubo.wanandroid.ui.personalcenter.vm;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.bean.CollectListBean;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.config.NetConstant;
import com.wubo.wanandroid.http.BaseNetObserver;
import com.wubo.wanandroid.http.NetRequest;
import com.wubo.wanandroid.http.cookies.CookiesManager;
import com.wubo.wanandroid.ui.dialog.ExitDialog;
import com.wubo.wanandroid.ui.my.act.LoginActivity;
import com.wubo.wanandroid.ui.webview.MyWebViewActivity;
import com.wubo.wanandroid.utils.CommonUtils;
import com.wubo.wanandroid.utils.OnItemClickListener;
import com.wubo.wanandroid.utils.Utils;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.utils.SPUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

import static android.content.ContentValues.TAG;

/**
 * Author: wubo
 * Create on: 2019/3/25 14:46
 * Description:
 */
public class PersonalCenterVm extends BaseViewModel {
    public int page =0;
    public ObservableInt status=new ObservableInt(0);
    public ObservableInt dataStatus=new ObservableInt(0);
    public ObservableField<String> username=new ObservableField<>();
    public ObservableBoolean isOver= new ObservableBoolean(false);
    public UIChangeObservable uc = new UIChangeObservable();
    public ObservableList<CollectListBean.DataBean.DatasBean> items = new ObservableArrayList();

    public ItemBinding itemBinding = ItemBinding.of(BR.item, R.layout.collect_list_item)
            .bindExtra(BR.listener, new OnItemClickListener<CollectListBean.DataBean.DatasBean>() {
                @Override
                public void onItemClick(int viewId, CollectListBean.DataBean.DatasBean datasBean) {
                    switch (viewId){
                        case R.id.article_item:
                            if (!"".equals(datasBean.getLink())){
                                Bundle bundle = new Bundle();
                                bundle.putString("url" ,datasBean.getLink());
                                startActivity(MyWebViewActivity.class , bundle);
                            }
                            break;
                        case R.id.btn_collect:
                            if (CommonUtils.isLogin()){
                                unCollect(datasBean.getId(),datasBean.getOriginId());
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
            if (CommonUtils.isLogin()){
                if (isOver.get()){
                    refreshLayout.setNoMoreData(true);
                }else{
                    page++;
                    requestCollectList(page,refreshLayout);
                }
            }else {
                if (refreshLayout != null) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

        }

        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            if (CommonUtils.isLogin()){
                page=0;
                requestCollectList(page,refreshLayout);
            }else{
                if (refreshLayout != null) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        }
    };

    public PersonalCenterVm(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onStart() {
        super.onStart();
        refreshLoginData();
    }

    public void refreshLoginData() {
        if (CommonUtils.isLogin()){
            username.set(SPUtils.getInstance().getString(NetConstant.USERNAME));
        }else{
            username.set("登录");
        }
    }

    public class UIChangeObservable{
        public ObservableBoolean loginOrLogout =new ObservableBoolean(false);
    }

    public BindingCommand gotoLoginOrLogOut =new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.loginOrLogout.set(!uc.loginOrLogout.get());
        }
    });

    private void requestCollectList(final int page, final RefreshLayout refreshLayout) {
        NetRequest.collectList(String.valueOf(page), getLifecycleProvider(), new BaseNetObserver<CollectListBean>() {
            @Override
            public void onSuccess(CollectListBean data) {

                if (page == 0) {
                    items.clear();
                }
                if (data.getData()!=null){
                    isOver.set(data.getData().isOver());
                    items.addAll(data.getData().getDatas());
                }
                if (items.size()==0){
                    status.set(0);
                    dataStatus.set(0);
                }else{
                    status.set(1);
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

    private void unCollect(final int id, int originId){
        NetRequest.unCollect(id, originId, getLifecycleProvider(), new BaseNetObserver<BaseBean>() {
            @Override
            public void onSuccess(BaseBean data) {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getId()==id){
                        items.remove(i);
                        break;
                    }
                }

                if (items.size()==0){
                    status.set(0);
                    dataStatus.set(0);
                }else{
                    status.set(1);
                    dataStatus.set(1);
                }
            }

            @Override
            public void onFail(Throwable t) {

            }
        });
    }


}
