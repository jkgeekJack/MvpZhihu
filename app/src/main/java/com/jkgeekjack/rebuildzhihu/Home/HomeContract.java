package com.jkgeekjack.rebuildzhihu.Home;

import com.jkgeekjack.rebuildzhihu.BasePrecenter;
import com.jkgeekjack.rebuildzhihu.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public interface HomeContract {
    interface View extends BaseView<Precenter> {
        void showArticle(List<ArticleBean>articleBeanList);
    }
    interface Precenter extends BasePrecenter {
        void loadArticle(String type);
    }

}
