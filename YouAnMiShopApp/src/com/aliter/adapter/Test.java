package com.aliter.adapter;

import com.aliter.entity.StoreArticleBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxly.o2o.shop.R;

import java.util.List;

/**
 * Created by sayid on 2017/6/2.
 */

public class Test extends BaseQuickAdapter<StoreArticleBean, BaseViewHolder> {

    public Test(List<StoreArticleBean> data) {
        super(R.layout.item_store_article, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, StoreArticleBean item) {

        helper.setText(R.id.txt_title,item.getTitle());
        helper.setText(R.id.txt_recomend,item.getDescription());


    }
}
