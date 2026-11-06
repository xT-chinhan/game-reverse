package com.byazt.zn;

import com.byazt.hg.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 94, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public com.byazt.ks.c aj;
    public i fw;
    public com.byazt.qe.hw uc;
    public String zo;
    public static int x = 1;
    public static int c = 2;

    public c(com.byazt.qe.hw hwVar, i iVar, com.byazt.ks.c cVar) {
        this.uc = hwVar;
        this.fw = iVar;
        if (hwVar != null) {
            this.zo = hwVar.x();
        }
        this.aj = cVar;
    }

    public com.byazt.qe.hw x() {
        return this.uc;
    }

    public i c() {
        return this.fw;
    }

    public String uc() {
        return this.zo;
    }

    public com.byazt.ks.c fw() {
        return this.aj;
    }
}
