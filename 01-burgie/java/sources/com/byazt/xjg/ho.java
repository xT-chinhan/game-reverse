package com.byazt.xjg;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 12, 19})
public class ho {
    public static Function<SparseArray<Object>, Object> pr(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        return com.byazt.ij.hn.hw;
    }

    public static Integer[] pr(int[] iArr) {
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
