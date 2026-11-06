package com.byazt.he;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1744, 18})
public class l extends com.byazt.dc.s {
    public final Function<SparseArray<Object>, Object> n;

    public l(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(View view, String str, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(-99999987, 142102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 142103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 142104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
