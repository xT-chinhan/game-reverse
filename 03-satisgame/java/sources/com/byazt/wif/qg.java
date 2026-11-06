package com.byazt.wif;

import com.byazt.gct.um;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 572, 26})
public class qg extends n {
    public boolean w = false;
    public int x = 0;
    public int fs = -1;

    public void s(boolean z) {
        this.w = z;
    }

    public void n(int i) {
        this.x = i;
    }

    @Override // com.byazt.wif.n
    public boolean s() {
        this.q = 1;
        boolean z = w.q;
        int iN = um.n(this.qg.D_());
        if (z) {
            iN = 0;
            w.q = false;
        }
        if (this.l) {
            return l();
        }
        if (this.w) {
            int i = this.x;
            if (i == 2) {
                return l();
            }
            if (iN == 2 && i == 1) {
                return l();
            }
        }
        if (iN == 0) {
            return l();
        }
        return true;
    }

    private boolean l() {
        this.q = q();
        return this.q != -1;
    }
}
