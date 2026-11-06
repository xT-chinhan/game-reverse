package com.byazt.si;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, 793})
public class hu implements m, Function {
    public volatile Function n;
    public volatile m qg;

    public hu(m mVar) {
        this.qg = mVar;
    }

    public hu(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object hdVar = sparseArray.get(1);
            if (hdVar != null) {
                hdVar = new hd((Function) hdVar);
            }
            this.qg.n((cy) hdVar);
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        this.qg.n(((Integer) sparseArray.get(1)).intValue(), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
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

    @Override // com.byazt.si.m
    public void n(int i, String str, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, th);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.m
    public void n(cy cyVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (cyVar != null) {
            cyVar = new hd(cyVar);
        }
        sparseArray.put(1, cyVar);
        this.n.apply(sparseArray);
    }
}
