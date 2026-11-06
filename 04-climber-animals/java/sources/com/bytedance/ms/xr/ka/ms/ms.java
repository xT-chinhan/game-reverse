package com.bytedance.ms.xr.ka.ms;

import android.content.Context;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.hi;
import com.bytedance.pangle.provider.ContentProviderManager;

/* JADX INFO: loaded from: classes2.dex */
class ms extends ah {
    ms(Context context, xr xrVar, d dVar) {
        super(com.bytedance.ms.xr.ah.ANR, context, xrVar, dVar);
    }

    @Override // com.bytedance.ms.xr.ka.ms.ah
    public com.bytedance.ms.xr.ah.ms ms(com.bytedance.ms.xr.ah.ms msVar) {
        com.bytedance.ms.xr.ah.ms msVarMs = super.ms(msVar);
        com.bytedance.ms.xr.ah.xr xrVarMs = com.bytedance.ms.xr.ah.xr.ms(this.xr);
        xrVarMs.ms(x.ms().ms());
        xrVarMs.ms(x.ah().ms());
        xrVarMs.xr(this.ah.ah());
        msVarMs.ms(xrVarMs);
        msVarMs.ms(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.ms.xr.x.ms.d(this.xr));
        hi.ms(msVarMs, xrVarMs, this.f573ms);
        return msVarMs;
    }
}
