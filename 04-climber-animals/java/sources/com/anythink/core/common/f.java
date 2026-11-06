package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.h.ac;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.bp;
import com.anythink.core.common.h.bq;
import com.anythink.core.common.h.bu;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.h.cb;
import com.anythink.core.common.h.z;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.ae;
import com.anythink.core.common.v.aj;
import com.anythink.core.debugger.CoreDebuggerManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    com.anythink.core.common.p.c i;
    com.anythink.core.common.p.d j;
    private boolean n;
    private long o;
    private ATAdRequest q;
    private ar r;
    private final String l = getClass().getSimpleName();
    protected String e = "";
    private String m = "";
    private boolean p = false;
    protected int f = 1;
    h.d k = new h.d() { // from class: com.anythink.core.common.f.5
        @Override // com.anythink.core.common.h.d
        public final void a(g gVar) {
            if (gVar != null) {
                gVar.b();
            }
        }
    };
    protected ConcurrentHashMap<String, g> c = new ConcurrentHashMap<>(5);
    final List<bx> h = Collections.synchronizedList(new ArrayList(2));

    static /* synthetic */ boolean h(f fVar) {
        fVar.n = false;
        return false;
    }

    static /* synthetic */ long i(f fVar) {
        fVar.o = 0L;
        return 0L;
    }

    public final void a(com.anythink.core.common.p.c cVar) {
        this.i = cVar;
    }

    private void a(com.anythink.core.common.p.d dVar) {
        this.j = dVar;
    }

    public final com.anythink.core.common.p.d a() {
        return this.j;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0036  */
    public static f a(Context context, String str, String str2) {
        byte b;
        f fVarA = u.a().a(str, str2);
        if (fVarA == null) {
            synchronized (f.class) {
                if (fVarA == null) {
                    fVarA = new f(context, str);
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
                        fVarA.j = new com.anythink.core.common.p.a(str, str2);
                    }
                    u.a().a(str, str2, fVarA);
                }
            }
        }
        return fVarA;
    }

    private f(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = str;
        if (com.anythink.core.common.d.t.b().g() == null) {
            com.anythink.core.common.d.t.b().a(this.a);
        }
    }

    protected final void b() {
        synchronized (this.h) {
            this.h.clear();
        }
    }

    protected final void a(bx bxVar, com.anythink.core.d.l lVar) {
        com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(this.b);
        if (lVarA != null) {
            boolean z = true;
            if (lVar != null && (TextUtils.equals(lVarA.an(), lVar.an()) || lVarA.aZ())) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        synchronized (this.h) {
            this.h.add(bxVar);
        }
    }

    public final int c() {
        List<bx> list = this.h;
        int i = 0;
        if (list != null) {
            synchronized (list) {
                Iterator<bx> it = this.h.iterator();
                while (it.hasNext()) {
                    bx next = it.next();
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

    public final void d() {
        List<bx> list = this.h;
        if (list != null) {
            synchronized (list) {
                this.h.size();
                if (this.h.size() > 0) {
                    this.h.remove(0);
                }
                this.h.size();
            }
        }
    }

    protected final void e() {
        this.n = false;
        this.o = 0L;
        this.p = false;
    }

    protected final void f() {
        com.anythink.core.d.l lVarB = com.anythink.core.d.n.a(this.a).b(this.b);
        if (this.n || lVarB == null) {
            return;
        }
        this.n = true;
        this.o = System.currentTimeMillis();
    }

    private boolean k() {
        return System.currentTimeMillis() - this.o <= com.anythink.basead.exoplayer.i.a.f;
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

    public final void a(String str, double d, bv bvVar) {
        g gVar = this.c.get(str);
        if (gVar != null) {
            gVar.a(d, bvVar);
        }
    }

    public final boolean g() {
        g gVar;
        if (this.d) {
            return true;
        }
        return (TextUtils.isEmpty(this.e) || (gVar = this.c.get(this.e)) == null || gVar.c()) ? false : true;
    }

    public final String h() {
        return this.e;
    }

    public final ATAdRequest i() {
        return this.q;
    }

    private ar l() {
        return this.r;
    }

    public final void a(final Context context, final String str, final String str2, final ar arVar, final com.anythink.core.common.d.a aVar) {
        if (!com.anythink.core.common.d.t.b().z()) {
            com.anythink.core.common.d.t.b().c = true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (arVar != null && arVar.n != 0) {
            jElapsedRealtime = arVar.n;
        }
        final long j = jElapsedRealtime;
        final Map<String, Object> mapB = u.a().b(str2);
        final int[] iArr = {0};
        if (mapB.containsKey(bu.S)) {
            try {
                iArr[0] = ((Integer) mapB.get(bu.S)).intValue();
            } catch (Throwable unused) {
            }
        }
        if (arVar.c == 0 || arVar.c == 3) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            u.a().a(str2, stackTrace);
            if (!TextUtils.equals(str, "4")) {
                u.a().a(str2, com.anythink.core.common.v.p.a(stackTrace));
            }
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.f.1
            /* JADX WARN: Code duplicated, block: B:71:0x01b4 A[PHI: r0
              0x01b4: PHI (r0v59 com.anythink.core.d.l) = (r0v58 com.anythink.core.d.l), (r0v58 com.anythink.core.d.l), (r0v135 com.anythink.core.d.l) binds: [B:55:0x017f, B:56:0x0181, B:69:0x01ae] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // java.lang.Runnable
            public final void run() {
                String strA;
                com.anythink.core.d.l lVar;
                boolean z;
                synchronized (f.this) {
                    com.anythink.core.common.d.t.b().b(f.this.a);
                    if (!f.this.g() || arVar.c == 0) {
                        if (f.a(f.this) || arVar.c != 5) {
                            if (f.this.n() && arVar.c == 0) {
                                Log.e("anythink", "PlacementId(" + str2 + ") the load api calls are not allowed in Auto-load mode");
                                return;
                            }
                            if (f.this.g == null) {
                                f.this.g = new n();
                            }
                            n nVar = f.this.g;
                            String str3 = str2;
                            String str4 = str;
                            nVar.a = str3;
                            nVar.b = str4;
                            f.this.g.a(aVar);
                            arVar.e = f.this.g;
                            if (arVar.c != 4 && arVar.c != 5) {
                                f.this.f = 1;
                            } else {
                                f.this.f++;
                            }
                            f.c(f.this);
                            int i = arVar.c;
                            com.anythink.core.common.d.t.b().a(context, true);
                            if (TextUtils.isEmpty(arVar.a)) {
                                strA = com.anythink.core.common.v.p.a(context);
                                arVar.a = strA;
                            } else {
                                strA = arVar.a;
                            }
                            String str5 = strA;
                            f fVar = f.this;
                            String str6 = arVar.a;
                            com.anythink.core.common.d.a aVar2 = aVar;
                            if (fVar.i != null) {
                                fVar.i.a(str6, aVar2);
                            }
                            f.this.r = arVar;
                            f.this.q = arVar.b();
                            if (com.anythink.core.common.d.t.b().g() != null && !TextUtils.isEmpty(com.anythink.core.common.d.t.b().p()) && !TextUtils.isEmpty(com.anythink.core.common.d.t.b().q()) && !com.anythink.core.common.v.q.a(str2)) {
                                Context contextG = com.anythink.core.common.d.t.b().g();
                                String strP = com.anythink.core.common.d.t.b().p();
                                String strQ = com.anythink.core.common.d.t.b().q();
                                boolean z2 = com.anythink.core.common.d.t.b().z();
                                int i2 = arVar.c;
                                if (arVar.m != null) {
                                    arVar.m.b(System.currentTimeMillis());
                                }
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (arVar.n != 0) {
                                    jElapsedRealtime2 = arVar.o;
                                }
                                long j2 = jElapsedRealtime2;
                                com.anythink.core.d.n nVarA = com.anythink.core.d.n.a(context);
                                com.anythink.core.d.l lVarA = f.a(f.this, z2, mapB);
                                boolean zH = nVarA.h(str2);
                                if (z2 || lVarA != null) {
                                    lVar = lVarA;
                                    z = false;
                                } else {
                                    if (i2 == 13) {
                                        lVarA = nVarA.d(str2);
                                    } else if (i2 == 14) {
                                        lVarA = nVarA.e(str2);
                                    } else {
                                        lVarA = nVarA.c(str2);
                                    }
                                    com.anythink.core.d.l lVarF = nVarA.f(str2);
                                    if (lVarA == null && lVarF != null) {
                                        lVarA = lVarF;
                                    }
                                    if (com.anythink.core.d.n.a(lVarA)) {
                                        lVar = lVarA;
                                        z = false;
                                    } else {
                                        lVar = lVarA;
                                        z = true;
                                    }
                                }
                                String unused2 = f.this.l;
                                new StringBuilder("startLoad() >>> loadType: ").append(i2).append(" mPlacementId: ").append(str2).append(" strategyType: ").append(lVar == null ? "本地缓存策略为空" : Integer.valueOf(lVar.bb()));
                                com.anythink.core.d.l lVar2 = lVar;
                                com.anythink.core.common.h.n nVarA2 = aj.a(str5, str2, lVar, i2, iArr[0], arVar.g, arVar.i, zH ? 1 : 2, arVar.b());
                                nVarA2.j(j);
                                nVarA2.c(j2);
                                nVarA2.K(str);
                                Map<String, Object> map = mapB;
                                if (map != null) {
                                    nVarA2.b(map);
                                }
                                if (lVar2 != null) {
                                    try {
                                        f.a(lVar2, nVarA2);
                                        f.b(lVar2, nVarA2);
                                    } catch (com.anythink.core.common.h.m e) {
                                        f.this.a(true, nVarA2, (Throwable) e, arVar);
                                        return;
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                                if (!arVar.d()) {
                                    int iC = f.this.c();
                                    if (iC > 0 && lVar2 != null) {
                                        com.anythink.core.common.h.c cVarA = a.a().a(context, str2);
                                        if (cVarA != null) {
                                            String unused3 = f.this.l;
                                            lVar2.q();
                                            if (iC >= lVar2.q()) {
                                                nVarA2.b(false);
                                                nVarA2.L(4);
                                                bv bvVarO = cVarA.o();
                                                if (bvVarO != null) {
                                                    nVarA2.a(bvVarO);
                                                }
                                                nVarA2.b(1);
                                                com.anythink.core.common.u.c.a(contextG).a(10, nVarA2);
                                                com.anythink.core.common.u.c.a(contextG).a(12, nVarA2);
                                                f.this.d = false;
                                                com.anythink.core.common.d.a aVar3 = aVar;
                                                if (aVar3 != null) {
                                                    aVar3.onAdLoaded();
                                                    f.this.g.b(aVar);
                                                }
                                                return;
                                            }
                                            com.anythink.core.common.d.a aVar4 = aVar;
                                            if (aVar4 != null) {
                                                aVar4.onAdLoaded();
                                                f.this.g.b(aVar);
                                            }
                                            String unused4 = f.this.l;
                                            lVar2.q();
                                            ar arVar2 = arVar;
                                            arVar2.b = arVar2.c;
                                            nVarA2.D(arVar.b);
                                            arVar.c = 9;
                                            nVarA2.C(arVar.c);
                                        } else {
                                            f.this.b();
                                        }
                                    }
                                } else {
                                    f.this.b();
                                }
                                if (lVar2 != null && f.this.n) {
                                    long jCurrentTimeMillis = System.currentTimeMillis() - f.this.o;
                                    if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < lVar2.aD()) {
                                        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.loadFailInPacingError, "", "");
                                        nVarA2.L(7);
                                        f.this.a(!f.this.p, nVarA2, new com.anythink.core.common.h.m(errorCode, errorCode.printStackTrace()), arVar);
                                        f.this.p = true;
                                        return;
                                    }
                                }
                                f.h(f.this);
                                f.i(f.this);
                                f.this.p = false;
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
                                    f.this.a(true, nVarA2, (Throwable) new com.anythink.core.common.h.m(errorCode2, errorCode2.printStackTrace()), arVar);
                                    return;
                                }
                                if (lVar2 != null && com.anythink.core.a.c.a().a(contextG, str2, lVar2) != -1) {
                                    AdError errorCode3 = ErrorCode.getErrorCode(ErrorCode.loadCappingError, "", "");
                                    nVarA2.L(iA);
                                    f.this.a(true, nVarA2, (Throwable) new com.anythink.core.common.h.m(errorCode3, errorCode3.printStackTrace()), arVar);
                                    return;
                                } else {
                                    if (f.this.g()) {
                                        Log.i("anythink", "Placement(" + str2 + ") is loading.");
                                        e.a(arVar.g, e.c, str2, f.this.m, f.this.e);
                                        return;
                                    }
                                    nVarA.g(str2);
                                    f.this.d = true;
                                    Iterator<g> it = f.this.c.values().iterator();
                                    while (it.hasNext()) {
                                        it.next().f();
                                    }
                                    int i3 = (z2 || !(lVar2 == null || lVar2.aR() || zH)) ? 2 : 3;
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    arVar.m.c(jCurrentTimeMillis2);
                                    arVar.m.d(jCurrentTimeMillis2);
                                    f.a(f.this, context, strP, strQ, lVar2, arVar, nVarA2, str, str5, i3, z);
                                    return;
                                }
                            }
                            f.this.a(arVar, ErrorCode.getErrorCode(ErrorCode.appIdOrPlaceIdEmpty, "", ""));
                            if (com.anythink.core.common.d.t.b().F()) {
                                Log.e("anythink", "Please check these params in your code (AppId: " + com.anythink.core.common.d.t.b().p() + ", AppKey: " + com.anythink.core.common.d.t.b().q() + ", PlacementId: " + str2 + ")");
                            }
                            f.this.d = false;
                        }
                    }
                }
            }
        }, 2);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.d.n.b {
        final /* synthetic */ com.anythink.core.common.h.n a;
        final /* synthetic */ String b;
        final /* synthetic */ ar c;
        final /* synthetic */ String d;

        AnonymousClass2(com.anythink.core.common.h.n nVar, String str, ar arVar, String str2) {
            this.a = nVar;
            this.b = str;
            this.c = arVar;
            this.d = str2;
        }

        @Override // com.anythink.core.d.n.b
        public final void a() {
            com.anythink.core.common.h.n nVar = this.a;
            if (nVar != null) {
                nVar.g(SystemClock.elapsedRealtime());
            }
        }

        @Override // com.anythink.core.d.n.b
        public final void b() {
            com.anythink.core.common.h.n nVar = this.a;
            if (nVar != null) {
                nVar.h(SystemClock.elapsedRealtime());
            }
        }

        @Override // com.anythink.core.d.n.b
        public final void a(com.anythink.core.d.l lVar) {
            com.anythink.core.common.h.n nVar;
            String unused = f.this.l;
            Object[] objArr = new Object[1];
            if (lVar != null) {
                lVar.i();
            }
            synchronized (f.this) {
                aj.a(this.a, lVar);
                if (!TextUtils.equals(String.valueOf(lVar != null ? lVar.aq() : 0), this.b)) {
                    AdError errorCode = ErrorCode.getErrorCode(ErrorCode.formatError, "", "Format corresponding to API: " + com.anythink.core.common.v.p.f(this.b) + ", Format corresponding to placement strategy: " + com.anythink.core.common.v.p.f(String.valueOf(lVar.aq())));
                    f.this.a(this.c, errorCode);
                    this.a.b(false);
                    com.anythink.core.common.u.e.a(this.a, errorCode);
                    f.this.d = false;
                    return;
                }
                if (lVar != null && (nVar = this.a) != null) {
                    nVar.i(SystemClock.elapsedRealtime());
                    if (lVar.bJ()) {
                        this.a.a(2);
                    } else {
                        this.a.a(1);
                    }
                }
                long j = 0;
                long jBH = lVar != null ? lVar.bH() : 0L;
                int iBI = lVar != null ? lVar.bI() : 0;
                com.anythink.core.common.h.h hVar = this.c.m;
                if (hVar != null) {
                    if (lVar == null || lVar.bJ()) {
                        j = jBH;
                    }
                    hVar.e(j);
                    hVar.f(System.currentTimeMillis());
                    hVar.a(iBI);
                }
                f fVar = f.this;
                f.a(fVar, fVar.a, f.this.b, this.d, lVar, this.a, this.c);
            }
        }

        @Override // com.anythink.core.d.n.b
        public final void a(AdError adError) {
            String str = com.anythink.core.common.d.j.r.n;
            String str2 = f.this.b;
            String strF = com.anythink.core.common.v.p.f(this.b);
            String strPrintStackTrace = adError.printStackTrace();
            if (ATSDK.isNetworkLogDebug()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.umeng.ccg.a.z, com.anythink.core.common.d.j.r.E);
                    jSONObject.put("result", str);
                    jSONObject.put("placementId", str2);
                    jSONObject.put("adtype", strF);
                    jSONObject.put(MediationConstant.KEY_ERROR_MSG, strPrintStackTrace);
                    ab.a("anythink_network", jSONObject.toString(), TextUtils.equals(com.anythink.core.common.d.j.r.n, str));
                } catch (Throwable unused) {
                }
            }
            if (adError.getCode().equals(ErrorCode.statuError)) {
                adError = ErrorCode.getErrorCode(ErrorCode.placeStrategyError, adError.getPlatformCode(), adError.getPlatformMSG());
            }
            this.a.L(5);
            f.this.a(true, this.a, adError, this.c);
        }

        @Override // com.anythink.core.d.n.b
        public final void b(com.anythink.core.d.l lVar) {
            if (lVar.aZ()) {
                return;
            }
            f.this.b();
        }
    }

    private void a(Context context, String str, String str2, com.anythink.core.d.l lVar, ar arVar, com.anythink.core.common.h.n nVar, String str3, String str4, int i, boolean z) {
        com.anythink.core.d.n.a(context).a(lVar, str, str2, this.b, arVar.g, new AnonymousClass2(nVar, str3, arVar, str4), i, z, arVar.b());
    }

    public final void j() {
        try {
            u.a().a(this.b, com.anythink.core.common.v.p.a(new Throwable().getStackTrace()));
        } catch (Throwable unused) {
        }
    }

    private void a(Context context, String str, String str2, com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar, ar arVar) {
        if (nVar != null) {
            nVar.e(SystemClock.elapsedRealtime());
        }
        com.anythink.core.common.w.b.h hVar = new com.anythink.core.common.w.b.h(context, str, lVar, new AnonymousClass3(arVar, context, str, str2, lVar, nVar));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new com.anythink.core.common.w.b.e());
        new com.anythink.core.common.w.b.g(arrayList, hVar, 0).a(hVar);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.core.common.w.b.b {
        final /* synthetic */ ar a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ com.anythink.core.d.l e;
        final /* synthetic */ com.anythink.core.common.h.n f;

        AnonymousClass3(ar arVar, Context context, String str, String str2, com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar) {
            this.a = arVar;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = lVar;
            this.f = nVar;
        }

        @Override // com.anythink.core.common.w.b.b
        public final void a() {
            if (this.a.m != null) {
                this.a.m.g(System.currentTimeMillis());
            }
            f.b(f.this, this.b, this.c, this.d, this.e, this.f, this.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    private void b(Context context, String str, String str2, com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar, ar arVar) {
        ar arVar2;
        com.anythink.core.common.h.n nVar2;
        f fVar;
        f fVar2;
        com.anythink.core.common.h.n nVar3;
        ar arVar3;
        boolean z;
        bv bvVar;
        bz bzVar;
        List<bv> list;
        boolean z2;
        boolean z3;
        bq bqVar;
        boolean z4;
        bp bpVar;
        g gVar;
        lVar.A();
        boolean z5 = false;
        ?? Aq = lVar.aq();
        ?? r8 = 0;
        ?? r9 = 0;
        com.anythink.core.common.u.e.a("1", nVar, str2, str, "", 0, (int) Aq, 0L);
        cb cbVar = new cb(arVar, lVar);
        if (nVar != null) {
            nVar.g(cbVar.e());
            nVar.h(cbVar.f());
        }
        try {
            try {
                try {
                    if (lVar.bj()) {
                        try {
                            a(lVar, nVar);
                            b(lVar, nVar);
                            bp bpVarA = ae.a(lVar, nVar);
                            com.anythink.core.common.h.n nVarC = bpVarA.c();
                            if (bpVarA.b() == 0) {
                                try {
                                    nVarC.L(5);
                                    if (bpVarA.a().D() == 1) {
                                        throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                                    }
                                    throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                                } catch (Throwable th) {
                                    th = th;
                                    z5 = true;
                                    arVar3 = arVar;
                                    nVar3 = nVar;
                                    fVar2 = this;
                                }
                            } else {
                                if (bpVarA.i()) {
                                    boolean zK = bpVarA.k();
                                    ArrayList arrayList = new ArrayList(1);
                                    ae.b(bpVarA, arrayList);
                                    List<bv> listD = bpVarA.d();
                                    if (listD != null && !listD.isEmpty()) {
                                        ae.a(lVar, bpVarA.c(), listD);
                                    }
                                    List<bv> listA = ae.a(bpVarA, bpVarA.d());
                                    a.a().b(str);
                                    boolean z6 = arrayList.size() > 0;
                                    boolean z7 = !z6 && (bpVarA.e() == null || bpVarA.e().size() == 0);
                                    nVar.f(SystemClock.elapsedRealtime());
                                    if (z7 && ((listA == null || listA.size() == 0) && ((bpVarA.f() == null || bpVarA.f().size() == 0) && ((bpVarA.g() == null || bpVarA.g().size() == 0) && (bpVarA.h() == null || bpVarA.h().size() == 0))))) {
                                        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                                        nVar.L(6);
                                        a(true, nVar, errorCode, arVar);
                                        this.d = false;
                                        return;
                                    }
                                    com.anythink.core.a.c.a();
                                    com.anythink.core.a.c.b(this.a, str, lVar);
                                    Map<String, Object> mapB = u.a().b(this.b);
                                    x xVarA = x.a(this.a);
                                    bz bzVarRemove = xVarA.a != null ? xVarA.a.remove(str) : null;
                                    bq bqVarA = v.a(this.a).a(str, str2);
                                    ac acVarA = d.a().a(str);
                                    ac acVar = new ac(str2);
                                    boolean z8 = z7;
                                    bq bqVar2 = bqVarA;
                                    d.a().a(this.b, acVar);
                                    nVar.b(true);
                                    nVar.B(cbVar.f());
                                    g gVar2 = new g(arVar.a());
                                    gVar2.h = mapB;
                                    gVar2.i = nVar;
                                    gVar2.a(arVar);
                                    gVar2.a(arVar.d);
                                    this.e = str2;
                                    this.m = nVar.aB();
                                    List<bv> listA2 = com.anythink.core.d.u.a(lVar, lVar.Y());
                                    if (listA2.size() > 0) {
                                        z = false;
                                        bvVar = listA2.get(0);
                                    } else {
                                        z = false;
                                        bvVar = null;
                                    }
                                    if (bvVar != null) {
                                        for (bv bvVar2 : bpVarA.e()) {
                                            if (bvVar2.z().equals(bvVar.z())) {
                                                z3 = z8;
                                                z4 = false;
                                                g gVar3 = gVar2;
                                                bqVar = bqVar2;
                                                bzVar = bzVarRemove;
                                                list = listA;
                                                z2 = zK;
                                                bpVar = bpVarA;
                                                com.anythink.core.common.a.c.a aVarA = com.anythink.core.common.a.c.a().a(context, str, str2, bvVar2, lVar, mapB, this.q);
                                                if (aVarA != null) {
                                                    bv bvVarD = aVarA.d();
                                                    AdError adErrorA = ae.a(0, nVar, bvVarD, (z) null);
                                                    new StringBuilder("checkToGetWaterfallList() >>> filter mAdxDefaultCacheInfo end:").append(adErrorA);
                                                    if (adErrorA != null) {
                                                        com.anythink.core.common.a.c.a().a(str, bvVarD.z());
                                                        gVar = gVar3;
                                                    } else {
                                                        gVar = gVar3;
                                                        gVar.J = aVarA;
                                                    }
                                                    nVar.d(SystemClock.elapsedRealtime());
                                                } else {
                                                    gVar = gVar3;
                                                }
                                                gVar2 = gVar;
                                                z = z4;
                                                z8 = z3;
                                                bpVarA = bpVar;
                                                bqVar2 = bqVar;
                                                bzVarRemove = bzVar;
                                                listA = list;
                                                zK = z2;
                                            } else {
                                                bzVar = bzVarRemove;
                                                list = listA;
                                                z2 = zK;
                                                z3 = z8;
                                                bqVar = bqVar2;
                                                z4 = false;
                                                bpVar = bpVarA;
                                                gVar = gVar2;
                                            }
                                            gVar2 = gVar;
                                            z = z4;
                                            z8 = z3;
                                            bpVarA = bpVar;
                                            bqVar2 = bqVar;
                                            bzVarRemove = bzVar;
                                            listA = list;
                                            zK = z2;
                                        }
                                    }
                                    boolean z9 = z;
                                    bz bzVar2 = bzVarRemove;
                                    List<bv> list2 = listA;
                                    boolean z10 = zK;
                                    boolean z11 = z8;
                                    bq bqVar3 = bqVar2;
                                    bp bpVar2 = bpVarA;
                                    g gVar4 = gVar2;
                                    com.anythink.core.common.u.c.a(this.a).a(10, nVar);
                                    Double[] dArr = new Double[1];
                                    Boolean boolBn = lVar.bn();
                                    if (bpVar2.j() || (boolBn != null && boolBn.booleanValue())) {
                                        com.anythink.core.common.h.c cVarA = a.a().a(context, str);
                                        if (cVarA != null) {
                                            dArr[z9 ? 1 : 0] = Double.valueOf(cVarA.n());
                                        }
                                    }
                                    new StringBuilder("checkToGetWaterfallList() >>> placementId=").append(this.b).append(", curMaxCachePrice=").append(dArr[z9 ? 1 : 0]).append(", hasDynamicAdSource=").append(bpVar2.j()).append(", inDynamicBidFloor=").append(boolBn);
                                    com.anythink.core.common.w.i iVar = new com.anythink.core.common.w.i(list2);
                                    com.anythink.core.common.w.h hVar = new com.anythink.core.common.w.h();
                                    hVar.a = str;
                                    hVar.b = str2;
                                    hVar.c = cbVar;
                                    hVar.d = list2;
                                    hVar.e = bpVar2.h();
                                    hVar.i = z11;
                                    hVar.j = nVar.aE();
                                    hVar.k = bzVar2;
                                    hVar.m = bqVar3;
                                    hVar.l = iVar;
                                    hVar.o = acVarA;
                                    hVar.n = acVar;
                                    hVar.f = bpVar2.f();
                                    hVar.g = bpVar2.g();
                                    Double d = dArr[0];
                                    hVar.h = d != null ? d.doubleValue() : 0.0d;
                                    hVar.p = bpVar2.e();
                                    gVar4.a(hVar);
                                    this.c.put(str2, gVar4);
                                    if (arVar.m != null) {
                                        arVar.m.h(System.currentTimeMillis());
                                    }
                                    com.anythink.core.common.u.e.a(arVar.m, nVar);
                                    h hVar2 = new h(str);
                                    gVar4.a(hVar2);
                                    hVar2.a(lVar, z10);
                                    hVar2.a(this.k);
                                    hVar2.a(gVar4);
                                    this.d = false;
                                    if (!z11) {
                                        com.anythink.core.common.v.b.b.a().b(new AnonymousClass4(context, arVar, str2, str, lVar, z6, bpVar2.e(), cbVar, nVar, bzVar2, bqVar3, acVarA, iVar, boolBn, dArr, z10, hVar2, gVar4));
                                    }
                                    Object[] objArr = new Object[1];
                                    Integer.valueOf(arVar.c);
                                    if (arVar.c == 0 || arVar.c == 3) {
                                        w.a().a(lVar, 15, arVar, nVar);
                                        return;
                                    }
                                    return;
                                }
                                nVarC.L(6);
                                AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                                throw new com.anythink.core.common.h.m(errorCode2, errorCode2.printStackTrace());
                            }
                        } catch (com.anythink.core.common.h.m e) {
                            e = e;
                            z5 = true;
                            Aq = arVar;
                            r9 = nVar;
                            fVar = this;
                            arVar2 = Aq;
                            nVar2 = r9;
                            fVar.a(z5, nVar2, e, arVar2);
                            return;
                        }
                    } else {
                        nVar.L(5);
                        throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
                    }
                } catch (com.anythink.core.common.h.m e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    fVar2 = this;
                    arVar3 = Aq;
                    nVar3 = r8;
                }
            } catch (com.anythink.core.common.h.m e3) {
                e = e3;
                z5 = true;
                arVar2 = arVar;
                nVar2 = nVar;
                fVar = this;
            }
        } catch (Throwable th3) {
            th = th3;
            z5 = true;
            Aq = arVar;
            r8 = nVar;
        }
        fVar2 = this;
        arVar3 = Aq;
        nVar3 = r8;
        fVar2.a(z5, nVar3, th, arVar3);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ ar b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ com.anythink.core.d.l e;
        final /* synthetic */ boolean f;
        final /* synthetic */ List g;
        final /* synthetic */ cb h;
        final /* synthetic */ com.anythink.core.common.h.n i;
        final /* synthetic */ bz j;
        final /* synthetic */ bq k;
        final /* synthetic */ ac l;
        final /* synthetic */ com.anythink.core.common.w.i m;
        final /* synthetic */ Boolean n;
        final /* synthetic */ Double[] o;
        final /* synthetic */ boolean p;
        final /* synthetic */ h q;
        final /* synthetic */ g r;

        AnonymousClass4(Context context, ar arVar, String str, String str2, com.anythink.core.d.l lVar, boolean z, List list, cb cbVar, com.anythink.core.common.h.n nVar, bz bzVar, bq bqVar, ac acVar, com.anythink.core.common.w.i iVar, Boolean bool, Double[] dArr, boolean z2, h hVar, g gVar) {
            this.a = context;
            this.b = arVar;
            this.c = str;
            this.d = str2;
            this.e = lVar;
            this.f = z;
            this.g = list;
            this.h = cbVar;
            this.i = nVar;
            this.j = bzVar;
            this.k = bqVar;
            this.l = acVar;
            this.m = iVar;
            this.n = bool;
            this.o = dArr;
            this.p = z2;
            this.q = hVar;
            this.r = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Double d;
            try {
                com.anythink.core.common.h.a aVar = new com.anythink.core.common.h.a();
                aVar.b = this.a;
                aVar.c = this.b;
                aVar.d = this.c;
                aVar.e = this.d;
                aVar.f = this.e.aq();
                aVar.g = this.e.ab();
                aVar.h = this.e.V();
                aVar.i = this.e.E();
                i.a();
                aVar.l = i.a(this.e, this.f);
                i.a();
                aVar.o = i.a(this.e);
                i.a();
                aVar.p = i.b(this.e);
                aVar.j = this.g;
                aVar.n = this.h;
                aVar.s = this.i;
                aVar.v = this.j;
                aVar.w = this.k;
                aVar.x = this.l;
                aVar.q = u.a().b(f.this.b);
                aVar.m = this.f;
                if (this.b.c == 8) {
                    aVar.t = 7;
                }
                aVar.y = this.m;
                aVar.A = this.b.l;
                aVar.B = d.a().c(f.this.b);
                Boolean bool = this.n;
                int iBv = 0;
                if (bool != null && bool.booleanValue() && (d = this.o[0]) != null) {
                    aVar.C = d.doubleValue();
                }
                if (this.p && this.e.bv() > 0) {
                    iBv = this.e.bv();
                }
                aVar.D = iBv;
                aVar.E = this.e.bE();
                aVar.F = this.q;
                com.anythink.core.b.b bVar = new com.anythink.core.b.b(aVar);
                bVar.a(ATSDK.isNetworkLogDebug());
                bVar.a(new j.a() { // from class: com.anythink.core.common.f.4.1
                    @Override // com.anythink.core.common.j.a
                    public final void a(String str, List<bv> list, List<bv> list2, boolean z) {
                        boolean zD = AnonymousClass4.this.h.d();
                        ArrayList arrayList = null;
                        for (bv bvVar : list2) {
                            if (zD && (bvVar.q() == 1 || bvVar.q() == 3)) {
                                if (bvVar.U() != 1) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList(4);
                                    }
                                    bvVar.C(7);
                                    arrayList.add(bvVar);
                                }
                            }
                            if (!zD && bvVar.p() != 0) {
                                c cVarA = c.a();
                                cVarA.c.put(bvVar.z(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                        AnonymousClass4.this.r.a(list, list2, arrayList, list2);
                        if (z) {
                            AnonymousClass4.this.r.e();
                        }
                    }

                    @Override // com.anythink.core.common.j.a
                    public final void a(String str) {
                        AnonymousClass4.this.r.d();
                    }
                });
            } catch (Throwable th) {
                com.anythink.core.common.u.e.b("notifyBiddingFinish error", th.getMessage() + ", " + com.anythink.core.common.v.q.a(th.getStackTrace()), com.anythink.core.common.d.t.b().r());
                this.r.e();
            }
        }
    }

    private static void c(com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar) {
        if (lVar.bj()) {
            return;
        }
        nVar.L(5);
        throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
    }

    private static void a(bp bpVar) {
        com.anythink.core.common.h.n nVarC = bpVar.c();
        if (bpVar.b() == 0) {
            nVarC.L(5);
            if (bpVar.a().D() == 1) {
                throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
            }
            throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
        }
        if (bpVar.i()) {
            return;
        }
        nVarC.L(6);
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
        throw new com.anythink.core.common.h.m(errorCode, errorCode.printStackTrace());
    }

    protected static void a(com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar) {
        int iA = com.anythink.core.a.a.a(com.anythink.core.common.d.t.b().g()).a(lVar, nVar.aI());
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

    protected static void b(com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar) {
        com.anythink.core.a.d.a();
        int iA = com.anythink.core.a.d.a(nVar.aI(), lVar);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.anythink.core.common.h.n nVar, Throwable th, ar arVar) {
        AdError errorCode;
        if (th instanceof com.anythink.core.common.h.m) {
            errorCode = ((com.anythink.core.common.h.m) th).a;
        } else {
            errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", th.getMessage());
        }
        a(z, nVar, errorCode, arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.anythink.core.common.h.n nVar, AdError adError, ar arVar) {
        this.d = false;
        nVar.b(false);
        if (z) {
            com.anythink.core.common.u.c.a(this.a).a(10, nVar);
            com.anythink.core.common.u.e.a(nVar, adError);
        }
        a(arVar, adError);
    }

    public final void a(com.anythink.core.common.h.c cVar) {
        List<bx> list;
        if (cVar == null || (list = this.h) == null) {
            return;
        }
        synchronized (list) {
            if (this.h.size() > 0) {
                this.h.remove(0);
            }
        }
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        boolean zG = g();
        com.anythink.core.common.h.ae aeVar = new com.anythink.core.common.h.ae();
        aeVar.a(map);
        aeVar.a(this.q);
        com.anythink.core.common.h.c cVarB = b(context, true, false, aeVar);
        ATAdStatusInfo aTAdStatusInfo = new ATAdStatusInfo(zG, cVarB != null, cVarB != null ? cVarB.p() : null);
        if (this.j != null) {
            if (!(System.currentTimeMillis() - this.o <= com.anythink.basead.exoplayer.i.a.f) && a(aTAdStatusInfo, 5) && (c() <= 0 || !aTAdStatusInfo.isReady())) {
                com.anythink.core.common.p.d dVar = this.j;
                dVar.a(context, ((com.anythink.core.common.p.a) dVar).a(), 5);
            }
        }
        return aTAdStatusInfo;
    }

    private List<com.anythink.core.common.h.c> c(Context context) {
        return a.a().a(context, this.b, false, false, true, (com.anythink.core.common.h.ae) null);
    }

    public final List<ATAdInfo> a(Context context, com.anythink.core.common.h.ae aeVar) {
        List<com.anythink.core.common.h.c> listD = d(context);
        if (listD == null || listD.size() <= 0) {
            return null;
        }
        return a(aeVar, listD);
    }

    private List<com.anythink.core.common.h.c> d(Context context) {
        if (a(false, false, (com.anythink.core.common.h.ae) null)) {
            return null;
        }
        return a.a().a(context, this.b, false, false, true, (com.anythink.core.common.h.ae) null);
    }

    private static List<ATAdInfo> a(com.anythink.core.common.h.ae aeVar, List<com.anythink.core.common.h.c> list) {
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
                    arrayList.add(com.anythink.core.common.d.l.a(baseAdF, aTBaseAdAdapterE, 4));
                } else if (aTBaseAdAdapterE != null) {
                    if (dVarB != null && (trackingInfo = aTBaseAdAdapterE.getTrackingInfo()) != null) {
                        trackingInfo.a(dVarB);
                    }
                    arrayList.add(com.anythink.core.common.d.l.a(aTBaseAdAdapterE, 4));
                }
            }
        }
        return arrayList;
    }

    public final com.anythink.core.common.h.c a(Context context, boolean z, boolean z2, com.anythink.core.common.h.ae aeVar) {
        if (a(z2, z, aeVar)) {
            return null;
        }
        return a.a().a(context, this.b, z, z2, aeVar);
    }

    private boolean a(boolean z, boolean z2, com.anythink.core.common.h.ae aeVar) {
        Map<String, Object> mapA = aeVar != null ? aeVar.a() : null;
        com.anythink.core.common.h.d dVarB = aeVar != null ? aeVar.b() : null;
        com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(this.b);
        String str = TextUtils.isEmpty(this.e) ? "" : this.e;
        if (lVarA == null) {
            lVarA = com.anythink.core.d.n.a(this.a).a(this.b);
        }
        com.anythink.core.d.l lVar = lVarA;
        if (lVar == null) {
            if (z) {
                com.anythink.core.common.u.e.a(str, this.b, lVar, 4, "", mapA, aeVar);
            } else if (z2) {
                com.anythink.core.common.u.e.a(str, this.b, false, 4, lVar, (com.anythink.core.common.h.c) null, "", "", mapA, dVarB, aeVar);
            }
            return true;
        }
        com.anythink.core.a.d.a();
        int iA = com.anythink.core.a.d.a(this.b, lVar);
        if (iA != -1) {
            if (z) {
                com.anythink.core.common.u.e.a(str, this.b, lVar, iA, "", mapA, aeVar);
            } else if (z2) {
                com.anythink.core.common.u.e.a(str, this.b, false, iA, lVar, (com.anythink.core.common.h.c) null, "", "", mapA, dVarB, aeVar);
            }
            return true;
        }
        int iA2 = com.anythink.core.a.a.a(this.a).a(lVar, this.b);
        if (iA2 == -1) {
            return false;
        }
        if (z) {
            com.anythink.core.common.u.e.a(str, this.b, lVar, iA2, "", mapA, aeVar);
        } else if (z2) {
            com.anythink.core.common.u.e.a(str, this.b, false, iA2, lVar, (com.anythink.core.common.h.c) null, "", "", mapA, dVarB, aeVar);
        }
        return true;
    }

    public final void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.f.6
            @Override // java.lang.Runnable
            public final void run() {
                g gVar = f.this.c.get(str);
                if (gVar != null) {
                    gVar.g();
                }
            }
        }, 2);
    }

    private void a(String str, com.anythink.core.common.d.a aVar) {
        com.anythink.core.common.p.c cVar = this.i;
        if (cVar != null) {
            cVar.a(str, aVar);
        }
    }

    public final void a(ar arVar, AdError adError) {
        n nVar = this.g;
        if (nVar != null) {
            nVar.a(1, arVar, (cb) null, adError);
        }
    }

    private boolean m() {
        return !TextUtils.isEmpty(this.e);
    }

    public final boolean a(ATAdStatusInfo aTAdStatusInfo, int i) {
        com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(this.b);
        if ((lVarA != null && c() >= lVarA.q() && aTAdStatusInfo != null && aTAdStatusInfo.isReady()) || ATAdxSetting.getInstance().isAdxNetworkMode(this.b)) {
            return false;
        }
        if (i == 6 || i == 18) {
            int iG = lVarA.g();
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
        if (!n()) {
            return lVarA != null && lVarA.ao() == 1;
        }
        if (a(i, lVarA != null ? lVarA.bz() : null)) {
            return true;
        }
        return lVarA != null && lVarA.ao() == 1 && (i == 5 || i == 6 || i == 7);
    }

    private boolean a(int i, List<String> list) {
        com.anythink.core.common.p.d dVar = this.j;
        if (dVar != null) {
            return dVar.a(i, list);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        com.anythink.core.common.p.d dVar = this.j;
        return dVar != null && dVar.b();
    }

    private void o() {
        com.anythink.core.common.p.d dVar = this.j;
        if (dVar != null) {
            dVar.d();
        }
    }

    private void p() {
        com.anythink.core.common.p.d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
    }

    final void a(AdError adError) {
        com.anythink.core.common.p.d dVar = this.j;
        if (dVar != null) {
            dVar.a(adError, this.f, a((ATAdStatusInfo) null, 4));
        }
    }

    private static String a(com.anythink.core.common.h.x xVar) {
        return xVar.b + xVar.c + xVar.f + System.currentTimeMillis();
    }

    public static String a(String str, String str2, String str3) {
        return str + str2 + str3 + System.currentTimeMillis();
    }

    public final void b(Context context, String str, String str2, ar arVar, com.anythink.core.common.d.a aVar) {
        if (w.a().b()) {
            com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(context).a(this.b);
            if (lVarA != null && w.a().a(this.b)) {
                Log.w("anythink", "Forbidden placement");
                if (aVar != null) {
                    aVar.onAdLoadFail(ErrorCode.getErrorCode(ErrorCode.sharedPlacementIdError, "", ""));
                    return;
                }
                return;
            }
            if (w.a().a(lVarA)) {
                String strU = lVarA.u();
                com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
                a(dVar, str2, lVarA);
                arVar.i = dVar;
                com.anythink.core.common.d.a[] aVarArr = {aVar};
                if (lVarA.y() == 1) {
                    com.anythink.core.common.h.c cVarB = b(context, strU, str, arVar);
                    if (cVarB != null) {
                        String strA = com.anythink.core.common.v.p.a(context);
                        arVar.a = strA;
                        ab.a("Shared", "placementId:" + str2 + ";result_callback:success;");
                        com.anythink.core.common.h.n nVarI = cVarB.i();
                        com.anythink.core.common.u.e.a(str2, strU, nVarI, str, strA, lVarA, true, "1", "2", nVarI != null ? nVarI.aJ() : "");
                        com.anythink.core.common.d.a aVar2 = aVarArr[0];
                        if (aVar2 != null) {
                            aVar2.onAdLoaded();
                        }
                        aVarArr[0] = null;
                    } else {
                        w.a().b(strU, arVar.b());
                    }
                    a(context, str, str2, arVar, new AnonymousClass7(aVarArr, str2, strU, str, arVar, lVarA));
                    return;
                }
                a(context, str, str2, arVar, new AnonymousClass8(str2, strU, str, arVar, lVarA, aVarArr, context));
                return;
            }
        }
        a(context, str, str2, arVar, aVar);
    }

    public final com.anythink.core.common.h.c b(Context context, boolean z, boolean z2, com.anythink.core.common.h.ae aeVar) {
        if (w.a().b()) {
            com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(context).a(this.b);
            if (lVarA != null && w.a().a(this.b)) {
                Log.w("anythink", "Forbidden placement");
                return null;
            }
            if (lVarA != null && w.a().a(lVarA)) {
                return a(context, z, z2, aeVar, this, lVarA);
            }
        }
        return a(context, z, z2, aeVar);
    }

    public final List<ATAdInfo> a(Context context) {
        List<com.anythink.core.common.h.c> listD = null;
        if (w.a().b()) {
            com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(context).a(this.b);
            if (lVarA != null && w.a().a(this.b)) {
                Log.w("anythink", "Forbidden placement");
                return null;
            }
            if (w.a().a(lVarA)) {
                String strU = lVarA.u();
                w.a();
                f fVarA = w.a(strU, String.valueOf(lVarA.aq()));
                com.anythink.core.common.h.ae aeVar = new com.anythink.core.common.h.ae();
                com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
                if (fVarA != null) {
                    a(dVar, this.b, lVarA);
                    aeVar.a(dVar);
                    aeVar.a(fVarA.q);
                    listD = fVarA.d(context);
                }
                List<com.anythink.core.common.h.c> listD2 = d(context);
                if (listD == null) {
                    return a(aeVar, listD2);
                }
                if (listD2 == null || listD2.size() == 0) {
                    return a(aeVar, listD);
                }
                listD2.addAll(listD);
                Collections.sort(listD2, new AnonymousClass9());
                return a(aeVar, listD2);
            }
        }
        return a(context, (com.anythink.core.common.h.ae) null);
    }

    public final List<com.anythink.core.common.h.c> b(Context context) {
        com.anythink.core.d.l lVarA;
        List<com.anythink.core.common.h.c> listC;
        try {
            List<com.anythink.core.common.h.c> listC2 = c(context);
            ArrayList arrayList = new ArrayList();
            if (listC2 != null) {
                listC2.size();
                arrayList.addAll(listC2);
            }
            if (w.a().b() && (lVarA = com.anythink.core.d.n.a(context).a(this.b)) != null && w.a().a(lVarA)) {
                String strU = lVarA.u();
                int iAq = lVarA.aq();
                w.a();
                f fVarA = w.a(strU, String.valueOf(iAq));
                if (fVarA != null && (listC = fVarA.c(context)) != null && !listC.isEmpty()) {
                    listC.size();
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
    public static com.anythink.core.common.h.c b(Context context, String str, String str2, ar arVar) {
        w.a();
        f fVarA = w.a(str, str2);
        if (fVarA == null) {
            return null;
        }
        com.anythink.core.common.h.ae aeVar = new com.anythink.core.common.h.ae();
        aeVar.a(arVar.g);
        aeVar.a(arVar.i);
        aeVar.a(arVar.b());
        return fVarA.a(context, true, false, aeVar);
    }

    private void a(Context context, String str, String str2, ar arVar, com.anythink.core.common.d.a aVar, f fVar, com.anythink.core.d.l lVar) {
        String strU = lVar.u();
        com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
        a(dVar, str2, lVar);
        arVar.i = dVar;
        com.anythink.core.common.d.a[] aVarArr = {aVar};
        if (lVar.y() == 1) {
            com.anythink.core.common.h.c cVarB = b(context, strU, str, arVar);
            if (cVarB != null) {
                String strA = com.anythink.core.common.v.p.a(context);
                arVar.a = strA;
                ab.a("Shared", "placementId:" + str2 + ";result_callback:success;");
                com.anythink.core.common.h.n nVarI = cVarB.i();
                com.anythink.core.common.u.e.a(str2, strU, nVarI, str, strA, lVar, true, "1", "2", nVarI != null ? nVarI.aJ() : "");
                com.anythink.core.common.d.a aVar2 = aVarArr[0];
                if (aVar2 != null) {
                    aVar2.onAdLoaded();
                }
                aVarArr[0] = null;
            } else {
                w.a().b(strU, arVar.b());
            }
            fVar.a(context, str, str2, arVar, new AnonymousClass7(aVarArr, str2, strU, str, arVar, lVar));
            return;
        }
        fVar.a(context, str, str2, arVar, new AnonymousClass8(str2, strU, str, arVar, lVar, aVarArr, context));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$7, reason: invalid class name */
    final class AnonymousClass7 implements com.anythink.core.common.d.a {
        final /* synthetic */ com.anythink.core.common.d.a[] a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ ar e;
        final /* synthetic */ com.anythink.core.d.l f;

        AnonymousClass7(com.anythink.core.common.d.a[] aVarArr, String str, String str2, String str3, ar arVar, com.anythink.core.d.l lVar) {
            this.a = aVarArr;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = arVar;
            this.f = lVar;
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoaded() {
            if (this.a[0] != null) {
                com.anythink.core.common.u.e.a(this.b, this.c, (com.anythink.core.common.h.n) null, this.d, this.e.a, this.f, true, "0", "1", "");
                this.a[0].onAdLoaded();
            }
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoadFail(AdError adError) {
            if (this.a[0] != null) {
                com.anythink.core.common.u.e.a(this.b, this.c, (com.anythink.core.common.h.n) null, this.d, this.e.a, this.f, false, "0", "0", "");
                this.a[0].onAdLoadFail(adError);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$8, reason: invalid class name */
    final class AnonymousClass8 implements com.anythink.core.common.d.a {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ ar d;
        final /* synthetic */ com.anythink.core.d.l e;
        final /* synthetic */ com.anythink.core.common.d.a[] f;
        final /* synthetic */ Context g;

        AnonymousClass8(String str, String str2, String str3, ar arVar, com.anythink.core.d.l lVar, com.anythink.core.common.d.a[] aVarArr, Context context) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = arVar;
            this.e = lVar;
            this.f = aVarArr;
            this.g = context;
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoaded() {
            com.anythink.core.common.u.e.a(this.a, this.b, (com.anythink.core.common.h.n) null, this.c, this.d.a, this.e, true, "2", "1", "");
            com.anythink.core.common.d.a aVar = this.f[0];
            if (aVar != null) {
                aVar.onAdLoaded();
            }
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoadFail(AdError adError) {
            com.anythink.core.common.h.c cVarB = f.b(this.g, this.b, this.c, this.d);
            if (cVarB != null) {
                ab.a("Shared", "placementId:" + this.a + ";result_callback:success;");
                com.anythink.core.common.h.n nVarI = cVarB.i();
                com.anythink.core.common.u.e.a(this.a, this.b, nVarI, this.c, this.d.a, this.e, true, "1", "0", nVarI != null ? nVarI.aJ() : "");
                com.anythink.core.common.d.a aVar = this.f[0];
                if (aVar != null) {
                    aVar.onAdLoaded();
                    return;
                }
                return;
            }
            w.a().b(this.b, this.d.b());
            com.anythink.core.common.u.e.a(this.a, this.b, (com.anythink.core.common.h.n) null, this.c, this.d.a, this.e, false, "0", "0", "");
            com.anythink.core.common.d.a aVar2 = this.f[0];
            if (aVar2 != null) {
                aVar2.onAdLoadFail(adError);
            }
        }
    }

    private com.anythink.core.common.h.c a(Context context, boolean z, boolean z2, com.anythink.core.common.h.ae aeVar, f fVar, com.anythink.core.d.l lVar) {
        com.anythink.core.common.h.c cVarA;
        boolean z3;
        String strAJ;
        String str;
        com.anythink.core.common.h.n nVar;
        boolean z4;
        com.anythink.core.common.h.c cVar;
        String strValueOf;
        String strU = lVar.u();
        int iAq = lVar.aq();
        w.a();
        f fVarA = w.a(strU, String.valueOf(iAq));
        if (fVarA != null) {
            com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
            a(dVar, this.b, lVar);
            if (aeVar != null) {
                aeVar.a(dVar);
                aeVar.a(fVarA.q);
            }
            cVarA = fVarA.a(context, z, z2, aeVar);
            if (cVarA != null) {
                aj.a(this.b, lVar, cVarA.i());
            }
        } else {
            cVarA = null;
        }
        com.anythink.core.common.h.c cVarA2 = fVar.a(context, z, z2, aeVar);
        String strAJ2 = "";
        if (cVarA2 != null) {
            com.anythink.core.common.h.n nVarI = cVarA2.i();
            if (nVarI != null) {
                strAJ = nVarI.aJ();
                strValueOf = String.valueOf(nVarI.U());
            } else {
                strAJ = "";
                strValueOf = strAJ;
                nVarI = null;
            }
            str = strValueOf;
            nVar = nVarI;
            z3 = true;
        } else {
            z3 = false;
            strAJ = "";
            str = strAJ;
            nVar = null;
        }
        if (cVarA != null) {
            com.anythink.core.common.h.n nVarI2 = cVarA.i();
            strAJ2 = nVarI2 != null ? nVarI2.aJ() : "";
            z4 = true;
        } else {
            w.a().b(strU, fVar.q);
            w.a().a(lVar, 17, fVar.r, nVar);
            z4 = false;
        }
        String str2 = strAJ2;
        if (cVarA != null) {
            if (cVarA2 != null) {
                if (com.anythink.core.common.v.l.a(cVarA.o(), cVarA2.o()) < 0) {
                    cVarA.n();
                    cVarA2.n();
                } else {
                    cVarA.n();
                    cVarA2.n();
                    cVar = cVarA2;
                }
            }
            cVar = cVarA;
        } else {
            cVar = cVarA2;
        }
        com.anythink.core.common.u.e.a(this.b, strU, lVar, cVar != null ? cVar.i() : null, z3 || z4, z3, z4, strAJ, str2, str);
        return cVar;
    }

    private List<ATAdInfo> a(Context context, f fVar, com.anythink.core.d.l lVar) {
        List<com.anythink.core.common.h.c> listD;
        String strU = lVar.u();
        w.a();
        f fVarA = w.a(strU, String.valueOf(lVar.aq()));
        com.anythink.core.common.h.ae aeVar = new com.anythink.core.common.h.ae();
        com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
        if (fVarA != null) {
            a(dVar, this.b, lVar);
            aeVar.a(dVar);
            aeVar.a(fVarA.q);
            listD = fVarA.d(context);
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
        Collections.sort(listD2, new AnonymousClass9());
        return a(aeVar, listD2);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.f$9, reason: invalid class name */
    final class AnonymousClass9 implements Comparator<com.anythink.core.common.h.c> {
        AnonymousClass9() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.anythink.core.common.h.c cVar, com.anythink.core.common.h.c cVar2) {
            return com.anythink.core.common.v.l.a(cVar.o(), cVar2.o());
        }

        private static int a(com.anythink.core.common.h.c cVar, com.anythink.core.common.h.c cVar2) {
            return com.anythink.core.common.v.l.a(cVar.o(), cVar2.o());
        }
    }

    private static void a(com.anythink.core.common.h.d dVar, String str, com.anythink.core.d.l lVar) {
        dVar.a(str, lVar.ay(), lVar.ai());
    }

    private com.anythink.core.d.l a(boolean z, Map<String, Object> map) {
        if (!z && map != null) {
            Object obj = map.get(CoreDebuggerManager.a);
            Object[] objArr = new Object[1];
            if (obj instanceof com.anythink.core.d.l) {
                return (com.anythink.core.d.l) obj;
            }
        }
        return null;
    }

    static /* synthetic */ boolean a(f fVar) {
        return !TextUtils.isEmpty(fVar.e);
    }

    static /* synthetic */ void c(f fVar) {
        com.anythink.core.common.p.d dVar = fVar.j;
        if (dVar != null) {
            dVar.d();
        }
    }

    static /* synthetic */ com.anythink.core.d.l a(f fVar, boolean z, Map map) {
        if (z || map == null) {
            return null;
        }
        Object obj = map.get(CoreDebuggerManager.a);
        String str = fVar.l;
        Object[] objArr = new Object[1];
        if (obj instanceof com.anythink.core.d.l) {
            return (com.anythink.core.d.l) obj;
        }
        return null;
    }

    static /* synthetic */ void a(f fVar, Context context, String str, String str2, com.anythink.core.d.l lVar, ar arVar, com.anythink.core.common.h.n nVar, String str3, String str4, int i, boolean z) {
        com.anythink.core.d.n.a(context).a(lVar, str, str2, fVar.b, arVar.g, fVar.new AnonymousClass2(nVar, str3, arVar, str4), i, z, arVar.b());
    }

    static /* synthetic */ void a(f fVar, Context context, String str, String str2, com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar, ar arVar) {
        if (nVar != null) {
            nVar.e(SystemClock.elapsedRealtime());
        }
        com.anythink.core.common.w.b.h hVar = new com.anythink.core.common.w.b.h(context, str, lVar, fVar.new AnonymousClass3(arVar, context, str, str2, lVar, nVar));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new com.anythink.core.common.w.b.e());
        new com.anythink.core.common.w.b.g(arrayList, hVar, 0).a(hVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    static /* synthetic */ void b(f fVar, Context context, String str, String str2, com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar, ar arVar) {
        boolean z;
        bv bvVar;
        bz bzVar;
        ac acVar;
        List<bv> list;
        boolean z2;
        boolean z3;
        bq bqVar;
        boolean z4;
        bp bpVar;
        g gVar;
        lVar.A();
        ar arVar2 = null;
        com.anythink.core.common.h.n nVarAq = lVar.aq();
        com.anythink.core.common.u.e.a("1", nVar, str2, str, "", 0, (int) nVarAq, 0L);
        cb cbVar = new cb(arVar, lVar);
        if (nVar != null) {
            nVar.g(cbVar.e());
            nVar.h(cbVar.f());
        }
        try {
            try {
                if (lVar.bj()) {
                    a(lVar, nVar);
                    b(lVar, nVar);
                    bp bpVarA = ae.a(lVar, nVar);
                    com.anythink.core.common.h.n nVarC = bpVarA.c();
                    if (bpVarA.b() == 0) {
                        nVarC.L(5);
                        if (bpVarA.a().D() == 1) {
                            throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                        }
                        throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                    }
                    if (bpVarA.i()) {
                        boolean zK = bpVarA.k();
                        ArrayList arrayList = new ArrayList(1);
                        ae.b(bpVarA, arrayList);
                        List<bv> listD = bpVarA.d();
                        if (listD != null && !listD.isEmpty()) {
                            ae.a(lVar, bpVarA.c(), listD);
                        }
                        List<bv> listA = ae.a(bpVarA, bpVarA.d());
                        a.a().b(str);
                        boolean z5 = arrayList.size() > 0;
                        boolean z6 = !z5 && (bpVarA.e() == null || bpVarA.e().size() == 0);
                        nVar.f(SystemClock.elapsedRealtime());
                        if (z6 && ((listA == null || listA.size() == 0) && ((bpVarA.f() == null || bpVarA.f().size() == 0) && ((bpVarA.g() == null || bpVarA.g().size() == 0) && (bpVarA.h() == null || bpVarA.h().size() == 0))))) {
                            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                            nVar.L(6);
                            fVar.a(true, nVar, errorCode, arVar);
                            fVar.d = false;
                            return;
                        }
                        com.anythink.core.a.c.a();
                        com.anythink.core.a.c.b(fVar.a, str, lVar);
                        Map<String, Object> mapB = u.a().b(fVar.b);
                        x xVarA = x.a(fVar.a);
                        bz bzVarRemove = xVarA.a != null ? xVarA.a.remove(str) : null;
                        bq bqVarA = v.a(fVar.a).a(str, str2);
                        ac acVarA = d.a().a(str);
                        ac acVar2 = new ac(str2);
                        boolean z7 = z6;
                        bq bqVar2 = bqVarA;
                        d.a().a(fVar.b, acVar2);
                        nVar.b(true);
                        nVar.B(cbVar.f());
                        g gVar2 = new g(arVar.a());
                        gVar2.h = mapB;
                        gVar2.i = nVar;
                        gVar2.a(arVar);
                        gVar2.a(arVar.d);
                        fVar.e = str2;
                        fVar.m = nVar.aB();
                        List<bv> listA2 = com.anythink.core.d.u.a(lVar, lVar.Y());
                        if (listA2.size() > 0) {
                            z = false;
                            bvVar = listA2.get(0);
                        } else {
                            z = false;
                            bvVar = null;
                        }
                        if (bvVar != null) {
                            for (bv bvVar2 : bpVarA.e()) {
                                if (bvVar2.z().equals(bvVar.z())) {
                                    z4 = false;
                                    g gVar3 = gVar2;
                                    bqVar = bqVar2;
                                    bzVar = bzVarRemove;
                                    acVar = acVarA;
                                    z3 = z7;
                                    list = listA;
                                    z2 = zK;
                                    bpVar = bpVarA;
                                    com.anythink.core.common.a.c.a aVarA = com.anythink.core.common.a.c.a().a(context, str, str2, bvVar2, lVar, mapB, fVar.q);
                                    if (aVarA != null) {
                                        bv bvVarD = aVarA.d();
                                        AdError adErrorA = ae.a(0, nVar, bvVarD, (z) null);
                                        new StringBuilder("checkToGetWaterfallList() >>> filter mAdxDefaultCacheInfo end:").append(adErrorA);
                                        if (adErrorA != null) {
                                            com.anythink.core.common.a.c.a().a(str, bvVarD.z());
                                            gVar = gVar3;
                                        } else {
                                            gVar = gVar3;
                                            gVar.J = aVarA;
                                        }
                                        nVar.d(SystemClock.elapsedRealtime());
                                    } else {
                                        gVar = gVar3;
                                    }
                                } else {
                                    bzVar = bzVarRemove;
                                    acVar = acVarA;
                                    list = listA;
                                    z2 = zK;
                                    z3 = z7;
                                    bqVar = bqVar2;
                                    z4 = false;
                                    bpVar = bpVarA;
                                    gVar = gVar2;
                                }
                                gVar2 = gVar;
                                z = z4;
                                z7 = z3;
                                bpVarA = bpVar;
                                bqVar2 = bqVar;
                                bzVarRemove = bzVar;
                                acVarA = acVar;
                                listA = list;
                                zK = z2;
                            }
                        }
                        boolean z8 = z;
                        bz bzVar2 = bzVarRemove;
                        ac acVar3 = acVarA;
                        List<bv> list2 = listA;
                        boolean z9 = zK;
                        boolean z10 = z7;
                        bq bqVar3 = bqVar2;
                        bp bpVar2 = bpVarA;
                        g gVar4 = gVar2;
                        com.anythink.core.common.u.c.a(fVar.a).a(10, nVar);
                        Double[] dArr = new Double[1];
                        Boolean boolBn = lVar.bn();
                        if (bpVar2.j() || (boolBn != null && boolBn.booleanValue())) {
                            com.anythink.core.common.h.c cVarA = a.a().a(context, str);
                            if (cVarA != null) {
                                dArr[z8 ? 1 : 0] = Double.valueOf(cVarA.n());
                            }
                        }
                        new StringBuilder("checkToGetWaterfallList() >>> placementId=").append(fVar.b).append(", curMaxCachePrice=").append(dArr[z8 ? 1 : 0]).append(", hasDynamicAdSource=").append(bpVar2.j()).append(", inDynamicBidFloor=").append(boolBn);
                        com.anythink.core.common.w.i iVar = new com.anythink.core.common.w.i(list2);
                        com.anythink.core.common.w.h hVar = new com.anythink.core.common.w.h();
                        hVar.a = str;
                        hVar.b = str2;
                        hVar.c = cbVar;
                        hVar.d = list2;
                        hVar.e = bpVar2.h();
                        hVar.i = z10;
                        hVar.j = nVar.aE();
                        hVar.k = bzVar2;
                        hVar.m = bqVar3;
                        hVar.l = iVar;
                        hVar.o = acVar3;
                        hVar.n = acVar2;
                        hVar.f = bpVar2.f();
                        hVar.g = bpVar2.g();
                        Double d = dArr[0];
                        hVar.h = d != null ? d.doubleValue() : 0.0d;
                        hVar.p = bpVar2.e();
                        gVar4.a(hVar);
                        fVar.c.put(str2, gVar4);
                        if (arVar.m != null) {
                            arVar.m.h(System.currentTimeMillis());
                        }
                        com.anythink.core.common.u.e.a(arVar.m, nVar);
                        h hVar2 = new h(str);
                        gVar4.a(hVar2);
                        hVar2.a(lVar, z9);
                        hVar2.a(fVar.k);
                        hVar2.a(gVar4);
                        fVar.d = false;
                        if (!z10) {
                            com.anythink.core.common.v.b.b.a().b(fVar.new AnonymousClass4(context, arVar, str2, str, lVar, z5, bpVar2.e(), cbVar, nVar, bzVar2, bqVar3, acVar3, iVar, boolBn, dArr, z9, hVar2, gVar4));
                        }
                        Object[] objArr = new Object[1];
                        Integer.valueOf(arVar.c);
                        if (arVar.c == 0 || arVar.c == 3) {
                            w.a().a(lVar, 15, arVar, nVar);
                            return;
                        }
                        return;
                    }
                    nVarC.L(6);
                    AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
                    throw new com.anythink.core.common.h.m(errorCode2, errorCode2.printStackTrace());
                }
                nVar.L(5);
                throw new com.anythink.core.common.h.m(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
            } catch (com.anythink.core.common.h.m e) {
                e = e;
                fVar.a(true, nVarAq, e, arVar2);
            } catch (Throwable th) {
                th = th;
                fVar.a(true, nVarAq, th, arVar2);
            }
        } catch (com.anythink.core.common.h.m e2) {
            e = e2;
            arVar2 = arVar;
            nVarAq = nVar;
        } catch (Throwable th2) {
            th = th2;
            arVar2 = arVar;
            nVarAq = nVar;
        }
    }
}
