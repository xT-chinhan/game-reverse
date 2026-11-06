package com.smartdigimkt.dlpd;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.d.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class NotificationPermissionRequester {
    private static final int API_33 = 33;
    private static final int APK_TYPE = 4;
    private static final String TAG = "NotificationPermission";
    private static final AtomicBoolean sRequested = new AtomicBoolean(false);

    private NotificationPermissionRequester() {
    }

    public static void requestIfNeeded(Context context, c cVar) {
        if (context == null || cVar == null) {
            return;
        }
        try {
            e eVar = cVar.w;
            int i = eVar != null ? eVar.n1 : 1;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (shouldRequest(Build.VERSION.SDK_INT, applicationInfo != null ? applicationInfo.targetSdkVersion : 0, cVar.o, i) && context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0 && sRequested.compareAndSet(false, true)) {
                b.a(context, "android.permission.POST_NOTIFICATIONS");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void resetForTest() {
        sRequested.set(false);
    }

    public static boolean shouldRequest(int i, int i2, int i3, int i4) {
        return i >= 33 && i2 >= 33 && i3 == 4 && i4 == 1;
    }
}
