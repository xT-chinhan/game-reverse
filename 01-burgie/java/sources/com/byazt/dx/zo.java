package com.byazt.dx;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends Drawable implements Animatable, Drawable.Callback {
    public com.byazt.cg.x a;
    public hw aj;
    public boolean b;
    public final com.byazt.ptr.fw c;
    public int cz;
    public Rect e;
    public Matrix er;
    public boolean fo;
    public boolean fw;
    public x g;
    public Canvas gz;
    public cz hn;
    public com.byazt.zwn.pr ho;
    public hn hw;
    public final Matrix iu;
    public com.byazt.zwn.hw k;
    public boolean lb;
    public RectF ls;
    public String m;
    public Rect n;
    public Rect nl;
    public Map<String, Typeface> nt;
    public boolean ny;
    public boolean of;
    public String pr;
    public boolean qa;
    public ny qi;
    public LottieAnimationView qn;
    public boolean rc;
    public RectF s;
    public boolean uc;
    public Matrix v;
    public Bitmap ve;
    public final ArrayList<pr> vk;
    public final ValueAnimator.AnimatorUpdateListener w;
    public Paint ww;
    public uc x;
    public RectF y;
    public boolean yb;
    public a z;
    public boolean zo;

    private enum hw {
        NONE,
        PLAY,
        RESUME
    }

    private interface pr {
        void pr(uc ucVar);
    }

    public zo(LottieAnimationView lottieAnimationView) {
        com.byazt.ptr.fw fwVar = new com.byazt.ptr.fw();
        this.c = fwVar;
        this.uc = true;
        this.fw = false;
        this.zo = false;
        this.aj = hw.NONE;
        this.vk = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.dx.zo.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (zo.this.a != null) {
                    zo.this.a.pr(zo.this.c.uc());
                }
            }
        };
        this.w = animatorUpdateListener;
        this.lb = false;
        this.qa = true;
        this.cz = 255;
        this.z = a.AUTOMATIC;
        this.b = false;
        this.iu = new Matrix();
        this.of = false;
        this.qn = lottieAnimationView;
        fwVar.addUpdateListener(animatorUpdateListener);
    }

    public void pr(ny nyVar) {
        this.qi = nyVar;
    }

    public ny pr() {
        return this.qi;
    }

    public LottieAnimationView hw() {
        return this.qn;
    }

    public void pr(boolean z, Context context) {
        if (this.yb == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.byazt.ptr.uc.hw("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.yb = z;
        if (this.x != null) {
            pr(context);
        }
    }

    public void pr(boolean z) {
        if (z != this.qa) {
            this.qa = z;
            com.byazt.cg.x xVar = this.a;
            if (xVar != null) {
                xVar.hw(z);
            }
            invalidateSelf();
        }
    }

    public com.byazt.cg.x hn() {
        return this.a;
    }

    public boolean x() {
        return this.qa;
    }

    public void pr(String str) {
        this.m = str;
    }

    public String c() {
        return this.m;
    }

    public void hw(boolean z) {
        this.lb = z;
    }

    public boolean uc() {
        return this.lb;
    }

    public boolean pr(uc ucVar, Context context) {
        if (this.x == ucVar) {
            return false;
        }
        this.of = true;
        w();
        this.x = ucVar;
        pr(context);
        this.c.pr(ucVar);
        x(this.c.getAnimatedFraction());
        Iterator it = new ArrayList(this.vk).iterator();
        while (it.hasNext()) {
            pr prVar = (pr) it.next();
            if (prVar != null) {
                prVar.pr(ucVar);
            }
            it.remove();
        }
        this.vk.clear();
        ucVar.hw(this.ny);
        ww();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void pr(a aVar) {
        this.z = aVar;
        ww();
    }

    public a fw() {
        return this.b ? a.SOFTWARE : a.HARDWARE;
    }

    private void ww() {
        uc ucVar = this.x;
        if (ucVar == null) {
            return;
        }
        this.b = this.z.pr(Build.VERSION.SDK_INT, ucVar.pr(), ucVar.hw());
    }

    public boolean zo() {
        return this.b;
    }

    public void hn(boolean z) {
        this.ny = z;
        uc ucVar = this.x;
        if (ucVar != null) {
            ucVar.hw(z);
        }
    }

    public void x(boolean z) {
        if (this.fo == z) {
            return;
        }
        this.fo = z;
        com.byazt.cg.x xVar = this.a;
        if (xVar != null) {
            xVar.pr(z);
        }
    }

    public qa aj() {
        uc ucVar = this.x;
        if (ucVar != null) {
            return ucVar.hn();
        }
        return null;
    }

    public void c(boolean z) {
        this.rc = z;
    }

    public boolean vk() {
        return this.rc;
    }

    private void pr(Context context) {
        uc ucVar = this.x;
        if (ucVar == null) {
            return;
        }
        com.byazt.cg.x xVar = this.a;
        if (xVar != null) {
            pr(xVar);
        }
        com.byazt.cg.x xVar2 = new com.byazt.cg.x(this, com.byazt.tx.ny.pr(ucVar), ucVar.g(), ucVar, context);
        this.a = xVar2;
        if (this.fo) {
            xVar2.pr(true);
        }
        this.a.hw(this.qa);
    }

    private void pr(com.byazt.cg.x xVar) {
        if (xVar != null) {
            xVar.hn();
            List<com.byazt.cg.hn> listG = xVar.g();
            if (listG != null) {
                for (com.byazt.cg.hn hnVar : listG) {
                    if (hnVar instanceof com.byazt.cg.x) {
                        pr((com.byazt.cg.x) hnVar);
                    } else if (hnVar != null) {
                        hnVar.hn();
                    }
                }
            }
        }
    }

    public void w() {
        if (this.c.isRunning()) {
            this.c.cancel();
            if (!isVisible()) {
                this.aj = hw.NONE;
            }
        }
        this.x = null;
        com.byazt.cg.x xVar = this.a;
        if (xVar != null) {
            pr(xVar);
        }
        this.a = null;
        this.k = null;
        this.c.zo();
        invalidateSelf();
    }

    public void uc(boolean z) {
        this.zo = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.of) {
            return;
        }
        this.of = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.cz = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.cz;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.byazt.ptr.uc.hw("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        c.pr("Drawable#draw");
        try {
            if (this.b) {
                pr(canvas, this.a);
            } else {
                pr(canvas);
            }
        } catch (Throwable th) {
            com.byazt.ptr.uc.hw("Lottie crashed in draw!", th);
        }
        this.of = false;
        c.hw("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        k();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return fo();
    }

    public void k() {
        if (this.a == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.6
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar) {
                    zo.this.k();
                }
            });
            return;
        }
        ww();
        if (n() || ny() == 0) {
            if (isVisible()) {
                this.c.w();
                this.aj = hw.NONE;
            } else {
                this.aj = hw.PLAY;
            }
        }
        if (!n()) {
            hn((int) (yb() < 0.0f ? ho() : nt()));
            this.c.k();
            if (!isVisible()) {
                this.aj = hw.NONE;
            }
        }
    }

    public void m() {
        this.vk.clear();
        this.c.k();
        if (!isVisible()) {
            this.aj = hw.NONE;
        }
    }

    public void g() {
        if (this.a == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.7
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar) {
                    zo.this.g();
                }
            });
            return;
        }
        ww();
        if (n() || ny() == 0) {
            if (isVisible()) {
                this.c.g();
                this.aj = hw.NONE;
            } else {
                this.aj = hw.RESUME;
            }
        }
        if (!n()) {
            hn((int) (yb() < 0.0f ? ho() : nt()));
            this.c.k();
            if (!isVisible()) {
                this.aj = hw.NONE;
            }
        }
    }

    public void pr(final int i) {
        if (this.x == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.8
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar) {
                    zo.this.pr(i);
                }
            });
        } else {
            this.c.pr(i);
        }
    }

    public float ho() {
        return this.c.ho();
    }

    public void pr(final float f) {
        uc ucVar = this.x;
        if (ucVar == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.9
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar2) {
                    zo.this.pr(f);
                }
            });
        } else {
            pr((int) com.byazt.ptr.aj.pr(ucVar.uc(), this.x.fw(), f));
        }
    }

    public void hw(final int i) {
        if (this.x == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.10
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar) {
                    zo.this.hw(i);
                }
            });
        } else {
            this.c.hw(i + 0.99f);
        }
    }

    public float nt() {
        return this.c.nt();
    }

    public void hw(final float f) {
        uc ucVar = this.x;
        if (ucVar == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.11
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar2) {
                    zo.this.hw(f);
                }
            });
        } else {
            this.c.hw(com.byazt.ptr.aj.pr(ucVar.uc(), this.x.fw(), f));
        }
    }

    public void hw(final String str) {
        uc ucVar = this.x;
        if (ucVar == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.12
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar2) {
                    zo.this.hw(str);
                }
            });
            return;
        }
        com.byazt.uxi.fw fwVarHn = ucVar.hn(str);
        if (fwVarHn == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        pr((int) fwVarHn.pr);
    }

    public void hn(final String str) {
        uc ucVar = this.x;
        if (ucVar == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.13
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar2) {
                    zo.this.hn(str);
                }
            });
            return;
        }
        com.byazt.uxi.fw fwVarHn = ucVar.hn(str);
        if (fwVarHn == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        hw((int) (fwVarHn.pr + fwVarHn.hw));
    }

    public void x(final String str) {
        uc ucVar = this.x;
        if (ucVar == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.2
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar2) {
                    zo.this.x(str);
                }
            });
            return;
        }
        com.byazt.uxi.fw fwVarHn = ucVar.hn(str);
        if (fwVarHn == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) fwVarHn.pr;
        pr(i, ((int) fwVarHn.hw) + i);
    }

    public void pr(final int i, final int i2) {
        if (this.x == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.3
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar) {
                    zo.this.pr(i, i2);
                }
            });
        } else {
            this.c.pr(i, i2 + 0.99f);
        }
    }

    public void hn(float f) {
        this.c.hn(f);
    }

    public float yb() {
        return this.c.vk();
    }

    public void pr(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.c.addUpdateListener(animatorUpdateListener);
    }

    public void hw(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.c.removeUpdateListener(animatorUpdateListener);
    }

    public void lb() {
        this.c.removeAllUpdateListeners();
        this.c.addUpdateListener(this.w);
    }

    public void pr(Animator.AnimatorListener animatorListener) {
        this.c.addListener(animatorListener);
    }

    public void hw(Animator.AnimatorListener animatorListener) {
        this.c.removeListener(animatorListener);
    }

    public void qa() {
        this.c.removeAllListeners();
    }

    public void hn(final int i) {
        if (this.x == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.4
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar) {
                    zo.this.hn(i);
                }
            });
        } else {
            this.c.pr(i);
        }
    }

    public int a() {
        return (int) this.c.fw();
    }

    public void x(final float f) {
        if (this.x == null) {
            this.vk.add(new pr() { // from class: com.byazt.dx.zo.5
                @Override // com.byazt.dx.zo.pr
                public void pr(uc ucVar) {
                    zo.this.x(f);
                }
            });
            return;
        }
        c.pr("Drawable#setProgress");
        this.c.pr(this.x.pr(f));
        c.hw("Drawable#setProgress");
    }

    public void x(int i) {
        this.c.setRepeatMode(i);
    }

    public int cz() {
        return this.c.getRepeatMode();
    }

    public void c(int i) {
        this.c.setRepeatCount(i);
    }

    public int ny() {
        return this.c.getRepeatCount();
    }

    public boolean fo() {
        com.byazt.ptr.fw fwVar = this.c;
        if (fwVar == null) {
            return false;
        }
        return fwVar.isRunning();
    }

    public boolean rc() {
        if (isVisible()) {
            return this.c.isRunning();
        }
        return this.aj == hw.PLAY || this.aj == hw.RESUME;
    }

    private boolean n() {
        return this.uc || this.fw;
    }

    public void pr(Boolean bool) {
        this.uc = bool.booleanValue();
    }

    public void fw(boolean z) {
        this.fw = z;
    }

    public void zo(boolean z) {
        this.c.hn(z);
    }

    public void pr(x xVar) {
        this.g = xVar;
        com.byazt.zwn.hw hwVar = this.k;
        if (hwVar != null) {
            hwVar.pr(xVar);
        }
    }

    public void pr(hn hnVar) {
        this.hw = hnVar;
        com.byazt.zwn.pr prVar = this.ho;
        if (prVar != null) {
            prVar.pr(hnVar);
        }
    }

    public void pr(Map<String, Typeface> map) {
        if (map == this.nt) {
            return;
        }
        this.nt = map;
        invalidateSelf();
    }

    public void pr(cz czVar) {
        this.hn = czVar;
    }

    public cz z() {
        return this.hn;
    }

    public boolean b() {
        return this.nt == null && this.hn == null && this.x.ho().size() > 0;
    }

    public uc iu() {
        return this.x;
    }

    public void ve() {
        this.vk.clear();
        this.c.cancel();
        if (!isVisible()) {
            this.aj = hw.NONE;
        }
    }

    public void gz() {
        this.vk.clear();
        this.c.m();
        if (!isVisible()) {
            this.aj = hw.NONE;
        }
    }

    public float nl() {
        return this.c.uc();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        uc ucVar = this.x;
        if (ucVar == null) {
            return -1;
        }
        return ucVar.x().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        uc ucVar = this.x;
        if (ucVar == null) {
            return -1;
        }
        return ucVar.x().height();
    }

    public Bitmap pr(String str, Bitmap bitmap) {
        com.byazt.zwn.hw hwVarE = e();
        if (hwVarE == null) {
            com.byazt.ptr.uc.hw("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapPr = hwVarE.pr(str, bitmap);
        invalidateSelf();
        return bitmapPr;
    }

    public Bitmap c(String str) {
        com.byazt.zwn.hw hwVarE = e();
        if (hwVarE != null) {
            return hwVarE.pr(str);
        }
        return null;
    }

    public aj uc(String str) {
        uc ucVar = this.x;
        if (ucVar == null) {
            return null;
        }
        return ucVar.yb().get(str);
    }

    private com.byazt.zwn.hw e() {
        uc ucVar = this.x;
        if (ucVar == null) {
            return null;
        }
        com.byazt.zwn.hw hwVar = this.k;
        if (hwVar != null && !hwVar.pr(getContext())) {
            this.k = null;
        }
        if (this.k == null) {
            this.k = new com.byazt.zwn.hw(getCallback(), this.m, this.g, ucVar.yb());
        }
        return this.k;
    }

    public Typeface pr(com.byazt.uxi.hn hnVar) {
        Map<String, Typeface> map = this.nt;
        if (map != null) {
            String strPr = hnVar.pr();
            if (map.containsKey(strPr)) {
                return map.get(strPr);
            }
            String strHw = hnVar.hw();
            if (map.containsKey(strHw)) {
                return map.get(strHw);
            }
            String str = hnVar.pr() + "-" + hnVar.hn();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.byazt.zwn.pr prVarS = s();
        if (prVarS != null) {
            return prVarS.pr(hnVar);
        }
        return null;
    }

    private com.byazt.zwn.pr s() {
        if (getCallback() == null) {
            return null;
        }
        if (this.ho == null) {
            com.byazt.zwn.pr prVar = new com.byazt.zwn.pr(getCallback(), this.hw);
            this.ho = prVar;
            String str = this.pr;
            if (str != null) {
                prVar.pr(str);
            }
        }
        return this.ho;
    }

    public void fw(String str) {
        this.pr = str;
        com.byazt.zwn.pr prVarS = s();
        if (prVarS != null) {
            prVarS.pr(str);
        }
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            if (this.aj == hw.PLAY) {
                k();
            } else if (this.aj == hw.RESUME) {
                g();
            }
        } else if (this.c.isRunning()) {
            gz();
            this.aj = hw.RESUME;
        } else if (!z3) {
            this.aj = hw.NONE;
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

    private void pr(Canvas canvas) {
        com.byazt.cg.x xVar = this.a;
        uc ucVar = this.x;
        if (xVar == null || ucVar == null) {
            return;
        }
        this.iu.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.iu.preScale(bounds.width() / ucVar.x().width(), bounds.height() / ucVar.x().height());
            this.iu.preTranslate(bounds.left, bounds.top);
        }
        xVar.pr(canvas, this.iu, this.cz);
    }

    public RectF y() {
        return this.ls;
    }

    private void pr(Canvas canvas, com.byazt.cg.x xVar) {
        if (this.x == null || xVar == null) {
            return;
        }
        ls();
        canvas.getMatrix(this.er);
        canvas.getClipBounds(this.nl);
        pr(this.nl, this.y);
        this.er.mapRect(this.y);
        pr(this.y, this.nl);
        if (this.qa) {
            this.ls.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            xVar.pr(this.ls, (Matrix) null, false);
        }
        this.er.mapRect(this.ls);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        pr(this.ls, fWidth, fHeight);
        if (!er()) {
            this.ls.intersect(this.nl.left, this.nl.top, this.nl.right, this.nl.bottom);
        }
        int iCeil = (int) Math.ceil(this.ls.width());
        int iCeil2 = (int) Math.ceil(this.ls.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        hw(iCeil, iCeil2);
        if (this.of) {
            this.iu.set(this.er);
            this.iu.preScale(fWidth, fHeight);
            this.iu.postTranslate(-this.ls.left, -this.ls.top);
            this.ve.eraseColor(0);
            xVar.pr(this.gz, this.iu, this.cz);
            this.er.invert(this.v);
            this.v.mapRect(this.s, this.ls);
            pr(this.s, this.e);
        }
        this.n.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.ve, this.n, this.e, this.ww);
    }

    private void ls() {
        if (this.gz != null) {
            return;
        }
        this.gz = new Canvas();
        this.ls = new RectF();
        this.er = new Matrix();
        this.v = new Matrix();
        this.nl = new Rect();
        this.y = new RectF();
        this.ww = new com.byazt.qpa.pr();
        this.n = new Rect();
        this.e = new Rect();
        this.s = new RectF();
    }

    private void hw(int i, int i2) {
        Bitmap bitmap = this.ve;
        if (bitmap == null || bitmap.getWidth() < i || this.ve.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.ve = bitmapCreateBitmap;
            this.gz.setBitmap(bitmapCreateBitmap);
            this.of = true;
            return;
        }
        if (this.ve.getWidth() > i || this.ve.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.ve, 0, 0, i, i2);
            this.ve = bitmapCreateBitmap2;
            this.gz.setBitmap(bitmapCreateBitmap2);
            this.of = true;
        }
    }

    private void pr(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void pr(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void pr(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean er() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return Build.VERSION.SDK_INT >= 18 && (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }
}
