package com.byazt.fli;

import com.byazt.gct.fs;
import com.byazt.gzx.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 26})
public abstract class qg {
    public int cp = -1;
    public l fs;
    public fs.s l;
    public int rv;
    public String tj;
    public com.byazt.gzx.s w;
    public com.byazt.gzx.s x;

    public void n(int i, String str) {
    }

    public void n(boolean z) {
    }

    public void s() {
    }

    public qg(l lVar) {
        this.fs = lVar;
    }

    public void n(com.byazt.gzx.s sVar) {
        this.w = sVar;
    }

    public void qg(com.byazt.gzx.s sVar) {
        this.x = sVar;
    }

    public boolean q() {
        return this.x != null;
    }

    public void qg(int i, String str) {
        this.rv = i;
        this.tj = str;
    }
}
