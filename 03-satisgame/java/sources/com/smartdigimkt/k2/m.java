package com.smartdigimkt.k2;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements c {
    public final /* synthetic */ WTWebView a;

    public m(WTWebView wTWebView) {
        this.a = wTWebView;
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView, String str, Bitmap bitmap) {
        WTWebView wTWebView = this.a;
        if (wTWebView.w == 0) {
            wTWebView.w = System.currentTimeMillis();
        }
        c cVar = this.a.j;
        if (cVar != null) {
            cVar.a(webView, str, bitmap);
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final boolean b(WebView webView, String str) {
        c cVar = this.a.j;
        if (cVar != null) {
            return cVar.b(webView, str);
        }
        return false;
    }

    @Override // com.smartdigimkt.k2.c
    public final void b(WebView webView) {
        c cVar = this.a.j;
        if (cVar != null) {
            cVar.b(webView);
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView, int i, String str, String str2) {
        int i2 = WTWebView.B;
        this.a.a("", "onReceivedError:" + i + "," + str);
        c cVar = this.a.j;
        if (cVar != null) {
            cVar.a(webView, i, str, str2);
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WTWebView wTWebView = this.a;
        int i = WTWebView.B;
        wTWebView.a("", "onReceivedSslError");
        c cVar = this.a.j;
        if (cVar != null) {
            cVar.a(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView, String str) {
        c cVar = this.a.j;
        if (cVar != null) {
            cVar.a(webView, str);
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView, int i) {
        c cVar = this.a.j;
        if (cVar != null) {
            cVar.a(webView, i);
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView) {
        WTWebView wTWebView = this.a;
        int i = WTWebView.B;
        wTWebView.a("", "onRenderProcessGone");
        c cVar = this.a.j;
        if (cVar != null) {
            cVar.a(webView);
        }
    }
}
