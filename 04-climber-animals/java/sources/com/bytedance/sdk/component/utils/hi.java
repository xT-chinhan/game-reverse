package com.bytedance.sdk.component.utils;

import android.os.Looper;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ms f1355ms = new xr();

    private static class ms {
        private ms() {
        }

        public void ms(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            hi.xr(new Runnable() { // from class: com.bytedance.sdk.component.utils.hi.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static class xr extends ms {
        private xr() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.hi.ms
        public void ms(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            hi.xr(new Runnable() { // from class: com.bytedance.sdk.component.utils.hi.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    boolean z = false;
                    if (str2 != null && str2.startsWith("javascript:")) {
                        try {
                            webView.evaluateJavascript(str, null);
                            z = true;
                        } catch (Throwable th) {
                            boolean z2 = th instanceof IllegalStateException;
                        }
                    }
                    if (z) {
                        return;
                    }
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Deprecated
    public static void ms(WebView webView, String str) {
        f1355ms.ms(webView, str);
    }

    public static void ms(com.bytedance.sdk.component.zb.ah ahVar, String str) {
        f1355ms.ms(ahVar.getWebView(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            x.xr().post(runnable);
        }
    }
}
