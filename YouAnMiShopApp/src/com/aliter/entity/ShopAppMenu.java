package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class ShopAppMenu {

   private  String 	shopId;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "ShopAppMenu{" +
                "shopId='" + shopId + '\'' +
                '}';
    }
}
