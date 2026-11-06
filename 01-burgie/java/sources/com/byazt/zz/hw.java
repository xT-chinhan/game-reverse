package com.byazt.zz;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1105, 13})
public class hw {
    public final Function<SparseArray<Object>, Object> pr;

    public hw(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void pr(com.byazt.mr.hw hwVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, hwVar);
        sparseArray.put(-99999987, 121201);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 112102);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void hw() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 112103);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
