package com.byazt.se;

import android.text.TextUtils;
import com.byazt.gct.dw;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.su;
import com.byazt.gct.ta;
import com.byazt.gct.v;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1270, 26})
public class qg extends n {
    public com.byazt.gct.n cp;
    public boolean d;
    public com.byazt.zsl.s fs;
    public com.byazt.imu.q l;
    public boolean oa;
    public int q;
    public int rv;
    public boolean tj;
    public int w;
    public int x;

    public qg(pk pkVar, boolean z) {
        if (pkVar == null) {
            return;
        }
        this.qg = pkVar;
        this.oa = z;
        this.d = nf.n(pkVar) == 2;
        qg(pkVar);
    }

    private void qg(pk pkVar) {
        int iCa = pkVar.ca();
        dw dwVarX = nf.x(pkVar);
        su suVarFs = nf.fs(pkVar);
        if (TextUtils.isEmpty(ta.n(pkVar))) {
            this.q = 1;
        } else if (s(pkVar)) {
            if (n(dwVarX) || n(suVarFs)) {
                this.q = 2;
            } else {
                if (qg(dwVarX) || qg(suVarFs)) {
                    nf.n(pkVar, 1);
                }
                this.q = 1;
            }
        } else if (iCa == 1) {
            this.q = 1;
        } else {
            this.q = 2;
        }
        q(pkVar);
    }

    private boolean n(dw dwVar) {
        return dwVar != null && n(dwVar.fs()) == 2;
    }

    private boolean n(su suVar) {
        return suVar != null && suVar.x() == 2;
    }

    private boolean qg(dw dwVar) {
        return dwVar != null && n(dwVar.fs()) == 0;
    }

    private boolean qg(su suVar) {
        return suVar != null && suVar.x() == 0;
    }

    private int n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private boolean s(pk pkVar) {
        return nf.n(pkVar) == 2;
    }

    private void q(pk pkVar) {
        l(pkVar);
        w(pkVar);
    }

    private void l(pk pkVar) {
        v vVar;
        if (pkVar.jo() == null || (vVar = pkVar.jo().get(0)) == null) {
            return;
        }
        String strN = vVar.n();
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        this.w = vVar.qg();
        this.x = vVar.s();
        this.l = new com.byazt.imu.q(strN, vVar.x());
    }

    private void w(pk pkVar) {
        this.fs = ta.k(pkVar);
        this.rv = com.byazt.vgx.w.cy(pkVar);
        this.tj = pkVar.bi();
    }

    public com.byazt.imu.q q() {
        return this.l;
    }

    public int l() {
        return this.w;
    }

    public int w() {
        return this.x;
    }

    public com.byazt.zsl.s x() {
        return this.fs;
    }

    public int fs() {
        return this.rv;
    }

    public boolean rv() {
        return this.tj;
    }

    public int tj() {
        return this.q;
    }

    public com.byazt.gct.n cp() {
        return this.cp;
    }

    public void n(com.byazt.gct.n nVar) {
        this.cp = nVar;
    }

    public boolean d() {
        return this.d;
    }

    public boolean oa() {
        return this.oa;
    }

    public void n(boolean z) {
        this.oa = z;
    }
}
