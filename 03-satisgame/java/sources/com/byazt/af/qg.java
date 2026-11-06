package com.byazt.af;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 26})
public class qg {
    public Boolean n = null;
    public Boolean qg = null;
    public Boolean s = null;

    public boolean n() {
        if (this.qg == null) {
            rv rvVarHd = com.byazt.vyf.s.cy().hd();
            this.qg = Boolean.valueOf(rvVarHd == null || rvVarHd.w());
        }
        return this.qg.booleanValue();
    }

    public boolean qg() {
        if (this.s == null) {
            rv rvVarHd = com.byazt.vyf.s.cy().hd();
            this.s = Boolean.valueOf(rvVarHd == null || rvVarHd.n());
        }
        return this.s.booleanValue();
    }

    public boolean n(int i) {
        rv rvVarHd = com.byazt.vyf.s.cy().hd();
        return rvVarHd == null || rv.n(rvVarHd, i);
    }
}
