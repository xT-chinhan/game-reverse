package com.bytedance.adsdk.lottie.ms.xr;

/* JADX INFO: loaded from: classes2.dex */
public class h<K, A> extends ms<K, A> {
    private final A d;

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    float c() {
        return 1.0f;
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    public void ms(float f) {
        this.xr = f;
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    public void xr() {
        if (this.ah != null) {
            super.xr();
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    public A ab() {
        com.bytedance.adsdk.lottie.c.ah<A> ahVar = this.ah;
        A a = this.d;
        return ahVar.ms(0.0f, 0.0f, a, a, x(), x(), x());
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    A ms(com.bytedance.adsdk.lottie.c.ms<K> msVar, float f) {
        return ab();
    }
}
