package com.smartdigimkt.x;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ j a;

    public h(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        String str = this.a.a;
        try {
            webView = new WebView(this.a.g);
        } catch (Throwable unused) {
            webView = null;
        }
        if (webView != null) {
            try {
                webView.destroy();
            } catch (Throwable unused2) {
            }
            this.a.n = Boolean.TRUE;
        } else {
            this.a.n = Boolean.FALSE;
        }
        j jVar = this.a;
        String str2 = jVar.a;
        Boolean bool = jVar.n;
    }
}
