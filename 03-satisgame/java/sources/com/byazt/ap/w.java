package com.byazt.ap;

import android.util.SparseArray;
import com.byazt.fvm.sz;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1201, 13})
public class w {
    public final Function<SparseArray<Object>, Object> n;

    public w(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 153101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(List<sz> list) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, list);
        sparseArray.put(-99999987, 153102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
