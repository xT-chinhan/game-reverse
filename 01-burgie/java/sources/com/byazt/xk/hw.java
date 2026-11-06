package com.byazt.xk;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.byazt.ca.uc;
import com.byazt.hg.lv;
import com.byazt.hg.of;
import com.byazt.is.vk;
import com.byazt.mg.PluginConstants;
import com.byazt.pr.hn;
import com.byazt.qam.c;
import com.byazt.qe.x;
import com.byazt.sd.a;
import com.byazt.sd.ny;
import com.byazt.sd.y;
import com.byazt.wt.ls;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 778, 13})
public class hw {
    public static String hw = "";
    public static volatile hw pr;

    private hw() {
    }

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    public void pr(final String str, final String str2, final String str3, final String str4, final int i, final String str5, final String str6, final String str7, final String str8, final int i2, final com.byazt.ttf.pr prVar) {
        zo.pr(new fw("stats") { // from class: com.byazt.xk.hw.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny()).pr(str, (byte) 1, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.1.1
                    @Override // com.byazt.ttf.pr
                    public JSONObject pr(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2;
                        jSONObject.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(i2));
                        if (prVar == null) {
                            jSONObject2 = null;
                        } else {
                            jSONObject2 = prVar.pr(jSONObject);
                        }
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
                            jSONObject.putOpt(Constants.ERROR_MSG_FIELD, str8);
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
                            jSONObject.putOpt("duration", str5);
                        }
                        jSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
                        hn.pr(str, jSONObject);
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        if (!TextUtils.isEmpty(ls.aj)) {
                            jSONObject2.put("wrong_stats_url", ls.aj);
                        }
                        if (!TextUtils.isEmpty(ls.vk)) {
                            jSONObject2.put("wrong_applog_url", ls.vk);
                        }
                        try {
                            jSONObject2.put("device_score", Double.parseDouble(com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", com.byazt.zb.pr.x())));
                        } catch (Exception e) {
                        }
                        try {
                            jSONObject2.put("abtest_version", com.byazt.sd.zo.nt().l());
                        } catch (Exception e2) {
                        }
                        if (com.byazt.sd.zo.nt().uc()) {
                            jSONObject2.putOpt("first_of_two", 1);
                        }
                        return jSONObject2;
                    }
                });
            }
        });
    }

    public void pr(String str, com.byazt.ttf.pr prVar) {
        pr(str, 0, (String) null, prVar);
    }

    public void pr(String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pr(str, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.12
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void pr(String str, String str2, com.byazt.ttf.pr prVar) {
        pr(str, str2, (String) null, prVar);
    }

    public void hw(String str, String str2, com.byazt.ttf.pr prVar) {
        pr(str, null, null, null, 0, str2, null, null, "", 0, prVar);
    }

    public void pr(String str, int i, String str2, com.byazt.ttf.pr prVar) {
        pr(str, null, null, null, 0, null, null, null, str2, i, prVar);
    }

    public void pr(String str, String str2, String str3, com.byazt.ttf.pr prVar) {
        pr(str, null, null, str2, 0, null, str3, null, "", 0, prVar);
    }

    public void pr(String str, String str2, String str3, int i, com.byazt.ttf.pr prVar) {
        pr(str, str2, null, str3, i, null, null, null, "", 0, prVar);
    }

    public void pr(String str, String str2, String str3, int i, int i2, String str4, com.byazt.ttf.pr prVar) {
        pr(str, str2, null, str3, i, null, null, null, str4, i2, prVar);
    }

    private void pr(String str, int i, String str2, int i2, String str3, com.byazt.ttf.pr prVar) {
        pr(str, null, null, null, i, String.valueOf(str2), null, null, str3, i2, prVar);
    }

    public void pr(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pr("render_backup", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.22
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void pr(final long j, final long j2, final int i) {
        long j3 = j2 - j;
        if (j3 <= 0 || j3 >= 30000000) {
            return;
        }
        hw("general_label", String.valueOf(j3), new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.33
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("starttime", j);
                    jSONObject2.put("endtime", j2);
                    jSONObject2.put("start_type", i);
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public void pr(String str, final String str2) {
        hw("sdk_retention", str, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.37
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("close_time_1", str2);
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public void pr(final Object obj, final Object obj2, final String str, final String str2, final String str3) {
        pr("obm_result", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.38
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
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
                    jSONObject2.put(Constants.ERROR_MSG_FIELD, str);
                    jSONObject2.put("req_id", str2);
                    jSONObject2.put(MediationConstant.EXTRA_ADID, str3);
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public void pr(of ofVar, int i, String str) {
        String str2;
        String str3;
        String strNy;
        if (ofVar == null) {
            str2 = "";
            str3 = str2;
            strNy = str3;
        } else {
            String strPr = ls.pr(ofVar, "");
            String strX = ofVar.x();
            strNy = ofVar.ny();
            str2 = strPr;
            str3 = strX;
        }
        pr("use_player", str2, str3, strNy, 0, null, null, null, str, i, null);
    }

    public void pr(String str, int i, int i2, String str2, int i3, String str3, long j, boolean z, boolean z2, boolean z3, boolean z4, int i4) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i3);
            jSONObject.put("message", str3);
            jSONObject.put("version", i2);
            jSONObject.put("current_version", i);
            jSONObject.put("package_name", str);
            jSONObject.put(BreakpointSQLiteKey.URL, str2);
            jSONObject.put("duration", j);
            jSONObject.put("max_retry_count", vk.hw(str));
            jSONObject.put("uuid", com.byazt.mp.pr.hn());
            jSONObject.put("isRetry", z);
            jSONObject.put("is_old_plugin", z2);
            jSONObject.put("is_resume_download", z3);
            jSONObject.put("is_downloader", z4);
            jSONObject.put("downloader_try_count", i4);
            jSONObject.put("host_abi", com.byazt.sp.hw.pr());
        } catch (Throwable th) {
        }
        pr("plugin_download", 0, String.valueOf(j), i3, str3, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.39
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void hw(final String str, String str2) {
        final String strConcat;
        String str3;
        final String str4;
        final String str5;
        final JSONObject jSONObject;
        String str6;
        File[] fileArrListFiles;
        String str7 = "";
        if (!TextUtils.isEmpty(str) && !str.startsWith("zeus") && !TextUtils.equals("plugin_load_failed", str)) {
            strConcat = "zeus_".concat(String.valueOf(str));
        } else {
            strConcat = str;
        }
        JSONObject jSONObject2 = null;
        try {
            if (TextUtils.isEmpty(str2)) {
                str6 = "";
            } else {
                JSONObject jSONObject3 = new JSONObject(str2);
                try {
                    String strOptString = jSONObject3.optString("version_code");
                    try {
                        String strOptString2 = jSONObject3.optString("plugin_package_name");
                        if ("zeus_install_finish".equals(strConcat) && "com.byted.pangle".equals(strOptString2)) {
                            hw = com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny()).hw() + "," + strOptString;
                            com.byazt.sd.hw.pr().pr("plugin_install_msg", hw);
                            boolean zPr = c.pr().pr(a.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            jSONObject3.putOpt("sd_per", Boolean.valueOf(zPr));
                            File file = new File(hn() + "ins/" + com.byazt.sd.zo.nt().ny(), strOptString);
                            boolean zExists = file.exists();
                            jSONObject3.putOpt("is_installed", Boolean.valueOf(zExists));
                            if (zExists && zPr) {
                                File parentFile = file.getParentFile();
                                if (parentFile != null && (fileArrListFiles = parentFile.listFiles()) != null && !strOptString.isEmpty()) {
                                    for (File file2 : fileArrListFiles) {
                                        if (file2 != null && !TextUtils.equals(file2.getName(), strOptString)) {
                                            file2.delete();
                                        }
                                    }
                                }
                                str5 = strOptString;
                                str4 = strOptString2;
                                jSONObject = jSONObject3;
                            } else {
                                jSONObject3.putOpt("mkdirs", Boolean.valueOf(file.mkdirs()));
                            }
                            com.byazt.xlm.c.hn(new fw("plugin_report") { // from class: com.byazt.xk.hw.40
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!"exception".equals(str)) {
                                        hw.hw(strConcat, jSONObject, str5, str4);
                                        return;
                                    }
                                    JSONObject jSONObject4 = jSONObject;
                                    if (jSONObject4 != null) {
                                        hw.this.pr(jSONObject4.optString("scene"), jSONObject, (Throwable) null);
                                    }
                                }
                            });
                        }
                        jSONObject2 = jSONObject3;
                        str7 = strOptString;
                        str6 = strOptString2;
                    } catch (JSONException e) {
                        jSONObject2 = jSONObject3;
                        str7 = strOptString;
                        str3 = "";
                        str4 = str3;
                        str5 = str7;
                        jSONObject = jSONObject2;
                    }
                } catch (JSONException e2) {
                    str3 = "";
                    jSONObject2 = jSONObject3;
                }
            }
            str4 = str6;
            str5 = str7;
            jSONObject = jSONObject2;
        } catch (JSONException e3) {
            str3 = "";
        }
        com.byazt.xlm.c.hn(new fw("plugin_report") { // from class: com.byazt.xk.hw.40
            @Override // java.lang.Runnable
            public void run() {
                if (!"exception".equals(str)) {
                    hw.hw(strConcat, jSONObject, str5, str4);
                    return;
                }
                JSONObject jSONObject4 = jSONObject;
                if (jSONObject4 != null) {
                    hw.this.pr(jSONObject4.optString("scene"), jSONObject, (Throwable) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(String str, final JSONObject jSONObject, String str2, String str3) {
        if (jSONObject != null) {
            try {
                jSONObject.put("current_version", "7.7.1.4");
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
                jSONObject.put("max_retry_count", vk.hw(str3));
                jSONObject.put("uuid", com.byazt.mp.pr.hn());
                jSONObject.put("host_abi", com.byazt.sp.hw.pr());
            } catch (Throwable th) {
                return;
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("boost", true);
        int iOptInt = jSONObject.optInt(jSONObject.has("status_code") ? "status_code" : PluginConstants.KEY_ERROR_CODE);
        String strOptString = jSONObject.optString("message");
        String strOptString2 = jSONObject.optString("duration");
        if ("zeus_load_finish".equals(str)) {
            int i = pr(str2, str3, jSONObject) ? 1 : 0;
            jSONObject.putOpt("first_load", Integer.valueOf(i));
            pr().pr(str, i, strOptString2, iOptInt, strOptString, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.41
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                    return jSONObject;
                }
            });
            return;
        }
        pr().pr(str, 0, strOptString2, iOptInt, strOptString, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    private static String hn() {
        return new String(Base64.decode("L3NkY2FyZC9Eb3dubG9hZC8uY3NqLw==", 2), StandardCharsets.UTF_8);
    }

    public void pr(final of ofVar) {
        if (ofVar == null) {
            return;
        }
        pr("saas_show_miss", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    int iHn = com.byazt.eg.hw.pr().hn();
                    int iC = com.byazt.eg.hw.pr().c();
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
                    jSONObject2.put("ext", ofVar.B_());
                    jSONObject2.put("live_sdk_status", iHn);
                    jSONObject2.put("live_auth_status", iC);
                    jSONObject2.put("app_start_time", jElapsedRealtime);
                    jSONObject2.put("is_web", ofVar.x_());
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public static void hn(String str, String str2) {
        String strHn = hn();
        File file = new File(strHn + com.byazt.sd.zo.nt().ny(), str2);
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(strHn + "ins/" + com.byazt.sd.zo.nt().ny(), str2);
        if (file2.exists()) {
            file2.delete();
        }
        File file3 = new File(uc.pr(a.getContext(), false, null), str);
        if (TextUtils.equals(com.byazt.zp.c.pr(file3), str2)) {
            com.byazt.zp.c.hw(file3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("version_code", str2);
                jSONObject.putOpt("package_name", str);
            } catch (Exception e) {
            }
            pr().pr("d_d", jSONObject, (Throwable) null);
        }
    }

    public static boolean pr(String str, String str2, JSONObject jSONObject) {
        File[] fileArrListFiles;
        Context context = a.getContext();
        File file = new File(uc.pr(context, false, null), str2);
        String strPr = com.byazt.zp.c.pr(file);
        try {
            jSONObject.putOpt("last_plugin_version", strPr);
            jSONObject.putOpt("version_file", file.getAbsoluteFile());
            boolean zPr = c.pr().pr(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            jSONObject.putOpt("sd_per", Boolean.valueOf(zPr));
            String strHn = hn();
            File file2 = new File(strHn + com.byazt.sd.zo.nt().ny(), str);
            boolean zExists = file2.exists();
            jSONObject.putOpt("is_loaded", Boolean.valueOf(zExists));
            jSONObject.putOpt("is_installed", Boolean.valueOf(new File(strHn + "ins/" + com.byazt.sd.zo.nt().ny(), str).exists()));
            if (zExists && zPr) {
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
            com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
            String strHw = hnVarPr.hw("plugin_first_load", "");
            if (!TextUtils.isEmpty(strHw)) {
                jSONObject.putOpt("plugin_first_load", strHw);
            }
            hnVarPr.pr("plugin_first_load", str);
            if (!TextUtils.equals(str, strPr)) {
                jSONObject.putOpt("write_suc", Boolean.valueOf(com.byazt.zp.c.pr(str, file)));
                String strHw2 = hw;
                if (TextUtils.isEmpty(strHw2)) {
                    strHw2 = hnVarPr.hw("plugin_install_msg", "");
                }
                jSONObject.putOpt("install_msg", strHw2);
                return true;
            }
        } catch (JSONException e) {
        }
        return false;
    }

    public void pr(final JSONObject jSONObject, String str) {
        pr("lp_monitor", str, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.4
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void hw() {
        pr("sdk_permission", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.5
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                x xVarA = com.byazt.sd.zo.nt().a();
                boolean zHw = xVarA.hw();
                boolean zPr = xVarA.pr();
                boolean zC = xVarA.c();
                boolean zX = xVarA.x();
                boolean zHn = xVarA.hn();
                boolean zUc = xVarA.uc();
                String strK = xVarA.k();
                JSONObject jSONObject2 = new JSONObject();
                int i = 1;
                try {
                    jSONObject2.put("access_fine_location", zPr ? 1 : 0);
                    jSONObject2.put("applist", zHw ? 1 : 0);
                    jSONObject2.put("external_storage", zC ? 1 : 0);
                    jSONObject2.put("wifi_state", zX ? 1 : 0);
                    jSONObject2.put("phone_state", zHn ? 1 : 0);
                    jSONObject2.put("can_use_androidId", zUc ? 1 : 0);
                    jSONObject2.put("dev_oaid", strK);
                    if (!com.byazt.sd.zo.nt().m()) {
                        i = 0;
                    }
                    jSONObject2.put("uip", i);
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public void pr(of ofVar, final JSONObject jSONObject) {
        if (ofVar == null) {
            return;
        }
        pr("jsb_video_action", ls.pr(ofVar, ""), ofVar.ny(), 0, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.6
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public static void pr(String str, final long j, final boolean z, final String str2, final JSONObject jSONObject) {
        pr().pr("over_freq", str, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.7
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_agg", z);
                jSONObject3.put("timestamp", j);
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

    public static void pr(final int i, final int i2) {
        pr().pr("system_change", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.8
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
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

    private boolean pr(String str, int i) {
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        int iHw = hnVarPr.hw(str, 0);
        boolean z = (iHw & 2) == 0 || (iHw & 1) != i;
        if (z) {
            hnVarPr.pr(str, i + 2);
        }
        return z;
    }

    public void pr(int i, of ofVar, boolean z) {
        String strValueOf = String.valueOf(ls.m(ofVar));
        if (!pr(strValueOf, z ? 1 : 0)) {
            return;
        }
        pr().pr(z ? "reg_creative" : "no_reg_creative", strValueOf, (String) null, i, (com.byazt.ttf.pr) null);
    }

    public void pr(final boolean z, final String[] strArr) {
        pr("download_permission", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.9
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
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
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public void pr(final String str, final String str2, final String str3, final boolean z) {
        pr("get_bidding_token", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.10
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                boolean zHw = a.hw().hw(str);
                JSONObject jSONObject2 = new JSONObject();
                if (zHw) {
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

    public void pr(final long j, final long j2, final boolean z, final com.byazt.la.hn hnVar, final JSONObject jSONObject, final int i) {
        pr("pitaya_init", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.11
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("duration", j2);
                jSONObject3.put("ext_plugin_code", y.hw());
                jSONObject3.put(TrackAction.SUCCESS, z ? 1 : 0);
                jSONObject3.put("retry_count", i);
                jSONObject3.put("python_vm_start_time", j);
                JSONObject jSONObject4 = jSONObject;
                if (jSONObject4 != null) {
                    jSONObject3.putOpt("record", jSONObject4);
                }
                com.byazt.la.hn hnVar2 = hnVar;
                if (hnVar2 != null) {
                    jSONObject3.putOpt("error", com.byazt.ba.x.pr(hnVar2));
                }
                return jSONObject3;
            }
        });
    }

    public void hw(final JSONObject jSONObject) {
        pr("pitaya_package_init", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.13
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void pr(final int i, ny nyVar) {
        if (nyVar == null) {
            return;
        }
        final JSONObject jSONObjectPr = nyVar.pr(-1L);
        final long jHw = nyVar.hw();
        pr("bid_token_time", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.14
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                try {
                    jSONObjectPr.put("total", jHw);
                    jSONObjectPr.put("opt_sample", 1);
                    jSONObjectPr.put("slot_type", i);
                } catch (Throwable th) {
                }
                return jSONObjectPr;
            }
        });
    }

    public void pr(final int i, final long j, final String str, final int i2) {
        pr("encrypt_track", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.15
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
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
                } catch (Throwable th) {
                    return null;
                }
            }
        });
    }

    public void pr(final int i, final long j, final Boolean bool, final String str) {
        pr("encrypt_track", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.16
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    long j2 = j;
                    if (j2 >= 0) {
                        jSONObject2.put("cost_time", j2);
                    }
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        jSONObject2.put("init_succ", bool2.booleanValue() ? 1 : 2);
                    }
                    jSONObject2.put("opt_sample", 1);
                    int i2 = i;
                    if (i2 != -1) {
                        jSONObject2.put("event_res", i2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject2.put("type", str);
                    }
                    return jSONObject2;
                } catch (Throwable th) {
                    return null;
                }
            }
        });
    }

    public void pr(int i) {
        pr("has_pre_req", 0, (String) null, i, (String) null, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.17
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                return null;
            }
        });
    }

    public void pr(final int i, final String str, String str2, String str3, final String str4) {
        pr("fetch_adm_status", str3, str2, 0, i, (String) null, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.18
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("fetch_adm", i == 0 ? 1 : 0);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, i);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject2.put("material_keys", str4);
                return jSONObject2;
            }
        });
    }

    public void hw(int i) {
        pr("get_ad_cache_failed", i, (String) null, (com.byazt.ttf.pr) null);
    }

    public void pr(String str) {
        if (str == null) {
            return;
        }
        pr("error_ad_info", null, null, null, 0, null, null, null, str, 0, null);
    }

    public void pr(com.byazt.ttf.pr prVar, String str) {
        pr(str, prVar);
    }

    public void pr(String str, JSONObject jSONObject, final JSONObject jSONObject2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject != null) {
            pr(str, jSONObject.optString("rit"), jSONObject.optString("cid"), jSONObject.optString("req_id"), jSONObject.optInt("adtype"), jSONObject.optString("duration"), null, null, null, 0, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.19
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject3) throws JSONException {
                    return jSONObject2;
                }
            });
        } else {
            pr(str, jSONObject2);
        }
    }

    public void hw(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pr(str, jSONObject);
    }

    public void pr(of ofVar, String str) {
        if (ofVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", str);
            jSONObject.putOpt("req_id", ofVar.ny());
            jSONObject.putOpt("aid", ofVar.fo());
            jSONObject.putOpt("cid", ofVar.x());
        } catch (JSONException e) {
        }
        pr("showTime", jSONObject, (Throwable) null);
    }

    public void pr(String str, Throwable th) {
        pr(str, (JSONObject) null, th);
    }

    public void pr(final JSONObject jSONObject, final JSONObject jSONObject2) {
        pr("device_register", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.20
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject3) throws JSONException {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("request", jSONObject);
                jSONObject4.put("response", jSONObject2);
                return jSONObject4;
            }
        });
    }

    public void pr(final String str, final JSONObject jSONObject, final Throwable th) {
        pr("exception", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.21
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
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

    public void hn(final String str, final JSONObject jSONObject) {
        pr(new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.23
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("scene", str);
                jSONObject3.putOpt("object", jSONObject);
                return jSONObject3;
            }
        }, "soverify_result");
    }

    public void hn(JSONObject jSONObject) {
        pr("saas_schema", jSONObject);
    }

    public void x(JSONObject jSONObject) {
        pr("saas_playable_end_card", jSONObject);
    }

    public void pr(final of ofVar, final long j, final boolean z, final boolean z2) {
        pr("auth_time", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.24
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("req_id", ofVar.ny());
                jSONObject2.put("auth", z);
                jSONObject2.put("duration", j);
                jSONObject2.put("time_out", z2);
                lv lvVarH_ = ofVar.H_();
                if (lvVarH_ != null) {
                    jSONObject2.put("saas_info", lvVarH_.pr());
                }
                jSONObject2.put("ext", ofVar.B_());
                return jSONObject2;
            }
        });
    }

    public void pr(final String str, final String str2, final int i, final JSONObject jSONObject) {
        pr("convert_event", new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.25
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("event_type", str2);
                jSONObject3.putOpt(NotificationCompat.CATEGORY_EVENT, str);
                jSONObject3.putOpt("object", jSONObject);
                jSONObject3.putOpt("state", Integer.valueOf(i));
                return jSONObject3;
            }
        });
    }

    public void c(JSONObject jSONObject) {
        hw("live_init_success", jSONObject);
    }

    public void uc(JSONObject jSONObject) {
        hw("live_init_start", jSONObject);
    }

    public void pr(final of ofVar, int i, final int i2, final View view) {
        pr("register_info", String.valueOf(ls.m(ofVar)), ofVar == null ? null : ofVar.ny(), i, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.26
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", i2);
                jSONObject2.put("targetIsNull", view == null ? 1 : 0);
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                return jSONObject2;
            }
        });
    }

    public void pr(final of ofVar, final Object obj) {
        pr("upie_img_play_success", ofVar == null ? null : ofVar.ny(), new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.27
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", obj);
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                return jSONObject2;
            }
        });
    }

    public void hw(final of ofVar, int i, String str) {
        pr("upie_img_play_fail", null, null, ofVar == null ? null : ofVar.ny(), 0, "", null, null, str, i, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.28
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                return jSONObject2;
            }
        });
    }

    public void hw(of ofVar, final String str) {
        Object[] objArr = {"上报uttie_start埋点, uttieUrl = %s", str};
        pr("uttie_start", ofVar == null ? null : ofVar.ny(), new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.29
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uttie_url", str);
                return jSONObject2;
            }
        });
    }

    public void pr(of ofVar, final String str, final long j) {
        Object[] objArr = {"上报uttie_played埋点, uttieUrl = %s, duration = %d", str, Long.valueOf(j)};
        pr("uttie_played", ofVar == null ? null : ofVar.ny(), new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.30
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uttie_url", str);
                jSONObject2.put("duration", j);
                return jSONObject2;
            }
        });
    }

    public void pr(final of ofVar, final boolean z, final long j, final boolean z2) {
        pr(new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.31
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                of ofVar2 = ofVar;
                if (ofVar2 != null && jSONObject != null) {
                    jSONObject.putOpt("req_id", ofVar2.ny());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TrackAction.SUCCESS, z ? 1 : 0);
                jSONObject2.put("is_first", z2 ? 1 : 0);
                if (z && jSONObject != null) {
                    jSONObject.put("duration", String.valueOf(j));
                }
                return jSONObject2;
            }
        }, "easy_play_first_frame");
    }

    public void hn(of ofVar, final String str) {
        pr("uttie_close", ofVar == null ? null : ofVar.ny(), new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.32
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uttie_url", str);
                return jSONObject2;
            }
        });
    }

    public void pr(of ofVar, String str, final JSONObject jSONObject) {
        String strB_;
        String strNy = ofVar == null ? null : ofVar.ny();
        if (ofVar == null) {
            strB_ = null;
        } else {
            strB_ = ofVar.B_();
        }
        pr(str, null, null, strNy, 0, null, strB_, null, null, 0, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.34
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void x(of ofVar, String str) {
        pr(ofVar, str, (JSONObject) null);
    }

    public void fw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pr("device_qty_compare", jSONObject);
    }

    public void zo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pr("device_bytebench", jSONObject);
    }

    public void aj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pr("render_timeout_opt", jSONObject);
    }

    public void vk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pr("landingpage_check_info", jSONObject);
    }

    public static void pr(com.byazt.qe.hw hwVar, long j, final long j2, final long j3, final int i, final int i2, final int i3) {
        pr().pr("splash_creative_check", hwVar.x(), (String) null, i, (int) j, (String) null, new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.35
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
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

    public void w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pr("type_realtime_feature_cost", jSONObject);
    }

    public void pr(final of ofVar, final float f, final float f2, final float f3, final float f4, final View view) {
        pr("video_size_gap", ofVar == null ? null : ofVar.ny(), new com.byazt.ttf.pr() { // from class: com.byazt.xk.hw.36
            /* JADX WARN: Code duplicated, block: B:19:0x006d  */
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                float fAbs;
                JSONObject jSONObject2 = new JSONObject();
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                of ofVar2 = ofVar;
                jSONObject2.put("image_mode", ofVar2 != null ? ofVar2.jg() : 0);
                of ofVar3 = ofVar;
                jSONObject2.put("slot_type", ofVar3 != null ? ls.k(ofVar3) : 0);
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
}
