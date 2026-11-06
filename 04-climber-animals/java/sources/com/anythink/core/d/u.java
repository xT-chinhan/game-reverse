package com.anythink.core.d;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATCustomAdapterConfig;
import com.anythink.core.common.h.aa;
import com.anythink.core.common.h.ap;
import com.anythink.core.common.h.bv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    private static final String[] a = {"unit_id", "unitid", "slot_id", "placement_id", "zone_id", "ad_place_id", "position_id", "pos_id", "placement_name", "spot_id", "ad_tag", "ad_id", "plid", "space_id", "location", "tagid", "adslot_id", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.INSTANCE_ID, "pid"};

    private static String a(String str, bv bvVar) {
        try {
            int iQ = bvVar.q();
            if (iQ == 3 || iQ == 7 || bvVar.g() == 35) {
                return str;
            }
            Map<String, Object> mapL = bvVar.l();
            for (String str2 : a) {
                String strA = com.anythink.core.common.v.q.a(mapL, str2, "");
                if (!TextUtils.isEmpty(strA)) {
                    return strA;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static void a(l lVar, Map<String, bv> map, List<bv> list) {
        a(lVar, map, list, lVar.az(), 0, 1);
        a(lVar, map, list, lVar.aA(), 0, 6);
        a(lVar, map, list, lVar.aB(), 1, 3);
        a(lVar, map, list, lVar.Y(), 3, 4);
        a(lVar, map, list, lVar.aC(), 2, 2);
        a(lVar, map, list, lVar.W(), 5, 7);
        a(lVar, map, list, lVar.O(), 6, 11);
        a(lVar, map, list, lVar.aI(), 7, 8);
        a(lVar, map, list, lVar.aJ(), 3, 5);
        a(lVar, map, list, lVar.J(), 8, 10);
        a(lVar, map, list, lVar.bt(), 2, 12);
        a(lVar, map, list, lVar.bu(), 1, 13);
    }

    private static void a(l lVar, Map<String, bv> map, List<bv> list, JSONArray jSONArray, int i, int i2) {
        try {
            com.anythink.core.common.h.q qVarBf = lVar.bf();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null) {
                    bv bvVarA = a(i2, i, jSONObjectOptJSONObject, lVar);
                    map.put(bvVarA.z(), bvVarA);
                    if (bvVarA.g() == 35) {
                        list.add(bvVarA);
                    }
                    a(lVar, bvVarA);
                    if (qVarBf != null && bvVarA.g() == 2) {
                        if (i == 0) {
                            qVarBf.a = true;
                        }
                        if (i == 1) {
                            qVarBf.b = true;
                        }
                    }
                    if (lVar.bn() == null && bvVarA.o() && bvVarA.aS() == 1) {
                        lVar.a(Boolean.TRUE);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(l lVar, bv bvVar) {
        if (bvVar.ar() > 0.0d || lVar == null) {
            return;
        }
        double dAM = lVar.aM();
        if (dAM > 0.0d) {
            bvVar.d(dAM);
        }
    }

    public static List<bv> a(l lVar) {
        List<bv> listA = a(lVar, lVar.aB(), 1, 3);
        List<bv> listA2 = a(lVar, lVar.Y(), 3, 4);
        List<bv> listA3 = a(lVar, lVar.aC(), 2, 2);
        List<bv> listA4 = a(lVar, lVar.W(), 5, 7);
        List<bv> listA5 = a(lVar, lVar.O(), 6, 11);
        List<bv> listA6 = a(lVar, lVar.aI(), 7, 8);
        List<bv> listA7 = a(lVar, lVar.aJ(), 3, 5);
        listA.addAll(listA2);
        listA.addAll(listA3);
        listA.addAll(listA4);
        listA.addAll(listA5);
        listA.addAll(listA6);
        listA.addAll(listA7);
        return listA;
    }

    public static List<bv> b(l lVar) {
        List<bv> listA = a(lVar, lVar.az(), 0, 1);
        listA.addAll(a(lVar, lVar.aA(), 4, 6));
        Collections.sort(listA);
        return listA;
    }

    public static List<bv> c(l lVar) {
        return a(lVar, lVar.J(), 8, 10);
    }

    public static List<bv> a(l lVar, JSONArray jSONArray) {
        return a(lVar, jSONArray, 3, 4);
    }

    public static List<bv> d(l lVar) {
        return a(lVar, lVar.bt(), 2, 12);
    }

    public static List<bv> e(l lVar) {
        return a(lVar, lVar.bu(), 1, 13);
    }

    private static List<bv> a(l lVar, JSONArray jSONArray, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    bv bvVarA = a(i2, i, jSONObject, lVar);
                    a(lVar, bvVarA);
                    arrayList.add(bvVarA);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private static bv a(int i, int i2, JSONObject jSONObject, l lVar) {
        long j;
        aa aaVarA;
        ATCustomAdapterConfig aTCustomAdapterConfigB;
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        int i3 = (i2 == 0 || i2 == 4 || i2 == 8) ? 0 : 1;
        bv bvVar = new bv(i);
        bvVar.e(i2);
        bvVar.d(i3);
        if (jSONObject.isNull(com.anythink.core.common.k.D)) {
            bvVar.c("");
        } else {
            bvVar.c(jSONObject.optString(com.anythink.core.common.k.D));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.A)) {
            bvVar.b(-1);
        } else {
            bvVar.b(jSONObject.optInt(com.anythink.core.common.k.A));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.B)) {
            bvVar.c(-1);
        } else {
            bvVar.c(jSONObject.optInt(com.anythink.core.common.k.B));
        }
        if (jSONObject.isNull("nw_firm_id")) {
            bvVar.a(-1);
        } else {
            bvVar.a(jSONObject.optInt("nw_firm_id"));
        }
        if (jSONObject.isNull("content")) {
            bvVar.b("");
            bvVar.a(new HashMap());
        } else {
            String strOptString = jSONObject.optString("content");
            Map<String, Object> mapC = com.anythink.core.common.v.q.c(strOptString);
            if (bvVar.g() == 22 && com.anythink.core.common.v.q.a(mapC, "unit_type", 0) == 1) {
                mapC.put(com.anythink.core.common.d.j.w.E, 1);
            }
            bvVar.b(strOptString);
            bvVar.a(mapC);
            bvVar.j(a(lVar.i(), bvVar));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.z)) {
            bvVar.a("");
        } else {
            bvVar.a(jSONObject.optString(com.anythink.core.common.k.z));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.E)) {
            bvVar.d("unknown");
        } else {
            bvVar.d(jSONObject.optString(com.anythink.core.common.k.E));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.x)) {
            bvVar.e(0L);
        } else {
            bvVar.e(jSONObject.optInt(com.anythink.core.common.k.x));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.v)) {
            bvVar.f(0L);
        } else {
            bvVar.f(jSONObject.optInt(com.anythink.core.common.k.v));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.w)) {
            bvVar.h(1);
        } else {
            bvVar.h(jSONObject.optInt(com.anythink.core.common.k.w));
        }
        if (jSONObject.isNull("pacing")) {
            bvVar.g(-1L);
        } else {
            bvVar.g(jSONObject.optLong("pacing"));
        }
        if (jSONObject.isNull("unit_id")) {
            bvVar.e("");
        } else {
            bvVar.e(jSONObject.optString("unit_id"));
        }
        if (jSONObject.isNull("ecpm")) {
            bvVar.b(0.0d);
        } else {
            bvVar.b(jSONObject.optDouble("ecpm", 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.I)) {
            bvVar.h(com.anythink.basead.exoplayer.i.a.f);
        } else {
            bvVar.h(jSONObject.optInt(com.anythink.core.common.k.I));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.K)) {
            bvVar.f("");
        } else {
            bvVar.f(jSONObject.optString(com.anythink.core.common.k.K));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.L)) {
            bvVar.i(0);
        } else {
            bvVar.i(jSONObject.optInt(com.anythink.core.common.k.L));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.M)) {
            bvVar.j(3000);
        } else {
            bvVar.j(jSONObject.optInt(com.anythink.core.common.k.M));
        }
        if (jSONObject.isNull("payload")) {
            bvVar.g("");
        } else {
            bvVar.g(jSONObject.optString("payload"));
        }
        if (jSONObject.isNull("error")) {
            bvVar.h("");
        } else {
            bvVar.h(jSONObject.optString("error"));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.N)) {
            bvVar.i(1800000L);
        } else {
            bvVar.i(jSONObject.optLong(com.anythink.core.common.k.N));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.O)) {
            bvVar.j(-1L);
        } else {
            bvVar.j(jSONObject.optLong(com.anythink.core.common.k.O));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.P)) {
            bvVar.d(1800000L);
        } else {
            bvVar.d(jSONObject.optLong(com.anythink.core.common.k.P));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.am)) {
            bvVar.g(i3 ^ 1);
        } else {
            bvVar.g(jSONObject.optInt(com.anythink.core.common.k.am));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.Q)) {
            bvVar.k(1);
        } else {
            bvVar.k(jSONObject.optInt(com.anythink.core.common.k.Q));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.R)) {
            bvVar.l(1);
        } else {
            bvVar.l(jSONObject.optInt(com.anythink.core.common.k.R));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.S)) {
            bvVar.m(-1);
        } else {
            bvVar.m(jSONObject.optInt(com.anythink.core.common.k.S));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.T)) {
            bvVar.i("publisher_defined");
        } else {
            bvVar.i(jSONObject.optString(com.anythink.core.common.k.T));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.U)) {
            j = 0;
            bvVar.k(0L);
        } else {
            j = 0;
            bvVar.k(jSONObject.optLong(com.anythink.core.common.k.U));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.V)) {
            bvVar.l(j);
        } else {
            bvVar.l(jSONObject.optLong(com.anythink.core.common.k.V));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.W)) {
            bvVar.c(0.0d);
        } else {
            bvVar.c(jSONObject.optDouble(com.anythink.core.common.k.W, 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.X)) {
            bvVar.n(1);
        } else {
            bvVar.n(jSONObject.optInt(com.anythink.core.common.k.X));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.Y)) {
            bvVar.o(1);
        } else {
            bvVar.o(jSONObject.optInt(com.anythink.core.common.k.Y));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.Z)) {
            bvVar.p(2);
        } else {
            bvVar.p(jSONObject.optInt(com.anythink.core.common.k.Z));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.aa)) {
            bvVar.f(1);
        } else {
            bvVar.f(jSONObject.optInt(com.anythink.core.common.k.aa));
        }
        if (jSONObject.isNull("s2s_sw")) {
            bvVar.q(2);
        } else {
            bvVar.q(jSONObject.optInt("s2s_sw"));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ab)) {
            bvVar.s(2);
        } else {
            bvVar.s(jSONObject.optInt(com.anythink.core.common.k.ab));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ac)) {
            bvVar.r(0);
        } else {
            bvVar.r(jSONObject.optInt(com.anythink.core.common.k.ac));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ae)) {
            bvVar.t(1);
        } else {
            bvVar.t(jSONObject.optInt(com.anythink.core.common.k.ae));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ah)) {
            bvVar.k("");
        } else {
            bvVar.k(jSONObject.optString(com.anythink.core.common.k.ah));
        }
        if (i2 == 7) {
            com.anythink.core.common.f.c.a(com.anythink.core.common.d.t.b().g()).a(bvVar.z(), bvVar.ac());
        }
        if (jSONObject.isNull(com.anythink.core.common.k.af)) {
            bvVar.u(2);
        } else {
            bvVar.u(jSONObject.optInt(com.anythink.core.common.k.af));
        }
        if (jSONObject.isNull("ad_type")) {
            bvVar.v(-1);
        } else {
            bvVar.v(jSONObject.optInt("ad_type", -1));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ai)) {
            bvVar.w(-1);
        } else {
            bvVar.w(jSONObject.optInt(com.anythink.core.common.k.ai, -1));
        }
        if (bvVar.q() == 2 && bvVar.g() == 22) {
            bvVar.a(ATAdConst.CURRENCY.RMB_CENT);
        } else {
            bvVar.a(ATAdConst.CURRENCY.USD);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.aj)) {
            bvVar.D(0);
        } else {
            bvVar.D(jSONObject.optInt(com.anythink.core.common.k.aj, 0));
        }
        if (jSONObject.isNull("bid_floor")) {
            bvVar.d(0.0d);
        } else {
            bvVar.d(jSONObject.optDouble("bid_floor", 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ao)) {
            bvVar.E(-1);
        } else {
            bvVar.E(jSONObject.optInt(com.anythink.core.common.k.ao, -1));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ap)) {
            bvVar.e(bvVar.D());
        } else {
            bvVar.e(jSONObject.optDouble(com.anythink.core.common.k.ap, bvVar.D()));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.aq)) {
            bvVar.m(com.anythink.core.common.d.j.C0079j.b);
        } else {
            bvVar.m(jSONObject.optString(com.anythink.core.common.k.aq, com.anythink.core.common.d.j.C0079j.b));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ar)) {
            bvVar.F(2);
        } else {
            bvVar.F(jSONObject.optInt(com.anythink.core.common.k.ar, 2));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.as)) {
            bvVar.I(1);
        } else {
            bvVar.I(jSONObject.optInt(com.anythink.core.common.k.as));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.at)) {
            bvVar.J(2);
        } else {
            bvVar.J(jSONObject.optInt(com.anythink.core.common.k.at, 2));
        }
        if (!jSONObject.has(com.anythink.core.common.k.au)) {
            bvVar.n("TopOn");
        } else {
            bvVar.n(jSONObject.optString(com.anythink.core.common.k.au));
        }
        bvVar.n(jSONObject.optLong(com.anythink.core.common.k.av, 15000L));
        int[] iArr = null;
        if (!jSONObject.isNull(l.a.ar) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(l.a.ar)) != null && jSONArrayOptJSONArray.length() > 0) {
            try {
                iArr = new int[jSONArrayOptJSONArray.length()];
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    iArr[i4] = jSONArrayOptJSONArray.getInt(i4);
                }
            } catch (Exception unused) {
            }
        }
        bvVar.a(iArr);
        bvVar.K(jSONObject.optInt(com.anythink.core.common.k.aw, 1));
        bvVar.L(jSONObject.optInt(com.anythink.core.common.k.ax, 1));
        if (!jSONObject.isNull(com.anythink.core.common.k.ay)) {
            bvVar.a(jSONObject.optJSONArray(com.anythink.core.common.k.ay));
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.az)) {
            bvVar.M(jSONObject.optInt(com.anythink.core.common.k.az));
        }
        if (!jSONObject.isNull("ad_s_reqf_mode")) {
            bvVar.N(jSONObject.optInt("ad_s_reqf_mode"));
        }
        bvVar.P(jSONObject.optInt("unit_type", 0));
        bvVar.Q(jSONObject.optInt(com.anythink.core.common.k.aC, 0));
        bvVar.O(jSONObject.optInt("network_id"));
        bvVar.R(jSONObject.optInt(com.anythink.core.common.k.aE, 2));
        bvVar.h(jSONObject.optDouble(com.anythink.core.common.k.aN, 0.0d));
        bvVar.g(jSONObject.optDouble(com.anythink.core.common.k.aO, 0.0d));
        bvVar.a(jSONObject.optJSONObject(com.anythink.core.common.k.aP));
        bvVar.S(jSONObject.optInt(com.anythink.core.common.k.aQ));
        bvVar.T(jSONObject.optInt(com.anythink.core.common.k.aR, 1));
        ap apVarBi = lVar.bi();
        if (apVarBi != null) {
            ap apVar = new ap();
            apVar.b(apVarBi.e());
            apVar.a(apVarBi.d());
            apVar.a(apVarBi.a());
            String strOptString2 = jSONObject.optString(com.anythink.core.common.k.aS);
            if (!TextUtils.isEmpty(strOptString2)) {
                apVar.b(strOptString2);
            }
            String strOptString3 = jSONObject.optString(com.anythink.core.common.k.aT);
            if (!TextUtils.isEmpty(strOptString3)) {
                apVar.d(strOptString3);
            }
            bvVar.a(apVar);
        }
        bvVar.a(jSONObject.optDouble(com.anythink.core.common.k.aU, 0.0d));
        bvVar.U(jSONObject.optInt(com.anythink.core.common.k.aV, 2));
        bvVar.V(jSONObject.optInt(com.anythink.core.common.k.aW, 1));
        bvVar.o(jSONObject.optLong(com.anythink.core.common.k.aX, 500L));
        String strOptString4 = jSONObject.optString(com.anythink.core.common.k.aY);
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                aaVarA = aa.a(strOptString4);
            } catch (Throwable unused2) {
            }
        } else {
            aaVarA = bvVar.g() == 2 ? aa.a() : null;
        }
        bvVar.a(aaVarA);
        bvVar.W(jSONObject.optInt(com.anythink.core.common.k.aZ, 0));
        bvVar.p(jSONObject.optLong(com.anythink.core.common.k.ba, 0L));
        bvVar.X(lVar.aq());
        JSONObject jSONObjectBA = lVar.bA();
        if (jSONObjectBA != null && (jSONObjectOptJSONObject = jSONObjectBA.optJSONObject(String.valueOf(bvVar.g()))) != null) {
            bvVar.Y(jSONObjectOptJSONObject.optInt(com.anythink.core.common.k.bb, 2));
            bvVar.o(jSONObjectOptJSONObject.optString(com.anythink.core.common.k.bc, ""));
            bvVar.f(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bd));
            bvVar.b(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.be));
            bvVar.c(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bf));
            bvVar.Z(jSONObjectOptJSONObject.optInt(com.anythink.core.common.k.br, 2));
            bvVar.d(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bs));
            bvVar.e(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bt));
        }
        bvVar.aa(jSONObject.optInt(com.anythink.core.common.k.bg));
        bvVar.q(jSONObject.optLong(com.anythink.core.common.k.bh));
        bvVar.r(jSONObject.optLong(com.anythink.core.common.k.bi));
        bvVar.i(jSONObject.optDouble(com.anythink.core.common.k.bj, 0.0d));
        bvVar.x(jSONObject.optInt(com.anythink.core.common.k.bk, 2));
        bvVar.y(jSONObject.optInt(com.anythink.core.common.k.bl, 2));
        bvVar.z(jSONObject.optInt(com.anythink.core.common.k.bm, 0));
        JSONObject jSONObjectBF = lVar.bF();
        if (jSONObjectBF != null) {
            bvVar.l(jSONObjectBF.optString(com.anythink.core.common.k.bn, ""));
        }
        bvVar.A(jSONObject.optInt(com.anythink.core.common.k.bo, 2));
        bvVar.ab(jSONObject.optInt(com.anythink.core.common.k.bp, 1));
        bvVar.B(jSONObject.optInt(com.anythink.core.common.k.bq, 2));
        ATAdRequest aTAdRequest = lVar.i;
        if (aTAdRequest != null) {
            bvVar.a(aTAdRequest);
        }
        bvVar.a(com.anythink.core.common.h.l.a(jSONObject.optJSONObject(com.anythink.core.common.k.bu)));
        if (bvVar.g() >= 100000 && (aTCustomAdapterConfigB = com.anythink.core.common.d.t.b().b(bvVar.m())) != null) {
            bvVar.f(aTCustomAdapterConfigB.isRealTimeBidSwitch() ? 2 : 1);
            bvVar.e(aTCustomAdapterConfigB.getAdCacheTime());
            if (aTCustomAdapterConfigB.getLossNoticePostion() > 0) {
                bvVar.E(aTCustomAdapterConfigB.getLossNoticePostion());
            }
        }
        return bvVar;
    }

    private static void a(Map<String, Object> map, int i) {
        if (map != null && i == 22 && com.anythink.core.common.v.q.a(map, "unit_type", 0) == 1) {
            map.put(com.anythink.core.common.d.j.w.E, 1);
        }
    }
}
