package com.byazt.qdx;

import com.byazt.gct.vb;
import com.byazt.si.cy;
import com.byazt.si.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 844, 8})
public class s extends n {
    public vb n;

    private void n(cy cyVar) {
        fs fsVarTj = cyVar.tj();
        if (fsVarTj == null || !q()) {
            return;
        }
        n(fsVarTj.n(), fsVarTj.qg());
    }

    private boolean q() {
        vb vbVar = this.n;
        return vbVar != null && vbVar.ou();
    }

    private void n(long j, long j2) {
        this.n.sz(j2);
        vb vbVar = this.n;
        vbVar.rv(j2 - vbVar.py());
        this.n.um(j2 - j);
    }

    private void l() {
        if (q()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            vb vbVar = this.n;
            vbVar.fs(jCurrentTimeMillis - vbVar.um());
            this.n.oa(jCurrentTimeMillis);
        }
    }

    public vb s() {
        return this.n;
    }

    public void n(vb vbVar) {
        this.n = vbVar;
    }

    @Override // com.byazt.qdx.n
    public void n(cy cyVar, n.qg qgVar) {
        n(cyVar);
        super.n(cyVar, qgVar);
    }

    @Override // com.byazt.qdx.n
    public void n() {
        l();
    }
}
