package com.byazt.kw;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1491, 37})
public class pr extends com.byazt.rf.pr {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }
}
