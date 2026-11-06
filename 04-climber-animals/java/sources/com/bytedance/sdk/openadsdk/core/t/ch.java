package com.bytedance.sdk.openadsdk.core.t;

/* JADX INFO: loaded from: classes2.dex */
class ch implements com.bytedance.sdk.component.x.ms.ms.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    com.bytedance.sdk.component.ny.xr.ah f3312ms;

    ch(com.bytedance.sdk.component.ny.xr.ah ahVar) {
        this.f3312ms = ahVar;
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.xr
    public void ms(String str) {
        com.bytedance.sdk.component.ny.xr.ah ahVar = this.f3312ms;
        if (ahVar != null) {
            ahVar.ms(str);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.xr
    public void ms(String str, String str2) {
        com.bytedance.sdk.component.ny.xr.ah ahVar = this.f3312ms;
        if (ahVar != null) {
            ahVar.xr(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.xr
    public com.bytedance.sdk.component.x.ms.ms.ka ms() {
        if (this.f3312ms == null) {
            return null;
        }
        return new hi(this.f3312ms.ms());
    }
}
