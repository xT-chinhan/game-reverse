package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
final class kl {
    static boolean ms(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean ms(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null && packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    static void ms(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.bytedance.sdk.component.ch.d.ah(new ms(runnable, str), str).start();
    }

    static class ms implements Runnable {
        private final String ah = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final Runnable f501ms;
        private final String xr;

        ms(Runnable runnable, String str) {
            this.f501ms = runnable;
            this.xr = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f501ms.run();
            } catch (Exception e) {
                oh.ah("Thread:" + this.xr + " exception\n" + this.ah, e);
            }
        }
    }
}
