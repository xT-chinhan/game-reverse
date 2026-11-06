package com.efs.sdk.memleaksdk.monitor.shark;

import android.app.Application;
import android.content.SharedPreferences;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static SharedPreferences a;
    private static String b;

    public static void a(Application application) {
        a = application.getSharedPreferences("u_monitor", 0);
        b = UMUtils.getAppVersionName(UMonitor.getContext()) + "_";
    }

    public static int a() {
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(b + "times", 0);
    }

    public static void b() {
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt(b + "times", sharedPreferences.getInt(b + "times", 0) + 1).apply();
    }

    public static long c() {
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences == null) {
            return 0L;
        }
        long j = sharedPreferences.getLong(b + "first_analysis_time", 0L);
        if (j != 0) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        a(jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    public static void a(long j) {
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences == null || sharedPreferences.contains(b + "first_analysis_time")) {
            return;
        }
        sharedPreferences.edit().putLong(b + "first_analysis_time", j).apply();
    }
}
