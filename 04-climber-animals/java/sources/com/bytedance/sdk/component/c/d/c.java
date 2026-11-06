package com.bytedance.sdk.component.c.d;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ms {
    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "disk_cache";
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        byte[] bArrMs;
        String strC = ahVar.c();
        com.bytedance.sdk.component.c.xr xrVarNw = ahVar.nw();
        if (ahVar.b() || xrVarNw.c()) {
            bArrMs = ms(ahVar, strC);
        } else {
            bArrMs = xr(ahVar, strC);
        }
        if (bArrMs == null) {
            ahVar.ms(new hi());
            return;
        }
        ahVar.ms(new xr(bArrMs, null));
        if (xrVarNw.ab()) {
            ahVar.t().xr(xrVarNw).ms(strC, bArrMs);
        }
    }

    private byte[] ms(com.bytedance.sdk.component.c.ah.ah ahVar, String str) {
        ahVar.t().ah(ahVar.nw());
        Collection<com.bytedance.sdk.component.c.ah> collectionAh = ahVar.t().ah();
        if (collectionAh == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.c.ah> it = collectionAh.iterator();
        while (it.hasNext()) {
            byte[] bArrMs = it.next().ms(str);
            if (bArrMs != null) {
                return bArrMs;
            }
        }
        return null;
    }

    private byte[] xr(com.bytedance.sdk.component.c.ah.ah ahVar, String str) {
        com.bytedance.sdk.component.c.ah ahVarAh = ahVar.t().ah(ahVar.nw());
        if (ahVarAh == null) {
            return null;
        }
        return ahVarAh.ms(str);
    }
}
