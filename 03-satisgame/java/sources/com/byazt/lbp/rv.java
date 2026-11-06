package com.byazt.lbp;

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
import androidx.core.app.NotificationCompat;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "is_reward", qg = "ALL")
    public boolean a;
    public String ae;
    public double an;

    @com.byazt.phr.n(n = "action_type", qg = "ALL")
    public int bb;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk cd;
    public boolean f;
    public com.byazt.hm.s fs;

    @com.byazt.phr.n(n = "orientation", qg = "ALL")
    public int h;

    @com.byazt.phr.n(n = "web_view", qg = "ALL")
    public WeakReference<SSWebView> hd;

    @com.byazt.phr.n(n = "end_card_param", qg = "ALL")
    public com.byazt.in.n hu;
    public double j;
    public com.byazt.vgn.w l;
    public double lh;

    @com.byazt.phr.n(n = "show_type", qg = "ALL")
    public int m;

    @com.byazt.phr.n(n = "activity", qg = "ALL")
    public TTBaseVideoActivity n;

    @com.byazt.phr.n(n = com.anythink.core.common.k.aN, qg = "ALL")
    public View ou;

    @com.byazt.phr.n(n = "extra_map", qg = "ALL")
    public Map<String, Object> py;
    public com.byazt.gcl.s q;

    @com.byazt.phr.n(n = "end_card_width", qg = "ALL")
    public int t;

    @com.byazt.phr.n(n = "event_tag", qg = "ALL")
    public String um;

    @com.byazt.phr.n(n = "end_card_height", qg = "ALL")
    public int ur;
    public double v;
    public String w;

    @com.byazt.phr.n(n = "download_listener", qg = "ALL")
    public DownloadListener wm;
    public com.byazt.dho.s x;
    public final Map<String, Bitmap> ln = new HashMap();
    public int qg = 0;
    public int s = 0;
    public int rv = 0;
    public String tj = "";
    public boolean cp = false;
    public boolean d = false;
    public final AtomicBoolean oa = new AtomicBoolean(true);
    public Handler fi = new Handler(Looper.myLooper()) { // from class: com.byazt.lbp.rv.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    rv.this.oa();
                    break;
                case 2:
                    rv.this.l();
                    break;
                case 3:
                    rv.this.x();
                    break;
                case 4:
                    rv.this.fs();
                    break;
                case 5:
                    rv.this.rv();
                    break;
                case 6:
                    rv.this.tj();
                    break;
                case 7:
                    rv.this.cp();
                    break;
                case 8:
                    rv.this.d();
                    break;
                case 9:
                    rv.this.sz();
                    break;
                case 10:
                    rv.this.k();
                    break;
                case 11:
                    rv.this.cy();
                    break;
                case 12:
                    rv.this.hd();
                    break;
                case 13:
                    rv.this.cd();
                    break;
                case 14:
                    rv.this.um();
                    break;
            }
        }
    };
    public AtomicBoolean sz = new AtomicBoolean(false);
    public com.byazt.uv.n k = new com.byazt.uv.n() { // from class: com.byazt.lbp.rv.6
        @Override // com.byazt.uv.n
        public int n() {
            SSWebView sSWebView = rv.this.hd != null ? (SSWebView) rv.this.hd.get() : null;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? com.byazt.okk.s.w((Context) rv.this.n) : measuredHeight;
        }

        @Override // com.byazt.uv.n
        public int qg() {
            SSWebView sSWebView = rv.this.hd != null ? (SSWebView) rv.this.hd.get() : null;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? com.byazt.okk.s.l((Context) rv.this.n) : measuredWidth;
        }
    };
    public com.byazt.uv.fs cy = new com.byazt.uv.fs() { // from class: com.byazt.lbp.rv.7
        @Override // com.byazt.uv.fs
        public void n() {
            SSWebView sSWebView = rv.this.hd != null ? (SSWebView) rv.this.hd.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.byazt.uv.fs
        public void qg() {
            SSWebView sSWebView = rv.this.hd != null ? (SSWebView) rv.this.hd.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };
    public final com.byazt.uv.qg df = new com.byazt.uv.qg() { // from class: com.byazt.lbp.rv.8
        @Override // com.byazt.uv.qg
        public void n(boolean z, int i, String str) {
            if (z) {
                rv.this.d = true;
                if (rv.this.f) {
                    rv rvVar = rv.this;
                    rvVar.n(rvVar.lh, rv.this.v, rv.this.j, rv.this.an, rv.this.ae);
                    rv.this.f = false;
                }
            }
            if (ta.cp(rv.this.cd)) {
                rv.this.n(z, i, str);
            }
        }
    };
    public final com.byazt.uv.l oj = new com.byazt.uv.l() { // from class: com.byazt.lbp.rv.9
        @Override // com.byazt.uv.l
        public void n() {
            rv.this.n.fs(1);
        }
    };

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        if (this.bb != 0) {
            w();
            return true;
        }
        n();
        qg();
        s();
        a();
        return true;
    }

    private void a() {
        com.byazt.in.n nVar = this.hu;
        if (nVar == null) {
            return;
        }
        nVar.n(new com.byazt.in.n() { // from class: com.byazt.lbp.rv.10
        });
    }

    public void n(boolean z, int i, String str) {
        com.byazt.vgn.w wVar = this.l;
        if (wVar == null) {
            return;
        }
        if (z) {
            wVar.l();
        } else {
            wVar.s(i, str);
        }
    }

    public void n() {
        final SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.hd;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.lbp.rv.11
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
                    rv.this.n(measuredWidth, measuredHeight);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2) {
        if (this.q == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.q.qg("resize", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void qg() {
        SSWebView sSWebView;
        String str;
        WeakReference<SSWebView> weakReference = this.hd;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.byazt.vgn.w wVar = new com.byazt.vgn.w(this.um, this.cd, jSONObject, null);
        this.l = wVar;
        wVar.n(jSONObject, "webview_source", (Object) 2);
        com.byazt.hm.s sVarQg = new com.byazt.hm.s(this.cd, sSWebView).qg(true);
        this.fs = sVarQg;
        sVarQg.n(true);
        py();
        com.byazt.hm.s sVar = this.fs;
        if (q()) {
            str = "landingpage_endcard";
        } else {
            str = this.a ? "reward_endcard" : "fullscreen_endcard";
        }
        sVar.n(str);
        com.byazt.gcl.s sVar2 = new com.byazt.gcl.s(this.n) { // from class: com.byazt.lbp.rv.12
        };
        this.q = sVar2;
        sVar2.qg(sSWebView).n(this.cd).qg(this.cd.q()).q(this.cd.F_()).s(this.a ? 7 : 5).n(this.k).l(com.byazt.vgx.w.wm(this.cd)).n(sSWebView).qg(com.byazt.oh.l.n(this.cd)).n(this.l).n(this.um).n(this.py).n(this.cy).n(this.ou).n(this.oj);
        this.q.n(this.df);
    }

    private void py() {
        this.w = ta.rv(this.cd);
        float fSl = this.cd.sl();
        if (TextUtils.isEmpty(this.w)) {
            return;
        }
        if (this.h == 1) {
            if (this.w.contains("?")) {
                this.w += "&orientation=portrait";
            } else {
                this.w += "?orientation=portrait";
            }
        }
        if (this.w.contains("?")) {
            this.w += "&height=" + this.ur + "&width=" + this.t + "&aspect_ratio=" + fSl;
        } else {
            this.w += "?height=" + this.ur + "&width=" + this.t + "&aspect_ratio=" + fSl;
        }
        this.w = com.byazt.ce.n.n(this.w);
    }

    public void s() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.hd;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.byazt.dho.s sVar = new com.byazt.dho.s(this.n, this.q, this.cd.q(), this.fs) { // from class: com.byazt.lbp.rv.13
            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseN = rv.this.n(str);
                return webResourceResponseN != null ? webResourceResponseN : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (rv.this.cd != null) {
                        WebResourceResponse webResourceResponseN = rv.this.n(string);
                        if (webResourceResponseN != null) {
                            return webResourceResponseN;
                        }
                        if (TextUtils.isEmpty(rv.this.cd.s())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        rv.this.qg++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                rv.this.oa.set(false);
                rv.this.rv = i;
                rv.this.tj = str;
                if (rv.this.l != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        rv.this.l.q(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    rv.this.oa.set(false);
                }
                if (rv.this.l != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceError.getErrorCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                        rv.this.l.q(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                rv.this.rv = webResourceError.getErrorCode();
                rv.this.tj = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (rv.this.l != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        rv.this.l.q(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (rv.this.w.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        rv.this.oa.set(false);
                    }
                    if (webResourceResponse != null) {
                        rv.this.rv = webResourceResponse.getStatusCode();
                        rv.this.tj = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (rv.this.l != null) {
                    rv.this.l.tj();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (rv.this.l != null) {
                    rv.this.l.rv();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.x = sVar;
        sSWebView.setWebViewClient(sVar);
        n(sSWebView);
        sSWebView.setBackgroundColor(-1);
        sSWebView.setDisplayZoomControls(false);
        sSWebView.setWebChromeClient(new com.byazt.dho.qg(this.q, this.fs) { // from class: com.byazt.lbp.rv.2
            @Override // com.byazt.dho.qg, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        sSWebView.setDownloadListener(this.wm);
    }

    public void n(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.byazt.dho.n.n(this.n).n(false).qg(false).n(sSWebView);
        com.byazt.qq.n.n(sSWebView, com.byazt.nf.tj.l, pk.l(this.cd));
        com.byazt.okk.s.n((com.byazt.uad.q) sSWebView);
        sSWebView.setMixedContentMode(0);
    }

    public boolean q() {
        String str = this.w;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void l() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.hd;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || this.cp) {
            return;
        }
        sSWebView.loadUrl(this.w);
        this.cp = true;
    }

    public void w() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.hd;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.byazt.okk.s.n((View) sSWebView, 0);
        if (this.m == 1) {
            com.byazt.okk.s.n((View) sSWebView, 0.0f);
        }
        if (this.m == 2) {
            ou();
        }
        com.byazt.gcl.s sVar = this.q;
        if (sVar != null) {
            sVar.n(com.byazt.vgx.w.wm(this.cd), false);
        }
        n(true);
        qg(true);
        n(false, true);
    }

    public void n(boolean z) {
        if (this.q == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.q.qg("viewableChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.q == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.q.qg("endcard_control_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void qg(boolean z) {
        if (this.q == null || this.n.isFinishing()) {
            return;
        }
        try {
            this.q.w(z);
        } catch (Exception unused) {
        }
    }

    private void ou() {
        WeakReference<SSWebView> weakReference;
        if (this.sz.getAndSet(true) || (weakReference = this.hd) == null) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(weakReference.get(), "translationY", com.byazt.okk.s.w((Context) this.n), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.lbp.rv.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    rv.this.sz.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable unused) {
        }
    }

    public void n(double d, double d2, double d3, double d4, String str) {
        if (this.q == null || this.n.isFinishing()) {
            return;
        }
        if (!this.d) {
            this.lh = d;
            this.v = d2;
            this.an = d4;
            this.j = d3;
            this.ae = str;
            this.f = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.byazt.af.x.n, d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.q.qg("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse n(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.ln.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    public void x() {
        com.byazt.hm.s sVar = this.fs;
        if (sVar != null) {
            sVar.n(System.currentTimeMillis());
        }
    }

    public void fs() {
        if (this.n.nf() instanceof com.byazt.has.fs) {
            wm();
            return;
        }
        WeakReference<SSWebView> weakReference = this.hd;
        if (weakReference == null) {
            return;
        }
        com.byazt.okk.s.n((View) weakReference.get(), 8);
    }

    private void wm() {
        WeakReference<SSWebView> weakReference;
        final SSWebView sSWebView;
        if (this.sz.getAndSet(true) || (weakReference = this.hd) == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(sSWebView, "translationY", 0.0f, com.byazt.okk.s.w((Context) this.n));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.lbp.rv.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.byazt.okk.s.n((View) sSWebView, 8);
                rv.this.sz.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void rv() {
        this.l = null;
    }

    public void tj() {
        WeakReference<SSWebView> weakReference = this.hd;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        com.byazt.gcl.s sVar = this.q;
        if (sVar != null) {
            sVar.bb();
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.q.w(true);
                    n(true);
                    n(false, true);
                } else {
                    this.q.w(false);
                    n(false);
                    n(true, false);
                }
            }
        }
        com.byazt.hm.s sVar2 = this.fs;
        if (sVar2 != null) {
            sVar2.q();
        }
        com.byazt.dho.s sVar3 = this.x;
        if (sVar3 != null) {
            sVar3.qg(false);
        }
    }

    public void cp() {
        WeakReference<SSWebView> weakReference = this.hd;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        com.byazt.gcl.s sVar = this.q;
        if (sVar != null) {
            sVar.ln();
            this.q.w(false);
            n(false);
            n(true, false);
        }
        com.byazt.dho.s sVar2 = this.x;
        if (sVar2 != null) {
            sVar2.s();
        }
    }

    public void d() {
        com.byazt.hm.s sVar = this.fs;
        if (sVar != null) {
            sVar.l();
        }
    }

    public void oa() {
        WeakReference<SSWebView> weakReference = this.hd;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            com.byazt.gcl.q.n(this.n, sSWebView);
            com.byazt.gcl.q.n(sSWebView);
            sSWebView.destroy();
        }
        WeakReference<SSWebView> weakReference2 = this.hd;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        com.byazt.gcl.s sVar = this.q;
        if (sVar != null) {
            sVar.lh();
        }
        com.byazt.vgn.w wVar = this.l;
        if (wVar != null) {
            wVar.n(true);
            this.l.fs();
        }
        com.byazt.hm.s sVar2 = this.fs;
        if (sVar2 != null) {
            sVar2.w();
        }
        this.ln.clear();
    }

    public void sz() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.hd;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.onResume();
        sSWebView.resumeTimers();
        com.byazt.okk.s.n((View) sSWebView, 1.0f);
        m();
    }

    private void m() {
        com.byazt.gcl.s sVar = this.q;
        if (sVar == null) {
            return;
        }
        sVar.n(new SSWebView.qg() { // from class: com.byazt.lbp.rv.5
            @Override // com.byazt.kfh.SSWebView.qg
            public void n(int i) {
                if (rv.this.q != null) {
                    rv.this.q.n(i);
                }
            }
        });
    }

    public void k() {
        com.byazt.vgn.w wVar = this.l;
        if (wVar != null) {
            wVar.oa();
        }
    }

    public void cy() {
        com.byazt.vgn.w wVar = this.l;
        if (wVar != null) {
            wVar.k();
        }
    }

    public void hd() {
        com.byazt.vgn.w wVar = this.l;
        if (wVar != null) {
            wVar.cy();
        }
    }

    public void cd() {
        com.byazt.vgn.w wVar = this.l;
        if (wVar != null) {
            wVar.n();
            this.l.d();
        }
    }

    public void um() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.hd;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.loadUrl(com.anythink.core.common.res.d.a);
    }
}
