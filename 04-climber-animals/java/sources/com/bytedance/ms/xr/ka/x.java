package com.bytedance.ms.xr.ka;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SharedPreferences f580ms;

    public x(Context context) {
        this.f580ms = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context, "npth", 0);
    }

    public void ms(String str) {
        this.f580ms.edit().putString("device_id", str).apply();
    }

    public String ms() {
        String strKa = com.bytedance.ms.xr.x.ms().ka();
        return (TextUtils.isEmpty(strKa) || "0".equals(strKa)) ? this.f580ms.getString("device_id", "0") : strKa;
    }
}
