package com.smartdigimkt.j2;

import android.webkit.WebView;
import com.smartdigimkt.b3.v;
import com.smartdigimkt.sdk.basead.ui.web.WebProgressBarView;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void callbackClickResult(v vVar);

    com.smartdigimkt.b3.c getBaseAdContent();

    com.smartdigimkt.a3.a getBaseAdRequestInfo();

    String getOriginalUrl();

    WebProgressBarView getWebProgressBarView();

    void onWebFinish();

    void onWebPageFinish(WebView webView, String str);

    void onWebPageLoadError(WebView webView, String str);

    void onWebPageStart(WebView webView, String str);

    void recordRedirectUrl(String str);

    boolean supportDeeplinkJump();
}
