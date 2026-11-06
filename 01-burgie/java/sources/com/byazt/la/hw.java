package com.byazt.la;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1119, 13})
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
                Object obj2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                Object vkVar = sparseArray.get(3);
                Object xVar = sparseArray.get(4);
                if (vkVar != null) {
                    vkVar = new vk((Function) vkVar);
                }
                if (xVar != null) {
                    xVar = new x((Function) xVar);
                }
                this.hw.pr((String) obj2, ((Boolean) obj3).booleanValue(), (aj) vkVar, (hn) xVar);
                break;
        }
        return null;
    }

    @Override // com.byazt.la.pr
    public void pr(String str, boolean z, aj ajVar, hn hnVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        if (ajVar != null) {
            ajVar = new vk(ajVar);
        }
        sparseArray.put(3, ajVar);
        if (hnVar != null) {
            hnVar = new x(hnVar);
        }
        sparseArray.put(4, hnVar);
        this.pr.apply(sparseArray);
    }
}
