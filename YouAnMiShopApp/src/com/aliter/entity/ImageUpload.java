package com.aliter.entity;

/**
 * Created by sayid on 2017/6/27.
 */

public class ImageUpload {


    /**
     * code : 00000
     * data : {"imageUrl":{"originImageUrl":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lR0QmAVlhfAAE5FfarffA392.jpg","thumImageUrl":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lR0QmAZMHHAAAHn2BbMTo140.jpg"}}
     * currentTimes : 1498534153816
     */

    private String code;
    private DataBean data;
    private long currentTimes;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public long getCurrentTimes() {
        return currentTimes;
    }

    public void setCurrentTimes(long currentTimes) {
        this.currentTimes = currentTimes;
    }

    public static class DataBean {
        /**
         * imageUrl : {"originImageUrl":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lR0QmAVlhfAAE5FfarffA392.jpg","thumImageUrl":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lR0QmAZMHHAAAHn2BbMTo140.jpg"}
         */

        private ImageUrlBean imageUrl;

        public ImageUrlBean getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(ImageUrlBean imageUrl) {
            this.imageUrl = imageUrl;
        }

        public static class ImageUrlBean {
            /**
             * originImageUrl : http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lR0QmAVlhfAAE5FfarffA392.jpg
             * thumImageUrl : http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lR0QmAZMHHAAAHn2BbMTo140.jpg
             */

            private String originImageUrl;
            private String thumImageUrl;

            public String getOriginImageUrl() {
                return originImageUrl;
            }

            public void setOriginImageUrl(String originImageUrl) {
                this.originImageUrl = originImageUrl;
            }

            public String getThumImageUrl() {
                return thumImageUrl;
            }

            public void setThumImageUrl(String thumImageUrl) {
                this.thumImageUrl = thumImageUrl;
            }
        }
    }
}
