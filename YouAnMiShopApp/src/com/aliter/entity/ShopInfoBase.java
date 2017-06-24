package com.aliter.entity;

/**
 * Created by sayid on 2017/6/24.
 */

public class ShopInfoBase {


//    areaId	地区id	number
//    cityId	城市id	number
//    detailedAddress	详细地址	string
//    headUrl	封面图	string
//    iconUrl	门店图标地址	string
//    imageUrls	店铺图片列表	string
//    labelNames	门店标签	string
//    name	门店名称	string
//    provinceId	省份id	number
//    serverPhone	客服电话	string
//    slogan	门店标语	string
//    villageId	乡村id	string


    private  int areaId;
    private  int cityId;
    private  String detailedAddress;
    private  String headUrl;
    private  String iconUrl;
    private  String imageUrls;
    private  String labelNames;
    private  String name;
    private  int provinceId;
    private  String serverPhone;
    private  String slogan;
    private  String villageId;


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

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(String labelNames) {
        this.labelNames = labelNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    @Override
    public String toString() {
        return "ShopInfoBase{" +
                "areaId=" + areaId +
                ", cityId=" + cityId +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", imageUrls='" + imageUrls + '\'' +
                ", labelNames='" + labelNames + '\'' +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                ", serverPhone='" + serverPhone + '\'' +
                ", slogan='" + slogan + '\'' +
                ", villageId='" + villageId + '\'' +
                '}';
    }
}
