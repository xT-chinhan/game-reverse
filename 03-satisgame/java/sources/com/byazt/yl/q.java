package com.byazt.yl;

import android.util.SparseArray;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1845, 5})
public class q implements s, Function {
    public volatile Function n;
    public volatile s qg;

    public q(s sVar) {
        this.qg = sVar;
    }

    public q(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return this.qg.n();
        }
        if (iIntValue != 2) {
            return null;
        }
        return Long.valueOf(this.qg.qg());
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

    @Override // com.byazt.yl.s
    public File n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (File) this.n.apply(sparseArray);
    }

    @Override // com.byazt.yl.s
    public long qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }
}
