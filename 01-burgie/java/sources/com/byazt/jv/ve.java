package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class ve {
    public long c;
    public long fw;
    public long hn;
    public long hw;
    public long pr = System.currentTimeMillis();
    public long uc;
    public long x;

    public void pr() {
        this.hn = System.currentTimeMillis();
    }

    public void hw() {
        this.x = System.currentTimeMillis();
    }

    public void hn() {
        this.c = System.currentTimeMillis();
    }

    public long x() {
        return this.pr;
    }

    public long c() {
        return this.hn;
    }

    public long uc() {
        return this.x;
    }

    public long fw() {
        return this.c;
    }

    public long zo() {
        return this.uc;
    }

    public void pr(long j) {
        this.uc = j;
    }

    public long aj() {
        return this.fw;
    }

    public void hw(long j) {
        this.fw = j;
    }

    public long vk() {
        return this.hw;
    }

    public void w() {
        this.hw = System.currentTimeMillis();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.pr + ", asyncCallExecTs=" + this.hw + ", requestStartExecTs=" + this.hn + ", requestConnectStartTs=" + this.x + ", requestConnectFinishTs=" + this.c + ", reqCallServerStartTs=" + this.uc + ", reqCallServerFinishTs=" + this.fw + AbstractJsonLexerKt.END_OBJ;
    }
}
