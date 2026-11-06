package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.ms.c;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.d.ny;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.zb.ka;
import com.bytedance.sdk.openadsdk.u.ab;
import com.bytedance.sdk.openadsdk.u.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms implements le.ms, com.bytedance.sdk.openadsdk.core.zb.d.xr {
    private static final ab.ms fm = new ab.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.2
        @Override // com.bytedance.sdk.openadsdk.u.ab.ms
        public void ms(String str, String str2, Throwable th) {
            sl.ah(str, str2, th);
        }
    };
    private String am;
    private PlayableEndcardFrameLayout az;
    long cv;
    private com.bytedance.sdk.openadsdk.core.multipro.xr.ms e;
    private com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.ms eg;
    private boolean f;
    private final AtomicBoolean g;
    private com.bytedance.sdk.openadsdk.core.qv.xr il;
    private x jw;
    private final ms k;
    private com.bytedance.sdk.openadsdk.core.xr.xr l;
    final le le;
    private final com.bytedance.sdk.openadsdk.core.playable.ms lm;
    private RewardLpBottomView m;
    private FrameLayout of;
    protected final AtomicBoolean op;
    private com.bytedance.sdk.openadsdk.core.ugeno.ah.ah p;
    private ka pc;
    private DownloadListener qf;
    private com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr ul;
    protected final AtomicBoolean w;
    private final com.bytedance.sdk.openadsdk.core.qv.d xn;
    protected final AtomicBoolean yu;

    public interface ms {
        void ms(WebView webView, String str);

        void ms(WebView webView, String str, Bitmap bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public String i() {
        return "playable";
    }

    public ah(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, lmVar, str, i, i2, z);
        this.w = new AtomicBoolean(false);
        this.yu = new AtomicBoolean(false);
        this.op = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.le = new le(Looper.getMainLooper(), this);
        this.cv = 0L;
        this.k = new ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.ms
            public void ms(WebView webView, String str2) {
                if (ah.this.f2177ms.sa() instanceof ny) {
                    return;
                }
                ah.this.le.removeMessages(101);
                if (ah.this.w.getAndSet(true)) {
                    return;
                }
                if (nw.ah(ah.this.xr) || ah.this.f) {
                    if (!ah.this.b()) {
                        if (ah.this.eg != null) {
                            ah.this.eg.ms();
                            return;
                        }
                        return;
                    }
                    ah.this.ms(0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.ms
            public void ms(WebView webView, String str2, Bitmap bitmap) {
                if (nw.ah(ah.this.xr)) {
                    if (ah.this.xr.vv() == 1 || t.hi(ah.this.xr)) {
                        ah.this.le.sendEmptyMessageDelayed(101, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                    }
                    if (ah.this.yu.getAndSet(true)) {
                        return;
                    }
                    ah.this.cv = System.currentTimeMillis();
                    ah.this.ul.ms();
                }
            }
        };
        this.xn = new com.bytedance.sdk.openadsdk.core.qv.d() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.3
            @Override // com.bytedance.sdk.openadsdk.core.qv.d
            public void ms() {
                ah.this.x.ny(true);
                if (t.hi(ah.this.xr)) {
                    ah.this.ul.xr();
                }
                ah.this.f2177ms.ah(0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.d
            public void xr() {
                if (qf.hi(ah.this.xr)) {
                    ah.this.f2177ms.d(3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.d
            public void ah() {
                if (!t.ms(ah.this.xr) || t.hi(ah.this.xr)) {
                    return;
                }
                ah.this.f2177ms.ms(1);
            }
        };
        this.il = new com.bytedance.sdk.openadsdk.core.qv.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.4
            @Override // com.bytedance.sdk.openadsdk.core.qv.xr
            public void ms(boolean z2, int i3, String str2) {
                if (z2) {
                    ah.this.ao = true;
                }
            }
        };
        this.ab = abstractEndCardFrameLayout.getPlayableWebView();
        this.of = (FrameLayout) this.f2177ms.findViewById(2114387925);
        this.az = (PlayableEndcardFrameLayout) this.f2177ms.findViewById(2114387681);
        this.m = (RewardLpBottomView) this.f2177ms.findViewById(2114387830);
        this.lm = new com.bytedance.sdk.openadsdk.core.playable.ms(this.ah, tTBaseVideoActivity, lmVar, nw.ah(this.xr) ? 2 : 1, tTBaseVideoActivity.sa().pc(), abstractEndCardFrameLayout.getVideoArea());
        ms();
    }

    public void ms(com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar) {
        this.e = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ms(boolean z, Map<String, Object> map, View view) {
        if (f.t(this.xr) && this.of != null) {
            ms(map, view);
        } else {
            xr(z, map, view);
        }
    }

    private void ms(final Map<String, Object> map, final View view) {
        ka kaVar = new ka(this.xr);
        this.pc = kaVar;
        kaVar.ms(true);
        this.pc.ms();
        this.of.setVisibility(0);
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ah ahVar = new com.bytedance.sdk.openadsdk.core.ugeno.ah.ah(this.f2177ms, this.of, this.pc, this.xr, this.ah, f.xr(this.ah), this.e);
        this.p = ahVar;
        ahVar.ms();
        this.p.ms(new com.bytedance.sdk.openadsdk.core.ugeno.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
            public void ms(View view2) {
                ah.this.jw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
            public void ms(int i) {
                ah.this.p = null;
                com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ah.this.of != null) {
                            ah.this.of.setVisibility(8);
                        }
                        ah.this.ub = false;
                        ah.this.xr(ah.this.d, map, view);
                        ah.this.xr(ah.this.qf, ah.this.l);
                        ah.this.qf = null;
                        ah.this.op();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw() {
        this.ao = true;
        this.op.set(true);
        this.le.sendMessage(xr(4));
        if (this.f2177ms != null) {
            this.f2177ms.sl(8);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr interfaceC0279xr = this.ul;
        if (interfaceC0279xr != null) {
            interfaceC0279xr.ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(boolean z, Map<String, Object> map, View view) {
        if (this.ab == null) {
            return;
        }
        this.sl = new com.bytedance.sdk.openadsdk.core.zb.d(this.xr, this.ab).xr(true);
        this.sl.ms(this);
        this.sl.ms(true);
        this.sl.ms(z ? "reward_endcard" : "fullscreen_endcard");
        this.x = new pc(this.f2177ms);
        this.x.xr(this.ab).ms(this.xr).xr(this.xr.df()).ah(this.xr.lx()).ah(z ? 7 : 5).ms(this.re).d(f.ao(this.xr)).ms(this.ab).xr(ub.ms(this.xr)).ms(this.ah).ms(map).ms(this.i).ms(view).ms(this.xn);
        if (!nw.ah(this.xr)) {
            this.x.x(true);
        }
        this.x.ms(this.il);
        f();
        ul();
        pc();
    }

    private void f() {
        RewardLpBottomView rewardLpBottomView;
        if (!nw.ab(this.xr)) {
            this.m = null;
            return;
        }
        if (t.d(this.xr)) {
            this.m = null;
            return;
        }
        if (!t.ka(this.xr)) {
            this.m = null;
        } else {
            if (this.az == null || (rewardLpBottomView = this.m) == null) {
                return;
            }
            rewardLpBottomView.ms(this.xr, this.ah);
            this.az.ms(new PlayableEndcardFrameLayout.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.ms
                public void ms() {
                    if (ah.this.m != null) {
                        ah.this.m.xr();
                    }
                    if (ah.this.f2177ms != null) {
                        ah.this.f2177ms.ny(1);
                    }
                }
            });
        }
    }

    private void ul() {
        this.ch = nw.ms(this.xr);
        float fLd = this.xr.ld();
        if (TextUtils.isEmpty(this.ch)) {
            return;
        }
        if (this.y == 1) {
            if (this.ch.contains("?")) {
                this.ch += "&orientation=portrait";
            } else {
                this.ch += "?orientation=portrait";
            }
        }
        if (this.ch.contains("?")) {
            this.ch += "&height=" + this.nw + "&width=" + this.t + "&aspect_ratio=" + fLd;
        } else {
            this.ch += "?height=" + this.nw + "&width=" + this.t + "&aspect_ratio=" + fLd;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ms(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        this.qf = downloadListener;
        this.l = xrVar;
        xr(downloadListener, xrVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        if (this.ab == null) {
            return;
        }
        this.l = null;
        this.hi = new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.f2177ms, this.x, this.xr.df(), this.sl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (ah.this.xr == null) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    if (TextUtils.isEmpty(ah.this.xr.so())) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    ah.this.ka++;
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    sl.ah("PlayableEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                ah.this.h.set(false);
                ah.this.qv = this.x;
                ah.this.zb = i;
                ah.this.u = str;
                if (ah.this.jw != null) {
                    ah.this.jw.ms(i, str, str2);
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    ah.this.h.set(false);
                    ah.this.qv = this.x;
                }
                ah.this.zb = webResourceError.getErrorCode();
                ah.this.u = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (ah.this.jw != null) {
                    try {
                        ah.this.jw.ms(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                if (ah.this.ch.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        ah.this.h.set(false);
                        ah.this.qv = this.x;
                    }
                    if (webResourceResponse != null) {
                        ah.this.zb = webResourceResponse.getStatusCode();
                        ah.this.u = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (ah.this.jw != null && str != null && !str.contains(com.anythink.core.common.res.d.a)) {
                    ah.this.jw.ab(str);
                }
                super.onPageFinished(webView, str);
                ah.this.k.ms(webView, str);
                if (ah.this.m != null) {
                    ah.this.m.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                ah.this.op.set(true);
                ah.this.k.ms(webView, str, bitmap);
            }
        };
        this.ab.setWebViewClient(this.hi);
        this.ab.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.x, this.sl));
        ms(this.ab);
        this.ab.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.ab.setDisplayZoomControls(false);
        this.ab.setDownloadListener(downloadListener);
        ms(xrVar);
    }

    private void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        RewardLpBottomView rewardLpBottomView;
        if (!nw.ab(this.xr) || (rewardLpBottomView = this.m) == null) {
            return;
        }
        rewardLpBottomView.setDownLoadClickListener(xrVar);
    }

    public void op() {
        if (this.ub || this.ab == null || this.ab.getWebView() == null) {
            return;
        }
        this.ab.loadUrl(this.ch);
        this.ub = true;
        x xVar = this.jw;
        if (xVar != null) {
            xVar.c(this.ch);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void zb() {
        super.zb();
        x xVar = this.jw;
        if (xVar != null) {
            xVar.xr(false);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ah ahVar = this.p;
        if (ahVar != null) {
            ahVar.xr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void sl() {
        super.sl();
        if (this.jw != null && ul.d(this.ab)) {
            this.jw.xr(true);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ah ahVar = this.p;
        if (ahVar != null) {
            ahVar.ah();
        }
        ka kaVar = this.pc;
        if (kaVar != null) {
            kaVar.ah();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void u() {
        super.u();
        ka kaVar = this.pc;
        if (kaVar != null) {
            kaVar.ms(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ub() {
        super.ub();
        x xVar = this.jw;
        if (xVar != null) {
            xVar.pc();
        }
        if (this.sl != null) {
            this.sl.ms((com.bytedance.sdk.openadsdk.core.zb.d.xr) null);
        }
        this.lm.d();
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ah ahVar = this.p;
        if (ahVar != null) {
            ahVar.d();
        }
        ka kaVar = this.pc;
        if (kaVar != null) {
            kaVar.d();
        }
        this.qf = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ms(int i) {
        super.ms(i);
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void w() {
        super.w();
        this.lm.ah();
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ah ahVar = this.p;
        if (ahVar != null) {
            ahVar.ah();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            this.lm.xr();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ah ahVar = this.p;
        if (ahVar != null) {
            ahVar.xr();
        }
    }

    public void le() {
        ms(true);
        x xVar = this.jw;
        if (xVar != null) {
            xVar.xr(true);
        }
        ah(true);
        ms(false, true);
        if (this.hi != null) {
            this.hi.xr(false);
        }
    }

    public void ka(boolean z) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        try {
            this.x.ab(z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReward", z);
            this.x.ms("isVerifyReward", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void xr(int i, int i2) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skip_remain_time", i);
            if (this.d) {
                jSONObject.put("reward_remain_time", i2);
            }
            this.x.ms("reward_button_status", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr interfaceC0279xr) {
        this.ul = interfaceC0279xr;
    }

    public long cv() {
        return System.currentTimeMillis() - this.cv;
    }

    public boolean g() {
        if (this.x != null) {
            return this.x.ch();
        }
        return true;
    }

    public pc of() {
        return this.x;
    }

    public boolean p() {
        return !this.op.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void xr(boolean z) {
        x xVar = this.jw;
        if (xVar != null) {
            xVar.ms(z);
        }
        this.lm.ms(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void c() {
        if (this.ab != null && this.ab.getVisibility() == 0) {
            this.ul.ah().ms(true);
        }
        super.c();
        this.lm.ms();
        x xVar = this.jw;
        if (xVar != null) {
            xVar.xr(false);
        }
        ms(true, false);
    }

    public void pc() {
        if (this.ab == null || this.jw != null) {
            return;
        }
        if (ch.ub().fm()) {
            ab.ms(fm);
        }
        com.bytedance.sdk.openadsdk.core.y.ah ahVar = new com.bytedance.sdk.openadsdk.core.y.ah();
        d dVar = new d(this.xr, this.ah, this.xn);
        com.bytedance.sdk.openadsdk.core.y.ka kaVar = new com.bytedance.sdk.openadsdk.core.y.ka(this.x);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.xr.df());
            jSONObject.put("log_extra", this.xr.lx());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        x xVarMs = ahVar.ms(re.getContext(), this.ab, kaVar, dVar, hashSet, x.ms.LAND_PAGE).ka(this.ch).d(com.bytedance.sdk.openadsdk.core.x.ms.ab()).ms(com.bytedance.sdk.openadsdk.core.x.ms.ms()).ka(jSONObject).ms("sdkEdition", com.bytedance.sdk.openadsdk.core.x.ms.ah()).xr(com.bytedance.sdk.openadsdk.core.x.ms.ka()).ah(com.bytedance.sdk.openadsdk.core.x.ms.d()).ms(10L).xr(10L).ah(false).ms(false);
        this.jw = xVarMs;
        Set<String> setCh = xVarMs.ch();
        if (this.x == null || setCh == null || setCh.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.jw);
        Iterator<String> it = setCh.iterator();
        while (it.hasNext()) {
            this.x.c().ms(it.next(), (com.bytedance.sdk.component.ms.ka<?, ?>) new com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah.8
                @Override // com.bytedance.sdk.component.ms.ka
                public JSONObject ms(JSONObject jSONObject2, c cVar) throws Exception {
                    try {
                        x xVar = (x) weakReference.get();
                        if (xVar == null) {
                            return null;
                        }
                        return xVar.d(ms(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int i = message.what;
        if (i == 101) {
            az();
            return;
        }
        if (i != 102) {
            return;
        }
        if (!this.g.getAndSet(true) && qr.u(this.xr) != null) {
            nw.ms(this.xr);
        }
        this.le.removeMessages(102);
        this.ul.ah().ms(true);
        this.f2177ms.s();
        if (message.arg1 == 2) {
            com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.ms msVar = this.eg;
            if (msVar != null) {
                msVar.ms();
                return;
            }
            return;
        }
        if (message.arg1 == 0 || message.arg1 == 1) {
            le();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.zb.d.xr
    public void ms(String str) {
        if (TextUtils.isEmpty(this.am)) {
            this.am = str;
        }
        if (TextUtils.equals(this.am, str)) {
            return;
        }
        this.am = str;
        this.f2177ms.ny(1);
    }

    private void az() {
        this.le.sendMessage(xr(3));
        com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.ms msVar = this.eg;
        if (msVar != null) {
            msVar.ms();
        }
        this.f2177ms.ah(0);
    }

    public void c(boolean z) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        this.f = z;
    }

    private Message xr(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 102;
        messageObtain.arg1 = i;
        return messageObtain;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.ms msVar) {
        this.eg = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ms(Map<String, Object> map) {
        if (this.ny != null) {
            this.ny.ch();
        }
        if (map == null || !nw.ah(this.xr)) {
            return;
        }
        map.put("duration", Long.valueOf(cv()));
    }

    private void m() {
        if (this.f2177ms.l() == null) {
            return;
        }
        long jAo = !this.f2177ms.l().ms() ? this.f2177ms.l().ao() : 0L;
        boolean zZb = this.f2177ms.l().zb();
        if (!(this.f2177ms.sa() instanceof ny)) {
            x xVar = this.jw;
            zZb = xVar != null && xVar.ab();
        }
        this.lm.ms(jAo, zZb);
    }
}
