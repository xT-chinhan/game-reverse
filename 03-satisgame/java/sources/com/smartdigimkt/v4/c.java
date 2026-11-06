package com.smartdigimkt.v4;

import android.text.TextUtils;
import com.smartdigimkt.m3.g;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.n3.l;
import com.smartdigimkt.n3.t;
import com.smartdigimkt.o4.o;
import com.smartdigimkt.p4.e;
import com.smartdigimkt.t4.p;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public c a;
    public b b;

    public final void a(a aVar) {
        synchronized (this) {
            if (this.b != null) {
                g.a().a(this.b);
                this.b = null;
            }
        }
        c cVar = this.a;
        if (cVar != null) {
            cVar.c(aVar);
        }
    }

    public abstract boolean b(a aVar);

    public final void c(a aVar) {
        try {
            if (aVar.t != null) {
                d(aVar);
                return;
            }
            boolean zB = b(aVar);
            if (aVar.t != null) {
                d(aVar);
                return;
            }
            if (zB) {
                a(aVar);
                return;
            }
            synchronized (this) {
                if (this.b != null) {
                    g.a().a(this.b);
                }
                this.b = new b(this, aVar, this.a);
                g.a().a.a(this.b, 300000L);
            }
        } catch (Throwable th) {
            aVar.a(com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.i, "load ad with an error." + th));
            d(aVar);
        }
    }

    public final void d(a aVar) {
        if (aVar.f.compareAndSet(false, true)) {
            synchronized (this) {
                if (this.b != null) {
                    g.a().a(this.b);
                    this.b = null;
                }
                g.a().a(aVar.l);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.smartdigimkt.w4.a aVar2 = aVar.i;
            if (aVar2 != null) {
                aVar2.h = jCurrentTimeMillis;
            }
            ConcurrentHashMap concurrentHashMap = t.a;
            l lVarA = l.a(aVar);
            if (lVarA != null && !TextUtils.isEmpty(lVarA.a)) {
                ConcurrentHashMap concurrentHashMap2 = t.a;
                l lVar = (l) concurrentHashMap2.get(lVarA.a);
                if (lVar != null && lVar.n) {
                    lVarA.n = true;
                    lVarA.o = lVar.o;
                }
                concurrentHashMap2.put(lVarA.a, lVarA);
                if (!TextUtils.isEmpty(lVarA.b)) {
                    t.b.put(lVarA.b, lVarA.a);
                }
            }
            com.smartdigimkt.n3.c.a(aVar, false);
            com.smartdigimkt.h3.b bVar = aVar.x;
            if (bVar != null) {
                bVar.c();
                bVar.d();
                aVar.a((com.smartdigimkt.h3.b) null);
            }
            p pVar = aVar.d;
            if (pVar != null) {
                pVar.onAdLoadFail(aVar.t);
            }
            com.smartdigimkt.f3.a aVar3 = aVar.v;
            com.smartdigimkt.z3.a aVar4 = aVar.t;
            try {
                com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c("", null);
                cVar.a = "3000001";
                if (aVar3 != null) {
                    cVar.a(aVar3);
                    e eVarB = o.a().b(aVar3.b);
                    cVar.i = eVarB != null ? eVarB.C : "";
                }
                if (aVar4 != null) {
                    cVar.l = aVar4.getErrorInfo();
                    cVar.m = aVar4.getCode();
                }
                k.a(cVar);
            } catch (Throwable unused) {
            }
        }
    }

    public final void e(a aVar) {
        if (aVar.f.compareAndSet(false, true)) {
            synchronized (this) {
                if (this.b != null) {
                    g.a().a(this.b);
                    this.b = null;
                }
                g.a().a(aVar.l);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.smartdigimkt.w4.a aVar2 = aVar.i;
            if (aVar2 != null) {
                aVar2.h = jCurrentTimeMillis;
            }
            ConcurrentHashMap concurrentHashMap = t.a;
            l lVarA = l.a(aVar);
            if (lVarA != null && !TextUtils.isEmpty(lVarA.a)) {
                ConcurrentHashMap concurrentHashMap2 = t.a;
                l lVar = (l) concurrentHashMap2.get(lVarA.a);
                if (lVar != null && lVar.n) {
                    lVarA.n = true;
                    lVarA.o = lVar.o;
                }
                concurrentHashMap2.put(lVarA.a, lVarA);
                if (!TextUtils.isEmpty(lVarA.b)) {
                    t.b.put(lVarA.b, lVarA.a);
                }
            }
            com.smartdigimkt.n3.c.a(aVar, true);
            com.smartdigimkt.h3.b bVar = aVar.x;
            if (bVar != null) {
                bVar.c();
                bVar.d();
                aVar.a((com.smartdigimkt.h3.b) null);
            }
            d dVar = aVar.u;
            p pVar = aVar.d;
            if (pVar != null) {
                pVar.onAdLoaded(dVar.a);
            }
        }
    }
}
