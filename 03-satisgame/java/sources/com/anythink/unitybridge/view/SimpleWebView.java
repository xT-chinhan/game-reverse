package com.anythink.unitybridge.view;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.anythink.core.common.res.d;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SimpleWebView extends WebView {
    public SimpleWebView(Context context) {
        super(context);
        restrictDeviceContentAccess();
        configSafeWebView(this);
        initializeWebView(this, context);
        setWebViewClient(new WebViewClient() { // from class: com.anythink.unitybridge.view.SimpleWebView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (TextUtils.isEmpty(str) || d.a.equals(str)) {
                    return false;
                }
                webView.loadUrl(str);
                return true;
            }
        });
        setWebChromeClient(new WebChromeClient());
    }

    private void restrictDeviceContentAccess() {
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
    }

    public static void configSafeWebView(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxjavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.getSettings().setSavePassword(false);
    }

    public static void initializeWebView(WebView webView, Context context) {
        WebSettings settings = webView.getSettings();
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.requestFocus();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setMediaPlaybackRequiresUserGesture(false);
        try {
            settings.setMixedContentMode(1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, false);
        } catch (Exception unused) {
        }
        settings.setDatabaseEnabled(false);
        settings.setGeolocationEnabled(false);
    }
}
