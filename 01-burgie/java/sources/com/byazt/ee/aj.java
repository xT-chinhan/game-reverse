package com.byazt.ee;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 61})
public final class aj {
    public static boolean pr;

    public static void pr(boolean z) {
        pr = z;
    }

    public static void pr(String str, Throwable th) {
        if (pr) {
            Log.getStackTraceString(th);
        }
    }

    public static void hw(String str, Throwable th) {
        if (pr) {
            com.byazt.ca.ho.pr("JsBridge2", str, th);
            com.byazt.ca.ho.hw("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void pr(RuntimeException runtimeException) {
        if (pr) {
            throw runtimeException;
        }
    }
}
