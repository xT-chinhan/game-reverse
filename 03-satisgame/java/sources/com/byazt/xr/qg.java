package com.byazt.xr;

import com.byazt.cy.d;
import com.byazt.cy.l;
import com.byazt.cy.oa;
import com.byazt.cy.w;
import com.byazt.np.x;
import com.byazt.vy.tj;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 685, 26})
public class qg implements d {
    public com.byazt.sg.s n;
    public com.byazt.qn.qg qg;
    public x s;

    @Override // com.byazt.cy.d
    public void n(oa oaVar) {
    }

    public qg(x xVar, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar) {
        this.n = sVar;
        this.qg = qgVar;
        this.s = xVar;
    }

    @Override // com.byazt.fb.s
    public boolean n() {
        if (this.n == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n);
        com.byazt.gp.s.n(arrayList, (List<com.byazt.sg.s>) null, (List<com.byazt.sg.s>) null, this.qg, 0);
        com.byazt.qn.qg qgVar = this.qg;
        if (qgVar != null) {
            return this.n.ae(qgVar.a());
        }
        return false;
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.q> qg() {
        List<com.byazt.mj.qg> listTj;
        ArrayList arrayList = new ArrayList();
        x xVar = this.s;
        if (xVar != null && (listTj = xVar.tj()) != null) {
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
        x xVar = this.s;
        if (xVar != null && (listCp = xVar.cp()) != null) {
            for (com.byazt.mj.s sVar : listCp) {
                if (sVar != null) {
                    arrayList.add(new w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg q() {
        if (this.n == null || !com.byazt.qt.qg.n().fi()) {
            return new l();
        }
        return new w(com.byazt.vy.x.n(this.qg, this.n, false));
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.qg> l() {
        List<com.byazt.mj.s> listD;
        ArrayList arrayList = new ArrayList();
        x xVar = this.s;
        if (xVar != null && (listD = xVar.d()) != null) {
            for (com.byazt.mj.s sVar : listD) {
                if (sVar != null) {
                    arrayList.add(new w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg w() {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || !sVar.pe() || tj.n()) {
            return new l();
        }
        return new w(com.byazt.vy.x.n(this.qg, this.n, true));
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
