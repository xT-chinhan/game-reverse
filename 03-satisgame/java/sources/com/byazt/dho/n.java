package com.byazt.dho;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.tk.k;
import com.byazt.uad.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1479, 19})
public class n {
    public WeakReference<Context> n;
    public boolean qg = true;
    public boolean s = true;
    public boolean q = true;
    public boolean l = true;
    public boolean w = true;
    public boolean x = true;
    public boolean fs = true;

    public static n n(Context context) {
        return new n(context);
    }

    private n(Context context) {
        this.n = new WeakReference<>(context);
    }

    public n n(boolean z) {
        this.fs = z;
        return this;
    }

    public n qg(boolean z) {
        this.s = z;
        return this;
    }

    public void n(final q qVar) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.dho.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.n(qVar.getWebView());
            }
        });
    }

    public void n(WebView webView) {
        if (webView == null || this.n.get() == null) {
            return;
        }
        qg(webView);
        WebSettings settings = webView.getSettings();
        n(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception unused) {
        }
        try {
            if (this.s) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable unused2) {
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.q);
        settings.setDomStorageEnabled(this.l);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.x);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.fs = false;
        }
        try {
            if (!this.fs) {
                webView.setLayerType(0, null);
            } else if (this.fs) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable unused3) {
        }
    }

    private void qg(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            k.n(th.toString());
        }
    }

    private void n(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            k.n(th.toString());
        }
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head?.appendChild(script);})();";
    }
}
