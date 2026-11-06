package com.bytedance.adsdk.ugeno.ka.xr;

import com.bytedance.adsdk.ugeno.ka.c;
import com.taptap.sdk.db.constant.Common;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    private List<com.bytedance.adsdk.ugeno.ka.ms.d> x;

    public xr(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, c.ms msVar) {
        super(ahVar, str, msVar);
        this.x = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.ka.xr.ms
    public void ms() {
        com.bytedance.adsdk.ugeno.ka.ms.ah ahVarMs;
        if (this.c == null || this.c.size() <= 0) {
            return;
        }
        String str = this.c.get(Common.System.NAME);
        com.bytedance.adsdk.ugeno.ka.ms.ms msVarM = this.ah.m();
        if (msVarM == null || (ahVarMs = msVarM.ms(str)) == null) {
            return;
        }
        ahVarMs.ms(str);
    }
}
