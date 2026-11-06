package com.byazt.ezh;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 166, 26})
public class qg {
    public InputStream n;
    public int qg;

    public qg(InputStream inputStream) {
        n(inputStream);
    }

    public final void n(InputStream inputStream) {
        this.n = inputStream;
        this.qg = 0;
    }

    public final void n() {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            n((InputStream) null);
        }
    }

    public final int qg() throws IOException {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int i3 = this.n.read();
            if (i3 == -1) {
                throw new EOFException();
            }
            this.qg++;
            i |= i3 << i2;
        }
        return i;
    }

    public final int[] n(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = qg();
            i--;
            i2++;
        }
        return iArr;
    }

    public final void s() throws IOException {
        long jSkip = this.n.skip(4L);
        this.qg = (int) (((long) this.qg) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }

    public void qg(int i) throws IOException {
        int iQg = qg();
        if (iQg != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(iQg)));
        }
    }
}
