package com.byazt.he;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1744, 19})
public class n {
    public final Function<SparseArray<Object>, Object> n;

    public n(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 268013);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268014);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268015);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
