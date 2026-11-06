package com.byazt.he;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1744, 26})
public class qg {
    public final Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public View n(com.byazt.suf.n nVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, nVar);
        sparseArray.put(-99999987, 266013);
        sparseArray.put(-99999985, View.class);
        return (View) this.n.apply(sparseArray);
    }
}
