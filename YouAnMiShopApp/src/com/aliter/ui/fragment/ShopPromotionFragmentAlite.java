package com.aliter.ui.fragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aliter.base.BaseFragment;
import com.aliter.base.BaseFragmentPageAdapter;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;

import butterknife.BindView;


public class ShopPromotionFragmentAlite extends BaseFragment implements AppBarLayout.OnOffsetChangedListener {

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @BindView(R.id.tab_gank)
    TabLayout tabGank;
    @BindView(R.id.shop_appbar)
    AppBarLayout shopAppbar;
    @BindView(R.id.vp_gank)
    ViewPager vpGank;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_content)
    LinearLayout collapsingContent;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

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
        vpGank.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabGank.setTabMode(TabLayout.MODE_FIXED);
        tabGank.setupWithViewPager(vpGank);

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
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
    }

    @Override
    public void onPause() {
        super.onPause();
        shopAppbar.removeOnOffsetChangedListener(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        shopAppbar.addOnOffsetChangedListener(this);
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
                    if(toolbarTitle.getVisibility()==View.VISIBLE)
                        toolbarTitle.setVisibility(View.GONE);
                    else
                        toolbarTitle.setVisibility(View.VISIBLE);
                }
                state = CollapsingToolbarLayoutState.INTERNEDIATE;//中间
            }
        }
    }
}
