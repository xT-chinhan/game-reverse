package com.byazt.tbi;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1862, 26})
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
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.qg.n());
            case 2:
                q qVarQg = this.qg.qg();
                return qVarQg != null ? new l(qVarQg) : qVarQg;
            case 3:
                return Boolean.valueOf(this.qg.s());
            case 4:
                return Boolean.valueOf(this.qg.q());
            case 5:
                return this.qg.l();
            case 6:
                return Boolean.valueOf(this.qg.w());
            case 7:
                return this.qg.x();
            case 8:
                return Boolean.valueOf(this.qg.fs());
            case 9:
                return this.qg.rv();
            case 10:
                return Boolean.valueOf(this.qg.tj());
            case 11:
                tj tjVarCp = this.qg.cp();
                return tjVarCp != null ? new cp(tjVarCp) : tjVarCp;
            case 12:
                return this.qg.d();
            case 13:
                return Boolean.valueOf(this.qg.oa());
            case 14:
                return this.qg.sz();
            case 15:
                return Boolean.valueOf(this.qg.k());
            case 16:
                return Boolean.valueOf(this.qg.n(((Integer) sparseArray.get(1)).intValue()));
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.tbi.n
    public tj cp() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.n.apply(sparseArray);
        ?? cpVar = Apply;
        if (Apply != 0) {
            cpVar = new cp((Function) Apply);
        }
        return (tj) cpVar;
    }

    @Override // com.byazt.tbi.n
    public String d() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.n.apply(sparseArray);
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

    @Override // com.byazt.tbi.n
    public boolean fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
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

    @Override // com.byazt.tbi.n
    public boolean k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.n
    public String l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.n
    public boolean n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.n
    public boolean n(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, Integer.valueOf(i));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.n
    public boolean oa() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.n
    public boolean q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.tbi.n
    public q qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        ?? Apply = this.n.apply(sparseArray);
        ?? lVar = Apply;
        if (Apply != 0) {
            lVar = new l((Function) Apply);
        }
        return (q) lVar;
    }

    @Override // com.byazt.tbi.n
    public String rv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.n
    public boolean s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.n
    public Map sz() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (Map) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.n
    public boolean tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.n
    public boolean w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.n
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.n.apply(sparseArray);
    }
}
