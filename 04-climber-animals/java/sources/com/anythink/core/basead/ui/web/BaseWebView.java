package com.anythink.core.basead.ui.web;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.anythink.core.common.d.v;
import com.anythink.core.common.res.d;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.p;

/* JADX INFO: loaded from: classes.dex */
public class BaseWebView extends WebView {
    private static boolean a = false;
    protected boolean g;

    private static void a(Context context) {
    }

    public BaseWebView(Context context) {
        super(context);
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, v.a(getContext()).b());
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.g) {
            return;
        }
        this.g = true;
        am.a(this);
        stopLoading();
        setWebChromeClient(null);
        setWebViewClient(null);
        clearHistory();
        clearCache(true);
        getSettings().setJavaScriptEnabled(false);
        loadUrl(d.a);
        removeAllViews();
        super.destroy();
    }

    private void b() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setCacheMode(-1);
    }

    private void c() {
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
    }

    public boolean isDestroyed() {
        return this.g;
    }

    protected void a() {
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        com.anythink.core.basead.ui.a.a.a(this);
        p.a(this);
        if (a) {
            return;
        }
        getContext();
        a = true;
    }
}
