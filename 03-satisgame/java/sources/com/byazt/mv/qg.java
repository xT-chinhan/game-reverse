package com.byazt.mv;

import android.text.TextUtils;
import com.byazt.vy.sz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 701, 26})
public class qg {
    public int n;
    public final Map<String, Float> qg = new ConcurrentHashMap();
    public final Map<String, q> s = new ConcurrentHashMap();

    public qg(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null) {
            this.n = jSONObject.optInt("lt_days");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("estimate");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.qg.put(next, Float.valueOf((float) jSONObjectOptJSONObject.optDouble(next)));
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("rule_excs");
            if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() == 0) {
                return;
            }
            Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next2);
                if (jSONObjectOptJSONObject3 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("prime_rits")) != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        this.s.put(strOptString, new q(next2, strOptString, jSONObjectOptJSONObject3));
                    }
                }
            }
        }
    }

    public JSONObject n(String str, sz szVar) {
        l lVar;
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        float fN = n(str);
        q qVar = this.s.get(str);
        if (qVar != null) {
            Map<String, l> mapL = qVar.l();
            String[] strArrS = qVar.s();
            if (mapL != null && !mapL.isEmpty() && strArrS != null && strArrS.length > 0) {
                for (String str2 : strArrS) {
                    if (!TextUtils.isEmpty(str2) && (lVar = mapL.get(str2)) != null) {
                        try {
                            jSONObject.putOpt(str2, Integer.valueOf(lVar.n(fN)));
                        } catch (Exception e) {
                            com.byazt.rb.qg.q("", "calculateRangeByScore计算异常：(tableName：" + str2 + ",primeRit:" + str + "），" + e.getMessage());
                        }
                    }
                }
            }
        }
        szVar.put(MediationConstant.KEY_GM_POLICY, jSONObject);
        szVar.put("adl_scr", Float.valueOf(fN));
        com.byazt.qt.n.d().n(str, fN);
        return jSONObject;
    }

    public float n(String str) {
        q qVar = this.s.get(str);
        float fN = -1.0f;
        if (qVar != null) {
            Map<String, Float> mapQg = qVar.qg();
            String strQ = qVar.q();
            if (mapQg != null) {
                if (mapQg.containsKey("lt_x_times")) {
                    Float f = mapQg.get("lt_x_times");
                    int iQg = n.qg();
                    if (f != null) {
                        fN = n(strQ, f.floatValue() * iQg, -1.0f);
                    }
                }
                if (mapQg.containsKey("active_duration")) {
                    Float f2 = mapQg.get("active_duration");
                    long jW = n.w();
                    if (f2 != null) {
                        fN = n(strQ, f2.floatValue() * jW, fN);
                    }
                }
                if (mapQg.containsKey("active_count")) {
                    Float f3 = mapQg.get("active_count");
                    int iQ = n.q();
                    if (f3 != null) {
                        fN = n(strQ, f3.floatValue() * iQ, fN);
                    }
                }
                if (mapQg.containsKey("show_period")) {
                    Float f4 = mapQg.get("show_period");
                    long jFs = n.fs(str);
                    if (f4 != null) {
                        fN = n(strQ, f4.floatValue() * jFs, fN);
                    }
                }
                if (mapQg.containsKey("show_count")) {
                    Float f5 = mapQg.get("show_count");
                    int iQ2 = n.q(str);
                    if (f5 != null) {
                        fN = n(strQ, f5.floatValue() * iQ2, fN);
                    }
                }
                if (mapQg.containsKey("dislike_count")) {
                    Float f6 = mapQg.get("dislike_count");
                    int iQg2 = n.qg(str);
                    if (f6 != null) {
                        fN = n(strQ, f6.floatValue() * iQg2, fN);
                    }
                }
                if (mapQg.containsKey("click_count")) {
                    Float f7 = mapQg.get("click_count");
                    int iW = n.w(str);
                    if (f7 != null) {
                        fN = n(strQ, f7.floatValue() * iW, fN);
                    }
                }
                if (mapQg.containsKey("install_days")) {
                    Float f8 = mapQg.get("install_days");
                    int iL = n.l();
                    if (f8 != null) {
                        fN = n(strQ, f8.floatValue() * iL, fN);
                    }
                }
                if (!this.qg.isEmpty()) {
                    for (Map.Entry<String, Float> entry : this.qg.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            float fFloatValue = entry.getValue().floatValue();
                            Float f9 = mapQg.get(key);
                            if (f9 != null) {
                                fN = n(strQ, f9.floatValue() * fFloatValue, fN);
                            }
                        }
                    }
                }
            }
        }
        return fN;
    }

    private float n(String str, float f, float f2) {
        if (f2 == -1.0f) {
            return f;
        }
        str.hashCode();
        switch (str) {
            case "*":
                return f2 * f;
            case "+":
                return f2 + f;
            case "max":
                return Math.max(f, f2);
            case "min":
                return Math.min(f, f2);
            default:
                return f2;
        }
    }

    public int n() {
        return this.n;
    }

    public q qg(String str) {
        return this.s.get(str);
    }

    public String s(String str) {
        q qVarQg;
        if (str == null || (qVarQg = qg(str)) == null) {
            return null;
        }
        return qVarQg.n();
    }
}
