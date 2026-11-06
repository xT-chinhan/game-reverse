package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements y, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> ah;
    private com.bytedance.adsdk.lottie.model.xr.u d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.x f247ms;
    private final String xr;

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
    }

    public h(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.zb zbVar) {
        this.f247ms = xVar;
        this.xr = zbVar.ms();
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs = zbVar.xr().ms();
        this.ah = msVarMs;
        ahVar.ms(msVarMs);
        msVarMs.ms(this);
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        this.f247ms.invalidateSelf();
    }

    public com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> xr() {
        return this.ah;
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.y
    public com.bytedance.adsdk.lottie.model.xr.u ms(com.bytedance.adsdk.lottie.model.xr.u uVar) {
        List<com.bytedance.adsdk.lottie.model.ms> listAh = uVar.ah();
        if (listAh.size() <= 2) {
            return uVar;
        }
        float fFloatValue = this.ah.ab().floatValue();
        if (fFloatValue == 0.0f) {
            return uVar;
        }
        com.bytedance.adsdk.lottie.model.xr.u uVarXr = xr(uVar);
        uVarXr.ms(uVar.ms().x, uVar.ms().y);
        List<com.bytedance.adsdk.lottie.model.ms> listAh2 = uVarXr.ah();
        boolean zXr = uVar.xr();
        int i = 0;
        int i2 = 0;
        while (i < listAh.size()) {
            com.bytedance.adsdk.lottie.model.ms msVar = listAh.get(i);
            com.bytedance.adsdk.lottie.model.ms msVar2 = listAh.get(ms(i - 1, listAh.size()));
            com.bytedance.adsdk.lottie.model.ms msVar3 = listAh.get(ms(i - 2, listAh.size()));
            PointF pointFAh = (i != 0 || zXr) ? msVar2.ah() : uVar.ms();
            PointF pointFXr = (i != 0 || zXr) ? msVar2.xr() : pointFAh;
            PointF pointFMs = msVar.ms();
            PointF pointFAh2 = msVar3.ah();
            PointF pointFAh3 = msVar.ah();
            boolean z = !uVar.xr() && i == 0 && i == listAh.size() + (-1);
            if (pointFXr.equals(pointFAh) && pointFMs.equals(pointFAh) && !z) {
                float f = pointFAh.x - pointFAh2.x;
                float f2 = pointFAh.y - pointFAh2.y;
                float f3 = pointFAh3.x - pointFAh.x;
                float f4 = pointFAh3.y - pointFAh.y;
                float fHypot = (float) Math.hypot(f, f2);
                float fHypot2 = (float) Math.hypot(f3, f4);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f5 = pointFAh.x + ((pointFAh2.x - pointFAh.x) * fMin);
                float f6 = pointFAh.y + ((pointFAh2.y - pointFAh.y) * fMin);
                float f7 = pointFAh.x + ((pointFAh3.x - pointFAh.x) * fMin2);
                float f8 = pointFAh.y + ((pointFAh3.y - pointFAh.y) * fMin2);
                float f9 = f5 - ((f5 - pointFAh.x) * 0.5519f);
                float f10 = f6 - ((f6 - pointFAh.y) * 0.5519f);
                float f11 = f7 - ((f7 - pointFAh.x) * 0.5519f);
                float f12 = f8 - ((f8 - pointFAh.y) * 0.5519f);
                com.bytedance.adsdk.lottie.model.ms msVar4 = listAh2.get(ms(i2 - 1, listAh2.size()));
                com.bytedance.adsdk.lottie.model.ms msVar5 = listAh2.get(i2);
                msVar4.xr(f5, f6);
                msVar4.ah(f5, f6);
                if (i == 0) {
                    uVarXr.ms(f5, f6);
                }
                msVar5.ms(f9, f10);
                i2++;
                com.bytedance.adsdk.lottie.model.ms msVar6 = listAh2.get(i2);
                msVar5.xr(f11, f12);
                msVar5.ah(f7, f8);
                msVar6.ms(f7, f8);
            } else {
                com.bytedance.adsdk.lottie.model.ms msVar7 = listAh2.get(ms(i2 - 1, listAh2.size()));
                com.bytedance.adsdk.lottie.model.ms msVar8 = listAh2.get(i2);
                msVar7.xr(msVar2.xr().x, msVar2.xr().y);
                msVar7.ah(msVar2.ah().x, msVar2.ah().y);
                msVar8.ms(msVar.ms().x, msVar.ms().y);
            }
            i2++;
            i++;
            listAh = listAh;
            zXr = zXr;
        }
        return uVarXr;
    }

    private com.bytedance.adsdk.lottie.model.xr.u xr(com.bytedance.adsdk.lottie.model.xr.u uVar) {
        List<com.bytedance.adsdk.lottie.model.ms> listAh = uVar.ah();
        boolean zXr = uVar.xr();
        int size = listAh.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.bytedance.adsdk.lottie.model.ms msVar = listAh.get(size);
            com.bytedance.adsdk.lottie.model.ms msVar2 = listAh.get(ms(size - 1, listAh.size()));
            PointF pointFAh = (size != 0 || zXr) ? msVar2.ah() : uVar.ms();
            i = (((size != 0 || zXr) ? msVar2.xr() : pointFAh).equals(pointFAh) && msVar.ms().equals(pointFAh) && !(!uVar.xr() && size == 0 && size == listAh.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.bytedance.adsdk.lottie.model.xr.u uVar2 = this.d;
        if (uVar2 == null || uVar2.ah().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.bytedance.adsdk.lottie.model.ms());
            }
            this.d = new com.bytedance.adsdk.lottie.model.xr.u(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.d.ms(zXr);
        return this.d;
    }

    private static int ms(int i, int i2) {
        return i - (xr(i, i2) * i2);
    }

    private static int xr(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}
