package com.bytedance.sdk.component.c.d;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends ms {
    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "raw_cache";
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        byte[] bArrMs = ahVar.t().xr(ahVar.nw()).ms(ahVar.c());
        if (bArrMs == null) {
            ahVar.ms(new c());
        } else {
            ahVar.ms(new xr(bArrMs, null));
        }
    }
}
