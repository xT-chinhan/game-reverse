package com.byazt.mr;

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
import com.byazt.ho.BaseConstants;
import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 5})
public class q extends AlertDialog {
    public static volatile AtomicInteger w = new AtomicInteger(0);
    public n l;
    public SSWebView n;
    public String q;
    public Context qg;
    public TextView s;
    public String x;

    public interface n {
        void n(Dialog dialog);
    }

    public q(Context context, String str, String str2) {
        super(context);
        this.qg = context;
        this.x = str2;
        this.q = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.cb.s.qg(this);
        setContentView(com.byazt.cb.qg.ri(getContext()));
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n() {
        this.n = (SSWebView) findViewById(2114387839);
        this.s = (TextView) findViewById(2114387912);
        ((TextView) findViewById(2114387696)).setText(this.x);
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.w.set(0);
                if (q.this.l != null) {
                    q.this.l.n(q.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.n.setWebViewClient(new com.byazt.dho.s(this.qg, null, 0 == true ? 1 : 0) { // from class: com.byazt.mr.q.2
            @Override // com.byazt.dho.s, android.webkit.WebViewClient
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
                    if (!lowerCase.contains("http") && !lowerCase.contains(BaseConstants.SCHEME_HTTPS)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.byazt.dho.s
            public boolean n(WebView webView, WebResourceRequest webResourceRequest) {
                this.fs = q.w;
                return super.n(webView, webResourceRequest);
            }

            @Override // com.byazt.dho.s
            public boolean n(WebView webView, String str) {
                this.fs = q.w;
                return super.n(webView, str);
            }
        });
        this.n.setJavaScriptEnabled(true);
        this.n.setDisplayZoomControls(false);
        this.n.setCacheMode(2);
        this.n.loadUrl(this.q);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        w.set(0);
        n nVar = this.l;
        if (nVar != null) {
            nVar.n(this);
        }
    }

    public q n(n nVar) {
        this.l = nVar;
        return this;
    }
}
