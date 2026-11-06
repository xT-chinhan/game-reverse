package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import com.umeng.analytics.pro.cl;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private static ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ms f3110ms;
    private static ms xr;

    public static void ms(com.bytedance.sdk.component.d.ms.xr xrVar) {
        try {
            f3110ms = new ms(new JSONObject(xrVar.xr("cache_strategy_reward", "")));
        } catch (JSONException unused) {
        }
        try {
            xr = new ms(new JSONObject(xrVar.xr("cache_strategy_full", "")));
        } catch (JSONException unused2) {
        }
    }

    public static void xr(com.bytedance.sdk.component.d.ms.xr xrVar) {
        ms msVar = f3110ms;
        if (msVar != null) {
            xrVar.ms("cache_strategy_reward", msVar.ms());
        }
        ms msVar2 = xr;
        if (msVar2 != null) {
            xrVar.ms("cache_strategy_full", msVar2.ms());
        }
        if (ah != null) {
            com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("cache_strategy_splash", ah.ms());
        }
    }

    public static ms ms() {
        ms msVar = f3110ms;
        return msVar == null ? new ms(new JSONObject()) : msVar;
    }

    public static ms xr() {
        ms msVar = xr;
        return msVar == null ? new ms(new JSONObject()) : msVar;
    }

    public static ms ah() {
        if (ah == null) {
            String strAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("cache_strategy_splash", (String) null);
            try {
                if (TextUtils.isEmpty(strAh)) {
                    ms msVar = new ms(new JSONObject());
                    ah = msVar;
                    msVar.d = 0;
                } else {
                    ah = new ms(new JSONObject(strAh));
                }
            } catch (JSONException unused) {
            }
        }
        return ah;
    }

    public static void ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_reward");
            if (jSONObjectOptJSONObject2 != null) {
                f3110ms = new ms(jSONObjectOptJSONObject2);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_full");
            if (jSONObjectOptJSONObject3 != null) {
                xr = new ms(jSONObjectOptJSONObject3);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_splash");
            if (jSONObjectOptJSONObject3 != null) {
                ah = new ms(jSONObjectOptJSONObject4);
            }
        }
    }

    public static class ms {
        private int ab;
        private int ah;
        private boolean c;
        private int ch;
        private int d;
        private boolean hi;
        private int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f3111ms;
        private xr ny;
        private int x;
        private int xr;

        public ms(JSONObject jSONObject) {
            this.hi = false;
            if (jSONObject != null) {
                this.f3111ms = jSONObject.optInt("get_type", 1);
                this.xr = jSONObject.optInt("max_count", 1);
                this.ah = jSONObject.optInt("strategy_type", -1);
                this.d = jSONObject.optInt("store_type", 1);
                this.ka = jSONObject.optInt("online_timeout", 10000);
                this.c = jSONObject.optBoolean(cl.q, false);
                this.ab = jSONObject.optInt("load_type", -1);
                this.x = jSONObject.optInt("trans_cache", 0);
                this.ny = new xr(jSONObject.optJSONObject("score_config"));
                this.ch = jSONObject.optInt("cache_check_type", 0);
                this.hi = jSONObject.optBoolean("disable_sdk_bidding", false);
            }
        }

        public String ms() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_type", this.f3111ms);
                jSONObject.put("max_count", this.xr);
                jSONObject.put("strategy_type", this.ah);
                jSONObject.put("store_type", this.d);
                jSONObject.put("online_timeout", this.ka);
                jSONObject.put(cl.q, this.c);
                jSONObject.put("load_type", this.ab);
                jSONObject.put("trans_cache", this.x);
                jSONObject.put("cache_check_type", this.ch);
                jSONObject.put("score_config", this.ny.ms());
                jSONObject.put("disable_sdk_bidding", this.hi);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public int xr() {
            return this.f3111ms;
        }

        public int ah() {
            if (this.xr <= 0) {
                this.xr = 1;
            }
            return this.xr;
        }

        public int d() {
            return this.ah;
        }

        public int ka() {
            return this.d;
        }

        public int c() {
            return this.ka;
        }

        public boolean ab() {
            return this.c;
        }

        public int x() {
            return this.ab;
        }

        public int ny() {
            return this.x;
        }

        public int ch() {
            return this.ch;
        }

        public xr hi() {
            return this.ny;
        }

        public boolean ms(lm lmVar) {
            Map<String, Object> mapOu;
            Object obj;
            return (!this.hi || lmVar == null || (mapOu = lmVar.ou()) == null || mapOu.isEmpty() || (obj = mapOu.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) ? false : true;
        }
    }

    public static class xr {
        private int ab;
        private int ah;
        private LinkedHashMap<Integer, Integer> c;
        private int ch;
        private int d;
        private int hi;
        private int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f3112ms;
        private int ny;
        private int x;
        private int xr;

        public xr(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f3112ms = jSONObject.optInt("device_score_threshold", 0);
                this.xr = jSONObject.optInt("net_type_threshold", 0);
                this.ah = jSONObject.optInt("base_score", 60);
                this.d = jSONObject.optInt("score_threshold", 60);
                this.ka = jSONObject.optInt("backup_score_threshold", 0);
                LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("last_cache_score");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        int iOptInt = jSONArrayOptJSONArray2.optInt(0);
                        int iOptInt2 = jSONArrayOptJSONArray2.optInt(1);
                        if (iOptInt > 0) {
                            linkedHashMap.put(Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2));
                        }
                    }
                }
                this.c = linkedHashMap;
                this.ab = jSONObject.optInt("freq_send_score", 0);
                this.x = jSONObject.optInt("freq_send_duration", 0);
                this.ny = jSONObject.optInt("continuous_send_score", 0);
                this.ch = jSONObject.optInt("continuous_send_count", 0);
                this.hi = jSONObject.optInt("show_score", 0);
            }
        }

        public JSONObject ms() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score_threshold", this.f3112ms);
                jSONObject.put("net_type_threshold", this.xr);
                jSONObject.put("base_score", this.ah);
                jSONObject.put("score_threshold", this.d);
                jSONObject.put("backup_score_threshold", this.ka);
                JSONArray jSONArray = new JSONArray();
                LinkedHashMap<Integer, Integer> linkedHashMap = this.c;
                if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                    for (Integer num : this.c.keySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(num);
                        jSONArray2.put(this.c.get(num));
                        jSONArray.put(jSONArray2);
                    }
                }
                jSONObject.put("last_cache_score", jSONArray);
                jSONObject.put("freq_send_score", this.ab);
                jSONObject.put("freq_send_duration", this.x);
                jSONObject.put("continuous_send_score", this.ny);
                jSONObject.put("continuous_send_count", this.ch);
                jSONObject.put("show_score", this.hi);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int xr() {
            return this.f3112ms;
        }

        public int ah() {
            return this.xr;
        }

        public int d() {
            return this.d;
        }

        public int ka() {
            return this.ka;
        }

        public int c() {
            return this.x;
        }

        public int ab() {
            return this.ab;
        }

        public int x() {
            return this.ch;
        }

        public int ny() {
            return this.ny;
        }

        public int ch() {
            return this.hi;
        }

        public int hi() {
            return this.ah;
        }

        public LinkedHashMap<Integer, Integer> sl() {
            return this.c;
        }
    }
}
