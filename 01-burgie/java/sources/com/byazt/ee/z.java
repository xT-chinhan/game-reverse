package com.byazt.ee;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 110})
public class z extends pr {
    public static final /* synthetic */ boolean aj = true;
    public String fw;
    public com.byazt.son.x zo;

    @Override // com.byazt.ee.pr
    public Context getContext(vk vkVar) {
        if (vkVar.c != null) {
            return vkVar.c;
        }
        if (vkVar.pr != null) {
            View view = vkVar.pr.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = vkVar.pr.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.byazt.ee.pr
    public String pr() {
        return this.zo.getUrl();
    }

    @Override // com.byazt.ee.pr
    public void pr(vk vkVar) {
        this.zo = vkVar.pr;
        this.fw = vkVar.hn;
        if (Build.VERSION.SDK_INT >= 17 && !vkVar.g) {
            x();
        }
    }

    public void x() {
        if (!aj && this.zo == null) {
            throw new AssertionError();
        }
        com.byazt.son.x xVar = this.zo;
        if (xVar != null) {
            xVar.addJavascriptInterface(this, this.fw);
        }
    }

    @Override // com.byazt.ee.pr
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.byazt.ee.pr
    public void hn() {
        super.hn();
        c();
    }

    public void c() {
        com.byazt.son.x xVar = this.zo;
        if (xVar != null) {
            xVar.removeJavascriptInterface(this.fw);
        }
    }

    @Override // com.byazt.ee.pr
    public void pr(String str, nt ntVar) {
        if (ntVar != null && !TextUtils.isEmpty(ntVar.zo)) {
            String str2 = ntVar.zo;
            pr(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.pr(str, ntVar);
    }

    @Override // com.byazt.ee.pr
    public void pr(String str) {
        pr(str, "javascript:" + this.fw + "._handleMessageFromToutiao(" + str + ")");
    }

    private void pr(String str, String str2) {
        if (this.c || TextUtils.isEmpty(str2) || this.c) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                this.zo.evaluateJavascript(str2, null);
            } else {
                this.zo.loadUrl(str2);
            }
        } catch (Throwable th) {
        }
    }
}
