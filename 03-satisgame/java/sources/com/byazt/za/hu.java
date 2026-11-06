package com.byazt.za;

import android.content.Context;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 793})
public class hu extends m {
    public hu(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        super(context, pkVar, qgVar);
    }

    @Override // com.byazt.za.m
    public void n(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        if (context == null) {
            return;
        }
        this.s = new BannerExpressVideoView(context, pkVar, qgVar);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(com.byazt.fx.s sVar) {
        if (this.s != null) {
            this.s.setVideoAdListener(sVar);
        }
    }

    @Override // com.byazt.za.qg
    public com.byazt.cs.n d() {
        if (this.rv != null && this.rv.get() != null) {
            return this.rv.get().getVideoModel();
        }
        if (this.s != null) {
            return ((BannerExpressVideoView) this.s).getVideoModel();
        }
        return null;
    }
}
