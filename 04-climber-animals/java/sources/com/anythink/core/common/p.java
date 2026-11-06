package com.anythink.core.common;

import android.text.TextUtils;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.appsflyer.AppsFlyerLib;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private static volatile p c;
    private final String a = "1";
    private final String b = "2";

    private p() {
    }

    public static p a() {
        if (c == null) {
            synchronized (p.class) {
                if (c == null) {
                    c = new p();
                }
            }
        }
        return c;
    }

    public static void a(com.anythink.core.common.h.n nVar) {
        if (nVar == null) {
            return;
        }
        try {
            com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(nVar.aI());
            if (lVarA != null) {
                String strX = lVarA.X();
                if (TextUtils.isEmpty(strX)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strX);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("1");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("token");
                    if (!TextUtils.isEmpty(strOptString)) {
                        String strD = nVar.D();
                        double dL = nVar.L() / 1000.0d;
                        String strZ = nVar.z();
                        try {
                            AdjustEvent adjustEvent = new AdjustEvent(strOptString);
                            adjustEvent.setRevenue(dL, strD);
                            adjustEvent.setOrderId(strZ);
                            Adjust.trackEvent(adjustEvent);
                        } catch (Throwable unused) {
                        }
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("2");
                if (jSONObjectOptJSONObject2 != null) {
                    int iOptInt = jSONObjectOptJSONObject2.optInt("rtye");
                    HashMap map = new HashMap();
                    map.put("af_order_id", nVar.z());
                    map.put("af_content_id", nVar.aI());
                    map.put("af_content_type", nVar.aK());
                    map.put("af_revenue", Double.valueOf(iOptInt == 2 ? nVar.L() : nVar.L() / 1000.0d));
                    map.put("af_currency", com.anythink.core.common.d.j.C0079j.a);
                    AppsFlyerLib.getInstance().trackEvent(com.anythink.core.common.d.t.b().g(), "af_ad_view", map);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private static void a(String str, double d, String str2, String str3) {
        try {
            AdjustEvent adjustEvent = new AdjustEvent(str);
            adjustEvent.setRevenue(d, str2);
            adjustEvent.setOrderId(str3);
            Adjust.trackEvent(adjustEvent);
        } catch (Throwable unused) {
        }
    }
}
