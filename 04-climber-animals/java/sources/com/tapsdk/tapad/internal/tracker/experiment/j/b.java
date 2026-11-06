package com.tapsdk.tapad.internal.tracker.experiment.j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    static String a = "";

    public static String a() {
        return Build.CPU_ABI;
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            a = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            a = "00000000";
        }
        return a;
    }

    public static boolean a(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        return applicationInfo != null;
    }

    public static String b() {
        Locale localeC = c();
        return localeC.getLanguage() + "-" + localeC.getCountry();
    }

    public static String b(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager == null) {
                return null;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return Formatter.formatFileSize(context, memoryInfo.totalMem);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return Formatter.formatFileSize(context, statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Locale c() {
        return LocaleList.getDefault().get(0);
    }

    public static String d() {
        return Build.MANUFACTURER;
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String e() {
        return Build.MODEL;
    }

    public static String f() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String f(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem);
        } catch (Exception e) {
            System.out.println(e.toString());
            return "";
        }
    }

    public static String g() {
        return "Android";
    }

    public static String h() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return String.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Exception e) {
            System.out.println(e.toString());
            return "";
        }
    }
}
