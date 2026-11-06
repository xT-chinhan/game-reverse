package com.bytedance.sdk.openadsdk.core.ugeno.ms;

import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements xr {
    protected abstract String ms(lm lmVar, int i, int i2);

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ms.xr
    public String ms(lm lmVar) {
        int iKa = ka(lmVar);
        int iD = d(lmVar);
        if (iKa <= 0 || iKa > 9 || iD == -1) {
            return null;
        }
        return ms(lmVar, iKa, iD);
    }

    private int d(lm lmVar) {
        if (lmVar == null) {
            return -1;
        }
        return lmVar.kz();
    }

    private static int ka(lm lmVar) {
        int iX;
        if (lmVar == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = lmVar.rt();
        int iT = xrVarRt != null ? xrVarRt.t() : -1;
        return ((iT <= 0 || iT >= 10) && (iX = f.x(lmVar)) > 0 && iX < 10) ? iX : iT;
    }

    public static xr ms(lm lmVar, zb zbVar) {
        if (lmVar == null || ka(lmVar) != 5) {
            return null;
        }
        if ((zbVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.xr) && ((com.bytedance.sdk.openadsdk.core.ugeno.express.xr) zbVar).jw()) {
            return new com.bytedance.sdk.openadsdk.core.ugeno.ms.xr.ms();
        }
        return new com.bytedance.sdk.openadsdk.core.ugeno.ms.ms.ms();
    }

    public static boolean xr(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        return (lmVar.ha() == 2) && ah(lmVar);
    }

    public static boolean ah(lm lmVar) {
        return ka(lmVar) == 5;
    }
}
