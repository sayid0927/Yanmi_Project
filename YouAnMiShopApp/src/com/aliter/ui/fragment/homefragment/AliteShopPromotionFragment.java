package com.aliter.ui.fragment.homefragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.aliter.base.BaseFragment;
import com.aliter.base.BaseFragmentPageAdapter;
import com.aliter.ui.fragment.StoreArticlesFragmentAlite;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;

import butterknife.BindView;


public class AliteShopPromotionFragment extends BaseFragment implements AppBarLayout.OnOffsetChangedListener {

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

    }

    @Override
    protected void initInject() {

    }


    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("店铺文章");
        mTitleList.add("本地热文");
        mTitleList.add("网络热文");
        mTitleList.add("自定义文章");
        mTitleList.add("活动");
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
    }

    @Override
    public void onPause() {
        super.onPause();
        appbarLayout.removeOnOffsetChangedListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        appbarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            if (state != CollapsingToolbarLayoutState.EXPANDED) {
                state = CollapsingToolbarLayoutState.EXPANDED;//展开
                toolbarTitle.setVisibility(View.GONE);
            }
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                state = CollapsingToolbarLayoutState.COLLAPSED;//折叠
                toolbarTitle.setVisibility(View.VISIBLE);
            }
        } else {
            if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                    if (toolbarTitle.getVisibility() == View.VISIBLE)
                        toolbarTitle.setVisibility(View.GONE);
                    else
                        toolbarTitle.setVisibility(View.VISIBLE);
                }
                state = CollapsingToolbarLayoutState.INTERNEDIATE;//中间
            }
        }
    }
}
