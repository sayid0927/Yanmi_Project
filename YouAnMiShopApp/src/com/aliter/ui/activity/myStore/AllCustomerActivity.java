package com.aliter.ui.activity.myStore;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.base.BaseFragmentPageAdapter;
import com.zxly.o2o.fragment.AllCustomerFragmentNew;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by sayid on 2017/6/22.
 */

public class AllCustomerActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter myAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_allcustomer;
    }

    @Override
    public void setToolBar() {
        setToolBar(toolbar,"");
    }

    @Override
    public void initView() {
        initFragmentList();

        myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments);
        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
//        tabLayout.setupWithViewPager(vp);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

    }

    private void initFragmentList() {
        mFragments.add(new AllCustomerFragmentNew());
    }

}
