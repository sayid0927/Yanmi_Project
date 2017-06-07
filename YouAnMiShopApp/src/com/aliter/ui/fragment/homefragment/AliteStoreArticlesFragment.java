package com.aliter.ui.fragment.homefragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aliter.adapter.Test;
import com.aliter.base.BaseFragment;
import com.aliter.entity.StoreArticleBean;
import com.aliter.http.BaseResponse;
import com.aliter.injector.component.StoreAriclesHttpModule;
import com.aliter.injector.component.fragment.DaggerStoreArticlesComponent;
import com.aliter.presenter.StorArticlesPresenter;
import com.aliter.presenter.impl.StorArticlesPresenterImpl;
import com.aliter.ui.fragment.StoreArticlesFragmentAlite;
import com.orhanobut.logger.Logger;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AliteStoreArticlesFragment extends BaseFragment<StorArticlesPresenterImpl> implements StorArticlesPresenter.View {


    private Test mAdapter;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private String TAG = StoreArticlesFragmentAlite.class.getName();
    private List<StoreArticleBean> data;

    @Override
    public void onSuccessView(BaseResponse<StoreArticleBean> mData) {
        Logger.t(TAG).d(mData);
    }

    @Override
    public void onFailView(String errorMsg) {

    }

    @Override
    protected void loadData() {

//        if(!StringUtil.isNull(articleCode))
//        {
//            addParams("codeId",articleCode);
//        }
//        addParams("pageIndex",pageIndex);
//        addParams("type",type);
//        addParams("shopId", Account.user.getShopId());
//        addParams("userId",Account.user.getId());








        data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            StoreArticleBean storeArticleBean = new StoreArticleBean();
            storeArticleBean.setDescription("fdsfsfsa");
            storeArticleBean.setTitle("dfsfsdfsf");
            data.add(storeArticleBean);
        }
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
        return R.layout.alite_fragment_strore_articles;
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setEnabled(false);
        mAdapter = new Test(data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }


    @Override
    protected void initInject() {
        DaggerStoreArticlesComponent.builder().storeAriclesHttpModule(new StoreAriclesHttpModule())
                .build().injectData(this);
    }
}
