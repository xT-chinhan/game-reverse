package com.byazt.ihe;

import android.content.Context;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 588, 250})
public class k implements vk, Function {
    public volatile vk hw;
    public volatile Function pr;

    public k(vk vkVar) {
        this.hw = vkVar;
    }

    public k(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object obj2 = sparseArray.get(1);
                Object gVar = sparseArray.get(2);
                Object wVar = sparseArray.get(3);
                if (gVar != null) {
                    gVar = new g((Function) gVar);
                }
                if (wVar != null) {
                    wVar = new w((Function) wVar);
                }
                this.hw.pr((Context) obj2, (m) gVar, (vk.pr) wVar);
                break;
        }
        return null;
    }

    @Override // com.byazt.ihe.vk
    public void pr(Context context, m mVar, vk.pr prVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(2, mVar);
        if (prVar != null) {
            prVar = new w(prVar);
        }
        sparseArray.put(3, prVar);
        this.pr.apply(sparseArray);
    }
}
