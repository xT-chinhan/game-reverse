package com.bytedance.pangle.util;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    public static boolean ab() {
        return false;
    }

    public static boolean ah() {
        return false;
    }

    public static boolean c() {
        return false;
    }

    public static boolean ch() {
        return true;
    }

    public static boolean hi() {
        return true;
    }

    public static boolean ka() {
        return false;
    }

    public static boolean ms() {
        return true;
    }

    public static boolean sl() {
        return false;
    }

    public static boolean u() {
        return true;
    }

    public static boolean xr() {
        return true;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean x() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean ny() {
        return Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT <= 30;
    }

    public static boolean zb() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean ub() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean ao() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean qv() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean y() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.VERSION.SDK_INT == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean t() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean nw() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }
}
