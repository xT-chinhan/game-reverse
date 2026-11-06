package com.byazt.csa;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2380, 19})
public class n {
    public final SparseArray<Object> n;

    private n() {
        this.n = new SparseArray<>();
    }

    public n(SparseArray<Object> sparseArray) {
        this.n = sparseArray;
    }

    public static n n(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        return new n(sparseArray);
    }

    public n n(int i, Object obj) {
        this.n.put(i, obj);
        return this;
    }

    public SparseArray<Object> n() {
        return this.n;
    }
}
