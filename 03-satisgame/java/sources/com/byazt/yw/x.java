package com.byazt.yw;

import android.app.ActivityManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 21})
public class x {
    public static final n n = new qg();

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private static class n {
        public long n(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }

        private n() {
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 1181})
    private static class qg extends n {
        private qg() {
            super();
        }

        @Override // com.byazt.yw.x.n
        public long n(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long n(ActivityManager.MemoryInfo memoryInfo) {
        return n.n(memoryInfo);
    }
}
