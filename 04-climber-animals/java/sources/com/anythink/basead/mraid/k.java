package com.anythink.basead.mraid;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.anythink.core.common.v.z;

/* JADX INFO: loaded from: classes.dex */
public final class k extends com.anythink.core.express.web.b {
    final String a = getClass().getSimpleName();
    String b;
    e c;

    public k(String str) {
        this.b = str;
    }

    private void a(e eVar) {
        this.c = eVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            webView.evaluateJavascript("javascript:" + z.a().b(), new ValueCallback<String>() { // from class: com.anythink.basead.mraid.k.1
                private static void a() {
                }

                @Override // android.webkit.ValueCallback
                public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.anythink.core.express.web.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        e eVar;
        try {
            if (!TextUtils.equals(str, this.b) && (eVar = this.c) != null) {
                eVar.open(str);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
