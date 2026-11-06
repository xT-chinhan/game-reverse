package com.byazt.ihe;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 588, 109})
public class w implements vk.pr, Function {
    public volatile vk.pr hw;
    public volatile Function pr;

    public w(vk.pr prVar) {
        this.hw = prVar;
    }

    public w(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object gVar = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (gVar != null) {
                    gVar = new g((Function) gVar);
                }
                this.hw.hw((m) gVar, ((Integer) obj2).intValue());
                break;
            case 2:
                Object gVar2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                Object obj4 = sparseArray.get(3);
                if (gVar2 != null) {
                    gVar2 = new g((Function) gVar2);
                }
                this.hw.pr((m) gVar2, ((Integer) obj3).intValue(), (String) obj4);
                break;
            case 3:
                Object gVar3 = sparseArray.get(1);
                Object obj5 = sparseArray.get(2);
                if (gVar3 != null) {
                    gVar3 = new g((Function) gVar3);
                }
                this.hw.pr((m) gVar3, ((Integer) obj5).intValue());
                break;
        }
        return null;
    }

    @Override // com.byazt.ihe.vk.pr
    public void hw(m mVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(1, mVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.vk.pr
    public void pr(m mVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(1, mVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.vk.pr
    public void pr(m mVar, int i, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(1, mVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, str);
        this.pr.apply(sparseArray);
    }
}
