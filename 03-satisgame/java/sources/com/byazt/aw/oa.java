package com.byazt.aw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements s {
    public final String n;
    public final com.byazt.ccr.oa<Float, Float> qg;

    public oa(String str, com.byazt.ccr.oa<Float, Float> oaVar) {
        this.n = str;
        this.qg = oaVar;
    }

    public String n() {
        return this.n;
    }

    public com.byazt.ccr.oa<Float, Float> qg() {
        return this.qg;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.hd(fsVar, sVar, this);
    }
}
