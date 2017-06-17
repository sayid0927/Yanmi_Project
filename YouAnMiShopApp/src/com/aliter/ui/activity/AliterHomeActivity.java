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
import com.aliter.ui.fragment.MyStoreFragmentAlite;
import com.aliter.ui.fragment.SelfFragmentAlite;
import com.aliter.ui.fragment.homefragment.AliteShopPromotionFragment;
import com.yongchun.library.view.ImageSelectorActivity;
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
    private  Drawable myStoreIconSelected,myStoreIcon,shopPromotionIcon,shopPromotionIconSelected,mySelfIcon,mySelfIconSelected;
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


        getSwipeBackLayout().setEnableGesture(false);
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

    private  void  setVpContentChangeListener(){
        rgHomeViewpagerContorl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i) {
                    case R.id.rb_shop_promotion:
                       // vpContent.setCurrentItem(0);// 设置当前页面
                        vpContent.setCurrentItem(0,false);// false去掉viewpager切换页面的动画
                        setSelectedIcon(0);
                        break;

                    case R.id.rb_my_store:
//                        vpContent.setCurrentItem(1);
                        vpContent.setCurrentItem(1,false);
                        setSelectedIcon(1);

                        break;
                    case R.id.rb_self:
//                        vpContent.setCurrentItem(2);
                        vpContent.setCurrentItem(2,false);
                        setSelectedIcon(2);
                        break;
                }
            }
        });
    }

    private  void  setSelectedIcon(int position){
        switch (position){
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
        if(resultCode == RESULT_OK && requestCode == ImageSelectorActivity.REQUEST_IMAGE){
            ArrayList<String> images = (ArrayList<String>) data.getSerializableExtra(ImageSelectorActivity.REQUEST_OUTPUT);
            if(SelfFragmentAlite.install!=null)
            SelfFragmentAlite.install.setImgUserHead(images);
        }
    }
}
