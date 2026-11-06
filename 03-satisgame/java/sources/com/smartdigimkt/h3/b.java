package com.smartdigimkt.h3;

import android.os.SystemClock;
import com.smartdigimkt.d0.d;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.v2.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final AtomicBoolean q = new AtomicBoolean(false);
    public static final AtomicLong r = new AtomicLong(0);
    public final long a;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final HashMap c;
    public final HashMap d;
    public final HashMap e;
    public final HashSet f;
    public final ArrayList g;
    public final HashMap h;
    public final HashSet i;
    public final ArrayList j;
    public long k;
    public boolean l;
    public int m;
    public boolean n;
    public final long o;
    public final long p;

    public b(String str) {
        HashMap map = new HashMap();
        this.c = map;
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashSet();
        this.g = new ArrayList();
        this.h = new HashMap();
        this.i = new HashSet();
        this.j = new ArrayList();
        this.k = -1L;
        this.l = true;
        this.m = -1;
        this.o = -1L;
        this.p = -1L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.a = jElapsedRealtime;
        if (str != null && str.length() != 0) {
            String strReplaceAll = str.replaceAll("[\\s=|]+", "_");
            if (strReplaceAll.length() > 80) {
                strReplaceAll.substring(0, 80);
            }
        }
        q.compareAndSet(false, true);
        SDKContext sDKContext = SDKContext.getInstance();
        if (sDKContext.e) {
            boolean z = sDKContext.f;
        }
        Long.toHexString(jElapsedRealtime);
        Long.toHexString(r.incrementAndGet());
        map.put("entryQueue", Long.valueOf(jElapsedRealtime));
    }

    public final boolean a(String str) {
        synchronized (this) {
            if (!this.b.get() && this.k < 0) {
                Long l = (Long) this.c.remove(str);
                if (l == null) {
                    return false;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.d.put(str, Long.valueOf(Math.max(0L, jElapsedRealtime - l.longValue())));
                if ("stateCheck".equals(str) || "bid".equals(str)) {
                    Math.max(0L, jElapsedRealtime - this.a);
                }
                "resource".equals(str);
                return true;
            }
            return false;
        }
    }

    public final void b(String str) {
        synchronized (this) {
            if (!this.b.get() && this.k < 0 && !this.d.containsKey(str) && this.f.add(str)) {
                this.c.remove(str);
                "resource".equals(str);
                SystemClock.elapsedRealtime();
            }
        }
    }

    public final void c() {
        synchronized (this) {
            if (!this.b.get() && this.k < 0 && !this.c.isEmpty()) {
                Iterator it = new ArrayList(this.c.keySet()).iterator();
                while (it.hasNext()) {
                    a((String) it.next());
                }
            }
        }
    }

    public final synchronized void d(String str) {
        if (!this.b.get() && this.k < 0 && !this.c.containsKey(str) && !this.d.containsKey(str) && !this.f.contains(str)) {
            this.c.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        }
    }

    public final synchronized void e() {
    }

    public final void f() {
        p.c().getClass();
        synchronized (this) {
        }
    }

    public final synchronized void d() {
        if (!this.b.get() && this.k < 0) {
            c();
            this.k = SystemClock.elapsedRealtime();
        }
    }

    public final long c(String str) {
        Long l = (Long) this.d.get(str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final synchronized void b(long j) {
        if (this.b.get()) {
            return;
        }
        Math.max(0L, j);
    }

    public final void b() {
        ArrayList arrayList;
        if (this.b.compareAndSet(false, true)) {
            synchronized (this) {
                arrayList = new ArrayList(this.j);
                this.j.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a.d();
            }
            a();
        }
    }

    public final synchronized void a(long j) {
        if (!this.b.get() && j >= 0 && this.l) {
            if (this.g.size() >= 24) {
                this.g.clear();
                this.l = false;
            } else {
                this.g.add(new a(j, -1L));
            }
        }
    }

    public final synchronized void a(long j, long j2) {
        if (!this.b.get() && j >= 0 && j2 >= j && this.l) {
            for (a aVar : this.g) {
                long j3 = aVar.a;
                if (j3 == j && aVar.b < j3) {
                    aVar.b = j2;
                    return;
                }
            }
            if (this.g.size() >= 24) {
                this.g.clear();
                this.l = false;
            } else {
                this.g.add(new a(j, j2));
            }
        }
    }

    public final synchronized void a() {
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.j.clear();
    }

    public final void a(int i, long j, String str, String str2, boolean z) {
        if (!"available".equals(str2) && !"empty".equals(str2) && !"unavailable".equals(str2)) {
            str2 = "unavailable";
        }
        if (!"strategy".equals(str) && !"bid".equals(str)) {
            "offer".equals(str);
        }
        synchronized (this) {
            if (this.b.get()) {
                return;
            }
            this.i.add(str2);
            this.m = Math.max(this.m, Math.max(0, i));
            Math.max(0L, j);
            this.n = this.n || z;
        }
    }
}
