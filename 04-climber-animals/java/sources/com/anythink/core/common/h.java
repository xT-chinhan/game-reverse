package com.anythink.core.common;

import com.anythink.core.common.h.bv;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private String b;
    private d c;
    private b d;
    private boolean e;
    private boolean f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private g k;
    private boolean l;
    private final String a = getClass().getSimpleName();
    private final List<a> m = new CopyOnWriteArrayList();

    public interface b {
        void a(com.anythink.core.b.d dVar, int i);
    }

    public interface d {
        void a(g gVar);
    }

    public h(String str) {
        this.b = str;
    }

    public final void a(com.anythink.core.d.l lVar, boolean z) {
        if (lVar == null) {
            this.f = false;
            return;
        }
        this.l = z;
        this.f = lVar.b() == 1;
        this.g = lVar.e();
        this.h = lVar.f();
        this.i = lVar.d();
        if (this.f) {
            return;
        }
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
    }

    private static boolean a(List<bv> list, bv bvVar) {
        return list == null || list.isEmpty() || com.anythink.core.common.v.l.a(bvVar, list.get(0)) == -1;
    }

    public final void a(g gVar) {
        this.e = true;
        new c(gVar);
    }

    public class c {
        public c(g gVar) {
            h.this.k = gVar;
            if (!h.this.f) {
                h.this.a();
            } else {
                com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.h.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.a();
                    }
                }, h.this.i);
            }
        }
    }

    public final synchronized void a() {
        if (this.c != null && !this.j) {
            this.c.a(this.k);
        }
        this.j = true;
        this.e = false;
    }

    private void a(com.anythink.core.b.d dVar, int i) {
        if (dVar != null) {
            new a(dVar, i);
        }
    }

    public class a {
        private boolean b;
        private com.anythink.core.b.d c;
        private int d;

        public a(com.anythink.core.b.d dVar, int i) {
            this.c = dVar;
            this.d = i;
            if (h.this.f) {
                if (h.this.l) {
                    synchronized (h.this.m) {
                        try {
                            h.this.m.add(this);
                        } catch (Throwable th) {
                            com.anythink.core.common.u.e.b("prepareBidLoadControllers add error", th.getMessage() + ", " + com.anythink.core.common.v.q.a(th.getStackTrace()), com.anythink.core.common.d.t.b().r());
                        }
                    }
                }
                String unused = h.this.a;
                if (2 == i) {
                    long unused2 = h.this.g;
                } else {
                    long unused3 = h.this.h;
                }
                com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.h.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a();
                    }
                }, 2 == i ? h.this.g : h.this.h);
                return;
            }
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void a() {
            if (!this.b) {
                this.b = true;
                String unused = h.this.a;
                if (2 == this.d) {
                    long unused2 = h.this.g;
                } else {
                    long unused3 = h.this.h;
                }
                if (h.this.d != null) {
                    h.this.d.a(this.c, this.d);
                }
            }
        }
    }

    public final void b() {
        if (!this.l) {
            return;
        }
        synchronized (this.m) {
            try {
                List<a> list = this.m;
                if (list != null && !list.isEmpty()) {
                    for (a aVar : this.m) {
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                }
            } catch (Throwable th) {
                com.anythink.core.common.u.e.b("callAnotherBiddingByOnlyBid error", th.getMessage() + ", " + com.anythink.core.common.v.q.a(th.getStackTrace()), com.anythink.core.common.d.t.b().r());
            }
        }
    }

    public final long c() {
        if (this.f) {
            return Math.max(this.h, this.g);
        }
        return 0L;
    }

    public final void a(d dVar) {
        this.c = dVar;
    }

    public final void a(b bVar) {
        this.d = bVar;
    }

    public final boolean d() {
        return this.e;
    }

    private void a(boolean z) {
        this.f = z;
    }

    public final boolean e() {
        return this.f;
    }
}
