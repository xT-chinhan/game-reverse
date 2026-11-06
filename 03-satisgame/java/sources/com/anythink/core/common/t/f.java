package com.anythink.core.common.t;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdMixBidInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATWaterfallFilter;
import com.anythink.core.api.AdError;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.af;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.au;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.ba;
import com.anythink.core.common.h.be;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.bl;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cg;
import com.anythink.core.common.h.h;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.u;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.u.ag;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.p;
import com.anythink.core.common.v;
import com.anythink.core.e.l;
import com.anythink.core.mg.api.MgAdInfo;
import com.anythink.core.mg.api.MgComparedResult;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 7;
    public static final int d = 8;
    public static final int e = 9;
    public static final int f = 10;
    public static final int g = 3;
    public static final int h = 11;
    public static final int i = 12;
    public static final int j = 4;
    public static final int k = 5;
    public static final int l = 5;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 1;
    public static final int s = 2;
    public static final int t = 3;
    public static final int u = 4;
    public static final int v = 5;
    public static final int w = 0;
    private static final String x = "f";

    private static void b() {
    }

    public static void a(n nVar, AdError adError) {
        a(nVar, adError, (by) null);
    }

    public static void a(n nVar, AdError adError, by byVar) {
        try {
            u uVar = new u(nVar.aS(), null);
            uVar.c = "1004630";
            uVar.a(nVar);
            l lVarA = com.anythink.core.e.n.a(s.b().g()).a(nVar.aQ());
            uVar.k = lVarA != null ? lVarA.am() : "";
            if (adError != null) {
                uVar.p = adError.printStackTrace();
                uVar.q = adError.getCode();
            }
            if (byVar != null) {
                uVar.r = byVar.G();
                uVar.s = String.valueOf(o.a(byVar));
            }
            uVar.U = nVar.aJ();
            uVar.V = nVar.aK();
            uVar.ab = nVar.aF();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(n nVar, String str, int i2, String str2, String str3, int i3, int i4, AdError adError, int i5, double d2, long j2, int i6, int i7, String str4, String str5, JSONObject jSONObject, int i8, String str6) {
        u uVar = new u(str3, String.valueOf(i2));
        uVar.c = "1004631";
        uVar.a(nVar);
        uVar.p = String.valueOf(i2);
        uVar.q = str2;
        uVar.r = String.valueOf(i3);
        if (!TextUtils.isEmpty(str6)) {
            uVar.s = "15";
        } else {
            uVar.s = String.valueOf(i4);
        }
        uVar.t = adError != null ? adError.getPlatformCode() : "";
        uVar.u = adError != null ? adError.getPlatformMSG() : "";
        uVar.v = String.valueOf(i5);
        uVar.w = String.valueOf(d2);
        if (i4 == 0) {
            uVar.x = String.valueOf(j2);
        }
        uVar.y = String.valueOf(i6);
        uVar.z = String.valueOf(i7);
        if (i8 >= -1) {
            uVar.A = String.valueOf(i8);
        }
        l lVarA = com.anythink.core.e.n.a(s.b().g()).a(str);
        uVar.k = lVarA != null ? lVarA.am() : "";
        uVar.U = str4;
        uVar.V = str5;
        if (jSONObject != null) {
            uVar.ab = jSONObject;
        }
        if (nVar.aC() > 0.0d) {
            uVar.C = String.valueOf(nVar.aC());
        }
        if (!TextUtils.isEmpty(nVar.aD())) {
            uVar.D = nVar.aD();
        }
        if (nVar.aE() > 0.0d) {
            uVar.E = String.valueOf(nVar.aE());
        }
        a(uVar);
    }

    public static void a(final n nVar, final int i2, final AdError adError) {
        com.anythink.core.common.u.b.c.a().g(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.E, new Runnable() { // from class: com.anythink.core.common.t.f.1
            final /* synthetic */ int d = -1;
            final /* synthetic */ long e = 0;

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String strA = f.a(adError, nVar.Z(), nVar.aQ(), i2);
                    n nVar2 = nVar;
                    f.a(nVar2, nVar2.aQ(), nVar.Z(), nVar.N(), nVar.aS(), this.d, i2, adError, nVar.K(), nVar.M(), this.e, nVar.ad(), nVar.t, nVar.aJ(), nVar.aK(), nVar.aF(), nVar.aq(), strA);
                } catch (Throwable unused) {
                }
            }
        }));
    }

    public static void a(final n nVar, final int i2, final AdError adError, final long j2) {
        com.anythink.core.common.u.b.c.a().g(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.F, new Runnable() { // from class: com.anythink.core.common.t.f.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String strA = f.a(adError, nVar.Z(), nVar.aQ(), i2);
                    n nVar2 = nVar;
                    f.a(nVar2, nVar2.aQ(), nVar.Z(), nVar.N(), nVar.aS(), nVar.P(), i2, adError, nVar.K(), nVar.M(), j2, nVar.ad(), nVar.t, nVar.aJ(), nVar.aK(), nVar.aF(), nVar.aq(), strA);
                } catch (Throwable unused) {
                }
            }
        }));
    }

    public static void a(String str, String str2, l lVar, int i2, af afVar, Map<String, Object> map, ae aeVar) {
        a(str, str2, lVar, i2, afVar.toString(), map, aeVar);
    }

    public static void a(String str, String str2, l lVar, int i2, String str3, Map<String, Object> map, ae aeVar) {
        try {
            u uVar = new u(lVar != null ? String.valueOf(lVar.ap()) : "", "");
            uVar.c = "1004633";
            uVar.a(lVar);
            uVar.a(aeVar);
            uVar.d = str;
            uVar.e = str2;
            uVar.h = String.valueOf(lVar != null ? lVar.ax() : 0);
            uVar.l = "0";
            uVar.o = String.valueOf(lVar != null ? Integer.valueOf(lVar.ah()) : "");
            uVar.p = String.valueOf(i2);
            uVar.q = str3;
            uVar.t = str;
            uVar.u = "0";
            uVar.k = lVar != null ? lVar.am() : "";
            uVar.U = lVar != null ? lVar.B() : "";
            if (map != null) {
                Object obj = map.get(ATAdConst.KEY.CP_PLACEMENT_ID);
                if (obj != null) {
                    uVar.V = obj.toString();
                }
                JSONObject jSONObjectA = ag.a(map);
                if (jSONObjectA != null) {
                    uVar.ab = jSONObjectA;
                }
            }
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(n nVar, by byVar, ATWaterfallFilter.PriceInterval priceInterval) {
        if (s.b().g() == null) {
            return;
        }
        u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
        uVar.c = "1004777";
        uVar.a(nVar);
        uVar.p = String.valueOf(byVar.n());
        uVar.r = String.valueOf(byVar.G());
        if (priceInterval != null) {
            try {
                uVar.s = String.valueOf(priceInterval.getLessPrice());
                uVar.t = priceInterval.getScurrency().name();
            } catch (Exception unused) {
            }
        }
        a(uVar);
    }

    public static void a(n nVar, boolean z) {
        if (s.b().g() == null) {
            return;
        }
        u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
        uVar.c = "1004634";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = nVar.N();
        uVar.r = String.valueOf(nVar.Q());
        uVar.s = z ? "1" : "0";
        uVar.t = String.valueOf(nVar.E);
        if (nVar.Z() == 66) {
            int iAk = nVar.ak();
            if (iAk != 0) {
                uVar.u = String.valueOf(iAk);
            }
            int iAm = nVar.am();
            if (iAm != 0) {
                uVar.w = String.valueOf(iAm);
            }
            int iAn = nVar.an();
            if (iAn != 0) {
                uVar.x = String.valueOf(iAn);
            }
        }
        uVar.v = nVar.aS();
        uVar.y = String.valueOf(nVar.ax());
        uVar.z = String.valueOf(nVar.aw());
        uVar.A = String.valueOf(nVar.ay());
        uVar.B = nVar.ai() == 2 ? "2" : "1";
        l lVarA = com.anythink.core.e.n.a(s.b().g()).a(nVar.aQ());
        uVar.k = lVarA != null ? lVarA.am() : "";
        uVar.S = nVar.aS();
        uVar.U = nVar.aJ();
        uVar.V = nVar.aK();
        uVar.ab = nVar.aF();
        a(uVar);
        d.a().a(uVar, nVar);
    }

    public static void a(String str, String str2, boolean z, int i2, l lVar, com.anythink.core.common.h.c cVar, af afVar, String str3, Map<String, Object> map, com.anythink.core.common.h.d dVar, ae aeVar) {
        a(str, str2, z, i2, lVar, cVar, afVar, str3, map, dVar, 0L, aeVar);
    }

    public static void a(final String str, final String str2, final boolean z, final int i2, final l lVar, final com.anythink.core.common.h.c cVar, final af afVar, final String str3, final Map<String, Object> map, final com.anythink.core.common.h.d dVar, final long j2, final ae aeVar) {
        try {
            a(new Runnable() { // from class: com.anythink.core.common.t.f.3
                @Override // java.lang.Runnable
                public final void run() {
                    Object obj;
                    JSONObject jSONObjectA;
                    try {
                        com.anythink.core.common.h.c cVar2 = cVar;
                        n nVarI = cVar2 != null ? cVar2.i() : null;
                        l lVar2 = lVar;
                        u uVar = new u(lVar2 != null ? String.valueOf(lVar2.ap()) : "", nVarI != null ? String.valueOf(nVarI.Z()) : "");
                        uVar.c = "1004632";
                        uVar.d = str;
                        uVar.e = str2;
                        uVar.a(nVarI);
                        if (nVarI == null) {
                            uVar.a(aeVar);
                            l lVar3 = lVar;
                            if (lVar3 != null) {
                                uVar.k = lVar3.am();
                                uVar.h = String.valueOf(lVar.ax());
                                uVar.o = String.valueOf(lVar.ah());
                            }
                        }
                        if (TextUtils.isEmpty(uVar.h)) {
                            l lVar4 = lVar;
                            if (lVar4 != null) {
                                uVar.h = String.valueOf(lVar4.ax());
                            } else {
                                uVar.h = "0";
                            }
                        }
                        uVar.p = z ? "1" : "0";
                        uVar.q = String.valueOf(i2);
                        uVar.r = nVarI != null ? String.valueOf(nVarI.Q()) : "-1";
                        uVar.s = nVarI != null ? nVarI.N() : "";
                        uVar.t = nVarI != null ? String.valueOf(nVarI.Z()) : "";
                        uVar.u = nVarI != null ? nVarI.y : "";
                        af afVar2 = afVar;
                        uVar.v = afVar2 != null ? afVar2.toString() : "";
                        uVar.w = nVarI != null ? nVarI.aR() : str;
                        if (nVarI != null && !TextUtils.equals(str, nVarI.aR())) {
                            uVar.x = "1";
                        } else {
                            uVar.x = "0";
                        }
                        if (nVarI != null) {
                            uVar.y = nVarI.t == 3 ? "1" : "0";
                        } else {
                            uVar.y = "0";
                        }
                        uVar.z = str3;
                        com.anythink.core.common.h.c cVar3 = cVar;
                        if (cVar3 != null && cVar3.l() == "3") {
                            uVar.B = "1";
                        }
                        long j3 = j2;
                        if (j3 > 0) {
                            uVar.A = String.valueOf(j3);
                        }
                        l lVar5 = lVar;
                        uVar.k = lVar5 != null ? lVar5.am() : "";
                        l lVar6 = lVar;
                        uVar.S = lVar6 != null ? String.valueOf(lVar6.ap()) : "";
                        if (nVarI != null) {
                            uVar.U = nVarI.aJ();
                        } else {
                            l lVar7 = lVar;
                            if (lVar7 != null) {
                                uVar.U = lVar7.B();
                            }
                        }
                        if (nVarI != null) {
                            uVar.V = nVarI.aK();
                        } else {
                            Map map2 = map;
                            if (map2 != null && (obj = map2.get(ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                                uVar.V = obj.toString();
                            }
                        }
                        com.anythink.core.common.h.d dVar2 = dVar;
                        if (dVar2 != null) {
                            uVar.X = dVar2.a();
                            uVar.Y = dVar.b();
                            uVar.Z = dVar.c();
                        }
                        if (nVarI != null) {
                            uVar.ab = nVarI.aF();
                        } else {
                            Map map3 = map;
                            if (map3 != null && (jSONObjectA = ag.a(map3)) != null) {
                                uVar.ab = jSONObjectA;
                            }
                        }
                        f.a(uVar);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public static void a(n nVar, AdError adError, Map<String, Object> map) {
        if (s.b().g() == null) {
            return;
        }
        u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
        uVar.c = "1004636";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = nVar.N();
        uVar.r = String.valueOf(nVar.Q());
        if (adError != null) {
            uVar.s = adError.getCode();
            uVar.t = adError.getPlatformCode();
            uVar.u = adError.getPlatformMSG();
        }
        l lVarA = com.anythink.core.e.n.a(s.b().g()).a(nVar.aQ());
        uVar.k = lVarA != null ? lVarA.am() : "";
        uVar.S = nVar.aS();
        if (map != null) {
            try {
                if (map.containsKey("offer_id")) {
                    uVar.v = map.get("offer_id").toString();
                }
                if (map.containsKey("rv_anim_type") && nVar.aS().equals("1")) {
                    uVar.w = map.get("rv_anim_type").toString();
                }
            } catch (Throwable unused) {
            }
        }
        uVar.U = nVar.aJ();
        uVar.V = nVar.aK();
        uVar.ab = nVar.aF();
        a(uVar);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, ATAdRequest aTAdRequest) {
        a(str, str2, str3, str4, str5, str6, str7, aTAdRequest, "", 0);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, ATAdRequest aTAdRequest, String str8, int i2) {
        u uVar = new u(null, null);
        uVar.c = "1004616";
        uVar.a(aTAdRequest);
        uVar.e = str5;
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        uVar.s = str4;
        uVar.t = str6;
        uVar.u = str7;
        uVar.v = String.valueOf(p.a(s.b().g()) ? 1 : 0);
        uVar.w = String.valueOf(com.anythink.core.e.d.a().aC());
        uVar.x = str8;
        if (i2 > 0) {
            uVar.y = String.valueOf(i2);
        }
        a(uVar);
    }

    public static void a(String str, String str2, long j2, long j3, long j4, ATAdRequest aTAdRequest) {
        a(str, str2, j2, j3, j4, aTAdRequest, "");
    }

    public static void a(String str, String str2, long j2, long j3, long j4, ATAdRequest aTAdRequest, String str3) {
        u uVar = new u(null, null);
        uVar.c = "1004635";
        uVar.a(aTAdRequest);
        if (!TextUtils.isEmpty(str2)) {
            uVar.e = str2;
        }
        uVar.p = str;
        uVar.q = String.valueOf(j2);
        uVar.r = String.valueOf(j3);
        uVar.s = String.valueOf(j4);
        uVar.t = String.valueOf(com.anythink.core.e.d.a().aC());
        uVar.u = str3;
        a(uVar);
    }

    public static void a(String str, String str2, String str3, String str4) {
        u uVar = new u(null, null);
        uVar.c = "1004637";
        uVar.e = str;
        uVar.p = str2;
        uVar.q = str3;
        uVar.r = str4;
        a(uVar);
    }

    public static void a(String str, String str2, String str3) {
        u uVar = new u(null, null);
        uVar.c = "1004772";
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        a(uVar);
    }

    private static void a(w wVar, x xVar, String str) {
        a(wVar, xVar, false, str, 0.0d, 0.0d, 0L);
    }

    private static void a(w wVar, x xVar, double d2, double d3, long j2) {
        a(wVar, xVar, true, "", d2, d3, j2);
    }

    private static void a(w wVar, x xVar, boolean z, String str, double d2, double d3, long j2) {
        u uVar = new u(null, null);
        uVar.c = "1004764";
        uVar.a(xVar);
        if (wVar != null) {
            uVar.p = String.valueOf(wVar.a());
            if (wVar instanceof r) {
                uVar.r = ((r) wVar).N();
                uVar.s = wVar.h();
            }
            uVar.t = wVar.p();
        }
        if (xVar != null) {
            uVar.q = String.valueOf(xVar.b);
            if (xVar.t != null) {
                uVar.y = String.valueOf(xVar.t.y());
            }
        }
        uVar.u = z ? "1" : "2";
        if (!TextUtils.isEmpty(str)) {
            uVar.v = str;
        }
        if (d2 > 0.0d) {
            uVar.w = String.valueOf(Math.round(d2 / 1024.0d));
        }
        if (d3 > 0.0d) {
            uVar.x = String.valueOf(Math.round(d3 / 1024.0d));
        }
        if (j2 > 0) {
            uVar.z = String.valueOf(j2);
        }
        a(uVar);
    }

    public static void a(n nVar) {
        try {
            u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
            uVar.c = "1004640";
            uVar.a(nVar);
            uVar.p = String.valueOf(nVar.Z());
            uVar.q = nVar.N();
            uVar.r = String.valueOf(nVar.P());
            uVar.s = String.valueOf(nVar.ab());
            uVar.t = String.valueOf(nVar.ac());
            uVar.U = nVar.aJ();
            uVar.V = nVar.aK();
            uVar.ab = nVar.aF();
            uVar.S = nVar.aS();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    private static void c(n nVar, String str) {
        try {
            u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
            uVar.c = "1004639";
            uVar.a(nVar);
            uVar.p = String.valueOf(nVar.Z());
            uVar.q = nVar.N();
            uVar.r = String.valueOf(nVar.P());
            uVar.s = str;
            uVar.S = nVar.aS();
            uVar.U = nVar.aJ();
            uVar.V = nVar.aK();
            uVar.ab = nVar.aF();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(int i2, int i3, int i4, int i5) {
        u uVar = new u(null, String.valueOf(i5));
        uVar.c = "1004641";
        uVar.p = String.valueOf(i2);
        uVar.q = String.valueOf(i3);
        uVar.r = String.valueOf(i4);
        uVar.s = String.valueOf(i5);
        a(uVar);
    }

    private static void a(String str, String str2, String str3, int i2, String str4, long j2, long j3, String str5, String str6) {
        u uVar = new u(null, null);
        uVar.c = "1004642";
        uVar.d = str;
        uVar.ac = str5;
        uVar.ad = str6;
        uVar.p = str2;
        uVar.q = str3;
        uVar.r = String.valueOf(i2);
        if (i2 == 3 || i2 == 10) {
            uVar.s = str4;
        } else if (i2 == 2) {
            uVar.t = String.valueOf(j2);
            uVar.u = String.valueOf(j3 / 1024.0f);
        }
        a(uVar);
    }

    private static void a(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, int i3, long j3, long j4, String str11, String str12) {
        u uVar = new u(null, str3);
        uVar.c = "1004711";
        uVar.d = str;
        uVar.ac = str11;
        uVar.ad = str12;
        uVar.e = str2;
        uVar.j = String.valueOf(j2);
        uVar.p = str3;
        uVar.q = str4;
        uVar.r = str5;
        uVar.s = str6;
        if (!TextUtils.isEmpty(str7)) {
            uVar.t = String.valueOf(str7.contains("data/data") ? 1 : 2);
        }
        uVar.u = str8;
        uVar.v = String.valueOf(i2);
        uVar.w = str9;
        if (!"1".equals(str9)) {
            uVar.x = str10;
        }
        uVar.y = String.valueOf(i3);
        uVar.z = String.valueOf(j3 / 1024.0f);
        uVar.A = String.valueOf(j4);
        a(uVar);
    }

    private static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9) {
        u uVar = new u(null, str3);
        uVar.c = "1004712";
        uVar.d = str;
        uVar.ac = str8;
        uVar.ad = str9;
        uVar.e = str2;
        uVar.j = String.valueOf(System.currentTimeMillis());
        uVar.p = str3;
        uVar.q = str4;
        uVar.r = str5;
        uVar.s = str6;
        uVar.t = str7;
        uVar.u = String.valueOf(i2);
        a(uVar);
    }

    public static void a(int i2, long j2, long j3, String str) {
        u uVar = new u(null, null);
        uVar.c = "1004644";
        uVar.f = str;
        uVar.p = String.valueOf(i2);
        uVar.q = String.valueOf(j2);
        uVar.r = String.valueOf(j3);
        uVar.s = String.valueOf(j3 - j2);
        a(uVar);
    }

    private static void a(int i2, long j2, long j3, String str, String str2) {
        u uVar = new u(null, null);
        uVar.c = "1004651";
        uVar.f = str;
        uVar.p = String.valueOf(i2);
        uVar.q = String.valueOf(j3 - j2);
        uVar.r = str2;
        a(uVar);
    }

    public static void a(n nVar, boolean z, long j2, long j3, long j4) {
        try {
            if (s.b().g() == null) {
                return;
            }
            u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
            uVar.c = "1004643";
            uVar.a(nVar);
            uVar.p = nVar.aS();
            uVar.q = String.valueOf(j2);
            uVar.r = String.valueOf(j3);
            uVar.s = String.valueOf(j4);
            uVar.t = String.valueOf(nVar.Z());
            uVar.u = nVar.N();
            uVar.v = String.valueOf(nVar.Q());
            uVar.w = String.valueOf(nVar.E);
            uVar.x = z ? "1" : "0";
            l lVarA = com.anythink.core.e.n.a(s.b().g()).a(nVar.aQ());
            uVar.k = lVarA != null ? lVarA.am() : "";
            uVar.S = nVar.aS();
            uVar.U = nVar.aJ();
            uVar.V = nVar.aK();
            uVar.ab = nVar.aF();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3, n nVar, l lVar, String str4, String str5) {
        try {
            u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
            uVar.c = str;
            uVar.a(nVar);
            uVar.d = nVar.aR();
            uVar.e = str2;
            uVar.k = lVar != null ? lVar.am() : "";
            uVar.p = String.valueOf(nVar.Z());
            uVar.q = nVar.N();
            uVar.r = nVar.A();
            uVar.s = nVar.p();
            uVar.t = nVar.H;
            uVar.u = str4;
            uVar.v = str5;
            uVar.w = str3;
            uVar.U = nVar.aJ();
            uVar.V = nVar.aK();
            uVar.ab = nVar.aF();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(x xVar, w wVar, int i2) {
        try {
            u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
            uVar.c = "1004679";
            uVar.a(xVar);
            if (wVar instanceof r) {
                uVar.p = ((r) wVar).N();
            }
            uVar.q = xVar.e;
            uVar.r = wVar.h();
            uVar.s = String.valueOf(wVar.a());
            uVar.t = wVar.c();
            uVar.u = wVar.d();
            uVar.v = String.valueOf(i2);
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2, l lVar, String str3) {
        u uVar = new u(null, null);
        uVar.c = "1004646";
        uVar.d = str;
        uVar.e = str2;
        uVar.h = String.valueOf(lVar.ax());
        uVar.o = String.valueOf(lVar.ah());
        uVar.k = lVar.am();
        uVar.w = String.valueOf(str3);
        a(uVar);
    }

    public static void b(String str, String str2, String str3) {
        b(str, str2, str3, "");
    }

    public static void b(String str, String str2, String str3, String str4) {
        u uVar = new u(null, null);
        uVar.c = "1004647";
        uVar.f = str3;
        uVar.p = str2;
        uVar.q = str;
        uVar.r = str4;
        a(uVar);
    }

    private static void a(x xVar, w wVar, String str, String str2, String str3, String str4) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(null, null);
        uVar.c = "1004648";
        uVar.a(xVar);
        uVar.p = wVar.h();
        uVar.q = String.valueOf(wVar.a());
        uVar.r = str;
        uVar.s = str2;
        uVar.t = str3;
        uVar.u = str4;
        a(uVar);
    }

    private static void a(x xVar, w wVar, String str, String str2, int i2, int i3, String str3) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004650";
        uVar.a(xVar);
        uVar.p = wVar.h();
        uVar.q = String.valueOf(wVar.a());
        uVar.r = str;
        uVar.s = str2;
        uVar.t = String.valueOf(i2);
        if (wVar instanceof r) {
            uVar.v = String.valueOf(((r) wVar).N());
        }
        uVar.w = String.valueOf(xVar.b);
        if (i3 > 0) {
            uVar.x = String.valueOf(i3);
        }
        uVar.y = str3;
        a(uVar);
    }

    private static void a(x xVar, w wVar, String str, String str2, int i2) {
        if (xVar == null || wVar == null) {
            return;
        }
        boolean z = i2 == 0;
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004728";
        uVar.a(xVar);
        uVar.p = wVar.h();
        uVar.q = String.valueOf(xVar.t.O());
        uVar.r = String.valueOf(z ? 1 : 2);
        uVar.s = str;
        uVar.t = str2;
        if (!z) {
            uVar.u = String.valueOf(i2);
        }
        a(uVar);
    }

    private static void a(w wVar, x xVar, String str, String str2) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004652";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.j);
        uVar.q = xVar.e;
        if (wVar instanceof ba) {
            uVar.r = "1";
        } else if (wVar instanceof r) {
            uVar.r = "2";
        } else if (wVar instanceof bk) {
            uVar.r = "3";
        }
        uVar.s = str;
        uVar.t = str2;
        uVar.u = wVar.h();
        uVar.v = wVar.i();
        uVar.w = wVar.s();
        uVar.x = wVar.j();
        uVar.y = wVar.k();
        uVar.z = wVar.l();
        uVar.A = wVar.m();
        uVar.B = wVar.p();
        try {
            if (wVar instanceof bl) {
                StringBuilder sb = new StringBuilder();
                String strP = ((bl) wVar).P();
                if (!TextUtils.isEmpty(strP)) {
                    JSONArray jSONArray = new JSONArray(strP);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(jSONArray.optString(i2));
                        sb.append(",");
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    uVar.C = sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        a(uVar);
    }

    public static void a() {
        u uVar = new u(null, null);
        uVar.c = "1004657";
        a(uVar);
    }

    public static void a(ay ayVar, double d2, String str, double d3, double d4, double d5, double d6, String str2, String str3, boolean z) {
        a(ayVar, d2, str, d3, d4, d5, d6, str2, str3, z, 0.0d);
    }

    public static void a(ay ayVar, double d2, String str, double d3, double d4, double d5, double d6, String str2, String str3, boolean z, double d7) {
        u uVar = new u(String.valueOf(ayVar.p()), String.valueOf(ayVar.m()));
        n nVarB = ayVar.B();
        uVar.c = "1004659";
        uVar.a(nVarB);
        uVar.k = ayVar.o();
        uVar.p = String.valueOf(ayVar.m());
        uVar.q = ayVar.n();
        uVar.r = String.valueOf(d2);
        uVar.s = str;
        uVar.U = ayVar.q();
        uVar.V = ayVar.r();
        uVar.t = String.valueOf(d3);
        uVar.u = String.valueOf(d4);
        uVar.v = ayVar.u();
        uVar.w = String.valueOf(ayVar.v());
        uVar.x = String.valueOf(ayVar.j());
        uVar.y = String.valueOf(d5);
        if (ayVar.e() != null) {
            uVar.z = ayVar.e();
        }
        Double dX = ayVar.x();
        if (dX != null) {
            uVar.A = String.valueOf(dX);
        }
        if (ayVar.m() == 66 && d6 > 0.0d) {
            uVar.B = String.valueOf(d4 / d6);
        }
        uVar.C = ayVar.D();
        uVar.D = z ? "1" : null;
        uVar.E = str2;
        if (!TextUtils.isEmpty(str3)) {
            uVar.F = str3;
        }
        ATAdMixBidInfo.BidEntity bidEntityB = ayVar.b();
        if (bidEntityB != null) {
            if (!TextUtils.isEmpty(bidEntityB.getAdUserName())) {
                uVar.G = bidEntityB.getAdUserName();
            }
            if (!TextUtils.isEmpty(bidEntityB.getAdTittle())) {
                uVar.H = bidEntityB.getAdTittle();
            }
            if (!TextUtils.isEmpty(bidEntityB.getAdPackageName())) {
                uVar.L = bidEntityB.getAdPackageName();
            }
        }
        uVar.I = String.valueOf(ayVar.G());
        MgComparedResult mgComparedResultH = ayVar.H();
        if (mgComparedResultH != null && com.anythink.core.c.d.c.b.a(ayVar.y())) {
            uVar.J = mgComparedResultH.isMgWin() ? "1" : "2";
            uVar.K = String.valueOf(mgComparedResultH.getCpCostTime());
        }
        uVar.M = String.valueOf(ayVar.I());
        uVar.N = String.valueOf(ayVar.J());
        if (ayVar.m() == 8 && d7 > 0.0d) {
            uVar.O = String.valueOf(com.anythink.core.c.d.a.a(8, String.valueOf(d7)));
        }
        if (ayVar.K() > 0.0d) {
            uVar.P = String.valueOf(ayVar.K());
        }
        if (!TextUtils.isEmpty(ayVar.L())) {
            uVar.Q = ayVar.L();
        }
        if (nVarB != null) {
            String strAg = nVarB.ag();
            if (!TextUtils.isEmpty(strAg)) {
                uVar.R = strAg;
            }
        }
        uVar.ab = ayVar.s();
        a(uVar);
    }

    public static void a(by byVar, com.anythink.core.common.h.a aVar, long j2, boolean z, boolean z2, boolean z3) {
        u uVar = new u(String.valueOf(aVar.f), String.valueOf(byVar.n()));
        uVar.c = "1004660";
        uVar.a(byVar);
        l lVarA = aVar.n != null ? aVar.n.a() : null;
        uVar.d = aVar.d;
        uVar.e = aVar.e;
        String strB = "";
        uVar.h = String.valueOf(lVarA != null ? Integer.valueOf(lVarA.ax()) : "");
        uVar.o = String.valueOf(lVarA != null ? Integer.valueOf(lVarA.ah()) : "");
        uVar.k = lVarA != null ? lVarA.am() : "";
        uVar.p = String.valueOf(byVar.n());
        uVar.q = byVar.G();
        uVar.r = z ? "1" : "2";
        uVar.s = String.valueOf(j2);
        uVar.t = z2 ? "1" : "2";
        uVar.u = z3 ? "1" : "2";
        if (lVarA != null) {
            try {
                strB = lVarA.B();
            } catch (Throwable unused) {
            }
        }
        uVar.U = strB;
        if (aVar.c.g != null) {
            try {
                Object obj = aVar.c.g.get(ATAdConst.KEY.CP_PLACEMENT_ID);
                if (obj != null) {
                    uVar.V = obj.toString();
                }
            } catch (Throwable unused2) {
            }
            try {
                JSONObject jSONObjectA = ag.a(aVar.c.g);
                if (jSONObjectA != null) {
                    uVar.ab = jSONObjectA;
                }
            } catch (Throwable unused3) {
            }
        }
        a(uVar);
    }

    public static void a(String str, by byVar, boolean z, long j2, com.anythink.core.common.h.a aVar) {
        l lVarA = aVar != null ? aVar.n.a() : null;
        u uVar = new u(String.valueOf(aVar.f), String.valueOf(byVar.n()));
        uVar.c = "1004665";
        uVar.a(byVar);
        uVar.e = str;
        String strB = "";
        uVar.k = lVarA != null ? lVarA.am() : "";
        uVar.p = String.valueOf(byVar.n());
        uVar.q = byVar.G();
        uVar.r = String.valueOf(z ? 1 : 2);
        uVar.s = String.valueOf(j2);
        if (lVarA != null) {
            try {
                strB = lVarA.B();
            } catch (Throwable unused) {
            }
        }
        uVar.U = strB;
        if (aVar.c.g != null) {
            try {
                Object obj = aVar.c.g.get(ATAdConst.KEY.CP_PLACEMENT_ID);
                if (obj != null) {
                    uVar.V = obj.toString();
                }
            } catch (Throwable unused2) {
            }
            try {
                JSONObject jSONObjectA = ag.a(aVar.c.g);
                if (jSONObjectA != null) {
                    uVar.ab = jSONObjectA;
                }
            } catch (Throwable unused3) {
            }
        }
        a(uVar);
    }

    public static void a(cg cgVar) {
        if (cgVar == null) {
            return;
        }
        u uVar = new u(cgVar.m(), String.valueOf(cgVar.k()));
        uVar.c = "1004667";
        n nVarY = cgVar.y();
        uVar.a(nVarY);
        uVar.p = String.valueOf(cgVar.k());
        uVar.q = cgVar.l();
        uVar.r = cgVar.g();
        uVar.s = cgVar.h();
        uVar.t = cgVar.f();
        uVar.u = cgVar.e();
        uVar.v = cgVar.j();
        uVar.w = cgVar.i();
        uVar.x = String.valueOf(cgVar.o());
        uVar.y = String.valueOf(cgVar.p());
        uVar.z = String.valueOf(cgVar.r());
        uVar.A = String.valueOf(cgVar.t());
        uVar.B = String.valueOf(cgVar.u());
        if (cgVar.b() != null) {
            uVar.C = cgVar.b();
        }
        Double dC = cgVar.c();
        if (dC != null) {
            uVar.D = String.valueOf(dC);
        }
        uVar.ab = cgVar.n();
        if (cgVar.k() == 66 && cgVar.w().doubleValue() > 0.0d) {
            uVar.E = String.valueOf(cgVar.t() / cgVar.w().doubleValue());
        }
        uVar.F = cgVar.B();
        if (nVarY != null) {
            String strAz = nVarY.az();
            if (!TextUtils.isEmpty(strAz)) {
                uVar.G = strAz;
            }
        }
        MgComparedResult mgComparedResultC = cgVar.C();
        if (mgComparedResultC != null && com.anythink.core.c.d.c.b.a(cgVar.x())) {
            MgAdInfo mgAdInfo = mgComparedResultC.getMgAdInfo();
            uVar.H = mgAdInfo != null ? String.valueOf(mgAdInfo.getUSDEcpm()) : "0";
            uVar.I = String.valueOf(mgComparedResultC.getCpCostTime());
        }
        uVar.J = String.valueOf(cgVar.q());
        if (nVarY != null) {
            String strAg = nVarY.ag();
            if (!TextUtils.isEmpty(strAg)) {
                uVar.K = strAg;
            }
        }
        a(uVar);
    }

    public static void a(n nVar, int i2, String str, double d2, double d3, String str2, String str3, String str4, String str5) {
        u uVar = new u(nVar.aS(), String.valueOf(i2));
        uVar.c = "1004668";
        uVar.a(nVar);
        uVar.e = nVar.aQ();
        uVar.ac = str4;
        uVar.ad = str5;
        uVar.p = String.valueOf(i2);
        uVar.q = str;
        uVar.r = String.valueOf(d2);
        uVar.s = str2;
        uVar.t = str3;
        uVar.u = String.valueOf(d3);
        uVar.k = nVar.aP();
        uVar.h = String.valueOf(nVar.aa());
        uVar.o = String.valueOf(nVar.aO());
        uVar.U = nVar.aJ();
        uVar.V = nVar.aK();
        uVar.ab = nVar.aF();
        a(uVar);
    }

    public static void a(n nVar, String str, String str2) {
        u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
        uVar.c = "1004669";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = str;
        uVar.r = str2;
        a(uVar);
    }

    public static void a(x xVar, int i2, String str, Map<String, JSONArray> map, int i3, int i4, int i5, String str2, int i6, int i7, long j2, String str3, int i8, boolean z) {
        u uVar = new u(null, null);
        uVar.c = "1004675";
        uVar.a(xVar);
        uVar.p = str;
        uVar.q = String.valueOf(i2);
        uVar.s = String.valueOf(i3);
        uVar.t = String.valueOf(i4);
        uVar.u = String.valueOf(i5);
        uVar.v = str2;
        uVar.w = String.valueOf(i6);
        if (i7 >= 0) {
            uVar.x = String.valueOf(i7);
        }
        if (j2 > 0) {
            uVar.y = String.valueOf(j2);
        }
        if (!TextUtils.isEmpty(str3)) {
            uVar.z = str3;
        }
        if (i8 > 0) {
            uVar.A = String.valueOf(i8);
        }
        if (map != null && map.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, JSONArray> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                uVar.B = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        if (z) {
            uVar.C = "1";
        }
        a(uVar);
    }

    private static void a(final String str, final String str2, final String str3, final String str4, final String str5, final int i2, final boolean z, final String str6, final String str7) {
        a(new Runnable() { // from class: com.anythink.core.common.t.f.4
            @Override // java.lang.Runnable
            public final void run() {
                boolean zIsScreenOn;
                u uVar = new u(str4, str5);
                uVar.c = "1004680";
                uVar.d = str;
                uVar.e = str2;
                uVar.p = str3;
                uVar.q = String.valueOf(i2);
                uVar.r = z ? "1" : "0";
                try {
                    zIsScreenOn = ((PowerManager) s.b().g().getSystemService("power")).isScreenOn();
                } catch (Throwable unused) {
                    zIsScreenOn = true;
                }
                uVar.s = zIsScreenOn ? "1" : "0";
                uVar.t = p.a(s.b().g()) ? "1" : "0";
                uVar.u = str7;
                uVar.v = str6;
                f.a(uVar);
            }
        });
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, String str12, String str13) {
        u uVar = new u("", "");
        if (TextUtils.isEmpty(uVar.c)) {
            uVar.c = "1004685";
        }
        if (!TextUtils.isEmpty(str)) {
            uVar.p = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            uVar.q = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            uVar.r = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            uVar.s = str4;
        }
        if (!TextUtils.isEmpty(str5)) {
            uVar.t = str5;
        }
        if (!TextUtils.isEmpty(str6)) {
            uVar.u = str6;
        }
        if (!TextUtils.isEmpty(str7)) {
            uVar.v = str7;
        }
        if (!TextUtils.isEmpty(str8)) {
            uVar.w = str8;
        }
        if (!TextUtils.isEmpty(str9)) {
            uVar.x = str9;
        }
        if (!TextUtils.isEmpty(str10)) {
            uVar.y = str10;
        }
        if (!TextUtils.isEmpty(str11)) {
            uVar.z = str11;
        }
        if (i2 > 0) {
            uVar.B = String.valueOf(i2);
        }
        uVar.A = "0";
        if (!TextUtils.isEmpty(str12)) {
            uVar.C = str12;
        }
        if (!TextUtils.isEmpty(str13)) {
            uVar.D = str13;
        }
        a(uVar);
    }

    public static void a(String str, String str2, l lVar, String str3, com.anythink.core.common.h.c cVar, long j2, ATAdRequest aTAdRequest) {
        u uVar = new u("4", cVar != null ? new StringBuilder().append(cVar.i().Z()).toString() : null);
        uVar.c = "1004690";
        uVar.a(aTAdRequest);
        uVar.a(lVar);
        uVar.d = str2;
        uVar.e = str;
        if (lVar != null) {
            uVar.o = String.valueOf(lVar.ah());
            uVar.h = String.valueOf(lVar.ax());
            uVar.k = lVar != null ? lVar.am() : "";
        }
        if (cVar != null) {
            uVar.a(cVar.i());
        }
        uVar.p = str3;
        if (cVar != null) {
            uVar.q = cVar.l();
            uVar.r = uVar.T;
            uVar.s = cVar.i() != null ? cVar.i().N() : "";
        }
        uVar.t = "1";
        uVar.u = String.valueOf(j2);
        a(uVar);
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        u uVar = new u(null, null);
        uVar.c = "1004688";
        if (!TextUtils.isEmpty(str)) {
            uVar.e = str;
        }
        uVar.p = str2;
        uVar.q = str3;
        uVar.r = str4;
        uVar.s = str5;
        a(uVar);
    }

    public static void a(final String str, final n nVar, final String str2, final String str3, final String str4, final int i2, final int i3, final long j2) {
        if (s.b().g() == null) {
            return;
        }
        a(new Runnable() { // from class: com.anythink.core.common.t.f.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    u uVar = new u(String.valueOf(i3), "");
                    uVar.c = "1004691";
                    uVar.a(nVar);
                    com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
                    if (bVarB == null || bVarB.J() || !bVarB.h() || com.anythink.core.common.t.c.a.a(bVarB, uVar)) {
                        return;
                    }
                    uVar.d = str2;
                    uVar.e = str3;
                    uVar.a(nVar);
                    uVar.p = str;
                    uVar.q = str4;
                    long j3 = j2;
                    if (j3 >= 0) {
                        uVar.r = String.valueOf(j3);
                    }
                    int i4 = i2;
                    if (i4 > 0) {
                        uVar.s = String.valueOf(i4);
                    }
                    com.anythink.core.common.n.d dVarB = com.anythink.core.common.n.e.a().b();
                    if (dVarB != null) {
                        uVar.t = String.valueOf(dVarB.a());
                        uVar.u = String.valueOf(dVarB.e());
                        uVar.v = String.valueOf(dVarB.f());
                        uVar.w = String.valueOf(dVarB.b());
                        uVar.x = String.valueOf(dVarB.g());
                        uVar.y = String.valueOf(dVarB.h());
                        uVar.z = String.valueOf(dVarB.c());
                        uVar.A = String.valueOf(dVarB.d());
                    }
                    uVar.B = String.valueOf(com.anythink.core.common.n.e.a().e());
                    f.a(uVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void a(x xVar, w wVar) {
        if (wVar == null || xVar == null || !(wVar instanceof bl)) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004697";
        uVar.a(xVar);
        uVar.p = wVar.h();
        uVar.q = wVar.i();
        uVar.r = ((bl) wVar).N();
        a(uVar);
    }

    public static void a(String str, String str2, n nVar, String str3, String str4, l lVar, String str5, String str6, String str7) {
        a(str, str2, nVar, str3, str4, lVar, true, str5, str6, str7, 0);
    }

    public static void a(String str, String str2, n nVar, String str3, String str4, l lVar, boolean z, String str5, String str6, String str7, int i2) {
        u uVar = new u(str3, "");
        uVar.c = "1004693";
        uVar.a(nVar);
        uVar.d = str4;
        uVar.e = str;
        if (lVar != null) {
            uVar.h = String.valueOf(lVar.ax());
            uVar.o = String.valueOf(lVar.ah());
            uVar.k = lVar.am();
        }
        uVar.p = z ? "1" : "2";
        uVar.q = str5;
        uVar.r = str6;
        if (lVar != null) {
            uVar.s = lVar.z() != 1 ? "2" : "1";
        }
        uVar.t = str2;
        uVar.u = str7;
        uVar.v = String.valueOf(i2);
        a(uVar);
    }

    public static void a(String str, String str2, l lVar, n nVar, boolean z, boolean z2, boolean z3, String str3, String str4, String str5) {
        u uVar = new u(null, "");
        uVar.c = "1004694";
        uVar.a(nVar);
        uVar.a(lVar);
        uVar.d = str3;
        uVar.e = str;
        if (lVar != null) {
            uVar.h = String.valueOf(lVar.ax());
            uVar.o = String.valueOf(lVar.ah());
            uVar.k = lVar.am();
        }
        uVar.l = str5;
        uVar.p = z ? "1" : "0";
        uVar.q = z3 ? "1" : "0";
        uVar.r = z2 ? "1" : "0";
        uVar.s = str2;
        uVar.t = str4;
        a(uVar);
    }

    public static void a(n nVar, l lVar, String str, String str2, String str3, String str4, String str5) {
        u uVar = new u(null, str);
        uVar.c = "1004695";
        uVar.a(nVar);
        if (lVar != null) {
            uVar.k = lVar.am();
        }
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        uVar.s = str4;
        uVar.t = str5;
        a(uVar);
    }

    public static void a(n nVar, l lVar, String str, String str2, String str3, int i2) {
        u uVar = new u(null, null);
        uVar.c = "1004696";
        uVar.a(nVar);
        if (lVar != null) {
            uVar.k = lVar.am();
        }
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        uVar.s = String.valueOf(i2);
        a(uVar);
    }

    private static void a(x xVar, w wVar, int i2, boolean z) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(null, null);
        uVar.c = "1004698";
        uVar.a(xVar);
        uVar.p = wVar.h();
        uVar.q = wVar.i();
        uVar.r = wVar instanceof r ? ((r) wVar).N() : "";
        uVar.s = String.valueOf(xVar.b);
        uVar.t = String.valueOf(xVar.i);
        uVar.u = String.valueOf(i2);
        uVar.v = String.valueOf(xVar.l);
        if (i2 != 5) {
            uVar.w = z ? "1" : "2";
        }
        a(uVar);
    }

    private static void a(x xVar, w wVar, boolean z, int i2, int i3, long j2, long j3) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(null, null);
        uVar.c = "1004699";
        uVar.a(xVar);
        uVar.p = z ? "2" : "1";
        uVar.q = String.valueOf(i2);
        uVar.r = String.valueOf(j2);
        uVar.s = String.valueOf(j3);
        uVar.t = String.valueOf(xVar.b);
        uVar.u = String.valueOf(i3);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.v = String.valueOf(rVar.N());
            uVar.w = String.valueOf(rVar.h());
        }
        a(uVar);
    }

    public static void a(x xVar, int i2, String str, JSONArray jSONArray, String str2, int i3) {
        u uVar = new u(null, null);
        uVar.c = "1004700";
        uVar.a(xVar);
        uVar.p = str;
        uVar.q = String.valueOf(i2);
        uVar.r = jSONArray != null ? jSONArray.toString() : "";
        uVar.s = str2;
        uVar.t = String.valueOf(i3);
        a(uVar);
    }

    public static void a(String str, n nVar, String str2, Object obj, String str3) {
        u uVar = new u(null, null);
        uVar.c = "1004701";
        uVar.a(nVar);
        uVar.e = str;
        uVar.h = String.valueOf(nVar.aa());
        uVar.o = String.valueOf(nVar.aO());
        uVar.p = nVar.aS();
        uVar.q = String.valueOf(nVar.Z());
        uVar.r = nVar.N();
        uVar.s = String.valueOf(nVar.ad());
        uVar.t = str2;
        uVar.u = obj != null ? obj.toString() : "";
        if (!TextUtils.isEmpty(str3)) {
            uVar.v = str3;
        }
        a(uVar);
    }

    public static void a(n nVar, com.anythink.core.e.g gVar, String str, double d2, String str2, double d3, String str3) {
        u uVar = new u(null, null);
        uVar.c = "1004702";
        uVar.a(nVar);
        uVar.p = nVar.aS();
        uVar.q = gVar.a() == 1 ? "1" : "2";
        uVar.r = String.valueOf(gVar.b());
        uVar.s = String.valueOf(gVar.c());
        uVar.t = String.valueOf(gVar.d());
        uVar.u = String.valueOf(gVar.f());
        uVar.v = String.valueOf(gVar.e());
        uVar.w = str;
        uVar.x = String.valueOf(d2);
        uVar.y = str2;
        uVar.z = String.valueOf(d3);
        if (!TextUtils.isEmpty(str3)) {
            uVar.A = str3;
        }
        a(uVar);
    }

    public static void a(n nVar, String str, String str2, String str3, String str4, String str5) {
        u uVar = new u(null, null);
        uVar.c = "1004705";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = nVar.N();
        uVar.r = str4;
        uVar.s = str5;
        uVar.t = str;
        uVar.u = str2;
        uVar.v = str3;
        a(uVar);
    }

    private static void a(x xVar, w wVar, int i2, String str) {
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004706";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.j);
        uVar.q = xVar.e;
        uVar.r = String.valueOf(xVar.b);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.s = rVar.N();
            uVar.t = rVar.h();
        }
        uVar.u = String.valueOf(i2);
        uVar.v = str;
        a(uVar);
    }

    private static void a(x xVar, w wVar, int i2, long j2, long j3, long j4, long j5) {
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004707";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.j);
        uVar.q = xVar.e;
        uVar.r = String.valueOf(xVar.b);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.s = rVar.N();
            uVar.t = rVar.h();
        }
        uVar.u = String.valueOf(i2);
        uVar.v = String.valueOf(j2);
        uVar.w = String.format("%.2f", Double.valueOf((j3 / 1024.0d) / 1024.0d));
        uVar.x = String.valueOf(j4);
        uVar.y = String.format("%.2f", Double.valueOf((j5 / 1024.0d) / 1024.0d));
        a(uVar);
    }

    private static void b(x xVar, w wVar, int i2, long j2, long j3, long j4, long j5) {
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004708";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.j);
        uVar.q = xVar.e;
        uVar.r = String.valueOf(xVar.b);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.s = rVar.N();
            uVar.t = rVar.h();
        }
        uVar.u = String.valueOf(i2);
        uVar.v = String.valueOf(j2);
        uVar.w = String.format("%.2f", Double.valueOf((j3 / 1024.0d) / 1024.0d));
        uVar.x = String.valueOf(j4);
        uVar.y = String.format("%.2f", Double.valueOf((j5 / 1024.0d) / 1024.0d));
        if (xVar.t != null && xVar.t.N() > 0) {
            uVar.z = String.valueOf(xVar.t.N());
        }
        a(uVar);
    }

    private static void a(n nVar, String str, String str2, int i2) {
        u uVar = new u(null, null);
        uVar.c = "1004709";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = nVar.N();
        uVar.r = nVar.aS();
        uVar.s = str;
        uVar.t = str2;
        uVar.u = String.valueOf(i2);
        uVar.v = "1";
        a(uVar);
    }

    private static void a(n nVar, String str, String str2, boolean z) {
        u uVar = new u(null, null);
        uVar.c = "1004710";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = nVar.N();
        uVar.r = str;
        uVar.s = str2;
        uVar.t = z ? "1" : "2";
        a(uVar);
    }

    private static void a(String str, x xVar, String str2, String str3, String str4, String str5, String str6, String str7, long j2, int i2, int i3) {
        u uVar = new u(null, null);
        uVar.c = "1004713";
        uVar.d = str;
        uVar.e = str2;
        uVar.a(xVar);
        uVar.p = str3;
        uVar.q = str4;
        uVar.r = str5;
        uVar.s = str6;
        uVar.t = str7;
        uVar.u = String.valueOf(j2);
        uVar.v = String.valueOf(i2);
        uVar.w = String.valueOf(i3);
        a(uVar);
    }

    public static void a(String str, String str2, by byVar, Double d2, Double d3, com.anythink.core.c.c.b bVar) {
        u uVar = new u(null, null);
        uVar.c = "1004716";
        uVar.a(byVar);
        uVar.d = str;
        uVar.e = str2;
        uVar.p = String.valueOf(byVar.n());
        uVar.q = byVar.G();
        uVar.r = d2 != null ? String.valueOf(d2) : "";
        uVar.s = d3 != null ? String.valueOf(d3) : "";
        uVar.t = bVar != null ? bVar.a() : "";
        a(uVar);
    }

    private static void a(x xVar, String str, String str2, String str3, String str4, long j2, String str5, String str6, String str7, String str8, String str9, String str10) {
        u uVar = new u(null, null);
        uVar.c = "1004715";
        uVar.a(xVar);
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        uVar.s = str4;
        uVar.t = String.valueOf(j2);
        uVar.u = str5;
        uVar.v = str6;
        uVar.w = str7;
        uVar.x = str8;
        uVar.y = str9;
        uVar.z = str10;
        a(uVar);
    }

    private static void a(String str, int i2, int i3, int i4) {
        u uVar = new u(null, null);
        uVar.c = "1004717";
        uVar.p = str;
        uVar.q = String.valueOf(i2);
        uVar.r = String.valueOf(i3);
        uVar.s = String.valueOf(i4);
        a(uVar);
    }

    private static void b(w wVar, x xVar, int i2) {
        int iK = wVar.f() != null ? wVar.f().K() : 1;
        u uVar = new u(null, null);
        uVar.c = "1004719";
        uVar.a(xVar);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.p = rVar.N();
            uVar.q = rVar.h();
        }
        uVar.r = "1";
        uVar.s = "1";
        uVar.v = String.valueOf(xVar.b);
        if (wVar != null && wVar.f() != null) {
            uVar.w = wVar.f().u();
        }
        uVar.x = String.valueOf(i2);
        uVar.y = String.valueOf(iK);
        a(uVar);
    }

    public static void a(n nVar, String str, String str2, String str3) {
        u uVar = new u(null, str);
        uVar.c = "1004718";
        uVar.a(nVar);
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        a(uVar);
    }

    private static void a(w wVar, x xVar, int i2, int i3) {
        u uVar = new u(null, null);
        uVar.c = "1004719";
        uVar.a(xVar);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.p = rVar.N();
            uVar.q = rVar.h();
        }
        uVar.r = "1";
        uVar.s = "1";
        uVar.v = String.valueOf(xVar.b);
        if (wVar != null && wVar.f() != null) {
            uVar.w = wVar.f().u();
        }
        uVar.x = String.valueOf(i2);
        uVar.y = String.valueOf(i3);
        a(uVar);
    }

    private static void a(x xVar, int i2, w wVar, long j2, long j3) {
        u uVar = new u(String.valueOf(i2), null);
        uVar.c = "1004721";
        uVar.a(xVar);
        uVar.p = String.valueOf(j2);
        uVar.q = String.valueOf(j3);
        if (wVar != null) {
            if (!TextUtils.isEmpty(wVar.A())) {
                uVar.r = wVar.A();
            }
            uVar.s = wVar.q();
            uVar.t = wVar.h();
            if (wVar instanceof r) {
                uVar.u = ((r) wVar).N();
            }
        }
        uVar.v = String.valueOf(i2);
        a(uVar);
    }

    public static void a(String str, l lVar, int i2, int i3, int i4, ATAdRequest aTAdRequest) {
        u uVar = new u("4", null);
        uVar.c = "1004722";
        uVar.e = str;
        uVar.a(aTAdRequest);
        uVar.a(lVar);
        if (lVar != null) {
            uVar.k = lVar.am();
            uVar.h = String.valueOf(lVar.ax());
            uVar.o = String.valueOf(lVar.ah());
        }
        uVar.p = String.valueOf(i2);
        uVar.q = String.valueOf(i4);
        uVar.r = String.valueOf(i3);
        a(uVar);
    }

    public static void a(String str, String str2, String str3, double d2, String str4, String str5, String str6) {
        u uVar = new u(str3, null);
        uVar.c = "1004724";
        uVar.e = str;
        uVar.d = str2;
        uVar.p = String.valueOf(System.currentTimeMillis());
        uVar.q = str3;
        uVar.r = String.valueOf(d2);
        uVar.s = str4;
        uVar.t = str5;
        uVar.u = str6;
        a(uVar);
    }

    public static void a(String str, String str2, String str3, int i2, long j2, long j3, long j4, long j5, long j6) {
        u uVar = new u(null, "2");
        uVar.c = "1004725";
        uVar.p = str;
        uVar.q = str3;
        uVar.r = str2;
        uVar.s = String.valueOf(i2);
        uVar.t = String.valueOf(j4);
        uVar.u = String.valueOf(j5);
        uVar.v = String.valueOf(j2);
        uVar.w = String.valueOf(j3);
        uVar.x = String.valueOf(j6);
        a(uVar);
    }

    private static void a(x xVar, String str, String str2, String str3, String str4, int i2) {
        u uVar = new u(null, "66");
        uVar.c = "1004735";
        uVar.a(xVar);
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        uVar.s = str4;
        uVar.t = String.valueOf(i2);
        a(uVar);
    }

    public static void a(String str, String str2) {
        boolean z = !str.isEmpty();
        u uVar = new u(null, null);
        uVar.c = "1004729";
        uVar.p = Build.MANUFACTURER;
        uVar.q = z ? "1" : "2";
        if (z) {
            uVar.r = str;
        } else {
            uVar.s = str2;
        }
        a(uVar);
    }

    public static void a(final com.anythink.core.common.j.e eVar, final boolean z, final n nVar, final long j2, final boolean z2, final String str, final ATBaseAdAdapter aTBaseAdAdapter) {
        com.anythink.core.common.u.b.c.a().g(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.G, new Runnable() { // from class: com.anythink.core.common.t.f.6
            final /* synthetic */ int b = 1;

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                Map<String, Object> networkInfoMap;
                u uVar = new u(nVar.aS(), "2");
                uVar.c = "1004730";
                uVar.a(nVar);
                uVar.p = nVar.N();
                uVar.q = String.valueOf(nVar.ae());
                uVar.r = String.valueOf(nVar.Z());
                uVar.s = String.valueOf(this.b);
                uVar.t = String.valueOf(j2);
                uVar.u = z2 ? "1" : "2";
                uVar.v = str;
                ATBaseAdAdapter aTBaseAdAdapter2 = aTBaseAdAdapter;
                if (aTBaseAdAdapter2 == null || (networkInfoMap = aTBaseAdAdapter2.getNetworkInfoMap()) == null) {
                    string = "";
                } else {
                    try {
                        string = new JSONObject(networkInfoMap).toString();
                    } catch (Throwable unused) {
                        string = "";
                    }
                }
                uVar.w = string;
                uVar.x = z ? "1" : "2";
                com.anythink.core.common.j.e eVar2 = eVar;
                if (eVar2 instanceof com.anythink.core.common.p.e) {
                    com.anythink.core.common.p.e eVar3 = (com.anythink.core.common.p.e) eVar2;
                    uVar.y = String.valueOf(eVar3.a());
                    String strB = eVar3.b();
                    if (!TextUtils.isEmpty(strB)) {
                        uVar.z = strB;
                    }
                }
                be beVarAu = nVar.au();
                if (beVarAu != null) {
                    if (!TextUtils.isEmpty(beVarAu.b())) {
                        uVar.A = beVarAu.b();
                    }
                    if (!TextUtils.isEmpty(beVarAu.c())) {
                        uVar.B = beVarAu.c();
                    }
                }
                f.a(uVar);
            }
        }));
    }

    private static void a(String str, String str2, x xVar, String str3, String str4, int i2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, boolean z, boolean z2, String str18, String str19, String str20) {
        u uVar = new u(null, "66");
        uVar.c = "1004731";
        uVar.d = str;
        uVar.e = str2;
        uVar.a(xVar);
        uVar.p = str3;
        uVar.q = str4;
        uVar.r = str6;
        uVar.s = str7;
        uVar.t = str8;
        uVar.u = str9;
        uVar.v = str10;
        uVar.w = str11;
        uVar.x = str12;
        uVar.y = str5;
        uVar.z = String.valueOf(i2);
        uVar.A = str13;
        uVar.B = str14;
        uVar.C = str15;
        uVar.D = str16;
        uVar.E = str17;
        uVar.F = z ? "2" : "1";
        uVar.G = z2 ? "1" : "2";
        uVar.H = str18;
        uVar.I = str19;
        uVar.J = str20;
        a(uVar);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        u uVar = new u(null, null);
        uVar.c = "1004738";
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        uVar.s = str4;
        uVar.t = str5;
        uVar.u = str6;
        uVar.v = String.valueOf(SystemClock.elapsedRealtime() - j2);
        a(uVar);
    }

    private static void a(x xVar, w wVar, long j2, boolean z, long j3, int i2) {
        u uVar = new u(String.valueOf(xVar.b), "66");
        uVar.c = "1004733";
        uVar.a(xVar);
        if (xVar.t != null) {
            uVar.p = xVar.t.P() == 2 ? "1" : "2";
            uVar.u = String.valueOf(xVar.t.Q());
            uVar.v = String.valueOf(xVar.t.R());
            uVar.x = String.valueOf(xVar.t.S());
            uVar.y = String.valueOf(xVar.t.h());
        }
        uVar.q = String.valueOf(j2);
        uVar.r = String.valueOf(System.currentTimeMillis() - j2);
        if (wVar instanceof r) {
            uVar.s = ((r) wVar).N();
            uVar.t = wVar.h();
        }
        uVar.w = z ? "1" : "2";
        uVar.z = String.valueOf(j3);
        uVar.A = String.valueOf(i2);
        a(uVar);
    }

    private static void a(x xVar, w wVar, int i2, int i3, int i4, boolean z, boolean z2) {
        u uVar = new u(String.valueOf(xVar.b), "66");
        uVar.c = "1004736";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.b);
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
            uVar.r = wVar.h();
        }
        uVar.s = 1 == ((bl) wVar).O() ? "2" : "1";
        if (xVar.t != null) {
            uVar.t = xVar.t.v() == 1 ? "1" : "2";
        }
        uVar.u = i2 == 1 ? "2" : "1";
        uVar.v = i3 == 1 ? "2" : "1";
        uVar.w = String.valueOf(i4);
        uVar.x = z ? "1" : "2";
        uVar.y = z2 ? "1" : "2";
        a(uVar);
    }

    private static void a(x xVar, w wVar, String str) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), "66");
        uVar.c = "1004737";
        uVar.a(xVar);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.p = String.valueOf(rVar.N());
            uVar.q = String.valueOf(rVar.h());
        }
        uVar.r = wVar.H();
        uVar.s = wVar.I();
        uVar.t = wVar.J();
        uVar.u = str;
        uVar.v = String.valueOf(xVar.b);
        a(uVar);
    }

    public static void a(long j2, long j3, long j4) {
        u uVar = new u("", "");
        uVar.c = "1004742";
        uVar.p = String.valueOf(j2);
        uVar.q = String.valueOf(j3);
        uVar.r = String.valueOf(j4);
        a(uVar);
    }

    public static void a(n nVar, String str, boolean z) {
        if (nVar == null) {
            return;
        }
        u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
        uVar.c = "1004744";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = nVar.N();
        uVar.r = String.valueOf(nVar.aS());
        uVar.s = z ? "1" : "2";
        uVar.t = str;
        uVar.u = s.b().W() ? "1" : "2";
        uVar.v = com.anythink.core.common.d.b.c().a();
        a(uVar);
    }

    public static void b(n nVar, String str, String str2) {
        if (nVar == null) {
            return;
        }
        u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
        uVar.c = "1004745";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = nVar.N();
        uVar.r = String.valueOf(nVar.aS());
        uVar.s = str;
        if (!TextUtils.isEmpty(str2)) {
            uVar.t = str2;
        }
        a(uVar);
    }

    public static void c(n nVar, String str, String str2) {
        if (nVar == null) {
            return;
        }
        u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
        uVar.c = "1004750";
        uVar.a(nVar);
        uVar.d = nVar.aR();
        uVar.e = nVar.aQ();
        uVar.k = nVar.aP();
        uVar.h = String.valueOf(nVar.aa());
        uVar.o = String.valueOf(nVar.aO());
        uVar.p = String.valueOf(nVar.Z());
        uVar.q = nVar.N();
        uVar.r = String.valueOf(nVar.aS());
        uVar.s = str;
        if (!TextUtils.isEmpty(str2)) {
            uVar.t = str2;
        }
        a(uVar);
    }

    public static void a(int i2) {
        u uVar = new u("", "");
        uVar.c = "1004739";
        uVar.p = String.valueOf(i2);
        a(uVar);
    }

    public static void a(String str, n nVar, boolean z, String str2) {
        u uVar = new u(null, null);
        uVar.c = "1004740";
        uVar.a(nVar);
        uVar.p = str;
        uVar.r = z ? "1" : "2";
        if (nVar != null) {
            uVar.q = String.valueOf(nVar.Z());
            uVar.s = String.valueOf(nVar.ae());
            uVar.t = nVar.N();
        }
        uVar.u = str2;
        a(uVar);
    }

    public static void a(n nVar, String str) {
        if (nVar != null) {
            u uVar = new u(nVar.aS(), String.valueOf(nVar.Z()));
            uVar.c = "1004741";
            uVar.a(nVar);
            uVar.p = nVar.N();
            uVar.q = "2";
            uVar.r = String.valueOf(nVar.Z());
            uVar.s = nVar.aS();
            uVar.t = String.valueOf(nVar.ae());
            uVar.u = str;
            a(uVar);
        }
    }

    private static void b(w wVar, x xVar, int i2, int i3) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004747";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
        }
        uVar.r = String.valueOf(i2);
        if (i3 > 0) {
            uVar.s = String.valueOf(i3);
        }
        uVar.t = String.valueOf(wVar.u());
        uVar.u = wVar.q();
        uVar.v = wVar.r();
        a(uVar);
    }

    public static void a(w wVar, x xVar, int i2, boolean z, int i3, String str) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004748";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
        }
        if (TextUtils.isEmpty(str)) {
            uVar.r = wVar.q();
        } else {
            uVar.r = str;
        }
        uVar.s = wVar.r();
        uVar.t = String.valueOf(i2);
        if (i2 != 1 && z) {
            uVar.u = z ? "1" : "2";
        }
        if (i2 == 3 && i3 > 0) {
            uVar.v = String.valueOf(i3);
        }
        a(uVar);
    }

    public static void a(w wVar, x xVar, int i2) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004749";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
        }
        uVar.r = wVar.q();
        uVar.s = String.valueOf(i2);
        a(uVar);
    }

    public static void a(h hVar, n nVar) {
        if (hVar == null || nVar == null) {
            return;
        }
        u uVar = new u(nVar.aS(), null);
        uVar.c = "1004753";
        uVar.a(nVar);
        uVar.p = String.valueOf(hVar.i());
        uVar.q = String.valueOf(hVar.a());
        uVar.r = String.valueOf(hVar.b());
        uVar.s = String.valueOf(hVar.c());
        uVar.t = String.valueOf(hVar.d());
        uVar.u = String.valueOf(hVar.e());
        uVar.v = String.valueOf(hVar.f());
        uVar.w = String.valueOf(hVar.g());
        uVar.x = String.valueOf(hVar.h());
        uVar.y = String.valueOf(nVar.ar());
        a(uVar);
    }

    public static void b(n nVar) {
        com.anythink.core.common.h.d dVarG = nVar.g();
        int iV = nVar.V();
        if (dVarG == null || !v.a().a(nVar.aQ())) {
            return;
        }
        u uVar = new u(nVar.aS(), null);
        uVar.c = "1004754";
        uVar.a(nVar);
        uVar.d = nVar.aR();
        uVar.e = nVar.aQ();
        uVar.h = String.valueOf(nVar.aa());
        uVar.o = String.valueOf(nVar.aO());
        uVar.p = String.valueOf(iV);
        uVar.q = dVarG.a();
        uVar.r = dVarG.d();
        uVar.s = String.valueOf(dVarG.e());
        uVar.t = String.valueOf(dVarG.i());
        uVar.u = String.valueOf(dVarG.g());
        uVar.v = String.valueOf(dVarG.f());
        uVar.w = String.valueOf(dVarG.h());
        a(uVar);
    }

    private static void a(w wVar, x xVar, boolean z, boolean z2) {
        String string;
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004751";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
        }
        if (xVar.t != null) {
            uVar.r = String.valueOf(xVar.t.T());
            uVar.u = String.valueOf(xVar.t.F());
            if (xVar.t.F() == 2) {
                string = String.valueOf(xVar.t.I());
            } else {
                string = xVar.t.H() != null ? xVar.t.H().toString() : "";
            }
            uVar.v = string;
            uVar.w = String.valueOf(xVar.t.U());
        }
        uVar.s = z ? "1" : "2";
        uVar.t = z2 ? "1" : "2";
        a(uVar);
    }

    private static void a(w wVar, x xVar, String str, String str2, List<Boolean> list, int i2, boolean z) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004756";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
        }
        uVar.r = str;
        uVar.s = str2;
        uVar.t = String.valueOf(xVar.b);
        uVar.v = String.valueOf(i2);
        if (list != null && list.size() == 5) {
            Boolean bool = list.get(0);
            Boolean bool2 = list.get(1);
            Boolean bool3 = list.get(2);
            Boolean bool4 = list.get(3);
            Boolean bool5 = list.get(4);
            if (bool != null) {
                uVar.w = bool.booleanValue() ? "1" : "2";
            }
            if (bool2 != null) {
                uVar.x = bool2.booleanValue() ? "1" : "2";
            }
            if (bool3 != null) {
                uVar.y = bool3.booleanValue() ? "1" : "2";
            }
            if (bool4 != null) {
                uVar.z = bool4.booleanValue() ? "1" : "2";
            }
            if (bool5 != null) {
                uVar.A = bool5.booleanValue() ? "1" : "2";
            }
        }
        uVar.B = z ? "1" : "2";
        a(uVar);
    }

    private static void a(int i2, int i3, int i4, long j2) {
        u uVar = new u(null, null);
        uVar.c = "1004758";
        uVar.p = String.valueOf(i2);
        uVar.q = String.valueOf(i3);
        uVar.r = String.valueOf(i4);
        uVar.s = String.valueOf(j2);
        a(uVar);
    }

    public static void b(String str, String str2) {
        u uVar = new u(null, null);
        uVar.c = "1004755";
        uVar.p = str;
        if (!TextUtils.isEmpty(str2)) {
            uVar.q = str2;
        }
        a(uVar);
    }

    private static void b(x xVar, w wVar, String str, String str2, String str3, String str4) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), "66");
        uVar.c = "1004743";
        uVar.d = xVar.f;
        uVar.e = xVar.a;
        uVar.a(xVar);
        uVar.p = str;
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.q = String.valueOf(rVar.N());
            uVar.r = String.valueOf(rVar.h());
        }
        uVar.s = String.valueOf(xVar.b);
        uVar.t = str2;
        uVar.u = "1";
        uVar.v = str3;
        uVar.w = str4;
        a(uVar);
    }

    public static void a(n nVar, int i2) {
        u uVar = new u(null, null);
        uVar.c = "1004759";
        uVar.a(nVar);
        uVar.p = String.valueOf(i2);
        uVar.q = nVar.N();
        uVar.r = String.valueOf(nVar.Z());
        a(uVar);
    }

    public static void b(n nVar, int i2) {
        ATAdRequest aTAdRequestB;
        if (nVar == null || (aTAdRequestB = nVar.b()) == null || aTAdRequestB.getPreLoadInfo() == null || aTAdRequestB.getPreLoadInfo().getPreLoadCallbackRegister() == null || aTAdRequestB.getPreLoadInfo().getPreLoadCallbackRegister().getMgAdInfo() == null) {
            return;
        }
        MgPreLoadAdRequest preLoadInfo = aTAdRequestB.getPreLoadInfo();
        MgAdInfo mgAdInfo = preLoadInfo.getPreLoadCallbackRegister().getMgAdInfo();
        int cpEcpmReceiveTime = preLoadInfo.getCpEcpmReceiveTime();
        if (!MgAdInfo.isMgAdInfoValid(mgAdInfo) || cpEcpmReceiveTime > 0) {
            return;
        }
        preLoadInfo.setCpEcpmReceiveTime(i2);
        u uVar = new u(null, null);
        uVar.c = "1004760";
        uVar.a(nVar);
        uVar.p = String.valueOf(i2);
        MgComparedResult mgComparedResult = aTAdRequestB.getPreLoadInfo().getMgComparedResult();
        uVar.q = String.valueOf(mgComparedResult != null ? mgComparedResult.getCpCostTime() : 0L);
        double cpPrice = mgComparedResult != null ? mgComparedResult.getCpPrice() : 0.0d;
        if (cpPrice > 0.0d) {
            uVar.r = String.valueOf(cpPrice);
        }
        a(uVar);
    }

    private static void a(x xVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u uVarA = u.a(str);
        uVarA.a(xVar);
        a(uVarA);
    }

    private static void b(w wVar, x xVar, long j2, long j3) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004761";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
        }
        uVar.r = "1";
        uVar.s = String.valueOf(j2);
        uVar.t = wVar.K();
        uVar.u = wVar.f() != null ? new StringBuilder().append(wVar.f().Z()).toString() : "";
        uVar.v = wVar.f() != null ? new StringBuilder().append(wVar.f().X()).toString() : "";
        uVar.w = wVar.f() != null ? new StringBuilder().append(wVar.f().Y()).toString() : "";
        if (j3 > 0) {
            uVar.z = String.valueOf(j3);
        }
        a(uVar);
    }

    private static void a(w wVar, x xVar, int i2, long j2, String str, long j3, long j4, long j5, long j6, long j7) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004762";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
        }
        uVar.r = String.valueOf(i2);
        uVar.s = String.valueOf(j2);
        uVar.t = wVar.K();
        uVar.u = wVar.f() != null ? new StringBuilder().append(wVar.f().Z()).toString() : "";
        uVar.v = wVar.f() != null ? new StringBuilder().append(wVar.f().X()).toString() : "";
        uVar.w = wVar.f() != null ? new StringBuilder().append(wVar.f().Y()).toString() : "";
        uVar.x = str;
        uVar.y = String.valueOf(j3);
        uVar.z = String.valueOf(j4);
        uVar.A = String.valueOf(j5);
        uVar.B = String.valueOf(j6);
        uVar.C = String.valueOf(j7);
        a(uVar);
    }

    private static void a(int i2, String str, String str2) {
        u uVar = new u("", "");
        uVar.c = "1004765";
        uVar.p = String.valueOf(i2);
        uVar.q = str;
        uVar.r = str2;
        a(uVar);
    }

    public static void b(n nVar, String str) {
        u uVar = new u("", "");
        uVar.a(nVar);
        uVar.c = "1004767";
        uVar.p = str;
        a(uVar);
    }

    public static void a(com.anythink.core.common.l.c.a aVar) {
        if (aVar == null) {
            return;
        }
        u uVar = new u("", "");
        uVar.c = "1004766";
        uVar.p = aVar.a();
        uVar.q = String.valueOf(aVar.b());
        uVar.r = String.valueOf(aVar.c());
        uVar.s = String.valueOf(aVar.f());
        uVar.t = String.valueOf(aVar.g());
        uVar.u = String.valueOf(aVar.d());
        uVar.v = String.valueOf(aVar.e());
        uVar.w = aVar.i();
        uVar.x = String.valueOf(aVar.j());
        uVar.y = aVar.k();
        uVar.z = aVar.l();
        uVar.A = aVar.m();
        uVar.C = String.valueOf(aVar.r());
        uVar.D = String.valueOf(aVar.s());
        uVar.E = String.valueOf(aVar.t());
        uVar.F = String.valueOf(aVar.u());
        uVar.G = String.valueOf(aVar.v());
        Context contextG = s.b().g();
        if (contextG != null) {
            uVar.B = p.a(contextG) ? "1" : "0";
        }
        a(uVar);
    }

    private static void c(w wVar, x xVar, int i2) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004768";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.q = rVar.N();
            uVar.r = String.valueOf(rVar.M());
        }
        uVar.s = String.valueOf(i2);
        a(uVar);
    }

    public static void a(int i2, int i3, String str, long j2) {
        u uVar = new u(null, null);
        uVar.c = "1004769";
        try {
            uVar.p = Build.MANUFACTURER;
        } catch (Throwable unused) {
        }
        uVar.q = String.valueOf(i2);
        uVar.r = String.valueOf(i3);
        if (!TextUtils.isEmpty(str)) {
            uVar.s = str;
        }
        uVar.t = String.valueOf(j2);
        a(uVar);
    }

    public static void a(com.anythink.core.common.e.b bVar) {
        if (bVar != null) {
            u uVar = new u("", "");
            uVar.c = "1004773";
            uVar.p = String.valueOf(bVar.a());
            uVar.q = bVar.c();
            a(uVar);
        }
    }

    public static void a(String str, int i2, String str2, int i3, boolean z, boolean z2, boolean z3, String str3) {
        u uVar = new u("", "");
        uVar.c = "1004774";
        uVar.p = str;
        uVar.q = String.valueOf(i2);
        uVar.r = str2;
        uVar.s = String.valueOf(i3);
        uVar.t = z ? "1" : "2";
        uVar.u = z2 ? "1" : "2";
        uVar.v = z3 ? "1" : "2";
        uVar.w = str3;
        a(uVar);
    }

    public static void a(au auVar) {
        if (auVar == null) {
            return;
        }
        u uVar = new u("", "");
        uVar.c = "1004775";
        uVar.p = String.valueOf(auVar.d());
        uVar.q = auVar.c();
        List<String> listE = auVar.e();
        if (listE != null) {
            uVar.r = new JSONArray((Collection) listE).toString();
        }
        Set<String> setF = auVar.f();
        if (setF != null) {
            uVar.s = new JSONArray((Collection) setF).toString();
        }
        uVar.t = String.valueOf(auVar.g());
        a(uVar);
    }

    public static void a(n nVar, int i2, int i3, int i4, String str, String str2, int[] iArr, int[] iArr2) {
        String str3 = "";
        u uVar = new u("", "");
        uVar.a(nVar);
        uVar.c = "1004776";
        uVar.p = (i2 == 1 || i2 == 2 || i2 == 3) ? "2" : "1";
        uVar.q = s.b().af();
        uVar.r = String.valueOf(i3);
        uVar.s = String.valueOf(i4);
        uVar.t = String.valueOf(i2);
        uVar.u = str;
        uVar.v = str2;
        uVar.w = (iArr == null || iArr.length < 2) ? "" : iArr[0] + "-" + iArr[1];
        if (iArr2 != null && iArr2.length >= 2) {
            str3 = iArr2[0] + "-" + iArr2[1];
        }
        uVar.x = str3;
        a(uVar);
    }

    protected static void a(u uVar) {
        if (uVar == null || s.b().g() == null) {
            return;
        }
        if (TextUtils.isEmpty(uVar.f)) {
            uVar.f = s.b().r();
        }
        if (!TextUtils.isEmpty(uVar.e)) {
            uVar.g = s.b().g(uVar.e);
            c(uVar);
            if (ATAdxSetting.getInstance().isAdxNetworkMode(uVar.e)) {
                uVar.aa = 1;
            }
        }
        uVar.j = String.valueOf(System.currentTimeMillis());
        com.anythink.core.common.t.a.a.a().a(uVar);
    }

    public static void a(final String str) {
        a(new Runnable() { // from class: com.anythink.core.common.t.f.7
            @Override // java.lang.Runnable
            public final void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                u uVarA = u.a(str);
                if (TextUtils.isEmpty(uVarA.c)) {
                    return;
                }
                f.a(uVarA);
            }
        });
    }

    private static void b(u uVar) {
        if (uVar != null) {
            a(uVar);
        }
    }

    private static void c(u uVar) {
        l lVarB = com.anythink.core.e.n.a(s.b().g()).b(uVar.e);
        if (lVarB != null) {
            uVar.W = lVarB.aN();
        }
    }

    private static void a(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().g(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.H, runnable));
    }

    private static String b(AdError adError, int i2, String str, int i3) {
        com.anythink.core.common.v.a.b.c cVar;
        aj ajVarA;
        return (i3 != 0 || (cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(str, com.anythink.core.common.v.a.b.c.class)) == null || adError == null || (ajVarA = cVar.a()) == null || ajVarA.e() == null) ? "" : com.anythink.core.common.v.a.d.a.a(adError.getPlatformCode() + "," + adError.getPlatformMSG(), ajVarA.e().get(Integer.valueOf(i2)));
    }

    private static void a(x xVar, w wVar, String str, String str2, int i2, int i3) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004650";
        uVar.a(xVar);
        uVar.p = wVar.h();
        uVar.q = String.valueOf(wVar.a());
        uVar.r = str;
        uVar.s = str2;
        uVar.t = String.valueOf(i2);
        if (wVar instanceof r) {
            uVar.v = String.valueOf(((r) wVar).N());
        }
        uVar.w = String.valueOf(xVar.b);
        if (i3 > 0) {
            uVar.x = String.valueOf(i3);
        }
        uVar.y = "";
        a(uVar);
    }

    private static void a(x xVar, w wVar, String str, String str2) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), "66");
        uVar.c = "1004743";
        uVar.d = xVar.f;
        uVar.e = xVar.a;
        uVar.a(xVar);
        uVar.p = str;
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.q = String.valueOf(rVar.N());
            uVar.r = String.valueOf(rVar.h());
        }
        uVar.s = String.valueOf(xVar.b);
        uVar.t = str2;
        uVar.u = "1";
        uVar.v = "";
        uVar.w = "";
        a(uVar);
    }

    private static void a(w wVar, x xVar, long j2, long j3) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.b), String.valueOf(xVar.j));
        uVar.c = "1004761";
        uVar.a(xVar);
        uVar.p = wVar.h();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).N();
        }
        uVar.r = "1";
        uVar.s = String.valueOf(j2);
        uVar.t = wVar.K();
        uVar.u = wVar.f() != null ? new StringBuilder().append(wVar.f().Z()).toString() : "";
        uVar.v = wVar.f() != null ? new StringBuilder().append(wVar.f().X()).toString() : "";
        uVar.w = wVar.f() != null ? new StringBuilder().append(wVar.f().Y()).toString() : "";
        if (j3 > 0) {
            uVar.z = String.valueOf(j3);
        }
        a(uVar);
    }

    static /* synthetic */ String a(AdError adError, int i2, String str, int i3) {
        com.anythink.core.common.v.a.b.c cVar;
        aj ajVarA;
        return (i3 != 0 || (cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(str, com.anythink.core.common.v.a.b.c.class)) == null || adError == null || (ajVarA = cVar.a()) == null || ajVarA.e() == null) ? "" : com.anythink.core.common.v.a.d.a.a(adError.getPlatformCode() + "," + adError.getPlatformMSG(), ajVarA.e().get(Integer.valueOf(i2)));
    }
}
