package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IATAdFilter;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.al;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.cb;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.ak;
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
    boolean A;
    protected com.anythink.core.common.t.b G;
    com.anythink.core.common.w.g I;
    com.anythink.core.common.a.c.a J;
    bv M;
    double N;
    bv P;
    private h T;
    protected WeakReference<Context> b;
    protected int c;
    protected cb e;
    protected String f;
    protected String g;
    Map<String, Object> h;
    com.anythink.core.common.h.n i;
    protected ar j;
    protected com.anythink.core.common.d.c k;
    boolean o;
    boolean p;
    String s;
    long u;
    int v;
    int w;
    private final String R = getClass().getSimpleName();
    protected String d = "";
    boolean l = false;
    boolean m = false;
    protected boolean n = false;
    boolean q = false;
    boolean r = false;
    Object x = new Object();
    bv y = null;
    boolean z = false;
    bv B = null;
    bv C = null;
    protected com.anythink.core.common.t.b F = null;
    protected com.anythink.core.common.t.b L = new com.anythink.core.common.t.b() { // from class: com.anythink.core.common.g.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.g.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.a();
                }
            });
        }
    };
    boolean O = false;
    boolean Q = false;
    protected Context a = com.anythink.core.common.d.t.b().g();
    AdError t = ErrorCode.getErrorCode(ErrorCode.noADError, "", "");
    protected Map<String, com.anythink.core.common.w.e> D = new ConcurrentHashMap();
    List<bv> E = Collections.synchronizedList(new ArrayList(3));
    com.anythink.core.common.w.j H = new com.anythink.core.common.w.j();
    List<ATBaseAdAdapter> K = new ArrayList();
    private final com.anythink.core.mg.a.a S = new com.anythink.core.mg.a.a();

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
    public synchronized void j() {
        com.anythink.core.common.h.c cVarC = C();
        this.r = true;
        if (this.n || cVarC == null) {
            return;
        }
        bv unitGroupInfo = cVarC.e() != null ? cVarC.e().getUnitGroupInfo() : null;
        a(unitGroupInfo, com.anythink.core.common.v.p.a(unitGroupInfo), true);
        a(9, unitGroupInfo);
    }

    protected final synchronized void a() {
        ConcurrentHashMap concurrentHashMap;
        this.H.a();
        synchronized (this.D) {
            concurrentHashMap = new ConcurrentHashMap(this.D);
        }
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            com.anythink.core.common.w.e eVar = (com.anythink.core.common.w.e) ((Map.Entry) it.next()).getValue();
            if (eVar != null) {
                eVar.b();
            }
        }
        if (!this.n) {
            this.n = true;
            y();
        }
        l();
    }

    public g(Context context) {
        this.b = new WeakReference<>(context);
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

    public final void a(ar arVar) {
        this.j = arVar;
    }

    private synchronized void k() {
        if (this.o) {
            this.I.b(this.i);
        }
    }

    private synchronized void a(List<bv> list, int i) {
        if (!this.H.b() && !this.H.c() && list != null && list.size() != 0) {
            this.I.a(list);
            this.I.d();
            Iterator<bv> it = list.iterator();
            while (it.hasNext()) {
                b(it.next(), i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        bv bvVarA = this.I.a(false);
        bv bvVarS = s();
        this.I.m();
        int i = this.w;
        this.e.g();
        com.anythink.core.common.v.l.a(bvVarA, bvVarS);
        this.H.c();
        this.H.b();
        if ((this.l && this.w >= this.e.g() && com.anythink.core.common.v.l.a(bvVarA, bvVarS) <= 0) || this.H.c() || this.H.b()) {
            this.o = true;
            k();
            if (this.I.m() == 0) {
                com.anythink.core.common.w.g.a(this.a, this.g);
                com.anythink.core.common.w.g.a(this.g);
                r();
            }
        }
        q();
        if (this.o || z()) {
            r();
        }
    }

    private synchronized void a(bv bvVar, int i) {
        this.I.b(bvVar, i);
    }

    private synchronized void c(int i) {
        int iO;
        try {
            if (i == 2) {
                iO = this.I.o();
            } else {
                iO = this.I.n();
            }
            if (iO == 0) {
                a(this.I.b(i), i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void a(bv bvVar) {
        this.I.b(bvVar);
    }

    public final void a(List<bv> list, List<bv> list2, List<bv> list3, List<bv> list4) {
        boolean zA;
        String str;
        synchronized (this.x) {
            if (list2 != null) {
                try {
                    Iterator<bv> it = list2.iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (list4 != null && !list4.isEmpty()) {
                for (bv bvVar : list4) {
                    if (bvVar != null) {
                        try {
                            if (bvVar.g() == 22) {
                                this.I.f(bvVar);
                                com.anythink.core.common.w.g.a(bvVar, this.i);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (list3 != null) {
                this.E.addAll(list3);
            }
            if (list != null && list.size() != 0) {
                this.H.f();
                h hVar = this.T;
                boolean zE = hVar == null ? false : hVar.e();
                h hVar2 = this.T;
                boolean zD = hVar2 == null ? false : hVar2.d();
                if (!this.l && zD && zE) {
                    a(list);
                    return;
                }
                bv bvVar2 = list.get(0);
                boolean zA2 = com.anythink.core.common.w.g.a(bvVar2, this.H);
                new StringBuilder("isStrategyOpen: ").append(zE).append(", isPrepareNormal: ");
                if (zE && !zD) {
                    zA = this.I.a(bvVar2, false);
                    new StringBuilder("isStrategyOpen: ").append(zE).append("canRequest : ");
                } else {
                    zA = this.I.a(bvVar2, true);
                }
                if (zA2 || zA) {
                    new StringBuilder("isAdvanceRequest: ").append(zA2).append(", cutInLine: ");
                    if (this.n) {
                        str = this.m ? "2" : "3";
                    } else {
                        str = "1";
                    }
                    String str2 = str;
                    String str3 = "1";
                    if (zA2) {
                        str3 = "1";
                    } else if (zA) {
                        str3 = "2";
                    }
                    com.anythink.core.common.u.e.a(this.i, bvVar2.g(), bvVar2.z(), com.anythink.core.common.v.p.a(bvVar2), com.anythink.core.common.v.p.b(bvVar2), str2, str3, bvVar2.bt(), bvVar2.bu());
                    if (bvVar2.an()) {
                        this.M = bvVar2;
                    }
                    d(bvVar2);
                    list.remove(0);
                    this.I.a(bvVar2);
                    b(bvVar2, 3);
                }
                a(list);
                E();
            }
        }
    }

    private void a(List<bv> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (bv bvVar : list) {
            d(bvVar);
            a(bvVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bv bvVar) {
        this.t.putNetworkErrorMsg(bvVar.z(), bvVar.g(), bvVar.h(), ErrorCode.getErrorCode(ErrorCode.noADError, "", bvVar.F()));
        this.I.c(bvVar);
    }

    private void c(bv bvVar) {
        if (bvVar != null) {
            try {
                if (bvVar.g() == 22) {
                    this.I.f(bvVar);
                    com.anythink.core.common.w.g.a(bvVar, this.i);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bv bvVar) {
        this.I.d(bvVar);
        com.anythink.core.common.w.g.a(this.a, this.g, this.f, null, bvVar);
        this.I.e(bvVar);
        this.I.c(bvVar);
        g(bvVar);
    }

    protected final void a(com.anythink.core.common.w.h hVar) {
        this.I = new com.anythink.core.common.w.g(hVar);
        this.l = hVar.i;
        this.f = hVar.b;
        this.g = hVar.a;
        this.e = hVar.c;
        this.c = hVar.j;
        this.s = com.anythink.core.common.w.g.c(hVar.d);
    }

    protected final void a(h hVar) {
        this.T = hVar;
        this.u = SystemClock.elapsedRealtime();
        com.anythink.core.common.t.d.a().a(this.L, this.e.h(), false);
        if (this.e.i() >= 0) {
            this.F = new AnonymousClass3();
            this.e.i();
            com.anythink.core.common.t.d.a().a(this.F, this.e.i(), false);
        }
    }

    protected final void b() {
        long jA = this.I.a(this.l, this.e.a().K());
        if (jA > -1) {
            this.G = new AnonymousClass4();
        }
        if (this.I.g() && this.l) {
            u();
        }
        a(this.I.s(), 1);
        if (this.G != null) {
            com.anythink.core.common.t.d.a().a(this.G, jA, false);
        }
        if (this.J != null) {
            com.anythink.core.common.h.n nVarAf = this.i.af();
            aj.a(nVarAf, this.J.d(), 0, true);
            this.J.a(this.f, nVarAf);
        }
    }

    private void m() {
        if (this.J != null) {
            com.anythink.core.common.h.n nVarAf = this.i.af();
            aj.a(nVarAf, this.J.d(), 0, true);
            this.J.a(this.f, nVarAf);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.g$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.core.common.t.b {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.this.F = null;
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.g.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.j();
                }
            }, 2);
        }
    }

    private void n() {
        if (this.e.i() >= 0) {
            this.F = new AnonymousClass3();
            this.e.i();
            com.anythink.core.common.t.d.a().a(this.F, this.e.i(), false);
        }
    }

    private void a(long j) {
        if (this.G != null) {
            com.anythink.core.common.t.d.a().a(this.G, j, false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.g$4, reason: invalid class name */
    final class AnonymousClass4 implements com.anythink.core.common.t.b {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.this.p();
        }
    }

    private com.anythink.core.common.t.b o() {
        return new AnonymousClass4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        if (!this.n && this.I.e() > 0) {
            this.G = null;
            bv bvVarF = this.I.f();
            bvVarF.toString();
            this.I.a(bvVarF);
            this.I.e();
            this.I.o();
            b(bvVarF, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final bv bvVar, final int i) {
        final com.anythink.core.common.w.e eVar = new com.anythink.core.common.w.e(bvVar, i);
        final String strA = eVar.a();
        this.D.put(strA, eVar);
        this.I.a(1, i);
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.g.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (g.this) {
                    if (g.this.H.b()) {
                        g.this.D.remove(strA);
                        return;
                    }
                    if (ak.a(bvVar) && TextUtils.isEmpty(u.a().a(g.this.g, bvVar.g()))) {
                        u.a().a(g.this.g, bvVar.g(), bvVar.k());
                    }
                    boolean zA = g.a(i);
                    com.anythink.core.common.h.n nVarAf = g.this.i.af();
                    nVarAf.s(zA ? new StringBuilder().append(bvVar.g()).toString() : g.this.s);
                    aj.a(nVarAf, bvVar, g.this.v, true);
                    nVarAf.o(SystemClock.elapsedRealtime() - g.this.u);
                    if (g.this.a(nVarAf, bvVar, i, strA)) {
                        return;
                    }
                    String unused = g.this.R;
                    bvVar.toString();
                    boolean zA2 = com.anythink.core.common.w.g.a(g.this.g, bvVar, nVarAf);
                    g.this.v++;
                    if (zA2) {
                        com.anythink.core.common.w.b bVar = new com.anythink.core.common.w.b();
                        bVar.c = 6;
                        bVar.d = ErrorCode.getErrorCode(ErrorCode.noADError, "", "Bid result has expired.");
                        bVar.e = 0L;
                        bVar.f = nVarAf;
                        bVar.g = bvVar;
                        g.this.a(strA, bVar);
                        return;
                    }
                    int iAo = bvVar.ao();
                    if (iAo <= 0) {
                        if (g.this.m && g.this.w < g.this.e.g()) {
                            nVarAf.t = 5;
                        }
                    } else {
                        nVarAf.t = iAo;
                    }
                    g.a(g.this, eVar, nVarAf, bvVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(com.anythink.core.common.h.n nVar, bv bvVar, int i, String str) {
        com.anythink.core.common.h.i iVarC = u.a().c(this.g);
        if (iVarC == null || !iVarC.a(bvVar)) {
            return false;
        }
        ab.a(this.g, nVar, "Can't Load On Showing", bvVar, -1, -1);
        com.anythink.core.common.u.e.a(nVar, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
        u.a().a(this.g, iVarC.a(), this.f);
        this.I.a(bvVar, i);
        a(bvVar);
        this.I.a(i);
        this.D.remove(str);
        this.I.a(-1, i);
        a(this.I.b(i), i);
        return true;
    }

    private void a(com.anythink.core.common.w.e eVar, com.anythink.core.common.h.n nVar, bv bvVar) {
        com.anythink.core.common.w.d dVar = new com.anythink.core.common.w.d();
        dVar.a = this.a;
        dVar.b = this.b;
        dVar.c = this.f;
        dVar.d = this.g;
        dVar.e = this.e.a();
        dVar.f = this.h;
        dVar.g = this.v;
        dVar.h = nVar;
        dVar.i = this.I.r();
        eVar.a(dVar);
        eVar.a(new AnonymousClass6(bvVar));
        eVar.a(this.C);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.g$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.core.common.w.c {
        final /* synthetic */ bv a;

        AnonymousClass6(bv bvVar) {
            this.a = bvVar;
        }

        @Override // com.anythink.core.common.w.c
        public final void a(com.anythink.core.common.h.n nVar) {
            com.anythink.core.common.u.c.a(g.this.a).a(1, nVar);
            ab.a(nVar, com.anythink.core.common.d.j.r.a, com.anythink.core.common.d.j.r.o, "");
        }

        @Override // com.anythink.core.common.w.c
        public final void a(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
            g.a(g.this, nVar, aTBaseAdAdapter);
            if (this.a.aJ() == 1) {
                g.a(g.this, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.common.w.c
        public final void a(ATBaseAdAdapter aTBaseAdAdapter, String str) {
            g.this.a(aTBaseAdAdapter, str);
        }

        @Override // com.anythink.core.common.w.c
        public final void a(String str, String str2) {
            g.this.a(str);
            if (this.a.aJ() == 1) {
                g.this.D();
            }
        }

        @Override // com.anythink.core.common.w.c
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, bv bvVar, com.anythink.core.common.h.c cVar) {
            g.this.a(str, aTBaseAdAdapter, cVar.f(), bvVar);
        }

        @Override // com.anythink.core.common.w.c
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, BaseAd... baseAdArr) {
            IATAdFilter iATAdFilterQ = com.anythink.core.common.d.t.b().q(g.this.g);
            BaseAd baseAd = (baseAdArr == null || baseAdArr.length <= 0) ? null : baseAdArr[0];
            if (iATAdFilterQ != null && iATAdFilterQ.isAdFilter(com.anythink.core.common.d.l.a(aTBaseAdAdapter, 3), baseAd)) {
                com.anythink.core.common.w.b bVar = new com.anythink.core.common.w.b();
                bVar.c = 8;
                bVar.e = aTBaseAdAdapter.getTrackingInfo().ab();
                bVar.d = ErrorCode.getErrorCode(ErrorCode.adSourceNotFilledError, "", "");
                bVar.f = aTBaseAdAdapter.getTrackingInfo();
                bVar.g = aTBaseAdAdapter.getUnitGroupInfo();
                g.this.a(str, bVar);
            } else {
                g.this.a(str, aTBaseAdAdapter, baseAdArr != null ? Arrays.asList(baseAdArr) : null);
            }
            if (this.a.aJ() == 1) {
                g.b(g.this, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.common.w.c
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.w.b bVar) {
            g.this.a(str, bVar);
            if (aTBaseAdAdapter == null || aTBaseAdAdapter.getUnitGroupInfo() == null) {
                return;
            }
            aTBaseAdAdapter.getUnitGroupInfo();
            if (this.a.aJ() == 1) {
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
            a(nVar, (AdError) null, com.anythink.core.common.w.a.a.b.a, aTBaseAdAdapter.getUnitGroupInfo());
        }
        if (aTBaseAdAdapter != null) {
            com.anythink.core.common.v.d.a().a(nVar, aTBaseAdAdapter.getUnitGroupInfo(), 3);
        }
    }

    private void b(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        com.anythink.core.common.d.c cVar = this.k;
        if (cVar != null) {
            cVar.onAdSourceLoadFilled(nVar);
        }
        a(nVar, (AdError) null, com.anythink.core.common.w.a.a.b.b, aTBaseAdAdapter.getUnitGroupInfo());
        if (aTBaseAdAdapter != null) {
            com.anythink.core.common.v.d.a().a(nVar, aTBaseAdAdapter.getUnitGroupInfo(), 4);
        }
    }

    private void a(com.anythink.core.common.h.n nVar, AdError adError, bv bvVar) {
        com.anythink.core.common.d.c cVar = this.k;
        if (cVar != null) {
            cVar.onAdSourceLoadFail(nVar, adError);
        }
        a(nVar, adError, com.anythink.core.common.w.a.a.b.c, bvVar);
    }

    private void a(com.anythink.core.common.h.n nVar, AdError adError, int i, bv bvVar) {
        String platformCode;
        String platformMSG;
        if (nVar == null) {
            return;
        }
        if (nVar.K() && i == com.anythink.core.common.w.a.a.b.a) {
            Object[] objArr = new Object[1];
            nVar.M();
            return;
        }
        com.anythink.core.common.w.a.b.d dVar = (com.anythink.core.common.w.a.b.d) com.anythink.core.common.w.a.a.d.a(nVar.aI(), com.anythink.core.common.w.a.b.d.class);
        if (dVar != null) {
            if (adError != null) {
                platformCode = adError.getPlatformCode();
                platformMSG = adError.getPlatformMSG();
            } else {
                platformCode = "";
                platformMSG = "";
            }
            dVar.a(al.a(nVar, platformCode, platformMSG, i));
        }
        com.anythink.core.a.c.a();
        if (i == com.anythink.core.common.w.a.a.b.a) {
            com.anythink.core.a.c.a(this.a, bvVar, nVar.aI());
            return;
        }
        if (i == com.anythink.core.common.w.a.a.b.c) {
            com.anythink.core.a.c.b(this.a, bvVar, nVar.aI());
        } else if (i == com.anythink.core.common.w.a.a.b.b) {
            Context context = this.a;
            nVar.aI();
            com.anythink.core.a.c.b(context, bvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, bv bvVar) {
        com.anythink.core.common.w.e eVarRemove = this.D.remove(str);
        if (eVarRemove == null) {
            return;
        }
        a(eVarRemove, aTBaseAdAdapter, bvVar, aTBaseAdAdapter.getTrackingInfo(), true, baseAd);
        bvVar.toString();
        a(bvVar);
        t();
        b(aTBaseAdAdapter.getTrackingInfo(), aTBaseAdAdapter);
        bvVar.z();
        a(eVarRemove);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f A[Catch: all -> 0x0114, TRY_ENTER, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x0032, B:14:0x0038, B:16:0x0043, B:18:0x0059, B:20:0x0063, B:21:0x0066, B:23:0x007a, B:25:0x008d, B:27:0x0093, B:29:0x009a, B:34:0x00a5, B:36:0x00ad, B:40:0x00bb, B:44:0x00c6, B:47:0x00d4, B:48:0x00de, B:50:0x00fd, B:49:0x00e4, B:24:0x0084), top: B:56:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:23:0x007a A[Catch: all -> 0x0114, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x0032, B:14:0x0038, B:16:0x0043, B:18:0x0059, B:20:0x0063, B:21:0x0066, B:23:0x007a, B:25:0x008d, B:27:0x0093, B:29:0x009a, B:34:0x00a5, B:36:0x00ad, B:40:0x00bb, B:44:0x00c6, B:47:0x00d4, B:48:0x00de, B:50:0x00fd, B:49:0x00e4, B:24:0x0084), top: B:56:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0084 A[Catch: all -> 0x0114, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x0032, B:14:0x0038, B:16:0x0043, B:18:0x0059, B:20:0x0063, B:21:0x0066, B:23:0x007a, B:25:0x008d, B:27:0x0093, B:29:0x009a, B:34:0x00a5, B:36:0x00ad, B:40:0x00bb, B:44:0x00c6, B:47:0x00d4, B:48:0x00de, B:50:0x00fd, B:49:0x00e4, B:24:0x0084), top: B:56:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0093 A[Catch: all -> 0x0114, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x0032, B:14:0x0038, B:16:0x0043, B:18:0x0059, B:20:0x0063, B:21:0x0066, B:23:0x007a, B:25:0x008d, B:27:0x0093, B:29:0x009a, B:34:0x00a5, B:36:0x00ad, B:40:0x00bb, B:44:0x00c6, B:47:0x00d4, B:48:0x00de, B:50:0x00fd, B:49:0x00e4, B:24:0x0084), top: B:56:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5 A[Catch: all -> 0x0114, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x0032, B:14:0x0038, B:16:0x0043, B:18:0x0059, B:20:0x0063, B:21:0x0066, B:23:0x007a, B:25:0x008d, B:27:0x0093, B:29:0x009a, B:34:0x00a5, B:36:0x00ad, B:40:0x00bb, B:44:0x00c6, B:47:0x00d4, B:48:0x00de, B:50:0x00fd, B:49:0x00e4, B:24:0x0084), top: B:56:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ad A[Catch: all -> 0x0114, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x0032, B:14:0x0038, B:16:0x0043, B:18:0x0059, B:20:0x0063, B:21:0x0066, B:23:0x007a, B:25:0x008d, B:27:0x0093, B:29:0x009a, B:34:0x00a5, B:36:0x00ad, B:40:0x00bb, B:44:0x00c6, B:47:0x00d4, B:48:0x00de, B:50:0x00fd, B:49:0x00e4, B:24:0x0084), top: B:56:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c6 A[Catch: all -> 0x0114, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x0032, B:14:0x0038, B:16:0x0043, B:18:0x0059, B:20:0x0063, B:21:0x0066, B:23:0x007a, B:25:0x008d, B:27:0x0093, B:29:0x009a, B:34:0x00a5, B:36:0x00ad, B:40:0x00bb, B:44:0x00c6, B:47:0x00d4, B:48:0x00de, B:50:0x00fd, B:49:0x00e4, B:24:0x0084), top: B:56:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00e4 A[Catch: all -> 0x0114, TryCatch #0 {, blocks: (B:5:0x0009, B:6:0x0010, B:10:0x001f, B:12:0x0032, B:14:0x0038, B:16:0x0043, B:18:0x0059, B:20:0x0063, B:21:0x0066, B:23:0x007a, B:25:0x008d, B:27:0x0093, B:29:0x009a, B:34:0x00a5, B:36:0x00ad, B:40:0x00bb, B:44:0x00c6, B:47:0x00d4, B:48:0x00de, B:50:0x00fd, B:49:0x00e4, B:24:0x0084), top: B:56:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001d A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:8:0x001d, please report this as an issue */
    public final synchronized void a(String str, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list) {
        com.anythink.core.common.w.e eVarRemove;
        com.anythink.core.common.h.n trackingInfo;
        bv unitGroupInfo;
        BaseAd[] baseAdArr;
        com.anythink.core.mg.a.a aVar;
        MgComparedResult mgComparedResultA;
        boolean z;
        boolean z2;
        ad adVarR;
        double uSDEcpm;
        if (aTBaseAdAdapter != null) {
            aTBaseAdAdapter.getTrackingInfo().M();
            eVarRemove = this.D.remove(str);
            if (eVarRemove == null) {
                return;
            }
            trackingInfo = aTBaseAdAdapter.getTrackingInfo();
            unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            unitGroupInfo.toString();
            a(unitGroupInfo);
            t();
            if (list != null || list.size() <= 0) {
                baseAdArr = null;
            } else {
                baseAdArr = new BaseAd[list.size()];
                list.toArray(baseAdArr);
            }
            a(eVarRemove, aTBaseAdAdapter, unitGroupInfo, trackingInfo, false, baseAdArr);
            if (unitGroupInfo.H() != -1 && trackingInfo.aa() > 0) {
                com.anythink.core.common.u.e.a(trackingInfo);
            }
            e(unitGroupInfo);
            b(aTBaseAdAdapter.getTrackingInfo(), aTBaseAdAdapter);
            if (com.anythink.core.common.v.p.e(unitGroupInfo.d()) == 0) {
                this.i.b(SystemClock.elapsedRealtime());
            } else {
                this.i.a(SystemClock.elapsedRealtime());
            }
            aVar = this.S;
            if (aVar != null) {
                Object[] objArr = new Object[1];
                com.anythink.core.common.a.a().a(this.g, aTBaseAdAdapter, list, unitGroupInfo.u(), this.e.p());
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
                    if (uSDEcpm > 0.0d && com.anythink.core.common.v.p.a(unitGroupInfo) < uSDEcpm) {
                        z = true;
                    }
                }
                if (z) {
                    Object[] objArr2 = new Object[1];
                    adVarR = unitGroupInfo.R();
                    if (unitGroupInfo.o() && adVarR != null) {
                        com.anythink.core.b.d.c.a(adVarR, new aw(2, unitGroupInfo, trackingInfo), true, 35);
                    }
                    com.anythink.core.common.u.e.b(trackingInfo, "1");
                } else {
                    Object[] objArr3 = new Object[1];
                    com.anythink.core.common.a.a().a(this.g, aTBaseAdAdapter, list, unitGroupInfo.u(), this.e.p());
                }
            }
            com.anythink.core.common.u.c.a(this.a).a(2, trackingInfo);
            ab.a(trackingInfo, com.anythink.core.common.d.j.r.b, com.anythink.core.common.d.j.r.m, "");
            a(eVarRemove);
            return;
        }
        eVarRemove = this.D.remove(str);
        if (eVarRemove == null) {
            return;
        }
        trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        unitGroupInfo.toString();
        a(unitGroupInfo);
        t();
        if (list != null) {
            baseAdArr = null;
        } else {
            baseAdArr = null;
        }
        a(eVarRemove, aTBaseAdAdapter, unitGroupInfo, trackingInfo, false, baseAdArr);
        if (unitGroupInfo.H() != -1) {
            com.anythink.core.common.u.e.a(trackingInfo);
        }
        e(unitGroupInfo);
        b(aTBaseAdAdapter.getTrackingInfo(), aTBaseAdAdapter);
        if (com.anythink.core.common.v.p.e(unitGroupInfo.d()) == 0) {
            this.i.b(SystemClock.elapsedRealtime());
        } else {
            this.i.a(SystemClock.elapsedRealtime());
        }
        aVar = this.S;
        if (aVar != null) {
            Object[] objArr4 = new Object[1];
            com.anythink.core.common.a.a().a(this.g, aTBaseAdAdapter, list, unitGroupInfo.u(), this.e.p());
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
                Object[] objArr5 = new Object[1];
                adVarR = unitGroupInfo.R();
                if (unitGroupInfo.o()) {
                    com.anythink.core.b.d.c.a(adVarR, new aw(2, unitGroupInfo, trackingInfo), true, 35);
                }
                com.anythink.core.common.u.e.b(trackingInfo, "1");
            } else {
                Object[] objArr6 = new Object[1];
                com.anythink.core.common.a.a().a(this.g, aTBaseAdAdapter, list, unitGroupInfo.u(), this.e.p());
            }
        }
        com.anythink.core.common.u.c.a(this.a).a(2, trackingInfo);
        ab.a(trackingInfo, com.anythink.core.common.d.j.r.b, com.anythink.core.common.d.j.r.m, "");
        a(eVarRemove);
        return;
        throw th;
    }

    private synchronized void e(bv bvVar) {
        bvVar.z();
        if (this.H.b()) {
            return;
        }
        if (this.i.ah()) {
            return;
        }
        com.anythink.core.common.w.g.i(bvVar);
    }

    private synchronized void a(bv bvVar, com.anythink.core.common.h.n nVar) {
        bvVar.z();
        com.anythink.core.common.w.g.c(bvVar, nVar);
    }

    private synchronized void q() {
        final ad adVarR;
        if (!this.H.g() && this.H.e()) {
            if (this.H.b()) {
                return;
            }
            if (this.i.ah()) {
                return;
            }
            final bv bvVarB = this.I.b(this.l);
            if (bvVarB != null && (adVarR = bvVarB.R()) != null) {
                this.H.h();
                com.anythink.core.mg.a.a aVar = this.S;
                if (aVar != null) {
                    MgComparedResult mgComparedResultA = aVar.a();
                    Object[] objArr = new Object[2];
                    if (mgComparedResultA == null) {
                        this.S.a(new com.anythink.core.mg.a.b() { // from class: com.anythink.core.common.g.7
                            @Override // com.anythink.core.mg.a.b
                            public final void a(MgComparedResult mgComparedResult) {
                                g.b(adVarR, bvVarB, mgComparedResult);
                            }
                        });
                        return;
                    } else {
                        b(adVarR, bvVarB, mgComparedResultA);
                        return;
                    }
                }
                b(adVarR, bvVarB, null);
            }
            return;
        }
        this.H.g();
        this.H.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public static void b(ad adVar, bv bvVar, MgComparedResult mgComparedResult) {
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
        Object[] objArr = new Object[1];
        Integer.valueOf(i);
        if (i > 0) {
            com.anythink.core.b.d.c.a(adVar, bvVar, i);
        }
    }

    private synchronized void r() {
        if (!this.H.e()) {
            this.H.e();
        } else {
            if (this.H.b()) {
                return;
            }
            this.I.a(this.i.af());
        }
    }

    private void a(com.anythink.core.common.w.e eVar, ATBaseAdAdapter aTBaseAdAdapter, bv bvVar, com.anythink.core.common.h.n nVar, boolean z, BaseAd... baseAdArr) {
        nVar.m(ak.a(bvVar, aTBaseAdAdapter));
        double dA = eVar.e() != 2 ? com.anythink.core.common.v.p.a(bvVar) : 0.0d;
        a(bvVar, dA, z);
        com.anythink.core.b.d.c.a(aTBaseAdAdapter, bvVar, nVar, baseAdArr);
        this.I.h(bvVar);
        double d = this.N;
        if (d <= 0.0d) {
            nVar.v = 0;
        } else if (d < dA) {
            nVar.v = 2;
        } else {
            nVar.v = 1;
        }
        com.anythink.core.common.w.g.a(this.a, this.g, this.f, bvVar, null);
    }

    private void a(com.anythink.core.common.w.e eVar) {
        boolean zD = eVar.d();
        if (zD) {
            this.I.a(-1, eVar.e());
        }
        b(eVar);
        c(eVar);
        if (this.J != null && this.I.b().a() != this.J.d() && com.anythink.core.common.v.l.a(this.y, this.J.d()) <= 0) {
            com.anythink.core.common.v.p.a(this.y);
            com.anythink.core.common.v.p.a(this.J.d());
            this.J.c();
        }
        if (!zD) {
            l();
            return;
        }
        eVar.e();
        this.I.a(eVar.e());
        a(this.I.b(eVar.e()), eVar.e());
        l();
    }

    private void b(com.anythink.core.common.w.e eVar) {
        if (eVar.c() == null || !eVar.c().booleanValue() || eVar.e() == 2 || !eVar.c().booleanValue()) {
            return;
        }
        this.w++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(com.anythink.core.common.w.e eVar) {
        boolean z;
        bv bvVarS = s();
        if (this.z) {
            if (((this.l || this.q) && com.anythink.core.common.v.l.a(this.y, bvVarS) <= 0) || this.r) {
                Object[] objArr = new Object[4];
                Boolean.valueOf(this.l);
                Boolean.valueOf(this.q);
                Boolean.valueOf(this.r);
                Boolean.valueOf(this.n);
                if (!this.n) {
                    a(-1, this.y);
                } else {
                    d(eVar);
                }
                v();
            }
        } else if (this.l) {
            if (this.Q) {
                return;
            }
            if (this.G == null || !A()) {
                z = false;
            } else {
                com.anythink.core.common.t.d.a().b(this.G);
                this.G.run();
                this.G = null;
                z = true;
            }
            if (z) {
                return;
            }
            if (z() && !this.n) {
                y();
            }
        }
    }

    private synchronized void d(com.anythink.core.common.w.e eVar) {
        bv bvVar;
        ATRequestingInfo aTRequestingInfoD;
        if (this.O) {
            ar arVar = this.j;
            if (arVar != null) {
                arVar.f = null;
            }
            return;
        }
        ar arVar2 = this.j;
        if (arVar2 != null && arVar2.f != null) {
            boolean z = true;
            if (this.B == null) {
                bvVar = this.y;
            } else if (eVar == null || eVar.f() == null || eVar.c() == null) {
                z = false;
                bvVar = null;
            } else {
                bv bvVarF = eVar.f();
                if (com.anythink.core.common.v.l.a(bvVarF, this.B) >= 0) {
                    z = false;
                } else if (eVar.c().booleanValue()) {
                    eVar.f().z();
                    com.anythink.core.common.v.p.a(bvVarF);
                } else {
                    eVar.f().z();
                    com.anythink.core.common.v.p.a(bvVarF);
                    z = false;
                }
                bvVar = bvVarF;
            }
            if (z) {
                this.B = bvVar;
                aTRequestingInfoD = this.I.d(bvVar, this.i);
                if (aTRequestingInfoD != null) {
                    this.j.f.onAdMultipleLoaded(aTRequestingInfoD);
                }
            } else {
                aTRequestingInfoD = null;
            }
            if (aTRequestingInfoD == null && this.I.a(this.l, this.B)) {
                this.j.f.onAdMultipleLoaded(null);
                this.j.f = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bv s() {
        bv bvVarA;
        if (this.e.j() == 2) {
            synchronized (this.D) {
                bvVarA = com.anythink.core.common.w.g.a(this.D);
            }
        } else {
            bvVarA = null;
        }
        bv bvVarV = this.I.v();
        return com.anythink.core.common.v.l.a(bvVarA, bvVarV) < 0 ? bvVarA : bvVarV;
    }

    private synchronized void t() {
        this.I.h();
        if (this.G != null) {
            com.anythink.core.common.t.d.a().b(this.G);
            this.G = null;
        }
    }

    public final void a(final int i, bv bvVar) {
        boolean z;
        t();
        if (this.F != null) {
            com.anythink.core.common.t.d.a().b(this.F);
            this.F = null;
        }
        com.anythink.core.common.a.c.a aVar = this.J;
        if (aVar != null && ((aVar.d() == this.I.b().a() || com.anythink.core.common.v.l.a(this.J.d(), this.y) < 0) && this.J.b())) {
            a(this.J.d(), com.anythink.core.common.v.p.a(this.J.d()), true);
            i = this.J.d().br() ? 13 : 11;
        }
        bv bvVar2 = this.y;
        if (bvVar2 != null && bvVar2.br()) {
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
        this.n = true;
        this.m = true;
        if (this.L != null) {
            com.anythink.core.common.t.d.a().b(this.L);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.u;
        final com.anythink.core.common.h.n nVarAf = this.i.af();
        nVarAf.b(true);
        nVarAf.r(j);
        nVarAf.l(jElapsedRealtime);
        if (this.A) {
            nVarAf.b(2);
        } else {
            nVarAf.b(1);
        }
        if (z) {
            nVarAf.L(i);
        }
        if (bvVar != null) {
            nVarAf.a(bvVar);
        }
        com.anythink.core.common.w.g.a(this.a, this.g);
        com.anythink.core.common.w.g.a(this.g);
        if (this.S != null) {
            Object[] objArr = new Object[1];
            com.anythink.core.common.v.q.a(Thread.currentThread().getStackTrace());
            Object[] objArr2 = new Object[1];
            Boolean.valueOf(z());
            this.S.a(new com.anythink.core.mg.a.b() { // from class: com.anythink.core.common.g.8
                @Override // com.anythink.core.mg.a.b
                public final void a(MgComparedResult mgComparedResult) {
                    int i2;
                    if (mgComparedResult != null) {
                        i2 = mgComparedResult.isCpTimeout() ? 3 : 2;
                    } else {
                        i2 = 0;
                    }
                    com.anythink.core.common.u.e.b(nVarAf, i2);
                    if (mgComparedResult != null && mgComparedResult.isMgWin()) {
                        com.anythink.core.common.a.a().c(g.this.g);
                        g.this.t = ErrorCode.getErrorCode(ErrorCode.compareFailedError, "", "");
                        bv bvVarS = g.this.s();
                        MgComparedResult mgComparedResultA = g.this.S.a();
                        if (com.anythink.core.common.v.p.a(bvVarS) <= ((mgComparedResultA == null || mgComparedResultA.getMgAdInfo() == null) ? 0.0d : mgComparedResultA.getMgAdInfo().getUSDEcpm())) {
                            bvVarS = null;
                        }
                        g.this.f(bvVarS);
                        return;
                    }
                    com.anythink.core.common.u.c.a(g.this.a).a(12, nVarAf);
                    g.a(g.this, i);
                }
            });
            this.S.a(this.j, this.P);
            return;
        }
        this.t = ErrorCode.getErrorCode(ErrorCode.noADError, "", "The MgComparePriceHandler can not be null.");
        f((bv) null);
    }

    private void d(int i) {
        com.anythink.core.d.l lVarA;
        u();
        if (this.O) {
            return;
        }
        ab.a("Mediation", "placementId:" + this.g + ";result_callback:success;loadType:" + this.j.c + ";");
        v.a(this.a).a(this.g, this.f, true);
        ar arVar = this.j;
        if (arVar != null && arVar.e != null) {
            boolean z = false;
            try {
                cb cbVar = this.e;
                if (cbVar != null && (lVarA = cbVar.a()) != null) {
                    try {
                        if (u.a().a(this.g, new StringBuilder().append(this.e.a().aq()).toString()) != null) {
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
                d((com.anythink.core.common.w.e) null);
                this.j.e.a(this.A ? 1 : 2, this.j, this.e, i);
            }
            this.j.e = null;
        }
        com.anythink.core.c.b.a().a(this.g, this.f, this.e.a().ay(), this.j, this.I.b().a());
    }

    private synchronized boolean u() {
        if (this.I.k()) {
            return false;
        }
        if (this.H.c()) {
            return false;
        }
        bv bvVar = this.y;
        if (bvVar != null && bvVar.br()) {
            return false;
        }
        this.H.f();
        this.Q = true;
        List<bv> listL = this.I.l();
        this.I.b(listL);
        a(8, listL, new j.a() { // from class: com.anythink.core.common.g.9
            @Override // com.anythink.core.common.j.a
            public final void a(String str) {
            }

            @Override // com.anythink.core.common.j.a
            public final void a(String str, List<bv> list, List<bv> list2, boolean z) {
                for (bv bvVar2 : list) {
                    g.this.d(bvVar2);
                    bvVar2.C(8);
                    g.this.I.a(bvVar2);
                    g.this.b(bvVar2, 3);
                }
                if (list2 != null) {
                    Iterator<bv> it = list2.iterator();
                    while (it.hasNext()) {
                        g.this.b(it.next());
                    }
                }
                g.this.Q = false;
                g.this.c((com.anythink.core.common.w.e) null);
            }
        });
        return true;
    }

    private synchronized void v() {
        if (this.l) {
            if (this.H.c()) {
                return;
            }
            bv bvVar = this.y;
            if (bvVar == null || !bvVar.br()) {
                List<bv> list = this.E;
                if (list != null && list.size() != 0) {
                    if (this.p) {
                        return;
                    }
                    this.p = true;
                    a(7, this.E, new j.a() { // from class: com.anythink.core.common.g.10
                        @Override // com.anythink.core.common.j.a
                        public final void a(String str) {
                        }

                        @Override // com.anythink.core.common.j.a
                        public final void a(String str, List<bv> list2, List<bv> list3, boolean z) {
                            if (g.this.H.c()) {
                                String unused = g.this.R;
                                for (bv bvVar2 : list2) {
                                    g.this.I.e(bvVar2);
                                    com.anythink.core.common.w.g.b(bvVar2, g.this.i);
                                }
                                return;
                            }
                            if (g.this.w < g.this.e.g()) {
                                String unused2 = g.this.R;
                                g.this.a(list2, (List<bv>) null, (List<bv>) null, list3);
                                g.this.l();
                                return;
                            }
                            String unused3 = g.this.R;
                            bv bvVarA = g.this.I.a(false);
                            int size = list2.size();
                            ArrayList<bv> arrayList = new ArrayList(size);
                            ArrayList arrayList2 = new ArrayList(size);
                            for (int i = 0; i < size; i++) {
                                bv bvVar3 = list2.get(i);
                                g.this.I.e(bvVar3);
                                if (com.anythink.core.common.v.l.a(bvVar3, bvVarA) < 0) {
                                    arrayList.add(bvVar3);
                                } else {
                                    arrayList2.add(bvVar3);
                                }
                            }
                            for (bv bvVar4 : arrayList) {
                                g.this.d(bvVar4);
                                bvVar4.C(7);
                                g.this.I.a(bvVar4);
                                g.this.b(bvVar4, 5);
                            }
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                com.anythink.core.common.w.g.b((bv) it.next(), g.this.i);
                            }
                        }
                    });
                }
            }
        }
    }

    private void a(int i, List<bv> list, final j.a aVar) {
        boolean z = this.M != null || ak.a(this.E);
        com.anythink.core.common.h.a aVar2 = new com.anythink.core.common.h.a();
        aVar2.b = this.a;
        aVar2.c = this.j;
        aVar2.d = this.f;
        aVar2.e = this.g;
        aVar2.f = this.e.a().aq();
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
        aVar2.v = this.I.p();
        aVar2.w = this.I.q();
        aVar2.x = this.I.r();
        aVar2.m = z;
        aVar2.t = i;
        aVar2.u = this.I.a(list, this.P);
        aVar2.y = this.I.a();
        com.anythink.core.b.b bVar = new com.anythink.core.b.b(aVar2);
        bVar.a(ATSDK.isNetworkLogDebug());
        bVar.a(new j.a() { // from class: com.anythink.core.common.g.2
            @Override // com.anythink.core.common.j.a
            public final void a(String str, List<bv> list2, List<bv> list3, boolean z2) {
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
        });
    }

    protected final synchronized void a(String str, com.anythink.core.common.w.b bVar) {
        com.anythink.core.common.h.n nVar = bVar.f;
        bv bvVar = bVar.g;
        AdError adError = bVar.d;
        long j = bVar.e;
        int i = bVar.h;
        String strM = nVar.M();
        com.anythink.core.common.w.e eVarRemove = this.D.remove(str);
        if (eVarRemove == null) {
            return;
        }
        bvVar.toString();
        a(bvVar);
        this.t.putNetworkErrorMsg(strM, nVar.Y(), nVar.aF(), adError);
        if (i == 0) {
            com.anythink.core.common.u.e.a(nVar, bVar.c, adError, j);
        } else {
            StringBuilder sbAppend = new StringBuilder("requestId=").append(this.f).append(", networkFirmId=").append(nVar.Y()).append(", adSourceId=").append(nVar.M()).append(", format=").append(nVar.aK());
            ad adVarR = bvVar.R();
            if (adVarR != null) {
                sbAppend.append(", hasShow=").append(adVarR.p()).append(", bidId=").append(adVarR.token).append(", tpBidId=").append(adVarR.g);
            }
            com.anythink.core.common.u.e.b("unexpected request failed", sbAppend.toString(), com.anythink.core.common.d.t.b().r());
        }
        if (j > 0) {
            com.anythink.core.common.d.c cVar = this.k;
            if (cVar != null) {
                cVar.onAdSourceLoadFail(nVar, adError);
            }
            a(nVar, adError, com.anythink.core.common.w.a.a.b.c, bvVar);
        }
        ab.a(nVar, com.anythink.core.common.d.j.r.b, com.anythink.core.common.d.j.r.n, adError.printStackTrace());
        a(bvVar, this.i);
        a(eVarRemove);
    }

    private boolean w() {
        if (this.G == null || !A()) {
            return false;
        }
        com.anythink.core.common.t.d.a().b(this.G);
        this.G.run();
        this.G = null;
        return true;
    }

    private void x() {
        f((bv) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(bv bvVar) {
        this.n = true;
        this.m = false;
        if (this.L != null) {
            com.anythink.core.common.t.d.a().b(this.L);
        }
        com.anythink.core.common.u.e.a(this.i.af(), this.t, bvVar);
        if (!this.O) {
            a(this.t);
        }
        f();
    }

    private void y() {
        com.anythink.core.common.h.c cVarC = C();
        if (cVarC != null) {
            bv unitGroupInfo = cVarC.e() != null ? cVarC.e().getUnitGroupInfo() : null;
            a(unitGroupInfo, com.anythink.core.common.v.p.a(unitGroupInfo), true);
            a(9, unitGroupInfo);
            return;
        }
        f((bv) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str) {
        if (this.H.b()) {
            return;
        }
        a(this.D.get(str));
    }

    private synchronized boolean z() {
        new StringBuilder("hasFinishAllRequest:\n isFinishBidding: ").append(this.l).append("\n requestWaitingPool: ").append(this.I.c()).append("\n requestingPool: ").append(this.I.d()).append("\n defaultRequestWaitingPool: ").append(this.I.e()).append("\n showCapWaitingPool: ").append(this.I.i()).append("\n mLoadedMaxUnitGroupInfo: ").append(this.y).append("\n mMaxPriceUnitGroupInfoForDynamic: ").append(this.P).append("\n mLoadedMinPriceUnitGroupInfo: ").append(this.C);
        return this.I.t();
    }

    private synchronized boolean A() {
        return this.I.c() == 0 && this.I.d() == 0;
    }

    private void b(long j) {
        com.anythink.core.common.t.d.a().a(this.L, j, false);
    }

    public final boolean c() {
        if (this.n) {
            return true;
        }
        return this.l && this.I.c() == 0 && this.I.m() == 0;
    }

    public final synchronized void a(double d, bv bvVar) {
        D();
        if (!this.H.g() && bvVar != null && bvVar.o()) {
            this.H.h();
        }
        if (d > this.N) {
            this.N = d;
        }
        int iAq = this.e.a().aq();
        if (iAq == 0 || iAq == 2) {
            return;
        }
        this.H.d();
        f fVarA = u.a().a(this.g, new StringBuilder().append(this.e.a().aq()).toString());
        if (fVarA != null) {
            fVarA.a(this.f);
        } else {
            com.anythink.core.common.u.e.b("AdManage is null--notifyimpression", "Id:" + this.g + "--format:" + this.e.a().aq(), com.anythink.core.common.d.t.b().r());
        }
        if (!this.n) {
            a(10, bvVar);
        }
        l();
    }

    public final void d() {
        this.q = true;
        c((com.anythink.core.common.w.e) null);
    }

    public final void e() {
        synchronized (this.x) {
            this.l = true;
            this.q = true;
            c((com.anythink.core.common.w.e) null);
            l();
        }
    }

    public final void f() {
        this.O = true;
        f fVarA = u.a().a(this.g, new StringBuilder().append(this.e.a().aq()).toString());
        if (fVarA != null) {
            fVarA.a(this.f);
        } else {
            com.anythink.core.common.u.e.b("AdManage is null--notifycancel", "Id:" + this.g + "--format:" + this.e.a().aq(), com.anythink.core.common.d.t.b().r());
        }
    }

    private void B() {
        if (this.L != null) {
            com.anythink.core.common.t.d.a().b(this.L);
        }
    }

    public final void a(ATBaseAdAdapter aTBaseAdAdapter, String str) {
        if (aTBaseAdAdapter != null) {
            str.hashCode();
            switch (str) {
                case "0":
                    aTBaseAdAdapter.setRequestNum(aTBaseAdAdapter.getUnitGroupInfo().x());
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
        com.anythink.core.d.l lVarA;
        ab.a("Mediation", "placementId:" + this.g + ";result_callback:success;loadType:" + this.j.c + ";");
        v.a(this.a).a(this.g, this.f, true);
        ar arVar = this.j;
        if (arVar != null && arVar.e != null) {
            boolean z = false;
            try {
                cb cbVar = this.e;
                if (cbVar != null && (lVarA = cbVar.a()) != null) {
                    try {
                        if (u.a().a(this.g, new StringBuilder().append(this.e.a().aq()).toString()) != null) {
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
                d((com.anythink.core.common.w.e) null);
                this.j.e.a(this.A ? 1 : 2, this.j, this.e, i);
            }
            this.j.e = null;
        }
        com.anythink.core.c.b.a().a(this.g, this.f, this.e.a().ay(), this.j, this.I.b().a());
    }

    private void a(AdError adError) {
        ab.a("Mediation", "placementId:" + this.g + ";result_callback:fail;loadType:" + this.j.c + ";");
        v.a(this.a).a(this.g, this.f, false);
        ar arVar = this.j;
        if (arVar == null || arVar.e == null) {
            return;
        }
        this.j.e.a(2, this.j, this.e, adError);
        this.j.e = null;
    }

    public final void g() {
        List<com.anythink.core.common.w.f> listJ = this.I.j();
        synchronized (listJ) {
            if (listJ.size() > 0) {
                bv bvVarA = listJ.remove(0).a();
                if (!this.n || this.w < this.e.g() || com.anythink.core.common.v.l.a(bvVarA, this.y) < 0) {
                    this.I.a(bvVarA);
                    b(bvVarA, 4);
                }
            }
            if (listJ.size() > 0) {
                for (com.anythink.core.common.w.f fVar : listJ) {
                    bv bvVarA2 = fVar.a();
                    if (!this.n || this.w < this.e.g() || com.anythink.core.common.v.l.a(bvVarA2, this.y) < 0) {
                        int iB = fVar.b();
                        if (iB == 1) {
                            a(bvVarA2, 1);
                            c(iB);
                        } else if (iB == 2) {
                            a(bvVarA2, 2);
                            c(iB);
                        } else if (iB == 3) {
                            this.I.a(bvVarA2);
                            b(bvVarA2, 3);
                        }
                    }
                }
            }
            listJ.clear();
        }
        l();
    }

    private void g(bv bvVar) {
        if (bvVar != null && com.anythink.core.common.w.g.j(bvVar) > com.anythink.core.common.v.p.a(this.P)) {
            new StringBuilder("resetDynamicPrice, record max price: ").append(bvVar);
            this.P = bvVar;
        }
    }

    private com.anythink.core.common.h.c C() {
        com.anythink.core.common.a.c.a aVar;
        com.anythink.core.common.h.c cVarA = com.anythink.core.common.a.a().a(this.a, this.g);
        return (cVarA == null && (aVar = this.J) != null) ? aVar.a() : cVarA;
    }

    public final com.anythink.core.common.a.c.a h() {
        return this.J;
    }

    private void a(bv bvVar, double d, boolean z) {
        if (bvVar == null) {
            return;
        }
        this.z = true;
        g(bvVar);
        if (d == 0.0d) {
            if (this.y == null && (!z || !this.A)) {
                this.A = !z;
            }
        } else if (com.anythink.core.common.v.l.a(bvVar, this.y) < 0) {
            this.y = bvVar;
            if (!z || !this.A) {
                this.A = !z;
            }
        }
        bv bvVar2 = this.C;
        if (bvVar2 == null || com.anythink.core.common.v.l.a(bvVar2, bvVar) < 0) {
            this.C = bvVar;
        }
        boolean zG = this.I.g(bvVar);
        if (this.n && this.m && zG) {
            com.anythink.core.c.b.a().a(this.g, this.f, this.e.a().ay(), this.j, this.I.b().a());
        }
    }

    public final com.anythink.core.d.l i() {
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
    public void D() {
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

    private synchronized void E() {
        if (this.I.u()) {
            List<bv> listB = this.I.b(1);
            if (listB.size() > 0) {
                a(listB, 1);
            }
        }
    }

    private String a(com.anythink.core.common.h.n nVar, bv bvVar) {
        StringBuilder sbAppend = new StringBuilder("requestId=").append(this.f).append(", networkFirmId=").append(nVar.Y()).append(", adSourceId=").append(nVar.M()).append(", format=").append(nVar.aK());
        ad adVarR = bvVar.R();
        if (adVarR != null) {
            sbAppend.append(", hasShow=").append(adVarR.p()).append(", bidId=").append(adVarR.token).append(", tpBidId=").append(adVarR.g);
        }
        return sbAppend.toString();
    }

    static /* synthetic */ void a(g gVar, com.anythink.core.common.w.e eVar, com.anythink.core.common.h.n nVar, bv bvVar) {
        com.anythink.core.common.w.d dVar = new com.anythink.core.common.w.d();
        dVar.a = gVar.a;
        dVar.b = gVar.b;
        dVar.c = gVar.f;
        dVar.d = gVar.g;
        dVar.e = gVar.e.a();
        dVar.f = gVar.h;
        dVar.g = gVar.v;
        dVar.h = nVar;
        dVar.i = gVar.I.r();
        eVar.a(dVar);
        eVar.a(gVar.new AnonymousClass6(bvVar));
        eVar.a(gVar.C);
    }

    static /* synthetic */ void a(g gVar, com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        com.anythink.core.common.d.c cVar = gVar.k;
        if (cVar != null) {
            cVar.onAdSourceAttempt(nVar);
        }
        if (aTBaseAdAdapter != null) {
            gVar.a(nVar, (AdError) null, com.anythink.core.common.w.a.a.b.a, aTBaseAdAdapter.getUnitGroupInfo());
        }
        if (aTBaseAdAdapter != null) {
            com.anythink.core.common.v.d.a().a(nVar, aTBaseAdAdapter.getUnitGroupInfo(), 3);
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
        com.anythink.core.d.l lVarA;
        gVar.u();
        if (gVar.O) {
            return;
        }
        ab.a("Mediation", "placementId:" + gVar.g + ";result_callback:success;loadType:" + gVar.j.c + ";");
        v.a(gVar.a).a(gVar.g, gVar.f, true);
        ar arVar = gVar.j;
        if (arVar != null && arVar.e != null) {
            boolean z = false;
            try {
                cb cbVar = gVar.e;
                if (cbVar != null && (lVarA = cbVar.a()) != null) {
                    try {
                        if (u.a().a(gVar.g, new StringBuilder().append(gVar.e.a().aq()).toString()) != null) {
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
                gVar.d((com.anythink.core.common.w.e) null);
                gVar.j.e.a(gVar.A ? 1 : 2, gVar.j, gVar.e, i);
            }
            gVar.j.e = null;
        }
        com.anythink.core.c.b.a().a(gVar.g, gVar.f, gVar.e.a().ay(), gVar.j, gVar.I.b().a());
    }
}
