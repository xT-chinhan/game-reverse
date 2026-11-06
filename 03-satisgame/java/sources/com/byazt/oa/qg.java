package com.byazt.oa;

import android.os.Handler;
import android.os.Looper;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 26})
public class qg {
    public static final Handler n = new Handler(Looper.getMainLooper());

    public static void n(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            n.post(runnable);
        }
    }

    public static void qg(Runnable runnable) {
        n.post(runnable);
    }

    public static void s(Runnable runnable) {
        rv.s().post(runnable);
    }
}
