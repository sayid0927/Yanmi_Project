package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class MobileExistBean {

//    接口名称 查询手机号是否注册1.0-非鉴权
//    请求类型 post
//    请求Url  /shopApp/isMobileExist
//    接口描述 1.0版本 作者:谭国军 2017-6-13
//    请求参数列表


//    isExist	是否注册,true:已注册,false:未注册	boolean


    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    private  boolean isExist;


}
