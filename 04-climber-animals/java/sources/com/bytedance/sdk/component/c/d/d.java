package com.bytedance.sdk.component.c.d;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "cache_policy";
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        com.bytedance.sdk.component.c.xr xrVarNw = ahVar.nw();
        if (xrVarNw != null) {
            if (xrVarNw.ah()) {
                ahVar.ms(new ch());
                return;
            } else if (xrVarNw.d()) {
                ahVar.ms(new c());
                return;
            }
        }
        ahVar.ms(new hi());
    }
}
