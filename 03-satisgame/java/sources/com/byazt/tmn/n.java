package com.byazt.tmn;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2322, 19})
public class n {
    public final Function<SparseArray<Object>, Object> n;

    public n(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void s(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121105);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(boolean z, int i, String str, int i2, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(7);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, str2);
        sparseArray.put(-99999987, 121106);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(boolean z, int i, Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, bundle);
        sparseArray.put(-99999987, 121107);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void s() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121108);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
