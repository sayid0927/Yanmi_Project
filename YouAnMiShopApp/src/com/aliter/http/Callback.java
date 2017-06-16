package com.aliter.http;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.orhanobut.logger.Logger;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.util.ViewUtils;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;

import rx.Subscriber;


public abstract class Callback<T> extends Subscriber<T> {
    private Stateful target;
    public String errorMsg;
    private String TAG = Callback.class.getName();

    public void setTarget(Stateful target) {
        this.target = target;
    }

    public void detachView() {
        if (target != null) {
            target = null;
        }
    }

    @Override
    public void onCompleted() {
    }


    @Override
    public void onError(Throwable e) {
        if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException)
            errorMsg = "解析错误";
        else if (e instanceof ConnectException)
            errorMsg = "连接失败";
        else if (e instanceof javax.net.ssl.SSLHandshakeException)
            errorMsg = "证书验证失败";
        else if (e instanceof ConnectTimeoutException)
            errorMsg = "连接超时";
        else if (e instanceof java.net.SocketTimeoutException)
            errorMsg = "连接超时";
//        else if (!NetworkUtils.isAvailableByPing())
//            errorMsg = "你连接的网络有问题，请检查网络";
        else
            errorMsg = StatusUtils.getErrorMsg();

        Logger.t(TAG).i("失败返回信息  ==  " + errorMsg);
        onFail(errorMsg);
        ViewUtils.showToast(errorMsg);

    }

    @Override
    public void onNext(T data) {
        Logger.t(TAG).i("成功返回信息  ==  " + data.toString());
        target.setState(AppController.STATE_SUCCESS);
        onSuccess(data);
    }

    public abstract void onSuccess(T data);

    public abstract void onFail(String msg);

}
