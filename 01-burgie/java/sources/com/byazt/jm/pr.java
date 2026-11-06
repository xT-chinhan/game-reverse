package com.byazt.jm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 37})
public class pr {
    public com.byazt.zz.hw pr;

    public void pr(com.byazt.zz.hw hwVar) {
        this.pr = hwVar;
    }

    public void pr() {
        com.byazt.zz.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.hw();
            this.pr = null;
        }
    }

    public void pr(com.byazt.mr.hw hwVar) {
        com.byazt.zz.hw hwVar2 = this.pr;
        if (hwVar2 != null) {
            hwVar2.pr(hwVar);
        }
    }

    public void hw() {
        com.byazt.zz.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.pr();
        }
    }

    public boolean hn() {
        return this.pr == null;
    }
}
