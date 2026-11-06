package com.byazt.nu;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1243, 21})
public class x extends n implements Choreographer.FrameCallback {
    public com.byazt.pp.w tj;
    public float qg = 1.0f;
    public boolean s = false;
    public long q = 0;
    public float l = 0.0f;
    public float w = 0.0f;
    public int x = 0;
    public float fs = -2.1474836E9f;
    public float rv = 2.1474836E9f;
    public boolean n = false;
    public boolean cp = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(w());
    }

    public float w() {
        com.byazt.pp.w wVar = this.tj;
        if (wVar == null) {
            return 0.0f;
        }
        return (this.w - wVar.w()) / (this.tj.x() - this.tj.w());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fK;
        float fCy;
        float fK2;
        if (this.tj == null) {
            return 0.0f;
        }
        if (a()) {
            fK = cy() - this.w;
            fCy = cy();
            fK2 = k();
        } else {
            fK = this.w - k();
            fCy = cy();
            fK2 = k();
        }
        return fK / (fCy - fK2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.byazt.pp.w wVar = this.tj;
        if (wVar == null) {
            return 0L;
        }
        return (long) wVar.l();
    }

    public float x() {
        return this.w;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.n;
    }

    public void s(boolean z) {
        this.cp = z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        hd();
        if (this.tj == null || !isRunning()) {
            return;
        }
        com.byazt.pp.l.n("LottieValueAnimator#doFrame");
        long j2 = this.q;
        float fUm = (j2 != 0 ? j - j2 : 0L) / um();
        float f = this.l;
        if (a()) {
            fUm = -fUm;
        }
        float f2 = f + fUm;
        boolean z = !rv.s(f2, k(), cy());
        float f3 = this.l;
        float fQg = rv.qg(f2, k(), cy());
        this.l = fQg;
        if (this.cp) {
            fQg = (float) Math.floor(fQg);
        }
        this.w = fQg;
        this.q = j;
        if (!this.cp || this.l != f3) {
            s();
        }
        if (z) {
            if (getRepeatCount() != -1 && this.x >= getRepeatCount()) {
                float fK = this.qg < 0.0f ? k() : cy();
                this.l = fK;
                this.w = fK;
                cd();
                qg(a());
            } else {
                n();
                this.x++;
                if (getRepeatMode() == 2) {
                    this.s = !this.s;
                    rv();
                } else {
                    float fCy = a() ? cy() : k();
                    this.l = fCy;
                    this.w = fCy;
                }
                this.q = j;
            }
        }
        py();
        com.byazt.pp.l.qg("LottieValueAnimator#doFrame");
    }

    private float um() {
        com.byazt.pp.w wVar = this.tj;
        if (wVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / wVar.oa()) / Math.abs(this.qg);
    }

    public void fs() {
        this.tj = null;
        this.fs = -2.1474836E9f;
        this.rv = 2.1474836E9f;
    }

    public void n(com.byazt.pp.w wVar) {
        boolean z = this.tj == null;
        this.tj = wVar;
        if (z) {
            n(Math.max(this.fs, wVar.w()), Math.min(this.rv, wVar.x()));
        } else {
            n((int) wVar.w(), (int) wVar.x());
        }
        float f = this.w;
        this.w = 0.0f;
        this.l = 0.0f;
        n((int) f);
        s();
    }

    public void n(float f) {
        if (this.l == f) {
            return;
        }
        float fQg = rv.qg(f, k(), cy());
        this.l = fQg;
        if (this.cp) {
            fQg = (float) Math.floor(fQg);
        }
        this.w = fQg;
        this.q = 0L;
        s();
    }

    public void n(int i) {
        n(i, (int) this.rv);
    }

    public void qg(float f) {
        n(this.fs, f);
    }

    public void n(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.byazt.pp.w wVar = this.tj;
        float fW = wVar == null ? -3.4028235E38f : wVar.w();
        com.byazt.pp.w wVar2 = this.tj;
        float fX = wVar2 == null ? Float.MAX_VALUE : wVar2.x();
        float fQg = rv.qg(f, fW, fX);
        float fQg2 = rv.qg(f2, fW, fX);
        if (fQg == this.fs && fQg2 == this.rv) {
            return;
        }
        this.fs = fQg;
        this.rv = fQg2;
        n((int) rv.qg(this.w, fQg, fQg2));
    }

    public void rv() {
        s(-tj());
    }

    public void s(float f) {
        this.qg = f;
    }

    public float tj() {
        return this.qg;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.s) {
            return;
        }
        this.s = false;
        rv();
    }

    public void cp() {
        this.n = true;
        n(a());
        n((int) (a() ? cy() : k()));
        this.q = 0L;
        this.x = 0;
        hd();
    }

    public void d() {
        cd();
        qg(a());
    }

    public void oa() {
        cd();
        q();
    }

    public void sz() {
        this.n = true;
        hd();
        this.q = 0L;
        if (a() && x() == k()) {
            n(cy());
        } else if (!a() && x() == cy()) {
            n(k());
        }
        l();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        qg();
        cd();
    }

    private boolean a() {
        return tj() < 0.0f;
    }

    public float k() {
        com.byazt.pp.w wVar = this.tj;
        if (wVar == null) {
            return 0.0f;
        }
        float f = this.fs;
        return f == -2.1474836E9f ? wVar.w() : f;
    }

    public float cy() {
        com.byazt.pp.w wVar = this.tj;
        if (wVar == null) {
            return 0.0f;
        }
        float f = this.rv;
        return f == 2.1474836E9f ? wVar.x() : f;
    }

    @Override // com.byazt.nu.n
    public void qg() {
        super.qg();
        qg(a());
    }

    public void hd() {
        if (isRunning()) {
            q(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void cd() {
        q(true);
    }

    public void q(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.n = false;
        }
    }

    private void py() {
        if (this.tj == null) {
            return;
        }
        float f = this.w;
        if (f < this.fs || f > this.rv) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.fs), Float.valueOf(this.rv), Float.valueOf(this.w)));
        }
    }
}
