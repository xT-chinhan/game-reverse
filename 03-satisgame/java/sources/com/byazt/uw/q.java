package com.byazt.uw;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1462, 5})
public final class q {
    public int cd;
    public final float[] cp;
    public int cy;
    public final float[] d;
    public final float[] fs;
    public int hd;
    public final float[] k;
    public final float[] l;
    public final qg n;
    public final int[] oa;
    public final float[] q;
    public final qg.s qg;
    public final float[] rv;
    public final qg.q[] s;
    public int sz;
    public final float[] tj;
    public final float[] w;
    public final float[] x;

    public q(qg qgVar) {
        this.n = qgVar;
        this.qg = qgVar.n();
        qg.q[] qVarArr = (qg.q[]) qgVar.qg().toArray(new qg.q[0]);
        this.s = qVarArr;
        this.q = new float[600];
        this.l = new float[600];
        this.w = new float[600];
        this.x = new float[600];
        this.fs = new float[600];
        this.rv = new float[600];
        this.tj = new float[600];
        this.cp = new float[600];
        this.d = new float[600];
        this.oa = new int[600];
        this.k = new float[qVarArr.length];
        int iNanoTime = (int) (System.nanoTime() ^ ((long) System.identityHashCode(this)));
        this.cy = iNanoTime == 0 ? 305441741 : iNanoTime;
    }

    public void n(int i, int i2) {
        this.hd = i;
        this.cd = i2;
    }

    public qg.q[] n() {
        return this.s;
    }

    public qg qg() {
        return this.n;
    }

    public void update(float f) {
        if (this.hd <= 0 || this.cd <= 0 || this.s.length == 0) {
            return;
        }
        n(f);
        qg(f);
    }

    private void n(float f) {
        float[] fArr = this.q;
        float[] fArr2 = this.l;
        float[] fArr3 = this.w;
        float[] fArr4 = this.x;
        float[] fArr5 = this.fs;
        float[] fArr6 = this.rv;
        float[] fArr7 = this.cp;
        float[] fArr8 = this.d;
        int i = 0;
        while (i < this.sz) {
            float f2 = fArr5[i] + f;
            if (f2 >= fArr6[i]) {
                n(i);
            } else {
                float f3 = fArr7[i] + (fArr8[i] * f);
                if (f3 <= 0.0f) {
                    n(i);
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

    private void n(int i) {
        int i2 = this.sz - 1;
        this.sz = i2;
        if (i != i2) {
            float[] fArr = this.q;
            fArr[i] = fArr[i2];
            float[] fArr2 = this.l;
            fArr2[i] = fArr2[i2];
            float[] fArr3 = this.w;
            fArr3[i] = fArr3[i2];
            float[] fArr4 = this.x;
            fArr4[i] = fArr4[i2];
            float[] fArr5 = this.fs;
            fArr5[i] = fArr5[i2];
            float[] fArr6 = this.rv;
            fArr6[i] = fArr6[i2];
            float[] fArr7 = this.tj;
            fArr7[i] = fArr7[i2];
            float[] fArr8 = this.cp;
            fArr8[i] = fArr8[i2];
            float[] fArr9 = this.d;
            fArr9[i] = fArr9[i2];
            int[] iArr = this.oa;
            iArr[i] = iArr[i2];
        }
    }

    private void qg(float f) {
        qg.q[] qVarArr = this.s;
        float[] fArr = this.k;
        for (int i = 0; i < qVarArr.length; i++) {
            qg.q qVar = qVarArr[i];
            if (qVar.qg > 0.0f) {
                fArr[i] = fArr[i] + (qVar.qg * f);
                while (true) {
                    float f2 = fArr[i];
                    if (f2 < 1.0f || this.sz >= 600) {
                        break;
                    }
                    fArr[i] = f2 - 1.0f;
                    n(i, qVar);
                }
                if (this.sz >= 600) {
                    fArr[i] = 0.0f;
                }
            }
        }
    }

    private void n(int i, qg.q qVar) {
        int i2 = this.sz;
        this.sz = i2 + 1;
        float fN = n(qVar.s, qVar.q);
        if (fN < 0.01f) {
            fN = 0.01f;
        }
        float fN2 = n(qVar.l, qVar.w);
        if (fN2 < 0.0f) {
            fN2 = 0.0f;
        }
        float fN3 = n(qVar.x, qVar.fs);
        if (fN3 < 0.0f) {
            fN3 = 0.0f;
        }
        float fS = s() * 6.2831855f;
        float radians = (float) Math.toRadians(qVar.rv);
        if (radians > 0.0f) {
            fS += (s() - 0.5f) * radians;
        }
        float fS2 = 1.0f - (qVar.tj > 0.0f ? s() * qVar.tj : 0.0f);
        if (fS2 < 0.0f) {
            fS2 = 0.0f;
        }
        this.fs[i2] = 0.0f;
        this.rv[i2] = fN;
        this.tj[i2] = fN2;
        double d = fS;
        this.w[i2] = ((float) Math.cos(d)) * fN3;
        this.x[i2] = ((float) Math.sin(d)) * fN3;
        this.cp[i2] = fS2;
        this.d[i2] = qVar.cp;
        this.oa[i2] = i;
        qg(i2);
    }

    private void qg(int i) {
        float fN = this.qg.rv.n(this.hd);
        float fN2 = this.qg.tj.n(this.cd);
        float f = fN < 0.0f ? 0.0f : fN;
        float f2 = fN2 < 0.0f ? 0.0f : fN2;
        float fN3 = this.qg.x.n(this.hd);
        float fN4 = this.qg.fs.n(this.cd);
        float f3 = f / 2.0f;
        float f4 = fN3 - f3;
        float f5 = f2 / 2.0f;
        float f6 = fN4 - f5;
        int i2 = this.qg.q;
        int i3 = this.qg.l;
        if (i2 == 2) {
            if (i3 == 1) {
                n(i, f4, f6, f, f2);
                return;
            } else {
                this.q[i] = f4 + (s() * f);
                this.l[i] = f6 + (s() * f2);
                return;
            }
        }
        if (i2 == 3 || i2 == 4) {
            float fS = s() * 6.2831855f;
            float fSqrt = i3 == 1 ? 1.0f : (float) Math.sqrt(s());
            double d = fS;
            this.q[i] = fN3 + (((float) Math.cos(d)) * f3 * fSqrt);
            this.l[i] = fN4 + (((float) Math.sin(d)) * f5 * fSqrt);
            return;
        }
        if (i2 == 1) {
            this.q[i] = f4 + (s() * f);
            this.l[i] = fN4;
        } else {
            this.q[i] = fN3;
            this.l[i] = fN4;
        }
    }

    private void n(int i, float f, float f2, float f3, float f4) {
        float f5 = f3 + f4;
        float f6 = f5 * 2.0f;
        if (f6 <= 0.0f) {
            this.q[i] = f;
            this.l[i] = f2;
            return;
        }
        float fS = s() * f6;
        if (fS < f3) {
            this.q[i] = f + fS;
            this.l[i] = f2;
            return;
        }
        if (fS < f5) {
            this.q[i] = f + f3;
            this.l[i] = f2 + (fS - f3);
            return;
        }
        float f7 = 2.0f * f3;
        if (fS < f7 + f4) {
            this.q[i] = (f + f3) - ((fS - f3) - f4);
            this.l[i] = f2 + f4;
        } else {
            this.q[i] = f;
            this.l[i] = (f2 + f4) - ((fS - f7) - f4);
        }
    }

    private float n(float f, float f2) {
        return f2 <= 0.0f ? f : f + (((s() * 2.0f) - 1.0f) * f2);
    }

    private float s() {
        int i = this.cy;
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        if (i4 == 0) {
            i4 = -1640531527;
        }
        this.cy = i4;
        return (i4 >>> 8) * 5.9604645E-8f;
    }

    public void n(w wVar) {
        int i = this.sz;
        wVar.n(600);
        wVar.n = i;
        System.arraycopy(this.q, 0, wVar.s, 0, i);
        System.arraycopy(this.l, 0, wVar.q, 0, i);
        System.arraycopy(this.tj, 0, wVar.l, 0, i);
        System.arraycopy(this.cp, 0, wVar.w, 0, i);
        System.arraycopy(this.fs, 0, wVar.x, 0, i);
        System.arraycopy(this.oa, 0, wVar.fs, 0, i);
        wVar.qg = this.qg.w;
    }
}
