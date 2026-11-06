package com.byazt.vf;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 26})
public class qg implements n, Function {
    public volatile Function n;
    public volatile n qg;

    public qg(n nVar) {
        this.qg = nVar;
    }

    public qg(Function function) {
        this.n = function;
    }

    @Override // com.byazt.vf.n
    public String a() {
        if (this.qg != null) {
            return this.qg.a();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        return (String) this.n.apply(sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue != -4) {
            switch (iIntValue) {
                case 2:
                    return n();
                case 3:
                    return Boolean.valueOf(qg());
                case 4:
                    return n((String) sparseArray.get(1));
                case 5:
                    return s();
                case 6:
                    return Boolean.valueOf(q());
                case 7:
                    return l();
                case 8:
                    return w();
                case 9:
                    return Integer.valueOf(x());
                case 10:
                    return Boolean.valueOf(fs());
                case 11:
                    return Boolean.valueOf(rv());
                case 12:
                    return tj();
                case 13:
                    return cp();
                case 14:
                    return Integer.valueOf(d());
                case 15:
                    return Integer.valueOf(oa());
                case 16:
                    return Integer.valueOf(sz());
                case 17:
                    return k();
                case 18:
                    return Boolean.valueOf(cy());
                case 19:
                    return hd();
                case 20:
                    n((SparseArray) sparseArray.get(1));
                    break;
                case 21:
                    return cd();
                case 22:
                    return um();
                case 23:
                    return a();
                case 24:
                    return py();
                case 25:
                    return Boolean.valueOf(ou());
                case 26:
                    return wm();
                case 27:
                    return qg((String) sparseArray.get(1));
            }
        } else {
            Function function = (Function) sparseArray.get(1);
            if (function != null) {
                this.n = function;
                this.qg = null;
            }
        }
        return null;
    }

    @Override // com.byazt.vf.n
    public String cd() {
        if (this.qg != null) {
            return this.qg.cd();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return (String) this.n.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vf.n
    public com.byazt.tbi.n cp() {
        ?? qgVar;
        if (this.qg != null) {
            return this.qg.cp();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            qgVar = Apply;
            qgVar = new com.byazt.tbi.qg((Function) Apply);
        }
        qgVar = Apply;
        return (com.byazt.tbi.n) qgVar;
    }

    @Override // com.byazt.vf.n
    public boolean cy() {
        if (this.qg != null) {
            return this.qg.cy();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.n
    public int d() {
        if (this.qg != null) {
            return this.qg.d();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
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

    @Override // com.byazt.vf.n
    public boolean fs() {
        if (this.qg != null) {
            return this.qg.fs();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
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

    @Override // com.byazt.vf.n
    public Map hd() {
        if (this.qg != null) {
            return this.qg.hd();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return (Map) this.n.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vf.n
    public com.byazt.tbi.w k() {
        ?? rvVar;
        if (this.qg != null) {
            return this.qg.k();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            rvVar = Apply;
            rvVar = new com.byazt.tbi.rv((Function) Apply);
        }
        rvVar = Apply;
        return (com.byazt.tbi.w) rvVar;
    }

    @Override // com.byazt.vf.n
    public String l() {
        if (this.qg != null) {
            return this.qg.l();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public Object n(String str) {
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public String n() {
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public void n(SparseArray sparseArray) {
        if (this.qg != null) {
            this.qg.n(sparseArray);
            return;
        }
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(0, 20);
        sparseArray2.put(1, sparseArray);
        this.n.apply(sparseArray2);
    }

    @Override // com.byazt.vf.n
    public int oa() {
        if (this.qg != null) {
            return this.qg.oa();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.n
    public boolean ou() {
        if (this.qg != null) {
            return this.qg.ou();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.n
    public String py() {
        if (this.qg != null) {
            return this.qg.py();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public boolean q() {
        if (this.qg != null) {
            return this.qg.q();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    public Object qg(String str) {
        return com.byazt.qp.q.n(str, this);
    }

    @Override // com.byazt.vf.n
    public boolean qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.n
    public boolean rv() {
        if (this.qg != null) {
            return this.qg.rv();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.n
    public String s() {
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public int sz() {
        if (this.qg != null) {
            return this.qg.sz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.n
    public int[] tj() {
        if (this.qg != null) {
            return this.qg.tj();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (int[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public String um() {
        if (this.qg != null) {
            return this.qg.um();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public String w() {
        if (this.qg != null) {
            return this.qg.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public String wm() {
        if (this.qg != null) {
            return this.qg.wm();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.n
    public int x() {
        if (this.qg != null) {
            return this.qg.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }
}
