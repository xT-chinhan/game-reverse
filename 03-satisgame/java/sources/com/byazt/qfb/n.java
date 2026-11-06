package com.byazt.qfb;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.d.i;
import com.byazt.ehw.DeviceUtils;
import com.byazt.nf.tj;
import com.byazt.ph.q;
import com.byazt.qf.w;
import com.byazt.qf.x;
import com.byazt.qit.l;
import com.byazt.qit.rv;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.k;
import com.byazt.vf.oa;
import com.byazt.vgx.s;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2004, 19})
public class n {
    public static String n;

    public static void n(Context context) {
        qg(context);
    }

    private static void qg(final Context context) {
        x.n(new w() { // from class: com.byazt.qfb.n.1
            @Override // com.byazt.qf.w
            public boolean n(final Throwable th, final Thread thread) {
                try {
                    rv.qg.x(com.byazt.ag.n.n);
                    if (!n.qg(th, null)) {
                        return false;
                    }
                    l.qg(new com.byazt.qit.x("tt_crash_handle") { // from class: com.byazt.qfb.n.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            qg.n().n(thread, th, n.n);
                            if (q.fs() && n.qg(th)) {
                                try {
                                    n.qg(com.byazt.lk.l.n(s.q(), "sp_oom"));
                                } catch (Throwable th2) {
                                    k.qg("NpthUtils", "record oom count err: " + th2.getMessage());
                                }
                            }
                        }
                    });
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // com.byazt.qf.w
            public boolean n() {
                try {
                    return n.qg(null, Looper.getMainLooper().getThread());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        boolean z = false;
        boolean z2 = new SecureRandom().nextInt(10) == 0;
        Context applicationContext = context.getApplicationContext();
        com.byazt.qf.l lVar = new com.byazt.qf.l() { // from class: com.byazt.qfb.n.2
            @Override // com.byazt.qf.l
            public Map<String, Integer> l() {
                return null;
            }

            @Override // com.byazt.qf.l
            public String q() {
                return null;
            }

            @Override // com.byazt.qf.l
            public List<String> w() {
                return null;
            }

            @Override // com.byazt.qf.l
            public Map<String, Object> n() {
                oa oaVar = (oa) com.byazt.qp.q.n("device_info_new");
                HashMap map = new HashMap();
                String strQg = com.byazt.yu.n.n().qg();
                if (TextUtils.isEmpty(strQg)) {
                    strQg = com.byazt.ehw.l.n();
                }
                if (!TextUtils.isEmpty(strQg)) {
                    map.put(TapEventParamConstants.PARAM_DEVICE_ID, strQg);
                }
                map.put("ac", com.byazt.nx.s.s(context));
                com.byazt.yu.n.n();
                map.put("aid", com.byazt.yu.n.l());
                com.byazt.yu.n.n();
                map.put("app_name", com.byazt.yu.n.w());
                String strTj = com.byazt.vgx.w.tj();
                if (!TextUtils.isEmpty(strTj)) {
                    map.put("app_version", strTj);
                }
                String strRv = com.byazt.vgx.w.rv();
                if (!TextUtils.isEmpty(strRv)) {
                    map.put("version_code", strRv);
                    try {
                        map.put("update_version_code", Integer.valueOf(strRv));
                    } catch (Exception e) {
                        map.put("update_version_code", 0);
                        e.getMessage();
                    }
                }
                map.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "7.8.1.4");
                map.put("sdk_api_version", tj.w);
                map.put("device_platform", "android");
                map.put(TapEventParamConstants.PARAM_SUB_OS, "Android");
                String strQg2 = oaVar.qg();
                map.put("device_type", strQg2);
                map.put("device_mode", strQg2);
                map.put(TapEventParamConstants.PARAM_SUB_ROM, oaVar.um());
                map.put("cpu_abi", Build.CPU_ABI);
                map.put("device_brand", Build.BRAND);
                map.put("channel", tj.w());
                map.put("language", Locale.getDefault().getLanguage());
                map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String strSubstring = Build.VERSION.RELEASE;
                    if (strSubstring != null && strSubstring.length() > 10) {
                        strSubstring = strSubstring.substring(0, 10);
                    }
                    map.put("os_version", strSubstring);
                } catch (Exception unused) {
                }
                map.put("openudid", DeviceUtils.qg());
                map.put("dpi", String.valueOf(oaVar.a()));
                map.put("resolution", com.byazt.okk.s.l(context) + "*" + com.byazt.okk.s.w(context));
                return map;
            }

            @Override // com.byazt.qf.l
            public String qg() {
                String strN = com.byazt.ehw.l.n();
                return TextUtils.isEmpty(strN) ? "0" : strN;
            }

            @Override // com.byazt.qf.l
            public String s() {
                return com.byazt.yu.n.n().s();
            }

            @Override // com.byazt.qf.l
            public Map<String, Object> x() {
                HashMap map = new HashMap();
                String strOu = com.byazt.vyf.s.cy().ou();
                if (TextUtils.isEmpty(strOu)) {
                    com.byazt.yu.n.n();
                    strOu = String.valueOf(com.byazt.yu.n.l());
                }
                map.put("host_appid", strOu);
                map.put("sdk_version", "7.8.1.4");
                map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
                map.put("channel", tj.w());
                map.put("sdk_api_version", tj.w);
                try {
                    map.put("device_score", Double.valueOf(Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", strOu))));
                } catch (Throwable unused) {
                }
                return map;
            }
        };
        boolean z3 = (com.byazt.nf.rv.qg().pz() & 2) == 0;
        if (z2 && (com.byazt.nf.rv.qg().pz() & 1) == 0) {
            z = true;
        }
        x.n(applicationContext, lVar, z3, z);
        com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.qfb.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (!com.byazt.vyf.s.cy().lh()) {
                    x.n();
                }
                if (com.byazt.gv.n.qg()) {
                    return;
                }
                boolean zLn = com.byazt.nf.rv.qg().ln();
                boolean zN = n.n();
                if (zLn && zN) {
                    x.n(new com.byazt.ib.qg() { // from class: com.byazt.qfb.n.3.1
                    });
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        String strN;
        if (com.byazt.vyf.s.cy().lh()) {
            return false;
        }
        if (th != null) {
            stackTrace = th.getStackTrace();
        } else {
            stackTrace = thread != null ? thread.getStackTrace() : null;
        }
        if (tj.l >= 7400) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 16);
            Class cls = (Class) com.byazt.vyf.s.cy().b().apply(sparseArray);
            if (cls != null) {
                n = n(cls);
            }
            strN = n(n.class);
            n(stackTrace);
        } else {
            strN = null;
        }
        String string = Arrays.toString(stackTrace);
        boolean zContains = string.contains("com.byazt.py") || string.contains("com.byazt.okm") || string.contains("com.bykv.vk") || string.contains("com.bytedance.sdk.ext") || string.contains("com.bytedance.adsdk") || string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm") || string.contains("com.byakv") || string.contains("com.byazt");
        if (!zContains && !TextUtils.isEmpty(n)) {
            zContains = string.contains(n);
        }
        if (!zContains && !TextUtils.isEmpty(strN)) {
            zContains = string.contains(strN);
        }
        if (!zContains) {
            return false;
        }
        Map<String, String> mapS = com.byazt.vyf.qg.n().s();
        if (mapS != null) {
            if (string.contains("com.bytedance.sdk.openadsdk.core.nativeexpress")) {
                mapS.put("express", "true");
            }
            if (string.contains(com.byazt.wq.n.class.getPackage().getName()) || string.contains("com.bytedance.sdk.openadsdk.live") || string.contains("com.bykv.vk.openvk.live")) {
                mapS.put("live_sdk", "true");
                mapS.put("live_sdk_version", s());
            }
            if (string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm")) {
                mapS.put("mediation", "true");
            } else {
                mapS.put("mediation", "false");
            }
            String strL = tj.s ? l() : null;
            if (!TextUtils.isEmpty(strL)) {
                mapS.put("second_plugin_version", strL);
            }
            x.n(mapS);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(Throwable th) {
        return th instanceof OutOfMemoryError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(com.byazt.gwu.s sVar) {
        if (sVar == null) {
            return;
        }
        try {
            int i = sVar.getInt("oom_count", 0);
            if (i < Integer.MAX_VALUE) {
                i++;
            }
            sVar.n("oom_count", i);
        } catch (Throwable th) {
            k.qg("NpthUtils", "increase oom count err: " + th.getMessage());
        }
    }

    private static void n(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        try {
            Function<SparseArray<Object>, Object> functionB = com.byazt.vyf.s.cy().b();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 17);
            String[] strArr = (String[]) functionB.apply(sparseArray);
            if (strArr != null && strArr.length != 0) {
                Field declaredField = StackTraceElement.class.getDeclaredField("declaringClass");
                declaredField.setAccessible(true);
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null) {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && !className.startsWith("java") && !className.startsWith("android") && !className.startsWith("org")) {
                            try {
                                com.byazt.cp.n nVar = (com.byazt.cp.n) Class.forName(className).getAnnotation(com.byazt.cp.n.class);
                                int[] iArrN = nVar != null ? nVar.n() : null;
                                if (iArrN != null) {
                                    StringBuilder sb = new StringBuilder();
                                    char[] charArray = strArr[strArr.length - 1].toCharArray();
                                    for (int i = 0; i < iArrN.length; i++) {
                                        int i2 = iArrN[i];
                                        if (i2 >= 0 && i2 < strArr.length) {
                                            sb.append(n(charArray, strArr[i2]));
                                            if (i != iArrN.length - 1) {
                                                sb.append(i.E);
                                            }
                                        }
                                    }
                                    declaredField.set(stackTraceElement, sb.toString());
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.byazt.eji.s.n().n("report", th);
        }
    }

    public static boolean n() {
        int iIntValue;
        try {
            String strDm = com.byazt.nf.rv.qg().dm();
            if (!TextUtils.isEmpty(strDm) && strDm.contains(";")) {
                String[] strArrSplit = strDm.split(";");
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
                    Object[] objArr = new Object[2];
                    e.getMessage();
                    iIntValue = -1;
                }
                if (lValueOf.longValue() >= 0 && iIntValue >= 0 && iIntValue <= 60) {
                    if (lValueOf.longValue() == 0 || iIntValue == 0 || lValueOf.longValue() / ((long) iIntValue) < 5000) {
                        return false;
                    }
                    String strQg = qg();
                    StringBuilder sb = new StringBuilder();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(strQg)) {
                        sb.append(jCurrentTimeMillis);
                        n(sb.toString());
                        return true;
                    }
                    String[] strArrSplit2 = strQg.split(";");
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
                        n(sb.toString());
                        Object[] objArr2 = new Object[1];
                        Boolean.valueOf(z);
                        return z;
                    }
                    for (String str4 : strArrSplit2) {
                        sb.append(str4).append(";");
                    }
                    sb.append(jCurrentTimeMillis);
                    n(sb.toString());
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static String qg() {
        return com.byazt.ed.s.n().qg("sp_apm_record", "");
    }

    public static void n(String str) {
        com.byazt.ed.s.n().n("sp_apm_record", str);
    }

    private static String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Function<SparseArray<Object>, Object> functionB = com.byazt.vyf.s.cy().b();
            if (functionB == null) {
                return null;
            }
            Object objApply = functionB.apply(com.byazt.of.qg.n().n(8).n(String.class).n(0, str).qg());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String l() {
        return qg("com.byted.pangle");
    }

    public static String s() {
        return qg("com.byted.live.lite");
    }

    private static String n(Class cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getPackage().getName();
        if (name.startsWith("com.bytedance.sdk")) {
            return name;
        }
        String[] strArrSplit = name.split("\\.");
        return strArrSplit.length > 3 ? strArrSplit[0] + i.E + strArrSplit[1] : name;
    }

    private static String n(char[] cArr, String str) {
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
