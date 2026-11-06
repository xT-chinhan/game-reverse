package com.mar.sdk.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mar.sdk.SDKTools;
import com.mar.sdk.log.Log;
import com.mar.sdk.utils.ResourceHelper;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARProtocolActivity extends Activity {
    private static int isProtocol = 0;
    private String title;
    private String url;
    private WebView webview;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MARAutoPermission.getInstance().getProtocolOrientation().equals("portrait")) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(6);
        }
        setContentView(ResourceHelper.getIdentifier(this, "R.layout.mar_protocol_webview"));
        Intent intent = getIntent();
        this.url = intent.getStringExtra(BreakpointSQLiteKey.URL);
        this.title = intent.getStringExtra(BundleKey.TITLE);
        TextView title_tv = (TextView) ResourceHelper.getView(this, "R.id.mar_p_title");
        title_tv.setText(this.title);
        LinearLayout back = (LinearLayout) ResourceHelper.getView(this, "R.id.mar_p_back");
        back.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.permission.MARProtocolActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (MARProtocolActivity.this.webview.canGoBack()) {
                    MARProtocolActivity.this.webview.goBack();
                } else {
                    MARProtocolActivity.this.finishPage();
                }
            }
        });
        if (!SDKTools.isNetworkAvailable(this) || this.url == null || "".equals(this.url)) {
            if (isProtocol == 1) {
                this.url = "file:///android_asset/userAgreement.html";
            } else if (isProtocol == 2) {
                this.url = "file:///android_asset/yszc.html";
            }
        }
        Log.d("MARSDK", "mar protocol title:" + this.title + ";url:" + this.url);
        initWebView();
    }

    @SuppressLint({"NewApi"})
    private void initWebView() {
        this.webview = (WebView) ResourceHelper.getView(this, "R.id.mar_p_webprotocol");
        WebSettings webSettings = this.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setCacheMode(2);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheMaxSize(LongCompanionObject.MAX_VALUE);
        webSettings.setMixedContentMode(0);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        this.webview.setWebViewClient(new WebViewClient());
        this.webview.setWebChromeClient(new WebChromeClient());
        this.webview.loadUrl(this.url);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPage() {
        finish();
    }

    public static void showProtocol(Activity context, String protocolUrl) {
        try {
            isProtocol = 2;
            Intent intent = new Intent(context, (Class<?>) MARProtocolActivity.class);
            intent.putExtra(BreakpointSQLiteKey.URL, protocolUrl);
            intent.putExtra(BundleKey.TITLE, ResourceHelper.getString(context, "R.string.mar_permission_title1"));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showProtocol(Activity context) {
        try {
            isProtocol = 2;
            Intent intent = new Intent(context, (Class<?>) MARProtocolActivity.class);
            intent.putExtra(BreakpointSQLiteKey.URL, MARAutoPermission.getInstance().getProtocolUrl());
            intent.putExtra(BundleKey.TITLE, ResourceHelper.getString(context, "R.string.mar_permission_title1"));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showUserAgreement(Activity activity, String userAgreementUrl) {
        try {
            isProtocol = 1;
            Intent intent = new Intent(activity, (Class<?>) MARProtocolActivity.class);
            intent.putExtra(BreakpointSQLiteKey.URL, userAgreementUrl);
            intent.putExtra(BundleKey.TITLE, ResourceHelper.getString(activity, "R.string.mar_permission_title2"));
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showUserAgreement(Activity activity) {
        try {
            isProtocol = 1;
            Intent intent = new Intent(activity, (Class<?>) MARProtocolActivity.class);
            intent.putExtra(BreakpointSQLiteKey.URL, MARAutoPermission.getInstance().getUserAgreementUrl());
            intent.putExtra(BundleKey.TITLE, ResourceHelper.getString(activity, "R.string.mar_permission_title2"));
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showBeiAn(Activity activity, String appBeianUrl) {
        try {
            Intent intent = new Intent(activity, (Class<?>) MARProtocolActivity.class);
            intent.putExtra(BreakpointSQLiteKey.URL, appBeianUrl);
            intent.putExtra(BundleKey.TITLE, "备案查询");
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
