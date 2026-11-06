package com.byazt.mk;

import android.app.Activity;
import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1141, 26})
public class qg {
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }

    public static int n(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }
}
