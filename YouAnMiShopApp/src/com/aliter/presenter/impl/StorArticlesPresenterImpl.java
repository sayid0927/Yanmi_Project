package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.StoreArticle;
import com.aliter.entity.StoreArticleBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitStoreArticleHttpUtils;
import com.aliter.presenter.StorArticlesPresenter;

import java.util.List;

import javax.inject.Inject;

public class StorArticlesPresenterImpl extends BasePresenter<StorArticlesPresenter.View> implements StorArticlesPresenter.Presenter {
    private RetrofitStoreArticleHttpUtils retrofitStoreArticleHttpUtils;

    @Inject
    public StorArticlesPresenterImpl(RetrofitStoreArticleHttpUtils retrofitStoreArticleHttpUtils) {
        this.retrofitStoreArticleHttpUtils = retrofitStoreArticleHttpUtils;
    }

    @Override
    public void fetchData(StoreArticle storeArticle) {
        invoke(retrofitStoreArticleHttpUtils.fetchData(storeArticle), new Callback<BaseResponse<List<StoreArticleBean>>>() {
            @Override
            public void onSuccess(BaseResponse<List<StoreArticleBean>> data) {
              List<StoreArticleBean> storeArticleBean =data.getData();
//                checkState(storeArticleBean);
                if (storeArticleBean.size()!= 0)
                    mView.onSuccessView(data);
                else {
                    mView.onFailView("data 数据为空");
                   // ((Stateful) mView).setState(AppController.STATE_EMPTY);

                }
            }

            @Override
            public void onFail(String msg) {
                mView.onFailView(msg);
            }
        });
    }

}
