package com.byazt.vf;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 984})
public class v implements lh, Function {
    public volatile Function n;
    public volatile lh qg;

    public v(lh lhVar) {
        this.qg = lhVar;
    }

    public v(Function function) {
        this.n = function;
    }

    @Override // com.byazt.vf.lh
    public String a() {
        if (this.qg != null) {
            return this.qg.a();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String an() {
        if (this.qg != null) {
            return this.qg.an();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 50);
        return (String) this.n.apply(sparseArray);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue != -4) {
            if (iIntValue == 1) {
                return n();
            }
            if (iIntValue == 3) {
                return Integer.valueOf(qg());
            }
            if (iIntValue == 4) {
                return s();
            }
            if (iIntValue == 5) {
                return q();
            }
            if (iIntValue == 20) {
                return hd();
            }
            if (iIntValue == 21) {
                return cd();
            }
            if (iIntValue == 25) {
                return um();
            }
            if (iIntValue == 26) {
                return a();
            }
            switch (iIntValue) {
                case 7:
                    return l();
                case 8:
                    return w();
                case 9:
                    return x();
                case 10:
                    return fs();
                case 11:
                    return Integer.valueOf(rv());
                case 12:
                    return tj();
                case 13:
                    return cp();
                case 14:
                    return d();
                case 15:
                    return oa();
                case 16:
                    return sz();
                case 17:
                    return k();
                case 18:
                    return cy();
                default:
                    switch (iIntValue) {
                        case 29:
                            return py();
                        case 30:
                            return ou();
                        case 31:
                            return Integer.valueOf(wm());
                        case 32:
                            return m();
                        case 33:
                            return Integer.valueOf(n(((Boolean) sparseArray.get(1)).booleanValue()));
                        case 34:
                            return hu();
                        case 35:
                            return qg(((Boolean) sparseArray.get(1)).booleanValue());
                        case 36:
                            return n((Boolean) sparseArray.get(1));
                        case 37:
                            return h();
                        case 38:
                            return qg((Boolean) sparseArray.get(1));
                        case 39:
                            return s((Boolean) sparseArray.get(1));
                        case 40:
                            return q((Boolean) sparseArray.get(1));
                        case 41:
                            return l((Boolean) sparseArray.get(1));
                        case 42:
                            return s(((Boolean) sparseArray.get(1)).booleanValue());
                        case 43:
                            return t();
                        case 44:
                            return ur();
                        case 45:
                            return bb();
                        case 46:
                            return Integer.valueOf(ln());
                        case 47:
                            return Integer.valueOf(lh());
                        case 48:
                            return Integer.valueOf(v());
                        case 49:
                            return j();
                        case 50:
                            return an();
                    }
            }
        }
        Function function = (Function) sparseArray.get(1);
        if (function != null) {
            this.n = function;
            this.qg = null;
        }
        return null;
    }

    @Override // com.byazt.vf.lh
    public String bb() {
        if (this.qg != null) {
            return this.qg.bb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String cd() {
        if (this.qg != null) {
            return this.qg.cd();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String cp() {
        if (this.qg != null) {
            return this.qg.cp();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String cy() {
        if (this.qg != null) {
            return this.qg.cy();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String d() {
        if (this.qg != null) {
            return this.qg.d();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
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

    @Override // com.byazt.vf.lh
    public String fs() {
        if (this.qg != null) {
            return this.qg.fs();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.n.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vf.lh
    public com.byazt.hsi.n h() {
        ?? qgVar;
        if (this.qg != null) {
            return this.qg.h();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            qgVar = Apply;
            qgVar = new com.byazt.hsi.qg((Function) Apply);
        }
        qgVar = Apply;
        return (com.byazt.hsi.n) qgVar;
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

    @Override // com.byazt.vf.lh
    public String hd() {
        if (this.qg != null) {
            return this.qg.hd();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String hu() {
        if (this.qg != null) {
            return this.qg.hu();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String j() {
        if (this.qg != null) {
            return this.qg.j();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 49);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String k() {
        if (this.qg != null) {
            return this.qg.k();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String l() {
        if (this.qg != null) {
            return this.qg.l();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String l(Boolean bool) {
        if (this.qg != null) {
            return this.qg.l(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public int lh() {
        if (this.qg != null) {
            return this.qg.lh();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 47);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.lh
    public int ln() {
        if (this.qg != null) {
            return this.qg.ln();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.lh
    public String m() {
        if (this.qg != null) {
            return this.qg.m();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public int n(boolean z) {
        if (this.qg != null) {
            return this.qg.n(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        sparseArray.put(1, Boolean.valueOf(z));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.lh
    public String n() {
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String n(Boolean bool) {
        if (this.qg != null) {
            return this.qg.n(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String oa() {
        if (this.qg != null) {
            return this.qg.oa();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String ou() {
        if (this.qg != null) {
            return this.qg.ou();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String py() {
        if (this.qg != null) {
            return this.qg.py();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String q() {
        if (this.qg != null) {
            return this.qg.q();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String q(Boolean bool) {
        if (this.qg != null) {
            return this.qg.q(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public int qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.lh
    public String qg(Boolean bool) {
        if (this.qg != null) {
            return this.qg.qg(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String[] qg(boolean z) {
        if (this.qg != null) {
            return this.qg.qg(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public int rv() {
        if (this.qg != null) {
            return this.qg.rv();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.lh
    public String s() {
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String s(Boolean bool) {
        if (this.qg != null) {
            return this.qg.s(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String s(boolean z) {
        if (this.qg != null) {
            return this.qg.s(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String sz() {
        if (this.qg != null) {
            return this.qg.sz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String t() {
        if (this.qg != null) {
            return this.qg.t();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String tj() {
        if (this.qg != null) {
            return this.qg.tj();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String um() {
        if (this.qg != null) {
            return this.qg.um();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public String ur() {
        if (this.qg != null) {
            return this.qg.ur();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public int v() {
        if (this.qg != null) {
            return this.qg.v();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 48);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.lh
    public String w() {
        if (this.qg != null) {
            return this.qg.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.lh
    public int wm() {
        if (this.qg != null) {
            return this.qg.wm();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.lh
    public String x() {
        if (this.qg != null) {
            return this.qg.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.n.apply(sparseArray);
    }
}
