package com.byazt.gx;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static boolean l() {
        return false;
    }

    public static boolean n() {
        return true;
    }

    public static boolean q() {
        return false;
    }

    public static boolean qg() {
        return true;
    }

    public static boolean rv() {
        return true;
    }

    public static boolean tj() {
        return true;
    }

    public static boolean s() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean w() {
        return Build.VERSION.SDK_INT <= 25;
    }

    public static boolean x() {
        return Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 28;
    }

    public static boolean fs() {
        return Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT <= 30;
    }

    public static boolean cp() {
        return Build.VERSION.SDK_INT <= 25;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean oa() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean sz() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean k() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean cy() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean hd() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean cd() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.VERSION.SDK_INT == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean um() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean a() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }
}
