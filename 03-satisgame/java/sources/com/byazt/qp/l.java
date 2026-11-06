package com.byazt.qp;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 18})
public class l implements com.byazt.vf.cp, Function {
    public com.byazt.vf.n n;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
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
            default:
                return null;
        }
    }

    public l(com.byazt.vf.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.vf.cp
    public boolean n() {
        return com.byazt.nf.rv.qg().dz();
    }

    @Override // com.byazt.vf.cp
    public String qg() {
        return com.byazt.vgx.w.m();
    }

    @Override // com.byazt.vf.cp
    public String s() {
        return com.byazt.vgx.w.hu();
    }

    @Override // com.byazt.vf.cp
    public String q() {
        return com.byazt.vgx.w.tj("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.byazt.vf.cp
    public boolean l() {
        return com.byazt.nf.rv.qg().rn();
    }

    @Override // com.byazt.vf.cp
    public boolean w() {
        return com.byazt.nf.rv.qg().j();
    }

    @Override // com.byazt.vf.cp
    public boolean x() {
        return com.byazt.nf.rv.qg().ax() == 1;
    }

    @Override // com.byazt.vf.cp
    public boolean fs() {
        return com.byazt.nf.rv.qg().ae();
    }

    @Override // com.byazt.vf.cp
    public long rv() {
        long jF = com.byazt.nf.rv.qg().f();
        if (jF < 0 || jF == 2147483647L) {
            return 5000L;
        }
        return jF;
    }

    @Override // com.byazt.vf.cp
    public int tj() {
        int iDf = com.byazt.nf.rv.qg().df();
        if (iDf < 0 || iDf == Integer.MAX_VALUE) {
            return 10;
        }
        return iDf;
    }

    @Override // com.byazt.vf.cp
    public int cp() {
        return com.byazt.nf.rv.qg().pk();
    }

    @Override // com.byazt.vf.cp
    public int d() {
        int iKc = com.byazt.nf.rv.qg().kc();
        if (iKc <= 0 || iKc == Integer.MAX_VALUE) {
            return 100;
        }
        return iKc;
    }

    @Override // com.byazt.vf.cp
    public int oa() {
        return com.byazt.nf.rv.qg().wo();
    }

    @Override // com.byazt.vf.cp
    public JSONObject sz() {
        return com.byazt.nf.rv.qg().nk();
    }

    @Override // com.byazt.vf.cp
    public JSONObject k() {
        return com.byazt.nf.rv.qg().xm();
    }

    @Override // com.byazt.vf.cp
    public JSONObject cy() {
        return com.byazt.nf.rv.qg().vo();
    }

    @Override // com.byazt.vf.cp
    public JSONArray n(String str) {
        return com.byazt.nf.rv.qg().um(str);
    }

    @Override // com.byazt.vf.cp
    public long hd() {
        return com.byazt.nf.rv.qg().pi();
    }

    @Override // com.byazt.vf.cp
    public int cd() {
        return com.byazt.nf.rv.qg().rt();
    }

    @Override // com.byazt.vf.cp
    public JSONObject um() {
        return com.byazt.nf.rv.qg().bz();
    }

    @Override // com.byazt.vf.cp
    public boolean a() {
        return com.byazt.nf.rv.qg().z();
    }

    @Override // com.byazt.vf.cp
    public int py() {
        return com.byazt.nf.rv.qg().an();
    }
}
