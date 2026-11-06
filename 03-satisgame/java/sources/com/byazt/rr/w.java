package com.byazt.rr;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 180, 13})
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
        if (iIntValue == 15) {
            com.byazt.vf.n nVarTj = this.qg.tj();
            return nVarTj != null ? new com.byazt.vf.qg(nVarTj) : nVarTj;
        }
        if (iIntValue == 16) {
            Object obj2 = sparseArray.get(1);
            Object qVar = sparseArray.get(2);
            Object obj3 = sparseArray.get(3);
            if (qVar != null) {
                qVar = new q((Function) qVar);
            }
            this.qg.n(((Boolean) obj2).booleanValue(), (s) qVar, (JSONObject) obj3);
            return null;
        }
        switch (iIntValue) {
            case 1:
                Object obj4 = sparseArray.get(1);
                Object qVar2 = sparseArray.get(2);
                if (qVar2 != null) {
                    qVar2 = new q((Function) qVar2);
                }
                this.qg.n(((Boolean) obj4).booleanValue(), (s) qVar2);
                return null;
            case 2:
                return this.qg.n();
            case 3:
                return Boolean.valueOf(this.qg.qg());
            case 4:
                return Integer.valueOf(this.qg.s());
            case 5:
                return this.qg.q();
            case 6:
                return Boolean.valueOf(this.qg.l());
            case 7:
                return this.qg.w();
            case 8:
                this.qg.n((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                return null;
            case 9:
                return this.qg.x();
            case 10:
                return this.qg.fs();
            case 11:
                this.qg.rv();
                return null;
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

    @Override // com.byazt.rr.l
    public String fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.n.apply(sparseArray);
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

    @Override // com.byazt.rr.l
    public boolean l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.rr.l
    public String n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.rr.l
    public void n(String str, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.rr.l
    public void n(boolean z, s sVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Boolean.valueOf(z));
        if (sVar != null) {
            sVar = new q(sVar);
        }
        sparseArray.put(2, sVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.rr.l
    public void n(boolean z, s sVar, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, Boolean.valueOf(z));
        if (sVar != null) {
            sVar = new q(sVar);
        }
        sparseArray.put(2, sVar);
        sparseArray.put(3, jSONObject);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.rr.l
    public String q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.rr.l
    public boolean qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.rr.l
    public void rv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.rr.l
    public int s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.rr.l
    public com.byazt.vf.n tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        ?? Apply = this.n.apply(sparseArray);
        ?? qgVar = Apply;
        if (Apply != 0) {
            qgVar = new com.byazt.vf.qg((Function) Apply);
        }
        return (com.byazt.vf.n) qgVar;
    }

    @Override // com.byazt.rr.l
    public String w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.rr.l
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.n.apply(sparseArray);
    }
}
