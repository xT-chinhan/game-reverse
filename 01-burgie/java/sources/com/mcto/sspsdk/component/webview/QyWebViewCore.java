package com.mcto.sspsdk.component.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mcto.sspsdk.internal.r9;

/* JADX INFO: loaded from: classes2.dex */
public class QyWebViewCore extends WebView {
    public QyWebViewCore(Context context) {
        this(context, null);
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        clearHistory();
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getScrollY() <= 0) {
            scrollTo(0, 1);
        }
        return super.onTouchEvent(motionEvent);
    }

    public QyWebViewCore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        try {
            WebSettings settings = getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(-1);
            settings.setSupportZoom(false);
            settings.setBuiltInZoomControls(true);
            settings.setDomStorageEnabled(true);
            settings.setDisplayZoomControls(false);
            settings.setUserAgentString(settings.getUserAgentString() + " iad-version/2.3.102");
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
            settings.setSavePassword(false);
        } catch (Throwable th) {
            r9.a("ssp_sdk", "setWebView: ", th);
        }
    }
}
