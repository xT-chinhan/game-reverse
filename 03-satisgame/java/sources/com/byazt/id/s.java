package com.byazt.id;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 8})
public class s extends com.byazt.bok.qg<com.byazt.hes.s, com.byazt.wea.q> {
    public final com.byazt.kmf.s qg = new com.byazt.kmf.s() { // from class: com.byazt.id.s.1
        @Override // com.byazt.kmf.s
        public void l(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.s
        public void n(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.s
        public void q(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.s
        public void qg(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.s
        public void s(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.s
        public void w(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.s
        public void x(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
            com.byazt.bok.n nVar;
            if (qVar == null || qVar.n() == null || (nVar = (com.byazt.bok.n) s.this.n.remove(qVar.n())) == null) {
                return;
            }
            nVar.qg(s.this.qg);
        }
    };

    public void qg(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.jax.s sVar = new com.byazt.jax.s(str, str2);
        sVar.n(this.qg);
        n(str, sVar);
    }

    public void n(String str, com.byazt.hes.s sVar, com.byazt.bok.w wVar) {
        com.byazt.bok.n<com.byazt.hes.s, com.byazt.wea.q> nVarN = n(str);
        if (nVarN instanceof com.byazt.jax.s) {
            ((com.byazt.jax.s) nVarN).n(sVar, wVar);
        }
    }

    public void n(String str, com.byazt.hes.s sVar) {
        n(str, sVar, null);
    }
}
