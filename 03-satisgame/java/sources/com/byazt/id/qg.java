package com.byazt.id;

import com.byazt.nf.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 26})
public class qg extends com.byazt.bok.qg<com.byazt.hes.qg, com.byazt.wea.s> {
    public final com.byazt.kmf.qg qg = new com.byazt.kmf.qg() { // from class: com.byazt.id.qg.1
        @Override // com.byazt.kmf.qg
        public void n(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.qg
        public void qg(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.qg
        public void s(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.qg
        public void q(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
            com.byazt.bok.n nVar;
            if (sVar == null || sVar.n() == null || (nVar = (com.byazt.bok.n) qg.this.n.remove(sVar.n())) == null) {
                return;
            }
            nVar.qg(qg.this.qg);
        }
    };

    public void qg(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.jax.qg qgVar = new com.byazt.jax.qg(str, str2);
        qgVar.n(this.qg);
        n(str, qgVar);
    }

    public void n() {
        long jAh = rv.qg().ah();
        if (jAh <= 0) {
            return;
        }
        for (String str : this.n.keySet()) {
            com.byazt.bok.n nVar = (com.byazt.bok.n) this.n.get(str);
            if ((nVar instanceof com.byazt.jax.qg) && ((com.byazt.jax.qg) nVar).n(jAh)) {
                this.n.remove(str);
                nVar.qg(this.qg);
            }
        }
    }

    public void n(String str, com.byazt.hes.qg qgVar, com.byazt.bok.w wVar) {
        com.byazt.bok.n<com.byazt.hes.qg, com.byazt.wea.s> nVarN = n(str);
        if (nVarN instanceof com.byazt.jax.qg) {
            ((com.byazt.jax.qg) nVarN).n(qgVar, wVar);
        }
    }

    public void n(String str, com.byazt.hes.qg qgVar) {
        n(str, qgVar, null);
    }
}
