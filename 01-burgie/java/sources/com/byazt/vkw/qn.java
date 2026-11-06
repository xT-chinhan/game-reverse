package com.byazt.vkw;

import android.os.Message;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 467})
public class qn implements qi.pr, Function {
    public volatile qi.pr hw;
    public volatile Function pr;

    public qn(qi.pr prVar) {
        this.hw = prVar;
    }

    public qn(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                this.hw.pr((Message) sparseArray.get(1));
                break;
        }
        return null;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, message);
        this.pr.apply(sparseArray);
    }
}
