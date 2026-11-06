package com.byazt.bo;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 508, 20})
public class hn implements Closeable {
    public int c;
    public byte[] hn;
    public final Charset hw;
    public final InputStream pr;
    public int x;

    public hn(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public hn(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(x.pr)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.pr = inputStream;
        this.hw = charset;
        this.hn = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.pr) {
            if (this.hn != null) {
                this.hn = null;
                this.pr.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String pr() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.pr) {
            if (this.hn == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.x >= this.c) {
                hn();
            }
            for (int i3 = this.x; i3 != this.c; i3++) {
                byte[] bArr2 = this.hn;
                if (bArr2[i3] == 10) {
                    int i4 = this.x;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    String str = new String(bArr2, i4, i2 - i4, this.hw.name());
                    this.x = i3 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.c - this.x) + 80) { // from class: com.byazt.bo.hn.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, hn.this.hw.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr3 = this.hn;
                int i5 = this.x;
                byteArrayOutputStream.write(bArr3, i5, this.c - i5);
                this.c = -1;
                hn();
                i = this.x;
                while (i != this.c) {
                    bArr = this.hn;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.x;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.x = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    public boolean hw() {
        return this.c == -1;
    }

    private void hn() throws IOException {
        InputStream inputStream = this.pr;
        byte[] bArr = this.hn;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.x = 0;
        this.c = i;
    }
}
