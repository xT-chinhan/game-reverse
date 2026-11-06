package com.smartdigimkt.k2;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends WebChromeClient {
    public c a;
    public g b;

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) throws com.smartdigimkt.p2.a {
        if (consoleMessage == null || consoleMessage.messageLevel() == null) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = s.a[consoleMessage.messageLevel().ordinal()];
        if (i == 1 || i == 2 || i != 3) {
            Objects.toString(consoleMessage.messageLevel());
            consoleMessage.message();
        } else {
            Objects.toString(consoleMessage.messageLevel());
            consoleMessage.message();
        }
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        if (this.b == null) {
            return super.onConsoleMessage(consoleMessage);
        }
        String strMessage = consoleMessage.message();
        if (!TextUtils.isEmpty(strMessage) && strMessage.startsWith("atwt:")) {
            g gVar = this.b;
            gVar.getClass();
            if (h.a[0].equals("atwt:")) {
                gVar.a = h.b;
                this.b.a(strMessage);
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(webView, i);
        }
    }
}
