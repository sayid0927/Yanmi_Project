package com.aliter.entity;

/**
 * Created by sayid on 2017/5/29.
 */

public class StoreArticle {

    /**
     * userId : 1
     * type : 1
     * shopId : 1
     * pageIndex : 1
     */

    private int userId;
    private int type;
    private int shopId;
    private int pageIndex;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

}
