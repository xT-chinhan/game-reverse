package com.byazt.pis;

import android.util.SparseArray;
import com.byazt.mr.w;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1372, 121})
public class x {
    public final Function<SparseArray<Object>, Object> pr;

    public x(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public void pr(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 132101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr(w wVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, wVar);
        sparseArray.put(-99999987, 132102);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void hw() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 132104);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void hw(w wVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, wVar);
        sparseArray.put(-99999987, 132103);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
