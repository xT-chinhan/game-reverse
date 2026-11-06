package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.az;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.d.ny;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.qv.c;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.zb.x;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    protected SSWebView ab;
    protected String ah;
    protected String ch;
    protected boolean d;
    protected com.bytedance.sdk.openadsdk.core.widget.ms.d hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected TTBaseVideoActivity f2177ms;
    protected int nw;
    protected x ny;
    protected AtomicInteger qv;
    com.bytedance.sdk.openadsdk.core.zb.d sl;
    protected int t;
    protected pc x;
    protected lm xr;
    protected int y;
    int ka = 0;
    int c = 0;
    int zb = 0;
    String u = "";
    protected boolean ub = false;
    protected boolean ao = false;
    protected final AtomicBoolean h = new AtomicBoolean(true);
    protected AtomicBoolean b = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.qv.ms re = new com.bytedance.sdk.openadsdk.core.qv.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms.1
        @Override // com.bytedance.sdk.openadsdk.core.qv.ms
        public int ms() {
            int measuredHeight = ms.this.ab != null ? ms.this.ab.getMeasuredHeight() : -1;
            sl.ms("TTAndroidObject", "mWebView>>>>height=".concat(String.valueOf(measuredHeight)));
            return measuredHeight <= 0 ? ul.ka((Context) ms.this.f2177ms) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.ms
        public int xr() {
            int measuredWidth = ms.this.ab != null ? ms.this.ab.getMeasuredWidth() : -1;
            sl.ms("TTAndroidObject", "mWebView>>>>width=".concat(String.valueOf(measuredWidth)));
            return measuredWidth <= 0 ? ul.d((Context) ms.this.f2177ms) : measuredWidth;
        }
    };
    protected c i = new c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms.2
        @Override // com.bytedance.sdk.openadsdk.core.qv.c
        public void ms() {
            SSWebView sSWebView = ms.this.ab;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.c
        public void xr() {
            SSWebView sSWebView = ms.this.ab;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };

    public void d(boolean z) {
    }

    public abstract String i();

    public abstract void ms(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.xr.xr xrVar);

    public abstract void ms(boolean z, Map<String, Object> map, View view);

    public void w() {
    }

    public ms(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, String str, int i, int i2, boolean z) {
        this.f2177ms = tTBaseVideoActivity;
        this.xr = lmVar;
        this.ah = str;
        this.y = lmVar.od();
        if (re.xr().zm()) {
            float f = this.f2177ms.getResources().getDisplayMetrics().density;
            float f2 = Resources.getSystem().getDisplayMetrics().density;
            this.t = ul.xr(f2, ul.ms(f, i));
            this.nw = ul.xr(f2, ul.ms(f, i2));
        } else {
            this.t = i;
            this.nw = i2;
        }
        this.d = z;
    }

    protected void ms() {
        SSWebView sSWebView = this.ab;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (ms.this.ab == null || ms.this.ab.getViewTreeObserver() == null) {
                        return;
                    }
                    ms.this.ab.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = ms.this.ab.getMeasuredWidth();
                    int measuredHeight = ms.this.ab.getMeasuredHeight();
                    if (ms.this.ab.getVisibility() == 0) {
                        ms.this.xr(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i, int i2) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.x.ms("resize", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void ms(boolean z) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.x.ms("viewableChange", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void xr(boolean z) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.x.ms("volumeChange", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void ms(boolean z, boolean z2) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.x.ms("endcard_control_event", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void ah(boolean z) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        try {
            this.x.c(z);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void ms(int i, int i2) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i);
            jSONObject.put("downloadProcessRate", i2);
            this.x.xr("showDownloadStatus", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void ms(long j, long j2, int i) {
        if (j2 > 0) {
            ms(i, (int) ((j * 100) / j2));
        }
    }

    public boolean xr() {
        return this.ao;
    }

    public boolean ah() {
        if (!b()) {
            return false;
        }
        AtomicInteger atomicInteger = this.qv;
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return this.h.get();
        }
        return true;
    }

    public boolean d() {
        return this.ub;
    }

    protected void ms(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.xr.ms(this.f2177ms).ms(false).xr(false).ms(sSWebView);
        t.ms(sSWebView, g.xr, lm.d(this.xr));
        ul.ms((com.bytedance.sdk.component.zb.ah) sSWebView);
        sSWebView.setMixedContentMode(0);
    }

    public void ms(int i) {
        ul.ms((View) this.ab, 0);
        if (i == 1) {
            ul.ms((View) this.ab, 0.0f);
        }
        if (i == 2) {
            op();
        }
        pc pcVar = this.x;
        if (pcVar != null) {
            pcVar.ms(f.ao(this.xr), false);
        }
    }

    public void ka() {
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.sl;
        if (dVar != null) {
            dVar.ms(System.currentTimeMillis());
        }
    }

    public void c() {
        if (this.f2177ms.sa() instanceof ny) {
            le();
        } else {
            ul.ms((View) this.ab, 8);
        }
    }

    public boolean ab() {
        SSWebView sSWebView = this.ab;
        if (sSWebView != null) {
            return sSWebView.canGoBack();
        }
        return false;
    }

    public void x() {
        SSWebView sSWebView = this.ab;
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return;
        }
        this.ab.goBack();
    }

    public void ny() {
        this.ny = null;
    }

    public int ch() {
        return this.zb;
    }

    public String hi() {
        return this.u;
    }

    public void sl() {
        SSWebView sSWebView = this.ab;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        pc pcVar = this.x;
        if (pcVar != null) {
            pcVar.yu();
            SSWebView sSWebView2 = this.ab;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.x.c(true);
                    ms(true);
                    ms(false, true);
                } else {
                    this.x.c(false);
                    ms(false);
                    ms(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.sl;
        if (dVar != null) {
            dVar.d();
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.d dVar2 = this.hi;
        if (dVar2 != null) {
            dVar2.xr(false);
        }
    }

    public void zb() {
        SSWebView sSWebView = this.ab;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        pc pcVar = this.x;
        if (pcVar != null) {
            pcVar.op();
            this.x.c(false);
            ms(false);
            ms(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.d dVar = this.hi;
        if (dVar != null) {
            dVar.ah();
        }
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.sl;
        if (dVar != null) {
            dVar.ka();
        }
    }

    public void ub() {
        pc pcVar = this.x;
        if (pcVar != null) {
            pcVar.le();
        }
        x xVar = this.ny;
        if (xVar != null) {
            xVar.ms(true);
            this.ny.h();
        }
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.sl;
        if (dVar != null) {
            dVar.c();
        }
        SSWebView sSWebView = this.ab;
        if (sSWebView != null) {
            az.ms(this.f2177ms, sSWebView);
            az.ms(this.ab);
            this.ab.destroy();
        }
        this.ab = null;
    }

    public void ao() {
        SSWebView sSWebView = this.ab;
        if (sSWebView != null) {
            sSWebView.onResume();
            this.ab.resumeTimers();
            ul.ms((View) this.ab, 1.0f);
            yu();
        }
    }

    public void ms(Map<String, Object> map) {
        x xVar = this.ny;
        if (xVar != null) {
            xVar.ch();
        }
    }

    public void h() {
        x xVar = this.ny;
        if (xVar != null) {
            xVar.ny();
        }
    }

    public void qv() {
        x xVar = this.ny;
        if (xVar != null) {
            xVar.hi();
        }
    }

    public void y() {
        x xVar = this.ny;
        if (xVar != null) {
            xVar.sl();
        }
    }

    public void t() {
        x xVar = this.ny;
        if (xVar != null) {
            xVar.ah();
            this.ny.d();
        }
    }

    public boolean nw() {
        pc pcVar = this.x;
        if (pcVar == null) {
            return false;
        }
        return pcVar.t();
    }

    public void ms(boolean z, int i, String str) {
        x xVar = this.ny;
        if (xVar == null) {
            return;
        }
        if (z) {
            xVar.xr();
        } else {
            xVar.ms(i, str);
        }
    }

    private boolean ms(String str) {
        try {
            new URL(str);
            return URLUtil.isValidUrl(str) && Patterns.WEB_URL.matcher(str).matches();
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        return ms(this.ch);
    }

    public void re() {
        SSWebView sSWebView = this.ab;
        if (sSWebView != null) {
            sSWebView.loadUrl(com.anythink.core.common.res.d.a);
        }
    }

    public void ms(JSONObject jSONObject) {
        pc pcVar = this.x;
        if (pcVar == null) {
            sl.d("BaseEndCard", "mJsObject is null!");
        } else {
            pcVar.ms("showPlayAgainEntrance", jSONObject);
        }
    }

    public void ms(lm lmVar) {
        this.xr = lmVar;
        this.ub = false;
    }

    private void op() {
        if (this.b.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ab, "translationY", ul.ka((Context) this.f2177ms), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ms.this.b.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private void le() {
        if (this.b.getAndSet(true)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ab, "translationY", 0.0f, ul.ka((Context) this.f2177ms));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ul.ms((View) ms.this.ab, 8);
                ms.this.b.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void yu() {
        pc pcVar = this.x;
        if (pcVar == null) {
            return;
        }
        pcVar.ms(new SSWebView.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms.6
            @Override // com.bytedance.sdk.component.widget.SSWebView.xr
            public void ms(int i) {
                if (ms.this.x != null) {
                    ms.this.x.ms(i);
                }
            }
        });
    }
}
