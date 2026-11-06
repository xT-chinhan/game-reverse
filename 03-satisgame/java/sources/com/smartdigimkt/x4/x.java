package com.smartdigimkt.x4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends com.smartdigimkt.v4.c {
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final AtomicBoolean d = new AtomicBoolean(false);

    public static void a(com.smartdigimkt.v4.a aVar, com.smartdigimkt.p4.g gVar, int i) {
        com.smartdigimkt.f3.a aVar2 = aVar.v;
        if (aVar2 == null) {
            return;
        }
        aVar2.P = 66;
        aVar2.Q = gVar.r;
        if (gVar.a == null) {
            com.smartdigimkt.z3.a aVar3 = aVar.t;
            gVar.a = new com.smartdigimkt.d3.c(false, 0.0d, "", "", "", "", aVar3 != null ? aVar3.getErrorInfo() : "");
        }
        com.smartdigimkt.d3.c cVar = gVar.a;
        gVar.a(cVar, i, cVar.a ? 1 : 0);
        com.smartdigimkt.q3.f.a().c(new f(new h(), aVar, gVar));
    }

    public static void f(com.smartdigimkt.v4.a aVar) {
        com.smartdigimkt.m3.b bVar = aVar.l;
        if (bVar != null) {
            com.smartdigimkt.m3.g.a().a(bVar);
        }
    }

    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        if (aVar.a()) {
            return true;
        }
        t tVar = new t(this, aVar);
        aVar.l = tVar;
        com.smartdigimkt.m3.g.a().a.a(tVar, 60000L);
        String str = aVar.e;
        if (TextUtils.isEmpty(aVar.g)) {
            aVar.g = com.smartdigimkt.r4.j.a(aVar.a);
        }
        String str2 = aVar.g;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar2 = aVar.i;
        if (aVar2 != null) {
            aVar2.b = jCurrentTimeMillis;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar3 = aVar.i;
        if (aVar3 != null) {
            aVar3.d = jCurrentTimeMillis2;
        }
        if (aVar.v == null) {
            aVar.v = com.smartdigimkt.r4.b0.a(aVar);
        }
        com.smartdigimkt.p4.e eVarB = com.smartdigimkt.o4.o.a().b(str);
        boolean z = aVar.A == 2;
        com.smartdigimkt.h3.b bVar = aVar.x;
        if (bVar != null) {
            bVar.d("bidToken");
        }
        com.smartdigimkt.a3.a aVar4 = new com.smartdigimkt.a3.a();
        aVar4.g = str2;
        aVar4.b = aVar.e;
        aVar4.c = aVar.c;
        aVar4.z = aVar.x;
        com.smartdigimkt.s3.m mVarA = com.smartdigimkt.s3.m.a();
        HashMap map = new HashMap();
        q qVar = new q(this, aVar, str2, str, eVarB, z);
        mVarA.getClass();
        com.smartdigimkt.h3.b bVar2 = aVar4.z;
        com.smartdigimkt.x.j jVarA = com.smartdigimkt.x.j.a();
        com.smartdigimkt.s3.l lVar = new com.smartdigimkt.s3.l(mVarA, qVar, bVar2, map, aVar4);
        jVarA.getClass();
        com.smartdigimkt.q3.f.a().getClass();
        if (com.smartdigimkt.q3.f.c()) {
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.x.e(jVarA, lVar));
        } else {
            jVarA.a(lVar);
        }
        return false;
    }

    public final void g(com.smartdigimkt.v4.a aVar) {
        com.smartdigimkt.d3.c cVar;
        if (aVar.f.get()) {
            return;
        }
        if (!aVar.z) {
            this.c.get();
        }
        if (this.c.get() && (cVar = aVar.r) != null) {
            com.smartdigimkt.t4.d0.a(cVar, SDMLossInfo.newInternalLossInfo(2), aVar.v);
        }
        aVar.a(com.smartdigimkt.z3.b.a("10005", ""));
        d(aVar);
    }

    public static void a(x xVar, com.smartdigimkt.v4.a aVar, com.smartdigimkt.z3.a aVar2, int i) {
        if (xVar.c.compareAndSet(false, true)) {
            com.smartdigimkt.h3.b bVar = aVar.x;
            if (bVar != null) {
                boolean zA = bVar.a("bidToken");
                boolean zA2 = bVar.a("bid");
                if (zA && !zA2) {
                    bVar.b("bid");
                }
            }
            com.smartdigimkt.m3.b bVar2 = aVar.l;
            if (bVar2 != null) {
                com.smartdigimkt.m3.g.a().a(bVar2);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.smartdigimkt.w4.a aVar3 = aVar.i;
            if (aVar3 != null) {
                aVar3.c = jCurrentTimeMillis;
            }
            aVar.a(System.currentTimeMillis());
            aVar.a(aVar2);
            aVar2.getErrorInfo();
            a(aVar, a(), i);
            xVar.d(aVar);
        }
    }

    public static com.smartdigimkt.p4.g a() {
        com.smartdigimkt.p4.g gVar = new com.smartdigimkt.p4.g(4);
        gVar.b = 66;
        gVar.n = 1;
        gVar.d = "";
        gVar.e = new HashMap();
        return gVar;
    }
}
