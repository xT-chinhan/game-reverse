package com.byazt.bk;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 18})
public class l {
    public static Boolean fs = null;
    public static String l = null;
    public static String n = null;
    public static String q = "";
    public static String qg = "";
    public static String s;
    public static String w;
    public static String x;

    public static boolean n() {
        return n("EMUI") || n("MAGICUI");
    }

    public static boolean qg() {
        return n("MAGICUI");
    }

    public static boolean s() {
        return n("MIUI");
    }

    public static boolean q() {
        return n("VIVO");
    }

    public static boolean l() {
        cd();
        return n(n);
    }

    public static boolean w() {
        return n("FLYME");
    }

    public static boolean x() {
        return n("SAMSUNG");
    }

    public static String fs() {
        if (l == null) {
            n("");
        }
        return l;
    }

    public static String rv() {
        if (w == null) {
            n("");
        }
        return w;
    }

    public static String tj() {
        if (s == null) {
            n("");
        }
        return s;
    }

    private static void cd() {
        if (TextUtils.isEmpty(n)) {
            com.byazt.xv.s.j();
            n = com.byazt.sk.l.qg;
            q = "ro.build.version." + com.byazt.sk.l.s + TapEventParamConstants.PARAM_SUB_ROM;
            qg = "com." + com.byazt.sk.l.s + ".market";
        }
    }

    public static boolean n(String str) {
        cd();
        String str2 = l;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strQ = q("ro.miui.ui.version.name");
        w = strQ;
        if (!TextUtils.isEmpty(strQ)) {
            l = "MIUI";
            s = "com.xiaomi.market";
            x = w;
        } else {
            String strQ2 = q("ro.build.version.emui");
            w = strQ2;
            if (!TextUtils.isEmpty(strQ2)) {
                String str3 = hd() ? "MAGICUI" : "EMUI";
                l = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    s = "com.hihonor.appmarket";
                } else {
                    s = "com.huawei.appmarket";
                }
            } else {
                String strQ3 = q("ro.build.version.magic");
                w = strQ3;
                if (!TextUtils.isEmpty(strQ3)) {
                    l = "MAGICUI";
                    s = "com.hihonor.appmarket";
                } else {
                    String strQ4 = q(q);
                    w = strQ4;
                    if (!TextUtils.isEmpty(strQ4)) {
                        l = n;
                        if (com.byazt.e.w.n(qg) >= 0) {
                            s = qg;
                        } else {
                            s = "com.heytap.market";
                        }
                    } else {
                        String strQ5 = q("ro.vivo.os.version");
                        w = strQ5;
                        if (!TextUtils.isEmpty(strQ5)) {
                            l = "VIVO";
                            s = "com.bbk.appstore";
                        } else {
                            String strQ6 = q("ro.smartisan.version");
                            w = strQ6;
                            if (!TextUtils.isEmpty(strQ6)) {
                                l = "SMARTISAN";
                                s = "com.smartisanos.appstore";
                            } else {
                                String strQ7 = q("ro.gn.sv.version");
                                w = strQ7;
                                if (!TextUtils.isEmpty(strQ7)) {
                                    l = "QIONEE";
                                    s = "com.gionee.aora.market";
                                } else {
                                    String strQ8 = q("ro.lenovo.lvp.version");
                                    w = strQ8;
                                    if (!TextUtils.isEmpty(strQ8)) {
                                        l = "LENOVO";
                                        s = "com.lenovo.leos.appstore";
                                    } else if (cp().toUpperCase().contains("SAMSUNG")) {
                                        l = "SAMSUNG";
                                        s = "com.sec.android.app.samsungapps";
                                    } else if (cp().toUpperCase().contains("ZTE")) {
                                        l = "ZTE";
                                        s = "zte.com.market";
                                    } else if (cp().toUpperCase().contains("NUBIA")) {
                                        l = "NUBIA";
                                        s = "cn.nubia.neostore";
                                    } else if (d().toUpperCase().contains("FLYME")) {
                                        l = "FLYME";
                                        s = "com.meizu.mstore";
                                        w = d();
                                    } else if (cp().toUpperCase().contains("ONEPLUS")) {
                                        l = "ONEPLUS";
                                        w = q("ro.rom.version");
                                        if (com.byazt.e.w.n(qg) >= 0) {
                                            s = qg;
                                        } else {
                                            s = "com.heytap.market";
                                        }
                                    } else {
                                        l = cp().toUpperCase();
                                        s = "";
                                        w = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return l.equals(str);
    }

    public static String qg(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                com.byazt.ta.w.n(bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.byazt.ta.w.n(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String s(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String q(String str) {
        if (com.byazt.f.n.qg().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return s(str);
            } catch (Throwable unused) {
            }
        }
        return qg(str);
    }

    public static String cp() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static String d() {
        return Build.DISPLAY == null ? "" : Build.DISPLAY.trim();
    }

    public static boolean oa() {
        um();
        return "V10".equals(x);
    }

    public static boolean sz() {
        um();
        return "V11".equals(x);
    }

    public static boolean k() {
        um();
        return "V12".equals(x);
    }

    private static void um() {
        if (x == null) {
            try {
                x = q("ro.miui.ui.version.name");
            } catch (Exception unused) {
            }
            String str = x;
            if (str == null) {
                str = "";
            }
            x = str;
        }
    }

    public static boolean cy() {
        if (fs == null) {
            fs = Boolean.valueOf(q.x().equals("harmony"));
        }
        return fs.booleanValue();
    }

    public static boolean hd() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor");
        }
        return true;
    }
}
