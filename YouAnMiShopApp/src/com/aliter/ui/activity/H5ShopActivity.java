package com.aliter.ui.activity;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliter.adapter.H5ShopAdapter;
import com.aliter.base.BaseActivity;
import com.zxly.o2o.model.LocalArticle;
import com.zxly.o2o.pullrefresh.PullToRefreshBase;
import com.zxly.o2o.pullrefresh.PullToRefreshListView;
import com.zxly.o2o.request.BaseRequest;
import com.zxly.o2o.request.H5Request;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.CallBack;
import com.zxly.o2o.util.DataUtil;
import com.zxly.o2o.util.ViewUtils;
import com.zxly.o2o.view.CollegeCourseView;
import com.zxly.o2o.view.LoadingView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dsnx on 2016/9/1.
 */
public class H5ShopActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener {
    @BindView(R.id.btn_back)
    TextView btnBack;
    private PullToRefreshListView mListView;
    private LoadingView loadingView;
    private H5ShopAdapter h5ShopAdapter;
    private String articleTypeId;
    private int pageIndex;
    private int pageSize = 10;
    private CollegeCourseView collegeCourseView;
    private CallBack callBack;
    private boolean hasCall;
    private TextView txCtys;
    private LocalArticle localArticle = new LocalArticle();


    private void hideCollegeCourse() {
        if (collegeCourseView != null) {
            collegeCourseView.setVisibility(View.GONE);
        }
    }

    private void showCollegeCourse() {

        if (collegeCourseView == null) {
            RelativeLayout.LayoutParams courseLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            courseLp.bottomMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, getResources().getDisplayMetrics());
            courseLp.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
            courseLp.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
            courseLp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            collegeCourseView = new CollegeCourseView(this, 5);
            collegeCourseView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    YamCollegeDetailAct.start(this, collegeCourseView.getId());
                }
            });
//            content.addView(collegeCourseView, courseLp);
        } else {
            collegeCourseView.show();
        }

    }

    private void loadData(int _pageIndex) {

        if (DataUtil.listIsNull(h5ShopAdapter.getContent())) {
            loadingView.startLoading();
        }
        this.pageIndex = _pageIndex;
        final H5Request articlesRequest = new H5Request(pageIndex, pageSize);
        articlesRequest.setOnResponseStateListener(new BaseRequest.ResponseStateListener() {
            @Override
            public void onOK() {

                loadingView.onLoadingComplete();
                if (!DataUtil.listIsNull(articlesRequest.articles.getProducts())) {
                    if (pageIndex == 1)
                        h5ShopAdapter.clear();
                    h5ShopAdapter.addItem(articlesRequest.articles.getProducts(), true);
                    articlesRequest.articles.getProducts().clear();
                    pageIndex++;
                    hideCollegeCourse();
                } else {
                    //下拉刷新的时候发现数据为空，
                    if (pageIndex == 1) {
                        h5ShopAdapter.clear();
                        h5ShopAdapter.notifyDataSetChanged();
                        loadingView.onDataEmpty("暂无内容", R.drawable.img_default_tired);
                        showCollegeCourse();
                    }
                }
                if (mListView.isRefreshing())
                    mListView.onRefreshComplete();
                if (articlesRequest.hasNext) {
                    mListView.setMode(PullToRefreshBase.Mode.BOTH);
                } else {
                    mListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                }
            }

            @Override
            public void onFail(int code) {
                hideCollegeCourse();
                loadingView.onLoadingFail();
            }
        });
        articlesRequest.start(this);

        loadingView.setOnAgainListener(new LoadingView.OnAgainListener() {
            @Override
            public void onLoading() {
                loadingView.startLoading();
                articlesRequest.start(this);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.al_h5_shop_activity;
    }

    @Override
    public void setToolBar() {

    }

    @Override
    public void initView() {

        loadingView = (LoadingView) findViewById(R.id.view_loading11);
        mListView = (PullToRefreshListView) findViewById(R.id.listview);
        ViewUtils.setRefreshText(mListView);
        h5ShopAdapter = new H5ShopAdapter(this);
        mListView.setDivideHeight(0);
        mListView.setVerticalScrollBarEnabled(false);
        mListView.getRefreshableView().setFastScrollEnabled(false);
        mListView.setIntercept(true);
        mListView.setOnRefreshListener(this);
        final ViewGroup headView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.al_h5_shop_head, null);
        View iv=headView.findViewById(R.id.iv_right);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListView.removedH(headView);
            }
        });
        mListView.addH(headView);
        mListView.setAdapter(h5ShopAdapter);

    }


    @Override
    protected void loadData() {
        if (DataUtil.listIsNull(h5ShopAdapter.getContent())) {
            loadData(1);
        }
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {
        if (refreshView.getCurrentMode() == PullToRefreshBase.Mode.PULL_FROM_START) {
            // 加载下啦数据
            loadData(1);

        }
        if (refreshView.getCurrentMode() == PullToRefreshBase.Mode.PULL_FROM_END) {
            // 加载上拉数据
            loadData(pageIndex);

        }
    }

    public void setParam(CallBack callBack) {
        this.callBack = callBack;
    }


    @OnClick(R.id.btn_back)
    public void onViewClicked() {

        finish();
        finishActivity();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        callBack = null;
    }
}
