package com.anythink.core.common.t.a;

import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.u;
import com.anythink.core.common.p;
import com.anythink.core.common.q;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.u.b.c;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import com.anythink.core.common.u.o;
import com.anythink.core.common.v;
import com.anythink.core.e.l;
import com.varbto.utils.api.MediationUtilsManager;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";
    private static C0048a c;
    private static volatile a d;
    private boolean e;
    private boolean f;
    private final AtomicLong b = new AtomicLong(0);
    private final AtomicBoolean g = new AtomicBoolean(false);

    private static void l() {
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public final boolean b() {
        return this.e;
    }

    public final boolean c() {
        return this.f;
    }

    public static void a(Runnable runnable) {
        c.a().g(new d(e.aR, runnable));
    }

    public final long d() {
        return this.b.get();
    }

    public final void e() {
        this.b.incrementAndGet();
    }

    public final void f() {
        if (this.g.getAndSet(true)) {
            return;
        }
        c = new C0048a();
        c.a().g(new d(e.aS, new Runnable() { // from class: com.anythink.core.common.t.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.a(false);
                } catch (Throwable unused) {
                }
            }
        }));
    }

    public final void a(final int i, final bx bxVar, final by byVar, final long j) {
        if (this.e || bxVar == null) {
            return;
        }
        c.a().g(new d(e.aU, new Runnable() { // from class: com.anythink.core.common.t.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                n nVar;
                String strAQ;
                l lVarA;
                List<String> listT;
                f fVarA;
                List<com.anythink.core.common.h.c> listA;
                ad adVarY;
                try {
                    int i2 = i;
                    bx bxVar2 = bxVar;
                    by byVar2 = byVar;
                    long jCurrentTimeMillis = j;
                    com.anythink.core.common.t.c.b.a(i2, byVar2, false);
                    if (i2 == 4) {
                        ad adVarY2 = byVar2 != null ? byVar2.Y() : null;
                        if (adVarY2 != null) {
                            com.anythink.core.c.d.c.a(adVarY2, true, adVarY2.getSortPrice(), true, false, byVar2);
                        }
                        if ((bxVar2 instanceof n) && (lVarA = com.anythink.core.e.n.a(s.b().g()).a((strAQ = (nVar = (n) bxVar2).aQ()))) != null && (listT = lVarA.T()) != null && listT.size() != 0 && (fVarA = nVar.a()) != null && (listA = fVarA.e().a(strAQ)) != null) {
                            for (com.anythink.core.common.h.c cVar : listA) {
                                if (cVar != null && cVar.c() == 0) {
                                    n nVarI = cVar.i();
                                    by unitGroupInfo = cVar.e().getUnitGroupInfo();
                                    boolean zR = (!aj.b(unitGroupInfo) || unitGroupInfo.Y() == null) ? false : unitGroupInfo.Y().r();
                                    if (listT.contains(String.valueOf(unitGroupInfo.n())) && !TextUtils.equals(nVar.y(), nVarI.y()) && (adVarY = unitGroupInfo.Y()) != null) {
                                        com.anythink.core.c.d.c.a(adVarY, false, o.a(byVar2), nVar.K() == 1, zR, unitGroupInfo);
                                    }
                                }
                            }
                        }
                    }
                    if (i2 == 4) {
                        if (bxVar2 instanceof n) {
                            if (byVar2 != null) {
                                com.anythink.core.d.a.a().a((n) bxVar2, byVar2);
                                if (byVar2.X() && byVar2.aK() > 0.0d) {
                                    ((n) bxVar2).e(byVar2.aK());
                                }
                            }
                            if (((n) bxVar2).j() == 2) {
                                v.a().a(bxVar2.aQ(), ((n) bxVar2).b());
                            }
                            com.anythink.core.common.d.a().a(bxVar2.aQ(), bxVar2.aR(), ((n) bxVar2).N());
                        }
                        com.anythink.core.d.b.a().a(bxVar2, byVar2);
                    }
                    if (i2 == 6 && (bxVar2 instanceof n)) {
                        com.anythink.core.common.d.a().b(bxVar2.aQ(), bxVar2.aR(), ((n) bxVar2).N());
                    }
                    com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
                    com.anythink.core.common.h.o oVar = new com.anythink.core.common.h.o();
                    oVar.a = i2;
                    oVar.b = bxVar2;
                    if (jCurrentTimeMillis <= 0) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                    oVar.c = jCurrentTimeMillis;
                    q.a(s.b().g()).a(i2, oVar, bVarB);
                    if (4 == i2 && (bxVar2 instanceof n)) {
                        p.a();
                        p.a((n) bxVar2);
                    }
                    com.anythink.core.common.t.a.b.a.a().a(oVar);
                } catch (Throwable unused) {
                }
            }
        }));
    }

    public final void a(final u uVar) {
        if (this.f || uVar == null) {
            return;
        }
        c.a().g(new d(e.aT, new Runnable() { // from class: com.anythink.core.common.t.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.anythink.core.common.t.a.b.a.a().a(uVar);
                } catch (Throwable unused) {
                }
            }
        }));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.t.a.a$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!a.this.e) {
                    com.anythink.core.common.t.a.b.a.a();
                    com.anythink.core.common.t.a.b.a.a(false);
                }
                if (a.this.f) {
                    return;
                }
                com.anythink.core.common.t.a.b.a.a();
                com.anythink.core.common.t.a.b.a.b(false);
            } catch (Throwable unused) {
            }
        }
    }

    private void j() {
        c.a().g(new d(e.aX, new AnonymousClass4()));
    }

    public final void g() {
        if (this.f) {
            return;
        }
        c.a().g(new d(e.aV, new Runnable() { // from class: com.anythink.core.common.t.a.a.5
            final /* synthetic */ boolean a = false;

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.anythink.core.common.t.a.b.a.a();
                    com.anythink.core.common.t.a.b.a.b(this.a);
                } catch (Throwable unused) {
                }
            }
        }));
    }

    public final void h() {
        if (this.e) {
            return;
        }
        c.a().g(new d(e.aY, new Runnable() { // from class: com.anythink.core.common.t.a.a.6
            final /* synthetic */ boolean a = false;

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.anythink.core.common.t.a.b.a.a();
                    com.anythink.core.common.t.a.b.a.a(this.a);
                } catch (Throwable unused) {
                }
            }
        }));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.t.a.a$7, reason: invalid class name */
    final class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                new com.anythink.core.common.t.a.b.a.b.a().a();
            } catch (Throwable unused) {
            }
        }
    }

    private void k() {
        c.a().g(new d(e.aW, new AnonymousClass7()));
    }

    public static void a(boolean z) {
        c.a(z);
    }

    public static C0048a i() {
        return c;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.t.a.a$a, reason: collision with other inner class name */
    public class C0048a {
        long a;
        long b;
        long c;
        long d;
        boolean e;
        boolean f;
        private boolean h;

        public C0048a() {
        }

        public final long a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public final void a(boolean z) {
            com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
            if (bVarA != null) {
                try {
                    this.a = bVarA.ac();
                    this.b = bVarA.ah();
                    this.c = bVarA.ae();
                    this.d = bVarA.aj();
                    this.e = bVarA.aT() == 1;
                    this.f = bVarA.aR() == 1;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (this.a == 0) {
                this.a = 50L;
            }
            if (this.b == 0) {
                this.b = 50L;
            }
            HashMap map = new HashMap();
            if (!a.this.e) {
                map.put("tk", new b.C0050b(this.c, new b.a() { // from class: com.anythink.core.common.t.a.a.a.1
                    @Override // com.anythink.core.common.t.a.b.a
                    public final void a() {
                        a.this.h();
                    }
                }));
            }
            if (!a.this.f) {
                map.put("da", new b.C0050b(this.d, new b.a() { // from class: com.anythink.core.common.t.a.a.a.2
                    @Override // com.anythink.core.common.t.a.b.a
                    public final void a() {
                        a.this.g();
                    }
                }));
            }
            boolean z2 = this.e;
            if (z2) {
                try {
                    boolean z3 = this.f;
                    if (!this.h) {
                        this.h = true;
                        try {
                            MediationUtilsManager.getInstance(s.b().g()).registerAnrSdk(1);
                            MediationUtilsManager.getInstance(s.b().g()).initAnrMonitoring(5000L, z3, z2);
                        } catch (Throwable unused2) {
                        }
                    }
                    map.put("anr", new b.C0050b(0L, new b.a() { // from class: com.anythink.core.common.t.a.a.a.3
                        @Override // com.anythink.core.common.t.a.b.a
                        public final void a() {
                            c.a().g(new d(e.aW, a.this.new AnonymousClass7()));
                        }
                    }));
                } catch (Throwable unused3) {
                }
            }
            b.a().a(map);
            if (z) {
                c.a().g(new d(e.aX, a.this.new AnonymousClass4()));
            }
        }

        private void a(boolean z, boolean z2) {
            if (this.h) {
                return;
            }
            this.h = true;
            try {
                MediationUtilsManager.getInstance(s.b().g()).registerAnrSdk(1);
                MediationUtilsManager.getInstance(s.b().g()).initAnrMonitoring(5000L, z2, z);
            } catch (Throwable unused) {
            }
        }
    }
}
