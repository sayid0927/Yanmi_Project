package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class MobileExist {

//    接口名称 查询手机号是否注册1.0-非鉴权
//    请求类型 post
//    请求Url  /shopApp/isMobileExist
//    接口描述 1.0版本 作者:谭国军 2017-6-13
//    请求参数列表

//    mobile	手机号	string

private  String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @Override
    public String toString() {
        return "MobileExist{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
