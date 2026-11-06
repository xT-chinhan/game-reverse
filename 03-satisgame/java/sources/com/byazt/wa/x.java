package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 21})
public abstract class x implements cd {
    public final cd n;

    public x(cd cdVar) {
        if (cdVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.n = cdVar;
    }

    @Override // com.byazt.wa.cd
    public void a_(s sVar, long j) throws IOException {
        this.n.a_(sVar, j);
    }

    @Override // com.byazt.wa.cd, java.io.Flushable
    public void flush() throws IOException {
        this.n.flush();
    }

    @Override // com.byazt.wa.cd
    public a n() {
        return this.n.n();
    }

    @Override // com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.n.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.n.toString() + ")";
    }
}
