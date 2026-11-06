package com.byazt.mp;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.hg.i;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.vkw.g;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.b;
import com.byazt.wt.er;
import com.byazt.wt.fo;
import com.byazt.wt.ls;
import com.byazt.wt.rc;
import com.byazt.wt.vk;
import com.byazt.wt.z;
import com.byazt.xlm.fw;
import com.bytedance.JProtect;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 168, 37})
public class pr {
    public static volatile String x;
    public static long pr = -1;
    public static boolean hw = false;
    public static AtomicBoolean hn = new AtomicBoolean(false);

    public static void pr() {
        if (pr > -1) {
            return;
        }
        pr = SystemClock.elapsedRealtime();
    }

    public static boolean hw() {
        if (hw) {
            return true;
        }
        if (pr == -1) {
            return false;
        }
        boolean z = SystemClock.elapsedRealtime() - pr > 60000;
        hw = z;
        return z;
    }

    public static JSONObject pr(Context context, int i) {
        return pr(context, i, (i) null);
    }

    /* JADX WARN: Code duplicated, block: B:156:0x03cc A[Catch: all -> 0x042c, TryCatch #1 {all -> 0x042c, blocks: (B:3:0x000b, B:5:0x002b, B:10:0x0035, B:14:0x003e, B:17:0x0050, B:19:0x005a, B:22:0x0061, B:29:0x007f, B:31:0x0089, B:34:0x0090, B:39:0x00a1, B:42:0x00ae, B:44:0x00b8, B:47:0x00bf, B:52:0x00d4, B:55:0x00e0, B:59:0x00f7, B:61:0x0101, B:64:0x0108, B:71:0x0126, B:73:0x0130, B:76:0x0137, B:83:0x0155, B:85:0x015f, B:88:0x0166, B:96:0x017c, B:98:0x0186, B:101:0x018d, B:109:0x01a3, B:111:0x01ad, B:114:0x01b4, B:122:0x01ca, B:124:0x01d4, B:128:0x01dc, B:136:0x01f2, B:138:0x01fc, B:143:0x020d, B:147:0x0361, B:149:0x036e, B:150:0x0377, B:153:0x03ba, B:155:0x03c8, B:157:0x03d7, B:159:0x03ea, B:160:0x03ef, B:162:0x03fe, B:163:0x0403, B:164:0x0409, B:169:0x0426, B:168:0x0423, B:156:0x03cc, B:139:0x0200, B:142:0x020a, B:129:0x01e0, B:133:0x01eb, B:115:0x01b8, B:119:0x01c3, B:102:0x0191, B:106:0x019c, B:89:0x016a, B:93:0x0175, B:77:0x013b, B:80:0x014e, B:65:0x010c, B:68:0x011f, B:56:0x00e8, B:48:0x00c3, B:51:0x00d1, B:35:0x0094, B:38:0x009e, B:23:0x0065, B:26:0x0078), top: B:176:0x000b, inners: #0 }] */
    @JProtect
    public static JSONObject pr(Context context, int i, i iVar) {
        String strK;
        String strW;
        String strVk;
        String strAj;
        String strZo;
        String strG;
        String strFw;
        String strUc;
        String strC;
        String strAj2;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            g gVar = (g) com.byazt.zs.uc.pr("device_info_new");
            com.byazt.vkw.hn hnVar = (com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog");
            com.byazt.qam.pr prVar = new com.byazt.qam.pr();
            boolean z = (prVar.pr() && prVar.hw()) ? false : true;
            boolean z2 = !hw();
            x.hw hwVar = new x.hw();
            long jPr = pr(iVar, "deviceInit", jCurrentTimeMillis);
            String str = null;
            if (z2 && (strAj2 = x.pr().aj(null)) != null) {
                if (TextUtils.isEmpty(strAj2)) {
                    strAj2 = null;
                }
                jSONObject.put("imei", strAj2);
            } else {
                String strPr = DeviceUtils.pr(Boolean.valueOf(prVar.pr(0)));
                jSONObject.put("imei", strPr);
                if (strPr == null) {
                    strPr = "";
                }
                hwVar.pr(strPr);
            }
            if (z2 && (strC = x.pr().c()) != null) {
                if (TextUtils.isEmpty(strC)) {
                    strC = null;
                }
                jSONObject.put(Common.Predefined.SUB_ANDROID_ID, strC);
            } else {
                String strHw = DeviceUtils.hw();
                jSONObject.put(Common.Predefined.SUB_ANDROID_ID, strHw);
                if (strHw == null) {
                    strHw = "";
                }
                hwVar.hw(strHw);
            }
            jSONObject.put("uuid", hn());
            if (z2 && (strUc = x.pr().uc()) != null) {
                if (TextUtils.isEmpty(strUc)) {
                    strUc = null;
                }
                jSONObject.put("ssid", strUc);
            } else {
                String strX = gVar.x(Boolean.valueOf(z));
                jSONObject.put("ssid", strX);
                if (strX == null) {
                    strX = "";
                }
                hwVar.hn(strX);
            }
            if (x.pr().fw(i)) {
                jSONObject.put("wifi_mac", gVar.z());
            } else {
                jSONObject.put("wifi_mac", gVar.pr(Boolean.valueOf(z)));
            }
            if (z2 && (strFw = x.pr().fw()) != null) {
                if (TextUtils.isEmpty(strFw)) {
                    strFw = null;
                }
                jSONObject.put("imsi", strFw);
            } else {
                String strC2 = gVar.c(Boolean.valueOf(prVar.pr(1)));
                jSONObject.put("imsi", strC2);
                if (strC2 == null) {
                    strC2 = "";
                }
                hwVar.x(strC2);
            }
            if (z2 && (strG = x.pr().g()) != null) {
                if (TextUtils.isEmpty(strG)) {
                    strG = null;
                }
                jSONObject.put("mac", strG);
            } else {
                String strHn = gVar.hn(Boolean.valueOf(prVar.pr(2)));
                jSONObject.put("mac", strHn);
                if (strHn == null) {
                    strHn = "";
                }
                hwVar.c(strHn);
            }
            if (z2 && (strZo = x.pr().zo()) != null) {
                if (TextUtils.isEmpty(strZo)) {
                    strZo = null;
                }
                jSONObject.put("mnc", strZo);
            } else {
                String strFw2 = gVar.fw();
                jSONObject.put("mnc", strFw2);
                if (strFw2 == null) {
                    strFw2 = "";
                }
                hwVar.uc(strFw2);
            }
            if (z2 && (strAj = x.pr().aj()) != null) {
                if (TextUtils.isEmpty(strAj)) {
                    strAj = null;
                }
                jSONObject.put("mcc", strAj);
            } else {
                String strUc2 = gVar.uc();
                jSONObject.put("mcc", strUc2);
                if (strUc2 == null) {
                    strUc2 = "";
                }
                hwVar.fw(strUc2);
            }
            if (z2 && (strVk = x.pr().vk()) != null) {
                if (TextUtils.isEmpty(strVk)) {
                    strVk = null;
                }
                jSONObject.put("mnc_2", strVk);
            } else {
                String strRc = gVar.rc();
                jSONObject.put("mnc_2", strRc);
                if (strRc == null) {
                    strRc = "";
                }
                hwVar.zo(strRc);
            }
            if (z2 && (strW = x.pr().w()) != null) {
                if (!TextUtils.isEmpty(strW)) {
                    str = strW;
                }
                jSONObject.put("mcc_2", str);
            } else {
                String strFo = gVar.fo();
                jSONObject.put("mcc_2", strFo);
                if (strFo == null) {
                    strFo = "";
                }
                hwVar.aj(strFo);
            }
            if (z2 && (strK = x.pr().k()) != null) {
                jSONObject.put("download_channel", strK);
            } else {
                String strAj3 = com.byazt.hb.pr.aj();
                jSONObject.put("download_channel", strAj3);
                hwVar.vk(strAj3 != null ? strAj3 : "");
            }
            hwVar.pr();
            long jPr2 = pr(iVar, "deviceIds", jPr);
            jSONObject.put("free_space", vk.pr);
            jSONObject.put("cpu_num", ls.g());
            jSONObject.put("cpu_max_freq", ls.ho());
            jSONObject.put("cpu_min_freq", ls.nt());
            jSONObject.put("battery_remaining_pct", (int) DeviceUtils.pr.hw(context));
            jSONObject.put("is_charging", DeviceUtils.pr.pr(context));
            jSONObject.put("total_mem", ls.k());
            jSONObject.put("total_space", String.valueOf(ls.yb()));
            jSONObject.put("free_space_in", String.valueOf(ls.qa()));
            jSONObject.put("sdcard_size", String.valueOf(ls.a()));
            jSONObject.put("rooted", ls.ny());
            long jPr3 = pr(iVar, "deviceHwStat", jPr2);
            jSONObject.put("boot", new StringBuilder().append(System.currentTimeMillis() - SystemClock.elapsedRealtime()).toString());
            jSONObject.put("power_on_time", new StringBuilder().append(SystemClock.elapsedRealtime()).toString());
            jSONObject.put("rom_version", gVar.qa());
            jSONObject.put("rom_new_version", z.g());
            jSONObject.put("sys_compiling_time", gVar.g());
            jSONObject.put("type", gVar.pr(z2));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(an.y, Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", gVar.hw());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", DeviceUtils.x());
            int[] iArrX = er.x(context);
            int i2 = 0;
            jSONObject.put("screen_width", iArrX[0]);
            jSONObject.put("screen_height", iArrX[1]);
            jSONObject.put("locale_language", gVar.c());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.c() * 10.0f) / 10.0d);
            if (!DeviceUtils.pr()) {
                i2 = 1;
            }
            jSONObject.put("is_screen_off", i2);
            if (!x.pr().fw(i)) {
                jSONObject.put("enable_assisted_clicking", DeviceUtils.uc());
            }
            jSONObject.put("sys_vol", DeviceUtils.vk());
            DeviceUtils.pr(jSONObject);
            long jPr4 = pr(iVar, "deviceSysProp", jPr3);
            jSONObject.put("oaid", hnVar.pr(z2));
            jSONObject.put("oaid_source", fo.pr());
            long jPr5 = pr(iVar, "deviceOaid", jPr4);
            jSONObject.put("is_app_log_con", com.byazt.lg.pr.pr(zo.nt().ny()).hn());
            if (z2) {
                String strM = x.pr().m();
                if (!TextUtils.isEmpty(strM)) {
                    jSONObject.put("applog_did", strM);
                } else {
                    jSONObject.put("applog_did", com.byazt.sd.uc.pr().hw());
                }
            } else {
                jSONObject.put("applog_did", com.byazt.sd.uc.pr().hw());
            }
            jSONObject.put("sec_did", com.byazt.qv.pr.hw());
            long jAj = DeviceUtils.aj();
            if (jAj != -1) {
                jSONObject.put("client_global_did", jAj);
            }
            com.byazt.wt.zo.hw(jSONObject);
            long jPr6 = pr(iVar, "deviceDid", jPr5);
            String strW2 = rc.w();
            if (strW2 != null) {
                jSONObject.put("ud", strW2);
            }
            long jPr7 = pr(iVar, "deviceUaid", jPr6);
            try {
                jSONObject.put("device_score", Double.parseDouble(com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", com.byazt.zb.pr.x())));
            } catch (NumberFormatException e) {
                jSONObject.put("device_score", -1);
            }
            pr(iVar, "deviceScore", jPr7);
        } catch (Throwable th) {
            pr(i, th);
        }
        return jSONObject;
    }

    private static long pr(i iVar, String str, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (iVar != null) {
            iVar.pr(str, jCurrentTimeMillis - j, true);
        }
        return jCurrentTimeMillis;
    }

    private static void pr(int i, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("type", Integer.valueOf(i));
            com.byazt.xk.hw.pr().pr("b_ad_req", jSONObject, th);
        } catch (Throwable th2) {
        }
    }

    public static void pr(JSONObject jSONObject, int i) throws JSONException {
        if (!hn.pr().pr(i)) {
            hw(jSONObject);
            return;
        }
        JSONArray jSONArrayHo = x.pr().ho();
        if (jSONArrayHo != null) {
            if (jSONArrayHo.length() > 0) {
                jSONObject.put("scheme_success_list", jSONArrayHo);
            }
            if (hn.get()) {
                return;
            }
            hn.set(true);
            com.byazt.xlm.c.hw(new fw("tt-scheme") { // from class: com.byazt.mp.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        pr.hw(null);
                    } catch (Exception e) {
                    }
                    pr.hn.set(false);
                }
            });
            return;
        }
        hw(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(JSONObject jSONObject) throws JSONException {
        Set<String> setGb = a.hw().gb();
        if (setGb != null && setGb.size() > 0) {
            Map<String, Boolean> mapPr = b.pr(259200000L);
            final JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Boolean> entry : mapPr.entrySet()) {
                String key = entry.getKey();
                if (setGb.contains(key)) {
                    String scheme = Uri.parse(key).getScheme();
                    if (entry.getValue().booleanValue()) {
                        jSONArray.put(scheme);
                    } else {
                        jSONArray2.put(scheme);
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
                x.pr().pr(jSONArray);
            } else {
                com.byazt.xlm.c.hw(new fw("tt-scheme-save") { // from class: com.byazt.mp.pr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        x.pr().pr(jSONArray);
                    }
                });
            }
        }
    }

    public static String[] pr(int i) {
        try {
            return ((g) com.byazt.zs.uc.pr("device_info_new")).hn(!hw());
        } catch (Exception e) {
            return new String[]{"", ""};
        }
    }

    public static String pr(String str, int i) {
        return com.byazt.wt.a.hw(str);
    }

    public static String hn() {
        if (!TextUtils.isEmpty(x)) {
            return x;
        }
        String strPr = x.pr().pr((String) null);
        x = strPr;
        return strPr;
    }
}
