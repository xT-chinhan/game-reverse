package com.byazt.ova;

import android.graphics.Path;
import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g implements com.byazt.al.pr.InterfaceC0016pr, m, w {
    public final com.byazt.al.pr<?, Float> aj;
    public final boolean c;
    public final com.byazt.al.pr<?, Float> fw;
    public final com.byazt.dx.zo hn;
    public boolean ho;
    public final String hw;
    public final com.byazt.al.pr<?, Float> k;
    public final com.byazt.al.pr<?, Float> m;
    public final boolean uc;
    public final com.byazt.al.pr<?, Float> vk;
    public final com.byazt.al.pr<?, Float> w;
    public final com.byazt.ynb.vk.pr x;
    public final com.byazt.al.pr<?, PointF> zo;
    public final Path pr = new Path();
    public final hw g = new hw();

    public g(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.vk vkVar) {
        this.hn = zoVar;
        this.hw = vkVar.pr();
        com.byazt.ynb.vk.pr type = vkVar.getType();
        this.x = type;
        this.c = vkVar.aj();
        this.uc = vkVar.vk();
        com.byazt.al.pr<Float, Float> prVarPr = vkVar.hw().pr();
        this.fw = prVarPr;
        com.byazt.al.pr<PointF, PointF> prVarPr2 = vkVar.hn().pr();
        this.zo = prVarPr2;
        com.byazt.al.pr<Float, Float> prVarPr3 = vkVar.x().pr();
        this.aj = prVarPr3;
        com.byazt.al.pr<Float, Float> prVarPr4 = vkVar.uc().pr();
        this.w = prVarPr4;
        com.byazt.al.pr<Float, Float> prVarPr5 = vkVar.zo().pr();
        this.m = prVarPr5;
        if (type == com.byazt.ynb.vk.pr.STAR) {
            this.vk = vkVar.c().pr();
            this.k = vkVar.fw().pr();
        } else {
            this.vk = null;
            this.k = null;
        }
        hnVar.pr(prVarPr);
        hnVar.pr(prVarPr2);
        hnVar.pr(prVarPr3);
        hnVar.pr(prVarPr4);
        hnVar.pr(prVarPr5);
        if (type == com.byazt.ynb.vk.pr.STAR) {
            hnVar.pr(this.vk);
            hnVar.pr(this.k);
        }
        prVarPr.pr(this);
        prVarPr2.pr(this);
        prVarPr3.pr(this);
        prVarPr4.pr(this);
        prVarPr5.pr(this);
        if (type == com.byazt.ynb.vk.pr.STAR) {
            this.vk.pr(this);
            this.k.pr(this);
        }
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        hw();
    }

    private void hw() {
        this.ho = false;
        this.hn.invalidateSelf();
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        for (int i = 0; i < list.size(); i++) {
            hn hnVar = list.get(i);
            if (hnVar instanceof cz) {
                cz czVar = (cz) hnVar;
                if (czVar.getType() == com.byazt.ynb.qa.pr.SIMULTANEOUSLY) {
                    this.g.pr(czVar);
                    czVar.pr(this);
                }
            }
        }
    }

    @Override // com.byazt.ova.m
    public Path x() {
        if (this.ho) {
            return this.pr;
        }
        this.pr.reset();
        if (this.c) {
            this.ho = true;
            return this.pr;
        }
        switch (AnonymousClass1.pr[this.x.ordinal()]) {
            case 1:
                hn();
                break;
            case 2:
                c();
                break;
        }
        this.pr.close();
        this.g.pr(this.pr);
        this.ho = true;
        return this.pr;
    }

    /* JADX INFO: renamed from: com.byazt.ova.g$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 423, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.ynb.vk.pr.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.ynb.vk.pr.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.ynb.vk.pr.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private void hn() {
        float fFloatValue;
        float fFloatValue2;
        double d;
        float fCos;
        float fSin;
        float f;
        float f2;
        float fFloatValue3 = this.fw.fw().floatValue();
        com.byazt.al.pr<?, Float> prVar = this.aj;
        double radians = Math.toRadians((prVar == null ? 0.0d : prVar.fw().floatValue()) - 90.0d);
        double d2 = fFloatValue3;
        float f3 = (float) (6.283185307179586d / d2);
        if (this.uc) {
            f3 *= -1.0f;
        }
        float f4 = f3 / 2.0f;
        float f5 = fFloatValue3 - ((int) fFloatValue3);
        if (f5 != 0.0f) {
            radians += (double) ((1.0f - f5) * f4);
        }
        float fFloatValue4 = this.w.fw().floatValue();
        float fFloatValue5 = this.vk.fw().floatValue();
        com.byazt.al.pr<?, Float> prVar2 = this.k;
        if (prVar2 == null) {
            fFloatValue = 0.0f;
        } else {
            fFloatValue = prVar2.fw().floatValue() / 100.0f;
        }
        com.byazt.al.pr<?, Float> prVar3 = this.m;
        if (prVar3 == null) {
            fFloatValue2 = 0.0f;
        } else {
            fFloatValue2 = prVar3.fw().floatValue() / 100.0f;
        }
        if (f5 != 0.0f) {
            f = ((fFloatValue4 - fFloatValue5) * f5) + fFloatValue5;
            double d3 = f;
            fCos = (float) (d3 * Math.cos(radians));
            fSin = (float) (d3 * Math.sin(radians));
            this.pr.moveTo(fCos, fSin);
            d = radians + ((double) ((f3 * f5) / 2.0f));
        } else {
            double d4 = fFloatValue4;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.pr.moveTo(fCos2, fSin2);
            d = radians + ((double) f4);
            fCos = fCos2;
            fSin = fSin2;
            f = 0.0f;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        int i = 0;
        boolean z = false;
        while (true) {
            float f6 = fFloatValue4;
            float f7 = fFloatValue5;
            double d5 = i;
            if (d5 < dCeil) {
                float f8 = z ? f6 : f7;
                float f9 = (f == 0.0f || d5 != dCeil - 2.0d) ? f4 : (f3 * f5) / 2.0f;
                double d6 = (f == 0.0f || d5 != dCeil - 1.0d) ? f8 : f;
                double d7 = dCeil;
                float fCos3 = (float) (d6 * Math.cos(d));
                float fSin3 = (float) (d6 * Math.sin(d));
                if (fFloatValue == 0.0f && fFloatValue2 == 0.0f) {
                    this.pr.lineTo(fCos3, fSin3);
                    f2 = fFloatValue;
                } else {
                    f2 = fFloatValue;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan3);
                    float fSin5 = (float) Math.sin(dAtan3);
                    float f10 = z ? f2 : fFloatValue2;
                    float f11 = z ? fFloatValue2 : f2;
                    float f12 = (z ? f7 : f6) * f10 * 0.47829f;
                    float f13 = fCos4 * f12;
                    float f14 = f12 * fSin4;
                    float f15 = (z ? f6 : f7) * f11 * 0.47829f;
                    float f16 = fCos5 * f15;
                    float f17 = f15 * fSin5;
                    if (f5 != 0.0f) {
                        if (i == 0) {
                            f13 *= f5;
                            f14 *= f5;
                        } else if (d5 == d7 - 1.0d) {
                            f16 *= f5;
                            f17 *= f5;
                        }
                    }
                    this.pr.cubicTo(fCos - f13, fSin - f14, fCos3 + f16, fSin3 + f17, fCos3, fSin3);
                }
                d += (double) f9;
                z = !z;
                i++;
                fCos = fCos3;
                fSin = fSin3;
                fFloatValue = f2;
                fFloatValue4 = f6;
                fFloatValue5 = f7;
                f = f;
                f4 = f4;
                f3 = f3;
                dCeil = d7;
            } else {
                PointF pointFFw = this.zo.fw();
                this.pr.offset(pointFFw.x, pointFFw.y);
                this.pr.close();
                return;
            }
        }
    }

    private void c() {
        int iFloor = (int) Math.floor(this.fw.fw().floatValue());
        com.byazt.al.pr<?, Float> prVar = this.aj;
        double radians = Math.toRadians((prVar == null ? 0.0d : prVar.fw().floatValue()) - 90.0d);
        double d = iFloor;
        float fFloatValue = this.m.fw().floatValue() / 100.0f;
        float fFloatValue2 = this.w.fw().floatValue();
        double d2 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d2);
        float fSin = (float) (Math.sin(radians) * d2);
        this.pr.moveTo(fCos, fSin);
        double d3 = (float) (6.283185307179586d / d);
        double d4 = radians + d3;
        double dCeil = Math.ceil(d);
        int i = 0;
        while (i < dCeil) {
            float fCos2 = (float) (Math.cos(d4) * d2);
            double d5 = dCeil;
            float fSin2 = (float) (d2 * Math.sin(d4));
            if (fFloatValue == 0.0f) {
                this.pr.lineTo(fCos2, fSin2);
            } else {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.pr.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan3)) * f), fSin2 + (f * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            }
            d4 += d3;
            i++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d5;
            d2 = d2;
            d3 = d3;
        }
        PointF pointFFw = this.zo.fw();
        this.pr.offset(pointFFw.x, pointFFw.y);
        this.pr.close();
    }
}
