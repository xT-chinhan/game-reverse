package com.byazt.gs;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 61})
public class aj {
    public static boolean pr() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean hw() {
        return Build.VERSION.SDK_INT > 22;
    }

    public static boolean hn() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 28;
    }

    public static boolean x() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23;
    }

    public static boolean uc() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25;
    }

    public static boolean fw() {
        return Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 28;
    }

    public static boolean zo() {
        return Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT <= 30;
    }

    public static boolean aj() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean vk() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean w() {
        return Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT <= 25;
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT <= 28;
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean g() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean ho() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean nt() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean yb() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean lb() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.VERSION.SDK_INT == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean qa() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean a() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }
}
