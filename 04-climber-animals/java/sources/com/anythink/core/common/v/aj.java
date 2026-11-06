package com.anythink.core.common.v;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.h.ap;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bo;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.cb;
import com.anythink.network.baidu.BaiduATConst;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aj {
    public static com.anythink.core.common.h.n a(String str, String str2, com.anythink.core.d.l lVar, int i, int i2, Map<String, Object> map, com.anythink.core.common.h.d dVar, int i3, ATAdRequest aTAdRequest) {
        com.anythink.core.common.h.n nVar = new com.anythink.core.common.h.n();
        nVar.I(str2);
        nVar.J(str);
        nVar.C(i);
        nVar.D(i);
        nVar.E(com.anythink.core.common.u.a().e(str2) ? 1 : 2);
        nVar.u = 0;
        nVar.t = 2;
        nVar.v = 0;
        a(nVar, lVar);
        nVar.aD();
        nVar.an(com.anythink.core.common.d.t.b().j());
        nVar.ao(i2);
        if (lVar != null) {
            nVar.al(lVar.p());
        } else {
            nVar.al(2);
        }
        a(map, nVar);
        nVar.a(dVar);
        nVar.c(ATAdxSetting.getInstance().isAdxNetworkMode(str2));
        nVar.ad(i3);
        nVar.a(aTAdRequest);
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
                nVar.am(Integer.parseInt(obj2.toString()));
            }
            Object obj3 = map.get(com.anythink.core.common.e.b);
            if (obj3 != null) {
                nVar.a(obj3);
            }
            JSONObject jSONObjectA = ai.a(map);
            if (jSONObjectA != null) {
                nVar.a(jSONObjectA);
            }
        }
    }

    public static void a(String str, com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar) {
        if (lVar == null || nVar == null) {
            return;
        }
        com.anythink.core.common.h.d dVar = new com.anythink.core.common.h.d();
        dVar.a(str, lVar.ay(), lVar.ai());
        nVar.a(dVar);
    }

    public static void a(String str, com.anythink.core.common.h.n nVar) {
        com.anythink.core.d.l lVarA;
        if (nVar == null || (lVarA = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(str)) == null || !lVarA.bm()) {
            return;
        }
        a(str, lVarA, nVar);
    }

    public static com.anythink.core.common.h.n a(ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.h.n nVar, bv bvVar) {
        com.anythink.core.common.h.ad adVarR = bvVar.R();
        if (adVarR != null) {
            nVar.l(bvVar.aQ());
            nVar.m(adVarR.originPrice);
        }
        aTBaseAdAdapter.setUnitGroupInfo(bvVar);
        aTBaseAdAdapter.setRefresh(nVar.U() == 1);
        try {
            nVar.x = aTBaseAdAdapter.getInternalNetworkSDKVersion();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(nVar.aF())) {
            nVar.G(aTBaseAdAdapter.getInternalNetworkName());
        }
        nVar.k(aTBaseAdAdapter.getClass().getName());
        aTBaseAdAdapter.setTrackingInfo(nVar);
        return nVar;
    }

    public static void a(com.anythink.core.common.h.n nVar, bv bvVar, int i, boolean z) {
        com.anythink.core.common.h.ad adVarR;
        ay ayVarB;
        String str;
        bo.a aVarA = z ? com.anythink.core.a.a.a(com.anythink.core.common.d.t.b().g()).a(nVar.aI(), bvVar.z(), Integer.parseInt(nVar.aK())) : null;
        nVar.j(bvVar.d());
        nVar.i(bvVar.q());
        nVar.F(bvVar.g());
        nVar.r(bvVar.z());
        nVar.u(bvVar.I());
        nVar.v(bvVar.J());
        nVar.m(bvVar.aa());
        nVar.x(i);
        nVar.t(bvVar.k());
        nVar.z(aVarA != null ? aVarA.e : 0);
        nVar.A(aVarA != null ? aVarA.d : 0);
        if (bvVar.Q()) {
            nVar.j(bvVar.D());
            nVar.f(bvVar.at());
            nVar.k(bvVar.c());
        } else {
            nVar.j(0.0d);
            nVar.f(0.0d);
            nVar.k(0.0d);
        }
        nVar.a(bvVar.aA());
        if (bvVar.o()) {
            if (bvVar.ab() != 2) {
                com.anythink.core.common.h.ad adVarR2 = bvVar.R();
                if (adVarR2 != null) {
                    str = adVarR2.t() == 3 ? "ecpm_api" : adVarR2.q;
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str = "exact";
                }
                nVar.o(str);
                if (!bvVar.an()) {
                    nVar.g(bvVar.D() * nVar.u());
                    nVar.h(bvVar.c());
                } else if (adVarR2 != null) {
                    nVar.g(adVarR2.o * nVar.u());
                    nVar.h(adVarR2.getRmbPrice());
                }
            }
            nVar.c(bvVar.ar() * nVar.u());
        } else {
            nVar.g(bvVar.O());
            nVar.h(bvVar.c());
            String strL = bvVar.L();
            if (TextUtils.isEmpty(strL)) {
                strL = "publisher_defined";
            }
            nVar.o(strL);
        }
        nVar.w(bvVar.n());
        nVar.l(bvVar.E());
        nVar.aP = bvVar.A();
        nVar.aQ = bvVar.B();
        nVar.aR = bvVar.C();
        nVar.s(bvVar.K());
        nVar.l(bvVar.ab());
        try {
            Map<String, Object> mapL = bvVar.l();
            JSONObject jSONObject = new JSONObject();
            if (35 == bvVar.g()) {
                String strA = q.a(mapL, "my_oid");
                com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(nVar.aI());
                if (lVarA != null && (ayVarB = lVarA.b(strA)) != null) {
                    jSONObject.put("o_id", strA);
                    jSONObject.put("c_id", ayVarB.w());
                }
            }
            if ("0".equals(nVar.aK()) && (3 == bvVar.q() || 7 == bvVar.q())) {
                String strA2 = q.a(mapL, "layout_type");
                if (TextUtils.isEmpty(strA2) || strA2.equals("0")) {
                    strA2 = "2";
                }
                jSONObject.put("tpl_type", strA2);
            }
            if (28 == bvVar.g()) {
                com.anythink.core.common.h.ad adVarR3 = bvVar.R();
                if (adVarR3 != null) {
                    jSONObject.put("origin_price", adVarR3.originPrice);
                }
            } else if (22 == bvVar.g() && (adVarR = bvVar.R()) != null) {
                jSONObject.put(BaiduATConst.EN_P_KEY, adVarR.getExtra());
            }
            nVar.v(jSONObject.toString());
            nVar.X(q.a(mapL, com.anythink.core.common.d.j.w.E, 0));
            nVar.Y(q.a(mapL, com.anythink.core.common.d.j.w.F, 0));
        } catch (Throwable unused) {
        }
        com.anythink.core.common.h.ad adVarR4 = bvVar.R();
        nVar.f(adVarR4 != null ? adVarR4.g : "");
        nVar.H(bvVar.ae());
        nVar.G(bvVar.h());
        nVar.d(bvVar.aM());
        ap apVarAW = bvVar.aW();
        if (apVarAW != null) {
            nVar.g(apVarAW.b());
            nVar.h(apVarAW.f());
            if (bvVar.aU()) {
                nVar.n(apVarAW.e());
            } else {
                nVar.n(apVarAW.d());
            }
            nVar.i(apVarAW.a());
            Object[] objArr = new Object[2];
            bvVar.z();
        }
        nVar.a(bvVar.bb());
        nVar.ae(bvVar.az());
        nVar.af(bvVar.bd());
        nVar.n(bvVar.bp());
        nVar.v(bvVar.bq());
        if (adVarR4 != null) {
            if (adVarR4.t() > 0) {
                nVar.B(adVarR4.u());
            }
            nVar.C(adVarR4.v());
            nVar.D(adVarR4.x());
            nVar.L(adVarR4.getOriginRequestId());
        }
        nVar.ak(bvVar.al());
    }

    public static void a(com.anythink.core.common.h.n nVar, com.anythink.core.d.l lVar) {
        if (nVar == null || lVar == null) {
            return;
        }
        if (lVar.aq() == Integer.parseInt("1")) {
            nVar.u("1");
        } else {
            nVar.u("0");
        }
        nVar.ap(lVar.ai());
        nVar.H(lVar.an());
        nVar.G(lVar.ay());
        nVar.K(String.valueOf(lVar.aq()));
        nVar.p(lVar.ae());
        nVar.q(lVar.ad());
        nVar.i(lVar.T());
        nVar.j(lVar.U());
        nVar.c(lVar.ac());
        nVar.a(lVar.af());
        nVar.d(lVar.ag());
        nVar.g(lVar.G());
        nVar.h(lVar.H());
        nVar.E(lVar.A());
        JSONObject jSONObjectAQ = lVar.aQ();
        if (jSONObjectAQ != null) {
            nVar.b(jSONObjectAQ);
        }
        nVar.al(lVar.p());
        if (com.anythink.core.common.w.a().a(nVar.aI())) {
            nVar.f(2);
        } else {
            nVar.f(1);
        }
        nVar.Q(lVar.bd());
        nVar.aj(lVar.bC());
    }

    private static void a(com.anythink.core.common.h.n nVar, cb cbVar) {
        if (nVar != null) {
            nVar.g(cbVar.e());
            nVar.h(cbVar.f());
        }
    }

    public static void a(Context context, com.anythink.core.common.h.n nVar) {
        System.currentTimeMillis();
        int i = Integer.parseInt(nVar.aK());
        int[] iArrA = com.anythink.core.a.a.a(context).a(Integer.parseInt(nVar.aK()));
        int i2 = iArrA[0];
        int i3 = iArrA[1];
        bo boVarA = com.anythink.core.a.a.a(context).a(nVar.aI(), i);
        nVar.o(i2 + 1);
        nVar.p(i3 + 1);
        nVar.q((boVarA != null ? boVarA.c : 0) + 1);
        nVar.r((boVarA != null ? boVarA.d : 0) + 1);
        System.currentTimeMillis();
    }

    private static void a(com.anythink.core.common.h.n nVar, bv bvVar) {
        ap apVarAW = bvVar.aW();
        if (apVarAW == null) {
            return;
        }
        nVar.g(apVarAW.b());
        nVar.h(apVarAW.f());
        if (bvVar.aU()) {
            nVar.n(apVarAW.e());
        } else {
            nVar.n(apVarAW.d());
        }
        nVar.i(apVarAW.a());
        Object[] objArr = new Object[2];
        bvVar.z();
    }

    public static void a(com.anythink.core.common.h.n nVar) {
        if (nVar != null) {
            nVar.j(0.0d);
            nVar.f(0.0d);
            nVar.g(0.0d);
            nVar.h(0.0d);
        }
    }
}
