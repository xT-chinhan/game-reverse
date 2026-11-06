package com.byazt.dw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS, 26})
public class qg implements Runnable {
    public com.byazt.ws.qg n;
    public Runnable qg;
    public boolean s = false;

    public qg(com.byazt.ws.qg qgVar, Runnable runnable) {
        this.n = qgVar;
        this.qg = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.byazt.ws.qg qgVar = this.n;
        if (qgVar != null && qgVar.rv() == 4) {
            this.n.fs().put("serverBidding_timeout", Boolean.TRUE);
        }
        this.s = true;
        Runnable runnable = this.qg;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean n() {
        return this.s;
    }
}
