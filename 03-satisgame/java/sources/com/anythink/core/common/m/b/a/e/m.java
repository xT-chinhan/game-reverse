package com.anythink.core.common.m.b.a.e;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    static final int a = 65535;
    static final int b = 1;
    static final int c = 2;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    static final int g = 7;
    static final int h = 10;
    private int i;
    private final int[] j = new int[10];

    final void a() {
        this.i = 0;
        Arrays.fill(this.j, 0);
    }

    final m a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.j;
            if (i < iArr.length) {
                this.i = (1 << i) | this.i;
                iArr[i] = i2;
            }
        }
        return this;
    }

    final boolean a(int i) {
        return ((1 << i) & this.i) != 0;
    }

    final int b(int i) {
        return this.j[i];
    }

    final int b() {
        return Integer.bitCount(this.i);
    }

    final int c() {
        if ((this.i & 2) != 0) {
            return this.j[1];
        }
        return -1;
    }

    private boolean a(boolean z) {
        int i;
        if ((this.i & 4) != 0) {
            i = this.j[2];
        } else {
            i = z ? 1 : 0;
        }
        return i == 1;
    }

    final int d() {
        if ((this.i & 16) != 0) {
            return this.j[4];
        }
        return Integer.MAX_VALUE;
    }

    final int c(int i) {
        return (this.i & 32) != 0 ? this.j[5] : i;
    }

    private int d(int i) {
        return (this.i & 64) != 0 ? this.j[6] : i;
    }

    final int e() {
        if ((this.i & 128) != 0) {
            return this.j[7];
        }
        return 65535;
    }

    final void a(m mVar) {
        for (int i = 0; i < 10; i++) {
            if (mVar.a(i)) {
                a(i, mVar.j[i]);
            }
        }
    }
}
