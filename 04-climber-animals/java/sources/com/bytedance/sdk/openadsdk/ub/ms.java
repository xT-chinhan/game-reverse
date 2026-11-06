package com.bytedance.sdk.openadsdk.ub;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ms.xr.ab;
import com.bytedance.ms.xr.c;
import com.bytedance.ms.xr.ka;
import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.cv;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.jw.w;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tencent.bugly.Bugly;
import com.umeng.analytics.pro.bv;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static void ms(Context context) {
        xr(context);
    }

    private static void xr(final Context context) {
        ab.ms(new c() { // from class: com.bytedance.sdk.openadsdk.ub.ms.1
            @Override // com.bytedance.ms.xr.c
            public boolean ms(final Throwable th, final Thread thread) {
                try {
                    hi.xr.ab(com.bytedance.sdk.openadsdk.core.of.ms.f3195ms);
                    if (!ms.xr(th, null)) {
                        return false;
                    }
                    com.bytedance.sdk.component.ch.ab.xr(new ny("tt_crash_handle") { // from class: com.bytedance.sdk.openadsdk.ub.ms.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            cv.ms().ms(thread, th);
                        }
                    });
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // com.bytedance.ms.xr.c
            public boolean ms() {
                try {
                    return ms.xr(null, Looper.getMainLooper().getThread());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        boolean z = false;
        boolean z2 = new SecureRandom().nextInt(10) == 0;
        Context applicationContext = context.getApplicationContext();
        ka kaVar = new ka() { // from class: com.bytedance.sdk.openadsdk.ub.ms.2
            @Override // com.bytedance.ms.xr.ka
            public List<String> c() {
                return null;
            }

            @Override // com.bytedance.ms.xr.ka
            public String d() {
                return null;
            }

            @Override // com.bytedance.ms.xr.ka
            public Map<String, Integer> ka() {
                return null;
            }

            @Override // com.bytedance.ms.xr.ka
            public Map<String, Object> ms() {
                HashMap map = new HashMap();
                String strAh = com.bytedance.sdk.openadsdk.core.c.ms().ah();
                if (TextUtils.isEmpty(strAh)) {
                    strAh = t.ah();
                }
                if (!TextUtils.isEmpty(strAh)) {
                    map.put("device_id", strAh);
                }
                map.put("ac", com.bytedance.sdk.component.ny.d.c.ah(context));
                map.put("aid", com.bytedance.sdk.openadsdk.core.c.ms().c());
                map.put("app_name", com.bytedance.sdk.openadsdk.core.c.ms().ab());
                String strSl = f.sl();
                if (!TextUtils.isEmpty(strSl)) {
                    map.put("app_version", strSl);
                }
                String strHi = f.hi();
                if (!TextUtils.isEmpty(strHi)) {
                    map.put("version_code", strHi);
                    try {
                        map.put("update_version_code", Integer.valueOf(strHi));
                    } catch (Exception e) {
                        map.put("update_version_code", 0);
                        e.getMessage();
                    }
                }
                map.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "6.9.2.3");
                map.put("sdk_api_version", g.ah);
                map.put("device_platform", "android");
                map.put("os", "Android");
                String strRe = t.re();
                map.put(bv.ac, strRe);
                map.put("device_mode", strRe);
                map.put("rom", w.ms());
                map.put("cpu_abi", Build.CPU_ABI);
                map.put(bv.F, Build.BRAND);
                map.put("channel", g.ka());
                map.put("language", Locale.getDefault().getLanguage());
                map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String strSubstring = Build.VERSION.RELEASE;
                    if (strSubstring != null && strSubstring.length() > 10) {
                        strSubstring = strSubstring.substring(0, 10);
                    }
                    map.put(bv.y, strSubstring);
                } catch (Exception unused) {
                }
                map.put("openudid", t.c());
                map.put("dpi", String.valueOf(ul.x(context)));
                map.put(bv.z, ul.d(context) + "*" + ul.ka(context));
                return map;
            }

            @Override // com.bytedance.ms.xr.ka
            public String xr() {
                String strAh = t.ah();
                return TextUtils.isEmpty(strAh) ? "0" : strAh;
            }

            @Override // com.bytedance.ms.xr.ka
            public String ah() {
                return com.bytedance.sdk.openadsdk.core.c.ms().d();
            }

            @Override // com.bytedance.ms.xr.ka
            public Map<String, Object> ab() {
                HashMap map = new HashMap();
                String strT = ch.ub().t();
                if (TextUtils.isEmpty(strT)) {
                    strT = String.valueOf(com.bytedance.sdk.openadsdk.core.c.ms().c());
                }
                map.put("host_appid", strT);
                map.put("sdk_version", "6.9.2.3");
                map.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
                map.put("channel", g.ka());
                map.put("sdk_api_version", g.ah);
                return map;
            }
        };
        boolean z3 = (re.xr().fs() & 2) == 0;
        if (z2 && (re.xr().fs() & 1) == 0) {
            z = true;
        }
        ab.ms(applicationContext, kaVar, z3, z);
        x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ub.ms.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.core.d.ms.ah()) {
                    return;
                }
                boolean zQv = re.xr().qv();
                boolean zMs = ms.ms();
                if (zQv && zMs) {
                    ab.ms(new com.bytedance.ms.ms.xr() { // from class: com.bytedance.sdk.openadsdk.ub.ms.3.1
                    });
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xr(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        if (ch.ub().cv()) {
            return false;
        }
        if (th != null) {
            stackTrace = th.getStackTrace();
        } else {
            stackTrace = thread != null ? thread.getStackTrace() : null;
        }
        String string = Arrays.toString(stackTrace);
        if (!(string.contains(BuildConfig.LIBRARY_PACKAGE_NAME) || string.contains("com.bytedance.sdk.component") || string.contains("com.bykv.vk") || string.contains("com.byted.csj.ext_impl") || string.contains("com.bytedance.adsdk") || string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm"))) {
            return false;
        }
        Map<String, String> mapXr = com.bytedance.sdk.openadsdk.core.d.ms().xr();
        if (mapXr != null) {
            if (string.contains("com.bytedance.sdk.openadsdk.core.nativeexpress")) {
                mapXr.put("express", "true");
            }
            if (string.contains(com.bytedance.sdk.openadsdk.core.live.ms.class.getPackage().getName()) || string.contains("com.bytedance.sdk.openadsdk.live") || string.contains("com.bykv.vk.openvk.live")) {
                mapXr.put("live_sdk", "true");
            }
            if (string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm")) {
                mapXr.put("mediation", "true");
            } else {
                mapXr.put("mediation", Bugly.SDK_IS_DEV);
            }
            ab.ms(com.bytedance.sdk.openadsdk.core.d.ms().xr());
        }
        return true;
    }

    public static boolean ms() {
        int iIntValue;
        try {
            String strZf = re.xr().zf();
            if (!TextUtils.isEmpty(strZf) && strZf.contains(";")) {
                String[] strArrSplit = strZf.split(";");
                if (strArrSplit.length != 2) {
                    return true;
                }
                String str = strArrSplit[0];
                String str2 = strArrSplit[1];
                Long lValueOf = -1L;
                try {
                    lValueOf = Long.valueOf(Long.valueOf(str).longValue() * 60 * 1000);
                    iIntValue = Integer.valueOf(str2).intValue();
                } catch (Exception e) {
                    sl.xr("apm", "error", e.getMessage());
                    iIntValue = -1;
                }
                if (lValueOf.longValue() >= 0 && iIntValue >= 0 && iIntValue <= 60) {
                    if (lValueOf.longValue() == 0 || iIntValue == 0 || lValueOf.longValue() / ((long) iIntValue) < 5000) {
                        return false;
                    }
                    String strXr = xr();
                    StringBuilder sb = new StringBuilder();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(strXr)) {
                        sb.append(jCurrentTimeMillis);
                        ms(sb.toString());
                        return true;
                    }
                    String[] strArrSplit2 = strXr.split(";");
                    int length = strArrSplit2.length;
                    if (length >= iIntValue && length != 0) {
                        boolean z = jCurrentTimeMillis - Long.valueOf(strArrSplit2[0]).longValue() > lValueOf.longValue();
                        int i = length - iIntValue;
                        for (int i2 = i; i2 < length; i2++) {
                            String str3 = strArrSplit2[i2];
                            if (i2 != i && !TextUtils.isEmpty(str3)) {
                                sb.append(str3).append(";");
                            }
                        }
                        sb.append(jCurrentTimeMillis);
                        ms(sb.toString());
                        Object[] objArr = new Object[1];
                        Boolean.valueOf(z);
                        return z;
                    }
                    for (String str4 : strArrSplit2) {
                        sb.append(str4).append(";");
                    }
                    sb.append(jCurrentTimeMillis);
                    ms(sb.toString());
                    return true;
                }
            }
            return true;
        } catch (Exception e2) {
            sl.ms(e2);
            return true;
        }
    }

    public static String xr() {
        return com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("sp_apm_record", "");
    }

    public static void ms(String str) {
        com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("sp_apm_record", str);
    }
}
