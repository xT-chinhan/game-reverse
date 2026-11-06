package com.byazt.tbi;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1862, 18})
public class l implements q, Function {
    public volatile Function n;
    public volatile q qg;

    public l(q qVar) {
        this.qg = qVar;
    }

    public l(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return Double.valueOf(this.qg.n());
        }
        if (iIntValue != 2) {
            return null;
        }
        return Double.valueOf(this.qg.qg());
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

    @Override // com.byazt.tbi.q
    public double n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Double) objApply).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.byazt.tbi.q
    public double qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Double) objApply).doubleValue();
        }
        return 0.0d;
    }
}
