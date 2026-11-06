package com.smartdigimkt.x4;

import android.text.TextUtils;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends com.smartdigimkt.v4.c {
    public static void f(com.smartdigimkt.v4.a aVar) {
        Map<String, Object> extraMap;
        SDMAdRequest sDMAdRequest = aVar.b;
        if (sDMAdRequest == null || (extraMap = sDMAdRequest.getExtraMap()) == null || extraMap.isEmpty() || (extraMap.get("s2s_bid_adm") == null && extraMap.get(com.anythink.core.bridge.a.C0010a.c) == null)) {
            String strA = com.smartdigimkt.r4.j.a(aVar.a);
            aVar.g = strA;
            com.smartdigimkt.t4.p pVar = aVar.d;
            if (pVar instanceof com.smartdigimkt.t4.c) {
                ((com.smartdigimkt.t4.c) pVar).setRequestId(strA);
            }
            com.smartdigimkt.o4.o oVarA = com.smartdigimkt.o4.o.a();
            String str = aVar.e;
            com.smartdigimkt.o4.u uVar = oVarA.a;
            String strA2 = SDKContext.getInstance().a();
            uVar.getClass();
            aVar.A = (TextUtils.isEmpty(strA2) || TextUtils.isEmpty(str) || !uVar.b.containsKey(new StringBuilder().append(strA2).append(str).toString())) ? 1 : 2;
            aVar.v = com.smartdigimkt.r4.b0.a(aVar);
            ConcurrentHashMap concurrentHashMap = com.smartdigimkt.n3.t.a;
            com.smartdigimkt.n3.l lVarA = com.smartdigimkt.n3.l.a(aVar);
            if (lVarA != null && !TextUtils.isEmpty(lVarA.a)) {
                ConcurrentHashMap concurrentHashMap2 = com.smartdigimkt.n3.t.a;
                com.smartdigimkt.n3.l lVar = (com.smartdigimkt.n3.l) concurrentHashMap2.get(lVarA.a);
                if (lVar != null && lVar.n) {
                    lVarA.n = true;
                    lVarA.o = lVar.o;
                }
                concurrentHashMap2.put(lVarA.a, lVarA);
                if (!TextUtils.isEmpty(lVarA.b)) {
                    com.smartdigimkt.n3.t.b.put(lVarA.b, lVarA.a);
                }
            }
            com.smartdigimkt.n3.e.a(aVar.a).a(10, aVar.v, -1L);
        }
    }

    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        com.smartdigimkt.h3.b bVar = aVar.x;
        if (bVar != null) {
            bVar.d("stateCheck");
        }
        if (aVar.h) {
            aVar.a(com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, ""));
            if (bVar != null) {
                bVar.a("stateCheck");
            }
            return false;
        }
        aVar.h = true;
        com.smartdigimkt.v2.p.c().i();
        com.smartdigimkt.v2.p pVarC = com.smartdigimkt.v2.p.c();
        pVarC.getClass();
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.v2.l(pVarC), 0L, 17);
        aVar.i = new com.smartdigimkt.w4.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar2 = aVar.i;
        if (aVar2 != null) {
            aVar2.a = jCurrentTimeMillis;
        }
        SDKContext sDKContext = SDKContext.getInstance();
        boolean z = sDKContext.e;
        boolean z2 = sDKContext.f;
        if (!z || !z2) {
            com.smartdigimkt.q3.f.a().c(new z(this, sDKContext, bVar, aVar));
            return false;
        }
        f(aVar);
        if (bVar != null) {
            synchronized (bVar) {
            }
            bVar.a("stateCheck");
        }
        return true;
    }
}
