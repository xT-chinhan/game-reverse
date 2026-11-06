package com.mcto.sspsdk.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.eyv.AdBaseConstants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static volatile l a;

    public static l a() {
        if (a != null) {
            return a;
        }
        synchronized (l.class) {
            if (a == null) {
                a = new l();
            }
        }
        return a;
    }

    public static void b(int i, p pVar, HashMap map) {
        int iA = j.a(i);
        if (iA == 0) {
            za.d().a(3, pVar, map);
        } else if (iA == 1) {
            za.d().a(4, pVar, map);
        } else if (iA == 5) {
            za.d().a(7, pVar, map);
        } else if (iA == 6) {
            za.d().a(8, pVar, map);
        }
        p9.a.getClass();
        q9.a(i, pVar, null);
    }

    public static void a(String str, String str2, int i, HashMap map) {
        switch (j.a(i)) {
            case 30:
                za.a(54, str2, map);
                break;
            case 31:
                za.a(55, str2, map);
                break;
            case 32:
                zj.a().getClass();
                zj.a(10, str2, map);
                if (TextUtils.equals("0", String.valueOf(map.get(v5.KEY_DOWNLOAD_TYPE)))) {
                    za.a(56, str2, map);
                }
                break;
            case 33:
                zj.a().getClass();
                zj.a(11, str2, map);
                break;
            case 34:
                zj.a().getClass();
                zj.a(12, str2, map);
                break;
        }
        p9.a.getClass();
        eh.a.a(new m9(i, str, map));
    }

    public static void b(int i, p pVar) {
        pVar.o.set(i);
        int i2 = pVar.h;
        if (i > i2 / 4) {
            a(14, pVar, null);
        }
        if (i > i2 / 2) {
            a(15, pVar, null);
        }
        if (i > (i2 * 3) / 4) {
            a(16, pVar, null);
        }
        int i3 = pVar.i;
        if (i3 < 0) {
            if (pVar.p > 0) {
                i3 = pVar.l;
            } else {
                i3 = pVar.k;
            }
        }
        if (i3 < 0 || i < i3) {
            return;
        }
        a(19, pVar, null);
    }

    public static void a(int i, p pVar) {
        boolean z;
        boolean z2;
        int iIndexOf;
        int iIndexOf2;
        za zaVarD = za.d();
        mh mhVarC = pVar.c();
        zaVarD.getClass();
        za.a(mhVarC);
        String strSubstring = pVar.x;
        vh vhVar = pVar.c;
        ArrayList<p> arrayList = vhVar.c;
        if (arrayList == null) {
            return;
        }
        int i2 = pVar.T0;
        if (5 != i2 && 11 != i2) {
            z2 = false;
            z = false;
        } else if (pVar.f == vhVar.h && (11 == i2 || i == 1)) {
            z2 = true;
            z = true;
        } else {
            z = true;
            z2 = false;
        }
        if (strSubstring != null && -1 != (iIndexOf2 = strSubstring.indexOf(","))) {
            strSubstring = strSubstring.substring(0, iIndexOf2);
        }
        for (p pVar2 : arrayList) {
            String strSubstring2 = pVar2.x;
            if (strSubstring2 != null && -1 != (iIndexOf = strSubstring2.indexOf(","))) {
                strSubstring2 = strSubstring2.substring(0, iIndexOf);
            }
            if (strSubstring == null || strSubstring.equals(strSubstring2) || z2 || (z && strSubstring.compareTo(strSubstring2) > 0)) {
                if (!pVar2.D0 || pVar2.e(1)) {
                    zj.a().a(1, pVar2);
                }
            }
        }
    }

    public static void a(p pVar) {
        if (pVar.e(1)) {
            pVar.a(v5.KEY_AD_VIEW_RECT);
            pVar.a(v5.KEY_TOKEN_VIEW_COORDINATE);
            zj.a().a(1, pVar);
            zj.a().a(15, pVar);
            int i = pVar.F0;
            if (i == 1 || i == 2) {
                zg.a.a(new k(pVar));
            }
            a(0, pVar);
            if (j.b(4, pVar.T0)) {
                ug ugVarA = ug.a();
                synchronized (ugVarA) {
                    if (ugVarA.b <= SystemClock.elapsedRealtime()) {
                        JSONObject jSONObject = pVar.I0;
                        if (jSONObject != null && jSONObject.length() != 0) {
                            String strOptString = jSONObject.optString("d");
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(an.aG);
                            AtomicInteger atomicInteger = gj.a;
                            HashMap map = new HashMap();
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                                while (itKeys.hasNext()) {
                                    String strValueOf = String.valueOf(itKeys.next());
                                    map.put(strValueOf, jSONObjectOptJSONObject.optString(strValueOf));
                                }
                            }
                            map.put("Signature-Code", gj.d(strOptString + "2ca2d2b8178a525fe969fb931f8b04af"));
                            map.put("Signature-Version", "1");
                            ugVarA.b = SystemClock.elapsedRealtime() + ((long) h4.j);
                            c7 c7VarA = c7.a();
                            bg bgVar = new bg();
                            bgVar.h = map;
                            bgVar.f = lj.a(strOptString);
                            bgVar.b = "https://bidinfo-ssp.iqiyi.com/anti";
                            bgVar.g = new int[]{10000, AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS};
                            bgVar.c = TapHttp.METHOD_POST;
                            bgVar.e = new tg(ugVarA, strOptString, pVar);
                            cg cgVar = new cg(bgVar);
                            c7VarA.getClass();
                            zg.a.a(new a7(c7VarA, cgVar));
                        } else {
                            ugVarA.a = -1;
                        }
                    }
                }
            }
            p9.a.getClass();
            q9.a(12, pVar, null);
        }
    }

    public static void a(int i, p pVar, HashMap map) {
        int i2;
        z3 z3Var;
        long j;
        if (pVar == null) {
            return;
        }
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                v5 v5Var = (v5) entry.getKey();
                Object value = entry.getValue();
                if (v5Var != null) {
                    if (value != null) {
                        pVar.K.put(v5Var, value);
                    } else {
                        pVar.K.remove(v5Var);
                    }
                }
            }
        }
        switch (j.a(i)) {
            case 11:
                a(pVar);
                break;
            case 12:
                if (pVar.e(5)) {
                    zj.a().a(5, pVar);
                }
                if (pVar.d(70)) {
                    za.d().a(70, pVar);
                    p9.a.getClass();
                    q9.a(13, pVar, null);
                }
                break;
            case 13:
                if (pVar.e(6)) {
                    zj.a().a(6, pVar);
                }
                if (pVar.d(71)) {
                    za.d().a(71, pVar);
                    p9.a.getClass();
                    q9.a(14, pVar, null);
                }
                break;
            case 14:
                if (pVar.e(7)) {
                    zj.a().a(7, pVar);
                }
                if (pVar.d(72)) {
                    za.d().a(72, pVar);
                    p9.a.getClass();
                    q9.a(15, pVar, null);
                }
                break;
            case 15:
                if (pVar.e(8)) {
                    zj.a().a(8, pVar);
                }
                if (pVar.d(73)) {
                    za.d().a(73, pVar);
                    p9.a.getClass();
                    q9.a(16, pVar, null);
                }
                break;
            case 16:
                if (pVar.h <= pVar.o.get() + 1000) {
                    if (pVar.e(9)) {
                        zj.a().a(9, pVar);
                    }
                    if (pVar.d(74)) {
                        za.d().a(74, pVar);
                        p9.a.getClass();
                        q9.a(18, pVar, null);
                    }
                }
                if (pVar.d(46)) {
                    pVar.o.get();
                    za.d().b(46, pVar, null);
                    p9.a.getClass();
                    q9.a(17, pVar, null);
                }
                za zaVarD = za.d();
                zaVarD.c();
                zaVarD.a();
                zaVarD.b();
                break;
            case 17:
                if (pVar.e(9)) {
                    zj.a().a(9, pVar);
                }
                if (pVar.d(74)) {
                    za.d().a(74, pVar);
                    p9.a.getClass();
                    q9.a(18, pVar, null);
                }
                break;
            case 18:
                if (pVar.e(3)) {
                    pVar.K.put(v5.KEY_TRUEVIEW_TYPE, 1);
                    zj.a().a(3, pVar);
                    p9.a.getClass();
                    q9.a(19, pVar, null);
                }
                break;
            case 20:
                Object obj = pVar.K.get(v5.KEY_CLICK_AREA);
                if (obj == null || !(obj instanceof z3)) {
                    z3Var = null;
                } else {
                    z3Var = (z3) obj;
                }
                if (z3Var != null && z3Var.b != 0 && (!j.b(1, pVar.S0) || pVar.n())) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    synchronized (pVar) {
                        j = pVar.u;
                        break;
                    }
                    if (jCurrentTimeMillis - j > 500) {
                        pVar.a(jCurrentTimeMillis);
                        pVar.p++;
                        if ((z3Var.b & 1) != 0) {
                            zj.a().a(2, pVar);
                        } else if (z3.CLOSE.equals(z3Var) || z3.NEGATIVE.equals(z3Var)) {
                            if (!j.b(3, pVar.T0) && !j.b(7, pVar.T0)) {
                                zj.a().a(4, pVar);
                            } else {
                                za.d().b(42, pVar, null);
                            }
                        }
                        if ((z3Var.b & 4) != 0) {
                            za.d().b(40, pVar, null);
                        }
                        p9.a.getClass();
                        q9.a(21, pVar, null);
                        if (("roll".equals(pVar.y) || 6 == pVar.d) && (z3Var.b & 2) != 0) {
                            if (pVar.e(3)) {
                                AtomicInteger atomicInteger = gj.a;
                                pVar.K.put(v5.KEY_TRUEVIEW_TYPE, Integer.valueOf(z3Var.a.equals("half_webview") ? 10 : 2));
                                zj.a().a(3, pVar);
                                q9.a(19, pVar, null);
                            }
                        } else if (!"roll".equals(pVar.y)) {
                            int i3 = pVar.d;
                        }
                    }
                }
                break;
            case 21:
                if (pVar.e(4)) {
                    zj.a().a(4, pVar);
                    p9.a.getClass();
                    q9.a(22, pVar, null);
                }
                za zaVarD2 = za.d();
                zaVarD2.c();
                zaVarD2.a();
                zaVarD2.b();
                break;
            case 24:
                if (pVar.e(13)) {
                    zj.a().a(13, pVar);
                    p9.a.getClass();
                    q9.a(25, pVar, null);
                }
                break;
            case 25:
                if (pVar.e(14)) {
                    zj.a().a(14, pVar);
                    za.d().a(76, pVar);
                    p9.a.getClass();
                    q9.a(26, pVar, null);
                }
                break;
        }
        if (j.b(3, pVar.S0) && !TextUtils.isEmpty(pVar.d())) {
            int i4 = pVar.e0;
            if (TextUtils.isEmpty(q.a)) {
                q.a = nh.a(jd.a).a("lcsw");
            }
            if ("1".equals(q.a)) {
                if (i4 == 0 && i == 12) {
                    i2 = 0;
                } else if (i4 != 5 || i != 21) {
                    return;
                } else {
                    i2 = 5;
                }
                String strOptString = pVar.i().optString("apkName");
                if (TextUtils.isEmpty(strOptString) || e1.c(strOptString)) {
                    return;
                }
                Context context = jd.a;
                v0.a().getClass();
                if (v0.b(strOptString) == null) {
                    v0 v0VarA = v0.a();
                    t0 t0Var = new t0();
                    t0Var.i = strOptString;
                    t0Var.d = pVar.E;
                    t0 t0VarA = t0Var.a(pVar.d());
                    t0VarA.o = i2;
                    u0 u0Var = new u0(t0VarA);
                    v0VarA.getClass();
                    v0.a(u0Var);
                    return;
                }
                v0 v0VarA2 = v0.a();
                u0 u0Var2 = new u0(new t0().a(pVar.d()));
                v0VarA2.getClass();
                v0.b(u0Var2);
            }
        }
    }
}
