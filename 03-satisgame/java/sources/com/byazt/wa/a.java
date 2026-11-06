package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a {
    public static final a s = new a() { // from class: com.byazt.wa.a.1
        @Override // com.byazt.wa.a
        public a n(long j) {
            return this;
        }

        @Override // com.byazt.wa.a
        public a n(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.byazt.wa.a
        public void x() throws IOException {
        }
    };
    public boolean n;
    public long q;
    public long qg;

    public a n(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.q = timeUnit.toNanos(j);
        return this;
    }

    public long n_() {
        return this.q;
    }

    public boolean s() {
        return this.n;
    }

    public long o_() {
        if (!this.n) {
            throw new IllegalStateException("No deadline");
        }
        return this.qg;
    }

    public a n(long j) {
        this.n = true;
        this.qg = j;
        return this;
    }

    public a l() {
        this.q = 0L;
        return this;
    }

    public a w() {
        this.n = false;
        return this;
    }

    public void x() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.n && this.qg - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
