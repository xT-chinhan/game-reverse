package com.smartdigimkt.k;

import android.text.TextUtils;
import android.util.Pair;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends b {
    public static final /* synthetic */ int g = 0;
    public final z c;
    public a d;
    public long e;
    public final o f;

    public d0(o oVar, r rVar) {
        ConcurrentHashMap concurrentHashMap;
        super(rVar);
        this.f = oVar;
        if (oVar != null) {
            String str = this.b;
            Pair pair = (TextUtils.isEmpty(str) || (concurrentHashMap = oVar.d) == null) ? null : (Pair) concurrentHashMap.get(str);
            if (pair != null) {
                rVar.h = ((Integer) pair.first).intValue();
                rVar.z = ((Boolean) pair.second).booleanValue();
            }
        }
        z zVar = new z();
        zVar.a = rVar.b;
        zVar.b = rVar.p ? com.smartdigimkt.r4.h.n() : "";
        zVar.f = rVar.h;
        zVar.d = rVar.b();
        zVar.e = rVar.x;
        zVar.h = 20971520;
        zVar.c = rVar.a();
        zVar.j = new c0(this);
        if (com.smartdigimkt.l.c.a == null) {
            com.smartdigimkt.l.c.a = new ThreadPoolExecutor(0, 6, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new com.smartdigimkt.l.a(), new com.smartdigimkt.l.b());
        }
        zVar.k = com.smartdigimkt.l.c.a;
        zVar.g = 60000L;
        this.c = zVar;
    }

    public final void a(com.smartdigimkt.o.a aVar) {
        this.d = aVar;
        z zVar = this.c;
        if (TextUtils.isEmpty(zVar.a) || TextUtils.isEmpty(zVar.c) || zVar.k == null) {
            zVar.a(3, "url, filePath or executorService can not be empty. url: " + zVar.a + " filePath: " + zVar.c + " executorService: " + zVar.k);
            return;
        }
        int i = zVar.i;
        if (i == 2 || i == 3) {
            return;
        }
        zVar.i = 2;
        c0 c0Var = zVar.j;
        if (c0Var != null) {
            c0Var.a(2);
        }
        zVar.l = new y(zVar);
        zVar.k.execute(new s(zVar));
    }
}
