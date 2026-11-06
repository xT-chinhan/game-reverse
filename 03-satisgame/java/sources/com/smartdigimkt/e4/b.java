package com.smartdigimkt.e4;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends InputStream {
    public final InputStream a;
    public final long b;
    public long c;

    public b(InputStream inputStream, long j) {
        this.a = inputStream;
        this.b = j;
        this.c = j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.c == 0) {
            if (this.a.read() == -1) {
                return -1;
            }
            throw new IOException("HTTP response body exceeds " + this.b + " bytes");
        }
        int i = this.a.read();
        if (i != -1) {
            this.c--;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.c;
        if (j == 0) {
            return read();
        }
        int i3 = this.a.read(bArr, i, (int) Math.min(i2, j));
        if (i3 > 0) {
            this.c -= (long) i3;
        }
        return i3;
    }
}
