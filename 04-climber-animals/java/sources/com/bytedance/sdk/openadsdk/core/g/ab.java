package com.bytedance.sdk.openadsdk.core.g;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public boolean f2501ms = false;
    public boolean xr = false;
    public boolean ah = false;
    public boolean d = false;
    private boolean ka = false;

    public static ab ms(String str) {
        ab abVar = new ab();
        if (TextUtils.isEmpty(str)) {
            return abVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            abVar.f2501ms = jSONObject.optBoolean("use_csj_main", false);
            abVar.xr = jSONObject.optBoolean("use_layze_layout", false);
            abVar.ah = jSONObject.optBoolean("create_ad_in_io", false);
            abVar.d = jSONObject.optBoolean("opt_panel_view", false);
            boolean zOptBoolean = jSONObject.optBoolean("so_lock", false);
            abVar.ka = zOptBoolean;
            if (zOptBoolean) {
                com.bytedance.sdk.openadsdk.op.c.ms().mkdirs();
            }
        } catch (Throwable unused) {
        }
        return abVar;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("use_csj_main", this.f2501ms);
            jSONObject.put("use_layze_layout", this.xr);
            jSONObject.put("create_ad_in_io", this.ah);
            jSONObject.put("opt_panel_view", this.d);
            jSONObject.put("so_lock", this.ka);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
