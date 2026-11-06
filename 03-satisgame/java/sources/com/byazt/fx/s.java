package com.byazt.fx;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1670, 8})
public class s {
    public final Function<SparseArray<Object>, Object> n;

    public s(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 152101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(int i, int i2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, Integer.valueOf(i2));
        sparseArray.put(-99999987, 152102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 152103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void s() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 152104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void q() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 152105);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(long j, long j2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(-99999987, 152106);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void l() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 152107);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
