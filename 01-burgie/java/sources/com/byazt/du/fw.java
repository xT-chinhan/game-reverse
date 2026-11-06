package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 62})
public abstract class fw implements lb {
    public final lb pr;

    public fw(lb lbVar) {
        if (lbVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pr = lbVar;
    }

    @Override // com.byazt.du.lb
    public void a_(hn hnVar, long j) throws IOException {
        this.pr.a_(hnVar, j);
    }

    @Override // com.byazt.du.lb, java.io.Flushable
    public void flush() throws IOException {
        this.pr.flush();
    }

    @Override // com.byazt.du.lb
    public a pr() {
        return this.pr.pr();
    }

    @Override // com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pr.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pr.toString() + ")";
    }
}
