package com.anythink.core.common.v;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.p;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.u.k;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.t;
import com.anythink.core.e.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final String a = "e";
    String b;
    by c;
    n d;
    String e;
    int f;
    ATBaseAdAdapter g;
    c h;
    boolean i;
    boolean j;
    long k;
    long l;
    com.anythink.core.common.u.b.d m;
    com.anythink.core.common.u.b.d n;
    d o;
    Boolean p;
    int q;
    String r;
    boolean s;
    private final com.anythink.core.common.f t;

    public e(by byVar, int i, com.anythink.core.common.f fVar) {
        this.c = byVar;
        this.q = i;
        this.t = fVar;
        this.e = byVar.G();
        this.r = this.e + "_" + hashCode();
    }

    public final String a() {
        return this.r;
    }

    public final void a(d dVar) {
        this.o = dVar;
        this.b = dVar.d;
        this.d = dVar.h;
        this.f = dVar.g;
    }

    public final void a(c cVar) {
        this.h = cVar;
    }

    public final void a(by byVar) {
        boolean z;
        com.anythink.core.common.h.c cVarA;
        boolean z2;
        BaseAd baseAdB;
        ATBaseAdAdapter aTBaseAdAdapterA;
        p pVar;
        String strA;
        this.s = true;
        ad adVarY = this.c.Y();
        if (adVarY != null && adVarY.o()) {
            if (this.h != null) {
                b bVar = new b();
                bVar.c = 0;
                bVar.e = 0L;
                bVar.d = ErrorCode.getErrorCode(ErrorCode.biddingResultHasShow, "", "Bidding result has been used");
                bVar.h = 1;
                a((ATBaseAdAdapter) null, bVar);
                return;
            }
            return;
        }
        if (this.c.w() && this.c.Y() != null && !TextUtils.isEmpty(this.o.c)) {
            this.c.Y().b(this.o.c);
        }
        com.anythink.core.common.f fVar = this.t;
        bz bzVarA = (fVar == null || fVar.e() == null) ? null : this.t.e().a(this.b, this.c);
        if (bzVarA != null) {
            com.anythink.core.common.h.j jVarA = bzVarA.a(this.c.Y());
            int iD = jVarA.d();
            if (this.c.v() == 1) {
                cVarA = jVarA.e();
            } else {
                cVarA = jVarA.a();
            }
            if (cVarA != null) {
                com.anythink.core.common.f fVar2 = this.t;
                List<com.anythink.core.common.h.c> listA = (fVar2 == null || fVar2.e() == null) ? null : this.t.e().a(this.b);
                if (listA == null || !listA.contains(cVarA)) {
                    com.anythink.core.common.t.f.b("adsource upstatus error", "cache no found in list", s.b().r());
                    cVarA = null;
                }
            }
            z = this.c.v() != 1 ? !(!jVarA.c() || cVarA == null || (k.a(this.c, byVar) < 0 && iD < this.c.aG())) : cVarA != null;
        } else {
            z = false;
            cVarA = null;
        }
        if (z) {
            c cVar = this.h;
            if (cVar != null) {
                cVar.a(cVarA.e().getTrackingInfo(), cVarA.e());
            }
            a(cVarA.e(), this.c, cVarA);
            return;
        }
        if (adVarY == null || !adVarY.t) {
            z2 = false;
            baseAdB = null;
            aTBaseAdAdapterA = null;
        } else {
            com.anythink.core.c.c.c cVar2 = adVarY.s;
            if (cVar2 != null) {
                aTBaseAdAdapterA = cVar2.a();
                baseAdB = cVar2.b();
            } else {
                baseAdB = null;
                aTBaseAdAdapterA = null;
            }
            adVarY.s = null;
            z2 = true;
        }
        if (aTBaseAdAdapterA != null || z2) {
            pVar = null;
        } else {
            p pVarA = t.a(this.c);
            pVar = pVarA;
            aTBaseAdAdapterA = pVarA != null ? pVarA.a : null;
        }
        if (aTBaseAdAdapterA == null) {
            if (this.h != null) {
                b bVar2 = new b();
                bVar2.c = 0;
                bVar2.e = z2 ? this.c.x() : 0L;
                String strB = z2 ? "" : this.c.u() + " does not exist!";
                if (pVar != null) {
                    strB = pVar.b(strB);
                    strA = pVar.a();
                } else {
                    strA = null;
                }
                if (TextUtils.isEmpty(strA)) {
                    bVar2.d = ErrorCode.getErrorCode(z2 ? ErrorCode.c2sBiddingCacheError : ErrorCode.adapterNotExistError, "", strB);
                } else {
                    if (strA.equals(ErrorCode.adapterBridgeVersionError)) {
                        bVar2.c = 39;
                    }
                    bVar2.d = ErrorCode.getErrorCode(strA, "", strB);
                }
                a((ATBaseAdAdapter) null, bVar2);
                return;
            }
            return;
        }
        ai.a(aTBaseAdAdapterA, this.d, this.c);
        this.d.m(aj.a(this.c, null));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.k = jElapsedRealtime;
        this.d.a(jElapsedRealtime);
        try {
            if (baseAdB != null) {
                this.d.a(baseAdB.getNetworkInfoMap());
            } else {
                this.d.a(aTBaseAdAdapterA.getInternalNetworkInfoMap());
            }
        } catch (Exception unused) {
        }
        c cVar3 = this.h;
        if (cVar3 != null) {
            cVar3.a(aTBaseAdAdapterA, String.valueOf(this.o.e.ap()));
        }
        c cVar4 = this.h;
        if (cVar4 != null) {
            cVar4.a(this.d);
        }
        long jO = this.c.O();
        if (jO != -1) {
            this.m = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dj, new AnonymousClass3());
            com.anythink.core.common.s.c.a().a(this.m, jO);
        }
        long jD = this.c.D();
        if (jD != -1) {
            this.n = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.di, new AnonymousClass2());
            com.anythink.core.common.s.c.a().a(this.n, jD);
        }
        Context context = this.o.b.get();
        if (context != null && (context instanceof Activity)) {
            aTBaseAdAdapterA.refreshActivityContext((Activity) context);
        }
        if (z2) {
            c cVar5 = this.h;
            if (cVar5 != null) {
                cVar5.a(this.d, aTBaseAdAdapterA);
            }
            if (baseAdB != null) {
                a(aTBaseAdAdapterA, baseAdB);
                return;
            } else {
                a(aTBaseAdAdapterA, new BaseAd[0]);
                return;
            }
        }
        by byVar2 = this.c;
        Map<String, Object> mapI = i();
        String.valueOf(this.o.e.ap());
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.x, new AnonymousClass1(aTBaseAdAdapterA, byVar2, mapI)), false);
    }

    private void g() {
        if (this.m != null) {
            com.anythink.core.common.s.c.a().a(this.m);
            this.m = null;
        }
    }

    private void h() {
        if (this.n != null) {
            com.anythink.core.common.s.c.a().a(this.n);
            this.n = null;
        }
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, by byVar) {
        Map<String, Object> mapI = i();
        String.valueOf(this.o.e.ap());
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.x, new AnonymousClass1(aTBaseAdAdapter, byVar, mapI)), false);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.e$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ATBaseAdAdapter a;
        final /* synthetic */ by b;
        final /* synthetic */ Map c;

        AnonymousClass1(ATBaseAdAdapter aTBaseAdAdapter, by byVar, Map map) {
            this.a = aTBaseAdAdapter;
            this.b = byVar;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context contextA = e.a(e.this);
            byte b = 0;
            if (contextA == null) {
                if (e.this.h != null) {
                    b bVar = new b();
                    bVar.c = 0;
                    bVar.e = SystemClock.elapsedRealtime() - e.this.k;
                    bVar.d = ErrorCode.getErrorCode(ErrorCode.adapterInnerError, "", "Request Context is null! Please check the Ad init Context.");
                    e.this.a(this.a, bVar);
                    return;
                }
                return;
            }
            e.a(e.this, contextA, this.b, this.a);
            try {
                Map<String, Object> mapJ = e.this.j();
                e.this.g = this.a;
                com.anythink.core.common.n.e.a().c();
                ATBaseAdAdapter aTBaseAdAdapter = this.a;
                Map<String, Object> map = this.c;
                n nVar = e.this.d;
                String str = e.this.e;
                Map map2 = this.c;
                e eVar = e.this;
                aTBaseAdAdapter.internalLoad(contextA, map, mapJ, new com.anythink.core.common.v.a(nVar, str, map2, new a(eVar, eVar, this.a, b)));
                n trackingInfo = this.a.getTrackingInfo();
                String internalNetworkPlacementId = this.a.getInternalNetworkPlacementId();
                if (!TextUtils.isEmpty(internalNetworkPlacementId)) {
                    trackingInfo.m(internalNetworkPlacementId);
                }
                if (e.this.h != null) {
                    e.this.h.a(trackingInfo, this.a);
                }
            } catch (Throwable th) {
                b bVar2 = new b();
                bVar2.c = 0;
                bVar2.e = SystemClock.elapsedRealtime() - e.this.k;
                bVar2.d = ErrorCode.getErrorCode(ErrorCode.adapterInnerError, "", th.getMessage());
                e.this.a(this.a, bVar2);
            }
        }
    }

    private void a(Context context, by byVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.e.b.aX()) {
            u uVarA = u.a(s.b().g());
            try {
                boolean zB = uVarA.b(byVar.n());
                if (uVarA.b(byVar.n(), zB) && aTBaseAdAdapter.internalSetUserDataConsent(context, zB, ATSDK.isEUTraffic(this.o.a))) {
                    uVarA.a(byVar.n(), zB);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter) {
        this.g = aTBaseAdAdapter;
    }

    private Map<String, Object> i() {
        l lVar = this.o.e;
        String str = this.o.c;
        if (lVar == null) {
            return new HashMap();
        }
        n nVar = this.d;
        Map<String, Object> mapA = lVar.a(this.b, str, this.c, nVar != null ? nVar.b() : null);
        int iN = this.c.n();
        if (iN == 2) {
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.o.a).b(s.b().p());
            if (bVarB != null) {
                mapA.put("mediation_switch", Boolean.valueOf(bVarB.n() == 1));
            }
            if (lVar.m() == 1) {
                mapA.put("admob_show_with_pay_info", Integer.valueOf(lVar.m()));
            } else {
                mapA.put("admob_show_with_pay_info", Integer.valueOf(this.c.aH()));
            }
        } else if (iN == 6) {
            JSONObject jSONObjectA = o.a(this.o.a, str, this.b, lVar.ap(), this.f);
            if (lVar.aM() == 1) {
                mapA.put("tp_info", jSONObjectA.toString());
            }
        } else if (iN == 22) {
            com.anythink.core.common.u.f.a(lVar, mapA, this.c, this.d, this.o.i);
        } else if (iN == 76) {
            mapA.put("internal_vast_load_timeout", Long.valueOf(this.c.D()));
        }
        if (aj.a(this.c) && this.o.e.aJ() == 1) {
            com.anythink.core.a.a.a(this.o.a);
            mapA.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_LOAD_SEQ, Integer.valueOf(com.anythink.core.a.a.a(this.b, this.o.e.ap()).c));
            com.anythink.core.common.f fVar = this.t;
            if (fVar != null) {
                synchronized (fVar.q()) {
                    String strB = this.t.b(this.c.n());
                    if (!TextUtils.isEmpty(strB)) {
                        mapA.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.CONTENT, strB);
                    }
                }
            }
        }
        return mapA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> j() {
        Map<String, Object> map = this.o.f;
        if (map == null) {
            return new HashMap(2);
        }
        if (this.c.n() != 2) {
            return map;
        }
        Object obj = map.get("admob_content_urls");
        String string = "";
        try {
            Object obj2 = map.get("admob_keywords");
            if (obj2 instanceof List) {
                string = obj2.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(obj instanceof List) && TextUtils.isEmpty(string)) {
            return map;
        }
        com.anythink.core.common.t.f.a(this.b, this.d, "admob_content_urls", obj, string);
        return map;
    }

    private Context k() {
        Context contextM = this.o.b.get();
        if (!(contextM instanceof Activity)) {
            contextM = s.b().M();
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.d(a, "requestContext = ".concat(String.valueOf(contextM)));
        }
        return contextM;
    }

    public final synchronized void b() {
        if (l()) {
            return;
        }
        this.p = Boolean.FALSE;
        this.j = true;
        b bVar = new b();
        bVar.c = 0;
        bVar.e = SystemClock.elapsedRealtime() - this.k;
        bVar.d = ErrorCode.getErrorCode(ErrorCode.timeOutError, "", "");
        a(this.g, bVar);
    }

    private boolean l() {
        return !this.s || this.j || s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        if (l()) {
            return;
        }
        this.i = true;
        c cVar = this.h;
        if (cVar != null) {
            cVar.a(this.r);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.e$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.B, new Runnable() { // from class: com.anythink.core.common.v.e.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.m();
                }
            }));
        }
    }

    private com.anythink.core.common.u.b.d n() {
        return new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.di, new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.e$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.B, new Runnable() { // from class: com.anythink.core.common.v.e.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.m();
                }
            }));
        }
    }

    private com.anythink.core.common.u.b.d o() {
        return new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dj, new AnonymousClass3());
    }

    private void p() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.k;
        this.l = j;
        n nVar = this.d;
        if (nVar != null) {
            nVar.r(j);
            this.d.l(jElapsedRealtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ATBaseAdAdapter aTBaseAdAdapter, BaseAd... baseAdArr) {
        if (l()) {
            return;
        }
        by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        long jX = unitGroupInfo.y() == 2 ? unitGroupInfo.x() : 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.d.s((jElapsedRealtime - this.k) + jX);
        this.d.m(jElapsedRealtime);
        ai.a(this.d, aTBaseAdAdapter);
        g();
        h();
        this.g = null;
        this.p = Boolean.TRUE;
        if (this.i) {
            this.d.u = 1;
        }
        c cVar = this.h;
        if (cVar != null) {
            cVar.a(this.r, aTBaseAdAdapter, baseAdArr);
        }
    }

    private synchronized void a(ATBaseAdAdapter aTBaseAdAdapter, by byVar, com.anythink.core.common.h.c cVar) {
        if (l()) {
            return;
        }
        g();
        h();
        this.g = null;
        this.p = Boolean.TRUE;
        if (this.i) {
            this.d.u = 1;
        }
        c cVar2 = this.h;
        if (cVar2 != null) {
            cVar2.a(this.r, aTBaseAdAdapter, byVar, cVar);
        }
    }

    public final synchronized void a(final ATBaseAdAdapter aTBaseAdAdapter, b bVar) {
        if (l()) {
            return;
        }
        g();
        h();
        if (aTBaseAdAdapter != null) {
            s.b();
            s.b(new Runnable() { // from class: com.anythink.core.common.v.e.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ATBaseAdAdapter aTBaseAdAdapter2 = aTBaseAdAdapter;
                        if (aTBaseAdAdapter2 != null) {
                            aTBaseAdAdapter2.internalDestroy();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
        this.g = null;
        this.p = Boolean.FALSE;
        if (!this.j) {
            if (this.i) {
                this.d.u = 1;
            }
        } else {
            this.d.u = 2;
        }
        if (!this.j) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.anythink.core.common.c.a().a(this.e, jCurrentTimeMillis);
            com.anythink.core.common.c.a().a(this.e, jCurrentTimeMillis, bVar.d);
        }
        bVar.f = this.d;
        bVar.g = this.c;
        c cVar = this.h;
        if (cVar != null) {
            cVar.a(this.r, aTBaseAdAdapter, bVar);
        }
    }

    private void r() {
        this.g = null;
    }

    public final Boolean c() {
        return this.p;
    }

    private boolean s() {
        return this.p != null;
    }

    public final boolean d() {
        return (s() && this.i) ? false : true;
    }

    public final int e() {
        return this.q;
    }

    private long t() {
        return this.k;
    }

    private boolean u() {
        return this.i;
    }

    public final by f() {
        return this.c;
    }

    public class a implements ATCustomLoadListener {
        ATBaseAdAdapter a;
        e b;

        /* synthetic */ a(e eVar, e eVar2, ATBaseAdAdapter aTBaseAdAdapter, byte b) {
            this(eVar2, aTBaseAdAdapter);
        }

        private a(e eVar, ATBaseAdAdapter aTBaseAdAdapter) {
            this.b = eVar;
            this.a = aTBaseAdAdapter;
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdDataLoaded() {
            e.d(e.this);
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.z, new Runnable() { // from class: com.anythink.core.common.v.e.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.a != null) {
                            a.this.b.q();
                        }
                    }
                }
            }));
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(final BaseAd... baseAdArr) {
            com.anythink.core.common.n.e.a().d();
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.y, new Runnable() { // from class: com.anythink.core.common.v.e.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.a != null) {
                            a.this.b.a(a.this.a, baseAdArr);
                            a.this.b = null;
                            a.this.a = null;
                        }
                    }
                }
            }));
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(final String str, final String str2) {
            com.anythink.core.common.n.e.a().d();
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.A, new Runnable() { // from class: com.anythink.core.common.v.e.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.a != null) {
                            b bVar = new b();
                            bVar.c = 0;
                            bVar.d = ErrorCode.getErrorCode(ErrorCode.noADError, str, str2);
                            bVar.e = SystemClock.elapsedRealtime() - e.this.k;
                            a.this.b.a(a.this.a, bVar);
                            a.this.b = null;
                            a.this.a = null;
                        }
                    }
                }
            }));
        }
    }

    private void a(long j) {
        if (j == -1) {
            return;
        }
        this.n = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.di, new AnonymousClass2());
        com.anythink.core.common.s.c.a().a(this.n, j);
    }

    private void b(long j) {
        if (j == -1) {
            return;
        }
        this.m = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dj, new AnonymousClass3());
        com.anythink.core.common.s.c.a().a(this.m, j);
    }

    static /* synthetic */ Context a(e eVar) {
        Context contextM = eVar.o.b.get();
        if (!(contextM instanceof Activity)) {
            contextM = s.b().M();
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.d(a, "requestContext = ".concat(String.valueOf(contextM)));
        }
        return contextM;
    }

    static /* synthetic */ void a(e eVar, Context context, by byVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.e.b.aX()) {
            u uVarA = u.a(s.b().g());
            try {
                boolean zB = uVarA.b(byVar.n());
                if (uVarA.b(byVar.n(), zB) && aTBaseAdAdapter.internalSetUserDataConsent(context, zB, ATSDK.isEUTraffic(eVar.o.a))) {
                    uVarA.a(byVar.n(), zB);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static /* synthetic */ void d(e eVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - eVar.k;
        eVar.l = j;
        n nVar = eVar.d;
        if (nVar != null) {
            nVar.r(j);
            eVar.d.l(jElapsedRealtime);
        }
    }
}
