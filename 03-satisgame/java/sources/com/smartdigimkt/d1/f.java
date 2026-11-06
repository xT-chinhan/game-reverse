package com.smartdigimkt.d1;

import com.smartdigimkt.b3.u;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static d a(com.smartdigimkt.b3.e eVar) {
        List list;
        if (eVar == null) {
            return null;
        }
        if (!eVar.P1) {
            g gVar = new g(eVar);
            b iVar = (gVar.a != 1 || (list = gVar.c) == null || list.isEmpty()) ? new i() : new c();
            iVar.a(gVar);
            return iVar;
        }
        u uVar = eVar.O1;
        if (uVar == null) {
            uVar = u.i;
        }
        if (!uVar.a()) {
            return null;
        }
        h hVar = new h();
        hVar.a = uVar;
        hVar.b();
        hVar.i = 0L;
        hVar.j = 0L;
        hVar.c = false;
        hVar.q = false;
        hVar.r = 0.0f;
        hVar.s = 0.0f;
        hVar.t = 0.0f;
        u uVar2 = hVar.a;
        int i = uVar2.a;
        double d = uVar2.f;
        return hVar;
    }
}
