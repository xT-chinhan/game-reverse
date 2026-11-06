package com.byazt.vlp;

import android.util.SparseArray;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2172, 250})
public class k implements w, Function {
    public volatile w hw;
    public volatile Function pr;

    public k(w wVar) {
        this.hw = wVar;
    }

    public k(Function function) {
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
                return Boolean.valueOf(this.hw.hn());
            case 4:
                return Boolean.valueOf(this.hw.x());
            case 5:
                return Boolean.valueOf(this.hw.c());
            default:
                return null;
        }
    }

    @Override // com.byazt.vlp.w
    public boolean c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.w
    public boolean hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.w
    public List hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (List) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.w
    public List pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (List) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.w
    public boolean x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
