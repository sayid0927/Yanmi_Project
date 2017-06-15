package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class ShopRegister {
//    注册接口1.0


//    areaId	地区id	number
//    cityId	城市id	number
//    code	验证码	string
//    generalizeCode	推广码	string
//    nickName	昵称	string	如果是第三方则是微信昵称
//    password	密码(明文)	string
//    provinceId	省份id	number
//    shopName	门店名称	string
//    userName	用户账号	string
//    wxHeadUrl	微信头像地址	string
//    wxOpenId	微信用户openId	string
//    wxUnionId  微信用户统一id	string

    private  int areaId;
    private  int cityId;
    private  String code;
    private String generalizeCode;
    private  String nickName;
    private  String password;
    private  int provinceId;
    private  String shopName;
    private  String userName;
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

    public String getGeneralizeCode() {
        return generalizeCode;
    }

    public void setGeneralizeCode(String generalizeCode) {
        this.generalizeCode = generalizeCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "ShopRegister{" +
                "areaId=" + areaId +
                ", cityId=" + cityId +
                ", code='" + code + '\'' +
                ", generalizeCode='" + generalizeCode + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", provinceId=" + provinceId +
                ", shopName='" + shopName + '\'' +
                ", userName='" + userName + '\'' +
                ", wxHeadUrl='" + wxHeadUrl + '\'' +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", wxUnionId='" + wxUnionId + '\'' +
                '}';
    }
}
