package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a {
    public static final a hn = new a() { // from class: com.byazt.du.a.1
        @Override // com.byazt.du.a
        public a pr(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.byazt.du.a
        public a pr(long j) {
            return this;
        }

        @Override // com.byazt.du.a
        public void fw() throws IOException {
        }
    };
    public long hw;
    public boolean pr;
    public long x;

    public a pr(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.x = timeUnit.toNanos(j);
        return this;
    }

    public long f_() {
        return this.x;
    }

    public boolean hn() {
        return this.pr;
    }

    public long g_() {
        if (!this.pr) {
            throw new IllegalStateException("No deadline");
        }
        return this.hw;
    }

    public a pr(long j) {
        this.pr = true;
        this.hw = j;
        return this;
    }

    public a c() {
        this.x = 0L;
        return this;
    }

    public a uc() {
        this.pr = false;
        return this;
    }

    public void fw() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.pr && this.hw - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
