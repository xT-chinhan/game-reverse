package com.smartdigimkt.t4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.api.format.SDMWinInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {
    public final /* synthetic */ com.smartdigimkt.e1.d a;
    public final /* synthetic */ SDMLossInfo b;

    public z(com.smartdigimkt.e1.d dVar, SDMLossInfo sDMLossInfo) {
        this.a = dVar;
        this.b = sDMLossInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.e1.d dVar = this.a;
        d0 d0Var = new d0(dVar);
        SDMLossInfo sDMLossInfo = this.b;
        if (!d0Var.a()) {
            try {
                com.smartdigimkt.u4.a aVarA = d0.a(false, dVar, null, sDMLossInfo);
                d0.a(dVar, sDMLossInfo, aVarA);
                if (TextUtils.isEmpty(aVarA.h)) {
                    d0.d(aVarA);
                } else {
                    new com.smartdigimkt.f4.h(aVarA.b ? aVarA.g : aVarA.h).a(0, (com.smartdigimkt.a4.b) new c0(aVarA));
                }
            } catch (Throwable unused) {
            }
        }
        com.smartdigimkt.e1.d dVar2 = d0Var.a;
        try {
            com.smartdigimkt.b3.b bVar = dVar2.e;
            if (bVar == null) {
                return;
            }
            com.smartdigimkt.h0.m mVar = new com.smartdigimkt.h0.m(dVar2.c, "");
            mVar.o = d0.b(dVar2, sDMLossInfo, null);
            com.smartdigimkt.z.s.a(36, bVar, mVar);
            d0Var.a(false, (SDMWinInfo) null, sDMLossInfo);
        } catch (Throwable unused2) {
        }
    }
}
