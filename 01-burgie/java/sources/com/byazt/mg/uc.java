package com.byazt.mg;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.qq.e.comm.pi.ACTD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, 5})
public final class uc {
    public static SharedPreferences hw;
    public static final List<Pair<String, JSONObject>> hn = new CopyOnWriteArrayList();
    public static final Map<String, String> pr = new HashMap();

    public static void pr(String str, JSONObject jSONObject) {
        if (com.byazt.yk.hw.w.equals(str)) {
            pr(str, jSONObject, null);
        } else {
            x("zeus_".concat(String.valueOf(str)), jSONObject);
        }
    }

    public static void pr() {
        List<Pair<String, JSONObject>> list = hn;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    x((String) pair.first, (JSONObject) pair.second);
                }
            }
            hn.clear();
        } catch (Exception e) {
        }
    }

    private static void x(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", str);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
            return;
        }
        c(str, jSONObject);
    }

    public static void pr(final int i, final String str, final boolean z, final fw fwVar, final Throwable th) {
        if (com.byazt.dea.c.pr()) {
            return;
        }
        com.byazt.as.pr.pr().x().execute(new Runnable() { // from class: com.byazt.mg.uc.1
            @Override // java.lang.Runnable
            public void run() {
                uc.hn(i, str, z, fwVar, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(int i, String str, boolean z, fw fwVar, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (fwVar != null) {
            try {
                fwVar.pr(jSONObject);
            } catch (Throwable th2) {
                pr("report_failed", null, th2);
                return;
            }
        }
        jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
        jSONObject.putOpt("message", str);
        jSONObject.putOpt("is_plugin", Boolean.valueOf(z));
        jSONObject.putOpt("api", Boolean.TRUE);
        aj.pr(TTAppContextHolder.getContext());
        Plugin plugin = Zeus.getPlugin("com.byted.pangle");
        if (plugin != null) {
            jSONObject.putOpt("install_version", Integer.valueOf(plugin.getVersion()));
            jSONObject.putOpt("life_cycle", Integer.valueOf(plugin.getLifeCycle()));
        }
        jSONObject.putOpt("load_record", c.hw());
        pr("init_failed", jSONObject, th);
    }

    public static void pr(String str, JSONObject jSONObject, Throwable th) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("scene", str);
            jSONObject2.putOpt("object", jSONObject);
            jSONObject2.putOpt("exception", Log.getStackTraceString(th));
            c("exception", jSONObject2);
        } catch (Exception e) {
        }
    }

    private static void c(final String str, final JSONObject jSONObject) {
        com.byazt.as.pr.pr().x().execute(new Runnable() { // from class: com.byazt.mg.uc.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ArrayList arrayList = new ArrayList();
                arrayList.add(uc.uc(str, jSONObject));
                uc.hw(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject uc(String str, JSONObject jSONObject) {
        String str2 = "7.7.1.4";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            jSONObject.put("is_boost", true);
            jSONObject.put("is_only_armv8a", com.byazt.ud.hn.hn());
            jSONObject2.put("ad_sdk_version", "7.7.1.4");
            aj.pr(TTAppContextHolder.getContext());
            String strPr = aj.pr("com.byted.pangle");
            if (!TextUtils.isEmpty(strPr)) {
                str2 = strPr;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = pr;
            jSONObject.put(ACTD.APPID_KEY, map.get(ACTD.APPID_KEY));
            jSONObject2.put("event_extra", jSONObject != null ? jSONObject.toString() : "");
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("model", Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException e) {
        }
        return jSONObject2;
    }

    public static void hw(String str, JSONObject jSONObject) {
        hn.add(new Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(List<JSONObject> list) throws Throwable {
        if (list == null) {
            return;
        }
        if (hw == null) {
            hw = hw.hw(TTAppContextHolder.getContext(), "tt_sdk_settings_other", 0);
        }
        String str = String.format("https://%s%s", hw.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = hn;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(uc((String) pair.first, (JSONObject) pair.second));
                }
                hn.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception e) {
        }
        com.byazt.bj.hn.pr().pr(true, str, com.byazt.ud.hw.pr(jSONObject).toString().getBytes());
    }

    public static void pr(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = pr;
        map.put(ACTD.APPID_KEY, adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        map.put("plugin_update_conf", pluginUpdateConfig != 0 ? String.valueOf(pluginUpdateConfig) : "2");
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put("oaid", customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception e) {
            }
        }
    }

    public static Map<String, String> hw() {
        return pr;
    }
}
