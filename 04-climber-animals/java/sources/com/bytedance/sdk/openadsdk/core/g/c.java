package com.bytedance.sdk.openadsdk.core.g;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public boolean f2506ms = false;
    public boolean xr = true;

    public static c ms(String str) {
        c cVar = new c();
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.f2506ms = jSONObject.optBoolean("encrypt", false);
            cVar.xr = jSONObject.optBoolean("wait_io", true);
        } catch (Throwable unused) {
        }
        return cVar;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encrypt", this.f2506ms);
            jSONObject.put("wait_io", this.xr);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
