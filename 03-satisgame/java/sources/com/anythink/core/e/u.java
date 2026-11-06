package com.anythink.core.e;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATCustomAdapterConfig;
import com.anythink.core.common.h.aa;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.h.by;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    private static final String[] a = {"unit_id", "unitid", "slot_id", "placement_id", "zone_id", "ad_place_id", "position_id", "pos_id", "placement_name", "spot_id", "ad_tag", MediationConstant.EXTRA_ADID, "plid", "space_id", "location", "tagid", "adslot_id", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.INSTANCE_ID, "pid"};

    private static String a(String str, by byVar) {
        try {
            int iY = byVar.y();
            if (iY == 3 || iY == 7 || byVar.n() == 35) {
                return str;
            }
            Map<String, Object> mapS = byVar.s();
            for (String str2 : a) {
                String strA = com.anythink.core.common.u.p.a(mapS, str2, "");
                if (!TextUtils.isEmpty(strA)) {
                    return strA;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static void a(l lVar, Map<String, by> map, List<by> list) {
        a(lVar, map, list, lVar.ay(), 0, 1);
        a(lVar, map, list, lVar.az(), 0, 6);
        a(lVar, map, list, lVar.aA(), 1, 3);
        a(lVar, map, list, lVar.Z(), 3, 4);
        a(lVar, map, list, lVar.aB(), 2, 2);
        a(lVar, map, list, lVar.P(), 6, 11);
        a(lVar, map, list, lVar.aH(), 7, 8);
        a(lVar, map, list, lVar.aI(), 3, 5);
        a(lVar, map, list, lVar.K(), 8, 10);
        a(lVar, map, list, lVar.bt(), 2, 12);
        a(lVar, map, list, lVar.bu(), 1, 13);
    }

    private static void a(l lVar, Map<String, by> map, List<by> list, JSONArray jSONArray, int i, int i2) {
        try {
            com.anythink.core.common.h.q qVarBa = lVar.ba();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null) {
                    by byVarA = a(i2, i, jSONObjectOptJSONObject, lVar);
                    map.put(byVarA.G(), byVarA);
                    if (byVarA.n() == 35) {
                        list.add(byVarA);
                    }
                    a(lVar, byVarA);
                    if (qVarBa != null && byVarA.n() == 2) {
                        if (i == 0) {
                            qVarBa.a = true;
                        }
                        if (i == 1) {
                            qVarBa.b = true;
                        }
                    }
                    if (lVar.bo() == null && byVarA.w() && byVarA.ba() == 1) {
                        lVar.a(Boolean.TRUE);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(l lVar, by byVar) {
        if (byVar.az() > 0.0d || lVar == null) {
            return;
        }
        double dAL = lVar.aL();
        if (dAL > 0.0d) {
            byVar.d(dAL);
        }
    }

    public static List<by> a(l lVar) {
        List<by> listA = a(lVar, lVar.aA(), 1, 3);
        List<by> listA2 = a(lVar, lVar.Z(), 3, 4);
        List<by> listA3 = a(lVar, lVar.aB(), 2, 2);
        List<by> listA4 = a(lVar, lVar.P(), 6, 11);
        List<by> listA5 = a(lVar, lVar.aH(), 7, 8);
        List<by> listA6 = a(lVar, lVar.aI(), 3, 5);
        listA.addAll(listA2);
        listA.addAll(listA3);
        listA.addAll(listA4);
        listA.addAll(listA5);
        listA.addAll(listA6);
        return listA;
    }

    public static List<by> b(l lVar) {
        List<by> listA = a(lVar, lVar.ay(), 0, 1);
        listA.addAll(a(lVar, lVar.az(), 4, 6));
        Collections.sort(listA);
        return listA;
    }

    public static List<by> c(l lVar) {
        return a(lVar, lVar.K(), 8, 10);
    }

    public static List<by> a(l lVar, JSONArray jSONArray) {
        return a(lVar, jSONArray, 3, 4);
    }

    public static List<by> d(l lVar) {
        return a(lVar, lVar.bt(), 2, 12);
    }

    public static List<by> e(l lVar) {
        return a(lVar, lVar.bu(), 1, 13);
    }

    private static List<by> a(l lVar, JSONArray jSONArray, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    by byVarA = a(i2, i, jSONObject, lVar);
                    a(lVar, byVarA);
                    arrayList.add(byVarA);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private static by a(int i, int i2, JSONObject jSONObject, l lVar) {
        long j;
        int i3;
        aa aaVarA;
        ATCustomAdapterConfig aTCustomAdapterConfigB;
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        int i4 = (i2 == 0 || i2 == 4 || i2 == 8) ? 0 : 1;
        by byVar = new by(i);
        byVar.i(i2);
        byVar.h(i4);
        if (jSONObject.isNull(com.anythink.core.common.k.E)) {
            byVar.c("");
        } else {
            byVar.c(jSONObject.optString(com.anythink.core.common.k.E));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.B)) {
            byVar.f(-1);
        } else {
            byVar.f(jSONObject.optInt(com.anythink.core.common.k.B));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.C)) {
            byVar.g(-1);
        } else {
            byVar.g(jSONObject.optInt(com.anythink.core.common.k.C));
        }
        if (jSONObject.isNull("nw_firm_id")) {
            byVar.e(-1);
        } else {
            byVar.e(jSONObject.optInt("nw_firm_id"));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.D)) {
            byVar.b("");
            byVar.a(new HashMap());
        } else {
            String strOptString = jSONObject.optString(com.anythink.core.common.k.D);
            Map<String, Object> mapC = com.anythink.core.common.u.p.c(strOptString);
            if (byVar.n() == 22 && com.anythink.core.common.u.p.a(mapC, "unit_type", 0) == 1) {
                mapC.put("render_type", 1);
            }
            byVar.b(strOptString);
            byVar.a(mapC);
            byVar.k(a(lVar.i(), byVar));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.A)) {
            byVar.a("");
        } else {
            byVar.a(jSONObject.optString(com.anythink.core.common.k.A));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.F)) {
            byVar.e("unknown");
        } else {
            byVar.e(jSONObject.optString(com.anythink.core.common.k.F));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.y)) {
            byVar.g(0L);
        } else {
            byVar.g(jSONObject.optInt(com.anythink.core.common.k.y));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.w)) {
            byVar.h(0L);
        } else {
            byVar.h(jSONObject.optInt(com.anythink.core.common.k.w));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.x)) {
            byVar.l(1);
        } else {
            byVar.l(jSONObject.optInt(com.anythink.core.common.k.x));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.G)) {
            byVar.i(-1L);
        } else {
            byVar.i(jSONObject.optLong(com.anythink.core.common.k.G));
        }
        if (jSONObject.isNull("unit_id")) {
            byVar.f("");
        } else {
            byVar.f(jSONObject.optString("unit_id"));
        }
        if (jSONObject.isNull("ecpm")) {
            byVar.b(0.0d);
        } else {
            byVar.b(jSONObject.optDouble("ecpm", 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.J)) {
            byVar.j(2000L);
        } else {
            byVar.j(jSONObject.optInt(com.anythink.core.common.k.J));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.L)) {
            byVar.g("");
        } else {
            byVar.g(jSONObject.optString(com.anythink.core.common.k.L));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.M)) {
            byVar.m(0);
        } else {
            byVar.m(jSONObject.optInt(com.anythink.core.common.k.M));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.N)) {
            byVar.n(3000);
        } else {
            byVar.n(jSONObject.optInt(com.anythink.core.common.k.N));
        }
        if (jSONObject.isNull("payload")) {
            byVar.h("");
        } else {
            byVar.h(jSONObject.optString("payload"));
        }
        if (jSONObject.isNull("error")) {
            byVar.i("");
        } else {
            byVar.i(jSONObject.optString("error"));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.O)) {
            byVar.k(com.anythink.core.common.g.c.a);
        } else {
            byVar.k(jSONObject.optLong(com.anythink.core.common.k.O));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.P)) {
            byVar.l(-1L);
        } else {
            byVar.l(jSONObject.optLong(com.anythink.core.common.k.P));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.Q)) {
            byVar.f(com.anythink.core.common.g.c.a);
        } else {
            byVar.f(jSONObject.optLong(com.anythink.core.common.k.Q));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.an)) {
            byVar.k(i4 ^ 1);
        } else {
            byVar.k(jSONObject.optInt(com.anythink.core.common.k.an));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.R)) {
            byVar.o(1);
        } else {
            byVar.o(jSONObject.optInt(com.anythink.core.common.k.R));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.S)) {
            byVar.p(1);
        } else {
            byVar.p(jSONObject.optInt(com.anythink.core.common.k.S));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.T)) {
            byVar.q(-1);
        } else {
            byVar.q(jSONObject.optInt(com.anythink.core.common.k.T));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.U)) {
            byVar.j("publisher_defined");
        } else {
            byVar.j(jSONObject.optString(com.anythink.core.common.k.U));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.V)) {
            j = 0;
            byVar.m(0L);
        } else {
            j = 0;
            byVar.m(jSONObject.optLong(com.anythink.core.common.k.V));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.W)) {
            byVar.n(j);
        } else {
            byVar.n(jSONObject.optLong(com.anythink.core.common.k.W));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.X)) {
            byVar.c(0.0d);
        } else {
            byVar.c(jSONObject.optDouble(com.anythink.core.common.k.X, 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.Y)) {
            byVar.r(1);
        } else {
            byVar.r(jSONObject.optInt(com.anythink.core.common.k.Y));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.Z)) {
            byVar.s(1);
        } else {
            byVar.s(jSONObject.optInt(com.anythink.core.common.k.Z));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.aa)) {
            byVar.t(2);
        } else {
            byVar.t(jSONObject.optInt(com.anythink.core.common.k.aa));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ab)) {
            byVar.j(1);
        } else {
            byVar.j(jSONObject.optInt(com.anythink.core.common.k.ab));
        }
        if (jSONObject.isNull("s2s_sw")) {
            byVar.u(2);
        } else {
            byVar.u(jSONObject.optInt("s2s_sw"));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ac)) {
            byVar.w(2);
        } else {
            byVar.w(jSONObject.optInt(com.anythink.core.common.k.ac));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ad)) {
            byVar.v(0);
        } else {
            byVar.v(jSONObject.optInt(com.anythink.core.common.k.ad));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.af)) {
            byVar.x(1);
        } else {
            byVar.x(jSONObject.optInt(com.anythink.core.common.k.af));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ai)) {
            byVar.l("");
        } else {
            byVar.l(jSONObject.optString(com.anythink.core.common.k.ai));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ag)) {
            byVar.y(2);
        } else {
            byVar.y(jSONObject.optInt(com.anythink.core.common.k.ag));
        }
        if (jSONObject.isNull("ad_type")) {
            i3 = -1;
            byVar.z(-1);
        } else {
            i3 = -1;
            byVar.z(jSONObject.optInt("ad_type", -1));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.aj)) {
            byVar.A(i3);
        } else {
            byVar.A(jSONObject.optInt(com.anythink.core.common.k.aj, i3));
        }
        if (byVar.y() == 2 && byVar.n() == 22) {
            byVar.a(ATAdConst.CURRENCY.RMB_CENT);
        } else {
            byVar.a(ATAdConst.CURRENCY.USD);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ak)) {
            byVar.H(0);
        } else {
            byVar.H(jSONObject.optInt(com.anythink.core.common.k.ak, 0));
        }
        if (jSONObject.isNull("bid_floor")) {
            byVar.d(0.0d);
        } else {
            byVar.d(jSONObject.optDouble("bid_floor", 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ap)) {
            byVar.I(-1);
        } else {
            byVar.I(jSONObject.optInt(com.anythink.core.common.k.ap, -1));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.aq)) {
            byVar.e(byVar.K());
        } else {
            byVar.e(jSONObject.optDouble(com.anythink.core.common.k.aq, byVar.K()));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ar)) {
            byVar.n(com.anythink.core.common.d.i.k.b);
        } else {
            byVar.n(jSONObject.optString(com.anythink.core.common.k.ar, com.anythink.core.common.d.i.k.b));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.as)) {
            byVar.J(2);
        } else {
            byVar.J(jSONObject.optInt(com.anythink.core.common.k.as, 2));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.at)) {
            byVar.M(1);
        } else {
            byVar.M(jSONObject.optInt(com.anythink.core.common.k.at));
        }
        if (jSONObject.isNull(com.anythink.core.common.k.au)) {
            byVar.N(2);
        } else {
            byVar.N(jSONObject.optInt(com.anythink.core.common.k.au, 2));
        }
        if (!jSONObject.has(com.anythink.core.common.k.av)) {
            byVar.o("TopOn");
        } else {
            byVar.o(jSONObject.optString(com.anythink.core.common.k.av));
        }
        byVar.p(jSONObject.optLong(com.anythink.core.common.k.aw, 15000L));
        int[] iArr = null;
        if (!jSONObject.isNull(l.a.ar) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(l.a.ar)) != null && jSONArrayOptJSONArray.length() > 0) {
            try {
                iArr = new int[jSONArrayOptJSONArray.length()];
                for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                    iArr[i5] = jSONArrayOptJSONArray.getInt(i5);
                }
            } catch (Exception unused) {
            }
        }
        byVar.a(iArr);
        byVar.O(jSONObject.optInt(com.anythink.core.common.k.ax, 1));
        byVar.P(jSONObject.optInt(com.anythink.core.common.k.ay, 1));
        if (!jSONObject.isNull(com.anythink.core.common.k.az)) {
            byVar.a(jSONObject.optJSONArray(com.anythink.core.common.k.az));
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.aA)) {
            byVar.Q(jSONObject.optInt(com.anythink.core.common.k.aA));
        }
        if (!jSONObject.isNull("ad_s_reqf_mode")) {
            byVar.R(jSONObject.optInt("ad_s_reqf_mode"));
        }
        byVar.T(jSONObject.optInt("unit_type", 0));
        byVar.U(jSONObject.optInt(com.anythink.core.common.k.aD, 0));
        byVar.S(jSONObject.optInt("network_id"));
        byVar.V(jSONObject.optInt(com.anythink.core.common.k.aF, 2));
        byVar.h(jSONObject.optDouble(com.anythink.core.common.k.aP, 0.0d));
        byVar.g(jSONObject.optDouble(com.anythink.core.common.k.aQ, 0.0d));
        byVar.a(jSONObject.optJSONObject(com.anythink.core.common.k.aR));
        byVar.W(jSONObject.optInt(com.anythink.core.common.k.aS));
        byVar.X(jSONObject.optInt(com.anythink.core.common.k.aT, 1));
        aq aqVarBe = lVar.be();
        if (aqVarBe != null) {
            aq aqVar = new aq();
            aqVar.b(aqVarBe.e());
            aqVar.a(aqVarBe.d());
            aqVar.a(aqVarBe.a());
            String strOptString2 = jSONObject.optString(com.anythink.core.common.k.aU);
            if (!TextUtils.isEmpty(strOptString2)) {
                aqVar.b(strOptString2);
            }
            String strOptString3 = jSONObject.optString(com.anythink.core.common.k.aV);
            if (!TextUtils.isEmpty(strOptString3)) {
                aqVar.d(strOptString3);
            }
            byVar.a(aqVar);
        }
        byVar.a(jSONObject.optDouble(com.anythink.core.common.k.aW, 0.0d));
        byVar.Y(jSONObject.optInt(com.anythink.core.common.k.aX, 2));
        byVar.Z(jSONObject.optInt(com.anythink.core.common.k.aY, 1));
        byVar.q(jSONObject.optLong(com.anythink.core.common.k.aZ, 500L));
        String strOptString4 = jSONObject.optString(com.anythink.core.common.k.ba);
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                aaVarA = aa.a(strOptString4);
            } catch (Throwable unused2) {
            }
        } else {
            aaVarA = byVar.n() == 2 ? aa.a() : null;
        }
        byVar.a(aaVarA);
        byVar.aa(jSONObject.optInt(com.anythink.core.common.k.bb, 0));
        byVar.r(jSONObject.optLong(com.anythink.core.common.k.bc, 0L));
        byVar.ab(lVar.ap());
        JSONObject jSONObjectBA = lVar.bA();
        if (jSONObjectBA != null && (jSONObjectOptJSONObject = jSONObjectBA.optJSONObject(String.valueOf(byVar.n()))) != null) {
            byVar.ac(jSONObjectOptJSONObject.optInt(com.anythink.core.common.k.bd, 2));
            byVar.p(jSONObjectOptJSONObject.optString(com.anythink.core.common.k.be, ""));
            byVar.f(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bf));
            byVar.b(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bg));
            byVar.c(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bh));
            byVar.ad(jSONObjectOptJSONObject.optInt(com.anythink.core.common.k.bt, 2));
            byVar.d(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bu));
            byVar.e(jSONObjectOptJSONObject.optJSONArray(com.anythink.core.common.k.bv));
        }
        byVar.ae(jSONObject.optInt(com.anythink.core.common.k.bi));
        byVar.s(jSONObject.optLong(com.anythink.core.common.k.bj));
        byVar.t(jSONObject.optLong(com.anythink.core.common.k.bk));
        byVar.i(jSONObject.optDouble(com.anythink.core.common.k.bl, 0.0d));
        byVar.B(jSONObject.optInt(com.anythink.core.common.k.bm, 2));
        byVar.C(jSONObject.optInt(com.anythink.core.common.k.bn, 2));
        byVar.D(jSONObject.optInt(com.anythink.core.common.k.bo, 0));
        JSONObject jSONObjectBF = lVar.bF();
        if (jSONObjectBF != null) {
            byVar.m(jSONObjectBF.optString(com.anythink.core.common.k.bp, ""));
        }
        byVar.E(jSONObject.optInt(com.anythink.core.common.k.bq, 2));
        byVar.af(jSONObject.optInt(com.anythink.core.common.k.br, 1));
        byVar.F(jSONObject.optInt(com.anythink.core.common.k.bs, 2));
        ATAdRequest aTAdRequest = lVar.i;
        if (aTAdRequest != null) {
            byVar.a(aTAdRequest);
        }
        byVar.a(com.anythink.core.common.h.l.a(jSONObject.optJSONObject(com.anythink.core.common.k.bw)));
        byVar.c(jSONObject.optInt(com.anythink.core.common.k.bx, 2));
        byVar.b(jSONObject.optInt(com.anythink.core.common.k.by, 2));
        byVar.d(jSONObject.optLong(com.anythink.core.common.k.bz, 0L));
        byVar.d(jSONObject.optInt(com.anythink.core.common.k.bA, 2));
        byVar.a(jSONObject.optInt(com.anythink.core.common.k.bB, 0));
        byVar.ah(jSONObject.optInt(com.anythink.core.common.k.bC, 1));
        byVar.ai(jSONObject.optInt(com.anythink.core.common.k.bD, 2));
        byVar.v(jSONObject.optLong(com.anythink.core.common.k.bE, 500L));
        byVar.aj(jSONObject.optInt(com.anythink.core.common.k.bF, 2));
        if (byVar.n() >= 100000 && (aTCustomAdapterConfigB = com.anythink.core.common.d.s.b().b(byVar.t())) != null) {
            byVar.j(aTCustomAdapterConfigB.isRealTimeBidSwitch() ? 2 : 1);
            byVar.g(aTCustomAdapterConfigB.getAdCacheTime());
            if (aTCustomAdapterConfigB.getLossNoticePostion() > 0) {
                byVar.I(aTCustomAdapterConfigB.getLossNoticePostion());
            }
        }
        return byVar;
    }

    private static void a(Map<String, Object> map, int i) {
        if (map != null && i == 22 && com.anythink.core.common.u.p.a(map, "unit_type", 0) == 1) {
            map.put("render_type", 1);
        }
    }
}
