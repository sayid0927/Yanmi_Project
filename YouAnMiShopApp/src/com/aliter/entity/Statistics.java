package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class Statistics {

//    days	获取多少天之内	number	获取指定天数之内的数据，参数样式(获取今天传0,获取昨天传-1,获取近7天穿传-7,获取近30天传-30)

    private int days;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }


    @Override
    public String toString() {
        return "Statistics{" +
                "days=" + days +
                '}';
    }
}


