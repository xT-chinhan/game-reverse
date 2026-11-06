package com.smartdigimkt.z;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ com.smartdigimkt.x.a a;
    public final /* synthetic */ com.smartdigimkt.b3.c b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;
    public final /* synthetic */ com.smartdigimkt.j.g f;
    public final /* synthetic */ j0 g;

    public i0(j0 j0Var, h0 h0Var, com.smartdigimkt.b3.c cVar, String str, String str2, long j, com.smartdigimkt.j.g gVar) {
        this.g = j0Var;
        this.a = h0Var;
        this.b = cVar;
        this.c = str;
        this.d = str2;
        this.e = j;
        this.f = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Application) this.g.b).unregisterActivityLifecycleCallbacks(this.a);
        if (s.b(this.g.b, this.b)) {
            String str = this.c;
            com.smartdigimkt.b3.c cVar = this.b;
            com.smartdigimkt.n3.k.a(str, cVar.a, this.d, 6, (String) null, 0L, 0L, cVar, 0, this.e);
        } else {
            String str2 = this.c;
            com.smartdigimkt.b3.c cVar2 = this.b;
            com.smartdigimkt.n3.k.a(str2, cVar2.a, this.d, 13, (String) null, 0L, 0L, cVar2, 0, 0L);
        }
        com.smartdigimkt.j.g gVar = this.f;
        if (gVar != null) {
            gVar.getClass();
        }
    }
}
