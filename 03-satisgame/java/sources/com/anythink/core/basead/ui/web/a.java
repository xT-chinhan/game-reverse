package com.anythink.core.basead.ui.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.anythink.core.basead.a.e;
import com.anythink.core.common.h.cf;
import com.anythink.core.common.res.d;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public final class a extends WebViewClient {
    private b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.c(str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && !d.a.equals(str)) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(str);
            }
            b bVar2 = this.a;
            if (bVar2 != null && bVar2.c()) {
                cf cfVarA = e.a(webView.getContext(), str, this.a.d());
                if (cfVarA.m) {
                    b bVar3 = this.a;
                    if (bVar3 != null) {
                        bVar3.a(cfVarA);
                    }
                    return true;
                }
                b bVar4 = this.a;
                if (bVar4 != null) {
                    bVar4.a(cfVarA);
                }
                cf cfVarA2 = e.a(str);
                b bVar5 = this.a;
                if (bVar5 != null) {
                    bVar5.a(cfVarA2);
                }
                if (!TextUtils.equals(cfVarA2.o, str)) {
                    webView.loadUrl(cfVarA2.o);
                    return true;
                }
            }
            if (!p.d(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        b bVar = this.a;
        if (bVar != null) {
            bVar.b(str);
            WebProgressBarView webProgressBarViewA = this.a.a();
            if (webProgressBarViewA != null) {
                webProgressBarViewA.setVisibility(0);
                webProgressBarViewA.setProgress(0);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        b bVar = this.a;
        if (bVar == null) {
            return true;
        }
        bVar.b();
        return true;
    }
}
