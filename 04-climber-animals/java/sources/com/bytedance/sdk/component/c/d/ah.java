package com.bytedance.sdk.component.c.d;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "generate_key";
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        if (TextUtils.isEmpty(ahVar.ab())) {
            com.bytedance.sdk.component.c.sl slVarKa = ahVar.t().ka();
            ahVar.xr(slVarKa.ms(ahVar));
            ahVar.ms(slVarKa.xr(ahVar));
        }
        ahVar.ms(new ab());
    }
}
