package com.wubo.wanandroid.http;

import com.google.gson.Gson;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.wubo.wanandroid.bean.ArchitectureBean;
import com.wubo.wanandroid.bean.ArchitectureChildrenBean;
import com.wubo.wanandroid.bean.ArticleBean;
import com.wubo.wanandroid.bean.BannerBean;
import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.bean.CollectListBean;
import com.wubo.wanandroid.bean.HotKeyBean;
import com.wubo.wanandroid.bean.ProjectListBean;
import com.wubo.wanandroid.bean.ProjectTabBean;
import com.wubo.wanandroid.bean.RegisterBean;
import com.wubo.wanandroid.bean.WXarticleBean;
import com.wubo.wanandroid.bean.WXarticleListBean;

import java.util.HashMap;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.SPUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class NetRequest {
    private static Gson gson = new Gson();
    private static ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

    public static void banner(LifecycleProvider lifecycleProvider,
                              BaseNetObserver<BannerBean> observer) {
        CommonBase(apiService.banner(), lifecycleProvider).subscribe(observer);
    }

    public static void homeArticle(String page, LifecycleProvider lifecycleProvider,
                                   BaseNetObserver<ArticleBean> observer) {
        CommonBase(apiService.homeArticle(page), lifecycleProvider).subscribe(observer);
    }

    public static void projectTab(LifecycleProvider lifecycleProvider,
                                  BaseNetObserver<ProjectTabBean> observer) {
        CommonBase(apiService.projectTab(), lifecycleProvider).subscribe(observer);
    }

    public static void projectList(String page, String cid, LifecycleProvider lifecycleProvider,
                                   BaseNetObserver<ProjectListBean> observer) {
        CommonBase(apiService.projectList(page, cid), lifecycleProvider).subscribe(observer);
    }

    public static void wxarticleTab(LifecycleProvider lifecycleProvider,
                                    BaseNetObserver<WXarticleBean> observer) {
        CommonBase(apiService.wxarticleTab(), lifecycleProvider).subscribe(observer);
    }

    public static void wxarticleList(String page, String id, LifecycleProvider lifecycleProvider,
                                     BaseNetObserver<WXarticleListBean> observer) {
        CommonBase(apiService.wxarticleList(page, id), lifecycleProvider).subscribe(observer);
    }

    public static void architecture(LifecycleProvider lifecycleProvider,
                                    BaseNetObserver<ArchitectureBean> observer) {
        CommonBase(apiService.architecture(), lifecycleProvider).subscribe(observer);
    }

    public static void architectureChildren(String page, String cid, LifecycleProvider
            lifecycleProvider,
                                            BaseNetObserver<ArchitectureChildrenBean> observer) {
        CommonBase(apiService.architectureChildren(page, cid), lifecycleProvider).subscribe(observer);
    }

    public static void login(String username, String password, LifecycleProvider lifecycleProvider,
                             BaseNetObserver<BaseBean> observer) {
        CommonBase(apiService.login(username, password), lifecycleProvider).subscribe(observer);
    }

    public static void register(String username, String password, String repassword,
                                LifecycleProvider
                                        lifecycleProvider,
                                BaseNetObserver<RegisterBean> observer) {
        CommonBase(apiService.register(username, password, repassword), lifecycleProvider).subscribe(observer);
    }

    public static void collectList(String page, LifecycleProvider lifecycleProvider,
                                   BaseNetObserver<CollectListBean> observer) {
        CommonBase(apiService.collectList(page), lifecycleProvider).subscribe(observer);
    }

    public static void collect(int id, LifecycleProvider lifecycleProvider,
                               BaseNetObserver<BaseBean> observer) {
        CommonBase(apiService.collect(id), lifecycleProvider).subscribe(observer);
    }

    public static void unCollect(int id, LifecycleProvider lifecycleProvider,
                                 BaseNetObserver<BaseBean> observer) {
        CommonBase(apiService.unCollect(id), lifecycleProvider).subscribe(observer);
    }

    public static void unCollect(int id, int originId, LifecycleProvider lifecycleProvider,
                                 BaseNetObserver<BaseBean> observer) {
        CommonBase(apiService.unCollect(id, originId), lifecycleProvider).subscribe(observer);
    }

    public static void hotKey(LifecycleProvider lifecycleProvider,BaseNetObserver<HotKeyBean> observer){
        CommonBase(apiService.hotkey(),lifecycleProvider).subscribe(observer);
    }

    public static void search(String page,String key,LifecycleProvider lifecycleProvider,BaseNetObserver<BaseBean> observer){
        CommonBase(apiService.search(page,key),lifecycleProvider).subscribe(observer);
    }

    private static <T> Observable CommonBase(Observable<T> observable,
                                             LifecycleProvider lifecycleProvider) {
        return observable.compose(RxUtils.bindToLifecycle(lifecycleProvider))
                .compose(RxUtils.schedulersTransformer())
                .compose(RxUtils.exceptionTransformer());
    }


    private static RequestBody getRequestBody(HashMap<String, Object> hashMap) {
        String strEntity = gson.toJson(hashMap);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                strEntity);
        return body;
    }


}
