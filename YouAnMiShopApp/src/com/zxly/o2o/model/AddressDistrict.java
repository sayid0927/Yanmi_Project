package com.zxly.o2o.model;

import java.io.Serializable;

public class AddressDistrict implements Serializable {
    /**
     *  districtId":1,"districtName":"南汇区"
     * */


    private static final long serialVersionUID = 1L;
    private String districtId;
    private String districtName;

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public String toString() {
        return "AddressDistrict{" +
                "districtId='" + districtId + '\'' +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
