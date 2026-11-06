package com.bytedance.ms.xr.x;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static File ms(Context context) {
        return new File(ah(context), "CrashLogJava");
    }

    public static File xr(Context context) {
        return new File(ah(context), "crash_history");
    }

    public static String ms() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String xr() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    private static String ah(Context context) {
        String path;
        try {
            if (com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context) != null) {
                path = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context).getPath();
            } else {
                File fileMs = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                path = fileMs != null ? fileMs.getPath() : null;
            }
            return path != null ? path : "/sdcard/";
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return "/sdcard/";
        }
    }
}
