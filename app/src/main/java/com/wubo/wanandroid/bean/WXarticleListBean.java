package com.wubo.wanandroid.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;
import com.wubo.wanandroid.BR;

/**
 * Author: wubo
 * Create on: 2019/3/28 16:08
 * Description:
 */
public class WXarticleListBean extends BaseBean {


    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"鸿洋","chapterId":408,
     * "chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,
     * "id":8160,"link":"https://mp.weixin.qq.com/s/TDm9Sk7uev8nppMTBqBs0w","niceDate":"2天前",
     * "origin":"","projectLink":"","publishTime":1553529600000,"superChapterId":408,
     * "superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],
     * "title":"零Flutter基础，四天搞定Flutter玩Android客户端攻略","type":0,"userId":-1,"visible":1,"zan":0},
     * {"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,
     * "courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8134,"link":"https://mp.weixin
     * .qq.com/s/gGOHF4-_tTHHGSbsX4Mptg","niceDate":"2019-03-25","origin":"","projectLink":"",
     * "publishTime":1553443200000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"嗷嗷加班，如何保持学习能力~","type":0,
     * "userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,
     * "chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,
     * "id":8108,"link":"https://mp.weixin.qq.com/s/QIuww9b0TsNjajEUS8c2fg",
     * "niceDate":"2019-03-21","origin":"","projectLink":"","publishTime":1553097600000,
     * "superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号",
     * "url":"/wxarticle/list/408/1"}],"title":"再学一次ConstraintLayout 一些新特性","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8107,
     * "link":"https://mp.weixin.qq.com/s/yxh_wkIaA_NPn7kFUdWZ-Q","niceDate":"2019-03-20",
     * "origin":"","projectLink":"","publishTime":1553011200000,"superChapterId":408,
     * "superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],
     * "title":"听说你们要拿玩Android API 开发小程序？","type":0,"userId":-1,"visible":1,"zan":0},
     * {"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,
     * "courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8085,"link":" https://mp
     * .weixin.qq.com/s/dz9sEHcpLLJUZDfnlRKbKg","niceDate":"2019-03-19","origin":"",
     * "projectLink":"","publishTime":1552924800000,"superChapterId":408,
     * "superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],
     * "title":"学Android 这么久，intent传递数据最大多少呢？","type":0,"userId":-1,"visible":1,"zan":0},
     * {"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,
     * "courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8084,"link":"https://mp.weixin
     * .qq.com/s/O8fyvEHRY82Ihc8Ibj9E8w","niceDate":"2019-03-15","origin":"","projectLink":"",
     * "publishTime":1552579200000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"无需再怨恨&ldquo;刘海屏&rdquo;
     * 了，因为适配十分简单","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋",
     * "chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"",
     * "envelopePic":"","fresh":false,"id":8046,"link":"https://mp.weixin.qq
     * .com/s/Qey-3JDdKYG04mo9WeBZ2g","niceDate":"2019-03-13","origin":"","projectLink":"",
     * "publishTime":1552406400000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"看完感觉我RecyclerView白学了！",
     * "type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,
     * "chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,
     * "id":8045,"link":"https://mp.weixin.qq.com/s/CQABJNacnsf8_s6l93JKUw",
     * "niceDate":"2019-03-12","origin":"","projectLink":"","publishTime":1552320000000,
     * "superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号",
     * "url":"/wxarticle/list/408/1"}],"title":"Android面试相关文章以及github整理","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8007,
     * "link":"https://mp.weixin.qq.com/s/FqXLNz5p9M-5vcMUkxJyFQ","niceDate":"2019-03-08",
     * "origin":"","projectLink":"","publishTime":1551974400000,"superChapterId":408,
     * "superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],
     * "title":"全民Kotlin：Java我们不一样","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"",
     * "author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"",
     * "envelopePic":"","fresh":false,"id":8006,"link":"https://mp.weixin.qq
     * .com/s/HCxJ8u-y5CVbQjXHDuj93g","niceDate":"2019-03-07","origin":"","projectLink":"",
     * "publishTime":1551888000000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"开放通用Api，总有你喜欢的","type":0,
     * "userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,
     * "chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,
     * "id":8005,"link":"https://mp.weixin.qq.com/s/b6cl6Gjo8Xf1oPQsqKLT7A",
     * "niceDate":"2019-03-06","origin":"","projectLink":"","publishTime":1551801600000,
     * "superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号",
     * "url":"/wxarticle/list/408/1"}],"title":"这交互炸了系列 仿掌阅实现书籍打开动画","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7998,
     * "link":"https://mp.weixin.qq.com/s/A9k94uKL6OlWwg_cdRdNfA","niceDate":"2019-03-04",
     * "origin":"","projectLink":"","publishTime":1551628800000,"superChapterId":408,
     * "superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],
     * "title":"分享几个优质开源项目 | 电商类app，趣享 gif，研发助手DoraemonKit，github小程序","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7981,
     * "link":"https://mp.weixin.qq.com/s/hiWxzJkDjvDoClOUuJI7CA","niceDate":"2019-02-27",
     * "origin":"","projectLink":"","publishTime":1551196800000,"superChapterId":408,
     * "superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],
     * "title":"&ldquo;为什么属性动画移动后仍可点击&rdquo;，你怎么答？","type":0,"userId":-1,"visible":1,"zan":0},
     * {"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,
     * "courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7980,"link":"https://mp.weixin
     * .qq.com/s/iacVz5JAhysnnbA_8f1xxQ","niceDate":"2019-02-26","origin":"","projectLink":"",
     * "publishTime":1551110400000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"轻松搞懂自定义蒙层引导原理","type":0,
     * "userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,
     * "chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,
     * "id":7976,"link":"https://mp.weixin.qq.com/s/9VXDqV7DI1qvlCGl1yp0VQ",
     * "niceDate":"2019-02-25","origin":"","projectLink":"","publishTime":1551024000000,
     * "superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号",
     * "url":"/wxarticle/list/408/1"}],"title":"ViewPager 要被废弃？官方ViewPager2升级版来临","type":0,
     * "userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,
     * "chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,
     * "id":7972,"link":"https://mp.weixin.qq.com/s/nn-nwXnRI9JYSmknH1pzYg",
     * "niceDate":"2019-02-22","origin":"","projectLink":"","publishTime":1550764800000,
     * "superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号",
     * "url":"/wxarticle/list/408/1"}],"title":"再&ldquo;丧心病狂&rdquo;的混淆也不怕","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3632,
     * "link":"http://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&amp;mid=2650826010&amp;idx=1&amp;
     * sn=491e295e6a6c0fe450ad7aa91b6e97cc&amp;
     * chksm=80b7b184b7c03892392015840e4ebc7f2c3533ce8c1a98a5dc6d6d3dd19d53562805d76f6dcb&amp;
     * scene=38#wechat_redirect","niceDate":"2019-02-20","origin":"","projectLink":"",
     * "publishTime":1550672863000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"关于Binder，作为应用开发者你需要知道的全部 |
     * 本周推荐","type":0,"userId":-1,"visible":0,"zan":0},{"apkLink":"","author":"鸿洋",
     * "chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"",
     * "envelopePic":"","fresh":false,"id":7958,"link":"https://mp.weixin.qq
     * .com/s/1PoO7DXBm8kddaPAhpBkZQ","niceDate":"2019-02-20","origin":"","projectLink":"",
     * "publishTime":1550592000000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"&ldquo;啥是佩奇？&rdquo; Android
     * 开发者眼里的佩奇","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋",
     * "chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"",
     * "envelopePic":"","fresh":false,"id":7957,"link":"https://mp.weixin.qq
     * .com/s/ya0RiLuHfIBrPLkl2lTbaA","niceDate":"2019-02-18","origin":"","projectLink":"",
     * "publishTime":1550419200000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"&ldquo;丧心病狂&rdquo;的混淆操作！",
     * "type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,
     * "chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,
     * "id":7945,"link":"https://mp.weixin.qq.com/s/JvlTnZJGSESpPEwYJF1XNg",
     * "niceDate":"2019-02-14","origin":"","projectLink":"","publishTime":1550073600000,
     * "superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号",
     * "url":"/wxarticle/list/408/1"}],"title":"&ldquo;阿里为大家学习Flutter操碎了心&rdquo;","type":0,
     * "userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":35,"size":20,
     * "total":688}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean extends BaseObservable {
            /**
             * apkLink :
             * author : 鸿洋
             * chapterId : 408
             * chapterName : 鸿洋
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 8160
             * link : https://mp.weixin.qq.com/s/TDm9Sk7uev8nppMTBqBs0w
             * niceDate : 2天前
             * origin :
             * projectLink :
             * publishTime : 1553529600000
             * superChapterId : 408
             * superChapterName : 公众号
             * tags : [{"name":"公众号","url":"/wxarticle/list/408/1"}]
             * title : 零Flutter基础，四天搞定Flutter玩Android客户端攻略
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private @Bindable boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<TagsBean> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            @Bindable
            public boolean isCollect() {
                return collect;
            }

            @Bindable
            public void setCollect(boolean collect) {
                this.collect = collect;
                notifyPropertyChanged(BR.collect);
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

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

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * name : 公众号
                 * url : /wxarticle/list/408/1
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
