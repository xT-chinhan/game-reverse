package com.byazt.fx;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1670, 26})
public class qg {
    public final Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(View view, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(-99999987, 151101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg(View view, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(-99999987, 151102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(View view, String str, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(-99999987, 151103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(View view, float f, float f2) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f));
        sparseArray.put(2, Float.valueOf(f2));
        sparseArray.put(-99999987, 151104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
