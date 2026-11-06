package com.bytedance.sdk.openadsdk.core.widget;

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
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends AlertDialog {
    protected static volatile AtomicInteger d = new AtomicInteger(0);
    private ImageView ab;
    protected ms ah;
    private FrameLayout ao;
    private ImageView c;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.ms ch;
    private int h;
    private Intent hi;
    private LinearLayout ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected SSWebView f3733ms;
    private TextView ny;
    private String sl;
    private TTViewStub u;
    private TTViewStub ub;
    private TextView x;
    protected Context xr;
    private com.bytedance.sdk.openadsdk.core.dislike.ah.xr zb;

    public interface ms {
        void ms(Dialog dialog);
    }

    static /* synthetic */ int ah(ny nyVar) {
        int i = nyVar.h;
        nyVar.h = i + 1;
        return i;
    }

    static /* synthetic */ int xr(ny nyVar) {
        int i = nyVar.h;
        nyVar.h = i - 1;
        return i;
    }

    public ny(Context context, Intent intent) {
        super(context, t.ab(context, "tt_dialog_full"));
        this.h = 0;
        this.xr = context;
        this.hi = intent;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().clearFlags(131072);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.xr);
        this.ka = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.ka.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.ka.setOrientation(1);
        this.f3733ms = new SSWebView(this.xr);
        if (this.hi != null && TTDelegateActivity.f1894ms != null) {
            this.zb = TTDelegateActivity.f1894ms.ca();
            this.sl = this.hi.getStringExtra("event_tag");
        }
        setContentView(com.bytedance.sdk.openadsdk.res.ka.f(this.xr));
        xr();
    }

    private void ah() {
        TTViewStub tTViewStub;
        this.ao = (FrameLayout) findViewById(2114387640);
        this.u = (TTViewStub) findViewById(2114387776);
        this.ub = (TTViewStub) findViewById(2114387798);
        this.ao.addView(this.f3733ms, new LinearLayout.LayoutParams(-1, -1));
        int iOp = com.bytedance.sdk.openadsdk.core.ch.ub().op();
        if (iOp == 0) {
            TTViewStub tTViewStub2 = this.u;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
        } else if (iOp == 1 && (tTViewStub = this.ub) != null) {
            tTViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2114387711);
        this.c = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ny.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ny.d.set(0);
                    if (ny.this.f3733ms != null && ny.this.f3733ms.canGoBack() && ny.this.h > 1) {
                        ny.this.f3733ms.goBack();
                        ny.xr(ny.this);
                    } else {
                        ny.this.dismiss();
                        if (ny.this.ah != null) {
                            ny.this.ah.ms(ny.this);
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387710);
        this.ab = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ny.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ny.d.set(0);
                    ny.this.dismiss();
                    if (ny.this.ah != null) {
                        ny.this.ah.ms(ny.this);
                    }
                }
            });
        }
        this.x = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387633);
        this.ny = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ny.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ny.this.ms();
                }
            });
        }
    }

    protected void ms() {
        if (this.xr == null || this.zb == null) {
            return;
        }
        if (this.ch == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.ms(this.xr, this.zb, this.sl, true);
            this.ch = msVar;
            com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.xr, msVar, TTDelegateActivity.f1894ms);
        }
        this.ch.ms();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        getWindow().getAttributes().height = ul.ka(this.xr) - ul.ah(this.xr, 50.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void xr() {
        ah();
        if (this.x != null && TTDelegateActivity.f1894ms != null && !TextUtils.isEmpty(TTDelegateActivity.f1894ms.eh())) {
            this.x.setText(TTDelegateActivity.f1894ms.eh());
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.xr.ms(this.xr).ms(false).xr(false).ms(this.f3733ms);
        this.f3733ms.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.xr, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.ny.4
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
                    ny.ah(ny.this);
                    return true;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            protected boolean ms(WebView webView, WebResourceRequest webResourceRequest) {
                this.x = ny.d;
                return super.ms(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            public boolean ms(WebView webView, String str) {
                this.x = ny.d;
                return super.ms(webView, str);
            }
        });
        this.f3733ms.setJavaScriptEnabled(true);
        this.f3733ms.setDisplayZoomControls(false);
        this.f3733ms.setCacheMode(2);
        this.f3733ms.loadUrl("https://phoniex.toutiao.com");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        d.set(0);
        ms msVar = this.ah;
        if (msVar != null) {
            msVar.ms(this);
        }
    }

    public ny ms(ms msVar) {
        this.ah = msVar;
        return this;
    }
}
