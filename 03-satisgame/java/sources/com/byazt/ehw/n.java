package com.byazt.ehw;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gct.y;
import com.byazt.vf.oa;
import com.bytedance.JProtect;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 470, 19})
public class n {
    public static long n = -1;
    public static volatile String q = null;
    public static boolean qg = false;
    public static AtomicBoolean s = new AtomicBoolean(false);

    private static boolean n(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public static void n() {
        if (n > -1) {
            return;
        }
        n = SystemClock.elapsedRealtime();
    }

    public static boolean qg() {
        if (qg) {
            return true;
        }
        if (n == -1) {
            return false;
        }
        boolean z = SystemClock.elapsedRealtime() - n > 60000;
        qg = z;
        return z;
    }

    public static JSONObject n(Context context, int i) {
        return n(context, i, (y) null);
    }

    /* JADX WARN: Code duplicated, block: B:156:0x03cb A[Catch: all -> 0x042a, TryCatch #0 {all -> 0x042a, blocks: (B:3:0x000b, B:5:0x002a, B:10:0x0034, B:14:0x003d, B:17:0x004f, B:19:0x0059, B:22:0x0060, B:29:0x007e, B:31:0x0088, B:34:0x008f, B:39:0x00a0, B:42:0x00ad, B:44:0x00b7, B:47:0x00be, B:52:0x00d3, B:55:0x00df, B:59:0x00f6, B:61:0x0100, B:64:0x0107, B:71:0x0125, B:73:0x012f, B:76:0x0136, B:83:0x0154, B:85:0x015e, B:88:0x0165, B:96:0x017b, B:98:0x0185, B:101:0x018c, B:109:0x01a2, B:111:0x01ac, B:114:0x01b3, B:122:0x01c9, B:124:0x01d3, B:128:0x01db, B:136:0x01f1, B:138:0x01fb, B:143:0x020c, B:147:0x0360, B:149:0x036d, B:150:0x0376, B:153:0x03b9, B:155:0x03c7, B:157:0x03d6, B:159:0x03e9, B:160:0x03ee, B:162:0x03fd, B:163:0x0402, B:164:0x0408, B:168:0x0424, B:167:0x0421, B:156:0x03cb, B:139:0x01ff, B:142:0x0209, B:129:0x01df, B:133:0x01ea, B:115:0x01b7, B:119:0x01c2, B:102:0x0190, B:106:0x019b, B:89:0x0169, B:93:0x0174, B:77:0x013a, B:80:0x014d, B:65:0x010b, B:68:0x011e, B:56:0x00e7, B:48:0x00c2, B:51:0x00d0, B:35:0x0093, B:38:0x009d, B:23:0x0064, B:26:0x0077), top: B:173:0x000b, inners: #1 }] */
    @JProtect
    public static JSONObject n(Context context, int i, y yVar) {
        String strCp;
        String strTj;
        String strRv;
        String strFs;
        String strX;
        String strOa;
        String strW;
        String strL;
        String strQ;
        String strRv2;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            oa oaVar = (oa) com.byazt.qp.q.n("device_info_new");
            com.byazt.vf.s sVar = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog");
            com.byazt.af.qg qgVar = new com.byazt.af.qg();
            boolean z = (qgVar.n() && qgVar.qg()) ? false : true;
            boolean z2 = !qg();
            com.byazt.ed.s.qg qgVar2 = new com.byazt.ed.s.qg();
            long jN = n(yVar, "deviceInit", jCurrentTimeMillis);
            String str = null;
            if (z2 && (strRv2 = com.byazt.ed.s.n().rv(null)) != null) {
                if (TextUtils.isEmpty(strRv2)) {
                    strRv2 = null;
                }
                jSONObject.put("imei", strRv2);
            } else {
                String strN = DeviceUtils.n(Boolean.valueOf(qgVar.n(0)));
                jSONObject.put("imei", strN);
                if (strN == null) {
                    strN = "";
                }
                qgVar2.n(strN);
            }
            if (z2 && (strQ = com.byazt.ed.s.n().q()) != null) {
                if (TextUtils.isEmpty(strQ)) {
                    strQ = null;
                }
                jSONObject.put("android_id", strQ);
            } else {
                String strQg = DeviceUtils.qg();
                jSONObject.put("android_id", strQg);
                if (strQg == null) {
                    strQg = "";
                }
                qgVar2.qg(strQg);
            }
            jSONObject.put("uuid", s());
            if (z2 && (strL = com.byazt.ed.s.n().l()) != null) {
                if (TextUtils.isEmpty(strL)) {
                    strL = null;
                }
                jSONObject.put("ssid", strL);
            } else {
                String strQ2 = oaVar.q(Boolean.valueOf(z));
                jSONObject.put("ssid", strQ2);
                if (strQ2 == null) {
                    strQ2 = "";
                }
                qgVar2.s(strQ2);
            }
            if (com.byazt.ed.s.n().x(i)) {
                jSONObject.put("wifi_mac", oaVar.hu());
            } else {
                jSONObject.put("wifi_mac", oaVar.n(Boolean.valueOf(z)));
            }
            if (z2 && (strW = com.byazt.ed.s.n().w()) != null) {
                if (TextUtils.isEmpty(strW)) {
                    strW = null;
                }
                jSONObject.put("imsi", strW);
            } else {
                String strL2 = oaVar.l(Boolean.valueOf(qgVar.n(1)));
                jSONObject.put("imsi", strL2);
                if (strL2 == null) {
                    strL2 = "";
                }
                qgVar2.q(strL2);
            }
            if (z2 && (strOa = com.byazt.ed.s.n().oa()) != null) {
                if (TextUtils.isEmpty(strOa)) {
                    strOa = null;
                }
                jSONObject.put("mac", strOa);
            } else {
                String strS = oaVar.s(Boolean.valueOf(qgVar.n(2)));
                jSONObject.put("mac", strS);
                if (strS == null) {
                    strS = "";
                }
                qgVar2.l(strS);
            }
            if (z2 && (strX = com.byazt.ed.s.n().x()) != null) {
                if (TextUtils.isEmpty(strX)) {
                    strX = null;
                }
                jSONObject.put("mnc", strX);
            } else {
                String strX2 = oaVar.x();
                jSONObject.put("mnc", strX2);
                if (strX2 == null) {
                    strX2 = "";
                }
                qgVar2.w(strX2);
            }
            if (z2 && (strFs = com.byazt.ed.s.n().fs()) != null) {
                if (TextUtils.isEmpty(strFs)) {
                    strFs = null;
                }
                jSONObject.put("mcc", strFs);
            } else {
                String strW2 = oaVar.w();
                jSONObject.put("mcc", strW2);
                if (strW2 == null) {
                    strW2 = "";
                }
                qgVar2.x(strW2);
            }
            if (z2 && (strRv = com.byazt.ed.s.n().rv()) != null) {
                if (TextUtils.isEmpty(strRv)) {
                    strRv = null;
                }
                jSONObject.put("mnc_2", strRv);
            } else {
                String strM = oaVar.m();
                jSONObject.put("mnc_2", strM);
                if (strM == null) {
                    strM = "";
                }
                qgVar2.fs(strM);
            }
            if (z2 && (strTj = com.byazt.ed.s.n().tj()) != null) {
                if (!TextUtils.isEmpty(strTj)) {
                    str = strTj;
                }
                jSONObject.put("mcc_2", str);
            } else {
                String strWm = oaVar.wm();
                jSONObject.put("mcc_2", strWm);
                if (strWm == null) {
                    strWm = "";
                }
                qgVar2.rv(strWm);
            }
            if (z2 && (strCp = com.byazt.ed.s.n().cp()) != null) {
                jSONObject.put("download_channel", strCp);
            } else {
                String strRv3 = com.byazt.ges.qg.rv();
                jSONObject.put("download_channel", strRv3);
                qgVar2.tj(strRv3 != null ? strRv3 : "");
            }
            qgVar2.n();
            long jN2 = n(yVar, "deviceIds", jN);
            jSONObject.put("free_space", s.n);
            jSONObject.put("cpu_num", com.byazt.vgx.w.sz());
            jSONObject.put("cpu_max_freq", com.byazt.vgx.w.k());
            jSONObject.put("cpu_min_freq", com.byazt.vgx.w.cy());
            jSONObject.put("battery_remaining_pct", (int) DeviceUtils.n.qg(context));
            jSONObject.put("is_charging", DeviceUtils.n.n(context));
            jSONObject.put("total_mem", com.byazt.vgx.w.d());
            jSONObject.put("total_space", String.valueOf(com.byazt.vgx.w.hd()));
            jSONObject.put("free_space_in", String.valueOf(com.byazt.vgx.w.um()));
            jSONObject.put("sdcard_size", String.valueOf(com.byazt.vgx.w.a()));
            jSONObject.put("rooted", com.byazt.vgx.w.ou());
            long jN3 = n(yVar, "deviceHwStat", jN2);
            jSONObject.put("boot", new StringBuilder().append(System.currentTimeMillis() - SystemClock.elapsedRealtime()).toString());
            jSONObject.put("power_on_time", new StringBuilder().append(SystemClock.elapsedRealtime()).toString());
            jSONObject.put("rom_version", oaVar.um());
            jSONObject.put("rom_new_version", rv.sz());
            jSONObject.put("sys_compiling_time", oaVar.sz());
            jSONObject.put("type", oaVar.n(z2));
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", oaVar.qg());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", DeviceUtils.q());
            int[] iArrQ = com.byazt.okk.s.q(context);
            int i2 = 0;
            jSONObject.put("screen_width", iArrQ[0]);
            jSONObject.put("screen_height", iArrQ[1]);
            jSONObject.put("locale_language", oaVar.l());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.l() * 10.0f) / 10.0d);
            if (!DeviceUtils.n()) {
                i2 = 1;
            }
            jSONObject.put("is_screen_off", i2);
            if (!com.byazt.ed.s.n().x(i)) {
                jSONObject.put("enable_assisted_clicking", DeviceUtils.w());
            }
            jSONObject.put("sys_vol", DeviceUtils.tj());
            DeviceUtils.n(jSONObject);
            long jN4 = n(yVar, "deviceSysProp", jN3);
            jSONObject.put("oaid", sVar.n(z2));
            jSONObject.put("oaid_source", x.n());
            long jN5 = n(yVar, "deviceOaid", jN4);
            jSONObject.put("is_app_log_con", com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).s());
            if (z2) {
                String strD = com.byazt.ed.s.n().d();
                if (!TextUtils.isEmpty(strD)) {
                    jSONObject.put("applog_did", strD);
                } else {
                    jSONObject.put("applog_did", com.byazt.yu.n.n().qg());
                }
            } else {
                jSONObject.put("applog_did", com.byazt.yu.n.n().qg());
            }
            jSONObject.put("sec_did", com.byazt.orb.n.qg());
            long jRv = DeviceUtils.rv();
            if (jRv != -1) {
                jSONObject.put("client_global_did", jRv);
            }
            qg.qg(jSONObject);
            long jN6 = n(yVar, "deviceDid", jN5);
            String strCp2 = com.byazt.cl.s.cp();
            if (strCp2 != null) {
                jSONObject.put("ud", strCp2);
            }
            long jN7 = n(yVar, "deviceUaid", jN6);
            try {
                jSONObject.put("device_score", Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", com.byazt.vgx.s.q())));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            n(yVar, "deviceScore", jN7);
        } catch (Throwable th) {
            n(i, th);
        }
        return jSONObject;
    }

    private static long n(y yVar, String str, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (yVar != null) {
            yVar.n(str, jCurrentTimeMillis - j, true);
        }
        return jCurrentTimeMillis;
    }

    private static void n(int i, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("type", Integer.valueOf(i));
            com.byazt.eji.s.n().n("b_ad_req", jSONObject, th);
        } catch (Throwable unused) {
        }
    }

    public static void n(JSONObject jSONObject, int i) throws JSONException {
        if (!com.byazt.ed.qg.n().n(i)) {
            qg(jSONObject);
            return;
        }
        JSONArray jSONArraySz = com.byazt.ed.s.n().sz();
        if (jSONArraySz != null) {
            if (jSONArraySz.length() > 0) {
                jSONObject.put("scheme_success_list", jSONArraySz);
            }
            if (s.get()) {
                return;
            }
            s.set(true);
            com.byazt.qit.l.qg(new com.byazt.qit.x("tt-scheme") { // from class: com.byazt.ehw.n.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.qg((JSONObject) null);
                    } catch (Exception unused) {
                    }
                    n.s.set(false);
                }
            });
            return;
        }
        qg(jSONObject);
    }

    private static String n(String str) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(58)) <= 0 || !n(str.charAt(0))) {
            return null;
        }
        for (int i = 1; i < iIndexOf; i++) {
            if (!qg(str.charAt(i))) {
                return null;
            }
        }
        return str.substring(0, iIndexOf);
    }

    private static boolean qg(char c) {
        if (n(c)) {
            return true;
        }
        return (c >= '0' && c <= '9') || c == '+' || c == '-' || c == '.';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(JSONObject jSONObject) throws JSONException {
        Set<String> setIi = com.byazt.nf.rv.qg().ii();
        if (setIi == null || setIi.size() <= 0) {
            return;
        }
        Map<String, Boolean> mapN = com.byazt.rd.n.n(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : mapN.entrySet()) {
            String key = entry.getKey();
            if (setIi.contains(key)) {
                String strN = n(key);
                if (entry.getValue().booleanValue()) {
                    jSONArray.put(strN);
                } else {
                    jSONArray2.put(strN);
                }
            }
        }
        if (jSONObject != null && jSONArray.length() > 0) {
            jSONObject.put("scheme_success_list", jSONArray);
        }
        if (jSONObject != null && jSONArray2.length() > 0) {
            jSONObject.put("scheme_fail_list", jSONArray2);
        }
        if (jSONObject == null) {
            com.byazt.ed.s.n().n(jSONArray);
        } else {
            com.byazt.qit.l.qg(new com.byazt.qit.x("tt-scheme-save") { // from class: com.byazt.ehw.n.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.ed.s.n().n(jSONArray);
                }
            });
        }
    }

    public static String[] n(int i) {
        try {
            return ((oa) com.byazt.qp.q.n("device_info_new")).s(!qg());
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String n(String str, int i) {
        return w.qg(str);
    }

    public static String s() {
        if (!TextUtils.isEmpty(q)) {
            return q;
        }
        String strN = com.byazt.ed.s.n().n((String) null);
        q = strN;
        return strN;
    }

    public static List<ResolveInfo> n(Intent intent, int i) {
        return com.byazt.nf.rv.getContext().getPackageManager().queryIntentActivities(intent, i);
    }
}
