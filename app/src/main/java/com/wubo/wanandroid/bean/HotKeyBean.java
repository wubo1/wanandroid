package com.wubo.wanandroid.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wubo.wanandroid.BR;

import java.util.List;

/**
 * Author: wubo
 * Create on: 2019/4/8 15:21
 * Description:
 */
public class HotKeyBean extends BaseBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends BaseObservable{
        /**
         * id : 6
         * link :
         * name : 面试
         * order : 1
         * visible : 1
         */

        private int id;
        private String link;
        private @Bindable String name;
        private int order;
        private int visible;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(BR.name);
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }
    }
}
