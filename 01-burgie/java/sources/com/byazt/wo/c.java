package com.byazt.wo;

import com.byazt.ae.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static uc pr;

    public static void pr(uc ucVar) {
        pr = ucVar;
    }

    public static void pr(Runnable runnable, boolean z) {
        if (z) {
            pr(runnable);
        } else {
            hw(runnable);
        }
    }

    public static void pr(Runnable runnable) {
        pr.pr(runnable);
    }

    public static void hw(Runnable runnable) {
        pr.hw(runnable);
    }

    public static void hn(Runnable runnable) {
        pr.hn(runnable);
    }
}
