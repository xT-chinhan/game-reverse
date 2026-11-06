package com.byazt.yb;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 101})
public final class fs {
    public static boolean n(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean n(Context context) {
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

    public static void n(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.byazt.xis.s(new n(runnable, str), str).start();
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    private static class n implements Runnable {
        public final Runnable n;
        public final String qg;
        public final String s = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        public n(Runnable runnable, String str) {
            this.n = runnable;
            this.qg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.n.run();
            } catch (Exception e) {
                com.byazt.km.cp.s("Thread:" + this.qg + " exception\n" + this.s, e);
            }
        }
    }
}
