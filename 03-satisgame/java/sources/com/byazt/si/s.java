package com.byazt.si;

import android.util.SparseArray;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, 8})
public class s implements qg, Function {
    public volatile Function n;
    public volatile qg qg;

    public s(qg qgVar) {
        this.qg = qgVar;
    }

    public s(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Long.valueOf(this.qg.n());
            case 2:
                return Integer.valueOf(this.qg.qg());
            case 3:
                return Boolean.valueOf(this.qg.s());
            case 4:
                return Boolean.valueOf(this.qg.q());
            case 5:
                return this.qg.l();
            case 6:
                return Boolean.valueOf(this.qg.w());
            case 7:
                return Integer.valueOf(this.qg.fs());
            case 8:
                return Boolean.valueOf(this.qg.x());
            default:
                return null;
        }
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

    @Override // com.byazt.si.qg
    public int fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
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

    @Override // com.byazt.si.qg
    public File l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (File) this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.qg
    public long n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.si.qg
    public boolean q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.si.qg
    public int qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.si.qg
    public boolean s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.si.qg
    public boolean w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.si.qg
    public boolean x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }
}
