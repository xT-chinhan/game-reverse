package com.byazt.gr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static long n(float f, float f2) {
        return ((long) Float.floatToRawIntBits(f2)) | (((long) Float.floatToRawIntBits(f)) << 32);
    }

    public static long n(int i, int i2) {
        return n(i, i2);
    }
}
