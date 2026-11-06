package com.anythink.core.common;

import android.text.TextUtils;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.anythink.core.common.h.au;
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
            com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(nVar.aQ());
            if (lVarA != null) {
                String strY = lVarA.Y();
                if (TextUtils.isEmpty(strY)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strY);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("1");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(au.b.a);
                    if (!TextUtils.isEmpty(strOptString)) {
                        String strE = nVar.E();
                        double dM = nVar.M() / 1000.0d;
                        String strA = nVar.A();
                        try {
                            AdjustEvent adjustEvent = new AdjustEvent(strOptString);
                            adjustEvent.setRevenue(dM, strE);
                            adjustEvent.setOrderId(strA);
                            Adjust.trackEvent(adjustEvent);
                        } catch (Throwable unused) {
                        }
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("2");
                if (jSONObjectOptJSONObject2 != null) {
                    int iOptInt = jSONObjectOptJSONObject2.optInt("rtye");
                    HashMap map = new HashMap();
                    map.put("af_order_id", nVar.A());
                    map.put("af_content_id", nVar.aQ());
                    map.put("af_content_type", nVar.aS());
                    map.put("af_revenue", Double.valueOf(iOptInt == 2 ? nVar.M() : nVar.M() / 1000.0d));
                    map.put("af_currency", com.anythink.core.common.d.i.k.a);
                    AppsFlyerLib.getInstance().trackEvent(com.anythink.core.common.d.s.b().g(), "af_ad_view", map);
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
