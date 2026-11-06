package com.byazt.ap;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1201, 19})
public class n {
    public final Function<SparseArray<Object>, Object> n;

    public n(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(com.byazt.fvm.qg qgVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, qgVar);
        sparseArray.put(-99999987, 114102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(com.byazt.fvm.n nVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, nVar);
        sparseArray.put(-99999987, 114103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg(com.byazt.fvm.qg qgVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, qgVar);
        sparseArray.put(-99999987, 114104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(com.byazt.fvm.qg qgVar, com.byazt.fvm.n nVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, qgVar);
        sparseArray.put(1, nVar);
        sparseArray.put(-99999987, 114105);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
