package com.byazt.qam;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1745, 13})
public class hw {
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i);
        }
    }

    public static int pr(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 23) {
                return -1;
            }
            return 0;
        }
    }
}
