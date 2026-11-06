package com.byazt.yg;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1797, 13})
public class hw {
    public final Function<SparseArray<Object>, Object> pr;

    public hw(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void pr(int i, com.byazt.xl.pr prVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, prVar);
        sparseArray.put(-99999987, 122101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
