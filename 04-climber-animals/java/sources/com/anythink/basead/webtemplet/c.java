package com.anythink.basead.webtemplet;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    void a();

    void a(WebView webView);

    void a(WebView webView, int i, String str, String str2);

    void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void a(WebView webView, String str, Bitmap bitmap);

    boolean a(WebView webView, String str);

    void b();

    void b(WebView webView);

    void c();

    void d();
}
