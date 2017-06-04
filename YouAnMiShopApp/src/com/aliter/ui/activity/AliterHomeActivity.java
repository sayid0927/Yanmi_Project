package com.aliter.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.aliter.base.BaseActivity;
import com.aliter.base.BaseFragmentPageAdapter;
import com.aliter.ui.fragment.MyStoreFragmentAlite;
import com.aliter.ui.fragment.SelfFragmentAlite;
import com.aliter.ui.fragment.ShopPromotionFragmentAlite;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AliterHomeActivity extends BaseActivity {

    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.rb_shop_promotion)
    RadioButton rbShopPromotion;
    @BindView(R.id.rb_my_store)
    RadioButton rbMyStore;
    @BindView(R.id.rb_self)
    RadioButton rbSelf;
    @BindView(R.id.rg_home_viewpager_contorl)
    RadioGroup rgHomeViewpagerContorl;

    private BaseFragmentPageAdapter myAdapter;

    @Override
    public void setState(int state) {
    }


    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_home;
    }

    @Override
    public void setToolBar() {

    }

    @Override
    public void initView() {
        setVpContentChangeListener();
        initFragmentList();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
    }

    private void initFragmentList() {

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new ShopPromotionFragmentAlite());
        mFragmentList.add(new MyStoreFragmentAlite());
        mFragmentList.add(new SelfFragmentAlite());
        vpContent.setAdapter(new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
        vpContent.setCurrentItem(0);
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rgHomeViewpagerContorl.check(R.id.rb_shop_promotion);
                        break;
                    case 1:
                        rgHomeViewpagerContorl.check(R.id.rb_my_store);
                        break;
                    case 2:
                        rgHomeViewpagerContorl.check(R.id.rb_self);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private  void  setVpContentChangeListener(){
        rgHomeViewpagerContorl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i) {
                    case R.id.rb_shop_promotion:
                        vpContent.setCurrentItem(0);// 设置当前页面
//                        vpContent.setCurrentItem(0,false);// false去掉viewpager切换页面的动画
                        break;
                    case R.id.rb_my_store:
                        vpContent.setCurrentItem(1);
                        break;
                    case R.id.rb_self:
                        vpContent.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
