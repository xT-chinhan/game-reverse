package com.bytedance.sdk.openadsdk.core.hi.ah.xr;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public String ah;
    public JSONObject d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public lm f2623ms;
    public String xr;

    public static ms ms() {
        return new ms();
    }

    public static ms ms(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject;
        lm lmVarMs = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            strOptString = jSONObject.optString(TTDownloadField.TT_TAG, null);
            try {
                strOptString2 = jSONObject.optString(TTDownloadField.TT_LABEL, null);
                try {
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
                    try {
                        lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONObjectOptJSONObject = null;
                }
            } catch (Exception unused3) {
                strOptString2 = null;
                jSONObjectOptJSONObject = strOptString2;
            }
        } catch (Exception unused4) {
            strOptString = null;
            strOptString2 = null;
        }
        return ms().ms(strOptString).xr(strOptString2).xr(jSONObjectOptJSONObject).ms(lmVarMs);
    }

    public ms ms(lm lmVar) {
        this.f2623ms = lmVar;
        return this;
    }

    public ms ms(String str) {
        this.xr = str;
        return this;
    }

    public ms xr(String str) {
        this.ah = str;
        return this;
    }

    public ms xr(JSONObject jSONObject) {
        this.d = jSONObject;
        return this;
    }

    public JSONObject xr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TTDownloadField.TT_TAG, this.xr);
            jSONObject.put(TTDownloadField.TT_LABEL, this.ah);
            JSONObject jSONObject2 = this.d;
            if (jSONObject2 != null) {
                jSONObject.put("extra", jSONObject2);
            }
            lm lmVar = this.f2623ms;
            if (lmVar != null) {
                jSONObject.put("material_meta", lmVar.rm());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
