package com.bytedance.adsdk.ugeno.ka.ah;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms implements com.bytedance.adsdk.ugeno.ka.ms.d {
    private com.bytedance.adsdk.ugeno.ka.ms.ah hi;

    public xr(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ah.ms
    public boolean ms(Object... objArr) {
        com.bytedance.adsdk.ugeno.ka.ms.ms msVarM = this.xr.m();
        if (msVarM == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.ka.ms.ah ahVarMs = msVarM.ms(this.c);
        this.hi = ahVarMs;
        if (ahVarMs != null) {
            ahVarMs.ms(this);
            return false;
        }
        msVarM.ms(this.c, new com.bytedance.adsdk.ugeno.ka.ms.xr());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ms.d
    public void ms(String str) {
        this.f360ms.ms(this.xr, this.c, this.ah.xr());
    }
}
