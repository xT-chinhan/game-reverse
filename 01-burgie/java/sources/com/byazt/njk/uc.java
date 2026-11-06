package com.byazt.njk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 5})
public final class uc {
    public int[] aj;
    public float[] c;
    public float[] fw;
    public float[] hn;
    public int hw;
    public int pr;
    public float[] uc;
    public float[] x;
    public int[] zo;

    public void pr(int i) {
        float[] fArr = this.hn;
        if (fArr == null || fArr.length < i) {
            this.hn = new float[i];
            this.x = new float[i];
            this.c = new float[i];
            this.uc = new float[i];
            this.fw = new float[i];
            this.zo = new int[i];
            this.aj = new int[i];
        }
    }
}
