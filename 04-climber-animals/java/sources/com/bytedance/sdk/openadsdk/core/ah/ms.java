package com.bytedance.sdk.openadsdk.core.ah;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.jw.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.hi;
import com.bytedance.sdk.openadsdk.core.jw.re;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.jw.w;
import com.bytedance.sdk.openadsdk.core.jw.yu;
import com.bytedance.sdk.openadsdk.core.t;
import com.umeng.analytics.pro.bv;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static AtomicBoolean ah = new AtomicBoolean(false);
    private static volatile String d = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static long f1976ms = -1;
    private static boolean xr = false;

    public static void ms() {
        if (f1976ms > -1) {
            return;
        }
        f1976ms = SystemClock.elapsedRealtime();
    }

    public static boolean xr() {
        if (xr) {
            return true;
        }
        if (f1976ms == -1) {
            return false;
        }
        boolean z = SystemClock.elapsedRealtime() - f1976ms > 60000;
        xr = z;
        return z;
    }

    public static JSONObject ms(Context context, int i) {
        return xr(context, i);
    }

    /* JADX WARN: Code duplicated, block: B:150:0x034f A[Catch: all -> 0x03a2, TryCatch #0 {all -> 0x03a2, blocks: (B:3:0x0009, B:7:0x0019, B:10:0x0025, B:12:0x002f, B:15:0x0036, B:22:0x004b, B:24:0x0055, B:27:0x005c, B:32:0x006d, B:35:0x007a, B:37:0x0084, B:40:0x008b, B:45:0x009c, B:48:0x00a8, B:52:0x00bb, B:54:0x00c5, B:57:0x00cc, B:62:0x00dd, B:65:0x017e, B:67:0x0188, B:70:0x018f, B:75:0x01a0, B:79:0x01e9, B:81:0x0268, B:84:0x0275, B:86:0x027f, B:89:0x0286, B:97:0x029c, B:99:0x02a6, B:102:0x02ad, B:110:0x02c3, B:112:0x02cd, B:115:0x02d4, B:123:0x02ea, B:125:0x02f4, B:129:0x02fc, B:137:0x0312, B:139:0x031c, B:144:0x032d, B:147:0x033d, B:149:0x034b, B:151:0x035a, B:153:0x036d, B:154:0x0372, B:156:0x0381, B:157:0x0386, B:161:0x039e, B:160:0x039b, B:150:0x034f, B:140:0x0320, B:143:0x032a, B:130:0x0300, B:134:0x030b, B:116:0x02d8, B:120:0x02e3, B:103:0x02b1, B:107:0x02bc, B:90:0x028a, B:94:0x0295, B:71:0x0193, B:74:0x019d, B:58:0x00d0, B:61:0x00da, B:49:0x00b0, B:41:0x008f, B:44:0x0099, B:28:0x0060, B:31:0x006a, B:16:0x003a, B:19:0x0044), top: B:166:0x0009, inners: #1 }] */
    public static JSONObject xr(Context context, int i) {
        String strU;
        String strZb;
        String strSl;
        String strHi;
        String strCh;
        String strAo;
        String strNy;
        String strX;
        String strAb;
        String strHi2;
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.i.ms msVar = new com.bytedance.sdk.openadsdk.core.i.ms();
            int i2 = 0;
            boolean z = !xr();
            d.xr xrVar = new d.xr();
            String str = null;
            if (z && (strHi2 = d.ms().hi(null)) != null) {
                if (TextUtils.isEmpty(strHi2)) {
                    strHi2 = null;
                }
                jSONObject.put("imei", strHi2);
            } else {
                String strMs = t.ms(msVar);
                jSONObject.put("imei", strMs);
                if (strMs == null) {
                    strMs = "";
                }
                xrVar.ms(strMs);
            }
            if (z && (strAb = d.ms().ab()) != null) {
                if (TextUtils.isEmpty(strAb)) {
                    strAb = null;
                }
                jSONObject.put("android_id", strAb);
            } else {
                String strC = t.c();
                jSONObject.put("android_id", strC);
                if (strC == null) {
                    strC = "";
                }
                xrVar.xr(strC);
            }
            jSONObject.put("uuid", ah());
            if (z && (strX = d.ms().x()) != null) {
                if (TextUtils.isEmpty(strX)) {
                    strX = null;
                }
                jSONObject.put("ssid", strX);
            } else {
                String strAh = t.ah(msVar);
                jSONObject.put("ssid", strAh);
                if (strAh == null) {
                    strAh = "";
                }
                xrVar.ah(strAh);
            }
            if (d.ms().ab(i)) {
                jSONObject.put("wifi_mac", t.hi());
            } else {
                jSONObject.put("wifi_mac", t.d(msVar));
            }
            if (z && (strNy = d.ms().ny()) != null) {
                if (TextUtils.isEmpty(strNy)) {
                    strNy = null;
                }
                jSONObject.put("imsi", strNy);
            } else {
                String strXr = t.xr(msVar);
                jSONObject.put("imsi", strXr);
                if (strXr == null) {
                    strXr = "";
                }
                xrVar.d(strXr);
            }
            jSONObject.put("boot", new StringBuilder().append(System.currentTimeMillis() - SystemClock.elapsedRealtime()).toString());
            jSONObject.put("power_on_time", new StringBuilder().append(SystemClock.elapsedRealtime()).toString());
            jSONObject.put("rom_version", w.ms());
            jSONObject.put("rom_new_version", w.ub());
            jSONObject.put("sys_compiling_time", t.d());
            jSONObject.put("type", ch.ms(context, z));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(bv.y, Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", t.re());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", ch.d());
            if (z && (strAo = d.ms().ao()) != null) {
                if (TextUtils.isEmpty(strAo)) {
                    strAo = null;
                }
                jSONObject.put("mac", strAo);
            } else {
                String strKa = t.ka(msVar);
                jSONObject.put("mac", strKa);
                if (strKa == null) {
                    strKa = "";
                }
                xrVar.ka(strKa);
            }
            int[] iArrAh = ul.ah(context);
            jSONObject.put("screen_width", iArrAh[0]);
            jSONObject.put("screen_height", iArrAh[1]);
            jSONObject.put("oaid", b.ms(z));
            jSONObject.put("free_space", hi.f2705ms);
            jSONObject.put("locale_language", ch.hi());
            jSONObject.put("screen_bright", Math.ceil(ch.sl() * 10.0f) / 10.0d);
            if (!ch.ms()) {
                i2 = 1;
            }
            jSONObject.put("is_screen_off", i2);
            jSONObject.put("cpu_num", f.ub());
            jSONObject.put("cpu_max_freq", f.ao());
            jSONObject.put("cpu_min_freq", f.h());
            jSONObject.put("battery_remaining_pct", (int) ch.ms.xr(context));
            jSONObject.put("is_charging", ch.ms.ms(context));
            jSONObject.put("total_mem", String.valueOf(Long.parseLong(f.zb()) * 1024));
            jSONObject.put("total_space", String.valueOf(f.qv()));
            jSONObject.put("free_space_in", String.valueOf(f.t()));
            jSONObject.put("sdcard_size", String.valueOf(f.nw()));
            jSONObject.put("rooted", f.re());
            if (!d.ms().ab(i)) {
                jSONObject.put("enable_assisted_clicking", ch.u());
            }
            if (z && (strCh = d.ms().ch()) != null) {
                if (TextUtils.isEmpty(strCh)) {
                    strCh = null;
                }
                jSONObject.put("mnc", strCh);
            } else {
                String strY = t.y();
                jSONObject.put("mnc", strY);
                if (strY == null) {
                    strY = "";
                }
                xrVar.c(strY);
            }
            if (z && (strHi = d.ms().hi()) != null) {
                if (TextUtils.isEmpty(strHi)) {
                    strHi = null;
                }
                jSONObject.put("mcc", strHi);
            } else {
                String strH = t.h();
                jSONObject.put("mcc", strH);
                if (strH == null) {
                    strH = "";
                }
                xrVar.ab(strH);
            }
            if (z && (strSl = d.ms().sl()) != null) {
                if (TextUtils.isEmpty(strSl)) {
                    strSl = null;
                }
                jSONObject.put("mnc_2", strSl);
            } else {
                String strT = t.t();
                jSONObject.put("mnc_2", strT);
                if (strT == null) {
                    strT = "";
                }
                xrVar.x(strT);
            }
            if (z && (strZb = d.ms().zb()) != null) {
                if (!TextUtils.isEmpty(strZb)) {
                    str = strZb;
                }
                jSONObject.put("mcc_2", str);
            } else {
                String strQv = t.qv();
                jSONObject.put("mcc_2", strQv);
                if (strQv == null) {
                    strQv = "";
                }
                xrVar.ny(strQv);
            }
            if (z && (strU = d.ms().u()) != null) {
                jSONObject.put("download_channel", strU);
            } else {
                String strMs2 = com.bytedance.sdk.openadsdk.core.x.ms.ms(context);
                jSONObject.put("download_channel", strMs2);
                xrVar.ch(strMs2 != null ? strMs2 : "");
            }
            xrVar.ms();
            jSONObject.put("is_app_log_con", com.bytedance.sdk.component.x.xr.ah.ms.ms());
            if (z) {
                String strUb = d.ms().ub();
                if (!TextUtils.isEmpty(strUb)) {
                    jSONObject.put("applog_did", strUb);
                } else {
                    jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.c.ms().ah());
                }
            } else {
                jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.c.ms().ah());
            }
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.ms.ms.ms.xr());
            long jAo = ch.ao();
            if (jAo != -1) {
                jSONObject.put("client_global_did", jAo);
            }
            jSONObject.put("sys_vol", ch.h());
            String strX2 = re.x();
            if (strX2 != null) {
                jSONObject.put("ud", strX2);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("DeviceRate", "bytebench_value")));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            ch.ms(jSONObject);
        } catch (Throwable th) {
            sl.ms(th);
        }
        return jSONObject;
    }

    public static void ms(JSONObject jSONObject, int i) throws JSONException {
        if (!ah.ms().ms(i)) {
            xr(jSONObject);
            return;
        }
        JSONArray jSONArrayH = d.ms().h();
        if (jSONArrayH != null) {
            if (jSONArrayH.length() > 0) {
                jSONObject.put("scheme_success_list", jSONArrayH);
            }
            if (ah.get()) {
                return;
            }
            ah.set(true);
            ab.xr(new ny("tt-scheme") { // from class: com.bytedance.sdk.openadsdk.core.ah.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ms.xr(null);
                    } catch (Exception unused) {
                    }
                    ms.ah.set(false);
                }
            });
            return;
        }
        xr(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(JSONObject jSONObject) throws JSONException {
        Set<String> setKk = com.bytedance.sdk.openadsdk.core.re.xr().kk();
        if (setKk == null || setKk.size() <= 0) {
            return;
        }
        Map<String, Boolean> mapMs = yu.ms(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : mapMs.entrySet()) {
            String key = entry.getKey();
            if (setKk.contains(key)) {
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
            d.ms().ms(jSONArray);
        } else {
            ab.xr(new ny("tt-scheme-save") { // from class: com.bytedance.sdk.openadsdk.core.ah.ms.2
                @Override // java.lang.Runnable
                public void run() {
                    d.ms().ms(jSONArray);
                }
            });
        }
    }

    public static String[] ms(int i) {
        try {
            return ch.ms(!xr());
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String ms(String str, int i) {
        return ch.ms(str);
    }

    public static String ah() {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String strAh = d.ms().ah((String) null);
        d = strAh;
        return strAh;
    }
}
