package com.bytedance.adsdk.lottie.ms.xr;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ab<com.bytedance.adsdk.lottie.model.xr.d> {
    private final com.bytedance.adsdk.lottie.model.xr.d d;

    public ka(List<com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.d>> list) {
        super(list);
        com.bytedance.adsdk.lottie.model.xr.d dVar = list.get(0).f150ms;
        int iAh = dVar != null ? dVar.ah() : 0;
        this.d = new com.bytedance.adsdk.lottie.model.xr.d(new float[iAh], new int[iAh]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.xr.d ms(com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.d> msVar, float f) {
        this.d.ms(msVar.f150ms, msVar.xr, f);
        return this.d;
    }
}
