package com.byazt.igw;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ca.ho;
import com.byazt.is.vk;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.vkw.g;
import com.byazt.vlj.fw;
import com.byazt.vlj.uc;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.nl;
import com.byazt.wt.nt;
import com.byazt.xlm.aj;
import com.byazt.xlm.c;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.db.constant.Common;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 77, 37})
public class pr {
    public static String pr;

    public static void pr(Context context) {
        hw(context);
    }

    private static void hw(final Context context) {
        fw.pr(new uc() { // from class: com.byazt.igw.pr.1
            @Override // com.byazt.vlj.uc
            public boolean pr(final Throwable th, final Thread thread) {
                try {
                    aj.hw.fw(com.byazt.jp.pr.pr);
                    if (pr.hw(th, null)) {
                        c.hw(new com.byazt.xlm.fw("tt_crash_handle") { // from class: com.byazt.igw.pr.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                nl.pr().pr(thread, th, pr.pr);
                                if (vk.zo() && pr.hw(th)) {
                                    try {
                                        pr.hw(com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "sp_oom"));
                                    } catch (Throwable th2) {
                                        ho.hw("NpthUtils", "record oom count err: " + th2.getMessage());
                                    }
                                }
                            }
                        });
                        return true;
                    }
                    return false;
                } catch (Throwable th2) {
                    return false;
                }
            }

            @Override // com.byazt.vlj.uc
            public boolean pr() {
                try {
                    if (pr.hw(null, Looper.getMainLooper().getThread())) {
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    return false;
                }
            }
        });
        boolean z = false;
        boolean z2 = new SecureRandom().nextInt(10) == 0;
        Context applicationContext = context.getApplicationContext();
        com.byazt.vlj.c cVar = new com.byazt.vlj.c() { // from class: com.byazt.igw.pr.2
            @Override // com.byazt.vlj.c
            public Map<String, Object> pr() {
                g gVar = (g) com.byazt.zs.uc.pr("device_info_new");
                HashMap map = new HashMap();
                String strHw = com.byazt.sd.uc.pr().hw();
                if (TextUtils.isEmpty(strHw)) {
                    strHw = nt.pr();
                }
                if (!TextUtils.isEmpty(strHw)) {
                    map.put("device_id", strHw);
                }
                map.put("ac", com.byazt.am.x.hn(context));
                com.byazt.sd.uc.pr();
                map.put("aid", com.byazt.sd.uc.c());
                com.byazt.sd.uc.pr();
                map.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, com.byazt.sd.uc.uc());
                String strVk = ls.vk();
                if (!TextUtils.isEmpty(strVk)) {
                    map.put("app_version", strVk);
                }
                String strAj = ls.aj();
                if (!TextUtils.isEmpty(strAj)) {
                    map.put("version_code", strAj);
                    try {
                        map.put("update_version_code", Integer.valueOf(strAj));
                    } catch (Exception e) {
                        map.put("update_version_code", 0);
                        e.getMessage();
                    }
                }
                map.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "7.7.1.4");
                map.put("sdk_api_version", iu.c);
                map.put("device_platform", "android");
                map.put("os", "Android");
                String strHw2 = gVar.hw();
                map.put(an.ai, strHw2);
                map.put("device_mode", strHw2);
                map.put(Common.Predefined.SUB_ROM, gVar.qa());
                map.put("cpu_abi", Build.CPU_ABI);
                map.put(an.F, Build.BRAND);
                map.put("channel", iu.c());
                map.put("language", Locale.getDefault().getLanguage());
                map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String strSubstring = Build.VERSION.RELEASE;
                    if (strSubstring != null && strSubstring.length() > 10) {
                        strSubstring = strSubstring.substring(0, 10);
                    }
                    map.put(an.y, strSubstring);
                } catch (Exception e2) {
                }
                map.put("openudid", DeviceUtils.hw());
                map.put("dpi", String.valueOf(gVar.a()));
                map.put(an.z, er.c(context) + "*" + er.uc(context));
                return map;
            }

            @Override // com.byazt.vlj.c
            public String hw() {
                String strPr = nt.pr();
                return TextUtils.isEmpty(strPr) ? "0" : strPr;
            }

            @Override // com.byazt.vlj.c
            public String hn() {
                return com.byazt.sd.uc.pr().hn();
            }

            @Override // com.byazt.vlj.c
            public String x() {
                return null;
            }

            @Override // com.byazt.vlj.c
            public Map<String, Integer> c() {
                return null;
            }

            @Override // com.byazt.vlj.c
            public List<String> uc() {
                return null;
            }

            @Override // com.byazt.vlj.c
            public Map<String, Object> fw() {
                HashMap map = new HashMap();
                String strNy = zo.nt().ny();
                if (TextUtils.isEmpty(strNy)) {
                    com.byazt.sd.uc.pr();
                    strNy = String.valueOf(com.byazt.sd.uc.c());
                }
                map.put("host_appid", strNy);
                map.put("sdk_version", "7.7.1.4");
                map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
                map.put("channel", iu.c());
                map.put("sdk_api_version", iu.c);
                try {
                    map.put("device_score", Double.valueOf(Double.parseDouble(com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", strNy))));
                } catch (Throwable th) {
                }
                return map;
            }
        };
        boolean z3 = (a.hw().ic() & 2) == 0;
        if (z2 && (a.hw().ic() & 1) == 0) {
            z = true;
        }
        fw.pr(applicationContext, cVar, z3, z);
        com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.igw.pr.3
            @Override // java.lang.Runnable
            public void run() {
                if (!zo.nt().y()) {
                    fw.pr();
                }
                if (com.byazt.iq.pr.hw()) {
                    return;
                }
                boolean zNl = a.hw().nl();
                boolean zPr = pr.pr();
                if (zNl && zPr) {
                    fw.pr(new com.byazt.yoc.hw() { // from class: com.byazt.igw.pr.3.1
                    });
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        String strPr;
        if (zo.nt().y()) {
            return false;
        }
        if (th != null) {
            stackTrace = th.getStackTrace();
        } else if (thread == null) {
            stackTrace = null;
        } else {
            stackTrace = thread.getStackTrace();
        }
        if (iu.x < 7400) {
            strPr = null;
        } else {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 16);
            Class cls = (Class) zo.nt().ie().apply(sparseArray);
            if (cls != null) {
                pr = pr(cls);
            }
            strPr = pr(pr.class);
            pr(stackTrace);
        }
        String string = Arrays.toString(stackTrace);
        boolean zContains = string.contains("com.byazt.ig") || string.contains("com.byazt.utw") || string.contains("com.bykv.vk") || string.contains("com.bytedance.sdk.ext") || string.contains("com.bytedance.adsdk") || string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm") || string.contains("com.byakv") || string.contains("com.byazt");
        if (!zContains && !TextUtils.isEmpty(pr)) {
            zContains = string.contains(pr);
        }
        if (!zContains && !TextUtils.isEmpty(strPr)) {
            zContains = string.contains(strPr);
        }
        if (!zContains) {
            return false;
        }
        Map<String, String> mapHw = com.byazt.sd.x.pr().hw();
        if (mapHw != null) {
            if (string.contains("com.byazt.qx")) {
                mapHw.put("express", "true");
            }
            if (string.contains(com.byazt.eg.pr.class.getPackage().getName()) || string.contains("com.bytedance.sdk.openadsdk.live") || string.contains("com.bykv.vk.openvk.live")) {
                mapHw.put("live_sdk", "true");
                mapHw.put("live_sdk_version", hn());
            }
            if (string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm")) {
                mapHw.put("mediation", "true");
            } else {
                mapHw.put("mediation", "false");
            }
            String strC = iu.hn ? c() : null;
            if (!TextUtils.isEmpty(strC)) {
                mapHw.put("second_plugin_version", strC);
            }
            fw.pr(com.byazt.sd.x.pr().hw());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(Throwable th) {
        return th instanceof OutOfMemoryError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(com.byazt.zq.hn hnVar) {
        if (hnVar != null) {
            try {
                int i = hnVar.getInt("oom_count", 0);
                if (i < Integer.MAX_VALUE) {
                    i++;
                }
                hnVar.pr("oom_count", i);
            } catch (Throwable th) {
                ho.hw("NpthUtils", "increase oom count err: " + th.getMessage());
            }
        }
    }

    private static void pr(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        try {
            Function<SparseArray<Object>, Object> functionIe = zo.nt().ie();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 17);
            String[] strArr = (String[]) functionIe.apply(sparseArray);
            if (strArr != null && strArr.length != 0) {
                Field declaredField = StackTraceElement.class.getDeclaredField("declaringClass");
                declaredField.setAccessible(true);
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null) {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && !className.startsWith(LogType.JAVA_TYPE) && !className.startsWith("android") && !className.startsWith("org")) {
                            try {
                                int[] iArrPr = null;
                                com.byazt.vzx.pr prVar = (com.byazt.vzx.pr) Class.forName(className).getAnnotation(com.byazt.vzx.pr.class);
                                if (prVar != null) {
                                    iArrPr = prVar.pr();
                                }
                                if (iArrPr != null) {
                                    StringBuilder sb = new StringBuilder();
                                    char[] charArray = strArr[strArr.length - 1].toCharArray();
                                    for (int i = 0; i < iArrPr.length; i++) {
                                        int i2 = iArrPr[i];
                                        if (i2 >= 0 && i2 < strArr.length) {
                                            sb.append(pr(charArray, strArr[i2]));
                                            if (i != iArrPr.length - 1) {
                                                sb.append(".");
                                            }
                                        }
                                    }
                                    declaredField.set(stackTraceElement, sb.toString());
                                }
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            com.byazt.xk.hw.pr().pr("report", th2);
        }
    }

    public static boolean pr() {
        try {
            String strRk = a.hw().rk();
            if (!TextUtils.isEmpty(strRk) && strRk.contains(";")) {
                String[] strArrSplit = strRk.split(";");
                if (strArrSplit.length != 2) {
                    return true;
                }
                String str = strArrSplit[0];
                String str2 = strArrSplit[1];
                Long lValueOf = -1L;
                int iIntValue = -1;
                try {
                    lValueOf = Long.valueOf(Long.valueOf(str).longValue() * 60 * 1000);
                    iIntValue = Integer.valueOf(str2).intValue();
                } catch (Exception e) {
                    Object[] objArr = {"error", e.getMessage()};
                }
                if (lValueOf.longValue() >= 0 && iIntValue >= 0 && iIntValue <= 60) {
                    if (lValueOf.longValue() == 0 || iIntValue == 0 || lValueOf.longValue() / ((long) iIntValue) < 5000) {
                        return false;
                    }
                    String strHw = hw();
                    StringBuilder sb = new StringBuilder();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(strHw)) {
                        sb.append(jCurrentTimeMillis);
                        pr(sb.toString());
                        return true;
                    }
                    String[] strArrSplit2 = strHw.split(";");
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
                        pr(sb.toString());
                        new Object[1][0] = Boolean.valueOf(z);
                        return z;
                    }
                    for (String str4 : strArrSplit2) {
                        sb.append(str4).append(";");
                    }
                    sb.append(jCurrentTimeMillis);
                    pr(sb.toString());
                    return true;
                }
                return true;
            }
            return true;
        } catch (Exception e2) {
            return true;
        }
    }

    public static String hw() {
        return com.byazt.mp.x.pr().hw("sp_apm_record", "");
    }

    public static void pr(String str) {
        com.byazt.mp.x.pr().pr("sp_apm_record", str);
    }

    private static String hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Function<SparseArray<Object>, Object> functionIe = zo.nt().ie();
            if (functionIe == null) {
                return null;
            }
            Object objApply = functionIe.apply(com.byazt.xi.hw.pr().pr(8).pr(String.class).pr(0, str).hw());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String c() {
        return hw("com.byted.pangle");
    }

    public static String hn() {
        return hw("com.byted.live.lite");
    }

    private static String pr(Class cls) {
        if (cls != null) {
            String name = cls.getPackage().getName();
            if (!name.startsWith("com.bytedance.sdk")) {
                String[] strArrSplit = name.split("\\.");
                if (strArrSplit.length > 3) {
                    return strArrSplit[0] + "." + strArrSplit[1];
                }
            }
            return name;
        }
        return null;
    }

    private static String pr(char[] cArr, String str) {
        if (str == null) {
            return null;
        }
        if (cArr.length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = cArr.length;
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ cArr[i % length]);
        }
        return new String(charArray);
    }
}
