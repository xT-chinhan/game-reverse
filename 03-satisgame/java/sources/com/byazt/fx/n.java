package com.byazt.fx;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1670, 19})
public class n extends qg {
    public final Function<SparseArray<Object>, Object> n;

    public n(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 151105);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
