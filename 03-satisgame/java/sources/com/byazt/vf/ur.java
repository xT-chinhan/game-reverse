package com.byazt.vf;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 1088})
public class ur implements t, Function {
    public volatile Function n;
    public volatile t qg;

    public ur(t tVar) {
        this.qg = tVar;
    }

    public ur(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue == -4) {
            Function function = (Function) sparseArray.get(1);
            if (function != null) {
                this.n = function;
                this.qg = null;
            }
        } else {
            if (iIntValue == 1) {
                return Integer.valueOf(n(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue()));
            }
            if (iIntValue == 2) {
                n(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue());
            } else {
                if (iIntValue == 3) {
                    return Boolean.valueOf(qg(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue()));
                }
                if (iIntValue == 4) {
                    n(((Integer) sparseArray.get(1)).intValue());
                }
            }
        }
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

    @Override // com.byazt.vf.t
    public int n(int i, int i2) {
        if (this.qg != null) {
            return this.qg.n(i, i2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.t
    public void n(int i) {
        if (this.qg != null) {
            this.qg.n(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.t
    public void n(int i, int i2, boolean z) {
        if (this.qg != null) {
            this.qg.n(i, i2, z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        sparseArray.put(3, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.t
    public boolean qg(int i, int i2, boolean z) {
        if (this.qg != null) {
            return this.qg.qg(i, i2, z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        sparseArray.put(3, Boolean.valueOf(z));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }
}
