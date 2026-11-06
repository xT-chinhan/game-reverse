package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRealTimeFilter;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.h.ac;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.af;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.bp;
import com.anythink.core.common.h.br;
import com.anythink.core.common.h.bs;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.ca;
import com.anythink.core.common.h.cc;
import com.anythink.core.common.h.ce;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.z;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ai;
import com.anythink.core.debugger.CoreDebuggerManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    protected Context a;
    protected String b;
    protected boolean d;
    n g;
    com.anythink.core.common.o.c i;
    com.anythink.core.common.o.d j;
    private boolean p;
    private long q;
    private final String w;
    private ATAdRequest x;
    private as y;
    private v.b z;
    private final String n = getClass().getSimpleName();
    protected String e = "";
    private String o = "";
    private boolean r = false;
    protected int f = 1;
    h.d k = new h.d() { // from class: com.anythink.core.common.f.6
        @Override // com.anythink.core.common.h.d
        public final void a(g gVar) {
            if (gVar != null) {
                gVar.b();
            }
        }
    };
    volatile int l = 0;
    private final Object A = new Object();
    private boolean B = false;
    private final a s = new a(this);
    private final com.anythink.core.common.a.c t = new com.anythink.core.common.a.c(this);
    private final com.anythink.core.c.f u = new com.anythink.core.c.f(this);
    private final w v = new w();
    protected ConcurrentHashMap<String, g> c = new ConcurrentHashMap<>(5);
    final List<ca> h = Collections.synchronizedList(new ArrayList(2));
    volatile bp m = new bp();

    private f w() {
        return this;
    }

    static /* synthetic */ boolean i(f fVar) {
        fVar.p = false;
        return false;
    }

    static /* synthetic */ long j(f fVar) {
        fVar.q = 0L;
        return 0L;
    }

    public final void a(com.anythink.core.common.o.c cVar) {
        this.i = cVar;
    }

    private void a(com.anythink.core.common.o.d dVar) {
        this.j = dVar;
    }

    public final com.anythink.core.common.o.d a() {
        return this.j;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    public static f a(Context context, String str, String str2) {
        f fVarA;
        byte b;
        f fVarA2 = t.a().a(str, str2);
        if (fVarA2 != null) {
            return fVarA2;
        }
        synchronized (f.class) {
            fVarA = t.a().a(str, str2);
            if (fVarA == null) {
                fVarA = new f(context, str, str2);
                int iHashCode = str2.hashCode();
                if (iHashCode != 49) {
                    if (iHashCode == 51 && str2.equals("3")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str2.equals("1")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0 || b == 1) {
                    fVarA.j = new com.anythink.core.common.o.a(str, str2);
                }
                t.a().a(str, str2, fVarA);
            }
        }
        return fVarA;
    }

    public f(Context context, String str, String str2) {
        this.a = context.getApplicationContext();
        this.b = str;
        this.w = str2;
        if (com.anythink.core.common.d.s.b().g() == null) {
            com.anythink.core.common.d.s.b().a(this.a);
        }
    }

    public final String b() {
        return this.w;
    }

    public final String c() {
        return this.b;
    }

    public final com.anythink.core.common.a.c d() {
        return this.t;
    }

    public final a e() {
        return this.s;
    }

    public final com.anythink.core.c.f f() {
        return this.u;
    }

    public final w g() {
        return this.v;
    }

    private void x() {
        synchronized (this.h) {
            this.h.clear();
        }
    }

    protected final void a(ca caVar, com.anythink.core.e.l lVar) {
        com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(this.b);
        if (lVarA != null) {
            boolean z = true;
            if (lVar != null && (TextUtils.equals(lVarA.am(), lVar.am()) || lVarA.bg())) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        synchronized (this.h) {
            this.h.add(caVar);
        }
    }

    public final int h() {
        List<ca> list = this.h;
        int i = 0;
        if (list != null) {
            synchronized (list) {
                Iterator<ca> it = this.h.iterator();
                while (it.hasNext()) {
                    ca next = it.next();
                    if (next == null || !next.a()) {
                        it.remove();
                    } else {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public final void i() {
        List<ca> list = this.h;
        if (list != null) {
            synchronized (list) {
                if (this.h.size() > 0) {
                    this.h.remove(0);
                }
            }
        }
    }

    protected final void j() {
        this.p = false;
        this.q = 0L;
        this.r = false;
    }

    protected final void k() {
        com.anythink.core.e.l lVarB = com.anythink.core.e.n.a(this.a).b(this.b);
        if (this.p || lVarB == null) {
            return;
        }
        this.p = true;
        this.q = System.currentTimeMillis();
    }

    private boolean y() {
        return System.currentTimeMillis() - this.q <= 2000;
    }

    public final void a(String str) {
        this.c.remove(str);
    }

    public final g b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.get(str);
    }

    public final void a(String str, double d, by byVar) {
        g gVar = this.c.get(str);
        if (gVar != null) {
            gVar.a(d, byVar);
        }
    }

    public final boolean l() {
        g gVar;
        if (this.d) {
            return true;
        }
        return (TextUtils.isEmpty(this.e) || (gVar = this.c.get(this.e)) == null || gVar.d()) ? false : true;
    }

    public final String m() {
        return this.e;
    }

    public final ATAdRequest n() {
        return this.x;
    }

    private as z() {
        return this.y;
    }

    public final void a(final Context context, final String str, final String str2, final as asVar, final com.anythink.core.common.d.a aVar) {
        if (!com.anythink.core.common.d.s.b().A()) {
            com.anythink.core.common.d.s.b().c = true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (asVar != null && asVar.n != 0) {
            jElapsedRealtime = asVar.n;
        }
        final long j = jElapsedRealtime;
        final Map<String, Object> mapR = r();
        final int[] iArr = {0};
        if (mapR.containsKey(bx.X)) {
            try {
                iArr[0] = ((Integer) mapR.get(bx.X)).intValue();
            } catch (Throwable unused) {
            }
        }
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.az, new Runnable() { // from class: com.anythink.core.common.f.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.e.l lVar;
                long j2;
                String strA;
                boolean z;
                com.anythink.core.e.l lVarD;
                com.anythink.core.common.d.s.b();
                com.anythink.core.common.d.s.e(f.this.a);
                Context contextG = com.anythink.core.common.d.s.b().g();
                String strP = com.anythink.core.common.d.s.b().p();
                String strQ = com.anythink.core.common.d.s.b().q();
                boolean zA = com.anythink.core.common.d.s.b().A();
                int i = asVar.c;
                if (asVar.m != null) {
                    asVar.m.b(System.currentTimeMillis());
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                if (asVar.n != 0) {
                    jElapsedRealtime2 = asVar.o;
                }
                com.anythink.core.e.n nVarA = com.anythink.core.e.n.a(context);
                com.anythink.core.e.l lVarA = f.a(zA, mapR);
                boolean zI = nVarA.i(str2);
                if (zA || lVarA != null) {
                    lVar = lVarA;
                    j2 = jElapsedRealtime2;
                } else {
                    if (i == 13) {
                        lVarD = nVarA.e(str2);
                    } else if (i == 14) {
                        lVarD = nVarA.f(str2);
                    } else {
                        lVarD = nVarA.d(str2);
                    }
                    com.anythink.core.e.l lVarG = nVarA.g(str2);
                    if (lVarD != null || lVarG == null) {
                        lVar = lVarD;
                        j2 = 0;
                    } else {
                        j2 = jElapsedRealtime2;
                        lVar = lVarG;
                    }
                }
                if (TextUtils.isEmpty(asVar.a)) {
                    strA = com.anythink.core.common.u.o.a(context);
                    asVar.a = strA;
                } else {
                    strA = asVar.a;
                }
                String str3 = strA;
                com.anythink.core.e.l lVar2 = lVar;
                com.anythink.core.common.h.n nVarA2 = ai.a(str3, str2, lVar, i, iArr[0], asVar.g, asVar.i, zI ? 1 : 2, asVar.b(), f.this);
                nVarA2.k(j);
                nVarA2.d(j2);
                nVarA2.K(str);
                Map<String, Object> map = mapR;
                if (map != null) {
                    nVarA2.b(map);
                }
                synchronized (f.this) {
                    if (!f.this.l() || asVar.c == 0) {
                        if (f.a(f.this) || asVar.c != 5) {
                            if (f.this.B() && asVar.c == 0) {
                                Log.e("anythink", "PlacementId(" + str2 + ") the load api calls are not allowed in Auto-load mode");
                                return;
                            }
                            if (f.this.g == null) {
                                f.this.g = new n(f.this);
                            }
                            n nVar = f.this.g;
                            String str4 = str2;
                            String str5 = str;
                            nVar.a = str4;
                            nVar.b = str5;
                            f.this.g.a(aVar);
                            asVar.e = f.this.g;
                            if (asVar.c != 4 && asVar.c != 5) {
                                f.this.f = 1;
                            } else {
                                f.this.f++;
                            }
                            f.c(f.this);
                            f fVar = f.this;
                            String str6 = asVar.a;
                            com.anythink.core.common.d.a aVar2 = aVar;
                            if (fVar.i != null) {
                                fVar.i.a(str6, aVar2);
                            }
                            f.this.y = asVar;
                            f.this.x = asVar.b();
                            if (contextG == null || TextUtils.isEmpty(strP) || TextUtils.isEmpty(strQ) || com.anythink.core.common.u.p.a(str2)) {
                                f.this.a(asVar, ErrorCode.getErrorCode(ErrorCode.appIdOrPlaceIdEmpty, "", ""));
                                if (com.anythink.core.common.d.s.b().G()) {
                                    Log.e("anythink", "Please check these params in your code (AppId: " + strP + ", AppKey: " + strQ + ", PlacementId: " + str2 + ")");
                                }
                                f.this.d = false;
                                return;
                            }
                            if (lVar2 != null) {
                                try {
                                    try {
                                        f.this.c(lVar2, nVarA2);
                                        f.a(lVar2, nVarA2);
                                        f.b(lVar2, nVarA2);
                                    } catch (com.anythink.core.common.h.m e) {
                                        f.this.a(true, nVarA2, (Throwable) e, asVar);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            if (!asVar.d()) {
                                int iH = f.this.h();
                                if (iH <= 0 || lVar2 == null) {
                                    z = false;
                                } else {
                                    com.anythink.core.common.h.c cVarA = f.this.s.a(context, str2);
                                    if (cVarA != null) {
                                        if (iH >= lVar2.r()) {
                                            nVarA2.b(false);
                                            nVarA2.L(4);
                                            by byVarO = cVarA.o();
                                            if (byVarO != null) {
                                                nVarA2.a(byVarO);
                                            }
                                            nVarA2.b(1);
                                            com.anythink.core.common.t.e.a(contextG);
                                            com.anythink.core.common.t.e.a(10, nVarA2);
                                            com.anythink.core.common.t.e.a(contextG);
                                            com.anythink.core.common.t.e.a(12, nVarA2);
                                            f.this.d = false;
                                            com.anythink.core.common.d.a aVar3 = aVar;
                                            if (aVar3 != null) {
                                                aVar3.onAdLoaded();
                                                f.this.g.b(aVar);
                                            }
                                            return;
                                        }
                                        z = false;
                                        com.anythink.core.common.d.a aVar4 = aVar;
                                        if (aVar4 != null) {
                                            aVar4.onAdLoaded();
                                            f.this.g.b(aVar);
                                        }
                                        as asVar2 = asVar;
                                        asVar2.b = asVar2.c;
                                        nVarA2.D(asVar.b);
                                        asVar.c = 9;
                                        nVarA2.C(asVar.c);
                                    } else {
                                        z = false;
                                        f.e(f.this);
                                    }
                                }
                            } else {
                                z = false;
                                f.e(f.this);
                            }
                            if (lVar2 != null && f.this.p) {
                                long jCurrentTimeMillis = System.currentTimeMillis() - f.this.q;
                                if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < lVar2.aC()) {
                                    AdError errorCode = ErrorCode.getErrorCode(ErrorCode.loadFailInPacingError, "", "");
                                    nVarA2.L(7);
                                    if (!f.this.r) {
                                        z = true;
                                    }
                                    f.this.a(z, nVarA2, new com.anythink.core.common.h.m(errorCode, errorCode.printStackTrace()), asVar);
                                    f.this.r = true;
                                    return;
                                }
                            }
                            f.i(f.this);
                            f.j(f.this);
                            f.this.r = z;
                            com.anythink.core.a.c.a();
                            int iA = com.anythink.core.a.c.a(contextG, str);
                            if (iA != -1) {
                                String str7 = ErrorCode.loadCappingError;
                                if (iA == 9) {
                                    str7 = ErrorCode.loadCappingError_Global;
                                } else if (iA == 10) {
                                    str7 = ErrorCode.loadCappingError_Format;
                                }
                                AdError errorCode2 = ErrorCode.getErrorCode(str7, "", "");
                                nVarA2.L(iA);
                                f.this.a(true, nVarA2, (Throwable) new com.anythink.core.common.h.m(errorCode2, errorCode2.printStackTrace()), asVar);
                                return;
                            }
                            if (lVar2 != null) {
                                com.anythink.core.a.c.a();
                                int iA2 = com.anythink.core.a.c.a(contextG, str2, lVar2);
                                if (iA2 != -1) {
                                    AdError errorCode3 = ErrorCode.getErrorCode(ErrorCode.loadCappingError, "", "");
                                    nVarA2.L(iA2);
                                    f.this.a(true, nVarA2, (Throwable) new com.anythink.core.common.h.m(errorCode3, errorCode3.printStackTrace()), asVar);
                                    return;
                                }
                            }
                            if (f.this.l()) {
                                Log.i("anythink", "Placement(" + str2 + ") is loading.");
                                e.a(asVar.g, e.c, f.this.o, f.this.e);
                                return;
                            }
                            nVarA.h(str2);
                            f.this.d = true;
                            Iterator<g> it = f.this.c.values().iterator();
                            while (it.hasNext()) {
                                it.next().g();
                            }
                            com.anythink.core.common.d.s.b().d(context);
                            int i2 = (zA || !(lVar2 == null || lVar2.aO() || zI)) ? 2 : 3;
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            if (asVar.m != null) {
                                asVar.m.c(jCurrentTimeMillis2);
                                asVar.m.d(jCurrentTimeMillis2);
                            }
                            f.a(f.this, context, strP, strQ, lVar2, asVar, nVarA2, str, str3, i2);
                        }
                    }
                }
            }
        }), false);
    }

    private static void a(String str, String str2, as asVar) {
        if (asVar.c == 0 || asVar.c == 3) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            t.a().a(str2, stackTrace);
            if (TextUtils.equals(str, "4")) {
                return;
            }
            t.a().a(str2, com.anythink.core.common.u.o.a(stackTrace));
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.core.e.n.b {
        final /* synthetic */ com.anythink.core.common.h.n a;
        final /* synthetic */ String b;
        final /* synthetic */ as c;
        final /* synthetic */ com.anythink.core.e.l d;
        final /* synthetic */ String e;

        AnonymousClass3(com.anythink.core.common.h.n nVar, String str, as asVar, com.anythink.core.e.l lVar, String str2) {
            this.a = nVar;
            this.b = str;
            this.c = asVar;
            this.d = lVar;
            this.e = str2;
        }

        @Override // com.anythink.core.e.n.b
        public final void a() {
            com.anythink.core.common.h.n nVar = this.a;
            if (nVar != null) {
                nVar.h(SystemClock.elapsedRealtime());
            }
        }

        @Override // com.anythink.core.e.n.b
        public final void b() {
            com.anythink.core.common.h.n nVar = this.a;
            if (nVar != null) {
                nVar.i(SystemClock.elapsedRealtime());
            }
        }

        @Override // com.anythink.core.e.n.b
        public final void a(final com.anythink.core.e.l lVar) {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ax, new Runnable() { // from class: com.anythink.core.common.f.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass3.a(AnonymousClass3.this, lVar);
                }
            }));
        }

        private void c(com.anythink.core.e.l lVar) {
            com.anythink.core.common.h.n nVar;
            synchronized (f.this) {
                ai.a(this.a, lVar);
                if (!TextUtils.equals(String.valueOf(lVar != null ? lVar.ap() : 0), this.b)) {
                    AdError errorCode = ErrorCode.getErrorCode(ErrorCode.formatError, "", "Format corresponding to API: " + com.anythink.core.common.u.o.f(this.b) + ", Format corresponding to placement strategy: " + com.anythink.core.common.u.o.f(String.valueOf(lVar.ap())));
                    f.this.a(this.c, errorCode);
                    this.a.b(false);
                    com.anythink.core.common.t.f.a(this.a, errorCode);
                    f.this.d = false;
                    return;
                }
                if (this.d == null && lVar != null) {
                    try {
                        f.this.c(lVar, this.a);
                    } catch (com.anythink.core.common.h.m e) {
                        f.this.a(true, this.a, (Throwable) e, this.c);
                        return;
                    } catch (Throwable th) {
                        f.this.a(true, this.a, th, this.c);
                        return;
                    }
                }
                if (lVar != null && (nVar = this.a) != null) {
                    nVar.j(SystemClock.elapsedRealtime());
                    if (lVar.bJ()) {
                        this.a.a(2);
                    } else {
                        this.a.a(1);
                    }
                }
                long jBH = lVar != null ? lVar.bH() : 0L;
                int iBI = lVar != null ? lVar.bI() : 0;
                com.anythink.core.common.h.h hVar = this.c.m;
                if (hVar != null) {
                    hVar.e((lVar == null || lVar.bJ()) ? jBH : 0L);
                    hVar.f(System.currentTimeMillis());
                    hVar.a(iBI);
                }
                f fVar = f.this;
                f.a(fVar, fVar.a, f.this.b, this.e, lVar, this.a, this.c);
            }
        }

        @Override // com.anythink.core.e.n.b
        public final void a(AdError adError) {
            String str = com.anythink.core.common.d.i.s.n;
            String str2 = f.this.b;
            String strF = com.anythink.core.common.u.o.f(this.b);
            String strPrintStackTrace = adError.printStackTrace();
            if (ATSDK.isNetworkLogDebug()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", com.anythink.core.common.d.i.s.E);
                    jSONObject.put("result", str);
                    jSONObject.put("placementId", str2);
                    jSONObject.put("adtype", strF);
                    jSONObject.put(MediationConstant.KEY_ERROR_MSG, strPrintStackTrace);
                    aa.a("anythink_network", jSONObject.toString(), TextUtils.equals(com.anythink.core.common.d.i.s.n, str));
                } catch (Throwable unused) {
                }
            }
            if (adError.getCode().equals(ErrorCode.statuError)) {
                adError = ErrorCode.getErrorCode(ErrorCode.placeStrategyError, adError.getPlatformCode(), adError.getPlatformMSG());
            }
            this.a.L(5);
            f.this.a(true, this.a, adError, this.c);
        }

        @Override // com.anythink.core.e.n.b
        public final void b(com.anythink.core.e.l lVar) {
            if (lVar.bg()) {
                return;
            }
            f.e(f.this);
        }

        static /* synthetic */ void a(AnonymousClass3 anonymousClass3, com.anythink.core.e.l lVar) {
            com.anythink.core.common.h.n nVar;
            synchronized (f.this) {
                ai.a(anonymousClass3.a, lVar);
                if (!TextUtils.equals(String.valueOf(lVar != null ? lVar.ap() : 0), anonymousClass3.b)) {
                    AdError errorCode = ErrorCode.getErrorCode(ErrorCode.formatError, "", "Format corresponding to API: " + com.anythink.core.common.u.o.f(anonymousClass3.b) + ", Format corresponding to placement strategy: " + com.anythink.core.common.u.o.f(String.valueOf(lVar.ap())));
                    f.this.a(anonymousClass3.c, errorCode);
                    anonymousClass3.a.b(false);
                    com.anythink.core.common.t.f.a(anonymousClass3.a, errorCode);
                    f.this.d = false;
                    return;
                }
                if (anonymousClass3.d == null && lVar != null) {
                    try {
                        f.this.c(lVar, anonymousClass3.a);
                    } catch (com.anythink.core.common.h.m e) {
                        f.this.a(true, anonymousClass3.a, (Throwable) e, anonymousClass3.c);
                        return;
                    } catch (Throwable th) {
                        f.this.a(true, anonymousClass3.a, th, anonymousClass3.c);
                        return;
                    }
                }
                if (lVar != null && (nVar = anonymousClass3.a) != null) {
                    nVar.j(SystemClock.elapsedRealtime());
                    if (lVar.bJ()) {
                        anonymousClass3.a.a(2);
                    } else {
                        anonymousClass3.a.a(1);
                    }
                }
                long jBH = lVar != null ? lVar.bH() : 0L;
                int iBI = lVar != null ? lVar.bI() : 0;
                com.anythink.core.common.h.h hVar = anonymousClass3.c.m;
                if (hVar != null) {
                    hVar.e((lVar == null || lVar.bJ()) ? jBH : 0L);
                    hVar.f(System.currentTimeMillis());
                    hVar.a(iBI);
                }
                f fVar = f.this;
                f.a(fVar, fVar.a, f.this.b, anonymousClass3.e, lVar, anonymousClass3.a, anonymousClass3.c);
            }
        }
    }

    private void a(Context context, String str, String str2, com.anythink.core.e.l lVar, as asVar, com.anythink.core.common.h.n nVar, String str3, String str4, int i) {
        com.anythink.core.e.n.a(context).a(lVar, str, str2, this.b, asVar.g, new AnonymousClass3(nVar, str3, asVar, lVar, str4), i, false, asVar.b(), true, null);
    }

    public final void o() {
        try {
            t.a().a(this.b, com.anythink.core.common.u.o.a(new Throwable().getStackTrace()));
        } catch (Throwable unused) {
        }
    }

    private void a(Context context, String str, String str2, com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar, as asVar) {
        if (nVar != null) {
            nVar.f(SystemClock.elapsedRealtime());
        }
        com.anythink.core.common.v.b.h hVar = new com.anythink.core.common.v.b.h(context, str, lVar, new AnonymousClass4(asVar, context, str, str2, lVar, nVar));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new com.anythink.core.common.v.b.e());
        new com.anythink.core.common.v.b.g(arrayList, hVar, 0).a(hVar);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$4, reason: invalid class name */
    final class AnonymousClass4 implements com.anythink.core.common.v.b.b {
        final /* synthetic */ as a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ com.anythink.core.e.l e;
        final /* synthetic */ com.anythink.core.common.h.n f;

        AnonymousClass4(as asVar, Context context, String str, String str2, com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar) {
            this.a = asVar;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = lVar;
            this.f = nVar;
        }

        @Override // com.anythink.core.common.v.b.b
        public final void a() {
            if (this.a.m != null) {
                this.a.m.g(System.currentTimeMillis());
            }
            com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ay, new Runnable() { // from class: com.anythink.core.common.f.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    f.b(f.this, AnonymousClass4.this.b, AnonymousClass4.this.c, AnonymousClass4.this.d, AnonymousClass4.this.e, AnonymousClass4.this.f, AnonymousClass4.this.a);
                }
            }), false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:127:0x038b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    private void b(Context context, String str, String str2, com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar, as asVar) {
        char c;
        by byVar;
        Context context2;
        ac acVar;
        long jBM;
        int iBv;
        int i;
        g gVar;
        bs bsVar;
        cc ccVar;
        ac acVar2;
        List<by> list;
        ce ceVar;
        boolean z;
        boolean z2;
        boolean z3;
        Map<String, Object> map;
        br brVar;
        com.anythink.core.common.a.c cVar;
        boolean z4 = "";
        as asVarAp = lVar.ap();
        com.anythink.core.common.t.f.a("1", nVar, str2, str, "", 0, (int) asVarAp, 0L);
        ce ceVar2 = new ce(asVar, lVar);
        ai.a(nVar, ceVar2);
        try {
            try {
                if (!lVar.bk()) {
                    nVar.L(5);
                    throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
                }
                com.anythink.core.a.b.a(this.a).a(this.b, lVar);
                a(lVar, nVar);
                b(lVar, nVar);
                br brVarA = com.anythink.core.common.u.ac.a(lVar, nVar);
                com.anythink.core.common.h.n nVarC = brVarA.c();
                if (brVarA.b() == 0) {
                    nVarC.L(5);
                    if (brVarA.a().E() == 1) {
                        throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                    }
                    throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                }
                if (brVarA.i()) {
                    boolean zK = brVarA.k();
                    ArrayList arrayList = new ArrayList(1);
                    com.anythink.core.common.u.ac.b(brVarA, arrayList);
                    List<by> listD = brVarA.d();
                    if (listD != null && !listD.isEmpty()) {
                        com.anythink.core.common.u.ac.a(lVar, brVarA.c(), listD);
                    }
                    List<by> listA = com.anythink.core.common.u.ac.a(brVarA, brVarA.d());
                    this.s.b(str);
                    boolean z5 = arrayList.size() > 0;
                    boolean z6 = !z5 && (brVarA.e() == null || brVarA.e().size() == 0);
                    nVar.g(SystemClock.elapsedRealtime());
                    if (z6 && ((listA == null || listA.size() == 0) && ((brVarA.f() == null || brVarA.f().size() == 0) && ((brVarA.g() == null || brVarA.g().size() == 0) && (brVarA.h() == null || brVarA.h().size() == 0))))) {
                        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                        nVar.L(6);
                        a(true, nVar, errorCode, asVar);
                        this.d = false;
                        return;
                    }
                    com.anythink.core.a.c.a();
                    com.anythink.core.a.c.b(this.a, str, lVar);
                    Map<String, Object> mapR = r();
                    w wVar = this.v;
                    cc ccVarRemove = (wVar == null || wVar.a == null) ? null : wVar.a.remove(str);
                    bs bsVarA = u.a(this.a).a(str, str2);
                    ac acVarA = d.a().a(str);
                    ac acVar3 = new ac(str2);
                    boolean z7 = z5;
                    boolean z8 = z6;
                    d.a().a(this.b, acVar3);
                    nVar.b(true);
                    nVar.B(ceVar2.f());
                    g gVar2 = new g(asVar.a(), this);
                    gVar2.h = mapR;
                    gVar2.i = nVar;
                    gVar2.a(asVar);
                    gVar2.a(asVar.d);
                    this.e = str2;
                    this.o = nVar.aJ();
                    List<by> listA2 = com.anythink.core.e.u.a(lVar, lVar.Z());
                    if (listA2.size() > 0) {
                        c = 0;
                        byVar = listA2.get(0);
                    } else {
                        c = 0;
                        byVar = null;
                    }
                    if (byVar != null) {
                        for (by byVar2 : brVarA.e()) {
                            if (!byVar2.G().equals(byVar.G()) || (cVar = this.t) == null) {
                                gVar = gVar2;
                                bsVar = bsVarA;
                                ccVar = ccVarRemove;
                                acVar2 = acVarA;
                                list = listA;
                                ceVar = ceVar2;
                                z = zK;
                                z2 = z7;
                                z3 = z8;
                                c = 0;
                                map = mapR;
                                brVar = brVarA;
                            } else {
                                gVar = gVar2;
                                z2 = z7;
                                z3 = z8;
                                c = 0;
                                bsVar = bsVarA;
                                ccVar = ccVarRemove;
                                acVar2 = acVarA;
                                ceVar = ceVar2;
                                z = zK;
                                map = mapR;
                                brVar = brVarA;
                                list = listA;
                                com.anythink.core.common.a.c.a aVarA = cVar.a(context, str, str2, byVar2, lVar, map, this.x);
                                if (aVarA != null) {
                                    by byVarD = aVarA.d();
                                    if (com.anythink.core.common.u.ac.a(0, nVar, byVarD, (z) null) != null) {
                                        this.t.a(str, byVarD.G());
                                    } else {
                                        gVar.J = aVarA;
                                    }
                                    nVar.e(SystemClock.elapsedRealtime());
                                }
                            }
                            gVar2 = gVar;
                            ceVar2 = ceVar;
                            mapR = map;
                            brVarA = brVar;
                            z7 = z2;
                            z8 = z3;
                            bsVarA = bsVar;
                            ccVarRemove = ccVar;
                            acVarA = acVar2;
                            zK = z;
                            listA = list;
                        }
                    }
                    g gVar3 = gVar2;
                    bs bsVar2 = bsVarA;
                    cc ccVar2 = ccVarRemove;
                    ac acVar4 = acVarA;
                    List<by> list2 = listA;
                    ce ceVar3 = ceVar2;
                    boolean z9 = zK;
                    boolean z10 = z7;
                    boolean z11 = z8;
                    br brVar2 = brVarA;
                    com.anythink.core.common.t.e.a(this.a);
                    com.anythink.core.common.t.e.a(10, nVar);
                    boolean z12 = 1;
                    z12 = 1;
                    Double[] dArr = new Double[1];
                    Boolean boolBo = lVar.bo();
                    if (brVar2.j() || (boolBo != null && boolBo.booleanValue())) {
                        context2 = context;
                        acVar = acVar3;
                        com.anythink.core.common.h.c cVarA = this.s.a(context2, str);
                        if (cVarA != null) {
                            dArr[c] = Double.valueOf(cVarA.n());
                        }
                    } else {
                        context2 = context;
                        acVar = acVar3;
                    }
                    com.anythink.core.common.b.c cVarA2 = com.anythink.core.common.b.f.a().a(lVar);
                    boolean z13 = (cVarA2 == null || !cVarA2.f()) ? c : 1;
                    boolean zBL = lVar.bL();
                    if (z13 == 0 && !zBL) {
                        z12 = c;
                    }
                    if (z12 == 0 || z13 != 0) {
                        jBM = -1;
                    } else {
                        Long biddingWaitMaxTime = ATAdRealTimeFilter.getInstance().getBiddingWaitMaxTime();
                        if (biddingWaitMaxTime != null) {
                            jBM = biddingWaitMaxTime.longValue();
                        } else {
                            jBM = lVar.bM() > 0 ? lVar.bM() : 5000L;
                        }
                    }
                    long j = jBM;
                    com.anythink.core.common.v.i iVar = new com.anythink.core.common.v.i(list2);
                    com.anythink.core.common.v.h hVar = new com.anythink.core.common.v.h();
                    hVar.a = str;
                    hVar.b = str2;
                    hVar.c = ceVar3;
                    hVar.d = list2;
                    hVar.e = brVar2.h();
                    hVar.i = z11;
                    hVar.j = nVar.aM();
                    hVar.k = ccVar2;
                    hVar.m = bsVar2;
                    hVar.l = iVar;
                    hVar.o = acVar4;
                    hVar.n = acVar;
                    hVar.f = brVar2.f();
                    hVar.g = brVar2.g();
                    Double d = dArr[0];
                    hVar.h = d != null ? d.doubleValue() : 0.0d;
                    hVar.p = brVar2.e();
                    hVar.q = z13;
                    gVar3.a(hVar);
                    this.c.put(str2, gVar3);
                    if (asVar != null && lVar != null && ((i = asVar.c) == 0 || i == 3)) {
                        String strV = lVar.v();
                        if (!TextUtils.isEmpty(strV) && v.a().a(lVar)) {
                            this.z = new AnonymousClass8(asVar, gVar3);
                            v.a().a(this.b, strV, this.z);
                        }
                    }
                    if (asVar.m != null) {
                        asVar.m.h(System.currentTimeMillis());
                    }
                    com.anythink.core.common.t.f.a(asVar.m, nVar);
                    h hVar2 = new h(str, gVar3);
                    gVar3.a(hVar2);
                    hVar2.a(lVar, z9);
                    hVar2.a(this.k);
                    if (z11 || z12 == 0) {
                        hVar2.a();
                    }
                    this.d = false;
                    if (!z11) {
                        List<by> listE = brVar2.e();
                        try {
                            com.anythink.core.common.h.a aVar = new com.anythink.core.common.h.a();
                            aVar.b = context2;
                            aVar.c = asVar;
                            aVar.d = str2;
                            aVar.e = str;
                            aVar.f = lVar.ap();
                            aVar.g = lVar.aa();
                            aVar.h = lVar.W();
                            aVar.i = lVar.F();
                            i.a();
                            aVar.l = i.a(lVar, z10);
                            i.a();
                            aVar.o = i.a(lVar);
                            i.a();
                            aVar.p = i.b(lVar);
                            aVar.j = listE;
                            aVar.n = ceVar3;
                            aVar.s = nVar;
                            aVar.v = ccVar2;
                            aVar.w = bsVar2;
                            aVar.x = acVar4;
                            aVar.q = r();
                            aVar.m = z10;
                            if (asVar.c == 8) {
                                aVar.t = 7;
                            }
                            aVar.y = iVar;
                            aVar.A = asVar.l;
                            aVar.B = d.a().b(this.b);
                            if (boolBo == null || !boolBo.booleanValue()) {
                                iBv = 0;
                            } else {
                                iBv = 0;
                                Double d2 = dArr[0];
                                if (d2 != null) {
                                    aVar.C = d2.doubleValue();
                                }
                            }
                            if (z9 && lVar.bv() > 0) {
                                iBv = lVar.bv();
                            }
                            aVar.D = iBv;
                            aVar.E = lVar.bE();
                            aVar.F = hVar2;
                            aVar.I = cVarA2;
                            aVar.G = z12;
                            aVar.H = j;
                            aVar.J = this;
                            aVar.K = lVar.k();
                            com.anythink.core.c.b bVar = new com.anythink.core.c.b(aVar);
                            bVar.a(ATSDK.isNetworkLogDebug());
                            bVar.a(new AnonymousClass5(ceVar3, gVar3));
                        } catch (Throwable th) {
                            com.anythink.core.common.t.f.b("notifyBiddingFinish error", th.getMessage() + ", " + com.anythink.core.common.u.p.a(th.getStackTrace()), com.anythink.core.common.d.s.b().r());
                            gVar3.f();
                        }
                    }
                    if (asVar.c == 0 || asVar.c == 3) {
                        v.a().a(lVar, 15, asVar, nVar);
                        return;
                    }
                    return;
                }
                nVarC.L(6);
                AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                throw new com.anythink.core.common.h.m(errorCode2, errorCode2.printStackTrace());
            } catch (com.anythink.core.common.h.m e) {
                e = e;
                a(z4, nVar, e, asVarAp);
            } catch (Throwable th2) {
                th = th2;
                a(z4, nVar, th, asVarAp);
            }
        } catch (com.anythink.core.common.h.m e2) {
            e = e2;
            z4 = 1;
            asVarAp = asVar;
        } catch (Throwable th3) {
            th = th3;
            z4 = 1;
            asVarAp = asVar;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$5, reason: invalid class name */
    final class AnonymousClass5 implements j.a {
        final /* synthetic */ ce a;
        final /* synthetic */ g b;

        AnonymousClass5(ce ceVar, g gVar) {
            this.a = ceVar;
            this.b = gVar;
        }

        @Override // com.anythink.core.common.j.a
        public final void a(String str, List<by> list, List<by> list2, boolean z) {
            boolean zD = this.a.d();
            ArrayList arrayList = null;
            for (by byVar : list2) {
                if (zD && (byVar.y() == 1 || byVar.y() == 3)) {
                    if (byVar.ab() != 1) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(4);
                        }
                        byVar.G(7);
                        arrayList.add(byVar);
                    }
                }
                if (!zD && byVar.x() != 0) {
                    c cVarA = c.a();
                    cVarA.c.put(byVar.G(), Long.valueOf(System.currentTimeMillis()));
                }
            }
            this.b.a(list, list2, arrayList, list2);
            if (z) {
                this.b.f();
            }
        }

        @Override // com.anythink.core.common.j.a
        public final void a(String str) {
            this.b.e();
        }

        @Override // com.anythink.core.common.j.a
        public final void a(Double d) {
            g gVar = this.b;
            if (gVar.I != null) {
                gVar.I.a(d);
            }
        }
    }

    private static void d(com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar) {
        if (lVar.bk()) {
            return;
        }
        nVar.L(5);
        throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
    }

    private static void a(br brVar) {
        com.anythink.core.common.h.n nVarC = brVar.c();
        if (brVar.b() == 0) {
            nVarC.L(5);
            if (brVar.a().E() == 1) {
                throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
            }
            throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
        }
        if (brVar.i()) {
            return;
        }
        nVarC.L(6);
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
        throw new com.anythink.core.common.h.m(errorCode, errorCode.printStackTrace());
    }

    private void a(com.anythink.core.e.l lVar) {
        com.anythink.core.a.b.a(this.a).a(this.b, lVar);
    }

    protected static void a(com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar) {
        com.anythink.core.a.a.a(com.anythink.core.common.d.s.b().g());
        int iA = com.anythink.core.a.a.a(lVar, nVar.aQ());
        if (iA != -1) {
            String str = ErrorCode.outOfCapError;
            if (iA != 2) {
                switch (iA) {
                    case 7:
                        str = ErrorCode.outOfCapError_day_Global;
                        break;
                    case 8:
                        str = ErrorCode.outOfCapError_day_Format;
                        break;
                    case 9:
                        str = ErrorCode.outOfCapError_hour_Global;
                        break;
                    case 10:
                        str = ErrorCode.outOfCapError_hour_Format;
                        break;
                }
            }
            nVar.L(1);
            throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(str, "", ""), "Capping.");
        }
    }

    protected static void b(com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar) {
        com.anythink.core.a.d.a();
        int iA = com.anythink.core.a.d.a(nVar.aQ(), lVar);
        if (iA != -1) {
            nVar.L(2);
            String str = ErrorCode.inPacingError;
            if (iA != 3) {
                if (iA == 11) {
                    str = ErrorCode.inPacingError_Global;
                } else if (iA == 12) {
                    str = ErrorCode.inPacingError_Format;
                }
            }
            throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(str, "", ""), "Pacing.");
        }
    }

    protected final void c(com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar) {
        com.anythink.core.common.b.f fVarA = com.anythink.core.common.b.f.a();
        int iG = com.anythink.core.common.b.f.g();
        int iH = com.anythink.core.common.b.f.h();
        int i = com.anythink.core.common.b.f.i();
        int iA = fVarA.a(this.b, lVar);
        com.anythink.core.common.b.a aVarJ = fVarA.j();
        com.anythink.core.common.b.d dVarA = fVarA.a(this.b);
        nVar.ao(iG);
        nVar.an(iH);
        nVar.am(i);
        nVar.ap(iA);
        if (com.anythink.core.common.b.f.b()) {
            com.anythink.core.common.t.f.a(nVar, iA, iH, i, aVarJ != null ? aVarJ.d() : "", (dVarA == null || dVarA.b() == null) ? "" : dVarA.b().i(), aVarJ != null ? aVarJ.a() : null, dVarA != null ? dVarA.a() : null);
            if (fVarA.e()) {
                nVar.L(11);
                throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode("2036", "", "SDK disabled due to ANR circuit breaker"), "SDK disabled.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.anythink.core.common.h.n nVar, Throwable th, as asVar) {
        AdError errorCode;
        if (th instanceof com.anythink.core.common.h.m) {
            errorCode = ((com.anythink.core.common.h.m) th).a;
        } else {
            errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", th.getMessage());
        }
        a(z, nVar, errorCode, asVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.anythink.core.common.h.n nVar, AdError adError, as asVar) {
        this.d = false;
        nVar.b(false);
        if (z) {
            com.anythink.core.common.t.e.a(this.a);
            com.anythink.core.common.t.e.a(10, nVar);
            com.anythink.core.common.t.f.a(nVar, adError);
        }
        a(asVar, adError);
    }

    private void b(com.anythink.core.common.h.c cVar) {
        List<ca> list;
        if (cVar == null || (list = this.h) == null) {
            return;
        }
        synchronized (list) {
            if (this.h.size() > 0) {
                this.h.remove(0);
            }
        }
    }

    public final void a(com.anythink.core.common.h.c cVar) {
        com.anythink.core.common.h.n nVarI;
        b(cVar);
        if (cVar == null || (nVarI = cVar.i()) == null) {
            return;
        }
        String strAQ = nVarI.aQ();
        if (v.a().a(strAQ)) {
            v.a();
            f fVarB = v.b(strAQ, nVarI.aS());
            if (fVarB != null) {
                fVarB.b(cVar);
            }
        }
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        boolean zL = l();
        ae aeVar = new ae();
        aeVar.a(map);
        aeVar.a(this.x);
        com.anythink.core.common.h.c cVarB = b(context, true, false, aeVar);
        ATAdStatusInfo aTAdStatusInfo = new ATAdStatusInfo(zL, cVarB != null, cVarB != null ? cVarB.p() : null);
        if (this.j != null) {
            if (!(System.currentTimeMillis() - this.q <= 2000) && a(aTAdStatusInfo, 5) && (h() <= 0 || !aTAdStatusInfo.isReady())) {
                com.anythink.core.common.o.d dVar = this.j;
                dVar.a(context, ((com.anythink.core.common.o.a) dVar).a(), 5);
            }
        }
        return aTAdStatusInfo;
    }

    private List<com.anythink.core.common.h.c> c(Context context) {
        a aVar = this.s;
        if (aVar != null) {
            return aVar.a(context, this.b, false, false, true, (ae) null);
        }
        return new ArrayList();
    }

    public final List<ATAdInfo> a(Context context, ae aeVar) {
        List<com.anythink.core.common.h.c> listD = d(context);
        if (listD == null || listD.size() <= 0) {
            return null;
        }
        return a(aeVar, listD);
    }

    private List<com.anythink.core.common.h.c> d(Context context) {
        if (a(false, false, (ae) null)) {
            return null;
        }
        a aVar = this.s;
        if (aVar != null) {
            return aVar.a(context, this.b, false, false, true, (ae) null);
        }
        return new ArrayList();
    }

    private static List<ATAdInfo> a(ae aeVar, List<com.anythink.core.common.h.c> list) {
        com.anythink.core.common.h.n detail;
        com.anythink.core.common.h.n trackingInfo;
        ArrayList arrayList = new ArrayList(3);
        if (list != null && list.size() > 0) {
            Iterator<com.anythink.core.common.h.c> it = list.iterator();
            com.anythink.core.common.h.d dVarB = null;
            while (it.hasNext()) {
                com.anythink.core.common.h.c next = it.next();
                if (aeVar != null) {
                    dVarB = aeVar.b();
                }
                BaseAd baseAdF = next != null ? next.f() : null;
                ATBaseAdAdapter aTBaseAdAdapterE = next != null ? next.e() : null;
                if (baseAdF != null) {
                    if (dVarB != null && (detail = baseAdF.getDetail()) != null) {
                        detail.a(dVarB);
                    }
                    arrayList.add(com.anythink.core.common.d.k.a(baseAdF, aTBaseAdAdapterE, 4));
                } else if (aTBaseAdAdapterE != null) {
                    if (dVarB != null && (trackingInfo = aTBaseAdAdapterE.getTrackingInfo()) != null) {
                        trackingInfo.a(dVarB);
                    }
                    arrayList.add(com.anythink.core.common.d.k.a(aTBaseAdAdapterE, 4));
                }
            }
        }
        return arrayList;
    }

    public final com.anythink.core.common.h.c a(Context context, boolean z, boolean z2, ae aeVar) {
        a aVar;
        List<com.anythink.core.common.h.c> listA;
        if (a(z2, z, aeVar) || (aVar = this.s) == null || (listA = aVar.a(context, this.b, z, z2, false, aeVar)) == null || listA.isEmpty()) {
            return null;
        }
        return listA.get(0);
    }

    private boolean a(boolean z, boolean z2, ae aeVar) {
        Map<String, Object> mapA = aeVar != null ? aeVar.a() : null;
        com.anythink.core.common.h.d dVarB = aeVar != null ? aeVar.b() : null;
        Context contextG = com.anythink.core.common.d.s.b().g();
        if (contextG == null) {
            contextG = this.a;
        }
        com.anythink.core.e.l lVarE = e(contextG);
        String str = TextUtils.isEmpty(this.e) ? "" : this.e;
        if (lVarE == null) {
            if (z) {
                com.anythink.core.common.t.f.a(str, this.b, lVarE, 4, "", mapA, aeVar);
            } else if (z2) {
                com.anythink.core.common.t.f.a(str, this.b, false, 4, lVarE, (com.anythink.core.common.h.c) null, (af) null, "", mapA, dVarB, aeVar);
            }
            return true;
        }
        com.anythink.core.a.d.a();
        int iA = com.anythink.core.a.d.a(this.b, lVarE);
        if (iA != -1) {
            if (z) {
                com.anythink.core.common.t.f.a(str, this.b, lVarE, iA, "", mapA, aeVar);
            } else if (z2) {
                com.anythink.core.common.t.f.a(str, this.b, false, iA, lVarE, (com.anythink.core.common.h.c) null, (af) null, "", mapA, dVarB, aeVar);
            }
            return true;
        }
        com.anythink.core.a.a.a(this.a);
        int iA2 = com.anythink.core.a.a.a(lVarE, this.b);
        if (iA2 == -1) {
            return false;
        }
        if (z) {
            com.anythink.core.common.t.f.a(str, this.b, lVarE, iA2, "", mapA, aeVar);
        } else if (z2) {
            com.anythink.core.common.t.f.a(str, this.b, false, iA2, lVarE, (com.anythink.core.common.h.c) null, (af) null, "", mapA, dVarB, aeVar);
        }
        return true;
    }

    public final void c(String str) {
        g gVar;
        if (TextUtils.isEmpty(str) || (gVar = this.c.get(str)) == null) {
            return;
        }
        gVar.h();
    }

    private void a(String str, com.anythink.core.common.d.a aVar) {
        com.anythink.core.common.o.c cVar = this.i;
        if (cVar != null) {
            cVar.a(str, aVar);
        }
    }

    public final void a(as asVar, AdError adError) {
        n nVar = this.g;
        if (nVar != null) {
            nVar.a(1, asVar, (ce) null, adError);
        }
    }

    private boolean A() {
        return !TextUtils.isEmpty(this.e);
    }

    private com.anythink.core.e.l e(Context context) {
        return com.anythink.core.e.n.a(context).c(this.b);
    }

    public final boolean a(ATAdStatusInfo aTAdStatusInfo, int i) {
        com.anythink.core.e.l lVarE = e(com.anythink.core.common.d.s.b().g());
        if (lVarE == null) {
            return false;
        }
        if ((lVarE != null && h() >= lVarE.r() && aTAdStatusInfo != null && aTAdStatusInfo.isReady()) || ATAdxSetting.getInstance().isAdxNetworkMode(this.b)) {
            return false;
        }
        if (i == 6 || i == 18) {
            int iG = lVarE.g();
            if (iG != -1) {
                if (iG == 1) {
                    return false;
                }
                if (i == 6 && iG == 2) {
                    return true;
                }
                return i == 18 && iG == 3;
            }
            if (i == 18) {
                return false;
            }
        }
        if (!B()) {
            return lVarE != null && b(lVarE);
        }
        if (a(i, lVarE != null ? lVarE.bz() : null)) {
            return true;
        }
        return lVarE != null && b(lVarE) && (i == 5 || i == 6 || i == 7);
    }

    private static boolean b(com.anythink.core.e.l lVar) {
        return com.anythink.core.common.b.e.b(lVar, lVar.an() == 1);
    }

    private boolean a(int i, List<String> list) {
        com.anythink.core.common.o.d dVar = this.j;
        if (dVar != null) {
            return dVar.a(i, list);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        com.anythink.core.common.o.d dVar = this.j;
        return dVar != null && dVar.b();
    }

    private void C() {
        com.anythink.core.common.o.d dVar = this.j;
        if (dVar != null) {
            dVar.d();
        }
    }

    private void D() {
        com.anythink.core.common.o.d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
    }

    final void a(AdError adError) {
        com.anythink.core.common.o.d dVar = this.j;
        if (dVar != null) {
            dVar.a(adError, this.f, a((ATAdStatusInfo) null, 4));
        }
    }

    private static String a(x xVar) {
        return xVar.a + xVar.e + xVar.j + System.currentTimeMillis();
    }

    public static String a(String str, String str2, String str3) {
        return str + str2 + str3 + System.currentTimeMillis();
    }

    public final com.anythink.core.common.h.c b(Context context, boolean z, boolean z2, ae aeVar) {
        if (v.a().b()) {
            com.anythink.core.e.l lVarE = e(context);
            if (lVarE != null && v.a().a(this.b)) {
                Log.w("anythink", "Forbidden placement");
                return null;
            }
            if (lVarE != null && v.a().a(lVarE)) {
                return a(context, z, z2, aeVar, this, lVarE);
            }
        }
        return a(context, z, z2, aeVar);
    }

    public final List<ATAdInfo> a(Context context) {
        List<com.anythink.core.common.h.c> listD = null;
        if (v.a().b()) {
            com.anythink.core.e.l lVarE = e(context);
            if (lVarE != null && v.a().a(this.b)) {
                Log.w("anythink", "Forbidden placement");
                return null;
            }
            if (v.a().a(lVarE)) {
                String strV = lVarE.v();
                v.a();
                f fVarB = v.b(strV, String.valueOf(lVarE.ap()));
                ae aeVar = new ae();
                com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
                if (fVarB != null) {
                    a(dVar, this.b, lVarE);
                    aeVar.a(dVar);
                    aeVar.a(fVarB.x);
                    listD = fVarB.d(context);
                }
                List<com.anythink.core.common.h.c> listD2 = d(context);
                if (listD == null) {
                    return a(aeVar, listD2);
                }
                if (listD2 == null || listD2.size() == 0) {
                    return a(aeVar, listD);
                }
                listD2.addAll(listD);
                Collections.sort(listD2, new AnonymousClass2());
                return a(aeVar, listD2);
            }
        }
        return a(context, (ae) null);
    }

    public final List<com.anythink.core.common.h.c> b(Context context) {
        com.anythink.core.e.l lVarE;
        List<com.anythink.core.common.h.c> listC;
        try {
            List<com.anythink.core.common.h.c> listC2 = c(context);
            ArrayList arrayList = new ArrayList();
            if (listC2 != null) {
                arrayList.addAll(listC2);
            }
            if (v.a().b() && (lVarE = e(context)) != null && v.a().a(lVarE)) {
                String strV = lVarE.v();
                int iAp = lVarE.ap();
                v.a();
                f fVarB = v.b(strV, String.valueOf(iAp));
                if (fVarB != null && (listC = fVarB.c(context)) != null && !listC.isEmpty()) {
                    arrayList.addAll(listC);
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.anythink.core.common.h.c b(Context context, String str, String str2, as asVar) {
        v.a();
        f fVarB = v.b(str, str2);
        if (fVarB == null) {
            return null;
        }
        ae aeVar = new ae();
        aeVar.a(asVar.g);
        aeVar.a(asVar.i);
        aeVar.a(asVar.b());
        return fVarB.a(context, true, false, aeVar);
    }

    private void a(as asVar, g gVar, com.anythink.core.e.l lVar) {
        if (asVar == null || lVar == null) {
            return;
        }
        int i = asVar.c;
        if (i == 0 || i == 3) {
            String strV = lVar.v();
            if (!TextUtils.isEmpty(strV) && v.a().a(lVar)) {
                this.z = new AnonymousClass8(asVar, gVar);
                v.a().a(this.b, strV, this.z);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$8, reason: invalid class name */
    final class AnonymousClass8 implements v.b {
        final /* synthetic */ as a;
        final /* synthetic */ g b;

        AnonymousClass8(as asVar, g gVar) {
            this.a = asVar;
            this.b = gVar;
        }

        @Override // com.anythink.core.common.v.b
        public final void a(String str, String str2, int i) {
            f.this.a(str, str2, i, this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        if (this.z == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        v.a().b(str, str2, this.z);
        this.z = null;
    }

    final synchronized void a(String str, String str2, int i, as asVar, g gVar) {
        if (asVar == null || gVar == null) {
            return;
        }
        if (gVar.c()) {
            b(str, str2);
            return;
        }
        n nVar = asVar.e;
        if (nVar == null) {
            return;
        }
        if (i == 1) {
            b(str, str2);
            this.l = 1;
            if (nVar.a() != null) {
                nVar.a().onAdLoaded();
            }
        } else if (i == 2) {
            v.a();
            by byVarC = v.c(str2, this.w);
            if (byVarC == null) {
                return;
            }
            int iA = gVar.a(byVarC);
            if (iA == 1) {
                b(str, str2);
                return;
            }
            if (iA == 2) {
                return;
            }
            if (iA == 3) {
                return;
            }
            b(str, str2);
            this.l = 2;
            if (nVar.a() != null) {
                nVar.a().onAdLoaded();
            }
        }
    }

    private void a(Context context, String str, String str2, as asVar, com.anythink.core.common.d.a aVar, f fVar, com.anythink.core.e.l lVar) {
        String strV = lVar.v();
        this.l = 0;
        com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
        a(dVar, str2, lVar);
        asVar.i = dVar;
        com.anythink.core.common.d.a[] aVarArr = {aVar};
        if (lVar.z() == 1) {
            com.anythink.core.common.h.c cVarB = b(context, strV, str, asVar);
            if (cVarB != null) {
                String strA = com.anythink.core.common.u.o.a(context);
                asVar.a = strA;
                aa.a("Shared", "placementId:" + str2 + ";result_callback:success;");
                com.anythink.core.common.h.n nVarI = cVarB.i();
                com.anythink.core.common.t.f.a(str2, strV, nVarI, str, strA, lVar, "1", "2", nVarI != null ? nVarI.aR() : "");
                com.anythink.core.common.d.a aVar2 = aVarArr[0];
                if (aVar2 != null) {
                    aVar2.onAdLoaded();
                }
                aVarArr[0] = null;
            } else {
                v.a().b(strV, asVar.b());
            }
            fVar.a(context, str, str2, asVar, new AnonymousClass9(str2, strV, aVarArr, str, asVar, lVar));
            return;
        }
        fVar.a(context, str, str2, asVar, new AnonymousClass10(str2, strV, str, asVar, lVar, aVarArr, context));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$9, reason: invalid class name */
    final class AnonymousClass9 implements com.anythink.core.common.d.a {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ com.anythink.core.common.d.a[] c;
        final /* synthetic */ String d;
        final /* synthetic */ as e;
        final /* synthetic */ com.anythink.core.e.l f;

        AnonymousClass9(String str, String str2, com.anythink.core.common.d.a[] aVarArr, String str3, as asVar, com.anythink.core.e.l lVar) {
            this.a = str;
            this.b = str2;
            this.c = aVarArr;
            this.d = str3;
            this.e = asVar;
            this.f = lVar;
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoaded() {
            f.this.b(this.a, this.b);
            if (this.c[0] != null) {
                com.anythink.core.common.t.f.a(this.a, this.b, (com.anythink.core.common.h.n) null, this.d, this.e.a, this.f, true, "0", "1", "", f.this.l);
                this.c[0].onAdLoaded();
                this.c[0] = null;
            }
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoadFail(AdError adError) {
            f.this.b(this.a, this.b);
            if (this.c[0] != null) {
                com.anythink.core.common.t.f.a(this.a, this.b, (com.anythink.core.common.h.n) null, this.d, this.e.a, this.f, false, "0", "0", "", 0);
                this.c[0].onAdLoadFail(adError);
                this.c[0] = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$10, reason: invalid class name */
    final class AnonymousClass10 implements com.anythink.core.common.d.a {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ as d;
        final /* synthetic */ com.anythink.core.e.l e;
        final /* synthetic */ com.anythink.core.common.d.a[] f;
        final /* synthetic */ Context g;

        AnonymousClass10(String str, String str2, String str3, as asVar, com.anythink.core.e.l lVar, com.anythink.core.common.d.a[] aVarArr, Context context) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = asVar;
            this.e = lVar;
            this.f = aVarArr;
            this.g = context;
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoaded() {
            f.this.b(this.a, this.b);
            com.anythink.core.common.t.f.a(this.a, this.b, (com.anythink.core.common.h.n) null, this.c, this.d.a, this.e, true, "2", "1", "", f.this.l);
            com.anythink.core.common.d.a aVar = this.f[0];
            if (aVar != null) {
                aVar.onAdLoaded();
                this.f[0] = null;
            }
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoadFail(AdError adError) {
            f.this.b(this.a, this.b);
            com.anythink.core.common.h.c cVarB = f.b(this.g, this.b, this.c, this.d);
            if (cVarB != null) {
                aa.a("Shared", "placementId:" + this.a + ";result_callback:success;");
                com.anythink.core.common.h.n nVarI = cVarB.i();
                com.anythink.core.common.t.f.a(this.a, this.b, nVarI, this.c, this.d.a, this.e, true, "1", "0", nVarI != null ? nVarI.aR() : "", 0);
                com.anythink.core.common.d.a aVar = this.f[0];
                if (aVar != null) {
                    aVar.onAdLoaded();
                    this.f[0] = null;
                    return;
                }
                return;
            }
            v.a().b(this.b, this.d.b());
            com.anythink.core.common.t.f.a(this.a, this.b, (com.anythink.core.common.h.n) null, this.c, this.d.a, this.e, false, "0", "0", "", 0);
            com.anythink.core.common.d.a aVar2 = this.f[0];
            if (aVar2 != null) {
                aVar2.onAdLoadFail(adError);
                this.f[0] = null;
            }
        }
    }

    private com.anythink.core.common.h.c a(Context context, boolean z, boolean z2, ae aeVar, f fVar, com.anythink.core.e.l lVar) {
        com.anythink.core.common.h.c cVarA;
        boolean z3;
        com.anythink.core.common.h.n nVar;
        String strAR;
        String strValueOf;
        String strAR2;
        boolean z4;
        String strV = lVar.v();
        int iAp = lVar.ap();
        v.a();
        f fVarB = v.b(strV, String.valueOf(iAp));
        if (fVarB != null) {
            com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
            a(dVar, this.b, lVar);
            if (aeVar != null) {
                aeVar.a(dVar);
                aeVar.a(fVarB.x);
            }
            cVarA = fVarB.a(context, z, z2, aeVar);
            if (cVarA != null) {
                ai.a(this.b, lVar, cVarA.i());
            }
        } else {
            cVarA = null;
        }
        com.anythink.core.common.h.c cVarA2 = fVar.a(context, z, z2, aeVar);
        if (cVarA2 != null) {
            com.anythink.core.common.h.n nVarI = cVarA2.i();
            if (nVarI != null) {
                strAR = nVarI.aR();
                strValueOf = String.valueOf(nVarI.V());
            } else {
                nVarI = null;
                strAR = "";
                strValueOf = strAR;
            }
            nVar = nVarI;
            z3 = true;
        } else {
            z3 = false;
            nVar = null;
            strAR = "";
            strValueOf = strAR;
        }
        if (cVarA != null) {
            com.anythink.core.common.h.n nVarI2 = cVarA.i();
            strAR2 = nVarI2 != null ? nVarI2.aR() : "";
            z4 = true;
        } else {
            if (aeVar != null && aeVar.e()) {
                v.a().b(strV, fVar.x);
                v.a().a(lVar, 17, fVar.y, nVar);
            }
            strAR2 = "";
            z4 = false;
        }
        com.anythink.core.common.h.c cVar = (cVarA == null || (cVarA2 != null && com.anythink.core.common.u.k.a(cVarA.o(), cVarA2.o()) >= 0)) ? cVarA2 : cVarA;
        com.anythink.core.common.t.f.a(this.b, strV, lVar, cVar != null ? cVar.i() : null, z3 || z4, z3, z4, strAR, strAR2, strValueOf);
        return cVar;
    }

    private List<ATAdInfo> a(Context context, f fVar, com.anythink.core.e.l lVar) {
        List<com.anythink.core.common.h.c> listD;
        String strV = lVar.v();
        v.a();
        f fVarB = v.b(strV, String.valueOf(lVar.ap()));
        ae aeVar = new ae();
        com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
        if (fVarB != null) {
            a(dVar, this.b, lVar);
            aeVar.a(dVar);
            aeVar.a(fVarB.x);
            listD = fVarB.d(context);
        } else {
            listD = null;
        }
        List<com.anythink.core.common.h.c> listD2 = fVar.d(context);
        if (listD == null) {
            return a(aeVar, listD2);
        }
        if (listD2 == null || listD2.size() == 0) {
            return a(aeVar, listD);
        }
        listD2.addAll(listD);
        Collections.sort(listD2, new AnonymousClass2());
        return a(aeVar, listD2);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$2, reason: invalid class name */
    final class AnonymousClass2 implements Comparator<com.anythink.core.common.h.c> {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.anythink.core.common.h.c cVar, com.anythink.core.common.h.c cVar2) {
            return com.anythink.core.common.u.k.a(cVar.o(), cVar2.o());
        }

        private static int a(com.anythink.core.common.h.c cVar, com.anythink.core.common.h.c cVar2) {
            return com.anythink.core.common.u.k.a(cVar.o(), cVar2.o());
        }
    }

    private static void a(com.anythink.core.common.h.d dVar, String str, com.anythink.core.e.l lVar) {
        dVar.a(str, lVar.ax(), lVar.ah());
    }

    private static com.anythink.core.e.l b(boolean z, Map<String, Object> map) {
        if (!z && map != null) {
            Object obj = map.get(CoreDebuggerManager.a);
            if (obj instanceof com.anythink.core.e.l) {
                return (com.anythink.core.e.l) obj;
            }
        }
        return null;
    }

    public final List<ATAdInfo> a(String str, int i, boolean z) {
        try {
            if (TextUtils.isEmpty(str) || com.anythink.core.common.d.s.b().g() == null) {
                return null;
            }
            synchronized (E().a()) {
                try {
                    List<ATAdInfo> listA = z ? a(com.anythink.core.common.d.s.b().g()) : a(com.anythink.core.common.d.s.b().g(), (ae) null);
                    if (listA != null && !listA.isEmpty()) {
                        if (i >= listA.size() - 1) {
                            return null;
                        }
                        ArrayList arrayList = new ArrayList();
                        if (i >= 0) {
                            while (true) {
                                i++;
                                if (i >= listA.size()) {
                                    break;
                                }
                                arrayList.add(listA.get(i));
                            }
                        } else {
                            arrayList.addAll(listA);
                        }
                        return arrayList;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(int i) {
        a(i, 1);
    }

    public final void a(int i, int i2) {
        a(a(this.b, i, true), i2);
    }

    public final void a(List<ATAdInfo> list) {
        a(list, 1);
    }

    private void a(List<ATAdInfo> list, int i) {
        a aVar;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String sharedPlacementId = null;
        for (ATAdInfo aTAdInfo : list) {
            if (aTAdInfo != null) {
                if (aTAdInfo.getPlacementType() == 2) {
                    if (sharedPlacementId == null) {
                        sharedPlacementId = aTAdInfo.getSharedPlacementId();
                    }
                    arrayList.add(aTAdInfo);
                } else {
                    arrayList2.add(aTAdInfo);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            this.s.a(this.b, arrayList2, i);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(this.b);
        String strValueOf = lVarA != null ? String.valueOf(lVarA.ap()) : null;
        if (!TextUtils.isEmpty(strValueOf) && v.a().a(lVarA)) {
            v.a();
            f fVarA = v.a(sharedPlacementId, strValueOf);
            if (fVarA == null || (aVar = fVarA.s) == null) {
                return;
            }
            aVar.a(sharedPlacementId, arrayList, i);
        }
    }

    public final void p() {
        a(-1, 6);
    }

    public final void a(Map<String, Object> map) {
        if (map != null) {
            try {
                Object obj = map.get("event_type");
                if (obj instanceof Integer) {
                    if (((Integer) obj).intValue() == 1) {
                        com.anythink.core.common.d.q.a(this, this.b, map);
                    } else if (((Integer) obj).intValue() == 2) {
                        com.anythink.core.common.d.q.b(this, this.b, map);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private bp E() {
        if (this.m == null) {
            synchronized (this.A) {
                if (this.m == null) {
                    this.m = new bp();
                }
            }
        }
        return this.m;
    }

    public final Object q() {
        return E().a();
    }

    public final void b(Map<String, Object> map) {
        synchronized (this.A) {
            E().a(com.anythink.core.common.u.i.a(map));
        }
    }

    public final Map<String, Object> r() {
        HashMap map = new HashMap(2);
        synchronized (this.A) {
            Map<String, Object> mapB = E().b();
            if (mapB != null) {
                map.putAll(mapB);
            }
        }
        return map;
    }

    public final void a(ATAdInfo aTAdInfo) {
        E().a(aTAdInfo);
    }

    public final com.anythink.core.common.h.i s() {
        return E().c();
    }

    public final void t() {
        E().a((ATAdInfo) null);
    }

    public final void a(String str, String str2) {
        E().a(str, str2);
    }

    public final String d(String str) {
        return E().b(str);
    }

    public final void a(int i, String str) {
        E().b(String.valueOf(i), str);
    }

    public final String b(int i) {
        return E().c(String.valueOf(i));
    }

    public final void a(String str, List<com.anythink.core.common.h.c> list) {
        E().a(str, list);
    }

    private void c(String str, String str2) {
        E().a(this.b, str, str2);
    }

    public final void u() {
        this.B = true;
    }

    public final boolean v() {
        return this.B;
    }

    public final void b(final Context context, final String str, final String str2, final as asVar, final com.anythink.core.common.d.a aVar) {
        if (asVar.c == 0 || asVar.c == 3) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            t.a().a(str2, stackTrace);
            if (!TextUtils.equals(str, "4")) {
                t.a().a(str2, com.anythink.core.common.u.o.a(stackTrace));
            }
        }
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dz, new Runnable() { // from class: com.anythink.core.common.f.7
            @Override // java.lang.Runnable
            public final void run() {
                if (v.a().b()) {
                    com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(context).a(f.this.b);
                    if (lVarA != null && v.a().a(f.this.b)) {
                        Log.w("anythink", "Forbidden placement");
                        com.anythink.core.common.d.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.onAdLoadFail(ErrorCode.getErrorCode(ErrorCode.sharedPlacementIdError, "", ""));
                            return;
                        }
                        return;
                    }
                    if (v.a().a(lVarA)) {
                        f fVar = f.this;
                        f.a(fVar, context, str, str2, asVar, aVar, fVar, lVarA);
                        return;
                    }
                }
                f.this.a(context, str, str2, asVar, aVar);
            }
        }));
    }

    static /* synthetic */ com.anythink.core.e.l a(boolean z, Map map) {
        if (z || map == null) {
            return null;
        }
        Object obj = map.get(CoreDebuggerManager.a);
        if (obj instanceof com.anythink.core.e.l) {
            return (com.anythink.core.e.l) obj;
        }
        return null;
    }

    static /* synthetic */ boolean a(f fVar) {
        return !TextUtils.isEmpty(fVar.e);
    }

    static /* synthetic */ void c(f fVar) {
        com.anythink.core.common.o.d dVar = fVar.j;
        if (dVar != null) {
            dVar.d();
        }
    }

    static /* synthetic */ void e(f fVar) {
        synchronized (fVar.h) {
            fVar.h.clear();
        }
    }

    static /* synthetic */ void a(f fVar, Context context, String str, String str2, com.anythink.core.e.l lVar, as asVar, com.anythink.core.common.h.n nVar, String str3, String str4, int i) {
        com.anythink.core.e.n.a(context).a(lVar, str, str2, fVar.b, asVar.g, fVar.new AnonymousClass3(nVar, str3, asVar, lVar, str4), i, false, asVar.b(), true, null);
    }

    static /* synthetic */ void a(f fVar, Context context, String str, String str2, com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar, as asVar) {
        if (nVar != null) {
            nVar.f(SystemClock.elapsedRealtime());
        }
        com.anythink.core.common.v.b.h hVar = new com.anythink.core.common.v.b.h(context, str, lVar, fVar.new AnonymousClass4(asVar, context, str, str2, lVar, nVar));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new com.anythink.core.common.v.b.e());
        new com.anythink.core.common.v.b.g(arrayList, hVar, 0).a(hVar);
    }

    /* JADX WARN: Code duplicated, block: B:127:0x038b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    static /* synthetic */ void b(f fVar, Context context, String str, String str2, com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar, as asVar) {
        char c;
        by byVar;
        Context context2;
        ac acVar;
        long jBM;
        int iBv;
        int i;
        g gVar;
        bs bsVar;
        cc ccVar;
        ac acVar2;
        List<by> list;
        ce ceVar;
        boolean z;
        boolean z2;
        boolean z3;
        Map<String, Object> map;
        br brVar;
        com.anythink.core.common.a.c cVar;
        boolean z4 = "";
        as asVarAp = lVar.ap();
        com.anythink.core.common.t.f.a("1", nVar, str2, str, "", 0, (int) asVarAp, 0L);
        ce ceVar2 = new ce(asVar, lVar);
        ai.a(nVar, ceVar2);
        try {
            try {
                if (!lVar.bk()) {
                    nVar.L(5);
                    throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
                }
                com.anythink.core.a.b.a(fVar.a).a(fVar.b, lVar);
                a(lVar, nVar);
                b(lVar, nVar);
                br brVarA = com.anythink.core.common.u.ac.a(lVar, nVar);
                com.anythink.core.common.h.n nVarC = brVarA.c();
                if (brVarA.b() == 0) {
                    nVarC.L(5);
                    if (brVarA.a().E() == 1) {
                        throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                    }
                    throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                }
                if (brVarA.i()) {
                    boolean zK = brVarA.k();
                    ArrayList arrayList = new ArrayList(1);
                    com.anythink.core.common.u.ac.b(brVarA, arrayList);
                    List<by> listD = brVarA.d();
                    if (listD != null && !listD.isEmpty()) {
                        com.anythink.core.common.u.ac.a(lVar, brVarA.c(), listD);
                    }
                    List<by> listA = com.anythink.core.common.u.ac.a(brVarA, brVarA.d());
                    fVar.s.b(str);
                    boolean z5 = arrayList.size() > 0;
                    boolean z6 = !z5 && (brVarA.e() == null || brVarA.e().size() == 0);
                    nVar.g(SystemClock.elapsedRealtime());
                    if (z6 && ((listA == null || listA.size() == 0) && ((brVarA.f() == null || brVarA.f().size() == 0) && ((brVarA.g() == null || brVarA.g().size() == 0) && (brVarA.h() == null || brVarA.h().size() == 0))))) {
                        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                        nVar.L(6);
                        fVar.a(true, nVar, errorCode, asVar);
                        fVar.d = false;
                        return;
                    }
                    com.anythink.core.a.c.a();
                    com.anythink.core.a.c.b(fVar.a, str, lVar);
                    Map<String, Object> mapR = fVar.r();
                    w wVar = fVar.v;
                    cc ccVarRemove = (wVar == null || wVar.a == null) ? null : wVar.a.remove(str);
                    bs bsVarA = u.a(fVar.a).a(str, str2);
                    ac acVarA = d.a().a(str);
                    ac acVar3 = new ac(str2);
                    boolean z7 = z5;
                    boolean z8 = z6;
                    d.a().a(fVar.b, acVar3);
                    nVar.b(true);
                    nVar.B(ceVar2.f());
                    g gVar2 = new g(asVar.a(), fVar);
                    gVar2.h = mapR;
                    gVar2.i = nVar;
                    gVar2.a(asVar);
                    gVar2.a(asVar.d);
                    fVar.e = str2;
                    fVar.o = nVar.aJ();
                    List<by> listA2 = com.anythink.core.e.u.a(lVar, lVar.Z());
                    if (listA2.size() > 0) {
                        c = 0;
                        byVar = listA2.get(0);
                    } else {
                        c = 0;
                        byVar = null;
                    }
                    if (byVar != null) {
                        for (by byVar2 : brVarA.e()) {
                            if (!byVar2.G().equals(byVar.G()) || (cVar = fVar.t) == null) {
                                gVar = gVar2;
                                bsVar = bsVarA;
                                ccVar = ccVarRemove;
                                acVar2 = acVarA;
                                list = listA;
                                ceVar = ceVar2;
                                z = zK;
                                z2 = z7;
                                z3 = z8;
                                c = 0;
                                map = mapR;
                                brVar = brVarA;
                            } else {
                                gVar = gVar2;
                                z2 = z7;
                                z3 = z8;
                                c = 0;
                                bsVar = bsVarA;
                                ccVar = ccVarRemove;
                                acVar2 = acVarA;
                                ceVar = ceVar2;
                                z = zK;
                                map = mapR;
                                brVar = brVarA;
                                list = listA;
                                com.anythink.core.common.a.c.a aVarA = cVar.a(context, str, str2, byVar2, lVar, map, fVar.x);
                                if (aVarA != null) {
                                    by byVarD = aVarA.d();
                                    if (com.anythink.core.common.u.ac.a(0, nVar, byVarD, (z) null) != null) {
                                        fVar.t.a(str, byVarD.G());
                                    } else {
                                        gVar.J = aVarA;
                                    }
                                    nVar.e(SystemClock.elapsedRealtime());
                                }
                            }
                            gVar2 = gVar;
                            ceVar2 = ceVar;
                            mapR = map;
                            brVarA = brVar;
                            z7 = z2;
                            z8 = z3;
                            bsVarA = bsVar;
                            ccVarRemove = ccVar;
                            acVarA = acVar2;
                            zK = z;
                            listA = list;
                        }
                    }
                    g gVar3 = gVar2;
                    bs bsVar2 = bsVarA;
                    cc ccVar2 = ccVarRemove;
                    ac acVar4 = acVarA;
                    List<by> list2 = listA;
                    ce ceVar3 = ceVar2;
                    boolean z9 = zK;
                    boolean z10 = z7;
                    boolean z11 = z8;
                    br brVar2 = brVarA;
                    com.anythink.core.common.t.e.a(fVar.a);
                    com.anythink.core.common.t.e.a(10, nVar);
                    boolean z12 = 1;
                    z12 = 1;
                    Double[] dArr = new Double[1];
                    Boolean boolBo = lVar.bo();
                    if (brVar2.j() || (boolBo != null && boolBo.booleanValue())) {
                        context2 = context;
                        acVar = acVar3;
                        com.anythink.core.common.h.c cVarA = fVar.s.a(context2, str);
                        if (cVarA != null) {
                            dArr[c] = Double.valueOf(cVarA.n());
                        }
                    } else {
                        context2 = context;
                        acVar = acVar3;
                    }
                    com.anythink.core.common.b.c cVarA2 = com.anythink.core.common.b.f.a().a(lVar);
                    boolean z13 = (cVarA2 == null || !cVarA2.f()) ? c : 1;
                    boolean zBL = lVar.bL();
                    if (z13 == 0 && !zBL) {
                        z12 = c;
                    }
                    if (z12 == 0 || z13 != 0) {
                        jBM = -1;
                    } else {
                        Long biddingWaitMaxTime = ATAdRealTimeFilter.getInstance().getBiddingWaitMaxTime();
                        if (biddingWaitMaxTime != null) {
                            jBM = biddingWaitMaxTime.longValue();
                        } else {
                            jBM = lVar.bM() > 0 ? lVar.bM() : 5000L;
                        }
                    }
                    long j = jBM;
                    com.anythink.core.common.v.i iVar = new com.anythink.core.common.v.i(list2);
                    com.anythink.core.common.v.h hVar = new com.anythink.core.common.v.h();
                    hVar.a = str;
                    hVar.b = str2;
                    hVar.c = ceVar3;
                    hVar.d = list2;
                    hVar.e = brVar2.h();
                    hVar.i = z11;
                    hVar.j = nVar.aM();
                    hVar.k = ccVar2;
                    hVar.m = bsVar2;
                    hVar.l = iVar;
                    hVar.o = acVar4;
                    hVar.n = acVar;
                    hVar.f = brVar2.f();
                    hVar.g = brVar2.g();
                    Double d = dArr[0];
                    hVar.h = d != null ? d.doubleValue() : 0.0d;
                    hVar.p = brVar2.e();
                    hVar.q = z13;
                    gVar3.a(hVar);
                    fVar.c.put(str2, gVar3);
                    if (asVar != null && lVar != null && ((i = asVar.c) == 0 || i == 3)) {
                        String strV = lVar.v();
                        if (!TextUtils.isEmpty(strV) && v.a().a(lVar)) {
                            fVar.z = fVar.new AnonymousClass8(asVar, gVar3);
                            v.a().a(fVar.b, strV, fVar.z);
                        }
                    }
                    if (asVar.m != null) {
                        asVar.m.h(System.currentTimeMillis());
                    }
                    com.anythink.core.common.t.f.a(asVar.m, nVar);
                    h hVar2 = new h(str, gVar3);
                    gVar3.a(hVar2);
                    hVar2.a(lVar, z9);
                    hVar2.a(fVar.k);
                    if (z11 || z12 == 0) {
                        hVar2.a();
                    }
                    fVar.d = false;
                    if (!z11) {
                        List<by> listE = brVar2.e();
                        try {
                            com.anythink.core.common.h.a aVar = new com.anythink.core.common.h.a();
                            aVar.b = context2;
                            aVar.c = asVar;
                            aVar.d = str2;
                            aVar.e = str;
                            aVar.f = lVar.ap();
                            aVar.g = lVar.aa();
                            aVar.h = lVar.W();
                            aVar.i = lVar.F();
                            i.a();
                            aVar.l = i.a(lVar, z10);
                            i.a();
                            aVar.o = i.a(lVar);
                            i.a();
                            aVar.p = i.b(lVar);
                            aVar.j = listE;
                            aVar.n = ceVar3;
                            aVar.s = nVar;
                            aVar.v = ccVar2;
                            aVar.w = bsVar2;
                            aVar.x = acVar4;
                            aVar.q = fVar.r();
                            aVar.m = z10;
                            if (asVar.c == 8) {
                                aVar.t = 7;
                            }
                            aVar.y = iVar;
                            aVar.A = asVar.l;
                            aVar.B = d.a().b(fVar.b);
                            if (boolBo == null || !boolBo.booleanValue()) {
                                iBv = 0;
                            } else {
                                iBv = 0;
                                Double d2 = dArr[0];
                                if (d2 != null) {
                                    aVar.C = d2.doubleValue();
                                }
                            }
                            if (z9 && lVar.bv() > 0) {
                                iBv = lVar.bv();
                            }
                            aVar.D = iBv;
                            aVar.E = lVar.bE();
                            aVar.F = hVar2;
                            aVar.I = cVarA2;
                            aVar.G = z12;
                            aVar.H = j;
                            aVar.J = fVar;
                            aVar.K = lVar.k();
                            com.anythink.core.c.b bVar = new com.anythink.core.c.b(aVar);
                            bVar.a(ATSDK.isNetworkLogDebug());
                            bVar.a(fVar.new AnonymousClass5(ceVar3, gVar3));
                        } catch (Throwable th) {
                            com.anythink.core.common.t.f.b("notifyBiddingFinish error", th.getMessage() + ", " + com.anythink.core.common.u.p.a(th.getStackTrace()), com.anythink.core.common.d.s.b().r());
                            gVar3.f();
                        }
                    }
                    if (asVar.c == 0 || asVar.c == 3) {
                        v.a().a(lVar, 15, asVar, nVar);
                        return;
                    }
                    return;
                }
                nVarC.L(6);
                AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                throw new com.anythink.core.common.h.m(errorCode2, errorCode2.printStackTrace());
            } catch (com.anythink.core.common.h.m e) {
                e = e;
                fVar.a(z4, nVar, e, asVarAp);
            } catch (Throwable th2) {
                th = th2;
                fVar.a(z4, nVar, th, asVarAp);
            }
        } catch (com.anythink.core.common.h.m e2) {
            e = e2;
            z4 = 1;
            asVarAp = asVar;
        } catch (Throwable th3) {
            th = th3;
            z4 = 1;
            asVarAp = asVar;
        }
    }

    static /* synthetic */ void a(f fVar, Context context, String str, String str2, as asVar, com.anythink.core.common.d.a aVar, f fVar2, com.anythink.core.e.l lVar) {
        String strV = lVar.v();
        fVar.l = 0;
        com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
        a(dVar, str2, lVar);
        asVar.i = dVar;
        com.anythink.core.common.d.a[] aVarArr = {aVar};
        if (lVar.z() == 1) {
            com.anythink.core.common.h.c cVarB = b(context, strV, str, asVar);
            if (cVarB != null) {
                String strA = com.anythink.core.common.u.o.a(context);
                asVar.a = strA;
                aa.a("Shared", "placementId:" + str2 + ";result_callback:success;");
                com.anythink.core.common.h.n nVarI = cVarB.i();
                com.anythink.core.common.t.f.a(str2, strV, nVarI, str, strA, lVar, "1", "2", nVarI != null ? nVarI.aR() : "");
                com.anythink.core.common.d.a aVar2 = aVarArr[0];
                if (aVar2 != null) {
                    aVar2.onAdLoaded();
                }
                aVarArr[0] = null;
            } else {
                v.a().b(strV, asVar.b());
            }
            fVar2.a(context, str, str2, asVar, fVar.new AnonymousClass9(str2, strV, aVarArr, str, asVar, lVar));
            return;
        }
        fVar2.a(context, str, str2, asVar, fVar.new AnonymousClass10(str2, strV, str, asVar, lVar, aVarArr, context));
    }
}
