package com.byazt.of;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1170, 8})
public class s {
    public final SparseArray<Object> n = new SparseArray<>();

    private s() {
    }

    public static s n() {
        return new s();
    }

    public s n(int i) {
        this.n.put(-999900, Integer.valueOf(i));
        return this;
    }

    public s n(String str) {
        this.n.put(-999901, str);
        return this;
    }

    public s n(boolean z) {
        this.n.put(-999903, Boolean.valueOf(z));
        return this;
    }

    public s n(SparseArray<Object> sparseArray) {
        this.n.put(-999902, sparseArray);
        return this;
    }

    public SparseArray<Object> qg() {
        return this.n;
    }
}
