package com.byazt.rkl;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1319, 37})
public class pr {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Object obj) {
        this.pr = obj != null ? (Function) obj : com.byazt.ij.pr.hw;
    }

    public void pr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 223101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
