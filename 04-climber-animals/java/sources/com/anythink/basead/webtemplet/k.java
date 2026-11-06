package com.anythink.basead.webtemplet;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.anythink.core.common.v.al;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes.dex */
public class k extends WebViewClient {
    g a;
    private final String b = t.a;
    private c c;
    private String d;

    private void a(WTWebView wTWebView) {
        this.a = new g(wTWebView);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(h.a)) {
            if (!TextUtils.isEmpty(str) && str.startsWith(h.a) && this.a.a(h.a)) {
                this.a.c(str);
            }
            return true;
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        sslError.toString();
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.d = str;
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029 A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #0 {all -> 0x002c, blocks: (B:4:0x000c, B:6:0x0014, B:7:0x0017, B:9:0x001b, B:10:0x0022, B:11:0x0025, B:13:0x0029), top: B:16:0x000c }] */
    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        c cVar;
        "onRenderProcessGone:".concat(String.valueOf(renderProcessGoneDetail));
        if (webView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                if (webView instanceof WTWebView) {
                    ((WTWebView) webView).release();
                } else {
                    webView.destroy();
                }
                cVar = this.c;
                if (cVar != null) {
                    cVar.a(webView);
                }
            } catch (Throwable unused) {
            }
        } else {
            cVar = this.c;
            if (cVar != null) {
                cVar.a(webView);
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str.startsWith("file:")) {
            String str2 = "";
            String strReplace = str.replace("file://", "");
            if (!al.a(strReplace, com.anythink.core.common.res.d.a(com.anythink.core.common.d.t.b().g()).a(6))) {
                return null;
            }
            if (str.endsWith(".js")) {
                str2 = "application/javascript";
            } else if (str.endsWith(".html")) {
                str2 = "text/html";
            } else if (str.endsWith(".css")) {
                str2 = "text/css";
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    File file = new File(strReplace);
                    if (file.exists()) {
                        return new WebResourceResponse(str2, "UTF-8", new FileInputStream(file));
                    }
                } catch (Throwable unused) {
                }
            }
        }
        WebResourceResponse webResourceResponseA = a(str);
        return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(webView, str);
    }

    private static WebResourceResponse a(String str) {
        Bitmap bitmapB;
        try {
            if (TextUtils.isEmpty(str) || !h.c(str) || (bitmapB = com.anythink.core.common.res.b.a(com.anythink.core.common.d.t.b().g()).b(new com.anythink.core.common.res.e(1, str), 0, 0)) == null || bitmapB.isRecycled()) {
                return null;
            }
            return new WebResourceResponse(h.d(str), "utf-8", com.anythink.core.common.v.h.a(bitmapB));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public final void a(c cVar) {
        this.c = cVar;
    }
}
