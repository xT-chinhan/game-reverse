package com.byazt.wif;

import com.byazt.gct.um;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 572, 18})
public class l extends n {
    @Override // com.byazt.wif.n
    public boolean s() {
        this.q = 2;
        int iQg = um.qg(this.qg.D_());
        if (iQg == 2) {
            return false;
        }
        return (iQg == 0 && q() == -1) ? false : true;
    }
}
