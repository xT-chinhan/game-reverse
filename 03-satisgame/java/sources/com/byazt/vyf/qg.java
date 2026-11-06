package com.byazt.vyf;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 26})
public class qg {
    public static String n = "AppEnvironment";
    public String l;
    public final AtomicBoolean q;
    public Map<String, String> qg;
    public volatile long s;
    public volatile String w;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 48})
    private static class n {
        public static final qg n = new qg();
    }

    private qg() {
        this.q = new AtomicBoolean(false);
        this.l = "";
        this.w = "";
        Map<String, String> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        this.qg = mapSynchronizedMap;
        mapSynchronizedMap.put("ad_style", "default");
        this.qg.put(MediationConstant.EXTRA_ADID, "default");
        this.qg.put("rit", "default");
        this.qg.put("request_id", "default");
        this.qg.put("ad_slot_type", "default");
        this.qg.put("net_type", "default");
        this.qg.put("low_memory", "default");
        this.qg.put("total_max_memory_rate", "default");
        this.qg.put("commit_hash", "15a431ecc5");
        this.qg.put("branch", "");
        this.qg.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
        this.qg.put("sdk_api_version", tj.w);
        this.qg.put("csj_app_id", s.cy().ou());
        this.qg.put("setting_ab_version", com.byazt.ed.q.n().l());
        this.qg.put("device_score", l());
        this.s = com.byazt.lk.l.n(com.byazt.vgx.s.q(), "tt_sp_app_env").qg("last_app_env_time", 0L);
    }

    private String l() {
        try {
            String strN = com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", com.byazt.vgx.s.q());
            if (!TextUtils.isEmpty(strN) && !"-1".equals(strN.trim())) {
                return String.valueOf(Math.round(Double.parseDouble(strN) * 10.0d) / 10.0d);
            }
            return "-1";
        } catch (Throwable unused) {
            return "-1";
        }
    }

    public static qg n() {
        return n.n;
    }

    public void n(pk pkVar) {
        if (pkVar == null) {
            return;
        }
        String strYk = pkVar.yk();
        Map<String, String> map = this.qg;
        if (TextUtils.isEmpty(strYk)) {
            strYk = "";
        }
        map.put("ad_info", strYk);
    }

    public void n(String str) {
        this.qg.put("dynamic_ptpl_id", str);
    }

    public void qg(String str) {
        this.qg.put("request_ad_info", str);
    }

    public void s(String str) {
        this.qg.put("show_ad_info", str);
    }

    public void qg(pk pkVar) {
        if (pkVar == null) {
            return;
        }
        s(pkVar.yk());
        JSONObject jSONObjectA_ = pkVar.A_();
        this.w = jSONObjectA_ == null ? "" : jSONObjectA_.optString("vid");
    }

    private void w() {
        String strQ = q(this.w);
        if (TextUtils.isEmpty(strQ)) {
            this.qg.remove("getads_vid");
        } else {
            this.qg.put("getads_vid", strQ);
        }
    }

    public String qg() {
        return this.w;
    }

    private String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(",")) {
            try {
                String strTrim = str2.trim();
                if (rv.qg().n(Long.parseLong(strTrim))) {
                    if (sb.length() > 0) {
                        sb.append(AbstractJsonLexerKt.COMMA);
                    }
                    sb.append(strTrim);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return sb.toString();
    }

    public void s(pk pkVar) {
        if (pkVar == null) {
            return;
        }
        this.qg.put(MediationConstant.EXTRA_ADID, pkVar.q());
        this.qg.put("rit", new StringBuilder().append(com.byazt.vgx.w.cy(pkVar)).toString());
        this.qg.put("request_id", com.byazt.vgx.w.a(pkVar));
        this.qg.put("ad_slot_type", new StringBuilder().append(com.byazt.vgx.w.d(pkVar)).toString());
        this.qg.put("net_type", hd.x(rv.getContext()));
        if (com.byazt.qq.qg.qg(pkVar)) {
            this.qg.put("ad_style", "is_playable");
        }
        x();
    }

    private void x() {
        Runtime runtime = Runtime.getRuntime();
        float fMaxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        float fFreeMemory = (float) ((runtime.freeMemory() * 1.0d) / 1048576.0d);
        ActivityManager activityManager = (ActivityManager) rv.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        k.qg(n, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        k.qg(n, "maxMemory: " + fMaxMemory);
        k.qg(n, "totalMemory: " + f);
        k.qg(n, "freeMemory: " + fFreeMemory);
        int i = (int) ((f / fMaxMemory) * 100.0f);
        k.qg(n, "totalMaxRate: " + i);
        this.qg.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.qg.put("total_max_memory_rate", String.valueOf(i));
    }

    public Map<String, String> s() {
        HashMap map;
        w();
        synchronized (this.qg) {
            map = new HashMap(this.qg);
        }
        return map;
    }

    public void q() {
        if (!com.byazt.vgx.w.n(this.s, System.currentTimeMillis()) && this.q.compareAndSet(false, true)) {
            try {
                com.byazt.eji.s.n().n("app_env", new com.byazt.rs.n() { // from class: com.byazt.vyf.qg.1
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject) throws JSONException {
                        try {
                            JSONObject jSONObjectFs = qg.this.fs();
                            if (rv.qg().xa()) {
                                if (jSONObjectFs == null) {
                                    jSONObjectFs = new JSONObject();
                                }
                                try {
                                    jSONObjectFs.put("download_folder", com.byazt.xu.n.n());
                                } catch (Exception e) {
                                    com.byazt.hm.w.n("download_folder_info", (JSONObject) null, e);
                                }
                            }
                            if (jSONObjectFs != null) {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                qg.this.s = jCurrentTimeMillis;
                                com.byazt.lk.l.n(com.byazt.vgx.s.q(), "tt_sp_app_env").n("last_app_env_time", jCurrentTimeMillis);
                            }
                            qg.this.q.set(false);
                            return jSONObjectFs;
                        } catch (Throwable th) {
                            qg.this.q.set(false);
                            throw th;
                        }
                    }
                });
            } catch (Throwable th) {
                this.q.set(false);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject fs() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = rv.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put("app_id", s.cy().ou());
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
