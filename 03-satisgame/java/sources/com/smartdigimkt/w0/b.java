package com.smartdigimkt.w0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final b d = new b(new long[0]);
    public final int a;
    public final long[] b;
    public final a[] c;

    public b(long... jArr) {
        int length = jArr.length;
        this.a = length;
        this.b = Arrays.copyOf(jArr, length);
        this.c = new a[length];
        for (int i = 0; i < length; i++) {
            this.c[i] = new a();
        }
    }
}
