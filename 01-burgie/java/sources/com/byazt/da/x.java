package com.byazt.da;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1572, 121})
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
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hw.pr();
            case 2:
                return this.hw.hw();
            case 3:
                return this.hw.hn();
            case 4:
                return this.hw.x();
            case 5:
                this.hw.pr((Function<SparseArray<Object>, Object>) sparseArray.get(1));
                return null;
            case 6:
                return this.hw.c();
            case 7:
                this.hw.pr((String) sparseArray.get(1));
                return null;
            case 8:
                return this.hw.uc();
            case 9:
                return this.hw.fw();
            default:
                return null;
        }
    }

    @Override // com.byazt.da.hn
    public Function c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (Function) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.hn
    public String fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.hn
    public String hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.hn
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.hn
    public Function pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (Function) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.hn
    public void pr(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.hn
    public void pr(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, function);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.hn
    public String uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.da.hn
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.pr.apply(sparseArray);
    }
}
