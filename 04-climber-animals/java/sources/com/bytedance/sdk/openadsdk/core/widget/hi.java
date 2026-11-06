package com.bytedance.sdk.openadsdk.core.widget;

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
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends AlertDialog {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected static volatile AtomicInteger f3716ms = new AtomicInteger(0);
    private String ab;
    private Context ah;
    private ms c;
    private ImageView ch;
    private TextView d;
    private ImageView hi;
    private String ka;
    private RelativeLayout ny;
    private RelativeLayout x;
    private SSWebView xr;

    public interface ms {
        void ms(Dialog dialog);
    }

    public hi(Context context, String str) {
        super(context, t.ab(context, "tt_dialog_full"));
        this.ab = str;
        this.ah = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.ka.m(this.ah));
        xr();
        ms();
    }

    protected void ms() {
        String strSi = re.xr().si();
        if (TextUtils.isEmpty(strSi)) {
            this.ka = "https://www.pangle.cn/privacy/partner";
        } else {
            this.ka = strSi;
        }
        if (TextUtils.isEmpty(this.ab)) {
            return;
        }
        if (this.ka.contains("?")) {
            this.ka += "&ad_info=" + this.ab;
        } else {
            this.ka += "?ad_info=" + this.ab;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f3716ms.set(0);
        ms msVar = this.c;
        if (msVar != null) {
            msVar.ms(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void xr() {
        this.xr = (SSWebView) findViewById(2114387769);
        TextView textView = (TextView) findViewById(2114387658);
        this.d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.hi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (hi.this.c != null) {
                    hi.this.c.ms(hi.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.xr.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.ah, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.hi.2
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
                    String lowerCase = scheme.toLowerCase(Locale.US);
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            protected boolean ms(WebView webView, WebResourceRequest webResourceRequest) {
                this.x = hi.f3716ms;
                return super.ms(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            public boolean ms(WebView webView, String str) {
                this.x = hi.f3716ms;
                return super.ms(webView, str);
            }
        });
        this.xr.setJavaScriptEnabled(true);
        this.xr.setDisplayZoomControls(false);
        this.xr.setCacheMode(2);
        this.xr.loadUrl(this.ka);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387889);
        this.x = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387900);
        this.ny = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.d.setVisibility(8);
        this.ch = (ImageView) findViewById(2114387819);
        this.hi = (ImageView) findViewById(2114387842);
        this.ch.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.hi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (hi.this.c != null) {
                    hi.this.c.ms(hi.this);
                    hi.f3716ms.set(0);
                }
            }
        });
        this.hi.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.hi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((ClipboardManager) hi.this.ah.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, hi.this.ka));
                    op.ms(hi.this.ah, "链接复制成功", 1);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                    op.ms(hi.this.ah, "链接复制失败", 1);
                }
            }
        });
    }

    public hi ms(ms msVar) {
        this.c = msVar;
        return this;
    }
}
