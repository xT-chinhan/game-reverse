package com.byazt.vlp;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2172, 5})
public class uc implements c, Function {
    public volatile c hw;
    public volatile Function pr;

    public uc(c cVar) {
        this.hw = cVar;
    }

    public uc(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Double.valueOf(this.hw.pr());
            case 2:
                return Double.valueOf(this.hw.hw());
            default:
                return null;
        }
    }

    @Override // com.byazt.vlp.c
    public double hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Double) this.pr.apply(sparseArray)).doubleValue();
    }

    @Override // com.byazt.vlp.c
    public double pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Double) this.pr.apply(sparseArray)).doubleValue();
    }
}
