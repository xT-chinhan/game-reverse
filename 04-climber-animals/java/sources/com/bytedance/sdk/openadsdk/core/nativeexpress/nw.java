package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class nw {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<String, ms> f2980ms;

    public void ms(Map<String, ms> map) {
        this.f2980ms = map;
    }

    public int ms(String str) {
        int iMs = ms(true);
        Map<String, ms> map = this.f2980ms;
        if (map != null && map.containsKey(str)) {
            ms msVar = this.f2980ms.get(str);
            iMs = msVar != null ? iMs + msVar.ms() : iMs + 5000;
        }
        return iMs + 5000;
    }

    public int xr(String str) {
        int iMs = ms(false);
        Map<String, ms> map = this.f2980ms;
        if (map != null && map.containsKey(str)) {
            ms msVar = this.f2980ms.get(str);
            iMs = msVar != null ? iMs + msVar.xr() : iMs + 5000;
        }
        return iMs + 5000;
    }

    private int ms(boolean z) {
        float fQd;
        int iVx = 0;
        if (!com.bytedance.sdk.openadsdk.core.re.xr().nq()) {
            return 0;
        }
        double d = 0.0d;
        try {
            String strMs = com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("DeviceRate", "bytebench_value");
            if (!TextUtils.isEmpty(strMs)) {
                double d2 = Double.parseDouble(strMs);
                if (d2 >= 0.0d) {
                    try {
                        if (d2 < com.bytedance.sdk.openadsdk.core.re.xr().ir()) {
                            iVx = 0 + com.bytedance.sdk.openadsdk.core.re.xr().vx();
                        }
                    } catch (NumberFormatException e) {
                        e = e;
                        d = d2;
                        com.bytedance.sdk.component.utils.sl.ms(e);
                    }
                }
                d = d2;
            }
        } catch (NumberFormatException e2) {
            e = e2;
        }
        try {
            int i = Integer.parseInt(com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("ugen_render", z ? "h5_render_success" : "native_render_success"));
            int i2 = Integer.parseInt(com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("ugen_render", z ? "h5_render_fail" : "native_render_fail"));
            int i3 = i + i2;
            float f = i3 > 0 ? (i2 / i3) * 100.0f : 0.0f;
            com.bytedance.sdk.component.utils.sl.ms("RenderTimeoutControl", "successCount: " + i + "failCount: " + i2 + " errorRate: " + f);
            if (z) {
                fQd = com.bytedance.sdk.openadsdk.core.re.xr().jr();
            } else {
                fQd = com.bytedance.sdk.openadsdk.core.re.xr().qd();
            }
            if (f >= fQd) {
                iVx += com.bytedance.sdk.openadsdk.core.re.xr().vx();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isH5", z);
            jSONObject.put("bytebenchScore", d);
            jSONObject.put("successCount", i);
            jSONObject.put("failCount", i2);
            jSONObject.put("errorRate", f);
            jSONObject.put("result", iVx);
            com.bytedance.sdk.openadsdk.core.t.u.ms().ka(jSONObject);
        } catch (NumberFormatException | JSONException e3) {
            com.bytedance.sdk.component.utils.sl.ms(e3);
        }
        return iVx;
    }

    public String toString() {
        if (this.f2980ms == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ms> entry : this.f2980ms.entrySet()) {
            ms value = entry.getValue();
            JSONArray jSONArray = new JSONArray();
            if (value != null) {
                jSONArray.put(value.ms());
                jSONArray.put(value.xr());
                try {
                    jSONObject.put(entry.getKey(), jSONArray);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        }
        return jSONObject.toString();
    }

    public static nw ah(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        nw nwVar = new nw();
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    map.put(next, new ms(jSONArrayOptJSONArray.optInt(0), jSONArrayOptJSONArray.optInt(1)));
                }
            }
            nwVar.ms(map);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return nwVar;
    }

    static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f2981ms;
        private int xr;

        public ms(int i, int i2) {
            this.f2981ms = i;
            this.xr = i2;
        }

        public ms() {
        }

        public int ms() {
            return this.f2981ms;
        }

        public int xr() {
            return this.xr;
        }
    }
}
