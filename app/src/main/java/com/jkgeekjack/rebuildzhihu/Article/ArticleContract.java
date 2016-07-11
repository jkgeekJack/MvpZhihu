package com.jkgeekjack.rebuildzhihu.Article;

import com.jkgeekjack.rebuildzhihu.BasePrecenter;
import com.jkgeekjack.rebuildzhihu.BaseView;

/**
 * Created by Administrator on 2016/7/10.
 */
public interface ArticleContract {
    interface View extends BaseView<Precenter>{
        void showAtrticleDetail(String content);
    }
    interface Precenter extends BasePrecenter{
        void loadArticleDetail(int id);
    }
}
