package com.smartdigimkt.j2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.smartdigimkt.b3.v;
import com.smartdigimkt.sdk.basead.ui.web.WebProgressBarView;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends WebViewClient {
    public final b a;
    public int b = 0;
    public boolean c = false;
    public boolean d = false;
    public int e = 0;

    public a(b bVar) {
        this.a = bVar;
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
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.onWebPageLoadError(webView, str2);
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

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        int i;
        try {
            if (!this.c) {
                if (this.d && (i = this.e) > 0) {
                    int i2 = this.b + 1;
                    this.b = i2;
                    if (i2 > i) {
                        this.c = true;
                        b bVar = this.a;
                        if (bVar != null) {
                            com.smartdigimkt.b3.c baseAdContent = bVar.getBaseAdContent();
                            com.smartdigimkt.a3.a baseAdRequestInfo = this.a.getBaseAdRequestInfo();
                            if (baseAdContent != null && baseAdRequestInfo != null) {
                                com.smartdigimkt.n3.k.a(baseAdContent, baseAdRequestInfo, "3", this.a.getOriginalUrl());
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(str) && !com.anythink.core.common.res.d.a.equals(str)) {
                    b bVar2 = this.a;
                    if (bVar2 != null) {
                        bVar2.recordRedirectUrl(str);
                    }
                    b bVar3 = this.a;
                    if (bVar3 != null && bVar3.supportDeeplinkJump()) {
                        v vVarA = com.smartdigimkt.c0.h.a(webView.getContext(), str, this.a.getBaseAdContent());
                        if (vVarA.b) {
                            b bVar4 = this.a;
                            if (bVar4 != null) {
                                bVar4.callbackClickResult(vVarA);
                            }
                            return true;
                        }
                        b bVar5 = this.a;
                        if (bVar5 != null) {
                            bVar5.callbackClickResult(vVarA);
                        }
                        v vVarB = com.smartdigimkt.c0.h.b(str);
                        b bVar6 = this.a;
                        if (bVar6 != null) {
                            bVar6.callbackClickResult(vVarB);
                        }
                        if (!TextUtils.equals(vVarB.d, str)) {
                            webView.loadUrl(vVarB.d);
                            return true;
                        }
                    }
                    char[] cArr = com.smartdigimkt.r4.k.a;
                    if (!com.smartdigimkt.r4.k.h.matcher(str.toLowerCase()).matches()) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }
}
