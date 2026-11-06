package com.byazt.ez;

import android.app.Activity;
import com.byazt.aqe.tj;
import com.byazt.gct.dh;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1378, 5})
public class q extends n {
    public n qg;

    public q(Activity activity, pk pkVar) {
        super(activity, pkVar);
    }

    @Override // com.byazt.ez.n, com.byazt.aqe.qg
    public com.byazt.aqe.qg.n n(tj tjVar) {
        ArrayList<ry> arrayListL = dh.l(this.x);
        if (arrayListL == null) {
            return new com.byazt.aqe.qg.n(false, 0, "");
        }
        for (ry ryVar : arrayListL) {
            if (ryVar.s() == 1) {
                this.qg = new s(this.fs, this.x, ryVar);
            }
            n nVar = this.qg;
            if (nVar != null) {
                nVar.s(this.d);
                this.qg.q(this.cp);
                this.qg.n(this.n);
                this.qg.qg(fs());
                this.qg.n(this.cy);
                com.byazt.aqe.qg.n nVarN = this.qg.n(tjVar);
                if (nVarN.s()) {
                    return nVarN;
                }
            }
        }
        return new com.byazt.aqe.qg.n(false, 0, "");
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        n nVar = this.qg;
        if (nVar == null) {
            return null;
        }
        return nVar.n();
    }

    @Override // com.byazt.aqe.qg
    public void qg(String str) {
        super.qg(str);
        n nVar = this.qg;
        if (nVar == null) {
            return;
        }
        nVar.qg(str);
    }
}
