package com.byazt.yoc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.byazt.ewn.AbsServerManager;
import com.byazt.tv.c;
import com.byazt.vlj.zo;
import com.byazt.wf.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 436, 37})
public class pr {
    public static volatile JSONObject pr;

    public static void pr(hw hwVar) {
        Map<String, Object> mapPr = zo.pr().pr();
        if (mapPr != null || mapPr.get("aid") != null) {
            try {
                byte[] bytes = pr(mapPr).toString().getBytes(Key.STRING_CHARSET_NAME);
                StringBuilder sb = new StringBuilder(com.byazt.tv.hw.hw(mapPr));
                sb.append("?device_platform=android&version_code=138&iid=iid&aid=").append(mapPr.get("aid"));
                com.byazt.tv.hw.pr(new c.pr().pr(sb.toString()).pr(true).pr(bytes).pr());
            } catch (Throwable th) {
            }
        }
    }

    private static String pr() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    private static JSONObject pr(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (pr == null) {
            Context contextX = zo.x();
            try {
                JSONObject jSONObject2 = new JSONObject();
                pr = jSONObject2;
                jSONObject2.put("os", "Android");
                pr.put("platform", "Android");
                pr.put("sdk_lib", "Android");
                pr.put(an.y, pr());
                pr.put("os_api", Build.VERSION.SDK_INT);
                pr.put("use_apm_sdk", "1");
                pr.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME);
                pr.put("sdk_version_code", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME);
                pr.put("sdk_version_name", "0.0.1-alpha.18-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                pr.put("device_model", str);
                pr.put(an.F, Build.BRAND);
                pr.put(an.H, Build.MANUFACTURER);
                if (map != null) {
                    pr.put("aid", String.valueOf(map.get("aid")));
                    pr.put("app_version", map.get("app_version"));
                    pr.put("version_code", map.get("version_code"));
                    pr.put("update_version_code", map.get("update_version_code"));
                    pr.put("manifest_version_code", map.get("version_code"));
                    pr.put("channel", map.get("channel"));
                }
                pr.put("bd_did", zo.hn().pr());
                pr.put(AbsServerManager.PACKAGE_QUERY_BINDER, contextX.getPackageName());
                pr.put(an.s, contextX.getApplicationInfo().name);
                pr(pr);
            } catch (Exception e) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", pr);
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

    private static void pr(JSONObject jSONObject) {
        Map<String, Object> mapHw;
        com.byazt.sds.pr prVarPr = zo.pr();
        if (prVarPr != null && jSONObject != null && (mapHw = prVarPr.hw()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : mapHw.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        Object obj = mapHw.get(str);
                        if (obj != null) {
                            jSONObject2.put(str, obj);
                        }
                    }
                }
                jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
            } catch (Exception e) {
                vk.hw(e);
            }
        }
    }
}
