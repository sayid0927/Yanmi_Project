package com.aliter.ui.activity.myStore;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.aliter.base.BaseActivity;
import com.aliter.base.BaseFragmentPageAdapter;
import com.zxly.o2o.fragment.AllCustomerFragmentNew;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class AllCustomerActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter myAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_allcustomer;
    }

    @Override
    public void setToolBar() {

    }

    @Override
    public void initView() {
        initFragmentList();
        myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments);
        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

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

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        finish();
        finishActivity();
    }
}
