package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 113})
public class d extends com.byazt.fvm.s {
    public w n;

    public d(pk pkVar) {
        if (pkVar == null) {
            return;
        }
        this.n = pkVar.cd();
    }

    @Override // com.byazt.fvm.s
    public String n() {
        w wVar = this.n;
        return wVar == null ? "" : wVar.sz();
    }

    @Override // com.byazt.fvm.s
    public String qg() {
        w wVar = this.n;
        return wVar == null ? "" : wVar.l();
    }

    @Override // com.byazt.fvm.s
    public String s() {
        w wVar = this.n;
        return wVar == null ? "" : wVar.x();
    }

    @Override // com.byazt.fvm.s
    public String q() {
        w wVar = this.n;
        return wVar == null ? "" : wVar.fs();
    }

    @Override // com.byazt.fvm.s
    public Map<String, String> l() {
        w wVar = this.n;
        if (wVar == null) {
            return null;
        }
        return wVar.n();
    }

    @Override // com.byazt.fvm.s
    public String w() {
        w wVar = this.n;
        if (wVar == null) {
            return null;
        }
        return wVar.qg();
    }

    @Override // com.byazt.fvm.s
    public String x() {
        w wVar = this.n;
        if (wVar == null) {
            return null;
        }
        return wVar.rv();
    }

    @Override // com.byazt.fvm.s
    public String rv() {
        w wVar = this.n;
        if (wVar == null) {
            return null;
        }
        return wVar.tj();
    }

    @Override // com.byazt.fvm.s
    public String fs() {
        w wVar = this.n;
        if (wVar == null) {
            return null;
        }
        return wVar.cp();
    }
}
