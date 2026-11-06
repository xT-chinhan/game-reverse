package com.byazt.nc;

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
import com.byazt.ca.b;
import com.byazt.fi.BaseConstants;
import com.byazt.fj.SSWebView;
import com.byazt.sd.a;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 109})
public class w extends AlertDialog {
    public static volatile AtomicInteger pr = new AtomicInteger(0);
    public RelativeLayout aj;
    public String c;
    public String fw;
    public Context hn;
    public SSWebView hw;
    public pr uc;
    public ImageView vk;
    public ImageView w;
    public TextView x;
    public RelativeLayout zo;

    public interface pr {
        void pr(Dialog dialog);
    }

    public w(Context context, String str) {
        super(context);
        this.fw = str;
        this.hn = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.sdv.uc.hw(this);
        setContentView(com.byazt.sdv.c.qi(this.hn));
        hw();
        pr();
    }

    public void pr() {
        String strWx = a.hw().wx();
        if (TextUtils.isEmpty(strWx)) {
            this.c = "https://www.pangle.cn/privacy/partner";
        } else {
            this.c = strWx;
        }
        if (TextUtils.isEmpty(this.fw)) {
            return;
        }
        if (this.c.contains("?")) {
            this.c += "&ad_info=" + this.fw;
        } else {
            this.c += "?ad_info=" + this.fw;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        pr.set(0);
        pr prVar = this.uc;
        if (prVar != null) {
            prVar.pr(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hw() {
        this.hw = (SSWebView) findViewById(2114387763);
        TextView textView = (TextView) findViewById(2114387652);
        this.x = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.uc != null) {
                    w.this.uc.pr(w.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.hw.setWebViewClient(new com.byazt.lz.x(this.hn, null, 0 == true ? 1 : 0) { // from class: com.byazt.nc.w.2
            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            String scheme = Uri.parse(str).getScheme();
                            if (!TextUtils.isEmpty(scheme)) {
                                String lowerCase = scheme.toLowerCase(Locale.US);
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
                this.zo = w.pr;
                return super.pr(webView, webResourceRequest);
            }

            @Override // com.byazt.lz.x
            public boolean pr(WebView webView, String str) {
                this.zo = w.pr;
                return super.pr(webView, str);
            }
        });
        this.hw.setJavaScriptEnabled(true);
        this.hw.setDisplayZoomControls(false);
        this.hw.setCacheMode(2);
        this.hw.loadUrl(this.c);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387883);
        this.zo = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387894);
        this.aj = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.x.setVisibility(8);
        this.vk = (ImageView) findViewById(2114387813);
        this.w = (ImageView) findViewById(2114387836);
        this.vk.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.w.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.uc != null) {
                    w.this.uc.pr(w.this);
                    w.pr.set(0);
                }
            }
        });
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.w.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((ClipboardManager) w.this.hn.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, w.this.c));
                    b.pr(w.this.hn, "链接复制成功", 1);
                } catch (Throwable th) {
                    b.pr(w.this.hn, "链接复制失败", 1);
                }
            }
        });
    }

    public w pr(pr prVar) {
        this.uc = prVar;
        return this;
    }
}
