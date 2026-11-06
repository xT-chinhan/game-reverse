package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class u implements hi, zb, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> ab;
    private final com.bytedance.adsdk.lottie.x ah;
    private final boolean c;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> ch;
    private final com.bytedance.adsdk.lottie.model.xr.ch.ms d;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> hi;
    private final boolean ka;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> ny;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> sl;
    private boolean ub;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, PointF> x;
    private final String xr;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Path f254ms = new Path();
    private final xr u = new xr();

    public u(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.ch chVar) {
        this.ah = xVar;
        this.xr = chVar.ms();
        com.bytedance.adsdk.lottie.model.xr.ch.ms type = chVar.getType();
        this.d = type;
        this.ka = chVar.ny();
        this.c = chVar.ch();
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs = chVar.xr().ms();
        this.ab = msVarMs;
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs2 = chVar.ah().ms();
        this.x = msVarMs2;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs3 = chVar.d().ms();
        this.ny = msVarMs3;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs4 = chVar.c().ms();
        this.hi = msVarMs4;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs5 = chVar.x().ms();
        this.zb = msVarMs5;
        if (type == com.bytedance.adsdk.lottie.model.xr.ch.ms.STAR) {
            this.ch = chVar.ka().ms();
            this.sl = chVar.ab().ms();
        } else {
            this.ch = null;
            this.sl = null;
        }
        ahVar.ms(msVarMs);
        ahVar.ms(msVarMs2);
        ahVar.ms(msVarMs3);
        ahVar.ms(msVarMs4);
        ahVar.ms(msVarMs5);
        if (type == com.bytedance.adsdk.lottie.model.xr.ch.ms.STAR) {
            ahVar.ms(this.ch);
            ahVar.ms(this.sl);
        }
        msVarMs.ms(this);
        msVarMs2.ms(this);
        msVarMs3.ms(this);
        msVarMs4.ms(this);
        msVarMs5.ms(this);
        if (type == com.bytedance.adsdk.lottie.model.xr.ch.ms.STAR) {
            this.ch.ms(this);
            this.sl.ms(this);
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        xr();
    }

    private void xr() {
        this.ub = false;
        this.ah.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        for (int i = 0; i < list.size(); i++) {
            ah ahVar = list.get(i);
            if (ahVar instanceof nw) {
                nw nwVar = (nw) ahVar;
                if (nwVar.getType() == com.bytedance.adsdk.lottie.model.xr.y.ms.SIMULTANEOUSLY) {
                    this.u.ms(nwVar);
                    nwVar.ms(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.zb
    public Path d() {
        if (this.ub) {
            return this.f254ms;
        }
        this.f254ms.reset();
        if (this.ka) {
            this.ub = true;
            return this.f254ms;
        }
        int i = AnonymousClass1.f255ms[this.d.ordinal()];
        if (i == 1) {
            ah();
        } else if (i == 2) {
            ka();
        }
        this.f254ms.close();
        this.u.ms(this.f254ms);
        this.ub = true;
        return this.f254ms;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.ms.ms.u$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f255ms;

        static {
            int[] iArr = new int[com.bytedance.adsdk.lottie.model.xr.ch.ms.values().length];
            f255ms = iArr;
            try {
                iArr[com.bytedance.adsdk.lottie.model.xr.ch.ms.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f255ms[com.bytedance.adsdk.lottie.model.xr.ch.ms.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void ah() {
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        float fFloatValue = this.ab.ab().floatValue();
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> msVar = this.ny;
        double radians = Math.toRadians((msVar == null ? 0.0d : msVar.ab().floatValue()) - 90.0d);
        double d2 = fFloatValue;
        float f6 = (float) (6.283185307179586d / d2);
        if (this.c) {
            f6 *= -1.0f;
        }
        float f7 = f6 / 2.0f;
        float f8 = fFloatValue - ((int) fFloatValue);
        if (f8 != 0.0f) {
            radians += (double) ((1.0f - f8) * f7);
        }
        float fFloatValue2 = this.hi.ab().floatValue();
        float fFloatValue3 = this.ch.ab().floatValue();
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> msVar2 = this.sl;
        float fFloatValue4 = msVar2 != null ? msVar2.ab().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> msVar3 = this.zb;
        float fFloatValue5 = msVar3 != null ? msVar3.ab().floatValue() / 100.0f : 0.0f;
        if (f8 != 0.0f) {
            f3 = ((fFloatValue2 - fFloatValue3) * f8) + fFloatValue3;
            double d3 = f3;
            float fCos = (float) (d3 * Math.cos(radians));
            fSin = (float) (d3 * Math.sin(radians));
            this.f254ms.moveTo(fCos, fSin);
            d = radians + ((double) ((f6 * f8) / 2.0f));
            f = fCos;
            f2 = f7;
        } else {
            double d4 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.f254ms.moveTo(fCos2, fSin2);
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
                    this.f254ms.lineTo(fCos3, fSin3);
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
                    this.f254ms.cubicTo(f10 - f16, fSin - f17, fCos3 + f19, fSin3 + f20, fCos3, fSin3);
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
                PointF pointFAb = this.x.ab();
                this.f254ms.offset(pointFAb.x, pointFAb.y);
                this.f254ms.close();
                return;
            }
        }
    }

    private void ka() {
        int iFloor = (int) Math.floor(this.ab.ab().floatValue());
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> msVar = this.ny;
        double radians = Math.toRadians((msVar == null ? 0.0d : msVar.ab().floatValue()) - 90.0d);
        double d = iFloor;
        float fFloatValue = this.zb.ab().floatValue() / 100.0f;
        float fFloatValue2 = this.hi.ab().floatValue();
        double d2 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d2);
        float fSin = (float) (Math.sin(radians) * d2);
        this.f254ms.moveTo(fCos, fSin);
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
                this.f254ms.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan3)) * f), fSin2 + (f * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            } else {
                this.f254ms.lineTo(fCos2, fSin2);
            }
            d4 += d3;
            i++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d5;
            d2 = d2;
            d3 = d3;
        }
        PointF pointFAb = this.x.ab();
        this.f254ms.offset(pointFAb.x, pointFAb.y);
        this.f254ms.close();
    }
}
