package com.byazt.pis;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1372, 37})
public class pr {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void pr(com.byazt.mr.hw hwVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, hwVar);
        sparseArray.put(-99999987, 114102);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr(com.byazt.mr.pr prVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, prVar);
        sparseArray.put(-99999987, 114103);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void hw(com.byazt.mr.hw hwVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, hwVar);
        sparseArray.put(-99999987, 114104);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr(com.byazt.mr.hw hwVar, com.byazt.mr.pr prVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, hwVar);
        sparseArray.put(1, prVar);
        sparseArray.put(-99999987, 114105);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
