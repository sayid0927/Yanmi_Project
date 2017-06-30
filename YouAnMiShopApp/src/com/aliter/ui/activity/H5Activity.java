package com.aliter.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/29.
 */

public class H5Activity extends BaseActivity {
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.tv_colo)
    TextView tvColo;
    @BindView(R.id.btn_bottom_share)
    Button btnBottomShare;


    private String loadUrl;
    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.al_h5;
    }

    @Override
    public void setToolBar() {

    }

    @Override
    public void initView() {

        title = getIntent().getStringExtra("title");
        loadUrl = getIntent().getStringExtra("loadUrl");
//        loadUrl = "http://192.168.1.135//friendsWebApp/src/dist/index.html?shopId=1";

        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setUseWideViewPort(true);
        //	webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSaveFormData(false); // 支持保存数据
        webView.clearCache(true); // 清除缓存
        webView.clearHistory(); // 清除历史记录
        webView.getSettings().setAppCacheEnabled(true);//是否使用缓存
        webView.getSettings().setDomStorageEnabled(true);//DOM Storage
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        webView.setHorizontalScrollBarEnabled(false);//水平不显示
        webView.setVerticalScrollBarEnabled(false); //垂直不显示

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (url.equals(loadUrl)) {
                    tvColo.setVisibility(View.GONE);
                } else {
                    tvColo.setVisibility(View.VISIBLE);
                }
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webView.loadUrl(loadUrl);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

    }

    public static void start(Activity curAct, String loadUrl, String title) {
        Intent intent = new Intent(curAct, H5Activity.class);
        intent.putExtra("title", title);
        intent.putExtra("loadUrl", loadUrl);
        ViewUtils.startActivity(intent, curAct);
    }


    @OnClick({R.id.btn_back, R.id.btn_bottom_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                    finishActivity();
                }
                break;
            case R.id.btn_bottom_share:

//                H5ShopActivity.start(H5Activity.this);

                 Intent intent = new Intent(this,H5ShopActivity.class);
                 startActivity(intent);


                break;
        }
    }

    @OnClick(R.id.tv_colo)
    public void onViewClicked() {
        finish();
        finishActivity();
    }
}
