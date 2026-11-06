package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends com.bytedance.sdk.openadsdk.core.widget.ms.d {
    private lm ch;
    private boolean hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public ArrayList<Integer> f2954ms;
    private final com.bytedance.sdk.openadsdk.u.x ny;
    private com.bytedance.sdk.component.adexpress.xr.zb sl;

    public ab(Context context, pc pcVar, lm lmVar, com.bytedance.sdk.openadsdk.core.zb.d dVar, boolean z, com.bytedance.sdk.openadsdk.u.x xVar, com.bytedance.sdk.component.adexpress.xr.zb zbVar) {
        super(context, pcVar, lmVar.df(), dVar);
        this.f2954ms = new ArrayList<>();
        this.ch = lmVar;
        this.hi = z;
        this.ny = xVar;
        this.sl = zbVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ah("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public int ms() {
        for (Integer num : this.f2954ms) {
            if (num.intValue() == 3 || num.intValue() == 2 || num.intValue() == -1) {
                return num.intValue();
            }
        }
        return TextUtils.isEmpty(d()) ? -1 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            com.bytedance.sdk.openadsdk.u.x xVar = this.ny;
            if (xVar != null) {
                xVar.x(str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.adexpress.ms.xr.ms msVarMs = com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.ms(webView, this.ch, str, new com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ab.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms
                public boolean ms() {
                    return true;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms
                public com.bytedance.sdk.component.adexpress.ms.xr.ms ms(String str2, com.bytedance.sdk.component.adexpress.d.ch.ms msVar, String str3) {
                    return com.bytedance.sdk.component.adexpress.ms.xr.xr.ms(str2, msVar, str3, ab.this.d());
                }
            });
            ms(jCurrentTimeMillis, System.currentTimeMillis(), str, (msVarMs == null || msVarMs.ms() == null) ? 2 : 1);
            if (msVarMs != null && msVarMs.getType() != 5) {
                this.f2954ms.add(Integer.valueOf(msVarMs.getType()));
            }
            if (msVarMs != null && msVarMs.ms() != null) {
                com.bytedance.sdk.openadsdk.u.x xVar2 = this.ny;
                if (xVar2 != null) {
                    xVar2.ny(str);
                }
                return msVarMs.ms();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ah("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        lm lmVar = this.ch;
        if (lmVar != null && lmVar.si() != null) {
            return this.ch.si().hi();
        }
        lm lmVar2 = this.ch;
        if (lmVar2 == null || lmVar2.pl() == null) {
            return null;
        }
        return "v3";
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.c = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.ab = false;
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.component.adexpress.xr.zb zbVar = this.sl;
        if (zbVar == null || !zbVar.yu()) {
            return;
        }
        com.bytedance.sdk.component.utils.hi.ms(webView, "javascript:window.SDK_INJECT_DATA=" + this.sl.ka());
    }

    private void ms(long j, long j2, String str, int i) {
        if (this.ka == null || this.ka.ah() == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.d.ch.ms msVarMs = com.bytedance.sdk.component.adexpress.d.ch.ms(str);
        if (msVarMs == com.bytedance.sdk.component.adexpress.d.ch.ms.HTML) {
            this.ka.ah().ms(str, j, j2, i);
        } else if (msVarMs == com.bytedance.sdk.component.adexpress.d.ch.ms.JS) {
            this.ka.ah().xr(str, j, j2, i);
        }
    }
}
