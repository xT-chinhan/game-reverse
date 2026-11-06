package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile boolean ah = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile String f2674ms = "";
    private static volatile String xr = "";

    public static void ms(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ah = true;
            f2674ms = str;
            com.bytedance.sdk.openadsdk.tools.xr.xr(7, f2674ms == null ? "" : f2674ms);
            update();
        } catch (Throwable unused) {
        }
    }

    public static void ms(com.bytedance.sdk.openadsdk.ub.d dVar) {
        com.bytedance.sdk.openadsdk.ms.ms.ms.ms(dVar);
        com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(dVar);
    }

    public static String xr(com.bytedance.sdk.openadsdk.ub.d dVar) {
        JSONObject jSONObjectMs;
        if (dVar != null) {
            String type = dVar.getType();
            if (TextUtils.equals(type, "error")) {
                return "error";
            }
            if (TextUtils.equals(type, "timeout")) {
                return "timeout";
            }
            com.bytedance.embedapplog.ka.ms msVarMs = dVar.ms();
            if (msVarMs != null && !TextUtils.isEmpty(msVarMs.f497ms) && (jSONObjectMs = ms(msVarMs)) != null) {
                return jSONObjectMs.toString();
            }
        }
        return "error";
    }

    public static String ah(com.bytedance.sdk.openadsdk.ub.d dVar) {
        if (dVar == null) {
            return null;
        }
        String type = dVar.getType();
        if (TextUtils.equals(type, "error")) {
            return "error";
        }
        if (TextUtils.equals(type, "timeout")) {
            return "timeout";
        }
        com.bytedance.embedapplog.ka.ms msVarMs = dVar.ms();
        return (msVarMs == null || TextUtils.isEmpty(msVarMs.f497ms)) ? "error" : msVarMs.f497ms;
    }

    private static JSONObject ms(com.bytedance.embedapplog.ka.ms msVar) {
        if (msVar == null) {
            return null;
        }
        String str = msVar.f497ms;
        long j = msVar.ah;
        boolean z = msVar.xr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.valueOf(z));
            jSONObject.putOpt("hWIdVersionCode", Long.valueOf(j));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "error";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.FALSE);
            jSONObject.putOpt("hWIdVersionCode", Integer.valueOf(ms(com.bytedance.sdk.openadsdk.core.re.getContext())));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    public static com.bytedance.embedapplog.ka.ms ah(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.bytedance.embedapplog.ka.ms(str, false, ms(com.bytedance.sdk.openadsdk.core.re.getContext()));
    }

    private static int ms(Context context) {
        String str = "com.huawei.hwid.tv";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                str = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                str = "com.huawei.hms";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return 0;
        }
    }

    public static String ms(boolean z) {
        long j;
        if (!TextUtils.isEmpty(f2674ms)) {
            return f2674ms;
        }
        if (z && !TextUtils.isEmpty(xr)) {
            return xr;
        }
        try {
            String strAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("new_app_log_oaid", (String) null);
            if (TextUtils.isEmpty(strAh)) {
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strAh);
                xr = com.bytedance.sdk.component.utils.ms.ah(jSONObject.getString(com.anythink.core.common.e.f.a.d));
                j = jSONObject.getLong("time");
            }
            if (!TextUtils.isEmpty(xr) && (z || System.currentTimeMillis() - j < 86400000)) {
                return xr;
            }
            if (!ah) {
                com.bytedance.sdk.openadsdk.core.c.ms().xr();
                com.bytedance.sdk.openadsdk.core.f.ka kaVarQv = com.bytedance.sdk.openadsdk.core.ch.ub().qv();
                if (kaVarQv != null && !TextUtils.isEmpty(kaVarQv.hi())) {
                    f2674ms = kaVarQv.hi();
                    update();
                }
                com.bytedance.sdk.openadsdk.tools.xr.xr(7, f2674ms == null ? "" : f2674ms);
            }
            if (TextUtils.isEmpty(f2674ms) && !TextUtils.isEmpty(xr) && com.bytedance.sdk.openadsdk.core.ch.ub().ny()) {
                return xr;
            }
            return f2674ms == null ? "" : f2674ms;
        } catch (Exception unused) {
        }
    }

    private static void update() {
        if (TextUtils.isEmpty(f2674ms)) {
            return;
        }
        String strXr = com.bytedance.sdk.component.utils.ms.xr(f2674ms);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().d("app_log_oaid", f2674ms);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().d("new_app_log_oaid", strXr);
    }
}
