package com.bytedance.sdk.openadsdk.core.widget.ms;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.op.ab;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<Context> f3731ms;
    private boolean xr = true;
    private boolean ah = true;
    private boolean d = true;
    private boolean ka = true;
    private boolean c = true;
    private boolean ab = true;
    private boolean x = true;

    public static xr ms(Context context) {
        return new xr(context);
    }

    private xr(Context context) {
        this.f3731ms = new WeakReference<>(context);
    }

    public xr ms(boolean z) {
        this.x = z;
        return this;
    }

    public xr xr(boolean z) {
        this.ah = z;
        return this;
    }

    public void ms(final com.bytedance.sdk.component.zb.ah ahVar) {
        ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.ms.xr.1
            @Override // java.lang.Runnable
            public void run() {
                xr.this.ms(ahVar.getWebView());
            }
        });
    }

    public void ms(WebView webView) {
        if (webView == null || this.f3731ms.get() == null) {
            return;
        }
        xr(webView);
        WebSettings settings = webView.getSettings();
        ms(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            sl.ms(e);
        }
        try {
            if (this.ah) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.d);
        settings.setDomStorageEnabled(this.ka);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.ab);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.x = false;
        }
        try {
            if (!this.x) {
                webView.setLayerType(0, null);
            } else if (this.x) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            sl.ms(th2);
        }
    }

    private void xr(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            sl.xr(th.toString());
        }
    }

    private void ms(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            sl.xr(th.toString());
        }
    }

    public static String ms(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
