package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdFilter;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IATAdFilter;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.ac;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.am;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cd;
import com.anythink.core.common.h.ce;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.aj;
import com.anythink.core.mg.api.MgComparedResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g {
    static final int N = 1;
    static final int O = 2;
    static final int P = 3;
    static final int Q = 4;
    boolean A;
    protected com.anythink.core.common.u.b.d G;
    com.anythink.core.common.v.g I;
    com.anythink.core.common.a.c.a J;
    by M;
    double R;
    by T;
    private h X;
    private boolean Y;
    private final f Z;
    protected WeakReference<Context> b;
    protected int c;
    protected ce e;
    protected String f;
    protected String g;
    Map<String, Object> h;
    com.anythink.core.common.h.n i;
    protected as j;
    protected com.anythink.core.common.d.c k;
    boolean p;
    boolean q;
    String t;
    long v;
    int w;
    int x;
    private final String V = getClass().getSimpleName();
    protected String d = "";
    boolean l = false;
    boolean m = false;
    boolean n = false;
    protected boolean o = false;
    boolean r = false;
    boolean s = false;
    by y = null;
    boolean z = false;
    by B = null;
    by C = null;
    protected com.anythink.core.common.u.b.d F = null;
    protected com.anythink.core.common.u.b.d L = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dm, new Runnable() { // from class: com.anythink.core.common.g.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aB, new Runnable() { // from class: com.anythink.core.common.g.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.a();
                }
            }));
        }
    });
    boolean S = false;
    boolean U = false;
    protected Context a = com.anythink.core.common.d.s.b().g();
    AdError u = ErrorCode.getErrorCode(ErrorCode.noADError, "", "");
    protected final Map<String, com.anythink.core.common.v.e> D = new ConcurrentHashMap();
    List<by> E = Collections.synchronizedList(new ArrayList(3));
    com.anythink.core.common.v.j H = new com.anythink.core.common.v.j();
    List<ATBaseAdAdapter> K = new ArrayList();
    private final com.anythink.core.mg.a.a W = new com.anythink.core.mg.a.a();

    public static class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
    }

    static /* synthetic */ boolean a(int i) {
        return i == 3 || i == 5;
    }

    private static boolean b(int i) {
        return i == 3 || i == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        com.anythink.core.common.h.c cVarD = D();
        this.s = true;
        if (!this.o && cVarD != null) {
            by unitGroupInfo = cVarD.e() != null ? cVarD.e().getUnitGroupInfo() : null;
            a(unitGroupInfo, com.anythink.core.common.u.o.a(unitGroupInfo), true);
            a(9, unitGroupInfo);
        }
    }

    private void a(Double d) {
        com.anythink.core.common.v.g gVar = this.I;
        if (gVar != null) {
            gVar.a(d);
        }
    }

    protected final synchronized void a() {
        ConcurrentHashMap concurrentHashMap;
        this.H.a();
        synchronized (this.D) {
            concurrentHashMap = new ConcurrentHashMap(this.D);
        }
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            com.anythink.core.common.v.e eVar = (com.anythink.core.common.v.e) ((Map.Entry) it.next()).getValue();
            if (eVar != null) {
                eVar.b();
            }
        }
        if (!this.o) {
            this.o = true;
            z();
        }
        m();
    }

    public g(Context context, f fVar) {
        this.b = new WeakReference<>(context);
        this.Z = fVar;
    }

    private void a(Map<String, Object> map) {
        this.h = map;
    }

    private void a(com.anythink.core.common.h.n nVar) {
        this.i = nVar;
    }

    public final void a(com.anythink.core.common.d.c cVar) {
        this.k = cVar;
    }

    public final void a(as asVar) {
        this.j = asVar;
    }

    private synchronized void l() {
        if (this.p) {
            this.I.b(this.i);
        }
    }

    private synchronized void a(List<by> list, int i) {
        if (!this.H.b() && !this.H.c() && list != null && list.size() != 0) {
            this.I.a(list);
            Iterator<by> it = list.iterator();
            while (it.hasNext()) {
                b(it.next(), i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        by byVarA = this.I.a(false);
        by byVarT = t();
        if ((this.m && this.x >= this.e.g() && com.anythink.core.common.u.k.a(byVarA, byVarT) <= 0) || this.H.c() || this.H.b()) {
            this.p = true;
            l();
            if (this.I.l() == 0) {
                s();
            }
        }
        r();
        if (this.p || A()) {
            s();
        }
    }

    private synchronized void a(by byVar, int i) {
        this.I.b(byVar, i);
    }

    private synchronized void c(int i) {
        int iN;
        try {
            if (i == 2) {
                iN = this.I.n();
            } else {
                iN = this.I.m();
            }
            if (iN == 0) {
                a(this.I.b(i), i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void b(by byVar) {
        this.I.b(byVar);
    }

    /* JADX WARN: Code duplicated, block: B:78:0x010e A[Catch: all -> 0x001d, TryCatch #1 {all -> 0x001d, blocks: (B:5:0x0009, B:6:0x000d, B:8:0x0013, B:12:0x0022, B:14:0x0028, B:15:0x002c, B:17:0x0032, B:19:0x003a, B:21:0x0042, B:23:0x004e, B:25:0x0056, B:27:0x005e, B:30:0x006b, B:32:0x0072, B:35:0x007a, B:39:0x008a, B:43:0x0094, B:51:0x00a4, B:47:0x009c, B:49:0x00a0, B:54:0x00a9, B:57:0x00b9, B:80:0x011f, B:61:0x00cb, B:76:0x00eb, B:78:0x010e, B:79:0x0110, B:65:0x00d3, B:58:0x00c0, B:42:0x0090, B:38:0x0086), top: B:90:0x0009 }] */
    public final synchronized void a(List<by> list, List<by> list2, List<by> list3, List<by> list4) {
        boolean zA;
        String str;
        String str2;
        String str3;
        if (list2 != null) {
            try {
                Iterator<by> it = list2.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (list4 != null && !list4.isEmpty()) {
            for (by byVar : list4) {
                if (byVar != null) {
                    try {
                        if (byVar.n() == 22) {
                            this.I.f(byVar);
                            com.anythink.core.common.v.g.a(byVar, this.i);
                        }
                    } catch (Exception unused) {
                    }
                }
                if (byVar != null && (byVar.B() == -11 || byVar.B() == -13)) {
                    this.I.f(byVar);
                    com.anythink.core.common.v.g.b(byVar, this.i);
                }
            }
        }
        if (list3 != null) {
            this.E.addAll(list3);
        }
        if (list != null && list.size() != 0) {
            this.H.f();
            h hVar = this.X;
            boolean zE = hVar == null ? false : hVar.e();
            h hVar2 = this.X;
            boolean zD = hVar2 == null ? false : hVar2.d();
            if (!this.m && ((zD && zE) || !this.l || this.Y)) {
                a(list);
                return;
            }
            by byVar2 = list.get(0);
            boolean zA2 = com.anythink.core.common.v.g.a(byVar2, this.H);
            if (zE && !zD) {
                zA = this.I.a(byVar2, false);
            } else {
                zA = this.I.a(byVar2, true);
            }
            if (zA2 || zA) {
                if (this.o) {
                    str = this.n ? "2" : "3";
                } else {
                    str = "1";
                }
                String str4 = str;
                if (zA2) {
                    str3 = "1";
                } else {
                    if (zA) {
                        str3 = "2";
                    } else {
                        str2 = "1";
                    }
                    com.anythink.core.common.t.f.a(this.i, byVar2.n(), byVar2.G(), com.anythink.core.common.u.o.a(byVar2), com.anythink.core.common.u.o.b(byVar2), str4, str2, byVar2.bB(), byVar2.bC());
                    if (byVar2.av()) {
                        this.M = byVar2;
                    }
                    e(byVar2);
                    list.remove(0);
                    this.I.a(byVar2);
                    b(byVar2, 3);
                }
                str2 = str3;
                com.anythink.core.common.t.f.a(this.i, byVar2.n(), byVar2.G(), com.anythink.core.common.u.o.a(byVar2), com.anythink.core.common.u.o.b(byVar2), str4, str2, byVar2.bB(), byVar2.bC());
                if (byVar2.av()) {
                    this.M = byVar2;
                }
                e(byVar2);
                list.remove(0);
                this.I.a(byVar2);
                b(byVar2, 3);
            }
            a(list);
            F();
        }
    }

    private void a(List<by> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (by byVar : list) {
            e(byVar);
            a(byVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(by byVar) {
        this.u.putNetworkErrorMsg(byVar.G(), byVar.n(), byVar.o(), ErrorCode.getErrorCode(ErrorCode.noADError, "", byVar.M()));
        this.I.c(byVar);
    }

    private void d(by byVar) {
        if (byVar != null) {
            try {
                if (byVar.n() == 22) {
                    this.I.f(byVar);
                    com.anythink.core.common.v.g.a(byVar, this.i);
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (byVar != null) {
            if (byVar.B() == -11 || byVar.B() == -13) {
                this.I.f(byVar);
                com.anythink.core.common.v.g.b(byVar, this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(by byVar) {
        this.I.d(byVar);
        com.anythink.core.common.v.g.a(this.Z, this.g, this.f, null, byVar);
        this.I.e(byVar);
        this.I.c(byVar);
        h(byVar);
    }

    protected final void a(com.anythink.core.common.v.h hVar) {
        this.I = new com.anythink.core.common.v.g(hVar, this.H);
        this.m = hVar.i;
        this.f = hVar.b;
        this.g = hVar.a;
        this.e = hVar.c;
        this.c = hVar.j;
        this.t = com.anythink.core.common.v.g.c(hVar.d);
        this.Y = hVar.q;
    }

    protected final void a(h hVar) {
        this.X = hVar;
        this.v = SystemClock.elapsedRealtime();
        com.anythink.core.common.s.c.a().a(this.L, this.e.h());
        if (this.e.i() >= 0) {
            this.F = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dk, new AnonymousClass3());
            com.anythink.core.common.s.c.a().a(this.F, this.e.i());
        }
        if (this.J != null) {
            com.anythink.core.common.h.n nVarAh = this.i.ah();
            ai.a(nVarAh, this.J.d(), 0, true);
            this.J.a(this.f, nVarAh);
        }
    }

    protected final void b() {
        this.l = true;
        long jA = this.I.a(this.m, this.e.a().L());
        if (jA > -1) {
            this.G = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dl, new AnonymousClass4());
        }
        if (this.I.g() && this.m) {
            v();
        }
        a(this.I.r(), 1);
        if (this.G != null) {
            com.anythink.core.common.s.c.a().a(this.G, jA);
        }
    }

    private void n() {
        if (this.J != null) {
            com.anythink.core.common.h.n nVarAh = this.i.ah();
            ai.a(nVarAh, this.J.d(), 0, true);
            this.J.a(this.f, nVarAh);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.g$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.this.F = null;
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aC, new Runnable() { // from class: com.anythink.core.common.g.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.k();
                }
            }));
        }
    }

    private void o() {
        if (this.e.i() >= 0) {
            this.F = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dk, new AnonymousClass3());
            com.anythink.core.common.s.c.a().a(this.F, this.e.i());
        }
    }

    private void a(long j) {
        if (this.G != null) {
            com.anythink.core.common.s.c.a().a(this.G, j);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.g$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.this.q();
        }
    }

    private com.anythink.core.common.u.b.d p() {
        return new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dl, new AnonymousClass4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q() {
        if (!this.o && this.I.e() > 0) {
            this.G = null;
            by byVarF = this.I.f();
            this.I.a(byVarF);
            b(byVarF, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final by byVar, final int i) {
        final com.anythink.core.common.v.e eVar = new com.anythink.core.common.v.e(byVar, i, this.Z);
        final String strA = eVar.a();
        this.D.put(strA, eVar);
        this.I.a(1, i);
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aD, new Runnable() { // from class: com.anythink.core.common.g.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (g.this) {
                    if (g.this.H.b()) {
                        g.this.D.remove(strA);
                        return;
                    }
                    if (aj.a(byVar)) {
                        if (TextUtils.isEmpty(g.this.Z != null ? g.this.Z.b(byVar.n()) : "") && g.this.Z != null) {
                            g.this.Z.a(byVar.n(), byVar.r());
                        }
                    }
                    boolean zA = g.a(i);
                    com.anythink.core.common.h.n nVarAh = g.this.i.ah();
                    nVarAh.s(zA ? new StringBuilder().append(byVar.n()).toString() : g.this.t);
                    byte b = 1;
                    ai.a(nVarAh, byVar, g.this.w, true);
                    nVarAh.p(SystemClock.elapsedRealtime() - g.this.v);
                    if (g.this.a(nVarAh, byVar, i, strA)) {
                        return;
                    }
                    boolean zA2 = com.anythink.core.common.v.g.a(g.this.g, byVar, nVarAh, g.this.Z);
                    g.this.w++;
                    if (zA2) {
                        com.anythink.core.common.v.b bVar = new com.anythink.core.common.v.b();
                        bVar.c = 6;
                        bVar.d = ErrorCode.getErrorCode(ErrorCode.noADError, "", "Bid result has expired.");
                        bVar.e = 0L;
                        bVar.f = nVarAh;
                        bVar.g = byVar;
                        g.this.a(strA, bVar);
                        return;
                    }
                    int iE = com.anythink.core.common.u.o.e(byVar.k());
                    if (g.this.I != null && g.this.I.v() != null && iE != 2) {
                        Double dV = g.this.I.v();
                        if (com.anythink.core.common.u.o.a(byVar) < dV.doubleValue()) {
                            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adSourceLoadPriceFilterError, "", "Filter by bid anchor price.");
                            com.anythink.core.common.v.b bVar2 = new com.anythink.core.common.v.b();
                            bVar2.c = 40;
                            byVar.i(errorCode.getPlatformMSG());
                            byVar.k(-14);
                            byVar.ag(3);
                            byVar.j(dV.doubleValue());
                            nVarAh.p(dV.doubleValue());
                            bVar2.d = errorCode;
                            bVar2.e = 0L;
                            bVar2.f = nVarAh;
                            bVar2.g = byVar;
                            if (byVar.w()) {
                                g.a(12, byVar.Y(), byVar, nVarAh, 38);
                            }
                            g.this.a(strA, bVar2);
                            return;
                        }
                    }
                    ATAdFilter aTAdFilterU = com.anythink.core.common.d.s.b().u(g.this.g);
                    if (aTAdFilterU != null) {
                        AdError adErrorDoFilter = aTAdFilterU.doFilter(new cd(0, String.valueOf(byVar.n()), String.valueOf(iE), com.anythink.core.common.u.o.a(byVar), aj.a(byVar, null), byVar));
                        if (adErrorDoFilter != null) {
                            com.anythink.core.common.v.b bVar3 = new com.anythink.core.common.v.b();
                            bVar3.c = 35;
                            String code = adErrorDoFilter.getCode();
                            code.hashCode();
                            switch (code.hashCode()) {
                                case 1537309:
                                    b = !code.equals(ErrorCode.adSourceLoadBidTypeFilterError) ? (byte) -1 : (byte) 0;
                                    break;
                                case 1537310:
                                    if (!code.equals(ErrorCode.adSourceLoadPriceFilterError)) {
                                        b = -1;
                                    }
                                    break;
                                case 1537311:
                                    b = !code.equals(ErrorCode.adSourceLoadUnitFilterError) ? (byte) -1 : (byte) 2;
                                    break;
                                default:
                                    b = -1;
                                    break;
                            }
                            switch (b) {
                                case 0:
                                    bVar3.c = 36;
                                    break;
                                case 1:
                                    bVar3.c = 37;
                                    break;
                                case 2:
                                    bVar3.c = 38;
                                    break;
                            }
                            byVar.i(adErrorDoFilter.getPlatformMSG());
                            byVar.k(-13);
                            nVarAh.o(byVar.bF());
                            nVarAh.C(byVar.bG());
                            bVar3.d = adErrorDoFilter;
                            bVar3.e = 0L;
                            bVar3.f = nVarAh;
                            bVar3.g = byVar;
                            if (byVar.w()) {
                                g.a(9, byVar.Y(), byVar, nVarAh, 37);
                            }
                            g.this.a(strA, bVar3);
                            return;
                        }
                    }
                    int iAw = byVar.aw();
                    if (iAw <= 0) {
                        if (g.this.n && g.this.x < g.this.e.g()) {
                            nVarAh.t = 5;
                        }
                    } else {
                        nVarAh.t = iAw;
                    }
                    g.a(g.this, eVar, nVarAh, byVar);
                }
            }
        }));
    }

    protected static void a(int i, ad adVar, by byVar, com.anythink.core.common.h.n nVar, int i2) {
        if (adVar != null) {
            ay ayVar = new ay(i, byVar, nVar, adVar.getSortPrice());
            if (byVar != null) {
                int iBE = byVar.bE();
                if (iBE == 1) {
                    ayVar.d(byVar.az());
                } else if (iBE == 2) {
                    ayVar.b(byVar.bG());
                    ayVar.d(byVar.bF());
                } else if (iBE == 3) {
                    ayVar.d(byVar.bF());
                }
            }
            com.anythink.core.c.d.c.a(adVar, ayVar, true, i2);
        }
    }

    private static void a(ay ayVar, by byVar) {
        if (byVar != null) {
            int iBE = byVar.bE();
            if (iBE == 1) {
                ayVar.d(byVar.az());
                return;
            }
            if (iBE == 2) {
                ayVar.b(byVar.bG());
                ayVar.d(byVar.bF());
            } else if (iBE == 3) {
                ayVar.d(byVar.bF());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(com.anythink.core.common.h.n nVar, by byVar, int i, String str) {
        f fVar = this.Z;
        com.anythink.core.common.h.i iVarS = fVar != null ? fVar.s() : null;
        if (iVarS == null || !iVarS.a(byVar)) {
            return false;
        }
        aa.a(this.g, nVar, "Can't Load On Showing", byVar, -1, -1);
        com.anythink.core.common.t.f.a(nVar, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
        this.Z.a(iVarS.a(), this.f);
        this.I.a(byVar, i);
        b(byVar);
        this.I.a(i);
        this.D.remove(str);
        this.I.a(-1, i);
        a(this.I.b(i), i);
        return true;
    }

    private void a(com.anythink.core.common.v.e eVar, com.anythink.core.common.h.n nVar, by byVar) {
        com.anythink.core.common.v.d dVar = new com.anythink.core.common.v.d();
        dVar.a = this.a;
        dVar.b = this.b;
        dVar.c = this.f;
        dVar.d = this.g;
        dVar.e = this.e.a();
        dVar.f = this.h;
        dVar.g = this.w;
        dVar.h = nVar;
        dVar.i = this.I.q();
        eVar.a(dVar);
        eVar.a(new AnonymousClass6(byVar));
        eVar.a(this.C);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.g$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.core.common.v.c {
        final /* synthetic */ by a;

        AnonymousClass6(by byVar) {
            this.a = byVar;
        }

        @Override // com.anythink.core.common.v.c
        public final void a(com.anythink.core.common.h.n nVar) {
            com.anythink.core.common.t.e.a(g.this.a);
            com.anythink.core.common.t.e.a(1, nVar);
            aa.a(nVar, com.anythink.core.common.d.i.s.a, com.anythink.core.common.d.i.s.o, "");
        }

        @Override // com.anythink.core.common.v.c
        public final void a(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
            g.a(g.this, nVar, aTBaseAdAdapter);
            if (this.a.aR() == 1) {
                g.a(g.this, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.common.v.c
        public final void a(ATBaseAdAdapter aTBaseAdAdapter, String str) {
            g.this.a(aTBaseAdAdapter, str);
        }

        @Override // com.anythink.core.common.v.c
        public final void a(String str) {
            g.this.a(str);
            if (this.a.aR() == 1) {
                g.this.E();
            }
        }

        @Override // com.anythink.core.common.v.c
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, by byVar, com.anythink.core.common.h.c cVar) {
            g.this.a(str, aTBaseAdAdapter, cVar.f(), byVar);
        }

        @Override // com.anythink.core.common.v.c
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, BaseAd... baseAdArr) {
            IATAdFilter iATAdFilterQ = com.anythink.core.common.d.s.b().q(g.this.g);
            BaseAd baseAd = (baseAdArr == null || baseAdArr.length <= 0) ? null : baseAdArr[0];
            if (iATAdFilterQ != null && iATAdFilterQ.isAdFilter(com.anythink.core.common.d.k.a(aTBaseAdAdapter, 3), baseAd)) {
                com.anythink.core.common.v.b bVar = new com.anythink.core.common.v.b();
                bVar.c = 8;
                bVar.e = aTBaseAdAdapter.getTrackingInfo().ac();
                bVar.d = ErrorCode.getErrorCode(ErrorCode.adSourceNotFilledError, "", "");
                bVar.f = aTBaseAdAdapter.getTrackingInfo();
                bVar.g = aTBaseAdAdapter.getUnitGroupInfo();
                g.this.a(str, bVar);
            } else {
                g.this.a(str, aTBaseAdAdapter, baseAdArr != null ? Arrays.asList(baseAdArr) : null);
            }
            if (this.a.aR() == 1) {
                g.b(g.this, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.common.v.c
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.v.b bVar) {
            g.this.a(str, bVar);
            if (aTBaseAdAdapter == null || aTBaseAdAdapter.getUnitGroupInfo() == null) {
                return;
            }
            aTBaseAdAdapter.getUnitGroupInfo();
            if (this.a.aR() == 1) {
                g.b(g.this, aTBaseAdAdapter);
            }
        }
    }

    private void a(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        com.anythink.core.common.d.c cVar = this.k;
        if (cVar != null) {
            cVar.onAdSourceAttempt(nVar);
        }
        if (aTBaseAdAdapter != null) {
            a(nVar, (AdError) null, com.anythink.core.common.v.a.a.b.a, aTBaseAdAdapter.getUnitGroupInfo());
        }
        if (aTBaseAdAdapter != null) {
            com.anythink.core.common.u.d.a().a(nVar, aTBaseAdAdapter.getUnitGroupInfo(), 3);
        }
    }

    private void b(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        com.anythink.core.common.d.c cVar = this.k;
        if (cVar != null) {
            cVar.onAdSourceLoadFilled(nVar);
        }
        a(nVar, (AdError) null, com.anythink.core.common.v.a.a.b.b, aTBaseAdAdapter.getUnitGroupInfo());
        if (aTBaseAdAdapter != null) {
            com.anythink.core.common.u.d.a().a(nVar, aTBaseAdAdapter.getUnitGroupInfo(), 4);
        }
    }

    private void a(com.anythink.core.common.h.n nVar, AdError adError, by byVar) {
        com.anythink.core.common.d.c cVar = this.k;
        if (cVar != null) {
            cVar.onAdSourceLoadFail(nVar, adError);
        }
        a(nVar, adError, com.anythink.core.common.v.a.a.b.c, byVar);
    }

    private void a(com.anythink.core.common.h.n nVar, AdError adError, int i, by byVar) {
        String platformCode;
        String platformMSG;
        if (nVar == null) {
            return;
        }
        if (nVar.L() && i == com.anythink.core.common.v.a.a.b.a) {
            return;
        }
        com.anythink.core.common.v.a.b.d dVar = (com.anythink.core.common.v.a.b.d) com.anythink.core.common.v.a.a.d.a(nVar.aQ(), com.anythink.core.common.v.a.b.d.class);
        if (dVar != null) {
            if (adError != null) {
                platformCode = adError.getPlatformCode();
                platformMSG = adError.getPlatformMSG();
            } else {
                platformCode = "";
                platformMSG = "";
            }
            dVar.a(am.a(nVar, platformCode, platformMSG, i));
        }
        com.anythink.core.a.c.a();
        if (i == com.anythink.core.common.v.a.a.b.a) {
            com.anythink.core.a.c.a(this.a, byVar, nVar.aQ());
            return;
        }
        if (i == com.anythink.core.common.v.a.a.b.c) {
            com.anythink.core.a.c.b(this.a, byVar, nVar.aQ());
        } else if (i == com.anythink.core.common.v.a.a.b.b) {
            Context context = this.a;
            nVar.aQ();
            com.anythink.core.a.c.b(context, byVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, by byVar) {
        com.anythink.core.common.v.e eVarRemove = this.D.remove(str);
        if (eVarRemove == null) {
            return;
        }
        a(eVarRemove, aTBaseAdAdapter, byVar, aTBaseAdAdapter.getTrackingInfo(), true, baseAd);
        b(byVar);
        u();
        b(aTBaseAdAdapter.getTrackingInfo(), aTBaseAdAdapter);
        byVar.G();
        a(eVarRemove);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x003f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0077 A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0081 A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x008f A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x009f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a2 A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00aa A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c3 A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00df A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e3 A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x002f, B:14:0x0035, B:16:0x0040, B:18:0x0056, B:20:0x0060, B:21:0x0063, B:23:0x0077, B:25:0x008a, B:27:0x008f, B:29:0x0097, B:34:0x00a2, B:36:0x00aa, B:40:0x00b8, B:44:0x00c3, B:47:0x00cf, B:48:0x00d9, B:54:0x0102, B:49:0x00df, B:51:0x00e3, B:53:0x00e9, B:24:0x0081), top: B:60:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001d A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:8:0x001d, please report this as an issue */
    public final synchronized void a(String str, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list) {
        com.anythink.core.common.v.e eVarRemove;
        com.anythink.core.common.h.n trackingInfo;
        by unitGroupInfo;
        BaseAd[] baseAdArr;
        com.anythink.core.mg.a.a aVar;
        f fVar;
        MgComparedResult mgComparedResultA;
        boolean z;
        boolean z2;
        ad adVarY;
        double uSDEcpm;
        if (aTBaseAdAdapter != null) {
            aTBaseAdAdapter.getTrackingInfo().N();
            eVarRemove = this.D.remove(str);
            if (eVarRemove == null) {
                return;
            }
            trackingInfo = aTBaseAdAdapter.getTrackingInfo();
            unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            b(unitGroupInfo);
            u();
            if (list != null || list.size() <= 0) {
                baseAdArr = null;
            } else {
                baseAdArr = new BaseAd[list.size()];
                list.toArray(baseAdArr);
            }
            a(eVarRemove, aTBaseAdAdapter, unitGroupInfo, trackingInfo, false, baseAdArr);
            if (unitGroupInfo.O() != -1 && trackingInfo.ab() > 0) {
                com.anythink.core.common.t.f.a(trackingInfo);
            }
            f(unitGroupInfo);
            b(aTBaseAdAdapter.getTrackingInfo(), aTBaseAdAdapter);
            if (com.anythink.core.common.u.o.e(unitGroupInfo.k()) == 0) {
                this.i.c(SystemClock.elapsedRealtime());
            } else {
                this.i.b(SystemClock.elapsedRealtime());
            }
            aVar = this.W;
            if (aVar != null) {
                fVar = this.Z;
                if (fVar != null) {
                    this.Z.e().a(this.g, aTBaseAdAdapter, list, aj.c(unitGroupInfo), this.e.p());
                }
            } else {
                mgComparedResultA = aVar.a();
                z = false;
                if (mgComparedResultA == null && mgComparedResultA.isMgWin()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (mgComparedResultA.getMgAdInfo() != null) {
                        uSDEcpm = mgComparedResultA.getMgAdInfo().getUSDEcpm();
                    } else {
                        uSDEcpm = 0.0d;
                    }
                    if (uSDEcpm > 0.0d && com.anythink.core.common.u.o.a(unitGroupInfo) < uSDEcpm) {
                        z = true;
                    }
                }
                if (z) {
                    adVarY = unitGroupInfo.Y();
                    if (unitGroupInfo.w() && adVarY != null) {
                        com.anythink.core.c.d.c.a(adVarY, new ay(2, unitGroupInfo, trackingInfo), true, 35);
                    }
                    com.anythink.core.common.t.f.b(trackingInfo, "1");
                } else {
                    fVar = this.Z;
                    if (fVar != null && fVar.e() != null) {
                        this.Z.e().a(this.g, aTBaseAdAdapter, list, aj.c(unitGroupInfo), this.e.p());
                    }
                }
            }
            com.anythink.core.common.t.e.a(this.a);
            com.anythink.core.common.t.e.a(2, trackingInfo);
            aa.a(trackingInfo, com.anythink.core.common.d.i.s.b, com.anythink.core.common.d.i.s.m, "");
            a(eVarRemove);
            return;
        }
        eVarRemove = this.D.remove(str);
        if (eVarRemove == null) {
            return;
        }
        trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        b(unitGroupInfo);
        u();
        if (list != null) {
            baseAdArr = null;
        } else {
            baseAdArr = null;
        }
        a(eVarRemove, aTBaseAdAdapter, unitGroupInfo, trackingInfo, false, baseAdArr);
        if (unitGroupInfo.O() != -1) {
            com.anythink.core.common.t.f.a(trackingInfo);
        }
        f(unitGroupInfo);
        b(aTBaseAdAdapter.getTrackingInfo(), aTBaseAdAdapter);
        if (com.anythink.core.common.u.o.e(unitGroupInfo.k()) == 0) {
            this.i.c(SystemClock.elapsedRealtime());
        } else {
            this.i.b(SystemClock.elapsedRealtime());
        }
        aVar = this.W;
        if (aVar != null) {
            fVar = this.Z;
            if (fVar != null) {
                this.Z.e().a(this.g, aTBaseAdAdapter, list, aj.c(unitGroupInfo), this.e.p());
            }
        } else {
            mgComparedResultA = aVar.a();
            z = false;
            if (mgComparedResultA == null) {
                z2 = false;
            } else {
                z2 = false;
            }
            if (z2) {
                if (mgComparedResultA.getMgAdInfo() != null) {
                    uSDEcpm = mgComparedResultA.getMgAdInfo().getUSDEcpm();
                } else {
                    uSDEcpm = 0.0d;
                }
                if (uSDEcpm > 0.0d) {
                    z = true;
                }
            }
            if (z) {
                adVarY = unitGroupInfo.Y();
                if (unitGroupInfo.w()) {
                    com.anythink.core.c.d.c.a(adVarY, new ay(2, unitGroupInfo, trackingInfo), true, 35);
                }
                com.anythink.core.common.t.f.b(trackingInfo, "1");
            } else {
                fVar = this.Z;
                if (fVar != null) {
                    this.Z.e().a(this.g, aTBaseAdAdapter, list, aj.c(unitGroupInfo), this.e.p());
                }
            }
        }
        com.anythink.core.common.t.e.a(this.a);
        com.anythink.core.common.t.e.a(2, trackingInfo);
        aa.a(trackingInfo, com.anythink.core.common.d.i.s.b, com.anythink.core.common.d.i.s.m, "");
        a(eVarRemove);
        return;
        throw th;
    }

    private synchronized void f(by byVar) {
        if (this.H.b()) {
            return;
        }
        if (this.i.al()) {
            return;
        }
        com.anythink.core.common.v.g.i(byVar);
    }

    private synchronized void a(by byVar, com.anythink.core.common.h.n nVar) {
        com.anythink.core.common.v.g.d(byVar, nVar);
    }

    private synchronized void r() {
        final ad adVarY;
        if (!this.H.g() && this.H.e()) {
            if (this.H.b()) {
                return;
            }
            if (this.i.al()) {
                return;
            }
            final by byVarB = this.I.b(this.m);
            if (byVarB != null && (adVarY = byVarB.Y()) != null) {
                this.H.h();
                com.anythink.core.mg.a.a aVar = this.W;
                if (aVar != null) {
                    MgComparedResult mgComparedResultA = aVar.a();
                    if (mgComparedResultA == null) {
                        this.W.a(new com.anythink.core.mg.a.b() { // from class: com.anythink.core.common.g.7
                            @Override // com.anythink.core.mg.a.b
                            public final void a(MgComparedResult mgComparedResult) {
                                g.b(adVarY, byVarB, mgComparedResult);
                            }
                        });
                        return;
                    } else {
                        b(adVarY, byVarB, mgComparedResultA);
                        return;
                    }
                }
                b(adVarY, byVarB, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public static void b(ad adVar, by byVar, MgComparedResult mgComparedResult) {
        int i;
        if (mgComparedResult == null) {
            i = 2;
        } else if (mgComparedResult.isMgWin()) {
            i = 0;
        } else if (mgComparedResult.isCompared()) {
            i = 34;
        } else {
            i = 2;
        }
        if (i > 0) {
            com.anythink.core.c.d.c.a(adVar, byVar, i);
        }
    }

    private synchronized void s() {
        if (this.H.e()) {
            if (this.H.b()) {
                return;
            }
            this.I.a(this.i.ah());
        }
    }

    private void a(com.anythink.core.common.v.e eVar, ATBaseAdAdapter aTBaseAdAdapter, by byVar, com.anythink.core.common.h.n nVar, boolean z, BaseAd... baseAdArr) {
        Map<String, Object> internalNetworkInfoMap;
        ac acVarB;
        BaseAd baseAd;
        Map<String, Object> internalNetworkInfoMap2;
        BaseAd baseAd2;
        try {
            if (nVar.i() == null || nVar.i().isEmpty()) {
                if (baseAdArr != null && baseAdArr.length > 0 && (baseAd2 = baseAdArr[0]) != null) {
                    internalNetworkInfoMap2 = baseAd2.getNetworkInfoMap();
                } else {
                    internalNetworkInfoMap2 = aTBaseAdAdapter.getInternalNetworkInfoMap();
                }
                nVar.a(internalNetworkInfoMap2);
            }
        } catch (Exception unused) {
        }
        nVar.m(aj.a(byVar, aTBaseAdAdapter));
        double dA = eVar.e() != 2 ? com.anythink.core.common.u.o.a(byVar) : 0.0d;
        a(byVar, dA, z);
        com.anythink.core.c.d.c.a(aTBaseAdAdapter, byVar, nVar, baseAdArr);
        this.I.h(byVar);
        double d = this.R;
        if (d <= 0.0d) {
            nVar.v = 0;
        } else if (d < dA) {
            nVar.v = 2;
        } else {
            nVar.v = 1;
        }
        com.anythink.core.common.v.g.a(this.Z, this.g, this.f, byVar, null);
        if (byVar == null || byVar.n() != 22) {
            return;
        }
        if (baseAdArr != null && baseAdArr.length > 0 && (baseAd = baseAdArr[0]) != null) {
            internalNetworkInfoMap = baseAd.getNetworkInfoMap();
        } else {
            internalNetworkInfoMap = aTBaseAdAdapter.getInternalNetworkInfoMap();
        }
        if (internalNetworkInfoMap == null || (acVarB = this.I.b()) == null) {
            return;
        }
        acVarB.a(byVar.G(), internalNetworkInfoMap);
    }

    private void a(com.anythink.core.common.v.e eVar) {
        boolean zD = eVar.d();
        if (zD) {
            this.I.a(-1, eVar.e());
        }
        b(eVar);
        c(eVar);
        if (this.J != null && this.I.b().b() != this.J.d() && com.anythink.core.common.u.k.a(this.y, this.J.d()) <= 0) {
            this.J.c();
        }
        if (!zD) {
            m();
            return;
        }
        this.I.a(eVar.e());
        a(this.I.b(eVar.e()), eVar.e());
        m();
    }

    private void b(com.anythink.core.common.v.e eVar) {
        if (eVar.c() == null || !eVar.c().booleanValue() || eVar.e() == 2 || !eVar.c().booleanValue()) {
            return;
        }
        this.x++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(com.anythink.core.common.v.e eVar) {
        boolean z;
        by byVarT = t();
        if (this.z) {
            if (((this.m || this.r) && com.anythink.core.common.u.k.a(this.y, byVarT) <= 0) || this.s) {
                if (!this.o) {
                    a(-1, this.y);
                } else {
                    d(eVar);
                }
                w();
            }
        } else if (this.m) {
            if (this.U) {
                return;
            }
            if (this.G == null || !B()) {
                z = false;
            } else {
                com.anythink.core.common.s.c.a().a(this.G);
                this.G.run();
                this.G = null;
                z = true;
            }
            if (z) {
                return;
            }
            if (A() && !this.o) {
                z();
            }
        }
    }

    private synchronized void d(com.anythink.core.common.v.e eVar) {
        by byVar;
        ATRequestingInfo aTRequestingInfoE;
        if (this.S) {
            as asVar = this.j;
            if (asVar != null) {
                asVar.f = null;
            }
            return;
        }
        as asVar2 = this.j;
        if (asVar2 != null && asVar2.f != null) {
            boolean z = true;
            if (this.B == null) {
                byVar = this.y;
            } else if (eVar == null || eVar.f() == null || eVar.c() == null) {
                z = false;
                byVar = null;
            } else {
                by byVarF = eVar.f();
                if (com.anythink.core.common.u.k.a(byVarF, this.B) >= 0 || !eVar.c().booleanValue()) {
                    z = false;
                }
                byVar = byVarF;
            }
            if (z) {
                this.B = byVar;
                aTRequestingInfoE = this.I.e(byVar, this.i);
                if (aTRequestingInfoE != null) {
                    this.j.f.onAdMultipleLoaded(aTRequestingInfoE);
                }
            } else {
                aTRequestingInfoE = null;
            }
            if (aTRequestingInfoE == null && this.I.a(this.m, this.B)) {
                this.j.f.onAdMultipleLoaded(null);
                this.j.f = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public by t() {
        by byVarA;
        if (this.e.j() == 2) {
            synchronized (this.D) {
                byVarA = com.anythink.core.common.v.g.a(this.D);
            }
        } else {
            byVarA = null;
        }
        by byVarU = this.I.u();
        return com.anythink.core.common.u.k.a(byVarA, byVarU) < 0 ? byVarA : byVarU;
    }

    final synchronized boolean c() {
        return this.o;
    }

    final synchronized int a(by byVar) {
        if (byVar != null) {
            byVar.G();
        }
        if (this.o) {
            return 1;
        }
        if (this.z && com.anythink.core.common.u.k.a(this.y, byVar) < 0) {
            by byVar2 = this.y;
            if (byVar2 != null) {
                byVar2.G();
            }
            return 2;
        }
        by byVarT = t();
        return (byVarT == null || com.anythink.core.common.u.k.a(byVarT, byVar) >= 0) ? 4 : 3;
    }

    private synchronized void u() {
        this.I.h();
        if (this.G != null) {
            com.anythink.core.common.s.c.a().a(this.G);
            this.G = null;
        }
    }

    public final void a(final int i, by byVar) {
        boolean z;
        u();
        if (this.F != null) {
            com.anythink.core.common.s.c.a().a(this.F);
            this.F = null;
        }
        com.anythink.core.common.a.c.a aVar = this.J;
        if (aVar != null && ((aVar.d() == this.I.b().b() || com.anythink.core.common.u.k.a(this.J.d(), this.y) < 0) && this.J.b())) {
            a(this.J.d(), com.anythink.core.common.u.o.a(this.J.d()), true);
            i = this.J.d().bz() ? 13 : 11;
        }
        by byVar2 = this.y;
        if (byVar2 != null && byVar2.bz()) {
            i = 13;
        }
        if (i != 5 && i != 13) {
            switch (i) {
                case 9:
                case 10:
                case 11:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
        } else {
            z = true;
        }
        this.o = true;
        this.n = true;
        if (this.L != null) {
            com.anythink.core.common.s.c.a().a(this.L);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.v;
        final com.anythink.core.common.h.n nVarAh = this.i.ah();
        nVarAh.b(true);
        nVarAh.s(j);
        nVarAh.m(jElapsedRealtime);
        if (this.A) {
            nVarAh.b(2);
        } else {
            nVarAh.b(1);
        }
        if (z) {
            nVarAh.L(i);
        }
        if (byVar != null) {
            nVarAh.a(byVar);
        }
        com.anythink.core.mg.a.a aVar2 = this.W;
        if (aVar2 != null) {
            aVar2.a(new com.anythink.core.mg.a.b() { // from class: com.anythink.core.common.g.8
                @Override // com.anythink.core.mg.a.b
                public final void a(MgComparedResult mgComparedResult) {
                    int i2;
                    if (mgComparedResult != null) {
                        i2 = mgComparedResult.isCpTimeout() ? 3 : 2;
                    } else {
                        i2 = 0;
                    }
                    com.anythink.core.common.t.f.b(nVarAh, i2);
                    if (mgComparedResult != null && mgComparedResult.isMgWin()) {
                        if (g.this.Z != null) {
                            g.this.Z.a(-1, 2);
                        }
                        g.this.u = ErrorCode.getErrorCode(ErrorCode.compareFailedError, "", "");
                        by byVarT = g.this.t();
                        MgComparedResult mgComparedResultA = g.this.W.a();
                        if (com.anythink.core.common.u.o.a(byVarT) <= ((mgComparedResultA == null || mgComparedResultA.getMgAdInfo() == null) ? 0.0d : mgComparedResultA.getMgAdInfo().getUSDEcpm())) {
                            byVarT = null;
                        }
                        g.this.g(byVarT);
                        return;
                    }
                    com.anythink.core.common.t.e.a(g.this.a);
                    com.anythink.core.common.t.e.a(12, nVarAh);
                    g.a(g.this, i);
                }
            });
            this.W.a(this.j, this.T);
        } else {
            this.u = ErrorCode.getErrorCode(ErrorCode.noADError, "", "The MgComparePriceHandler can not be null.");
            g((by) null);
        }
    }

    private void d(int i) {
        com.anythink.core.e.l lVarA;
        v();
        if (this.S) {
            return;
        }
        aa.a("Mediation", "placementId:" + this.g + ";result_callback:success;loadType:" + this.j.c + ";");
        u.a(this.a).a(this.g, this.f, true);
        as asVar = this.j;
        if (asVar != null && asVar.e != null) {
            boolean z = false;
            try {
                ce ceVar = this.e;
                if (ceVar != null && (lVarA = ceVar.a()) != null) {
                    try {
                        if (this.Z != null) {
                            f.a(lVarA, this.i);
                            f.b(lVarA, this.i);
                        }
                    } catch (com.anythink.core.common.h.m e) {
                        this.j.e.a(1, this.j, this.e, e.a);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!z) {
                d((com.anythink.core.common.v.e) null);
                this.j.e.a(this.A ? 1 : 2, this.j, this.e, i);
            }
            this.j.e = null;
        }
        com.anythink.core.d.b.a().a(this.g, this.f, this.e.a().ax(), this.j, this.I.b().b());
    }

    private synchronized boolean v() {
        if (this.I.j()) {
            return false;
        }
        if (this.H.c()) {
            return false;
        }
        by byVar = this.y;
        if (byVar != null && byVar.bz()) {
            return false;
        }
        this.H.f();
        this.U = true;
        List<by> listK = this.I.k();
        this.I.b(listK);
        a(8, listK, new j.a() { // from class: com.anythink.core.common.g.9
            @Override // com.anythink.core.common.j.a
            public final void a(Double d) {
            }

            @Override // com.anythink.core.common.j.a
            public final void a(String str) {
            }

            @Override // com.anythink.core.common.j.a
            public final void a(String str, List<by> list, List<by> list2, boolean z) {
                for (by byVar2 : list) {
                    g.this.e(byVar2);
                    byVar2.G(8);
                    g.this.I.a(byVar2);
                    g.this.b(byVar2, 3);
                }
                if (list2 != null) {
                    Iterator<by> it = list2.iterator();
                    while (it.hasNext()) {
                        g.this.c(it.next());
                    }
                }
                g.this.U = false;
                g.this.c((com.anythink.core.common.v.e) null);
            }
        });
        return true;
    }

    private synchronized void w() {
        if (this.m) {
            if (this.H.c()) {
                return;
            }
            by byVar = this.y;
            if (byVar == null || !byVar.bz()) {
                List<by> list = this.E;
                if (list != null && list.size() != 0) {
                    if (this.q) {
                        return;
                    }
                    this.q = true;
                    a(7, this.E, new j.a() { // from class: com.anythink.core.common.g.10
                        @Override // com.anythink.core.common.j.a
                        public final void a(Double d) {
                        }

                        @Override // com.anythink.core.common.j.a
                        public final void a(String str) {
                        }

                        @Override // com.anythink.core.common.j.a
                        public final void a(String str, List<by> list2, List<by> list3, boolean z) {
                            if (g.this.H.c()) {
                                for (by byVar2 : list2) {
                                    g.this.I.e(byVar2);
                                    com.anythink.core.common.v.g.c(byVar2, g.this.i);
                                }
                                return;
                            }
                            if (g.this.x < g.this.e.g()) {
                                g.this.a(list2, (List<by>) null, (List<by>) null, list3);
                                g.this.m();
                                return;
                            }
                            by byVarA = g.this.I.a(false);
                            int size = list2.size();
                            ArrayList<by> arrayList = new ArrayList(size);
                            ArrayList arrayList2 = new ArrayList(size);
                            for (int i = 0; i < size; i++) {
                                by byVar3 = list2.get(i);
                                g.this.I.e(byVar3);
                                if (com.anythink.core.common.u.k.a(byVar3, byVarA) < 0) {
                                    arrayList.add(byVar3);
                                } else {
                                    arrayList2.add(byVar3);
                                }
                            }
                            for (by byVar4 : arrayList) {
                                g.this.e(byVar4);
                                byVar4.G(7);
                                g.this.I.a(byVar4);
                                g.this.b(byVar4, 5);
                            }
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                com.anythink.core.common.v.g.c((by) it.next(), g.this.i);
                            }
                        }
                    });
                }
            }
        }
    }

    private void a(int i, List<by> list, final j.a aVar) {
        boolean z = this.M != null || aj.a(this.E);
        com.anythink.core.common.h.a aVar2 = new com.anythink.core.common.h.a();
        aVar2.b = this.a;
        aVar2.c = this.j;
        aVar2.d = this.f;
        aVar2.e = this.g;
        aVar2.f = this.e.a().ap();
        aVar2.g = this.e.k();
        aVar2.h = this.e.l();
        i.a();
        aVar2.l = i.a(this.e.a(), z);
        i.a();
        aVar2.o = i.a(this.e.a());
        i.a();
        aVar2.p = i.b(this.e.a());
        aVar2.j = list;
        aVar2.n = this.e;
        aVar2.s = this.i;
        aVar2.q = this.h;
        aVar2.v = this.I.o();
        aVar2.w = this.I.p();
        aVar2.x = this.I.q();
        aVar2.m = z;
        aVar2.t = i;
        aVar2.u = this.I.a(list, this.T);
        aVar2.y = this.I.a();
        aVar2.J = this.Z;
        com.anythink.core.c.b bVar = new com.anythink.core.c.b(aVar2);
        bVar.a(ATSDK.isNetworkLogDebug());
        bVar.a(new j.a() { // from class: com.anythink.core.common.g.2
            @Override // com.anythink.core.common.j.a
            public final void a(String str, List<by> list2, List<by> list3, boolean z2) {
                j.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(str, list2, list3, z2);
                }
            }

            @Override // com.anythink.core.common.j.a
            public final void a(String str) {
                j.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(str);
                }
            }

            @Override // com.anythink.core.common.j.a
            public final void a(Double d) {
                j.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(d);
                }
            }
        });
    }

    protected final synchronized void a(String str, com.anythink.core.common.v.b bVar) {
        com.anythink.core.common.h.n nVar = bVar.f;
        by byVar = bVar.g;
        AdError adError = bVar.d;
        long j = bVar.e;
        int i = bVar.h;
        String strN = nVar.N();
        com.anythink.core.common.v.e eVarRemove = this.D.remove(str);
        if (eVarRemove == null) {
            return;
        }
        b(byVar);
        this.u.putNetworkErrorMsg(strN, nVar.Z(), nVar.aN(), adError);
        if (i == 0) {
            com.anythink.core.common.t.f.a(nVar, bVar.c, adError, j);
        } else {
            StringBuilder sbAppend = new StringBuilder("requestId=").append(this.f).append(", networkFirmId=").append(nVar.Z()).append(", adSourceId=").append(nVar.N()).append(", format=").append(nVar.aS());
            ad adVarY = byVar.Y();
            if (adVarY != null) {
                sbAppend.append(", hasShow=").append(adVarY.o()).append(", bidId=").append(adVarY.token).append(", tpBidId=").append(adVarY.g);
            }
            com.anythink.core.common.t.f.b("unexpected request failed", sbAppend.toString(), com.anythink.core.common.d.s.b().r());
        }
        if (j > 0) {
            com.anythink.core.common.d.c cVar = this.k;
            if (cVar != null) {
                cVar.onAdSourceLoadFail(nVar, adError);
            }
            a(nVar, adError, com.anythink.core.common.v.a.a.b.c, byVar);
        }
        aa.a(nVar, com.anythink.core.common.d.i.s.b, com.anythink.core.common.d.i.s.n, adError.printStackTrace());
        a(byVar, this.i);
        a(eVarRemove);
    }

    private boolean x() {
        if (this.G == null || !B()) {
            return false;
        }
        com.anythink.core.common.s.c.a().a(this.G);
        this.G.run();
        this.G = null;
        return true;
    }

    private void y() {
        g((by) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(by byVar) {
        this.o = true;
        this.n = false;
        if (this.L != null) {
            com.anythink.core.common.s.c.a().a(this.L);
        }
        com.anythink.core.common.t.f.a(this.i.ah(), this.u, byVar);
        if (!this.S) {
            a(this.u);
        }
        g();
    }

    private void z() {
        com.anythink.core.common.h.c cVarD = D();
        if (cVarD != null) {
            by unitGroupInfo = cVarD.e() != null ? cVarD.e().getUnitGroupInfo() : null;
            a(unitGroupInfo, com.anythink.core.common.u.o.a(unitGroupInfo), true);
            a(9, unitGroupInfo);
            return;
        }
        g((by) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str) {
        if (this.H.b()) {
            return;
        }
        a(this.D.get(str));
    }

    private synchronized boolean A() {
        return this.I.s();
    }

    private synchronized boolean B() {
        return this.I.c() == 0 && this.I.d() == 0;
    }

    private void b(long j) {
        com.anythink.core.common.s.c.a().a(this.L, j);
    }

    public final boolean d() {
        if (this.o) {
            return true;
        }
        return this.m && this.I.c() == 0 && this.I.l() == 0;
    }

    public final synchronized void a(double d, by byVar) {
        E();
        if (!this.H.g() && byVar != null && byVar.w()) {
            this.H.h();
        }
        if (d > this.R) {
            this.R = d;
        }
        int iAp = this.e.a().ap();
        if (iAp == 0 || iAp == 2) {
            return;
        }
        this.H.d();
        f fVar = this.Z;
        if (fVar != null) {
            fVar.a(this.f);
        } else {
            com.anythink.core.common.t.f.b("AdManage is null--notifyimpression", "Id:" + this.g + "--format:" + this.e.a().ap(), com.anythink.core.common.d.s.b().r());
        }
        if (!this.o) {
            a(10, byVar);
        }
        m();
    }

    public final void e() {
        this.r = true;
        c((com.anythink.core.common.v.e) null);
    }

    public final synchronized void f() {
        this.m = true;
        this.r = true;
        c((com.anythink.core.common.v.e) null);
        m();
    }

    public final void g() {
        this.S = true;
        f fVar = this.Z;
        if (fVar != null) {
            fVar.a(this.f);
        } else {
            com.anythink.core.common.t.f.b("AdManage is null--notifycancel", "Id:" + this.g + "--format:" + this.e.a().ap(), com.anythink.core.common.d.s.b().r());
        }
    }

    private void C() {
        if (this.L != null) {
            com.anythink.core.common.s.c.a().a(this.L);
        }
    }

    public final void a(ATBaseAdAdapter aTBaseAdAdapter, String str) {
        if (aTBaseAdAdapter != null) {
            str.hashCode();
            switch (str) {
                case "0":
                    aTBaseAdAdapter.setRequestNum(aTBaseAdAdapter.getUnitGroupInfo().E());
                    break;
                case "4":
                    aTBaseAdAdapter.setFetchAdTimeout(this.j.h);
                    break;
                case "50":
                    if (this.j.d instanceof com.anythink.core.common.d.d) {
                        ((com.anythink.core.common.d.d) this.j.d).onPrepareAdapterLoad(aTBaseAdAdapter);
                        break;
                    }
                    break;
            }
        }
    }

    private void e(int i) {
        com.anythink.core.e.l lVarA;
        aa.a("Mediation", "placementId:" + this.g + ";result_callback:success;loadType:" + this.j.c + ";");
        u.a(this.a).a(this.g, this.f, true);
        as asVar = this.j;
        if (asVar != null && asVar.e != null) {
            boolean z = false;
            try {
                ce ceVar = this.e;
                if (ceVar != null && (lVarA = ceVar.a()) != null) {
                    try {
                        if (this.Z != null) {
                            f.a(lVarA, this.i);
                            f.b(lVarA, this.i);
                        }
                    } catch (com.anythink.core.common.h.m e) {
                        this.j.e.a(1, this.j, this.e, e.a);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!z) {
                d((com.anythink.core.common.v.e) null);
                this.j.e.a(this.A ? 1 : 2, this.j, this.e, i);
            }
            this.j.e = null;
        }
        com.anythink.core.d.b.a().a(this.g, this.f, this.e.a().ax(), this.j, this.I.b().b());
    }

    private void a(AdError adError) {
        aa.a("Mediation", "placementId:" + this.g + ";result_callback:fail;loadType:" + this.j.c + ";");
        u.a(this.a).a(this.g, this.f, false);
        as asVar = this.j;
        if (asVar == null || asVar.e == null) {
            return;
        }
        this.j.e.a(2, this.j, this.e, adError);
        this.j.e = null;
    }

    public final void h() {
        List<com.anythink.core.common.v.f> listI = this.I.i();
        synchronized (listI) {
            if (listI.size() > 0) {
                by byVarA = listI.remove(0).a();
                if (!this.o || this.x < this.e.g() || com.anythink.core.common.u.k.a(byVarA, this.y) < 0) {
                    this.I.a(byVarA);
                    b(byVarA, 4);
                }
            }
            if (listI.size() > 0) {
                for (com.anythink.core.common.v.f fVar : listI) {
                    by byVarA2 = fVar.a();
                    if (!this.o || this.x < this.e.g() || com.anythink.core.common.u.k.a(byVarA2, this.y) < 0) {
                        int iB = fVar.b();
                        if (iB == 1) {
                            a(byVarA2, 1);
                            c(iB);
                        } else if (iB == 2) {
                            a(byVarA2, 2);
                            c(iB);
                        } else if (iB == 3) {
                            this.I.a(byVarA2);
                            b(byVarA2, 3);
                        }
                    }
                }
            }
            listI.clear();
        }
        m();
    }

    private void h(by byVar) {
        if (byVar != null && com.anythink.core.common.v.g.j(byVar) > com.anythink.core.common.u.o.a(this.T)) {
            this.T = byVar;
        }
    }

    private com.anythink.core.common.h.c D() {
        com.anythink.core.common.a.c.a aVar;
        f fVar = this.Z;
        com.anythink.core.common.h.c cVarA = (fVar == null || fVar.e() == null) ? null : this.Z.e().a(this.a, this.g);
        return (cVarA == null && (aVar = this.J) != null) ? aVar.a() : cVarA;
    }

    public final com.anythink.core.common.a.c.a i() {
        return this.J;
    }

    private void a(by byVar, double d, boolean z) {
        if (byVar == null) {
            return;
        }
        this.z = true;
        h(byVar);
        if (d == 0.0d) {
            if (this.y == null && (!z || !this.A)) {
                this.A = !z;
            }
        } else if (com.anythink.core.common.u.k.a(byVar, this.y) < 0) {
            this.y = byVar;
            if (!z || !this.A) {
                this.A = !z;
            }
        }
        by byVar2 = this.C;
        if (byVar2 == null || com.anythink.core.common.u.k.a(byVar2, byVar) < 0) {
            this.C = byVar;
        }
        boolean zG = this.I.g(byVar);
        if (this.o && this.n && zG) {
            com.anythink.core.d.b.a().a(this.g, this.f, this.e.a().ax(), this.j, this.I.b().b());
        }
    }

    public final com.anythink.core.e.l j() {
        return this.e.a();
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter == null) {
            return;
        }
        synchronized (this.K) {
            if (aTBaseAdAdapter != null) {
                this.K.add(aTBaseAdAdapter);
            }
        }
    }

    private void b(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter == null) {
            return;
        }
        synchronized (this.K) {
            if (aTBaseAdAdapter != null) {
                this.K.remove(aTBaseAdAdapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.K.size() == 0) {
            return;
        }
        synchronized (this.K) {
            Iterator<ATBaseAdAdapter> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().destory();
            }
            this.K.clear();
        }
    }

    private synchronized void F() {
        if (this.I.t()) {
            List<by> listB = this.I.b(1);
            if (listB.size() > 0) {
                a(listB, 1);
            }
        }
    }

    private String a(com.anythink.core.common.h.n nVar, by byVar) {
        StringBuilder sbAppend = new StringBuilder("requestId=").append(this.f).append(", networkFirmId=").append(nVar.Z()).append(", adSourceId=").append(nVar.N()).append(", format=").append(nVar.aS());
        ad adVarY = byVar.Y();
        if (adVarY != null) {
            sbAppend.append(", hasShow=").append(adVarY.o()).append(", bidId=").append(adVarY.token).append(", tpBidId=").append(adVarY.g);
        }
        return sbAppend.toString();
    }

    static /* synthetic */ void a(g gVar, com.anythink.core.common.v.e eVar, com.anythink.core.common.h.n nVar, by byVar) {
        com.anythink.core.common.v.d dVar = new com.anythink.core.common.v.d();
        dVar.a = gVar.a;
        dVar.b = gVar.b;
        dVar.c = gVar.f;
        dVar.d = gVar.g;
        dVar.e = gVar.e.a();
        dVar.f = gVar.h;
        dVar.g = gVar.w;
        dVar.h = nVar;
        dVar.i = gVar.I.q();
        eVar.a(dVar);
        eVar.a(gVar.new AnonymousClass6(byVar));
        eVar.a(gVar.C);
    }

    static /* synthetic */ void a(g gVar, com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        com.anythink.core.common.d.c cVar = gVar.k;
        if (cVar != null) {
            cVar.onAdSourceAttempt(nVar);
        }
        if (aTBaseAdAdapter != null) {
            gVar.a(nVar, (AdError) null, com.anythink.core.common.v.a.a.b.a, aTBaseAdAdapter.getUnitGroupInfo());
        }
        if (aTBaseAdAdapter != null) {
            com.anythink.core.common.u.d.a().a(nVar, aTBaseAdAdapter.getUnitGroupInfo(), 3);
        }
    }

    static /* synthetic */ void a(g gVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            synchronized (gVar.K) {
                if (aTBaseAdAdapter != null) {
                    gVar.K.add(aTBaseAdAdapter);
                }
            }
        }
    }

    static /* synthetic */ void b(g gVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            synchronized (gVar.K) {
                if (aTBaseAdAdapter != null) {
                    gVar.K.remove(aTBaseAdAdapter);
                }
            }
        }
    }

    static /* synthetic */ void a(g gVar, int i) {
        com.anythink.core.e.l lVarA;
        gVar.v();
        if (gVar.S) {
            return;
        }
        aa.a("Mediation", "placementId:" + gVar.g + ";result_callback:success;loadType:" + gVar.j.c + ";");
        u.a(gVar.a).a(gVar.g, gVar.f, true);
        as asVar = gVar.j;
        if (asVar != null && asVar.e != null) {
            boolean z = false;
            try {
                ce ceVar = gVar.e;
                if (ceVar != null && (lVarA = ceVar.a()) != null) {
                    try {
                        if (gVar.Z != null) {
                            f.a(lVarA, gVar.i);
                            f.b(lVarA, gVar.i);
                        }
                    } catch (com.anythink.core.common.h.m e) {
                        gVar.j.e.a(1, gVar.j, gVar.e, e.a);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!z) {
                gVar.d((com.anythink.core.common.v.e) null);
                gVar.j.e.a(gVar.A ? 1 : 2, gVar.j, gVar.e, i);
            }
            gVar.j.e = null;
        }
        com.anythink.core.d.b.a().a(gVar.g, gVar.f, gVar.e.a().ax(), gVar.j, gVar.I.b().b());
    }
}
