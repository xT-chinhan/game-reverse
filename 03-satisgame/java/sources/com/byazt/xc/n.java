package com.byazt.xc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.vf.l;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2465, 19})
public class n implements l, Function {
    public static String qg;
    public Context n;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return Boolean.valueOf(n());
        }
        if (iIntValue != 2) {
            return null;
        }
        return qg();
    }

    public n(Context context) {
        if (context != null) {
            this.n = context.getApplicationContext();
        }
    }

    @Override // com.byazt.vf.l
    public boolean n() {
        return n(this.n);
    }

    @Override // com.byazt.vf.l
    public String qg() {
        return qg(this.n);
    }

    private boolean n(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return false;
        }
        return TextUtils.equals(context.getApplicationContext().getPackageName(), qg(context));
    }

    private String qg(Context context) {
        if (!TextUtils.isEmpty(qg)) {
            return qg;
        }
        String strS = s();
        qg = strS;
        if (!TextUtils.isEmpty(strS)) {
            return qg;
        }
        String strQ = q();
        qg = strQ;
        if (!TextUtils.isEmpty(strQ)) {
            return qg;
        }
        String strS2 = s(context);
        qg = strS2;
        return strS2;
    }

    private static String s() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String q() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String s(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
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
