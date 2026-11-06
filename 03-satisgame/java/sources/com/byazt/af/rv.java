package com.byazt.af;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends q {
    public boolean n;

    public rv(com.byazt.zq.q qVar, boolean z) {
        super(qVar);
        this.n = z;
    }

    private boolean qg(int i) {
        return com.byazt.nf.rv.qg().tj(i) && s(i);
    }

    private boolean s(int i) {
        if (i != 0 && i != 1) {
            if (i == 2) {
                return super.w();
            }
            if (i != 3) {
                return false;
            }
        }
        return super.q();
    }

    public boolean n(int i) {
        return qg(i);
    }

    public static boolean n(rv rvVar, int i) {
        if (rvVar == null) {
            return true;
        }
        return rvVar.n(i);
    }

    @Override // com.byazt.af.q, com.byazt.zq.q
    public boolean w() {
        if (this.n) {
            return false;
        }
        return super.w();
    }

    @Override // com.byazt.af.q, com.byazt.zq.q
    public boolean q() {
        if (this.n) {
            return false;
        }
        return super.q();
    }
}
