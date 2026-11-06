package com.byazt.ng;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 200, 37})
public class pr {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void pr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 171102);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void hw() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 171101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
