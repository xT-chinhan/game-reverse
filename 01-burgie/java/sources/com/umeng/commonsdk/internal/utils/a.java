package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.byazt.ol.TTDownloadField;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: ApplicationLayerUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApplicationLayerUtil.java */
    public static class C0286a {
        public String a;
        public String b;
    }

    public static long a(Context context, String str) throws Throwable {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (packageInfoA == null) {
                return 0L;
            }
            return packageInfoA.firstInstallTime;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (th == null) {
                return 0L;
            }
            ULog.e("getAppFirstInstallTime" + th.getMessage());
            return 0L;
        }
    }

    public static long b(Context context, String str) throws Throwable {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (packageInfoA == null) {
                return 0L;
            }
            return packageInfoA.lastUpdateTime;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (th == null) {
                return 0L;
            }
            ULog.e("getAppLastUpdateTime:" + th.getMessage());
            return 0L;
        }
    }

    public static String c(Context context, String str) throws Throwable {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            if (e != null) {
                ULog.e("getAppInstaller:" + e.getMessage());
            }
            return null;
        }
    }

    public static int d(Context context, String str) throws Throwable {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (packageInfoA != null && (applicationInfo = packageInfoA.applicationInfo) != null) {
                return applicationInfo.uid;
            }
            return 0;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (th != null) {
                ULog.e("getAppUid:" + th.getMessage());
            }
            return 0;
        }
    }

    public static boolean a() {
        return h.a();
    }

    public static String b() {
        return new SimpleDateFormat().format(new Date());
    }

    public static float a(Context context) throws Throwable {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            if (configuration == null) {
                return 0.0f;
            }
            return configuration.fontScale;
        } catch (Exception e) {
            if (e == null) {
                return 0.0f;
            }
            ULog.e("getFontSize:" + e.getMessage());
            return 0.0f;
        }
    }

    public static void b(Context context) {
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static DisplayMetrics e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static List<InputMethodInfo> f(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return null;
        }
        return inputMethodManager.getInputMethodList();
    }

    public static List<C0286a> g(Context context) throws Throwable {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file != null && file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(".")) {
                        C0286a c0286a = new C0286a();
                        c0286a.a = str;
                        c0286a.b = e(context, str);
                        arrayList.add(c0286a);
                    }
                }
            }
        } catch (Exception e) {
            if (e != null) {
                ULog.e("getAppList:" + e.getMessage());
            }
        }
        return arrayList;
    }

    private static String e(Context context, String str) throws Throwable {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            return (String) applicationInfo.loadLabel(context.getPackageManager());
        } catch (Exception e) {
            if (e == null) {
                return null;
            }
            ULog.e("getLabel:" + e.getMessage());
            return null;
        }
    }

    public static ActivityManager.MemoryInfo h(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static long c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String i(Context context) {
        return context == null ? null : null;
    }

    public static String j(Context context) {
        return null;
    }

    public static String d() throws Throwable {
        String str = null;
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String string = declaredMethod.invoke(null, "net.hostname").toString();
            if (string != null) {
                try {
                    if (!string.equalsIgnoreCase("")) {
                        return HelperUtils.getUmengMD5(string);
                    }
                } catch (Exception e) {
                    e = e;
                    str = string;
                    if (e != null) {
                        ULog.e("getHostName:" + e.getMessage());
                        return str;
                    }
                    return str;
                }
            }
            return string;
        } catch (Exception e2) {
            e = e2;
        }
    }
}
