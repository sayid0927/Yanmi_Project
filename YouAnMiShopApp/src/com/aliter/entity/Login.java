package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class Login  {


  /*
    clientId	个推客户端id	string
    code	验证码	string	type为3，必传，店店推项目增加
    password	用户密码	string	type为1，必传
    type	登录类型,1:账号密码登录,2:微信登录,3:验证码登录	number	不传服务器默认为1，店店推项目增加
    userName	用户账号	string	type为1、3，必传
    wxOpenId	微信用户openId	string	type为2，必传，店店推项目增加
    wxUnionId	微信用户统一id	string	type为2，必传，店店推项目增加

    */





    String clientId;
    String userName;
    String password;
    String code;
    String wxOpenId;
    String wxUnionId;
    int type;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Login{" +
                "clientId='" + clientId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", wxUnionId='" + wxUnionId + '\'' +
                ", type=" + type +
                '}';
    }
}
