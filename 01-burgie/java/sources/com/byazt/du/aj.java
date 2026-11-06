package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 61})
public class aj extends a {
    public a pr;

    public aj(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pr = aVar;
    }

    public final a pr() {
        return this.pr;
    }

    public final aj pr(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pr = aVar;
        return this;
    }

    @Override // com.byazt.du.a
    public a pr(long j, TimeUnit timeUnit) {
        return this.pr.pr(j, timeUnit);
    }

    @Override // com.byazt.du.a
    public long f_() {
        return this.pr.f_();
    }

    @Override // com.byazt.du.a
    public boolean hn() {
        return this.pr.hn();
    }

    @Override // com.byazt.du.a
    public long g_() {
        return this.pr.g_();
    }

    @Override // com.byazt.du.a
    public a pr(long j) {
        return this.pr.pr(j);
    }

    @Override // com.byazt.du.a
    public a c() {
        return this.pr.c();
    }

    @Override // com.byazt.du.a
    public a uc() {
        return this.pr.uc();
    }

    @Override // com.byazt.du.a
    public void fw() throws IOException {
        this.pr.fw();
    }
}
