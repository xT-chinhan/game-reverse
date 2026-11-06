package com.byazt.ihe;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 588, 13})
public class hw implements pr, Function {
    public volatile pr hw;
    public volatile Function pr;

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public hw(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                this.hw.pr((String) sparseArray.get(1));
                return null;
            case 2:
                return this.hw.hw();
            case 3:
                return this.hw.hn();
            case 4:
                return this.hw.x();
            case 5:
                return this.hw.pr();
            case 6:
                this.hw.c();
                return null;
            case 7:
                Object gVar = sparseArray.get(1);
                if (gVar != null) {
                    gVar = new g((Function) gVar);
                }
                return Boolean.valueOf(this.hw.pr((m) gVar));
            case 8:
                Object gVar2 = sparseArray.get(1);
                if (gVar2 != null) {
                    gVar2 = new g((Function) gVar2);
                }
                return Long.valueOf(this.hw.hw((m) gVar2));
            default:
                return null;
        }
    }

    @Override // com.byazt.ihe.pr
    public void c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.pr
    public String hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.pr
    public long hw(m mVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(1, mVar);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ihe.pr
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.pr
    public String pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.pr
    public void pr(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.pr
    public boolean pr(m mVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(1, mVar);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.pr
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.pr.apply(sparseArray);
    }
}
