package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f2754ms = null;
    private static long xr = -1;

    public static JSONArray ms(final Context context) {
        if (System.currentTimeMillis() - xr <= 1000) {
            return null;
        }
        xr = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.g.x.c() || !xr() || !com.bytedance.sdk.openadsdk.core.re.xr().ph() || !com.bytedance.sdk.openadsdk.core.ch.ub().ao().xr()) {
            return null;
        }
        com.bytedance.sdk.component.ch.ab.ms(new com.bytedance.sdk.component.ch.ny("getIncrementalInstallApps") { // from class: com.bytedance.sdk.openadsdk.core.jw.y.1
            @Override // java.lang.Runnable
            public void run() {
                y.ah(context);
            }
        }, 1);
        return ms();
    }

    private static JSONArray ms() {
        try {
            String strXr = com.bytedance.sdk.openadsdk.core.xr.ms().xr("install_app_incremental_string", f2754ms);
            if (TextUtils.isEmpty(strXr)) {
                return null;
            }
            return new JSONArray((Collection) d(strXr));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(Context context) {
        try {
            List<String> listMs = com.bytedance.sdk.openadsdk.core.g.ah.ah().ms(context);
            if (listMs != null && !listMs.isEmpty()) {
                List<String> listD = d(com.bytedance.sdk.openadsdk.core.xr.ms().xr("install_app_string", f2754ms));
                xr(ms(listMs));
                if (listD != null && !listD.isEmpty()) {
                    listMs.removeAll(listD);
                }
                ah(ms(listMs));
            }
        } catch (Exception unused) {
        }
    }

    private static void xr(String str) {
        com.bytedance.sdk.openadsdk.core.xr.ms().ms("install_app_string", str);
    }

    private static void ah(String str) {
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        xrVarMs.ms("install_app_incremental_string", str);
        xrVarMs.ms("apptime", System.currentTimeMillis());
    }

    private static boolean xr() {
        long jXr = com.bytedance.sdk.openadsdk.core.xr.ms().xr("apptime", -1L);
        return jXr == -1 || System.currentTimeMillis() - jXr > 43200000;
    }

    private static List<String> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    private static String ms(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            ms(0, 0, null);
            return false;
        }
        if (f.xr(com.bytedance.sdk.openadsdk.core.re.getContext()) && !f.ah(com.bytedance.sdk.openadsdk.core.re.getContext(), str)) {
            ms(0, 0, null);
        }
        return false;
    }

    private static void ms(final int i, final int i2, final String str) {
        com.bytedance.sdk.openadsdk.core.t.xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.y.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("call_api_status", i);
                    jSONObject.put("has_actived", i2);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("error_msg", str);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("call_active_api").xr(jSONObject.toString());
            }
        }, "call_active_api", true);
    }
}
