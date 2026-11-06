package com.byazt.nn;

import com.byazt.vkw.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 938, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static void pr(AtomicLong atomicLong, int i, k kVar) {
        if (kVar != null && kVar.zo() && atomicLong != null) {
            atomicLong.getAndAdd(i);
        }
    }
}
