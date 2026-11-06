package com.byazt.wf;

import android.os.Build;
import android.os.Debug;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 13})
public class hw {
    public static final pr pr;

    @com.byazt.vzx.pr(pr = {0, 1, 201, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        private pr() {
        }

        public int pr(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int hw(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int hn(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: com.byazt.wf.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 201, 497})
    private static class C0224hw extends pr {
        private C0224hw() {
            super();
        }

        @Override // com.byazt.wf.hw.pr
        public int pr(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.byazt.wf.hw.pr
        public int hw(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.byazt.wf.hw.pr
        public int hn(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            pr = new C0224hw();
        } else {
            pr = new pr();
        }
    }

    public static int pr(Debug.MemoryInfo memoryInfo) {
        return pr.pr(memoryInfo);
    }

    public static int hw(Debug.MemoryInfo memoryInfo) {
        return pr.hw(memoryInfo);
    }

    public static int hn(Debug.MemoryInfo memoryInfo) {
        return pr.hn(memoryInfo);
    }
}
