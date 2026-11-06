package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends a {
    public a n;

    public rv(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.n = aVar;
    }

    public final a n() {
        return this.n;
    }

    public final rv n(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.n = aVar;
        return this;
    }

    @Override // com.byazt.wa.a
    public a n(long j, TimeUnit timeUnit) {
        return this.n.n(j, timeUnit);
    }

    @Override // com.byazt.wa.a
    public long n_() {
        return this.n.n_();
    }

    @Override // com.byazt.wa.a
    public boolean s() {
        return this.n.s();
    }

    @Override // com.byazt.wa.a
    public long o_() {
        return this.n.o_();
    }

    @Override // com.byazt.wa.a
    public a n(long j) {
        return this.n.n(j);
    }

    @Override // com.byazt.wa.a
    public a l() {
        return this.n.l();
    }

    @Override // com.byazt.wa.a
    public a w() {
        return this.n.w();
    }

    @Override // com.byazt.wa.a
    public void x() throws IOException {
        this.n.x();
    }
}
