package com.smartdigimkt.v2;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static p y;
    public long b;
    public j g;
    public boolean j;
    public HashSet k;
    public boolean l;
    public boolean m;
    public boolean o;
    public ScheduledFuture p;
    public long q;
    public int v;
    public final String a = com.anythink.core.common.l.f.W;
    public final Set h = Collections.synchronizedSet(new HashSet());
    public final CopyOnWriteArrayList n = new CopyOnWriteArrayList();
    public long r = 3600000;
    public final CopyOnWriteArrayList s = new CopyOnWriteArrayList();
    public Long t = null;
    public final CopyOnWriteArrayList u = new CopyOnWriteArrayList();
    public final ArrayList w = new ArrayList();
    public final ArrayList x = new ArrayList();
    public final Object f = new Object();
    public final ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();
    public final ConcurrentHashMap d = new ConcurrentHashMap();
    public final ConcurrentHashMap e = new ConcurrentHashMap();
    public boolean i = false;

    public p() {
        this.b = 0L;
        this.b = Math.max(0L, com.smartdigimkt.q2.g.g);
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        if (aVarA != null && !aVarA.g) {
            this.b = aVarA.I;
        }
        com.smartdigimkt.q3.f.a().a(new g(this), 0L, 17);
    }

    public static void a(p pVar, String str) {
        pVar.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (pVar.f) {
            HashSet hashSet = pVar.k;
            if (hashSet != null && !hashSet.isEmpty()) {
                if (pVar.k.remove(str)) {
                    if (pVar.k.isEmpty()) {
                        HashSet hashSet2 = pVar.k;
                        if (hashSet2 != null) {
                            hashSet2.clear();
                        }
                        if (!pVar.w.isEmpty()) {
                            ArrayList arrayList = new ArrayList(pVar.w);
                            pVar.w.clear();
                            com.smartdigimkt.q3.f.a().a(new k(arrayList), 0L, 17);
                        }
                        pVar.l = true;
                        if (!pVar.x.isEmpty()) {
                            ArrayList arrayList2 = new ArrayList(pVar.x);
                            pVar.x.clear();
                            pVar.c.addAll(arrayList2);
                            pVar.a();
                        }
                        pVar.f();
                    }
                }
            }
        }
    }

    public static void b(p pVar) {
        synchronized (pVar.f) {
            if (pVar.g != null) {
                pVar.g = null;
            }
        }
    }

    public static p c() {
        if (y == null) {
            synchronized (p.class) {
                if (y == null) {
                    y = new p();
                }
            }
        }
        return y;
    }

    public final boolean e() {
        if (SDKContext.getInstance().a(com.anythink.core.common.l.f.bG) || !(!TextUtils.isEmpty("f4KCKTZGm6zHJpxq26rq24wXmEzGmEoGJWK6KTZGm6zHJ8VV285726wpJ8btYWwHmECPKGtGI4K1K8vs23wD5EwHlEwpJpMV28xa26xa24KPKTItKTZGm6zHJpvq28HamE7A2EkV5ykq2GKPKThXvGK1K8vs23wGmER753wUlEb4m6qG2QSGJWKULWK1K8vs23wi5EbVY6qs53wAlEra2ehGJWKCI3K1K8vs23wRl4wq28x426R7J7bP9uMqfF5t9ezAl3KPKThDKTZGm6zHJpvH9ECRJ85Vl8aq96k4KGtGvWK1K8aRJ8kPl3KPKTI4KTZGm6zHJpbamuriJ8r42Q5UluKGJWKaIWK1K8vs23ww2Qki53wt9ezAl3KPKThQKTZGm6zHJ8bT9eRR58oA58RtY6qsYWKPKTKaKTZGm6zHJpvV28hA56kVm8oGJWKUv3K1K8vs23wq5uxs28b693wH9EwV2EbtKGtGvBOGLGrT26XAfeRAl6RAJpqZY4KPKTI6KTZGm6zHJpxq26rq24wVleCRl8RU9WKPKTIwKTZGm6zHJ8HHfyIAY8kqlek4KGtGvUFGLGrT26XA5ekAm6kA5WwH23KPKTIXKTZGm6zHJ8rq9ExaJ7rq9ExaBEbtKGtGITmDKTZGm6zHJpxqYyxqYWrz")) || this.l) {
            return true;
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        return (aVarA == null || aVarA.g || !this.m) ? false : true;
    }

    public final void f() {
        com.smartdigimkt.p4.a aVarA;
        synchronized (this.f) {
            if (!this.x.isEmpty() && (this.l || SDKContext.getInstance().a(com.anythink.core.common.l.f.bG) || !(!TextUtils.isEmpty("f4KCKTZGm6zHJpxq26rq24wXmEzGmEoGJWK6KTZGm6zHJ8VV285726wpJ8btYWwHmECPKGtGI4K1K8vs23wD5EwHlEwpJpMV28xa26xa24KPKTItKTZGm6zHJpvq28HamE7A2EkV5ykq2GKPKThXvGK1K8vs23wGmER753wUlEb4m6qG2QSGJWKULWK1K8vs23wi5EbVY6qs53wAlEra2ehGJWKCI3K1K8vs23wRl4wq28x426R7J7bP9uMqfF5t9ezAl3KPKThDKTZGm6zHJpvH9ECRJ85Vl8aq96k4KGtGvWK1K8aRJ8kPl3KPKTI4KTZGm6zHJpbamuriJ8r42Q5UluKGJWKaIWK1K8vs23ww2Qki53wt9ezAl3KPKThQKTZGm6zHJ8bT9eRR58oA58RtY6qsYWKPKTKaKTZGm6zHJpvV28hA56kVm8oGJWKUv3K1K8vs23wq5uxs28b693wH9EwV2EbtKGtGvBOGLGrT26XAfeRAl6RAJpqZY4KPKTI6KTZGm6zHJpxq26rq24wVleCRl8RU9WKPKTIwKTZGm6zHJ8HHfyIAY8kqlek4KGtGvUFGLGrT26XA5ekAm6kA5WwH23KPKTIXKTZGm6zHJ8rq9ExaJ7rq9ExaBEbtKGtGITmDKTZGm6zHJpxqYyxqYWrz")) || ((aVarA = com.smartdigimkt.o4.e.c().a()) != null && !aVarA.g && this.m))) {
                if (!this.x.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.x);
                    this.x.clear();
                    this.c.addAll(arrayList);
                    a();
                }
            }
        }
        if (e()) {
            synchronized (this.f) {
                h();
                b();
            }
        }
    }

    public final d g() {
        if (this.c.isEmpty()) {
            return null;
        }
        if (!this.j || this.l) {
            return (d) this.c.poll();
        }
        for (d dVar : this.c) {
            if (dVar != null && dVar.b() != 1) {
                this.c.remove(dVar);
                return dVar;
            }
        }
        return (d) this.c.poll();
    }

    public final String h() {
        if (SDKContext.getInstance().a(com.anythink.core.common.l.f.bG) || !(!TextUtils.isEmpty("f4KCKTZGm6zHJpxq26rq24wXmEzGmEoGJWK6KTZGm6zHJ8VV285726wpJ8btYWwHmECPKGtGI4K1K8vs23wD5EwHlEwpJpMV28xa26xa24KPKTItKTZGm6zHJpvq28HamE7A2EkV5ykq2GKPKThXvGK1K8vs23wGmER753wUlEb4m6qG2QSGJWKULWK1K8vs23wi5EbVY6qs53wAlEra2ehGJWKCI3K1K8vs23wRl4wq28x426R7J7bP9uMqfF5t9ezAl3KPKThDKTZGm6zHJpvH9ECRJ85Vl8aq96k4KGtGvWK1K8aRJ8kPl3KPKTI4KTZGm6zHJpbamuriJ8r42Q5UluKGJWKaIWK1K8vs23ww2Qki53wt9ezAl3KPKThQKTZGm6zHJ8bT9eRR58oA58RtY6qsYWKPKTKaKTZGm6zHJpvV28hA56kVm8oGJWKUv3K1K8vs23wq5uxs28b693wH9EwV2EbtKGtGvBOGLGrT26XAfeRAl6RAJpqZY4KPKTI6KTZGm6zHJpxq26rq24wVleCRl8RU9WKPKTIwKTZGm6zHJ8HHfyIAY8kqlek4KGtGvUFGLGrT26XA5ekAm6kA5WwH23KPKTIXKTZGm6zHJ8rq9ExaJ7rq9ExaBEbtKGtGITmDKTZGm6zHJpxqYyxqYWrz"))) {
            return "not_required";
        }
        if (this.l) {
            return this.v > 0 ? "completed" : "cache";
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        return (aVarA == null || aVarA.g || !this.m) ? "completed" : "cache";
    }

    public final void i() {
        synchronized (this.f) {
            if (this.j) {
                return;
            }
            if (SDKContext.getInstance().a(com.anythink.core.common.l.f.bG)) {
                return;
            }
            if (TextUtils.isEmpty("f4KCKTZGm6zHJpxq26rq24wXmEzGmEoGJWK6KTZGm6zHJ8VV285726wpJ8btYWwHmECPKGtGI4K1K8vs23wD5EwHlEwpJpMV28xa26xa24KPKTItKTZGm6zHJpvq28HamE7A2EkV5ykq2GKPKThXvGK1K8vs23wGmER753wUlEb4m6qG2QSGJWKULWK1K8vs23wi5EbVY6qs53wAlEra2ehGJWKCI3K1K8vs23wRl4wq28x426R7J7bP9uMqfF5t9ezAl3KPKThDKTZGm6zHJpvH9ECRJ85Vl8aq96k4KGtGvWK1K8aRJ8kPl3KPKTI4KTZGm6zHJpbamuriJ8r42Q5UluKGJWKaIWK1K8vs23ww2Qki53wt9ezAl3KPKThQKTZGm6zHJ8bT9eRR58oA58RtY6qsYWKPKTKaKTZGm6zHJpvV28hA56kVm8oGJWKUv3K1K8vs23wq5uxs28b693wH9EwV2EbtKGtGvBOGLGrT26XAfeRAl6RAJpqZY4KPKTI6KTZGm6zHJpxq26rq24wVleCRl8RU9WKPKTIwKTZGm6zHJ8HHfyIAY8kqlek4KGtGvUFGLGrT26XA5ekAm6kA5WwH23KPKTIXKTZGm6zHJ8rq9ExaJ7rq9ExaBEbtKGtGITmDKTZGm6zHJpxqYyxqYWrz")) {
                return;
            }
            com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
            if (aVarA != null && aVarA.g) {
                this.j = true;
                a("f4KCKTZGm6zHJpxq26rq24wXmEzGmEoGJWK6KTZGm6zHJ8VV285726wpJ8btYWwHmECPKGtGI4K1K8vs23wD5EwHlEwpJpMV28xa26xa24KPKTItKTZGm6zHJpvq28HamE7A2EkV5ykq2GKPKThXvGK1K8vs23wGmER753wUlEb4m6qG2QSGJWKULWK1K8vs23wi5EbVY6qs53wAlEra2ehGJWKCI3K1K8vs23wRl4wq28x426R7J7bP9uMqfF5t9ezAl3KPKThDKTZGm6zHJpvH9ECRJ85Vl8aq96k4KGtGvWK1K8aRJ8kPl3KPKTI4KTZGm6zHJpbamuriJ8r42Q5UluKGJWKaIWK1K8vs23ww2Qki53wt9ezAl3KPKThQKTZGm6zHJ8bT9eRR58oA58RtY6qsYWKPKTKaKTZGm6zHJpvV28hA56kVm8oGJWKUv3K1K8vs23wq5uxs28b693wH9EwV2EbtKGtGvBOGLGrT26XAfeRAl6RAJpqZY4KPKTI6KTZGm6zHJpxq26rq24wVleCRl8RU9WKPKTIwKTZGm6zHJ8HHfyIAY8kqlek4KGtGvUFGLGrT26XA5ekAm6kA5WwH23KPKTIXKTZGm6zHJ8rq9ExaJ7rq9ExaBEbtKGtGITmDKTZGm6zHJpxqYyxqYWrz", 1, com.smartdigimkt.q2.g.g, 1, true);
            }
        }
    }

    public final JSONArray[] d() {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = this.e.keySet().iterator();
            while (it.hasNext()) {
                b bVar = (b) this.e.get((String) it.next());
                if (bVar != null && bVar.c) {
                    jSONArray.put(Long.parseLong(bVar.f));
                    jSONArray2.put(Math.floor(((System.currentTimeMillis() - bVar.b) / 1000.0d) / 3600.0d));
                }
            }
            jSONArrayArr[0] = jSONArray;
            jSONArrayArr[1] = jSONArray2;
        } catch (Throwable unused) {
        }
        return jSONArrayArr;
    }

    public final void b() {
        synchronized (this.f) {
            if (this.n.isEmpty()) {
                if (this.o || this.p != null) {
                    this.o = false;
                    this.q++;
                    ScheduledFuture scheduledFuture = this.p;
                    this.p = null;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                }
                return;
            }
            ArrayList arrayList = new ArrayList(this.n);
            this.n.clear();
            if (this.o || this.p != null) {
                this.o = false;
                this.q++;
                ScheduledFuture scheduledFuture2 = this.p;
                this.p = null;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                o oVar = (o) arrayList.get(i);
                if (oVar != null) {
                    com.smartdigimkt.q3.f.a().c(oVar.a);
                }
            }
        }
    }

    public static void c(p pVar) {
        synchronized (pVar.f) {
        }
        Iterator it = pVar.u.iterator();
        while (it.hasNext()) {
            try {
                ((com.smartdigimkt.s3.h) it.next()).getClass();
                if (com.smartdigimkt.s3.j.g.compareAndSet(false, true)) {
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s3.f());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(p pVar) {
        if (pVar.o) {
            return;
        }
        pVar.o = true;
        n nVar = new n(pVar);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorB = com.smartdigimkt.q3.f.a().b();
        if (scheduledThreadPoolExecutorB != null) {
            pVar.p = scheduledThreadPoolExecutorB.schedule(nVar, 300L, TimeUnit.MILLISECONDS);
            return;
        }
        long j = pVar.q + 1;
        pVar.q = j;
        com.smartdigimkt.q3.f.a().a(new f(pVar, j, nVar), 300L, 17);
    }

    public final void a(String str, int i, long j, int i2, boolean z) {
        this.b = j;
        this.i = (i2 == 1 || SDKContext.getInstance().a(com.anythink.core.common.l.f.bH)) ? false : true;
        if (SDKContext.getInstance().a(com.anythink.core.common.l.f.bG) || TextUtils.isEmpty(str)) {
            return;
        }
        com.smartdigimkt.q3.f.a().a(new i(this, j, str, z, i, i2), 0L, 2);
    }

    public static void a(p pVar, ArrayList arrayList, boolean z) {
        com.smartdigimkt.p4.a aVarA;
        synchronized (pVar.f) {
            if (arrayList.isEmpty()) {
                return;
            }
            if (!z && !SDKContext.getInstance().a(com.anythink.core.common.l.f.bG) && (!TextUtils.isEmpty("f4KCKTZGm6zHJpxq26rq24wXmEzGmEoGJWK6KTZGm6zHJ8VV285726wpJ8btYWwHmECPKGtGI4K1K8vs23wD5EwHlEwpJpMV28xa26xa24KPKTItKTZGm6zHJpvq28HamE7A2EkV5ykq2GKPKThXvGK1K8vs23wGmER753wUlEb4m6qG2QSGJWKULWK1K8vs23wi5EbVY6qs53wAlEra2ehGJWKCI3K1K8vs23wRl4wq28x426R7J7bP9uMqfF5t9ezAl3KPKThDKTZGm6zHJpvH9ECRJ85Vl8aq96k4KGtGvWK1K8aRJ8kPl3KPKTI4KTZGm6zHJpbamuriJ8r42Q5UluKGJWKaIWK1K8vs23ww2Qki53wt9ezAl3KPKThQKTZGm6zHJ8bT9eRR58oA58RtY6qsYWKPKTKaKTZGm6zHJpvV28hA56kVm8oGJWKUv3K1K8vs23wq5uxs28b693wH9EwV2EbtKGtGvBOGLGrT26XAfeRAl6RAJpqZY4KPKTI6KTZGm6zHJpxq26rq24wVleCRl8RU9WKPKTIwKTZGm6zHJ8HHfyIAY8kqlek4KGtGvUFGLGrT26XA5ekAm6kA5WwH23KPKTIXKTZGm6zHJ8rq9ExaJ7rq9ExaBEbtKGtGITmDKTZGm6zHJpxqYyxqYWrz")) && !pVar.l && ((aVarA = com.smartdigimkt.o4.e.c().a()) == null || aVarA.g || !pVar.m)) {
                int i = 0;
                while (true) {
                    if (i < arrayList.size()) {
                        d dVar = (d) arrayList.get(i);
                        if (dVar == null || dVar.b() != 1) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        pVar.x.addAll(arrayList);
                        return;
                    }
                }
            }
            if (z) {
                arrayList.size();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    pVar.s.add(((d) arrayList.get(i2)).a);
                }
            }
            pVar.c.addAll(arrayList);
            pVar.a();
        }
    }

    public final void a() {
        synchronized (this.f) {
            if (this.b >= 0 && this.c.size() > 0 && this.g == null) {
                d dVarG = g();
                if (dVarG != null) {
                    j jVar = new j(this, dVarG);
                    this.g = jVar;
                    com.smartdigimkt.q3.f.a().a(jVar, 0L, 17);
                } else {
                    a();
                }
            }
        }
    }

    public static boolean a(d dVar) {
        return (dVar instanceof c) && ((c) dVar).f;
    }

    public static void a(p pVar, d dVar, b bVar) {
        pVar.getClass();
        if (a(dVar)) {
            c cVar = (c) dVar;
            synchronized (pVar.f) {
                int i = 1;
                if (cVar.g) {
                    pVar.v++;
                    Math.max(0L, -1L);
                }
                if (bVar != null && bVar.e) {
                    com.smartdigimkt.a3.b bVar2 = new com.smartdigimkt.a3.b();
                    bVar2.a = bVar.f;
                    bVar2.b = com.smartdigimkt.r4.e.b(bVar.a);
                    if (!bVar.c) {
                        i = 2;
                    }
                    bVar2.c = i;
                    bVar2.d = bVar.b;
                    pVar.w.add(bVar2);
                }
            }
        }
    }

    public final void a(Runnable runnable, com.smartdigimkt.h3.b bVar, String str) {
        synchronized (this.f) {
            if (e()) {
                h();
                com.smartdigimkt.q3.f.a().c(runnable);
            } else {
                i();
                com.smartdigimkt.q3.f.a().a(new m(this, runnable, bVar, str), 0L, 17);
            }
        }
    }

    public static void a(p pVar) {
        synchronized (pVar.f) {
            HashSet hashSet = pVar.k;
            if (hashSet != null) {
                hashSet.clear();
            }
            if (!pVar.w.isEmpty()) {
                ArrayList arrayList = new ArrayList(pVar.w);
                pVar.w.clear();
                com.smartdigimkt.q3.f.a().a(new k(arrayList), 0L, 17);
            }
            pVar.l = true;
            if (!pVar.x.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(pVar.x);
                pVar.x.clear();
                pVar.c.addAll(arrayList2);
                pVar.a();
            }
            pVar.f();
        }
    }
}
