package com.byazt.has;

import android.view.View;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.gct.ta;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, 18})
public class l extends n {
    public static int qg(pk pkVar) {
        return 3;
    }

    @Override // com.byazt.has.qg
    public boolean ci() {
        return true;
    }

    @Override // com.byazt.has.qg
    public boolean cx() {
        return false;
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return false;
    }

    public l(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
    }

    @Override // com.byazt.has.n
    public View rv() {
        if (this.q != 100.0f) {
            return e();
        }
        if (this.s == 2) {
            int iGe = this.qg.ge();
            if (iGe == 3) {
                return com.byazt.cb.qg.hd(this.n);
            }
            if (iGe == 33) {
                return com.byazt.cb.qg.cd(this.n);
            }
            return com.byazt.cb.qg.um(this.n);
        }
        int iGe2 = this.qg.ge();
        if (iGe2 == 3) {
            return com.byazt.cb.qg.a(this.n);
        }
        if (iGe2 == 33) {
            return com.byazt.cb.qg.py(this.n);
        }
        return com.byazt.cb.qg.ou(this.n);
    }

    @Override // com.byazt.has.n
    public com.byazt.tkz.qg n(boolean z) {
        if (this.q != 100.0f) {
            this.rv = new com.byazt.tkz.x(this.n, this.qg, z);
        } else {
            this.rv = new com.byazt.tkz.w(this.n, this.qg, z);
        }
        return this.rv;
    }

    public static boolean n(pk pkVar) {
        return (pkVar == null || pk.s(pkVar)) ? false : true;
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        if (!com.byazt.nf.rv.qg().ec()) {
            return cx.s(this.qg, x()) && ta.d(this.qg);
        }
        if (this.qg.sl() != 100.0f) {
            return pk.s(this.qg) || com.byazt.ql.s.n(this.qg);
        }
        if (this.tj.l()) {
            return this.tj.tj();
        }
        return true;
    }

    @Override // com.byazt.has.qg
    public void dn() {
        this.rv.l(8);
        this.rv.w(8);
        this.cd.l(lq());
        this.cd.qg(this.qg.yv());
        this.n.sh();
    }

    @Override // com.byazt.has.qg
    public boolean hf() {
        return this.sz;
    }

    @Override // com.byazt.has.qg
    public boolean kc() {
        if (!cx.s(this.qg, x())) {
            return false;
        }
        if (cx.hd(this.qg)) {
            return true;
        }
        return (com.byazt.nf.rv.qg().ec() || lq()) ? false : true;
    }

    @Override // com.byazt.has.qg
    public boolean rv(boolean z) {
        if (com.byazt.nf.rv.qg().ec()) {
            return false;
        }
        return (z || !cx.hd(this.qg)) && !lq() && kc();
    }

    @Override // com.byazt.has.n
    public int pk() {
        if (rv(false)) {
            return (int) Math.min(cx.n() / 1000, (int) ta.x(this.qg));
        }
        if (cx.hd(this.qg)) {
            return super.pk();
        }
        return (int) ta.x(this.qg);
    }

    @Override // com.byazt.has.qg
    public void z() {
        super.z();
        if (kc()) {
            int iUr = ur();
            int iT = t();
            if (!com.byazt.nf.rv.qg().ec() && !lq() && cx.s(this.qg, x()) && iUr > ta.x(this.qg)) {
                this.n.lq();
            }
            this.n.s(0);
            if (rv(false)) {
                if (this.a.an()) {
                    return;
                }
                if (iT > pk() || this.k) {
                    com.byazt.rv.s.n = 0;
                    this.n.sh();
                    if (this.tj == null || hu() != 7) {
                        return;
                    }
                    this.tj.n("0", iT, 0, false);
                    return;
                }
                int iW = w(true);
                int iW2 = w(false);
                com.byazt.rv.s.n = iW;
                this.n.sh();
                qg(iW);
                if (this.tj == null || hu() != 7) {
                    return;
                }
                this.tj.n(String.valueOf(iW2), iT, 0, false);
                return;
            }
            if (iT > pk() || this.k) {
                this.n.rf();
                com.byazt.rv.s.n = 0;
                this.cd.n(this.sz, this.sz ? "领取成功" : "", null, true, true);
                if (this.tj == null || hu() != 7) {
                    return;
                }
                this.tj.n("0", iT, 0, false);
                return;
            }
            int iW3 = w(true);
            int iW4 = w(false);
            com.byazt.rv.s.n = iW3;
            boolean z = iT > this.bb.s() || this.n.dh();
            this.cd.n(this.sz, iW4 + com.anythink.core.common.s.a + (this.sz ? "后可领取奖励" : ""), null, z, z);
            qg(iW3);
            if (this.tj == null || hu() != 7) {
                return;
            }
            this.tj.n(String.valueOf(iW4), iT, 0, false);
        }
    }

    @Override // com.byazt.has.n
    public int v() {
        return qg(this.qg);
    }
}
