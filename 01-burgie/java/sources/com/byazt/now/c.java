package com.byazt.now;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1862, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static String c;
    public static String fw;
    public static String hn;
    public static String pr;
    public static String uc;
    public static String x = "";
    public static String hw = "";
    public static Boolean zo = null;

    public static boolean pr() {
        return pr("EMUI") || pr("MAGICUI");
    }

    public static boolean hw() {
        return pr("MAGICUI");
    }

    public static boolean hn() {
        return pr("MIUI");
    }

    public static boolean x() {
        return pr("VIVO");
    }

    public static boolean c() {
        lb();
        return pr(pr);
    }

    public static boolean uc() {
        return pr("FLYME");
    }

    public static boolean fw() {
        return pr("SAMSUNG");
    }

    public static String zo() {
        if (c == null) {
            pr("");
        }
        return c;
    }

    public static String aj() {
        if (uc == null) {
            pr("");
        }
        return uc;
    }

    public static String vk() {
        if (hn == null) {
            pr("");
        }
        return hn;
    }

    private static void lb() {
        if (TextUtils.isEmpty(pr)) {
            com.byazt.lj.hn.n();
            pr = com.byazt.mrs.c.hw;
            x = "ro.build.version." + com.byazt.mrs.c.hn + Common.Predefined.SUB_ROM;
            hw = "com." + com.byazt.mrs.c.hn + ".market";
        }
    }

    public static boolean pr(String str) {
        lb();
        String str2 = c;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strX = x("ro.miui.ui.version.name");
        uc = strX;
        if (!TextUtils.isEmpty(strX)) {
            c = "MIUI";
            hn = "com.xiaomi.market";
            fw = uc;
        } else {
            String strX2 = x("ro.build.version.emui");
            uc = strX2;
            if (!TextUtils.isEmpty(strX2)) {
                String str3 = yb() ? "MAGICUI" : "EMUI";
                c = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    hn = "com.hihonor.appmarket";
                } else {
                    hn = "com.huawei.appmarket";
                }
            } else {
                String strX3 = x("ro.build.version.magic");
                uc = strX3;
                if (!TextUtils.isEmpty(strX3)) {
                    c = "MAGICUI";
                    hn = "com.hihonor.appmarket";
                } else {
                    String strX4 = x(x);
                    uc = strX4;
                    if (TextUtils.isEmpty(strX4)) {
                        String strX5 = x("ro.vivo.os.version");
                        uc = strX5;
                        if (!TextUtils.isEmpty(strX5)) {
                            c = "VIVO";
                            hn = "com.bbk.appstore";
                        } else {
                            String strX6 = x("ro.smartisan.version");
                            uc = strX6;
                            if (!TextUtils.isEmpty(strX6)) {
                                c = "SMARTISAN";
                                hn = "com.smartisanos.appstore";
                            } else {
                                String strX7 = x("ro.gn.sv.version");
                                uc = strX7;
                                if (!TextUtils.isEmpty(strX7)) {
                                    c = "QIONEE";
                                    hn = "com.gionee.aora.market";
                                } else {
                                    String strX8 = x("ro.lenovo.lvp.version");
                                    uc = strX8;
                                    if (!TextUtils.isEmpty(strX8)) {
                                        c = "LENOVO";
                                        hn = "com.lenovo.leos.appstore";
                                    } else if (w().toUpperCase().contains("SAMSUNG")) {
                                        c = "SAMSUNG";
                                        hn = "com.sec.android.app.samsungapps";
                                    } else if (w().toUpperCase().contains("ZTE")) {
                                        c = "ZTE";
                                        hn = "zte.com.market";
                                    } else if (w().toUpperCase().contains("NUBIA")) {
                                        c = "NUBIA";
                                        hn = "cn.nubia.neostore";
                                    } else if (k().toUpperCase().contains("FLYME")) {
                                        c = "FLYME";
                                        hn = "com.meizu.mstore";
                                        uc = k();
                                    } else if (w().toUpperCase().contains("ONEPLUS")) {
                                        c = "ONEPLUS";
                                        uc = x("ro.rom.version");
                                        if (com.byazt.mdu.uc.pr(hw) >= 0) {
                                            hn = hw;
                                        } else {
                                            hn = "com.heytap.market";
                                        }
                                    } else {
                                        c = w().toUpperCase();
                                        hn = "";
                                        uc = "";
                                    }
                                }
                            }
                        }
                    } else {
                        c = pr;
                        if (com.byazt.mdu.uc.pr(hw) >= 0) {
                            hn = hw;
                        } else {
                            hn = "com.heytap.market";
                        }
                    }
                }
            }
        }
        return c.equals(str);
    }

    public static String hw(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                com.byazt.tuy.uc.pr(bufferedReader);
                return line;
            } catch (Throwable th) {
                com.byazt.tuy.uc.pr(bufferedReader);
                return null;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
    }

    public static String hn(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String x(String str) {
        if (com.byazt.ew.pr.hw().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return hn(str);
            } catch (Throwable th) {
            }
        }
        return hw(str);
    }

    public static String w() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static String k() {
        return Build.DISPLAY == null ? "" : Build.DISPLAY.trim();
    }

    public static boolean m() {
        qa();
        return "V10".equals(fw);
    }

    public static boolean g() {
        qa();
        return "V11".equals(fw);
    }

    public static boolean ho() {
        qa();
        return "V12".equals(fw);
    }

    private static void qa() {
        if (fw == null) {
            try {
                fw = x("ro.miui.ui.version.name");
            } catch (Exception e) {
            }
            String str = fw;
            if (str == null) {
                str = "";
            }
            fw = str;
        }
    }

    public static boolean nt() {
        if (zo == null) {
            zo = Boolean.valueOf(x.fw().equals("harmony"));
        }
        return zo.booleanValue();
    }

    public static boolean yb() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor");
        }
        return true;
    }
}
