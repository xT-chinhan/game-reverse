package com.byazt.he;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1744, 8})
public class s {
    public final Function<SparseArray<Object>, Object> n;

    public s(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public String n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 267001);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    public String qg() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 267002);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    public String s() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 267003);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    public String q() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 267004);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }
}
