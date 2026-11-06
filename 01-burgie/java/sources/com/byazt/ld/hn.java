package com.byazt.ld;

import android.util.SparseArray;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 20})
public class hn implements hw, Function {
    public volatile hw hw;
    public volatile Function pr;

    public hn(hw hwVar) {
        this.hw = hwVar;
    }

    public hn(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Long.valueOf(this.hw.pr());
            case 2:
                return Integer.valueOf(this.hw.hw());
            case 3:
                return Boolean.valueOf(this.hw.hn());
            case 4:
                return Boolean.valueOf(this.hw.x());
            case 5:
                return this.hw.c();
            case 6:
                return Boolean.valueOf(this.hw.uc());
            case 7:
                return Integer.valueOf(this.hw.zo());
            case 8:
                return Boolean.valueOf(this.hw.fw());
            default:
                return null;
        }
    }

    @Override // com.byazt.ld.hw
    public File c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (File) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.hw
    public boolean fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ld.hw
    public boolean hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ld.hw
    public int hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ld.hw
    public long pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ld.hw
    public boolean uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ld.hw
    public boolean x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ld.hw
    public int zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }
}
