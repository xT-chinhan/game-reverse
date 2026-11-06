package com.byazt.id;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 5})
public class q extends com.byazt.bok.qg<com.byazt.hes.q, com.byazt.wea.l> {
    public final com.byazt.kmf.q qg = new com.byazt.kmf.q() { // from class: com.byazt.id.q.1
        @Override // com.byazt.kmf.q
        public void fs(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void l(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void n(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void q(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void qg(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void rv(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void s(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void w(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void x(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.q
        public void tj(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
            com.byazt.bok.n nVar;
            if (lVar == null || lVar.n() == null || (nVar = (com.byazt.bok.n) q.this.n.remove(lVar.n())) == null) {
                return;
            }
            nVar.qg(q.this.qg);
        }
    };

    public void qg(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.jax.q qVar = new com.byazt.jax.q(str, str2);
        qVar.n(this.qg);
        n(str, qVar);
    }

    public void n(String str, com.byazt.hes.q qVar, com.byazt.bok.w wVar) {
        com.byazt.bok.n<com.byazt.hes.q, com.byazt.wea.l> nVarN = n(str);
        if (nVarN instanceof com.byazt.jax.q) {
            ((com.byazt.jax.q) nVarN).n(qVar, wVar);
        }
    }

    public void n(String str, com.byazt.hes.q qVar) {
        n(str, qVar, null);
    }
}
