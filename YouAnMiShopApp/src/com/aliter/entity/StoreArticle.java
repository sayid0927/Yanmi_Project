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

    private long userId;
    private int type;
    private long shopId;
    private int pageIndex;
    private String codeId;



    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

}
