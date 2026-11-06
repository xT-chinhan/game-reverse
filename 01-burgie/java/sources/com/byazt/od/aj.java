package com.byazt.od;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bumptech.glide.load.Key;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.mg.PluginConstants;
import com.byazt.ol.TTDownloadField;
import com.byazt.sd.e;
import com.byazt.sd.iu;
import com.byazt.sd.nl;
import com.byazt.wt.cz;
import com.byazt.wt.er;
import com.byazt.wt.ls;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 61})
@com.byazt.qa.hw
public class aj implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "is_reward")
    public boolean a;

    @com.byazt.qa.pr(hw = "ALL", pr = "orientation")
    public int b;
    public com.byazt.pj.zo c;

    @com.byazt.qa.pr(hw = "ALL", pr = "extra_map")
    public Map<String, Object> cz;
    public double e;

    @com.byazt.qa.pr(hw = "ALL", pr = "download_listener")
    public DownloadListener fo;
    public com.byazt.lz.x fw;

    @com.byazt.qa.pr(hw = "ALL", pr = "action_type")
    public int gz;

    @com.byazt.qa.pr(hw = "ALL", pr = "end_card_width")
    public int iu;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of lb;
    public boolean ls;
    public double n;

    @com.byazt.qa.pr(hw = "ALL", pr = "close_button")
    public View ny;

    @com.byazt.qa.pr(hw = "ALL", pr = TTDownloadField.TT_ACTIVITY)
    public TTBaseVideoActivity pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "event_tag")
    public String qa;

    @com.byazt.qa.pr(hw = "ALL", pr = "show_type")
    public int rc;
    public String s;
    public String uc;

    @com.byazt.qa.pr(hw = "ALL", pr = "end_card_height")
    public int ve;
    public double ww;
    public nl x;
    public double y;

    @com.byazt.qa.pr(hw = "ALL", pr = "web_view")
    public WeakReference<SSWebView> yb;

    @com.byazt.qa.pr(hw = "ALL", pr = "end_card_param")
    public com.byazt.el.pr z;
    public com.byazt.pj.hn zo;
    public final Map<String, Bitmap> nl = new HashMap();
    public int hw = 0;
    public int hn = 0;
    public int aj = 0;
    public String vk = "";
    public boolean w = false;
    public boolean k = false;
    public final AtomicBoolean m = new AtomicBoolean(true);
    public Handler er = new Handler(Looper.myLooper()) { // from class: com.byazt.od.aj.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    aj.this.m();
                    break;
                case 2:
                    aj.this.c();
                    break;
                case 3:
                    aj.this.fw();
                    break;
                case 4:
                    aj.this.zo();
                    break;
                case 5:
                    aj.this.aj();
                    break;
                case 6:
                    aj.this.vk();
                    break;
                case 7:
                    aj.this.w();
                    break;
                case 8:
                    aj.this.k();
                    break;
                case 9:
                    aj.this.g();
                    break;
                case 10:
                    aj.this.ho();
                    break;
                case 11:
                    aj.this.nt();
                    break;
                case 12:
                    aj.this.yb();
                    break;
                case 13:
                    aj.this.lb();
                    break;
                case 14:
                    aj.this.qa();
                    break;
            }
        }
    };
    public AtomicBoolean g = new AtomicBoolean(false);
    public com.byazt.ap.pr ho = new com.byazt.ap.pr() { // from class: com.byazt.od.aj.6
        @Override // com.byazt.ap.pr
        public int pr() {
            SSWebView sSWebView;
            int measuredHeight;
            if (aj.this.yb != null) {
                sSWebView = (SSWebView) aj.this.yb.get();
            } else {
                sSWebView = null;
            }
            if (sSWebView == null) {
                measuredHeight = -1;
            } else {
                measuredHeight = sSWebView.getMeasuredHeight();
            }
            if (measuredHeight <= 0) {
                return er.uc((Context) aj.this.pr);
            }
            return measuredHeight;
        }

        @Override // com.byazt.ap.pr
        public int hw() {
            SSWebView sSWebView;
            int measuredWidth;
            if (aj.this.yb != null) {
                sSWebView = (SSWebView) aj.this.yb.get();
            } else {
                sSWebView = null;
            }
            if (sSWebView == null) {
                measuredWidth = -1;
            } else {
                measuredWidth = sSWebView.getMeasuredWidth();
            }
            if (measuredWidth <= 0) {
                return er.c((Context) aj.this.pr);
            }
            return measuredWidth;
        }
    };
    public com.byazt.ap.fw nt = new com.byazt.ap.fw() { // from class: com.byazt.od.aj.7
        @Override // com.byazt.ap.fw
        public void pr() {
            SSWebView sSWebView;
            if (aj.this.yb != null) {
                sSWebView = (SSWebView) aj.this.yb.get();
            } else {
                sSWebView = null;
            }
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.byazt.ap.fw
        public void hw() {
            SSWebView sSWebView;
            if (aj.this.yb != null) {
                sSWebView = (SSWebView) aj.this.yb.get();
            } else {
                sSWebView = null;
            }
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };
    public final com.byazt.ap.hw v = new com.byazt.ap.hw() { // from class: com.byazt.od.aj.8
        @Override // com.byazt.ap.hw
        public void pr(boolean z, int i, String str) {
            if (z) {
                aj.this.k = true;
                if (aj.this.ls) {
                    aj ajVar = aj.this;
                    ajVar.pr(ajVar.y, aj.this.ww, aj.this.n, aj.this.e, aj.this.s);
                    aj.this.ls = false;
                }
            }
            if (qv.w(aj.this.lb)) {
                aj.this.pr(z, i, str);
            }
        }
    };
    public final com.byazt.oy.pr qi = new com.byazt.oy.pr() { // from class: com.byazt.od.aj.9
        @Override // com.byazt.oy.pr
        public void pr() {
            aj.this.pr.zo(1);
        }
    };

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        if (this.gz != 0) {
            uc();
            return true;
        }
        pr();
        hw();
        hn();
        a();
        return true;
    }

    private void a() {
        com.byazt.el.pr prVar = this.z;
        if (prVar == null) {
            return;
        }
        prVar.pr(new com.byazt.el.pr() { // from class: com.byazt.od.aj.10
        });
    }

    public void pr(boolean z, int i, String str) {
        com.byazt.pj.zo zoVar = this.c;
        if (zoVar == null) {
            return;
        }
        if (z) {
            zoVar.hw();
        } else {
            zoVar.pr(i, str);
        }
    }

    public void pr() {
        final SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.od.aj.11
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
                    aj.this.pr(measuredWidth, measuredHeight);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, int i2) {
        if (this.x == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.x.hw("resize", jSONObject);
        } catch (Exception e) {
        }
    }

    public void hw() {
        SSWebView sSWebView;
        String str;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.byazt.pj.zo zoVar = new com.byazt.pj.zo(this.qa, this.lb, jSONObject, null);
        this.c = zoVar;
        zoVar.pr(jSONObject, "webview_source", (Object) 2);
        com.byazt.pj.hn hnVarHw = new com.byazt.pj.hn(this.lb, sSWebView).hw(true);
        this.zo = hnVarHw;
        hnVarHw.pr(true);
        cz();
        com.byazt.pj.hn hnVar = this.zo;
        if (x()) {
            str = "landingpage_endcard";
        } else {
            str = this.a ? "reward_endcard" : "fullscreen_endcard";
        }
        hnVar.pr(str);
        nl nlVar = new nl(this.pr) { // from class: com.byazt.od.aj.12
        };
        this.x = nlVar;
        nlVar.hw(sSWebView).pr(this.lb).hw(this.lb.x()).x(this.lb.B_()).hn(this.a ? 7 : 5).pr(this.ho).c(ls.a(this.lb)).pr(sSWebView).hw(com.byazt.ri.c.pr(this.lb)).pr(this.c).pr(this.qa).pr(this.cz).pr(this.nt).pr(this.ny).pr(this.qi);
        this.x.pr(this.v);
    }

    private void cz() {
        this.uc = qv.aj(this.lb);
        float fOq = this.lb.oq();
        if (!TextUtils.isEmpty(this.uc)) {
            if (this.b == 1) {
                if (this.uc.contains("?")) {
                    this.uc += "&orientation=portrait";
                } else {
                    this.uc += "?orientation=portrait";
                }
            }
            if (this.uc.contains("?")) {
                this.uc += "&height=" + this.ve + "&width=" + this.iu + "&aspect_ratio=" + fOq;
            } else {
                this.uc += "?height=" + this.ve + "&width=" + this.iu + "&aspect_ratio=" + fOq;
            }
            this.uc = com.byazt.hf.pr.pr(this.uc);
        }
    }

    public void hn() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.byazt.lz.x xVar = new com.byazt.lz.x(this.pr, this.x, this.lb.x(), this.zo) { // from class: com.byazt.od.aj.13
            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponsePr = aj.this.pr(str);
                if (webResourceResponsePr != null) {
                    return webResourceResponsePr;
                }
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (aj.this.lb != null) {
                        WebResourceResponse webResourceResponsePr = aj.this.pr(string);
                        if (webResourceResponsePr != null) {
                            return webResourceResponsePr;
                        }
                        if (TextUtils.isEmpty(aj.this.lb.hn())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        aj.this.hw++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                aj.this.m.set(false);
                aj.this.aj = i;
                aj.this.vk = str;
                if (aj.this.c != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        }
                        aj.this.c.hw(jSONObject);
                    } catch (JSONException e) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    aj.this.m.set(false);
                }
                if (aj.this.c != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, webResourceError.getErrorCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                        }
                        aj.this.c.hw(jSONObject);
                    } catch (JSONException e) {
                    }
                }
                aj.this.aj = webResourceError.getErrorCode();
                aj.this.vk = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (aj.this.c != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 21) {
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, webResourceResponse.getStatusCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        }
                        aj.this.c.hw(jSONObject);
                    } catch (JSONException e) {
                    }
                }
                if (aj.this.uc.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        aj.this.m.set(false);
                    }
                    if (webResourceResponse != null) {
                        aj.this.aj = webResourceResponse.getStatusCode();
                        aj.this.vk = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (aj.this.c != null) {
                    aj.this.c.fw();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (aj.this.c != null) {
                    aj.this.c.uc();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.fw = xVar;
        sSWebView.setWebViewClient(xVar);
        pr(sSWebView);
        sSWebView.setBackgroundColor(-1);
        sSWebView.setDisplayZoomControls(false);
        sSWebView.setWebChromeClient(new com.byazt.lz.hn(this.x, this.zo) { // from class: com.byazt.od.aj.2
            @Override // com.byazt.lz.hn, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        sSWebView.setDownloadListener(this.fo);
    }

    public void pr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.byazt.lz.hw.pr(this.pr).pr(false).hw(false).pr(sSWebView);
        cz.pr(sSWebView, iu.x, of.c(this.lb));
        er.pr((com.byazt.son.x) sSWebView);
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.setMixedContentMode(0);
        }
    }

    public boolean x() {
        String str = this.uc;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception e) {
            return false;
        }
    }

    public void c() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || this.w) {
            return;
        }
        sSWebView.loadUrl(this.uc);
        this.w = true;
    }

    public void uc() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        er.pr((View) sSWebView, 0);
        if (this.rc == 1) {
            er.pr((View) sSWebView, 0.0f);
        }
        if (this.rc == 2) {
            ny();
        }
        nl nlVar = this.x;
        if (nlVar != null) {
            nlVar.pr(ls.a(this.lb), false);
        }
        pr(true);
        hw(true);
        pr(false, true);
    }

    public void pr(boolean z) {
        if (this.x == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.x.hw("viewableChange", jSONObject);
        } catch (Exception e) {
        }
    }

    public void pr(boolean z, boolean z2) {
        if (this.x == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.x.hw("endcard_control_event", jSONObject);
        } catch (Exception e) {
        }
    }

    public void hw(boolean z) {
        if (this.x == null || this.pr.isFinishing()) {
            return;
        }
        try {
            this.x.uc(z);
        } catch (Exception e) {
        }
    }

    private void ny() {
        WeakReference<SSWebView> weakReference;
        if (this.g.getAndSet(true) || (weakReference = this.yb) == null) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(weakReference.get(), "translationY", er.uc((Context) this.pr), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.od.aj.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    aj.this.g.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable th) {
        }
    }

    public void pr(double d, double d2, double d3, double d4, String str) {
        if (this.x == null || this.pr.isFinishing()) {
            return;
        }
        if (!this.k) {
            this.y = d;
            this.ww = d2;
            this.e = d4;
            this.n = d3;
            this.s = str;
            this.ls = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.x.hw("endcardTransform", jSONObject);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse pr(String str) {
        if (str.startsWith("csjclientimg://")) {
            Bitmap bitmap = this.nl.get(str.replace("csjclientimg://", ""));
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return new WebResourceResponse("text/html", Key.STRING_CHARSET_NAME, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            }
            return null;
        }
        return null;
    }

    public void fw() {
        com.byazt.pj.hn hnVar = this.zo;
        if (hnVar != null) {
            hnVar.pr(System.currentTimeMillis());
        }
    }

    public void zo() {
        if (this.pr.bm() instanceof com.byazt.lu.zo) {
            fo();
            return;
        }
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null) {
            return;
        }
        er.pr((View) weakReference.get(), 8);
    }

    private void fo() {
        WeakReference<SSWebView> weakReference;
        final SSWebView sSWebView;
        if (this.g.getAndSet(true) || (weakReference = this.yb) == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(sSWebView, "translationY", 0.0f, er.uc((Context) this.pr));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.od.aj.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                er.pr((View) sSWebView, 8);
                aj.this.g.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void aj() {
        this.c = null;
    }

    public void vk() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null) {
            sSWebView = null;
        } else {
            sSWebView = weakReference.get();
        }
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        nl nlVar = this.x;
        if (nlVar != null) {
            nlVar.gz();
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.x.uc(true);
                    pr(true);
                    pr(false, true);
                } else {
                    this.x.uc(false);
                    pr(false);
                    pr(true, false);
                }
            }
        }
        com.byazt.pj.hn hnVar = this.zo;
        if (hnVar != null) {
            hnVar.x();
        }
        com.byazt.lz.x xVar = this.fw;
        if (xVar != null) {
            xVar.hw(false);
        }
    }

    public void w() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null) {
            sSWebView = null;
        } else {
            sSWebView = weakReference.get();
        }
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        nl nlVar = this.x;
        if (nlVar != null) {
            nlVar.nl();
            this.x.uc(false);
            pr(false);
            pr(true, false);
        }
        com.byazt.lz.x xVar = this.fw;
        if (xVar != null) {
            xVar.hn();
        }
    }

    public void k() {
        com.byazt.pj.hn hnVar = this.zo;
        if (hnVar != null) {
            hnVar.c();
        }
    }

    public void m() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null) {
            sSWebView = null;
        } else {
            sSWebView = weakReference.get();
        }
        if (sSWebView != null) {
            e.pr(this.pr, sSWebView);
            e.pr(sSWebView);
            sSWebView.destroy();
        }
        WeakReference<SSWebView> weakReference2 = this.yb;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        nl nlVar = this.x;
        if (nlVar != null) {
            nlVar.y();
        }
        com.byazt.pj.zo zoVar = this.c;
        if (zoVar != null) {
            zoVar.pr(true);
            this.c.nt();
        }
        com.byazt.pj.hn hnVar = this.zo;
        if (hnVar != null) {
            hnVar.uc();
        }
        this.nl.clear();
    }

    public void g() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.onResume();
        sSWebView.resumeTimers();
        er.pr((View) sSWebView, 1.0f);
        rc();
    }

    private void rc() {
        nl nlVar = this.x;
        if (nlVar == null) {
            return;
        }
        nlVar.pr(new SSWebView.hw() { // from class: com.byazt.od.aj.5
            @Override // com.byazt.fj.SSWebView.hw
            public void pr(int i) {
                if (aj.this.x != null) {
                    aj.this.x.pr(i);
                }
            }
        });
    }

    public void ho() {
        com.byazt.pj.zo zoVar = this.c;
        if (zoVar != null) {
            zoVar.aj();
        }
    }

    public void nt() {
        com.byazt.pj.zo zoVar = this.c;
        if (zoVar != null) {
            zoVar.w();
        }
    }

    public void yb() {
        com.byazt.pj.zo zoVar = this.c;
        if (zoVar != null) {
            zoVar.k();
        }
    }

    public void lb() {
        com.byazt.pj.zo zoVar = this.c;
        if (zoVar != null) {
            zoVar.hn();
            this.c.x();
        }
    }

    public void qa() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.yb;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.loadUrl("about:blank");
    }
}
