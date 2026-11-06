package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1744})
public class he {
    public int n;
    public int qg;
    public int s;

    public int n() {
        return this.n;
    }

    public void n(int i) {
        if (i != 1 && i != 2) {
            i = 0;
        }
        this.n = i;
    }

    public int qg() {
        return this.qg;
    }

    public void qg(int i) {
        if (i <= 0 || i >= q()) {
            int i2 = this.n;
            if (i2 == 1) {
                this.qg = 90;
                return;
            } else {
                if (i2 == 2) {
                    this.qg = 150;
                    return;
                }
                return;
            }
        }
        this.qg = i;
    }

    public int s() {
        return this.s;
    }

    public void s(int i) {
        if (i <= 0 || i >= q()) {
            int i2 = this.n;
            if (i2 == 1) {
                this.s = 90;
                return;
            } else {
                if (i2 == 2) {
                    this.s = 150;
                    return;
                }
                return;
            }
        }
        this.s = i;
    }

    private int q() {
        return com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), com.byazt.okk.s.w(com.byazt.nf.rv.getContext()));
    }
}
