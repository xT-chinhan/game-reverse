package com.byazt.yw;

import android.os.Debug;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 26})
public class qg {
    public static final n n = new C0407qg();

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 48})
    private static class n {
        public int n(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int qg(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int s(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        private n() {
        }
    }

    /* JADX INFO: renamed from: com.byazt.yw.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 201})
    private static class C0407qg extends n {
        private C0407qg() {
            super();
        }

        @Override // com.byazt.yw.qg.n
        public int n(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.byazt.yw.qg.n
        public int qg(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.byazt.yw.qg.n
        public int s(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int n(Debug.MemoryInfo memoryInfo) {
        return n.n(memoryInfo);
    }

    public static int qg(Debug.MemoryInfo memoryInfo) {
        return n.qg(memoryInfo);
    }

    public static int s(Debug.MemoryInfo memoryInfo) {
        return n.s(memoryInfo);
    }
}
