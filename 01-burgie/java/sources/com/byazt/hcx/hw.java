package com.byazt.hcx;

import android.util.SparseArray;
import java.io.InputStream;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1225, 13})
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
                return this.hw.pr((InputStream) sparseArray.get(1));
            default:
                return null;
        }
    }

    @Override // com.byazt.hcx.pr
    public Object pr(InputStream inputStream) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, inputStream);
        return this.pr.apply(sparseArray);
    }
}
