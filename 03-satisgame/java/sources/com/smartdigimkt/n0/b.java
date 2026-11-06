package com.smartdigimkt.n0;

import com.smartdigimkt.z0.u;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements l {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    public final long f;

    public b(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length <= 0) {
            this.f = 0L;
        } else {
            int i = length - 1;
            this.f = jArr2[i] + jArr3[i];
        }
    }

    @Override // com.smartdigimkt.n0.l
    public final j a(long j) {
        int i;
        long[] jArr = this.e;
        int i2 = u.a;
        int iBinarySearch = Arrays.binarySearch(jArr, j);
        if (iBinarySearch < 0) {
            i = -(iBinarySearch + 2);
        } else {
            while (true) {
                int i3 = iBinarySearch - 1;
                if (i3 < 0 || jArr[i3] != j) {
                    break;
                }
                iBinarySearch = i3;
            }
            i = iBinarySearch;
        }
        int iMax = Math.max(0, i);
        long[] jArr2 = this.e;
        long j2 = jArr2[iMax];
        long[] jArr3 = this.c;
        m mVar = new m(j2, jArr3[iMax]);
        if (j2 >= j || iMax == this.a - 1) {
            return new j(mVar, mVar);
        }
        int i4 = iMax + 1;
        return new j(mVar, new m(jArr2[i4], jArr3[i4]));
    }

    @Override // com.smartdigimkt.n0.l
    public final boolean a() {
        return true;
    }

    @Override // com.smartdigimkt.n0.l
    public final long b() {
        return this.f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}
