package com.byazt.wn;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 773, 26})
public class qg {
    public final Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(-99999987, 163101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
