package com.byazt.zh;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1161, 5})
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
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.qg.n();
            case 2:
                return this.qg.qg();
            case 3:
                return this.qg.s();
            case 4:
                return this.qg.q();
            case 5:
                this.qg.n((Function<SparseArray<Object>, Object>) sparseArray.get(1));
                return null;
            case 6:
                return this.qg.l();
            case 7:
                this.qg.n((String) sparseArray.get(1));
                return null;
            case 8:
                return this.qg.w();
            case 9:
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

    @Override // com.byazt.zh.s
    public Function l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (Function) this.n.apply(sparseArray);
    }

    @Override // com.byazt.zh.s
    public Function n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (Function) this.n.apply(sparseArray);
    }

    @Override // com.byazt.zh.s
    public void n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.zh.s
    public void n(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, function);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.zh.s
    public String q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.zh.s
    public String qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.zh.s
    public String s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.zh.s
    public String w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.zh.s
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.n.apply(sparseArray);
    }
}
