package com.jkgeekjack.rebuildzhihu.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jkgeekjack.rebuildzhihu.BaseActivity;
import com.jkgeekjack.rebuildzhihu.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {
    private TabLayout tab;
    private ViewPager pager;
    private List<HomeFragment> fragmentList=new ArrayList<HomeFragment>();
    private List<String> titleList=new ArrayList<String>();
    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initParms(Bundle parms) {
        fragmentList.add(HomeFragment.getInstance("今日头条"));
        fragmentList.add(HomeFragment.getInstance("互联网安全"));
        fragmentList.add(HomeFragment.getInstance("不准无聊"));
        fragmentList.add(HomeFragment.getInstance("体育日报"));
        titleList.add("今日头条");
        titleList.add("互联网安全");
        titleList.add("不准无聊");
        titleList.add("体育日报");
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        tab=$(R.id.tab);
        pager=$(R.id.pager);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doBusiness(Context mContext) {
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        });
        tab.setupWithViewPager(pager);
    }
}
