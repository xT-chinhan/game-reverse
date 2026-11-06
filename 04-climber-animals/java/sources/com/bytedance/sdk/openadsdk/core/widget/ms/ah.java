package com.bytedance.sdk.openadsdk.core.widget.ms;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.nw.p;
import com.bytedance.sdk.openadsdk.core.pc;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends WebChromeClient {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f3728ms = WebChromeClient.class.getSimpleName();
    private com.bytedance.sdk.openadsdk.core.zb.d ah;
    private final pc xr;

    public ah(pc pcVar) {
        this.xr = pcVar;
    }

    public ah(pc pcVar, com.bytedance.sdk.openadsdk.core.zb.d dVar) {
        this.xr = pcVar;
        this.ah = dVar;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ms(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !ms(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    private boolean ms(String str) {
        ch.ub().fm();
        try {
            Uri uri = Uri.parse(str);
            if (!"bytedance".equals(uri.getScheme().toLowerCase())) {
                return false;
            }
            t.ms(uri, this.xr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        com.bytedance.sdk.openadsdk.core.zb.d dVar;
        super.onProgressChanged(webView, i);
        com.bytedance.sdk.openadsdk.core.zb.d dVar2 = this.ah;
        if (dVar2 != null) {
            dVar2.ms(webView, i);
        }
        if (i <= 90 || (dVar = this.ah) == null) {
            return;
        }
        dVar.ms(webView);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!p.ms(this.xr, 1, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!p.ms(this.xr, 2, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (!p.ms(this.xr, 3, str2)) {
            return false;
        }
        jsPromptResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!p.ms(this.xr, 4, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }
}
