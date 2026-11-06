package com.byazt.ld;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 672})
public class gz implements ve, Function {
    public volatile ve hw;
    public volatile Function pr;

    public gz(ve veVar) {
        this.hw = veVar;
    }

    public gz(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return this.hw.pr();
            case 2:
                return this.hw.hw();
            case 3:
                return Integer.valueOf(this.hw.hn());
            case 4:
                return Integer.valueOf(this.hw.x());
            case 5:
                return this.hw.c();
            default:
                return null;
        }
    }

    @Override // com.byazt.ld.ve
    public SparseArray c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (SparseArray) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.ve
    public int hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ld.ve
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.ve
    public String pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.ve
    public int x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }
}
