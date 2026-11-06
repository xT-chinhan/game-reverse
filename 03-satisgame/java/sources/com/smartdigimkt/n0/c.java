package com.smartdigimkt.n0;

import com.smartdigimkt.z0.u;
import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final com.smartdigimkt.y0.i b;
    public final long c;
    public long d;
    public int f;
    public int g;
    public byte[] e = new byte[65536];
    public final byte[] a = new byte[4096];

    public c(com.smartdigimkt.y0.i iVar, long j, long j2) {
        this.b = iVar;
        this.d = j;
        this.c = j2;
    }

    public final boolean a(int i) throws InterruptedException, EOFException {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            int i3 = u.a;
            this.e = Arrays.copyOf(this.e, Math.max(65536 + i2, Math.min(bArr.length * 2, i2 + 524288)));
        }
        int iMin = Math.min(this.g - this.f, i);
        while (iMin < i) {
            iMin = a(this.e, this.f, i, iMin, false);
            if (iMin == -1) {
                return false;
            }
        }
        int i4 = this.f + i;
        this.f = i4;
        this.g = Math.max(this.g, i4);
        return true;
    }

    public final void b(int i) throws InterruptedException, EOFException {
        int iMin = Math.min(this.g, i);
        int i2 = this.g - iMin;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, iMin, bArr2, 0, i2);
        this.e = bArr2;
        int iA = iMin;
        while (iA < i && iA != -1) {
            iA = a(this.a, -iA, Math.min(i, this.a.length + iA), iA, false);
        }
        if (iA != -1) {
            this.d += (long) iA;
        }
    }

    public final boolean a(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, EOFException {
        int iA;
        int i3 = this.g;
        if (i3 == 0) {
            iA = 0;
        } else {
            int iMin = Math.min(i3, i2);
            System.arraycopy(this.e, 0, bArr, i, iMin);
            int i4 = this.g - iMin;
            this.g = i4;
            this.f = 0;
            byte[] bArr2 = this.e;
            byte[] bArr3 = i4 < bArr2.length - 524288 ? new byte[65536 + i4] : bArr2;
            System.arraycopy(bArr2, iMin, bArr3, 0, i4);
            this.e = bArr3;
            iA = iMin;
        }
        while (iA < i2 && iA != -1) {
            iA = a(bArr, i, i2, iA, z);
        }
        if (iA != -1) {
            this.d += (long) iA;
        }
        return iA != -1;
    }

    public final int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, EOFException {
        if (!Thread.interrupted()) {
            int iA = this.b.a(bArr, i + i3, i2 - i3);
            if (iA != -1) {
                return i3 + iA;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }
}
