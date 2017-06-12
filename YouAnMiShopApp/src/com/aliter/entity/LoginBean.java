package com.aliter.entity;

import com.aliter.http.BaseResponse;
import com.easemob.easeui.model.IMUserInfoVO;

import java.io.Serializable;

/**
 * Created by Sayid on 2017/5/19.
 */

public class LoginBean extends BaseResponse<LoginBean> implements Serializable {

    private IMUserInfoVO  imUserInfoVO;
    private AuthCodeBean  authCodeBean;

    public IMUserInfoVO getImUserInfoVO() {
        return imUserInfoVO;
    }

    public void setImUserInfoVO(IMUserInfoVO imUserInfoVO) {
        this.imUserInfoVO = imUserInfoVO;
    }

    public AuthCodeBean getAuthCodeBean() {
        return authCodeBean;
    }

    public void setAuthCodeBean(AuthCodeBean authCodeBean) {
        this.authCodeBean = authCodeBean;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "imUserInfoVO=" + imUserInfoVO +
                ", authCodeBean=" + authCodeBean +
                '}';
    }
}

