package com.bytedance.sdk.openadsdk.core.i;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }

    public static int ms(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable th) {
            sl.ms(th);
            return -1;
        }
    }
}
