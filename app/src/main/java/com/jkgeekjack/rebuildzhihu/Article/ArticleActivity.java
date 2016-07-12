package com.jkgeekjack.rebuildzhihu.Article;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.jkgeekjack.rebuildzhihu.BaseActivity;
import com.jkgeekjack.rebuildzhihu.R;

public class ArticleActivity extends BaseActivity implements ArticleContract.View{
    private WebView webView;
    private int id;
    private ArticleContract.Precenter precenter;


    @Override
    public void setPrecenter(ArticleContract.Precenter precenter) {
        precenter.loadArticleDetail(id);
//        this.precenter=precenter;
    }

    @Override
    public void showAtrticleDetail(String content) {
        webView.loadDataWithBaseURL("file:///android_asset/", content, "text/html", "UTF-8", null);
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initParms(Bundle parms) {
        Intent intent=getIntent();
        id=intent.getIntExtra("id",0);
        precenter=new ArticlePrecenter(this,this);
        setPrecenter(precenter);
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_artitle;
    }

    @Override
    public void initView(View view) {
        webView=$(R.id.webView);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    protected void onResume() {
        super.onResume();
//        precenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        precenter.unsubscribe();
    }
}
