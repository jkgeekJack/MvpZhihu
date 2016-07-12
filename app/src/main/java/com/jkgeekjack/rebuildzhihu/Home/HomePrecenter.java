package com.jkgeekjack.rebuildzhihu.Home;

import android.content.Context;

import com.jkgeekjack.rebuildzhihu.Service.ActionService;
import com.jkgeekjack.rebuildzhihu.Service.ServiceFactory;
import com.orhanobut.logger.Logger;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/7/10.
 */
public class HomePrecenter implements HomeContract.Precenter{
    private HomeContract.View view;
    private CompositeSubscription subscription;
    private ActionService service;
    private String type;
    public HomePrecenter(HomeContract.View view, Context context){
        this.view=view;
        service= ServiceFactory.createRetrofitService(ActionService.class,ActionService.baseUrl,context);
        subscription=new CompositeSubscription();
    }
    @Override
    public void loadArticle(String type) {
        this.type=type;
        Observable<RootBean> rootBean = null;
        if (type.equals("今日头条")){
            rootBean=service.getLatestNews();
        }else if (type.equals("互联网安全")){
            rootBean=service.getSafety();
        }else if (type.equals("不准无聊")){
            rootBean=service.getInterest();
        }else if (type.equals("体育日报")){
            rootBean=service.getSport();
        }
        subscription.add(rootBean
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RootBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d(e.toString());
                    }

                    @Override
                    public void onNext(RootBean rootBean) {
                        view.showArticle(rootBean.getStories());
                    }
                }));
    }


    @Override
    public void subscribe() {
//        if (type!=null){
//            loadArticle(type);
//        }
    }

    @Override
    public void unsubscribe() {
//        subscription.clear();
    }
}
