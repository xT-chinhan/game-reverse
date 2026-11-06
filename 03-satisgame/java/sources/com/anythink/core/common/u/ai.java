package com.anythink.core.common.u;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.h.ba;
import com.anythink.core.common.h.bq;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.ce;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ai {
    private static final String a = "ai";

    public static com.anythink.core.common.h.n a(String str, String str2, com.anythink.core.e.l lVar, int i, int i2, Map<String, Object> map, com.anythink.core.common.h.d dVar, int i3, ATAdRequest aTAdRequest, com.anythink.core.common.f fVar) {
        com.anythink.core.common.h.n nVar = new com.anythink.core.common.h.n();
        nVar.I(str2);
        nVar.J(str);
        nVar.C(i);
        nVar.D(i);
        nVar.E(com.anythink.core.common.t.a().a(str2) ? 1 : 2);
        nVar.u = 0;
        nVar.t = 2;
        nVar.v = 0;
        a(nVar, lVar);
        nVar.aL();
        nVar.as(com.anythink.core.common.d.s.b().j());
        nVar.at(i2);
        if (lVar != null) {
            nVar.aq(lVar.q());
        } else {
            nVar.aq(2);
        }
        a(map, nVar);
        nVar.a(dVar);
        nVar.c(ATAdxSetting.getInstance().isAdxNetworkMode(str2));
        nVar.ae(i3);
        nVar.a(aTAdRequest);
        nVar.a(fVar);
        return nVar;
    }

    public static void a(Map<String, Object> map, com.anythink.core.common.h.n nVar) {
        if (map != null) {
            Object obj = map.get(ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                nVar.F(obj.toString());
            }
            Object obj2 = map.get(ATAdConst.KEY.CP_LOAD_MODE);
            if (obj2 instanceof Integer) {
                nVar.ar(Integer.parseInt(obj2.toString()));
            }
            Object obj3 = map.get(com.anythink.core.common.e.b);
            if (obj3 != null) {
                nVar.a(obj3);
            }
            JSONObject jSONObjectA = ag.a(map);
            if (jSONObjectA != null) {
                nVar.a(jSONObjectA);
            }
        }
    }

    public static void a(String str, com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar) {
        if (lVar == null || nVar == null) {
            return;
        }
        com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
        dVar.a(str, lVar.ax(), lVar.ah());
        nVar.a(dVar);
    }

    public static void a(String str, com.anythink.core.common.h.n nVar) {
        com.anythink.core.e.l lVarA;
        if (nVar == null || TextUtils.isEmpty(str) || (lVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(str)) == null || !lVarA.bn()) {
            return;
        }
        a(str, lVarA, nVar);
    }

    public static void a(ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.h.n nVar, by byVar) {
        com.anythink.core.common.h.ad adVarY;
        int i;
        com.anythink.core.common.h.ad adVarY2 = byVar.Y();
        if (adVarY2 != null) {
            nVar.l(byVar.aY());
            nVar.m(adVarY2.originPrice);
        }
        aTBaseAdAdapter.setUnitGroupInfo(byVar);
        aTBaseAdAdapter.setRefresh(nVar.V() == 1);
        try {
            nVar.y = aTBaseAdAdapter.getInternalNetworkSDKVersion();
            nVar.x = String.valueOf(aTBaseAdAdapter.internalBaseOnAdapterBridgeVersion());
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(nVar.aN())) {
            nVar.G(aTBaseAdAdapter.getInternalNetworkName());
        }
        nVar.k(aTBaseAdAdapter.getClass().getName());
        if (byVar != null && nVar != null && byVar.n() == 66 && (adVarY = byVar.Y()) != null) {
            try {
                i = Integer.parseInt(nVar.aS());
            } catch (Throwable unused2) {
                i = -2;
            }
            nVar.ac(adVarY.a(i));
        }
        aTBaseAdAdapter.setTrackingInfo(nVar);
        byVar.a(aTBaseAdAdapter);
    }

    private static void a(com.anythink.core.common.h.n nVar, by byVar) {
        com.anythink.core.common.h.ad adVarY;
        int i;
        if (byVar == null || nVar == null || byVar.n() != 66 || (adVarY = byVar.Y()) == null) {
            return;
        }
        try {
            i = Integer.parseInt(nVar.aS());
        } catch (Throwable unused) {
            i = -2;
        }
        nVar.ac(adVarY.a(i));
    }

    public static void a(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        Map<String, Object> adExtraInfoMap;
        if (nVar == null || nVar.Z() != 66 || (adExtraInfoMap = aTBaseAdAdapter.getAdExtraInfoMap()) == null || adExtraInfoMap.isEmpty()) {
            return;
        }
        nVar.M(p.a(adExtraInfoMap, com.anythink.core.bridge.a.b.a, 0));
    }

    public static void b(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        Map<String, Object> adExtraInfoMap;
        if (nVar == null || nVar.Z() != 66 || (adExtraInfoMap = aTBaseAdAdapter.getAdExtraInfoMap()) == null || adExtraInfoMap.isEmpty()) {
            return;
        }
        nVar.V(p.a(adExtraInfoMap, com.anythink.core.bridge.a.b.b, 0));
        nVar.X(p.a(adExtraInfoMap, com.anythink.core.bridge.a.b.c, 0));
        String strAS = nVar.aS();
        strAS.hashCode();
        if (strAS.equals("1")) {
            nVar.t(p.a(adExtraInfoMap, com.anythink.core.bridge.a.b.d, 0));
            nVar.ab(p.a(adExtraInfoMap, com.anythink.core.bridge.a.b.e, 0));
        } else if (strAS.equals("3")) {
            nVar.ab(p.a(adExtraInfoMap, com.anythink.core.bridge.a.b.e, 0));
            nVar.e(p.a(adExtraInfoMap, com.anythink.core.bridge.a.b.f, 0));
            nVar.aa(p.a(adExtraInfoMap, com.anythink.core.bridge.a.b.g, 0));
        }
        com.anythink.core.common.q.a(com.anythink.core.common.d.s.b().g()).a(adExtraInfoMap, nVar, 4);
    }

    public static void c(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (nVar == null || aTBaseAdAdapter == null || nVar.Z() != 66) {
            return;
        }
        a(nVar, aTBaseAdAdapter.getAdExtraInfoMap());
    }

    public static void a(com.anythink.core.common.h.n nVar, Map<String, Object> map) {
        if (nVar == null || map == null || map.isEmpty() || nVar.Z() != 66 || map == null || map.isEmpty()) {
            return;
        }
        nVar.I(p.a(map, com.anythink.core.bridge.a.b.h, 0));
        nVar.J(p.a(map, com.anythink.core.bridge.a.b.i, 0));
        nVar.X(p.a(map, com.anythink.core.bridge.a.b.c, 0));
        int iA = p.a(map, com.anythink.core.bridge.a.b.j, 6);
        nVar.d(iA == 28);
        if (iA != 28) {
            com.anythink.core.common.q.a(com.anythink.core.common.d.s.b().g()).a(map, nVar, 6);
        }
    }

    public static void a(com.anythink.core.common.h.n nVar, by byVar, int i, boolean z) {
        bq.a aVarA;
        com.anythink.core.common.h.ad adVarY;
        ba baVarB;
        String str;
        Integer.parseInt(nVar.aS());
        if (z) {
            com.anythink.core.a.a.a(com.anythink.core.common.d.s.b().g());
            nVar.aQ();
            aVarA = com.anythink.core.a.a.a(byVar.G());
        } else {
            aVarA = null;
        }
        nVar.j(byVar.k());
        nVar.i(byVar.y());
        nVar.F(byVar.n());
        nVar.r(byVar.G());
        nVar.u(byVar.P());
        nVar.v(byVar.Q());
        nVar.m(byVar.ah());
        nVar.x(i);
        nVar.t(byVar.r());
        nVar.z(aVarA != null ? aVarA.e : 0);
        nVar.A(aVarA != null ? aVarA.d : 0);
        if (byVar.X()) {
            nVar.j(byVar.K());
            nVar.f(byVar.aB());
            nVar.k(byVar.j());
        } else {
            nVar.j(0.0d);
            nVar.f(0.0d);
            nVar.k(0.0d);
        }
        nVar.a(byVar.aI());
        if (byVar.w()) {
            if (byVar.ai() != 2) {
                com.anythink.core.common.h.ad adVarY2 = byVar.Y();
                if (adVarY2 != null) {
                    str = adVarY2.s() == 3 ? "ecpm_api" : adVarY2.q;
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str = "exact";
                }
                nVar.o(str);
                if (!byVar.av()) {
                    nVar.g(byVar.K() * nVar.v());
                    nVar.h(byVar.j());
                } else if (adVarY2 != null) {
                    nVar.g(adVarY2.o * nVar.v());
                    nVar.h(adVarY2.getRmbPrice());
                }
            }
            nVar.c(byVar.az() * nVar.v());
        } else {
            nVar.g(byVar.V());
            nVar.h(byVar.j());
            String strS = byVar.S();
            if (TextUtils.isEmpty(strS)) {
                strS = "publisher_defined";
            }
            nVar.o(strS);
        }
        nVar.w(byVar.v());
        nVar.l(byVar.L());
        nVar.bb = byVar.H();
        nVar.bc = byVar.I();
        nVar.bd = byVar.J();
        nVar.s(byVar.R());
        nVar.l(byVar.ai());
        try {
            Map<String, Object> mapS = byVar.s();
            JSONObject jSONObject = new JSONObject();
            if (35 == byVar.n()) {
                String strA = p.a(mapS, "my_oid");
                com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(nVar.aQ());
                if (lVarA != null && (baVarB = lVarA.b(strA)) != null) {
                    jSONObject.put("o_id", strA);
                    jSONObject.put("c_id", baVarB.i());
                }
            }
            if ("0".equals(nVar.aS()) && (3 == byVar.y() || 7 == byVar.y())) {
                String strA2 = p.a(mapS, "layout_type");
                if (TextUtils.isEmpty(strA2) || strA2.equals("0")) {
                    strA2 = "2";
                }
                jSONObject.put("tpl_type", strA2);
            }
            if (28 == byVar.n()) {
                com.anythink.core.common.h.ad adVarY3 = byVar.Y();
                if (adVarY3 != null) {
                    jSONObject.put("origin_price", adVarY3.originPrice);
                }
            } else if (22 == byVar.n() && (adVarY = byVar.Y()) != null) {
                jSONObject.put("en_p", adVarY.getExtra());
            }
            nVar.v(jSONObject.toString());
            nVar.Y(p.a(mapS, "render_type", 0));
            nVar.Z(p.a(mapS, "template_type", 0));
        } catch (Throwable unused) {
        }
        com.anythink.core.common.h.ad adVarY4 = byVar.Y();
        nVar.f(adVarY4 != null ? adVarY4.g : "");
        nVar.H(byVar.ak());
        nVar.G(byVar.o());
        nVar.d(byVar.aU());
        aq aqVarBe = byVar.be();
        if (aqVarBe != null) {
            nVar.g(aqVarBe.b());
            nVar.h(aqVarBe.f());
            if (byVar.bc()) {
                nVar.n(aqVarBe.e());
            } else {
                nVar.n(aqVarBe.d());
            }
            nVar.i(aqVarBe.a());
        }
        nVar.a(byVar.bj());
        nVar.af(byVar.aH());
        nVar.ag(byVar.bl());
        nVar.n(byVar.bx());
        nVar.z(byVar.by());
        if (adVarY4 != null) {
            if (adVarY4.s() > 0) {
                nVar.A(adVarY4.t());
            }
            nVar.B(adVarY4.u());
            nVar.D(adVarY4.w());
            nVar.L(adVarY4.getOriginRequestId());
        }
        nVar.al(byVar.ar());
    }

    public static void a(com.anythink.core.common.h.n nVar, com.anythink.core.e.l lVar) {
        if (nVar == null || lVar == null) {
            return;
        }
        if (lVar.ap() == Integer.parseInt("1")) {
            nVar.u("1");
        } else {
            nVar.u("0");
        }
        nVar.au(lVar.ah());
        nVar.H(lVar.am());
        nVar.G(lVar.ax());
        nVar.K(String.valueOf(lVar.ap()));
        nVar.p(lVar.ad());
        nVar.q(lVar.ac());
        nVar.i(lVar.U());
        nVar.j(lVar.V());
        nVar.c(lVar.ab());
        nVar.a(lVar.ae());
        nVar.d(lVar.af());
        nVar.g(lVar.H());
        nVar.h(lVar.I());
        nVar.E(lVar.B());
        JSONObject jSONObjectAN = lVar.aN();
        if (jSONObjectAN != null) {
            nVar.b(jSONObjectAN);
        }
        nVar.aq(lVar.q());
        if (com.anythink.core.common.v.a().a(nVar.aQ())) {
            nVar.f(2);
        } else {
            nVar.f(1);
        }
        nVar.R(lVar.aY());
        nVar.ak(lVar.bC());
    }

    public static void a(com.anythink.core.common.h.n nVar, ce ceVar) {
        if (nVar != null) {
            nVar.g(ceVar.e());
            nVar.h(ceVar.f());
        }
    }

    public static void a(Context context, com.anythink.core.common.h.n nVar) {
        System.currentTimeMillis();
        int i = Integer.parseInt(nVar.aS());
        com.anythink.core.a.a.a(context);
        int[] iArrA = com.anythink.core.a.a.a(Integer.parseInt(nVar.aS()));
        int i2 = iArrA[0];
        int i3 = iArrA[1];
        com.anythink.core.a.a.a(context);
        bq bqVarA = com.anythink.core.a.a.a(nVar.aQ(), i);
        nVar.o(i2 + 1);
        nVar.p(i3 + 1);
        nVar.q(bqVarA.c + 1);
        nVar.r(bqVarA.d + 1);
    }

    private static void b(com.anythink.core.common.h.n nVar, by byVar) {
        aq aqVarBe = byVar.be();
        if (aqVarBe == null) {
            return;
        }
        nVar.g(aqVarBe.b());
        nVar.h(aqVarBe.f());
        if (byVar.bc()) {
            nVar.n(aqVarBe.e());
        } else {
            nVar.n(aqVarBe.d());
        }
        nVar.i(aqVarBe.a());
    }

    public static void a(com.anythink.core.common.h.n nVar) {
        if (nVar != null) {
            nVar.j(0.0d);
            nVar.f(0.0d);
            nVar.g(0.0d);
            nVar.h(0.0d);
        }
    }

    public static void a(ATAdRequest aTAdRequest, com.anythink.core.common.h.n nVar) {
        if (aTAdRequest == null || nVar == null) {
            return;
        }
        try {
            ATAdRequest aTAdRequestB = nVar.b();
            if (aTAdRequestB != null) {
                MgPreLoadAdRequest preLoadInfo = aTAdRequest.getPreLoadInfo();
                MgPreLoadAdRequest preLoadInfo2 = aTAdRequestB.getPreLoadInfo();
                if (preLoadInfo == null || preLoadInfo2 == null) {
                    return;
                }
                preLoadInfo2.requestId = preLoadInfo.getRequestId();
            }
        } catch (Throwable unused) {
        }
    }
}
