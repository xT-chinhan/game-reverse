package com.byazt.zz;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1105, 37})
public class pr {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void pr(com.byazt.mr.hw hwVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, hwVar);
        sparseArray.put(-99999987, 111101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void hw(com.byazt.mr.hw hwVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, hwVar);
        sparseArray.put(-99999987, 111102);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr(com.byazt.mr.hw hwVar, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, hwVar);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(-99999987, 111103);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
