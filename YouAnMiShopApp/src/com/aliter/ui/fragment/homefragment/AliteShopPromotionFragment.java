package com.aliter.ui.fragment.homefragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aliter.base.BaseFragment;
import com.aliter.base.BaseFragmentPageAdapter;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.fragment.LocalArticleFragement;
import com.zxly.o2o.fragment.PromotionAcitcityFragment;
import com.zxly.o2o.fragment.PromotionArticleFragment;
import com.zxly.o2o.fragment.StoreArticleFragement;
import com.zxly.o2o.fragment.TerraceArticleFragement;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.PreferUtil;

import java.util.ArrayList;

import butterknife.BindView;


public class AliteShopPromotionFragment extends BaseFragment {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingtool)
    CollapsingToolbarLayout collapsingtool;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinator;
    @BindView(R.id.segment_tab_layout)
    SegmentTabLayout segmentTabLayout;

    private AppBarLayout.Behavior behavior;

    private String[] mTitles = {"今天", "昨天", "近7天", "近30天"};


    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }


    private CollapsingToolbarLayoutState state;
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter myAdapter;

    @Override
    protected void loadData() {
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.alite_fragment_shop_promotion;
    }

    @Override
    protected void initView() {
        initFragmentList();
        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(vp);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        segmentTabLayout.setTabData(mTitles);
        segmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    protected void initInject() {
    }

    private void initFragmentList() {

        if (PreferUtil.getInstance().getDpwz001()) {
            mTitleList.add("店铺文章");
        }
        if (PreferUtil.getInstance().getBdrw001()) {
            mTitleList.add("本地热文");
        }
        if (PreferUtil.getInstance().getWlrw001()) {
            mTitleList.add("网络热文");
        }
        if (PreferUtil.getInstance().getZdywz001()) {
            mTitleList.add("自定义文章");
        }
        if (PreferUtil.getInstance().getHd001()) {
            mTitleList.add("活动");
        }

        if (PreferUtil.getInstance().getDpwz001()) {
            StoreArticleFragement storeArticleFragement = StoreArticleFragement.newInstance(1);
            mFragments.add(storeArticleFragement);
        }
        if (PreferUtil.getInstance().getBdrw001()) {
            LocalArticleFragement localArticleFragement = LocalArticleFragement.newInstance(1);
            mFragments.add(localArticleFragement);
        }
        if (PreferUtil.getInstance().getWlrw001()) {
            mFragments.add(new TerraceArticleFragement());
        }
        if (PreferUtil.getInstance().getZdywz001()) {
            mFragments.add(PromotionArticleFragment.newInstance());
        }
        if (PreferUtil.getInstance().getHd001()) {
            mFragments.add(PromotionAcitcityFragment.newInstance());
        }
        if(mFragments.size()==0||mTitleList.size()==0){
            mTitleList.add("店铺文章");
            StoreArticleFragement storeArticleFragement = StoreArticleFragement.newInstance(1);
            mFragments.add(storeArticleFragement);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
