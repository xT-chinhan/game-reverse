package com.smartdigimkt.j;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements com.smartdigimkt.k.a {
    public final /* synthetic */ u a;

    public q(u uVar) {
        this.a = uVar;
    }

    @Override // com.smartdigimkt.k.a
    public final void a(com.smartdigimkt.k.r rVar, long j) {
        if (rVar == null) {
            return;
        }
        com.smartdigimkt.m.j jVarA = com.smartdigimkt.m.j.a(this.a.a);
        jVarA.getClass();
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.d(jVarA, rVar));
        u uVar = this.a;
        uVar.getClass();
        int i = SDKContext.getInstance().l ? 1 : 2;
        com.smartdigimkt.k.p pVar = uVar.q;
        if (pVar != null) {
            pVar.a(rVar, i);
        }
        this.a.e(rVar);
        com.smartdigimkt.k.o oVar = this.a.o;
        if (oVar != null) {
            oVar.a(rVar, "at_offer_action_2");
        }
        this.a.e.remove(rVar.o);
        this.a.c.remove(rVar.o);
        u uVar2 = this.a;
        if (uVar2.f == null) {
            uVar2.f = new ConcurrentHashMap();
        }
        this.a.f.put(rVar.o, rVar);
        this.a.b();
        this.a.f(rVar);
        com.smartdigimkt.n3.k.a(rVar.a, rVar.f, rVar.b, 2, (String) null, j, rVar.h, rVar.j, 0, 0L);
        String str = rVar.a;
        String str2 = rVar.t;
        long j2 = rVar.B;
        String str3 = rVar.v;
        String str4 = rVar.u;
        com.smartdigimkt.b3.c cVar = rVar.j;
        String str5 = cVar instanceof com.smartdigimkt.b3.l ? ((com.smartdigimkt.b3.l) cVar).c0 : "";
        String str6 = rVar.f;
        String strA = rVar.a();
        String str7 = rVar.e;
        int i2 = rVar.x;
        if (TextUtils.isEmpty(rVar.E)) {
            rVar.E = "1";
        }
        String str8 = rVar.E;
        String strValueOf = String.valueOf(rVar.D);
        int i3 = rVar.C;
        long j3 = rVar.h;
        long j4 = rVar.i;
        com.smartdigimkt.b3.c cVar2 = rVar.j;
        String str9 = cVar2 != null ? cVar2.L : null;
        String str10 = cVar2 != null ? cVar2.M : null;
        com.smartdigimkt.f3.c cVar3 = new com.smartdigimkt.f3.c(null, str3);
        cVar3.a = "1004711";
        cVar3.b = str;
        cVar3.Q = str9;
        cVar3.R = str10;
        cVar3.c = str2;
        cVar3.h = String.valueOf(j2);
        cVar3.l = str3;
        cVar3.m = str4;
        cVar3.n = str5;
        cVar3.o = str6;
        if (!TextUtils.isEmpty(strA)) {
            cVar3.p = String.valueOf(strA.contains("data/data") ? 1 : 2);
        }
        cVar3.q = str7;
        cVar3.r = String.valueOf(i2);
        cVar3.s = str8;
        if (!"1".equals(str8)) {
            cVar3.t = strValueOf;
        }
        cVar3.u = String.valueOf(i3);
        cVar3.v = String.valueOf(j3 / 1024.0f);
        cVar3.w = String.valueOf(j4);
        com.smartdigimkt.n3.k.a(cVar3);
    }

    @Override // com.smartdigimkt.k.a
    public final void b(com.smartdigimkt.k.r rVar, long j, long j2) {
        String str = rVar.o;
        this.a.b.size();
        ConcurrentHashMap concurrentHashMap = this.a.c;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(rVar.o, rVar);
        }
        if (j < j2) {
            u uVar = this.a;
            String str2 = "正在下载： " + rVar.c;
            uVar.getClass();
            com.smartdigimkt.q3.f.a().a(new t(uVar, str2));
            com.smartdigimkt.m.j jVarA = com.smartdigimkt.m.j.a(this.a.a);
            jVarA.getClass();
            com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.c(j, j2, rVar, jVarA, true));
        }
        this.a.e(rVar);
        com.smartdigimkt.k.o oVar = this.a.o;
        if (oVar != null) {
            oVar.a(rVar, "at_offer_action_1");
        }
        this.a.f(rVar);
        com.smartdigimkt.n3.k.a(rVar.a, rVar.f, rVar.b, 1, (String) null, 0L, j2, rVar.j, 0, 0L);
    }

    @Override // com.smartdigimkt.k.a
    public final void a(com.smartdigimkt.k.r rVar, long j, long j2) {
        if (rVar == null) {
            return;
        }
        com.smartdigimkt.m.j jVarA = com.smartdigimkt.m.j.a(this.a.a);
        jVarA.getClass();
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.c(j, j2, rVar, jVarA, false));
        com.smartdigimkt.k.o oVar = this.a.o;
        if (oVar != null) {
            oVar.c.b(new com.smartdigimkt.k.j(oVar, rVar));
        }
        ConcurrentHashMap concurrentHashMap = this.a.c;
        if (concurrentHashMap != null) {
            if (rVar.C != 2) {
                rVar.C = concurrentHashMap.size() < 2 ? 1 : 2;
            }
        }
    }

    @Override // com.smartdigimkt.k.a
    public final void a(com.smartdigimkt.k.r rVar, String str) {
        if (rVar == null) {
            return;
        }
        rVar.a(4);
        u uVar = this.a;
        String str2 = "下载失败： " + rVar.c;
        uVar.getClass();
        com.smartdigimkt.q3.f.a().a(new t(uVar, str2));
        com.smartdigimkt.m.j jVarA = com.smartdigimkt.m.j.a(this.a.a);
        jVarA.getClass();
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.c(0L, 100L, rVar, jVarA, true));
        this.a.e(rVar);
        this.a.e.remove(rVar.o);
        this.a.c.remove(rVar.o);
        u uVar2 = this.a;
        if (uVar2.i == null) {
            uVar2.i = new ConcurrentHashMap();
        }
        this.a.i.put(rVar.o, rVar);
        this.a.b();
        this.a.f(rVar);
        com.smartdigimkt.n3.k.a(rVar.a, rVar.f, rVar.b, 3, str, 0L, rVar.h, rVar.j, 0, 0L);
    }

    @Override // com.smartdigimkt.k.a
    public final void a(com.smartdigimkt.k.r rVar, long j, long j2, int i) {
        String str = rVar.o;
        rVar.a(2);
        this.a.e(rVar);
        this.a.c.remove(rVar.o);
        if (i == 2) {
            com.smartdigimkt.m.j jVarA = com.smartdigimkt.m.j.a(this.a.a);
            jVarA.getClass();
            com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.c(j, j2, rVar, jVarA, true));
            ConcurrentHashMap concurrentHashMap = this.a.d;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(rVar.o, rVar);
            }
            this.a.b();
        }
        this.a.f(rVar);
    }
}
