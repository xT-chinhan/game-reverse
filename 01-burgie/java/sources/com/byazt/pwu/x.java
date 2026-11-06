package com.byazt.pwu;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1002, 121})
public class x {
    public int hn;
    public boolean hw;
    public InputStream pr;

    public x() {
    }

    public x(InputStream inputStream, boolean z) {
        pr(inputStream, z);
    }

    public final void pr(InputStream inputStream, boolean z) {
        this.pr = inputStream;
        this.hw = z;
        this.hn = 0;
    }

    public final void pr() {
        InputStream inputStream = this.pr;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
            pr(null, false);
        }
    }

    public final int hw() throws IOException {
        return pr(4);
    }

    public final int pr(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.hw) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int i4 = this.pr.read();
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.hn++;
                    i2 |= i4 << i3;
                }
                return i2;
            }
            int i5 = i * 8;
            int i6 = 0;
            while (i2 != i5) {
                int i7 = this.pr.read();
                if (i7 == -1) {
                    throw new EOFException();
                }
                this.hn++;
                i6 |= i7 << i2;
                i2 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final int[] hw(int i) throws IOException {
        int[] iArr = new int[i];
        pr(iArr, 0, i);
        return iArr;
    }

    public final void pr(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = hw();
            i2--;
            i++;
        }
    }

    public final void hn(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long jSkip = this.pr.skip(j);
            this.hn = (int) (((long) this.hn) + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public final void hn() throws IOException {
        hn(4);
    }
}
