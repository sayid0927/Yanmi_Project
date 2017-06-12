package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class AuthShopRegister {


    /*  areaId	地区id	number
    cityId	城市id	number
    code	验证码	string
    detailedAddress	详细地址	string
    generalizeCode	推广码	string
    headUrl	门店logo图	string
    password	密码	string
    provinceId	省份id	number
    shopName	门店名称	string
    slogan	门店标语	string
    userName	用户账号	string
    villageId	乡镇id	number
    wxHeadUrl	微信头像地址	string
    wxOpenId	微信用户openId	string
    wxUnionId	微信用户统一id	string

*/


    private  int areaId;
    private  int cityId;
    private  String code;
    private  String detailedAddress;
    private  String generalizeCode;
    private  String headUrl;
    private  String password;
    private  String provinceId;
    private  String shopName;
    private  String slogan;
    private  String userName;
    private  String villageId;
    private  String wxHeadUrl;
    private  String wxOpenId;
    private  String wxUnionId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getGeneralizeCode() {
        return generalizeCode;
    }

    public void setGeneralizeCode(String generalizeCode) {
        this.generalizeCode = generalizeCode;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getWxHeadUrl() {
        return wxHeadUrl;
    }

    public void setWxHeadUrl(String wxHeadUrl) {
        this.wxHeadUrl = wxHeadUrl;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    @Override
    public String toString() {
        return "AuthShopRegister{" +
                "areaId=" + areaId +
                ", cityId=" + cityId +
                ", code='" + code + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", generalizeCode='" + generalizeCode + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", password='" + password + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", slogan='" + slogan + '\'' +
                ", userName='" + userName + '\'' +
                ", villageId='" + villageId + '\'' +
                ", wxHeadUrl='" + wxHeadUrl + '\'' +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", wxUnionId='" + wxUnionId + '\'' +
                '}';
    }
}
