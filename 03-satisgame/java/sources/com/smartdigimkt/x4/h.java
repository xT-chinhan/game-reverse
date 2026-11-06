package com.smartdigimkt.x4;

import com.smartdigimkt.sdk.api.SDMSDK;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.smartdigimkt.v4.c {
    public final String c = "h";
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final AtomicBoolean e = new AtomicBoolean(false);
    public g f;

    public static void a(h hVar, com.smartdigimkt.v4.a aVar, com.smartdigimkt.p4.g gVar, String str) {
        hVar.getClass();
        com.smartdigimkt.m3.g.a().a(hVar.f);
        if (hVar.d.compareAndSet(false, true)) {
            com.smartdigimkt.h3.b bVar = aVar.x;
            if (bVar != null) {
                bVar.a("bidToken");
                bVar.b("bid");
            }
            aVar.a(com.smartdigimkt.z3.b.a("10008", str));
            a("fail", aVar);
            hVar.a(aVar, gVar, -2);
            hVar.a(aVar);
        }
    }

    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        a("start", aVar);
        if (aVar.a() || aVar.y) {
            com.smartdigimkt.h3.b bVar = aVar.x;
            if (bVar != null) {
                bVar.b("bidToken");
                bVar.b("bid");
            }
            a("success", aVar);
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar2 = aVar.i;
        if (aVar2 != null) {
            aVar2.d = jCurrentTimeMillis;
        }
        String str = aVar.g;
        com.smartdigimkt.p4.e eVar = aVar.n;
        if (eVar == null) {
            com.smartdigimkt.h3.b bVar2 = aVar.x;
            if (bVar2 != null) {
                bVar2.b("bidToken");
                bVar2.b("bid");
            }
            aVar.a(com.smartdigimkt.z3.b.a("10008", "The placeStrategy is null."));
            return false;
        }
        com.smartdigimkt.p4.g gVar = aVar.o;
        if (gVar == null) {
            com.smartdigimkt.h3.b bVar3 = aVar.x;
            if (bVar3 != null) {
                bVar3.b("bidToken");
                bVar3.b("bid");
            }
            aVar.a(com.smartdigimkt.z3.b.a("10008", "The placeStrategy does not has ADX ad source"));
            return false;
        }
        long j = eVar.p;
        if (j < 0) {
            j = 10000;
        }
        this.f = new g(new c(this, aVar, gVar));
        com.smartdigimkt.m3.g gVarA = com.smartdigimkt.m3.g.a();
        gVarA.a.a(this.f, j);
        ArrayList arrayList = new ArrayList();
        com.smartdigimkt.a3.a aVarA = com.smartdigimkt.a3.a.a(str, eVar, gVar);
        com.smartdigimkt.h3.b bVar4 = aVar.x;
        aVarA.z = bVar4;
        if (bVar4 != null) {
            bVar4.d("bidToken");
        }
        com.smartdigimkt.s3.m mVarA = com.smartdigimkt.s3.m.a();
        Map map = gVar.e;
        e eVar2 = new e(this, aVar, gVar, bVar4, arrayList, str, eVar);
        mVarA.getClass();
        com.smartdigimkt.h3.b bVar5 = aVarA.z;
        com.smartdigimkt.x.j jVarA = com.smartdigimkt.x.j.a();
        com.smartdigimkt.s3.l lVar = new com.smartdigimkt.s3.l(mVarA, eVar2, bVar5, map, aVarA);
        jVarA.getClass();
        com.smartdigimkt.q3.f.a().getClass();
        if (com.smartdigimkt.q3.f.c()) {
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.x.e(jVarA, lVar));
        } else {
            jVarA.a(lVar);
        }
        return false;
    }

    public static void a(String str, com.smartdigimkt.v4.a aVar) {
        ThreadPoolExecutor threadPoolExecutor;
        com.smartdigimkt.z3.a aVar2;
        com.smartdigimkt.p4.g gVar = aVar.o;
        if (gVar != null && (aVar2 = aVar.t) != null) {
            gVar.p = aVar2.getErrorInfo();
        }
        String str2 = aVar.e;
        String strA = com.smartdigimkt.r4.j.a(String.valueOf(aVar.c));
        com.smartdigimkt.p4.g gVar2 = aVar.o;
        ThreadPoolExecutor threadPoolExecutor2 = com.smartdigimkt.r4.w.a;
        if (!SDMSDK.getInstance().isNetworkLogDebug() || (threadPoolExecutor = com.smartdigimkt.r4.w.a) == null) {
            return;
        }
        threadPoolExecutor.execute(new com.smartdigimkt.r4.s(str, str2, strA, gVar2));
    }

    public final void a(com.smartdigimkt.v4.a aVar, com.smartdigimkt.p4.g gVar, int i) {
        com.smartdigimkt.z3.a aVar2;
        if (gVar == null) {
            return;
        }
        gVar.a(new com.smartdigimkt.d3.c(false, 0.0d, "", "", "", "", (aVar == null || (aVar2 = aVar.t) == null) ? "" : aVar2.getErrorInfo()), i, 0);
        if (aVar == null) {
            return;
        }
        com.smartdigimkt.q3.f.a().c(new f(this, aVar, gVar));
    }
}
