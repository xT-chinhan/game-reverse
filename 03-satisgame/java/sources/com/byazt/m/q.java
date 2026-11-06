package com.byazt.m;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, 5})
public class q {
    public final double n;
    public int q;
    public final int qg;
    public double s = -1.0d;

    public q(double d) {
        this.n = d;
        this.qg = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void n(double d) {
        double d2 = 1.0d - this.n;
        int i = this.q;
        if (i > this.qg) {
            this.s = Math.exp((d2 * Math.log(this.s)) + (this.n * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.s = Math.exp((d3 * Math.log(this.s)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.s = d;
        }
        this.q++;
    }

    public double n() {
        return this.s;
    }
}
