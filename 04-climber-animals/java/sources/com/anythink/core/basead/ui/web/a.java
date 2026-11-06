package com.anythink.core.basead.ui.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.anythink.core.basead.a.e;
import com.anythink.core.common.h.cc;
import com.anythink.core.common.res.d;
import com.anythink.core.common.v.q;

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
            bVar.onWebPageLoadError(webView, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && !d.a.equals(str)) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.recordRedirectUrl(str);
            }
            b bVar2 = this.a;
            if (bVar2 != null && bVar2.supportDeeplinkJump()) {
                cc ccVarA = e.a(webView.getContext(), str, this.a.getBaseAdContent());
                if (ccVarA.m) {
                    b bVar3 = this.a;
                    if (bVar3 != null) {
                        bVar3.callbackClickResult(ccVarA);
                    }
                    return true;
                }
                b bVar4 = this.a;
                if (bVar4 != null) {
                    bVar4.callbackClickResult(ccVarA);
                }
                cc ccVarA2 = e.a(str);
                b bVar5 = this.a;
                if (bVar5 != null) {
                    bVar5.callbackClickResult(ccVarA2);
                }
                if (!TextUtils.equals(ccVarA2.o, str)) {
                    webView.loadUrl(ccVarA2.o);
                    return true;
                }
            }
            if (!q.d(str)) {
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
            bVar.onWebPageStart(webView, str);
            WebProgressBarView webProgressBarView = this.a.getWebProgressBarView();
            if (webProgressBarView != null) {
                webProgressBarView.setVisibility(0);
                webProgressBarView.setProgress(0);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        b bVar = this.a;
        if (bVar != null) {
            bVar.onWebPageFinish(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        b bVar = this.a;
        if (bVar == null) {
            return true;
        }
        bVar.onWebFinish();
        return true;
    }
}
