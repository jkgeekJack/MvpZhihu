package com.jkgeekjack.rebuildzhihu.Service;

import com.jkgeekjack.rebuildzhihu.Article.ArticleDetailBean;
import com.jkgeekjack.rebuildzhihu.Home.RootBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/7/10.
 */
public interface ActionService {
    public static String baseUrl="http://news-at.zhihu.com";
    //今日头条
    @GET("/api/4/news/latest")
    Observable<RootBean> getLatestNews();
    //互联网安全
    @GET("/api/4/theme/10")
    Observable<RootBean> getSafety();
    //不准无聊
    @GET("/api/4/theme/11")
    Observable<RootBean> getInterest();
    //体育日报
    @GET("/api/4/theme/8")
    Observable<RootBean> getSport();
    //传入id查看详细信息
    @GET("/api/4/news/{id}")
    Observable<ArticleDetailBean> getNewsDetails(@Path("id") int id);

}
