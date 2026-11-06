package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    public static int ms(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean ms(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }
}
