package com.aliter.entity;

import com.aliter.http.BaseResponse;

import java.io.Serializable;

/**
 * Created by Sayid on 2017/5/19.
 */

public class WeixinUserPhoneBean extends BaseResponse<WeixinUserPhoneBean> implements Serializable {

    private CheckAuthCodeBean  checkAuthCodeBean;
    private AuthCodeBean  authCodeBean;

    public CheckAuthCodeBean getCheckAuthCodeBean() {
        return checkAuthCodeBean;
    }

    public void setCheckAuthCodeBean(CheckAuthCodeBean checkAuthCodeBean) {
        this.checkAuthCodeBean = checkAuthCodeBean;
    }

    public AuthCodeBean getAuthCodeBean() {
        return authCodeBean;
    }

    public void setAuthCodeBean(AuthCodeBean authCodeBean) {
        this.authCodeBean = authCodeBean;
    }

    @Override
    public String toString() {
        return "WeixinUserPhoneBean{" +
                "checkAuthCodeBean=" + checkAuthCodeBean +
                ", authCodeBean=" + authCodeBean +
                '}';
    }
}

