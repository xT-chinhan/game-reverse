package com.bytedance.pangle.ab.ms;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private InputStream f615ms;
    private int xr;

    public xr(InputStream inputStream) {
        ms(inputStream);
    }

    public final void ms(InputStream inputStream) {
        this.f615ms = inputStream;
        this.xr = 0;
    }

    public final void ms() {
        InputStream inputStream = this.f615ms;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            ms((InputStream) null);
        }
    }

    public final int xr() throws IOException {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int i3 = this.f615ms.read();
            if (i3 == -1) {
                throw new EOFException();
            }
            this.xr++;
            i |= i3 << i2;
        }
        return i;
    }

    public final int[] ms(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = xr();
            i--;
            i2++;
        }
        return iArr;
    }

    public final void ah() throws IOException {
        long jSkip = this.f615ms.skip(4L);
        this.xr = (int) (((long) this.xr) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }

    public void xr(int i) throws IOException {
        int iXr = xr();
        if (iXr != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(iXr)));
        }
    }
}
