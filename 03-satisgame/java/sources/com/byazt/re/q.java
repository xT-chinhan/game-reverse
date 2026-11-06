package com.byazt.re;

import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 796, 5})
public class q {
    public l l;
    public boolean n;
    public qg q;
    public final TTBaseVideoActivity qg;
    public pk s;
    public boolean w = false;

    public q(TTBaseVideoActivity tTBaseVideoActivity) {
        this.qg = tTBaseVideoActivity;
    }

    public void n(qg qgVar, pk pkVar, String str, l lVar) {
        if (this.w) {
            return;
        }
        this.w = true;
        this.q = qgVar;
        this.s = pkVar;
        this.l = lVar;
    }

    public void n() {
        if (com.byazt.qq.qg.qg(this.s) && !this.q.an()) {
            q();
        }
    }

    public void n(boolean z) {
        qg qgVar = this.q;
        if (qgVar != null && qgVar.bb()) {
            this.n = z;
            this.l.q(z);
            this.q.n(this.n);
        }
    }

    public void qg() {
        if (com.byazt.qq.qg.qg(this.s)) {
            if (this.q.an() || q()) {
                boolean z = !this.n;
                this.n = z;
                this.q.n(z);
            }
        }
    }

    public void n(boolean z, boolean z2) {
        this.q.hu();
        n(z);
        qg(z2);
    }

    public void s() {
        this.q.ur();
        this.l.n(this.qg.nf().ic());
    }

    public boolean q() {
        qg qgVar = this.q;
        if (qgVar != null) {
            return qgVar.ln();
        }
        return false;
    }

    public boolean l() {
        if (com.byazt.qq.qg.s(this.s)) {
            return this.q.j();
        }
        return false;
    }

    public void qg(boolean z) {
        this.q.w(z);
    }

    public void n(int i, int i2) {
        this.q.qg(i, i2);
    }

    public void n(pk pkVar) {
        this.s = pkVar;
    }

    public boolean w() {
        return this.n;
    }
}
