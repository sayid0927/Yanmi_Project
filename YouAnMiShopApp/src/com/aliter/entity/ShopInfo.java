package com.aliter.entity;

/**
 * Created by sayid on 2017/6/24.
 */

public class ShopInfo {




    private  Long shopId;


    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "shopId=" + shopId +
                '}';
    }
}
