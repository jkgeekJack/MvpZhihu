package com.jkgeekjack.rebuildzhihu.Service;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2016/7/10.
 */
public class ServiceFactory {
    public static <T> T createRetrofitService(Class<T> clazz,String baseUrl){
        final Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        T service =retrofit.create(clazz);
        return service;
    }
}
