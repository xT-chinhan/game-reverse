package com.smartdigimkt.k2;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends b {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean[] b;
    public final /* synthetic */ w c;

    public v(w wVar, boolean z, boolean[] zArr) {
        this.c = wVar;
        this.a = z;
        this.b = zArr;
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView) {
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.d0.r((WTWebView) com.smartdigimkt.d0.s.b.remove(this.c.f)));
        this.c.d.release();
        com.smartdigimkt.h0.g gVar = new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.b, "onRenderProcessGone");
        String str = this.c.c;
        gVar.a();
        new Throwable();
        boolean[] zArr = this.b;
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        x xVar = this.c.g;
        if (xVar != null) {
            xVar.a(gVar);
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final void b(WebView webView) {
        w wVar = this.c;
        if (wVar.e == 1 && !this.a) {
            com.smartdigimkt.d0.s.b.put(wVar.f, wVar.d);
        }
        w wVar2 = this.c;
        String str = wVar2.c;
        boolean[] zArr = this.b;
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        x xVar = wVar2.g;
        if (xVar != null) {
            xVar.a();
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView, int i, String str, String str2) {
        com.smartdigimkt.h0.g gVar;
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.d0.r((WTWebView) com.smartdigimkt.d0.s.b.remove(this.c.f)));
        this.c.d.release();
        if (i == -999) {
            gVar = new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.u, i + "_" + str);
        } else {
            gVar = new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.b, i + "_" + str);
        }
        String str3 = this.c.c;
        gVar.a();
        new Throwable();
        boolean[] zArr = this.b;
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        x xVar = this.c.g;
        if (xVar != null) {
            xVar.a(gVar);
        }
    }

    @Override // com.smartdigimkt.k2.c
    public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.d0.r((WTWebView) com.smartdigimkt.d0.s.b.remove(this.c.f)));
        this.c.d.release();
        com.smartdigimkt.h0.g gVar = new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.b, sslError != null ? sslError.toString() : "onReceivedSslError");
        String str = this.c.c;
        gVar.a();
        new Throwable();
        boolean[] zArr = this.b;
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        x xVar = this.c.g;
        if (xVar != null) {
            xVar.a(gVar);
        }
    }
}
