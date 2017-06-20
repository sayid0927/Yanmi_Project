package com.aliter.entity;

/**
 * Created by Administrator on 2017/5/20.
 */

public class ShopAppMenuBean {


    /**
     * code : 00000
     * data : [
     * {"id":4,"menuName":"店铺文章","parentId":1,"type":2,"orders":1,"code":"dpwz001"},
     * {"id":5,"menuName":"本地热文","parentId":1,"type":2,"orders":2,"code":"bdrw001"},
     * {"id":6,"menuName":"网络热文","parentId":1,"type":2,"orders":3,"code":"wlrw001"},
     * {"id":7,"menuName":"自定义文章","parentId":1,"type":2,"orders":4,"code":"zdywz001"},
     * {"id":8,"menuName":"活动","parentId":1,"type":2,"orders":5,"code":"hd001"},
     * {"id":9,"menuName":"我的网店","parentId":2,"type":2,"orders":1,"code":"wdwd001"},
     * {"id":10,"menuName":"碎柚保","parentId":2,"type":2,"orders":2,"code":"syb001"},
     * {"id":11,"menuName":"流量充值","parentId":2,"type":2,"orders":3,"code":"llcz001"},
     * {"id":12,"menuName":"赚佣金","parentId":2,"type":2,"orders":4,"code":"zyj001"},
     * {"id":13,"menuName":"店员榜单","parentId":2,"type":2,"orders":5,"code":"dybd001"},
     * {"id":14,"menuName":"送货清单","parentId":2,"type":2,"orders":6,"code":"shqd001"},
     * {"id":15,"menuName":"优惠领取","parentId":2,"type":2,"orders":7,"code":"yhlq001"},
     * {"id":16,"menuName":"优惠统计","parentId":2,"type":2,"orders":8,"code":"yhtj001"},
     * {"id":17,"menuName":"订单管理","parentId":2,"type":2,"orders":9,"code":"ddgl001"},
     * {"id":19,"menuName":"赚钱攻略","parentId":3,"type":2,"orders":1,"code":"zqgl001"},
     * {"id":1,"menuName":"店店推首页Tab","parentId":0,"type":1,"orders":1,"createTime":1497852529000,"isDelete":0,"level":1,"code":"ddtsy001"},
     * {"id":2,"menuName":"我的门店","parentId":0,"type":1,"orders":2,"createTime":1497852529000,"isDelete":0,"level":1,"code":"wdmd001"},
     * {"id":3,"menuName":"我","parentId":0,"type":1,"orders":3,"createTime":1497852529000,"isDelete":0,"level":1,"code":"w001"}
     * ]
     * currentTimes : 1497951906567
     */

        /**
         * id : 4
         * menuName : 店铺文章
         * parentId : 1
         * type : 2
         * orders : 1
         * code : dpwz001
         * createTime : 1497852529000
         * isDelete : 0
         * level : 1
         */

        private int id;
        private String menuName;
        private int parentId;
        private int type;
        private int orders;
        private String code;
        private long createTime;
        private int isDelete;
        private int level;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getOrders() {
            return orders;
        }

        public void setOrders(int orders) {
            this.orders = orders;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", menuName='" + menuName + '\'' +
                    ", parentId=" + parentId +
                    ", type=" + type +
                    ", orders=" + orders +
                    ", code='" + code + '\'' +
                    ", createTime=" + createTime +
                    ", isDelete=" + isDelete +
                    ", level=" + level +
                    '}';
        }
}
