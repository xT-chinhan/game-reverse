package com.byazt.rij;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 13})
public class hw {
    public static int pr(boolean z, int i, int i2) {
        if (i2 != 0 && z) {
            int i3 = i - 512;
            int iAbs = Math.abs(i3) % i2;
            if (i3 >= 0 || iAbs == 0) {
                return iAbs;
            }
            return i2 - iAbs;
        }
        return i;
    }

    public static boolean pr(int i, Collection<?> collection) {
        return i >= 0 && i < collection.size();
    }
}
