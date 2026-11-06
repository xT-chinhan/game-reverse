package com.byazt.stx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements c {
    public final c hw;
    public final c pr;

    public zo(c cVar, c cVar2) {
        this.pr = cVar;
        this.hw = cVar2;
    }

    @Override // com.byazt.stx.c
    public void hw(pr prVar) throws IOException {
        prVar.hw = this.hw;
        this.pr.hw(prVar);
    }
}
