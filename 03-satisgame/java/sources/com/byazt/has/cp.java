package com.byazt.has;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, 29})
public class cp extends n {
    public int lh;
    public int ln;
    public com.byazt.hm.q v;

    @Override // com.byazt.has.qg
    public boolean cx() {
        return false;
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        return false;
    }

    @Override // com.byazt.has.n
    public boolean w() {
        return false;
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return false;
    }

    public cp(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
        this.ln = 0;
        this.lh = 0;
        com.byazt.hm.q qVar = new com.byazt.hm.q(pkVar);
        this.v = qVar;
        qVar.n(true);
    }

    public static boolean n(pk pkVar) {
        return pkVar.el() == 1 && cd.n(pkVar);
    }

    @Override // com.byazt.has.n
    public void qg(boolean z) {
        super.qg(z);
        this.v.s();
        if (this.rv instanceof com.byazt.tkz.n) {
            ((com.byazt.tkz.n) this.rv).rv();
        }
    }

    @Override // com.byazt.has.n
    public void s(boolean z) {
        super.s(z);
        if (this.rv instanceof com.byazt.tkz.n) {
            if (((com.byazt.tkz.n) this.rv).w()) {
                this.v.n(((com.byazt.tkz.n) this.rv).l().get());
            }
            ((com.byazt.tkz.n) this.rv).fs();
        }
    }

    @Override // com.byazt.has.n
    public void hd() {
        super.hd();
        if ((this.rv instanceof com.byazt.tkz.n) && ((com.byazt.tkz.n) this.rv).w()) {
            this.v.q();
        }
        this.rv.tj();
    }

    @Override // com.byazt.has.n
    public void k() {
        super.k();
    }

    @Override // com.byazt.has.qg
    public void dn() {
        this.rv.l(0);
        this.cd.n(true);
        if (com.byazt.ep.cp.q(this.qg)) {
            this.cd.l(true);
        }
        if (com.byazt.ep.cp.l(this.qg) || com.byazt.ep.cp.q(this.qg)) {
            this.cd.qg(false);
        } else {
            this.cd.qg(this.qg.yv());
        }
        if (com.byazt.ep.cp.s(this.qg)) {
            this.cd.s(true);
            this.cd.l(true);
            this.cd.n(this.sz, oj() + com.anythink.core.common.s.a + (this.sz ? "后可领取奖励" : ""), null, true, true);
        } else {
            this.cd.l(false);
            this.cd.n(false, null, null, true, true);
        }
    }

    @Override // com.byazt.has.n
    public void l(boolean z) {
        super.l(z);
        if (com.byazt.ep.cp.q(this.qg)) {
            ((com.byazt.tkz.n) this.rv).qg(z);
        }
    }

    @Override // com.byazt.has.n
    public boolean an() {
        if (oj() > 0) {
            return false;
        }
        if (!com.byazt.ep.cp.l(this.qg)) {
            return true;
        }
        ((com.byazt.tkz.n) this.rv).n(0);
        return true;
    }

    @Override // com.byazt.has.n
    public int x(boolean z) {
        if ((this.a.an() && cd.n(this.qg)) || this.ln == 0) {
            return 0;
        }
        if (com.byazt.ep.cp.l(this.qg) || com.byazt.ep.cp.q(this.qg)) {
            return Math.max(this.ln - t(), 0);
        }
        return Math.max(Math.min(this.ln, 27) - t(), 0);
    }

    @Override // com.byazt.has.n
    public int fs(boolean z) {
        if ((this.a.an() && cd.n(this.qg)) || this.ln == 0) {
            return 0;
        }
        if (com.byazt.ep.cp.l(this.qg) || com.byazt.ep.cp.q(this.qg)) {
            return Math.max(this.ln - t(), 0);
        }
        return Math.max(((int) Math.min((this.ln * this.qg.gr()) / 100.0f, 27.0f)) - t(), 0);
    }

    @Override // com.byazt.has.n
    public void fs() {
        JSONObject jSONObjectS;
        super.fs();
        com.byazt.ltk.n.n().n(this.qg);
        if (com.byazt.ep.cp.l(this.qg) || com.byazt.ep.cp.q(this.qg)) {
            com.byazt.ul.n nVarFl = this.qg.fl();
            this.ln = 30;
            if (nVarFl != null && (jSONObjectS = nVarFl.s()) != null) {
                this.ln = jSONObjectS.optInt("reward_time", 30);
            }
        } else {
            this.ln = com.byazt.qq.qg.l(this.qg);
        }
        this.lh = com.byazt.qq.qg.w(this.qg);
    }

    @Override // com.byazt.has.n
    public View rv() {
        FrameLayout frameLayout = new FrameLayout(this.n);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.byazt.has.n, com.byazt.has.qg
    public void s() {
        this.cd.n(4);
        this.rv.s(true);
        if (com.byazt.ep.cp.l(this.qg) || com.byazt.ep.cp.q(this.qg)) {
            ((com.byazt.tkz.n) this.rv).n(Math.max(0, this.ln - t()));
        }
        this.n.s(true, true);
    }

    @Override // com.byazt.has.n
    public com.byazt.tkz.qg n(boolean z) {
        this.rv = new com.byazt.tkz.n(this.n, this.qg, z, this.v, this.cd);
        return this.rv;
    }

    @Override // com.byazt.has.n
    public com.byazt.aqe.qg.n n(final pk pkVar, final com.byazt.aqe.tj tjVar) {
        this.n.dg();
        this.n.oj();
        com.byazt.aqe.fs fsVar = new com.byazt.aqe.fs(this.n, pkVar);
        fsVar.n(this.a.py());
        fsVar.n(dg());
        return fsVar.qg(new com.byazt.aqe.tj() { // from class: com.byazt.has.cp.1
            @Override // com.byazt.aqe.tj
            public void n() {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n();
                }
                if (com.byazt.ep.cp.q(pkVar) && ((com.byazt.tkz.n) cp.this.rv).q()) {
                    return;
                }
                cp.this.n.u();
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
    public void m() {
        if (com.byazt.ep.cp.q(this.qg) && ((com.byazt.tkz.n) this.rv).s()) {
            ((com.byazt.tkz.n) this.rv).n(false);
        }
    }

    @Override // com.byazt.has.qg
    public void z() {
        int iT = t();
        int iMax = Math.max(0, this.ln - iT);
        if (!this.a.an()) {
            int i = this.ln;
            if (iT >= i) {
                if (com.byazt.ep.cp.s(this.qg)) {
                    this.cd.n(this.sz, this.sz ? "领取成功" : "", null, true, true);
                } else {
                    this.cd.n(false, null, null, true, true);
                }
                this.n.oa();
            } else if (this.lh >= i) {
                this.cd.n(false, String.valueOf(iMax), null, false, false);
            } else if (com.byazt.ep.cp.s(this.qg)) {
                this.cd.n(this.sz, iMax + com.anythink.core.common.s.a + (this.sz ? "后可领取奖励" : ""), null, this.lh <= iT, true);
            } else if (com.byazt.ep.cp.l(this.qg) || com.byazt.ep.cp.q(this.qg)) {
                if (iT >= this.lh) {
                    this.cd.n(false, null, null, true, true);
                }
            } else if (iT >= this.lh) {
                this.cd.n(false, String.valueOf(iMax), "跳过", false, true);
            } else {
                this.cd.n(false, String.valueOf(iMax), (this.lh - iT) + "s后可跳过", false, false);
            }
        }
        this.n.s(0);
        if (com.byazt.ep.cp.l(this.qg)) {
            ((com.byazt.tkz.n) this.rv).n(iMax);
        }
        if (iMax == 0 && (this.rv instanceof com.byazt.tkz.n)) {
            ((com.byazt.tkz.n) this.rv).x();
        }
    }

    @Override // com.byazt.has.n
    public int v() {
        return qg(this.qg);
    }

    public static int qg(pk pkVar) {
        return com.byazt.ep.cp.s(pkVar) ? 6 : 7;
    }
}
