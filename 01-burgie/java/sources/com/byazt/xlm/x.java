package com.byazt.xlm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 121})
public final class x {
    private static void pr(Throwable th) {
        String.valueOf(th.getMessage());
    }

    public static int pr() {
        ThreadGroup threadGroupHw = hw();
        if (threadGroupHw == null) {
            return 0;
        }
        int iActiveCount = threadGroupHw.activeCount();
        try {
            return threadGroupHw.enumerate(new Thread[(iActiveCount / 2) + iActiveCount]);
        } catch (Throwable th) {
            return iActiveCount;
        }
    }

    public static ThreadGroup hw() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e) {
            pr(e);
            return null;
        }
    }
}
