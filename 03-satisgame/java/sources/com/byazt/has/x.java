package com.byazt.has;

import android.view.View;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.b;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.yyw.RewardJointEndCardFrameLayout;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, 21})
public class x extends n {
    public int lh;
    public int ln;
    public boolean v;

    @Override // com.byazt.has.qg
    public boolean cx() {
        return true;
    }

    @Override // com.byazt.has.n
    public boolean w() {
        return false;
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return true;
    }

    public x(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
        this.ln = 0;
        this.lh = 0;
        this.v = false;
    }

    public static boolean n(pk pkVar) {
        return com.byazt.qq.qg.s(pkVar);
    }

    @Override // com.byazt.has.n
    public View rv() {
        return com.byazt.cb.qg.n(this.n);
    }

    @Override // com.byazt.has.n
    public View tj() {
        if (cd.q(this.qg)) {
            this.cp = new RewardJointEndCardFrameLayout(this.n, this.qg);
        }
        return super.tj();
    }

    @Override // com.byazt.has.n, com.byazt.has.qg
    public void s() {
        this.cd.n(4);
        this.a.qg();
        this.n.um();
        if (cd.oa(this.qg)) {
            this.cd.qg(true);
        }
        this.ln = com.byazt.qq.qg.l(this.qg);
        this.lh = com.byazt.qq.qg.w(this.qg);
        if (cd.q(this.qg)) {
            this.n.w();
        }
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        return cd.q(this.qg) && pk.s(this.qg);
    }

    @Override // com.byazt.has.n
    public int x(boolean z) {
        int i;
        if (cd.oa(this.qg) || (i = this.ln) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i, 27.0f)) - t());
    }

    @Override // com.byazt.has.n
    public int fs(boolean z) {
        if (cd.oa(this.qg) || this.ln == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.ln * this.qg.gr()) / 100.0f, 27.0f)) - t());
    }

    @Override // com.byazt.has.qg
    public void dn() {
        this.cd.n(true);
        this.rv.w(8);
        if (cd.n(this.qg)) {
            vb();
        } else {
            this.cd.l(true);
            this.cd.qg(this.qg.yv());
        }
    }

    public void vb() {
        int iTs = this.qg.ts();
        if (iTs == 0) {
            this.rv.l(0);
            this.cd.l(true);
            this.cd.qg(this.qg.yv());
        } else {
            if (iTs != 1) {
                if (iTs != 3) {
                    return;
                }
                this.cd.l(false);
                this.cd.qg(false);
                this.cd.n(false, null, null, true, true);
                return;
            }
            this.rv.l(0);
            this.cd.qg(this.qg.yv());
            if (cd.q(this.qg)) {
                this.cd.l(pk.s(this.qg));
            } else {
                this.cd.l(com.byazt.ql.s.n(this.qg));
            }
        }
    }

    @Override // com.byazt.has.n
    public void fs() {
        super.fs();
        com.byazt.ltk.n.n().n(this.qg);
    }

    @Override // com.byazt.has.n
    public void qg(boolean z) {
        super.qg(z);
    }

    @Override // com.byazt.has.n
    public void k() {
        super.k();
        this.n.oj();
    }

    @Override // com.byazt.has.n
    public void hd() {
        super.hd();
        com.byazt.ltk.n.n().qg(this.qg);
    }

    @Override // com.byazt.has.n
    public boolean an() {
        if (oj() > 0) {
            return false;
        }
        if (!cd.q(this.qg) && b.n(this.qg) == 0) {
            return this.a.py();
        }
        return true;
    }

    @Override // com.byazt.has.qg
    public void z() {
        if (cd.oa(this.qg)) {
            return;
        }
        int iT = t();
        int i = this.ln;
        int i2 = i - iT;
        if (iT >= i) {
            this.cd.n(false, null, null, true, true);
            if (!cd.oa(this.qg)) {
                this.n.oa();
            }
        } else {
            int i3 = this.lh;
            if (i3 >= i) {
                this.cd.n(false, String.valueOf(i2), null, false, false);
            } else if (iT >= i3) {
                this.cd.n(false, String.valueOf(i2), "跳过", false, true);
            } else {
                this.cd.n(false, String.valueOf(i2), (this.lh - iT) + "s后可跳过", false, false);
            }
        }
        this.n.s(0);
    }

    @Override // com.byazt.has.qg
    public boolean hf() {
        return cd.q(this.qg);
    }

    @Override // com.byazt.has.qg
    public boolean kc() {
        return cx.hd(this.qg);
    }

    @Override // com.byazt.has.n
    public com.byazt.aqe.qg.n n(pk pkVar, final com.byazt.aqe.tj tjVar) {
        if (this.py.l()) {
            return new com.byazt.aqe.qg.n(false, 0, "");
        }
        this.n.dg();
        this.n.oj();
        com.byazt.aqe.fs fsVar = new com.byazt.aqe.fs(this.n, pkVar);
        fsVar.n(this.a.py());
        fsVar.n(dg());
        return fsVar.qg(new com.byazt.aqe.tj() { // from class: com.byazt.has.x.1
            @Override // com.byazt.aqe.tj
            public void n() {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n();
                }
                x.this.n.u();
            }

            @Override // com.byazt.aqe.tj
            public void qg() {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.qg();
                }
            }
        });
    }

    @Override // com.byazt.has.n
    public int v() {
        return qg(this.qg);
    }

    public static int qg(pk pkVar) {
        return cd.n(pkVar) ? 6 : 0;
    }
}
