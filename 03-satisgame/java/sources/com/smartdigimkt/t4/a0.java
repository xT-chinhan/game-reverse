package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.api.format.SDMWinInfo;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ com.smartdigimkt.e1.d a;

    public a0(com.smartdigimkt.e1.d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.e1.d dVar = this.a;
        d0 d0Var = new d0(dVar);
        com.smartdigimkt.a3.a aVar = dVar.c;
        if (!d0Var.a()) {
            d0.a(dVar, (SDMWinInfo) null, true);
        }
        try {
            com.smartdigimkt.b3.b bVar = dVar.e;
            if (bVar == null) {
                return;
            }
            com.smartdigimkt.h0.m mVar = new com.smartdigimkt.h0.m(dVar.c, "");
            mVar.p = true;
            mVar.o = new HashMap();
            com.smartdigimkt.z.s.a(10, bVar, mVar);
            d0Var.a(true, (SDMWinInfo) null, (SDMLossInfo) null);
            com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
            SDKContext.getInstance().d();
            eVarA.getClass();
        } catch (Throwable unused) {
        }
    }
}
