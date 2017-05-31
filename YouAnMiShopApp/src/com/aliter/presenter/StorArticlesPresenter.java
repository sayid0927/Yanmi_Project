package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.StoreArticle;
import com.aliter.entity.StoreArticleBean;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface StorArticlesPresenter {
    interface View extends BaseView<StoreArticleBean> {
    }
    interface Presenter {
        void fetchData(StoreArticle storeArticle);
    }
}
