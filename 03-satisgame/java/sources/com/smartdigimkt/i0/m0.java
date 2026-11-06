package com.smartdigimkt.i0;

import android.util.Pair;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 {
    public static final j0 a = new j0();

    public abstract int a();

    public abstract int a(Object obj);

    public abstract k0 a(int i, k0 k0Var, boolean z);

    public final l0 a(int i, l0 l0Var) {
        return a(i, l0Var, 0L);
    }

    public abstract l0 a(int i, l0 l0Var, long j);

    public abstract int b();

    public final boolean c() {
        return b() == 0;
    }

    public final Pair a(l0 l0Var, k0 k0Var, int i, long j, long j2) {
        int iB = b();
        if (i < 0 || i >= iB) {
            throw new IndexOutOfBoundsException();
        }
        a(i, l0Var, j2);
        if (j == -9223372036854775807L) {
            j = l0Var.e;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = l0Var.c;
        long j3 = l0Var.g + j;
        long j4 = a(i2, k0Var, false).c;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < l0Var.d) {
            j3 -= j4;
            i2++;
            j4 = a(i2, k0Var, false).c;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    public final int a(int i, k0 k0Var, l0 l0Var, int i2, boolean z) {
        int i3 = a(i, k0Var, false).b;
        if (a(i3, l0Var, 0L).d != i) {
            return i + 1;
        }
        if (i2 == 0) {
            if (i3 == (c() ? -1 : b() - 1)) {
                i3 = -1;
            } else {
                i3++;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                if (i3 == (c() ? -1 : b() - 1)) {
                    i3 = c() ? -1 : 0;
                } else {
                    i3++;
                }
            } else {
                throw new IllegalStateException();
            }
        }
        if (i3 == -1) {
            return -1;
        }
        return a(i3, l0Var, 0L).c;
    }
}
