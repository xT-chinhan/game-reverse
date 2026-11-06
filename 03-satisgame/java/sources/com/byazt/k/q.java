package com.byazt.k;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 210, 5})
public class q {
    public InputStream n;
    public boolean qg;
    public int s;

    public q() {
    }

    public q(InputStream inputStream, boolean z) {
        n(inputStream, z);
    }

    public final void n(InputStream inputStream, boolean z) {
        this.n = inputStream;
        this.qg = z;
        this.s = 0;
    }

    public final void n() {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            n(null, false);
        }
    }

    public final int qg() throws IOException {
        return n(4);
    }

    public final int n(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.qg) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int i4 = this.n.read();
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.s++;
                    i2 |= i4 << i3;
                }
                return i2;
            }
            int i5 = i * 8;
            int i6 = 0;
            while (i2 != i5) {
                int i7 = this.n.read();
                if (i7 == -1) {
                    throw new EOFException();
                }
                this.s++;
                i6 |= i7 << i2;
                i2 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final int[] qg(int i) throws IOException {
        int[] iArr = new int[i];
        n(iArr, 0, i);
        return iArr;
    }

    public final void n(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = qg();
            i2--;
            i++;
        }
    }

    public final void s(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long jSkip = this.n.skip(j);
            this.s = (int) (((long) this.s) + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public final void s() throws IOException {
        s(4);
    }
}
