package com.byazt.dx;

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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 478})
public class LottieAnimationView extends ImageView {
    public com.byazt.cg.hn a;
    public int aj;
    public String b;
    public vk<Throwable> c;
    public final RectF cz;
    public List<com.byazt.cg.uc> e;
    public int er;
    public final com.byazt.wg.pr fo;
    public final zo fw;
    public final Set<k> g;
    public Handler gz;
    public final vk<uc> hn;
    public g<uc> ho;
    public final Runnable hs;
    public int i;
    public pr ie;
    public JSONArray ii;
    public volatile boolean iu;
    public boolean k;
    public final Handler lb;
    public List<com.byazt.cg.k> ls;
    public final Set<x> m;
    public com.byazt.cg.uc n;
    public long nl;
    public uc nt;
    public hw nw;
    public final RectF ny;
    public String of;
    public com.byazt.n.hw qa;
    public int qi;
    public int qn;
    public int r;
    public com.byazt.wg.hn rc;
    public com.byazt.cg.k s;
    public int uc;
    public int v;
    public int ve;
    public boolean vk;
    public boolean w;
    public final Runnable ww;
    public final vk<Throwable> x;
    public volatile int y;
    public final Handler yb;
    public com.byazt.wg.x z;
    public String zo;
    public static final String pr = LottieAnimationView.class.getSimpleName();
    public static final vk<Throwable> hw = new vk<Throwable>() { // from class: com.byazt.dx.LottieAnimationView.1
        @Override // com.byazt.dx.vk
        public void pr(Throwable th) {
            if (com.byazt.ptr.vk.pr(th)) {
                com.byazt.ptr.uc.pr("Unable to load composition.", th);
            } else {
                com.byazt.ptr.uc.pr("Unable to parse composition:", th);
            }
        }
    };

    public interface hw {
        void pr(String str, JSONArray jSONArray);
    }

    public interface pr {
        void hw(Map<String, Object> map);

        void pr(Map<String, Object> map);
    }

    private enum x {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public static /* synthetic */ int cz(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.er;
        lottieAnimationView.er = i - 1;
        return i;
    }

    public static /* synthetic */ int x(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.ve;
        lottieAnimationView.ve = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final uc ucVar, com.byazt.rwn.x xVar) {
        com.byazt.rwn.uc.pr().pr(xVar, new com.byazt.rwn.fw() { // from class: com.byazt.dx.LottieAnimationView.10
            @Override // com.byazt.rwn.fw
            public void pr(com.byazt.rwn.x xVar2) {
                LottieAnimationView.this.setComposition(ucVar);
            }

            @Override // com.byazt.rwn.fw
            public void pr(com.byazt.rwn.x xVar2, int i, String str) {
                LottieAnimationView.this.pr(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, String str) {
        pr(new Exception("Lottie zip download failed, errorCode: " + i + ", errorDesc: " + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Throwable th) {
        int i = this.uc;
        if (i != 0) {
            setImageResource(i);
        }
        vk<Throwable> vkVar = this.c;
        if (vkVar == null) {
            vkVar = hw;
        }
        vkVar.pr(th);
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.hn = new vk<uc>() { // from class: com.byazt.dx.LottieAnimationView.9
            @Override // com.byazt.dx.vk
            public void pr(uc ucVar) {
                uc.hw hwVarK = ucVar.k();
                com.byazt.rwn.x xVar = hwVarK != null ? hwVarK.zo : null;
                if (xVar != null && !com.byazt.rwn.uc.pr().hn()) {
                    LottieAnimationView.this.pr(ucVar, xVar);
                } else {
                    LottieAnimationView.this.setComposition(ucVar);
                }
            }
        };
        this.x = new vk<Throwable>() { // from class: com.byazt.dx.LottieAnimationView.11
            @Override // com.byazt.dx.vk
            public void pr(Throwable th) {
                LottieAnimationView.this.pr(th);
            }
        };
        this.uc = 0;
        this.fw = new zo(this);
        this.vk = false;
        this.w = false;
        this.k = true;
        this.m = new HashSet();
        this.g = new HashSet();
        this.yb = new Handler(Looper.getMainLooper());
        this.lb = new Handler(Looper.getMainLooper());
        this.cz = new RectF();
        this.ny = new RectF();
        this.fo = new com.byazt.wg.pr() { // from class: com.byazt.dx.LottieAnimationView.12
            @Override // com.byazt.wg.pr
            public void pr() {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.pr(lottieAnimationView.a);
            }
        };
        this.iu = false;
        this.ve = 0;
        this.nl = 0L;
        this.y = 0;
        this.ww = new Runnable() { // from class: com.byazt.dx.LottieAnimationView.6
            @Override // java.lang.Runnable
            public void run() {
                LottieAnimationView.this.ho();
                if (LottieAnimationView.this.y == 0) {
                    return;
                }
                if (LottieAnimationView.this.isShown()) {
                    if (LottieAnimationView.this.y == 1) {
                        LottieAnimationView.this.y = 2;
                        LottieAnimationView.this.yb();
                        return;
                    }
                    return;
                }
                if (LottieAnimationView.this.y == 2) {
                    LottieAnimationView.this.y = 1;
                    LottieAnimationView.this.lb();
                }
            }
        };
        this.hs = new Runnable() { // from class: com.byazt.dx.LottieAnimationView.7
            @Override // java.lang.Runnable
            public void run() {
                int unused = LottieAnimationView.this.er;
                int unused2 = LottieAnimationView.this.v;
                if (LottieAnimationView.this.er <= LottieAnimationView.this.v) {
                    LottieAnimationView.this.y = 0;
                    LottieAnimationView.this.nt();
                    if (LottieAnimationView.this.qi < 0 || LottieAnimationView.this.qn < 0) {
                        int unused3 = LottieAnimationView.this.qi;
                        int unused4 = LottieAnimationView.this.qn;
                    } else {
                        int unused5 = LottieAnimationView.this.qi;
                        LottieAnimationView.this.hw();
                        LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                        lottieAnimationView.setFrame(lottieAnimationView.qi);
                        LottieAnimationView.this.pr(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.dx.LottieAnimationView.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (LottieAnimationView.this.getFrame() >= LottieAnimationView.this.qn - 1 && LottieAnimationView.this.getFrame() < LottieAnimationView.this.qn + 2) {
                                    int unused6 = LottieAnimationView.this.qn;
                                    LottieAnimationView.this.hw(this);
                                    LottieAnimationView.this.fw();
                                }
                            }
                        });
                    }
                    if ((!TextUtils.isEmpty(LottieAnimationView.this.of) || (LottieAnimationView.this.ii != null && LottieAnimationView.this.ii.length() > 0)) && LottieAnimationView.this.nw != null) {
                        LottieAnimationView.this.nw.pr(LottieAnimationView.this.of, LottieAnimationView.this.ii);
                        return;
                    }
                    return;
                }
                LottieAnimationView.cz(LottieAnimationView.this);
                LottieAnimationView.this.qa();
                LottieAnimationView.this.invalidate();
                LottieAnimationView.this.yb();
            }
        };
        zo();
    }

    private void zo() {
        boolean z = false;
        setSaveEnabled(false);
        this.k = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        pr(0.0f, false);
        pr(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        zo zoVar = this.fw;
        if (com.byazt.ptr.vk.pr(getContext()) != 0.0f) {
            z = true;
        }
        zoVar.pr(Boolean.valueOf(z));
        aj();
        vk();
        k();
    }

    public void setAutoPlay(boolean z) {
        this.w = z;
    }

    private void aj() {
        pr(new Animator.AnimatorListener() { // from class: com.byazt.dx.LottieAnimationView.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LottieAnimationView.this.hw(this);
                LottieAnimationView.this.g();
                LottieAnimationView.this.w();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void vk() {
        pr(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.dx.LottieAnimationView.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if ((animatedValue instanceof Float) && ((Float) animatedValue).floatValue() >= 0.98f) {
                    LottieAnimationView.x(LottieAnimationView.this);
                    uc.hw globalConfig = LottieAnimationView.this.getGlobalConfig();
                    if (globalConfig != null && globalConfig.x > 0 && globalConfig.x > LottieAnimationView.this.ve) {
                        LottieAnimationView.this.g();
                        LottieAnimationView.this.pr();
                        LottieAnimationView.this.setProgress(0.0f);
                        return;
                    }
                    LottieAnimationView.this.hw(this);
                    if (LottieAnimationView.this.ie != null) {
                        Map<String, Object> map = null;
                        if (globalConfig != null && globalConfig.hn != null) {
                            map = globalConfig.hn;
                        }
                        LottieAnimationView.this.ie.hw(map);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        final uc.hw globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.c <= 0) {
            return;
        }
        if (!TextUtils.isEmpty(globalConfig.uc) || globalConfig.fw != null) {
            int maxFrame = globalConfig.c;
            if (maxFrame > getMaxFrame()) {
                maxFrame = (int) getMaxFrame();
            }
            final float maxFrame2 = maxFrame / getMaxFrame();
            pr(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.dx.LottieAnimationView.15
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if ((animatedValue instanceof Float) && ((Float) animatedValue).floatValue() >= maxFrame2) {
                        LottieAnimationView.this.hw(this);
                        if (LottieAnimationView.this.nw != null) {
                            LottieAnimationView.this.nw.pr(globalConfig.uc, globalConfig.fw);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(long j) {
        uc.hw globalConfig = getGlobalConfig();
        if (this.ie != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j));
            if (globalConfig != null && globalConfig.hw != null && !globalConfig.hw.isEmpty()) {
                map.putAll(globalConfig.hw);
            }
            this.ie.pr(map);
        }
    }

    private void k() {
        pr(new Animator.AnimatorListener() { // from class: com.byazt.dx.LottieAnimationView.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                cz czVarZ;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.nl;
                LottieAnimationView.this.hw(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (czVarZ = LottieAnimationView.this.fw.z()) != null) {
                    try {
                        int i = Integer.parseInt(czVarZ.pr(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.nl > 0) {
                            long jElapsedRealtime2 = (LottieAnimationView.this.nl + ((long) i)) - SystemClock.elapsedRealtime();
                            if (jElapsedRealtime2 > 0) {
                                LottieAnimationView.this.fw();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.gz == null) {
                                    LottieAnimationView.this.gz = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.gz.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.gz.postDelayed(new Runnable() { // from class: com.byazt.dx.LottieAnimationView.16.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.pr();
                                        LottieAnimationView.this.pr(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException e) {
                    }
                }
                LottieAnimationView.this.pr(jElapsedRealtime);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    public void setVideoStats(com.byazt.n.hw hwVar) {
        this.qa = hwVar;
    }

    public com.byazt.n.hw getVideoStats() {
        return this.qa;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        m();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        m();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        zo zoVar;
        if (!this.vk && drawable == (zoVar = this.fw) && zoVar.fo()) {
            fw();
        } else if (!this.vk && (drawable instanceof zo)) {
            zo zoVar2 = (zo) drawable;
            if (zoVar2.fo()) {
                zoVar2.gz();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof zo) && ((zo) drawable).fw() == a.SOFTWARE) {
            this.fw.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        zo zoVar = this.fw;
        if (drawable2 == zoVar) {
            super.invalidateDrawable(zoVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        uc ucVarIu;
        zo zoVar = this.fw;
        if (zoVar != null && (ucVarIu = zoVar.iu()) != null) {
            return ucVarIu.aj();
        }
        return null;
    }

    private aj pr(String str) {
        zo zoVar;
        uc ucVarIu;
        Map<String, aj> mapYb;
        if (TextUtils.isEmpty(str) || (zoVar = this.fw) == null || (ucVarIu = zoVar.iu()) == null || (mapYb = ucVarIu.yb()) == null) {
            return null;
        }
        return mapYb.get(str);
    }

    private uc.pr getArea() {
        uc ucVarIu;
        zo zoVar = this.fw;
        if (zoVar != null && (ucVarIu = zoVar.iu()) != null) {
            return ucVarIu.vk();
        }
        return null;
    }

    private uc.hn getGlobalEvent() {
        uc ucVarIu;
        zo zoVar = this.fw;
        if (zoVar != null && (ucVarIu = zoVar.iu()) != null) {
            return ucVarIu.w();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uc.hw getGlobalConfig() {
        uc ucVarIu;
        zo zoVar = this.fw;
        if (zoVar != null && (ucVarIu = zoVar.iu()) != null) {
            return ucVarIu.k();
        }
        return null;
    }

    private void pr(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i >= 0 && i2 >= 0) {
                lb();
                pr();
                setFrame(i);
                pr(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.dx.LottieAnimationView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (LottieAnimationView.this.getFrame() >= i2 - 1 && LottieAnimationView.this.getFrame() < i2 + 2) {
                            LottieAnimationView.this.getFrame();
                            LottieAnimationView.this.hw(this);
                            LottieAnimationView.this.fw();
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    private void pr(uc.pr prVar) {
        prVar.c = com.byazt.ptr.vk.pr("x", prVar.pr, getWidth());
        prVar.uc = com.byazt.ptr.vk.pr("y", prVar.hw, getHeight());
        prVar.fw = com.byazt.ptr.vk.pr((String) null, prVar.hn, getWidth());
        prVar.zo = com.byazt.ptr.vk.pr((String) null, prVar.x, getHeight());
    }

    private boolean pr(aj ajVar) {
        if (ajVar != null) {
            if (!TextUtils.isEmpty(ajVar.fw())) {
                return true;
            }
            if (ajVar.aj() != null && ajVar.aj().length() > 0) {
                return true;
            }
            if ((ajVar.zo() != null && ajVar.zo().length > 0) || !TextUtils.isEmpty(ajVar.nt())) {
                return true;
            }
        }
        uc.hw globalConfig = getGlobalConfig();
        if (globalConfig != null && !TextUtils.isEmpty(globalConfig.aj)) {
            return true;
        }
        uc.hn globalEvent = getGlobalEvent();
        if (globalEvent != null) {
            if (!TextUtils.isEmpty(globalEvent.pr)) {
                return true;
            }
            if (globalEvent.hn != null && globalEvent.hn.length() > 0) {
                return true;
            }
            if ((globalEvent.hw != null && globalEvent.hw.length > 0) || !TextUtils.isEmpty(globalEvent.c)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        String str;
        String str2;
        JSONArray jSONArray;
        int i;
        String str3;
        if (motionEvent.getAction() == 0) {
            uc.pr area = getArea();
            if (area != null) {
                if (area.c == -1.0f) {
                    pr(area);
                }
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                if (x2 < area.c || x2 > area.c + area.fw || y < area.uc || y > area.uc + area.zo) {
                    getWidth();
                    getHeight();
                    return false;
                }
            }
            com.byazt.cg.hn hnVarPr = pr(motionEvent);
            if (hnVarPr == null || (hnVarPr instanceof com.byazt.cg.x)) {
                if (getGlobalConfig() != null && getGlobalConfig().pr == 1) {
                    return false;
                }
                return super.onTouchEvent(motionEvent);
            }
            String strW = hnVarPr.w();
            if (strW != null && strW.startsWith("CSJNTP")) {
                return false;
            }
            this.a = hnVarPr;
        }
        com.byazt.cg.hn hnVar = this.a;
        aj ajVarPr = hnVar != null ? pr(hnVar.fw()) : null;
        if (this.a != null && pr(ajVarPr)) {
            if (this.rc != null) {
                com.byazt.cg.hn hnVar2 = this.a;
                String strW2 = hnVar2.w();
                uc.hn globalEvent = getGlobalEvent();
                if (globalEvent == null) {
                    str = null;
                    str2 = null;
                    jSONArray = null;
                    i = 10;
                } else {
                    String str4 = globalEvent.pr;
                    JSONArray jSONArray2 = globalEvent.hn;
                    int i2 = globalEvent.x;
                    str = globalEvent.c;
                    i = i2;
                    jSONArray = jSONArray2;
                    str2 = str4;
                }
                uc.hw globalConfig = getGlobalConfig();
                if (globalConfig != null && !TextUtils.isEmpty(globalConfig.aj)) {
                    str3 = globalConfig.aj;
                } else {
                    str3 = str;
                }
                zo zoVar = this.fw;
                if (zoVar != null && zoVar.zo()) {
                    hnVar2.pr(this.cz, hnVar2.uc(), true);
                    RectF rectFY = this.fw.y();
                    if (rectFY != null) {
                        pr(this.cz, rectFY);
                    }
                } else {
                    hnVar2.pr(this.ny, hnVar2.uc(), true);
                    hw(this.cz, this.ny);
                }
                this.rc.pr(motionEvent, strW2, ajVarPr, str2, jSONArray, i, str3, this.fo, pr(motionEvent, this.cz));
            }
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.a = null;
                case 2:
                default:
                    return true;
            }
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.cg.hn hnVar) {
        int[][] iArr;
        int[][] iArrZo;
        if (hnVar == null) {
            return;
        }
        String strW = hnVar.w();
        if (strW != null && strW.startsWith("CSJCLOSE")) {
            lb();
        }
        aj ajVarPr = pr(hnVar.fw());
        if (ajVarPr != null && (iArrZo = ajVarPr.zo()) != null) {
            pr(iArrZo);
        } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().hw) != null) {
            pr(iArr);
        }
    }

    private com.byazt.cg.hn pr(MotionEvent motionEvent) {
        com.byazt.cg.x xVarHn;
        zo zoVar = this.fw;
        if (zoVar == null || (xVarHn = zoVar.hn()) == null) {
            return null;
        }
        return pr(xVarHn, motionEvent);
    }

    private com.byazt.cg.hn pr(com.byazt.cg.x xVar, MotionEvent motionEvent) {
        com.byazt.cg.hn hnVarPr;
        for (com.byazt.cg.hn hnVar : xVar.g()) {
            if (hnVar instanceof com.byazt.cg.x) {
                if (hnVar.vk() && hnVar.zo() > 0.0f) {
                    RectF rectF = new RectF();
                    hnVar.pr(rectF, hnVar.uc(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (hnVarPr = pr((com.byazt.cg.x) hnVar, motionEvent)) != null) {
                        return hnVarPr;
                    }
                }
            } else if (hnVar.vk() && hnVar.zo() > 0.0f) {
                RectF rectF2 = new RectF();
                zo zoVar = this.fw;
                if (zoVar != null && zoVar.zo()) {
                    hnVar.pr(rectF2, hnVar.uc(), true);
                    RectF rectFY = this.fw.y();
                    if (rectFY != null) {
                        pr(rectF2, rectFY);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    hnVar.pr(rectF3, hnVar.uc(), true);
                    hw(rectF2, rectF3);
                }
                if (pr(motionEvent, rectF2)) {
                    return hnVar;
                }
            }
        }
        return null;
    }

    private boolean pr(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent == null || rectF == null) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        return x2 >= rectF.left && x2 <= rectF.right && y >= rectF.top && y <= rectF.bottom;
    }

    private void pr(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        switch (AnonymousClass8.pr[getScaleType().ordinal()]) {
            case 1:
                pr(matrix, width, height, fWidth, fHeight);
                break;
            case 2:
                hw(matrix, width, height, fWidth, fHeight);
                break;
            case 3:
                hn(matrix, width, height, fWidth, fHeight);
                break;
            case 4:
                x(matrix, width, height, fWidth, fHeight);
                break;
        }
        matrix.mapRect(rectF);
    }

    /* JADX INFO: renamed from: com.byazt.dx.LottieAnimationView$8, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 229, 1441})
    static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            pr = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private void hw(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.fw.getBounds().width();
        float fHeight = this.fw.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        switch (AnonymousClass8.pr[getScaleType().ordinal()]) {
            case 1:
                pr(matrix, width, height, fWidth, fHeight);
                break;
            case 2:
                hw(matrix, width, height, fWidth, fHeight);
                break;
            case 3:
                hn(matrix, width, height, fWidth, fHeight);
                break;
            case 4:
                x(matrix, width, height, fWidth, fHeight);
                break;
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void pr(Matrix matrix, float f, float f2, float f3, float f4) {
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

    private void hw(Matrix matrix, float f, float f2, float f3, float f4) {
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

    private void hn(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void x(Matrix matrix, float f, float f2, float f3, float f4) {
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
        hn hnVar = new hn(super.onSaveInstanceState());
        hnVar.pr = this.zo;
        hnVar.hw = this.aj;
        hnVar.hn = this.fw.nl();
        hnVar.x = this.fw.rc();
        hnVar.c = this.fw.c();
        hnVar.uc = this.fw.cz();
        hnVar.fw = this.fw.ny();
        return hnVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof hn)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        hn hnVar = (hn) parcelable;
        super.onRestoreInstanceState(hnVar.getSuperState());
        this.zo = hnVar.pr;
        if (!this.m.contains(x.SET_ANIMATION) && !TextUtils.isEmpty(this.zo)) {
            setAnimation(this.zo);
        }
        this.aj = hnVar.hw;
        if (!this.m.contains(x.SET_ANIMATION) && (i = this.aj) != 0) {
            setAnimation(i);
        }
        if (!this.m.contains(x.SET_PROGRESS)) {
            pr(hnVar.hn, false);
        }
        if (!this.m.contains(x.PLAY_OPTION) && hnVar.x) {
            pr();
        }
        if (!this.m.contains(x.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(hnVar.c);
        }
        if (!this.m.contains(x.SET_REPEAT_MODE)) {
            setRepeatMode(hnVar.uc);
        }
        if (!this.m.contains(x.SET_REPEAT_COUNT)) {
            setRepeatCount(hnVar.fw);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.w) {
            this.fw.k();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        lb();
        nt();
        Handler handler = this.gz;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        x();
        hn();
        uc();
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.fw.fw(z);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.fw.zo(z);
    }

    public void pr(boolean z, Context context) {
        this.fw.pr(z, context);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.fw.pr(z);
    }

    public boolean getClipToCompositionBounds() {
        return this.fw.x();
    }

    public void setCacheComposition(boolean z) {
        this.k = z;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.fw.x(z);
    }

    public void setAnimation(int i) {
        this.aj = i;
        this.zo = null;
        setCompositionTask(pr(i));
    }

    private g<uc> pr(final int i) {
        if (isInEditMode()) {
            return new g<>(new Callable<m<uc>>() { // from class: com.byazt.dx.LottieAnimationView.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public m<uc> call() throws Exception {
                    return LottieAnimationView.this.k ? fw.hw(LottieAnimationView.this.getContext(), i) : fw.hw(LottieAnimationView.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.k ? fw.pr(getContext(), i) : fw.pr(getContext(), i, (String) null);
    }

    public void setAnimation(String str) {
        this.zo = str;
        this.aj = 0;
        setCompositionTask(hw(str));
    }

    private g<uc> hw(final String str) {
        if (isInEditMode()) {
            return new g<>(new Callable<m<uc>>() { // from class: com.byazt.dx.LottieAnimationView.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public m<uc> call() throws Exception {
                    return LottieAnimationView.this.k ? fw.hn(LottieAnimationView.this.getContext(), str) : fw.hn(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.k ? fw.hw(getContext(), str) : fw.hw(getContext(), str, (String) null);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        pr(str, (String) null);
    }

    public void pr(String str, String str2) {
        if (!this.iu) {
            throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromJson");
        }
        pr(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void pr(InputStream inputStream, String str) {
        setCompositionTask(fw.pr(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        if (!this.iu) {
            throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromUrl");
        }
        setCompositionTask(this.k ? fw.pr(getContext(), str) : fw.pr(getContext(), str, (String) null));
    }

    public void hw(String str, String str2) {
        if (!this.iu) {
            throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromUrl");
        }
        setCompositionTask(fw.pr(getContext(), str, str2));
    }

    public void setFailureListener(vk<Throwable> vkVar) {
        this.c = vkVar;
    }

    public void setFallbackResource(int i) {
        this.uc = i;
    }

    private void setCompositionTask(g<uc> gVar) {
        this.m.add(x.SET_ANIMATION);
        a();
        m();
        this.ho = gVar.pr(this.hn).hn(this.x);
    }

    private void m() {
        g<uc> gVar = this.ho;
        if (gVar != null) {
            gVar.hw(this.hn);
            this.ho.x(this.x);
        }
    }

    private com.byazt.cg.k pr(com.byazt.cg.x xVar, String str) {
        for (com.byazt.cg.hn hnVar : xVar.g()) {
            if (hnVar instanceof com.byazt.cg.x) {
                com.byazt.cg.k kVarPr = pr((com.byazt.cg.x) hnVar, str);
                if (kVarPr != null) {
                    return kVarPr;
                }
            } else if (TextUtils.equals(str, hnVar.w()) && (hnVar instanceof com.byazt.cg.k)) {
                return (com.byazt.cg.k) hnVar;
            }
        }
        return null;
    }

    private com.byazt.cg.k hn(String str) {
        com.byazt.cg.x xVarHn;
        zo zoVar = this.fw;
        if (zoVar == null || (xVarHn = zoVar.hn()) == null) {
            return null;
        }
        return pr(xVarHn, str);
    }

    private com.byazt.cg.uc hw(com.byazt.cg.x xVar, String str) {
        for (com.byazt.cg.hn hnVar : xVar.g()) {
            if (hnVar instanceof com.byazt.cg.x) {
                com.byazt.cg.uc ucVarHw = hw((com.byazt.cg.x) hnVar, str);
                if (ucVarHw != null) {
                    return ucVarHw;
                }
            } else if (TextUtils.equals(str, hnVar.w()) && (hnVar instanceof com.byazt.cg.uc)) {
                return (com.byazt.cg.uc) hnVar;
            }
        }
        return null;
    }

    private com.byazt.cg.uc x(String str) {
        com.byazt.cg.x xVarHn;
        zo zoVar = this.fw;
        if (zoVar == null || (xVarHn = zoVar.hn()) == null) {
            return null;
        }
        return hw(xVarHn, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        zo zoVar;
        final int i;
        int i2;
        int i3;
        int i4;
        int i5;
        final int i6;
        if (this.nt != null && (zoVar = this.fw) != null) {
            cz czVarZ = zoVar.z();
            final uc.x xVarZo = this.nt.zo();
            if (xVarZo == null || czVarZ == null || (i = xVarZo.pr) < 0) {
                return;
            }
            if (xVarZo.c != null && xVarZo.c.length >= 2) {
                i2 = xVarZo.c[0];
                i3 = xVarZo.c[1];
            } else {
                i2 = -1;
                i3 = -1;
            }
            String strPr = czVarZ.pr(xVarZo.hn);
            String strPr2 = czVarZ.pr(xVarZo.x);
            try {
                i4 = Integer.parseInt(strPr);
                try {
                    i5 = Integer.parseInt(strPr2);
                    i6 = i4;
                } catch (NumberFormatException e) {
                    i5 = -1;
                    i6 = i4;
                }
            } catch (NumberFormatException e2) {
                i4 = -1;
            }
            if (xVarZo.w == 2 && xVarZo.k != null) {
                this.e = new ArrayList(3);
                this.ls = new ArrayList(3);
                for (String str : xVarZo.k) {
                    if (!TextUtils.isEmpty(str)) {
                        com.byazt.cg.uc ucVarX = x(str);
                        if (ucVarX != null) {
                            this.e.add(ucVarX);
                        }
                        com.byazt.cg.k kVarHn = hn(str);
                        if (kVarHn != null) {
                            this.ls.add(kVarHn);
                        }
                    }
                }
                if (this.e.size() != 3 && this.ls.size() != 3) {
                    this.e.size();
                    this.ls.size();
                    return;
                }
            }
            if (!TextUtils.isEmpty(xVarZo.hw)) {
                this.n = x(xVarZo.hw);
                this.s = hn(xVarZo.hw);
            }
            if (this.e != null || this.n != null || this.ls != null || this.s != null) {
                this.i = xVarZo.w;
                this.of = xVarZo.uc;
                this.ii = xVarZo.fw;
                this.r = xVarZo.m;
                this.er = i6;
                this.v = i6 - i5;
                this.qi = i2;
                this.qn = i3;
                qa();
                final int i7 = i5;
                pr(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.dx.LottieAnimationView.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (LottieAnimationView.this.getFrame() >= i - 1 && LottieAnimationView.this.getFrame() < i + 2) {
                            LottieAnimationView.this.getFrame();
                            LottieAnimationView.this.hw(this);
                            if (i6 >= 0 && i7 >= 0) {
                                LottieAnimationView.this.y = 2;
                                if (xVarZo.vk == 1) {
                                    LottieAnimationView.this.ho();
                                }
                                LottieAnimationView.this.yb();
                                if ((!TextUtils.isEmpty(xVarZo.zo) || (xVarZo.aj != null && xVarZo.aj.length() > 0)) && LottieAnimationView.this.nw != null) {
                                    LottieAnimationView.this.nw.pr(xVarZo.zo, xVarZo.aj);
                                }
                            }
                            if (LottieAnimationView.this.r != 1) {
                                LottieAnimationView.this.fw();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho() {
        nt();
        this.lb.postDelayed(this.ww, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt() {
        this.lb.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        lb();
        this.yb.postDelayed(this.hs, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb() {
        this.yb.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        String[] strArrSplit;
        String[] strArrSplit2;
        List<com.byazt.cg.uc> list = this.e;
        if (list != null && list.size() == 3) {
            String strHw = hw(this.er);
            if (!TextUtils.isEmpty(strHw) && (strArrSplit2 = strHw.split(":")) != null && strArrSplit2.length == 3) {
                for (int i = 0; i < 3; i++) {
                    com.byazt.cg.uc ucVar = this.e.get(i);
                    if (ucVar != null) {
                        ucVar.pr(strArrSplit2[i]);
                    }
                }
            }
        } else {
            com.byazt.cg.uc ucVar2 = this.n;
            if (ucVar2 != null) {
                if (this.i == 1) {
                    ucVar2.pr(hw(this.er));
                } else {
                    ucVar2.pr(new StringBuilder().append(this.er).toString());
                }
            }
        }
        List<com.byazt.cg.k> list2 = this.ls;
        if (list2 == null || list2.size() != 3) {
            com.byazt.cg.k kVar = this.s;
            if (kVar != null) {
                if (this.i == 1) {
                    kVar.pr(hw(this.er));
                    return;
                } else {
                    kVar.pr(new StringBuilder().append(this.er).toString());
                    return;
                }
            }
            return;
        }
        String strHw2 = hw(this.er);
        if (TextUtils.isEmpty(strHw2) || (strArrSplit = strHw2.split(":")) == null || strArrSplit.length != 3) {
            return;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            com.byazt.cg.k kVar2 = this.ls.get(i2);
            if (kVar2 != null) {
                kVar2.pr(strArrSplit[i2]);
            }
        }
    }

    private String hw(int i) {
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

    public void setComposition(uc ucVar) {
        boolean z = c.pr;
        this.fw.setCallback(this);
        this.nt = ucVar;
        this.vk = true;
        boolean zPr = this.fw.pr(ucVar, getContext().getApplicationContext());
        this.vk = false;
        if (getDrawable() == this.fw && !zPr) {
            return;
        }
        if (!zPr) {
            cz();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator<k> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().pr(ucVar);
        }
    }

    public uc getComposition() {
        return this.nt;
    }

    public void pr() {
        if (this.nl == 0) {
            this.nl = SystemClock.elapsedRealtime();
        }
        this.m.add(x.PLAY_OPTION);
        this.fw.k();
    }

    public void hw() {
        this.m.add(x.PLAY_OPTION);
        this.fw.g();
    }

    public void setMinFrame(int i) {
        this.fw.pr(i);
    }

    public float getMinFrame() {
        return this.fw.ho();
    }

    public void setMinProgress(float f) {
        this.fw.pr(f);
    }

    public void setMaxFrame(int i) {
        this.fw.hw(i);
    }

    public float getMaxFrame() {
        return this.fw.nt();
    }

    public void setMaxProgress(float f) {
        this.fw.hw(f);
    }

    public void setMinFrame(String str) {
        this.fw.hw(str);
    }

    public void setMaxFrame(String str) {
        this.fw.hn(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.fw.x(str);
    }

    public void setSpeed(float f) {
        this.fw.hn(f);
    }

    public float getSpeed() {
        return this.fw.yb();
    }

    public void pr(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.fw.pr(animatorUpdateListener);
    }

    public void hw(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.fw.hw(animatorUpdateListener);
    }

    public void hn() {
        this.fw.lb();
    }

    public void pr(Animator.AnimatorListener animatorListener) {
        this.fw.pr(animatorListener);
    }

    public void hw(Animator.AnimatorListener animatorListener) {
        this.fw.hw(animatorListener);
    }

    public void x() {
        this.fw.qa();
    }

    @Deprecated
    public void pr(boolean z) {
        this.fw.c(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.m.add(x.SET_REPEAT_MODE);
        this.fw.x(i);
    }

    public int getRepeatMode() {
        return this.fw.cz();
    }

    public void setRepeatCount(int i) {
        this.m.add(x.SET_REPEAT_COUNT);
        this.fw.c(i);
    }

    public int getRepeatCount() {
        return this.fw.ny();
    }

    public boolean c() {
        return this.fw.fo();
    }

    public void setImageAssetsFolder(String str) {
        this.fw.pr(str);
    }

    public String getImageAssetsFolder() {
        return this.fw.c();
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.fw.hw(z);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.fw.uc();
    }

    public Bitmap pr(String str, Bitmap bitmap) {
        return this.fw.pr(str, bitmap);
    }

    public void setImageAssetDelegate(com.byazt.dx.x xVar) {
        this.iu = true;
        this.fw.pr(xVar);
    }

    public void setDefaultFontFileExtension(String str) {
        this.fw.fw(str);
    }

    public void setFontAssetDelegate(com.byazt.dx.hn hnVar) {
        this.fw.pr(hnVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.fw.pr(map);
    }

    public void setTextDelegate(cz czVar) {
        this.fw.pr(czVar);
    }

    public void setViewDelegate(ny nyVar) {
        this.fw.pr(nyVar);
    }

    public void uc() {
        this.m.add(x.PLAY_OPTION);
        this.fw.ve();
    }

    public void fw() {
        this.w = false;
        this.fw.gz();
    }

    public void setFrame(int i) {
        this.fw.hn(i);
    }

    public int getFrame() {
        return this.fw.a();
    }

    public void setProgress(float f) {
        pr(f, true);
    }

    private void pr(float f, boolean z) {
        if (z) {
            this.m.add(x.SET_PROGRESS);
        }
        this.fw.x(f);
    }

    public float getProgress() {
        return this.fw.nl();
    }

    public long getDuration() {
        uc ucVar = this.nt;
        if (ucVar != null) {
            return (long) ucVar.c();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.fw.hn(z);
    }

    public qa getPerformanceTracker() {
        return this.fw.aj();
    }

    private void a() {
        this.nt = null;
        this.fw.w();
    }

    public void setSafeMode(boolean z) {
        this.fw.uc(z);
    }

    public void setRenderMode(a aVar) {
        this.fw.pr(aVar);
    }

    public a getRenderMode() {
        return this.fw.fw();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.fw.c(z);
    }

    public boolean pr(k kVar) {
        uc ucVar = this.nt;
        if (ucVar != null) {
            kVar.pr(ucVar);
        }
        return this.g.add(kVar);
    }

    private void cz() {
        boolean zC = c();
        setImageDrawable(null);
        setImageDrawable(this.fw);
        if (zC) {
            this.fw.g();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 229, 1597})
    private static class hn extends View.BaseSavedState {
        public static final Parcelable.Creator<hn> CREATOR = new Parcelable.Creator<hn>() { // from class: com.byazt.dx.LottieAnimationView.hn.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public hn createFromParcel(Parcel parcel) {
                return new hn(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public hn[] newArray(int i) {
                return new hn[i];
            }
        };
        public String c;
        public int fw;
        public float hn;
        public int hw;
        public String pr;
        public int uc;
        public boolean x;

        public hn(Parcelable parcelable) {
            super(parcelable);
        }

        private hn(Parcel parcel) {
            super(parcel);
            this.pr = parcel.readString();
            this.hn = parcel.readFloat();
            this.x = parcel.readInt() == 1;
            this.c = parcel.readString();
            this.uc = parcel.readInt();
            this.fw = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.pr);
            parcel.writeFloat(this.hn);
            parcel.writeInt(this.x ? 1 : 0);
            parcel.writeString(this.c);
            parcel.writeInt(this.uc);
            parcel.writeInt(this.fw);
        }
    }

    public void setLottieClicklistener(hw hwVar) {
        this.nw = hwVar;
    }

    public void setLottieAnimListener(pr prVar) {
        this.ie = prVar;
    }

    public void setEventMonitorProxy(com.byazt.wg.hn hnVar) {
        this.rc = hnVar;
    }

    public void setTriggerManagerProxy(com.byazt.wg.x xVar) {
        this.z = xVar;
    }

    public com.byazt.wg.x getTriggerManagerProxy() {
        return this.z;
    }

    public void setTriggerScenarioId(String str) {
        this.b = str;
    }

    private String getTriggerScenarioId() {
        return this.b;
    }

    public void pr(String str, com.byazt.rwn.aj ajVar) {
        if (this.nt == null) {
            if (ajVar != null) {
                ajVar.pr();
                return;
            }
            return;
        }
        com.byazt.rwn.pr.pr().pr(this.nt.k(), str, ajVar);
    }
}
