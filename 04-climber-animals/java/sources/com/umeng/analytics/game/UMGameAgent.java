package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.MLog;

/* JADX INFO: loaded from: classes4.dex */
public class UMGameAgent extends MobclickAgent {
    public static final int LEVEL_LEGITIMATE_LENGTH = 64;
    private static final String a = "Input string is null or empty";
    private static final String b = "Input string must be less than 64 chars";
    private static final String c = "Input value type is negative";
    private static final String d = "The int value for 'Pay Channels' ranges between 1 ~ 99 ";
    private static final b e = new b();
    private static Context f;

    public static void init(Context context) {
        try {
            if (f == null && context != null) {
                f = context.getApplicationContext();
            }
            e.a(f);
        } catch (Throwable unused) {
            MLog.e("please check Context!");
        }
    }

    public static void setTraceSleepTime(boolean z) {
        e.a(z);
    }

    public static void setPlayerLevel(int i) {
        e.a(String.valueOf(i));
    }

    public static void startLevel(String str) {
        if (a(str)) {
            UMLog.aq(c.k, 0, "\\|");
        } else if (str.length() > 64) {
            UMLog.aq(c.l, 0, "\\|");
        } else {
            e.b(str);
        }
    }

    public static void finishLevel(String str) {
        if (a(str)) {
            UMLog.aq(c.m, 0, "\\|");
        } else if (str.length() > 64) {
            UMLog.aq(c.n, 0, "\\|");
        } else {
            e.c(str);
        }
    }

    public static void failLevel(String str) {
        if (a(str)) {
            UMLog.aq(c.o, 0, "\\|");
        } else if (str.length() > 64) {
            UMLog.aq(c.p, 0, "\\|");
        } else {
            e.d(str);
        }
    }

    public static void pay(double d2, double d3, int i) {
        if (i <= 0 || i >= 100) {
            UMLog.aq(c.r, 0, "\\|");
        } else if (d2 < 0.0d || d3 < 0.0d) {
            UMLog.aq(c.q, 0, "\\|");
        } else {
            e.a(d2, d3, i);
        }
    }

    public static void pay(double d2, String str, int i, double d3, int i2) {
        if (i2 <= 0 || i2 >= 100) {
            UMLog.aq(c.s, 0, "\\|");
            return;
        }
        if (d2 < 0.0d || i < 0 || d3 < 0.0d) {
            UMLog.aq(c.t, 0, "\\|");
        } else if (a(str)) {
            UMLog.aq(c.u, 0, "\\|");
        } else {
            e.a(d2, str, i, d3, i2);
        }
    }

    public static void exchange(double d2, String str, double d3, int i, String str2) {
        if (d2 < 0.0d || d3 < 0.0d) {
            UMLog.aq(c.v, 0, "\\|");
        } else if (i <= 0 || i >= 100) {
            UMLog.aq(c.w, 0, "\\|");
        } else {
            e.a(d2, str, d3, i, str2);
        }
    }

    public static void buy(String str, int i, double d2) {
        if (a(str)) {
            UMLog.aq(c.x, 0, "\\|");
        } else if (i < 0 || d2 < 0.0d) {
            UMLog.aq(c.y, 0, "\\|");
        } else {
            e.a(str, i, d2);
        }
    }

    public static void use(String str, int i, double d2) {
        if (a(str)) {
            UMLog.aq(c.E, 0, "\\|");
        } else if (i < 0 || d2 < 0.0d) {
            UMLog.aq(c.F, 0, "\\|");
        } else {
            e.b(str, i, d2);
        }
    }

    public static void bonus(double d2, int i) {
        if (d2 < 0.0d) {
            UMLog.aq(c.z, 0, "\\|");
        } else if (i <= 0 || i >= 100) {
            UMLog.aq(c.A, 0, "\\|");
        } else {
            e.a(d2, i);
        }
    }

    public static void bonus(String str, int i, double d2, int i2) {
        if (a(str)) {
            UMLog.aq(c.B, 0, "\\|");
            return;
        }
        if (i < 0 || d2 < 0.0d) {
            UMLog.aq(c.C, 0, "\\|");
        } else if (i2 <= 0 || i2 >= 100) {
            UMLog.aq(c.D, 0, "\\|");
        } else {
            e.a(str, i, d2, i2);
        }
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() <= 0;
    }
}
