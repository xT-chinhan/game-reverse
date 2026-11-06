package com.byazt.ap;

import android.util.SparseArray;
import com.byazt.fvm.k;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1201, 21})
public class x {
    public final Function<SparseArray<Object>, Object> n;

    public x(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 124101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(k kVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, kVar);
        sparseArray.put(-99999987, 124102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 124104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg(k kVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, kVar);
        sparseArray.put(-99999987, 124103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
