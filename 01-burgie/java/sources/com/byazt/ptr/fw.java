package com.byazt.ptr;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 950, 62})
public class fw extends pr implements Choreographer.FrameCallback {
    public com.byazt.dx.uc vk;
    public float hw = 1.0f;
    public boolean hn = false;
    public long x = 0;
    public float c = 0.0f;
    public float uc = 0.0f;
    public int fw = 0;
    public float zo = -2.1474836E9f;
    public float aj = 2.1474836E9f;
    public boolean pr = false;
    public boolean w = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(uc());
    }

    public float uc() {
        com.byazt.dx.uc ucVar = this.vk;
        if (ucVar == null) {
            return 0.0f;
        }
        return (this.uc - ucVar.uc()) / (this.vk.fw() - this.vk.uc());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        if (this.vk == null) {
            return 0.0f;
        }
        if (a()) {
            return (nt() - this.uc) / (nt() - ho());
        }
        return (this.uc - ho()) / (nt() - ho());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.byazt.dx.uc ucVar = this.vk;
        if (ucVar == null) {
            return 0L;
        }
        return (long) ucVar.c();
    }

    public float fw() {
        return this.uc;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.pr;
    }

    public void hn(boolean z) {
        this.w = z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        yb();
        if (this.vk == null || !isRunning()) {
            return;
        }
        com.byazt.dx.c.pr("LottieValueAnimator#doFrame");
        long j2 = this.x;
        float fQa = (j2 != 0 ? j - j2 : 0L) / qa();
        float f = this.c;
        if (a()) {
            fQa = -fQa;
        }
        float f2 = f + fQa;
        boolean z = !aj.hn(f2, ho(), nt());
        float f3 = this.c;
        float fHw = aj.hw(f2, ho(), nt());
        this.c = fHw;
        if (this.w) {
            fHw = (float) Math.floor(fHw);
        }
        this.uc = fHw;
        this.x = j;
        if (!this.w || this.c != f3) {
            hn();
        }
        if (z) {
            if (getRepeatCount() != -1 && this.fw >= getRepeatCount()) {
                float fHo = this.hw < 0.0f ? ho() : nt();
                this.c = fHo;
                this.uc = fHo;
                lb();
                hw(a());
            } else {
                pr();
                this.fw++;
                if (getRepeatMode() == 2) {
                    this.hn = !this.hn;
                    aj();
                } else {
                    float fNt = a() ? nt() : ho();
                    this.c = fNt;
                    this.uc = fNt;
                }
                this.x = j;
            }
        }
        cz();
        com.byazt.dx.c.hw("LottieValueAnimator#doFrame");
    }

    private float qa() {
        com.byazt.dx.uc ucVar = this.vk;
        if (ucVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / ucVar.m()) / Math.abs(this.hw);
    }

    public void zo() {
        this.vk = null;
        this.zo = -2.1474836E9f;
        this.aj = 2.1474836E9f;
    }

    public void pr(com.byazt.dx.uc ucVar) {
        boolean z = this.vk == null;
        this.vk = ucVar;
        if (z) {
            pr(Math.max(this.zo, ucVar.uc()), Math.min(this.aj, ucVar.fw()));
        } else {
            pr((int) ucVar.uc(), (int) ucVar.fw());
        }
        float f = this.uc;
        this.uc = 0.0f;
        this.c = 0.0f;
        pr((int) f);
        hn();
    }

    public void pr(float f) {
        if (this.c == f) {
            return;
        }
        float fHw = aj.hw(f, ho(), nt());
        this.c = fHw;
        if (this.w) {
            fHw = (float) Math.floor(fHw);
        }
        this.uc = fHw;
        this.x = 0L;
        hn();
    }

    public void pr(int i) {
        pr(i, (int) this.aj);
    }

    public void hw(float f) {
        pr(this.zo, f);
    }

    public void pr(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.byazt.dx.uc ucVar = this.vk;
        float fUc = ucVar == null ? -3.4028235E38f : ucVar.uc();
        com.byazt.dx.uc ucVar2 = this.vk;
        float fFw = ucVar2 == null ? Float.MAX_VALUE : ucVar2.fw();
        float fHw = aj.hw(f, fUc, fFw);
        float fHw2 = aj.hw(f2, fUc, fFw);
        if (fHw != this.zo || fHw2 != this.aj) {
            this.zo = fHw;
            this.aj = fHw2;
            pr((int) aj.hw(this.uc, fHw, fHw2));
        }
    }

    public void aj() {
        hn(-vk());
    }

    public void hn(float f) {
        this.hw = f;
    }

    public float vk() {
        return this.hw;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.hn) {
            this.hn = false;
            aj();
        }
    }

    public void w() {
        this.pr = true;
        pr(a());
        pr((int) (a() ? nt() : ho()));
        this.x = 0L;
        this.fw = 0;
        yb();
    }

    public void k() {
        lb();
        hw(a());
    }

    public void m() {
        lb();
        x();
    }

    public void g() {
        this.pr = true;
        yb();
        this.x = 0L;
        if (a() && fw() == ho()) {
            pr(nt());
        } else if (!a() && fw() == nt()) {
            pr(ho());
        }
        c();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        hw();
        lb();
    }

    private boolean a() {
        return vk() < 0.0f;
    }

    public float ho() {
        com.byazt.dx.uc ucVar = this.vk;
        if (ucVar == null) {
            return 0.0f;
        }
        float f = this.zo;
        return f == -2.1474836E9f ? ucVar.uc() : f;
    }

    public float nt() {
        com.byazt.dx.uc ucVar = this.vk;
        if (ucVar == null) {
            return 0.0f;
        }
        float f = this.aj;
        return f == 2.1474836E9f ? ucVar.fw() : f;
    }

    @Override // com.byazt.ptr.pr
    public void hw() {
        super.hw();
        hw(a());
    }

    public void yb() {
        if (isRunning()) {
            x(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void lb() {
        x(true);
    }

    public void x(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.pr = false;
        }
    }

    private void cz() {
        if (this.vk == null) {
            return;
        }
        float f = this.uc;
        if (f < this.zo || f > this.aj) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.zo), Float.valueOf(this.aj), Float.valueOf(this.uc)));
        }
    }
}
