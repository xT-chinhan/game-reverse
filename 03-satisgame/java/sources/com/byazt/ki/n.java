package com.byazt.ki;

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
import com.anythink.core.common.res.d;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.k;
import com.byazt.uv.fs;
import com.byazt.vgn.w;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 715, 19})
public abstract class n {
    public int a;
    public AtomicInteger cd;
    public com.byazt.dho.s cp;
    public com.byazt.hm.s d;
    public com.byazt.gcl.s fs;
    public TTBaseVideoActivity n;
    public int py;
    public boolean q;
    public pk qg;
    public w rv;
    public String s;
    public String tj;
    public int um;
    public SSWebView x;
    public int l = 0;
    public int w = 0;
    public int oa = 0;
    public String sz = "";
    public boolean k = false;
    public boolean cy = false;
    public final AtomicBoolean hd = new AtomicBoolean(true);
    public AtomicBoolean ou = new AtomicBoolean(false);
    public com.byazt.uv.n wm = new com.byazt.uv.n() { // from class: com.byazt.ki.n.1
        @Override // com.byazt.uv.n
        public int n() {
            int measuredHeight = n.this.x != null ? n.this.x.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? com.byazt.okk.s.w((Context) n.this.n) : measuredHeight;
        }

        @Override // com.byazt.uv.n
        public int qg() {
            int measuredWidth = n.this.x != null ? n.this.x.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? com.byazt.okk.s.l((Context) n.this.n) : measuredWidth;
        }
    };
    public fs m = new fs() { // from class: com.byazt.ki.n.2
        @Override // com.byazt.uv.fs
        public void n() {
            SSWebView sSWebView = n.this.x;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.byazt.uv.fs
        public void qg() {
            SSWebView sSWebView = n.this.x;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };

    public void hu() {
    }

    public abstract String m();

    public abstract void n(DownloadListener downloadListener, com.byazt.ys.qg qgVar);

    public abstract void n(boolean z, Map<String, Object> map, View view);

    public void q(boolean z) {
    }

    public n(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, String str, int i, int i2, boolean z) {
        this.n = tTBaseVideoActivity;
        this.qg = pkVar;
        this.s = str;
        this.um = pkVar.ys();
        if (rv.qg().yj()) {
            float f = this.n.getResources().getDisplayMetrics().density;
            float f2 = Resources.getSystem().getDisplayMetrics().density;
            this.a = com.byazt.okk.s.qg(f2, com.byazt.okk.s.n(f, i));
            this.py = com.byazt.okk.s.qg(f2, com.byazt.okk.s.n(f, i2));
        } else {
            this.a = i;
            this.py = i2;
        }
        this.q = z;
    }

    public void n() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.ki.n.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (n.this.x == null || n.this.x.getViewTreeObserver() == null) {
                        return;
                    }
                    n.this.x.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = n.this.x.getMeasuredWidth();
                    int measuredHeight = n.this.x.getMeasuredHeight();
                    if (n.this.x.getVisibility() == 0) {
                        n.this.qg(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i, int i2) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.fs.qg("resize", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void n(boolean z) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.fs.qg("viewableChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void qg(boolean z) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.fs.qg("volumeChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.fs.qg("endcard_control_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void s(boolean z) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        try {
            this.fs.w(z);
        } catch (Exception unused) {
        }
    }

    public void n(int i, int i2) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i);
            jSONObject.put("downloadProcessRate", i2);
            this.fs.s("showDownloadStatus", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void n(long j, long j2, int i) {
        if (j2 > 0) {
            n(i, (int) ((j * 100) / j2));
        }
    }

    public boolean qg() {
        return this.cy;
    }

    public boolean s() {
        if (!ou()) {
            return false;
        }
        AtomicInteger atomicInteger = this.cd;
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return this.hd.get();
        }
        return true;
    }

    public boolean q() {
        return this.k;
    }

    public void n(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.byazt.dho.n.n(this.n).n(false).qg(false).n(sSWebView);
        com.byazt.qq.n.n(sSWebView, tj.l, pk.l(this.qg));
        com.byazt.okk.s.n((com.byazt.uad.q) sSWebView);
        sSWebView.setMixedContentMode(0);
        com.byazt.uad.n.n(this.qg.py(), this.x.getInnerIWebView());
    }

    public void n(int i) {
        com.byazt.okk.s.n((View) this.x, 0);
        if (i == 1) {
            com.byazt.okk.s.n((View) this.x, 0.0f);
        }
        if (i == 2) {
            t();
        }
        com.byazt.gcl.s sVar = this.fs;
        if (sVar != null) {
            sVar.n(this.n.a());
            this.fs.n(com.byazt.vgx.w.wm(this.qg), false);
        }
    }

    public void l() {
        com.byazt.hm.s sVar = this.d;
        if (sVar != null) {
            sVar.n(System.currentTimeMillis());
        }
    }

    public void w() {
        if (this.n.nf() instanceof com.byazt.has.fs) {
            ur();
        } else {
            com.byazt.okk.s.n((View) this.x, 8);
        }
    }

    public boolean x() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            return sSWebView.canGoBack();
        }
        return false;
    }

    public void fs() {
        SSWebView sSWebView = this.x;
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return;
        }
        this.x.goBack();
    }

    public void rv() {
        this.rv = null;
    }

    public int tj() {
        return this.oa;
    }

    public String cp() {
        return this.sz;
    }

    public void d() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        com.byazt.gcl.s sVar = this.fs;
        if (sVar != null) {
            sVar.bb();
            SSWebView sSWebView2 = this.x;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.fs.w(true);
                    n(true);
                    n(false, true);
                } else {
                    this.fs.w(false);
                    n(false);
                    n(true, false);
                }
            }
        }
        com.byazt.hm.s sVar2 = this.d;
        if (sVar2 != null) {
            sVar2.q();
        }
        com.byazt.dho.s sVar3 = this.cp;
        if (sVar3 != null) {
            sVar3.qg(false);
        }
    }

    public void oa() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        com.byazt.gcl.s sVar = this.fs;
        if (sVar != null) {
            sVar.ln();
            this.fs.w(false);
            n(false);
            n(true, false);
        }
        com.byazt.dho.s sVar2 = this.cp;
        if (sVar2 != null) {
            sVar2.s();
        }
    }

    public void sz() {
        com.byazt.hm.s sVar = this.d;
        if (sVar != null) {
            sVar.l();
        }
    }

    public void k() {
        com.byazt.gcl.s sVar = this.fs;
        if (sVar != null) {
            sVar.lh();
        }
        w wVar = this.rv;
        if (wVar != null) {
            wVar.n(true);
            this.rv.fs();
        }
        com.byazt.hm.s sVar2 = this.d;
        if (sVar2 != null) {
            sVar2.w();
        }
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            com.byazt.gcl.q.n(this.n, sSWebView);
            com.byazt.gcl.q.n(this.x);
            this.x.destroy();
        }
        this.x = null;
    }

    public void cy() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.onResume();
            this.x.resumeTimers();
            com.byazt.okk.s.n((View) this.x, 1.0f);
            h();
        }
    }

    public void n(Map<String, Object> map) {
        w wVar = this.rv;
        if (wVar != null) {
            wVar.sz();
        }
    }

    public void hd() {
        w wVar = this.rv;
        if (wVar != null) {
            wVar.oa();
        }
    }

    public void cd() {
        w wVar = this.rv;
        if (wVar != null) {
            wVar.k();
        }
    }

    public void um() {
        w wVar = this.rv;
        if (wVar != null) {
            wVar.cy();
        }
    }

    public void a() {
        w wVar = this.rv;
        if (wVar != null) {
            wVar.n();
            this.rv.d();
        }
    }

    public boolean py() {
        com.byazt.gcl.s sVar = this.fs;
        if (sVar == null) {
            return false;
        }
        return sVar.wm();
    }

    public void n(boolean z, int i, String str) {
        w wVar = this.rv;
        if (wVar == null) {
            return;
        }
        if (z) {
            wVar.l();
        } else {
            wVar.s(i, str);
        }
    }

    private boolean n(String str) {
        try {
            new URL(str);
            return URLUtil.isValidUrl(str) && Patterns.WEB_URL.matcher(str).matches();
        } catch (Exception unused) {
        }
    }

    public boolean ou() {
        return n(this.tj);
    }

    public void wm() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.loadUrl(d.a);
        }
    }

    public void n(JSONObject jSONObject) {
        com.byazt.gcl.s sVar = this.fs;
        if (sVar == null) {
            k.qg("BaseEndCard", "mJsObject is null!");
        } else {
            sVar.qg("showPlayAgainEntrance", jSONObject);
        }
    }

    public void n(pk pkVar) {
        this.qg = pkVar;
        this.k = false;
    }

    private void t() {
        if (this.ou.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "translationY", com.byazt.okk.s.w((Context) this.n), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.ki.n.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    n.this.ou.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable unused) {
        }
    }

    private void ur() {
        if (this.ou.getAndSet(true)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "translationY", 0.0f, com.byazt.okk.s.w((Context) this.n));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.ki.n.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.byazt.okk.s.n((View) n.this.x, 8);
                n.this.ou.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void h() {
        com.byazt.gcl.s sVar = this.fs;
        if (sVar == null) {
            return;
        }
        sVar.n(new SSWebView.qg() { // from class: com.byazt.ki.n.6
            @Override // com.byazt.kfh.SSWebView.qg
            public void n(int i) {
                if (n.this.fs != null) {
                    n.this.fs.n(i);
                }
            }
        });
    }
}
