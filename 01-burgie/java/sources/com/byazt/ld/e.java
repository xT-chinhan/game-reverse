package com.byazt.ld;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 105})
public class e implements n, Function {
    public volatile n hw;
    public volatile Function pr;

    public e(n nVar) {
        this.hw = nVar;
    }

    public e(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object obj2 = sparseArray.get(1);
                Object mVar = sparseArray.get(2);
                if (mVar != null) {
                    mVar = new m((Function) mVar);
                }
                this.hw.pr((String) obj2, (k) mVar);
                break;
            case 2:
                Object obj3 = sparseArray.get(1);
                Object mVar2 = sparseArray.get(2);
                if (mVar2 != null) {
                    mVar2 = new m((Function) mVar2);
                }
                this.hw.hw((String) obj3, (k) mVar2);
                break;
        }
        return null;
    }

    @Override // com.byazt.ld.n
    public void hw(String str, k kVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        if (kVar != null) {
            kVar = new m(kVar);
        }
        sparseArray.put(2, kVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.n
    public void pr(String str, k kVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        if (kVar != null) {
            kVar = new m(kVar);
        }
        sparseArray.put(2, kVar);
        this.pr.apply(sparseArray);
    }
}
