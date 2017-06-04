package com.aliter.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliter.base.BaseFragmentPageAdapter;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;


public class MyStoreFragmentAlite extends Fragment {

    private CollapsingToolbarLayoutState state;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }


    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      View  view = inflater.inflate(R.layout.alite_fragment_my_store, container, false);

        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.my_appbar);

        initFragmentList();
        TabLayout tabGank= (TabLayout) view.findViewById(R.id.tab_gank);
        ViewPager vpGank= (ViewPager) view.findViewById(R.id.vp_gank);

        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vpGank.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabGank.setTabMode(TabLayout.MODE_FIXED);
        tabGank.setupWithViewPager(vpGank);
        return view;
    }

    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("店铺文章");
        mTitleList.add("本地热文");
        mTitleList.add("网络热文");
        mTitleList.add("自定义文章");
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
    }
}
