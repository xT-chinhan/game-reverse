package com.byazt.la;

import android.util.SparseArray;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1119, 121})
public class x implements hn, Function {
    public volatile hn hw;
    public volatile Function pr;

    public x(hn hnVar) {
        this.hw = hnVar;
    }

    public x(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Integer.valueOf(this.hw.pr());
            case 2:
                return this.hw.hw();
            case 3:
                return Integer.valueOf(this.hw.hn());
            case 4:
                return this.hw.x();
            case 5:
                return this.hw.c();
            default:
                return null;
        }
    }

    @Override // com.byazt.la.hn
    public List c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (List) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.hn
    public int hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.la.hn
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.hn
    public int pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.la.hn
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.pr.apply(sparseArray);
    }
}
