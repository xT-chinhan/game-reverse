package com.bytedance.adsdk.lottie.model.ms;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends u<com.bytedance.adsdk.lottie.model.xr.d, com.bytedance.adsdk.lottie.model.xr.d> {
    @Override // com.bytedance.adsdk.lottie.model.ms.u, com.bytedance.adsdk.lottie.model.ms.zb
    public /* bridge */ /* synthetic */ List ah() {
        return super.ah();
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.u
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.u, com.bytedance.adsdk.lottie.model.ms.zb
    public /* bridge */ /* synthetic */ boolean xr() {
        return super.xr();
    }

    public ah(List<com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.d>> list) {
        super(ms(list));
    }

    private static List<com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.d>> ms(List<com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.d>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, ms(list.get(i)));
        }
        return list;
    }

    private static com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.d> ms(com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.d> msVar) {
        com.bytedance.adsdk.lottie.model.xr.d dVar = msVar.f150ms;
        com.bytedance.adsdk.lottie.model.xr.d dVar2 = msVar.xr;
        if (dVar == null || dVar2 == null || dVar.ms().length == dVar2.ms().length) {
            return msVar;
        }
        float[] fArrMs = ms(dVar.ms(), dVar2.ms());
        return msVar.ms(dVar.ms(fArrMs), dVar2.ms(fArrMs));
    }

    static float[] ms(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.d, com.bytedance.adsdk.lottie.model.xr.d> ms() {
        return new com.bytedance.adsdk.lottie.ms.xr.ka(this.f213ms);
    }
}
