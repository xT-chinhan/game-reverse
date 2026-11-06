package com.byazt.xev;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public static boolean pr(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean pr(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null && packageManager.getPackageInfo("com.huawei.hms", 0) == null) ? false : true;
        } catch (PackageManager.NameNotFoundException | Exception e) {
            return false;
        }
    }

    public static void pr(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.byazt.fr.hn(new pr(runnable, str), str).start();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 75, 673})
    private static class pr implements Runnable {
        public final String hn = Log.getStackTraceString(new RuntimeException("origin stacktrace"));
        public final String hw;
        public final Runnable pr;

        public pr(Runnable runnable, String str) {
            this.pr = runnable;
            this.hw = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.pr.run();
            } catch (Exception e) {
                com.byazt.ec.w.hn("Thread:" + this.hw + " exception\n" + this.hn, e);
            }
        }
    }
}
