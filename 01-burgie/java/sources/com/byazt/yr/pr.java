package com.byazt.yr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.byazt.ap.fw;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.pj.zo;
import com.byazt.sd.a;
import com.byazt.sd.e;
import com.byazt.sd.iu;
import com.byazt.sd.nl;
import com.byazt.wt.cz;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, 37})
public abstract class pr {
    public int a;
    public zo aj;
    public int cz;
    public SSWebView fw;
    public String hn;
    public of hw;
    public com.byazt.pj.hn k;
    public AtomicInteger lb;
    public TTBaseVideoActivity pr;
    public int qa;
    public String vk;
    public com.byazt.lz.x w;
    public boolean x;
    public nl zo;
    public int c = 0;
    public int uc = 0;
    public int m = 0;
    public String g = "";
    public boolean ho = false;
    public boolean nt = false;
    public final AtomicBoolean yb = new AtomicBoolean(true);
    public AtomicBoolean ny = new AtomicBoolean(false);
    public com.byazt.ap.pr fo = new com.byazt.ap.pr() { // from class: com.byazt.yr.pr.1
        @Override // com.byazt.ap.pr
        public int pr() {
            int measuredHeight;
            if (pr.this.fw == null) {
                measuredHeight = -1;
            } else {
                measuredHeight = pr.this.fw.getMeasuredHeight();
            }
            if (measuredHeight <= 0) {
                return er.uc((Context) pr.this.pr);
            }
            return measuredHeight;
        }

        @Override // com.byazt.ap.pr
        public int hw() {
            int measuredWidth;
            if (pr.this.fw == null) {
                measuredWidth = -1;
            } else {
                measuredWidth = pr.this.fw.getMeasuredWidth();
            }
            if (measuredWidth <= 0) {
                return er.c((Context) pr.this.pr);
            }
            return measuredWidth;
        }
    };
    public fw rc = new fw() { // from class: com.byazt.yr.pr.2
        @Override // com.byazt.ap.fw
        public void pr() {
            SSWebView sSWebView = pr.this.fw;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.byazt.ap.fw
        public void hw() {
            SSWebView sSWebView = pr.this.fw;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };

    public abstract void pr(DownloadListener downloadListener, com.byazt.az.hw hwVar);

    public abstract void pr(boolean z, Map<String, Object> map, View view);

    public abstract String rc();

    public pr(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, String str, int i, int i2, boolean z) {
        this.pr = tTBaseVideoActivity;
        this.hw = ofVar;
        this.hn = str;
        this.qa = ofVar.rf();
        if (a.hw().kq()) {
            float f = this.pr.getResources().getDisplayMetrics().density;
            float f2 = Resources.getSystem().getDisplayMetrics().density;
            this.a = er.hw(f2, er.pr(f, i));
            this.cz = er.hw(f2, er.pr(f, i2));
        } else {
            this.a = i;
            this.cz = i2;
        }
        this.x = z;
    }

    public void pr() {
        SSWebView sSWebView = this.fw;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.yr.pr.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (pr.this.fw == null || pr.this.fw.getViewTreeObserver() == null) {
                        return;
                    }
                    pr.this.fw.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = pr.this.fw.getMeasuredWidth();
                    int measuredHeight = pr.this.fw.getMeasuredHeight();
                    if (pr.this.fw.getVisibility() == 0) {
                        pr.this.hw(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i, int i2) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.zo.hw("resize", jSONObject);
        } catch (Exception e) {
        }
    }

    public void pr(boolean z) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.zo.hw("viewableChange", jSONObject);
        } catch (Exception e) {
        }
    }

    public void hw(boolean z) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.zo.hw("volumeChange", jSONObject);
        } catch (Exception e) {
        }
    }

    public void pr(boolean z, boolean z2) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.zo.hw("endcard_control_event", jSONObject);
        } catch (Exception e) {
        }
    }

    public void hn(boolean z) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        try {
            this.zo.uc(z);
        } catch (Exception e) {
        }
    }

    public void pr(int i, int i2) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i);
            jSONObject.put("downloadProcessRate", i2);
            this.zo.hn("showDownloadStatus", jSONObject);
        } catch (Exception e) {
        }
    }

    public void pr(long j, long j2, int i) {
        if (j2 > 0) {
            pr(i, (int) ((j * 100) / j2));
        }
    }

    public boolean hw() {
        return this.nt;
    }

    public boolean hn() {
        if (!ny()) {
            return false;
        }
        AtomicInteger atomicInteger = this.lb;
        if (atomicInteger != null && atomicInteger.get() != 0) {
            return true;
        }
        return this.yb.get();
    }

    public boolean x() {
        return this.ho;
    }

    public void pr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.byazt.lz.hw.pr(this.pr).pr(false).hw(false).pr(sSWebView);
        cz.pr(sSWebView, iu.x, of.c(this.hw));
        er.pr((com.byazt.son.x) sSWebView);
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.setMixedContentMode(0);
        }
        com.byazt.son.pr.pr(this.hw.cz(), this.fw.getInnerIWebView());
    }

    public void pr(int i) {
        er.pr((View) this.fw, 0);
        if (i == 1) {
            er.pr((View) this.fw, 0.0f);
        }
        if (i == 2) {
            iu();
        }
        nl nlVar = this.zo;
        if (nlVar != null) {
            nlVar.pr(this.pr.a());
            this.zo.pr(ls.a(this.hw), false);
        }
    }

    public void c() {
        com.byazt.pj.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.pr(System.currentTimeMillis());
        }
    }

    public void uc() {
        if (this.pr.bm() instanceof com.byazt.lu.zo) {
            ve();
        } else {
            er.pr((View) this.fw, 8);
        }
    }

    public boolean fw() {
        SSWebView sSWebView = this.fw;
        if (sSWebView != null) {
            return sSWebView.canGoBack();
        }
        return false;
    }

    public void zo() {
        SSWebView sSWebView = this.fw;
        if (sSWebView != null && sSWebView.canGoBack()) {
            this.fw.goBack();
        }
    }

    public void aj() {
        this.aj = null;
    }

    public int vk() {
        return this.m;
    }

    public String w() {
        return this.g;
    }

    public void k() {
        SSWebView sSWebView = this.fw;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        nl nlVar = this.zo;
        if (nlVar != null) {
            nlVar.gz();
            SSWebView sSWebView2 = this.fw;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.zo.uc(true);
                    pr(true);
                    pr(false, true);
                } else {
                    this.zo.uc(false);
                    pr(false);
                    pr(true, false);
                }
            }
        }
        com.byazt.pj.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.x();
        }
        com.byazt.lz.x xVar = this.w;
        if (xVar != null) {
            xVar.hw(false);
        }
    }

    public void m() {
        SSWebView sSWebView = this.fw;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        nl nlVar = this.zo;
        if (nlVar != null) {
            nlVar.nl();
            this.zo.uc(false);
            pr(false);
            pr(true, false);
        }
        com.byazt.lz.x xVar = this.w;
        if (xVar != null) {
            xVar.hn();
        }
    }

    public void g() {
        com.byazt.pj.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.c();
        }
    }

    public void ho() {
        nl nlVar = this.zo;
        if (nlVar != null) {
            nlVar.y();
        }
        zo zoVar = this.aj;
        if (zoVar != null) {
            zoVar.pr(true);
            this.aj.nt();
        }
        com.byazt.pj.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.uc();
        }
        SSWebView sSWebView = this.fw;
        if (sSWebView != null) {
            e.pr(this.pr, sSWebView);
            e.pr(this.fw);
            this.fw.destroy();
        }
        this.fw = null;
    }

    public void nt() {
        SSWebView sSWebView = this.fw;
        if (sSWebView != null) {
            sSWebView.onResume();
            this.fw.resumeTimers();
            er.pr((View) this.fw, 1.0f);
            b();
        }
    }

    public void pr(Map<String, Object> map) {
        zo zoVar = this.aj;
        if (zoVar != null) {
            zoVar.vk();
        }
    }

    public void yb() {
        zo zoVar = this.aj;
        if (zoVar != null) {
            zoVar.aj();
        }
    }

    public void lb() {
        zo zoVar = this.aj;
        if (zoVar != null) {
            zoVar.w();
        }
    }

    public void qa() {
        zo zoVar = this.aj;
        if (zoVar != null) {
            zoVar.k();
        }
    }

    public void a() {
        zo zoVar = this.aj;
        if (zoVar != null) {
            zoVar.hn();
            this.aj.x();
        }
    }

    public boolean cz() {
        nl nlVar = this.zo;
        if (nlVar == null) {
            return false;
        }
        return nlVar.fo();
    }

    public void pr(boolean z, int i, String str) {
        zo zoVar = this.aj;
        if (zoVar == null) {
            return;
        }
        if (z) {
            zoVar.hw();
        } else {
            zoVar.pr(i, str);
        }
    }

    private boolean pr(String str) {
        try {
            new URL(str);
            return URLUtil.isValidUrl(str) && Patterns.WEB_URL.matcher(str).matches();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean ny() {
        return pr(this.vk);
    }

    public void fo() {
        SSWebView sSWebView = this.fw;
        if (sSWebView != null) {
            sSWebView.loadUrl("about:blank");
        }
    }

    public void pr(JSONObject jSONObject) {
        nl nlVar = this.zo;
        if (nlVar == null) {
            ho.hw("BaseEndCard", "mJsObject is null!");
        } else {
            nlVar.hw("showPlayAgainEntrance", jSONObject);
        }
    }

    public void pr(of ofVar) {
        this.hw = ofVar;
        this.ho = false;
    }

    public void z() {
    }

    public void x(boolean z) {
    }

    private void iu() {
        if (this.ny.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.fw, "translationY", er.uc((Context) this.pr), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.yr.pr.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    pr.this.ny.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable th) {
        }
    }

    private void ve() {
        if (this.ny.getAndSet(true)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.fw, "translationY", 0.0f, er.uc((Context) this.pr));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.yr.pr.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                er.pr((View) pr.this.fw, 8);
                pr.this.ny.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void b() {
        nl nlVar = this.zo;
        if (nlVar == null) {
            return;
        }
        nlVar.pr(new SSWebView.hw() { // from class: com.byazt.yr.pr.6
            @Override // com.byazt.fj.SSWebView.hw
            public void pr(int i) {
                if (pr.this.zo != null) {
                    pr.this.zo.pr(i);
                }
            }
        });
    }
}
