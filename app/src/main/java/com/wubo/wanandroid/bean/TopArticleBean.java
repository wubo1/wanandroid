package com.wubo.wanandroid.bean;

import java.util.List;

/**
 * Author: wubo
 * Create on: 2019/4/10 14:32
 * Description:
 */
public class TopArticleBean extends BaseBean {


    private List<ArticleBean.DataBean.DatasBean> data;

    public List<ArticleBean.DataBean.DatasBean> getData() {
        return data;
    }

    public void setData(List<ArticleBean.DataBean.DatasBean> data) {
        this.data = data;
    }

}
