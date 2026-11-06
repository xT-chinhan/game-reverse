package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static boolean ab = false;
    public static String ah = "6.9.2.3";
    public static String c = "main";
    public static int d = 999;
    public static boolean ka = true;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static boolean f2500ms = false;
    public static String x = "6.6.0.0";
    public static int xr = 6923;

    public static String ms(Context context) {
        return "";
    }

    public static boolean ms() {
        return true;
    }

    public static boolean xr() {
        return false;
    }

    public static boolean ah() {
        return com.bytedance.sdk.openadsdk.op.c.xr();
    }

    public static boolean d() {
        return com.bytedance.sdk.component.sl.xr.xr.t();
    }

    public static String ka() {
        return c + (ms() ? "_plugin" : "") + (ab ? "_open" : "_close");
    }

    public static boolean c() {
        return TextUtils.equals(UMModuleRegister.INNER, c);
    }
}
