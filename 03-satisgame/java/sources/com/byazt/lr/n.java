package com.byazt.lr;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1731, 19})
public class n {
    public final Function<SparseArray<Object>, Object> n;

    public n(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 244101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(int i, String str, boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(-99999987, 244102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 244103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
