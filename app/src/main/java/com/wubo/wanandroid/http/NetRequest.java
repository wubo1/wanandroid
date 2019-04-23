package com.wubo.wanandroid.http;

import com.google.gson.Gson;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.wubo.wanandroid.bean.ArchitectureBean;
import com.wubo.wanandroid.bean.ArchitectureChildrenBean;
import com.wubo.wanandroid.bean.ArticleBean;
import com.wubo.wanandroid.bean.BannerBean;
import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.bean.CollectListBean;
import com.wubo.wanandroid.bean.FriendBean;
import com.wubo.wanandroid.bean.HotKeyBean;
import com.wubo.wanandroid.bean.ProjectListBean;
import com.wubo.wanandroid.bean.ProjectTabBean;
import com.wubo.wanandroid.bean.RegisterBean;
import com.wubo.wanandroid.bean.SearchResultBean;
import com.wubo.wanandroid.bean.TopArticleBean;
import com.wubo.wanandroid.bean.WXarticleBean;
import com.wubo.wanandroid.bean.WXarticleListBean;

import java.util.HashMap;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.utils.RxUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class NetRequest {
    private static Gson gson = new Gson();
    private static ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

    /**
     * 首页banner
     */
    public static void banner(LifecycleProvider lifecycleProvider, BaseNetObserver<BannerBean> observer) {
        CommonBase(apiService.banner(), lifecycleProvider).subscribe(observer);
    }

    /**
     * 首页文章
     * @param page 页码
     */
    public static void homeArticle(String page, LifecycleProvider lifecycleProvider, BaseNetObserver<ArticleBean> observer) {
        CommonBase(apiService.homeArticle(page), lifecycleProvider).subscribe(observer);
    }

    /**
     * 项目分类
     */
    public static void projectTab(LifecycleProvider lifecycleProvider, BaseNetObserver<ProjectTabBean> observer) {
        CommonBase(apiService.projectTab(), lifecycleProvider).subscribe(observer);
    }

    /**
     * 项目分类下的列表数据
     * @param page 页码
     * @param cid 分类id
     */
    public static void projectList(String page, String cid, LifecycleProvider lifecycleProvider, BaseNetObserver<ProjectListBean> observer) {
        CommonBase(apiService.projectList(page, cid), lifecycleProvider).subscribe(observer);
    }

    /**
     * 公众号列表
     */
    public static void wxarticleTab(LifecycleProvider lifecycleProvider, BaseNetObserver<WXarticleBean> observer) {
        CommonBase(apiService.wxarticleTab(), lifecycleProvider).subscribe(observer);
    }

    /**
     * 某个公众号历史数据
     * @param page 页码
     * @param id 公众号id
     */
    public static void wxarticleList(String page, String id, LifecycleProvider lifecycleProvider, BaseNetObserver<WXarticleListBean> observer) {
        CommonBase(apiService.wxarticleList(page, id), lifecycleProvider).subscribe(observer);
    }

    /**
     * 在某个公众号中搜索历史文章
     * @param page 页码
     * @param id 公众号ID
     * @param key 搜索关键字
     * @return
     */
    public static void wxarticleListKey(String page, String id,String key, LifecycleProvider lifecycleProvider,
                                        BaseNetObserver<WXarticleListBean> observer) {
        CommonBase(apiService.wxarticleListKey(page, id, key), lifecycleProvider).subscribe(observer);
    }

    /**
     * 体系数据 分类
     */
    public static void architecture(LifecycleProvider lifecycleProvider, BaseNetObserver<ArchitectureBean> observer) {
        CommonBase(apiService.architecture(), lifecycleProvider).subscribe(observer);
    }

    /**
     * 体系下的文章
     * @param page 页码
     * @param cid 分类id
     */
    public static void architectureChildren(String page, String cid, LifecycleProvider lifecycleProvider,
                                            BaseNetObserver<ArchitectureChildrenBean> observer) {
        CommonBase(apiService.architectureChildren(page, cid), lifecycleProvider).subscribe(observer);
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     */
    public static void login(String username, String password, LifecycleProvider lifecycleProvider, BaseNetObserver<BaseBean> observer) {
        CommonBase(apiService.login(username, password), lifecycleProvider).subscribe(observer);
    }

    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param repassword 确认密码
     */
    public static void register(String username, String password, String repassword, LifecycleProvider lifecycleProvider,
                                BaseNetObserver<RegisterBean> observer) {
        CommonBase(apiService.register(username, password, repassword), lifecycleProvider).subscribe(observer);
    }

    /**
     * 收藏文章列表
     * @param page 页码
     */
    public static void collectList(String page, LifecycleProvider lifecycleProvider, BaseNetObserver<CollectListBean> observer) {
        CommonBase(apiService.collectList(page), lifecycleProvider).subscribe(observer);
    }

    /**
     * 收藏文章
     * @param id 文章ID
     */
    public static void collect(int id, LifecycleProvider lifecycleProvider, BaseNetObserver<BaseBean> observer) {
        CommonBase(apiService.collect(id), lifecycleProvider).subscribe(observer);
    }

    /**
     * 取消收藏文章
     * @param id 文章ID
     */
    public static void unCollect(int id, LifecycleProvider lifecycleProvider, BaseNetObserver<BaseBean> observer) {
        CommonBase(apiService.unCollect(id), lifecycleProvider).subscribe(observer);
    }

    /**
     * 我的收藏取消收藏文章
     * @param id 文章ID
     */
    public static void unCollect(int id, int originId, LifecycleProvider lifecycleProvider, BaseNetObserver<BaseBean> observer) {
        CommonBase(apiService.unCollect(id, originId), lifecycleProvider).subscribe(observer);
    }

    /**
     * 搜索热词
     */
    public static void hotKey(LifecycleProvider lifecycleProvider, BaseNetObserver<HotKeyBean> observer) {
        CommonBase(apiService.hotkey(), lifecycleProvider).subscribe(observer);
    }

    /**
     * 搜索
     * @param key 关键字
     */
    public static void search(String page, String key, LifecycleProvider lifecycleProvider, BaseNetObserver<SearchResultBean> observer) {
        CommonBase(apiService.search(page, key), lifecycleProvider).subscribe(observer);
    }

    /**
     * 常用网站
     */
    public static void friend(LifecycleProvider lifecycleProvider, BaseNetObserver<FriendBean> observer) {
        CommonBase(apiService.friend(), lifecycleProvider).subscribe(observer);
    }

    /**
     * 置顶文章
     */
    public static void topArticle(LifecycleProvider lifecycleProvider,BaseNetObserver<TopArticleBean> observer){
        CommonBase(apiService.topArticle(),lifecycleProvider).subscribe(observer);
    }

    private static <T> Observable CommonBase(Observable<T> observable, LifecycleProvider lifecycleProvider) {
        return observable.compose(RxUtils.bindToLifecycle(lifecycleProvider)).compose(RxUtils.schedulersTransformer()).compose(RxUtils.exceptionTransformer());
    }


    private static RequestBody getRequestBody(HashMap<String, Object> hashMap) {
        String strEntity = gson.toJson(hashMap);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), strEntity);
        return body;
    }


}
