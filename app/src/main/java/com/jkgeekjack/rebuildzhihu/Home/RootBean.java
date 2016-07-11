package com.jkgeekjack.rebuildzhihu.Home;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/10.
 */
public class RootBean {
    private ArrayList<ArticleBean> stories ;
    public void setStories(ArrayList<ArticleBean> stories){
        this.stories = stories;
    }
    public ArrayList<ArticleBean> getStories(){
        return this.stories;
    }
}
