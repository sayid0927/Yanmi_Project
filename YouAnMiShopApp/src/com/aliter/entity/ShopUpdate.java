package com.aliter.entity;

/**
 * Created by sayid on 2017/6/24.
 */

public class ShopUpdate {


//    areaId	地区id	number	type=4,必传
//    cityId	城市id	number	type=4,必传
//    detailedAddress	详细地址	string	type=5,不传则设置为空
//    iconUrl	门店图标	string	type=1
//    provinceId	省份id	number	type=4,必传
//    serverPhone	客服电话	string	type=3,不传则设置为空
//    shopId	门店id	number
//    slogan	门店标语	string	type=2
//    type	修改类型,1:门店图标,2:门店标语,3:客服电话,4:地址,5:详细地址	number


    private  int areaId;
    private  int cityId;
    private  String detailedAddress;
    private  String iconUrl;
    private  int provinceId;
    private  String serverPhone;
    private  Long shopId;
    private  String slogan;
    private  int type;


    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getServerPhone() {
        return serverPhone;
    }

    public void setServerPhone(String serverPhone) {
        this.serverPhone = serverPhone;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShopUpdate{" +
                "areaId=" + areaId +
                ", cityId=" + cityId +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", provinceId=" + provinceId +
                ", serverPhone='" + serverPhone + '\'' +
                ", shopId=" + shopId +
                ", slogan='" + slogan + '\'' +
                ", type=" + type +
                '}';
    }
}
