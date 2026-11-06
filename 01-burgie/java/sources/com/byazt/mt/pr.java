package com.byazt.mt;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1528, 37})
public class pr {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public int pr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 271027);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    public int hw() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 271032);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }
}
