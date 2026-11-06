package com.byazt.ls;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd extends Exception {
    public final int n;

    public hd(int i, String str) {
        super(str);
        this.n = i;
    }

    public hd(int i, String str, Throwable th) {
        super(str, th);
        this.n = i;
    }
}
