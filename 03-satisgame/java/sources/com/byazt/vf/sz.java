package com.byazt.vf;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 110})
public class sz implements oa, Function {
    public volatile Function n;
    public volatile oa qg;

    public sz(oa oaVar) {
        this.qg = oaVar;
    }

    public sz(Function function) {
        this.n = function;
    }

    @Override // com.byazt.vf.oa
    public int a() {
        if (this.qg != null) {
            return this.qg.a();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.oa
    public boolean an() {
        if (this.qg != null) {
            return this.qg.an();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 48);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
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
                case 1:
                    return n();
                case 2:
                    return qg();
                case 3:
                    return s();
                case 4:
                    return q();
                case 5:
                    return l();
                case 6:
                    return w();
                case 7:
                    return x();
                case 8:
                    return Integer.valueOf(fs());
                case 9:
                    return rv();
                case 10:
                    return tj();
                case 11:
                    return cp();
                case 12:
                    return d();
                case 13:
                    return oa();
                case 14:
                    return sz();
                case 15:
                    return k();
                case 16:
                    return cy();
                case 17:
                    return hd();
                case 18:
                    return Integer.valueOf(cd());
                case 19:
                    return Integer.valueOf(n(((Boolean) sparseArray.get(1)).booleanValue()));
                case 20:
                    return qg(((Boolean) sparseArray.get(1)).booleanValue());
                case 21:
                    return s(((Boolean) sparseArray.get(1)).booleanValue());
                case 22:
                    return n((Boolean) sparseArray.get(1));
                case 23:
                    return q(((Boolean) sparseArray.get(1)).booleanValue());
                case 24:
                    return qg((Boolean) sparseArray.get(1));
                case 25:
                    return s((Boolean) sparseArray.get(1));
                case 26:
                    return q((Boolean) sparseArray.get(1));
                case 27:
                    return l((Boolean) sparseArray.get(1));
                case 28:
                    return um();
                case 29:
                    return Integer.valueOf(a());
                case 30:
                    return Integer.valueOf(py());
                case 31:
                    return Integer.valueOf(ou());
                case 32:
                    return wm();
                case 33:
                    return m();
                case 34:
                    return hu();
                case 35:
                    return h();
                case 36:
                    return Integer.valueOf(n(((Long) sparseArray.get(1)).longValue()));
                case 37:
                    Object lVar = sparseArray.get(1);
                    if (lVar != null) {
                        lVar = new com.byazt.hsi.l((Function) lVar);
                    }
                    n((com.byazt.hsi.s) lVar);
                    break;
                case 38:
                    Object lVar2 = sparseArray.get(1);
                    if (lVar2 != null) {
                        lVar2 = new com.byazt.hsi.l((Function) lVar2);
                    }
                    qg((com.byazt.hsi.s) lVar2);
                    break;
                case 39:
                    return t();
                case 40:
                    return Boolean.valueOf(ur());
                case 41:
                    return Float.valueOf(bb());
                case 42:
                    return l(((Boolean) sparseArray.get(1)).booleanValue());
                case 43:
                    return n(((Integer) sparseArray.get(1)).intValue());
                case 44:
                    return ln();
                case 45:
                    return lh();
                case 46:
                    return Long.valueOf(v());
                case 47:
                    return Boolean.valueOf(j());
                case 48:
                    return Boolean.valueOf(an());
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

    @Override // com.byazt.vf.oa
    public float bb() {
        if (this.qg != null) {
            return this.qg.bb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Float) objApply).floatValue();
        }
        return 0.0f;
    }

    @Override // com.byazt.vf.oa
    public int cd() {
        if (this.qg != null) {
            return this.qg.cd();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.oa
    public String cp() {
        if (this.qg != null) {
            return this.qg.cp();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String cy() {
        if (this.qg != null) {
            return this.qg.cy();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String d() {
        if (this.qg != null) {
            return this.qg.d();
        }
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

    @Override // com.byazt.vf.oa
    public int fs() {
        if (this.qg != null) {
            return this.qg.fs();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.oa
    public String h() {
        if (this.qg != null) {
            return this.qg.h();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
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

    @Override // com.byazt.vf.oa
    public String hd() {
        if (this.qg != null) {
            return this.qg.hd();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String hu() {
        if (this.qg != null) {
            return this.qg.hu();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public boolean j() {
        if (this.qg != null) {
            return this.qg.j();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 47);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.oa
    public String k() {
        if (this.qg != null) {
            return this.qg.k();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String l() {
        if (this.qg != null) {
            return this.qg.l();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String l(Boolean bool) {
        if (this.qg != null) {
            return this.qg.l(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public Map l(boolean z) {
        if (this.qg != null) {
            return this.qg.l(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Boolean.valueOf(z));
        return (Map) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String lh() {
        if (this.qg != null) {
            return this.qg.lh();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String ln() {
        if (this.qg != null) {
            return this.qg.ln();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String m() {
        if (this.qg != null) {
            return this.qg.m();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public int n(long j) {
        if (this.qg != null) {
            return this.qg.n(j);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, Long.valueOf(j));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.oa
    public int n(boolean z) {
        if (this.qg != null) {
            return this.qg.n(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, Boolean.valueOf(z));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.oa
    public String n() {
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String n(int i) {
        if (this.qg != null) {
            return this.qg.n(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        sparseArray.put(1, Integer.valueOf(i));
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String n(Boolean bool) {
        if (this.qg != null) {
            return this.qg.n(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public void n(com.byazt.hsi.s sVar) {
        if (this.qg != null) {
            this.qg.n(sVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        if (sVar != null) {
            sVar = new com.byazt.hsi.l(sVar);
        }
        sparseArray.put(1, sVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String oa() {
        if (this.qg != null) {
            return this.qg.oa();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public int ou() {
        if (this.qg != null) {
            return this.qg.ou();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.oa
    public int py() {
        if (this.qg != null) {
            return this.qg.py();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.vf.oa
    public com.byazt.hsi.n q(boolean z) {
        ?? qgVar;
        if (this.qg != null) {
            return this.qg.q(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, Boolean.valueOf(z));
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            qgVar = Apply;
            qgVar = new com.byazt.hsi.qg((Function) Apply);
        }
        qgVar = Apply;
        return (com.byazt.hsi.n) qgVar;
    }

    @Override // com.byazt.vf.oa
    public String q() {
        if (this.qg != null) {
            return this.qg.q();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String q(Boolean bool) {
        if (this.qg != null) {
            return this.qg.q(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String qg(Boolean bool) {
        if (this.qg != null) {
            return this.qg.qg(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String qg(boolean z) {
        if (this.qg != null) {
            return this.qg.qg(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public void qg(com.byazt.hsi.s sVar) {
        if (this.qg != null) {
            this.qg.qg(sVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        if (sVar != null) {
            sVar = new com.byazt.hsi.l(sVar);
        }
        sparseArray.put(1, sVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String rv() {
        if (this.qg != null) {
            return this.qg.rv();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String s() {
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String s(Boolean bool) {
        if (this.qg != null) {
            return this.qg.s(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, bool);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String[] s(boolean z) {
        if (this.qg != null) {
            return this.qg.s(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String sz() {
        if (this.qg != null) {
            return this.qg.sz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String t() {
        if (this.qg != null) {
            return this.qg.t();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String tj() {
        if (this.qg != null) {
            return this.qg.tj();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String um() {
        if (this.qg != null) {
            return this.qg.um();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public boolean ur() {
        if (this.qg != null) {
            return this.qg.ur();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.oa
    public long v() {
        if (this.qg != null) {
            return this.qg.v();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.vf.oa
    public String w() {
        if (this.qg != null) {
            return this.qg.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String wm() {
        if (this.qg != null) {
            return this.qg.wm();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.oa
    public String x() {
        if (this.qg != null) {
            return this.qg.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.n.apply(sparseArray);
    }
}
