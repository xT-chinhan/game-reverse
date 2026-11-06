package com.byazt.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 26})
public class qg implements com.byazt.xv.x {
    @Override // com.byazt.xv.x
    public int n(int i, com.byazt.m.d dVar) {
        if (dVar.ordinal() <= com.byazt.m.d.MODERATE.ordinal()) {
            return 1;
        }
        return dVar == com.byazt.m.d.GOOD ? i - 1 : i;
    }
}
