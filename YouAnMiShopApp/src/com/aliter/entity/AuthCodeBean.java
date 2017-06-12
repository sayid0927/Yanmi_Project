package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class AuthCodeBean {

//    状态,1:手机号不存在,需要注册,2:手机号已经存在,绑定操作

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AuthCodeBean{" +
                "status=" + status +
                '}';
    }
}
