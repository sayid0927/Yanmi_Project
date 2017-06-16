package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class ShopSetPassword2 {

    // 设置新密码接口
//    @"code": self.verifyCode,
//    @"userName": self.userName,
//    @"paw": [self.passWord secrectMd5]

    private  String code;
    private  String userName;
    private  String paw;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaw() {
        return paw;
    }

    public void setPaw(String paw) {
        this.paw = paw;
    }

    @Override
    public String toString() {
        return "ShopSetPassword2{" +
                "code='" + code + '\'' +
                ", userName='" + userName + '\'' +
                ", paw='" + paw + '\'' +
                '}';
    }
}
