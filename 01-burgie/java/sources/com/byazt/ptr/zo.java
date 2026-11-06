package com.byazt.ptr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 950, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public int hw;
    public float pr;

    public void pr(float f) {
        float f2 = this.pr + f;
        this.pr = f2;
        int i = this.hw + 1;
        this.hw = i;
        if (i == Integer.MAX_VALUE) {
            this.pr = f2 / 2.0f;
            this.hw = i / 2;
        }
    }
}
