package com.byazt.sd;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.mg.PluginConstants;
import com.byazt.ol.TTDownloadField;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.constants.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 121})
public class x {
    public static String pr = "AppEnvironment";
    public String c;
    public long hn;
    public Map<String, String> hw;
    public boolean x;

    @com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private static class pr {
        public static final x pr = new x();
    }

    private x() {
        this.c = "";
        HashMap map = new HashMap();
        this.hw = map;
        map.put("ad_style", "default");
        this.hw.put(MediationConstant.EXTRA_ADID, "default");
        this.hw.put("rit", "default");
        this.hw.put(Constants.Bidding.REQUEST_ID, "default");
        this.hw.put("ad_slot_type", "default");
        this.hw.put("net_type", "default");
        this.hw.put("low_memory", "default");
        this.hw.put("total_max_memory_rate", "default");
        this.hw.put("commit_hash", "cf3afeb");
        this.hw.put("branch", "v7700");
        this.hw.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
        this.hw.put("sdk_api_version", iu.c);
        this.hw.put("csj_app_id", zo.nt().ny());
        this.hw.put("setting_ab_version", com.byazt.mp.c.pr().c());
        this.hw.put("device_score", x());
        this.hn = com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "tt_sp_app_env").hw("last_app_env_time", 0L);
        this.x = false;
    }

    private String x() {
        try {
            String strPr = com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", com.byazt.zb.pr.x());
            if (!TextUtils.isEmpty(strPr) && !"-1".equals(strPr.trim())) {
                return String.valueOf(Math.round(Double.parseDouble(strPr) * 10.0d) / 10.0d);
            }
            return "-1";
        } catch (Throwable th) {
            return "-1";
        }
    }

    public static x pr() {
        return pr.pr;
    }

    public void pr(of ofVar) {
        if (ofVar == null) {
            return;
        }
        String strTd = ofVar.td();
        Map<String, String> map = this.hw;
        if (TextUtils.isEmpty(strTd)) {
            strTd = "";
        }
        map.put("ad_info", strTd);
    }

    public void pr(String str) {
        this.hw.put("dynamic_ptpl_id", str);
    }

    public void hw(String str) {
        this.hw.put("request_ad_info", str);
    }

    public void hn(String str) {
        this.hw.put("show_ad_info", str);
    }

    public void hw(of ofVar) {
        if (ofVar == null) {
            return;
        }
        this.hw.put(MediationConstant.EXTRA_ADID, ofVar.x());
        this.hw.put("rit", new StringBuilder().append(ls.m(ofVar)).toString());
        this.hw.put(Constants.Bidding.REQUEST_ID, ls.yb(ofVar));
        this.hw.put("ad_slot_type", new StringBuilder().append(ls.k(ofVar)).toString());
        this.hw.put("net_type", com.byazt.ca.yb.fw(a.getContext()));
        if (com.byazt.wt.ny.hw(ofVar)) {
            this.hw.put("ad_style", "is_playable");
        }
        c();
    }

    private void c() {
        Runtime runtime = Runtime.getRuntime();
        float fMaxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        float fFreeMemory = (float) ((runtime.freeMemory() * 1.0d) / 1048576.0d);
        ActivityManager activityManager = (ActivityManager) a.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        com.byazt.ca.ho.hw(pr, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.byazt.ca.ho.hw(pr, "maxMemory: ".concat(String.valueOf(fMaxMemory)));
        com.byazt.ca.ho.hw(pr, "totalMemory: ".concat(String.valueOf(f)));
        com.byazt.ca.ho.hw(pr, "freeMemory: ".concat(String.valueOf(fFreeMemory)));
        int i = (int) ((f / fMaxMemory) * 100.0f);
        com.byazt.ca.ho.hw(pr, "totalMaxRate: ".concat(String.valueOf(i)));
        this.hw.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.hw.put("total_max_memory_rate", String.valueOf(i));
    }

    public Map<String, String> hw() {
        return this.hw;
    }

    public void hn() {
        if (this.x || ls.pr(this.hn, System.currentTimeMillis())) {
            return;
        }
        this.x = true;
        com.byazt.xk.hw.pr().pr("app_env", new com.byazt.ttf.pr() { // from class: com.byazt.sd.x.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                x.this.x = false;
                JSONObject jSONObjectUc = x.this.uc();
                if (jSONObjectUc != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    x.this.hn = jCurrentTimeMillis;
                    com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "tt_sp_app_env").pr("last_app_env_time", jCurrentTimeMillis);
                }
                return jSONObjectUc;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject uc() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = a.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put(PluginConstants.KEY_APP_ID, zo.nt().ny());
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
        } catch (Throwable th) {
            return null;
        }
    }
}
