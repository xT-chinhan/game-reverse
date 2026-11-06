package com.byazt.nc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.bs.TTViewStub;
import com.byazt.fi.BaseConstants;
import com.byazt.fj.SSWebView;
import com.byazt.wt.er;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 61})
public class aj extends AlertDialog {
    public static volatile AtomicInteger x = new AtomicInteger(0);
    public TextView aj;
    public LinearLayout c;
    public ImageView fw;
    public TTViewStub g;
    public pr hn;
    public TTViewStub ho;
    public Context hw;
    public String k;
    public com.byazt.dw.hw m;
    public FrameLayout nt;
    public SSWebView pr;
    public ImageView uc;
    public com.byazt.pfl.hw vk;
    public Intent w;
    public int yb;
    public TextView zo;

    public interface pr {
        void pr(Dialog dialog);
    }

    public static /* synthetic */ int hn(aj ajVar) {
        int i = ajVar.yb;
        ajVar.yb = i + 1;
        return i;
    }

    public static /* synthetic */ int hw(aj ajVar) {
        int i = ajVar.yb;
        ajVar.yb = i - 1;
        return i;
    }

    public aj(Context context, Intent intent) {
        super(context);
        this.yb = 0;
        this.hw = context;
        this.w = intent;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.sdv.uc.hw(this);
        getWindow().clearFlags(131072);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.hw);
        this.c = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.c.setOrientation(1);
        this.pr = new SSWebView(this.hw);
        if (this.w != null && TTDelegateActivity.pr != null) {
            this.m = TTDelegateActivity.pr.ae();
            this.k = this.w.getStringExtra("event_tag");
        }
        setContentView(com.byazt.sdv.c.ls(this.hw));
        hw();
    }

    private void hn() {
        this.nt = (FrameLayout) findViewById(2114387634);
        this.g = (TTViewStub) findViewById(2114387770);
        this.ho = (TTViewStub) findViewById(2114387792);
        this.nt.addView(this.pr, new LinearLayout.LayoutParams(-1, -1));
        switch (com.byazt.sd.zo.nt().gz()) {
            case 0:
                TTViewStub tTViewStub = this.g;
                if (tTViewStub != null) {
                    tTViewStub.setVisibility(0);
                }
                break;
            case 1:
                TTViewStub tTViewStub2 = this.ho;
                if (tTViewStub2 != null) {
                    tTViewStub2.setVisibility(0);
                }
                break;
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.uc = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.aj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aj.x.set(0);
                    if (aj.this.pr != null && aj.this.pr.canGoBack() && aj.this.yb > 1) {
                        aj.this.pr.goBack();
                        aj.hw(aj.this);
                    } else {
                        aj.this.dismiss();
                        if (aj.this.hn != null) {
                            aj.this.hn.pr(aj.this);
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.fw = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.aj.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aj.x.set(0);
                    aj.this.dismiss();
                    if (aj.this.hn != null) {
                        aj.this.hn.pr(aj.this);
                    }
                }
            });
        }
        this.zo = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.aj = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.aj.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aj.this.pr();
                }
            });
        }
    }

    public void pr() {
        com.byazt.dw.hw hwVar;
        Context context = this.hw;
        if (context == null || (hwVar = this.m) == null) {
            return;
        }
        if (this.vk == null) {
            this.vk = new com.byazt.pfl.hw(context, hwVar, this.k, true, com.byazt.ub.hw.pr());
            com.byazt.pw.hn.pr(this.hw, TTDelegateActivity.pr, this.vk);
        }
        this.vk.pr();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        getWindow().getAttributes().height = er.uc(this.hw) - er.hn(this.hw, 50.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hw() {
        hn();
        if (this.zo != null && TTDelegateActivity.pr != null && !TextUtils.isEmpty(TTDelegateActivity.pr.A_())) {
            this.zo.setText(TTDelegateActivity.pr.A_());
        }
        com.byazt.lz.hw.pr(this.hw).pr(false).hw(false).pr(this.pr);
        this.pr.setWebViewClient(new com.byazt.lz.x(this.hw, null, 0 == true ? 1 : 0) { // from class: com.byazt.nc.aj.4
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
                                    aj.hn(aj.this);
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
                this.zo = aj.x;
                return super.pr(webView, webResourceRequest);
            }

            @Override // com.byazt.lz.x
            public boolean pr(WebView webView, String str) {
                this.zo = aj.x;
                return super.pr(webView, str);
            }
        });
        this.pr.setJavaScriptEnabled(true);
        this.pr.setDisplayZoomControls(false);
        this.pr.setCacheMode(2);
        this.pr.loadUrl("https://phoniex.toutiao.com");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        x.set(0);
        pr prVar = this.hn;
        if (prVar != null) {
            prVar.pr(this);
        }
    }

    public aj pr(pr prVar) {
        this.hn = prVar;
        return this;
    }
}
