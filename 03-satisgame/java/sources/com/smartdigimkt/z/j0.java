package com.smartdigimkt.z;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements com.smartdigimkt.g3.b {
    public com.smartdigimkt.m3.d a;
    public final Context b = SDKContext.getInstance().d();

    public final void a(com.smartdigimkt.b3.c cVar, String str, String str2, boolean z, com.smartdigimkt.j.g gVar, long j) {
        if (z) {
            if (s.b(this.b, cVar)) {
                com.smartdigimkt.n3.k.a(str, cVar.a, str2, 12, (String) null, 0L, 0L, cVar, 0, j);
                return;
            } else {
                com.smartdigimkt.n3.k.a(str, cVar.a, str2, 13, (String) null, 0L, 0L, cVar, 0, 0L);
                return;
            }
        }
        com.smartdigimkt.b3.e eVar = cVar.w;
        if (eVar == null) {
            return;
        }
        int i = eVar.B;
        int i2 = eVar.C;
        if (i == 1) {
            h0 h0Var = new h0(this);
            this.a = new com.smartdigimkt.m3.d(i2, new i0(this, h0Var, cVar, str, str2, j, gVar));
            try {
                ((Application) this.b).registerActivityLifecycleCallbacks(h0Var);
                return;
            } catch (Exception unused) {
                com.smartdigimkt.n3.k.a("Error", "Error, cannot registerActivityLifecycleCallbacks here!", SDKContext.getInstance().f(), "");
                return;
            }
        }
        if (i != 3) {
            return;
        }
        d dVarA = d.a();
        com.smartdigimkt.h0.j jVar = new com.smartdigimkt.h0.j(cVar, str2, str, gVar, j);
        synchronized (dVarA) {
            if (TextUtils.isEmpty("1")) {
                return;
            }
            com.smartdigimkt.q3.f.a().c(new c(dVarA, jVar));
        }
    }
}
