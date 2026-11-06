package com.bytedance.sdk.component.c.d;

import com.bytedance.sdk.component.c.ao;
import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class x extends ms {
    private String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Throwable f1187ms;
    private int xr;

    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return IdentityVerifyStateKt.VERIFY_STATE_FAILED;
    }

    public x(int i, String str, Throwable th) {
        this.xr = i;
        this.ah = str;
        this.f1187ms = th;
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        ahVar.ms(new com.bytedance.sdk.component.c.ah.ms(this.xr, this.ah, this.f1187ms));
        String strI = ahVar.i();
        Map<String, List<com.bytedance.sdk.component.c.ah.ah>> mapAb = ahVar.t().ab();
        List<com.bytedance.sdk.component.c.ah.ah> list = mapAb.get(strI);
        if (list == null) {
            xr(ahVar);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.c.ah.ah> it = list.iterator();
            while (it.hasNext()) {
                xr(it.next());
            }
            list.clear();
            mapAb.remove(strI);
        }
    }

    private void xr(com.bytedance.sdk.component.c.ah.ah ahVar) {
        ao aoVarHi = ahVar.hi();
        if (aoVarHi != null) {
            aoVarHi.ms(this.xr, this.ah, this.f1187ms);
        }
    }
}
