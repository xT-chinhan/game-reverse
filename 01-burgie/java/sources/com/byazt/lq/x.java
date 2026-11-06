package com.byazt.lq;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 595, 121})
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
                Object cVar = sparseArray.get(1);
                if (cVar != null) {
                    cVar = new c((Function) cVar);
                }
                this.hw.pr((hw) cVar);
                break;
        }
        return null;
    }

    @Override // com.byazt.lq.hn
    public void pr(hw hwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (hwVar != null) {
            hwVar = new c(hwVar);
        }
        sparseArray.put(1, hwVar);
        this.pr.apply(sparseArray);
    }
}
