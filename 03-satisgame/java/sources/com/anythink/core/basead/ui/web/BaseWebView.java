package com.anythink.core.basead.ui.web;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.anythink.core.common.d.u;
import com.anythink.core.common.res.d;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.o;

/* JADX INFO: loaded from: classes.dex */
public class BaseWebView extends WebView {
    private static boolean b = false;
    protected boolean a;

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

    private void a() {
        c();
        com.anythink.core.basead.ui.a.a.a(this);
        o.a(this);
        if (b) {
            return;
        }
        a(getContext());
        b = true;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, u.a(getContext()).b());
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.a) {
            return;
        }
        this.a = true;
        al.a((View) this);
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
        return this.a;
    }
}
