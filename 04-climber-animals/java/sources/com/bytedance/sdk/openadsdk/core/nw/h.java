package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile String f3055ms;
    private String ab;
    private String ah;
    private int c;
    private int d;
    private JSONObject ka;
    private boolean ny;
    private String x;
    private String xr;

    public static void ms(String str) {
        f3055ms = str;
    }

    public h() {
        this.ab = "";
        this.x = "";
    }

    public h(JSONObject jSONObject) {
        this.ab = "";
        this.x = "";
        if (jSONObject == null) {
            return;
        }
        xr(jSONObject.optString("deeplink_url"));
        ah(jSONObject.optString("fallback_url"));
        ms(jSONObject.optInt("fallback_type"));
        this.ka = jSONObject.optJSONObject("addon_params");
        this.c = jSONObject.optInt("fallback_landing");
        this.ab = jSONObject.optString("fallback_landing_ugen_url");
        this.x = jSONObject.optString("fallback_landing_ugen_md5");
    }

    public void ms(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deeplink_url", xr());
            jSONObject2.put("fallback_url", d());
            jSONObject2.put("fallback_type", ka());
            jSONObject2.put("addon_params", this.ka);
            jSONObject2.put("fallback_landing", this.c);
            jSONObject2.put("fallback_landing_ugen_url", this.ab);
            jSONObject2.put("fallback_landing_ugen_md5", this.x);
            jSONObject.put("deep_link", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public boolean ms() {
        return this.ny;
    }

    public void ms(boolean z) {
        this.ny = z;
    }

    public String xr() {
        return d(f3055ms);
    }

    public int ah() {
        return this.c;
    }

    private String d(String str) {
        if (this.ka != null && !TextUtils.isEmpty(str) && this.xr != null) {
            String strOptString = this.ka.optString(str);
            if (!TextUtils.isEmpty(strOptString)) {
                return this.xr + (this.xr.contains("?") ? "&" : "?") + strOptString;
            }
        }
        return this.xr;
    }

    public void xr(String str) {
        this.xr = str;
    }

    public String d() {
        return this.ah;
    }

    public void ah(String str) {
        this.ah = str;
    }

    public int ka() {
        return this.d;
    }

    public void ms(int i) {
        this.d = i;
    }

    public String c() {
        return this.ab;
    }

    public String ab() {
        return this.x;
    }

    public void ms(h hVar) {
        if (hVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(hVar.xr())) {
            xr(hVar.xr());
        }
        if (!TextUtils.isEmpty(hVar.d())) {
            ah(hVar.d());
        }
        if (hVar.ka() != 0) {
            ms(hVar.ka());
        }
    }
}
