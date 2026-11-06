package com.bytedance.sdk.component.ms;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class w extends ms {
    static final /* synthetic */ boolean ch = true;
    protected com.bytedance.sdk.component.zb.ah ny;
    protected String x;

    @Override // com.bytedance.sdk.component.ms.ms
    protected Context getContext(ch chVar) {
        if (chVar.ka != null) {
            return chVar.ka;
        }
        if (chVar.f1255ms != null) {
            View view = chVar.f1255ms.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = chVar.f1255ms.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.ms.ms
    protected String ms() {
        return this.ny.getUrl();
    }

    @Override // com.bytedance.sdk.component.ms.ms
    protected void ms(ch chVar) {
        this.ny = chVar.f1255ms;
        this.x = chVar.ah;
        if (chVar.u) {
            return;
        }
        ah();
    }

    private void ms(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.d.post(runnable);
        }
    }

    protected void ah() {
        if (!ch && this.ny == null) {
            throw new AssertionError();
        }
        com.bytedance.sdk.component.zb.ah ahVar = this.ny;
        if (ahVar != null) {
            ahVar.addJavascriptInterface(this, this.x);
        }
    }

    @Override // com.bytedance.sdk.component.ms.ms
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.component.ms.ms
    protected void xr() {
        super.xr();
        d();
    }

    protected void d() {
        com.bytedance.sdk.component.zb.ah ahVar = this.ny;
        if (ahVar != null) {
            ahVar.removeJavascriptInterface(this.x);
        }
    }

    @Override // com.bytedance.sdk.component.ms.ms
    protected void ms(String str, ao aoVar) {
        if (aoVar != null && !TextUtils.isEmpty(aoVar.x)) {
            String str2 = aoVar.x;
            ms(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.ms(str, aoVar);
    }

    @Override // com.bytedance.sdk.component.ms.ms
    protected void ms(String str) {
        ms(str, "javascript:" + this.x + "._handleMessageFromToutiao(" + str + ")");
    }

    private void ms(String str, final String str2) {
        if (this.c || TextUtils.isEmpty(str2)) {
            return;
        }
        ms(new Runnable() { // from class: com.bytedance.sdk.component.ms.w.1
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.c) {
                    return;
                }
                try {
                    ny.ms("Invoking Jsb using evaluateJavascript: " + str2);
                    w.this.ny.evaluateJavascript(str2, null);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                }
            }
        });
    }
}
