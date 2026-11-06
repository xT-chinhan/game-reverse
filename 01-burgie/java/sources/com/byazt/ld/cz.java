package com.byazt.ld;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 213})
public class cz implements a, Function {
    public volatile a hw;
    public volatile Function pr;

    public cz(a aVar) {
        this.hw = aVar;
    }

    public cz(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object obj2 = sparseArray.get(1);
                this.hw.pr(((Integer) obj2).intValue(), sparseArray.get(2));
                break;
        }
        return null;
    }

    @Override // com.byazt.ld.a
    public void pr(int i, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        this.pr.apply(sparseArray);
    }
}
