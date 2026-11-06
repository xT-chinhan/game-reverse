package com.byazt.zve;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2318, 18})
public class l implements qg, Function {
    public volatile Function n;
    public volatile qg qg;

    public l(qg qgVar) {
        this.qg = qgVar;
    }

    public l(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return this.qg.n();
        }
        if (iIntValue == 2) {
            return Boolean.valueOf(this.qg.qg());
        }
        if (iIntValue != 3) {
            return null;
        }
        return Long.valueOf(this.qg.s());
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

    @Override // com.byazt.zve.qg
    public String n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.zve.qg
    public boolean qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.zve.qg
    public long s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }
}
