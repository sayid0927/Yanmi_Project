package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.Statistics;
import com.aliter.entity.StatisticsBase;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface ShopPromotionPresenter {
    interface View extends BaseView {
        void   onAitrleHomepageStatisticsSuccessView(StatisticsBase statisticsBase);
         void  onFailView(String errorMsg);//获取数据失败调用该方法。

    }

    interface Presenter {
        void AitrleHomepageStatistics(Statistics statistics);
    }
}
