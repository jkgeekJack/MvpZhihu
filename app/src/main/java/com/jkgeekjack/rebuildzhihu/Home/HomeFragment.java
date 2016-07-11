package com.jkgeekjack.rebuildzhihu.Home;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jkgeekjack.rebuildzhihu.Article.ArticleActivity;
import com.jkgeekjack.rebuildzhihu.BaseFragment;
import com.jkgeekjack.rebuildzhihu.R;
import com.jkgeekjack.rebuildzhihu.adapter.ArticleAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeContract.View{
    private String type;
    private ListView lvNews;
    private ArticleAdapter adapter;
    private HomeContract.Precenter precenter;

    @Override
    public void initVariable() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        lvNews=$(R.id.lvNews);
    }

    @Override
    public void doBusiness(Context mContext) {
        //创建P传入V
        precenter=new HomePrecenter(this);
        setPrecenter(precenter);
    }

    public static HomeFragment getInstance(String type){
        HomeFragment homeFragment=new HomeFragment();
        homeFragment.type=type;
        return homeFragment;
    }
    @Override
    public void showArticle(final List<ArticleBean> articleBeanList) {
        adapter=new ArticleAdapter(articleBeanList,getContext());
        lvNews.setAdapter(adapter);
        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), ArticleActivity.class);
                intent.putExtra("id",articleBeanList.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void setPrecenter(HomeContract.Precenter precenter) {
        precenter.loadArticle(type);
    }

    @Override
    public void onResume() {
        super.onResume();
//        precenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
//        precenter.unsubscribe();
    }
}
