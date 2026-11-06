package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.anythink.core.express.b.a;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.constants.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f2454ms = "AppEnvironment";
    private long ah;
    private boolean d;
    private String ka;
    private Map<String, String> xr;

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public static final d f2456ms = new d();
    }

    private d() {
        this.ka = "";
        HashMap map = new HashMap();
        this.xr = map;
        map.put("ad_style", a.f);
        this.xr.put("ad_id", a.f);
        this.xr.put("rit", a.f);
        this.xr.put("request_id", a.f);
        this.xr.put("ad_slot_type", a.f);
        this.xr.put("net_type", a.f);
        this.xr.put("low_memory", a.f);
        this.xr.put("total_max_memory_rate", a.f);
        this.xr.put("commit_hash", "53624fc");
        this.xr.put("branch", "v6900");
        this.xr.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
        this.xr.put("sdk_api_version", g.ah);
        this.xr.put("setting_ab_version", com.bytedance.sdk.openadsdk.core.ah.ka.ms().ka());
        this.ah = com.bytedance.sdk.openadsdk.core.jw.g.ms("tt_sp_app_env").xr("last_app_env_time", 0L);
        this.d = false;
    }

    public static d ms() {
        return ms.f2456ms;
    }

    public void ms(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        String strZg = lmVar.zg();
        Map<String, String> map = this.xr;
        if (TextUtils.isEmpty(strZg)) {
            strZg = "";
        }
        map.put(Constants.p.a, strZg);
    }

    public void ms(String str) {
        this.xr.put("dynamic_ptpl_id", str);
    }

    public void xr(String str) {
        this.xr.put("request_ad_info", str);
    }

    public void ah(String str) {
        this.xr.put("show_ad_info", str);
    }

    public void xr(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        this.xr.put("ad_id", lmVar.df());
        this.xr.put("rit", new StringBuilder().append(com.bytedance.sdk.openadsdk.core.jw.f.ny(lmVar)).toString());
        this.xr.put("request_id", com.bytedance.sdk.openadsdk.core.jw.f.zb(lmVar));
        this.xr.put("ad_slot_type", new StringBuilder().append(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar)).toString());
        this.xr.put("net_type", com.bytedance.sdk.component.utils.u.ab(re.getContext()));
        if (com.bytedance.sdk.openadsdk.core.jw.nw.xr(lmVar)) {
            this.xr.put("ad_style", "is_playable");
        }
        d();
    }

    private void d() {
        Runtime runtime = Runtime.getRuntime();
        float fMaxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        float fFreeMemory = (float) ((runtime.freeMemory() * 1.0d) / 1048576.0d);
        ActivityManager activityManager = (ActivityManager) re.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        com.bytedance.sdk.component.utils.sl.d(f2454ms, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.bytedance.sdk.component.utils.sl.d(f2454ms, "maxMemory: ".concat(String.valueOf(fMaxMemory)));
        com.bytedance.sdk.component.utils.sl.d(f2454ms, "totalMemory: ".concat(String.valueOf(f)));
        com.bytedance.sdk.component.utils.sl.d(f2454ms, "freeMemory: ".concat(String.valueOf(fFreeMemory)));
        int i = (int) ((f / fMaxMemory) * 100.0f);
        com.bytedance.sdk.component.utils.sl.d(f2454ms, "totalMaxRate: ".concat(String.valueOf(i)));
        this.xr.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.xr.put("total_max_memory_rate", String.valueOf(i));
    }

    public Map<String, String> xr() {
        return this.xr;
    }

    public void ah() {
        if (this.d || com.bytedance.sdk.openadsdk.core.jw.f.ms(this.ah, System.currentTimeMillis())) {
            return;
        }
        this.d = true;
        com.bytedance.sdk.openadsdk.core.t.u.ms().x(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.d.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                d.this.d = false;
                com.bytedance.sdk.openadsdk.core.t.ms.xr<com.bytedance.sdk.openadsdk.core.t.ms.xr> xrVarXr = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr();
                JSONObject jSONObjectKa = d.this.ka();
                if (jSONObjectKa != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    d.this.ah = jCurrentTimeMillis;
                    com.bytedance.sdk.openadsdk.core.jw.g.ms("tt_sp_app_env").ms("last_app_env_time", jCurrentTimeMillis);
                    xrVarXr.xr(jSONObjectKa.toString());
                }
                return xrVarXr;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ka() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = re.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put("app_id", ch.ub().t());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
