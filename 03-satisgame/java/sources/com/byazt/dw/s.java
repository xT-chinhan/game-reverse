package com.byazt.dw;

import android.os.Handler;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS, 8})
public class s implements n {
    public Handler n;
    public qg qg;

    @Override // com.byazt.dw.n
    public void n(Handler handler, com.byazt.ws.qg qgVar, qg qgVar2) {
        this.n = handler;
        this.qg = qgVar2;
        if (handler == null || qgVar2 == null || qgVar == null) {
            return;
        }
        qgVar.fs().put("serverBidding_timeout", Boolean.FALSE);
        handler.postDelayed(qgVar2, qgVar.tj());
    }

    @Override // com.byazt.dw.n
    public void n() {
        qg qgVar;
        if (this.n == null || (qgVar = this.qg) == null || qgVar.n()) {
            return;
        }
        this.n.removeCallbacks(this.qg);
        this.qg.run();
    }
}
