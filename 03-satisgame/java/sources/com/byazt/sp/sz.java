package com.byazt.sp;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 110})
public class sz implements cp, oa, com.byazt.bd.n.InterfaceC0134n {
    public final com.byazt.bd.n<?, Float> cp;
    public final com.byazt.bd.n<?, Float> d;
    public final com.byazt.bd.n<?, PointF> fs;
    public boolean k;
    public final boolean l;
    public final com.byazt.bd.n<?, Float> oa;
    public final com.byazt.aw.tj.n q;
    public final String qg;
    public final com.byazt.bd.n<?, Float> rv;
    public final com.byazt.pp.fs s;
    public final com.byazt.bd.n<?, Float> tj;
    public final boolean w;
    public final com.byazt.bd.n<?, Float> x;
    public final Path n = new Path();
    public final qg sz = new qg();

    public sz(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.tj tjVar) {
        this.s = fsVar;
        this.qg = tjVar.n();
        com.byazt.aw.tj.n type = tjVar.getType();
        this.q = type;
        this.l = tjVar.rv();
        this.w = tjVar.tj();
        com.byazt.bd.n<Float, Float> nVarN = tjVar.qg().n();
        this.x = nVarN;
        com.byazt.bd.n<PointF, PointF> nVarN2 = tjVar.s().n();
        this.fs = nVarN2;
        com.byazt.bd.n<Float, Float> nVarN3 = tjVar.q().n();
        this.rv = nVarN3;
        com.byazt.bd.n<Float, Float> nVarN4 = tjVar.w().n();
        this.cp = nVarN4;
        com.byazt.bd.n<Float, Float> nVarN5 = tjVar.fs().n();
        this.oa = nVarN5;
        if (type == com.byazt.aw.tj.n.STAR) {
            this.tj = tjVar.l().n();
            this.d = tjVar.x().n();
        } else {
            this.tj = null;
            this.d = null;
        }
        sVar.n(nVarN);
        sVar.n(nVarN2);
        sVar.n(nVarN3);
        sVar.n(nVarN4);
        sVar.n(nVarN5);
        if (type == com.byazt.aw.tj.n.STAR) {
            sVar.n(this.tj);
            sVar.n(this.d);
        }
        nVarN.n(this);
        nVarN2.n(this);
        nVarN3.n(this);
        nVarN4.n(this);
        nVarN5.n(this);
        if (type == com.byazt.aw.tj.n.STAR) {
            this.tj.n(this);
            this.d.n(this);
        }
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        qg();
    }

    private void qg() {
        this.k = false;
        this.s.invalidateSelf();
    }

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        for (int i = 0; i < list.size(); i++) {
            s sVar = list.get(i);
            if (sVar instanceof py) {
                py pyVar = (py) sVar;
                if (pyVar.getType() == com.byazt.aw.um.n.SIMULTANEOUSLY) {
                    this.sz.n(pyVar);
                    pyVar.n(this);
                }
            }
        }
    }

    @Override // com.byazt.sp.oa
    public Path q() {
        if (this.k) {
            return this.n;
        }
        this.n.reset();
        if (this.l) {
            this.k = true;
            return this.n;
        }
        int i = AnonymousClass1.n[this.q.ordinal()];
        if (i == 1) {
            s();
        } else if (i == 2) {
            l();
        }
        this.n.close();
        this.sz.n(this.n);
        this.k = true;
        return this.n;
    }

    /* JADX INFO: renamed from: com.byazt.sp.sz$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 1179, 684})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.aw.tj.n.values().length];
            n = iArr;
            try {
                iArr[com.byazt.aw.tj.n.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.aw.tj.n.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void s() {
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        float fFloatValue = this.x.x().floatValue();
        com.byazt.bd.n<?, Float> nVar = this.rv;
        double radians = Math.toRadians((nVar == null ? 0.0d : nVar.x().floatValue()) - 90.0d);
        double d2 = fFloatValue;
        float f6 = (float) (6.283185307179586d / d2);
        if (this.w) {
            f6 *= -1.0f;
        }
        float f7 = f6 / 2.0f;
        float f8 = fFloatValue - ((int) fFloatValue);
        if (f8 != 0.0f) {
            radians += (double) ((1.0f - f8) * f7);
        }
        float fFloatValue2 = this.cp.x().floatValue();
        float fFloatValue3 = this.tj.x().floatValue();
        com.byazt.bd.n<?, Float> nVar2 = this.d;
        float fFloatValue4 = nVar2 != null ? nVar2.x().floatValue() / 100.0f : 0.0f;
        com.byazt.bd.n<?, Float> nVar3 = this.oa;
        float fFloatValue5 = nVar3 != null ? nVar3.x().floatValue() / 100.0f : 0.0f;
        if (f8 != 0.0f) {
            f3 = ((fFloatValue2 - fFloatValue3) * f8) + fFloatValue3;
            double d3 = f3;
            float fCos = (float) (d3 * Math.cos(radians));
            fSin = (float) (d3 * Math.sin(radians));
            this.n.moveTo(fCos, fSin);
            d = radians + ((double) ((f6 * f8) / 2.0f));
            f = fCos;
            f2 = f7;
        } else {
            double d4 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.n.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f7;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        int i = 0;
        float f9 = f2;
        float f10 = f;
        boolean z = false;
        while (true) {
            double d5 = i;
            if (d5 < dCeil) {
                float f11 = z ? fFloatValue2 : fFloatValue3;
                float f12 = (f3 == 0.0f || d5 != dCeil - 2.0d) ? f9 : (f6 * f8) / 2.0f;
                if (f3 == 0.0f || d5 != dCeil - 1.0d) {
                    f3 = f11;
                }
                double d6 = f3;
                double d7 = dCeil;
                float fCos3 = (float) (d6 * Math.cos(d));
                float fSin3 = (float) (d6 * Math.sin(d));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.n.lineTo(fCos3, fSin3);
                    f4 = fFloatValue4;
                    f5 = fFloatValue5;
                } else {
                    f4 = fFloatValue4;
                    double dAtan2 = (float) (Math.atan2(fSin, f10) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    f5 = fFloatValue5;
                    double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan3);
                    float fSin5 = (float) Math.sin(dAtan3);
                    float f13 = z ? f4 : f5;
                    float f14 = z ? f5 : f4;
                    float f15 = (z ? fFloatValue3 : fFloatValue2) * f13 * 0.47829f;
                    float f16 = fCos4 * f15;
                    float f17 = f15 * fSin4;
                    float f18 = (z ? fFloatValue2 : fFloatValue3) * f14 * 0.47829f;
                    float f19 = fCos5 * f18;
                    float f20 = f18 * fSin5;
                    if (f8 != 0.0f) {
                        if (i == 0) {
                            f16 *= f8;
                            f17 *= f8;
                        } else if (d5 == d7 - 1.0d) {
                            f19 *= f8;
                            f20 *= f8;
                        }
                    }
                    this.n.cubicTo(f10 - f16, fSin - f17, fCos3 + f19, fSin3 + f20, fCos3, fSin3);
                }
                d += (double) f12;
                z = !z;
                i++;
                f10 = fCos3;
                fSin = fSin3;
                fFloatValue5 = f5;
                fFloatValue4 = f4;
                f3 = f3;
                f6 = f6;
                dCeil = d7;
            } else {
                PointF pointFX = this.fs.x();
                this.n.offset(pointFX.x, pointFX.y);
                this.n.close();
                return;
            }
        }
    }

    private void l() {
        int iFloor = (int) Math.floor(this.x.x().floatValue());
        com.byazt.bd.n<?, Float> nVar = this.rv;
        double radians = Math.toRadians((nVar == null ? 0.0d : nVar.x().floatValue()) - 90.0d);
        double d = iFloor;
        float fFloatValue = this.oa.x().floatValue() / 100.0f;
        float fFloatValue2 = this.cp.x().floatValue();
        double d2 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d2);
        float fSin = (float) (Math.sin(radians) * d2);
        this.n.moveTo(fCos, fSin);
        double d3 = (float) (6.283185307179586d / d);
        double d4 = radians + d3;
        double dCeil = Math.ceil(d);
        int i = 0;
        while (i < dCeil) {
            float fCos2 = (float) (Math.cos(d4) * d2);
            double d5 = dCeil;
            float fSin2 = (float) (d2 * Math.sin(d4));
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.n.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan3)) * f), fSin2 + (f * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            } else {
                this.n.lineTo(fCos2, fSin2);
            }
            d4 += d3;
            i++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d5;
            d2 = d2;
            d3 = d3;
        }
        PointF pointFX = this.fs.x();
        this.n.offset(pointFX.x, pointFX.y);
        this.n.close();
    }
}
