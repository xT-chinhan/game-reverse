package com.byazt.mr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ho.BaseConstants;
import com.byazt.kfh.SSWebView;
import com.byazt.tk.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 29})
public class cp extends AlertDialog {
    public static volatile AtomicInteger n = new AtomicInteger(0);
    public ImageView cp;
    public RelativeLayout fs;
    public String l;
    public TextView q;
    public SSWebView qg;
    public RelativeLayout rv;
    public Context s;
    public ImageView tj;
    public n w;
    public String x;

    public interface n {
        void n(Dialog dialog);
    }

    public cp(Context context, String str) {
        super(context);
        this.x = str;
        this.s = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.cb.s.qg(this);
        setContentView(com.byazt.cb.qg.oj(this.s));
        qg();
        n();
    }

    public void n() {
        String strKj = com.byazt.nf.rv.qg().kj();
        if (TextUtils.isEmpty(strKj)) {
            this.l = "https://www.pangle.cn/privacy/partner";
        } else {
            this.l = strKj;
        }
        if (TextUtils.isEmpty(this.x)) {
            return;
        }
        if (this.l.contains("?")) {
            this.l += "&ad_info=" + this.x;
        } else {
            this.l += "?ad_info=" + this.x;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        n.set(0);
        n nVar = this.w;
        if (nVar != null) {
            nVar.n(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void qg() {
        this.qg = (SSWebView) findViewById(2114387763);
        TextView textView = (TextView) findViewById(2114387652);
        this.q = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.cp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (cp.this.w != null) {
                    cp.this.w.n(cp.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.qg.setWebViewClient(new com.byazt.dho.s(this.s, null, 0 == true ? 1 : 0) { // from class: com.byazt.mr.cp.2
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
                    String lowerCase = scheme.toLowerCase(Locale.US);
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
                this.fs = cp.n;
                return super.n(webView, webResourceRequest);
            }

            @Override // com.byazt.dho.s
            public boolean n(WebView webView, String str) {
                this.fs = cp.n;
                return super.n(webView, str);
            }
        });
        this.qg.setJavaScriptEnabled(true);
        this.qg.setDisplayZoomControls(false);
        this.qg.setCacheMode(2);
        this.qg.loadUrl(this.l);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387883);
        this.fs = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387894);
        this.rv = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.q.setVisibility(8);
        this.tj = (ImageView) findViewById(2114387813);
        this.cp = (ImageView) findViewById(2114387836);
        this.tj.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.cp.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (cp.this.w != null) {
                    cp.this.w.n(cp.this);
                    cp.n.set(0);
                }
            }
        });
        this.cp.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.cp.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((ClipboardManager) cp.this.s.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, cp.this.l));
                    h.n(cp.this.s, "链接复制成功", 1);
                } catch (Throwable unused) {
                    h.n(cp.this.s, "链接复制失败", 1);
                }
            }
        });
    }

    public cp n(n nVar) {
        this.w = nVar;
        return this;
    }
}
