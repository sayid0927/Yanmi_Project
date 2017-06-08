package com.aliter.adapter;

import android.view.View;
import android.widget.ImageView;

import com.aliter.entity.StoreArticleBean;
import com.blankj.utilcode.utils.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.utils.GlideUtils;
import com.zxly.o2o.shop.R;

import java.util.List;

/**
 * Created by sayid on 2017/6/8.
 */

public class AliteStoreArticleAdapter extends BaseQuickAdapter<StoreArticleBean, BaseViewHolder> {

    public AliteStoreArticleAdapter(List<StoreArticleBean> data) {
        super(R.layout.alite_item_store_article, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, StoreArticleBean item) {

        List<StoreArticleBean.LabelsBean> labelsBeen = item.getLabels();

        if (labelsBeen.size() != 0)
            helper.setText(R.id.btn_cityName, labelsBeen.get(0).getName());
        helper.setText(R.id.txt_title, item.getTitle());
        helper.setText(R.id.txt_browseCount, String.valueOf(item.getScanCount())+"次推广");
        if(!StringUtils.isEmpty(item.getHeadUrl()))


        GlideUtils.loadMovieTopImg((ImageView) helper.getView(R.id.img_head_icon),item.getHeadUrl());
        else
            helper.getView(R.id.img_head_icon).setVisibility(View.GONE);
    }
}
