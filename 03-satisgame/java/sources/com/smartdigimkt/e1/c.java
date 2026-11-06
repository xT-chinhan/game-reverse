package com.smartdigimkt.e1;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.h0.m;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.s;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.smartdigimkt.j1.f b;
    public final /* synthetic */ d c;

    public c(d dVar, String str, b bVar) {
        this.c = dVar;
        this.a = str;
        this.b = bVar;
    }

    public final void a(com.smartdigimkt.b3.b bVar) {
        int i;
        com.smartdigimkt.n3.b.a().a(this.a).c = System.currentTimeMillis();
        d dVar = this.c;
        dVar.getClass();
        if (bVar.j0 == 1) {
            com.smartdigimkt.t2.j jVarA = com.smartdigimkt.t2.j.a();
            jVarA.getClass();
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.h(jVarA));
            if (k.b(dVar.b, bVar.m)) {
                com.smartdigimkt.t2.j jVarA2 = com.smartdigimkt.t2.j.a();
                jVarA2.getClass();
                if (bVar.f0 == 1 && ((i = bVar.o) == 1 || i == 4)) {
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.i(jVarA2, bVar));
                }
            } else {
                com.smartdigimkt.t2.j jVarA3 = com.smartdigimkt.t2.j.a();
                jVarA3.getClass();
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.f(jVarA3, bVar));
            }
        }
        com.smartdigimkt.j1.f fVar = this.b;
        if (fVar != null) {
            fVar.a();
        }
        if (TextUtils.isEmpty(bVar.P)) {
            return;
        }
        String str = com.smartdigimkt.f0.e.g;
        com.smartdigimkt.f0.e eVar = com.smartdigimkt.f0.d.a;
        Context contextD = SDKContext.getInstance().d();
        String str2 = bVar.P;
        synchronized (eVar) {
            if (eVar.f) {
                return;
            }
            if (contextD == null) {
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Context applicationContext = contextD.getApplicationContext();
            String strC = y.c(applicationContext, "sdm_adx_rp_sdk", "tracker_mapping");
            if (TextUtils.isEmpty(strC) || !TextUtils.equals(strC, str2)) {
                eVar.f = true;
                try {
                    new com.smartdigimkt.f4.g(str2).a(1, (com.smartdigimkt.a4.b) new com.smartdigimkt.f0.b(eVar, str2, applicationContext));
                } catch (Throwable unused) {
                    eVar.f = false;
                }
            }
        }
    }

    public final void a(com.smartdigimkt.b3.b bVar, com.smartdigimkt.h0.g gVar) {
        int iA;
        String str;
        com.smartdigimkt.n3.b.a().a(this.a).b = System.currentTimeMillis();
        if (bVar == null || (((iA = c0.a(bVar, this.c.c)) < 0 || iA > 4) && iA != 7 && iA != 8)) {
            iA = -1;
        }
        int i = iA;
        if (TextUtils.equals(String.valueOf(this.c.c.c), "0")) {
            str = this.c.c.w ? "1" : "0";
        } else {
            str = "";
        }
        d.a(this.c, this.a, bVar, str, false, i);
        d dVar = this.c;
        com.smartdigimkt.j1.f fVar = this.b;
        if (bVar != null) {
            s.a(34, bVar, new m(dVar.c, ""));
        } else {
            dVar.getClass();
        }
        try {
            com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
            Context contextD = SDKContext.getInstance().d();
            String str2 = dVar.c.j;
            eVarA.getClass();
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.c(eVarA, contextD, str2));
        } catch (Throwable unused) {
        }
        if (fVar != null) {
            fVar.a(gVar);
        }
    }
}
