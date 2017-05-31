package com.aliter.http;



public class BaseResponse<T> {

    private String code;
    private T data;
    private long currentTimes;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getCurrentTimes() {
        return currentTimes;
    }

    public void setCurrentTimes(long currentTimes) {
        this.currentTimes = currentTimes;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", currentTimes='" + currentTimes + '\'' +
                '}';
    }
}
