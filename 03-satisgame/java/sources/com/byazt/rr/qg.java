package com.byazt.rr;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 180, 26})
public class qg implements n, Function {
    public volatile Function n;
    public volatile n qg;

    public qg(n nVar) {
        this.qg = nVar;
    }

    public qg(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        Object obj2 = sparseArray.get(1);
        Object obj3 = sparseArray.get(2);
        Object tjVar = sparseArray.get(3);
        Object qVar = sparseArray.get(4);
        if (tjVar != null) {
            tjVar = new tj((Function) tjVar);
        }
        if (qVar != null) {
            qVar = new q((Function) qVar);
        }
        this.qg.n((String) obj2, ((Boolean) obj3).booleanValue(), (rv) tjVar, (s) qVar);
        return null;
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        if (this.n != null) {
            obj2 = this.n;
        } else {
            if (this.qg == null) {
                return super.equals(obj);
            }
            obj2 = this.qg;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        Object obj;
        if (this.n != null) {
            obj = this.n;
        } else {
            if (this.qg == null) {
                return super.hashCode();
            }
            obj = this.qg;
        }
        return obj.hashCode();
    }

    @Override // com.byazt.rr.n
    public void n(String str, boolean z, rv rvVar, s sVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        if (rvVar != null) {
            rvVar = new tj(rvVar);
        }
        sparseArray.put(3, rvVar);
        if (sVar != null) {
            sVar = new q(sVar);
        }
        sparseArray.put(4, sVar);
        this.n.apply(sparseArray);
    }
}
