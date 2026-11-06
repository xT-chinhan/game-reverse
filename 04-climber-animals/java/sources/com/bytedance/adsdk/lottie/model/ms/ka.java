package com.bytedance.adsdk.lottie.model.ms;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements zb<PointF, PointF> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.c.ms<PointF>> f210ms;

    public ka(List<com.bytedance.adsdk.lottie.c.ms<PointF>> list) {
        this.f210ms = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public List<com.bytedance.adsdk.lottie.c.ms<PointF>> ah() {
        return this.f210ms;
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public boolean xr() {
        return this.f210ms.size() == 1 && this.f210ms.get(0).ka();
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> ms() {
        if (this.f210ms.get(0).ka()) {
            return new com.bytedance.adsdk.lottie.ms.xr.hi(this.f210ms);
        }
        return new com.bytedance.adsdk.lottie.ms.xr.ch(this.f210ms);
    }
}
