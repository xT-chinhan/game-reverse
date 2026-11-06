package com.byazt.cc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 762, 13})
public class hw {
    public int hw;
    public InputStream pr;

    public hw(InputStream inputStream) {
        pr(inputStream);
    }

    public final void pr(InputStream inputStream) {
        this.pr = inputStream;
        this.hw = 0;
    }

    public final void pr() {
        InputStream inputStream = this.pr;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
            pr((InputStream) null);
        }
    }

    public final int hw() throws IOException {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int i3 = this.pr.read();
            if (i3 == -1) {
                throw new EOFException();
            }
            this.hw++;
            i |= i3 << i2;
        }
        return i;
    }

    public final int[] pr(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = hw();
            i--;
            i2++;
        }
        return iArr;
    }

    public final void hn() throws IOException {
        long jSkip = this.pr.skip(4L);
        this.hw = (int) (((long) this.hw) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }

    public void hw(int i) throws IOException {
        int iHw = hw();
        if (iHw != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(iHw)));
        }
    }
}
