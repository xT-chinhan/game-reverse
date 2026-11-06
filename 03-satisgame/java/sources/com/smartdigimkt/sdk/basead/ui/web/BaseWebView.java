package com.smartdigimkt.sdk.basead.ui.web;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.smartdigimkt.i2.u;
import com.smartdigimkt.i2.x;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.r4.j;

/* JADX INFO: loaded from: classes3.dex */
public class BaseWebView extends WebView {
    public static boolean b = false;
    public boolean a;

    public BaseWebView(Context context) {
        super(context);
        a();
    }

    public void a() {
        Looper.myLooper();
        Looper.getMainLooper();
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        setWebChromeClient(new u());
        j.a(this);
        if (b) {
            return;
        }
        getContext();
        b = true;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.a) {
            return;
        }
        this.a = true;
        d.a(this);
        stopLoading();
        setWebChromeClient(null);
        setWebViewClient(null);
        clearHistory();
        clearCache(true);
        getSettings().setJavaScriptEnabled(false);
        loadUrl(com.anythink.core.common.res.d.a);
        removeAllViews();
        super.destroy();
    }

    public boolean isDestroyed() {
        return this.a;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.a(this);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
