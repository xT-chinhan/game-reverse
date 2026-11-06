package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 101})
public abstract class fs implements um {
    public final um n;

    public fs(um umVar) {
        if (umVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.n = umVar;
    }

    public final um qg() {
        return this.n;
    }

    @Override // com.byazt.wa.um
    public long n(s sVar, long j) throws IOException {
        return this.n.n(sVar, j);
    }

    @Override // com.byazt.wa.um
    public a n() {
        return this.n.n();
    }

    @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.n.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.n.toString() + ")";
    }
}
