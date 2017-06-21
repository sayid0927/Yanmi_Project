package com.aliter.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.aliter.base.BaseActivity;
import com.aliter.base.BaseFragmentPageAdapter;
import com.aliter.entity.ShopAppMenu;
import com.aliter.entity.ShopAppMenuBean;
import com.aliter.injector.component.AliteHomeActivityModule;
import com.aliter.injector.component.activity.DaggerHomeActivityComponent;
import com.aliter.presenter.HomeActivityPresenter;
import com.aliter.presenter.impl.HomeActivityPresenterImpl;
import com.aliter.ui.fragment.MyStoreFragmentAlite;
import com.aliter.ui.fragment.SelfFragmentAlite;
import com.aliter.ui.fragment.homefragment.AliteShopPromotionFragment;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.PreferUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AliterHomeActivity extends BaseActivity<HomeActivityPresenterImpl> implements HomeActivityPresenter.View {

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
    private Drawable myStoreIconSelected, myStoreIcon, shopPromotionIcon, shopPromotionIconSelected, mySelfIcon, mySelfIconSelected;

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
        myStoreIcon = this.getResources().getDrawable(R.drawable.al_icon_store);
        myStoreIconSelected = this.getResources().getDrawable(R.drawable.al_icon_store_click);
        shopPromotionIcon = this.getResources().getDrawable(R.drawable.al_icon_name);
        shopPromotionIconSelected = this.getResources().getDrawable(R.drawable.al_icon_name_click);
        mySelfIcon = this.getResources().getDrawable(R.drawable.al_icon_me);
        mySelfIconSelected = this.getResources().getDrawable(R.drawable.al_icon_me_click);

        ShopAppMenu shopAppMenu = new ShopAppMenu();
        shopAppMenu.setShopId("1");
        mPresenter.ShopAppMenu(shopAppMenu);

        getSwipeBackLayout().setEnableGesture(false);
        setVpContentChangeListener();

//        initFragmentList();

    }


    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
        DaggerHomeActivityComponent.builder().aliteHomeActivityModule(new AliteHomeActivityModule()).build().injectWeChat(this);
    }

    private void initFragmentList() {

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new AliteShopPromotionFragment());
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
                        setSelectedIcon(0);
                        break;
                    case 1:
                        rgHomeViewpagerContorl.check(R.id.rb_my_store);
                        setSelectedIcon(1);
                        break;
                    case 2:
                        rgHomeViewpagerContorl.check(R.id.rb_self);
                        setSelectedIcon(2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setVpContentChangeListener() {
        rgHomeViewpagerContorl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i) {
                    case R.id.rb_shop_promotion:
                        // vpContent.setCurrentItem(0);// 设置当前页面
                        vpContent.setCurrentItem(0, false);// false去掉viewpager切换页面的动画
                        setSelectedIcon(0);

                        break;

                    case R.id.rb_my_store:
//                        vpContent.setCurrentItem(1);
                        vpContent.setCurrentItem(1, false);
                        setSelectedIcon(1);


                        break;
                    case R.id.rb_self:
//                        vpContent.setCurrentItem(2);
                        vpContent.setCurrentItem(2, false);
                        setSelectedIcon(2);
                        break;
                }
            }
        });
    }

    private void setSelectedIcon(int position) {
        switch (position) {
            case 0:
                rbMyStore.setCompoundDrawablesWithIntrinsicBounds(null, myStoreIcon, null, null);
                rbSelf.setCompoundDrawablesWithIntrinsicBounds(null, mySelfIcon, null, null);
                rbShopPromotion.setCompoundDrawablesWithIntrinsicBounds(null, shopPromotionIconSelected, null, null);
                rbShopPromotion.setTextColor(this.getResources().getColor(R.color.half_transparent_orange));
                rbSelf.setTextColor(this.getResources().getColor(R.color.black));
                rbMyStore.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case 1:
                rbMyStore.setCompoundDrawablesWithIntrinsicBounds(null, myStoreIconSelected, null, null);
                rbSelf.setCompoundDrawablesWithIntrinsicBounds(null, mySelfIcon, null, null);
                rbShopPromotion.setCompoundDrawablesWithIntrinsicBounds(null, shopPromotionIcon, null, null);
                rbShopPromotion.setTextColor(this.getResources().getColor(R.color.black));
                rbSelf.setTextColor(this.getResources().getColor(R.color.black));
                rbMyStore.setTextColor(this.getResources().getColor(R.color.half_transparent_orange));
                break;
            case 2:
                rbMyStore.setCompoundDrawablesWithIntrinsicBounds(null, myStoreIcon, null, null);
                rbSelf.setCompoundDrawablesWithIntrinsicBounds(null, mySelfIconSelected, null, null);
                rbShopPromotion.setCompoundDrawablesWithIntrinsicBounds(null, shopPromotionIcon, null, null);
                rbShopPromotion.setTextColor(this.getResources().getColor(R.color.black));
                rbSelf.setTextColor(this.getResources().getColor(R.color.half_transparent_orange));
                rbMyStore.setTextColor(this.getResources().getColor(R.color.black));
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1000) {
                if (SelfFragmentAlite.install != null)
                    SelfFragmentAlite.install.setImgUserHead();
            }
        }
    }


    @Override
    public void onShopAppMenuSuccessView(List<ShopAppMenuBean> shopAppMenuBean) {
        String tmp;
        ///   先简单处理 下次优化算法
        for (int i = 0; i < shopAppMenuBean.size(); i++) {
            tmp = shopAppMenuBean.get(i).getCode();
            if (tmp.equals("dpwz001")) {
                PreferUtil.getInstance().setDpwz001(true);
            }
            if (tmp.equals("bdrw001")) {
                PreferUtil.getInstance().setBdrw001(true);
            }
            if (tmp.equals("wlrw001")) {
                PreferUtil.getInstance().setWlrw001(true);
            }
            if (tmp.equals("zdywz001")) {
                PreferUtil.getInstance().setZdywz001(true);
            }
            if (tmp.equals("hd001")) {
                PreferUtil.getInstance().setHd001(true);
            }
            if (tmp.equals("wdwd001")) {
                PreferUtil.getInstance().setWdwd001(true);
            }
            if (tmp.equals("syb001")) {
                PreferUtil.getInstance().setSyb001(true);
            }
            if (tmp.equals("llcz001")) {
                PreferUtil.getInstance().setLlcz001(true);
            }
            if (tmp.equals("zyj001")) {
                PreferUtil.getInstance().setZyj001(true);
            }
            if (tmp.equals("dybd001")) {
                PreferUtil.getInstance().setDybd001(true);
            }
            if (tmp.equals("shqd001")) {
                PreferUtil.getInstance().setShqd001(true);
            }
            if (tmp.equals("yhlq001")) {
                PreferUtil.getInstance().setYhlq001(true);
            }
            if (tmp.equals("yhtj001")) {
                PreferUtil.getInstance().setYhtj001(true);
            }
            if (tmp.equals("ddgl001")) {
                PreferUtil.getInstance().setDdgl001(true);
            }
            if (tmp.equals("zqgl001")) {
                PreferUtil.getInstance().setZqgl001(true);
            }
        }
        initFragmentList();
    }

    @Override
    public void onFailView(String errorMsg) {
        initFragmentList();
    }
}
