package com.aliter.ui.fragment;

import android.support.v4.app.Fragment;
import android.webkit.WebView;

import com.aliter.base.BaseFragment;
import com.aliter.base.BaseFragmentPageAdapter;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by sayid on 2017/6/2.
 */

public class ShopPromotionFragmentAlite extends BaseFragment {


    @BindView(R.id.webview_detail)
    WebView webview;

    private ArrayList<String> mTitleList = new ArrayList<>(4);
    private ArrayList<Fragment> mFragments = new ArrayList<>(4);
    private BaseFragmentPageAdapter myAdapter;


    @Override
    protected void loadData() {
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.alite_fragment_strore_articles;
    }

    @Override
    protected void initView() {

        webview.loadUrl("https://www.baidu.com/");

//        initFragmentList();
//        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
//        vpContent.setAdapter(myAdapter);
//        myAdapter.notifyDataSetChanged();
//        tabContent.setTabMode(TabLayout.MODE_FIXED);
//        tabContent.setupWithViewPager(vpContent);

    }

    @Override
    protected void initInject() {

    }


//    private void initFragmentList() {
//        if (mTitleList.size() != 0) {
//            return;
//        }
//        mTitleList.add("店铺文章");
//        mTitleList.add("本地热文");
//        mTitleList.add("网络热文");
//        mTitleList.add("自定义文章");
//        mFragments.add(new StoreArticlesFragmentAlite());
//        mFragments.add(new StoreArticlesFragmentAlite());
//        mFragments.add(new StoreArticlesFragmentAlite());
//        mFragments.add(new StoreArticlesFragmentAlite());
//    }

}
