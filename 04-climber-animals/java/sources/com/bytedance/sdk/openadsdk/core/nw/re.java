package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class re {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public Map<String, ms> f3090ms = new HashMap();

    public re(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sub_convert_link");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    ms msVar = new ms(jSONObjectOptJSONObject.optJSONObject(next));
                    if (msVar.xr()) {
                        this.f3090ms.put(next, msVar);
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public void ms(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, ms> entry : this.f3090ms.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().ms());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private static re ms(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.go();
    }

    public static boolean ms(lm lmVar, String str) {
        re reVarMs = ms(lmVar);
        return (reVarMs == null || !reVarMs.f3090ms.containsKey(str) || TextUtils.isEmpty(ah(lmVar, str))) ? false : true;
    }

    public static int xr(lm lmVar, String str) {
        ms msVar;
        re reVarMs = ms(lmVar);
        if (reVarMs == null || (msVar = reVarMs.f3090ms.get(str)) == null) {
            return 0;
        }
        return msVar.f3091ms;
    }

    public static String ah(lm lmVar, String str) {
        ms msVar;
        re reVarMs = ms(lmVar);
        return (reVarMs == null || (msVar = reVarMs.f3090ms.get(str)) == null) ? "" : msVar.xr;
    }

    public static String d(lm lmVar, String str) {
        ms msVar;
        re reVarMs = ms(lmVar);
        return (reVarMs == null || (msVar = reVarMs.f3090ms.get(str)) == null) ? "" : msVar.ah;
    }

    public static String ka(lm lmVar, String str) {
        ms msVar;
        re reVarMs = ms(lmVar);
        return (reVarMs == null || (msVar = reVarMs.f3090ms.get(str)) == null) ? "" : msVar.d;
    }

    private static class ms {
        public String ah;
        public String d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public int f3091ms;
        public String xr;

        public ms(JSONObject jSONObject) {
            try {
                this.f3091ms = jSONObject.optInt("type");
                this.xr = jSONObject.optString("url");
                this.ah = jSONObject.optString("pid");
                this.d = jSONObject.optString("ecom_live_params");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }

        public JSONObject ms() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f3091ms);
                jSONObject.put("url", this.xr);
                jSONObject.put("pid", this.ah);
                jSONObject.put("ecom_live_params", this.d);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean xr() {
            if (3 == this.f3091ms) {
                return !TextUtils.isEmpty(this.d);
            }
            return !TextUtils.isEmpty(this.xr);
        }
    }
}
