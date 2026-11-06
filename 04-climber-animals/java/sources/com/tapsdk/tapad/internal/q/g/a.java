package com.tapsdk.tapad.internal.q.g;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class a extends FilterInputStream {
    private final c a;
    private int b;

    public a(InputStream inputStream, c cVar) {
        super(inputStream);
        this.a = cVar;
    }

    private synchronized int a(int i) {
        if (i == -1) {
            this.a.a();
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        try {
            int iA = a(((FilterInputStream) this).in.read());
            if (iA != -1) {
                this.b++;
            }
            this.a.a(this.b);
            return iA;
        } catch (IOException unused) {
            return 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            int iA = a(((FilterInputStream) this).in.read(bArr, i, i2));
            if (iA != -1) {
                this.b += iA;
            }
            this.a.a(iA);
            return iA;
        } catch (IOException unused) {
            return 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException("Mark not supported");
    }
}
