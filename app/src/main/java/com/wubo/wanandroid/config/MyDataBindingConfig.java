package com.wubo.wanandroid.config;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wubo.wanandroid.R;

public class MyDataBindingConfig {


    @BindingAdapter(value = "hloadUrl")
    public static void hloadUrl(ImageView imageView , String url){
            //使用Glide框架加载图片
            //@drawable/touxiang
            RequestOptions requestOptions = RequestOptions.circleCropTransform()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background);
            Glide.with(imageView.getContext())
                    .load(url)
                    .apply(requestOptions)
                    .into(imageView);

    }


    @BindingAdapter(value = "hcodeUrl")
    public static void hcodeUrl(ImageView imageView , Object url){
        //使用Glide框架加载图片
        //@drawable/touxiang
        /*RequestOptions requestOptions = RequestOptions.circleCropTransform()
                .placeholder(R.drawable.touxiang)
                .error(R.drawable.touxiang);
        Glide.with(imageView.getContext())
                .load(url)
                .apply(requestOptions)
                .into(imageView);*/
        if(url != null) {
            RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background);
            if (url instanceof String) {
                Glide.with(imageView.getContext())
                        .load(url)
                        .apply(requestOptions)
                        .into(imageView);
            } else if (url instanceof Bitmap) {
                Glide.with(imageView.getContext()).load(url).apply(requestOptions)
                        .into(imageView);
            }
        }else {
            Glide.with(imageView.getContext()).load(R.drawable.ic_launcher_background).into(imageView);
        }

    }


    @BindingAdapter(value = "hlocalImage")
    public static void hlocalImage(ImageView imageView , int resId){
        imageView.setImageResource(resId);
    }

    @BindingAdapter(value = "smartRefresh")
    public static void smartRefresh(SmartRefreshLayout layout , OnRefreshLoadMoreListener listener){
        if(listener != null){
            layout.setOnRefreshLoadMoreListener(listener);
        }
    }


}
