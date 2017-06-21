package com.aliter.ui.activity.self;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.base.BaseFragmentPageAdapter;
import com.zxly.o2o.activity.YamCollegeListAct;
import com.zxly.o2o.fragment.MakeMoneyFragment;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sayid on 2017/6/21.
 */

public class AliteMeakeMoneyActivity extends BaseActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter myAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_meake_money;
    }

    @Override
    public void setToolBar() {
            setToolBar(toolbar,"");
    }

    @Override
    public void initView() {
        initFragmentList();

        myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(vp);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

    }

    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }


        mTitleList.add("赚钱攻略");
        mTitleList.add("柚安迷商学院");

        mFragments.add(new MakeMoneyFragment());
        mFragments.add(new YamCollegeListAct());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
