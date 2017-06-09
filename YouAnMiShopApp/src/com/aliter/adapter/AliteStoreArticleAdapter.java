package com.aliter.adapter;

import android.widget.ImageView;

import com.aliter.entity.StoreArticleBean;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.aliter.utils.GlideUtils;
import com.zxly.o2o.shop.R;

import java.util.List;

/**
 * Created by sayid on 2017/6/8.
 */

public class AliteStoreArticleAdapter extends  BaseMultiItemQuickAdapter<StoreArticleBean, BaseViewHolder>{

    public AliteStoreArticleAdapter(List<StoreArticleBean> data) {
        super(data);
        addItemType(StoreArticleBean.ICON,R.layout.alite_item_store_article);
        addItemType(StoreArticleBean.NO_ICON, R.layout.alite_item_store_article_no_icon);
    }

    @Override
    protected void convert(BaseViewHolder helper, final StoreArticleBean item) {

        List<StoreArticleBean.LabelsBean> labelsBeen = item.getLabels();
        switch (helper.getItemViewType()) {
            case StoreArticleBean.ICON:
                if (labelsBeen.size() != 0)
                    helper.setText(R.id.btn_cityName, labelsBeen.get(0).getName());

                helper.setText(R.id.txt_title, item.getTitle());
                helper.setText(R.id.txt_browseCount, String.valueOf(item.getScanCount()) + "次推广");

                GlideUtils.loadMovieTopImg((ImageView) helper.getView(R.id.img_head_icon), item.getHeadUrl());
                break;
            case StoreArticleBean.NO_ICON:
                if (labelsBeen.size() != 0)
                    helper.setText(R.id.btn_cityName, labelsBeen.get(0).getName());
                helper.setText(R.id.txt_title, item.getTitle());
                helper.setText(R.id.txt_browseCount, String.valueOf(item.getScanCount()) + "次推广");

                break;

        }

        helper.addOnClickListener(R.id.ll_share);

    }

}
