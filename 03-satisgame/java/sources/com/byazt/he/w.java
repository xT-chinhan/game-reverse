package com.byazt.he;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1744, 13})
public class w {
    public final Function<SparseArray<Object>, Object> n;

    public w(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270012);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
