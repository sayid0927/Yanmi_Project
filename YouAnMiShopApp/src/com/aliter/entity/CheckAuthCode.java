package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class CheckAuthCode {

//    code	验证码	string
//    mobile	获取短信验证码的手机号码	string
//    type	短信模板类型	number	7:找回密码,18:手机验证码登录,19:绑定第三方平台,20:商户app注

    private  String code;
    private  String mobile;
    private  int type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return "CheckAuthCode{" +
                "code='" + code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                '}';
    }
}
