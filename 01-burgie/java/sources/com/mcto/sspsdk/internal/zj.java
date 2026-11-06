package com.mcto.sspsdk.internal;

import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zj {
    public static volatile zj a;

    public static zj a() {
        if (a != null) {
            return a;
        }
        synchronized (za.class) {
            if (a == null) {
                a = new zj();
            }
        }
        return a;
    }

    public final void a(int i, p pVar) {
        ak.a(i);
        pVar.a();
        try {
            a(i, pVar, "cupidTracking");
            a(i, pVar, "qilinTracking");
            a(i, pVar, "thirdParty");
            a(i, pVar, "adxTracking");
        } catch (Exception e) {
            r9.a("ssp_tracking", "sendTrackings: ", e);
        }
    }

    public static void a(int i, p pVar, String str, JSONObject jSONObject, h7 h7Var, String str2) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        map.put("errMsg", "url:".concat(str));
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, -1);
            if (iOptInt != -1) {
                sb.append("ec:").append(iOptInt).append(";");
            }
            String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
            if (!lj.b(strOptString)) {
                sb.append("sm:").append(gj.f(strOptString)).append(";");
            }
        }
        if (h7Var != null) {
            sb.append("hc:").append(h7Var.c).append(";");
        }
        if (!lj.b(str2)) {
            sb.append("ic:-1;im:");
            sb.append(gj.f(str2)).append(";");
        }
        map.put("extCustom", sb.toString());
        za.d().b(i, pVar, map);
    }

    public static void a(int i, String str, HashMap map) {
        String strC;
        if (lj.b(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ak.a(i));
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            jSONObjectOptJSONObject.toString();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String strValueOf = String.valueOf(itKeys.next());
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(strValueOf);
                if (jSONArrayOptJSONArray != null) {
                    int length = jSONArrayOptJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i2);
                        if (strOptString.contains("__CUPID_ETI__")) {
                            try {
                                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("extraJson");
                                if (jSONObjectOptJSONObject2 != null) {
                                    map.put(v5.KEY_EXTRA_TUNNEL_ETI, jSONObjectOptJSONObject2);
                                }
                                map.put(v5.KEY_TRACKING_EXT_INFO, jSONObject.optString("trackingExtInfo"));
                                strOptString = a(strOptString, map);
                            } catch (Exception e) {
                                e.toString();
                            }
                        }
                        if ("cupidTracking".equals(strValueOf)) {
                            strC = bk.b(strOptString);
                        } else if ("adxTracking".equals(strValueOf)) {
                            strC = bk.a(strOptString);
                        } else {
                            strC = bk.c(strOptString);
                        }
                        bg bgVar = new bg();
                        bgVar.c = TapHttp.METHOD_GET;
                        bgVar.g = new int[]{10000};
                        if (strC != null) {
                            bgVar.b = strC;
                        }
                        cg cgVar = new cg(bgVar);
                        c7 c7VarA = c7.a();
                        c7VarA.getClass();
                        ih.a.a(new b7(c7VarA, cgVar));
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static String a(String str, HashMap map) {
        String strA;
        HashMap map2 = new HashMap(8);
        y4 y4Var = y4.r;
        map2.put("otp", y4Var.m);
        map2.put("hmv", y4Var.n);
        map2.put("hmpm", Integer.valueOf(y4Var.c));
        map2.put("rak", map.get(v5.KEY_REAL_APK_NAME));
        Object obj = map.get(v5.KEY_DOWNLOAD_TYPE);
        if (obj != null) {
            map2.put("dw", obj);
            str = str + "&dw=" + obj;
        }
        map2.put("lcas", map.get(v5.KEY_INSTALL_EVENT_TYPE));
        JSONObject jSONObject = (JSONObject) map.get(v5.KEY_EXTRA_TUNNEL_ETI);
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, jSONObject.optString(next, ""));
            }
        }
        v5 v5Var = v5.KEY_AD_INSTALL_TIME;
        if (map.containsKey(v5Var)) {
            map2.put("ints", map.get(v5Var));
        }
        String str2 = (String) map.get(v5.KEY_TRACKING_EXT_INFO);
        if (str2 != null) {
            strA = str2 + gj.a((Map) map2, ";", ":", true);
        } else {
            strA = gj.a((Map) map2, ";", ":", true);
        }
        return str.replaceFirst("__CUPID_ETI__", gj.f(strA));
    }

    public final void a(int i, p pVar, String str) {
        s7 s7Var = (s7) pVar.F.get(str);
        ArrayList<String> arrayListB = s7Var != null ? s7Var.b(i, pVar) : null;
        if (arrayListB != null) {
            for (String str2 : arrayListB) {
                bg bgVar = new bg();
                bgVar.c = TapHttp.METHOD_GET;
                if (str2 != null) {
                    bgVar.b = str2;
                }
                bgVar.g = pVar.J;
                bgVar.e = new yj(this, pVar, str2, str, i);
                cg cgVar = new cg(bgVar);
                if ("thirdParty".equals(str) && !str2.contains("iqiyi")) {
                    cgVar.j = pVar.J0;
                }
                if (pVar.q0 == 1) {
                    p9.a.a(Integer.valueOf(pVar.a), "request", str2);
                }
                c7 c7VarA = c7.a();
                c7VarA.getClass();
                ih.a.a(new b7(c7VarA, cgVar));
            }
        }
    }
}
