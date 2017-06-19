package com.aliter.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.aliter.http.LifeSubscription;
import com.aliter.http.Stateful;
import com.aliter.injector.component.ActivityComponent;
import com.aliter.injector.component.DaggerActivityComponent;
import com.aliter.injector.component.module.ActivityModule;
import com.aliter.ui.SwipeBackActivity.SwipeBackActivity;
import com.aliter.ui.SwipeBackActivity.SwipeBackLayout;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.dialog.LoadingDialog;
import com.zxly.o2o.shop.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public abstract class BaseActivity<P extends BasePresenter> extends SwipeBackActivity implements LifeSubscription, Stateful {

    @Inject
    protected P mPresenter;

    public static BaseActivity activity;
    private SwipeBackLayout mSwipeBackLayout;

    public abstract int getLayoutId();

    public abstract void setToolBar();

    public abstract void initView();


    protected abstract void loadData();

    protected abstract void initInject();


    private Unbinder bind;
    protected LoadingDialog loadingDialog;
    protected   int State;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        initSwipeBackLayout();
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        initInject();
        if (mPresenter!=null)
        mPresenter.attachView(this);
        initView();
        setToolBar();
        loadData();
        AppController.addAct(this);
    }


    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示toolbar的返回按钮

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onBackPressed();
                finish();
                finishActivity();
            }
        });
    }


    @Override
    public void setState(int state) {
       State =state;
    }

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }


    @Override
    protected void onPause() {
        super.onPause();
        activity = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppController.cancelAll(this);
        AppController.remove(this);
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
        if (mPresenter!=null){
            mPresenter.detachView();
        }
        if (bind != null) {
            bind.unbind();
        }
    }

    /**
     * 回退键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(loadingDialog!=null&&loadingDialog.isShow()){
                loadingDialog.dismiss();
            }
            finish();
            finishActivity();
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void finishActivity() {
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);

    }

    protected  void startActivityIn() {
     overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }
    protected  void  ShowLoadingDialog(){
        if(State!=AppController.STATE_ERROR) {
            if (loadingDialog == null) {
                loadingDialog = new LoadingDialog(this);
                loadingDialog.show();
            } else {
                loadingDialog.show();
            }
        }
    }

    protected  void  DismissLoadingDialog(){
        if(loadingDialog.isShow()){
            loadingDialog.dismiss();
        }
    }


//    public void killAllActivity() {
//        List<Activity> copy;
//        synchronized (mActivities) {
//            copy = new LinkedList<>(mActivities);
//        }
//        for (Activity activity : copy) {
//            activity.finish();
//        }
//        // 杀死当前的进程
//        // android.os.Process.killProcess(android.os.Process.myPid());
//    }

    private CompositeSubscription mCompositeSubscription;


    @Override
    public void bindSubscription(Subscription subscription) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(subscription);
    }

    @SuppressWarnings("deprecation")
    public void initSwipeBackLayout() {
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    public void setEdgeTrackingEnabled(int size, int position) {
        if (size == 0) {
        }

        else if (size == 1 && position == 0) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);
        }

        else if (size != 1 && position == 0) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        }

        else if (size != 1 && position == size - 1) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_RIGHT);
        }

        else {
            mSwipeBackLayout.setEdgeTrackingEnabled(0);
        }
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
