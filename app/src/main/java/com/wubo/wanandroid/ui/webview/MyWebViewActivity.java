package com.wubo.wanandroid.ui.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.BR;
import com.wubo.wanandroid.databinding.ActivityWebBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * Created by C on 2017/5/23.
 */

public class MyWebViewActivity extends BaseActivity<ActivityWebBinding, MyWebViewVm> implements
        com.tencent.smtt.sdk.DownloadListener {
    private String url;
    private X5WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getIntent().getStringExtra("url");
        initWebView();
    }

    private void initWebView() {
        mWebView = binding.webView;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(android.webkit.WebSettings
                    .MIXED_CONTENT_ALWAYS_ALLOW);
        }
        WebSettings settings = mWebView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        mWebView.setDownloadListener(this);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(com.tencent.smtt.sdk.WebView webView, int i) {

            }

            @Override
            public void onReceivedTitle(com.tencent.smtt.sdk.WebView webView, String title) {
                super.onReceivedTitle(webView, title);
                if (title != null) {
                    binding.topLl.setTitle(title);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.loadUrl(url);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_web;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
    }

    @Override
    public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}