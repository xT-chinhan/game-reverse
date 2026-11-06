package com.smartdigimkt.o2;

import android.text.TextUtils;
import android.webkit.WebView;
import com.smartdigimkt.k2.d;
import com.smartdigimkt.k2.h;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.e;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static volatile a a;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public final void b(WebView webView, String str, String str2) {
        try {
            if ((webView instanceof WTWebView) && ((WTWebView) webView).isDestroyed()) {
                return;
            }
            webView.loadUrl(a(str, str2));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void b(Object obj, String str) {
        final String str2;
        if (obj instanceof d) {
            final d dVar = (d) obj;
            if (TextUtils.isEmpty(str)) {
                str2 = "javascript:window.ATWebTPL.onSuccess('" + dVar.g + "','');";
            } else {
                String[] strArr = h.a;
                if (!TextUtils.isEmpty(str)) {
                    str = e.b(str);
                }
                str2 = "javascript:window.ATWebTPL.onSuccess('" + dVar.g + "','" + str + "');";
            }
            String str3 = dVar.g;
            f.a().a(new Runnable() { // from class: com.smartdigimkt.o2.a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(dVar, str2);
                }
            });
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "javascript:window.ATWebTPL.fireEvent('" + str + "', '');";
        }
        String[] strArr = h.a;
        if (!TextUtils.isEmpty(str2)) {
            str2 = e.b(str2);
        }
        return "javascript:window.ATWebTPL.fireEvent('" + str + "','" + str2 + "');";
    }

    public final void a(final WebView webView, final String str, final String str2) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        f.a().a(new Runnable() { // from class: com.smartdigimkt.o2.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(webView, str, str2);
            }
        });
    }

    public final void b(d dVar, String str) {
        WTWebView wTWebView = dVar.a;
        if (wTWebView == null || wTWebView.isDestroyed()) {
            return;
        }
        try {
            dVar.a.loadUrl(str);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void a(Object obj, String str) {
        final String str2;
        if (obj instanceof d) {
            final d dVar = (d) obj;
            if (TextUtils.isEmpty(str)) {
                str2 = "javascript:window.ATWebTPL.onFailure('" + dVar.g + "','');";
            } else {
                String[] strArr = h.a;
                if (!TextUtils.isEmpty(str)) {
                    str = e.b(str);
                }
                str2 = "javascript:window.ATWebTPL.onFailure('" + dVar.g + "','" + str + "');";
            }
            String str3 = dVar.g;
            f.a().a(new Runnable() { // from class: com.smartdigimkt.o2.a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(dVar, str2);
                }
            });
        }
    }

    public final void a(d dVar, String str) {
        WTWebView wTWebView = dVar.a;
        if (wTWebView == null || wTWebView.isDestroyed()) {
            return;
        }
        try {
            dVar.a.loadUrl(str);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
