package com.byazt.js;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static void pr(com.byazt.xlm.fw fwVar, int i) {
        if (fwVar == null) {
            return;
        }
        com.byazt.bg.hn hnVarHn = com.byazt.bg.pr.pr().hn();
        ExecutorService executorServiceK = null;
        if (hnVarHn != null) {
            executorServiceK = hnVarHn.k();
        }
        if (executorServiceK != null) {
            fwVar.pr(i);
            executorServiceK.execute(fwVar);
        } else {
            com.byazt.xlm.c.pr(fwVar, i);
        }
    }

    public static void hw(com.byazt.xlm.fw fwVar, int i) {
        if (fwVar == null) {
            return;
        }
        com.byazt.bg.hn hnVarHn = com.byazt.bg.pr.pr().hn();
        ExecutorService executorServiceW = null;
        if (hnVarHn != null) {
            executorServiceW = hnVarHn.w();
        }
        if (executorServiceW != null) {
            fwVar.pr(i);
            executorServiceW.execute(fwVar);
        } else {
            com.byazt.xlm.c.pr(fwVar);
        }
    }

    public static ScheduledFuture pr(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.byazt.xlm.c.x().schedule(runnable, j, timeUnit);
    }
}
