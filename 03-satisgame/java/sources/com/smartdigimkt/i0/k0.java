package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 {
    public Object a;
    public int b;
    public long c;
    public long d;
    public com.smartdigimkt.w0.b e;

    public final int a(long j) {
        com.smartdigimkt.w0.b bVar = this.e;
        int i = 0;
        while (true) {
            long[] jArr = bVar.b;
            if (i >= jArr.length) {
                break;
            }
            long j2 = jArr[i];
            if (j2 == Long.MIN_VALUE) {
                break;
            }
            if (j < j2) {
                bVar.c[i].getClass();
                break;
            }
            i++;
        }
        if (i < bVar.b.length) {
            return i;
        }
        return -1;
    }

    public final int b(long j) {
        com.smartdigimkt.w0.b bVar = this.e;
        int length = bVar.b.length - 1;
        while (length >= 0) {
            long j2 = bVar.b[length];
            if (j2 != Long.MIN_VALUE && j2 <= j) {
                break;
            }
            length--;
        }
        if (length < 0) {
            return -1;
        }
        bVar.c[length].getClass();
        return length;
    }
}
