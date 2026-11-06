package com.byazt.aa;

import com.byazt.af.rv;
import com.byazt.tbi.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, 19})
public class n implements com.byazt.tbi.n {
    public final rv n;
    public com.byazt.tbi.q qg;
    public tj s;

    public n(rv rvVar) {
        this.n = rvVar;
    }

    @Override // com.byazt.tbi.n
    public boolean n() {
        return this.n.n();
    }

    @Override // com.byazt.tbi.n
    public com.byazt.tbi.q qg() {
        if (this.qg == null) {
            final com.byazt.zq.s sVarQg = this.n.qg();
            if (sVarQg == null) {
                return null;
            }
            this.qg = new com.byazt.tbi.q() { // from class: com.byazt.aa.n.1
                @Override // com.byazt.tbi.q
                public double n() {
                    return sVarQg.n();
                }

                @Override // com.byazt.tbi.q
                public double qg() {
                    return sVarQg.qg();
                }
            };
        }
        return this.qg;
    }

    @Override // com.byazt.tbi.n
    public boolean s() {
        return this.n.s();
    }

    @Override // com.byazt.tbi.n
    public boolean q() {
        return this.n.q();
    }

    @Override // com.byazt.tbi.n
    public String l() {
        return this.n.l();
    }

    @Override // com.byazt.tbi.n
    public boolean w() {
        return this.n.w();
    }

    @Override // com.byazt.tbi.n
    public String x() {
        return this.n.x();
    }

    @Override // com.byazt.tbi.n
    public boolean fs() {
        return this.n.fs();
    }

    @Override // com.byazt.tbi.n
    public String rv() {
        return this.n.rv();
    }

    @Override // com.byazt.tbi.n
    public boolean tj() {
        return this.n.tj();
    }

    @Override // com.byazt.tbi.n
    public tj cp() {
        if (this.s == null) {
            com.byazt.xmw.qg qgVarCy = this.n.cy();
            if (qgVarCy == null) {
                return null;
            }
            this.s = new q(qgVarCy);
        }
        return this.s;
    }

    @Override // com.byazt.tbi.n
    public String d() {
        return this.n.cp();
    }

    @Override // com.byazt.tbi.n
    public boolean oa() {
        return this.n.sz();
    }

    @Override // com.byazt.tbi.n
    public Map<String, Object> sz() {
        return this.n.d();
    }

    @Override // com.byazt.tbi.n
    public boolean k() {
        return this.n.oa();
    }

    @Override // com.byazt.tbi.n
    public boolean n(int i) {
        return rv.n(this.n, i);
    }
}
