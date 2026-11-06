package com.smartdigimkt.j;

import android.content.Context;
import android.util.TypedValue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ com.smartdigimkt.a3.a b;
    public final /* synthetic */ com.smartdigimkt.b3.c c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Runnable f;
    public final /* synthetic */ com.smartdigimkt.g3.b g;
    public final /* synthetic */ u h;

    public n(u uVar, Context context, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str, String str2, Runnable runnable, com.smartdigimkt.g3.b bVar) {
        this.h = uVar;
        this.a = context;
        this.b = aVar;
        this.c = cVar;
        this.d = str;
        this.e = str2;
        this.f = runnable;
        this.g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar = this.h;
        Context context = this.a;
        com.smartdigimkt.a3.a aVar = this.b;
        com.smartdigimkt.b3.c cVar = this.c;
        String str = this.d;
        String str2 = this.e;
        Runnable runnable = this.f;
        com.smartdigimkt.g3.b bVar = this.g;
        uVar.getClass();
        if (runnable != null) {
            runnable.run();
        }
        com.smartdigimkt.k.r rVar = new com.smartdigimkt.k.r();
        rVar.o = com.smartdigimkt.r4.j.a(cVar);
        rVar.a = aVar.g;
        rVar.f = cVar.a;
        rVar.b = str;
        rVar.n = str2;
        rVar.e = cVar.m;
        rVar.c = cVar.c;
        rVar.j = cVar;
        rVar.k = aVar;
        com.smartdigimkt.b3.e eVar = aVar.s;
        if (eVar != null) {
            rVar.p = eVar.F == 1;
            rVar.r = eVar.H;
            rVar.q = eVar.G;
        }
        int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
        rVar.d = com.smartdigimkt.i3.m.a(context).b(new com.smartdigimkt.i3.o(1, cVar.e), iApplyDimension, iApplyDimension);
        String str3 = cVar.k;
        if (str3 != null) {
            String str4 = aVar.g;
            if (str4 == null) {
                str4 = "";
            }
            rVar.l = str3.replaceAll("\\{req_id\\}", str4);
        }
        rVar.m = bVar;
        rVar.w = com.smartdigimkt.n.c.a(rVar.o);
        rVar.t = aVar.b;
        rVar.u = aVar.f;
        rVar.v = String.valueOf(aVar.k);
        ConcurrentHashMap concurrentHashMap = uVar.h;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(rVar.o);
        }
        ConcurrentHashMap concurrentHashMap2 = uVar.i;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.remove(rVar.o);
        }
        String str5 = rVar.o;
        if (!uVar.a(str5)) {
            uVar.c(rVar);
            return;
        }
        com.smartdigimkt.k.o oVar = uVar.o;
        o oVar2 = new o(uVar, rVar);
        oVar.getClass();
        oVar.c.b(new com.smartdigimkt.k.l(oVar, str5, oVar2));
    }
}
