package com.aliter.adapter;

import android.view.View;

import com.aliter.entity.MySroreAuthority;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxly.o2o.shop.R;

import java.util.List;

/**
 * Created by sayid on 2017/6/8.
 */

public class MyStoreAdapter extends BaseQuickAdapter<MySroreAuthority, BaseViewHolder> {

    public MyStoreAdapter(List<MySroreAuthority> data) {
        super(R.layout.alite_item_my_store, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySroreAuthority item) {
        helper.setText(R.id.tv_my_order, item.getTitle());
        if(item.getBitmap()!=null)
        helper.setImageDrawable(R.id.icon,item.getBitmap());
        if(item.getKehuIconShow()!=1){
            helper.getView(R.id.txt_keduoduo).setVisibility(View.VISIBLE);
        }else {
            helper.getView(R.id.txt_keduoduo).setVisibility(View.GONE);
        }
    }
}
