package com.byazt.ti;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 107, 20})
public class hn {
    public final Function<SparseArray<Object>, Object> pr;

    public hn(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void pr(View view, float f, float f2, boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f));
        sparseArray.put(2, Float.valueOf(f2));
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(-99999987, 142101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
