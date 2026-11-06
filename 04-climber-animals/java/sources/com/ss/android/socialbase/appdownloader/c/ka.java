package com.ss.android.socialbase.appdownloader.c;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.ab;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public class ka {
    private static String ab = null;
    public static String ah = null;
    private static String c = null;
    private static String d = "";
    private static String ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static String f4562ms = null;
    private static Boolean x = null;
    public static String xr = "";

    public static boolean ms() {
        return ms("EMUI") || ms("MAGICUI");
    }

    public static boolean xr() {
        return ms("MAGICUI");
    }

    public static boolean ah() {
        return ms("MIUI");
    }

    public static boolean d() {
        return ms("VIVO");
    }

    public static boolean ka() {
        qv();
        return ms(f4562ms);
    }

    public static boolean c() {
        return ms("FLYME");
    }

    public static boolean ab() {
        return ms("SAMSUNG");
    }

    public static String x() {
        if (ka == null) {
            ms("");
        }
        return ka;
    }

    public static String ny() {
        if (c == null) {
            ms("");
        }
        return c;
    }

    public static String ch() {
        if (ah == null) {
            ms("");
        }
        return ah;
    }

    private static void qv() {
        if (TextUtils.isEmpty(f4562ms)) {
            com.ss.android.socialbase.downloader.downloader.ah.pc();
            f4562ms = com.ss.android.socialbase.downloader.constants.ka.xr;
            d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.ka.ah + "rom";
            xr = "com." + com.ss.android.socialbase.downloader.constants.ka.ah + ".market";
        }
    }

    public static boolean ms(String str) {
        qv();
        String str2 = ka;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strD = d("ro.miui.ui.version.name");
        c = strD;
        if (!TextUtils.isEmpty(strD)) {
            ka = "MIUI";
            ah = "com.xiaomi.market";
            ab = c;
        } else {
            String strD2 = d("ro.build.version.emui");
            c = strD2;
            if (!TextUtils.isEmpty(strD2)) {
                String str3 = h() ? "MAGICUI" : "EMUI";
                ka = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    ah = "com.hihonor.appmarket";
                } else {
                    ah = "com.huawei.appmarket";
                }
            } else {
                String strD3 = d("ro.build.version.magic");
                c = strD3;
                if (!TextUtils.isEmpty(strD3)) {
                    ka = "MAGICUI";
                    ah = "com.hihonor.appmarket";
                } else {
                    String strD4 = d(d);
                    c = strD4;
                    if (!TextUtils.isEmpty(strD4)) {
                        ka = f4562ms;
                        if (ab.ms(xr) >= 0) {
                            ah = xr;
                        } else {
                            ah = "com.heytap.market";
                        }
                    } else {
                        String strD5 = d("ro.vivo.os.version");
                        c = strD5;
                        if (!TextUtils.isEmpty(strD5)) {
                            ka = "VIVO";
                            ah = "com.bbk.appstore";
                        } else {
                            String strD6 = d("ro.smartisan.version");
                            c = strD6;
                            if (!TextUtils.isEmpty(strD6)) {
                                ka = "SMARTISAN";
                                ah = "com.smartisanos.appstore";
                            } else {
                                String strD7 = d("ro.gn.sv.version");
                                c = strD7;
                                if (!TextUtils.isEmpty(strD7)) {
                                    ka = "QIONEE";
                                    ah = "com.gionee.aora.market";
                                } else {
                                    String strD8 = d("ro.lenovo.lvp.version");
                                    c = strD8;
                                    if (!TextUtils.isEmpty(strD8)) {
                                        ka = "LENOVO";
                                        ah = "com.lenovo.leos.appstore";
                                    } else if (hi().toUpperCase().contains("SAMSUNG")) {
                                        ka = "SAMSUNG";
                                        ah = "com.sec.android.app.samsungapps";
                                    } else if (hi().toUpperCase().contains("ZTE")) {
                                        ka = "ZTE";
                                        ah = "zte.com.market";
                                    } else if (hi().toUpperCase().contains("NUBIA")) {
                                        ka = "NUBIA";
                                        ah = "cn.nubia.neostore";
                                    } else if (sl().toUpperCase().contains("FLYME")) {
                                        ka = "FLYME";
                                        ah = "com.meizu.mstore";
                                        c = sl();
                                    } else if (hi().toUpperCase().contains("ONEPLUS")) {
                                        ka = "ONEPLUS";
                                        c = d("ro.rom.version");
                                        if (ab.ms(xr) >= 0) {
                                            ah = xr;
                                        } else {
                                            ah = "com.heytap.market";
                                        }
                                    } else {
                                        ka = hi().toUpperCase();
                                        ah = "";
                                        c = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ka.equals(str);
    }

    public static String xr(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                com.ss.android.socialbase.downloader.ny.c.ms(bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.ss.android.socialbase.downloader.ny.c.ms(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String ah(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String d(String str) {
        if (com.ss.android.socialbase.downloader.ab.ms.xr().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return ah(str);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
        return xr(str);
    }

    public static String hi() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static String sl() {
        return Build.DISPLAY == null ? "" : Build.DISPLAY.trim();
    }

    public static boolean zb() {
        y();
        return "V10".equals(ab);
    }

    public static boolean u() {
        y();
        return "V11".equals(ab);
    }

    public static boolean ub() {
        y();
        return "V12".equals(ab);
    }

    private static void y() {
        if (ab == null) {
            try {
                ab = d("ro.miui.ui.version.name");
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            String str = ab;
            if (str == null) {
                str = "";
            }
            ab = str;
        }
    }

    public static boolean ao() {
        if (x == null) {
            x = Boolean.valueOf(d.ab().equals("harmony"));
        }
        return x.booleanValue();
    }

    public static boolean h() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor");
        }
        return true;
    }
}
