package com.byazt.id;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 19})
public class n extends com.byazt.bok.qg<com.byazt.hes.n, com.byazt.wea.qg> {
    public final com.byazt.kmf.n qg = new com.byazt.kmf.n() { // from class: com.byazt.id.n.1
        @Override // com.byazt.kmf.n
        public void fs(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void l(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void n(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void q(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void qg(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void rv(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void s(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void w(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void x(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.n
        public void tj(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
            com.byazt.bok.n nVar;
            if (qgVar == null || qgVar.n() == null || (nVar = (com.byazt.bok.n) n.this.n.remove(qgVar.n())) == null) {
                return;
            }
            nVar.qg(n.this.qg);
        }
    };

    public void qg(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.jax.n nVar = new com.byazt.jax.n(str, str2);
        nVar.n(this.qg);
        n(str, nVar);
    }

    public void n(String str, com.byazt.hes.n nVar, com.byazt.bok.w wVar) {
        com.byazt.bok.n<com.byazt.hes.n, com.byazt.wea.qg> nVarN = n(str);
        if (nVarN instanceof com.byazt.jax.n) {
            ((com.byazt.jax.n) nVarN).n(nVar, wVar);
        }
    }

    public void n(String str, com.byazt.hes.n nVar) {
        n(str, nVar, null);
    }
}
