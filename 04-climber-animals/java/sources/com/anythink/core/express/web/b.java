package com.anythink.core.express.web;

import android.net.http.SslError;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b extends WebViewClient {
    private static final String a = "BaseWebViewClient";
    private a b;
    private c c;

    private static boolean a(String str, String str2) {
        try {
            return new File(str).getCanonicalFile().getPath().startsWith(new File(str2).getCanonicalFile().getPath());
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    public final a a() {
        return this.b;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar = this.b;
        if (aVar != null && aVar.a(str)) {
            return true;
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.shouldOverrideUrlLoading(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        c cVar = this.c;
        if (cVar != null) {
            cVar.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        c cVar = this.c;
        if (cVar != null) {
            cVar.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        c cVar = this.c;
        if (cVar != null) {
            cVar.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                if (webView instanceof BaseWebView) {
                    ((BaseWebView) webView).release();
                } else {
                    webView.destroy();
                }
            } catch (Throwable th) {
                th.getMessage();
                return true;
            }
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.onRenderProcessGone(webView);
        }
        return true;
    }

    public final void a(c cVar) {
        this.c = cVar;
    }
}
