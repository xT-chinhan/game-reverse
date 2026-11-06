package com.byazt.ap;

import android.util.SparseArray;
import com.byazt.fvm.cp;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1201, 5})
public class q {
    public final Function<SparseArray<Object>, Object> n;

    public q(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 132101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(cp cpVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, cpVar);
        sparseArray.put(-99999987, 132102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 132104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg(cp cpVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, cpVar);
        sparseArray.put(-99999987, 132103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
