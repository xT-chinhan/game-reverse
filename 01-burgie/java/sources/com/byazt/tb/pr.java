package com.byazt.tb;

import com.byazt.sd.cz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 37})
public class pr implements com.byazt.mc.pr {
    public com.byazt.pv.pr pr;
    public boolean hw = false;
    public boolean hn = false;

    private void pr(com.byazt.pv.pr prVar) {
        if (this.pr == null) {
            this.pr = prVar;
        }
    }

    @Override // com.byazt.mc.pr
    public void pr(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
    }

    @Override // com.byazt.mc.pr
    public void hw(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        pr(prVar);
        this.hn = true;
    }

    @Override // com.byazt.mc.pr
    public void hn(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        pr(prVar);
        this.hn = true;
    }

    @Override // com.byazt.mc.pr
    public void x(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        pr(prVar);
        this.hn = true;
    }

    @Override // com.byazt.mc.pr
    public void c(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        pr(prVar);
        this.hn = true;
    }

    @Override // com.byazt.mc.pr
    public void uc(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        pr(prVar);
        this.hn = true;
    }

    @Override // com.byazt.mc.pr
    public void fw(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        com.byazt.rkl.hw hwVar;
        pr(prVar);
        this.hn = true;
        if (prVar.ho != null && prVar.ho.gb() == 1 && (hwVar = (com.byazt.rkl.hw) cz.pr(prVar.ho.cz(), com.byazt.rkl.hw.class)) != null) {
            hwVar.pr(6, null);
        }
    }

    @Override // com.byazt.mc.pr
    public void zo(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        pr(prVar);
        this.hn = true;
    }

    @Override // com.byazt.mc.pr
    public void aj(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        pr(prVar);
        this.hn = true;
        if (!this.hw && prVar.ho != null && prVar.ho.i() && !prVar.ho.r() && prVar.ho.ob() && prVar.ho.gb() == 1) {
            this.hw = true;
            prVar.ho.c(true);
            com.byazt.rkl.hw hwVar = (com.byazt.rkl.hw) cz.pr(prVar.ho.cz(), com.byazt.rkl.hw.class);
            if (hwVar != null) {
                com.byazt.pj.pr.pr(prVar.ho, 1);
                hwVar.pr(5, null);
            }
        }
    }

    @Override // com.byazt.mc.pr
    public void vk(com.byazt.pv.pr prVar, com.byazt.ewt.zo zoVar) {
        if (!this.hw && zoVar != null && zoVar.pr("source") != null && this.hn && prVar.ho != null && prVar.ho.i() && !prVar.ho.r() && prVar.ho.ob() && zoVar.pr("source").equals(1)) {
            this.hw = true;
            com.byazt.rkl.hw hwVar = (com.byazt.rkl.hw) cz.pr(prVar.ho.cz(), com.byazt.rkl.hw.class);
            if (hwVar != null) {
                prVar.ho.c(true);
                com.byazt.pj.pr.pr(prVar.ho, 2);
                hwVar.pr(5, null);
            }
        }
    }
}
