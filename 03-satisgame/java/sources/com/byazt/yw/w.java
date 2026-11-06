package com.byazt.yw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 13})
public final class w {
    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
