package com.byazt.id;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 18})
public class l extends com.byazt.bok.qg<com.byazt.hes.l, com.byazt.wea.w> {
    public final com.byazt.kmf.l qg = new com.byazt.kmf.l() { // from class: com.byazt.id.l.1
        @Override // com.byazt.kmf.l
        public void l(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        }

        @Override // com.byazt.kmf.l
        public void n(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        }

        @Override // com.byazt.kmf.l
        public void q(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        }

        @Override // com.byazt.kmf.l
        public void qg(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        }

        @Override // com.byazt.kmf.l
        public void s(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        }

        @Override // com.byazt.kmf.l
        public void w(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        }

        @Override // com.byazt.kmf.l
        public void x(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
            com.byazt.bok.n nVar;
            if (wVar == null || wVar.n() == null || (nVar = (com.byazt.bok.n) l.this.n.remove(wVar.n())) == null) {
                return;
            }
            nVar.qg(l.this.qg);
        }
    };

    public void qg(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.jax.l lVar = new com.byazt.jax.l(str, str2);
        lVar.n(this.qg);
        n(str, lVar);
    }

    public void n(String str, com.byazt.hes.l lVar, com.byazt.bok.w wVar) {
        com.byazt.bok.n<com.byazt.hes.l, com.byazt.wea.w> nVarN = n(str);
        if (nVarN instanceof com.byazt.jax.l) {
            ((com.byazt.jax.l) nVarN).n(lVar, wVar);
        }
    }

    public void n(String str, com.byazt.hes.l lVar) {
        n(str, lVar, null);
    }
}
