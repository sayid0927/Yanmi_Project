package com.aliter.adapter;

import android.widget.ImageView;

import com.aliter.entity.H5ShopBase;
import com.aliter.utils.GlideUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.StringUtil;

import java.util.List;


public class H5ShopListAdapter extends BaseQuickAdapter<H5ShopBase.ProductsBean, BaseViewHolder> {

    public H5ShopListAdapter(List<H5ShopBase.ProductsBean> data) {
        super(R.layout.h5_shop_item,data);
    }



    @Override
    protected void convert(BaseViewHolder helper, H5ShopBase.ProductsBean item) {

        ImageView ivPic = helper.getView(R.id.img_head_icon);
        if(!StringUtil.isNull(item.getHeadUrl())){
            GlideUtils.loadMovieLatestImg(ivPic,item.getHeadUrl());
        }

        helper.setText(R.id.txt_title,item.getProductName());
        helper.setText(R.id.txt_browseCount,String.valueOf(item.getMinPrice()));
        helper.setText(R.id.txt_date,String.valueOf(item.getMaxPrice()));


    }
}
