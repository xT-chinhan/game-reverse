package com.bytedance.adsdk.xr.xr.xr.ms;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements com.bytedance.adsdk.xr.xr.xr.ms {
    protected com.bytedance.adsdk.xr.xr.d.ah ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected com.bytedance.adsdk.xr.xr.xr.ms f470ms;
    protected com.bytedance.adsdk.xr.xr.xr.ms xr;

    protected h(com.bytedance.adsdk.xr.xr.d.ah ahVar) {
        this.ah = ahVar;
    }

    public void ms(com.bytedance.adsdk.xr.xr.xr.ms msVar) {
        this.f470ms = msVar;
    }

    public void xr(com.bytedance.adsdk.xr.xr.xr.ms msVar) {
        this.xr = msVar;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public com.bytedance.adsdk.xr.xr.d.ka ms() {
        return com.bytedance.adsdk.xr.xr.d.c.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public String xr() {
        return this.f470ms.xr() + this.ah.ms() + this.xr.xr();
    }

    public String toString() {
        return xr();
    }
}
