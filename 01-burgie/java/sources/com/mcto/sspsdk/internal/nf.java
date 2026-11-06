package com.mcto.sspsdk.internal;

import android.R;
import android.content.Context;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class nf extends WebViewClient {
    public final Context c;
    public boolean a = false;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public boolean d = false;

    public nf(Context context) {
        this.c = context;
    }

    public final void a(SslErrorHandler sslErrorHandler, SslError sslError, boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c, R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
            builder.setTitle("安全警告");
            builder.setMessage("该网站的安全证书存在问题，原网页内容可能已被非法篡改，" + (z ? "请勿打开！必要时请联系您的网络服务运营商，反馈【网页劫持】问题。" : "已为您屏蔽显示。") + "\n\n错误码：" + sslError.getPrimaryError());
            if (z) {
                builder.setPositiveButton("坚持打开", new lf(this, sslErrorHandler));
            }
            builder.setNegativeButton(z ? "取消" : "确定", new mf(sslErrorHandler));
            builder.setCancelable(false);
            builder.create().show();
        } catch (Exception e) {
            r9.a("ssp_sdk", "ssl dialog error.", e);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webResourceRequest.isForMainFrame()) {
            fc.a(this.c, "页面加载出错");
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        int statusCode = webResourceResponse.getStatusCode();
        if (!webResourceRequest.isForMainFrame() || 400 > statusCode) {
            return;
        }
        fc.a(this.c, "页面加载出错:(" + statusCode + ")");
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!this.d) {
            sslErrorHandler.cancel();
            if (this.b.compareAndSet(false, true)) {
                a(sslErrorHandler, sslError, false);
                return;
            }
            return;
        }
        if (this.a) {
            sslErrorHandler.proceed();
        } else if (this.b.compareAndSet(false, true)) {
            a(sslErrorHandler, sslError, true);
        } else {
            sslErrorHandler.cancel();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("http")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String scheme = webResourceRequest.getUrl().getScheme();
        if (scheme == null || !scheme.startsWith("http")) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
