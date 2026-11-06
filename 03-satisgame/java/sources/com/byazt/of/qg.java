package com.byazt.of;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1170, 26})
public class qg {
    public final SparseArray<Object> n;

    private qg() {
        this.n = new SparseArray<>();
    }

    public qg(SparseArray<Object> sparseArray) {
        this.n = sparseArray;
    }

    public static qg n() {
        return new qg();
    }

    public static qg n(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        return new qg(sparseArray);
    }

    public qg n(int i) {
        this.n.put(-99999987, Integer.valueOf(i));
        return this;
    }

    public qg n(Class<?> cls) {
        this.n.put(-99999985, cls);
        return this;
    }

    public qg n(int i, Object obj) {
        this.n.put(i, obj);
        return this;
    }

    public SparseArray<Object> qg() {
        return this.n;
    }
}
