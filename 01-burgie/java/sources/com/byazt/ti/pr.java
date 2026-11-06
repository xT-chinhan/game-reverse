package com.byazt.ti;

import android.util.SparseArray;
import android.view.View;
import com.byazt.mr.m;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 107, 37})
public class pr {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void pr(View view, m mVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, mVar);
        sparseArray.put(-99999987, 141101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void hw(View view, m mVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, mVar);
        sparseArray.put(-99999987, 141102);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr(m mVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, mVar);
        sparseArray.put(-99999987, 141103);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
