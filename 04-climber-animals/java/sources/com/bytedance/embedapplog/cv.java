package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class cv extends le {
    private final pc c;
    private final Context ka;

    cv(Context context, pc pcVar) {
        super(true, false);
        this.ka = context;
        this.c = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        jSONObject.put("os", "Android");
        jSONObject.put(bv.y, Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", zd.ah());
        jSONObject.put(bv.F, Build.BRAND);
        jSONObject.put(bv.H, Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.c.e() ? ms(this.ka) : this.c.lm());
        return true;
    }

    private static String ms(Context context) {
        String serial = null;
        if (context == null) {
            return null;
        }
        if (context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                serial = Build.getSerial();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(serial) || TextUtils.equals(serial, "unknown")) {
            serial = Build.SERIAL;
        }
        return (TextUtils.isEmpty(serial) || TextUtils.equals(serial, "unknown")) ? "" : serial;
    }
}
