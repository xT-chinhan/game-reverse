package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2234})
public class fl {
    public int n;
    public int qg;
    public int s;
    public int q = 1;
    public int l = 0;

    public int n() {
        return this.n;
    }

    public void n(int i) {
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            this.n = 2;
        } else {
            this.n = i;
        }
    }

    public int qg() {
        return this.qg;
    }

    public void qg(int i) {
        if (i <= 0 || i >= x()) {
            this.qg = 16;
        } else {
            this.qg = i;
        }
    }

    public int s() {
        return this.s;
    }

    public void s(int i) {
        if (i <= 0 || i >= w()) {
            int i2 = this.n;
            if (i2 == 3 || i2 == 4) {
                this.s = 30;
                return;
            } else {
                this.s = 16;
                return;
            }
        }
        this.s = i;
    }

    private int w() {
        return com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), com.byazt.okk.s.w(com.byazt.nf.rv.getContext()));
    }

    private int x() {
        return com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), com.byazt.okk.s.l(com.byazt.nf.rv.getContext()));
    }

    public int q() {
        return this.q == 2 ? 2 : 1;
    }

    public void q(int i) {
        this.q = i;
    }

    public int l() {
        return this.l;
    }

    public void l(int i) {
        this.l = i;
    }

    public static boolean n(pk pkVar) {
        return (pkVar == null || pkVar.ba() == null || pkVar.ba().l() != 1) ? false : true;
    }
}
