package com.byazt.oz;

import com.byazt.hg.jw;
import com.byazt.ld.nt;
import com.byazt.ld.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 37})
public class pr extends com.byazt.bd.pr {
    public jw pr;

    private void pr(nt ntVar) {
        zo zoVarVk = ntVar.vk();
        if (zoVarVk != null && x()) {
            pr(zoVarVk.pr(), zoVarVk.hw());
        }
    }

    private boolean x() {
        jw jwVar = this.pr;
        return jwVar != null && jwVar.ny();
    }

    private void pr(long j, long j2) {
        this.pr.g(j2);
        jw jwVar = this.pr;
        jwVar.aj(j2 - jwVar.cz());
        this.pr.qa(j2 - j);
    }

    private void c() {
        if (x()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            jw jwVar = this.pr;
            jwVar.zo(jCurrentTimeMillis - jwVar.qa());
            this.pr.m(jCurrentTimeMillis);
        }
    }

    public jw hn() {
        return this.pr;
    }

    public void pr(jw jwVar) {
        this.pr = jwVar;
    }

    @Override // com.byazt.bd.pr
    public void pr(nt ntVar, com.byazt.bd.pr.hw hwVar) {
        pr(ntVar);
        super.pr(ntVar, hwVar);
    }

    @Override // com.byazt.bd.pr
    public void pr() {
        c();
    }
}
