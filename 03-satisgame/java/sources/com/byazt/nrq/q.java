package com.byazt.nrq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 5})
public class q extends Exception {
    public boolean n;
    public boolean qg;
    public long s;

    public q(boolean z) {
        this.n = z;
    }

    public q(boolean z, boolean z2, long j) {
        this.n = z;
        this.qg = z2;
        this.s = j;
    }

    public q(boolean z, long j) {
        this.n = z;
        this.s = j;
    }
}
