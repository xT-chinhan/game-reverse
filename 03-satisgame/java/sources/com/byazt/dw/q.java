package com.byazt.dw;

import android.os.Handler;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS, 5})
public class q implements n {
    @Override // com.byazt.dw.n
    public void n() {
    }

    @Override // com.byazt.dw.n
    public void n(Handler handler, com.byazt.ws.qg qgVar, qg qgVar2) {
        if (qgVar2 != null) {
            qgVar2.run();
        }
    }
}
