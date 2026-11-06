package com.bytedance.sdk.openadsdk.core.t;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.h.aq;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.jw;
import com.bytedance.sdk.openadsdk.core.nw.am;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.w;
import com.tapsdk.tapad.internal.tracker.experiment.h.f;
import com.umeng.ccg.a;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile u f3318ms;

    private boolean xr(com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar) {
        return xrVar == null;
    }

    private u() {
    }

    public static u ms() {
        if (f3318ms == null) {
            synchronized (u.class) {
                if (f3318ms == null) {
                    f3318ms = new u();
                }
            }
        }
        return f3318ms;
    }

    public void ms(com.bytedance.sdk.openadsdk.hi.ms.ms msVar, String str) {
        xr.ah().ms(msVar, str, true);
    }

    public void ms(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("render_backup").xr(jSONObject.toString());
            }
        }, "render_backup", true);
    }

    public static void ms(Result result, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        long j;
        String str;
        if (result != null) {
            ValueSet valueSetValues = result.values();
            boolean zIsSuccess = result.isSuccess();
            int iCode = result.code();
            String strMessage = result.message();
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("success", zIsSuccess);
                jSONObject4.put("code", iCode);
                jSONObject4.put("message", strMessage);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
            long jCurrentTimeMillis = -1;
            if (valueSetValues != null) {
                JSONObject jSONObject5 = (JSONObject) valueSetValues.objectValue(10, JSONObject.class);
                String strStringValue = valueSetValues.stringValue(5);
                if (jSONObject5 != null) {
                    jCurrentTimeMillis = System.currentTimeMillis() - jSONObject5.optLong("run_package_start", 0L);
                }
                jSONObject2 = (JSONObject) valueSetValues.objectValue(3, JSONObject.class);
                jSONObject3 = (JSONObject) valueSetValues.objectValue(4, JSONObject.class);
                j = jCurrentTimeMillis;
                str = strStringValue;
            } else {
                jSONObject2 = null;
                jSONObject3 = null;
                j = -1;
                str = null;
            }
            ms().ms(str, jSONObject != null ? jSONObject.optString(aq.h) : "", zIsSuccess, j, jSONObject2, jSONObject3, jSONObject4);
        }
    }

    public void ms(final long j, final long j2, final int i) {
        final long j3 = j2 - j;
        if (j3 <= 0 || j3 >= 30000000) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.12
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j);
                    jSONObject.put("endtime", j2);
                    jSONObject.put("start_type", i);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("general_label").ka(new StringBuilder().append(j3).toString()).xr(jSONObject.toString());
            }
        }, "general_label", true);
    }

    public void ms(final String str, final String str2) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.22
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("close_time_1", str2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("sdk_retention").ka(str).xr(jSONObject.toString());
            }
        }, "sdk_retention", true);
    }

    public void ms(final Object obj, final Object obj2, final String str, final String str2, final String str3) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.33
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    Object obj3 = obj;
                    if (obj3 instanceof Boolean) {
                        jSONObject.put("is_button", obj3);
                    }
                    Object obj4 = obj2;
                    if (obj4 instanceof Boolean) {
                        jSONObject.put("convert_result", obj4);
                    }
                    jSONObject.put("error_msg", str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put("ad_id", str3);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("obm_result").xr(jSONObject.toString());
            }
        }, "obm_result", true);
    }

    public void ms(String str, int i, int i2, String str2, final int i3, final String str3, final long j) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            jSONObject.put("message", str3);
            jSONObject.put("version", i2);
            jSONObject.put("current_version", i);
            jSONObject.put("package_name", str);
            jSONObject.put("url", str2);
            jSONObject.put("duration", j);
        } catch (Throwable unused) {
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.39
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("plugin_download").xr(i3).ab(str3).ka(new StringBuilder().append(j).toString()).xr(jSONObject.toString());
            }
        }, "plugin_download", true);
    }

    public void xr(final String str, final String str2) {
        com.bytedance.sdk.component.ch.ab.ah(new com.bytedance.sdk.component.ch.ny("plugin_report") { // from class: com.bytedance.sdk.openadsdk.core.t.u.40
            @Override // java.lang.Runnable
            public void run() {
                if (!"exception".equals(str)) {
                    u.ka(str, str2);
                    return;
                }
                try {
                    JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
                    if (str2 != null) {
                        u.this.ms(jSONObject.optString(a.j), jSONObject, (Throwable) null);
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ka(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !str.startsWith("zeus") && !TextUtils.equals("plugin_load_failed", str)) {
                str = "zeus_".concat(String.valueOf(str));
            }
            JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
            if (str2 != null) {
                jSONObject.put("current_version", "6.9.2.3");
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            final int iOptInt = jSONObject.has(f.z) ? jSONObject.optInt(f.z) : jSONObject.optInt("code");
            final String strOptString = jSONObject.optString("message");
            final String strOptString2 = jSONObject.optString("duration");
            final String string = jSONObject.toString();
            final String str3 = str;
            xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.41
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    if ("zeus_load_finish".equals(str3)) {
                        return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(str3).xr(string).xr(iOptInt).ab(strOptString).ka(strOptString2).ms(u.ms("6.9.2.3") ? 1 : 0);
                    }
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(str3).xr(string).xr(iOptInt).ka(strOptString2).ab(strOptString);
                }
            }, str, true);
        } catch (Throwable unused) {
        }
    }

    public static boolean ms(String str) {
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        String strXr = xrVarMs.xr("plugin_first_load", "");
        if (!TextUtils.isEmpty(strXr) && strXr.endsWith(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(strXr)) {
            str = strXr + "-" + str;
        }
        xrVarMs.ms("plugin_first_load", str);
        return true;
    }

    public void ah(final String str, final String str2) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.42
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("lp_monitor").c(str2).xr(str);
            }
        }, "lp_monitor", true);
    }

    public void xr() {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.43
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.f.ka kaVarQv = com.bytedance.sdk.openadsdk.core.ch.ub().qv();
                boolean zXr = kaVarQv.xr();
                boolean zMs = kaVarQv.ms();
                boolean zKa = kaVarQv.ka();
                boolean zD = kaVarQv.d();
                boolean zAh = kaVarQv.ah();
                boolean zC = kaVarQv.c();
                String strHi = kaVarQv.hi();
                JSONObject jSONObject = new JSONObject();
                int i = 1;
                try {
                    jSONObject.put("access_fine_location", zMs ? 1 : 0);
                    jSONObject.put("applist", zXr ? 1 : 0);
                    jSONObject.put("external_storage", zKa ? 1 : 0);
                    jSONObject.put("wifi_state", zD ? 1 : 0);
                    jSONObject.put("phone_state", zAh ? 1 : 0);
                    if (!zC) {
                        i = 0;
                    }
                    jSONObject.put("can_use_androidId", i);
                    jSONObject.put("dev_oaid", strHi);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("sdk_permission").xr(jSONObject.toString());
            }
        }, "sdk_permission", true);
    }

    public void ms(final lm lmVar, final JSONObject jSONObject) {
        if (lmVar == null) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarC = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("jsb_video_action").c(lmVar.eu());
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    xrVarC.xr(jSONObject2.toString());
                }
                xrVarC.ah(com.bytedance.sdk.openadsdk.core.jw.f.ms(lmVar, ""));
                return xrVarC;
            }
        }, "jsb_video_action", true);
    }

    public static void ms(final String str, final long j, final boolean z) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.3
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_agg", z);
                jSONObject.put("timestamp", j);
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("over_freq").ah(str).xr(jSONObject.toString());
            }
        }, "over_freq", true);
    }

    private void ms(final com.bytedance.sdk.openadsdk.hi.ms.ms msVar, final String str, boolean z) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.4
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar = (com.bytedance.sdk.openadsdk.core.t.ms.xr) msVar.ms();
                xrVar.ms(str);
                xrVar.ms(jCurrentTimeMillis);
                return xrVar;
            }
        }, str, true);
    }

    private void ah(com.bytedance.sdk.openadsdk.hi.ms.ms msVar, String str) {
        ms(msVar, str, true);
    }

    private void d(final com.bytedance.sdk.openadsdk.hi.ms.ms msVar, final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.5
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar = (com.bytedance.sdk.openadsdk.core.t.ms.xr) msVar.ms();
                xrVar.ms(str);
                xrVar.ms(jCurrentTimeMillis);
                return xrVar;
            }
        }, str, true);
    }

    public void ms(com.bytedance.sdk.openadsdk.hi.ms.ms msVar) {
        ah(msVar, "outer_call");
    }

    public void xr(com.bytedance.sdk.openadsdk.hi.ms.ms msVar) {
        ah(msVar, "outer_call_send");
    }

    public void ah(com.bytedance.sdk.openadsdk.hi.ms.ms msVar) {
        ah(msVar, "outer_call_no_rsp");
    }

    public void d(com.bytedance.sdk.openadsdk.hi.ms.ms msVar) {
        ah(msVar, "load_timeout");
    }

    public void ka(com.bytedance.sdk.openadsdk.hi.ms.ms msVar) {
        d(msVar, "express_ad_render");
    }

    private boolean ms(String str, int i) {
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        int iXr = xrVarMs.xr(str, 0);
        boolean z = (iXr & 2) == 0 || (iXr & 1) != i;
        if (z) {
            xrVarMs.ms(str, i + 2);
        }
        return z;
    }

    public void ms(final int i, lm lmVar, final boolean z) {
        final String strValueOf = String.valueOf(com.bytedance.sdk.openadsdk.core.jw.f.ny(lmVar));
        if (ms(strValueOf, z ? 1 : 0)) {
            xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.6
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarAh = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(i).ah(strValueOf);
                    if (z) {
                        xrVarAh.ms("reg_creative");
                    } else {
                        xrVarAh.ms("no_reg_creative");
                    }
                    return xrVarAh;
                }
            }, z ? "reg_creative" : "no_reg_creative", true);
        }
    }

    public void ms(final com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar) {
        if (xr(xrVar)) {
            return;
        }
        xrVar.ms("load_icon_error");
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.7
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return xrVar;
            }
        }, "load_icon_error", true);
    }

    public void c(com.bytedance.sdk.openadsdk.hi.ms.ms msVar) {
        d(msVar, "show_backup_endcard");
    }

    public void ab(com.bytedance.sdk.openadsdk.hi.ms.ms msVar) {
        ah(msVar, "splash_creative_check");
    }

    public void ms(final boolean z, final String[] strArr) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.8
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("if_sd", z ? 1 : 0);
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str).append(",");
                            }
                        }
                        jSONObject.put("permission", sb.toString());
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("download_permission").ms(System.currentTimeMillis() / 1000).xr(jSONObject.toString());
            }
        }, "download_permission", true);
    }

    public void x(final com.bytedance.sdk.openadsdk.hi.ms.ms msVar) {
        if (msVar == null) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.9
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return ((com.bytedance.sdk.openadsdk.core.t.ms.xr) msVar.ms()).ms("app_env").ms(System.currentTimeMillis() / 1000);
            }
        }, "app_env", true);
    }

    public void ms(final String str, final String str2, final String str3, final boolean z) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.10
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("get_bidding_token");
                boolean zXr = re.xr().xr(str);
                JSONObject jSONObject = new JSONObject();
                if (zXr) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("cache_req_id", str2);
                    }
                    if (TextUtils.equals(str3, "0")) {
                        jSONObject.put("no_cache_reason", 0);
                    } else if (TextUtils.equals(str3, "1")) {
                        jSONObject.put("no_cache_reason", 1);
                    }
                }
                if (z) {
                    jSONObject.put("opt_sample", 1);
                }
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "get_bidding_token", z);
    }

    public void ms(final long j, final com.bytedance.sdk.openadsdk.core.w.d dVar) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.11
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j);
                jSONObject.put("ext_plugin_code", jw.xr());
                com.bytedance.sdk.openadsdk.core.w.d dVar2 = dVar;
                if (dVar2 != null) {
                    jSONObject.put("success", dVar2.ms() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.w.c cVarXr = dVar.xr();
                    if (cVarXr != null) {
                        jSONObject.put("msg", cVarXr.toString());
                        jSONObject.put("code", cVarXr.ms());
                    }
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("pitaya_init").xr(jSONObject.toString());
            }
        }, "pitaya_init", true);
    }

    public void ms(final String str, final String str2, final boolean z, final long j, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.13
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("duration", j);
                jSONObject4.put("business", str);
                jSONObject4.put("biztype", str2);
                jSONObject4.put("result", z);
                JSONObject jSONObject5 = jSONObject;
                if (jSONObject5 != null) {
                    jSONObject4.put("package_info", jSONObject5.toString());
                }
                JSONObject jSONObject6 = jSONObject2;
                if (jSONObject6 != null) {
                    jSONObject4.put("error_info", jSONObject6.toString());
                }
                JSONObject jSONObject7 = jSONObject3;
                if (jSONObject7 != null) {
                    jSONObject4.put("common_info", jSONObject7.toString());
                }
                jSONObject4.put("ext_plugin_code", jw.xr());
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("pitaya_run_task").xr(jSONObject4.toString());
            }
        }, "pitaya_run_task", true);
    }

    public void ms(final int i, w wVar) {
        if (wVar == null) {
            return;
        }
        final JSONObject jSONObjectMs = wVar.ms(-1L);
        final long jXr = wVar.xr();
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.14
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("bid_token_time");
                try {
                    jSONObjectMs.put("total", jXr);
                    jSONObjectMs.put("opt_sample", 1);
                    jSONObjectMs.put("slot_type", i);
                    xrVarMs.xr(jSONObjectMs.toString());
                } catch (Throwable unused) {
                }
                return xrVarMs;
            }
        }, "get_bidding_token", true);
    }

    public void ms(int i, long j, String str) {
        ms(i, j, (Boolean) null, str);
    }

    public void ms(final int i, final long j, final Boolean bool, final String str) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.15
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j2 = j;
                    if (j2 >= 0) {
                        jSONObject.put("cost_time", j2);
                    }
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        jSONObject.put("init_succ", bool2.booleanValue() ? 1 : 2);
                    }
                    jSONObject.put("opt_sample", 1);
                    int i2 = i;
                    if (i2 != -1) {
                        jSONObject.put("event_res", i2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("type", str);
                    }
                    xrVarMs.xr(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return xrVarMs;
            }
        }, "encrypt_track", true);
    }

    public void ms(final int i) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.16
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("has_pre_req").xr(i);
            }
        }, "has_pre_req", true);
    }

    public void ms(final int i, final String str, final String str2, final String str3, final String str4) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.17
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fetch_adm", i == 0 ? 1 : 0);
                jSONObject.put("code", i);
                jSONObject.put("msg", str);
                jSONObject.put("material_keys", str4);
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("fetch_adm_status").xr(i).ah(str3).c(str2).xr(jSONObject.toString());
            }
        }, "fetch_adm_status", true);
    }

    public void xr(final int i) {
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.18
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("get_ad_cache_failed").xr(i);
            }
        }, "get_ad_cache_failed", true);
    }

    public void xr(final String str) {
        if (str == null) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.19
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("error_ad_info").ms(System.currentTimeMillis() / 1000).ny(str);
            }
        }, "error_ad_info", true);
    }

    public void xr(com.bytedance.sdk.openadsdk.hi.ms.ms msVar, String str) {
        xr.ah().ms(msVar, str, true);
    }

    public void ms(final String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.20
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(str);
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    xrVarMs.xr(jSONObject2.toString());
                }
                return xrVarMs;
            }
        }, str);
    }

    public void ms(String str, Throwable th) {
        ms(str, (JSONObject) null, th);
    }

    public void ms(final String str, final JSONObject jSONObject, final Throwable th) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.21
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(a.j, str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("exception", th);
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("exception").xr(jSONObject2.toString());
            }
        }, "exception");
    }

    public void xr(final JSONObject jSONObject) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.23
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("saas_schema").xr(jSONObject.toString());
            }
        }, "saas_schema");
    }

    public void ms(final lm lmVar, final long j, final boolean z, final boolean z2) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.24
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("req_id", lmVar.eu());
                jSONObject.put("auth", z);
                jSONObject.put("duration", j);
                jSONObject.put("time_out", z2);
                am amVarMg = lmVar.mg();
                if (amVarMg != null) {
                    jSONObject.put("saas_info", amVarMg.ms());
                }
                jSONObject.put("ext", lmVar.lx());
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("auth_time").xr(jSONObject.toString());
            }
        }, "auth_time");
    }

    public void ms(final String str, final String str2, final int i, final JSONObject jSONObject) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.25
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(com.anythink.core.common.e.a.C0080a.b, str2);
                jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("state", Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("convert_event").xr(jSONObject2.toString());
            }
        }, "convert_event");
    }

    public void ms(final boolean z) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.26
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", z);
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("live_init_success").xr(jSONObject.toString());
            }
        }, "live_init_success");
    }

    public void ms(final lm lmVar, final Object obj) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.27
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("upie_img_play_success");
                lm lmVar2 = lmVar;
                if (lmVar2 != null) {
                    xrVarMs.c(lmVar2.eu());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", obj);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, lmVar);
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "upie_img_play_success");
    }

    public void ms(final lm lmVar, final int i, final String str) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.28
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("upie_img_play_fail");
                lm lmVar2 = lmVar;
                if (lmVar2 != null) {
                    xrVarMs.c(lmVar2.eu());
                }
                xrVarMs.xr(i);
                xrVarMs.ab(str);
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, lmVar);
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "upie_img_play_fail");
    }

    public void ms(final lm lmVar, final String str) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.29
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("uttie_start");
                lm lmVar2 = lmVar;
                if (lmVar2 != null) {
                    xrVarMs.c(lmVar2.eu());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "uttie_start");
    }

    public void ms(final lm lmVar, final String str, final long j) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.30
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("uttie_played");
                lm lmVar2 = lmVar;
                if (lmVar2 != null) {
                    xrVarMs.c(lmVar2.eu());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                jSONObject.put("duration", j);
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "uttie_played");
    }

    public void xr(final lm lmVar, final String str) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.31
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("uttie_close");
                lm lmVar2 = lmVar;
                if (lmVar2 != null) {
                    xrVarMs.c(lmVar2.eu());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "uttie_close");
    }

    public void ms(final lm lmVar, final String str, final JSONObject jSONObject) {
        xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.32
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(str);
                lm lmVar2 = lmVar;
                if (lmVar2 != null) {
                    xrVarMs.c(lmVar2.eu()).x(lmVar.lx());
                }
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    xrVarMs.xr(jSONObject2.toString());
                }
                return xrVarMs;
            }
        }, str);
    }

    public void ah(lm lmVar, String str) {
        ms(lmVar, str, (JSONObject) null);
    }

    public void ah(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.34
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("device_qty_compare");
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "device_qty_compare", true);
    }

    public void d(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.35
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("device_bytebench");
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "device_bytebench", true);
    }

    public void ka(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.36
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("render_timeout_opt");
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "render_timeout_opt", true);
    }

    public void c(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.37
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("landingpage_check_info");
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "landingpage_check_info", true);
    }

    public static void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final boolean z, final long j, final long j2, final long j3, final int i) {
        ms().ab(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.u.38
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                int i2 = z ? 2 : 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(i2));
                jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
                jSONObject.putOpt("total_duration", Long.valueOf(j3));
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(i).ah(xrVar.d()).xr((int) j).xr(jSONObject.toString());
            }
        });
    }
}
