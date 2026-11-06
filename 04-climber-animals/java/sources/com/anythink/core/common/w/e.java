package com.anythink.core.common.w;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.v;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bo;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bw;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.p;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.ak;
import com.anythink.core.common.v.l;
import com.anythink.core.common.v.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final String a = "e";
    String b;
    bv c;
    n d;
    String e;
    int f;
    ATBaseAdAdapter g;
    c h;
    boolean i;
    boolean j;
    long k;
    long l;
    com.anythink.core.common.t.b m;
    com.anythink.core.common.t.b n;
    d o;
    Boolean p;
    int q;
    String r;
    boolean s;

    public e(bv bvVar, int i) {
        this.c = bvVar;
        this.q = i;
        this.e = bvVar.z();
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

    /* JADX WARN: Code duplicated, block: B:35:0x00ba  */
    public final void a(bv bvVar) {
        boolean z;
        com.anythink.core.common.h.c cVarE;
        boolean z2;
        BaseAd baseAdB;
        ATBaseAdAdapter aTBaseAdAdapterA;
        p pVar;
        this.s = true;
        ad adVarR = this.c.R();
        if (adVarR != null && adVarR.p()) {
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
        if (this.c.o() && this.c.R() != null && !TextUtils.isEmpty(this.o.c)) {
            this.c.R().b(this.o.c);
        }
        bw bwVarA = com.anythink.core.common.a.a().a(this.b, this.c);
        if (bwVarA != null) {
            com.anythink.core.common.h.j jVarA = bwVarA.a(this.c.R());
            int iD = jVarA.d();
            if (this.c.n() == 1) {
                cVarE = jVarA.e();
                if (cVarE != null) {
                    this.c.toString();
                    z = true;
                } else {
                    z = false;
                }
            } else {
                com.anythink.core.common.h.c cVarA = jVarA.a();
                if (!jVarA.c() || cVarA == null) {
                    z = false;
                } else {
                    if (l.a(this.c, bvVar) >= 0) {
                        com.anythink.core.common.v.p.a(bvVar);
                        this.c.toString();
                    } else if (iD >= this.c.ay()) {
                        this.c.toString();
                    } else {
                        z = false;
                    }
                    z = true;
                }
                cVarE = cVarA;
            }
            this.c.toString();
        } else {
            this.c.toString();
            z = false;
            cVarE = null;
        }
        if (z) {
            c cVar = this.h;
            if (cVar != null) {
                cVar.a(cVarE.e().getTrackingInfo(), cVarE.e());
            }
            this.c.toString();
            a(cVarE.e(), this.c, cVarE);
            return;
        }
        this.c.toString();
        if (adVarR == null || !adVarR.t) {
            z2 = false;
            baseAdB = null;
            aTBaseAdAdapterA = null;
        } else {
            com.anythink.core.b.c.b bVar2 = adVarR.s;
            if (bVar2 != null) {
                aTBaseAdAdapterA = bVar2.a();
                baseAdB = bVar2.b();
            } else {
                baseAdB = null;
                aTBaseAdAdapterA = null;
            }
            adVarR.s = null;
            z2 = true;
        }
        if (aTBaseAdAdapterA != null || z2) {
            pVar = null;
        } else {
            p pVarA = u.a(this.c);
            pVar = pVarA;
            aTBaseAdAdapterA = pVarA != null ? pVarA.a : null;
        }
        if (aTBaseAdAdapterA == null) {
            if (this.h != null) {
                b bVar3 = new b();
                bVar3.c = 0;
                bVar3.e = z2 ? this.c.p() : 0L;
                String strA = z2 ? "" : this.c.m() + " does not exist!";
                if (pVar != null) {
                    strA = pVar.a(strA);
                }
                bVar3.d = ErrorCode.getErrorCode(z2 ? ErrorCode.c2sBiddingCacheError : ErrorCode.adapterNotExistError, "", strA);
                a((ATBaseAdAdapter) null, bVar3);
                return;
            }
            return;
        }
        n nVarA = aj.a(aTBaseAdAdapterA, this.d, this.c);
        this.d = nVarA;
        nVarA.m(ak.a(this.c, (ATBaseAdAdapter) null));
        c cVar2 = this.h;
        if (cVar2 != null) {
            cVar2.a(aTBaseAdAdapterA, String.valueOf(this.o.e.aq()));
        }
        c cVar3 = this.h;
        if (cVar3 != null) {
            cVar3.a(this.d);
        }
        long jH = this.c.H();
        if (jH != -1) {
            this.m = n();
            com.anythink.core.common.t.d.a().a(this.m, jH, false);
        }
        long jW = this.c.w();
        if (jW != -1) {
            this.n = n();
            com.anythink.core.common.t.d.a().a(this.n, jW, false);
        }
        this.k = SystemClock.elapsedRealtime();
        Context context = this.o.b.get();
        if (context != null && (context instanceof Activity)) {
            aTBaseAdAdapterA.refreshActivityContext((Activity) context);
        }
        if (z2) {
            c cVar4 = this.h;
            if (cVar4 != null) {
                cVar4.a(this.d, aTBaseAdAdapterA);
            }
            if (baseAdB != null) {
                a(aTBaseAdAdapterA, baseAdB);
                return;
            } else {
                a(aTBaseAdAdapterA, new BaseAd[0]);
                return;
            }
        }
        bv bvVar2 = this.c;
        Map<String, Object> mapI = i();
        String strValueOf = String.valueOf(this.o.e.aq());
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(aTBaseAdAdapterA, bvVar2, mapI);
        if (TextUtils.equals(strValueOf, "2")) {
            t.b().b(anonymousClass1);
        } else {
            com.anythink.core.common.v.b.b.a().b(anonymousClass1);
        }
    }

    private void a(long j) {
        if (j == -1) {
            return;
        }
        this.n = n();
        com.anythink.core.common.t.d.a().a(this.n, j, false);
    }

    private void b(long j) {
        if (j == -1) {
            return;
        }
        this.m = n();
        com.anythink.core.common.t.d.a().a(this.m, j, false);
    }

    private void g() {
        if (this.m != null) {
            com.anythink.core.common.t.d.a().b(this.m);
            this.m = null;
        }
    }

    private void h() {
        if (this.n != null) {
            com.anythink.core.common.t.d.a().b(this.n);
            this.n = null;
        }
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, bv bvVar) {
        Map<String, Object> mapI = i();
        String strValueOf = String.valueOf(this.o.e.aq());
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(aTBaseAdAdapter, bvVar, mapI);
        if (TextUtils.equals(strValueOf, "2")) {
            t.b().b(anonymousClass1);
        } else {
            com.anythink.core.common.v.b.b.a().b(anonymousClass1);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.w.e$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ATBaseAdAdapter a;
        final /* synthetic */ bv b;
        final /* synthetic */ Map c;

        AnonymousClass1(ATBaseAdAdapter aTBaseAdAdapter, bv bvVar, Map map) {
            this.a = aTBaseAdAdapter;
            this.b = bvVar;
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
                com.anythink.core.common.o.e.a().c();
                ATBaseAdAdapter aTBaseAdAdapter = this.a;
                Map<String, Object> map = this.c;
                n nVar = e.this.d;
                String str = e.this.e;
                Map map2 = this.c;
                e eVar = e.this;
                aTBaseAdAdapter.internalLoad(contextA, map, mapJ, new com.anythink.core.common.w.a(nVar, str, map2, new a(eVar, eVar, this.a, b)));
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

    private void a(Context context, bv bvVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.d.b.aX()) {
            v vVarA = v.a(t.b().g());
            try {
                boolean zB = vVarA.b(bvVar.g());
                if (vVarA.b(bvVar.g(), zB) && aTBaseAdAdapter.internalSetUserDataConsent(context, zB, ATSDK.isEUTraffic(this.o.a))) {
                    vVarA.a(bvVar.g(), zB);
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
        com.anythink.core.d.l lVar = this.o.e;
        String str = this.o.c;
        if (lVar == null) {
            return new HashMap();
        }
        n nVar = this.d;
        Map<String, Object> mapA = lVar.a(this.b, str, this.c, nVar != null ? nVar.a() : null);
        int iG = this.c.g();
        if (iG == 2) {
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.o.a).b(t.b().p());
            if (bVarB != null) {
                mapA.put(com.anythink.core.common.d.j.w.n, Boolean.valueOf(bVarB.v() == 1));
            }
            if (lVar.l() == 1) {
                mapA.put(com.anythink.core.common.d.j.w.q, Integer.valueOf(lVar.l()));
            } else {
                mapA.put(com.anythink.core.common.d.j.w.q, Integer.valueOf(this.c.az()));
            }
        } else if (iG == 6) {
            JSONObject jSONObjectA = com.anythink.core.common.v.p.a(this.o.a, str, this.b, lVar.aq(), this.f);
            if (lVar.aP() == 1) {
                mapA.put("tp_info", jSONObjectA.toString());
            }
        } else if (iG == 22) {
            com.anythink.core.common.v.f.a(lVar, mapA, this.c, this.o.i);
        } else if (iG == 76) {
            mapA.put("internal_vast_load_timeout", Long.valueOf(this.c.w()));
        }
        if (ak.a(this.c) && this.o.e.aK() == 1) {
            bo boVarA = com.anythink.core.a.a.a(this.o.a).a(this.b, this.o.e.aq());
            mapA.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_LOAD_SEQ, Integer.valueOf(boVarA != null ? boVarA.c : 0));
            synchronized (com.anythink.core.common.u.a().a(this.b)) {
                String strA = com.anythink.core.common.u.a().a(this.b, this.c.g());
                if (!TextUtils.isEmpty(strA)) {
                    mapA.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.CONTENT, strA);
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
        if (this.c.g() != 2) {
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
        com.anythink.core.common.u.e.a(this.b, this.d, "admob_content_urls", obj, string);
        return map;
    }

    private Context k() {
        Context contextM = this.o.b.get();
        if (!(contextM instanceof Activity)) {
            contextM = t.b().M();
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
        return !this.s || this.j || r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        if (l()) {
            return;
        }
        this.i = true;
        String str = this.e;
        c cVar = this.h;
        if (cVar != null) {
            cVar.a(this.r, str);
        }
    }

    private com.anythink.core.common.t.b n() {
        return new com.anythink.core.common.t.b() { // from class: com.anythink.core.common.w.e.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.w.e.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.m();
                    }
                });
            }
        };
    }

    private void o() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.k;
        this.l = j;
        n nVar = this.d;
        if (nVar != null) {
            nVar.q(j);
            this.d.k(jElapsedRealtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ATBaseAdAdapter aTBaseAdAdapter, BaseAd... baseAdArr) {
        if (l()) {
            return;
        }
        bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        long jP = unitGroupInfo.q() == 2 ? unitGroupInfo.p() : 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.d.r((jElapsedRealtime - this.k) + jP);
        this.d.l(jElapsedRealtime);
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

    private synchronized void a(ATBaseAdAdapter aTBaseAdAdapter, bv bvVar, com.anythink.core.common.h.c cVar) {
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
            cVar2.a(this.r, aTBaseAdAdapter, bvVar, cVar);
        }
    }

    public final synchronized void a(final ATBaseAdAdapter aTBaseAdAdapter, b bVar) {
        if (l()) {
            return;
        }
        g();
        h();
        if (aTBaseAdAdapter != null) {
            t.b().b(new Runnable() { // from class: com.anythink.core.common.w.e.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ATBaseAdAdapter aTBaseAdAdapter2 = aTBaseAdAdapter;
                        if (aTBaseAdAdapter2 != null) {
                            aTBaseAdAdapter2.internalDestory();
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

    private void q() {
        this.g = null;
    }

    public final Boolean c() {
        return this.p;
    }

    private boolean r() {
        return this.p != null;
    }

    public final boolean d() {
        return (r() && this.i) ? false : true;
    }

    public final int e() {
        return this.q;
    }

    private long s() {
        return this.k;
    }

    private boolean t() {
        return this.i;
    }

    public final bv f() {
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
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.w.e.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.a != null) {
                            a.this.b.p();
                        }
                    }
                }
            });
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(final BaseAd... baseAdArr) {
            com.anythink.core.common.o.e.a().d();
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.w.e.a.2
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
            });
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(final String str, final String str2) {
            com.anythink.core.common.o.e.a().d();
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.w.e.a.3
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
            });
        }
    }

    static /* synthetic */ Context a(e eVar) {
        Context contextM = eVar.o.b.get();
        if (!(contextM instanceof Activity)) {
            contextM = t.b().M();
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.d(a, "requestContext = ".concat(String.valueOf(contextM)));
        }
        return contextM;
    }

    static /* synthetic */ void a(e eVar, Context context, bv bvVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.d.b.aX()) {
            v vVarA = v.a(t.b().g());
            try {
                boolean zB = vVarA.b(bvVar.g());
                if (vVarA.b(bvVar.g(), zB) && aTBaseAdAdapter.internalSetUserDataConsent(context, zB, ATSDK.isEUTraffic(eVar.o.a))) {
                    vVarA.a(bvVar.g(), zB);
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
            nVar.q(j);
            eVar.d.k(jElapsedRealtime);
        }
    }
}
