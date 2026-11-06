package com.byazt.id;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 13})
public class w extends com.byazt.bok.qg<com.byazt.hes.w, com.byazt.wea.x> {
    public final com.byazt.kmf.w qg = new com.byazt.kmf.w() { // from class: com.byazt.id.w.1
        @Override // com.byazt.kmf.w
        public void n(com.byazt.wea.x xVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.w
        public void qg(com.byazt.wea.x xVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.w
        public void s(com.byazt.wea.x xVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.w
        public void q(com.byazt.wea.x xVar, com.byazt.bok.w wVar) {
            com.byazt.bok.n nVar;
            if (xVar == null || xVar.n() == null || (nVar = (com.byazt.bok.n) w.this.n.remove(xVar.n())) == null) {
                return;
            }
            nVar.qg(w.this.qg);
        }
    };

    public void qg(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.jax.w wVar = new com.byazt.jax.w(str, str2);
        wVar.n(this.qg);
        n(str, wVar);
    }

    public void n(String str, com.byazt.hes.w wVar, com.byazt.bok.w wVar2) {
        com.byazt.bok.n<com.byazt.hes.w, com.byazt.wea.x> nVarN = n(str);
        if (nVarN instanceof com.byazt.jax.w) {
            ((com.byazt.jax.w) nVarN).n(wVar, wVar2);
        }
    }

    public void n(String str, com.byazt.hes.w wVar) {
        n(str, wVar, null);
    }
}
