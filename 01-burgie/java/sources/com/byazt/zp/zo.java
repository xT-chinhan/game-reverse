package com.byazt.zp;

import android.os.Looper;
import com.byazt.sd.a;
import com.byazt.sd.lb;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static boolean pr() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void pr(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            lb.uc().post(runnable);
        }
    }

    public static void pr(Runnable runnable, long j) {
        lb.uc().postDelayed(runnable, j);
    }

    public static void pr(com.byazt.xlm.fw fwVar) {
        ((qi) com.byazt.zs.uc.pr("thread_service")).pr(fwVar);
    }

    public static void hw(Runnable runnable) {
        ((qi) com.byazt.zs.uc.pr("thread_service")).hw(runnable);
    }

    public static void hn(Runnable runnable) {
        if (a.hw().zs() || Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            lb.uc().post(runnable);
        }
    }

    public static void x(Runnable runnable) {
        if (a.hw().jb()) {
            ((qi) com.byazt.zs.uc.pr("thread_service")).c().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void pr(final Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        if (pr()) {
            if (scheduledExecutorService != null) {
                scheduledExecutorService.execute(runnable);
                return;
            } else {
                ((qi) com.byazt.zs.uc.pr("thread_service")).pr(new Runnable() { // from class: com.byazt.zp.zo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                });
                return;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void c(Runnable runnable) {
        pr(runnable, (ScheduledExecutorService) null);
    }

    public static Looper hw() {
        if (a.hw().jb()) {
            return ((qi) com.byazt.zs.uc.pr("thread_service")).c().getLooper();
        }
        return Looper.getMainLooper();
    }
}
