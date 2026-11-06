package com.byazt.cy;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 19})
public class n implements com.byazt.fb.q {
    public com.byazt.mj.qg n;

    public n(com.byazt.mj.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.fb.q
    public String n() {
        com.byazt.mj.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.qg();
        }
        return null;
    }

    @Override // com.byazt.fb.q
    public String qg() {
        com.byazt.mj.qg qgVar = this.n;
        if (qgVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(qgVar.s())) {
            return this.n.q();
        }
        return this.n.s();
    }

    @Override // com.byazt.fb.q
    public String s() {
        com.byazt.mj.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.n();
        }
        return null;
    }

    @Override // com.byazt.fb.q
    public int q() {
        com.byazt.mj.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.l();
        }
        return 0;
    }

    @Override // com.byazt.fb.q
    public String l() {
        com.byazt.mj.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.w();
        }
        return null;
    }
}
