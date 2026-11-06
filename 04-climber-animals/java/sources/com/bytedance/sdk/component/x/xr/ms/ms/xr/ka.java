package com.bytedance.sdk.component.x.xr.ms.ms.xr;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends c {
    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.c
    public byte ah() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.c
    public byte xr() {
        return (byte) 2;
    }

    public ka(Context context, com.bytedance.sdk.component.x.xr.d.xr.ms msVar, com.bytedance.sdk.component.x.ms.ka kaVar) {
        super(context, msVar, kaVar);
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.c, com.bytedance.sdk.component.x.xr.ms.ms.xr.xr
    public String ms() {
        com.bytedance.sdk.component.x.ms.c cVarXr = this.xr.xr();
        if (cVarXr != null) {
            return cVarXr.ah();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.c, com.bytedance.sdk.component.x.xr.ms.ms
    public boolean ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return com.bytedance.sdk.component.x.xr.ah.ms.xr(xrVar);
    }
}
