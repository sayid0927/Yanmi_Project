package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.Statistics;
import com.aliter.entity.StatisticsBase;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.ShopPromotionHttpUtils;
import com.aliter.presenter.ShopPromotionPresenter;

import javax.inject.Inject;

public class ShopPromotionPresenterImpl extends BasePresenter<ShopPromotionPresenter.View> implements ShopPromotionPresenter.Presenter {
    private ShopPromotionHttpUtils shopPromotionHttpUtils;

    @Inject
    public ShopPromotionPresenterImpl(ShopPromotionHttpUtils shopPromotionHttpUtils) {
        this.shopPromotionHttpUtils = shopPromotionHttpUtils;
    }


    @Override
    public void AitrleHomepageStatistics(Statistics statistics) {
        invoke(shopPromotionHttpUtils.aitrleHomepageStatistics(statistics), new Callback<BaseResponse<StatisticsBase>>() {
            @Override
            public void onSuccess(BaseResponse<StatisticsBase> data) {
                StatisticsBase shopAppMenuBean =data.getData();
                if(shopAppMenuBean!=null){
                    mView.onAitrleHomepageStatisticsSuccessView(shopAppMenuBean);
                }else {
                    mView.onFailView("数据为空");
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }


}
