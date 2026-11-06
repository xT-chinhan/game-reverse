package com.byazt.pp;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 598})
public class LottieAnimationView extends ImageView {
    public static final String n = "LottieAnimationView";
    public static final tj<Throwable> qg = new tj<Throwable>() { // from class: com.byazt.pp.LottieAnimationView.1
        @Override // com.byazt.pp.tj
        public void n(Throwable th) {
            if (com.byazt.nu.tj.n(th)) {
                com.byazt.nu.w.n("Unable to load composition.", th);
            } else {
                com.byazt.nu.w.n("Unable to parse composition:", th);
            }
        }
    };
    public com.byazt.eg.s a;
    public com.byazt.eg.d ae;
    public List<com.byazt.eg.w> an;
    public Handler bb;
    public final Handler cd;
    public boolean cp;
    public w cy;
    public boolean d;
    public int df;
    public int dg;
    public n dh;
    public List<com.byazt.eg.d> f;
    public int fi;
    public String fs;
    public String h;
    public final Handler hd;
    public com.byazt.rx.q hu;
    public com.byazt.eg.w j;
    public sz<w> k;
    public tj<Throwable> l;
    public volatile int lh;
    public long ln;
    public com.byazt.rx.s m;
    public final Set<q> oa;
    public int oj;
    public final RectF ou;
    public JSONArray pk;
    public final RectF py;
    public final tj<Throwable> q;
    public qg rf;
    public int rv;
    public final tj<w> s;
    public int sh;
    public final Set<d> sz;
    public volatile boolean t;
    public boolean tj;
    public String u;
    public com.byazt.ej.oa um;
    public int ur;
    public final Runnable v;
    public int w;
    public final com.byazt.rx.n wm;
    public int wo;
    public final fs x;
    public final Runnable y;

    public interface n {
        void n(Map<String, Object> map);

        void qg(Map<String, Object> map);
    }

    private enum q {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public interface qg {
        void n(String str, JSONArray jSONArray);
    }

    public static /* synthetic */ int py(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.fi;
        lottieAnimationView.fi = i - 1;
        return i;
    }

    public static /* synthetic */ int q(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.ur;
        lottieAnimationView.ur = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final w wVar, com.byazt.vk.q qVar) {
        com.byazt.vk.w.n().n(qVar, new com.byazt.vk.x() { // from class: com.byazt.pp.LottieAnimationView.10
            @Override // com.byazt.vk.x
            public void n(com.byazt.vk.q qVar2) {
                LottieAnimationView.this.setComposition(wVar);
            }

            @Override // com.byazt.vk.x
            public void n(com.byazt.vk.q qVar2, int i, String str) {
                LottieAnimationView.this.n(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        n(new Exception("Lottie zip download failed, errorCode: " + i + ", errorDesc: " + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Throwable th) {
        int i = this.w;
        if (i != 0) {
            setImageResource(i);
        }
        tj<Throwable> tjVar = this.l;
        if (tjVar == null) {
            tjVar = qg;
        }
        tjVar.n(th);
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.s = new tj<w>() { // from class: com.byazt.pp.LottieAnimationView.9
            @Override // com.byazt.pp.tj
            public void n(w wVar) {
                w.qg qgVarD = wVar.d();
                com.byazt.vk.q qVar = qgVarD != null ? qgVarD.fs : null;
                if (qVar != null && !com.byazt.vk.w.n().s()) {
                    LottieAnimationView.this.n(wVar, qVar);
                } else {
                    LottieAnimationView.this.setComposition(wVar);
                }
            }
        };
        this.q = new tj<Throwable>() { // from class: com.byazt.pp.LottieAnimationView.11
            @Override // com.byazt.pp.tj
            public void n(Throwable th) {
                LottieAnimationView.this.n(th);
            }
        };
        this.w = 0;
        this.x = new fs(this);
        this.tj = false;
        this.cp = false;
        this.d = true;
        this.oa = new HashSet();
        this.sz = new HashSet();
        this.hd = new Handler(Looper.getMainLooper());
        this.cd = new Handler(Looper.getMainLooper());
        this.py = new RectF();
        this.ou = new RectF();
        this.wm = new com.byazt.rx.n() { // from class: com.byazt.pp.LottieAnimationView.12
            @Override // com.byazt.rx.n
            public void n() {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.n(lottieAnimationView.a);
            }
        };
        this.t = false;
        this.ur = 0;
        this.ln = 0L;
        this.lh = 0;
        this.v = new Runnable() { // from class: com.byazt.pp.LottieAnimationView.6
            @Override // java.lang.Runnable
            public void run() {
                LottieAnimationView.this.k();
                if (LottieAnimationView.this.lh == 0) {
                    return;
                }
                if (LottieAnimationView.this.isShown()) {
                    if (LottieAnimationView.this.lh == 1) {
                        LottieAnimationView.this.lh = 2;
                        LottieAnimationView.this.hd();
                        return;
                    }
                    return;
                }
                if (LottieAnimationView.this.lh == 2) {
                    LottieAnimationView.this.lh = 1;
                    LottieAnimationView.this.cd();
                }
            }
        };
        this.y = new Runnable() { // from class: com.byazt.pp.LottieAnimationView.7
            @Override // java.lang.Runnable
            public void run() {
                int unused = LottieAnimationView.this.fi;
                int unused2 = LottieAnimationView.this.df;
                if (LottieAnimationView.this.fi <= LottieAnimationView.this.df) {
                    LottieAnimationView.this.lh = 0;
                    LottieAnimationView.this.cy();
                    if (LottieAnimationView.this.oj < 0 || LottieAnimationView.this.dg < 0) {
                        int unused3 = LottieAnimationView.this.oj;
                        int unused4 = LottieAnimationView.this.dg;
                    } else {
                        int unused5 = LottieAnimationView.this.oj;
                        LottieAnimationView.this.qg();
                        LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                        lottieAnimationView.setFrame(lottieAnimationView.oj);
                        LottieAnimationView.this.n(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.pp.LottieAnimationView.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (LottieAnimationView.this.getFrame() < LottieAnimationView.this.dg - 1 || LottieAnimationView.this.getFrame() >= LottieAnimationView.this.dg + 2) {
                                    return;
                                }
                                int unused6 = LottieAnimationView.this.dg;
                                LottieAnimationView.this.qg(this);
                                LottieAnimationView.this.x();
                            }
                        });
                    }
                    if ((!TextUtils.isEmpty(LottieAnimationView.this.u) || (LottieAnimationView.this.pk != null && LottieAnimationView.this.pk.length() > 0)) && LottieAnimationView.this.rf != null) {
                        LottieAnimationView.this.rf.n(LottieAnimationView.this.u, LottieAnimationView.this.pk);
                        return;
                    }
                    return;
                }
                LottieAnimationView.py(LottieAnimationView.this);
                LottieAnimationView.this.um();
                LottieAnimationView.this.invalidate();
                LottieAnimationView.this.hd();
            }
        };
        fs();
    }

    private void fs() {
        setSaveEnabled(false);
        this.d = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        n(0.0f, false);
        n(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.x.n(Boolean.valueOf(com.byazt.nu.tj.n(getContext()) != 0.0f));
        rv();
        tj();
        d();
    }

    public void setAutoPlay(boolean z) {
        this.cp = z;
    }

    private void rv() {
        n(new Animator.AnimatorListener() { // from class: com.byazt.pp.LottieAnimationView.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LottieAnimationView.this.qg(this);
                LottieAnimationView.this.sz();
                LottieAnimationView.this.cp();
            }
        });
    }

    private void tj() {
        n(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.pp.LottieAnimationView.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                LottieAnimationView.q(LottieAnimationView.this);
                w.qg globalConfig = LottieAnimationView.this.getGlobalConfig();
                if (globalConfig != null && globalConfig.q > 0 && globalConfig.q > LottieAnimationView.this.ur) {
                    LottieAnimationView.this.sz();
                    LottieAnimationView.this.n();
                    LottieAnimationView.this.setProgress(0.0f);
                } else {
                    LottieAnimationView.this.qg(this);
                    if (LottieAnimationView.this.dh != null) {
                        LottieAnimationView.this.dh.qg((globalConfig == null || globalConfig.s == null) ? null : globalConfig.s);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp() {
        final w.qg globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.l <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.w) && globalConfig.x == null) {
            return;
        }
        int maxFrame = globalConfig.l;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        n(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.pp.LottieAnimationView.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                LottieAnimationView.this.qg(this);
                if (LottieAnimationView.this.rf != null) {
                    LottieAnimationView.this.rf.n(globalConfig.w, globalConfig.x);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) {
        w.qg globalConfig = getGlobalConfig();
        if (this.dh != null) {
            HashMap map = new HashMap();
            map.put(MediationConstant.EXTRA_DURATION, Long.valueOf(j));
            if (globalConfig != null && globalConfig.qg != null && !globalConfig.qg.isEmpty()) {
                map.putAll(globalConfig.qg);
            }
            this.dh.n(map);
        }
    }

    private void d() {
        n(new Animator.AnimatorListener() { // from class: com.byazt.pp.LottieAnimationView.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                py pyVarHu;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.ln;
                LottieAnimationView.this.qg(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (pyVarHu = LottieAnimationView.this.x.hu()) != null) {
                    try {
                        int i = Integer.parseInt(pyVarHu.n(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.ln > 0) {
                            long jElapsedRealtime2 = (LottieAnimationView.this.ln + ((long) i)) - SystemClock.elapsedRealtime();
                            if (jElapsedRealtime2 > 0) {
                                LottieAnimationView.this.x();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.bb == null) {
                                    LottieAnimationView.this.bb = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.bb.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.bb.postDelayed(new Runnable() { // from class: com.byazt.pp.LottieAnimationView.16.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.n();
                                        LottieAnimationView.this.n(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                LottieAnimationView.this.n(jElapsedRealtime);
            }
        });
    }

    public void setVideoStats(com.byazt.ej.oa oaVar) {
        this.um = oaVar;
    }

    public com.byazt.ej.oa getVideoStats() {
        return this.um;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        oa();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        oa();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        oa();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        fs fsVar;
        if (!this.tj && drawable == (fsVar = this.x) && fsVar.wm()) {
            x();
        } else if (!this.tj && (drawable instanceof fs)) {
            fs fsVar2 = (fs) drawable;
            if (fsVar2.wm()) {
                fsVar2.bb();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof fs) && ((fs) drawable).x() == a.SOFTWARE) {
            this.x.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        fs fsVar = this.x;
        if (drawable2 == fsVar) {
            super.invalidateDrawable(fsVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        w wVarT;
        fs fsVar = this.x;
        if (fsVar == null || (wVarT = fsVar.t()) == null) {
            return null;
        }
        return wVarT.rv();
    }

    private rv n(String str) {
        fs fsVar;
        w wVarT;
        Map<String, rv> mapHd;
        if (TextUtils.isEmpty(str) || (fsVar = this.x) == null || (wVarT = fsVar.t()) == null || (mapHd = wVarT.hd()) == null) {
            return null;
        }
        return mapHd.get(str);
    }

    private w.n getArea() {
        w wVarT;
        fs fsVar = this.x;
        if (fsVar == null || (wVarT = fsVar.t()) == null) {
            return null;
        }
        return wVarT.tj();
    }

    private w.s getGlobalEvent() {
        w wVarT;
        fs fsVar = this.x;
        if (fsVar == null || (wVarT = fsVar.t()) == null) {
            return null;
        }
        return wVarT.cp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w.qg getGlobalConfig() {
        w wVarT;
        fs fsVar = this.x;
        if (fsVar == null || (wVarT = fsVar.t()) == null) {
            return null;
        }
        return wVarT.d();
    }

    private void n(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i < 0 || i2 < 0) {
                return;
            }
            cd();
            n();
            setFrame(i);
            n(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.pp.LottieAnimationView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i2 - 1 || LottieAnimationView.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    LottieAnimationView.this.getFrame();
                    LottieAnimationView.this.qg(this);
                    LottieAnimationView.this.x();
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void n(w.n nVar) {
        nVar.l = com.byazt.nu.tj.n(com.byazt.af.x.n, nVar.n, getWidth());
        nVar.w = com.byazt.nu.tj.n("y", nVar.qg, getHeight());
        nVar.x = com.byazt.nu.tj.n((String) null, nVar.s, getWidth());
        nVar.fs = com.byazt.nu.tj.n((String) null, nVar.q, getHeight());
    }

    private boolean n(rv rvVar) {
        if (rvVar != null) {
            if (!TextUtils.isEmpty(rvVar.x())) {
                return true;
            }
            if (rvVar.rv() != null && rvVar.rv().length() > 0) {
                return true;
            }
            if ((rvVar.fs() != null && rvVar.fs().length > 0) || !TextUtils.isEmpty(rvVar.cy())) {
                return true;
            }
        }
        w.qg globalConfig = getGlobalConfig();
        if (globalConfig != null && !TextUtils.isEmpty(globalConfig.rv)) {
            return true;
        }
        w.s globalEvent = getGlobalEvent();
        if (globalEvent == null) {
            return false;
        }
        if (!TextUtils.isEmpty(globalEvent.n)) {
            return true;
        }
        if (globalEvent.s == null || globalEvent.s.length() <= 0) {
            return (globalEvent.qg != null && globalEvent.qg.length > 0) || !TextUtils.isEmpty(globalEvent.l);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        String str;
        JSONArray jSONArray;
        int i;
        String str2;
        if (motionEvent.getAction() == 0) {
            w.n area = getArea();
            if (area != null) {
                if (area.l == -1.0f) {
                    n(area);
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (x < area.l || x > area.l + area.x || y < area.w || y > area.w + area.fs) {
                    getWidth();
                    getHeight();
                    return false;
                }
            }
            com.byazt.eg.s sVarN = n(motionEvent);
            if (sVarN == null || (sVarN instanceof com.byazt.eg.q)) {
                if (getGlobalConfig() == null || getGlobalConfig().n != 1) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            }
            String strCp = sVarN.cp();
            if (strCp != null && strCp.startsWith("CSJNTP")) {
                return false;
            }
            this.a = sVarN;
        }
        com.byazt.eg.s sVar = this.a;
        rv rvVarN = sVar != null ? n(sVar.x()) : null;
        if (this.a != null && n(rvVarN)) {
            if (this.m != null) {
                com.byazt.eg.s sVar2 = this.a;
                String strCp2 = sVar2.cp();
                w.s globalEvent = getGlobalEvent();
                if (globalEvent != null) {
                    String str3 = globalEvent.n;
                    JSONArray jSONArray2 = globalEvent.s;
                    int i2 = globalEvent.q;
                    str2 = globalEvent.l;
                    i = i2;
                    jSONArray = jSONArray2;
                    str = str3;
                } else {
                    str = null;
                    jSONArray = null;
                    i = 10;
                    str2 = null;
                }
                w.qg globalConfig = getGlobalConfig();
                if (globalConfig != null && !TextUtils.isEmpty(globalConfig.rv)) {
                    str2 = globalConfig.rv;
                }
                String str4 = str2;
                fs fsVar = this.x;
                if (fsVar != null && fsVar.fs()) {
                    sVar2.n(this.py, sVar2.w(), true);
                    RectF rectFLh = this.x.lh();
                    if (rectFLh != null) {
                        n(this.py, rectFLh);
                    }
                } else {
                    sVar2.n(this.ou, sVar2.w(), true);
                    qg(this.py, this.ou);
                }
                this.m.n(motionEvent, strCp2, rvVarN, str, jSONArray, i, str4, this.wm, n(motionEvent, this.py));
            }
            int action = motionEvent.getAction();
            if (action == 1 || action == 3) {
                this.a = null;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.eg.s sVar) {
        int[][] iArr;
        int[][] iArrFs;
        if (sVar == null) {
            return;
        }
        String strCp = sVar.cp();
        if (strCp != null && strCp.startsWith("CSJCLOSE")) {
            cd();
        }
        rv rvVarN = n(sVar.x());
        if (rvVarN != null && (iArrFs = rvVarN.fs()) != null) {
            n(iArrFs);
        } else {
            if (getGlobalEvent() == null || (iArr = getGlobalEvent().qg) == null) {
                return;
            }
            n(iArr);
        }
    }

    private com.byazt.eg.s n(MotionEvent motionEvent) {
        com.byazt.eg.q qVarS;
        fs fsVar = this.x;
        if (fsVar == null || (qVarS = fsVar.s()) == null) {
            return null;
        }
        return n(qVarS, motionEvent);
    }

    private com.byazt.eg.s n(com.byazt.eg.q qVar, MotionEvent motionEvent) {
        com.byazt.eg.s sVarN;
        for (com.byazt.eg.s sVar : qVar.sz()) {
            if (sVar instanceof com.byazt.eg.q) {
                if (sVar.tj() && sVar.fs() > 0.0f) {
                    RectF rectF = new RectF();
                    sVar.n(rectF, sVar.w(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (sVarN = n((com.byazt.eg.q) sVar, motionEvent)) != null) {
                        return sVarN;
                    }
                }
            } else if (sVar.tj() && sVar.fs() > 0.0f) {
                RectF rectF2 = new RectF();
                fs fsVar = this.x;
                if (fsVar != null && fsVar.fs()) {
                    sVar.n(rectF2, sVar.w(), true);
                    RectF rectFLh = this.x.lh();
                    if (rectFLh != null) {
                        n(rectF2, rectFLh);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    sVar.n(rectF3, sVar.w(), true);
                    qg(rectF2, rectF3);
                }
                if (n(motionEvent, rectF2)) {
                    return sVar;
                }
            }
        }
        return null;
    }

    private boolean n(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void n(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass8.n[getScaleType().ordinal()];
        if (i == 1) {
            n(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            qg(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            s(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            q(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    /* JADX INFO: renamed from: com.byazt.pp.LottieAnimationView$8, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 1559})
    static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            n = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void qg(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.x.getBounds().width();
        float fHeight = this.x.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass8.n[getScaleType().ordinal()];
        if (i == 1) {
            n(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            qg(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            s(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            q(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void n(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 / f4 >= f / f2) {
            float f5 = f2 / f4;
            matrix.preScale(f5, f5);
            matrix.postTranslate(-(((f3 * f5) - f) / 2.0f), 0.0f);
        } else {
            float f6 = f / f3;
            matrix.preScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f4 * f6) - f2) / 2.0f));
        }
    }

    private void qg(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 < f && f4 < f2) {
            matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
            return;
        }
        if (f3 / f4 >= f / f2) {
            float f5 = f / f3;
            matrix.preScale(f5, f5);
            matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
        } else {
            float f6 = f2 / f4;
            matrix.preScale(f6, f6);
            matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
        }
    }

    private void s(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void q(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 >= f || f4 >= f2) {
            if (f3 / f4 >= f / f2) {
                float f5 = f / f3;
                matrix.preScale(f5, f5);
                matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
                return;
            } else {
                float f6 = f2 / f4;
                matrix.preScale(f6, f6);
                matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f3 / f4 >= f / f2) {
            float f7 = f / f3;
            matrix.preScale(f7, f7);
            matrix.postTranslate(0.0f, (f2 - (f4 * f7)) / 2.0f);
        } else {
            float f8 = f2 / f4;
            matrix.preScale(f8, f8);
            matrix.postTranslate((f - (f3 * f8)) / 2.0f, 0.0f);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        s sVar = new s(super.onSaveInstanceState());
        sVar.n = this.fs;
        sVar.qg = this.rv;
        sVar.s = this.x.ln();
        sVar.q = this.x.m();
        sVar.l = this.x.l();
        sVar.w = this.x.py();
        sVar.x = this.x.ou();
        return sVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        s sVar = (s) parcelable;
        super.onRestoreInstanceState(sVar.getSuperState());
        this.fs = sVar.n;
        if (!this.oa.contains(q.SET_ANIMATION) && !TextUtils.isEmpty(this.fs)) {
            setAnimation(this.fs);
        }
        this.rv = sVar.qg;
        if (!this.oa.contains(q.SET_ANIMATION) && (i = this.rv) != 0) {
            setAnimation(i);
        }
        if (!this.oa.contains(q.SET_PROGRESS)) {
            n(sVar.s, false);
        }
        if (!this.oa.contains(q.PLAY_OPTION) && sVar.q) {
            n();
        }
        if (!this.oa.contains(q.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(sVar.l);
        }
        if (!this.oa.contains(q.SET_REPEAT_MODE)) {
            setRepeatMode(sVar.w);
        }
        if (this.oa.contains(q.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(sVar.x);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.cp) {
            return;
        }
        this.x.d();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cd();
        cy();
        Handler handler = this.bb;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        q();
        s();
        w();
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.x.x(z);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.x.fs(z);
    }

    public void n(boolean z, Context context) {
        this.x.n(z, context);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.x.n(z);
    }

    public boolean getClipToCompositionBounds() {
        return this.x.q();
    }

    public void setCacheComposition(boolean z) {
        this.d = z;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.x.q(z);
    }

    public void setAnimation(int i) {
        this.rv = i;
        this.fs = null;
        setCompositionTask(n(i));
    }

    private sz<w> n(final int i) {
        if (isInEditMode()) {
            return new sz<>(new Callable<oa<w>>() { // from class: com.byazt.pp.LottieAnimationView.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public oa<w> call() throws Exception {
                    return LottieAnimationView.this.d ? x.qg(LottieAnimationView.this.getContext(), i) : x.qg(LottieAnimationView.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.d ? x.n(getContext(), i) : x.n(getContext(), i, (String) null);
    }

    public void setAnimation(String str) {
        this.fs = str;
        this.rv = 0;
        setCompositionTask(qg(str));
    }

    private sz<w> qg(final String str) {
        if (isInEditMode()) {
            return new sz<>(new Callable<oa<w>>() { // from class: com.byazt.pp.LottieAnimationView.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public oa<w> call() throws Exception {
                    return LottieAnimationView.this.d ? x.s(LottieAnimationView.this.getContext(), str) : x.s(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.d ? x.qg(getContext(), str) : x.qg(getContext(), str, (String) null);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        n(str, (String) null);
    }

    public void n(String str, String str2) {
        if (!this.t) {
            throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromJson");
        }
        n(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void n(InputStream inputStream, String str) {
        setCompositionTask(x.n(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        if (!this.t) {
            throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromUrl");
        }
        setCompositionTask(this.d ? x.n(getContext(), str) : x.n(getContext(), str, (String) null));
    }

    public void qg(String str, String str2) {
        if (!this.t) {
            throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromUrl");
        }
        setCompositionTask(x.n(getContext(), str, str2));
    }

    public void setFailureListener(tj<Throwable> tjVar) {
        this.l = tjVar;
    }

    public void setFallbackResource(int i) {
        this.w = i;
    }

    private void setCompositionTask(sz<w> szVar) {
        this.oa.add(q.SET_ANIMATION);
        a();
        oa();
        this.k = szVar.n(this.s).s(this.q);
    }

    private void oa() {
        sz<w> szVar = this.k;
        if (szVar != null) {
            szVar.qg(this.s);
            this.k.q(this.q);
        }
    }

    private com.byazt.eg.d n(com.byazt.eg.q qVar, String str) {
        for (com.byazt.eg.s sVar : qVar.sz()) {
            if (sVar instanceof com.byazt.eg.q) {
                com.byazt.eg.d dVarN = n((com.byazt.eg.q) sVar, str);
                if (dVarN != null) {
                    return dVarN;
                }
            } else if (TextUtils.equals(str, sVar.cp()) && (sVar instanceof com.byazt.eg.d)) {
                return (com.byazt.eg.d) sVar;
            }
        }
        return null;
    }

    private com.byazt.eg.d s(String str) {
        com.byazt.eg.q qVarS;
        fs fsVar = this.x;
        if (fsVar == null || (qVarS = fsVar.s()) == null) {
            return null;
        }
        return n(qVarS, str);
    }

    private com.byazt.eg.w qg(com.byazt.eg.q qVar, String str) {
        for (com.byazt.eg.s sVar : qVar.sz()) {
            if (sVar instanceof com.byazt.eg.q) {
                com.byazt.eg.w wVarQg = qg((com.byazt.eg.q) sVar, str);
                if (wVarQg != null) {
                    return wVarQg;
                }
            } else if (TextUtils.equals(str, sVar.cp()) && (sVar instanceof com.byazt.eg.w)) {
                return (com.byazt.eg.w) sVar;
            }
        }
        return null;
    }

    private com.byazt.eg.w q(String str) {
        com.byazt.eg.q qVarS;
        fs fsVar = this.x;
        if (fsVar == null || (qVarS = fsVar.s()) == null) {
            return null;
        }
        return qg(qVarS, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz() {
        fs fsVar;
        final int i;
        int i2;
        int i3;
        int i4;
        if (this.cy == null || (fsVar = this.x) == null) {
            return;
        }
        py pyVarHu = fsVar.hu();
        final w.q qVarFs = this.cy.fs();
        if (qVarFs == null || pyVarHu == null || (i = qVarFs.n) < 0) {
            return;
        }
        int i5 = -1;
        if (qVarFs.l == null || qVarFs.l.length < 2) {
            i2 = -1;
            i3 = -1;
        } else {
            i2 = qVarFs.l[0];
            i3 = qVarFs.l[1];
        }
        String strN = pyVarHu.n(qVarFs.s);
        String strN2 = pyVarHu.n(qVarFs.q);
        try {
            i4 = !TextUtils.isEmpty(strN) ? Integer.parseInt(strN) : -1;
            try {
                if (!TextUtils.isEmpty(strN2)) {
                    i5 = Integer.parseInt(strN2);
                }
            } catch (NumberFormatException unused) {
            }
        } catch (NumberFormatException unused2) {
            i4 = -1;
        }
        final int i6 = i5;
        final int i7 = i4;
        if (qVarFs.cp == 2 && qVarFs.d != null) {
            this.an = new ArrayList(3);
            this.f = new ArrayList(3);
            for (String str : qVarFs.d) {
                if (!TextUtils.isEmpty(str)) {
                    com.byazt.eg.w wVarQ = q(str);
                    if (wVarQ != null) {
                        this.an.add(wVarQ);
                    }
                    com.byazt.eg.d dVarS = s(str);
                    if (dVarS != null) {
                        this.f.add(dVarS);
                    }
                }
            }
            if (this.an.size() != 3 && this.f.size() != 3) {
                this.an.size();
                this.f.size();
                return;
            }
        }
        if (!TextUtils.isEmpty(qVarFs.qg)) {
            this.j = q(qVarFs.qg);
            this.ae = s(qVarFs.qg);
        }
        if (this.an == null && this.j == null && this.f == null && this.ae == null) {
            return;
        }
        this.wo = qVarFs.cp;
        this.u = qVarFs.w;
        this.pk = qVarFs.x;
        this.sh = qVarFs.oa;
        this.fi = i7;
        this.df = i7 - i6;
        this.oj = i2;
        this.dg = i3;
        um();
        n(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.pp.LottieAnimationView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieAnimationView.this.getFrame() < i - 1 || LottieAnimationView.this.getFrame() >= i + 2) {
                    return;
                }
                LottieAnimationView.this.getFrame();
                LottieAnimationView.this.qg(this);
                if (i7 >= 0 && i6 >= 0) {
                    LottieAnimationView.this.lh = 2;
                    if (qVarFs.tj == 1) {
                        LottieAnimationView.this.k();
                    }
                    LottieAnimationView.this.hd();
                    if ((!TextUtils.isEmpty(qVarFs.fs) || (qVarFs.rv != null && qVarFs.rv.length() > 0)) && LottieAnimationView.this.rf != null) {
                        LottieAnimationView.this.rf.n(qVarFs.fs, qVarFs.rv);
                    }
                }
                if (LottieAnimationView.this.sh != 1) {
                    LottieAnimationView.this.x();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        cy();
        this.cd.postDelayed(this.v, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        this.cd.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        cd();
        this.hd.postDelayed(this.y, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd() {
        this.hd.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um() {
        String[] strArrSplit;
        String[] strArrSplit2;
        List<com.byazt.eg.w> list = this.an;
        if (list != null && list.size() == 3) {
            String strQg = qg(this.fi);
            if (!TextUtils.isEmpty(strQg) && (strArrSplit2 = strQg.split(":")) != null && strArrSplit2.length == 3) {
                for (int i = 0; i < 3; i++) {
                    com.byazt.eg.w wVar = this.an.get(i);
                    if (wVar != null) {
                        wVar.n(strArrSplit2[i]);
                    }
                }
            }
        } else {
            com.byazt.eg.w wVar2 = this.j;
            if (wVar2 != null) {
                if (this.wo == 1) {
                    wVar2.n(qg(this.fi));
                } else {
                    wVar2.n(new StringBuilder().append(this.fi).toString());
                }
            }
        }
        List<com.byazt.eg.d> list2 = this.f;
        if (list2 != null && list2.size() == 3) {
            String strQg2 = qg(this.fi);
            if (TextUtils.isEmpty(strQg2) || (strArrSplit = strQg2.split(":")) == null || strArrSplit.length != 3) {
                return;
            }
            for (int i2 = 0; i2 < 3; i2++) {
                com.byazt.eg.d dVar = this.f.get(i2);
                if (dVar != null) {
                    dVar.n(strArrSplit[i2]);
                }
            }
            return;
        }
        com.byazt.eg.d dVar2 = this.ae;
        if (dVar2 != null) {
            if (this.wo == 1) {
                dVar2.n(qg(this.fi));
            } else {
                dVar2.n(new StringBuilder().append(this.fi).toString());
            }
        }
    }

    private String qg(int i) {
        int i2 = i / 3600;
        int i3 = i % 3600;
        int i4 = i3 / 60;
        int i5 = i3 % 60;
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2).append(":");
        if (i4 < 10) {
            sb.append("0");
        }
        sb.append(i4).append(":");
        if (i5 < 10) {
            sb.append("0");
        }
        sb.append(i5);
        return sb.toString();
    }

    public void setComposition(w wVar) {
        boolean z = l.n;
        this.x.setCallback(this);
        this.cy = wVar;
        this.tj = true;
        boolean zN = this.x.n(wVar, getContext().getApplicationContext());
        this.tj = false;
        if (getDrawable() != this.x || zN) {
            if (!zN) {
                py();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<d> it = this.sz.iterator();
            while (it.hasNext()) {
                it.next().n(wVar);
            }
        }
    }

    public w getComposition() {
        return this.cy;
    }

    public void n() {
        if (this.ln == 0) {
            this.ln = SystemClock.elapsedRealtime();
        }
        this.oa.add(q.PLAY_OPTION);
        this.x.d();
    }

    public void qg() {
        this.oa.add(q.PLAY_OPTION);
        this.x.sz();
    }

    public void setMinFrame(int i) {
        this.x.n(i);
    }

    public float getMinFrame() {
        return this.x.k();
    }

    public void setMinProgress(float f) {
        this.x.n(f);
    }

    public void setMaxFrame(int i) {
        this.x.qg(i);
    }

    public float getMaxFrame() {
        return this.x.cy();
    }

    public void setMaxProgress(float f) {
        this.x.qg(f);
    }

    public void setMinFrame(String str) {
        this.x.qg(str);
    }

    public void setMaxFrame(String str) {
        this.x.s(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.x.q(str);
    }

    public void setSpeed(float f) {
        this.x.s(f);
    }

    public float getSpeed() {
        return this.x.hd();
    }

    public void n(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.x.n(animatorUpdateListener);
    }

    public void qg(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.x.qg(animatorUpdateListener);
    }

    public void s() {
        this.x.cd();
    }

    public void n(Animator.AnimatorListener animatorListener) {
        this.x.n(animatorListener);
    }

    public void qg(Animator.AnimatorListener animatorListener) {
        this.x.qg(animatorListener);
    }

    public void q() {
        this.x.um();
    }

    @Deprecated
    public void n(boolean z) {
        this.x.l(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.oa.add(q.SET_REPEAT_MODE);
        this.x.q(i);
    }

    public int getRepeatMode() {
        return this.x.py();
    }

    public void setRepeatCount(int i) {
        this.oa.add(q.SET_REPEAT_COUNT);
        this.x.l(i);
    }

    public int getRepeatCount() {
        return this.x.ou();
    }

    public boolean l() {
        return this.x.wm();
    }

    public void setImageAssetsFolder(String str) {
        this.x.n(str);
    }

    public String getImageAssetsFolder() {
        return this.x.l();
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.x.qg(z);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.x.w();
    }

    public Bitmap n(String str, Bitmap bitmap) {
        return this.x.n(str, bitmap);
    }

    public void setImageAssetDelegate(com.byazt.pp.q qVar) {
        this.t = true;
        this.x.n(qVar);
    }

    public void setDefaultFontFileExtension(String str) {
        this.x.x(str);
    }

    public void setFontAssetDelegate(com.byazt.pp.s sVar) {
        this.x.n(sVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.x.n(map);
    }

    public void setTextDelegate(py pyVar) {
        this.x.n(pyVar);
    }

    public void setViewDelegate(ou ouVar) {
        this.x.n(ouVar);
    }

    public void w() {
        this.oa.add(q.PLAY_OPTION);
        this.x.ur();
    }

    public void x() {
        this.cp = false;
        this.x.bb();
    }

    public void setFrame(int i) {
        this.x.s(i);
    }

    public int getFrame() {
        return this.x.a();
    }

    public void setProgress(float f) {
        n(f, true);
    }

    private void n(float f, boolean z) {
        if (z) {
            this.oa.add(q.SET_PROGRESS);
        }
        this.x.q(f);
    }

    public float getProgress() {
        return this.x.ln();
    }

    public long getDuration() {
        w wVar = this.cy;
        if (wVar != null) {
            return (long) wVar.l();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.x.s(z);
    }

    public um getPerformanceTracker() {
        return this.x.rv();
    }

    private void a() {
        this.cy = null;
        this.x.cp();
    }

    public void setSafeMode(boolean z) {
        this.x.w(z);
    }

    public void setRenderMode(a aVar) {
        this.x.n(aVar);
    }

    public a getRenderMode() {
        return this.x.x();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.x.l(z);
    }

    public boolean n(d dVar) {
        w wVar = this.cy;
        if (wVar != null) {
            dVar.n(wVar);
        }
        return this.sz.add(dVar);
    }

    private void py() {
        boolean zL = l();
        setImageDrawable(null);
        setImageDrawable(this.x);
        if (zL) {
            this.x.sz();
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 1519})
    private static class s extends View.BaseSavedState {
        public static final Parcelable.Creator<s> CREATOR = new Parcelable.Creator<s>() { // from class: com.byazt.pp.LottieAnimationView.s.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public s createFromParcel(Parcel parcel) {
                return new s(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public s[] newArray(int i) {
                return new s[i];
            }
        };
        public String l;
        public String n;
        public boolean q;
        public int qg;
        public float s;
        public int w;
        public int x;

        public s(Parcelable parcelable) {
            super(parcelable);
        }

        private s(Parcel parcel) {
            super(parcel);
            this.n = parcel.readString();
            this.s = parcel.readFloat();
            this.q = parcel.readInt() == 1;
            this.l = parcel.readString();
            this.w = parcel.readInt();
            this.x = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.n);
            parcel.writeFloat(this.s);
            parcel.writeInt(this.q ? 1 : 0);
            parcel.writeString(this.l);
            parcel.writeInt(this.w);
            parcel.writeInt(this.x);
        }
    }

    public void setLottieClicklistener(qg qgVar) {
        this.rf = qgVar;
    }

    public void setLottieAnimListener(n nVar) {
        this.dh = nVar;
    }

    public void setEventMonitorProxy(com.byazt.rx.s sVar) {
        this.m = sVar;
    }

    public void setTriggerManagerProxy(com.byazt.rx.q qVar) {
        this.hu = qVar;
    }

    public com.byazt.rx.q getTriggerManagerProxy() {
        return this.hu;
    }

    public void setTriggerScenarioId(String str) {
        this.h = str;
    }

    private String getTriggerScenarioId() {
        return this.h;
    }

    public void n(String str, com.byazt.vk.rv rvVar) {
        if (this.cy != null) {
            com.byazt.vk.n.n().n(this.cy.d(), str, rvVar);
        } else if (rvVar != null) {
            rvVar.n();
        }
    }
}
