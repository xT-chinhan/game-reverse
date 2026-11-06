package com.byazt.mi;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 794, 8})
public class s {
    public final Function<SparseArray<Object>, Object> n;

    public s(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 221101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(long j, long j2, String str, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg(long j, long j2, String str, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void s(long j, long j2, String str, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(long j, String str, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(-99999987, 221105);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(String str, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, str);
        sparseArray.put(1, str2);
        sparseArray.put(-99999987, 221106);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
