package com.aliter.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20.
 */

public class H5ShopBase {


//    allPage	总页数	number
//    allRecord	总记录数	number
//    pageIndex	查询页数	number
//    pageSize	每页记录查询数	number
//    products	推荐商品列表	array<object>	JsonArray对象

        /**
         * pageIndex : 1
         * pageSize : 10
         * allRecord : 17
         * products : [{"id":4,"productName":"爆炸机111","maxPrice":123,"brandId":5,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0h2AZTzoAAE8NC0Mmfs741.png","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0h2AZTzoAAE8NC0Mmfs741.png,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0nOAB9sAAAE8NC0Mmfs319.png,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0oCAMVC5AAAEgMSKiws421.png,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0oaAMae8AAAb2zt-5Yw948.png,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0o6AREieAAATnKgQmt8025.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0o6AKWSTAADBqhV6ekk235.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0pWAW7mLAAATnKgQmt8232.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0pWAUmLWAADBqhV6ekk834.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0puADCbQAAATnKgQmt8325.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0puAKUp7AADBqhV6ekk033.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0qCAGRVyAAATnKgQmt8947.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0qGAPzLyAADBqhV6ekk395.jpg","colors":"没货,777","memorys":"没货,3","orders":18,"createTime":1497959853417,"updateTime":1498469950948,"brandName":"三星","isShelves":2},{"id":16,"productName":"火腿肠火腿肠","maxPrice":2,"brandId":10,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2X-ALfYZAAALYj2RzBg171.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2X-ALfYZAAALYj2RzBg171.jpg","colors":"火腿肠1,火腿肠2,火腿肠3","memorys":"火腿肠a,火腿肠b,火腿肠c,火腿肠d","orders":17,"createTime":1498012017319,"updateTime":1498297544733,"brandName":"HTC","isShelves":2},{"id":15,"productName":"这是什么","minPrice":555,"maxPrice":556,"brandId":21,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2USAPLvtAAAr1LR3OwU026.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2USAPLvtAAAr1LR3OwU026.jpg","colors":"123,665,989,","memorys":"9a996s,653,32","orders":16,"createTime":1498011962881,"updateTime":1498031230153,"brandName":"LG","isShelves":2},{"id":17,"productName":"煎饼果子来一套","minPrice":5,"maxPrice":10,"brandId":22,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2dWASGV9AAAMmJbMkWY535.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2dWASGV9AAAMmJbMkWY535.jpg,http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2dWAbE3JAAAvCw3WrKk583.jpg,http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2dyAadSPAAAN8qYz8hI107.jpg","colors":"白色,黑色","memorys":"1mk,2mk,3mk","orders":15,"createTime":1498012113767,"updateTime":1498031230153,"brandName":"摩托罗拉","isShelves":2},{"id":14,"productName":"老人机,只要一块钱","minPrice":1,"maxPrice":100,"brandId":14,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2QGALat0AAATnKgQmt8360.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AE/wKgBC1lJ2QGALat0AAATnKgQmt8360.jpg","colors":"老人机,只要一块钱","memorys":"老人机,只要一百块钱","orders":14,"createTime":1498011890986,"updateTime":1498031230153,"brandName":"诺基亚","isShelves":2},{"id":13,"productName":"我是电脑!","minPrice":799,"maxPrice":899,"brandId":9,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ2M-AEF4AAAAvCw3WrKk962.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ2M-AEF4AAAAvCw3WrKk962.jpg","colors":"我是电脑,我是电脑,我是电脑","memorys":"我是充电器1,我是充电器2","orders":13,"createTime":1498011846097,"updateTime":1498031230153,"brandName":"苹果","isShelves":2},{"id":1,"productName":"aaa1","minPrice":1.22,"maxPrice":1.23,"brandId":4,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lI8iaAVdPjAAATnKgQmt8178.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lI8iaAVdPjAAATnKgQmt8178.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lI8iaADBkgAADBqhV6ekk893.jpg","colors":"hei,hong,lv","memorys":"1k,2k,3b","orders":12,"createTime":1497956479129,"updateTime":1498031230153,"brandName":"华为","isShelves":2},{"id":11,"productName":"唱歌会跑掉的手机!","minPrice":123,"brandId":11,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ2EmAAi43AAAr1LR3OwU134.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ2EmAAi43AAAr1LR3OwU134.jpg","colors":"没货了,没货了","memorys":"没货了,没货了没货了没货了,","orders":11,"createTime":1498011709964,"updateTime":1498031230153,"brandName":"vivo","isShelves":2},{"id":10,"productName":"好便宜","minPrice":798,"maxPrice":799,"brandId":6,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ2CCAACg_AACuqypI2Kw765.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ2CCAACg_AACuqypI2Kw765.jpg","colors":"好便宜,好便宜,好便宜","memorys":"好便宜,好便宜,好便宜","orders":10,"createTime":1498011668758,"updateTime":1498031230153,"brandName":"努比亚","isShelves":2},{"id":9,"productName":"有点贵哦!","minPrice":100101,"maxPrice":100102,"brandId":12,"headUrl":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ19uAHg5fAAATnKgQmt8408.jpg","imgUrls":"http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ19uAHg5fAAATnKgQmt8408.jpg","colors":"黑色,大号,小号","memorys":"123MK,MKD3","orders":9,"createTime":1498011601598,"updateTime":1498031217900,"brandName":"小米","isShelves":2}]
         * allPage : 2
         */

        private int pageIndex;
        private int pageSize;
        private int allRecord;
        private int allPage;
        private List<ProductsBean> products;

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getAllRecord() {
            return allRecord;
        }

        public void setAllRecord(int allRecord) {
            this.allRecord = allRecord;
        }

        public int getAllPage() {
            return allPage;
        }

        public void setAllPage(int allPage) {
            this.allPage = allPage;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * id : 4
             * productName : 爆炸机111
             * maxPrice : 123.0
             * brandId : 5
             * headUrl : http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0h2AZTzoAAE8NC0Mmfs741.png
             * imgUrls : http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0h2AZTzoAAE8NC0Mmfs741.png,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0nOAB9sAAAE8NC0Mmfs319.png,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0oCAMVC5AAAEgMSKiws421.png,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0oaAMae8AAAb2zt-5Yw948.png,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0o6AREieAAATnKgQmt8025.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0o6AKWSTAADBqhV6ekk235.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0pWAW7mLAAATnKgQmt8232.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0pWAUmLWAADBqhV6ekk834.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0puADCbQAAATnKgQmt8325.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0puAKUp7AADBqhV6ekk033.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0qCAGRVyAAATnKgQmt8947.jpg,http://ptest.youanmi.com/group1/M00/54/AD/wKgBC1lJ0qGAPzLyAADBqhV6ekk395.jpg
             * colors : 没货,777
             * memorys : 没货,3
             * orders : 18
             * createTime : 1497959853417
             * updateTime : 1498469950948
             * brandName : 三星
             * isShelves : 2
             * minPrice : 555.0
             */

            private int id;
            private String productName;
            private double maxPrice;
            private int brandId;
            private String headUrl;
            private String imgUrls;
            private String colors;
            private String memorys;
            private int orders;
            private long createTime;
            private long updateTime;
            private String brandName;
            private int isShelves;
            private double minPrice;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public double getMaxPrice() {
                return maxPrice;
            }

            public void setMaxPrice(double maxPrice) {
                this.maxPrice = maxPrice;
            }

            public int getBrandId() {
                return brandId;
            }

            public void setBrandId(int brandId) {
                this.brandId = brandId;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public String getImgUrls() {
                return imgUrls;
            }

            public void setImgUrls(String imgUrls) {
                this.imgUrls = imgUrls;
            }

            public String getColors() {
                return colors;
            }

            public void setColors(String colors) {
                this.colors = colors;
            }

            public String getMemorys() {
                return memorys;
            }

            public void setMemorys(String memorys) {
                this.memorys = memorys;
            }

            public int getOrders() {
                return orders;
            }

            public void setOrders(int orders) {
                this.orders = orders;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public int getIsShelves() {
                return isShelves;
            }

            public void setIsShelves(int isShelves) {
                this.isShelves = isShelves;
            }

            public double getMinPrice() {
                return minPrice;
            }

            public void setMinPrice(double minPrice) {
                this.minPrice = minPrice;
            }
        }
}
