package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class i {
    private static volatile String a;

    public static synchronized String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = a;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + (str2.endsWith("_") ? "" : "_") + d.a(str2);
    }

    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            a = Application.getProcessName();
            return a;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                try {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        a = next.processName;
                        return a;
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }
}
