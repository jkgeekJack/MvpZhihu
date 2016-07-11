package com.jkgeekjack.rebuildzhihu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/8.
 */
public abstract class BaseFragment extends Fragment {
    private static View view;
    public BaseFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(bindLayout(),container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.view=view;
        initView();
        doBusiness(getActivity());
        super.onViewCreated(view, savedInstanceState);

    }

    /**
     * [初始化数据]
     *
     * @return
     */
    public abstract void initVariable();
    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();
    /**
     * [初始化控件]
     *
     * @param
     */
    public abstract void initView();

    /**
     * [业务操作]
     *
     * @param mContext
     */
    public abstract void doBusiness(Context mContext);
    /**
     * [简化Toast]
     * @param msg
     */
    protected void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
    protected    <T extends View> T $(int resId) {
        return (T) view.findViewById(resId);
    }
}
