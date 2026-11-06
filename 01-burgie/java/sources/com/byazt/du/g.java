package com.byazt.du;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public final class g implements c {
    public boolean hn;
    public final qa hw;
    public final hn pr = new hn();

    public g(qa qaVar) {
        if (qaVar == null) {
            throw new NullPointerException("source == null");
        }
        this.hw = qaVar;
    }

    @Override // com.byazt.du.c
    public hn hn() {
        return this.pr;
    }

    @Override // com.byazt.du.qa
    public long pr(hn hnVar, long j) throws IOException {
        if (hnVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        if (this.pr.hw == 0 && this.hw.pr(this.pr, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.pr.pr(hnVar, Math.min(j, this.pr.hw));
    }

    @Override // com.byazt.du.c
    public boolean c() throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        return this.pr.c() && this.hw.pr(this.pr, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // com.byazt.du.c
    public void pr(long j) throws IOException {
        if (!hw(j)) {
            throw new EOFException();
        }
    }

    public boolean hw(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        while (this.pr.hw < j) {
            if (this.hw.pr(this.pr, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.du.c
    public byte zo() throws IOException {
        pr(1L);
        return this.pr.zo();
    }

    @Override // com.byazt.du.c
    public uc hn(long j) throws IOException {
        pr(j);
        return this.pr.hn(j);
    }

    @Override // com.byazt.du.c
    public byte[] yb() throws IOException {
        this.pr.pr(this.hw);
        return this.pr.yb();
    }

    @Override // com.byazt.du.c
    public byte[] fw(long j) throws IOException {
        pr(j);
        return this.pr.fw(j);
    }

    @Override // com.byazt.du.c
    public void pr(byte[] bArr) throws IOException {
        try {
            pr(bArr.length);
            this.pr.pr(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.pr.hw > 0) {
                hn hnVar = this.pr;
                int iPr = hnVar.pr(bArr, i, (int) hnVar.hw);
                if (iPr == -1) {
                    throw new AssertionError();
                }
                i += iPr;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.pr.hw == 0 && this.hw.pr(this.pr, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.pr.read(byteBuffer);
    }

    @Override // com.byazt.du.c
    public String pr(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.pr.pr(this.hw);
        return this.pr.pr(charset);
    }

    @Override // com.byazt.du.c
    public String nt() throws IOException {
        return c(LongCompanionObject.MAX_VALUE);
    }

    @Override // com.byazt.du.c
    public String c(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jPr = pr((byte) 10, 0L, j2);
        if (jPr != -1) {
            return this.pr.uc(jPr);
        }
        if (j2 < LongCompanionObject.MAX_VALUE && hw(j2) && this.pr.hw(j2 - 1) == 13 && hw(1 + j2) && this.pr.hw(j2) == 10) {
            return this.pr.uc(j2);
        }
        hn hnVar = new hn();
        hn hnVar2 = this.pr;
        hnVar2.pr(hnVar, 0L, Math.min(32L, hnVar2.hw()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.pr.hw(), j) + " content=" + hnVar.g().c() + Typography.ellipsis);
    }

    @Override // com.byazt.du.c
    public short aj() throws IOException {
        pr(2L);
        return this.pr.aj();
    }

    @Override // com.byazt.du.c
    public short w() throws IOException {
        pr(2L);
        return this.pr.w();
    }

    @Override // com.byazt.du.c
    public int vk() throws IOException {
        pr(4L);
        return this.pr.vk();
    }

    @Override // com.byazt.du.c
    public int k() throws IOException {
        pr(4L);
        return this.pr.k();
    }

    @Override // com.byazt.du.c
    public long m() throws IOException {
        pr(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!hw(i2)) {
                break;
            }
            byte bHw = this.pr.hw(i);
            if ((bHw >= 48 && bHw <= 57) || ((bHw >= 97 && bHw <= 102) || (bHw >= 65 && bHw <= 70))) {
                i = i2;
            } else {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bHw)));
            }
        }
        return this.pr.m();
    }

    @Override // com.byazt.du.c
    public void zo(long j) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.pr.hw == 0 && this.hw.pr(this.pr, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.pr.hw());
            this.pr.zo(jMin);
            j -= jMin;
        }
    }

    @Override // com.byazt.du.c
    public long pr(byte b) throws IOException {
        return pr(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    public long pr(byte b, long j, long j2) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jPr = this.pr.pr(b, j, j2);
            if (jPr != -1) {
                return jPr;
            }
            long j3 = this.pr.hw;
            if (j3 >= j2 || this.hw.pr(this.pr, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.byazt.du.c
    public boolean pr(long j, uc ucVar) throws IOException {
        return pr(j, ucVar, 0, ucVar.fw());
    }

    public boolean pr(long j, uc ucVar, int i, int i2) throws IOException {
        if (this.hn) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || ucVar.fw() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = ((long) i3) + j;
            if (!hw(1 + j2) || this.pr.hw(j2) != ucVar.pr(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.du.c
    public InputStream uc() {
        return new InputStream() { // from class: com.byazt.du.g.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (g.this.hn) {
                    throw new IOException("closed");
                }
                if (g.this.pr.hw == 0 && g.this.hw.pr(g.this.pr, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return g.this.pr.zo() & UByte.MAX_VALUE;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (g.this.hn) {
                    throw new IOException("closed");
                }
                cz.pr(bArr.length, i, i2);
                if (g.this.pr.hw == 0 && g.this.hw.pr(g.this.pr, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return g.this.pr.pr(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (g.this.hn) {
                    throw new IOException("closed");
                }
                return (int) Math.min(g.this.pr.hw, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                g.this.close();
            }

            public String toString() {
                return g.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.hn;
    }

    @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hn) {
            return;
        }
        this.hn = true;
        this.hw.close();
        this.pr.lb();
    }

    @Override // com.byazt.du.qa
    public a pr() {
        return this.hw.pr();
    }

    public String toString() {
        return "buffer(" + this.hw + ")";
    }
}
