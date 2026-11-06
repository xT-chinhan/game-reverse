package com.byazt.kv;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1533, 19})
public class n {
    public static com.byazt.qn.qg n(int i, com.byazt.pch.n nVar, Function<SparseArray<Object>, Object> function) {
        if (nVar == null) {
            return null;
        }
        com.byazt.zs.n.n().n(function);
        return new com.byazt.qn.qg(i, nVar.lh(), nVar.an());
    }
}
