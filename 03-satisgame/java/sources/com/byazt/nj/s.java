package com.byazt.nj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1070, 8})
public final class s {
    public static final s n = new s(false, -1, -1, 0);
    public final int l;
    public final int q;
    public final boolean qg;
    public final int s;

    private s(boolean z, int i, int i2, int i3) {
        this.qg = z;
        this.s = i;
        this.q = i2;
        this.l = i3;
    }

    public static s n() {
        return n;
    }

    public static s n(int i, int i2, int i3) {
        return new s(true, i, i2, i3);
    }

    public boolean qg() {
        return this.qg;
    }

    public int s() {
        return this.s;
    }

    public int q() {
        return this.q;
    }
}
