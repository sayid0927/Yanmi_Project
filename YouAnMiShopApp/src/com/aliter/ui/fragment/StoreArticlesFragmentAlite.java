package com.aliter.ui.fragment;

import com.aliter.base.BaseFragment;
import com.aliter.entity.StoreArticleBean;
import com.aliter.http.BaseResponse;
import com.aliter.presenter.StorArticlesPresenter;
import com.aliter.presenter.impl.StorArticlesPresenterImpl;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;


public class StoreArticlesFragmentAlite extends BaseFragment<StorArticlesPresenterImpl> implements StorArticlesPresenter.View {

    private String TAG = StoreArticlesFragmentAlite.class.getName();


//    @Inject
    protected BaseQuickAdapter mAdapter;

    @Override
    public void onSuccessView(BaseResponse<StoreArticleBean> mData) {
        Logger.t(TAG).d(mData);
    }

    @Override
    public void onFailView(String errorMsg) {

    }

    @Override
    protected void loadData() {
        setState(AppController.STATE_SUCCESS);
//        StoreArticle storeArticle = new StoreArticle();
//        storeArticle.setShopId(1);
//        storeArticle.setUserId(1);
//        storeArticle.setType(1);
//        storeArticle.setPageIndex(1);
//        mPresenter.fetchData(storeArticle);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.alite_fragment_shop_promotion;
    }

    @Override
    protected void initView() {



    }



    @Override
    protected void initInject() {
//        DaggerStoreArticlesComponent.builder().storeAriclesHttpModule(new StoreAriclesHttpModule()).build().injectData(this);
    }
}
