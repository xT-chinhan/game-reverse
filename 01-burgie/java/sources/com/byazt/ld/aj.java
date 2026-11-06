package com.byazt.ld;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 61})
public class aj implements zo, Function {
    public volatile zo hw;
    public volatile Function pr;

    public aj(zo zoVar) {
        this.hw = zoVar;
    }

    public aj(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Long.valueOf(this.hw.pr());
            case 2:
                return Long.valueOf(this.hw.hw());
            case 3:
                return Long.valueOf(this.hw.hn());
            default:
                return null;
        }
    }

    @Override // com.byazt.ld.zo
    public long hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ld.zo
    public long hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ld.zo
    public long pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }
}
