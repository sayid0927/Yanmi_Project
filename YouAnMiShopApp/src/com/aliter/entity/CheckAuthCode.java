package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class CheckAuthCode {

//    code	验证码	string
//    command	短信模板类型，传递的是获取验证码传的是什么类型	number
//    mobilePhone	获取短信验证码的手机号码	string

    private  String code;
    private  String mobilePhone;
    private  int command;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "CheckAuthCode{" +
                "code='" + code + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", command=" + command +
                '}';
    }
}
