package com.byazt.ib;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.anythink.core.common.l.f;
import com.byazt.gc.AbsServerManager;
import com.byazt.qf.fs;
import com.byazt.xh.l;
import com.byazt.yw.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1231, 19})
public class n {
    public static volatile JSONObject n;

    public static void n(qg qgVar) {
        Map<String, Object> mapN = fs.n().n();
        if (mapN == null && mapN.get("aid") == null) {
            return;
        }
        try {
            byte[] bytes = n(mapN).toString().getBytes("UTF-8");
            StringBuilder sb = new StringBuilder(com.byazt.xh.qg.qg(mapN));
            sb.append("?device_platform=android&version_code=138&iid=iid&aid=").append(mapN.get("aid"));
            com.byazt.xh.qg.n(new l.n().n(sb.toString()).n(true).n(bytes).n());
        } catch (Throwable unused) {
        }
    }

    private static String n() {
        String str = Build.VERSION.RELEASE;
        return str.contains(i.E) ? str : str + ".0";
    }

    private static JSONObject n(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (n == null) {
            Context contextQ = fs.q();
            try {
                JSONObject jSONObject2 = new JSONObject();
                n = jSONObject2;
                jSONObject2.put(TapEventParamConstants.PARAM_SUB_OS, "Android");
                n.put("platform", "Android");
                n.put("sdk_lib", "Android");
                n.put("os_version", n());
                n.put("os_api", Build.VERSION.SDK_INT);
                n.put("use_apm_sdk", "1");
                n.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME);
                n.put("sdk_version_code", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME);
                n.put("sdk_version_name", "0.0.1-alpha.18-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                n.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, str);
                n.put("device_brand", Build.BRAND);
                n.put("device_manufacturer", Build.MANUFACTURER);
                if (map != null) {
                    n.put("aid", String.valueOf(map.get("aid")));
                    n.put("app_version", map.get("app_version"));
                    n.put("version_code", map.get("version_code"));
                    n.put("update_version_code", map.get("update_version_code"));
                    n.put("manifest_version_code", map.get("version_code"));
                    n.put("channel", map.get("channel"));
                }
                n.put("bd_did", fs.s().n());
                n.put(AbsServerManager.PACKAGE_QUERY_BINDER, contextQ.getPackageName());
                n.put("display_name", contextQ.getApplicationInfo().name);
                n(n);
            } catch (Exception unused) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", n);
        jSONObject.put("local_time", jCurrentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put("local_time_ms", jCurrentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put(f.bo, UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jCurrentTimeMillis2)));
        jSONArray.put(jSONObject3);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    private static void n(JSONObject jSONObject) {
        Map<String, Object> mapQg;
        Object obj;
        com.byazt.qi.n nVarN = fs.n();
        if (nVarN == null || jSONObject == null || (mapQg = nVarN.qg()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapQg.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapQg.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Exception e) {
            tj.qg(e);
        }
    }
}
