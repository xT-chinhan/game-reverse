package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public final class oa implements q {
    public final s n = new s();
    public final cd qg;
    public boolean s;

    public oa(cd cdVar) {
        if (cdVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.qg = cdVar;
    }

    @Override // com.byazt.wa.q
    public s s() {
        return this.n;
    }

    @Override // com.byazt.wa.cd
    public void a_(s sVar, long j) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.a_(sVar, j);
        py();
    }

    @Override // com.byazt.wa.q
    public q qg(w wVar) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.qg(wVar);
        return py();
    }

    @Override // com.byazt.wa.q
    public q qg(String str) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.qg(str);
        return py();
    }

    @Override // com.byazt.wa.q
    public q s(byte[] bArr) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.s(bArr);
        return py();
    }

    @Override // com.byazt.wa.q
    public q s(byte[] bArr, int i, int i2) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.s(bArr, i, i2);
        return py();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.n.write(byteBuffer);
        py();
        return iWrite;
    }

    @Override // com.byazt.wa.q
    public q rv(int i) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.rv(i);
        return py();
    }

    @Override // com.byazt.wa.q
    public q fs(int i) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.fs(i);
        return py();
    }

    @Override // com.byazt.wa.q
    public q x(int i) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.x(i);
        return py();
    }

    @Override // com.byazt.wa.q
    public q d(long j) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.d(j);
        return py();
    }

    @Override // com.byazt.wa.q
    public q cp(long j) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        this.n.cp(j);
        return py();
    }

    @Override // com.byazt.wa.q
    public q py() throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        long jX = this.n.x();
        if (jX > 0) {
            this.qg.a_(this.n, jX);
        }
        return this;
    }

    @Override // com.byazt.wa.q, com.byazt.wa.cd, java.io.Flushable
    public void flush() throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        if (this.n.qg > 0) {
            cd cdVar = this.qg;
            s sVar = this.n;
            cdVar.a_(sVar, sVar.qg);
        }
        this.qg.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.s;
    }

    @Override // com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.s) {
            return;
        }
        if (this.n.qg > 0) {
            cd cdVar = this.qg;
            s sVar = this.n;
            cdVar.a_(sVar, sVar.qg);
        }
        th = null;
        try {
            this.qg.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.s = true;
        if (th != null) {
            py.n(th);
        }
    }

    @Override // com.byazt.wa.cd
    public a n() {
        return this.qg.n();
    }

    public String toString() {
        return "buffer(" + this.qg + ")";
    }
}
