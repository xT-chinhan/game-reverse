package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    public String ah;
    public String d;
    public String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f4589ms;
    public int xr = -1;

    public String ms() {
        return xr().toString();
    }

    public JSONObject xr() {
        JSONObject jSONObject = new JSONObject();
        ms(jSONObject);
        return jSONObject;
    }

    public void ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f4589ms);
            jSONObject.put("error_code", String.valueOf(this.xr));
            jSONObject.put("error_msg", this.ah);
            jSONObject.put("real_device_plan", this.d);
            jSONObject.put("device_plans", this.ka);
        } catch (Throwable unused) {
        }
    }

    public static ms ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ms msVar = new ms();
        try {
            JSONObject jSONObject = new JSONObject(str);
            msVar.ka = jSONObject.optString("device_plans", null);
            msVar.d = jSONObject.optString("real_device_plan", null);
            msVar.ah = jSONObject.optString("error_msg", null);
            msVar.f4589ms = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(strOptString)) {
                msVar.xr = -1;
            } else {
                msVar.xr = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        return msVar;
    }
}
