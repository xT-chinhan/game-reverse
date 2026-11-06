package com.bytedance.ms.xr.ka.ms;

import android.content.Context;
import com.bytedance.ms.xr.x;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
class c extends ah {
    c(Context context, xr xrVar, d dVar) {
        super(com.bytedance.ms.xr.ah.CUSTOM_JAVA, context, xrVar, dVar);
    }

    @Override // com.bytedance.ms.xr.ka.ms.ah
    public com.bytedance.ms.xr.ah.ms ms(com.bytedance.ms.xr.ah.ms msVar) {
        com.bytedance.ms.xr.ah.ms msVarMs = super.ms(msVar);
        com.bytedance.ms.xr.ah.xr xrVarMs = com.bytedance.ms.xr.ah.xr.ms(this.xr);
        xrVarMs.ms(x.ms().ms());
        xrVarMs.ms(x.ah().ms());
        xrVarMs.xr(this.ah.ah());
        msVarMs.ms(xrVarMs);
        return msVarMs;
    }
}
