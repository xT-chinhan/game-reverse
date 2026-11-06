package com.byazt.mr;

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
import com.byazt.ho.BaseConstants;
import com.byazt.kfh.SSWebView;
import com.byazt.lz.TTViewStub;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends AlertDialog {
    public static volatile AtomicInteger q = new AtomicInteger(0);
    public Intent cp;
    public FrameLayout cy;
    public String d;
    public TextView fs;
    public int hd;
    public TTViewStub k;
    public LinearLayout l;
    public SSWebView n;
    public com.byazt.oj.qg oa;
    public Context qg;
    public TextView rv;
    public n s;
    public TTViewStub sz;
    public com.byazt.wg.qg tj;
    public ImageView w;
    public ImageView x;

    public interface n {
        void n(Dialog dialog);
    }

    public static /* synthetic */ int qg(rv rvVar) {
        int i = rvVar.hd;
        rvVar.hd = i - 1;
        return i;
    }

    public static /* synthetic */ int s(rv rvVar) {
        int i = rvVar.hd;
        rvVar.hd = i + 1;
        return i;
    }

    public rv(Context context, Intent intent) {
        super(context);
        this.hd = 0;
        this.qg = context;
        this.cp = intent;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.cb.s.qg(this);
        getWindow().clearFlags(131072);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.qg);
        this.l = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.l.setOrientation(1);
        this.n = new SSWebView(this.qg);
        if (this.cp != null && TTDelegateActivity.n != null) {
            this.oa = TTDelegateActivity.n.pt();
            this.d = this.cp.getStringExtra("event_tag");
        }
        setContentView(com.byazt.cb.qg.f(this.qg));
        qg();
    }

    private void s() {
        TTViewStub tTViewStub;
        this.cy = (FrameLayout) findViewById(2114387634);
        this.sz = (TTViewStub) findViewById(2114387770);
        this.k = (TTViewStub) findViewById(2114387792);
        this.cy.addView(this.n, new LinearLayout.LayoutParams(-1, -1));
        int iBb = com.byazt.vyf.s.cy().bb();
        if (iBb == 0) {
            TTViewStub tTViewStub2 = this.sz;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
        } else if (iBb == 1 && (tTViewStub = this.k) != null) {
            tTViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.w = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.rv.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    rv.q.set(0);
                    if (rv.this.n != null && rv.this.n.canGoBack() && rv.this.hd > 1) {
                        rv.this.n.goBack();
                        rv.qg(rv.this);
                    } else {
                        rv.this.dismiss();
                        if (rv.this.s != null) {
                            rv.this.s.n(rv.this);
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.x = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.rv.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    rv.q.set(0);
                    rv.this.dismiss();
                    if (rv.this.s != null) {
                        rv.this.s.n(rv.this);
                    }
                }
            });
        }
        this.fs = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.rv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.rv.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    rv.this.n();
                }
            });
        }
    }

    public void n() {
        if (this.qg == null || this.oa == null) {
            return;
        }
        if (this.tj == null) {
            this.tj = new com.byazt.wg.qg(this.qg, this.oa, this.d, true, com.byazt.imu.s.n());
            com.byazt.yo.s.n(this.qg, TTDelegateActivity.n, this.tj);
        }
        this.tj.n();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        getWindow().getAttributes().height = com.byazt.okk.s.w(this.qg) - com.byazt.okk.s.s(this.qg, 50.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void qg() {
        s();
        if (this.fs != null && TTDelegateActivity.n != null && !TextUtils.isEmpty(TTDelegateActivity.n.E_())) {
            this.fs.setText(TTDelegateActivity.n.E_());
        }
        com.byazt.dho.n.n(this.qg).n(false).qg(false).n(this.n);
        this.n.setWebViewClient(new com.byazt.dho.s(this.qg, null, 0 == true ? 1 : 0) { // from class: com.byazt.mr.rv.4
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
                    rv.s(rv.this);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.byazt.dho.s
            public boolean n(WebView webView, WebResourceRequest webResourceRequest) {
                this.fs = rv.q;
                return super.n(webView, webResourceRequest);
            }

            @Override // com.byazt.dho.s
            public boolean n(WebView webView, String str) {
                this.fs = rv.q;
                return super.n(webView, str);
            }
        });
        this.n.setJavaScriptEnabled(true);
        this.n.setDisplayZoomControls(false);
        this.n.setCacheMode(2);
        this.n.loadUrl("https://phoniex.toutiao.com");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        q.set(0);
        n nVar = this.s;
        if (nVar != null) {
            nVar.n(this);
        }
    }

    public rv n(n nVar) {
        this.s = nVar;
        return this;
    }
}
