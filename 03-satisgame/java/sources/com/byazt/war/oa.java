package com.byazt.war;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends n {
    @Override // com.byazt.war.rv
    public String n() {
        return "spec_file_cache";
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        String strW = sVar.w();
        com.byazt.si.qg qgVarOu = sVar.ou();
        byte[] bArrN = com.byazt.esj.n.n(sVar);
        if (bArrN == null) {
            sVar.n(new fs(1006, "not image cache", null));
            return;
        }
        sVar.n(new qg(bArrN, null));
        if (qgVarOu.x()) {
            sVar.py().qg(qgVarOu).n(strW, bArrN);
        }
    }
}
