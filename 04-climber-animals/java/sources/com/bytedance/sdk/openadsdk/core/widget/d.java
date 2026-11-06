package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d extends AlertDialog {
    protected static volatile AtomicInteger c = new AtomicInteger(0);
    private String ab;
    protected TextView ah;
    protected String d;
    protected ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected SSWebView f3713ms;
    protected Context xr;

    public interface ms {
        void ms(Dialog dialog);
    }

    public d(Context context, String str, String str2) {
        super(context, t.ab(context, "tt_dialog_full"));
        this.xr = context;
        this.ab = str2;
        this.d = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.ka.am(getContext()));
        ms();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void ms() {
        this.f3713ms = (SSWebView) findViewById(2114387845);
        this.ah = (TextView) findViewById(2114387918);
        ((TextView) findViewById(2114387702)).setText(this.ab);
        this.ah.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.c.set(0);
                if (d.this.ka != null) {
                    d.this.ka.ms(d.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.f3713ms.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.xr, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.d.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.getDefault());
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            protected boolean ms(WebView webView, WebResourceRequest webResourceRequest) {
                this.x = d.c;
                return super.ms(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            public boolean ms(WebView webView, String str) {
                this.x = d.c;
                return super.ms(webView, str);
            }
        });
        this.f3713ms.setJavaScriptEnabled(true);
        this.f3713ms.setDisplayZoomControls(false);
        this.f3713ms.setCacheMode(2);
        this.f3713ms.loadUrl(this.d);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        c.set(0);
        ms msVar = this.ka;
        if (msVar != null) {
            msVar.ms(this);
        }
    }

    public d ms(ms msVar) {
        this.ka = msVar;
        return this;
    }
}
