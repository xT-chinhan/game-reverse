package com.byazt.id;

import com.byazt.wea.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 21})
public class x extends com.byazt.bok.qg<com.byazt.hes.x, rv> {
    public final com.byazt.kmf.x qg = new com.byazt.kmf.x() { // from class: com.byazt.id.x.1
        @Override // com.byazt.kmf.x
        public void l(rv rvVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.x
        public void n(rv rvVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.x
        public void q(rv rvVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.x
        public void qg(rv rvVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.x
        public void s(rv rvVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.x
        public void w(rv rvVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.x
        public void x(rv rvVar, com.byazt.bok.w wVar) {
        }

        @Override // com.byazt.kmf.x
        public void fs(rv rvVar, com.byazt.bok.w wVar) {
            com.byazt.bok.n nVar;
            if (rvVar == null || rvVar.n() == null || (nVar = (com.byazt.bok.n) x.this.n.remove(rvVar.n())) == null) {
                return;
            }
            nVar.qg(x.this.qg);
        }
    };

    public void qg(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.jax.x xVar = new com.byazt.jax.x(str, str2);
        xVar.n(this.qg);
        n(str, xVar);
    }

    public void n(String str, com.byazt.hes.x xVar, com.byazt.bok.w wVar) {
        com.byazt.bok.n<com.byazt.hes.x, rv> nVarN = n(str);
        if (nVarN instanceof com.byazt.jax.x) {
            ((com.byazt.jax.x) nVarN).n(xVar, wVar);
        }
    }

    public void n(String str, com.byazt.hes.x xVar) {
        n(str, xVar, null);
    }
}
