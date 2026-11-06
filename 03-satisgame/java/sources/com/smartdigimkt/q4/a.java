package com.smartdigimkt.q4;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.i;
import com.anythink.core.e.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.p4.e;
import com.smartdigimkt.p4.f;
import com.smartdigimkt.p4.g;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.u2.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final String[] a = {"unit_id", "unitid", "slot_id", "placement_id", "zone_id", "ad_place_id", "position_id", "pos_id", "placement_name", "spot_id", "ad_tag", MediationConstant.EXTRA_ADID, "plid", "space_id", "location", "tagid", "adslot_id", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.INSTANCE_ID, "pid"};

    public static void a(g gVar, LinkedHashMap linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            gVar.g = false;
            gVar.h = 0;
            gVar.i = "";
            gVar.j = 0;
            gVar.k = 0;
            return;
        }
        if (linkedHashMap.containsKey("unit_type")) {
            int iIntValue = ((Integer) k.a((Map) linkedHashMap, "unit_type", (Object) 0)).intValue();
            gVar.g = true;
            gVar.h = iIntValue;
        } else {
            gVar.g = false;
            gVar.h = 0;
        }
        gVar.i = (String) k.a(linkedHashMap, "layout_type", "");
        gVar.j = ((Integer) k.a((Map) linkedHashMap, "render_type", (Object) 0)).intValue();
        gVar.k = ((Integer) k.a((Map) linkedHashMap, "template_type", (Object) 0)).intValue();
        String[] strArr = {"my_oid", "myOfferId", "my_offer_id"};
        if (linkedHashMap.isEmpty()) {
            return;
        }
        for (int i = 0; i < 3 && TextUtils.isEmpty((String) k.a(linkedHashMap, strArr[i], "")); i++) {
        }
    }

    public static ArrayList a(e eVar, JSONArray jSONArray, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    g gVarA = a(i2, i, jSONObject, eVar);
                    if (gVarA.z <= 0.0d) {
                        double d = eVar.s;
                        if (d > 0.0d) {
                            gVarA.z = d;
                        }
                    }
                    arrayList.add(gVarA);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static g a(int i, int i2, JSONObject jSONObject, e eVar) {
        f fVar;
        int[] iArr;
        JSONArray jSONArrayOptJSONArray;
        int i3 = (i2 == 0 || i2 == 4 || i2 == 8) ? 0 : 1;
        g gVar = new g(i);
        gVar.u = i2;
        gVar.n = i3;
        if (!jSONObject.isNull(com.anythink.core.common.k.E)) {
            jSONObject.optString(com.anythink.core.common.k.E);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.B)) {
            jSONObject.optInt(com.anythink.core.common.k.B);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.C)) {
            jSONObject.optInt(com.anythink.core.common.k.C);
        }
        if (jSONObject.isNull("nw_firm_id")) {
            gVar.b = -1;
        } else {
            gVar.b = jSONObject.optInt("nw_firm_id");
        }
        if (jSONObject.isNull(com.anythink.core.common.k.D)) {
            gVar.d = "";
            gVar.e = new HashMap();
            a(gVar, null);
            gVar.f = f.b;
        } else {
            String strOptString = jSONObject.optString(com.anythink.core.common.k.D);
            LinkedHashMap linkedHashMapA = k.a(strOptString);
            gVar.d = strOptString;
            gVar.e = linkedHashMapA;
            a(gVar, linkedHashMapA);
            f fVar2 = f.b;
            if (linkedHashMapA.isEmpty()) {
                fVar = f.b;
            } else {
                fVar = new f(linkedHashMapA);
            }
            gVar.f = fVar;
            String str = eVar.e;
            try {
                int i4 = gVar.u;
                if (i4 != 3 && i4 != 7) {
                    Map map = gVar.e;
                    String[] strArr = a;
                    for (int i5 = 0; i5 < 19 && TextUtils.isEmpty((String) k.a(map, strArr[i5], "")); i5++) {
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (jSONObject.isNull(com.anythink.core.common.k.A)) {
            gVar.c = "";
        } else {
            gVar.c = jSONObject.optString(com.anythink.core.common.k.A);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.F)) {
            jSONObject.optString(com.anythink.core.common.k.F);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.y)) {
            jSONObject.optInt(com.anythink.core.common.k.y);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.w)) {
            jSONObject.optInt(com.anythink.core.common.k.w);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.x)) {
            jSONObject.optInt(com.anythink.core.common.k.x);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.G)) {
            jSONObject.optLong(com.anythink.core.common.k.G);
        }
        if (jSONObject.isNull("unit_id")) {
            gVar.r = "";
        } else {
            gVar.r = jSONObject.optString("unit_id");
        }
        if (jSONObject.isNull("ecpm")) {
            gVar.m = 0.0d;
        } else {
            gVar.m = jSONObject.optDouble("ecpm", 0.0d);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.J)) {
            jSONObject.optInt(com.anythink.core.common.k.J);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.L)) {
            gVar.l = "";
        } else {
            gVar.l = jSONObject.optString(com.anythink.core.common.k.L);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.M)) {
            jSONObject.optInt(com.anythink.core.common.k.M);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.N)) {
            jSONObject.optInt(com.anythink.core.common.k.N);
        }
        if (jSONObject.isNull("payload")) {
            gVar.o = "";
        } else {
            gVar.o = jSONObject.optString("payload");
        }
        if (jSONObject.isNull("error")) {
            gVar.p = "";
        } else {
            gVar.p = jSONObject.optString("error");
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.O)) {
            jSONObject.optLong(com.anythink.core.common.k.O);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.P)) {
            jSONObject.optLong(com.anythink.core.common.k.P);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.Q)) {
            jSONObject.optLong(com.anythink.core.common.k.Q);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.an)) {
            gVar.q = i3 ^ 1;
        } else {
            gVar.q = jSONObject.optInt(com.anythink.core.common.k.an);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.R)) {
            jSONObject.optInt(com.anythink.core.common.k.R);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.S)) {
            jSONObject.optInt(com.anythink.core.common.k.S);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.T)) {
            jSONObject.optInt(com.anythink.core.common.k.T);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.U)) {
            gVar.s = "publisher_defined";
        } else {
            gVar.s = jSONObject.optString(com.anythink.core.common.k.U);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.V)) {
            jSONObject.optLong(com.anythink.core.common.k.V);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.W)) {
            jSONObject.optLong(com.anythink.core.common.k.W);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.X)) {
            jSONObject.optDouble(com.anythink.core.common.k.X, 0.0d);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.Y)) {
            jSONObject.optInt(com.anythink.core.common.k.Y);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.Z)) {
            jSONObject.optInt(com.anythink.core.common.k.Z);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.aa)) {
            gVar.t = 2;
        } else {
            gVar.t = jSONObject.optInt(com.anythink.core.common.k.aa);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.ab)) {
            jSONObject.optInt(com.anythink.core.common.k.ab);
        }
        if (!jSONObject.isNull("s2s_sw")) {
            jSONObject.optInt("s2s_sw");
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.ac)) {
            jSONObject.optInt(com.anythink.core.common.k.ac);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.ad)) {
            jSONObject.optInt(com.anythink.core.common.k.ad);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.af)) {
            gVar.x = 1;
        } else {
            gVar.x = jSONObject.optInt(com.anythink.core.common.k.af);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.ai)) {
            gVar.y = "";
        } else {
            gVar.y = jSONObject.optString(com.anythink.core.common.k.ai);
        }
        if (i2 == 7) {
            c.a(SDKContext.getInstance().d()).a(gVar.r, gVar.y);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.ag)) {
            jSONObject.optInt(com.anythink.core.common.k.ag);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.aj)) {
            jSONObject.optInt(com.anythink.core.common.k.aj, -1);
        }
        SDMAdConst.CURRENCY currency = SDMAdConst.CURRENCY.RMB;
        if (!jSONObject.isNull(com.anythink.core.common.k.ak)) {
            jSONObject.optInt(com.anythink.core.common.k.ak, 0);
        }
        if (jSONObject.isNull("bid_floor")) {
            gVar.z = 0.0d;
        } else {
            gVar.z = jSONObject.optDouble("bid_floor", 0.0d);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.ap)) {
            jSONObject.optInt(com.anythink.core.common.k.ap, -1);
        }
        if (jSONObject.isNull(com.anythink.core.common.k.aq)) {
            gVar.A = gVar.m;
        } else {
            gVar.A = jSONObject.optDouble(com.anythink.core.common.k.aq, gVar.m);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.ar)) {
            jSONObject.optString(com.anythink.core.common.k.ar, i.k.b);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.as)) {
            jSONObject.optInt(com.anythink.core.common.k.as, 2);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.at)) {
            jSONObject.optInt(com.anythink.core.common.k.at);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.au)) {
            jSONObject.optInt(com.anythink.core.common.k.au, 2);
        }
        if (jSONObject.has(com.anythink.core.common.k.av)) {
            jSONObject.optString(com.anythink.core.common.k.av);
        }
        jSONObject.optLong(com.anythink.core.common.k.aw, 15000L);
        if (jSONObject.isNull(l.a.ar) || (jSONArrayOptJSONArray = jSONObject.optJSONArray(l.a.ar)) == null || jSONArrayOptJSONArray.length() <= 0) {
            iArr = null;
        } else {
            try {
                iArr = new int[jSONArrayOptJSONArray.length()];
                for (int i6 = 0; i6 < jSONArrayOptJSONArray.length(); i6++) {
                    try {
                        iArr[i6] = jSONArrayOptJSONArray.getInt(i6);
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception unused3) {
                iArr = null;
            }
        }
        gVar.B = iArr;
        gVar.C = jSONObject.optInt(com.anythink.core.common.k.ax, 1);
        gVar.D = jSONObject.optInt(com.anythink.core.common.k.ay, 1);
        if (!jSONObject.isNull(com.anythink.core.common.k.az)) {
            jSONObject.optJSONArray(com.anythink.core.common.k.az);
        }
        if (!jSONObject.isNull(com.anythink.core.common.k.aA)) {
            jSONObject.optInt(com.anythink.core.common.k.aA);
        }
        if (!jSONObject.isNull("ad_s_reqf_mode")) {
            jSONObject.optInt("ad_s_reqf_mode");
        }
        gVar.E = jSONObject.optInt("unit_type", 0);
        jSONObject.optInt(com.anythink.core.common.k.aD, 0);
        jSONObject.optInt("network_id");
        jSONObject.optInt(com.anythink.core.common.k.aF, 2);
        gVar.F = jSONObject.optDouble(com.anythink.core.common.k.aP, 0.0d);
        jSONObject.optDouble(com.anythink.core.common.k.aQ, 0.0d);
        jSONObject.optJSONObject(com.anythink.core.common.k.aR);
        gVar.G = jSONObject.optInt(com.anythink.core.common.k.aS);
        jSONObject.optInt(com.anythink.core.common.k.aT, 1);
        com.smartdigimkt.p4.c cVar = eVar.y;
        if (cVar != null) {
            com.smartdigimkt.p4.c cVar2 = new com.smartdigimkt.p4.c();
            cVar2.e = cVar.e;
            cVar2.d = cVar.d;
            cVar2.a = cVar.a;
            String strOptString2 = jSONObject.optString(com.anythink.core.common.k.aU);
            if (!TextUtils.isEmpty(strOptString2)) {
                cVar2.b = strOptString2;
            }
            String strOptString3 = jSONObject.optString(com.anythink.core.common.k.aV);
            if (!TextUtils.isEmpty(strOptString3)) {
                cVar2.f = strOptString3;
            }
            gVar.L = cVar2;
        }
        gVar.K = jSONObject.optDouble(com.anythink.core.common.k.aW, 0.0d);
        jSONObject.optInt(com.anythink.core.common.k.aX, 2);
        jSONObject.optLong(com.anythink.core.common.k.aZ, 500L);
        jSONObject.optInt(com.anythink.core.common.k.bb, 0);
        jSONObject.optLong(com.anythink.core.common.k.bc, 0L);
        jSONObject.optInt(com.anythink.core.common.k.bi);
        jSONObject.optLong(com.anythink.core.common.k.bj);
        gVar.I = jSONObject.optLong(com.anythink.core.common.k.bk);
        gVar.H = jSONObject.optDouble(com.anythink.core.common.k.bl, 0.0d);
        jSONObject.optInt(com.anythink.core.common.k.bm, 2);
        jSONObject.optInt(com.anythink.core.common.k.bn, 2);
        jSONObject.optInt(com.anythink.core.common.k.bo, 0);
        JSONObject jSONObject2 = eVar.z;
        if (jSONObject2 != null) {
            jSONObject2.optString(com.anythink.core.common.k.bp, "");
        }
        gVar.J = jSONObject.optInt(com.anythink.core.common.k.bq, 2);
        jSONObject.optInt(com.anythink.core.common.k.br, 1);
        jSONObject.optInt(com.anythink.core.common.k.bs, 2);
        return gVar;
    }
}
