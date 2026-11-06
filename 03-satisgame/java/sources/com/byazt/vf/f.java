package com.byazt.vf;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 990})
public class f implements ae, Function {
    public volatile Function n;
    public volatile ae qg;

    public f(ae aeVar) {
        this.qg = aeVar;
    }

    public f(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue != -4) {
            switch (iIntValue) {
                case 1:
                    Object objQg = sparseArray.get(1);
                    Object obj2 = sparseArray.get(2);
                    if (objQg != null) {
                        objQg = com.byazt.qp.q.qg((String) objQg);
                    }
                    return n((n) objQg, (String) obj2);
                case 2:
                    Object objQg2 = sparseArray.get(1);
                    Object obj3 = sparseArray.get(2);
                    if (objQg2 != null) {
                        objQg2 = com.byazt.qp.q.qg((String) objQg2);
                    }
                    return qg((n) objQg2, (String) obj3);
                case 3:
                    Object objQg3 = sparseArray.get(1);
                    Object obj4 = sparseArray.get(2);
                    if (objQg3 != null) {
                        objQg3 = com.byazt.qp.q.qg((String) objQg3);
                    }
                    return s((n) objQg3, (String) obj4);
                case 4:
                    Object objQg4 = sparseArray.get(1);
                    Object obj5 = sparseArray.get(2);
                    Object obj6 = sparseArray.get(3);
                    Object obj7 = sparseArray.get(4);
                    if (objQg4 != null) {
                        objQg4 = com.byazt.qp.q.qg((String) objQg4);
                    }
                    return n((n) objQg4, (String) obj5, ((Integer) obj6).intValue(), (Map) obj7);
                case 5:
                    Object objQg5 = sparseArray.get(1);
                    Object obj8 = sparseArray.get(2);
                    Object obj9 = sparseArray.get(3);
                    Object obj10 = sparseArray.get(4);
                    if (objQg5 != null) {
                        objQg5 = com.byazt.qp.q.qg((String) objQg5);
                    }
                    return qg((n) objQg5, (String) obj8, ((Integer) obj9).intValue(), (Map) obj10);
                case 6:
                    Object objQg6 = sparseArray.get(1);
                    Object obj11 = sparseArray.get(2);
                    Object obj12 = sparseArray.get(3);
                    Object obj13 = sparseArray.get(4);
                    if (objQg6 != null) {
                        objQg6 = com.byazt.qp.q.qg((String) objQg6);
                    }
                    return s((n) objQg6, (String) obj11, ((Integer) obj12).intValue(), (Map) obj13);
            }
        }
        Function function = (Function) sparseArray.get(1);
        if (function != null) {
            this.n = function;
            this.qg = null;
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
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.vf.ae
    public com.byazt.gwu.l n(n nVar, String str) {
        if (this.qg != null) {
            return this.qg.n(nVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, nVar != null ? nVar.n() : null);
        sparseArray.put(2, str);
        ?? Apply = this.n.apply(sparseArray);
        ?? wVar = Apply;
        if (Apply != 0) {
            wVar = new com.byazt.gwu.w((Function) Apply);
        }
        return (com.byazt.gwu.l) wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.byazt.vf.ae
    public com.byazt.gwu.l n(n nVar, String str, int i, Map map) {
        if (this.qg != null) {
            return this.qg.n(nVar, str, i, map);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, nVar != null ? nVar.n() : null);
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, map);
        ?? Apply = this.n.apply(sparseArray);
        ?? wVar = Apply;
        if (Apply != 0) {
            wVar = new com.byazt.gwu.w((Function) Apply);
        }
        return (com.byazt.gwu.l) wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.vf.ae
    public com.byazt.gwu.s qg(n nVar, String str) {
        if (this.qg != null) {
            return this.qg.qg(nVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, nVar != null ? nVar.n() : null);
        sparseArray.put(2, str);
        ?? Apply = this.n.apply(sparseArray);
        ?? qVar = Apply;
        if (Apply != 0) {
            qVar = new com.byazt.gwu.q((Function) Apply);
        }
        return (com.byazt.gwu.s) qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.vf.ae
    public com.byazt.gwu.s qg(n nVar, String str, int i, Map map) {
        if (this.qg != null) {
            return this.qg.qg(nVar, str, i, map);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, nVar != null ? nVar.n() : null);
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, map);
        ?? Apply = this.n.apply(sparseArray);
        ?? qVar = Apply;
        if (Apply != 0) {
            qVar = new com.byazt.gwu.q((Function) Apply);
        }
        return (com.byazt.gwu.s) qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.vf.ae
    public com.byazt.gwu.x s(n nVar, String str) {
        if (this.qg != null) {
            return this.qg.s(nVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, nVar != null ? nVar.n() : null);
        sparseArray.put(2, str);
        ?? Apply = this.n.apply(sparseArray);
        ?? fsVar = Apply;
        if (Apply != 0) {
            fsVar = new com.byazt.gwu.fs((Function) Apply);
        }
        return (com.byazt.gwu.x) fsVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.vf.ae
    public com.byazt.gwu.x s(n nVar, String str, int i, Map map) {
        if (this.qg != null) {
            return this.qg.s(nVar, str, i, map);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, nVar != null ? nVar.n() : null);
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, map);
        ?? Apply = this.n.apply(sparseArray);
        ?? fsVar = Apply;
        if (Apply != 0) {
            fsVar = new com.byazt.gwu.fs((Function) Apply);
        }
        return (com.byazt.gwu.x) fsVar;
    }
}
