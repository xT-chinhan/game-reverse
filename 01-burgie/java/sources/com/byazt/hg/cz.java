package com.byazt.hg;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 213})
public class cz {
    public Map<String, pr> pr = new HashMap();

    public cz(JSONObject jSONObject, boolean z) {
        if (z) {
            try {
                jSONObject = jSONObject.optJSONObject("sub_convert_link");
            } catch (Exception e) {
                return;
            }
        }
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                pr prVar = new pr(jSONObject.optJSONObject(next));
                if (prVar.hw()) {
                    this.pr.put(next, prVar);
                }
            }
        }
    }

    public void pr(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, pr> entry : this.pr.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().pr());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception e) {
        }
    }

    private static cz pr(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.m();
    }

    public static boolean pr(cz czVar, String str) {
        return (czVar == null || !czVar.pr.containsKey(str) || TextUtils.isEmpty(hn(czVar, str))) ? false : true;
    }

    public static int hw(cz czVar, String str) {
        pr prVar;
        if (czVar == null || (prVar = czVar.pr.get(str)) == null) {
            return 0;
        }
        return prVar.pr;
    }

    public static String hn(cz czVar, String str) {
        pr prVar;
        if (czVar == null || (prVar = czVar.pr.get(str)) == null) {
            return "";
        }
        return prVar.hw;
    }

    public static JSONObject x(cz czVar, String str) {
        pr prVar;
        if (czVar == null || (prVar = czVar.pr.get(str)) == null) {
            return null;
        }
        return prVar.pr();
    }

    public static String pr(of ofVar, String str) {
        pr prVar;
        cz czVarPr = pr(ofVar);
        if (czVarPr == null || (prVar = czVarPr.pr.get(str)) == null) {
            return "";
        }
        return prVar.hn;
    }

    public static String c(cz czVar, String str) {
        pr prVar;
        if (czVar == null || (prVar = czVar.pr.get(str)) == null) {
            return "";
        }
        return prVar.x;
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE})
    private static class pr {
        public String hn;
        public String hw;
        public int pr;
        public String x;

        public pr(JSONObject jSONObject) {
            try {
                this.pr = jSONObject.optInt("type");
                this.hw = jSONObject.optString(BreakpointSQLiteKey.URL);
                this.hn = jSONObject.optString("pid");
                this.x = jSONObject.optString("ecom_live_params");
            } catch (Exception e) {
            }
        }

        public JSONObject pr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.pr);
                jSONObject.put(BreakpointSQLiteKey.URL, this.hw);
                jSONObject.put("pid", this.hn);
                jSONObject.put("ecom_live_params", this.x);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean hw() {
            if (3 == this.pr) {
                return !TextUtils.isEmpty(this.x);
            }
            return !TextUtils.isEmpty(this.hw);
        }
    }
}
