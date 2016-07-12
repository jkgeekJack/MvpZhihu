package com.jkgeekjack.rebuildzhihu.Article;

import android.content.Context;

import com.jkgeekjack.rebuildzhihu.Service.ActionService;
import com.jkgeekjack.rebuildzhihu.Service.ServiceFactory;
import com.jkgeekjack.rebuildzhihu.util.HtmlUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/7/10.
 */
public class ArticlePrecenter implements ArticleContract.Precenter{
    private CompositeSubscription subscription;
    private ArticleContract.View view;
    private ActionService service;
    private int id;
    public ArticlePrecenter(ArticleContract.View view, Context context){
        this.view=view;
        this.service= ServiceFactory.createRetrofitService(ActionService.class,ActionService.baseUrl,context);
        subscription=new CompositeSubscription();
    }
    @Override
    public void loadArticleDetail(int id) {
        this.id=id;
        subscription.add(service.getNewsDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ArticleDetailBean, String>() {
                    @Override
                    public String call(ArticleDetailBean articleDetailBean) {
                        return HtmlUtils.structHtml(articleDetailBean);
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        view.showAtrticleDetail(s);
                    }
                }));
    }

    @Override
    public void subscribe() {
        if (id!=0){
            loadArticleDetail(id);
        }
    }

    @Override
    public void unsubscribe() {
        subscription.clear();
    }
}
