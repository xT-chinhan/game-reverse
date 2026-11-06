package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.anythink.core.common.k;
import com.anythink.network.tap.TapATInitManager;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.az;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class ny implements com.bytedance.sdk.component.hi.ms.ms.ah {
    protected com.bytedance.sdk.openadsdk.core.widget.ms.d ab;

    @com.bytedance.sdk.component.hi.xr.ms(ms = k.aM)
    private View b;
    protected String c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "action_type")
    private int cv;
    protected pc d;
    private String f;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "web_view")
    private WeakReference<SSWebView> h;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "show_type")
    private int i;
    private double jw;
    protected com.bytedance.sdk.openadsdk.core.zb.x ka;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "end_card_height")
    private int le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = TTDownloadField.TT_ACTIVITY)
    protected TTBaseVideoActivity f3170ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "extra_map")
    private Map<String, Object> nw;
    private double of;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "end_card_width")
    private int op;
    private double p;
    private double pc;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm qv;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "download_listener")
    private DownloadListener re;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_reward")
    private boolean t;
    private boolean ul;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "end_card_param")
    private com.bytedance.sdk.openadsdk.core.ny.ms.ah.ms w;
    com.bytedance.sdk.openadsdk.core.zb.d x;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "event_tag")
    private String y;

    @com.bytedance.sdk.component.hi.xr.ms(ms = TapATInitManager.ORIENTATION_KEY)
    private int yu;
    private final Map<String, Bitmap> g = new HashMap();
    int xr = 0;
    int ah = 0;
    int ny = 0;
    String ch = "";
    protected boolean hi = false;
    protected boolean sl = false;
    protected final AtomicBoolean zb = new AtomicBoolean(true);
    private Handler az = new Handler(Looper.myLooper()) { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    ny.this.zb();
                    break;
                case 2:
                    ny.this.ka();
                    break;
                case 3:
                    ny.this.ab();
                    break;
                case 4:
                    ny.this.x();
                    break;
                case 5:
                    ny.this.ny();
                    break;
                case 6:
                    ny.this.ch();
                    break;
                case 7:
                    ny.this.hi();
                    break;
                case 8:
                    ny.this.sl();
                    break;
                case 9:
                    ny.this.u();
                    break;
                case 10:
                    ny.this.ub();
                    break;
                case 11:
                    ny.this.ao();
                    break;
                case 12:
                    ny.this.h();
                    break;
                case 13:
                    ny.this.qv();
                    break;
                case 14:
                    ny.this.y();
                    break;
            }
        }
    };
    protected AtomicBoolean u = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.qv.ms ub = new com.bytedance.sdk.openadsdk.core.qv.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.6
        @Override // com.bytedance.sdk.openadsdk.core.qv.ms
        public int ms() {
            SSWebView sSWebView = ny.this.h != null ? (SSWebView) ny.this.h.get() : null;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? ul.ka((Context) ny.this.f3170ms) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.ms
        public int xr() {
            SSWebView sSWebView = ny.this.h != null ? (SSWebView) ny.this.h.get() : null;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? ul.d((Context) ny.this.f3170ms) : measuredWidth;
        }
    };
    protected com.bytedance.sdk.openadsdk.core.qv.c ao = new com.bytedance.sdk.openadsdk.core.qv.c() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.7
        @Override // com.bytedance.sdk.openadsdk.core.qv.c
        public void ms() {
            SSWebView sSWebView = ny.this.h != null ? (SSWebView) ny.this.h.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.c
        public void xr() {
            SSWebView sSWebView = ny.this.h != null ? (SSWebView) ny.this.h.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };
    private final com.bytedance.sdk.openadsdk.core.qv.xr m = new com.bytedance.sdk.openadsdk.core.qv.xr() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.8
        @Override // com.bytedance.sdk.openadsdk.core.qv.xr
        public void ms(boolean z, int i, String str) {
            if (z) {
                ny.this.sl = true;
                if (ny.this.ul) {
                    ny nyVar = ny.this;
                    nyVar.ms(nyVar.of, ny.this.p, ny.this.pc, ny.this.jw, ny.this.f);
                    ny.this.ul = false;
                }
            }
            if (qr.ch(ny.this.qv)) {
                ny.this.ms(z, i, str);
            }
        }
    };
    private final com.bytedance.sdk.openadsdk.ch.ms lm = new com.bytedance.sdk.openadsdk.ch.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.9
        @Override // com.bytedance.sdk.openadsdk.ch.ms
        public void ms() {
            ny.this.f3170ms.x(1);
        }
    };

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        if (this.cv != 0) {
            c();
            return true;
        }
        ms();
        xr();
        ah();
        t();
        return true;
    }

    private void t() {
        com.bytedance.sdk.openadsdk.core.ny.ms.ah.ms msVar = this.w;
        if (msVar == null) {
            return;
        }
        msVar.ms(new com.bytedance.sdk.openadsdk.core.ny.ms.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.10
        });
    }

    public void ms(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.core.zb.x xVar = this.ka;
        if (xVar == null) {
            return;
        }
        if (z) {
            xVar.xr();
        } else {
            xVar.ms(i, str);
        }
    }

    protected void ms() {
        final SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SSWebView sSWebView2 = sSWebView;
                if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                    return;
                }
                sSWebView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measuredWidth = sSWebView.getMeasuredWidth();
                int measuredHeight = sSWebView.getMeasuredHeight();
                if (sSWebView.getVisibility() == 0) {
                    ny.this.ms(measuredWidth, measuredHeight);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, int i2) {
        if (this.d == null || this.f3170ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.d.ms("resize", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public void xr() {
        SSWebView sSWebView;
        String str;
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.zb.x xVar = new com.bytedance.sdk.openadsdk.core.zb.x(this.y, this.qv, jSONObject);
        this.ka = xVar;
        xVar.ms(jSONObject, "webview_source", (Object) 2);
        com.bytedance.sdk.openadsdk.core.zb.d dVarXr = new com.bytedance.sdk.openadsdk.core.zb.d(this.qv, sSWebView).xr(true);
        this.x = dVarXr;
        dVarXr.ms(true);
        nw();
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.x;
        if (d()) {
            str = "landingpage_endcard";
        } else {
            str = this.t ? "reward_endcard" : "fullscreen_endcard";
        }
        dVar.ms(str);
        pc pcVar = new pc(this.f3170ms) { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.12
        };
        this.d = pcVar;
        pcVar.xr(sSWebView).ms(this.qv).xr(this.qv.df()).ah(this.qv.lx()).ah(this.t ? 7 : 5).ms(this.ub).d(f.ao(this.qv)).ms(sSWebView).xr(com.bytedance.sdk.openadsdk.core.hi.ah.ub.ms(this.qv)).ms(this.ka).ms(this.y).ms(this.nw).ms(this.ao).ms(this.b).ms(this.lm);
        this.d.ms(this.m);
    }

    private void nw() {
        this.c = qr.x(this.qv);
        float fLd = this.qv.ld();
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        if (this.yu == 1) {
            if (this.c.contains("?")) {
                this.c += "&orientation=portrait";
            } else {
                this.c += "?orientation=portrait";
            }
        }
        if (this.c.contains("?")) {
            this.c += "&height=" + this.le + "&width=" + this.op + "&aspect_ratio=" + fLd;
        } else {
            this.c += "?height=" + this.le + "&width=" + this.op + "&aspect_ratio=" + fLd;
        }
        this.c = com.bytedance.sdk.openadsdk.core.component.reward.ka.ms.ms(this.c);
    }

    public void ah() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.d dVar = new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.f3170ms, this.d, this.qv.df(), this.x) { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseMs = ny.this.ms(str);
                return webResourceResponseMs != null ? webResourceResponseMs : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (ny.this.qv != null) {
                        WebResourceResponse webResourceResponseMs = ny.this.ms(string);
                        if (webResourceResponseMs != null) {
                            return webResourceResponseMs;
                        }
                        if (TextUtils.isEmpty(ny.this.qv.so())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        ny.this.xr++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                ny.this.zb.set(false);
                ny.this.ny = i;
                ny.this.ch = str;
                if (ny.this.ka != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        jSONObject.put("msg", str);
                        ny.this.ka.xr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    ny.this.zb.set(false);
                }
                if (ny.this.ka != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceError.getErrorCode());
                        jSONObject.put("msg", webResourceError.getDescription());
                        ny.this.ka.xr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                ny.this.ny = webResourceError.getErrorCode();
                ny.this.ch = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (ny.this.ka != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        ny.this.ka.xr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (ny.this.c.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        ny.this.zb.set(false);
                    }
                    if (webResourceResponse != null) {
                        ny.this.ny = webResourceResponse.getStatusCode();
                        ny.this.ch = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (ny.this.ka != null) {
                    ny.this.ka.ab();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (ny.this.ka != null) {
                    ny.this.ka.c();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.ab = dVar;
        sSWebView.setWebViewClient(dVar);
        ms(sSWebView);
        sSWebView.setBackgroundColor(-1);
        sSWebView.setDisplayZoomControls(false);
        sSWebView.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.d, this.x) { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.ah, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        sSWebView.setDownloadListener(this.re);
    }

    protected void ms(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.xr.ms(this.f3170ms).ms(false).xr(false).ms(sSWebView);
        t.ms(sSWebView, g.xr, lm.d(this.qv));
        ul.ms((com.bytedance.sdk.component.zb.ah) sSWebView);
        sSWebView.setMixedContentMode(0);
    }

    protected boolean d() {
        String str = this.c;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void ka() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || this.hi) {
            return;
        }
        sSWebView.loadUrl(this.c);
        this.hi = true;
    }

    public void c() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ul.ms((View) sSWebView, 0);
        if (this.i == 1) {
            ul.ms((View) sSWebView, 0.0f);
        }
        if (this.i == 2) {
            b();
        }
        pc pcVar = this.d;
        if (pcVar != null) {
            pcVar.ms(f.ao(this.qv), false);
        }
        ms(true);
        xr(true);
        ms(false, true);
    }

    public void ms(boolean z) {
        if (this.d == null || this.f3170ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.d.ms("viewableChange", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public void ms(boolean z, boolean z2) {
        if (this.d == null || this.f3170ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.d.ms("endcard_control_event", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public void xr(boolean z) {
        if (this.d == null || this.f3170ms.isFinishing()) {
            return;
        }
        try {
            this.d.c(z);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private void b() {
        WeakReference<SSWebView> weakReference;
        if (this.u.getAndSet(true) || (weakReference = this.h) == null) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(weakReference.get(), "translationY", ul.ka((Context) this.f3170ms), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ny.this.u.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    public void ms(double d, double d2, double d3, double d4, String str) {
        if (this.d == null || this.f3170ms.isFinishing()) {
            return;
        }
        if (!this.sl) {
            this.of = d;
            this.p = d2;
            this.jw = d4;
            this.pc = d3;
            this.f = str;
            this.ul = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.d.ms("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse ms(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.g.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    public void ab() {
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.x;
        if (dVar != null) {
            dVar.ms(System.currentTimeMillis());
        }
    }

    public void x() {
        if (this.f3170ms.sa() instanceof com.bytedance.sdk.openadsdk.core.component.reward.d.ny) {
            re();
            return;
        }
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference == null) {
            return;
        }
        ul.ms((View) weakReference.get(), 8);
    }

    private void re() {
        WeakReference<SSWebView> weakReference;
        final SSWebView sSWebView;
        if (this.u.getAndSet(true) || (weakReference = this.h) == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(sSWebView, "translationY", 0.0f, ul.ka((Context) this.f3170ms));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ul.ms((View) sSWebView, 8);
                ny.this.u.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void ny() {
        this.ka = null;
    }

    public void ch() {
        WeakReference<SSWebView> weakReference = this.h;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        pc pcVar = this.d;
        if (pcVar != null) {
            pcVar.yu();
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.d.c(true);
                    ms(true);
                    ms(false, true);
                } else {
                    this.d.c(false);
                    ms(false);
                    ms(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.x;
        if (dVar != null) {
            dVar.d();
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.d dVar2 = this.ab;
        if (dVar2 != null) {
            dVar2.xr(false);
        }
    }

    public void hi() {
        WeakReference<SSWebView> weakReference = this.h;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        pc pcVar = this.d;
        if (pcVar != null) {
            pcVar.op();
            this.d.c(false);
            ms(false);
            ms(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.d dVar = this.ab;
        if (dVar != null) {
            dVar.ah();
        }
    }

    public void sl() {
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.x;
        if (dVar != null) {
            dVar.ka();
        }
    }

    public void zb() {
        WeakReference<SSWebView> weakReference = this.h;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            az.ms(this.f3170ms, sSWebView);
            az.ms(sSWebView);
            sSWebView.destroy();
        }
        WeakReference<SSWebView> weakReference2 = this.h;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        pc pcVar = this.d;
        if (pcVar != null) {
            pcVar.le();
        }
        com.bytedance.sdk.openadsdk.core.zb.x xVar = this.ka;
        if (xVar != null) {
            xVar.ms(true);
            this.ka.h();
        }
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.x;
        if (dVar != null) {
            dVar.c();
        }
        this.g.clear();
    }

    public void u() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.onResume();
        sSWebView.resumeTimers();
        ul.ms((View) sSWebView, 1.0f);
        i();
    }

    private void i() {
        pc pcVar = this.d;
        if (pcVar == null) {
            return;
        }
        pcVar.ms(new SSWebView.xr() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny.5
            @Override // com.bytedance.sdk.component.widget.SSWebView.xr
            public void ms(int i) {
                if (ny.this.d != null) {
                    ny.this.d.ms(i);
                }
            }
        });
    }

    public void ub() {
        com.bytedance.sdk.openadsdk.core.zb.x xVar = this.ka;
        if (xVar != null) {
            xVar.ny();
        }
    }

    public void ao() {
        com.bytedance.sdk.openadsdk.core.zb.x xVar = this.ka;
        if (xVar != null) {
            xVar.hi();
        }
    }

    public void h() {
        com.bytedance.sdk.openadsdk.core.zb.x xVar = this.ka;
        if (xVar != null) {
            xVar.sl();
        }
    }

    public void qv() {
        com.bytedance.sdk.openadsdk.core.zb.x xVar = this.ka;
        if (xVar != null) {
            xVar.ah();
            this.ka.d();
        }
    }

    public void y() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.loadUrl(com.anythink.core.common.res.d.a);
    }
}
