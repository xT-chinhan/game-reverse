package com.byazt.rz;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1415, 37})
public class pr {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void hw() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 244101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr(int i, String str, boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(-99999987, 244102);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 244103);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
