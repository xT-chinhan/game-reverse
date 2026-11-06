package com.byazt.qx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 48})
public class lb {
    public int c;
    public float hn;
    public int hw = -1;
    public int pr;
    public int x;

    public lb(int i, float f, int i2, int i3) {
        this.pr = 1;
        this.hn = 1.0f;
        this.x = 600;
        this.c = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
        this.pr = i;
        this.hn = f;
        this.x = i2;
        this.c = i3;
    }
}
