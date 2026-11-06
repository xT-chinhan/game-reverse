package com.bytedance.adsdk.lottie;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class LottieAnimationView extends ImageView {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f113ms = "LottieAnimationView";
    private static final ch<Throwable> xr = new ch<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.1
        @Override // com.bytedance.adsdk.lottie.ch
        public void ms(Throwable th) {
            if (com.bytedance.adsdk.lottie.ka.ny.ms(th)) {
                com.bytedance.adsdk.lottie.ka.ka.ms("Unable to load composition.", th);
            } else {
                com.bytedance.adsdk.lottie.ka.ka.ms("Unable to parse composition:", th);
            }
        }
    };
    private final x ab;
    private final ch<c> ah;
    private c ao;
    private int b;
    private int c;
    private boolean ch;
    private xr cv;
    private final ch<Throwable> d;
    private ms g;
    private final Handler h;
    private boolean hi;
    private int i;
    private ch<Throwable> ka;
    private final Runnable le;
    private com.bytedance.adsdk.lottie.model.layer.c nw;
    private int ny;
    private JSONArray op;
    private int qv;
    private int re;
    private boolean sl;
    private long t;
    private final Set<Object> u;
    private zb<c> ub;
    private int w;
    private String x;
    private Handler y;
    private String yu;
    private final Set<d> zb;

    private enum d {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public interface ms {
        void ms(Map<String, Object> map);

        void xr(Map<String, Object> map);
    }

    public interface xr {
        void ms(String str, JSONArray jSONArray);
    }

    static /* synthetic */ int ka(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.qv;
        lottieAnimationView.qv = i + 1;
        return i;
    }

    static /* synthetic */ int qv(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.b;
        lottieAnimationView.b = i - 1;
        return i;
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.ah = new ch<c>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.6
            @Override // com.bytedance.adsdk.lottie.ch
            public void ms(c cVar) {
                LottieAnimationView.this.setComposition(cVar);
            }
        };
        this.d = new ch<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.7
            @Override // com.bytedance.adsdk.lottie.ch
            public void ms(Throwable th) {
                if (LottieAnimationView.this.c != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.c);
                }
                (LottieAnimationView.this.ka == null ? LottieAnimationView.xr : LottieAnimationView.this.ka).ms(th);
            }
        };
        this.c = 0;
        this.ab = new x(this);
        this.ch = false;
        this.hi = false;
        this.sl = true;
        this.zb = new HashSet();
        this.u = new HashSet();
        this.h = new Handler(Looper.getMainLooper());
        this.qv = 0;
        this.t = 0L;
        this.le = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- timer callback, timer: " + LottieAnimationView.this.b + ", " + LottieAnimationView.this.re);
                if (LottieAnimationView.this.b <= LottieAnimationView.this.re) {
                    if (LottieAnimationView.this.i >= 0 && LottieAnimationView.this.w >= 0) {
                        com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- timer end, play anim, startframe: " + LottieAnimationView.this.i);
                        LottieAnimationView.this.xr();
                        LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                        lottieAnimationView.setFrame(lottieAnimationView.i);
                        LottieAnimationView.this.ms(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (LottieAnimationView.this.getFrame() < LottieAnimationView.this.w - 1 || LottieAnimationView.this.getFrame() >= LottieAnimationView.this.w + 2) {
                                    return;
                                }
                                com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- timer end, play anim, endframe: " + LottieAnimationView.this.w);
                                LottieAnimationView.this.xr(this);
                                LottieAnimationView.this.ab();
                            }
                        });
                    } else {
                        com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- timer end, frame invalid: " + LottieAnimationView.this.i + "," + LottieAnimationView.this.w);
                    }
                    if ((!TextUtils.isEmpty(LottieAnimationView.this.yu) || (LottieAnimationView.this.op != null && LottieAnimationView.this.op.length() > 0)) && LottieAnimationView.this.cv != null) {
                        LottieAnimationView.this.cv.ms(LottieAnimationView.this.yu, LottieAnimationView.this.op);
                        return;
                    }
                    return;
                }
                LottieAnimationView.qv(LottieAnimationView.this);
                LottieAnimationView.this.nw.ms(new StringBuilder().append(LottieAnimationView.this.b).toString());
                LottieAnimationView.this.invalidate();
                LottieAnimationView.this.ao();
            }
        };
        ny();
    }

    private void ny() {
        setSaveEnabled(false);
        this.sl = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        ms(0.0f, false);
        ms(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.ab.ms(Boolean.valueOf(com.bytedance.adsdk.lottie.ka.ny.ms(getContext()) != 0.0f));
        ch();
        hi();
        zb();
    }

    private void ch() {
        ms(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.8
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
                LottieAnimationView.this.xr(this);
                LottieAnimationView.this.ub();
                LottieAnimationView.this.sl();
            }
        });
    }

    private void hi() {
        ms(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                LottieAnimationView.ka(LottieAnimationView.this);
                c.xr globalConfig = LottieAnimationView.this.getGlobalConfig();
                if (globalConfig != null && globalConfig.d > 0 && globalConfig.d > LottieAnimationView.this.qv) {
                    LottieAnimationView.this.ub();
                    LottieAnimationView.this.ms();
                    LottieAnimationView.this.setProgress(0.0f);
                } else {
                    LottieAnimationView.this.xr(this);
                    if (LottieAnimationView.this.g != null) {
                        LottieAnimationView.this.g.xr((globalConfig == null || globalConfig.ah == null) ? null : globalConfig.ah);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl() {
        final c.xr globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.ka <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.c) && globalConfig.ab == null) {
            return;
        }
        int maxFrame = globalConfig.ka;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        ms(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                LottieAnimationView.this.xr(this);
                if (LottieAnimationView.this.cv != null) {
                    LottieAnimationView.this.cv.ms(globalConfig.c, globalConfig.ab);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(long j) {
        c.xr globalConfig = getGlobalConfig();
        if (this.g != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j));
            if (globalConfig != null && globalConfig.xr != null && !globalConfig.xr.isEmpty()) {
                map.putAll(globalConfig.xr);
            }
            this.g.ms(map);
        }
    }

    private void zb() {
        ms(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11
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
                t tVarW;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.t;
                LottieAnimationView.this.xr(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (tVarW = LottieAnimationView.this.ab.w()) != null) {
                    try {
                        int i = Integer.parseInt(tVarW.ms(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.t > 0) {
                            long jElapsedRealtime2 = (LottieAnimationView.this.t + ((long) i)) - SystemClock.elapsedRealtime();
                            com.bytedance.sdk.component.utils.sl.ms("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(jElapsedRealtime2)));
                            if (jElapsedRealtime2 > 0) {
                                LottieAnimationView.this.ab();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.y == null) {
                                    LottieAnimationView.this.y = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.y.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.y.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.bytedance.sdk.component.utils.sl.ms("TMe", "--==-- lottie real start play");
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.ms();
                                        LottieAnimationView.this.ms(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                    }
                }
                LottieAnimationView.this.ms(jElapsedRealtime);
            }
        });
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        u();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        u();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        u();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        x xVar;
        if (!this.ch && drawable == (xVar = this.ab) && xVar.re()) {
            ab();
        } else if (!this.ch && (drawable instanceof x)) {
            x xVar2 = (x) drawable;
            if (xVar2.re()) {
                xVar2.cv();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof x) && ((x) drawable).ab() == y.SOFTWARE) {
            this.ab.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        x xVar = this.ab;
        if (drawable2 == xVar) {
            super.invalidateDrawable(xVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        c cVarOp;
        x xVar = this.ab;
        if (xVar == null || (cVarOp = xVar.op()) == null) {
            return null;
        }
        return cVarOp.ny();
    }

    private ny ms(String str) {
        x xVar;
        c cVarOp;
        Map<String, ny> mapH;
        if (TextUtils.isEmpty(str) || (xVar = this.ab) == null || (cVarOp = xVar.op()) == null || (mapH = cVarOp.h()) == null) {
            return null;
        }
        return mapH.get(str);
    }

    private c.ms getArea() {
        c cVarOp;
        x xVar = this.ab;
        if (xVar == null || (cVarOp = xVar.op()) == null) {
            return null;
        }
        return cVarOp.ch();
    }

    private c.ah getGlobalEvent() {
        c cVarOp;
        x xVar = this.ab;
        if (xVar == null || (cVarOp = xVar.op()) == null) {
            return null;
        }
        return cVarOp.hi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.xr getGlobalConfig() {
        c cVarOp;
        x xVar = this.ab;
        if (xVar == null || (cVarOp = xVar.op()) == null) {
            return null;
        }
        return cVarOp.sl();
    }

    private void ms(int[][] iArr) {
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
            com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- inel enter, play anim, startframe: ".concat(String.valueOf(i)));
            h();
            ms();
            setFrame(i);
            ms(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i2 - 1 || LottieAnimationView.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- inel enter, play anim end, endframe: " + i2 + ", realFrame: " + LottieAnimationView.this.getFrame());
                    LottieAnimationView.this.xr(this);
                    LottieAnimationView.this.ab();
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    private void ms(String str, String str2, JSONArray jSONArray) {
        xr xrVar;
        c.ah globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.f144ms;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.ah;
            }
        }
        if ((!TextUtils.isEmpty(str2) || (jSONArray != null && jSONArray.length() > 0)) && (xrVar = this.cv) != null) {
            xrVar.ms(str2, jSONArray);
        }
    }

    private void ms(c.ms msVar) {
        msVar.ka = com.bytedance.adsdk.lottie.ka.ny.ms("x", msVar.f146ms, getWidth());
        msVar.c = com.bytedance.adsdk.lottie.ka.ny.ms("y", msVar.xr, getHeight());
        msVar.ab = com.bytedance.adsdk.lottie.ka.ny.ms((String) null, msVar.ah, getWidth());
        msVar.x = com.bytedance.adsdk.lottie.ka.ny.ms((String) null, msVar.d, getHeight());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[][] iArr;
        c.ms area = getArea();
        if (area != null) {
            if (area.ka == -1.0f) {
                ms(area);
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x < area.ka || x > area.ka + area.ab || y < area.c || y > area.c + area.x) {
                com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--:width: " + getWidth() + ", height: " + getHeight());
                com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--:".concat(String.valueOf(area)));
                com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--:pintx: " + x + ", pointY: " + y);
                return false;
            }
        }
        com.bytedance.adsdk.lottie.model.layer.ah ahVarMs = ms(motionEvent);
        if (ahVarMs != null) {
            String strHi = ahVarMs.hi();
            if (ahVarMs instanceof com.bytedance.adsdk.lottie.model.layer.d) {
                if (getGlobalConfig() == null || getGlobalConfig().f147ms != 1) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            }
            if (strHi != null && strHi.startsWith("CSJCLOSE")) {
                h();
            }
            ny nyVarMs = ms(ahVarMs.ab());
            if (nyVarMs != null && motionEvent.getAction() == 1) {
                ms(strHi, nyVarMs.ab(), nyVarMs.ny());
                int[][] iArrX = nyVarMs.x();
                if (iArrX != null) {
                    ms(iArrX);
                } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().xr) != null) {
                    ms(iArr);
                }
            }
            if (strHi != null && strHi.startsWith("CSJNTP")) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (getGlobalConfig() == null || getGlobalConfig().f147ms != 1) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private com.bytedance.adsdk.lottie.model.layer.ah ms(MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.d dVarAh;
        x xVar = this.ab;
        if (xVar == null || (dVarAh = xVar.ah()) == null) {
            return null;
        }
        return ms(dVarAh, motionEvent);
    }

    private com.bytedance.adsdk.lottie.model.layer.ah ms(com.bytedance.adsdk.lottie.model.layer.d dVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.ah ahVarMs;
        for (com.bytedance.adsdk.lottie.model.layer.ah ahVar : dVar.u()) {
            if (ahVar instanceof com.bytedance.adsdk.lottie.model.layer.d) {
                if (ahVar.ch() && ahVar.x() > 0.0f) {
                    RectF rectF = new RectF();
                    ahVar.ms(rectF, ahVar.c(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (ahVarMs = ms((com.bytedance.adsdk.lottie.model.layer.d) ahVar, motionEvent)) != null) {
                        return ahVarMs;
                    }
                }
            } else if (ahVar.ch() && ahVar.x() > 0.0f) {
                RectF rectF2 = new RectF();
                x xVar = this.ab;
                if (xVar != null && xVar.x()) {
                    ahVar.ms(rectF2, ahVar.c(), true);
                    RectF rectFOf = this.ab.of();
                    if (rectFOf != null) {
                        ms(rectF2, rectFOf);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    ahVar.ms(rectF3, ahVar.c(), true);
                    xr(rectF2, rectF3);
                }
                if (ms(motionEvent, rectF2)) {
                    return ahVar;
                }
            }
        }
        return null;
    }

    private boolean ms(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void ms(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass5.f123ms[getScaleType().ordinal()];
        if (i == 1) {
            ms(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            xr(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            ah(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            d(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.LottieAnimationView$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f123ms;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f123ms = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f123ms[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f123ms[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f123ms[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void xr(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.ab.getBounds().width();
        float fHeight = this.ab.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass5.f123ms[getScaleType().ordinal()];
        if (i == 1) {
            ms(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            xr(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            ah(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            d(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void ms(Matrix matrix, float f, float f2, float f3, float f4) {
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

    private void xr(Matrix matrix, float f, float f2, float f3, float f4) {
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

    private void ah(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void d(Matrix matrix, float f, float f2, float f3, float f4) {
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
    protected Parcelable onSaveInstanceState() {
        ah ahVar = new ah(super.onSaveInstanceState());
        ahVar.f128ms = this.x;
        ahVar.xr = this.ny;
        ahVar.ah = this.ab.g();
        ahVar.d = this.ab.i();
        ahVar.ka = this.ab.ka();
        ahVar.c = this.ab.nw();
        ahVar.ab = this.ab.b();
        return ahVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof ah)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ah ahVar = (ah) parcelable;
        super.onRestoreInstanceState(ahVar.getSuperState());
        this.x = ahVar.f128ms;
        if (!this.zb.contains(d.SET_ANIMATION) && !TextUtils.isEmpty(this.x)) {
            setAnimation(this.x);
        }
        this.ny = ahVar.xr;
        if (!this.zb.contains(d.SET_ANIMATION) && (i = this.ny) != 0) {
            setAnimation(i);
        }
        if (!this.zb.contains(d.SET_PROGRESS)) {
            ms(ahVar.ah, false);
        }
        if (!this.zb.contains(d.PLAY_OPTION) && ahVar.d) {
            ms();
        }
        if (!this.zb.contains(d.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(ahVar.ka);
        }
        if (!this.zb.contains(d.SET_REPEAT_MODE)) {
            setRepeatMode(ahVar.c);
        }
        if (this.zb.contains(d.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(ahVar.ab);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.hi) {
            return;
        }
        this.ab.sl();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
        Handler handler = this.y;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        d();
        ah();
        c();
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.ab.ab(z);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.ab.x(z);
    }

    public void ms(boolean z, Context context) {
        this.ab.ms(z, context);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.ab.ms(z);
    }

    public boolean getClipToCompositionBounds() {
        return this.ab.d();
    }

    public void setCacheComposition(boolean z) {
        this.sl = z;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.ab.d(z);
    }

    public void setAnimation(int i) {
        this.ny = i;
        this.x = null;
        setCompositionTask(ms(i));
    }

    private zb<c> ms(final int i) {
        if (isInEditMode()) {
            return new zb<>(new Callable<sl<c>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.13
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public sl<c> call() throws Exception {
                    return LottieAnimationView.this.sl ? ab.xr(LottieAnimationView.this.getContext(), i) : ab.xr(LottieAnimationView.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.sl ? ab.ms(getContext(), i) : ab.ms(getContext(), i, (String) null);
    }

    public void setAnimation(String str) {
        this.x = str;
        this.ny = 0;
        setCompositionTask(xr(str));
    }

    private zb<c> xr(final String str) {
        if (isInEditMode()) {
            return new zb<>(new Callable<sl<c>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public sl<c> call() throws Exception {
                    return LottieAnimationView.this.sl ? ab.ah(LottieAnimationView.this.getContext(), str) : ab.ah(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.sl ? ab.xr(getContext(), str) : ab.xr(getContext(), str, (String) null);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        ms(str, (String) null);
    }

    public void ms(String str, String str2) {
        ms(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void ms(InputStream inputStream, String str) {
        setCompositionTask(ab.ms(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.sl ? ab.ms(getContext(), str) : ab.ms(getContext(), str, (String) null));
    }

    public void setFailureListener(ch<Throwable> chVar) {
        this.ka = chVar;
    }

    public void setFallbackResource(int i) {
        this.c = i;
    }

    private void setCompositionTask(zb<c> zbVar) {
        this.zb.add(d.SET_ANIMATION);
        qv();
        u();
        this.ub = zbVar.ms(this.ah).ah(this.d);
    }

    private void u() {
        zb<c> zbVar = this.ub;
        if (zbVar != null) {
            zbVar.xr(this.ah);
            this.ub.d(this.d);
        }
    }

    private com.bytedance.adsdk.lottie.model.layer.c ms(com.bytedance.adsdk.lottie.model.layer.d dVar, String str) {
        for (com.bytedance.adsdk.lottie.model.layer.ah ahVar : dVar.u()) {
            if (ahVar instanceof com.bytedance.adsdk.lottie.model.layer.d) {
                com.bytedance.adsdk.lottie.model.layer.c cVarMs = ms((com.bytedance.adsdk.lottie.model.layer.d) ahVar, str);
                if (cVarMs != null) {
                    return cVarMs;
                }
            } else if (TextUtils.equals(str, ahVar.hi()) && (ahVar instanceof com.bytedance.adsdk.lottie.model.layer.c)) {
                return (com.bytedance.adsdk.lottie.model.layer.c) ahVar;
            }
        }
        return null;
    }

    private com.bytedance.adsdk.lottie.model.layer.c ah(String str) {
        com.bytedance.adsdk.lottie.model.layer.d dVarAh;
        x xVar = this.ab;
        if (xVar == null || (dVarAh = xVar.ah()) == null) {
            return null;
        }
        return ms(dVarAh, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub() {
        x xVar;
        int i;
        int i2;
        final int i3;
        if (this.ao == null || (xVar = this.ab) == null) {
            return;
        }
        t tVarW = xVar.w();
        c.d dVarX = this.ao.x();
        if (dVarX == null || tVarW == null) {
            return;
        }
        final int i4 = dVarX.f145ms;
        if (i4 < 0) {
            com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- timer fail, ke is invalid: ".concat(String.valueOf(i4)));
            return;
        }
        final int i5 = -1;
        if (dVarX.ka == null || dVarX.ka.length < 2) {
            i = -1;
            i2 = -1;
        } else {
            i = dVarX.ka[0];
            i2 = dVarX.ka[1];
        }
        String strMs = tVarW.ms(dVarX.ah);
        String strMs2 = tVarW.ms(dVarX.d);
        try {
            i3 = Integer.parseInt(strMs);
            try {
                i5 = Integer.parseInt(strMs2);
            } catch (NumberFormatException e) {
                e = e;
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        } catch (NumberFormatException e2) {
            e = e2;
            i3 = -1;
        }
        com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- prepare timer, startS: " + i3 + ", lenS: " + i5);
        if (!TextUtils.isEmpty(dVarX.xr)) {
            com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- timer, id:" + dVarX.xr);
            com.bytedance.adsdk.lottie.model.layer.c cVarAh = ah(dVarX.xr);
            if (cVarAh != null) {
                com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- timer success");
                this.yu = dVarX.c;
                this.op = dVarX.ab;
                this.nw = cVarAh;
                this.b = i3;
                this.re = i3 - i5;
                this.i = i;
                this.w = i2;
                cVarAh.ms(new StringBuilder().append(this.b).toString());
                ms(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (LottieAnimationView.this.getFrame() < i4 - 1 || LottieAnimationView.this.getFrame() >= i4 + 2) {
                            return;
                        }
                        com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- enter timer point, frame: " + LottieAnimationView.this.getFrame());
                        LottieAnimationView.this.xr(this);
                        if (i3 >= 0 && i5 >= 0) {
                            com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- enter timer callback, start timer");
                            LottieAnimationView.this.ao();
                        } else {
                            com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- enter timer callback, NOT start timer");
                        }
                        LottieAnimationView.this.ab();
                    }
                });
                return;
            }
            return;
        }
        com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- timer fail, id is invalid: " + dVarX.xr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        this.h.postDelayed(this.le, 1000L);
    }

    private void h() {
        this.h.removeCallbacksAndMessages(null);
    }

    public void setComposition(c cVar) {
        boolean z = ka.f166ms;
        this.ab.setCallback(this);
        this.ao = cVar;
        this.ch = true;
        boolean zMs = this.ab.ms(cVar, getContext().getApplicationContext());
        this.ch = false;
        if (getDrawable() != this.ab || zMs) {
            if (!zMs) {
                y();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.u.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public c getComposition() {
        return this.ao;
    }

    public void ms() {
        if (this.t == 0) {
            this.t = SystemClock.elapsedRealtime();
        }
        this.zb.add(d.PLAY_OPTION);
        this.ab.sl();
    }

    public void xr() {
        this.zb.add(d.PLAY_OPTION);
        this.ab.u();
    }

    public void setMinFrame(int i) {
        this.ab.ms(i);
    }

    public float getMinFrame() {
        return this.ab.ub();
    }

    public void setMinProgress(float f) {
        this.ab.ms(f);
    }

    public void setMaxFrame(int i) {
        this.ab.xr(i);
    }

    public float getMaxFrame() {
        return this.ab.ao();
    }

    public void setMaxProgress(float f) {
        this.ab.xr(f);
    }

    public void setMinFrame(String str) {
        this.ab.xr(str);
    }

    public void setMaxFrame(String str) {
        this.ab.ah(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.ab.d(str);
    }

    public void setSpeed(float f) {
        this.ab.ah(f);
    }

    public float getSpeed() {
        return this.ab.h();
    }

    public void ms(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ab.ms(animatorUpdateListener);
    }

    public void xr(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ab.xr(animatorUpdateListener);
    }

    public void ah() {
        this.ab.qv();
    }

    public void ms(Animator.AnimatorListener animatorListener) {
        this.ab.ms(animatorListener);
    }

    public void xr(Animator.AnimatorListener animatorListener) {
        this.ab.xr(animatorListener);
    }

    public void d() {
        this.ab.y();
    }

    @Deprecated
    public void ms(boolean z) {
        this.ab.ka(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.zb.add(d.SET_REPEAT_MODE);
        this.ab.d(i);
    }

    public int getRepeatMode() {
        return this.ab.nw();
    }

    public void setRepeatCount(int i) {
        this.zb.add(d.SET_REPEAT_COUNT);
        this.ab.ka(i);
    }

    public int getRepeatCount() {
        return this.ab.b();
    }

    public boolean ka() {
        return this.ab.re();
    }

    public void setImageAssetsFolder(String str) {
        this.ab.ms(str);
    }

    public String getImageAssetsFolder() {
        return this.ab.ka();
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.ab.xr(z);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.ab.c();
    }

    public Bitmap ms(String str, Bitmap bitmap) {
        return this.ab.ms(str, bitmap);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.lottie.d dVar) {
        this.ab.ms(dVar);
    }

    public void setDefaultFontFileExtension(String str) {
        this.ab.ab(str);
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.lottie.ah ahVar) {
        this.ab.ms(ahVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.ab.ms(map);
    }

    public void setTextDelegate(t tVar) {
        this.ab.ms(tVar);
    }

    public void setViewDelegate(nw nwVar) {
        this.ab.ms(nwVar);
    }

    public void c() {
        this.zb.add(d.PLAY_OPTION);
        this.ab.le();
    }

    public void ab() {
        this.hi = false;
        this.ab.cv();
    }

    public void setFrame(int i) {
        this.ab.ah(i);
    }

    public int getFrame() {
        return this.ab.t();
    }

    public void setProgress(float f) {
        ms(f, true);
    }

    private void ms(float f, boolean z) {
        if (z) {
            this.zb.add(d.SET_PROGRESS);
        }
        this.ab.d(f);
    }

    public float getProgress() {
        return this.ab.g();
    }

    public long getDuration() {
        c cVar = this.ao;
        if (cVar != null) {
            return (long) cVar.ka();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.ab.ah(z);
    }

    public qv getPerformanceTracker() {
        return this.ab.ny();
    }

    private void qv() {
        this.ao = null;
        this.ab.hi();
    }

    public void setSafeMode(boolean z) {
        this.ab.c(z);
    }

    public void setRenderMode(y yVar) {
        this.ab.ms(yVar);
    }

    public y getRenderMode() {
        return this.ab.ab();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.ab.ka(z);
    }

    private void y() {
        boolean zKa = ka();
        setImageDrawable(null);
        setImageDrawable(this.ab);
        if (zKa) {
            this.ab.u();
        }
    }

    private static class ah extends View.BaseSavedState {
        public static final Parcelable.Creator<ah> CREATOR = new Parcelable.Creator<ah>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.ah.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ah createFromParcel(Parcel parcel) {
                return new ah(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ah[] newArray(int i) {
                return new ah[i];
            }
        };
        int ab;
        float ah;
        int c;
        boolean d;
        String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f128ms;
        int xr;

        ah(Parcelable parcelable) {
            super(parcelable);
        }

        private ah(Parcel parcel) {
            super(parcel);
            this.f128ms = parcel.readString();
            this.ah = parcel.readFloat();
            this.d = parcel.readInt() == 1;
            this.ka = parcel.readString();
            this.c = parcel.readInt();
            this.ab = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f128ms);
            parcel.writeFloat(this.ah);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeString(this.ka);
            parcel.writeInt(this.c);
            parcel.writeInt(this.ab);
        }
    }

    public void setLottieClicklistener(xr xrVar) {
        this.cv = xrVar;
    }

    public void setLottieAnimListener(ms msVar) {
        this.g = msVar;
    }
}
