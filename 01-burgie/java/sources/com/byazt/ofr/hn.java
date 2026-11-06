package com.byazt.ofr;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1195, 20})
public class hn {
    public hw hw;
    public final Function<SparseArray<Object>, Object> pr;

    public hn(Function<SparseArray<Object>, Object> function) {
        this.pr = function;
    }

    public void pr(int i, SparseArray<Object> sparseArray) {
        if ((!com.byazt.ij.pr.pr(sparseArray).hw().booleanValue(-999903) || i != 8001 || this.hw == null) && this.pr != null) {
            this.pr.apply(com.byazt.xi.hw.pr().pr(i).pr(Void.class).pr(-99999979, sparseArray).hw());
        }
    }
}
