/**
 * Copyright(C)2012-2013 深圳市掌星立意科技有限公司版权所有
 * 创 建 人:Jacky
 * 修 改 人:
 * 创 建日期:2013-7-25
 * 描    述:xml储存数据
 * 版 本 号:
 */
package com.zxly.o2o.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.aliter.entity.ShopInfoBase;
import com.aliter.entity.WeixinUserInfoBean;

import java.util.Map;


public final class PreferUtil {

    public static PreferUtil INSTANCE;
    private static SharedPreferences mPrefer;
    private static final String APP_NAME = "com.zxly.o2o.sharedPreferences";
    private static final String LOGIN_USER = "login_user";
    private static final String LOGIN_TOKEN = "login_token";
    private static final String TOPIC_BV = "Topicbv";
    private static final String ARTICLE_BV = "Articlebv";
    private static final String ARTICLEREPLY_BV = "ArticleReplybv";
    private static final String HOME_MAINTAIN = "homepage_maintain";
    private static final String REGISTER_PHONE = "register_phone";
    private static final String REGISTER_PWD = "register_pwd";
    private static final String REGISTER_CODE = "register_code";

    private static final String SHOP_APPSETPASSWORD_CODE = "ShopAppSetPasswordCode";
    private static final String SHOP_APPSETPASSWORD_NUM = "ShopAppSetPasswordNum";


    private static final String SHOP_DPWZ_001 = "shop_dpwz_001";
    private static final String SHOP_BDRW_001 = "shop_bdrw_001";
    private static final String SHOP_WLRW_001 = "shop_wlrw_001";
    private static final String SHOP_ZDYWZ_001 = "shop_zdywz_001";
    private static final String SHOP_HD_001 = "shop_hd_001";
    private static final String SHOP_WDWD_001 = "shop_wdwd_001";
    private static final String SHOP_SYB_001 = "shop_syb_001";
    private static final String SHOP_LLCZ_001 = "shop_llcz_001";
    private static final String SHOP_ZYJ_001 = "shop_zyj_001";
    private static final String SHOP_SYBD_001 = "shop_sybd_001";
    private static final String SHOP_SHQD_001 = "shop_shqd_001";
    private static final String SHOP_YHLQ_001 = "shop_yhlq_001";
    private static final String SHOP_YHTJ_001 = "shop_yhtj_001";
    private static final String SHOP_DDGL_001 = "shop_DDGL_001";
    private static final String SHOP_ZQGL_001 = "shop_zqgl_001";
    private static final String SHOP_DYBD_001 = "shop_dybd_001";
    private static final String SHOP_KDD_001 = "shop_kdd_001";


    private static final String NOTIFY_ALL = "notification_all";
    private static final String NOTIFY_LOGOUT = "notification_logout";
    private static final String NOTIFY_SLEEP = "notification_sleep";
    private static final String NOTIFY_ORDER = "notification_order";
    private static final String NOTIFY_MONEY = "notification_money";
    private static final String NOTIFY_SYSTEM = "notification_system";
    private static final String NOTIFY_FEEDBACK = "notification_feedback";
    private static final String CONTACT_UPDATE = "contact_update";



    private static final String SHOP_INFO_AREAID = "shop_info_areaid";
    private static final String SHOP_INFO_CITYID = "shop_info_cityid";
    public static final String SHOP_INFO_DETAILEDADDRESS = "shop_info_detailedaddress";
    private static final String SHOP_INFO_HEADURL = "shop_info_headurl";
    public static final String SHOP_INFO_ICONURL = "shop_info_iconurl";
    private static final String SHOP_INFO_IMAGEURLS = "shop_info_imageurls";
    private static final String SHOP_INFO_LABELNAMES = "shop_info_labelnames";
    private static final String SHOP_INFO_NAME = "shop_info_name";
    private static final String SHOP_INFO_PROVINCEID = "shop_info_provinceid";
    public static final String SHOP_INFO_SERVERPHONE = "shop_info_serverphone";
    public static final String SHOP_INFO_SLOGAN = "shop_info_slogan";
    private static final String SHOP_INFO_VILLAGEID = "shop_info_villageid";

    public static final String SHOP_INFO_CITYNAME = "shop_info_cityname";
    public static final String SHOP_INFO_PROVINCENAME = "shop_info_provincename";
    public static final String SHOP_INFO_AREANAME = "shop_info_areaname";
    public static final String SHOP_INFO_H5URL = "shop_info_h5url";

    public static final String SHOP_PACK_TYPE = "shop_pack_type";



    private PreferUtil() {
    }

    public static PreferUtil getInstance() {
        if (INSTANCE == null) {
            return new PreferUtil();
        }
        return INSTANCE;
    }

    public void init(Context ctx) {
        mPrefer = ctx.getSharedPreferences(APP_NAME, Context.MODE_WORLD_READABLE
                | Context.MODE_WORLD_WRITEABLE);
        mPrefer.edit().commit();
    }


    public String getString(String key, String defValue) {
        return mPrefer.getString(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return mPrefer.getInt(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mPrefer.getBoolean(key, defValue);
    }

    public void putString(String key, String value) {
        mPrefer.edit().putString(key, value).commit();
    }

    public void putInt(String key, int value) {
        mPrefer.edit().putInt(key, value).commit();
    }

    public void putBoolean(String key, boolean value) {
        mPrefer.edit().putBoolean(key, value).commit();
    }

    public void putLong(String key, long value) {
        mPrefer.edit().putLong(key, value).commit();
    }

    public long getLong(String key, long defValue) {
        return mPrefer.getLong(key, defValue);
    }

    public void removeKey(String key) {
        mPrefer.edit().remove(key).commit();
    }

    public void setLoginUser(String userStr) {
        putString(LOGIN_USER, userStr);
    }


    public void setLoginToken(String tokenStr) {
        putString(LOGIN_TOKEN, tokenStr);
    }

    public String getLoginToken() {
        return getString(LOGIN_TOKEN, "");
    }


    public String getMyCircleTopicBV() {
        return getString(TOPIC_BV, "");
    }

    public void setMyCircleTopicBV(String tokenStr) {
        putString(TOPIC_BV, tokenStr);
    }

    public String getMyCircleArticleBV() {
        return getString(ARTICLE_BV, "");
    }

    public void setMyCircleArticleBV(String tokenStr) {
        putString(ARTICLE_BV, tokenStr);
    }

    public String getMyCircleArticleReplyBV() {
        return getString(ARTICLEREPLY_BV, "");
    }

    public void setMyCircleArticleReplyBV(String tokenStr) {
        putString(ARTICLEREPLY_BV, tokenStr);
    }

    public String getHomeMaintain() {
        return getString(HOME_MAINTAIN, "");
    }

    public void setHomeMaintain(String homeMaintain) {
        putString(HOME_MAINTAIN, homeMaintain);
    }

    public void setRegisterPwd(String Registerpwd) {
        putString(REGISTER_PWD, Registerpwd);
    }
    public String getRegisterPwd() {
        return getString(REGISTER_PWD, "");
    }

    public void setRegisterPhonenum(String RegisterPhonenum) {
        putString(REGISTER_PHONE, RegisterPhonenum);
    }
    public String getRegisterPhonenum() {
        return getString(REGISTER_PHONE, "");
    }

    public void setRegisterCode(String RegisterCode) {
        putString(REGISTER_CODE, RegisterCode);
    }
    public String getRegisterCode() {
        return getString(REGISTER_CODE, "");
    }


    public void setShopAppSetPasswordCode(String code) {
        putString(SHOP_APPSETPASSWORD_CODE, code);
    }
    public String getShopAppSetPasswordCode() {
        return getString(SHOP_APPSETPASSWORD_CODE, "");
    }

    public void setShopAppSetPasswordPhoneNUm(String PhoneNUm) {
        putString(SHOP_APPSETPASSWORD_NUM, PhoneNUm);
    }
    public String getShopAppSetPasswordPhoneNum() {
        return getString(SHOP_APPSETPASSWORD_NUM, "");
    }


    /**获取店铺文章是否显示 */
    public boolean getDpwz001() {
        return getBoolean(SHOP_DPWZ_001, false);
    }
    /**设置店铺文章是否显示 */
    public void setDpwz001(boolean flag) {
        putBoolean(SHOP_DPWZ_001, flag);
    }

    /**获取本地热文是否显示 */
    public boolean getBdrw001() {
        return getBoolean(SHOP_BDRW_001, false);
    }
    /**设置本地热文是否显示 */
    public void setBdrw001(boolean flag) {
        putBoolean(SHOP_BDRW_001, flag);
    }

    /**获取网络热文是否`显示 */
    public boolean getWlrw001() {
        return getBoolean(SHOP_WLRW_001, false);
    }
    /**设置网络热文是否显示 */
    public void setWlrw001(boolean flag) {
        putBoolean(SHOP_WLRW_001, flag);
    }


    /**获取自定义文章是否`显示 */
    public boolean getZdywz001() {
        return getBoolean(SHOP_ZDYWZ_001, false);
    }
    /**设置自定义文章是否显示 */
    public void setZdywz001(boolean flag) {
        putBoolean(SHOP_ZDYWZ_001, flag);
    }


    /**获取活动是否`显示 */
    public boolean getHd001() {
        return getBoolean(SHOP_HD_001, false);
    }
    /**设置活动是否显示 */
    public void setHd001(boolean flag) {
        putBoolean(SHOP_HD_001, flag);
    }

    /**获取我的网店是否`显示 */
    public boolean getWdwd001() {
        return getBoolean(SHOP_WDWD_001, false);
    }
    /**设置我的网店是否显示 */
    public void setWdwd001(boolean flag) {
        putBoolean(SHOP_WDWD_001, flag);
    }


    /**获取碎柚宝是否`显示 */
    public boolean getSyb001() {
        return getBoolean(SHOP_SYB_001, false);
    }
    /**设置碎柚宝是否显示 */
    public void setSyb001(boolean flag) {
        putBoolean(SHOP_SYB_001, flag);
    }



    /**获取流量冲值是否`显示 */
    public boolean getLlczb001() {
        return getBoolean(SHOP_LLCZ_001, false);
    }
    /**设置流量冲值是否显示 */
    public void setLlcz001(boolean flag) {
        putBoolean(SHOP_LLCZ_001, flag);
    }


    /**获取赚佣金是否`显示 */
    public boolean getZyj001() {
        return getBoolean(SHOP_ZYJ_001, false);
    }
    /**设置赚佣金是否显示 */
    public void setZyj001(boolean flag) {
        putBoolean(SHOP_ZYJ_001, flag);
    }


    /**获取店员榜单是否`显示 */
    public boolean getDybd001() {
        return getBoolean(SHOP_DYBD_001, false);
    }
    /**设置店员榜单是否显示 */
    public void setDybd001(boolean flag) {
        putBoolean(SHOP_DYBD_001, flag);
    }

    /**获取送货清单是否`显示 */
    public boolean getShqd001() {
        return getBoolean(SHOP_SHQD_001, false);
    }
    /**设置送货清单是否显示 */
    public void setShqd001(boolean flag) {
        putBoolean(SHOP_SHQD_001, flag);
    }

    /**获取优惠领取是否`显示 */
    public boolean getYhlq001() {
        return getBoolean(SHOP_YHLQ_001, false);
    }
    /**设置优惠领取是否显示 */
    public void setYhlq001(boolean flag) {
        putBoolean(SHOP_YHLQ_001, flag);
    }

    /**获取优惠统计是否`显示 */
    public boolean getYhtj001() {
        return getBoolean(SHOP_YHTJ_001, false);
    }
    /**设置优惠统计是否显示 */
    public void setYhtj001(boolean flag) {
        putBoolean(SHOP_YHTJ_001, flag);
    }


    /**获取订单管理是否`显示 */
    public boolean getDdgl001() {
        return getBoolean(SHOP_DDGL_001, false);
    }
    /**设置订单管理是否显示 */
    public void setDdgl001(boolean flag) {
        putBoolean(SHOP_DDGL_001, flag);
    }

    /**获取赚钱攻略是否`显示 */
    public boolean getZqgl001() {
        return getBoolean(SHOP_DDGL_001, false);
    }
    /**设置赚钱攻略是否显示 */
    public void setZqgl001(boolean flag) {
        putBoolean(SHOP_DDGL_001, flag);
    }

    /**获取客多多是否显示 */
    public boolean getKdd001() {
        return getBoolean(SHOP_KDD_001, false);
    }
    /**设置客多多是否显示 */
    public void setKdd001(boolean flag) {
        putBoolean(SHOP_KDD_001, flag);
    }




    /**获取套餐类型 */
    public int getPackType() {
        return getInt(SHOP_PACK_TYPE, 1);
    }
    /**设置套餐类型 */
    public void setShopPackType(int flag) {
        putInt(SHOP_PACK_TYPE, flag);
    }


    public  void  CleanShopAppMenu(){
        putBoolean(SHOP_DPWZ_001, false);
        putBoolean(SHOP_BDRW_001, false);
        putBoolean(SHOP_WLRW_001, false);
        putBoolean(SHOP_ZDYWZ_001, false);
        putBoolean(SHOP_HD_001, false);
        putBoolean(SHOP_WDWD_001, false);
        putBoolean(SHOP_SYB_001, false);
        putBoolean(SHOP_LLCZ_001, false);
        putBoolean(SHOP_ZYJ_001, false);
        putBoolean(SHOP_DYBD_001, false);
        putBoolean(SHOP_SHQD_001, false);
        putBoolean(SHOP_YHLQ_001, false);
        putBoolean(SHOP_YHTJ_001, false);
        putBoolean(SHOP_DDGL_001, false);
        putBoolean(SHOP_DDGL_001, false);
    }




    //保存门店信息
    public  void setShopInfo(ShopInfoBase shopInfoBase) {

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
//           cityName;
//           areaName;
//           provinceName;


        putInt(SHOP_INFO_AREAID,shopInfoBase.getAreaId());
        putInt(SHOP_INFO_CITYID,shopInfoBase.getCityId());
        putString(SHOP_INFO_DETAILEDADDRESS,shopInfoBase.getDetailedAddress());
        putString(SHOP_INFO_HEADURL,shopInfoBase.getHeadUrl());
        putString(SHOP_INFO_ICONURL,shopInfoBase.getIconUrl());
        putString(SHOP_INFO_IMAGEURLS,shopInfoBase.getImageUrls());
        putString(SHOP_INFO_LABELNAMES,shopInfoBase.getLabelNames());
        putString(SHOP_INFO_NAME,shopInfoBase.getName());
        putInt(SHOP_INFO_PROVINCEID,shopInfoBase.getProvinceId());
        putString(SHOP_INFO_SERVERPHONE,shopInfoBase.getServerPhone());
        putString(SHOP_INFO_SLOGAN,shopInfoBase.getSlogan());
        putString(SHOP_INFO_VILLAGEID,shopInfoBase.getVillageId());

        putString(SHOP_INFO_CITYNAME,shopInfoBase.getCityName());
        putString(SHOP_INFO_AREANAME,shopInfoBase.getAreaName());
        putString(SHOP_INFO_PROVINCENAME,shopInfoBase.getProvinceName());

        putString(SHOP_INFO_H5URL,shopInfoBase.getH5url());
    }


    public  ShopInfoBase getShopInfo(){
        ShopInfoBase shopInfoBase = new ShopInfoBase();
        shopInfoBase.setAreaId(getInt(SHOP_INFO_AREAID, 0));
        shopInfoBase.setCityId(getInt(SHOP_INFO_CITYID,0));
        shopInfoBase.setDetailedAddress(getString(SHOP_INFO_DETAILEDADDRESS,""));
        shopInfoBase.setHeadUrl(getString(SHOP_INFO_HEADURL,""));
        shopInfoBase.setIconUrl(getString(SHOP_INFO_ICONURL,""));
        shopInfoBase.setImageUrls(getString(SHOP_INFO_IMAGEURLS,""));
        shopInfoBase.setLabelNames(getString(SHOP_INFO_LABELNAMES,""));
        shopInfoBase.setName(getString(SHOP_INFO_NAME,""));
        shopInfoBase.setProvinceId(getInt(SHOP_INFO_PROVINCEID,0));
        shopInfoBase.setServerPhone(getString(SHOP_INFO_SERVERPHONE,""));
        shopInfoBase.setSlogan(getString(SHOP_INFO_SLOGAN,""));
        shopInfoBase.setVillageId(getString(SHOP_INFO_VILLAGEID,""));

        shopInfoBase.setCityName(getString(SHOP_INFO_CITYNAME,""));
        shopInfoBase.setAreaName(getString(SHOP_INFO_AREANAME,""));
        shopInfoBase.setProvinceName(getString(SHOP_INFO_PROVINCENAME,""));
        shopInfoBase.setH5url(getString(SHOP_INFO_H5URL,""));
        return  shopInfoBase;
    }
    //保存微信个人信息
    public  void setWeixinUserInfo(Map<String, String> data) {
        for (String key : data.keySet()) {
            putString(key, data.get(key));
        }
    }
    public void CleanWeixinUserInfo(WeixinUserInfoBean user){

        user.setUnionid("");
        user.setScreen_name("");
        user.setCity("");
        user.setAccessToken("");
        user.setRefreshToken("");
        user.setGender("");
        user.setProvince("");
        user.setOpenid("");
        user.setProfile_image_url("");
        user.setCountry("");
        user.setAccess_token("");
        user.setIconurl("");
        user.setName("");
        user.setUid("");
        user.setExpiration("");
        user.setLanguage("");
        user.setExpires_in("");
    }

    //获取微信个人信息
    public  WeixinUserInfoBean getWeixinUserInfo() {
        WeixinUserInfoBean user = new WeixinUserInfoBean();
        user.setUnionid(getString("unionid", ""));
        user.setScreen_name(getString("screen_name", ""));
        user.setCity(getString("city", ""));
        user.setAccessToken(getString("accessToken", ""));
        user.setRefreshToken(getString("refreshToken", ""));
        user.setGender(getString("gender", ""));
        user.setProvince(getString("province", ""));
        user.setOpenid(getString("openid", ""));
        user.setProfile_image_url(getString("profile_image_url", ""));
        user.setCountry(getString("country", ""));
        user.setAccess_token(getString("access_token", ""));
        user.setIconurl(getString("iconurl", ""));
        user.setName(getString("name", ""));
        user.setUid(getString("uid", ""));
        user.setExpiration(getString("expiration", ""));
        user.setLanguage(getString("language", ""));
        user.setExpires_in(getString("expires_in", ""));
        return user;
    }



    /**
     * 接收消息通知
     *
     * @return
     */
    public boolean getNotifyAll() {
        return getBoolean(NOTIFY_ALL, true);
    }

    public void setNotifyAll(boolean flag) {
        putBoolean(NOTIFY_ALL, flag);
    }


    /**
     * 退出后仍接收消息通知
     *
     * @return
     */
    public boolean getNotifyLogout() {
        return getBoolean(NOTIFY_LOGOUT, true);
    }

    public void setNotifyLogout(boolean flag) {
        putBoolean(NOTIFY_LOGOUT, flag);
    }

    /**
     * 夜间防骚扰模式
     *
     * @return
     */
    public boolean getNotifySleep() {
        return getBoolean(NOTIFY_SLEEP, true);
    }

    public void setNotifySleep(boolean flag) {
        putBoolean(NOTIFY_SLEEP, flag);
    }

    /**
     * 接收订单消息提醒
     *
     * @return
     */
    public boolean getNotifyOrder() {
        return getBoolean(NOTIFY_ORDER, true);
    }

    public void setNotifyOrder(boolean flag) {
        putBoolean(NOTIFY_ORDER, flag);
    }

    /**
     * 接收资金消息提醒
     *
     * @return
     */
    public boolean getNotifyMoney() {
        return getBoolean(NOTIFY_MONEY, true);
    }

    public void setNotifyMoney(boolean flag) {
        putBoolean(NOTIFY_MONEY, flag);
    }

    /**
     * 接收系统消息提醒
     *
     * @return
     */
    public boolean getNotifySystem() {
        return getBoolean(NOTIFY_SYSTEM, true);
    }

    public void setNotifySystem(boolean flag) {
        putBoolean(NOTIFY_SYSTEM, flag);
    }

    /**
     * 接收店铺反馈消息提醒
     *
     * @return
     */
    public boolean getNotifyFeedback() {
        return getBoolean(NOTIFY_FEEDBACK, true);
    }

    public void setNotifyFeedback(boolean flag) {
        putBoolean(NOTIFY_FEEDBACK, flag);
    }


    /**
     * 商户端联系人列表更新日期
     * */
    public long getContactUpdateTime() {
        return getLong(CONTACT_UPDATE, 0);
    }

    public void setContactUpdateTime(long flag) {
        putLong(CONTACT_UPDATE, flag);
    }


    public boolean getIsFirstOpen() {
        boolean isInit = getBoolean("isInit", true);
        putBoolean("isInit", false);
        return isInit;
    }
//第一次打开粉丝页面（首页）
    public boolean getIsFirstOpenFans() {
        boolean isFirstOpenFans = getBoolean("isFirstOpenFans", true);
        putBoolean("isFirstOpenFans", false);
        return isFirstOpenFans;
    }

    public void setIsFirstOpenFans(){
        putBoolean("isFirstOpenFans", false);
    }


//第一次打开粉丝详情页面
    public boolean getIsFirstOpenFansDetail() {
        boolean isFirstOpenFans = getBoolean("isFirstOpenFansdetail", true);
        putBoolean("isFirstOpenFansdetail", false);
        return isFirstOpenFans;
    }

    //第一次打开会员详情页面
    public boolean getIsFirstOpenMenbersDetail() {
        boolean isFirstOpenFans = getBoolean("isFirstOpenMembersdetail", true);
        putBoolean("isFirstOpenMembersdetail", false);
        return isFirstOpenFans;
    }

    public boolean getIsFirstOpenApp() {
        boolean isFirstOpenApp = getBoolean("isFirstOpenApp", true);
        return isFirstOpenApp;
    }

    public void setShopAppHasOpen(){
        putBoolean("isFirstOpenApp",false);
    }
}
