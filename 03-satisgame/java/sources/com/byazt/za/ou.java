package com.byazt.za;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 849})
public class ou {
    public Map<String, n> n;
    public String qg;

    public ou(String str) {
        this.qg = str;
    }

    public void n(Map<String, n> map) {
        this.n = map;
    }

    public int n(String str) {
        int iN = n(true);
        Map<String, n> map = this.n;
        if (map != null && map.containsKey(str)) {
            n nVar = this.n.get(str);
            iN = nVar != null ? iN + nVar.n() : iN + 5000;
        }
        return iN + 5000;
    }

    public int qg(String str) {
        int iN = n(false);
        Map<String, n> map = this.n;
        if (map != null && map.containsKey(str)) {
            n nVar = this.n.get(str);
            iN = nVar != null ? iN + nVar.qg() : iN + 5000;
        }
        return iN + 5000;
    }

    private int n(boolean z) {
        float fOv;
        int iJo = 0;
        if (!com.byazt.nf.rv.qg().om()) {
            return 0;
        }
        double d = 0.0d;
        try {
            String strN = com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", this.qg);
            if (!TextUtils.isEmpty(strN)) {
                double d2 = Double.parseDouble(strN);
                if (d2 >= 0.0d) {
                    try {
                        if (d2 < com.byazt.nf.rv.qg().pp()) {
                            iJo = 0 + com.byazt.nf.rv.qg().jo();
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                d = d2;
            }
        } catch (NumberFormatException unused2) {
        }
        try {
            int i = Integer.parseInt(com.byazt.gh.n.n().n("ugen_render", z ? "h5_render_success" : "native_render_success", this.qg));
            int i2 = Integer.parseInt(com.byazt.gh.n.n().n("ugen_render", z ? "h5_render_fail" : "native_render_fail", this.qg));
            int i3 = i + i2;
            float f = i3 > 0 ? (i2 / i3) * 100.0f : 0.0f;
            if (z) {
                fOv = com.byazt.nf.rv.qg().db();
            } else {
                fOv = com.byazt.nf.rv.qg().ov();
            }
            if (f >= fOv) {
                iJo += com.byazt.nf.rv.qg().jo();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isH5", z);
            jSONObject.put("bytebenchScore", d);
            jSONObject.put("successCount", i);
            jSONObject.put("failCount", i2);
            jSONObject.put("errorRate", f);
            jSONObject.put("result", iJo);
            com.byazt.eji.s.n().tj(jSONObject);
        } catch (NumberFormatException | JSONException unused3) {
        }
        return iJo;
    }

    public String toString() {
        if (this.n == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, n> entry : this.n.entrySet()) {
            n value = entry.getValue();
            JSONArray jSONArray = new JSONArray();
            if (value != null) {
                jSONArray.put(value.n());
                jSONArray.put(value.qg());
                try {
                    jSONObject.put(entry.getKey(), jSONArray);
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject.toString();
    }

    public static ou n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ou ouVar = new ou(str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    map.put(next, new n(jSONArrayOptJSONArray.optInt(0), jSONArrayOptJSONArray.optInt(1)));
                }
            }
            ouVar.n(map);
        } catch (JSONException unused) {
        }
        return ouVar;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 946})
    static class n {
        public int n;
        public int qg;

        public n(int i, int i2) {
            this.n = i;
            this.qg = i2;
        }

        public n() {
        }

        public int n() {
            return this.n;
        }

        public int qg() {
            return this.qg;
        }
    }
}
