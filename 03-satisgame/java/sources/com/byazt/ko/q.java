package com.byazt.ko;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 5})
public class q extends s {
    public final Context l;
    public final fs w;

    public q(Context context, fs fsVar) {
        super(true, false);
        this.l = context;
        this.w = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException, SecurityException {
        jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, com.byazt.km.n.l());
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", com.byazt.km.n.w());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.w.dg() ? n(this.l) : this.w.oj());
        return true;
    }

    private static String n(Context context) {
        String serial = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
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
