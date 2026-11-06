package com.bytedance.adsdk.lottie.ka;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ms implements Choreographer.FrameCallback {
    private com.bytedance.adsdk.lottie.c ch;
    private float xr = 1.0f;
    private boolean ah = false;
    private long d = 0;
    private float ka = 0.0f;
    private float c = 0.0f;
    private int ab = 0;
    private float x = -2.1474836E9f;
    private float ny = 2.1474836E9f;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected boolean f169ms = false;
    private boolean hi = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(c());
    }

    public float c() {
        com.bytedance.adsdk.lottie.c cVar = this.ch;
        if (cVar == null) {
            return 0.0f;
        }
        return (this.c - cVar.c()) / (this.ch.ab() - this.ch.c());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fUb;
        float fAo;
        float fUb2;
        if (this.ch == null) {
            return 0.0f;
        }
        if (t()) {
            fUb = ao() - this.c;
            fAo = ao();
            fUb2 = ub();
        } else {
            fUb = this.c - ub();
            fAo = ao();
            fUb2 = ub();
        }
        return fUb / (fAo - fUb2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.bytedance.adsdk.lottie.c cVar = this.ch;
        if (cVar == null) {
            return 0L;
        }
        return (long) cVar.ka();
    }

    public float ab() {
        return this.c;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f169ms;
    }

    public void ah(boolean z) {
        this.hi = z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        h();
        if (this.ch == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.lottie.ka.ms("LottieValueAnimator#doFrame");
        long j2 = this.d;
        float fY = (j2 != 0 ? j - j2 : 0L) / y();
        float f = this.ka;
        if (t()) {
            fY = -fY;
        }
        float f2 = f + fY;
        boolean z = !x.ah(f2, ub(), ao());
        float f3 = this.ka;
        float fXr = x.xr(f2, ub(), ao());
        this.ka = fXr;
        if (this.hi) {
            fXr = (float) Math.floor(fXr);
        }
        this.c = fXr;
        this.d = j;
        if (!this.hi || this.ka != f3) {
            ah();
        }
        if (z) {
            if (getRepeatCount() != -1 && this.ab >= getRepeatCount()) {
                float fUb = this.xr < 0.0f ? ub() : ao();
                this.ka = fUb;
                this.c = fUb;
                qv();
                xr(t());
            } else {
                ms();
                this.ab++;
                if (getRepeatMode() == 2) {
                    this.ah = !this.ah;
                    ny();
                } else {
                    float fAo = t() ? ao() : ub();
                    this.ka = fAo;
                    this.c = fAo;
                }
                this.d = j;
            }
        }
        nw();
        com.bytedance.adsdk.lottie.ka.xr("LottieValueAnimator#doFrame");
    }

    private float y() {
        com.bytedance.adsdk.lottie.c cVar = this.ch;
        if (cVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / cVar.zb()) / Math.abs(this.xr);
    }

    public void x() {
        this.ch = null;
        this.x = -2.1474836E9f;
        this.ny = 2.1474836E9f;
    }

    public void ms(com.bytedance.adsdk.lottie.c cVar) {
        boolean z = this.ch == null;
        this.ch = cVar;
        if (z) {
            ms(Math.max(this.x, cVar.c()), Math.min(this.ny, cVar.ab()));
        } else {
            ms((int) cVar.c(), (int) cVar.ab());
        }
        float f = this.c;
        this.c = 0.0f;
        this.ka = 0.0f;
        ms((int) f);
        ah();
    }

    public void ms(float f) {
        if (this.ka == f) {
            return;
        }
        float fXr = x.xr(f, ub(), ao());
        this.ka = fXr;
        if (this.hi) {
            fXr = (float) Math.floor(fXr);
        }
        this.c = fXr;
        this.d = 0L;
        ah();
    }

    public void ms(int i) {
        ms(i, (int) this.ny);
    }

    public void xr(float f) {
        ms(this.x, f);
    }

    public void ms(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.bytedance.adsdk.lottie.c cVar = this.ch;
        float fC = cVar == null ? -3.4028235E38f : cVar.c();
        com.bytedance.adsdk.lottie.c cVar2 = this.ch;
        float fAb = cVar2 == null ? Float.MAX_VALUE : cVar2.ab();
        float fXr = x.xr(f, fC, fAb);
        float fXr2 = x.xr(f2, fC, fAb);
        if (fXr == this.x && fXr2 == this.ny) {
            return;
        }
        this.x = fXr;
        this.ny = fXr2;
        ms((int) x.xr(this.c, fXr, fXr2));
    }

    public void ny() {
        ah(-ch());
    }

    public void ah(float f) {
        this.xr = f;
    }

    public float ch() {
        return this.xr;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.ah) {
            return;
        }
        this.ah = false;
        ny();
    }

    public void hi() {
        this.f169ms = true;
        ms(t());
        ms((int) (t() ? ao() : ub()));
        this.d = 0L;
        this.ab = 0;
        h();
    }

    public void sl() {
        qv();
        xr(t());
    }

    public void zb() {
        qv();
        d();
    }

    public void u() {
        this.f169ms = true;
        h();
        this.d = 0L;
        if (t() && ab() == ub()) {
            ms(ao());
        } else if (!t() && ab() == ao()) {
            ms(ub());
        }
        ka();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        xr();
        qv();
    }

    private boolean t() {
        return ch() < 0.0f;
    }

    public float ub() {
        com.bytedance.adsdk.lottie.c cVar = this.ch;
        if (cVar == null) {
            return 0.0f;
        }
        float f = this.x;
        return f == -2.1474836E9f ? cVar.c() : f;
    }

    public float ao() {
        com.bytedance.adsdk.lottie.c cVar = this.ch;
        if (cVar == null) {
            return 0.0f;
        }
        float f = this.ny;
        return f == 2.1474836E9f ? cVar.ab() : f;
    }

    @Override // com.bytedance.adsdk.lottie.ka.ms
    void xr() {
        super.xr();
        xr(t());
    }

    protected void h() {
        if (isRunning()) {
            d(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void qv() {
        d(true);
    }

    protected void d(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f169ms = false;
        }
    }

    private void nw() {
        if (this.ch == null) {
            return;
        }
        float f = this.c;
        if (f < this.x || f > this.ny) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.x), Float.valueOf(this.ny), Float.valueOf(this.c)));
        }
    }
}
