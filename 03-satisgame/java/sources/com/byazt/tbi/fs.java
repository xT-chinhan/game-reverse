package com.byazt.tbi;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1862, 101})
public class fs implements x, Function {
    public volatile Function n;
    public volatile x qg;

    public fs(x xVar) {
        this.qg = xVar;
    }

    public fs(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return this.qg.n();
            case 2:
                return this.qg.qg();
            case 3:
                return this.qg.s();
            case 4:
                return Integer.valueOf(this.qg.q());
            case 5:
                return this.qg.l();
            case 6:
                return this.qg.w();
            case 7:
                return this.qg.x();
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

    @Override // com.byazt.tbi.x
    public String l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.x
    public String n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.x
    public int q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.tbi.x
    public String qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.x
    public String s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.x
    public String w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.x
    public Map x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (Map) this.n.apply(sparseArray);
    }
}
