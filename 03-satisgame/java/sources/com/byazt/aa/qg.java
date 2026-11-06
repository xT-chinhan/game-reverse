package com.byazt.aa;

import com.byazt.tbi.w;
import com.byazt.tbi.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, 26})
public class qg implements w {
    public final com.byazt.xmw.n n;
    public x qg;

    public qg(com.byazt.xmw.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.tbi.w
    public String n() {
        return this.n.n();
    }

    @Override // com.byazt.tbi.w
    public boolean qg() {
        return this.n.qg();
    }

    @Override // com.byazt.tbi.w
    public x s() {
        if (this.qg == null) {
            com.byazt.xmw.s sVarS = this.n.s();
            if (sVarS == null) {
                return null;
            }
            this.qg = new s(sVarS);
        }
        return this.qg;
    }

    @Override // com.byazt.tbi.w
    public Map<String, Object> q() {
        return this.n.q();
    }

    @Override // com.byazt.tbi.w
    public boolean l() {
        return this.n.l();
    }

    @Override // com.byazt.tbi.w
    public JSONObject w() {
        return this.n.w();
    }

    @Override // com.byazt.tbi.w
    public String x() {
        return this.n.x();
    }

    @Override // com.byazt.tbi.w
    public boolean fs() {
        return this.n.fs();
    }

    @Override // com.byazt.tbi.w
    public boolean rv() {
        return this.n.rv();
    }

    @Override // com.byazt.tbi.w
    public boolean tj() {
        return this.n.tj();
    }

    @Override // com.byazt.tbi.w
    public String cp() {
        return this.n.cp();
    }
}
