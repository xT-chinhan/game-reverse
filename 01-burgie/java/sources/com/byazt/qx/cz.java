package com.byazt.qx;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 213})
public class cz {
    public String hw;
    public Map<String, pr> pr;

    public cz(String str) {
        this.hw = str;
    }

    public void pr(Map<String, pr> map) {
        this.pr = map;
    }

    public int pr(String str) {
        int iPr = pr(true);
        Map<String, pr> map = this.pr;
        if (map != null && map.containsKey(str)) {
            pr prVar = this.pr.get(str);
            iPr = prVar != null ? iPr + prVar.pr() : iPr + 5000;
        }
        return iPr + 5000;
    }

    public int hw(String str) {
        int iPr = pr(false);
        Map<String, pr> map = this.pr;
        if (map != null && map.containsKey(str)) {
            pr prVar = this.pr.get(str);
            iPr = prVar != null ? iPr + prVar.hw() : iPr + 5000;
        }
        return iPr + 5000;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0049  */
    private int pr(boolean z) {
        float fGx;
        int iIq = 0;
        if (!com.byazt.sd.a.hw().mx()) {
            return 0;
        }
        double d = 0.0d;
        try {
            String strPr = com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", this.hw);
            if (!TextUtils.isEmpty(strPr)) {
                double d2 = Double.parseDouble(strPr);
                if (d2 >= 0.0d) {
                    try {
                        if (d2 < com.byazt.sd.a.hw().df()) {
                            iIq = 0 + com.byazt.sd.a.hw().iq();
                            d = d2;
                        } else {
                            d = d2;
                        }
                    } catch (NumberFormatException e) {
                        d = d2;
                    }
                } else {
                    d = d2;
                }
            }
        } catch (NumberFormatException e2) {
        }
        try {
            int i = Integer.parseInt(com.byazt.ba.pr.pr().pr("ugen_render", z ? "h5_render_success" : "native_render_success", this.hw));
            int i2 = Integer.parseInt(com.byazt.ba.pr.pr().pr("ugen_render", z ? "h5_render_fail" : "native_render_fail", this.hw));
            float f = 0.0f;
            int i3 = i + i2;
            if (i3 > 0) {
                f = (i2 / i3) * 100.0f;
            }
            if (z) {
                fGx = com.byazt.sd.a.hw().de();
            } else {
                fGx = com.byazt.sd.a.hw().gx();
            }
            if (f >= fGx) {
                iIq += com.byazt.sd.a.hw().iq();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isH5", z);
            jSONObject.put("bytebenchScore", d);
            jSONObject.put("successCount", i);
            jSONObject.put("failCount", i2);
            jSONObject.put("errorRate", f);
            jSONObject.put("result", iIq);
            com.byazt.xk.hw.pr().aj(jSONObject);
        } catch (NumberFormatException e3) {
        } catch (JSONException e4) {
        }
        return iIq;
    }

    public String toString() {
        if (this.pr == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, pr> entry : this.pr.entrySet()) {
            pr value = entry.getValue();
            JSONArray jSONArray = new JSONArray();
            if (value != null) {
                jSONArray.put(value.pr());
                jSONArray.put(value.hw());
                try {
                    jSONObject.put(entry.getKey(), jSONArray);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject.toString();
    }

    public static cz pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        cz czVar = new cz(str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    map.put(next, new pr(jSONArrayOptJSONArray.optInt(0), jSONArrayOptJSONArray.optInt(1)));
                }
            }
            czVar.pr(map);
        } catch (JSONException e) {
        }
        return czVar;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 49, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE})
    static class pr {
        public int hw;
        public int pr;

        public pr(int i, int i2) {
            this.pr = i;
            this.hw = i2;
        }

        public pr() {
        }

        public int pr() {
            return this.pr;
        }

        public int hw() {
            return this.hw;
        }
    }
}
