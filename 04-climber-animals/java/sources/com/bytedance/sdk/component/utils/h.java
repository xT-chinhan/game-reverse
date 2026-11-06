package com.bytedance.sdk.component.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f1354ms;

    public static boolean ms(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return false;
        }
        return TextUtils.equals(context.getApplicationContext().getPackageName(), xr(context));
    }

    public static String xr(Context context) {
        if (!TextUtils.isEmpty(f1354ms)) {
            return f1354ms;
        }
        String strMs = ms();
        f1354ms = strMs;
        if (!TextUtils.isEmpty(strMs)) {
            return f1354ms;
        }
        String strXr = xr();
        f1354ms = strXr;
        if (!TextUtils.isEmpty(strXr)) {
            return f1354ms;
        }
        String strAh = ah(context);
        f1354ms = strAh;
        return strAh;
    }

    private static String ms() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            sl.ms(e);
            return null;
        }
    }

    private static String xr() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            sl.ms(th);
            return null;
        }
    }

    private static String ah(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
