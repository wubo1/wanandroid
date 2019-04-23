package com.wubo.wanandroid.http;

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

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    /**
     * 首页banner
     * @return
     */
    @GET("/banner/json")
    Observable<BannerBean> banner();

    /**
     * 首页文章
     * @param page 页码
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<ArticleBean> homeArticle(@Path("page")String page);

    /**
     * 项目分类
     * @return
     */
    @GET("project/tree/json")
    Observable<ProjectTabBean> projectTab();

    /**
     * 项目分类下的列表数据
     * @param page 页码
     * @param cid 分类id
     * @return
     */
    @GET("project/list/{page}/json?")
    Observable<ProjectListBean> projectList(@Path("page")String page,@Query("cid") String cid);

    /**
     * 公众号列表
     * @return
     */
    @GET("wxarticle/chapters/json")
    Observable<WXarticleBean> wxarticleTab();

    /**
     * 某个公众号历史数据
     * @param page 页码
     * @param cid 公众号id
     * @return
     */
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<WXarticleListBean> wxarticleList(@Path("page")String page, @Path("id") String cid);

    /**
     * 在某个公众号中搜索历史文章
     * @param page 页码
     * @param cid 公众号ID
     * @param key 搜索关键字
     * @return
     */
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<WXarticleListBean> wxarticleListKey(@Path("page")String page, @Path("id") String cid,@Query("k") String key);

    /**
     * 体系数据 分类
     * @return
     */
    @GET("tree/json")
    Observable<ArchitectureBean> architecture();

    /**
     * 体系下的文章
     * @param page 页码
     * @param cid 分类id
     * @return
     */
    @GET("article/list/{page}/json?")
    Observable<ArchitectureChildrenBean> architectureChildren(@Path("page")String page,@Query("cid") String cid);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @POST("user/login")
    Observable<BaseBean>login(@Query("username")String username,@Query("password")String password);

    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param repassword 确认密码
     * @return
     */
    @POST("user/register")
    Observable<RegisterBean>register(@Query("username")String username, @Query("password")String password,
                                     @Query("repassword")String repassword);

    /**
     * 收藏文章列表
     * @param page 页码
     * @return
     */
    @GET("lg/collect/list/{page}/json")
    Observable<CollectListBean>collectList(@Path("page")String page);

    /**
     * 收藏文章
     * @param id 文章ID
     * @return
     */
    @POST("lg/collect/{id}/json")
    Observable<BaseBean>collect(@Path("id")int id);

    /**
     * 取消收藏文章
     * @param id 文章ID
     * @return
     */
    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseBean>unCollect(@Path("id")int id);

    /**
     * 我的收藏取消收藏文章
     * @param id 文章ID
     * @return
     */
    @POST("lg/uncollect/{id}/json")
    Observable<BaseBean>unCollect(@Path("id")int id,@Query("originId")int originId );

    /**
     * 搜索热词
     * @return
     */
    @GET("hotkey/json")
    Observable<HotKeyBean> hotkey();

    /**
     * 搜索
     * @param key 关键字
     * @return
     */
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Observable<SearchResultBean> search(@Path("page")String page, @Field("k")String key);

    /**
     * 常用网站
     * @return
     */
    @GET("friend/json")
    Observable<FriendBean> friend();

    /**
     * 置顶文章
     * @return
     */
    @GET("article/top/json")
    Observable<TopArticleBean>topArticle();
}
