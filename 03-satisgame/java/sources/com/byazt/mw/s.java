package com.byazt.mw;

import com.byazt.gct.ae;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 8})
public class s {
    public static volatile s n;
    public com.byazt.qdx.s qg;
    public final com.byazt.phf.qg s;

    public static s n() {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    com.byazt.ddg.n.n().n(com.byazt.ed.qg.n().w() != 2);
                    n = new s();
                }
            }
        }
        return n;
    }

    private s() {
        com.byazt.phf.qg qgVarN = new com.byazt.phf.qg.n().n(10000L, TimeUnit.MILLISECONDS).qg(10000L, TimeUnit.MILLISECONDS).s(10000L, TimeUnit.MILLISECONDS).n(new com.byazt.jc.s.n()).n(ae.n()).n(ae.qg()).n(true).n();
        this.s = qgVarN;
        com.byazt.tbt.q qVarN = qgVarN.n().n();
        if (qVarN != null) {
            qVarN.n(32);
            qVarN.qg(com.byazt.ed.qg.n().l());
        }
    }

    public com.byazt.phf.qg qg() {
        return this.s;
    }

    public com.byazt.qdx.s s() {
        q();
        return this.qg;
    }

    private void q() {
        if (this.qg == null) {
            this.qg = new com.byazt.qdx.s();
        }
    }
}
