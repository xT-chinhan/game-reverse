package com.bytedance.ms.xr.ka.ms;

import android.content.Context;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.hi;

/* JADX INFO: loaded from: classes2.dex */
class ab extends ah {
    ab(Context context, xr xrVar, d dVar) {
        super(com.bytedance.ms.xr.ah.JAVA, context, xrVar, dVar);
    }

    @Override // com.bytedance.ms.xr.ka.ms.ah
    public com.bytedance.ms.xr.ah.ms ms(com.bytedance.ms.xr.ah.ms msVar) {
        com.bytedance.ms.xr.ah.ms msVarMs = super.ms(msVar);
        msVarMs.ms("app_count", (Object) 1);
        msVarMs.ms("magic_tag", "ss_app_log");
        ah(msVarMs);
        com.bytedance.ms.xr.ah.xr xrVarMs = com.bytedance.ms.xr.ah.xr.ms(this.xr);
        xrVarMs.ms(x.ms().ms());
        xrVarMs.ms(x.ah().ms());
        xrVarMs.xr(this.ah.ah());
        msVarMs.ms(xrVarMs);
        hi.ms(msVarMs, xrVarMs, this.f573ms);
        return msVarMs;
    }
}
