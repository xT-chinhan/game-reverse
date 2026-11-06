package com.byazt.jm;

import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static boolean pr() {
        return (com.byazt.mp.c.pr().k() & 8) == 8;
    }

    public static void pr(Runnable runnable) {
        if (pr()) {
            if (Looper.myLooper() == com.byazt.ca.aj.hn().getLooper()) {
                runnable.run();
                return;
            } else {
                com.byazt.ca.aj.hn().post(runnable);
                return;
            }
        }
        com.byazt.zp.zo.pr(runnable);
    }

    public static void hw(Runnable runnable) {
        if (pr() && Looper.myLooper() != com.byazt.ca.aj.hn().getLooper()) {
            com.byazt.ca.aj.hn().post(runnable);
        } else {
            runnable.run();
        }
    }
}
