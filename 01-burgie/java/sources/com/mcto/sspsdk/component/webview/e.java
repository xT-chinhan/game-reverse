package com.mcto.sspsdk.component.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.mcto.sspsdk.internal.nf;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends nf {
    public final /* synthetic */ QyWebViewPanel e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(QyWebViewPanel qyWebViewPanel, Context context) {
        super(context);
        this.e = qyWebViewPanel;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        if (this.e.d != null) {
            this.e.d.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT > 21) {
            for (int i = 0; i < this.e.k.size(); i++) {
                String str2 = (String) this.e.k.get(i);
                if (webView != null) {
                    webView.evaluateJavascript("var newscript = document.createElement(\"script\");newscript.src=\"" + str2 + "\";newscript.setAttribute(\"charset\", \"utf-8\");document.body.appendChild(newscript);", null);
                }
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.e.d != null) {
            this.e.d.setVisibility(0);
        }
    }

    @Override // com.mcto.sspsdk.internal.nf, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (QyWebViewPanel.a(this.e, Uri.parse(str))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.mcto.sspsdk.internal.nf, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (QyWebViewPanel.a(this.e, webResourceRequest.getUrl())) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
