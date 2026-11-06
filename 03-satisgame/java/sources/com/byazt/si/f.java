package com.byazt.si;

import android.util.SparseArray;
import java.io.File;
import java.util.Collection;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, 990})
public class f implements h, Function {
    public com.byazt.gxb.w loadFactory = new com.byazt.gxb.w(com.byazt.gxb.l.tj(), false);

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object bbVar = sparseArray.get(1);
            if (bbVar != null) {
                bbVar = new bb((Function) bbVar);
            }
            sz szVarN = n((ur) bbVar);
            return szVarN != null ? new k(szVarN) : szVarN;
        }
        if (iIntValue == 2) {
            Object bbVar2 = sparseArray.get(1);
            if (bbVar2 != null) {
                bbVar2 = new bb((Function) bbVar2);
            }
            qg((ur) bbVar2);
            return null;
        }
        if (iIntValue != 3) {
            if (iIntValue != 4) {
                return null;
            }
            n();
            return null;
        }
        Object bbVar3 = sparseArray.get(1);
        if (bbVar3 != null) {
            bbVar3 = new bb((Function) bbVar3);
        }
        s((ur) bbVar3);
        return null;
    }

    @Override // com.byazt.si.h
    public sz n(ur urVar) {
        String strN = urVar.n();
        String strQg = urVar.qg();
        sz szVarN = new com.byazt.gxb.s.qg(this.loadFactory).n(strQg);
        szVarN.qg(com.byazt.esj.n.n(strN, strQg));
        szVarN.s(strN);
        szVarN.n(q(urVar));
        return szVarN;
    }

    @Override // com.byazt.si.h
    public void qg(ur urVar) {
        lh lhVarN;
        com.byazt.gxb.w wVar = this.loadFactory;
        if (wVar == null || (lhVarN = wVar.n(q(urVar))) == null) {
            return;
        }
        lhVarN.n();
    }

    @Override // com.byazt.si.h
    public void s(ur urVar) {
        v vVarQg;
        com.byazt.gxb.w wVar = this.loadFactory;
        if (wVar == null || (vVarQg = wVar.qg(q(urVar))) == null) {
            return;
        }
        vVarQg.n();
    }

    @Override // com.byazt.si.h
    public void n() {
        n(this.loadFactory.n(), 0.0d);
        n(this.loadFactory.qg(), 0.0d);
    }

    private void n(Collection<? extends n> collection, double d) {
        if (collection == null) {
            return;
        }
        for (n nVar : collection) {
            if (nVar != null) {
                nVar.n(d);
            }
        }
    }

    private qg q(final ur urVar) {
        return new qg() { // from class: com.byazt.si.f.1
            @Override // com.byazt.si.qg
            public long n() {
                return 0L;
            }

            @Override // com.byazt.si.qg
            public boolean q() {
                return false;
            }

            @Override // com.byazt.si.qg
            public boolean w() {
                return false;
            }

            @Override // com.byazt.si.qg
            public int qg() {
                return urVar.s();
            }

            @Override // com.byazt.si.qg
            public boolean s() {
                return urVar.s() > 0;
            }

            @Override // com.byazt.si.qg
            public File l() {
                return new File(urVar.n());
            }

            @Override // com.byazt.si.qg
            public boolean x() {
                return urVar.q() > 0;
            }

            @Override // com.byazt.si.qg
            public int fs() {
                return urVar.q();
            }
        };
    }
}
