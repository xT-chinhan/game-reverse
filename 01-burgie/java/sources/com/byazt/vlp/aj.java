package com.byazt.vlp;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2172, 61})
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
                return this.hw.pr();
            case 2:
                return this.hw.hw();
            case 3:
                return this.hw.hn();
            case 4:
                return Integer.valueOf(this.hw.x());
            case 5:
                return this.hw.c();
            case 6:
                return this.hw.uc();
            case 7:
                return this.hw.fw();
            default:
                return null;
        }
    }

    @Override // com.byazt.vlp.zo
    public String c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.zo
    public Map fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.zo
    public String hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.zo
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.zo
    public String pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.zo
    public String uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.zo
    public int x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }
}
