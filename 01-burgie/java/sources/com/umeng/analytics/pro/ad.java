package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: compiled from: DeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
public class ad {
    private static final String a = "ro.build.version.emui";
    private static final String b = "hw_sc.build.platform.version";

    public static aa a(Context context) {
        String str = Build.BRAND;
        am.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new ae();
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new al();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new ak();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new ai();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new af();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new ah();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
            return new aj();
        }
        if (b()) {
            return new ac();
        }
        if (a()) {
            return new ae();
        }
        if (str.equalsIgnoreCase("meizu") || str.equalsIgnoreCase("mblu")) {
            return new ag();
        }
        return null;
    }

    private static boolean a() {
        String strA = a(a);
        String strA2 = a(b);
        if (!TextUtils.isEmpty(strA) || !TextUtils.isEmpty(strA2)) {
            return true;
        }
        return false;
    }

    private static boolean b() {
        if (!TextUtils.isEmpty(a("ro.coolos.version"))) {
            return true;
        }
        return false;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable th) {
            return "";
        }
    }
}
