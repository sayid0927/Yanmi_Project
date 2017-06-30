package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class H5Shop {

//    pageIndex	查询页数	number	不传默认1
//    pageSize	每页大小	number	Long类型
//    shopId	门店id	number

    private int pageIndex;
    private Long pageSize;
    private  Long shopId;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "H5Shop{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", shopId=" + shopId +
                '}';
    }
}
