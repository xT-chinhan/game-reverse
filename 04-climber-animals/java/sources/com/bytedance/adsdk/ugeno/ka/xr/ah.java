package com.bytedance.adsdk.ugeno.ka.xr;

import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ka.c;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    private ub x;

    public ah(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, c.ms msVar) {
        super(ahVar, str, msVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ka.xr.ms
    public void ms() {
        ub ubVarB = this.ah.b();
        this.x = ubVarB;
        if (ubVarB != null) {
            ubVarB.ms(this.ah, this.ab, this.xr);
        }
    }
}
