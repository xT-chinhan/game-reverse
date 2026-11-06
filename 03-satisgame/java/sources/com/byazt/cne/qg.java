package com.byazt.cne;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1063, 26})
public class qg {
    public final Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(com.byazt.fvm.qg qgVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, qgVar);
        sparseArray.put(-99999987, 121201);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 112102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 112103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
