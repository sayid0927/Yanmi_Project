package com.aliter.adapter;

import android.widget.TextView;

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
        TextView textView = helper.getView(R.id.tv_my_order);
        textView.setCompoundDrawablesWithIntrinsicBounds(null, item.getBitmap(), null, null);

    }
}
