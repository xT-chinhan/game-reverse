package com.byazt.ts;

import com.byazt.lj.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 50})
public class vk implements qa {
    @Override // com.byazt.lj.qa
    public long pr(int i, int i2) {
        if (i == 1) {
            return 3000L;
        }
        if (i == 2) {
            return IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS;
        }
        if (i == 3) {
            return 30000L;
        }
        if (i > 3) {
            return 300000L;
        }
        return 0L;
    }
}
