package com.byazt.lz;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.byazt.hg.e;
import com.byazt.sd.nl;
import com.byazt.sd.zo;
import com.byazt.wt.cz;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1266, 20})
public class hn extends WebChromeClient {
    public static final String pr = WebChromeClient.class.getSimpleName();
    public com.byazt.pj.hn hn;
    public final nl hw;

    public hn(nl nlVar) {
        this.hw = nlVar;
    }

    public hn(nl nlVar, com.byazt.pj.hn hnVar) {
        this.hw = nlVar;
        this.hn = hnVar;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            pr(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage != null && !TextUtils.isEmpty(consoleMessage.message()) && pr(consoleMessage.message())) {
            return true;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    private boolean pr(String str) {
        zo.nt().of();
        try {
            Uri uri = Uri.parse(str);
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                cz.pr(uri, this.hw);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        com.byazt.pj.hn hnVar;
        super.onProgressChanged(webView, i);
        com.byazt.pj.hn hnVar2 = this.hn;
        if (hnVar2 != null) {
            hnVar2.pr(webView, i);
        }
        if (i > 90 && (hnVar = this.hn) != null) {
            hnVar.pr(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (e.pr(this.hw, 1, str2)) {
            jsResult.confirm();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (e.pr(this.hw, 2, str2)) {
            jsResult.confirm();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (e.pr(this.hw, 3, str2)) {
            jsPromptResult.confirm();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (e.pr(this.hw, 4, str2)) {
            jsResult.confirm();
            return true;
        }
        return false;
    }
}
