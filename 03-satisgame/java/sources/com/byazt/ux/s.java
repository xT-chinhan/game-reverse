package com.byazt.ux;

import com.byazt.cy.d;
import com.byazt.cy.oa;
import com.byazt.np.rv;
import com.byazt.vy.tj;
import com.byazt.vy.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 727, 8})
public class s implements d {
    public com.byazt.sg.s n;
    public com.byazt.qn.qg qg;
    public rv s;

    public s(rv rvVar, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar) {
        this.n = sVar;
        this.qg = qgVar;
        this.s = rvVar;
    }

    @Override // com.byazt.fb.s
    public boolean n() {
        if (this.qg == null || this.n == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n);
        com.byazt.gp.s.n(arrayList, (List<com.byazt.sg.s>) null, (List<com.byazt.sg.s>) null, this.qg, 0);
        return this.n.ae(this.qg.a());
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.q> qg() {
        List<com.byazt.mj.qg> listTj;
        ArrayList arrayList = new ArrayList();
        rv rvVar = this.s;
        if (rvVar != null && (listTj = rvVar.tj()) != null) {
            for (com.byazt.mj.qg qgVar : listTj) {
                if (qgVar != null) {
                    arrayList.add(new com.byazt.cy.n(qgVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.qg> s() {
        List<com.byazt.mj.s> listCp;
        ArrayList arrayList = new ArrayList();
        rv rvVar = this.s;
        if (rvVar != null && (listCp = rvVar.cp()) != null) {
            for (com.byazt.mj.s sVar : listCp) {
                if (sVar != null) {
                    arrayList.add(new com.byazt.cy.w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg q() {
        com.byazt.qn.qg qgVar;
        if (this.n != null && (qgVar = this.qg) != null) {
            if (!qgVar.nf() && !com.byazt.qt.qg.n().fi()) {
                return new com.byazt.cy.l();
            }
            return new com.byazt.cy.w(x.n(this.qg, this.n, false));
        }
        return new com.byazt.cy.l();
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.qg> l() {
        List<com.byazt.mj.s> listD;
        ArrayList arrayList = new ArrayList();
        rv rvVar = this.s;
        if (rvVar != null && (listD = rvVar.d()) != null) {
            for (com.byazt.mj.s sVar : listD) {
                if (sVar != null) {
                    arrayList.add(new com.byazt.cy.w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg w() {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || !sVar.pe() || tj.n()) {
            return new com.byazt.cy.l();
        }
        return new com.byazt.cy.w(x.n(this.qg, this.n, true));
    }

    @Override // com.byazt.cy.d
    public boolean x() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.a();
        }
        return false;
    }

    @Override // com.byazt.cy.d
    public void n(boolean z) {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            sVar.q(z);
        }
    }

    @Override // com.byazt.cy.d
    public void n(final oa oaVar) {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            sVar.n(new com.byazt.kv.l() { // from class: com.byazt.ux.s.1
                @Override // com.byazt.kv.l
                public void n() {
                    oa oaVar2 = oaVar;
                    if (oaVar2 != null) {
                        oaVar2.n();
                    }
                }
            });
        }
    }

    @Override // com.byazt.cy.d
    public boolean fs() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.kc();
        }
        return false;
    }

    @Override // com.byazt.cy.d
    public void rv() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            sVar.hd();
        }
    }

    @Override // com.byazt.cy.d
    public void tj() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            sVar.cy();
        }
    }
}
