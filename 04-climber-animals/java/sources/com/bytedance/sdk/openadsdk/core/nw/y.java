package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class y {
    private static int ah;
    private static JSONObject d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f3116ms;
    private static int xr;

    public static void ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config")) == null) {
            return;
        }
        xr(jSONObjectOptJSONObject.optJSONObject("dex_strategy"));
    }

    private static void xr(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        f3116ms = jSONObject.optInt("use_dex_load_gdt");
        xr = jSONObject.optInt("use_dex_load_ks");
        ah = jSONObject.optInt("use_dex_load_xiaomi");
        d = jSONObject;
    }

    public static void ms(com.bytedance.sdk.component.d.ms.xr xrVar) {
        JSONObject jSONObject;
        if (xrVar == null || (jSONObject = d) == null) {
            return;
        }
        xrVar.ms("dex_strategy", jSONObject.toString());
    }

    public static void xr(com.bytedance.sdk.component.d.ms.xr xrVar) {
        if (xrVar != null) {
            try {
                xr(new JSONObject(xrVar.xr("dex_strategy", "")));
            } catch (JSONException unused) {
            }
        }
    }
}
