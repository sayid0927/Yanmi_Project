package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class AuthCode {

     /*
    command	短信模板类型(1-18)	number
    mobilePhone	11位手机号码	string*/

    private int command;
    private  String mobilePhone;

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "AuthCode{" +
                "command=" + command +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
