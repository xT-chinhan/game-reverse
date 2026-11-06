package com.bytedance.ms.ms;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bytedance.ms.xr.ab.ka;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.ch;
import com.tapsdk.tapad.internal.tracker.experiment.a;
import com.umeng.analytics.pro.bv;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static volatile JSONObject f545ms;

    public static void ms(xr xrVar) {
        Map<String, Object> mapMs = x.ms().ms();
        if (mapMs == null && mapMs.get("aid") == null) {
            return;
        }
        try {
            byte[] bytes = ms(mapMs).toString().getBytes("UTF-8");
            StringBuilder sb = new StringBuilder(com.bytedance.ms.xr.ab.xr.xr(mapMs));
            sb.append("?device_platform=android&version_code=137&iid=iid&aid=").append(mapMs.get("aid"));
            com.bytedance.ms.xr.ab.xr.ms(new ka.ms().ms(sb.toString()).ms(true).ms(bytes).ms());
        } catch (Throwable unused) {
        }
    }

    private static String ms() {
        String str = Build.VERSION.RELEASE;
        return str.contains(j.z) ? str : str + ".0";
    }

    private static JSONObject ms(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (f545ms == null) {
            Context contextD = x.d();
            try {
                JSONObject jSONObject2 = new JSONObject();
                f545ms = jSONObject2;
                jSONObject2.put("os", "Android");
                f545ms.put("platform", "Android");
                f545ms.put("sdk_lib", "Android");
                f545ms.put(bv.y, ms());
                f545ms.put("os_api", Build.VERSION.SDK_INT);
                f545ms.put("use_apm_sdk", "1");
                f545ms.put("sdk_version", 137);
                f545ms.put("sdk_version_code", 137);
                f545ms.put(a.b, "0.0.1-alpha.17-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                f545ms.put("device_model", str);
                f545ms.put(bv.F, Build.BRAND);
                f545ms.put(bv.H, Build.MANUFACTURER);
                if (map != null) {
                    f545ms.put("aid", String.valueOf(map.get("aid")));
                    f545ms.put("app_version", map.get("app_version"));
                    f545ms.put("version_code", map.get("version_code"));
                    f545ms.put("update_version_code", map.get("update_version_code"));
                    f545ms.put("manifest_version_code", map.get("version_code"));
                    f545ms.put("channel", map.get("channel"));
                }
                f545ms.put("bd_did", x.ah().ms());
                f545ms.put("package", contextD.getPackageName());
                f545ms.put(bv.s, contextD.getApplicationInfo().name);
                ms(f545ms);
            } catch (Exception unused) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", f545ms);
        jSONObject.put("local_time", jCurrentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put("local_time_ms", jCurrentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put("session_id", UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jCurrentTimeMillis2)));
        jSONArray.put(jSONObject3);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    private static void ms(JSONObject jSONObject) {
        Map<String, Object> mapXr;
        Object obj;
        com.bytedance.ms.xr.ka.ms msVarMs = x.ms();
        if (msVarMs == null || jSONObject == null || (mapXr = msVarMs.xr()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapXr.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapXr.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Exception e) {
            ch.xr(e);
        }
    }
}
