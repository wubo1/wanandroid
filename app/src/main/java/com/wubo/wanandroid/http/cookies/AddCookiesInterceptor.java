package com.wubo.wanandroid.http.cookies;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.wubo.wanandroid.MyApplication;
import com.wubo.wanandroid.config.NetConstant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author: wubo
 * Create on: 2019/4/1 10:35
 * Description:
 */
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        String cookie = getCookie(request.url().toString(), request.url().host());
        if (!TextUtils.isEmpty(cookie)) {
            builder.addHeader("Cookie", cookie);
        }

        return chain.proceed(builder.build());
    }

    private String getCookie(String url, String domain) {
        SharedPreferences sp = MyApplication.getInstance().getSharedPreferences(NetConstant.COOKIEPREF, Context
                .MODE_PRIVATE);
        if (!TextUtils.isEmpty(url) && sp.contains(url) && !TextUtils.isEmpty(sp.getString(url, ""))) {
            return sp.getString(url, "");
        }
        if (!TextUtils.isEmpty(domain) && sp.contains(domain) && !TextUtils.isEmpty(sp.getString(domain, ""))) {
            return sp.getString(domain, "");
        }

        return null;
    }

}
