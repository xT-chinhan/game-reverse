package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
final class mh {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final SharedPreferences f503ms;

    mh(Context context) {
        this.f503ms = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context, "device_register_oaid_refine", 0);
    }

    void ms(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f503ms.edit().putString("oaid", aVar.xr().toString()).apply();
    }

    a ms() {
        return a.ms(this.f503ms.getString("oaid", ""));
    }
}
