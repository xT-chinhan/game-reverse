package com.smartdigimkt.q1;

import android.content.Context;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.smartdigimkt.i2.x;
import com.smartdigimkt.sdk.basead.ui.animplayerview.WebLandpagePlayerView;
import com.smartdigimkt.sdk.basead.ui.web.BaseWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ WebLandpagePlayerView b;

    public p(WebLandpagePlayerView webLandpagePlayerView, Context context) {
        this.b = webLandpagePlayerView;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebLandpagePlayerView webLandpagePlayerView = this.b;
        Context context = this.a;
        int i = WebLandpagePlayerView.S;
        webLandpagePlayerView.getClass();
        try {
            webLandpagePlayerView.G = new BaseWebView(context);
            webLandpagePlayerView.K = new com.smartdigimkt.j2.e(webLandpagePlayerView.p);
            webLandpagePlayerView.G.setBackgroundColor(-1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, webLandpagePlayerView.getMeasuredHeight());
            webLandpagePlayerView.G.setVisibility(8);
            webLandpagePlayerView.addView(webLandpagePlayerView.G, layoutParams);
            x.a(context);
            x.a((WebView) webLandpagePlayerView.G, (com.smartdigimkt.j2.b) webLandpagePlayerView, false);
            webLandpagePlayerView.G.setDownloadListener(new r(webLandpagePlayerView, context));
            webLandpagePlayerView.O = true;
        } catch (Throwable unused) {
            webLandpagePlayerView.O = false;
        }
        WebLandpagePlayerView webLandpagePlayerView2 = this.b;
        if (webLandpagePlayerView2.E == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -webLandpagePlayerView2.getMeasuredHeight());
            webLandpagePlayerView2.E = translateAnimation;
            translateAnimation.setFillAfter(true);
            webLandpagePlayerView2.E.setDuration(1200L);
        }
        if (webLandpagePlayerView2.F == null) {
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, webLandpagePlayerView2.getMeasuredHeight(), 0.0f);
            webLandpagePlayerView2.F = translateAnimation2;
            translateAnimation2.setFillAfter(true);
            webLandpagePlayerView2.F.setDuration(1200L);
            webLandpagePlayerView2.F.setAnimationListener(new q(webLandpagePlayerView2));
        }
    }
}
