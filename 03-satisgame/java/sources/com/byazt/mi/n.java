package com.byazt.mi;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 794, 19})
public class n {
    public final Function<SparseArray<Object>, Object> n;

    public n(Object obj) {
        this.n = obj != null ? (Function) obj : com.byazt.qvu.n.qg;
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 223101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
