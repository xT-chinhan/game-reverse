package com.byazt.lz;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.ca.ho;
import com.byazt.zp.zo;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1266, 13})
public class hw {
    public WeakReference<Context> pr;
    public boolean hw = true;
    public boolean hn = true;
    public boolean x = true;
    public boolean c = true;
    public boolean uc = true;
    public boolean fw = true;
    public boolean zo = true;

    public static hw pr(Context context) {
        return new hw(context);
    }

    private hw(Context context) {
        this.pr = new WeakReference<>(context);
    }

    public hw pr(boolean z) {
        this.zo = z;
        return this;
    }

    public hw hw(boolean z) {
        this.hn = z;
        return this;
    }

    public void pr(final com.byazt.son.x xVar) {
        zo.pr(new Runnable() { // from class: com.byazt.lz.hw.1
            @Override // java.lang.Runnable
            public void run() {
                hw.this.pr(xVar.getWebView());
            }
        });
    }

    public void pr(WebView webView) {
        if (webView == null || this.pr.get() == null) {
            return;
        }
        hw(webView);
        WebSettings settings = webView.getSettings();
        pr(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
        }
        try {
            if (this.hn) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.x);
        settings.setDomStorageEnabled(this.c);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.fw);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.zo = false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 11 && !this.zo) {
                webView.setLayerType(0, null);
            } else if (Build.VERSION.SDK_INT >= 16 && this.zo) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
        }
    }

    private void hw(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            ho.pr(th.toString());
        }
    }

    private void pr(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            ho.pr(th.toString());
        }
    }

    public static String pr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head?.appendChild(script);})();";
    }
}
