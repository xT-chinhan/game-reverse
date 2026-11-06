package com.byazt.cr;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1991, 13})
public class hw implements pr, Function {
    public volatile pr hw;
    public volatile Function pr;

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public hw(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hw.pr(sparseArray.get(1));
            default:
                return null;
        }
    }

    @Override // com.byazt.cr.pr
    public Object pr(Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, obj);
        return this.pr.apply(sparseArray);
    }
}
