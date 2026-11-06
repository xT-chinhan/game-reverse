package com.byazt.eji;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.anythink.china.b.c;
import com.anythink.core.common.f.h;
import com.byazt.gct.a;
import com.byazt.gct.ic;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.nf.rv;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.qyu.PluginConstants;
import com.byazt.twu.q;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, 8})
public class s {
    public static volatile s n = null;
    public static String qg = "";

    private s() {
    }

    public static s n() {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s();
                }
            }
        }
        return n;
    }

    public void n(final String str, final String str2, final String str3, final String str4, final int i, final String str5, final String str6, final String str7, final String str8, final int i2, final com.byazt.rs.n nVar) {
        com.byazt.ag.qg.n(new x("stats") { // from class: com.byazt.eji.s.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).n(str, (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.eji.s.1.1
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject) throws JSONException {
                        jSONObject.putOpt("error_code", Integer.valueOf(i2));
                        JSONObject jSONObjectN = nVar != null ? nVar.n(jSONObject) : null;
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.putOpt("rit", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.putOpt("creative_id", str3);
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            jSONObject.putOpt("req_id", str4);
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            jSONObject.putOpt("error_msg", str8);
                        }
                        if (i > 0) {
                            jSONObject.putOpt("adtype", Integer.valueOf(i));
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            jSONObject.putOpt("extra", str6);
                        }
                        if (!TextUtils.isEmpty(str7)) {
                            jSONObject.putOpt("ad_info", str7);
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            jSONObject.putOpt(MediationConstant.EXTRA_DURATION, str5);
                        }
                        jSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
                        if (TextUtils.isEmpty(jSONObject.optString(ACTD.APPID_KEY))) {
                            jSONObject.putOpt(ACTD.APPID_KEY, com.byazt.vyf.s.cy().ou());
                        }
                        q.n(str, jSONObject);
                        if (jSONObjectN == null) {
                            jSONObjectN = new JSONObject();
                        }
                        if (!TextUtils.isEmpty(w.rv)) {
                            jSONObjectN.put("wrong_stats_url", w.rv);
                        }
                        if (!TextUtils.isEmpty(w.tj)) {
                            jSONObjectN.put("wrong_applog_url", w.tj);
                        }
                        try {
                            jSONObjectN.put("device_score", Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", com.byazt.vgx.s.q())));
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObjectN.put("abtest_version", com.byazt.vyf.s.cy().yw());
                        } catch (Exception unused2) {
                        }
                        if (com.byazt.vyf.s.cy().w()) {
                            jSONObjectN.putOpt("first_of_two", 1);
                        }
                        return jSONObjectN;
                    }
                });
            }
        });
    }

    public void n(String str, com.byazt.rs.n nVar) {
        n(str, 0, (String) null, nVar);
    }

    public void n(String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n(str, new com.byazt.rs.n() { // from class: com.byazt.eji.s.12
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void n(String str, String str2, com.byazt.rs.n nVar) {
        n(str, str2, (String) null, nVar);
    }

    public void qg(String str, String str2, com.byazt.rs.n nVar) {
        n(str, null, null, null, 0, str2, null, null, "", 0, nVar);
    }

    public void n(String str, int i, String str2, com.byazt.rs.n nVar) {
        n(str, null, null, null, 0, null, null, null, str2, i, nVar);
    }

    public void n(String str, String str2, String str3, com.byazt.rs.n nVar) {
        n(str, null, null, str2, 0, null, str3, null, "", 0, nVar);
    }

    public void n(String str, String str2, String str3, int i, com.byazt.rs.n nVar) {
        n(str, str2, null, str3, i, null, null, null, "", 0, nVar);
    }

    public void n(String str, String str2, int i, final int i2, final com.byazt.wd.s sVar, final long j, final String str3) {
        n("req_drop_pitaya_result", str2, str, i, new com.byazt.rs.n() { // from class: com.byazt.eji.s.21
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("req_stage", i2);
                jSONObject2.put("pitaya_duration", j);
                try {
                    JSONObject jSONObject3 = new JSONObject(str3);
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject3.get(next));
                    }
                } catch (Exception unused) {
                }
                jSONObject2.put("pitaya_has_result", sVar != null ? 1 : 0);
                com.byazt.wd.s sVar2 = sVar;
                if (sVar2 != null) {
                    jSONObject2.put("code", sVar2.l());
                    jSONObject2.put("req_exempt", sVar.x() ? 1 : 0);
                    jSONObject2.putOpt("strategy_result", sVar.fs());
                }
                Object[] objArr = new Object[1];
                return jSONObject2;
            }
        });
    }

    public void n(String str, String str2, String str3, int i, int i2, String str4, com.byazt.rs.n nVar) {
        n(str, str2, null, str3, i, null, null, null, str4, i2, nVar);
    }

    private void n(String str, int i, String str2, int i2, String str3, com.byazt.rs.n nVar) {
        n(str, null, null, null, i, String.valueOf(str2), null, null, str3, i2, nVar);
    }

    public void n(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        n("render_backup", new com.byazt.rs.n() { // from class: com.byazt.eji.s.32
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void n(final long j, final long j2, final int i) {
        long j3 = j2 - j;
        if (j3 <= 0 || j3 >= 30000000) {
            return;
        }
        qg("general_label", String.valueOf(j3), new com.byazt.rs.n() { // from class: com.byazt.eji.s.42
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("starttime", j);
                    jSONObject2.put("endtime", j2);
                    jSONObject2.put("start_type", i);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public void n(String str, final String str2) {
        qg("sdk_retention", str, new com.byazt.rs.n() { // from class: com.byazt.eji.s.43
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("close_time_1", str2);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public void n(final Object obj, final Object obj2, final String str, final String str2, final String str3) {
        n("obm_result", new com.byazt.rs.n() { // from class: com.byazt.eji.s.44
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    Object obj3 = obj;
                    if (obj3 instanceof Boolean) {
                        jSONObject2.put("is_button", obj3);
                    }
                    Object obj4 = obj2;
                    if (obj4 instanceof Boolean) {
                        jSONObject2.put("convert_result", obj4);
                    }
                    jSONObject2.put("error_msg", str);
                    jSONObject2.put("req_id", str2);
                    jSONObject2.put(MediationConstant.EXTRA_ADID, str3);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public void n(pk pkVar, int i, String str) {
        String str2;
        String str3;
        String strOu;
        if (pkVar != null) {
            String strN = w.n(pkVar, "");
            String strQ = pkVar.q();
            strOu = pkVar.ou();
            str2 = strN;
            str3 = strQ;
        } else {
            str2 = "";
            str3 = str2;
            strOu = str3;
        }
        n("use_player", str2, str3, strOu, 0, null, null, null, str, i, null);
    }

    public void n(String str, int i, int i2, String str2, int i3, String str3, long j, boolean z, boolean z2, boolean z3, boolean z4, int i4) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            jSONObject.put("message", str3);
            jSONObject.put("version", i2);
            jSONObject.put("current_version", i);
            jSONObject.put("package_name", str);
            jSONObject.put(ImagesContract.URL, str2);
            jSONObject.put(MediationConstant.EXTRA_DURATION, j);
            jSONObject.put("max_retry_count", com.byazt.ph.q.qg(str));
            jSONObject.put("uuid", com.byazt.ehw.n.s());
            jSONObject.put("isRetry", z);
            jSONObject.put("is_old_plugin", z2);
            jSONObject.put("is_resume_download", z3);
            jSONObject.put("is_downloader", z4);
            jSONObject.put("downloader_try_count", i4);
            jSONObject.put("host_abi", com.byazt.wl.qg.n());
        } catch (Throwable unused) {
        }
        n("plugin_download", 0, String.valueOf(j), i3, str3, new com.byazt.rs.n() { // from class: com.byazt.eji.s.45
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void qg(final String str, String str2) {
        String str3;
        final String str4;
        final String str5;
        final JSONObject jSONObject;
        File[] fileArrListFiles;
        String strOptString = "";
        final String strConcat = (TextUtils.isEmpty(str) || str.startsWith("zeus") || TextUtils.equals("plugin_load_failed", str)) ? str : "zeus_".concat(String.valueOf(str));
        JSONObject jSONObject2 = null;
        try {
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                JSONObject jSONObject3 = new JSONObject(str2);
                try {
                    String strOptString2 = jSONObject3.optString("version_code");
                    try {
                        strOptString = jSONObject3.optString("plugin_package_name");
                        if ("zeus_install_finish".equals(strConcat) && "com.byted.pangle".equals(strOptString)) {
                            qg = com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).qg() + "," + strOptString2;
                            com.byazt.ikv.n.n().n("plugin_install_msg", qg);
                            boolean zN = com.byazt.af.x.n().n(rv.getContext(), c.b);
                            jSONObject3.putOpt("sd_per", Boolean.valueOf(zN));
                            File file = new File(s() + "ins/" + com.byazt.vyf.s.cy().ou(), strOptString2);
                            boolean zExists = file.exists();
                            jSONObject3.putOpt("is_installed", Boolean.valueOf(zExists));
                            if (zExists && zN) {
                                File parentFile = file.getParentFile();
                                if (parentFile != null && (fileArrListFiles = parentFile.listFiles()) != null && !strOptString2.isEmpty()) {
                                    for (File file2 : fileArrListFiles) {
                                        if (file2 != null && !TextUtils.equals(file2.getName(), strOptString2)) {
                                            file2.delete();
                                        }
                                    }
                                }
                                str5 = strOptString2;
                                str4 = strOptString;
                                jSONObject = jSONObject3;
                            } else {
                                jSONObject3.putOpt("mkdirs", Boolean.valueOf(file.mkdirs()));
                            }
                            l.s(new x("plugin_report") { // from class: com.byazt.eji.s.46
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!"exception".equals(str)) {
                                        s.qg(strConcat, jSONObject, str5, str4);
                                        return;
                                    }
                                    JSONObject jSONObject4 = jSONObject;
                                    if (jSONObject4 != null) {
                                        s.this.n(jSONObject4.optString("scene"), jSONObject, (Throwable) null);
                                    }
                                }
                            });
                        }
                    } catch (JSONException unused) {
                    }
                    jSONObject2 = jSONObject3;
                    String str6 = strOptString;
                    strOptString = strOptString2;
                    str3 = str6;
                } catch (JSONException unused2) {
                    str3 = "";
                    jSONObject2 = jSONObject3;
                }
            }
        } catch (JSONException unused3) {
        }
        str4 = str3;
        str5 = strOptString;
        jSONObject = jSONObject2;
        l.s(new x("plugin_report") { // from class: com.byazt.eji.s.46
            @Override // java.lang.Runnable
            public void run() {
                if (!"exception".equals(str)) {
                    s.qg(strConcat, jSONObject, str5, str4);
                    return;
                }
                JSONObject jSONObject4 = jSONObject;
                if (jSONObject4 != null) {
                    s.this.n(jSONObject4.optString("scene"), jSONObject, (Throwable) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(String str, final JSONObject jSONObject, String str2, String str3) {
        String str4 = "status_code";
        if (jSONObject != null) {
            try {
                jSONObject.put("current_version", "7.8.1.4");
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
                jSONObject.put("max_retry_count", com.byazt.ph.q.qg(str3));
                jSONObject.put("uuid", com.byazt.ehw.n.s());
                jSONObject.put("host_abi", com.byazt.wl.qg.n());
            } catch (Throwable unused) {
                return;
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = 1;
        jSONObject.put("boost", true);
        if (!jSONObject.has("status_code")) {
            str4 = "code";
        }
        int iOptInt = jSONObject.optInt(str4);
        String strOptString = jSONObject.optString("message");
        String strOptString2 = jSONObject.optString(MediationConstant.EXTRA_DURATION);
        if ("zeus_load_finish".equals(str)) {
            if (!n(str2, str3, jSONObject)) {
                i = 0;
            }
            int i2 = i;
            jSONObject.putOpt("first_load", Integer.valueOf(i2));
            n().n(str, i2, strOptString2, iOptInt, strOptString, new com.byazt.rs.n() { // from class: com.byazt.eji.s.2
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
                    return jSONObject;
                }
            });
            return;
        }
        n().n(str, 0, strOptString2, iOptInt, strOptString, new com.byazt.rs.n() { // from class: com.byazt.eji.s.3
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    private static String s() {
        return new String(Base64.decode("L3NkY2FyZC9Eb3dubG9hZC8uY3NqLw==", 2), StandardCharsets.UTF_8);
    }

    public void n(final pk pkVar) {
        if (pkVar == null) {
            return;
        }
        n("saas_show_miss", new com.byazt.rs.n() { // from class: com.byazt.eji.s.4
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    int iS = com.byazt.wq.qg.n().s();
                    int iL = com.byazt.wq.qg.n().l();
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
                    jSONObject2.put("ext", pkVar.F_());
                    jSONObject2.put("live_sdk_status", iS);
                    jSONObject2.put("live_auth_status", iL);
                    jSONObject2.put("app_start_time", jElapsedRealtime);
                    jSONObject2.put("is_web", pkVar.B_());
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void s(String str, String str2) {
        String strS = s();
        File file = new File(strS + com.byazt.vyf.s.cy().ou(), str2);
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(strS + "ins/" + com.byazt.vyf.s.cy().ou(), str2);
        if (file2.exists()) {
            file2.delete();
        }
        File file3 = new File(com.byazt.tk.w.n(rv.getContext(), false, null), str);
        if (TextUtils.equals(com.byazt.xu.s.n(file3), str2)) {
            com.byazt.xu.s.qg(file3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("version_code", str2);
                jSONObject.putOpt("package_name", str);
            } catch (Exception unused) {
            }
            n().n("d_d", jSONObject, (Throwable) null);
        }
    }

    public static boolean n(String str, String str2, JSONObject jSONObject) {
        File[] fileArrListFiles;
        Context context = rv.getContext();
        File file = new File(com.byazt.tk.w.n(context, false, null), str2);
        String strN = com.byazt.xu.s.n(file);
        try {
            jSONObject.putOpt("last_plugin_version", strN);
            jSONObject.putOpt("version_file", file.getAbsoluteFile());
            boolean zN = com.byazt.af.x.n().n(context, c.b);
            jSONObject.putOpt("sd_per", Boolean.valueOf(zN));
            String strS = s();
            File file2 = new File(strS + com.byazt.vyf.s.cy().ou(), str);
            boolean zExists = file2.exists();
            jSONObject.putOpt("is_loaded", Boolean.valueOf(zExists));
            jSONObject.putOpt("is_installed", Boolean.valueOf(new File(strS + "ins/" + com.byazt.vyf.s.cy().ou(), str).exists()));
            if (zExists && zN) {
                File parentFile = file2.getParentFile();
                if (parentFile != null && (fileArrListFiles = parentFile.listFiles()) != null && !str.isEmpty()) {
                    for (File file3 : fileArrListFiles) {
                        if (file3 != null && !TextUtils.equals(file3.getName(), str)) {
                            file3.delete();
                        }
                    }
                }
            } else {
                jSONObject.putOpt("mkdirs", Boolean.valueOf(file2.mkdirs()));
            }
            com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
            String strQg = sVarN.qg("plugin_first_load", "");
            if (!TextUtils.isEmpty(strQg)) {
                jSONObject.putOpt("plugin_first_load", strQg);
            }
            sVarN.n("plugin_first_load", str);
            if (!TextUtils.equals(str, strN)) {
                jSONObject.putOpt("write_suc", Boolean.valueOf(com.byazt.xu.s.n(str, file)));
                String strQg2 = qg;
                if (TextUtils.isEmpty(strQg2)) {
                    strQg2 = sVarN.qg("plugin_install_msg", "");
                }
                jSONObject.putOpt("install_msg", strQg2);
                return true;
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    public void n(final JSONObject jSONObject, String str) {
        n("lp_monitor", str, new com.byazt.rs.n() { // from class: com.byazt.eji.s.5
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void qg() {
        n("sdk_permission", new com.byazt.rs.n() { // from class: com.byazt.eji.s.6
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                com.byazt.zq.q qVarA = com.byazt.vyf.s.cy().a();
                boolean zS = qVarA.s();
                boolean zN = qVarA.n();
                boolean zFs = qVarA.fs();
                boolean zW = qVarA.w();
                boolean zQ = qVarA.q();
                boolean zTj = qVarA.tj();
                String strRv = qVarA.rv();
                JSONObject jSONObject2 = new JSONObject();
                int i = 1;
                try {
                    jSONObject2.put("access_fine_location", zN ? 1 : 0);
                    jSONObject2.put("applist", zS ? 1 : 0);
                    jSONObject2.put("external_storage", zFs ? 1 : 0);
                    jSONObject2.put("wifi_state", zW ? 1 : 0);
                    jSONObject2.put("phone_state", zQ ? 1 : 0);
                    jSONObject2.put("can_use_androidId", zTj ? 1 : 0);
                    jSONObject2.put("dev_oaid", strRv);
                    if (!com.byazt.vyf.s.cy().oa()) {
                        i = 0;
                    }
                    jSONObject2.put("uip", i);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public void n(pk pkVar, final JSONObject jSONObject) {
        if (pkVar == null) {
            return;
        }
        n("jsb_video_action", w.n(pkVar, ""), pkVar.ou(), 0, new com.byazt.rs.n() { // from class: com.byazt.eji.s.7
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public static void n(String str, final long j, final boolean z, final String str2, final JSONObject jSONObject) {
        n().n("over_freq", str, new com.byazt.rs.n() { // from class: com.byazt.eji.s.8
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_agg", z);
                jSONObject3.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, j);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject3.put("exempt_strategy_id", str2);
                }
                JSONObject jSONObject4 = jSONObject;
                if (jSONObject4 != null) {
                    jSONObject3.put("strategy_results", jSONObject4);
                }
                return jSONObject3;
            }
        });
    }

    public static void n(final int i, final int i2) {
        n().n("system_change", new com.byazt.rs.n() { // from class: com.byazt.eji.s.9
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                int i3 = i;
                if (i3 != -1) {
                    jSONObject2.put("user_volume_change", i3);
                }
                int i4 = i2;
                if (i4 != -1) {
                    jSONObject2.put("user_bright_change", i4);
                }
                return jSONObject2;
            }
        });
    }

    private boolean n(String str, int i) {
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        int iQg = sVarN.qg(str, 0);
        boolean z = (iQg & 2) == 0 || (iQg & 1) != i;
        if (z) {
            sVarN.n(str, i + 2);
        }
        return z;
    }

    public void n(int i, pk pkVar, boolean z) {
        String strValueOf = String.valueOf(w.cy(pkVar));
        if (n(strValueOf, z ? 1 : 0)) {
            n().n(z ? "reg_creative" : "no_reg_creative", strValueOf, (String) null, i, (com.byazt.rs.n) null);
        }
    }

    public void n(final boolean z, final String[] strArr) {
        n("download_permission", new com.byazt.rs.n() { // from class: com.byazt.eji.s.10
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("if_sd", z ? 1 : 0);
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str).append(",");
                            }
                        }
                        jSONObject2.put("permission", sb.toString());
                    }
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public void n(final String str, final String str2, final String str3, final boolean z) {
        n("get_bidding_token", new com.byazt.rs.n() { // from class: com.byazt.eji.s.11
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                boolean zQg = rv.qg().qg(str);
                JSONObject jSONObject2 = new JSONObject();
                if (zQg) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject2.put("cache_req_id", str2);
                    }
                    if (TextUtils.equals(str3, "0")) {
                        jSONObject2.put("no_cache_reason", 0);
                    } else if (TextUtils.equals(str3, "1")) {
                        jSONObject2.put("no_cache_reason", 1);
                    }
                }
                if (z) {
                    jSONObject2.put("opt_sample", 1);
                }
                return jSONObject2;
            }
        });
    }

    public void n(final long j, final long j2, final boolean z, final com.byazt.rr.s sVar, final JSONObject jSONObject, final int i) {
        n("pitaya_init", new com.byazt.rs.n() { // from class: com.byazt.eji.s.13
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(MediationConstant.EXTRA_DURATION, j2);
                jSONObject3.put("ext_plugin_code", com.byazt.vzq.s.qg());
                jSONObject3.put("success", z ? 1 : 0);
                jSONObject3.put(h.b.h, i);
                jSONObject3.put("python_vm_start_time", j);
                JSONObject jSONObject4 = jSONObject;
                if (jSONObject4 != null) {
                    jSONObject3.putOpt("record", jSONObject4);
                }
                com.byazt.rr.s sVar2 = sVar;
                if (sVar2 != null) {
                    jSONObject3.putOpt("error", com.byazt.gh.q.n(sVar2));
                }
                return jSONObject3;
            }
        });
    }

    public void qg(final JSONObject jSONObject) {
        n("pitaya_package_init", new com.byazt.rs.n() { // from class: com.byazt.eji.s.14
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void n(final int i, com.byazt.vyf.w wVar) {
        if (wVar == null) {
            return;
        }
        final JSONObject jSONObjectN = wVar.n(-1L);
        final long jQg = wVar.qg();
        n("bid_token_time", new com.byazt.rs.n() { // from class: com.byazt.eji.s.15
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                try {
                    jSONObjectN.put("total", jQg);
                    jSONObjectN.put("opt_sample", 1);
                    jSONObjectN.put("slot_type", i);
                } catch (Throwable unused) {
                }
                return jSONObjectN;
            }
        });
    }

    public void n(final int i, final long j, final String str, final int i2) {
        n("encrypt_track", new com.byazt.rs.n() { // from class: com.byazt.eji.s.16
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    long j2 = j;
                    if (j2 >= 0) {
                        jSONObject2.put("cost_time", j2);
                    }
                    jSONObject2.put("opt_sample", 1);
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject2.put("event_res", i3);
                    }
                    int i4 = i2;
                    if (i4 != -1 && i == 3) {
                        jSONObject2.put("armor_load_status", i4);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject2.put("type", str);
                    }
                    return jSONObject2;
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
    }

    public void n(int i) {
        n("has_pre_req", 0, (String) null, i, (String) null, new com.byazt.rs.n() { // from class: com.byazt.eji.s.17
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                return null;
            }
        });
    }

    public void n(final int i, final String str, String str2, String str3, final String str4) {
        n("fetch_adm_status", str3, str2, 0, i, (String) null, new com.byazt.rs.n() { // from class: com.byazt.eji.s.18
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("fetch_adm", i == 0 ? 1 : 0);
                jSONObject2.put("code", i);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject2.put("material_keys", str4);
                return jSONObject2;
            }
        });
    }

    public void qg(int i) {
        n("get_ad_cache_failed", i, (String) null, (com.byazt.rs.n) null);
    }

    public void n(String str) {
        if (str == null) {
            return;
        }
        n("error_ad_info", null, null, null, 0, null, null, null, str, 0, null);
    }

    public void n(com.byazt.rs.n nVar, String str) {
        n(str, nVar);
    }

    public void n(String str, JSONObject jSONObject, final JSONObject jSONObject2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject != null) {
            n(str, jSONObject.optString("rit"), jSONObject.optString("cid"), jSONObject.optString("req_id"), jSONObject.optInt("adtype"), jSONObject.optString(MediationConstant.EXTRA_DURATION), null, null, null, 0, new com.byazt.rs.n() { // from class: com.byazt.eji.s.19
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject3) throws JSONException {
                    return jSONObject2;
                }
            });
        } else {
            n(str, jSONObject2);
        }
    }

    public void qg(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n(str, jSONObject);
    }

    public void n(pk pkVar, String str) {
        if (pkVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", str);
            jSONObject.putOpt("req_id", pkVar.ou());
            jSONObject.putOpt("aid", pkVar.wm());
            jSONObject.putOpt("cid", pkVar.q());
        } catch (JSONException unused) {
        }
        n("showTime", jSONObject, (Throwable) null);
    }

    public void n(String str, Throwable th) {
        n(str, (JSONObject) null, th);
    }

    public void n(final JSONObject jSONObject, final JSONObject jSONObject2) {
        n("device_register", new com.byazt.rs.n() { // from class: com.byazt.eji.s.20
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject3) throws JSONException {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("request", jSONObject);
                jSONObject4.put("response", jSONObject2);
                return jSONObject4;
            }
        });
    }

    public void n(final String str, final JSONObject jSONObject, final Throwable th) {
        n("exception", new com.byazt.rs.n() { // from class: com.byazt.eji.s.22
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("scene", str);
                jSONObject3.putOpt("object", jSONObject);
                Throwable th2 = th;
                if (th2 != null) {
                    jSONObject3.putOpt("exception", Log.getStackTraceString(th2));
                }
                return jSONObject3;
            }
        });
    }

    public void s(final JSONObject jSONObject) {
        n("run_package", new com.byazt.rs.n() { // from class: com.byazt.eji.s.23
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void s(final String str, final JSONObject jSONObject) {
        n(new com.byazt.rs.n() { // from class: com.byazt.eji.s.24
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("scene", str);
                jSONObject3.putOpt("object", jSONObject);
                return jSONObject3;
            }
        }, "soverify_result");
    }

    public void q(JSONObject jSONObject) {
        n("saas_schema", jSONObject);
    }

    public void l(JSONObject jSONObject) {
        n("saas_playable_end_card", jSONObject);
    }

    public void n(final pk pkVar, final long j, final boolean z, final boolean z2) {
        n("auth_time", new com.byazt.rs.n() { // from class: com.byazt.eji.s.25
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("req_id", pkVar.ou());
                jSONObject2.put("auth", z);
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject2.put("time_out", z2);
                ic icVarL_ = pkVar.L_();
                if (icVarL_ != null) {
                    jSONObject2.put("saas_info", icVarL_.n());
                }
                jSONObject2.put("ext", pkVar.F_());
                return jSONObject2;
            }
        });
    }

    public void n(final String str, final String str2, final int i, final JSONObject jSONObject) {
        n("convert_event", new com.byazt.rs.n() { // from class: com.byazt.eji.s.26
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("event_type", str2);
                jSONObject3.putOpt(NotificationCompat.CATEGORY_EVENT, str);
                jSONObject3.putOpt("object", jSONObject);
                jSONObject3.putOpt(WebLoginFragment.QUERY_KEY_ID, Integer.valueOf(i));
                return jSONObject3;
            }
        });
    }

    public void w(JSONObject jSONObject) {
        qg("live_init_success", jSONObject);
    }

    public void x(JSONObject jSONObject) {
        qg("live_init_start", jSONObject);
    }

    public void n(final pk pkVar, int i, final int i2, final View view) {
        n("register_info", String.valueOf(w.cy(pkVar)), pkVar == null ? null : pkVar.ou(), i, new com.byazt.rs.n() { // from class: com.byazt.eji.s.27
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", i2);
                jSONObject2.put("targetIsNull", view == null ? 1 : 0);
                com.byazt.aci.n.n(jSONObject2, pkVar);
                return jSONObject2;
            }
        });
    }

    public void n(final pk pkVar, final Object obj) {
        n("upie_img_play_success", pkVar == null ? null : pkVar.ou(), new com.byazt.rs.n() { // from class: com.byazt.eji.s.28
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MediationConstant.EXTRA_DURATION, obj);
                com.byazt.aci.n.n(jSONObject2, pkVar);
                if (com.byazt.aci.n.q(pkVar) || com.byazt.aci.n.n(pkVar)) {
                    String strRv = com.byazt.aci.n.rv(pkVar);
                    if (com.byazt.ts.qg.n().n(strRv)) {
                        jSONObject2.put("simple_uttie_url", strRv);
                    }
                }
                return jSONObject2;
            }
        });
    }

    public void qg(final pk pkVar, int i, String str) {
        n("upie_img_play_fail", null, null, pkVar == null ? null : pkVar.ou(), 0, "", null, null, str, i, new com.byazt.rs.n() { // from class: com.byazt.eji.s.29
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                com.byazt.aci.n.n(jSONObject2, pkVar);
                if (com.byazt.aci.n.q(pkVar) || com.byazt.aci.n.n(pkVar)) {
                    String strRv = com.byazt.aci.n.rv(pkVar);
                    if (com.byazt.ts.qg.n().n(strRv)) {
                        jSONObject2.put("simple_uttie_url", strRv);
                    }
                }
                return jSONObject2;
            }
        });
    }

    public void qg(pk pkVar, final String str) {
        Object[] objArr = new Object[2];
        n("uttie_start", pkVar == null ? null : pkVar.ou(), new com.byazt.rs.n() { // from class: com.byazt.eji.s.30
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uttie_url", str);
                return jSONObject2;
            }
        });
    }

    public void n(pk pkVar, final String str, final long j) {
        Object[] objArr = new Object[3];
        Long.valueOf(j);
        n("uttie_played", pkVar == null ? null : pkVar.ou(), new com.byazt.rs.n() { // from class: com.byazt.eji.s.31
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uttie_url", str);
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                return jSONObject2;
            }
        });
    }

    public void n(final pk pkVar, final boolean z, final long j, final boolean z2) {
        n(new com.byazt.rs.n() { // from class: com.byazt.eji.s.33
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                pk pkVar2 = pkVar;
                if (pkVar2 != null && jSONObject != null) {
                    jSONObject.putOpt("req_id", pkVar2.ou());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", z ? 1 : 0);
                jSONObject2.put("is_first", z2 ? 1 : 0);
                if (z && jSONObject != null) {
                    jSONObject.put(MediationConstant.EXTRA_DURATION, String.valueOf(j));
                }
                return jSONObject2;
            }
        }, "easy_play_first_frame");
    }

    public void s(pk pkVar, final String str) {
        n("uttie_close", pkVar == null ? null : pkVar.ou(), new com.byazt.rs.n() { // from class: com.byazt.eji.s.34
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uttie_url", str);
                return jSONObject2;
            }
        });
    }

    public void n(pk pkVar, String str, final JSONObject jSONObject) {
        n(str, null, null, pkVar == null ? null : pkVar.ou(), 0, null, pkVar == null ? null : pkVar.F_(), null, null, 0, new com.byazt.rs.n() { // from class: com.byazt.eji.s.35
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void q(pk pkVar, String str) {
        n(pkVar, str, (JSONObject) null);
    }

    public void fs(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        n("device_qty_compare", jSONObject);
    }

    public void rv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        n("device_bytebench", jSONObject);
    }

    public void tj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        n("render_timeout_opt", jSONObject);
    }

    public void cp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        n("landingpage_check_info", jSONObject);
    }

    public static void n(com.byazt.zq.qg qgVar, long j, final long j2, final long j3, final int i, final int i2, final int i3) {
        n().n("splash_creative_check", qgVar.q(), (String) null, i, (int) j, (String) null, new com.byazt.rs.n() { // from class: com.byazt.eji.s.36
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                int i4 = i3 > 0 ? 2 : 1;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("available_type", Integer.valueOf(i4));
                jSONObject2.putOpt("creative_check_duration", Long.valueOf(j2));
                jSONObject2.putOpt("total_duration", Long.valueOf(j3));
                jSONObject2.putOpt("ad_slot_type", Integer.valueOf(i));
                jSONObject2.putOpt("check_count", Integer.valueOf(i2));
                jSONObject2.putOpt("success_count", Integer.valueOf(i3));
                return jSONObject2;
            }
        });
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        n("type_realtime_feature_cost", jSONObject);
    }

    public void n(final pk pkVar, final float f, final float f2, final float f3, final float f4, final View view) {
        n("video_size_gap", pkVar == null ? null : pkVar.ou(), new com.byazt.rs.n() { // from class: com.byazt.eji.s.37
            /* JADX WARN: Code duplicated, block: B:19:0x006c  */
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                float fAbs;
                JSONObject jSONObject2 = new JSONObject();
                com.byazt.aci.n.n(jSONObject2, pkVar);
                pk pkVar2 = pkVar;
                jSONObject2.put("image_mode", pkVar2 != null ? pkVar2.ge() : 0);
                pk pkVar3 = pkVar;
                jSONObject2.put("slot_type", pkVar3 != null ? w.d(pkVar3) : 0);
                jSONObject2.put("resolution_w", f3);
                jSONObject2.put("resolution_h", f4);
                jSONObject2.put("container_w", f);
                jSONObject2.put("container_h", f2);
                float f5 = f3;
                float fAbs2 = -1.0f;
                if (f5 != 0.0f) {
                    float f6 = f4;
                    if (f6 != 0.0f) {
                        float f7 = f;
                        if (f7 != 0.0f) {
                            float f8 = f2;
                            if (f8 != 0.0f) {
                                fAbs = Math.abs((f7 / f8) - (f5 / f6));
                            } else {
                                fAbs = -1.0f;
                            }
                        } else {
                            fAbs = -1.0f;
                        }
                    } else {
                        fAbs = -1.0f;
                    }
                } else {
                    fAbs = -1.0f;
                }
                jSONObject2.put("size_gap_value", fAbs);
                View view2 = view;
                float width = view2 != null ? view2.getWidth() : 0.0f;
                View view3 = view;
                float height = view3 != null ? view3.getHeight() : 0.0f;
                jSONObject2.put("dev_container_w", width);
                jSONObject2.put("dev_container_h", height);
                float f9 = f3;
                if (f9 != 0.0f) {
                    float f10 = f4;
                    if (f10 != 0.0f && width != 0.0f && height != 0.0f) {
                        fAbs2 = Math.abs((width / height) - (f9 / f10));
                    }
                }
                jSONObject2.put("dev_size_gap_value", fAbs2);
                jSONObject2.put("gap_gaosi_fill", 0);
                return jSONObject2;
            }
        });
    }

    public void n(final long j, final long j2, final int i, final int i2) {
        n("encrypt_track", new com.byazt.rs.n() { // from class: com.byazt.eji.s.38
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                long j3 = j;
                if (j3 >= 0) {
                    jSONObject2.put("initZeusCostTime", j3);
                }
                long j4 = j2;
                if (j4 > 0) {
                    jSONObject2.put("loadCostTime", j4);
                }
                jSONObject2.put("eventRes", i);
                jSONObject2.put("eventType", i2);
                return jSONObject2;
            }
        });
    }

    public void qg(pk pkVar, String str, final JSONObject jSONObject) {
        if (pkVar == null) {
            n("dl_meta_null_".concat(String.valueOf(str)), jSONObject, (Throwable) null);
        } else {
            n().n(str, w.n(pkVar, (String) null), pkVar.q(), pkVar.ou(), w.d(pkVar), null, pkVar.F_(), null, null, 0, new com.byazt.rs.n() { // from class: com.byazt.eji.s.39
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
                    return jSONObject;
                }
            });
        }
    }

    public void n(pk pkVar, int i, final com.byazt.nj.qg qgVar) {
        if (pkVar == null || qgVar == null) {
            return;
        }
        n("ad_show_threshold", w.n(pkVar, (String) null), pkVar.q(), pkVar.ou(), i, null, pkVar.F_(), null, null, 0, new com.byazt.rs.n() { // from class: com.byazt.eji.s.40
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("show_check_poll_time", qgVar.qg());
                jSONObject2.put("show_check_need_double_check", qgVar.s());
                jSONObject2.put("show_check_blocked", qgVar.q());
                jSONObject2.put("click_show", qgVar.l());
                return jSONObject2;
            }
        });
    }

    public void qg(pk pkVar) {
        if (pkVar != null && pkVar.rv() == 4) {
            final um umVarD_ = pkVar.D_();
            final a aVarXs = pkVar.xs();
            n("download_click_conf", w.n(pkVar, (String) null), pkVar.q(), pkVar.ou(), w.d(pkVar), null, pkVar.F_(), null, null, 0, new com.byazt.rs.n() { // from class: com.byazt.eji.s.41
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        um umVar = umVarD_;
                        if (umVar != null) {
                            umVar.n(jSONObject2);
                        }
                        a aVar = aVarXs;
                        if (aVar != null) {
                            jSONObject2.put("download_sdk_conf", aVar.s());
                        }
                    } catch (JSONException unused) {
                    }
                    return jSONObject2;
                }
            });
        }
    }
}
