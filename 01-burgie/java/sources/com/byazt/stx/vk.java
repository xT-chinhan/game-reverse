package com.byazt.stx;

import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 50})
public class vk extends BaseException {
    public int pr;

    public vk(int i, String str) {
        super(1072, "applyCode=" + i + ", " + str);
        this.pr = i;
    }
}
