package com.byazt.sd;

import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 166})
public final class iu {
    public static final int hw = 7714;
    public static final Boolean pr = Boolean.FALSE;
    public static boolean hn = false;
    public static int x = 7714;
    public static String c = "7.7.1.4";
    public static int uc = 1160;
    public static boolean fw = true;
    public static String zo = "main";
    public static boolean aj = false;
    public static String vk = "6.6.0.0";

    public static boolean pr() {
        return true;
    }

    public static boolean hw() {
        return com.byazt.zp.fw.hw();
    }

    public static boolean hn() {
        return false;
    }

    public static boolean x() {
        return com.byazt.it.hw.pr().pr();
    }

    public static String c() {
        return zo + (pr() ? "_plugin" : "") + (aj ? "_open" : "_close");
    }

    public static String uc() {
        return pr("com.byted.pangle", 7714);
    }

    public static String pr(String str, int i) {
        return "";
    }

    public static boolean fw() {
        return TextUtils.equals(UMModuleRegister.INNER, zo);
    }
}
