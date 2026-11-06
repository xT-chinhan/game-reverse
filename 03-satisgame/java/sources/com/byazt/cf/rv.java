package com.byazt.cf;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv {
    public static boolean n;

    public static void n(boolean z) {
        n = z;
    }

    public static void n(String str, Throwable th) {
        if (n) {
            Log.getStackTraceString(th);
        }
    }

    public static void qg(String str, Throwable th) {
        if (n) {
            com.byazt.tk.k.n("JsBridge2", str, th);
            com.byazt.tk.k.qg("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void n(RuntimeException runtimeException) {
        if (n) {
            throw runtimeException;
        }
    }
}
