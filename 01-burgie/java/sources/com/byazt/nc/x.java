package com.byazt.nc;

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
import com.byazt.fi.BaseConstants;
import com.byazt.fj.SSWebView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 121})
public class x extends AlertDialog {
    public static volatile AtomicInteger uc = new AtomicInteger(0);
    public pr c;
    public String fw;
    public TextView hn;
    public Context hw;
    public SSWebView pr;
    public String x;

    public interface pr {
        void pr(Dialog dialog);
    }

    public x(Context context, String str, String str2) {
        super(context);
        this.hw = context;
        this.fw = str2;
        this.x = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.sdv.uc.hw(this);
        setContentView(com.byazt.sdv.c.f(getContext()));
        pr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr() {
        this.pr = (SSWebView) findViewById(2114387839);
        this.hn = (TextView) findViewById(2114387912);
        ((TextView) findViewById(2114387696)).setText(this.fw);
        this.hn.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x.uc.set(0);
                if (x.this.c != null) {
                    x.this.c.pr(x.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.pr.setWebViewClient(new com.byazt.lz.x(this.hw, null, 0 == true ? 1 : 0) { // from class: com.byazt.nc.x.2
            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            String scheme = Uri.parse(str).getScheme();
                            if (!TextUtils.isEmpty(scheme)) {
                                String lowerCase = scheme.toLowerCase(Locale.getDefault());
                                if (lowerCase.contains("http") || lowerCase.contains(BaseConstants.SCHEME_HTTPS)) {
                                    webView.loadUrl(str);
                                    return true;
                                }
                                return true;
                            }
                            return true;
                        }
                        return true;
                    } catch (Exception e) {
                        return true;
                    }
                }
                return true;
            }

            @Override // com.byazt.lz.x
            public boolean pr(WebView webView, WebResourceRequest webResourceRequest) {
                this.zo = x.uc;
                return super.pr(webView, webResourceRequest);
            }

            @Override // com.byazt.lz.x
            public boolean pr(WebView webView, String str) {
                this.zo = x.uc;
                return super.pr(webView, str);
            }
        });
        this.pr.setJavaScriptEnabled(true);
        this.pr.setDisplayZoomControls(false);
        this.pr.setCacheMode(2);
        this.pr.loadUrl(this.x);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        uc.set(0);
        pr prVar = this.c;
        if (prVar != null) {
            prVar.pr(this);
        }
    }

    public x pr(pr prVar) {
        this.c = prVar;
        return this;
    }
}
