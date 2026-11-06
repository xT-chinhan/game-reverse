package com.byazt.yl;

import android.util.SparseArray;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1845, 13})
public class w implements l, Function {
    public volatile Function n;
    public volatile l qg;

    public w(l lVar) {
        this.qg = lVar;
    }

    public w(Function function) {
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
                Object qVar = sparseArray.get(1);
                if (qVar != null) {
                    qVar = new q((Function) qVar);
                }
                return n((s) qVar);
            }
            if (iIntValue == 2) {
                return n((File) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue());
            }
            if (iIntValue == 3) {
                Object qVar2 = sparseArray.get(1);
                if (qVar2 != null) {
                    qVar2 = new q((Function) qVar2);
                }
                return Boolean.valueOf(qg((s) qVar2));
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.byazt.yl.l
    public qg n(s sVar) {
        if (this.qg != null) {
            return this.qg.n(sVar);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (sVar != null) {
            sVar = new q(sVar);
        }
        sparseArray.put(1, sVar);
        ?? Apply = this.n.apply(sparseArray);
        ?? xVar = Apply;
        if (Apply != 0) {
            xVar = new x((Function) Apply);
        }
        return (qg) xVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.yl.l
    public qg n(File file, long j) {
        ?? xVar;
        if (this.qg != null) {
            return this.qg.n(file, j);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, file);
        sparseArray.put(2, Long.valueOf(j));
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            xVar = Apply;
            xVar = new x((Function) Apply);
        }
        xVar = Apply;
        return (qg) xVar;
    }

    @Override // com.byazt.yl.l
    public boolean qg(s sVar) {
        if (this.qg != null) {
            return this.qg.qg(sVar);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (sVar != null) {
            sVar = new q(sVar);
        }
        sparseArray.put(1, sVar);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }
}
