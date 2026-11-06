package com.smartdigimkt.x4;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends com.smartdigimkt.v4.c {
    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        com.smartdigimkt.h3.b bVar = aVar.x;
        if (bVar != null) {
            bVar.d("strategy");
        }
        if (!aVar.a()) {
            com.smartdigimkt.o4.e.c().a(aVar.x);
        }
        if (aVar.a() || aVar.y) {
            if (bVar == null) {
                return true;
            }
            bVar.b("strategy");
            return true;
        }
        if (TextUtils.isEmpty(aVar.g)) {
            aVar.g = com.smartdigimkt.r4.j.a(aVar.a);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar2 = aVar.i;
        if (aVar2 != null) {
            aVar2.b = jCurrentTimeMillis;
        }
        String str = aVar.e;
        com.smartdigimkt.p4.e eVarB = com.smartdigimkt.o4.o.a().b(str);
        b0 b0Var = new b0(this, aVar, bVar, eVarB);
        synchronized (aVar) {
            if (aVar.B) {
                if (aVar.C.get()) {
                    com.smartdigimkt.p4.e eVar = aVar.D;
                    if (eVar != null) {
                        b0Var.b(eVar);
                    } else {
                        b0Var.a(aVar.E);
                    }
                } else {
                    aVar.F = b0Var;
                }
                return false;
            }
            com.smartdigimkt.y3.a aVar3 = new com.smartdigimkt.y3.a(str);
            aVar3.b = eVarB;
            aVar3.c = b0Var;
            aVar3.d = bVar;
            com.smartdigimkt.q3.f.a().c(new c0(new com.smartdigimkt.y3.b(aVar3)));
            return false;
        }
    }
}
