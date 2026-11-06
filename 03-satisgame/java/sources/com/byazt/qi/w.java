package com.byazt.qi;

import com.byazt.iip.l$$ExternalSyntheticBackport0;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 13})
public class w {
    public static final AtomicReference<Long> n = new AtomicReference<>(0L);

    public static void n(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = n;
            long jLongValue = atomicReference.get().longValue();
            if (l$$ExternalSyntheticBackport0.m(atomicReference, Long.valueOf(jLongValue), Long.valueOf(jLongValue | j))) {
                return;
            } else {
                i = i2;
            }
        }
    }
}
