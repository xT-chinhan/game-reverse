package com.smartdigimkt.b3;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || (str != null && str.trim().isEmpty());
    }

    public static int b(d dVar) {
        if (dVar != null && h.a(dVar)) {
            String strA = dVar.a();
            if (TextUtils.isEmpty(strA)) {
                return 0;
            }
            try {
                int iA = a("b_a_s", new JSONObject(strA));
                if (iA != Integer.MIN_VALUE && iA >= 1) {
                    return Math.min(600, iA);
                }
                return 0;
            } catch (JSONException e) {
                e.getMessage();
            }
        }
        return 0;
    }

    public static int c(d dVar) {
        if (dVar != null && h.a(dVar)) {
            String strA = dVar.a();
            if (a(strA)) {
                return (h.a(3, dVar) || h.a(4, dVar)) ? 5 : 0;
            }
            try {
                int iA = a("t_t_s", new JSONObject(strA.trim()));
                if (iA != Integer.MIN_VALUE && iA >= 1) {
                    return Math.min(15, iA);
                }
                return 0;
            } catch (JSONException e) {
                e.getMessage();
            }
        }
        return 0;
    }

    public static o a(d dVar) {
        o oVar = new o();
        if (dVar == null) {
            return oVar;
        }
        String strA = dVar.a();
        if (!a(strA)) {
            oVar.b = h.a(3, dVar) ? 1 : 2;
            try {
                JSONObject jSONObject = new JSONObject(strA.trim());
                int iOptInt = jSONObject.optInt("t_c_s", 3);
                oVar.a = iOptInt;
                if (iOptInt < 0) {
                    oVar.a = 3;
                }
                int iA = a("a_e_c", jSONObject);
                if (iA != Integer.MIN_VALUE) {
                    oVar.b = iA;
                }
                oVar.c = jSONObject.optInt("s_p_b", 1);
                oVar.d = jSONObject.optString("s_m_c", "");
                oVar.e = jSONObject.optString("s_r_c", "");
                oVar.f = jSONObject.optString("s_a_c", "");
            } catch (JSONException e) {
                e.getMessage();
            }
            return oVar;
        }
        if (q.a) {
            if (h.a(3, dVar)) {
                o oVar2 = new o();
                oVar2.a = 3;
                oVar2.b = 2;
                oVar2.c = 1;
                oVar2.d = "您将关闭整个激励视频广告，与双倍奖励彻底无缘";
                oVar2.e = "去意已决";
                oVar2.f = "我要奖励";
                return oVar2;
            }
            if (h.a(4, dVar)) {
                o oVar3 = new o();
                oVar3.a = 3;
                oVar3.b = 1;
                oVar3.c = 1;
                oVar3.d = "您将错失获得双倍奖励的机会";
                oVar3.e = "去意已决";
                oVar3.f = "我要奖励";
                return oVar3;
            }
        }
        oVar.b = h.a(3, dVar) ? 1 : 2;
        return oVar;
    }

    public static int a(String str, JSONObject jSONObject) {
        if (!jSONObject.has(str)) {
            return Integer.MIN_VALUE;
        }
        try {
            Object objOpt = jSONObject.opt(str);
            if (objOpt != null && objOpt != JSONObject.NULL) {
                if (objOpt instanceof Number) {
                    return ((Number) objOpt).intValue();
                }
                if (objOpt instanceof String) {
                    String strTrim = ((String) objOpt).trim();
                    if (strTrim.isEmpty()) {
                        return Integer.MIN_VALUE;
                    }
                    return Integer.parseInt(strTrim);
                }
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            e.getMessage();
            return Integer.MIN_VALUE;
        }
    }
}
