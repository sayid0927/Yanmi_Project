package com.aliter.entity;

/**
 * Created by Sayid on 2017/5/19.
 */

public class LoginBean {

        /**
         * id : 1
         * shopId : 1
         * shopUserId : 1
         * userName : 13728890837
         * userShopId : 1
         * roleId : 477
         * roleType : 1
         * token : DAC0F40498DB3E456C2CB3EBD05B150095198E6D28440A43C47C9326CA60D5FDB9982C168F6DCE736A74E4BA0EDF7655
         * userStatus : 2
         * shopStatus : 1
         * shopName : 测试门店
         * roleName : 管理员
         * isBoss : 1
         * nickname : 啦啦@啦啦yh
         * gender : 2
         * mobilePhone : 13728890837
         * provinceName : 上海市
         * promotionCode : 5s00
         * birthday : 882460800000
         * thumHeadUrl : http://cdnimg3.youanmi.com/yam/M00/0C/05/eExLKlhGGImAJxY1AAAJB8WpLOQ906.jpg
         * originHeadUrl : http://cdnimg3.youanmi.com/yam/M00/0C/05/eExLKlhGGImALL46AABIGy9QGmw570.jpg
         * appIconUrl : http://cdnimg3.youanmi.com/yam/M00/00/F4/eExLKlfHi3CAAxtBAAAbhm4VHkA397.png
         * originalPassword : E10ADC3949BA59ABBE56E057F20F883E
         * signKey : HTCGSxsXNWPrEHhSXhpK1YVXLLCDYxgWSKw9VNltFw8=
         * serialNum : 0001
         * packageName : 20170104
         */

        private int id;
        private int shopId;
        private int shopUserId;
        private String userName;
        private int userShopId;
        private int roleId;
        private int roleType;
        private String token;
        private int userStatus;
        private int shopStatus;
        private String shopName;
        private String roleName;
        private int isBoss;
        private String nickname;
        private int gender;
        private String mobilePhone;
        private String provinceName;
        private String promotionCode;
        private long birthday;
        private String thumHeadUrl;
        private String originHeadUrl;
        private String appIconUrl;
        private String originalPassword;
        private String signKey;
        private String serialNum;
        private String packageName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public int getShopUserId() {
            return shopUserId;
        }

        public void setShopUserId(int shopUserId) {
            this.shopUserId = shopUserId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserShopId() {
            return userShopId;
        }

        public void setUserShopId(int userShopId) {
            this.userShopId = userShopId;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public int getRoleType() {
            return roleType;
        }

        public void setRoleType(int roleType) {
            this.roleType = roleType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(int userStatus) {
            this.userStatus = userStatus;
        }

        public int getShopStatus() {
            return shopStatus;
        }

        public void setShopStatus(int shopStatus) {
            this.shopStatus = shopStatus;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public int getIsBoss() {
            return isBoss;
        }

        public void setIsBoss(int isBoss) {
            this.isBoss = isBoss;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getPromotionCode() {
            return promotionCode;
        }

        public void setPromotionCode(String promotionCode) {
            this.promotionCode = promotionCode;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public String getThumHeadUrl() {
            return thumHeadUrl;
        }

        public void setThumHeadUrl(String thumHeadUrl) {
            this.thumHeadUrl = thumHeadUrl;
        }

        public String getOriginHeadUrl() {
            return originHeadUrl;
        }

        public void setOriginHeadUrl(String originHeadUrl) {
            this.originHeadUrl = originHeadUrl;
        }

        public String getAppIconUrl() {
            return appIconUrl;
        }

        public void setAppIconUrl(String appIconUrl) {
            this.appIconUrl = appIconUrl;
        }

        public String getOriginalPassword() {
            return originalPassword;
        }

        public void setOriginalPassword(String originalPassword) {
            this.originalPassword = originalPassword;
        }

        public String getSignKey() {
            return signKey;
        }

        public void setSignKey(String signKey) {
            this.signKey = signKey;
        }

        public String getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(String serialNum) {
            this.serialNum = serialNum;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

    @Override
    public String toString() {
        return "LoginBean{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", shopUserId=" + shopUserId +
                ", userName='" + userName + '\'' +
                ", userShopId=" + userShopId +
                ", roleId=" + roleId +
                ", roleType=" + roleType +
                ", token='" + token + '\'' +
                ", userStatus=" + userStatus +
                ", shopStatus=" + shopStatus +
                ", shopName='" + shopName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", isBoss=" + isBoss +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", promotionCode='" + promotionCode + '\'' +
                ", birthday=" + birthday +
                ", thumHeadUrl='" + thumHeadUrl + '\'' +
                ", originHeadUrl='" + originHeadUrl + '\'' +
                ", appIconUrl='" + appIconUrl + '\'' +
                ", originalPassword='" + originalPassword + '\'' +
                ", signKey='" + signKey + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", packageName='" + packageName + '\'' +
                '}';
    }
}

