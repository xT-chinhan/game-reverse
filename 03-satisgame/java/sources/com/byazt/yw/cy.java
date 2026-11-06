package com.byazt.yw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public final class cy {
    public static Thread n(Runnable runnable, String str) {
        com.byazt.xis.s sVar;
        if (runnable == null) {
            return null;
        }
        if (str == null) {
            sVar = new com.byazt.xis.s(runnable, "hreadExecutor");
        } else {
            sVar = new com.byazt.xis.s(runnable, str);
        }
        sVar.start();
        return sVar;
    }

    public static Thread n(Runnable runnable) {
        return n(runnable, null);
    }
}
