package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.ol.TTDownloadField;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class i {
    private static volatile String a;

    public static synchronized String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = a;
            if (!TextUtils.isEmpty(str2)) {
                str = str + (str2.endsWith("_") ? "" : "_") + d.a(str2);
            }
        }
        return str;
    }

    public static synchronized String a(Context context) {
        String str;
        if (!TextUtils.isEmpty(a)) {
            str = a;
        } else if (Build.VERSION.SDK_INT >= 28) {
            a = Application.getProcessName();
            str = a;
        } else {
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    try {
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == iMyPid) {
                            a = next.processName;
                            str = a;
                        } else {
                            continue;
                        }
                    } catch (Exception e) {
                    }
                }
                str = null;
            } else {
                str = null;
            }
        }
        return str;
    }
}
