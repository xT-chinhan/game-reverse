package com.byazt.zs;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ol.TTDownloadField;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 20})
public class hn implements com.byazt.vkw.c, Function {
    public static String hw;
    public Context pr;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(pr());
            case 2:
                return hw();
            default:
                return null;
        }
    }

    public hn(Context context) {
        if (context != null) {
            this.pr = context.getApplicationContext();
        }
    }

    @Override // com.byazt.vkw.c
    public boolean pr() {
        return pr(this.pr);
    }

    @Override // com.byazt.vkw.c
    public String hw() {
        return hw(this.pr);
    }

    private boolean pr(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return false;
        }
        return TextUtils.equals(context.getApplicationContext().getPackageName(), hw(context));
    }

    private String hw(Context context) {
        if (!TextUtils.isEmpty(hw)) {
            return hw;
        }
        String strHn = hn();
        hw = strHn;
        if (!TextUtils.isEmpty(strHn)) {
            return hw;
        }
        String strX = x();
        hw = strX;
        if (!TextUtils.isEmpty(strX)) {
            return hw;
        }
        String strHn2 = hn(context);
        hw = strHn2;
        return strHn2;
    }

    private static String hn() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static String x() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (!(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String hn(Context context) {
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
