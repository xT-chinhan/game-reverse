package com.byazt.njk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 121})
public final class x {
    public final float[] aj;
    public final float[] c;
    public final float[] fw;
    public int g;
    public final hw.x[] hn;
    public final float[] ho;
    public final hw.hn hw;
    public final float[] k;
    public int lb;
    public final int[] m;
    public int nt;
    public final hw pr;
    public final float[] uc;
    public final float[] vk;
    public final float[] w;
    public final float[] x;
    public int yb;
    public final float[] zo;

    public x(hw hwVar) {
        this.pr = hwVar;
        this.hw = hwVar.pr();
        hw.x[] xVarArr = (hw.x[]) hwVar.hw().toArray(new hw.x[0]);
        this.hn = xVarArr;
        this.x = new float[600];
        this.c = new float[600];
        this.uc = new float[600];
        this.fw = new float[600];
        this.zo = new float[600];
        this.aj = new float[600];
        this.vk = new float[600];
        this.w = new float[600];
        this.k = new float[600];
        this.m = new int[600];
        this.ho = new float[xVarArr.length];
        int iNanoTime = (int) (System.nanoTime() ^ ((long) System.identityHashCode(this)));
        this.nt = iNanoTime == 0 ? 305441741 : iNanoTime;
    }

    public void pr(int i, int i2) {
        this.yb = i;
        this.lb = i2;
    }

    public hw.x[] pr() {
        return this.hn;
    }

    public hw hw() {
        return this.pr;
    }

    public void update(float f) {
        if (this.yb <= 0 || this.lb <= 0 || this.hn.length == 0) {
            return;
        }
        pr(f);
        hw(f);
    }

    private void pr(float f) {
        float[] fArr = this.x;
        float[] fArr2 = this.c;
        float[] fArr3 = this.uc;
        float[] fArr4 = this.fw;
        float[] fArr5 = this.zo;
        float[] fArr6 = this.aj;
        float[] fArr7 = this.w;
        float[] fArr8 = this.k;
        int i = 0;
        while (i < this.g) {
            float f2 = fArr5[i] + f;
            if (f2 >= fArr6[i]) {
                pr(i);
            } else {
                float f3 = fArr7[i] + (fArr8[i] * f);
                if (f3 <= 0.0f) {
                    pr(i);
                } else {
                    if (f3 > 1.0f) {
                        f3 = 1.0f;
                    }
                    fArr5[i] = f2;
                    fArr7[i] = f3;
                    fArr[i] = fArr[i] + (fArr3[i] * f);
                    fArr2[i] = fArr2[i] + (fArr4[i] * f);
                    i++;
                }
            }
        }
    }

    private void pr(int i) {
        int i2 = this.g - 1;
        this.g = i2;
        if (i != i2) {
            float[] fArr = this.x;
            fArr[i] = fArr[i2];
            float[] fArr2 = this.c;
            fArr2[i] = fArr2[i2];
            float[] fArr3 = this.uc;
            fArr3[i] = fArr3[i2];
            float[] fArr4 = this.fw;
            fArr4[i] = fArr4[i2];
            float[] fArr5 = this.zo;
            fArr5[i] = fArr5[i2];
            float[] fArr6 = this.aj;
            fArr6[i] = fArr6[i2];
            float[] fArr7 = this.vk;
            fArr7[i] = fArr7[i2];
            float[] fArr8 = this.w;
            fArr8[i] = fArr8[i2];
            float[] fArr9 = this.k;
            fArr9[i] = fArr9[i2];
            int[] iArr = this.m;
            iArr[i] = iArr[i2];
        }
    }

    private void hw(float f) {
        hw.x[] xVarArr = this.hn;
        float[] fArr = this.ho;
        for (int i = 0; i < xVarArr.length; i++) {
            hw.x xVar = xVarArr[i];
            if (xVar.hw > 0.0f) {
                fArr[i] = fArr[i] + (xVar.hw * f);
                while (true) {
                    float f2 = fArr[i];
                    if (f2 < 1.0f || this.g >= 600) {
                        break;
                    }
                    fArr[i] = f2 - 1.0f;
                    pr(i, xVar);
                }
                if (this.g >= 600) {
                    fArr[i] = 0.0f;
                }
            }
        }
    }

    private void pr(int i, hw.x xVar) {
        int i2 = this.g;
        this.g = i2 + 1;
        float fPr = pr(xVar.hn, xVar.x);
        if (fPr < 0.01f) {
            fPr = 0.01f;
        }
        float fPr2 = pr(xVar.c, xVar.uc);
        if (fPr2 < 0.0f) {
            fPr2 = 0.0f;
        }
        float fPr3 = pr(xVar.fw, xVar.zo);
        if (fPr3 < 0.0f) {
            fPr3 = 0.0f;
        }
        float fHn = hn() * 6.2831855f;
        float radians = (float) Math.toRadians(xVar.aj);
        if (radians > 0.0f) {
            fHn += (hn() - 0.5f) * radians;
        }
        float fHn2 = 1.0f - (xVar.vk > 0.0f ? hn() * xVar.vk : 0.0f);
        if (fHn2 < 0.0f) {
            fHn2 = 0.0f;
        }
        this.zo[i2] = 0.0f;
        this.aj[i2] = fPr;
        this.vk[i2] = fPr2;
        double d = fHn;
        this.uc[i2] = ((float) Math.cos(d)) * fPr3;
        this.fw[i2] = ((float) Math.sin(d)) * fPr3;
        this.w[i2] = fHn2;
        this.k[i2] = xVar.w;
        this.m[i2] = i;
        hw(i2);
    }

    private void hw(int i) {
        float fPr = this.hw.aj.pr(this.yb);
        float fPr2 = this.hw.vk.pr(this.lb);
        float f = fPr < 0.0f ? 0.0f : fPr;
        float f2 = fPr2 < 0.0f ? 0.0f : fPr2;
        float fPr3 = this.hw.fw.pr(this.yb);
        float fPr4 = this.hw.zo.pr(this.lb);
        float f3 = f / 2.0f;
        float f4 = fPr3 - f3;
        float f5 = f2 / 2.0f;
        float f6 = fPr4 - f5;
        int i2 = this.hw.x;
        int i3 = this.hw.c;
        if (i2 == 2) {
            if (i3 == 1) {
                pr(i, f4, f6, f, f2);
                return;
            } else {
                this.x[i] = f4 + (hn() * f);
                this.c[i] = f6 + (hn() * f2);
                return;
            }
        }
        if (i2 == 3 || i2 == 4) {
            float fHn = hn() * 6.2831855f;
            float fSqrt = i3 == 1 ? 1.0f : (float) Math.sqrt(hn());
            double d = fHn;
            this.x[i] = fPr3 + (((float) Math.cos(d)) * f3 * fSqrt);
            this.c[i] = fPr4 + (((float) Math.sin(d)) * f5 * fSqrt);
            return;
        }
        if (i2 == 1) {
            this.x[i] = f4 + (hn() * f);
            this.c[i] = fPr4;
        } else {
            this.x[i] = fPr3;
            this.c[i] = fPr4;
        }
    }

    private void pr(int i, float f, float f2, float f3, float f4) {
        float f5 = f3 + f4;
        float f6 = f5 * 2.0f;
        if (f6 <= 0.0f) {
            this.x[i] = f;
            this.c[i] = f2;
            return;
        }
        float fHn = hn() * f6;
        if (fHn < f3) {
            this.x[i] = f + fHn;
            this.c[i] = f2;
            return;
        }
        if (fHn < f5) {
            this.x[i] = f + f3;
            this.c[i] = f2 + (fHn - f3);
            return;
        }
        float f7 = 2.0f * f3;
        if (fHn < f7 + f4) {
            this.x[i] = (f + f3) - ((fHn - f3) - f4);
            this.c[i] = f2 + f4;
        } else {
            this.x[i] = f;
            this.c[i] = (f2 + f4) - ((fHn - f7) - f4);
        }
    }

    private float pr(float f, float f2) {
        return f2 <= 0.0f ? f : f + (((hn() * 2.0f) - 1.0f) * f2);
    }

    private float hn() {
        int i = this.nt;
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        if (i4 == 0) {
            i4 = -1640531527;
        }
        this.nt = i4;
        return (i4 >>> 8) * 5.9604645E-8f;
    }

    public void pr(uc ucVar) {
        int i = this.g;
        ucVar.pr(600);
        ucVar.pr = i;
        System.arraycopy(this.x, 0, ucVar.hn, 0, i);
        System.arraycopy(this.c, 0, ucVar.x, 0, i);
        System.arraycopy(this.vk, 0, ucVar.c, 0, i);
        System.arraycopy(this.w, 0, ucVar.uc, 0, i);
        System.arraycopy(this.zo, 0, ucVar.fw, 0, i);
        System.arraycopy(this.m, 0, ucVar.zo, 0, i);
        ucVar.hw = this.hw.uc;
    }
}
