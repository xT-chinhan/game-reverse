package com.byazt.xwa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 8})
public class s implements Closeable {
    public int l;
    public final InputStream n;
    public int q;
    public final Charset qg;
    public byte[] s;

    public s(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public s(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(q.n)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.n = inputStream;
        this.qg = charset;
        this.s = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.n) {
            if (this.s != null) {
                this.s = null;
                this.n.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String n() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.n) {
            if (this.s == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.q >= this.l) {
                s();
            }
            for (int i3 = this.q; i3 != this.l; i3++) {
                byte[] bArr2 = this.s;
                if (bArr2[i3] == 10) {
                    if (i3 != this.q) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    byte[] bArr3 = this.s;
                    int i4 = this.q;
                    String str = new String(bArr3, i4, i2 - i4, this.qg.name());
                    this.q = i3 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.l - this.q) + 80) { // from class: com.byazt.xwa.s.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, s.this.qg.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr4 = this.s;
                int i5 = this.q;
                byteArrayOutputStream.write(bArr4, i5, this.l - i5);
                this.l = -1;
                s();
                i = this.q;
                while (i != this.l) {
                    bArr = this.s;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.q;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.q = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    public boolean qg() {
        return this.l == -1;
    }

    private void s() throws IOException {
        InputStream inputStream = this.n;
        byte[] bArr = this.s;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.q = 0;
        this.l = i;
    }
}
