package com.byazt.wif;

import android.content.Context;
import com.byazt.gct.um;
import com.byazt.llp.rv;
import com.byazt.tk.h;
import com.byazt.tk.hd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 572, 19})
public abstract class n {
    public Context n;
    public rv qg;
    public boolean s = true;
    public int q = 0;
    public boolean l = false;

    public abstract boolean s();

    public void n(Context context) {
        this.n = context;
    }

    public void n(rv rvVar) {
        this.qg = rvVar;
    }

    public void n(boolean z) {
        this.s = z;
    }

    public void qg(boolean z) {
        this.l = z;
    }

    public boolean n() {
        Context context;
        if (this.qg == null || (context = this.n) == null) {
            this.q = 10;
            return true;
        }
        if (!this.s) {
            return false;
        }
        if (hd.s(context) == 0) {
            try {
                h.n(this.n, "\"无网络，请稍后再试\"", 0);
            } catch (Throwable unused) {
            }
        }
        boolean zS = s();
        if (zS) {
            w.n = true;
            w.s = true;
        }
        return zS;
    }

    public int qg() {
        return this.q;
    }

    public int q() {
        int iS = hd.s(this.n);
        rv rvVar = this.qg;
        if (rvVar == null) {
            return -1;
        }
        int iQ = um.q(rvVar.D_());
        if (iQ == -1) {
            return !com.byazt.vyf.s.cy().s(iS) ? 11 : -1;
        }
        if (iQ == 0) {
            return -1;
        }
        if (iQ == 2) {
            return iS != 4 ? 12 : -1;
        }
        if (iQ == 3) {
            return 13;
        }
        if (com.byazt.vyf.s.cy().s(iS)) {
            return -1;
        }
        com.byazt.gct.l lVarK = this.qg.k();
        return ((lVarK == null || lVarK.x() <= 0) ? 104857600 : lVarK.x()) > um.l(this.qg.D_()) ? 14 : -1;
    }
}
