package com.byazt.qp;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 26})
public class qg implements com.byazt.vf.n, Function {
    public com.byazt.tbi.n l;
    public String mAppId;
    public volatile SparseArray n;
    public com.byazt.tbi.w q;
    public String qg;
    public volatile com.byazt.zq.n s;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -3) {
            qg((SparseArray) sparseArray.get(1));
            return null;
        }
        if (iIntValue == -2) {
            return m();
        }
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
                com.byazt.tbi.n nVarCp = cp();
                return nVarCp != null ? new com.byazt.tbi.qg(nVarCp) : nVarCp;
            case 14:
                return Integer.valueOf(d());
            case 15:
                return Integer.valueOf(oa());
            case 16:
                return Integer.valueOf(sz());
            case 17:
                com.byazt.tbi.w wVarK = k();
                return wVarK != null ? new com.byazt.tbi.rv(wVarK) : wVarK;
            case 18:
                return Boolean.valueOf(cy());
            case 19:
                return hd();
            case 20:
                n((SparseArray) sparseArray.get(1));
                return null;
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
            default:
                return null;
        }
    }

    public SparseArray m() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.n);
        sparseArray.put(2, this.qg);
        return sparseArray;
    }

    public void qg(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.n = (SparseArray) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            this.qg = (String) obj2;
        }
    }

    public qg(String str) {
        this.mAppId = str;
        if (TextUtils.isEmpty(str)) {
            this.mAppId = com.byazt.vyf.s.cy().ou();
        }
    }

    private com.byazt.zq.n hu() {
        if (this.s == null && this.n != null) {
            this.s = new com.byazt.zq.n(this.n);
        }
        return this.s;
    }

    @Override // com.byazt.vf.n
    public String n() {
        return this.mAppId;
    }

    @Override // com.byazt.vf.n
    public boolean qg() {
        return com.byazt.ed.qg.n().qg();
    }

    @Override // com.byazt.vf.n
    public Object n(String str) {
        Map<String, Object> mapHd;
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null || (mapHd = nVarHu.hd()) == null) {
            return null;
        }
        return mapHd.get(str);
    }

    @Override // com.byazt.vf.n
    public String s() {
        String str = this.qg;
        if (str != null) {
            return str;
        }
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return "";
        }
        String strQg = nVarHu.qg();
        this.qg = strQg;
        if (TextUtils.isEmpty(strQg)) {
            this.qg = com.byazt.ges.qg.tj();
        }
        return this.qg;
    }

    @Override // com.byazt.vf.n
    public boolean q() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return false;
        }
        return nVarHu.s();
    }

    @Override // com.byazt.vf.n
    public String l() {
        com.byazt.zq.n nVarHu = hu();
        return nVarHu == null ? "" : nVarHu.q();
    }

    @Override // com.byazt.vf.n
    public String w() {
        com.byazt.zq.n nVarHu = hu();
        return nVarHu == null ? "" : nVarHu.l();
    }

    @Override // com.byazt.vf.n
    public int x() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return 0;
        }
        return nVarHu.w();
    }

    @Override // com.byazt.vf.n
    public boolean fs() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return false;
        }
        return nVarHu.x();
    }

    @Override // com.byazt.vf.n
    public boolean rv() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return false;
        }
        return nVarHu.fs();
    }

    @Override // com.byazt.vf.n
    public int[] tj() {
        com.byazt.zq.n nVarHu = hu();
        return nVarHu == null ? new int[0] : nVarHu.rv();
    }

    @Override // com.byazt.vf.n
    public com.byazt.tbi.n cp() {
        com.byazt.tbi.n nVar = this.l;
        if (nVar != null) {
            return nVar;
        }
        h();
        return this.l;
    }

    @Override // com.byazt.vf.n
    public int d() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return 0;
        }
        return nVarHu.d();
    }

    private void h() {
        com.byazt.af.rv rvVarHd = com.byazt.vyf.s.cy().hd();
        if (rvVarHd == null) {
            return;
        }
        this.l = new com.byazt.aa.n(rvVarHd);
    }

    @Override // com.byazt.vf.n
    public int oa() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return 0;
        }
        return nVarHu.oa();
    }

    @Override // com.byazt.vf.n
    public int sz() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return 0;
        }
        return nVarHu.sz();
    }

    @Override // com.byazt.vf.n
    public com.byazt.tbi.w k() {
        com.byazt.tbi.w wVar = this.q;
        if (wVar != null) {
            return wVar;
        }
        t();
        return this.q;
    }

    private void t() {
        com.byazt.xmw.n nVarK;
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null || (nVarK = nVarHu.k()) == null) {
            return;
        }
        this.q = new com.byazt.aa.qg(nVarK);
    }

    @Override // com.byazt.vf.n
    public boolean cy() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return false;
        }
        return nVarHu.cy();
    }

    @Override // com.byazt.vf.n
    public Map<String, Object> hd() {
        com.byazt.zq.n nVarHu = hu();
        if (nVarHu == null) {
            return Collections.emptyMap();
        }
        return nVarHu.hd();
    }

    @Override // com.byazt.vf.n
    public void n(SparseArray sparseArray) {
        if (this.n == sparseArray) {
            return;
        }
        this.n = sparseArray;
        this.s = new com.byazt.zq.n(sparseArray);
        t();
        h();
    }

    @Override // com.byazt.vf.n
    public String cd() {
        return com.byazt.ges.qg.l();
    }

    @Override // com.byazt.vf.n
    public String um() {
        return com.byazt.vgx.w.fs();
    }

    @Override // com.byazt.vf.n
    public String a() {
        return com.byazt.vgx.w.rv();
    }

    @Override // com.byazt.vf.n
    public String py() {
        return com.byazt.nf.tj.w;
    }

    @Override // com.byazt.vf.n
    public boolean ou() {
        return com.byazt.nf.tj.n();
    }

    @Override // com.byazt.vf.n
    public String wm() {
        return com.byazt.ges.qg.rv();
    }

    public <T> T qg(String str) {
        return (T) q.n(str, this);
    }
}
