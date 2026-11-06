package com.anythink.basead.mraid;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class j extends WebChromeClient {
    private static final String b = "H5_ENTRY";
    MraidBaseWebView a;
    private com.anythink.core.express.web.c c;

    public j(MraidBaseWebView mraidBaseWebView) {
        this.a = mraidBaseWebView;
    }

    public final void a(com.anythink.core.express.web.c cVar) {
        this.c = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        a signalCommunication = this.a.getSignalCommunication();
        if (signalCommunication == null || str3 == null || !signalCommunication.a(str3)) {
            return false;
        }
        signalCommunication.b(str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        com.anythink.core.express.web.c cVar = this.c;
        if (cVar != null) {
            cVar.onProgressChanged(webView, i);
        }
    }
}
