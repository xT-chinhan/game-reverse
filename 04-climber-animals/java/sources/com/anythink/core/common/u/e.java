package com.anythink.core.common.u;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdMixBidInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.AdError;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bh;
import com.anythink.core.common.h.bi;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.cd;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.u;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.ai;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.anythink.core.d.l;
import com.anythink.core.mg.api.MgAdInfo;
import com.anythink.core.mg.api.MgComparedResult;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
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
    private static final String x = "e";
    private static String y = "";

    public static void a(n nVar, AdError adError) {
        a(nVar, adError, (bv) null);
    }

    public static void a(n nVar, AdError adError, bv bvVar) {
        try {
            u uVar = new u(nVar.aK(), null);
            uVar.c = "1004630";
            uVar.a(nVar);
            l lVarA = com.anythink.core.d.n.a(t.b().g()).a(nVar.aI());
            uVar.k = lVarA != null ? lVarA.an() : "";
            if (adError != null) {
                uVar.p = adError.printStackTrace();
                uVar.q = adError.getCode();
            }
            if (bvVar != null) {
                uVar.r = bvVar.z();
                uVar.s = String.valueOf(p.a(bvVar));
            }
            uVar.R = nVar.aB();
            uVar.S = nVar.aC();
            uVar.Y = nVar.ax();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    private static void a(n nVar, String str, int i2, String str2, String str3, int i3, int i4, AdError adError, int i5, double d2, long j2, int i6, int i7, String str4, String str5, JSONObject jSONObject, int i8, String str6) {
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
        l lVarA = com.anythink.core.d.n.a(t.b().g()).a(str);
        uVar.k = lVarA != null ? lVarA.an() : "";
        uVar.R = str4;
        uVar.S = str5;
        if (jSONObject != null) {
            uVar.Y = jSONObject;
        }
        a(uVar);
    }

    public static void a(n nVar, int i2, AdError adError) {
        try {
            a(nVar, nVar.aI(), nVar.Y(), nVar.M(), nVar.aK(), -1, i2, adError, nVar.J(), nVar.L(), 0L, nVar.ac(), nVar.t, nVar.aB(), nVar.aC(), nVar.ax(), nVar.am(), a(adError, nVar.Y(), nVar.aI(), i2));
        } catch (Throwable unused) {
        }
    }

    public static void a(n nVar, int i2, AdError adError, long j2) {
        try {
            a(nVar, nVar.aI(), nVar.Y(), nVar.M(), nVar.aK(), nVar.O(), i2, adError, nVar.J(), nVar.L(), j2, nVar.ac(), nVar.t, nVar.aB(), nVar.aC(), nVar.ax(), nVar.am(), a(adError, nVar.Y(), nVar.aI(), i2));
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, l lVar, int i2, String str3, Map<String, Object> map, ae aeVar) {
        try {
            u uVar = new u(lVar != null ? String.valueOf(lVar.aq()) : "", "");
            uVar.c = "1004633";
            uVar.a(lVar);
            uVar.a(aeVar);
            uVar.d = str;
            uVar.e = str2;
            uVar.h = String.valueOf(lVar != null ? lVar.ay() : 0);
            uVar.l = "0";
            uVar.o = String.valueOf(lVar != null ? Integer.valueOf(lVar.ai()) : "");
            uVar.p = String.valueOf(i2);
            uVar.q = str3;
            uVar.t = str;
            uVar.u = "0";
            uVar.k = lVar != null ? lVar.an() : "";
            uVar.R = lVar != null ? lVar.A() : "";
            if (map != null) {
                Object obj = map.get(ATAdConst.KEY.CP_PLACEMENT_ID);
                if (obj != null) {
                    uVar.S = obj.toString();
                }
                JSONObject jSONObjectA = ai.a(map);
                if (jSONObjectA != null) {
                    uVar.Y = jSONObjectA;
                }
            }
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(n nVar, boolean z) {
        if (t.b().g() == null) {
            return;
        }
        u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
        uVar.c = "1004634";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Y());
        uVar.q = nVar.M();
        uVar.r = String.valueOf(nVar.P());
        uVar.s = z ? "1" : "0";
        uVar.t = String.valueOf(nVar.C);
        if (nVar.Y() == 66) {
            int iAg = nVar.ag();
            if (iAg != 0) {
                uVar.u = String.valueOf(iAg);
            }
            int iAi = nVar.ai();
            if (iAi != 0) {
                uVar.w = String.valueOf(iAi);
            }
            int iAj = nVar.aj();
            if (iAj != 0) {
                uVar.x = String.valueOf(iAj);
            }
        }
        uVar.v = nVar.aK();
        uVar.y = String.valueOf(nVar.as());
        uVar.z = String.valueOf(nVar.ar());
        uVar.A = String.valueOf(nVar.at());
        l lVarA = com.anythink.core.d.n.a(t.b().g()).a(nVar.aI());
        uVar.k = lVarA != null ? lVarA.an() : "";
        uVar.P = nVar.aK();
        uVar.R = nVar.aB();
        uVar.S = nVar.aC();
        uVar.Y = nVar.ax();
        a(uVar);
        b.a().a(uVar, nVar);
    }

    public static void a(String str, String str2, boolean z, int i2, l lVar, com.anythink.core.common.h.c cVar, String str3, String str4, Map<String, Object> map, com.anythink.core.common.h.d dVar, ae aeVar) {
        a(str, str2, z, i2, lVar, cVar, str3, str4, map, dVar, 0L, aeVar);
    }

    public static void a(final String str, final String str2, final boolean z, final int i2, final l lVar, final com.anythink.core.common.h.c cVar, final String str3, final String str4, final Map<String, Object> map, final com.anythink.core.common.h.d dVar, final long j2, final ae aeVar) {
        try {
            a(new Runnable() { // from class: com.anythink.core.common.u.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    Object obj;
                    JSONObject jSONObjectA;
                    try {
                        com.anythink.core.common.h.c cVar2 = cVar;
                        n nVarI = cVar2 != null ? cVar2.i() : null;
                        l lVar2 = lVar;
                        u uVar = new u(lVar2 != null ? String.valueOf(lVar2.aq()) : "", nVarI != null ? String.valueOf(nVarI.Y()) : "");
                        uVar.c = "1004632";
                        uVar.d = str;
                        uVar.e = str2;
                        uVar.a(nVarI);
                        if (nVarI == null) {
                            uVar.a(aeVar);
                        }
                        if (TextUtils.isEmpty(uVar.h)) {
                            l lVar3 = lVar;
                            if (lVar3 != null) {
                                uVar.h = String.valueOf(lVar3.ay());
                            } else {
                                uVar.h = "0";
                            }
                        }
                        uVar.p = z ? "1" : "0";
                        uVar.q = String.valueOf(i2);
                        uVar.r = nVarI != null ? String.valueOf(nVarI.P()) : "-1";
                        uVar.s = nVarI != null ? nVarI.M() : "";
                        uVar.t = nVarI != null ? String.valueOf(nVarI.Y()) : "";
                        uVar.u = nVarI != null ? nVarI.x : "";
                        uVar.v = str3;
                        uVar.w = nVarI != null ? nVarI.aJ() : str;
                        if (nVarI != null && !TextUtils.equals(str, nVarI.aJ())) {
                            uVar.x = "1";
                        } else {
                            uVar.x = "0";
                        }
                        if (nVarI != null) {
                            uVar.y = nVarI.t == 3 ? "1" : "0";
                        } else {
                            uVar.y = "0";
                        }
                        uVar.z = str4;
                        com.anythink.core.common.h.c cVar3 = cVar;
                        if (cVar3 != null && cVar3.l() == "3") {
                            uVar.B = "1";
                        }
                        long j3 = j2;
                        if (j3 > 0) {
                            uVar.A = String.valueOf(j3);
                        }
                        l lVar4 = lVar;
                        uVar.k = lVar4 != null ? lVar4.an() : "";
                        l lVar5 = lVar;
                        uVar.P = lVar5 != null ? String.valueOf(lVar5.aq()) : "";
                        if (nVarI != null) {
                            uVar.R = nVarI.aB();
                        } else {
                            l lVar6 = lVar;
                            if (lVar6 != null) {
                                uVar.R = lVar6.A();
                            }
                        }
                        if (nVarI != null) {
                            uVar.S = nVarI.aC();
                        } else {
                            Map map2 = map;
                            if (map2 != null && (obj = map2.get(ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                                uVar.S = obj.toString();
                            }
                        }
                        com.anythink.core.common.h.d dVar2 = dVar;
                        if (dVar2 != null) {
                            uVar.U = dVar2.a();
                            uVar.V = dVar.b();
                            uVar.W = dVar.c();
                        }
                        if (nVarI != null) {
                            uVar.Y = nVarI.ax();
                        } else {
                            Map map3 = map;
                            if (map3 != null && (jSONObjectA = ai.a(map3)) != null) {
                                uVar.Y = jSONObjectA;
                            }
                        }
                        e.a(uVar);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public static void a(n nVar, AdError adError, Map<String, Object> map) {
        if (t.b().g() == null) {
            return;
        }
        u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
        uVar.c = "1004636";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Y());
        uVar.q = nVar.M();
        uVar.r = String.valueOf(nVar.P());
        if (adError != null) {
            uVar.s = adError.getCode();
            uVar.t = adError.getPlatformCode();
            uVar.u = adError.getPlatformMSG();
        }
        l lVarA = com.anythink.core.d.n.a(t.b().g()).a(nVar.aI());
        uVar.k = lVarA != null ? lVarA.an() : "";
        uVar.P = nVar.aK();
        if (map != null) {
            try {
                if (map.containsKey("offer_id")) {
                    uVar.v = map.get("offer_id").toString();
                }
                if (map.containsKey(ATAdConst.NETWORK_CUSTOM_KEY.RV_ANIM_TYPE) && nVar.aK().equals("1")) {
                    uVar.w = map.get(ATAdConst.NETWORK_CUSTOM_KEY.RV_ANIM_TYPE).toString();
                }
            } catch (Throwable unused) {
            }
        }
        uVar.R = nVar.aB();
        uVar.S = nVar.aC();
        uVar.Y = nVar.ax();
        a(uVar);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, ATAdRequest aTAdRequest) {
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
        uVar.v = String.valueOf(q.a(t.b().g()) ? 1 : 0);
        uVar.w = String.valueOf(com.anythink.core.d.d.a().aS());
        a(uVar);
    }

    public static void a(String str, String str2, long j2, long j3, long j4, ATAdRequest aTAdRequest) {
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

    public static void a(w wVar, x xVar, String str) {
        a(wVar, xVar, false, str, 0.0d, 0.0d, 0L, 0L, 0L, 0);
    }

    public static void a(w wVar, x xVar, double d2, double d3, long j2) {
        a(wVar, xVar, true, "", d2, d3, j2, 0L, 0L, 0);
    }

    public static void a(w wVar, x xVar, boolean z, String str, double d2, double d3, long j2, long j3, long j4, int i2) {
        u uVar = new u(null, null);
        uVar.c = "1004764";
        uVar.a(xVar);
        if (wVar != null) {
            uVar.p = String.valueOf(wVar.b());
            if (wVar instanceof r) {
                uVar.r = ((r) wVar).aC();
                uVar.s = wVar.v();
            }
            uVar.t = wVar.E();
        }
        if (xVar != null) {
            uVar.q = String.valueOf(xVar.j);
            if (xVar.o != null) {
                uVar.y = String.valueOf(xVar.o.aa());
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
        if (j3 > 0) {
            uVar.A = String.valueOf(j3);
        }
        if (j4 > 0) {
            uVar.B = String.valueOf(j4);
        }
        if (i2 > 0) {
            uVar.C = String.valueOf(i2);
        }
        a(uVar);
    }

    public static void a(n nVar) {
        try {
            u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
            uVar.c = "1004640";
            uVar.a(nVar);
            uVar.p = String.valueOf(nVar.Y());
            uVar.q = nVar.M();
            uVar.r = String.valueOf(nVar.O());
            uVar.s = String.valueOf(nVar.aa());
            uVar.t = String.valueOf(nVar.ab());
            uVar.R = nVar.aB();
            uVar.S = nVar.aC();
            uVar.Y = nVar.ax();
            uVar.P = nVar.aK();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    private static void c(n nVar, String str) {
        try {
            u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
            uVar.c = "1004639";
            uVar.a(nVar);
            uVar.p = String.valueOf(nVar.Y());
            uVar.q = nVar.M();
            uVar.r = String.valueOf(nVar.O());
            uVar.s = str;
            uVar.P = nVar.aK();
            uVar.R = nVar.aB();
            uVar.S = nVar.aC();
            uVar.Y = nVar.ax();
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

    public static void a(String str, String str2, String str3, int i2, String str4, long j2, long j3, String str5, String str6) {
        u uVar = new u(null, null);
        uVar.c = "1004642";
        uVar.d = str;
        uVar.Z = str5;
        uVar.aa = str6;
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

    public static void a(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, int i3, long j3, long j4, String str11, String str12) {
        u uVar = new u(null, str3);
        uVar.c = "1004711";
        uVar.d = str;
        uVar.Z = str11;
        uVar.aa = str12;
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

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9) {
        u uVar = new u(null, str3);
        uVar.c = "1004712";
        uVar.d = str;
        uVar.Z = str8;
        uVar.aa = str9;
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
            if (t.b().g() == null) {
                return;
            }
            u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
            uVar.c = "1004643";
            uVar.a(nVar);
            uVar.p = nVar.aK();
            uVar.q = String.valueOf(j2);
            uVar.r = String.valueOf(j3);
            uVar.s = String.valueOf(j4);
            uVar.t = String.valueOf(nVar.Y());
            uVar.u = nVar.M();
            uVar.v = String.valueOf(nVar.P());
            uVar.w = String.valueOf(nVar.C);
            uVar.x = z ? "1" : "0";
            l lVarA = com.anythink.core.d.n.a(t.b().g()).a(nVar.aI());
            uVar.k = lVarA != null ? lVarA.an() : "";
            uVar.P = nVar.aK();
            uVar.R = nVar.aB();
            uVar.S = nVar.aC();
            uVar.Y = nVar.ax();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3, n nVar, l lVar, String str4, String str5) {
        try {
            u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
            uVar.c = str;
            uVar.a(nVar);
            uVar.d = nVar.aJ();
            uVar.e = str2;
            uVar.k = lVar != null ? lVar.an() : "";
            uVar.p = String.valueOf(nVar.Y());
            uVar.q = nVar.M();
            uVar.r = nVar.z();
            uVar.s = nVar.o();
            uVar.t = nVar.F;
            uVar.u = str4;
            uVar.v = str5;
            uVar.w = str3;
            uVar.R = nVar.aB();
            uVar.S = nVar.aC();
            uVar.Y = nVar.ax();
            a(uVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(x xVar, w wVar, int i2) {
        try {
            u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
            uVar.c = "1004679";
            uVar.a(xVar);
            if (wVar instanceof r) {
                uVar.p = ((r) wVar).aC();
            }
            uVar.q = xVar.c;
            uVar.r = wVar.v();
            uVar.s = String.valueOf(wVar.b());
            uVar.t = wVar.k();
            uVar.u = wVar.l();
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
        uVar.h = String.valueOf(lVar.ay());
        uVar.o = String.valueOf(lVar.ai());
        uVar.k = lVar.an();
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

    public static void a(x xVar, w wVar, String str, String str2, String str3, String str4) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(null, null);
        uVar.c = "1004648";
        uVar.a(xVar);
        uVar.p = wVar.v();
        uVar.q = String.valueOf(wVar.b());
        uVar.r = str;
        uVar.s = str2;
        uVar.t = str3;
        uVar.u = str4;
        a(uVar);
    }

    public static void a(x xVar, w wVar, String str, String str2, int i2) {
        a(xVar, wVar, str, str2, i2, 0, "");
    }

    public static void a(x xVar, w wVar, String str, String str2, int i2, int i3, String str3) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004650";
        uVar.a(xVar);
        uVar.p = wVar.v();
        uVar.q = String.valueOf(wVar.b());
        uVar.r = str;
        uVar.s = str2;
        uVar.t = String.valueOf(i2);
        if (wVar instanceof r) {
            uVar.v = String.valueOf(((r) wVar).aC());
        }
        uVar.w = String.valueOf(xVar.j);
        if (i3 > 0) {
            uVar.x = String.valueOf(i3);
        }
        uVar.y = str3;
        a(uVar);
    }

    public static void b(x xVar, w wVar, String str, String str2, int i2) {
        if (xVar == null || wVar == null) {
            return;
        }
        boolean z = i2 == 0;
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004728";
        uVar.a(xVar);
        uVar.p = wVar.v();
        uVar.q = String.valueOf(xVar.o.bl());
        uVar.r = String.valueOf(z ? 1 : 2);
        uVar.s = str;
        uVar.t = str2;
        if (!z) {
            uVar.u = String.valueOf(i2);
        }
        a(uVar);
    }

    public static void a(w wVar, x xVar, String str, String str2) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004652";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.f);
        uVar.q = xVar.c;
        if (wVar instanceof ay) {
            uVar.r = "1";
        } else if (wVar instanceof r) {
            uVar.r = "2";
        } else if (wVar instanceof bi) {
            uVar.r = "3";
        }
        uVar.s = str;
        uVar.t = str2;
        uVar.u = wVar.v();
        uVar.v = wVar.w();
        uVar.w = wVar.I();
        uVar.x = wVar.x();
        uVar.y = wVar.y();
        uVar.z = wVar.z();
        uVar.A = wVar.B();
        uVar.B = wVar.E();
        try {
            if (wVar instanceof bj) {
                StringBuilder sb = new StringBuilder();
                String strAJ = ((bj) wVar).aJ();
                if (!TextUtils.isEmpty(strAJ)) {
                    JSONArray jSONArray = new JSONArray(strAJ);
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

    public static void a(aw awVar, double d2, String str, double d3, double d4, double d5, double d6, String str2, String str3, boolean z) {
        a(awVar, d2, str, d3, d4, d5, d6, str2, str3, z, 0.0d);
    }

    public static void a(aw awVar, double d2, String str, double d3, double d4, double d5, double d6, String str2, String str3, boolean z, double d7) {
        u uVar = new u(String.valueOf(awVar.n()), String.valueOf(awVar.k()));
        uVar.c = "1004659";
        uVar.a(awVar.z());
        uVar.k = awVar.m();
        uVar.p = String.valueOf(awVar.k());
        uVar.q = awVar.l();
        uVar.r = String.valueOf(d2);
        uVar.s = str;
        uVar.R = awVar.o();
        uVar.S = awVar.p();
        uVar.t = String.valueOf(d3);
        uVar.u = String.valueOf(d4);
        uVar.v = awVar.s();
        uVar.w = String.valueOf(awVar.t());
        uVar.x = String.valueOf(awVar.h());
        uVar.y = String.valueOf(d5);
        if (awVar.d() != null) {
            uVar.z = awVar.d();
        }
        Double dV = awVar.v();
        if (dV != null) {
            uVar.A = String.valueOf(dV);
        }
        if (awVar.k() == 66 && d6 > 0.0d) {
            uVar.B = String.valueOf(d4 / d6);
        }
        uVar.C = awVar.B();
        uVar.D = z ? "1" : null;
        uVar.E = str2;
        if (!TextUtils.isEmpty(str3)) {
            uVar.F = str3;
        }
        ATAdMixBidInfo.BidEntity bidEntityA = awVar.a();
        if (bidEntityA != null) {
            if (!TextUtils.isEmpty(bidEntityA.getAdUserName())) {
                uVar.G = bidEntityA.getAdUserName();
            }
            if (!TextUtils.isEmpty(bidEntityA.getAdTittle())) {
                uVar.H = bidEntityA.getAdTittle();
            }
            if (!TextUtils.isEmpty(bidEntityA.getAdPackageName())) {
                uVar.L = bidEntityA.getAdPackageName();
            }
        }
        uVar.I = String.valueOf(awVar.E());
        MgComparedResult mgComparedResultF = awVar.F();
        if (mgComparedResultF != null && com.anythink.core.b.d.c.b.a(awVar.w())) {
            uVar.J = mgComparedResultF.isMgWin() ? "1" : "2";
            uVar.K = String.valueOf(mgComparedResultF.getCpCostTime());
        }
        uVar.M = String.valueOf(awVar.G());
        uVar.N = String.valueOf(awVar.H());
        if (awVar.k() == 8 && d7 > 0.0d) {
            uVar.O = String.valueOf(com.anythink.core.b.d.a.a(8, String.valueOf(d7)));
        }
        uVar.Y = awVar.q();
        a(uVar);
    }

    public static void a(bv bvVar, com.anythink.core.common.h.a aVar, long j2, boolean z, boolean z2) {
        u uVar = new u(String.valueOf(aVar.f), String.valueOf(bvVar.g()));
        uVar.c = "1004660";
        uVar.a(bvVar);
        l lVarA = aVar.n != null ? aVar.n.a() : null;
        uVar.d = aVar.d;
        uVar.e = aVar.e;
        String strA = "";
        uVar.h = String.valueOf(lVarA != null ? Integer.valueOf(lVarA.ay()) : "");
        uVar.o = String.valueOf(lVarA != null ? Integer.valueOf(lVarA.ai()) : "");
        uVar.k = lVarA != null ? lVarA.an() : "";
        uVar.p = String.valueOf(bvVar.g());
        uVar.q = bvVar.z();
        uVar.r = z ? "1" : "2";
        uVar.s = String.valueOf(j2);
        uVar.t = z2 ? "1" : "2";
        if (lVarA != null) {
            try {
                strA = lVarA.A();
            } catch (Throwable unused) {
            }
        }
        uVar.R = strA;
        if (aVar.c.g != null) {
            try {
                Object obj = aVar.c.g.get(ATAdConst.KEY.CP_PLACEMENT_ID);
                if (obj != null) {
                    uVar.S = obj.toString();
                }
            } catch (Throwable unused2) {
            }
            try {
                JSONObject jSONObjectA = ai.a(aVar.c.g);
                if (jSONObjectA != null) {
                    uVar.Y = jSONObjectA;
                }
            } catch (Throwable unused3) {
            }
        }
        a(uVar);
    }

    public static void a(String str, bv bvVar, boolean z, long j2, com.anythink.core.common.h.a aVar) {
        l lVarA = aVar != null ? aVar.n.a() : null;
        u uVar = new u(String.valueOf(aVar.f), String.valueOf(bvVar.g()));
        uVar.c = "1004665";
        uVar.a(bvVar);
        uVar.e = str;
        String strA = "";
        uVar.k = lVarA != null ? lVarA.an() : "";
        uVar.p = String.valueOf(bvVar.g());
        uVar.q = bvVar.z();
        uVar.r = String.valueOf(z ? 1 : 2);
        uVar.s = String.valueOf(j2);
        if (lVarA != null) {
            try {
                strA = lVarA.A();
            } catch (Throwable unused) {
            }
        }
        uVar.R = strA;
        if (aVar.c.g != null) {
            try {
                Object obj = aVar.c.g.get(ATAdConst.KEY.CP_PLACEMENT_ID);
                if (obj != null) {
                    uVar.S = obj.toString();
                }
            } catch (Throwable unused2) {
            }
            try {
                JSONObject jSONObjectA = ai.a(aVar.c.g);
                if (jSONObjectA != null) {
                    uVar.Y = jSONObjectA;
                }
            } catch (Throwable unused3) {
            }
        }
        a(uVar);
    }

    public static void a(cd cdVar) {
        if (cdVar == null) {
            return;
        }
        u uVar = new u(cdVar.m(), String.valueOf(cdVar.k()));
        uVar.c = "1004667";
        uVar.a(cdVar.y());
        uVar.p = String.valueOf(cdVar.k());
        uVar.q = cdVar.l();
        uVar.r = cdVar.g();
        uVar.s = cdVar.h();
        uVar.t = cdVar.f();
        uVar.u = cdVar.e();
        uVar.v = cdVar.j();
        uVar.w = cdVar.i();
        uVar.x = String.valueOf(cdVar.o());
        uVar.y = String.valueOf(cdVar.p());
        uVar.z = String.valueOf(cdVar.r());
        uVar.A = String.valueOf(cdVar.t());
        uVar.B = String.valueOf(cdVar.u());
        if (cdVar.b() != null) {
            uVar.C = cdVar.b();
        }
        Double dC = cdVar.c();
        if (dC != null) {
            uVar.D = String.valueOf(dC);
        }
        uVar.Y = cdVar.n();
        if (cdVar.k() == 66 && cdVar.w().doubleValue() > 0.0d) {
            uVar.E = String.valueOf(cdVar.t() / cdVar.w().doubleValue());
        }
        uVar.F = cdVar.B();
        if (cdVar.y() != null) {
            String strAu = cdVar.y().au();
            if (!TextUtils.isEmpty(strAu)) {
                uVar.G = strAu;
            }
        }
        MgComparedResult mgComparedResultC = cdVar.C();
        if (mgComparedResultC != null && com.anythink.core.b.d.c.b.a(cdVar.x())) {
            MgAdInfo mgAdInfo = mgComparedResultC.getMgAdInfo();
            uVar.H = mgAdInfo != null ? String.valueOf(mgAdInfo.getUSDEcpm()) : "0";
            uVar.I = String.valueOf(mgComparedResultC.getCpCostTime());
        }
        uVar.J = String.valueOf(cdVar.q());
        a(uVar);
    }

    public static void a(n nVar, int i2, String str, double d2, double d3, String str2, String str3, String str4, String str5) {
        u uVar = new u(nVar.aK(), String.valueOf(i2));
        uVar.c = "1004668";
        uVar.a(nVar);
        uVar.e = nVar.aI();
        uVar.Z = str4;
        uVar.aa = str5;
        uVar.p = String.valueOf(i2);
        uVar.q = str;
        uVar.r = String.valueOf(d2);
        uVar.s = str2;
        uVar.t = str3;
        uVar.u = String.valueOf(d3);
        uVar.k = nVar.aH();
        uVar.h = String.valueOf(nVar.Z());
        uVar.o = String.valueOf(nVar.aG());
        uVar.R = nVar.aB();
        uVar.S = nVar.aC();
        uVar.Y = nVar.ax();
        a(uVar);
    }

    public static void a(n nVar, String str, String str2) {
        u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
        uVar.c = "1004669";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Y());
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
        a(new Runnable() { // from class: com.anythink.core.common.u.e.2
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
                    zIsScreenOn = ((PowerManager) t.b().g().getSystemService("power")).isScreenOn();
                } catch (Throwable unused) {
                    zIsScreenOn = true;
                }
                uVar.s = zIsScreenOn ? "1" : "0";
                uVar.t = q.a(t.b().g()) ? "1" : "0";
                uVar.u = str7;
                uVar.v = str6;
                e.a(uVar);
            }
        });
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a(str, str2, str3, str4, str5, str6, str7, "", "", "", "", 0);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2) {
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
        a(uVar);
    }

    public static void a(String str, String str2, l lVar, String str3, com.anythink.core.common.h.c cVar, long j2, ATAdRequest aTAdRequest) {
        u uVar = new u("4", cVar != null ? new StringBuilder().append(cVar.i().Y()).toString() : null);
        uVar.c = "1004690";
        uVar.a(aTAdRequest);
        uVar.a(lVar);
        uVar.d = str2;
        uVar.e = str;
        if (lVar != null) {
            uVar.o = String.valueOf(lVar.ai());
            uVar.h = String.valueOf(lVar.ay());
            uVar.k = lVar != null ? lVar.an() : "";
        }
        if (cVar != null) {
            uVar.a(cVar.i());
        }
        uVar.p = str3;
        if (cVar != null) {
            uVar.q = cVar.l();
            uVar.r = uVar.Q;
            uVar.s = cVar.i() != null ? cVar.i().M() : "";
        }
        uVar.t = "1";
        uVar.u = String.valueOf(j2);
        a(uVar);
    }

    public static void a(final String str, final x xVar, final String str2, final String str3, final String str4, final int i2, final int i3, final String str5, final String str6, final boolean z, final long j2) {
        if (t.b().g() == null) {
            return;
        }
        a(new Runnable() { // from class: com.anythink.core.common.u.e.3
            @Override // java.lang.Runnable
            public final void run() {
                boolean zIsScreenOn;
                String str7;
                u uVar = new u(str3, str4);
                uVar.c = "1004687";
                com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
                if (bVarB == null || !e.c(bVarB, uVar)) {
                    uVar.a(xVar);
                    uVar.p = str2;
                    uVar.q = String.valueOf(i2);
                    uVar.r = String.valueOf(i3);
                    boolean zA = true;
                    try {
                        zIsScreenOn = ((PowerManager) t.b().g().getSystemService("power")).isScreenOn();
                    } catch (Throwable unused) {
                        zIsScreenOn = true;
                    }
                    boolean zInKeyguardRestrictedInputMode = false;
                    try {
                        KeyguardManager keyguardManager = (KeyguardManager) t.b().g().getSystemService("keyguard");
                        if (keyguardManager != null) {
                            zInKeyguardRestrictedInputMode = keyguardManager.inKeyguardRestrictedInputMode();
                        }
                    } catch (Throwable unused2) {
                    }
                    if (!zInKeyguardRestrictedInputMode && zIsScreenOn) {
                        str7 = "0";
                    } else if (zInKeyguardRestrictedInputMode || zIsScreenOn) {
                        str7 = (zInKeyguardRestrictedInputMode && zIsScreenOn) ? "2" : "3";
                    } else {
                        str7 = "1";
                    }
                    uVar.s = str7;
                    try {
                        zA = q.a(t.b().g());
                    } catch (Throwable unused3) {
                    }
                    uVar.t = zA ? "1" : "0";
                    uVar.u = str6;
                    uVar.v = str5;
                    uVar.w = z ? "1" : "2";
                    if (!TextUtils.isEmpty(e.y)) {
                        uVar.x = e.y;
                    } else {
                        try {
                            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                            String unused4 = e.y = ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / BaseConstants.MB_VALUE) + "MB";
                            uVar.x = e.y;
                        } catch (Throwable unused5) {
                        }
                    }
                    uVar.y = str;
                    uVar.z = String.valueOf(j2);
                    e.a(uVar);
                }
            }
        });
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
        if (t.b().g() == null) {
            return;
        }
        a(new Runnable() { // from class: com.anythink.core.common.u.e.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    u uVar = new u(String.valueOf(i3), "");
                    uVar.c = "1004691";
                    uVar.a(nVar);
                    com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
                    if (bVarB == null || bVarB.R() || !bVarB.i() || e.c(bVarB, uVar)) {
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
                    com.anythink.core.common.o.d dVarB = com.anythink.core.common.o.e.a().b();
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
                    uVar.B = String.valueOf(com.anythink.core.common.o.e.a().e());
                    e.a(uVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void a(x xVar, w wVar) {
        if (wVar == null || xVar == null || !(wVar instanceof bj)) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004697";
        uVar.a(xVar);
        uVar.p = wVar.v();
        uVar.q = wVar.w();
        uVar.r = ((bj) wVar).aC();
        a(uVar);
    }

    public static void a(String str, String str2, n nVar, String str3, String str4, l lVar, boolean z, String str5, String str6, String str7) {
        u uVar = new u(str3, "");
        uVar.c = "1004693";
        uVar.a(nVar);
        uVar.d = str4;
        uVar.e = str;
        if (lVar != null) {
            uVar.h = String.valueOf(lVar.ay());
            uVar.o = String.valueOf(lVar.ai());
            uVar.k = lVar.an();
        }
        uVar.p = z ? "1" : "2";
        uVar.q = str5;
        uVar.r = str6;
        if (lVar != null) {
            uVar.s = lVar.y() != 1 ? "2" : "1";
        }
        uVar.t = str2;
        uVar.u = str7;
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
            uVar.h = String.valueOf(lVar.ay());
            uVar.o = String.valueOf(lVar.ai());
            uVar.k = lVar.an();
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
            uVar.k = lVar.an();
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
            uVar.k = lVar.an();
        }
        uVar.p = str;
        uVar.q = str2;
        uVar.r = str3;
        uVar.s = String.valueOf(i2);
        a(uVar);
    }

    public static void a(x xVar, w wVar, int i2, boolean z) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(null, null);
        uVar.c = "1004698";
        uVar.a(xVar);
        uVar.p = wVar.v();
        uVar.q = wVar.w();
        uVar.r = wVar instanceof r ? ((r) wVar).aC() : "";
        uVar.s = String.valueOf(xVar.j);
        uVar.t = String.valueOf(xVar.a);
        uVar.u = String.valueOf(i2);
        uVar.v = String.valueOf(xVar.l);
        if (i2 != 5) {
            uVar.w = z ? "1" : "2";
        }
        a(uVar);
    }

    public static void a(x xVar, w wVar, boolean z, int i2, int i3, long j2, long j3) {
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
        uVar.t = String.valueOf(xVar.j);
        uVar.u = String.valueOf(i3);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.v = String.valueOf(rVar.aC());
            uVar.w = String.valueOf(rVar.v());
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
        uVar.h = String.valueOf(nVar.Z());
        uVar.o = String.valueOf(nVar.aG());
        uVar.p = nVar.aK();
        uVar.q = String.valueOf(nVar.Y());
        uVar.r = nVar.M();
        uVar.s = String.valueOf(nVar.ac());
        uVar.t = str2;
        uVar.u = obj != null ? obj.toString() : "";
        if (!TextUtils.isEmpty(str3)) {
            uVar.v = str3;
        }
        a(uVar);
    }

    public static void a(n nVar, com.anythink.core.d.f fVar, String str, double d2, String str2, double d3, String str3) {
        u uVar = new u(null, null);
        uVar.c = "1004702";
        uVar.a(nVar);
        uVar.p = nVar.aK();
        uVar.q = fVar.a() == 1 ? "1" : "2";
        uVar.r = String.valueOf(fVar.b());
        uVar.s = String.valueOf(fVar.c());
        uVar.t = String.valueOf(fVar.d());
        uVar.u = String.valueOf(fVar.f());
        uVar.v = String.valueOf(fVar.e());
        uVar.w = str;
        uVar.x = String.valueOf(d2);
        uVar.y = str2;
        uVar.z = String.valueOf(d3);
        if (!TextUtils.isEmpty(str3)) {
            uVar.A = str3;
        }
        a(uVar);
    }

    public static void a(r rVar, x xVar, String str, bh bhVar, boolean z, int i2) {
        u uVar = new u(String.valueOf(xVar.j), "66");
        uVar.c = "1004704";
        uVar.a(xVar);
        uVar.p = rVar != null ? rVar.v() : "";
        uVar.q = "2";
        uVar.r = String.valueOf(xVar.j);
        if (!TextUtils.isEmpty(str)) {
            uVar.s = str;
        }
        uVar.t = String.valueOf(bhVar.b - bhVar.a);
        uVar.u = String.valueOf(bhVar.c - bhVar.a);
        if (rVar != null) {
            uVar.v = rVar.g() == 1 ? "1" : "0";
        } else {
            uVar.v = "0";
        }
        uVar.w = String.valueOf(bhVar.a());
        uVar.x = xVar.q ? "1" : "0";
        uVar.y = String.valueOf(bhVar.b - bhVar.c);
        uVar.z = z ? "1" : "0";
        if (bhVar.f > 0 && bhVar.g > 0) {
            uVar.A = String.valueOf(bhVar.b());
        }
        uVar.B = String.valueOf(i2);
        a(uVar);
    }

    public static void a(n nVar, String str, String str2, String str3, String str4, String str5) {
        u uVar = new u(null, null);
        uVar.c = "1004705";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Y());
        uVar.q = nVar.M();
        uVar.r = str4;
        uVar.s = str5;
        uVar.t = str;
        uVar.u = str2;
        uVar.v = str3;
        a(uVar);
    }

    public static void a(x xVar, w wVar, int i2, String str) {
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004706";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.f);
        uVar.q = xVar.c;
        uVar.r = String.valueOf(xVar.j);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.s = rVar.aC();
            uVar.t = rVar.v();
        }
        uVar.u = String.valueOf(i2);
        uVar.v = str;
        a(uVar);
    }

    public static void a(x xVar, w wVar, int i2, long j2, long j3, long j4, long j5) {
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004707";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.f);
        uVar.q = xVar.c;
        uVar.r = String.valueOf(xVar.j);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.s = rVar.aC();
            uVar.t = rVar.v();
        }
        uVar.u = String.valueOf(i2);
        uVar.v = String.valueOf(j2);
        uVar.w = String.format("%.2f", Double.valueOf((j3 / 1024.0d) / 1024.0d));
        uVar.x = String.valueOf(j4);
        uVar.y = String.format("%.2f", Double.valueOf((j5 / 1024.0d) / 1024.0d));
        a(uVar);
    }

    public static void b(x xVar, w wVar, int i2, long j2, long j3, long j4, long j5) {
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004708";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.f);
        uVar.q = xVar.c;
        uVar.r = String.valueOf(xVar.j);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.s = rVar.aC();
            uVar.t = rVar.v();
        }
        uVar.u = String.valueOf(i2);
        uVar.v = String.valueOf(j2);
        uVar.w = String.format("%.2f", Double.valueOf((j3 / 1024.0d) / 1024.0d));
        uVar.x = String.valueOf(j4);
        uVar.y = String.format("%.2f", Double.valueOf((j5 / 1024.0d) / 1024.0d));
        if (xVar.o != null && xVar.o.bi() > 0) {
            uVar.z = String.valueOf(xVar.o.bi());
        }
        a(uVar);
    }

    public static void a(n nVar, String str, String str2, int i2) {
        u uVar = new u(null, null);
        uVar.c = "1004709";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Y());
        uVar.q = nVar.M();
        uVar.r = nVar.aK();
        uVar.s = str;
        uVar.t = str2;
        uVar.u = String.valueOf(i2);
        uVar.v = "1";
        a(uVar);
    }

    public static void a(n nVar, String str, String str2, boolean z) {
        u uVar = new u(null, null);
        uVar.c = "1004710";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Y());
        uVar.q = nVar.M();
        uVar.r = str;
        uVar.s = str2;
        uVar.t = z ? "1" : "2";
        a(uVar);
    }

    public static void a(String str, x xVar, String str2, String str3, String str4, String str5, String str6, String str7, long j2, int i2, int i3) {
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

    public static void a(String str, String str2, bv bvVar, Double d2, Double d3, com.anythink.core.b.c.a aVar) {
        u uVar = new u(null, null);
        uVar.c = "1004716";
        uVar.a(bvVar);
        uVar.d = str;
        uVar.e = str2;
        uVar.p = String.valueOf(bvVar.g());
        uVar.q = bvVar.z();
        uVar.r = d2 != null ? String.valueOf(d2) : "";
        uVar.s = d3 != null ? String.valueOf(d3) : "";
        uVar.t = aVar != null ? aVar.a() : "";
        a(uVar);
    }

    public static void a(x xVar, String str, String str2, String str3, String str4, long j2, String str5, String str6, String str7, String str8, String str9, String str10) {
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

    public static void a(w wVar, x xVar, int i2) {
        a(wVar, xVar, i2, false, 0, "", 0, wVar.r() != null ? wVar.r().aO() : 1);
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

    public static void a(w wVar, x xVar, int i2, boolean z, int i3, String str, int i4, int i5) {
        u uVar = new u(null, null);
        uVar.c = "1004719";
        uVar.a(xVar);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.p = rVar.aC();
            uVar.q = rVar.v();
        }
        uVar.r = z ? "2" : "1";
        if (i3 > 0) {
            uVar.s = String.valueOf(i3);
            if (!TextUtils.isEmpty(str)) {
                uVar.t = str;
            }
            if (i4 > 0) {
                uVar.u = String.valueOf(i4);
            }
        } else {
            uVar.s = "1";
        }
        uVar.v = String.valueOf(xVar.j);
        if (wVar != null && wVar.r() != null) {
            uVar.w = wVar.r().O();
        }
        uVar.x = String.valueOf(i2);
        uVar.y = String.valueOf(i5);
        a(uVar);
    }

    public static void a(x xVar, int i2, w wVar, long j2, long j3) {
        u uVar = new u(String.valueOf(i2), null);
        uVar.c = "1004721";
        uVar.a(xVar);
        uVar.p = String.valueOf(j2);
        uVar.q = String.valueOf(j3);
        if (wVar != null) {
            if (!TextUtils.isEmpty(wVar.R())) {
                uVar.r = wVar.R();
            }
            uVar.s = wVar.G();
            uVar.t = wVar.v();
            if (wVar instanceof r) {
                uVar.u = ((r) wVar).aC();
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
            uVar.k = lVar.an();
            uVar.h = String.valueOf(lVar.ay());
            uVar.o = String.valueOf(lVar.ai());
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

    public static void a(x xVar, String str, String str2, String str3, String str4, int i2) {
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

    public static void a(final com.anythink.core.common.k.e eVar, final boolean z, final n nVar, final long j2, final boolean z2, final String str, final ATBaseAdAdapter aTBaseAdAdapter) {
        com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.core.common.u.e.5
            final /* synthetic */ int b = 1;

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                Map<String, Object> networkInfoMap;
                u uVar = new u(nVar.aK(), "2");
                uVar.c = "1004730";
                uVar.a(nVar);
                uVar.p = nVar.M();
                uVar.q = String.valueOf(nVar.ad());
                uVar.r = String.valueOf(nVar.Y());
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
                com.anythink.core.common.k.e eVar2 = eVar;
                if (eVar2 instanceof com.anythink.core.common.q.e) {
                    com.anythink.core.common.q.e eVar3 = (com.anythink.core.common.q.e) eVar2;
                    uVar.y = String.valueOf(eVar3.a());
                    String strB = eVar3.b();
                    if (!TextUtils.isEmpty(strB)) {
                        uVar.z = strB;
                    }
                }
                e.a(uVar);
            }
        }, 13);
    }

    public static void a(String str, String str2, x xVar, String str3, String str4, int i2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, boolean z, boolean z2, String str18, String str19, String str20) {
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

    public static void a(x xVar, w wVar, long j2, boolean z, long j3, int i2) {
        u uVar = new u(String.valueOf(xVar.j), "66");
        uVar.c = "1004733";
        uVar.a(xVar);
        if (xVar.o != null) {
            uVar.p = xVar.o.bo() == 2 ? "1" : "2";
            uVar.u = String.valueOf(xVar.o.bp());
            uVar.v = String.valueOf(xVar.o.bq());
            uVar.x = String.valueOf(xVar.o.br());
            uVar.y = String.valueOf(xVar.o.o());
        }
        uVar.q = String.valueOf(j2);
        uVar.r = String.valueOf(System.currentTimeMillis() - j2);
        if (wVar instanceof r) {
            uVar.s = ((r) wVar).aC();
            uVar.t = wVar.v();
        }
        uVar.w = z ? "1" : "2";
        uVar.z = String.valueOf(j3);
        uVar.A = String.valueOf(i2);
        a(uVar);
    }

    public static void a(x xVar, w wVar, int i2, int i3, int i4, boolean z, boolean z2) {
        u uVar = new u(String.valueOf(xVar.j), "66");
        uVar.c = "1004736";
        uVar.a(xVar);
        uVar.p = String.valueOf(xVar.j);
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).aC();
            uVar.r = wVar.v();
        }
        uVar.s = 1 == ((bj) wVar).aI() ? "2" : "1";
        if (xVar.o != null) {
            uVar.t = xVar.o.U() == 1 ? "1" : "2";
        }
        uVar.u = i2 == 1 ? "2" : "1";
        uVar.v = i3 == 1 ? "2" : "1";
        uVar.w = String.valueOf(i4);
        uVar.x = z ? "1" : "2";
        uVar.y = z2 ? "1" : "2";
        a(uVar);
    }

    public static void a(x xVar, w wVar, String str) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), "66");
        uVar.c = "1004737";
        uVar.a(xVar);
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.p = String.valueOf(rVar.aC());
            uVar.q = String.valueOf(rVar.v());
        }
        uVar.r = wVar.ak();
        uVar.s = wVar.al();
        uVar.t = wVar.am();
        uVar.u = str;
        uVar.v = String.valueOf(xVar.j);
        a(uVar);
    }

    public static void a(long j2, long j3) {
        u uVar = new u("", "");
        uVar.c = "1004742";
        uVar.p = String.valueOf(j2);
        uVar.q = "0";
        uVar.r = String.valueOf(j3);
        a(uVar);
    }

    public static void a(n nVar, String str, boolean z) {
        if (nVar == null) {
            return;
        }
        u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
        uVar.c = "1004744";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Y());
        uVar.q = nVar.M();
        uVar.r = String.valueOf(nVar.aK());
        uVar.s = z ? "1" : "2";
        uVar.t = str;
        uVar.u = t.b().W() ? "1" : "2";
        uVar.v = com.anythink.core.common.d.b.b().a();
        a(uVar);
    }

    public static void b(n nVar, String str, String str2) {
        if (nVar == null) {
            return;
        }
        u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
        uVar.c = "1004745";
        uVar.a(nVar);
        uVar.p = String.valueOf(nVar.Y());
        uVar.q = nVar.M();
        uVar.r = String.valueOf(nVar.aK());
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
        u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
        uVar.c = "1004750";
        uVar.a(nVar);
        uVar.d = nVar.aJ();
        uVar.e = nVar.aI();
        uVar.k = nVar.aH();
        uVar.h = String.valueOf(nVar.Z());
        uVar.o = String.valueOf(nVar.aG());
        uVar.p = String.valueOf(nVar.Y());
        uVar.q = nVar.M();
        uVar.r = String.valueOf(nVar.aK());
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
            uVar.q = String.valueOf(nVar.Y());
            uVar.s = String.valueOf(nVar.ad());
            uVar.t = nVar.M();
        }
        uVar.u = str2;
        a(uVar);
    }

    public static void a(n nVar, String str) {
        if (nVar != null) {
            u uVar = new u(nVar.aK(), String.valueOf(nVar.Y()));
            uVar.c = "1004741";
            uVar.a(nVar);
            uVar.p = nVar.M();
            uVar.q = "2";
            uVar.r = String.valueOf(nVar.Y());
            uVar.s = nVar.aK();
            uVar.t = String.valueOf(nVar.ad());
            uVar.u = str;
            a(uVar);
        }
    }

    public static void a(w wVar, x xVar, int i2, int i3) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004747";
        uVar.a(xVar);
        uVar.p = wVar.v();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).aC();
        }
        uVar.r = String.valueOf(i2);
        if (i3 > 0) {
            uVar.s = String.valueOf(i3);
        }
        uVar.t = String.valueOf(wVar.K());
        uVar.u = wVar.G();
        uVar.v = wVar.H();
        a(uVar);
    }

    public static void a(w wVar, x xVar, int i2, boolean z, int i3, String str) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004748";
        uVar.a(xVar);
        uVar.p = wVar.v();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).aC();
        }
        if (TextUtils.isEmpty(str)) {
            uVar.r = wVar.G();
        } else {
            uVar.r = str;
        }
        uVar.s = wVar.H();
        uVar.t = String.valueOf(i2);
        if (i2 != 1 && z) {
            uVar.u = z ? "1" : "2";
        }
        if (i2 == 3 && i3 > 0) {
            uVar.v = String.valueOf(i3);
        }
        a(uVar);
    }

    public static void b(w wVar, x xVar, int i2) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004749";
        uVar.a(xVar);
        uVar.p = wVar.v();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).aC();
        }
        uVar.r = wVar.G();
        uVar.s = String.valueOf(i2);
        a(uVar);
    }

    public static void a(com.anythink.core.common.h.h hVar, n nVar) {
        if (hVar == null || nVar == null) {
            return;
        }
        u uVar = new u(nVar.aK(), null);
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
        uVar.y = String.valueOf(nVar.an());
        Object[] objArr = new Object[1];
        Long.valueOf(hVar.h() - hVar.a());
        a(uVar);
    }

    public static void b(n nVar) {
        com.anythink.core.common.h.d dVarF = nVar.f();
        int iU = nVar.U();
        Object[] objArr = new Object[3];
        nVar.aI();
        Integer.valueOf(iU);
        if (dVarF == null || !com.anythink.core.common.w.a().a(nVar.aI())) {
            return;
        }
        u uVar = new u(nVar.aK(), null);
        uVar.c = "1004754";
        uVar.a(nVar);
        uVar.d = nVar.aJ();
        uVar.e = nVar.aI();
        uVar.h = String.valueOf(nVar.Z());
        uVar.o = String.valueOf(nVar.aG());
        uVar.p = String.valueOf(iU);
        uVar.q = dVarF.a();
        uVar.r = dVarF.d();
        uVar.s = String.valueOf(dVarF.e());
        uVar.t = String.valueOf(dVarF.i());
        uVar.u = String.valueOf(dVarF.g());
        uVar.v = String.valueOf(dVarF.f());
        uVar.w = String.valueOf(dVarF.h());
        a(uVar);
    }

    public static void a(w wVar, x xVar, boolean z, boolean z2) {
        String string;
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004751";
        uVar.a(xVar);
        uVar.p = wVar.v();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).aC();
        }
        if (xVar.o != null) {
            uVar.r = String.valueOf(xVar.o.bw());
            uVar.u = String.valueOf(xVar.o.aI());
            if (xVar.o.aI() == 2) {
                string = String.valueOf(xVar.o.aL());
            } else {
                string = xVar.o.aK() != null ? xVar.o.aK().toString() : "";
            }
            uVar.v = string;
            uVar.w = String.valueOf(xVar.o.bx());
        }
        uVar.s = z ? "1" : "2";
        uVar.t = z2 ? "1" : "2";
        a(uVar);
    }

    public static void a(w wVar, x xVar, String str, String str2, List<Boolean> list, int i2, boolean z) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004756";
        uVar.a(xVar);
        uVar.p = wVar.v();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).aC();
        }
        uVar.r = str;
        uVar.s = str2;
        uVar.t = String.valueOf(xVar.j);
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

    public static void a(int i2, int i3, int i4, long j2) {
        u uVar = new u(null, null);
        uVar.c = "1004758";
        uVar.p = String.valueOf(i2);
        uVar.q = String.valueOf(i3);
        uVar.r = String.valueOf(i4);
        uVar.s = String.valueOf(j2);
        a(uVar);
    }

    public static void a(String str) {
        u uVar = new u(null, null);
        uVar.c = "1004755";
        uVar.p = str;
        a(uVar);
    }

    private static void a(x xVar, w wVar, String str, String str2) {
        a(xVar, wVar, str, str2, true, "", "");
    }

    public static void a(x xVar, w wVar, String str, String str2, boolean z, String str3, String str4) {
        if (xVar == null || wVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), "66");
        uVar.c = "1004743";
        uVar.d = xVar.d;
        uVar.e = xVar.b;
        uVar.a(xVar);
        uVar.p = str;
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.q = String.valueOf(rVar.aC());
            uVar.r = String.valueOf(rVar.v());
        }
        uVar.s = String.valueOf(xVar.j);
        uVar.t = str2;
        uVar.u = z ? "1" : "2";
        uVar.v = str3;
        uVar.w = str4;
        a(uVar);
    }

    public static void a(n nVar, int i2) {
        u uVar = new u(null, null);
        uVar.c = "1004759";
        uVar.a(nVar);
        uVar.p = i2 == 7 ? "1" : "2";
        a(uVar);
    }

    public static void b(n nVar, int i2) {
        ATAdRequest aTAdRequestA;
        if (nVar == null || (aTAdRequestA = nVar.a()) == null || aTAdRequestA.getPreLoadInfo() == null || aTAdRequestA.getPreLoadInfo().getPreLoadCallbackRegister() == null || aTAdRequestA.getPreLoadInfo().getPreLoadCallbackRegister().getMgAdInfo() == null) {
            return;
        }
        MgPreLoadAdRequest preLoadInfo = aTAdRequestA.getPreLoadInfo();
        MgAdInfo mgAdInfo = preLoadInfo.getPreLoadCallbackRegister().getMgAdInfo();
        int cpEcpmReceiveTime = preLoadInfo.getCpEcpmReceiveTime();
        Object[] objArr = new Object[1];
        Integer.valueOf(cpEcpmReceiveTime);
        if (!MgAdInfo.isMgAdInfoValid(mgAdInfo) || cpEcpmReceiveTime > 0) {
            return;
        }
        preLoadInfo.setCpEcpmReceiveTime(i2);
        u uVar = new u(null, null);
        uVar.c = "1004760";
        uVar.a(nVar);
        uVar.p = String.valueOf(i2);
        MgComparedResult mgComparedResult = aTAdRequestA.getPreLoadInfo().getMgComparedResult();
        uVar.q = String.valueOf(mgComparedResult != null ? mgComparedResult.getCpCostTime() : 0L);
        double cpPrice = mgComparedResult != null ? mgComparedResult.getCpPrice() : 0.0d;
        if (cpPrice > 0.0d) {
            uVar.r = String.valueOf(cpPrice);
        }
        a(uVar);
    }

    public static void a(x xVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u uVarA = u.a(str);
        uVarA.a(xVar);
        a(uVarA);
    }

    public static void a(w wVar, x xVar, long j2, long j3) {
        a(wVar, xVar, true, j2, 0, "", j3);
    }

    public static void a(w wVar, x xVar, boolean z, long j2, int i2, String str, long j3) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004761";
        uVar.a(xVar);
        uVar.p = wVar.v();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).aC();
        }
        uVar.r = z ? "1" : "2";
        uVar.s = String.valueOf(j2);
        uVar.t = wVar.an();
        uVar.u = wVar.r() != null ? new StringBuilder().append(wVar.r().bD()).toString() : "";
        uVar.v = wVar.r() != null ? new StringBuilder().append(wVar.r().bB()).toString() : "";
        uVar.w = wVar.r() != null ? new StringBuilder().append(wVar.r().bC()).toString() : "";
        if (!z) {
            uVar.x = String.valueOf(i2);
            uVar.y = str;
        }
        if (j3 > 0) {
            uVar.z = String.valueOf(j3);
        }
        a(uVar);
    }

    public static void a(w wVar, x xVar, int i2, long j2, String str, long j3, long j4, long j5, long j6, long j7) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004762";
        uVar.a(xVar);
        uVar.p = wVar.v();
        if (wVar instanceof r) {
            uVar.q = ((r) wVar).aC();
        }
        uVar.r = String.valueOf(i2);
        uVar.s = String.valueOf(j2);
        uVar.t = wVar.an();
        uVar.u = wVar.r() != null ? new StringBuilder().append(wVar.r().bD()).toString() : "";
        uVar.v = wVar.r() != null ? new StringBuilder().append(wVar.r().bB()).toString() : "";
        uVar.w = wVar.r() != null ? new StringBuilder().append(wVar.r().bC()).toString() : "";
        uVar.x = str;
        uVar.y = String.valueOf(j3);
        uVar.z = String.valueOf(j4);
        uVar.A = String.valueOf(j5);
        uVar.B = String.valueOf(j6);
        uVar.C = String.valueOf(j7);
        a(uVar);
    }

    public static void a(int i2, String str, String str2) {
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

    public static void a(com.anythink.core.common.m.b.a aVar) {
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
        uVar.y = aVar.l();
        uVar.z = aVar.m();
        uVar.A = aVar.n();
        uVar.C = String.valueOf(aVar.q());
        Context contextG = t.b().g();
        if (contextG != null) {
            uVar.B = q.a(contextG) ? "1" : "0";
        }
        a(uVar);
    }

    public static void c(w wVar, x xVar, int i2) {
        if (wVar == null || xVar == null) {
            return;
        }
        u uVar = new u(String.valueOf(xVar.j), String.valueOf(xVar.f));
        uVar.c = "1004768";
        uVar.a(xVar);
        uVar.p = wVar.v();
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            uVar.q = rVar.aC();
            uVar.r = String.valueOf(rVar.ay());
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

    protected static void a(final u uVar) {
        if (uVar == null || t.b().g() == null) {
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.u.e.6
            @Override // java.lang.Runnable
            public final void run() {
                boolean zA;
                try {
                    if (TextUtils.isEmpty(uVar.f)) {
                        uVar.f = t.b().r();
                    }
                    if (!TextUtils.isEmpty(uVar.e)) {
                        uVar.g = t.b().g(uVar.e);
                        e.c(uVar);
                        if (ATAdxSetting.getInstance().isAdxNetworkMode(uVar.e)) {
                            uVar.X = 1;
                        }
                    }
                    uVar.j = String.valueOf(System.currentTimeMillis());
                    com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
                    if (bVarB != null) {
                        zA = e.a(uVar, bVarB);
                        if (e.c(bVarB, uVar)) {
                            return;
                        }
                        if (e.b(bVarB, uVar)) {
                            f.a(t.b().g()).a(uVar, zA);
                            return;
                        }
                    } else {
                        zA = false;
                    }
                    d.a().a(uVar, zA);
                } catch (Throwable unused) {
                }
            }
        }, 8);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    private static boolean b(u uVar, com.anythink.core.d.b bVar) {
        Map<String, String> mapF;
        boolean z = true;
        if ("1004742".equals(uVar.c)) {
            return true;
        }
        if (TextUtils.isEmpty(uVar.c) || TextUtils.isEmpty(uVar.Q) || TextUtils.isEmpty(uVar.P) || (mapF = bVar.f(uVar.c)) == null) {
            return false;
        }
        if (mapF.containsKey("0")) {
            String str = mapF.get("0");
            if (TextUtils.isEmpty(str) || !str.contains(uVar.P)) {
                z = false;
            }
        } else {
            if (!mapF.containsKey(uVar.Q)) {
                return false;
            }
            String str2 = mapF.get(uVar.Q);
            if (TextUtils.isEmpty(str2) || !str2.contains(uVar.P)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(com.anythink.core.d.b bVar, u uVar) {
        if (t.b().z()) {
            return true;
        }
        String strAz = bVar.az();
        if (!TextUtils.isEmpty(strAz)) {
            String str = uVar.Q;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(strAz);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (TextUtils.equals(str, jSONArray.optString(i2))) {
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        Map<String, String> mapAx = bVar.ax();
        if (mapAx == null) {
            return false;
        }
        if (TextUtils.isEmpty(uVar.P)) {
            return mapAx.containsKey(uVar.c);
        }
        if (mapAx.containsKey(uVar.c)) {
            String str2 = mapAx.get(uVar.c);
            if (!TextUtils.isEmpty(str2) && str2.contains(uVar.P)) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(com.anythink.core.d.b bVar, u uVar) {
        Map<String, String> mapAv = bVar.av();
        if (mapAv != null) {
            if (TextUtils.isEmpty(uVar.P)) {
                return mapAv.containsKey(uVar.c);
            }
            if (mapAv.containsKey(uVar.c)) {
                String str = mapAv.get(uVar.c);
                if (!TextUtils.isEmpty(str) && str.contains(uVar.P)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(final String str) {
        a(new Runnable() { // from class: com.anythink.core.common.u.e.7
            @Override // java.lang.Runnable
            public final void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                u uVarA = u.a(str);
                if (TextUtils.isEmpty(uVarA.c)) {
                    return;
                }
                e.a(uVarA);
            }
        });
    }

    public static void b(u uVar) {
        a(uVar);
    }

    public static void c(u uVar) {
        l lVarB = com.anythink.core.d.n.a(t.b().g()).b(uVar.e);
        if (lVarB != null) {
            uVar.T = lVarB.aQ();
        }
    }

    private static void a(Runnable runnable) {
        com.anythink.core.common.v.b.b.a().b(runnable, 13);
    }

    private static String a(AdError adError, int i2, String str, int i3) {
        com.anythink.core.common.w.a.b.c cVar;
        com.anythink.core.common.h.ai aiVarA;
        return (i3 != 0 || (cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(str, com.anythink.core.common.w.a.b.c.class)) == null || adError == null || (aiVarA = cVar.a()) == null || aiVarA.e() == null) ? "" : com.anythink.core.common.w.a.d.a.a(adError.getPlatformCode() + "," + adError.getPlatformMSG(), aiVarA.e().get(Integer.valueOf(i2)));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    static /* synthetic */ boolean a(u uVar, com.anythink.core.d.b bVar) {
        Map<String, String> mapF;
        boolean z = true;
        if ("1004742".equals(uVar.c)) {
            return true;
        }
        if (TextUtils.isEmpty(uVar.c) || TextUtils.isEmpty(uVar.Q) || TextUtils.isEmpty(uVar.P) || (mapF = bVar.f(uVar.c)) == null) {
            return false;
        }
        if (mapF.containsKey("0")) {
            String str = mapF.get("0");
            if (TextUtils.isEmpty(str) || !str.contains(uVar.P)) {
                z = false;
            }
        } else {
            if (!mapF.containsKey(uVar.Q)) {
                return false;
            }
            String str2 = mapF.get(uVar.Q);
            if (TextUtils.isEmpty(str2) || !str2.contains(uVar.P)) {
                z = false;
            }
        }
        return z;
    }

    static /* synthetic */ boolean b(com.anythink.core.d.b bVar, u uVar) {
        Map<String, String> mapAv = bVar.av();
        if (mapAv != null) {
            if (TextUtils.isEmpty(uVar.P)) {
                return mapAv.containsKey(uVar.c);
            }
            if (mapAv.containsKey(uVar.c)) {
                String str = mapAv.get(uVar.c);
                if (!TextUtils.isEmpty(str) && str.contains(uVar.P)) {
                    return true;
                }
            }
        }
        return false;
    }
}
