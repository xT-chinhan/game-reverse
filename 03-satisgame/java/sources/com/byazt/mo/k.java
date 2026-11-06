package com.byazt.mo;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 210})
public class k {
    public static Function<SparseArray<Object>, Object> n(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        return com.byazt.qvu.s.qg;
    }

    public static Integer[] n(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }
}
