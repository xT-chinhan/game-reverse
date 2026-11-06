package com.anythink.basead.mraid;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.anythink.core.express.web.c {
    protected static final String a = "MraidBaseWebView";

    @Override // com.anythink.core.express.web.c
    public void loadingResourceStatus(WebView webView, int i) {
    }

    @Override // com.anythink.core.express.web.c
    public void onPageFinished(WebView webView, String str) {
    }

    @Override // com.anythink.core.express.web.c
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    @Override // com.anythink.core.express.web.c
    public void onProgressChanged(WebView webView, int i) {
    }

    @Override // com.anythink.core.express.web.c
    public void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    @Override // com.anythink.core.express.web.c
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // com.anythink.core.express.web.c
    public void onRenderProcessGone(WebView webView) {
    }

    @Override // com.anythink.core.express.web.c
    public void readyState(WebView webView, int i) {
    }

    @Override // com.anythink.core.express.web.c
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return true;
    }
}
