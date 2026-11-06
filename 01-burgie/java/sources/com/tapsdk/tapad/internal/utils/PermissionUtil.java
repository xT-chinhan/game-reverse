package com.tapsdk.tapad.internal.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge;
import com.tapsdk.tapad.internal.telephony.TelephonyAccessUtils;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionUtil {
    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        boolean z = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        if (Build.VERSION.SDK_INT >= 23) {
            HashMap map = new HashMap();
            map.put("permission", str);
            map.put("result", Boolean.valueOf(z));
            CoreMediationTelemetryBridge.reportFact(77, map);
        }
        return z;
    }

    public static boolean hasReadPhoneStatePermission(Context context) {
        if (context == null) {
            return false;
        }
        return TelephonyAccessUtils.hasPhoneStatePermission(context);
    }

    public static void requestPermissions(Activity activity, List<String> list) {
        if (activity == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        activity.requestPermissions((String[]) list.toArray(new String[0]), 10001);
    }
}
