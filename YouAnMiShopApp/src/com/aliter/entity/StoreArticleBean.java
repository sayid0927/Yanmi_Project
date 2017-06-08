package com.aliter.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sayid on 2017/5/29.
 */

public class StoreArticleBean  implements Serializable {


        /**
         * articleId : 258002
         * createTime : 1491898686359
         * headUrl :
         * labels : [{"id":1219,"articleId":258002,"name":"a"},{"id":1220,"articleId":258002,"name":"b"}]
         * scanCount : 47
         * title : test3
         * url : https://share.youanmi.com/style/articleDetail/articledetail.html?shopId=1&userId=1&isShare=0&id=258002&articleFrom=2&h5Host=aHR0cHM6Ly9zaGFyZS55b3Vhbm1pLmNvbS8=
         * userAppName : 明阳测试店
         * description :
         * shareUrl : http://pxqd.youanmi.com/share/shop-app-article-detail/index.html?shopId=1&userId=1&isShare=0&id=258002&articleFrom=2&u=aHR0cHM6Ly9zaGFyZS55b3Vhbm1pLmNvbS8&shareImage=aHR0cDovL2NkbmltZzMueW91YW5taS5jb20veWFtL00wMC8wMC9GNC9lRXhMS2xmSGkzQ0FBeHRCQUFBYmhtNFZIa0EzOTcucG5n&title=test3&desc=&userAppName=明阳测试店
         * isProductArticle : 1
         * hasNewLabel : 1
         */

        private int articleId;
        private long createTime;
        private String headUrl;
        private int scanCount;
        private String title;
        private String url;
        private String userAppName;
        private String description;
        private String shareUrl;
        private int isProductArticle;
        private int hasNewLabel;
        private List<LabelsBean> labels;

        public int getArticleId() {
            return articleId;
        }

        public void setArticleId(int articleId) {
            this.articleId = articleId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public int getScanCount() {
            return scanCount;
        }

        public void setScanCount(int scanCount) {
            this.scanCount = scanCount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUserAppName() {
            return userAppName;
        }

        public void setUserAppName(String userAppName) {
            this.userAppName = userAppName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public int getIsProductArticle() {
            return isProductArticle;
        }

        public void setIsProductArticle(int isProductArticle) {
            this.isProductArticle = isProductArticle;
        }

        public int getHasNewLabel() {
            return hasNewLabel;
        }

        public void setHasNewLabel(int hasNewLabel) {
            this.hasNewLabel = hasNewLabel;
        }

        public List<LabelsBean> getLabels() {
            return labels;
        }

        public void setLabels(List<LabelsBean> labels) {
            this.labels = labels;
        }

        public static class LabelsBean {
            /**
             * id : 1219
             * articleId : 258002
             * name : a
             */

            private int id;
            private int articleId;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getArticleId() {
                return articleId;
            }

            public void setArticleId(int articleId) {
                this.articleId = articleId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

    @Override
    public String toString() {
        return "StoreArticleBean{" +
                "articleId=" + articleId +
                ", createTime=" + createTime +
                ", headUrl='" + headUrl + '\'' +
                ", scanCount=" + scanCount +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", userAppName='" + userAppName + '\'' +
                ", description='" + description + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", isProductArticle=" + isProductArticle +
                ", hasNewLabel=" + hasNewLabel +
                ", labels=" + labels +
                '}';
    }
}
