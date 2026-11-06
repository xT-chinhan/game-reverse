package com.byazt.vf;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 36})
public class pk implements u, Function {
    public volatile Function n;
    public volatile u qg;

    public pk(u uVar) {
        this.qg = uVar;
    }

    public pk(Function function) {
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
                return n((String) sparseArray.get(1));
            }
            if (iIntValue == 2) {
                return Integer.valueOf(qg((String) sparseArray.get(1)));
            }
            if (iIntValue == 3) {
                return Long.valueOf(s((String) sparseArray.get(1)));
            }
            if (iIntValue == 4) {
                return Boolean.valueOf(q((String) sparseArray.get(1)));
            }
            if (iIntValue == 5) {
                n((String) sparseArray.get(1), (String) sparseArray.get(2));
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

    @Override // com.byazt.vf.u
    public String n(String str) {
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.u
    public void n(String str, String str2) {
        if (this.qg != null) {
            this.qg.n(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.u
    public boolean q(String str) {
        if (this.qg != null) {
            return this.qg.q(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.u
    public int qg(String str) {
        if (this.qg != null) {
            return this.qg.qg(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.u
    public long s(String str) {
        if (this.qg != null) {
            return this.qg.s(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }
}
