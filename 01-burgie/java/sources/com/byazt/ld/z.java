package com.byazt.ld;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 110})
public class z implements rc, Function {
    public volatile rc hw;
    public volatile Function pr;

    public z(rc rcVar) {
        this.hw = rcVar;
    }

    public z(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object ybVar = sparseArray.get(1);
                if (ybVar != null) {
                    ybVar = new yb((Function) ybVar);
                }
                this.hw.pr((nt) ybVar);
                break;
            case 2:
                this.hw.pr(((Integer) sparseArray.get(1)).intValue(), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
                break;
        }
        return null;
    }

    @Override // com.byazt.ld.rc
    public void pr(int i, String str, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, th);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.rc
    public void pr(nt ntVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (ntVar != null) {
            ntVar = new yb(ntVar);
        }
        sparseArray.put(1, ntVar);
        this.pr.apply(sparseArray);
    }
}
