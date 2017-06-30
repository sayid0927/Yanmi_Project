package com.aliter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliter.entity.H5ShopBase;
import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.easemob.easeui.AppException;
import com.orhanobut.logger.Logger;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.adapter.ObjectAdapter;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.request.BaseRequest;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.ViewUtils;

import static com.zxly.o2o.request.IMGetUnRegistListRequest.pageIndex;


public class H5ShopAdapter extends ObjectAdapter implements View.OnClickListener {


    public H5ShopAdapter(Context _context) {
        super(_context);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.h5_shop_item;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        final H5ShopBase.ProductsBean loaclItem = (H5ShopBase.ProductsBean) getItem(position);

        if (convertView == null) {

            convertView = inflateConvertView();
            holder = new ViewHolder();
            holder.headIcon = (NetworkImageView) convertView.findViewById(R.id.img_head_icon);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.txt_title);
            holder.txtBrwoseCount = (TextView) convertView.findViewById(R.id.txt_browseCount);
            holder.btnPromotion = (TextView) convertView.findViewById(R.id.btn_promotion);
            holder.txCityName = (TextView) convertView.findViewById(R.id.btn_cityName);
//            holder.txDate = (TextView) convertView.findViewById(R.id.txt_date);
            holder.ivload=(ImageView)convertView.findViewById(R.id.iv_promotion);
            holder.btnPromotion.setOnClickListener(this);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.headIcon.setImageUrl(loaclItem.getHeadUrl(), AppController.imageLoader);
        holder.headIcon.setDefaultImageResId(R.drawable.al_manage_productpic);
        holder.txtTitle.setText(loaclItem.getBrandName()+" "+loaclItem.getProductName());

        holder.txtBrwoseCount.setText(String.valueOf(loaclItem.getMinPrice())+" - "+String.valueOf(loaclItem.getMaxPrice()));
//        holder.txDate.setText(String.valueOf(loaclItem.getMaxPrice()));
        if (loaclItem.getIsShelves() == 1) {   //是否上架,1:上架,2:下架
            holder.btnPromotion.setBackground(context.getResources().getDrawable(R.drawable.alite_h5_shop_selector));
            holder.btnPromotion.setTextColor(context.getResources().getColor(R.color.textSelectColor));
            holder.btnPromotion.setText("下架");

        } else {

            holder.btnPromotion.setBackground(context.getResources().getDrawable(R.drawable.alite_h5_shop_normal));
            holder.btnPromotion.setTextColor(context.getResources().getColor(R.color.white));
            holder.btnPromotion.setText("上架");

        }

        holder.btnPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final H5ShopBase.ProductsBean productsBean = (H5ShopBase.ProductsBean) v.getTag();
              //  1:上架商品,2:下架商品
                final int type;
                type= (productsBean.getIsShelves()==1)?2:1;
                H5ShopShelvesRequest h5ShopShelvesRequest = new H5ShopShelvesRequest(productsBean.getId(), type);
                h5ShopShelvesRequest.setOnResponseStateListener(new BaseRequest.ResponseStateListener() {
                    @Override
                    public void onOK() {
                        holder.btnPromotion.setVisibility(View.VISIBLE);
                        holder.ivload.setVisibility(View.GONE);
                        if (type==1) {

                            ViewUtils.showToast("上架成功");
                            holder.btnPromotion.setBackground(context.getResources().getDrawable(R.drawable.alite_h5_shop_selector));
                            holder.btnPromotion.setTextColor(context.getResources().getColor(R.color.textSelectColor));
                            holder.btnPromotion.setText("下架");
                            productsBean.setIsShelves(1);

                        } else {
                            ViewUtils.showToast("下架成功");
                            holder.btnPromotion.setBackground(context.getResources().getDrawable(R.drawable.alite_h5_shop_normal));
                            holder.btnPromotion.setTextColor(context.getResources().getColor(R.color.white));
                            holder.btnPromotion.setText("上架");
                            productsBean.setIsShelves(2);

                        }
                    }

                    @Override
                    public void onFail(int code) {

                    }
                });
                holder.btnPromotion.setVisibility(View.GONE);
                holder.ivload.setVisibility(View.VISIBLE);
                Glide.with(context).load(R.drawable.il_manage_loading).asGif().diskCacheStrategy(DiskCacheStrategy.NONE)
                        .fitCenter()
                        .dontAnimate()
                        .into(holder.ivload);

                h5ShopShelvesRequest.start();

            }
        });
        holder.loaclItem = loaclItem;
        holder.btnPromotion.setTag(loaclItem);
        return convertView;
    }


    class ViewHolder {
        H5ShopBase.ProductsBean loaclItem;
        NetworkImageView headIcon;
        TextView txtTitle, txtBrwoseCount;
        TextView txCityName;
        TextView btnPromotion;
        ImageView ivload;
    }


//    id	推荐商品id	number
//    shopId	门店id	number
//    type	1:上架商品,2:下架商品	number


    class H5ShopShelvesRequest extends BaseRequest {

        public H5ShopShelvesRequest(int id, int type) {
            addParams("id", pageIndex);
            addParams("type", type);
            addParams("shopId", Account.user.getShopId());
        }

        @Override
        protected void fire(String data) throws AppException {

            Logger.t("TAG").d(data);

        }

        @Override
        protected String method() {
            return "/commend/product/shelves";
        }
    }
}
