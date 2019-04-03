package com.wubo.wanandroid.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wubo.wanandroid.BR;

import java.util.List;

/**
 * Author: wubo
 * Create on: 2019/3/27 09:55
 * Description:
 */
public class ArticleBean extends BaseBean {


    /**
     * data : {"curPage":2,"datas":[{"apkLink":"","author":"开发的猫","chapterId":100,
     * "chapterName":"RecyclerView","collect":false,"courseId":13,"desc":"","envelopePic":"",
     * "fresh":false,"id":8123,"link":"https://www.jianshu.com/p/1837a801e599","niceDate":"2天前",
     * "origin":"","projectLink":"","publishTime":1553440323000,"superChapterId":54,
     * "superChapterName":"5.+高新技术","tags":[],"title":"由旋转画廊，看自定义RecyclerView.LayoutManager",
     * "type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"慕涵盛华","chapterId":153,
     * "chapterName":"进程启动相关","collect":false,"courseId":13,"desc":"","envelopePic":"",
     * "fresh":false,"id":8121,"link":"https://www.jianshu.com/p/4dfc0b67d92f","niceDate":"2天前",
     * "origin":"","projectLink":"","publishTime":1553440094000,"superChapterId":153,
     * "superChapterName":"framework","tags":[],"title":"Android系统启动过程分析","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"慕涵盛华","chapterId":153,"chapterName":"进程启动相关",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8122,
     * "link":"https://www.jianshu.com/p/b158615cc2ad","niceDate":"2天前","origin":"",
     * "projectLink":"","publishTime":1553440051000,"superChapterId":153,
     * "superChapterName":"framework","tags":[],"title":"应用程序进程启动过程","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"ForgetSky","chapterId":294,
     * "chapterName":"完整项目","collect":false,"courseId":13,"desc":"项目基于 Material Design + MVP
     * +dagger2 + RxJava + Retrofit + Glide + greendao 等架构进行设计实现，极力打造一款 优秀的玩Android  https://www
     * .wanandroid.com  客户端，是一个不错的Android应用开发学习参考项目","envelopePic":"https://www.wanandroid
     * .com/blogimgs/796709d5-6238-4fc7-bcbd-6346ea43cf81.png","fresh":false,"id":8120,
     * "link":"http://www.wanandroid.com/blog/show/2538","niceDate":"2019-03-23","origin":"",
     * "projectLink":"https://github.com/ForgetSky/ForgetSkyWanAndroid",
     * "publishTime":1553342918000,"superChapterId":294,"superChapterName":"开源项目主Tab",
     * "tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"一款精致的玩Android客户端",
     * "type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"digtal","chapterId":294,
     * "chapterName":"完整项目","collect":false,"courseId":13,"desc":"Kotlin + MVP + Rxjava+
     * Retrofit2写一个玩Android客户端","envelopePic":"https://www.wanandroid
     * .com/blogimgs/cf0d5bc9-50fa-4e8e-b2ff-4b8bc2b0c347.png","fresh":false,"id":8119,
     * "link":"http://www.wanandroid.com/blog/show/2537","niceDate":"2019-03-23","origin":"",
     * "projectLink":"https://github.com/digtal/WanAndroid","publishTime":1553342871000,
     * "superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目",
     * "url":"/project/list/1?cid=294"}],"title":"Kotlin玩Android客户端","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"无心.","chapterId":307,"chapterName":"Apk诞生记",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8118,
     * "link":"https://blog.csdn.net/huxin1875/article/details/87816465","niceDate":"2019-03-23",
     * "origin":"","projectLink":"","publishTime":1553336778000,"superChapterId":168,
     * "superChapterName":"基础知识","tags":[],"title":" Android打包流程之资源管理","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"文淑","chapterId":79,"chapterName":"黑科技",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8117,
     * "link":"https://www.jianshu.com/p/0fa85b6c6359","niceDate":"2019-03-23","origin":"",
     * "projectLink":"","publishTime":1553332932000,"superChapterId":197,
     * "superChapterName":"热门专题","tags":[],"title":"Android如何在免Root下自动Pay（非人为非无障碍），引起的深思？",
     * "type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Android小Y",
     * "chapterId":238,"chapterName":"其他动画","collect":false,"courseId":13,"desc":"",
     * "envelopePic":"","fresh":false,"id":8116,"link":"https://www.jianshu.com/p/806219fd4d0b",
     * "niceDate":"2019-03-23","origin":"","projectLink":"","publishTime":1553332734000,
     * "superChapterId":188,"superChapterName":"动画效果","tags":[],"title":"Lottie for
     * Android：一个解放开发者双手的动画神器","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"",
     * "author":"Mr_万能胶","chapterId":262,"chapterName":"SDK开发","collect":false,"courseId":13,
     * "desc":"","envelopePic":"","fresh":false,"id":8115,"link":"https://juejin
     * .im/post/5c9228e7f265da60fe7c2732","niceDate":"2019-03-23","origin":"","projectLink":"",
     * "publishTime":1553332528000,"superChapterId":197,"superChapterName":"热门专题","tags":[],
     * "title":"编写 Android Library 的最佳实践","type":0,"userId":-1,"visible":1,"zan":0},
     * {"apkLink":"","author":" Coo 1","chapterId":423,"chapterName":"Architecture",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8114,
     * "link":"https://juejin.im/post/5c947ef9e51d455de73ac7a0","niceDate":"2019-03-23",
     * "origin":"","projectLink":"","publishTime":1553332291000,"superChapterId":423,
     * "superChapterName":"Jetpack","tags":[],"title":"带你领略Android 架构组件的魅力","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"鸡汤程序员","chapterId":267,
     * "chapterName":"handler","collect":false,"courseId":13,"desc":"","envelopePic":"",
     * "fresh":false,"id":8113,"link":"https://www.jianshu.com/p/13c8a66d3b5c",
     * "niceDate":"2019-03-23","origin":"","projectLink":"","publishTime":1553329456000,
     * "superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"Handler全家桶之 &mdash;
     * &mdash; Handler 源码解析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"",
     * "author":"嘉伟咯 ","chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,
     * "desc":"","envelopePic":"","fresh":false,"id":8112,"link":"https://www.jianshu
     * .com/p/866702bcbc47","niceDate":"2019-03-23","origin":"","projectLink":"",
     * "publishTime":1553326937000,"superChapterId":245,"superChapterName":"Java深入","tags":[],
     * "title":"大概优秀的java程序员都要会分析class文件吧","type":0,"userId":-1,"visible":1,"zan":0},
     * {"apkLink":"","author":"刘洪凯","chapterId":406,"chapterName":"Android 9.0","collect":false,
     * "courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8111,"link":"https://infoq
     * .cn/article/2018/04/Android-P-API","niceDate":"2019-03-23","origin":"","projectLink":"",
     * "publishTime":1553320819000,"superChapterId":54,"superChapterName":"5.+高新技术","tags":[],
     * "title":"突破 Android P 非公开 API 限制","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"",
     * "author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,
     * "desc":"","envelopePic":"","fresh":false,"id":8132,"link":"https://mp.weixin.qq
     * .com/s/UqE2EqnzolnvZdQ2wamWtw","niceDate":"2019-03-22","origin":"","projectLink":"",
     * "publishTime":1553184000000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"Android 仿抖音实现动态壁纸",
     * "type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"程序亦非猿","chapterId":428,
     * "chapterName":"程序亦非猿","collect":false,"courseId":13,"desc":"","envelopePic":"",
     * "fresh":false,"id":8133,"link":"https://mp.weixin.qq.com/s/AWDLJ0cKBxr77GWTftcu2Q",
     * "niceDate":"2019-03-22","origin":"","projectLink":"","publishTime":1553184000000,
     * "superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号",
     * "url":"/wxarticle/list/428/1"}],"title":"安卓从入门到进阶第四章（调试方法）","type":0,"userId":-1,
     * "visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖",
     * "collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8135,
     * "link":"https://mp.weixin.qq.com/s/-XxypTwZopyZsobWZxJYig","niceDate":"2019-03-22",
     * "origin":"","projectLink":"","publishTime":1553184000000,"superChapterId":408,
     * "superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],
     * "title":"Kotlin的特性应用示例，原来还可以这么玩","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"",
     * "author":"码小猪","chapterId":267,"chapterName":"handler","collect":false,"courseId":13,
     * "desc":"","envelopePic":"","fresh":false,"id":8105,"link":"https://www.hchstudio
     * .cn/article/2019/556f/","niceDate":"2019-03-21","origin":"","projectLink":"",
     * "publishTime":1553133744000,"superChapterId":10,"superChapterName":"四大组件","tags":[],
     * "title":"Handler 源码解析(Java 层)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"",
     * "author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,
     * "desc":"","envelopePic":"","fresh":false,"id":8106,"link":"https://mp.weixin.qq
     * .com/s/cR_fPJvNvcVUTDLfZ3LcyA","niceDate":"2019-03-21","origin":"","projectLink":"",
     * "publishTime":1553097600000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],
     * "title":"一目了然：git命令三种方式实现Gitlab和Github同时登录","type":0,"userId":-1,"visible":1,"zan":0},
     * {"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,
     * "courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8108,"link":"https://mp.weixin
     * .qq.com/s/QIuww9b0TsNjajEUS8c2fg","niceDate":"2019-03-21","origin":"","projectLink":"",
     * "publishTime":1553097600000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"再学一次ConstraintLayout
     * 一些新特性","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Android达摩院",
     * "chapterId":434,"chapterName":"Android达摩院","collect":false,"courseId":13,"desc":"",
     * "envelopePic":"","fresh":false,"id":8140,"link":"http://mp.weixin.qq
     * .com/s?__biz=MzI5NjE3NzA4Mg==&mid=2650359899&idx=1&sn=76a156a24ba4116e19f8a5ef85a9ecaa
     * &chksm=f445b48ec3323d987a1a165d832c2befd79ca5c39711b29f281c8ec5e9ecf69c63a54de53688&scene
     * =38#wechat_redirect","niceDate":"2019-03-21","origin":"","projectLink":"",
     * "publishTime":1553097600000,"superChapterId":408,"superChapterName":"公众号",
     * "tags":[{"name":"公众号","url":"/wxarticle/list/434/1"}],"title":"Android技术架构演进与未来","type":0,
     * "userId":-1,"visible":1,"zan":0}],"offset":20,"over":false,"pageCount":313,"size":20,
     * "total":6251}
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
             * author : 开发的猫
             * chapterId : 100
             * chapterName : RecyclerView
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 8123
             * link : https://www.jianshu.com/p/1837a801e599
             * niceDate : 2天前
             * origin :
             * projectLink :
             * publishTime : 1553440323000
             * superChapterId : 54
             * superChapterName : 5.+高新技术
             * tags : []
             * title : 由旋转画廊，看自定义RecyclerView.LayoutManager
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
            private List<?> tags;

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

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
