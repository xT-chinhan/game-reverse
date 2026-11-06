package com.byazt.qit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 5})
public final class q {
    private static void n(Throwable th) {
        String.valueOf(th.getMessage());
    }

    public static int n() {
        ThreadGroup threadGroupQg = qg();
        if (threadGroupQg == null) {
            return 0;
        }
        int iActiveCount = threadGroupQg.activeCount();
        try {
            return threadGroupQg.enumerate(new Thread[(iActiveCount / 2) + iActiveCount]);
        } catch (Throwable unused) {
            return iActiveCount;
        }
    }

    public static ThreadGroup qg() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e) {
            n(e);
            return null;
        }
    }
}
