package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class jw {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public JSONObject f3060ms;

    public String toString() {
        JSONObject jSONObject = this.f3060ms;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String ms() {
        JSONObject jSONObject = this.f3060ms;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("performance_js");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("url") : "";
    }

    public static jw ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ms(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static jw ms(JSONObject jSONObject) {
        jw jwVar = new jw();
        jwVar.f3060ms = jSONObject;
        return jwVar;
    }
}
