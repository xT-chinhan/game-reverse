package com.byazt.pp;

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
import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 101})
public class fs extends Drawable implements Animatable, Drawable.Callback {
    public com.byazt.eg.q a;
    public RectF ae;
    public Rect an;
    public Canvas bb;
    public boolean cd;
    public final ValueAnimator.AnimatorUpdateListener cp;
    public Map<String, Typeface> cy;
    public com.byazt.jq.qg d;
    public Matrix df;
    public LottieAnimationView dg;
    public RectF f;
    public Matrix fi;
    public boolean fs;
    public boolean h;
    public boolean hd;
    public a hu;
    public Rect j;
    public com.byazt.jq.n k;
    public final com.byazt.nu.x l;
    public RectF lh;
    public Rect ln;
    public boolean m;
    public String n;
    public String oa;
    public ou oj;
    public boolean ou;
    public int py;
    public w q;
    public s qg;
    public qg rv;
    public py s;
    public q sz;
    public final Matrix t;
    public final ArrayList<n> tj;
    public boolean u;
    public boolean um;
    public Bitmap ur;
    public Paint v;
    public boolean w;
    public boolean wm;
    public boolean x;

    private interface n {
        void n(w wVar);
    }

    private enum qg {
        NONE,
        PLAY,
        RESUME
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public fs(LottieAnimationView lottieAnimationView) {
        com.byazt.nu.x xVar = new com.byazt.nu.x();
        this.l = xVar;
        this.w = true;
        this.x = false;
        this.fs = false;
        this.rv = qg.NONE;
        this.tj = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.pp.fs.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (fs.this.a != null) {
                    fs.this.a.n(fs.this.l.w());
                }
            }
        };
        this.cp = animatorUpdateListener;
        this.cd = false;
        this.um = true;
        this.py = 255;
        this.hu = a.AUTOMATIC;
        this.h = false;
        this.t = new Matrix();
        this.u = false;
        this.dg = lottieAnimationView;
        xVar.addUpdateListener(animatorUpdateListener);
    }

    public void n(ou ouVar) {
        this.oj = ouVar;
    }

    public ou n() {
        return this.oj;
    }

    public LottieAnimationView qg() {
        return this.dg;
    }

    public void n(boolean z, Context context) {
        if (this.hd == z) {
            return;
        }
        this.hd = z;
        if (this.q != null) {
            n(context);
        }
    }

    public void n(boolean z) {
        if (z != this.um) {
            this.um = z;
            com.byazt.eg.q qVar = this.a;
            if (qVar != null) {
                qVar.qg(z);
            }
            invalidateSelf();
        }
    }

    public com.byazt.eg.q s() {
        return this.a;
    }

    public boolean q() {
        return this.um;
    }

    public void n(String str) {
        this.oa = str;
    }

    public String l() {
        return this.oa;
    }

    public void qg(boolean z) {
        this.cd = z;
    }

    public boolean w() {
        return this.cd;
    }

    public boolean n(w wVar, Context context) {
        if (this.q == wVar) {
            return false;
        }
        this.u = true;
        cp();
        this.q = wVar;
        n(context);
        this.l.n(wVar);
        q(this.l.getAnimatedFraction());
        Iterator it = new ArrayList(this.tj).iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (nVar != null) {
                nVar.n(wVar);
            }
            it.remove();
        }
        this.tj.clear();
        wVar.qg(this.ou);
        v();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void n(a aVar) {
        this.hu = aVar;
        v();
    }

    public a x() {
        return this.h ? a.SOFTWARE : a.HARDWARE;
    }

    private void v() {
        w wVar = this.q;
        if (wVar == null) {
            return;
        }
        this.h = this.hu.n(Build.VERSION.SDK_INT, wVar.n(), wVar.qg());
    }

    public boolean fs() {
        return this.h;
    }

    public void s(boolean z) {
        this.ou = z;
        w wVar = this.q;
        if (wVar != null) {
            wVar.qg(z);
        }
    }

    public void q(boolean z) {
        if (this.wm == z) {
            return;
        }
        this.wm = z;
        com.byazt.eg.q qVar = this.a;
        if (qVar != null) {
            qVar.n(z);
        }
    }

    public um rv() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.s();
        }
        return null;
    }

    public void l(boolean z) {
        this.m = z;
    }

    public boolean tj() {
        return this.m;
    }

    private void n(Context context) {
        w wVar = this.q;
        if (wVar == null) {
            return;
        }
        com.byazt.eg.q qVar = this.a;
        if (qVar != null) {
            n(qVar);
        }
        com.byazt.eg.q qVar2 = new com.byazt.eg.q(this, com.byazt.ur.ou.n(wVar), wVar.sz(), wVar, context);
        this.a = qVar2;
        if (this.wm) {
            qVar2.n(true);
        }
        this.a.qg(this.um);
    }

    private void n(com.byazt.eg.q qVar) {
        if (qVar != null) {
            qVar.s();
            List<com.byazt.eg.s> listSz = qVar.sz();
            if (listSz != null) {
                for (com.byazt.eg.s sVar : listSz) {
                    if (sVar instanceof com.byazt.eg.q) {
                        n((com.byazt.eg.q) sVar);
                    } else if (sVar != null) {
                        sVar.s();
                    }
                }
            }
        }
    }

    public void cp() {
        if (this.l.isRunning()) {
            this.l.cancel();
            if (!isVisible()) {
                this.rv = qg.NONE;
            }
        }
        this.q = null;
        com.byazt.eg.q qVar = this.a;
        if (qVar != null) {
            n(qVar);
        }
        this.a = null;
        this.d = null;
        this.l.fs();
        invalidateSelf();
    }

    public void w(boolean z) {
        this.fs = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.u) {
            return;
        }
        this.u = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.py = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.py;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.byazt.nu.w.qg("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        l.n("Drawable#draw");
        try {
            if (this.h) {
                n(canvas, this.a);
            } else {
                n(canvas);
            }
        } catch (Throwable th) {
            com.byazt.nu.w.qg("Lottie crashed in draw!", th);
        }
        this.u = false;
        l.qg("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        d();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        oa();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return wm();
    }

    public void d() {
        if (this.a == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.6
                @Override // com.byazt.pp.fs.n
                public void n(w wVar) {
                    fs.this.d();
                }
            });
            return;
        }
        v();
        if (j() || ou() == 0) {
            if (isVisible()) {
                this.l.cp();
                this.rv = qg.NONE;
            } else {
                this.rv = qg.PLAY;
            }
        }
        if (j()) {
            return;
        }
        s((int) (hd() < 0.0f ? k() : cy()));
        this.l.d();
        if (isVisible()) {
            return;
        }
        this.rv = qg.NONE;
    }

    public void oa() {
        this.tj.clear();
        this.l.d();
        if (isVisible()) {
            return;
        }
        this.rv = qg.NONE;
    }

    public void sz() {
        if (this.a == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.7
                @Override // com.byazt.pp.fs.n
                public void n(w wVar) {
                    fs.this.sz();
                }
            });
            return;
        }
        v();
        if (j() || ou() == 0) {
            if (isVisible()) {
                this.l.sz();
                this.rv = qg.NONE;
            } else {
                this.rv = qg.RESUME;
            }
        }
        if (j()) {
            return;
        }
        s((int) (hd() < 0.0f ? k() : cy()));
        this.l.d();
        if (isVisible()) {
            return;
        }
        this.rv = qg.NONE;
    }

    public void n(final int i) {
        if (this.q == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.8
                @Override // com.byazt.pp.fs.n
                public void n(w wVar) {
                    fs.this.n(i);
                }
            });
        } else {
            this.l.n(i);
        }
    }

    public float k() {
        return this.l.k();
    }

    public void n(final float f) {
        w wVar = this.q;
        if (wVar == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.9
                @Override // com.byazt.pp.fs.n
                public void n(w wVar2) {
                    fs.this.n(f);
                }
            });
        } else {
            n((int) com.byazt.nu.rv.n(wVar.w(), this.q.x(), f));
        }
    }

    public void qg(final int i) {
        if (this.q == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.10
                @Override // com.byazt.pp.fs.n
                public void n(w wVar) {
                    fs.this.qg(i);
                }
            });
        } else {
            this.l.qg(i + 0.99f);
        }
    }

    public float cy() {
        return this.l.cy();
    }

    public void qg(final float f) {
        w wVar = this.q;
        if (wVar == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.11
                @Override // com.byazt.pp.fs.n
                public void n(w wVar2) {
                    fs.this.qg(f);
                }
            });
        } else {
            this.l.qg(com.byazt.nu.rv.n(wVar.w(), this.q.x(), f));
        }
    }

    public void qg(final String str) {
        w wVar = this.q;
        if (wVar == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.12
                @Override // com.byazt.pp.fs.n
                public void n(w wVar2) {
                    fs.this.qg(str);
                }
            });
            return;
        }
        com.byazt.ld.x xVarS = wVar.s(str);
        if (xVarS == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + i.E);
        }
        n((int) xVarS.n);
    }

    public void s(final String str) {
        w wVar = this.q;
        if (wVar == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.13
                @Override // com.byazt.pp.fs.n
                public void n(w wVar2) {
                    fs.this.s(str);
                }
            });
            return;
        }
        com.byazt.ld.x xVarS = wVar.s(str);
        if (xVarS == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + i.E);
        }
        qg((int) (xVarS.n + xVarS.qg));
    }

    public void q(final String str) {
        w wVar = this.q;
        if (wVar == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.2
                @Override // com.byazt.pp.fs.n
                public void n(w wVar2) {
                    fs.this.q(str);
                }
            });
            return;
        }
        com.byazt.ld.x xVarS = wVar.s(str);
        if (xVarS == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + i.E);
        }
        int i = (int) xVarS.n;
        n(i, ((int) xVarS.qg) + i);
    }

    public void n(final int i, final int i2) {
        if (this.q == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.3
                @Override // com.byazt.pp.fs.n
                public void n(w wVar) {
                    fs.this.n(i, i2);
                }
            });
        } else {
            this.l.n(i, i2 + 0.99f);
        }
    }

    public void s(float f) {
        this.l.s(f);
    }

    public float hd() {
        return this.l.tj();
    }

    public void n(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.l.addUpdateListener(animatorUpdateListener);
    }

    public void qg(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.l.removeUpdateListener(animatorUpdateListener);
    }

    public void cd() {
        this.l.removeAllUpdateListeners();
        this.l.addUpdateListener(this.cp);
    }

    public void n(Animator.AnimatorListener animatorListener) {
        this.l.addListener(animatorListener);
    }

    public void qg(Animator.AnimatorListener animatorListener) {
        this.l.removeListener(animatorListener);
    }

    public void um() {
        this.l.removeAllListeners();
    }

    public void s(final int i) {
        if (this.q == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.4
                @Override // com.byazt.pp.fs.n
                public void n(w wVar) {
                    fs.this.s(i);
                }
            });
        } else {
            this.l.n(i);
        }
    }

    public int a() {
        return (int) this.l.x();
    }

    public void q(final float f) {
        if (this.q == null) {
            this.tj.add(new n() { // from class: com.byazt.pp.fs.5
                @Override // com.byazt.pp.fs.n
                public void n(w wVar) {
                    fs.this.q(f);
                }
            });
            return;
        }
        l.n("Drawable#setProgress");
        this.l.n(this.q.n(f));
        l.qg("Drawable#setProgress");
    }

    public void q(int i) {
        this.l.setRepeatMode(i);
    }

    public int py() {
        return this.l.getRepeatMode();
    }

    public void l(int i) {
        this.l.setRepeatCount(i);
    }

    public int ou() {
        return this.l.getRepeatCount();
    }

    public boolean wm() {
        com.byazt.nu.x xVar = this.l;
        if (xVar == null) {
            return false;
        }
        return xVar.isRunning();
    }

    public boolean m() {
        if (isVisible()) {
            return this.l.isRunning();
        }
        return this.rv == qg.PLAY || this.rv == qg.RESUME;
    }

    private boolean j() {
        return this.w || this.x;
    }

    public void n(Boolean bool) {
        this.w = bool.booleanValue();
    }

    public void x(boolean z) {
        this.x = z;
    }

    public void fs(boolean z) {
        this.l.s(z);
    }

    public void n(q qVar) {
        this.sz = qVar;
        com.byazt.jq.qg qgVar = this.d;
        if (qgVar != null) {
            qgVar.n(qVar);
        }
    }

    public void n(s sVar) {
        this.qg = sVar;
        com.byazt.jq.n nVar = this.k;
        if (nVar != null) {
            nVar.n(sVar);
        }
    }

    public void n(Map<String, Typeface> map) {
        if (map == this.cy) {
            return;
        }
        this.cy = map;
        invalidateSelf();
    }

    public void n(py pyVar) {
        this.s = pyVar;
    }

    public py hu() {
        return this.s;
    }

    public boolean h() {
        return this.cy == null && this.s == null && this.q.k().size() > 0;
    }

    public w t() {
        return this.q;
    }

    public void ur() {
        this.tj.clear();
        this.l.cancel();
        if (isVisible()) {
            return;
        }
        this.rv = qg.NONE;
    }

    public void bb() {
        this.tj.clear();
        this.l.oa();
        if (isVisible()) {
            return;
        }
        this.rv = qg.NONE;
    }

    public float ln() {
        return this.l.w();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        w wVar = this.q;
        if (wVar == null) {
            return -1;
        }
        return wVar.q().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        w wVar = this.q;
        if (wVar == null) {
            return -1;
        }
        return wVar.q().height();
    }

    public Bitmap n(String str, Bitmap bitmap) {
        com.byazt.jq.qg qgVarAn = an();
        if (qgVarAn == null) {
            com.byazt.nu.w.qg("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapN = qgVarAn.n(str, bitmap);
        invalidateSelf();
        return bitmapN;
    }

    public Bitmap l(String str) {
        com.byazt.jq.qg qgVarAn = an();
        if (qgVarAn != null) {
            return qgVarAn.n(str);
        }
        return null;
    }

    public rv w(String str) {
        w wVar = this.q;
        if (wVar == null) {
            return null;
        }
        return wVar.hd().get(str);
    }

    private com.byazt.jq.qg an() {
        w wVar = this.q;
        if (wVar == null) {
            return null;
        }
        com.byazt.jq.qg qgVar = this.d;
        if (qgVar != null && !qgVar.n(getContext())) {
            this.d = null;
        }
        if (this.d == null) {
            this.d = new com.byazt.jq.qg(getCallback(), this.oa, this.sz, wVar.hd());
        }
        return this.d;
    }

    public Typeface n(com.byazt.ld.s sVar) {
        Map<String, Typeface> map = this.cy;
        if (map != null) {
            String strN = sVar.n();
            if (map.containsKey(strN)) {
                return map.get(strN);
            }
            String strQg = sVar.qg();
            if (map.containsKey(strQg)) {
                return map.get(strQg);
            }
            String str = sVar.n() + "-" + sVar.s();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.byazt.jq.n nVarAe = ae();
        if (nVarAe != null) {
            return nVarAe.n(sVar);
        }
        return null;
    }

    private com.byazt.jq.n ae() {
        if (getCallback() == null) {
            return null;
        }
        if (this.k == null) {
            com.byazt.jq.n nVar = new com.byazt.jq.n(getCallback(), this.qg);
            this.k = nVar;
            String str = this.n;
            if (str != null) {
                nVar.n(str);
            }
        }
        return this.k;
    }

    public void x(String str) {
        this.n = str;
        com.byazt.jq.n nVarAe = ae();
        if (nVarAe != null) {
            nVarAe.n(str);
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
            if (this.rv == qg.PLAY) {
                d();
            } else if (this.rv == qg.RESUME) {
                sz();
            }
        } else if (this.l.isRunning()) {
            bb();
            this.rv = qg.RESUME;
        } else if (!z3) {
            this.rv = qg.NONE;
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

    private void n(Canvas canvas) {
        com.byazt.eg.q qVar = this.a;
        w wVar = this.q;
        if (qVar == null || wVar == null) {
            return;
        }
        this.t.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.t.preScale(bounds.width() / wVar.q().width(), bounds.height() / wVar.q().height());
            this.t.preTranslate(bounds.left, bounds.top);
        }
        qVar.n(canvas, this.t, this.py);
    }

    public RectF lh() {
        return this.f;
    }

    private void n(Canvas canvas, com.byazt.eg.q qVar) {
        if (this.q == null || qVar == null) {
            return;
        }
        f();
        canvas.getMatrix(this.fi);
        canvas.getClipBounds(this.ln);
        n(this.ln, this.lh);
        this.fi.mapRect(this.lh);
        n(this.lh, this.ln);
        if (this.um) {
            this.f.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            qVar.n(this.f, (Matrix) null, false);
        }
        this.fi.mapRect(this.f);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        n(this.f, fWidth, fHeight);
        if (!fi()) {
            this.f.intersect(this.ln.left, this.ln.top, this.ln.right, this.ln.bottom);
        }
        int iCeil = (int) Math.ceil(this.f.width());
        int iCeil2 = (int) Math.ceil(this.f.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        qg(iCeil, iCeil2);
        if (this.u) {
            this.t.set(this.fi);
            this.t.preScale(fWidth, fHeight);
            this.t.postTranslate(-this.f.left, -this.f.top);
            this.ur.eraseColor(0);
            qVar.n(this.bb, this.t, this.py);
            this.fi.invert(this.df);
            this.df.mapRect(this.ae, this.f);
            n(this.ae, this.an);
        }
        this.j.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.ur, this.j, this.an, this.v);
    }

    private void f() {
        if (this.bb != null) {
            return;
        }
        this.bb = new Canvas();
        this.f = new RectF();
        this.fi = new Matrix();
        this.df = new Matrix();
        this.ln = new Rect();
        this.lh = new RectF();
        this.v = new com.byazt.ft.n();
        this.j = new Rect();
        this.an = new Rect();
        this.ae = new RectF();
    }

    private void qg(int i, int i2) {
        Bitmap bitmap = this.ur;
        if (bitmap == null || bitmap.getWidth() < i || this.ur.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.ur = bitmapCreateBitmap;
            this.bb.setBitmap(bitmapCreateBitmap);
            this.u = true;
            return;
        }
        if (this.ur.getWidth() > i || this.ur.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.ur, 0, 0, i, i2);
            this.ur = bitmapCreateBitmap2;
            this.bb.setBitmap(bitmapCreateBitmap2);
            this.u = true;
        }
    }

    private void n(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void n(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void n(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean fi() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }
}
