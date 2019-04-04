package com.wubo.wanandroid.http;

import com.wubo.wanandroid.bean.ArchitectureBean;
import com.wubo.wanandroid.bean.ArchitectureChildrenBean;
import com.wubo.wanandroid.bean.ArticleBean;
import com.wubo.wanandroid.bean.BannerBean;
import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.bean.CollectListBean;
import com.wubo.wanandroid.bean.ProjectListBean;
import com.wubo.wanandroid.bean.ProjectTabBean;
import com.wubo.wanandroid.bean.RegisterBean;
import com.wubo.wanandroid.bean.WXarticleBean;
import com.wubo.wanandroid.bean.WXarticleListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/banner/json")
    Observable<BannerBean> banner();

    @GET("article/list/{page}/json")
    Observable<ArticleBean> homeArticle(@Path("page")String page);

    @GET("project/tree/json")
    Observable<ProjectTabBean> projectTab();

    @GET("project/list/{page}/json?")
    Observable<ProjectListBean> projectList(@Path("page")String page,@Query("cid") String cid);

    @GET("wxarticle/chapters/json")
    Observable<WXarticleBean> wxarticleTab();

    @GET("wxarticle/list/{id}/{page}/json")
    Observable<WXarticleListBean> wxarticleList(@Path("page")String page, @Path("id") String cid);

    @GET("tree/json")
    Observable<ArchitectureBean> architecture();

    @GET("article/list/{page}/json?")
    Observable<ArchitectureChildrenBean> architectureChildren(@Path("page")String page,@Query("cid") String cid);

    @POST("user/login")
    Observable<BaseBean>login(@Query("username")String username,@Query("password")String password);

    @POST("user/register")
    Observable<RegisterBean>register(@Query("username")String username, @Query("password")String password,
                                     @Query("repassword")String repassword);

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


}