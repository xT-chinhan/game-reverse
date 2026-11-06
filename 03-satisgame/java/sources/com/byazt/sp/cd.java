package com.byazt.sp;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 86})
public class cd implements oa, com.byazt.bd.n.InterfaceC0134n {
    public final com.byazt.bd.oa l;
    public final com.byazt.pp.fs q;
    public final String qg;
    public final boolean s;
    public boolean w;
    public final Path n = new Path();
    public final qg x = new qg();

    public cd(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.hd hdVar) {
        this.qg = hdVar.n();
        this.s = hdVar.s();
        this.q = fsVar;
        com.byazt.bd.oa oaVarN = hdVar.qg().n();
        this.l = oaVarN;
        sVar.n(oaVarN);
        oaVarN.n(this);
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        qg();
    }

    private void qg() {
        this.w = false;
        this.q.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[SYNTHETIC] */
    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            s sVar = list.get(i);
            if (sVar instanceof py) {
                py pyVar = (py) sVar;
                if (pyVar.getType() == com.byazt.aw.um.n.SIMULTANEOUSLY) {
                    this.x.n(pyVar);
                    pyVar.n(this);
                } else if (!(sVar instanceof um)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((um) sVar);
                }
            } else if (!(sVar instanceof um)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((um) sVar);
            }
        }
        this.l.n((List<um>) arrayList);
    }

    @Override // com.byazt.sp.oa
    public Path q() {
        if (this.w) {
            return this.n;
        }
        this.n.reset();
        if (this.s) {
            this.w = true;
            return this.n;
        }
        Path pathX = this.l.x();
        if (pathX == null) {
            return this.n;
        }
        this.n.set(pathX);
        this.n.setFillType(Path.FillType.EVEN_ODD);
        this.x.n(this.n);
        this.w = true;
        return this.n;
    }
}
