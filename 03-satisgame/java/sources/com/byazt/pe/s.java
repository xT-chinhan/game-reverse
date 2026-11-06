package com.byazt.pe;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 865, 8})
public class s {
    public final Function<SparseArray<Object>, Object> n;

    public s(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(String str, com.byazt.am.qg qgVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, str);
        sparseArray.put(1, qgVar);
        sparseArray.put(-99999987, 270026);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 270027);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
