package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.StoreArticle;
import com.aliter.entity.StoreArticleBean;

import java.util.List;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface StorArticlesPresenter {
    interface View extends BaseView<List<StoreArticleBean>> {
        void  onGetDataSuccessView(List<StoreArticleBean> list);
        void  onFailView(String errorMsg);//获取数据失败调用该方法。
    }
    interface Presenter {
        void fetchData(StoreArticle storeArticle);
    }
}
