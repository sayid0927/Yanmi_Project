package com.aliter.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by sayid on 2017/6/24.
 */

public class MySroreAuthority {


    private  String title;
    private Drawable bitmap;
    private  int orderNum;
    private int  kehuIconShow;

    private  int Type;


    public int getKehuIconShow() {
        return kehuIconShow;
    }

    public void setKehuIconShow(int kehuIconShow) {
        this.kehuIconShow = kehuIconShow;
    }

    public int getType() {

        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getBitmap() {
        return bitmap;
    }

    public void setBitmap(Drawable bitmap) {
        this.bitmap = bitmap;
    }
}
