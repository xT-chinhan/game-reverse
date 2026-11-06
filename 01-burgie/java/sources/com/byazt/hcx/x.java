package com.byazt.hcx;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1225, 121})
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
                return Boolean.valueOf(this.hw.pr());
            case 2:
                return Integer.valueOf(this.hw.hw());
            case 3:
                return this.hw.hn();
            case 4:
                return Boolean.valueOf(this.hw.x());
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

    @Override // com.byazt.hcx.hn
    public byte[] c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (byte[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.hn
    public Throwable fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (Throwable) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.hn
    public String hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.hn
    public int hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.hcx.hn
    public boolean pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.hcx.hn
    public String uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.hn
    public boolean x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
