package com.anythink.china.e;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static String h = null;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static boolean l = false;
    private static String m = "";
    private static String n = "";

    public static void a(Context context) {
        b = c(context);
        c = d(context);
        d = l.s();
        String[] strArrA = b.a(l.y(context));
        if (strArrA != null && strArrA.length == 2) {
            e = strArrA[0];
            f = strArrA[1];
        }
        g = b.a();
    }

    public static String b(Context context) {
        d(context);
        return !TextUtils.isEmpty(c) ? c : "";
    }

    public static synchronized String c(Context context) {
        if (s.b().c("mac")) {
            return "";
        }
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
            s.b();
            if (!s.y()) {
                return "";
            }
        }
        if (!j && TextUtils.isEmpty(b)) {
            b = s.b().c("mac") ? "" : d.a();
            j = true;
        }
        return b;
    }

    public static synchronized String d(Context context) {
        if (s.b().c("imei")) {
            return "";
        }
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
            s.b();
            if (!s.y()) {
                return "";
            }
        }
        if (!i && TextUtils.isEmpty(c) && com.anythink.china.b.c.a(context, com.anythink.china.b.c.a)) {
            c = c.a(context);
            i = true;
        }
        return c;
    }

    public static synchronized String a() {
        if (s.b().c("wifi_name")) {
            return "";
        }
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
            s.b();
            s.b().g();
            if (!s.y()) {
                return "";
            }
        }
        if (!k && TextUtils.isEmpty(m)) {
            m = b.b(s.b().g());
            k = true;
        }
        return m;
    }

    public static synchronized void b() {
        m = null;
    }

    public static String c() {
        if (s.b().c("imsi")) {
            return "";
        }
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
            s.b();
            s.b().g();
            if (!s.y()) {
                return "";
            }
        }
        if (!l && TextUtils.isEmpty(n) && com.anythink.china.b.c.a(s.b().g(), com.anythink.china.b.c.a)) {
            synchronized (b.class) {
                if (!l) {
                    n = b.a(s.b().g());
                    l = true;
                }
            }
        }
        return n;
    }

    public static String d() {
        return d;
    }

    public static String e() {
        return l.s(s.b().g());
    }

    public static String f() {
        return e;
    }

    public static String g() {
        return f;
    }

    public static String h() {
        return g;
    }

    public static synchronized String e(Context context) {
        String str = h;
        if (str != null) {
            return str;
        }
        try {
            h = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (h == null) {
            h = "";
        }
        return h;
    }

    public static String i() {
        try {
            return new BigDecimal((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d).setScale(6, 4).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String j() {
        String strB = l.b();
        String lowerCase = Build.MANUFACTURER != null ? Build.MANUFACTURER.toLowerCase() : "";
        if (strB.contains(MediationConstant.ADN_XIAOMI) || strB.contains("redmi") || lowerCase.contains(MediationConstant.ADN_XIAOMI) || lowerCase.contains("redmi")) {
            return i.u.c;
        }
        if (strB.contains("huawei") || lowerCase.contains("huawei")) {
            return i.u.a;
        }
        if (strB.contains("oppo") || lowerCase.contains("oppo")) {
            if (Build.VERSION.SDK_INT >= 29) {
                return i.u.d;
            }
            return i.u.e;
        }
        if (strB.contains("vivo") || lowerCase.contains("vivo")) {
            return i.u.f;
        }
        return (strB.contains("honor") || lowerCase.contains("honor") || strB.contains("hihonor") || lowerCase.contains("hihonor")) ? i.u.g : "";
    }
}
