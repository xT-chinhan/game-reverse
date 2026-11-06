package com.bytedance.sdk.openadsdk.core.dislike;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.re;
import com.umeng.analytics.pro.cl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private String ah;
    private com.bytedance.sdk.openadsdk.core.dislike.ah.ah d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f2495ms;
    private String xr;

    public static xr ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ms(new JSONObject(str));
        } catch (JSONException e) {
            sl.xr("OncallUploadConfig", "parse failed:".concat(String.valueOf(e)));
            return null;
        }
    }

    public static xr ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xr xrVar = new xr();
        xrVar.f2495ms = jSONObject.optBoolean(cl.q);
        xrVar.xr = jSONObject.optString("upload_api");
        xrVar.ah = jSONObject.optString("alert_text");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("filter_word");
        if (jSONObjectOptJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.dislike.ah.ah ahVarMs = com.bytedance.sdk.openadsdk.core.dislike.ah.ah.ms(jSONObjectOptJSONObject);
            if (ahVarMs != null) {
                if (TextUtils.isEmpty(ahVarMs.ms())) {
                    ahVarMs.ms("99:1");
                }
                if (TextUtils.isEmpty(ahVarMs.xr())) {
                    ahVarMs.xr("素材反馈");
                }
            }
            xrVar.d = ahVarMs;
        }
        return xrVar;
    }

    public static com.bytedance.sdk.openadsdk.core.dislike.ah.ah ms() {
        xr xrVarJy = re.xr().jy();
        if (xrVarJy != null) {
            return xrVarJy.ka();
        }
        return null;
    }

    public boolean xr() {
        return this.f2495ms;
    }

    public String ah() {
        return this.xr;
    }

    public String d() {
        return this.ah;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.ah.ah ka() {
        return this.d;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(cl.q, Boolean.valueOf(this.f2495ms));
            jSONObject.putOpt("upload_api", this.xr);
            jSONObject.putOpt("alert_text", this.ah);
            com.bytedance.sdk.openadsdk.core.dislike.ah.ah ahVar = this.d;
            if (ahVar != null) {
                jSONObject.putOpt("filter_word", ahVar.ab());
            }
        } catch (JSONException e) {
            sl.xr("OncallUploadConfig", e);
        }
        return jSONObject.toString();
    }
}
