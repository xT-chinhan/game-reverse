package com.byazt.xdz;

import com.byazt.vf.cp;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, 8})
public class s implements com.byazt.zad.qg<com.byazt.vr.n> {
    public com.byazt.vr.qg n;
    public cp q;
    public com.byazt.vf.n qg;
    public oa s = (oa) com.byazt.qp.q.n("device_info_new");

    public s(com.byazt.vf.n nVar, com.byazt.vr.qg qgVar) {
        this.qg = nVar;
        this.n = qgVar;
        this.q = (cp) com.byazt.qp.q.n("csj_settings", nVar);
    }

    @Override // com.byazt.zad.qg
    public com.byazt.zad.n n(List<com.byazt.vr.n> list, com.byazt.vr.l lVar) {
        return new qg(this.qg, this.n, this.q, this.s, lVar).n(list);
    }

    @Override // com.byazt.zad.qg
    public com.byazt.zad.n qg(List<com.byazt.vr.n> list, com.byazt.vr.l lVar) {
        return new l(this.qg, this.n, this.q, this.s, lVar).n(list);
    }

    @Override // com.byazt.zad.qg
    public com.byazt.zad.n s(List<com.byazt.vr.n> list, com.byazt.vr.l lVar) {
        return new q(this.qg, this.n, this.q, this.s, lVar).n(list);
    }

    @Override // com.byazt.zad.qg
    public List<qg.n> q(List<com.byazt.vr.n> list, com.byazt.vr.l lVar) {
        return new qg(this.qg, this.n, this.q, this.s, lVar).qg(list);
    }
}
