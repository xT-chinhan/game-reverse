package com.byazt.cc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 762, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public com.byazt.sjd.pr hn;
    public int hw;
    public String pr;

    public c(String str, int i) {
        this.pr = str;
        this.hw = i;
    }

    public c(com.byazt.sjd.pr prVar) {
        if (prVar != null) {
            this.pr = prVar.hw();
            this.hw = prVar.hn();
            this.hn = prVar;
        }
    }
}
