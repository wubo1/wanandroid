package com.wubo.wanandroid.http;


import com.wubo.wanandroid.BuildConfig;
import com.wubo.wanandroid.http.cookies.AddCookiesInterceptor;
import com.wubo.wanandroid.http.cookies.SaveCookiesInterceptor;

import java.util.concurrent.TimeUnit;

import me.goldze.mvvmhabit.http.interceptor.logging.Level;
import me.goldze.mvvmhabit.http.interceptor.logging.LoggingInterceptor;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;


    //超时时间
    private static final int DEFAULT_TIMEOUT = 30;

    private static class SingletonHolder{
        private static RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static RetrofitClient getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private RetrofitClient(){
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .addInterceptor(new LoggingInterceptor
                        .Builder()//构建者模式
                        .loggable(BuildConfig.DEBUG) //是否开启日志打印
                        .setLevel(Level.BASIC) //打印的等级
                        .log(Platform.INFO) // 打印类型
                        .request("Request") // request的Tag
                        .response("Response")// Response的Tag
                        .addHeader("log-header", "I am the log request header.") // 添加打印头, 注意 key 和 value 都不能是中文
                        .build())
                .addInterceptor(new AddCookiesInterceptor())
                .addInterceptor(new SaveCookiesInterceptor())
                .connectTimeout(DEFAULT_TIMEOUT , TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT , TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(8, 15, TimeUnit.SECONDS))
                .build();


        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://www.wanandroid.com/")
                .build();

    }

    public <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return retrofit.create(service);
    }


}
