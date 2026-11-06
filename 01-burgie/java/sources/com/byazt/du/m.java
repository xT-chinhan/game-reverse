package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 108})
public final class m implements x {
    public boolean hn;
    public final lb hw;
    public final hn pr = new hn();

    public m(lb lbVar) {
        if (lbVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.hw = lbVar;
    }

    @Override // com.byazt.du.x
    public hn hn() {
        return this.pr;
    }

    @Override // com.byazt.du.lb
    public void a_(hn hnVar, long j) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.a_(hnVar, j);
        cz();
    }

    @Override // com.byazt.du.x
    public x hw(uc ucVar) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.hw(ucVar);
        return cz();
    }

    @Override // com.byazt.du.x
    public x hw(String str) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.hw(str);
        return cz();
    }

    @Override // com.byazt.du.x
    public x hn(byte[] bArr) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.hn(bArr);
        return cz();
    }

    @Override // com.byazt.du.x
    public x hn(byte[] bArr, int i, int i2) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.hn(bArr, i, i2);
        return cz();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.pr.write(byteBuffer);
        cz();
        return iWrite;
    }

    @Override // com.byazt.du.x
    public x aj(int i) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.aj(i);
        return cz();
    }

    @Override // com.byazt.du.x
    public x zo(int i) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.zo(i);
        return cz();
    }

    @Override // com.byazt.du.x
    public x fw(int i) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.fw(i);
        return cz();
    }

    @Override // com.byazt.du.x
    public x k(long j) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.k(j);
        return cz();
    }

    @Override // com.byazt.du.x
    public x w(long j) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        this.pr.w(j);
        return cz();
    }

    @Override // com.byazt.du.x
    public x cz() throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        long jFw = this.pr.fw();
        if (jFw > 0) {
            this.hw.a_(this.pr, jFw);
        }
        return this;
    }

    @Override // com.byazt.du.x, com.byazt.du.lb, java.io.Flushable
    public void flush() throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        if (this.pr.hw > 0) {
            lb lbVar = this.hw;
            hn hnVar = this.pr;
            lbVar.a_(hnVar, hnVar.hw);
        }
        this.hw.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.hn;
    }

    @Override // com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.hn) {
            return;
        }
        Throwable th = null;
        try {
            if (this.pr.hw > 0) {
                lb lbVar = this.hw;
                hn hnVar = this.pr;
                lbVar.a_(hnVar, hnVar.hw);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.hw.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.hn = true;
        if (th != null) {
            cz.pr(th);
        }
    }

    @Override // com.byazt.du.lb
    public a pr() {
        return this.hw.pr();
    }

    public String toString() {
        return "buffer(" + this.hw + ")";
    }
}
