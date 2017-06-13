package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class AuthCode {

     /*
   mobile	11位手机号码	string
   type	短信模板类型	number	7:找回密码,18:手机验证码登录,19:绑定第三方平台,20:商户app注册
   userName	账号	string	type=7时,需要此参数

    */

    private String userName;
    private  String mobile;
    private int type;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AuthCode{" +
                "userName=" + userName +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                '}';
    }
}
