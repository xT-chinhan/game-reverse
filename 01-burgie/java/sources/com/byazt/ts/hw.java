package com.byazt.ts;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 13})
public class hw implements com.byazt.lj.fw {
    @Override // com.byazt.lj.fw
    public int pr(int i, com.byazt.edb.k kVar) {
        if (kVar.ordinal() <= com.byazt.edb.k.MODERATE.ordinal()) {
            return 1;
        }
        if (kVar == com.byazt.edb.k.GOOD) {
            return i - 1;
        }
        return i;
    }
}
