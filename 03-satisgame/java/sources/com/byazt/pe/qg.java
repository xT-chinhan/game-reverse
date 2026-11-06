package com.byazt.pe;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 865, 26})
public class qg extends com.byazt.rzx.n {
    public final Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 131106);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void s() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131107);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void q() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131108);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void l() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131109);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void q(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, bundle);
        sparseArray.put(-99999987, 131110);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
