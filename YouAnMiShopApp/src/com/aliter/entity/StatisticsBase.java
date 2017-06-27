package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class StatisticsBase {

//"shopBrowseCount": 0,
//        "airtleShareCount": 28,
//        "airtleBrowseCount": 75





    private  int shopBrowseCount;
    private  int airtleShareCount;
    private  int airtleBrowseCount;

    public int getShopBrowseCount() {
        return shopBrowseCount;
    }

    public void setShopBrowseCount(int shopBrowseCount) {
        this.shopBrowseCount = shopBrowseCount;
    }

    public int getAirtleShareCount() {
        return airtleShareCount;
    }

    public void setAirtleShareCount(int airtleShareCount) {
        this.airtleShareCount = airtleShareCount;
    }

    public int getAirtleBrowseCount() {
        return airtleBrowseCount;
    }

    public void setAirtleBrowseCount(int airtleBrowseCount) {
        this.airtleBrowseCount = airtleBrowseCount;
    }

    @Override
    public String toString() {
        return "StatisticsBase{" +
                "shopBrowseCount=" + shopBrowseCount +
                ", airtleShareCount=" + airtleShareCount +
                ", airtleBrowseCount=" + airtleBrowseCount +
                '}';
    }
}


