package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.anythink.core.common.d.j;
import com.bytedance.adsdk.lottie.d.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class x extends Drawable implements Animatable, Drawable.Callback {
    private boolean ab;
    t ah;
    private Map<String, Typeface> ao;
    private Matrix az;
    private boolean b;
    private boolean c;
    private final ArrayList<ms> ch;
    private Canvas cv;
    private c d;
    private LottieAnimationView e;
    private RectF f;
    private Rect g;
    private boolean h;
    private final ValueAnimator.AnimatorUpdateListener hi;
    private boolean i;
    private Rect jw;
    private boolean k;
    private final com.bytedance.adsdk.lottie.ka.c ka;
    private Bitmap le;
    private nw lm;
    private Matrix m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    String f276ms;
    private int nw;
    private xr ny;
    private RectF of;
    private final Matrix op;
    private Paint p;
    private Rect pc;
    private boolean qv;
    private boolean re;
    private com.bytedance.adsdk.lottie.xr.xr sl;
    private com.bytedance.adsdk.lottie.model.layer.d t;
    private d u;
    private com.bytedance.adsdk.lottie.xr.ms ub;
    private RectF ul;
    private y w;
    private boolean x;
    ah xr;
    private boolean y;
    private boolean yu;
    private String zb;

    private interface ms {
        void ms(c cVar);
    }

    private enum xr {
        NONE,
        PLAY,
        RESUME
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public x(LottieAnimationView lottieAnimationView) {
        com.bytedance.adsdk.lottie.ka.c cVar = new com.bytedance.adsdk.lottie.ka.c();
        this.ka = cVar;
        this.c = true;
        this.ab = false;
        this.x = false;
        this.ny = xr.NONE;
        this.ch = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.x.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (x.this.t != null) {
                    x.this.t.ms(x.this.ka.c());
                }
            }
        };
        this.hi = animatorUpdateListener;
        this.qv = false;
        this.y = true;
        this.nw = 255;
        this.w = y.AUTOMATIC;
        this.yu = false;
        this.op = new Matrix();
        this.k = false;
        this.e = lottieAnimationView;
        cVar.addUpdateListener(animatorUpdateListener);
    }

    public void ms(nw nwVar) {
        this.lm = nwVar;
    }

    public nw ms() {
        return this.lm;
    }

    public LottieAnimationView xr() {
        return this.e;
    }

    public void ms(boolean z, Context context) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        if (this.d != null) {
            ms(context);
        }
    }

    public void ms(boolean z) {
        if (z != this.y) {
            this.y = z;
            com.bytedance.adsdk.lottie.model.layer.d dVar = this.t;
            if (dVar != null) {
                dVar.xr(z);
            }
            invalidateSelf();
        }
    }

    public com.bytedance.adsdk.lottie.model.layer.d ah() {
        return this.t;
    }

    public boolean d() {
        return this.y;
    }

    public void ms(String str) {
        this.zb = str;
    }

    public String ka() {
        return this.zb;
    }

    public void xr(boolean z) {
        this.qv = z;
    }

    public boolean c() {
        return this.qv;
    }

    public boolean ms(c cVar, Context context) {
        if (this.d == cVar) {
            return false;
        }
        this.k = true;
        hi();
        this.d = cVar;
        ms(context);
        this.ka.ms(cVar);
        d(this.ka.getAnimatedFraction());
        Iterator it = new ArrayList(this.ch).iterator();
        while (it.hasNext()) {
            ms msVar = (ms) it.next();
            if (msVar != null) {
                msVar.ms(cVar);
            }
            it.remove();
        }
        this.ch.clear();
        cVar.xr(this.b);
        p();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void ms(y yVar) {
        this.w = yVar;
        p();
    }

    public y ab() {
        return this.yu ? y.SOFTWARE : y.HARDWARE;
    }

    private void p() {
        c cVar = this.d;
        if (cVar == null) {
            return;
        }
        this.yu = this.w.ms(Build.VERSION.SDK_INT, cVar.ms(), cVar.xr());
    }

    public boolean x() {
        return this.yu;
    }

    public void ah(boolean z) {
        this.b = z;
        c cVar = this.d;
        if (cVar != null) {
            cVar.xr(z);
        }
    }

    public void d(boolean z) {
        if (this.re == z) {
            return;
        }
        this.re = z;
        com.bytedance.adsdk.lottie.model.layer.d dVar = this.t;
        if (dVar != null) {
            dVar.ms(z);
        }
    }

    public qv ny() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.ah();
        }
        return null;
    }

    public void ka(boolean z) {
        this.i = z;
    }

    public boolean ch() {
        return this.i;
    }

    private void ms(Context context) {
        c cVar = this.d;
        if (cVar == null) {
            return;
        }
        com.bytedance.adsdk.lottie.model.layer.d dVar = this.t;
        if (dVar != null) {
            ms(dVar);
        }
        com.bytedance.adsdk.lottie.model.layer.d dVar2 = new com.bytedance.adsdk.lottie.model.layer.d(this, b.ms(cVar), cVar.u(), cVar, context);
        this.t = dVar2;
        if (this.re) {
            dVar2.ms(true);
        }
        this.t.xr(this.y);
    }

    private void ms(com.bytedance.adsdk.lottie.model.layer.d dVar) {
        if (dVar != null) {
            dVar.ah();
            List<com.bytedance.adsdk.lottie.model.layer.ah> listU = dVar.u();
            if (listU != null) {
                for (com.bytedance.adsdk.lottie.model.layer.ah ahVar : listU) {
                    if (ahVar instanceof com.bytedance.adsdk.lottie.model.layer.d) {
                        ms((com.bytedance.adsdk.lottie.model.layer.d) ahVar);
                    } else if (ahVar != null) {
                        ahVar.ah();
                    }
                }
            }
        }
    }

    public void hi() {
        if (this.ka.isRunning()) {
            this.ka.cancel();
            if (!isVisible()) {
                this.ny = xr.NONE;
            }
        }
        this.d = null;
        com.bytedance.adsdk.lottie.model.layer.d dVar = this.t;
        if (dVar != null) {
            ms(dVar);
        }
        this.t = null;
        this.sl = null;
        this.ka.x();
        invalidateSelf();
    }

    public void c(boolean z) {
        this.x = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.k) {
            return;
        }
        this.k = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.nw = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.nw;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.bytedance.adsdk.lottie.ka.ka.xr("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ka.ms("Drawable#draw");
        try {
            if (this.yu) {
                ms(canvas, this.t);
            } else {
                ms(canvas);
            }
        } catch (Throwable th) {
            com.bytedance.adsdk.lottie.ka.ka.xr("Lottie crashed in draw!", th);
        }
        this.k = false;
        ka.xr("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        sl();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        zb();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return re();
    }

    public void sl() {
        if (this.t == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.6
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar) {
                    x.this.sl();
                }
            });
            return;
        }
        p();
        if (pc() || b() == 0) {
            if (isVisible()) {
                this.ka.hi();
                this.ny = xr.NONE;
            } else {
                this.ny = xr.PLAY;
            }
        }
        if (pc()) {
            return;
        }
        ah((int) (h() < 0.0f ? ub() : ao()));
        this.ka.sl();
        if (isVisible()) {
            return;
        }
        this.ny = xr.NONE;
    }

    public void zb() {
        this.ch.clear();
        this.ka.sl();
        if (isVisible()) {
            return;
        }
        this.ny = xr.NONE;
    }

    public void u() {
        if (this.t == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.7
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar) {
                    x.this.u();
                }
            });
            return;
        }
        p();
        if (pc() || b() == 0) {
            if (isVisible()) {
                this.ka.u();
                this.ny = xr.NONE;
            } else {
                this.ny = xr.RESUME;
            }
        }
        if (pc()) {
            return;
        }
        ah((int) (h() < 0.0f ? ub() : ao()));
        this.ka.sl();
        if (isVisible()) {
            return;
        }
        this.ny = xr.NONE;
    }

    public void ms(final int i) {
        if (this.d == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.8
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar) {
                    x.this.ms(i);
                }
            });
        } else {
            this.ka.ms(i);
        }
    }

    public float ub() {
        return this.ka.ub();
    }

    public void ms(final float f) {
        c cVar = this.d;
        if (cVar == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.9
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar2) {
                    x.this.ms(f);
                }
            });
        } else {
            ms((int) com.bytedance.adsdk.lottie.ka.x.ms(cVar.c(), this.d.ab(), f));
        }
    }

    public void xr(final int i) {
        if (this.d == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.10
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar) {
                    x.this.xr(i);
                }
            });
        } else {
            this.ka.xr(i + 0.99f);
        }
    }

    public float ao() {
        return this.ka.ao();
    }

    public void xr(final float f) {
        c cVar = this.d;
        if (cVar == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.11
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar2) {
                    x.this.xr(f);
                }
            });
        } else {
            this.ka.xr(com.bytedance.adsdk.lottie.ka.x.ms(cVar.c(), this.d.ab(), f));
        }
    }

    public void xr(final String str) {
        c cVar = this.d;
        if (cVar == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.12
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar2) {
                    x.this.xr(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.c cVarAh = cVar.ah(str);
        if (cVarAh == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + j.z);
        }
        ms((int) cVarAh.f179ms);
    }

    public void ah(final String str) {
        c cVar = this.d;
        if (cVar == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.13
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar2) {
                    x.this.ah(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.c cVarAh = cVar.ah(str);
        if (cVarAh == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + j.z);
        }
        xr((int) (cVarAh.f179ms + cVarAh.xr));
    }

    public void d(final String str) {
        c cVar = this.d;
        if (cVar == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.2
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar2) {
                    x.this.d(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.c cVarAh = cVar.ah(str);
        if (cVarAh == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + j.z);
        }
        int i = (int) cVarAh.f179ms;
        ms(i, ((int) cVarAh.xr) + i);
    }

    public void ms(final int i, final int i2) {
        if (this.d == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.3
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar) {
                    x.this.ms(i, i2);
                }
            });
        } else {
            this.ka.ms(i, i2 + 0.99f);
        }
    }

    public void ah(float f) {
        this.ka.ah(f);
    }

    public float h() {
        return this.ka.ch();
    }

    public void ms(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ka.addUpdateListener(animatorUpdateListener);
    }

    public void xr(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ka.removeUpdateListener(animatorUpdateListener);
    }

    public void qv() {
        this.ka.removeAllUpdateListeners();
        this.ka.addUpdateListener(this.hi);
    }

    public void ms(Animator.AnimatorListener animatorListener) {
        this.ka.addListener(animatorListener);
    }

    public void xr(Animator.AnimatorListener animatorListener) {
        this.ka.removeListener(animatorListener);
    }

    public void y() {
        this.ka.removeAllListeners();
    }

    public void ah(final int i) {
        if (this.d == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.4
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar) {
                    x.this.ah(i);
                }
            });
        } else {
            this.ka.ms(i);
        }
    }

    public int t() {
        return (int) this.ka.ab();
    }

    public void d(final float f) {
        if (this.d == null) {
            this.ch.add(new ms() { // from class: com.bytedance.adsdk.lottie.x.5
                @Override // com.bytedance.adsdk.lottie.x.ms
                public void ms(c cVar) {
                    x.this.d(f);
                }
            });
            return;
        }
        ka.ms("Drawable#setProgress");
        this.ka.ms(this.d.ms(f));
        ka.xr("Drawable#setProgress");
    }

    public void d(int i) {
        this.ka.setRepeatMode(i);
    }

    public int nw() {
        return this.ka.getRepeatMode();
    }

    public void ka(int i) {
        this.ka.setRepeatCount(i);
    }

    public int b() {
        return this.ka.getRepeatCount();
    }

    public boolean re() {
        com.bytedance.adsdk.lottie.ka.c cVar = this.ka;
        if (cVar == null) {
            return false;
        }
        return cVar.isRunning();
    }

    boolean i() {
        if (isVisible()) {
            return this.ka.isRunning();
        }
        return this.ny == xr.PLAY || this.ny == xr.RESUME;
    }

    private boolean pc() {
        return this.c || this.ab;
    }

    public void ms(Boolean bool) {
        this.c = bool.booleanValue();
    }

    public void ab(boolean z) {
        this.ab = z;
    }

    public void x(boolean z) {
        this.ka.ah(z);
    }

    public void ms(d dVar) {
        this.u = dVar;
        com.bytedance.adsdk.lottie.xr.xr xrVar = this.sl;
        if (xrVar != null) {
            xrVar.ms(dVar);
        }
    }

    public void ms(ah ahVar) {
        this.xr = ahVar;
        com.bytedance.adsdk.lottie.xr.ms msVar = this.ub;
        if (msVar != null) {
            msVar.ms(ahVar);
        }
    }

    public void ms(Map<String, Typeface> map) {
        if (map == this.ao) {
            return;
        }
        this.ao = map;
        invalidateSelf();
    }

    public void ms(t tVar) {
        this.ah = tVar;
    }

    public t w() {
        return this.ah;
    }

    public boolean yu() {
        return this.ao == null && this.ah == null && this.d.ub().size() > 0;
    }

    public c op() {
        return this.d;
    }

    public void le() {
        this.ch.clear();
        this.ka.cancel();
        if (isVisible()) {
            return;
        }
        this.ny = xr.NONE;
    }

    public void cv() {
        this.ch.clear();
        this.ka.zb();
        if (isVisible()) {
            return;
        }
        this.ny = xr.NONE;
    }

    public float g() {
        return this.ka.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        c cVar = this.d;
        if (cVar == null) {
            return -1;
        }
        return cVar.d().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        c cVar = this.d;
        if (cVar == null) {
            return -1;
        }
        return cVar.d().height();
    }

    public Bitmap ms(String str, Bitmap bitmap) {
        com.bytedance.adsdk.lottie.xr.xr xrVarJw = jw();
        if (xrVarJw == null) {
            com.bytedance.adsdk.lottie.ka.ka.xr("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapMs = xrVarJw.ms(str, bitmap);
        invalidateSelf();
        return bitmapMs;
    }

    public Bitmap ka(String str) {
        com.bytedance.adsdk.lottie.xr.xr xrVarJw = jw();
        if (xrVarJw != null) {
            return xrVarJw.ms(str);
        }
        return null;
    }

    public ny c(String str) {
        c cVar = this.d;
        if (cVar == null) {
            return null;
        }
        return cVar.h().get(str);
    }

    private com.bytedance.adsdk.lottie.xr.xr jw() {
        com.bytedance.adsdk.lottie.xr.xr xrVar = this.sl;
        if (xrVar != null && !xrVar.ms(getContext())) {
            this.sl = null;
        }
        if (this.sl == null) {
            this.sl = new com.bytedance.adsdk.lottie.xr.xr(getCallback(), this.zb, this.u, this.d.h());
        }
        return this.sl;
    }

    public Typeface ms(com.bytedance.adsdk.lottie.model.ah ahVar) {
        Map<String, Typeface> map = this.ao;
        if (map != null) {
            String strMs = ahVar.ms();
            if (map.containsKey(strMs)) {
                return map.get(strMs);
            }
            String strXr = ahVar.xr();
            if (map.containsKey(strXr)) {
                return map.get(strXr);
            }
            String str = ahVar.ms() + "-" + ahVar.ah();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.lottie.xr.ms msVarF = f();
        if (msVarF != null) {
            return msVarF.ms(ahVar);
        }
        return null;
    }

    private com.bytedance.adsdk.lottie.xr.ms f() {
        if (getCallback() == null) {
            return null;
        }
        if (this.ub == null) {
            com.bytedance.adsdk.lottie.xr.ms msVar = new com.bytedance.adsdk.lottie.xr.ms(getCallback(), this.xr);
            this.ub = msVar;
            String str = this.f276ms;
            if (str != null) {
                msVar.ms(str);
            }
        }
        return this.ub;
    }

    public void ab(String str) {
        this.f276ms = str;
        com.bytedance.adsdk.lottie.xr.ms msVarF = f();
        if (msVarF != null) {
            msVarF.ms(str);
        }
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            if (this.ny == xr.PLAY) {
                sl();
            } else if (this.ny == xr.RESUME) {
                u();
            }
        } else if (this.ka.isRunning()) {
            cv();
            this.ny = xr.RESUME;
        } else if (!z3) {
            this.ny = xr.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private void ms(Canvas canvas) {
        com.bytedance.adsdk.lottie.model.layer.d dVar = this.t;
        c cVar = this.d;
        if (dVar == null || cVar == null) {
            return;
        }
        this.op.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.op.preScale(bounds.width() / cVar.d().width(), bounds.height() / cVar.d().height());
            this.op.preTranslate(bounds.left, bounds.top);
        }
        dVar.ms(canvas, this.op, this.nw);
    }

    public RectF of() {
        return this.ul;
    }

    private void ms(Canvas canvas, com.bytedance.adsdk.lottie.model.layer.d dVar) {
        if (this.d == null || dVar == null) {
            return;
        }
        ul();
        canvas.getMatrix(this.az);
        canvas.getClipBounds(this.g);
        ms(this.g, this.of);
        this.az.mapRect(this.of);
        ms(this.of, this.g);
        if (this.y) {
            this.ul.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            dVar.ms(this.ul, (Matrix) null, false);
        }
        this.az.mapRect(this.ul);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        ms(this.ul, fWidth, fHeight);
        if (!az()) {
            this.ul.intersect(this.g.left, this.g.top, this.g.right, this.g.bottom);
        }
        int iCeil = (int) Math.ceil(this.ul.width());
        int iCeil2 = (int) Math.ceil(this.ul.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        xr(iCeil, iCeil2);
        if (this.k) {
            this.op.set(this.az);
            this.op.preScale(fWidth, fHeight);
            this.op.postTranslate(-this.ul.left, -this.ul.top);
            this.le.eraseColor(0);
            dVar.ms(this.cv, this.op, this.nw);
            this.az.invert(this.m);
            this.m.mapRect(this.f, this.ul);
            ms(this.f, this.jw);
        }
        this.pc.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.le, this.pc, this.jw, this.p);
    }

    private void ul() {
        if (this.cv != null) {
            return;
        }
        this.cv = new Canvas();
        this.ul = new RectF();
        this.az = new Matrix();
        this.m = new Matrix();
        this.g = new Rect();
        this.of = new RectF();
        this.p = new com.bytedance.adsdk.lottie.ms.ms();
        this.pc = new Rect();
        this.jw = new Rect();
        this.f = new RectF();
    }

    private void xr(int i, int i2) {
        Bitmap bitmap = this.le;
        if (bitmap == null || bitmap.getWidth() < i || this.le.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.le = bitmapCreateBitmap;
            this.cv.setBitmap(bitmapCreateBitmap);
            this.k = true;
            return;
        }
        if (this.le.getWidth() > i || this.le.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.le, 0, 0, i, i2);
            this.le = bitmapCreateBitmap2;
            this.cv.setBitmap(bitmapCreateBitmap2);
            this.k = true;
        }
    }

    private void ms(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void ms(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void ms(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean az() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }
}
