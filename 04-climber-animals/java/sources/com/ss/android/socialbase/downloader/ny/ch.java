package com.ss.android.socialbase.downloader.ny;

import android.content.Context;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ch {
    public static boolean ms(Context context, String str, String str2) {
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        return false;
    }
}
