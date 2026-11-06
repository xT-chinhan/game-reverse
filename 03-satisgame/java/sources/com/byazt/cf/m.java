package com.byazt.cf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public class m extends n {
    public static final /* synthetic */ boolean rv = true;
    public com.byazt.uad.q fs;
    public String x;

    @Override // com.byazt.cf.n
    public Context getContext(tj tjVar) {
        if (tjVar.l != null) {
            return tjVar.l;
        }
        if (tjVar.n != null) {
            View view = tjVar.n.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = tjVar.n.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.byazt.cf.n
    public String n() {
        return this.fs.getUrl();
    }

    @Override // com.byazt.cf.n
    public void n(tj tjVar) {
        this.fs = tjVar.n;
        this.x = tjVar.s;
        if (tjVar.sz) {
            return;
        }
        q();
    }

    public void q() {
        if (!rv && this.fs == null) {
            throw new AssertionError();
        }
        com.byazt.uad.q qVar = this.fs;
        if (qVar != null) {
            qVar.addJavascriptInterface(this, this.x);
        }
    }

    @Override // com.byazt.cf.n
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.byazt.cf.n
    public void s() {
        super.s();
        l();
    }

    public void l() {
        com.byazt.uad.q qVar = this.fs;
        if (qVar != null) {
            qVar.removeJavascriptInterface(this.x);
        }
    }

    @Override // com.byazt.cf.n
    public void n(String str, k kVar) {
        if (kVar != null && !TextUtils.isEmpty(kVar.fs)) {
            String str2 = kVar.fs;
            n(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.n(str, kVar);
    }

    @Override // com.byazt.cf.n
    public void n(String str) {
        n(str, "javascript:" + this.x + "._handleMessageFromToutiao(" + str + ")");
    }

    private void n(String str, String str2) {
        if (this.l || TextUtils.isEmpty(str2) || this.l) {
            return;
        }
        try {
            this.fs.evaluateJavascript(str2, null);
        } catch (Throwable unused) {
        }
    }
}
