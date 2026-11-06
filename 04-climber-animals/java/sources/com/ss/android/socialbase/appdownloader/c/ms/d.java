package com.ss.android.socialbase.appdownloader.c.ms;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private InputStream f4566ms;
    private boolean xr;

    public d() {
    }

    public d(InputStream inputStream, boolean z) {
        ms(inputStream, z);
    }

    public final void ms(InputStream inputStream, boolean z) {
        this.f4566ms = inputStream;
        this.xr = z;
        this.ah = 0;
    }

    public final void ms() {
        InputStream inputStream = this.f4566ms;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            ms(null, false);
        }
    }

    public final int xr() throws IOException {
        return ms(4);
    }

    public final int ms(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.xr) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int i4 = this.f4566ms.read();
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.ah++;
                    i2 |= i4 << i3;
                }
                return i2;
            }
            int i5 = i * 8;
            int i6 = 0;
            while (i2 != i5) {
                int i7 = this.f4566ms.read();
                if (i7 == -1) {
                    throw new EOFException();
                }
                this.ah++;
                i6 |= i7 << i2;
                i2 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final int[] xr(int i) throws IOException {
        int[] iArr = new int[i];
        ms(iArr, 0, i);
        return iArr;
    }

    public final void ms(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = xr();
            i2--;
            i++;
        }
    }

    public final void ah(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long jSkip = this.f4566ms.skip(j);
            this.ah = (int) (((long) this.ah) + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public final void ah() throws IOException {
        ah(4);
    }
}
