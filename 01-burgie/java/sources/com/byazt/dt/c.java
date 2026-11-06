package com.byazt.dt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1167, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c {
    public String hn;
    public boolean hw;
    public boolean pr;

    private c(boolean z, boolean z2, String str) {
        this.pr = z;
        this.hw = z2;
        this.hn = str;
    }

    public static c pr() {
        return new c(false, false, null);
    }

    public static c pr(boolean z, String str) {
        return new c(true, z, str);
    }

    public boolean hw() {
        return this.pr;
    }

    public boolean hn() {
        return this.hw;
    }

    public String x() {
        return this.hn;
    }
}
