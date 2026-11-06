package com.bytedance.sdk.component.c.ah.ms.ms;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
class ah implements Closeable {
    private byte[] ah;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final InputStream f1168ms;
    private final Charset xr;

    public ah(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public ah(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(d.f1170ms)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f1168ms = inputStream;
        this.xr = charset;
        this.ah = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f1168ms) {
            if (this.ah != null) {
                this.ah = null;
                this.f1168ms.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String ms() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f1168ms) {
            if (this.ah == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.ka) {
                ah();
            }
            for (int i3 = this.d; i3 != this.ka; i3++) {
                byte[] bArr2 = this.ah;
                if (bArr2[i3] == 10) {
                    if (i3 != this.d) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    byte[] bArr3 = this.ah;
                    int i4 = this.d;
                    String str = new String(bArr3, i4, i2 - i4, this.xr.name());
                    this.d = i3 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.ka - this.d) + 80) { // from class: com.bytedance.sdk.component.c.ah.ms.ms.ah.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, ah.this.xr.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr4 = this.ah;
                int i5 = this.d;
                byteArrayOutputStream.write(bArr4, i5, this.ka - i5);
                this.ka = -1;
                ah();
                i = this.d;
                while (i != this.ka) {
                    bArr = this.ah;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.d;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.d = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    public boolean xr() {
        return this.ka == -1;
    }

    private void ah() throws IOException {
        InputStream inputStream = this.f1168ms;
        byte[] bArr = this.ah;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.ka = i;
    }
}
