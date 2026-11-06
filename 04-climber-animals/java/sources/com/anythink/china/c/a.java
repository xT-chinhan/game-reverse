package com.anythink.china.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.math.BigDecimal;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = null;
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static String l = "";
    private static String m = "";

    public static void a(Context context) {
        a = c(context);
        b = d(context);
        c = m.s();
        String[] strArrA = b.a(m.A(context));
        if (strArrA != null && strArrA.length == 2) {
            d = strArrA[0];
            e = strArrA[1];
        }
        f = b.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.anythink.core.common.c.a(j.t.f, "vivo_ver"));
        if (Build.VERSION.SDK_INT >= 29) {
            arrayList.add(new com.anythink.core.common.c.a(j.t.d, "oppo_ver"));
        } else {
            arrayList.add(new com.anythink.core.common.c.a(j.t.e, "oppo_ver"));
        }
        arrayList.add(new com.anythink.core.common.c.a(j.t.c, "xiaomi_ver"));
        arrayList.add(new com.anythink.core.common.c.a(j.t.a, "honor_ver"));
        arrayList.add(new com.anythink.core.common.c.a(j.t.g, "honor_v2_ver"));
        com.anythink.core.common.c.b.a().a(arrayList);
    }

    public static String b(Context context) {
        d(context);
        return !TextUtils.isEmpty(b) ? b : "";
    }

    public static synchronized String c(Context context) {
        if (t.b().c("mac")) {
            return "";
        }
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
            t.b();
            if (!t.c(context)) {
                return "";
            }
        }
        if (!i && TextUtils.isEmpty(a)) {
            a = t.b().c("mac") ? "" : d.a();
            i = true;
        }
        return a;
    }

    public static synchronized String d(Context context) {
        if (t.b().c("imei")) {
            return "";
        }
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
            t.b();
            if (!t.c(context)) {
                return "";
            }
        }
        if (!h && TextUtils.isEmpty(b) && com.anythink.china.a.c.a(context, "android.permission.READ_PHONE_STATE")) {
            b = c.a(context);
            h = true;
        }
        return b;
    }

    public static synchronized String a() {
        if (t.b().c("wifi_name")) {
            return "";
        }
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
            t.b();
            if (!t.c(t.b().g())) {
                return "";
            }
        }
        if (!j && TextUtils.isEmpty(l)) {
            l = b.b(t.b().g());
            j = true;
        }
        return l;
    }

    public static synchronized void b() {
        l = null;
    }

    public static String c() {
        if (t.b().c("imsi")) {
            return "";
        }
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
            t.b();
            if (!t.c(t.b().g())) {
                return "";
            }
        }
        if (!k && TextUtils.isEmpty(m) && com.anythink.china.a.c.a(t.b().g(), "android.permission.READ_PHONE_STATE")) {
            synchronized (b.class) {
                if (!k) {
                    m = b.a(t.b().g());
                    k = true;
                }
            }
        }
        return m;
    }

    public static String d() {
        return c;
    }

    public static String e() {
        return m.u(t.b().g());
    }

    public static String f() {
        return d;
    }

    public static String g() {
        return e;
    }

    public static String h() {
        return f;
    }

    public static synchronized String e(Context context) {
        String str = g;
        if (str != null) {
            return str;
        }
        try {
            g = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (g == null) {
            g = "";
        }
        return g;
    }

    public static String i() {
        try {
            return new BigDecimal((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d).setScale(6, 4).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String j() {
        String strB = m.b();
        String lowerCase = Build.MANUFACTURER != null ? Build.MANUFACTURER.toLowerCase() : "";
        if (strB.contains(MediationConstant.ADN_XIAOMI) || strB.contains("redmi") || lowerCase.contains(MediationConstant.ADN_XIAOMI) || lowerCase.contains("redmi")) {
            return j.t.c;
        }
        if (strB.contains("huawei") || lowerCase.contains("huawei")) {
            return j.t.a;
        }
        if (strB.contains("oppo") || lowerCase.contains("oppo")) {
            if (Build.VERSION.SDK_INT >= 29) {
                return j.t.d;
            }
            return j.t.e;
        }
        if (strB.contains("vivo") || lowerCase.contains("vivo")) {
            return j.t.f;
        }
        return (strB.contains("honor") || lowerCase.contains("honor") || strB.contains("hihonor") || lowerCase.contains("hihonor")) ? j.t.g : "";
    }
}
