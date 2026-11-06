package com.anythink.core.b.d;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static void a(JSONObject jSONObject, String str, bv bvVar, com.anythink.core.common.h.a aVar) {
        if (jSONObject != null) {
            try {
                if (bvVar.ae() == -1) {
                    jSONObject.put("ad_format", str);
                } else {
                    jSONObject.put("ad_format", String.valueOf(bvVar.ae()));
                }
                jSONObject.put("ad_source_id", bvVar.z());
                jSONObject.put("nw_firm_id", bvVar.g());
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BIDDING_FLOOR, a(aVar, bvVar));
                if (t.b().y()) {
                    jSONObject.put("test", 1);
                }
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.P_BIDFLOOR, bvVar.ak());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static double a(com.anythink.core.common.h.a aVar, bv bvVar) {
        double dDoubleValue = 0.0d;
        if (aVar.t == 8) {
            Double d = aVar.u != null ? aVar.u.get(bvVar.z()) : null;
            if (d != null) {
                dDoubleValue = d.doubleValue();
                bvVar.d(dDoubleValue);
            }
            bvVar.z();
            return dDoubleValue;
        }
        double dAr = bvVar.ar();
        if (aVar.C > 0.0d && bvVar.aS() == 1) {
            double dMax = Math.max(dAr, aVar.C);
            bvVar.d(dMax);
            new StringBuilder("BiddingRequestParamsUtil curMaxCachePrice: ").append(aVar.C).append(", origin bid floor: ").append(dAr).append(", reset bid floor to : ").append(dMax).append(", placementId: ").append(aVar.e).append(", ").append(bvVar);
            return dMax;
        }
        new StringBuilder("BiddingRequestParamsUtil curMaxCachePrice: ").append(aVar.C).append(", origin bid floor: ").append(dAr).append(", no need to reset bid floor, placementId: ").append(aVar.e).append(", ").append(bvVar);
        return dAr;
    }
}
