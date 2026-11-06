package com.byazt.vf;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 113})
public class d implements cp, Function {
    public volatile Function n;
    public volatile cp qg;

    public d(cp cpVar) {
        this.qg = cpVar;
    }

    public d(Function function) {
        this.n = function;
    }

    @Override // com.byazt.vf.cp
    public boolean a() {
        if (this.qg != null) {
            return this.qg.a();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
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
                    return Boolean.valueOf(n());
                case 2:
                    return qg();
                case 3:
                    return s();
                case 4:
                    return q();
                case 5:
                    return Boolean.valueOf(l());
                case 6:
                    return Boolean.valueOf(w());
                case 7:
                    return Boolean.valueOf(x());
                case 8:
                    return Boolean.valueOf(fs());
                case 9:
                    return Long.valueOf(rv());
                case 10:
                    return Integer.valueOf(tj());
                case 11:
                    return Integer.valueOf(cp());
                case 12:
                    return Integer.valueOf(d());
                case 13:
                    return Integer.valueOf(oa());
                case 14:
                    return sz();
                case 15:
                    return k();
                case 16:
                    return cy();
                case 17:
                    return n((String) sparseArray.get(1));
                case 18:
                    return Long.valueOf(hd());
                case 19:
                    return Integer.valueOf(cd());
                case 20:
                    return um();
                case 21:
                    return Boolean.valueOf(a());
                case 22:
                    return Integer.valueOf(py());
            }
        }
        Function function = (Function) sparseArray.get(1);
        if (function != null) {
            this.n = function;
            this.qg = null;
        }
        return null;
    }

    @Override // com.byazt.vf.cp
    public int cd() {
        if (this.qg != null) {
            return this.qg.cd();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.cp
    public int cp() {
        if (this.qg != null) {
            return this.qg.cp();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.cp
    public JSONObject cy() {
        if (this.qg != null) {
            return this.qg.cy();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.cp
    public int d() {
        if (this.qg != null) {
            return this.qg.d();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
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

    @Override // com.byazt.vf.cp
    public boolean fs() {
        if (this.qg != null) {
            return this.qg.fs();
        }
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

    @Override // com.byazt.vf.cp
    public long hd() {
        if (this.qg != null) {
            return this.qg.hd();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.vf.cp
    public JSONObject k() {
        if (this.qg != null) {
            return this.qg.k();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.cp
    public boolean l() {
        if (this.qg != null) {
            return this.qg.l();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.cp
    public JSONArray n(String str) {
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, str);
        return (JSONArray) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.cp
    public boolean n() {
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.cp
    public int oa() {
        if (this.qg != null) {
            return this.qg.oa();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.cp
    public int py() {
        if (this.qg != null) {
            return this.qg.py();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.cp
    public String q() {
        if (this.qg != null) {
            return this.qg.q();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.cp
    public String qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.cp
    public long rv() {
        if (this.qg != null) {
            return this.qg.rv();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.vf.cp
    public String s() {
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.cp
    public JSONObject sz() {
        if (this.qg != null) {
            return this.qg.sz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.cp
    public int tj() {
        if (this.qg != null) {
            return this.qg.tj();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.cp
    public JSONObject um() {
        if (this.qg != null) {
            return this.qg.um();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.cp
    public boolean w() {
        if (this.qg != null) {
            return this.qg.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.cp
    public boolean x() {
        if (this.qg != null) {
            return this.qg.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }
}
