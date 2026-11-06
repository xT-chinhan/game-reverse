package com.byazt.za;

import android.content.Context;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL})
public class t extends ur {
    public t(Context context, pk pkVar, com.byazt.zq.qg qgVar, int i) {
        super(context, pkVar, qgVar, i);
    }

    @Override // com.byazt.za.ur, com.byazt.za.h
    public void n(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        this.w = "draw_ad";
        this.s = new NativeExpressDrawVideoView(context, pkVar, qgVar, "draw_ad");
        n(this.s, this.l);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(boolean z) {
        if (this.s != null) {
            ((NativeExpressVideoView) this.s).setCanInterruptVideoPlay(z);
        }
    }
}
