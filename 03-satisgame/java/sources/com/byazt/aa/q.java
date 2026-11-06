package com.byazt.aa;

import com.byazt.tbi.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, 5})
public class q implements tj {
    public final com.byazt.xmw.qg n;

    public q(com.byazt.xmw.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.tbi.tj
    public List<String> n() {
        return this.n.n();
    }

    @Override // com.byazt.tbi.tj
    public List<String> qg() {
        return this.n.qg();
    }

    @Override // com.byazt.tbi.tj
    public boolean s() {
        return this.n.s();
    }

    @Override // com.byazt.tbi.tj
    public boolean q() {
        return this.n.q();
    }

    @Override // com.byazt.tbi.tj
    public boolean l() {
        return this.n.l();
    }
}
