package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public abstract class zo implements qa {
    public final qa pr;

    public zo(qa qaVar) {
        if (qaVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pr = qaVar;
    }

    public final qa hw() {
        return this.pr;
    }

    @Override // com.byazt.du.qa
    public long pr(hn hnVar, long j) throws IOException {
        return this.pr.pr(hnVar, j);
    }

    @Override // com.byazt.du.qa
    public a pr() {
        return this.pr.pr();
    }

    @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pr.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pr.toString() + ")";
    }
}
