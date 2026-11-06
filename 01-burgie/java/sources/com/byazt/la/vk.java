package com.byazt.la;

import android.util.SparseArray;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1119, 50})
public class vk implements aj, Function {
    public volatile aj hw;
    public volatile Function pr;

    public vk(aj ajVar) {
        this.hw = ajVar;
    }

    public vk(Function function) {
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
                return this.hw.hn();
            case 4:
                return Integer.valueOf(this.hw.x());
            case 5:
                return Integer.valueOf(this.hw.c());
            case 6:
                return this.hw.uc();
            case 7:
                return this.hw.fw();
            case 8:
                return this.hw.zo();
            default:
                return null;
        }
    }

    @Override // com.byazt.la.aj
    public int c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.la.aj
    public String fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.aj
    public String hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.aj
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.aj
    public String pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.aj
    public String uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.aj
    public int x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.la.aj
    public List zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (List) this.pr.apply(sparseArray);
    }
}
