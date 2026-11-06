package com.byazt.tbi;

import android.util.SparseArray;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1862, 29})
public class cp implements tj, Function {
    public volatile Function n;
    public volatile tj qg;

    public cp(tj tjVar) {
        this.qg = tjVar;
    }

    public cp(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return this.qg.n();
        }
        if (iIntValue == 2) {
            return this.qg.qg();
        }
        if (iIntValue == 3) {
            return Boolean.valueOf(this.qg.s());
        }
        if (iIntValue == 4) {
            return Boolean.valueOf(this.qg.q());
        }
        if (iIntValue != 5) {
            return null;
        }
        return Boolean.valueOf(this.qg.l());
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

    @Override // com.byazt.tbi.tj
    public boolean l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.tj
    public List n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (List) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.tj
    public boolean q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.tj
    public List qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (List) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.tj
    public boolean s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }
}
