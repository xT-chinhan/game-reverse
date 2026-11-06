package com.byazt.ck;

import com.byazt.cy.d;
import com.byazt.cy.l;
import com.byazt.cy.oa;
import com.byazt.cy.w;
import com.byazt.fb.q;
import com.byazt.np.cp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1900, 26})
public class qg implements d {
    public cp n;

    @Override // com.byazt.cy.d
    public boolean fs() {
        return false;
    }

    @Override // com.byazt.cy.d
    public void n(oa oaVar) {
    }

    @Override // com.byazt.cy.d
    public void n(boolean z) {
    }

    @Override // com.byazt.cy.d
    public boolean x() {
        return false;
    }

    public qg(cp cpVar) {
        this.n = cpVar;
    }

    @Override // com.byazt.fb.s
    public boolean n() {
        cp cpVar = this.n;
        if (cpVar != null) {
            return cpVar.q();
        }
        return false;
    }

    @Override // com.byazt.fb.s
    public List<q> qg() {
        List<com.byazt.mj.qg> listFs;
        ArrayList arrayList = new ArrayList();
        cp cpVar = this.n;
        if (cpVar != null && (listFs = cpVar.fs()) != null) {
            for (com.byazt.mj.qg qgVar : listFs) {
                if (qgVar != null) {
                    arrayList.add(new com.byazt.cy.n(qgVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.qg> s() {
        List<com.byazt.mj.s> listRv;
        ArrayList arrayList = new ArrayList();
        cp cpVar = this.n;
        if (cpVar != null && (listRv = cpVar.rv()) != null) {
            for (com.byazt.mj.s sVar : listRv) {
                if (sVar != null) {
                    arrayList.add(new w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg q() {
        if (this.n != null) {
            return new w(this.n.tj());
        }
        return new l();
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.qg> l() {
        List<com.byazt.mj.s> listCp;
        ArrayList arrayList = new ArrayList();
        cp cpVar = this.n;
        if (cpVar != null && (listCp = cpVar.cp()) != null) {
            for (com.byazt.mj.s sVar : listCp) {
                if (sVar != null) {
                    arrayList.add(new w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg w() {
        if (this.n != null) {
            return new w(this.n.d());
        }
        return new l();
    }

    @Override // com.byazt.cy.d
    public void rv() {
        cp cpVar = this.n;
        if (cpVar != null) {
            cpVar.n();
        }
    }

    @Override // com.byazt.cy.d
    public void tj() {
        cp cpVar = this.n;
        if (cpVar != null) {
            cpVar.qg();
        }
    }
}
