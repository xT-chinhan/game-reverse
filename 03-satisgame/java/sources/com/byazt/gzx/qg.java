package com.byazt.gzx;

import com.byazt.gct.pk;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1081, 26})
public class qg {
    public com.byazt.yxf.n l;
    public int n;
    public com.byazt.yxf.n q;
    public com.byazt.ghh.l qg;
    public int s = -2;

    public qg(int i) {
        this.n = i;
        q();
    }

    private int s() {
        com.byazt.gct.fs.s sVarN = n();
        if (sVarN == null) {
            return -2;
        }
        if (sVarN.x() && rv.qg().gr()) {
            return sVarN.q();
        }
        return -1;
    }

    private void q() {
        int i = this.n;
        if (i == 1) {
            this.l = new com.byazt.msp.q(this, this.n);
            this.q = new com.byazt.nk.qg(this);
            return;
        }
        switch (i) {
            case 5:
                this.l = new com.byazt.msp.q(this, this.n);
                this.q = new com.byazt.be.qg(this);
                break;
            case 6:
                this.q = new com.byazt.hrr.qg(this);
                break;
            case 7:
                this.q = new com.byazt.pj.w(this);
                break;
            case 8:
                this.q = new com.byazt.pj.n(this);
                break;
            case 9:
                this.l = new com.byazt.msp.q(this, this.n);
                this.q = new com.byazt.vgo.qg(this);
                break;
        }
    }

    public boolean n(pk pkVar) {
        return com.byazt.wq.qg.n().s(pkVar) != 3;
    }

    public com.byazt.gct.fs.s n() {
        return com.byazt.gct.fs.n(this.n);
    }

    public com.byazt.ghh.l qg() {
        int iS = s();
        com.byazt.ghh.l lVar = this.qg;
        if (lVar != null && iS == this.s) {
            return lVar;
        }
        if (iS == -1) {
            this.qg = new com.byazt.ghh.qg(this.n);
        } else if (iS == 0) {
            this.qg = new com.byazt.ghh.n(this.n);
        } else if (iS == 1) {
            this.qg = new com.byazt.ghh.q(this.n);
        } else if (iS == 3) {
            this.qg = new com.byazt.ghh.s(this.n);
        } else {
            this.qg = n.qg(this.n);
        }
        this.s = iS;
        return this.qg;
    }

    public com.byazt.yxf.n n(boolean z) {
        com.byazt.yxf.n nVar;
        return (!z || (nVar = this.l) == null) ? this.q : nVar;
    }
}
