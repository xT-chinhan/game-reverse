package com.byazt.has;

import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cx;
import com.byazt.gct.nf;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, 113})
public class d extends n {
    public static boolean n(pk pkVar) {
        return true;
    }

    public static int qg(pk pkVar) {
        return 1;
    }

    @Override // com.byazt.has.qg
    public boolean ci() {
        return true;
    }

    @Override // com.byazt.has.qg
    public boolean cx() {
        return true;
    }

    public d(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return cx();
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        return !x() || cx.s(this.qg, x());
    }

    @Override // com.byazt.has.qg
    public void dn() {
        this.cd.qg(this.qg.yv());
        if (w()) {
            this.rv.l(8);
            this.rv.w(8);
            this.cd.n(false);
        } else {
            this.rv.l(0);
            this.rv.w(0);
            this.cd.l(true);
        }
        this.n.sh();
    }

    @Override // com.byazt.has.qg
    public void he() {
        if (this.ou != null) {
            ((com.byazt.zct.n) this.ou.n(com.byazt.zct.n.class)).n((Object) this.n);
        }
        if (this.wm != null) {
            ((com.byazt.zct.n) this.wm.n(com.byazt.zct.n.class)).n((Object) this.n);
        }
    }

    @Override // com.byazt.has.n
    public void cd() {
        super.cd();
        this.n.sh();
    }

    @Override // com.byazt.has.qg
    public void z() {
        if (cx.hd(this.qg)) {
            boolean z = !cx.s();
            boolean zS = cx.s();
            this.n.s(0);
            if (t() > pk() || this.k) {
                com.byazt.rv.s.n = 0;
                this.cd.n(this.sz, this.sz ? "领取成功" : "", z ? "跳过" : "", zS, true);
                this.n.rf();
                return;
            }
            int iW = w(true);
            int iW2 = w(false);
            com.byazt.rv.s.n = iW;
            boolean z2 = t() > this.bb.s() || this.n.dh();
            this.cd.n(this.sz, iW2 + com.anythink.core.common.s.a + (this.sz ? "后可领取奖励" : ""), z && z2 ? "跳过" : "", zS && z2, z2);
            qg(iW);
        }
    }

    @Override // com.byazt.has.qg
    public boolean hf() {
        if (!this.sz) {
            return false;
        }
        if (nf.n(this.qg) == 2 && nf.s(this.qg) == 3) {
            return false;
        }
        return (nf.n(this.qg) == 2 && nf.s(this.qg) == 7) ? false : true;
    }

    @Override // com.byazt.has.qg
    public boolean kc() {
        return cx.hd(this.qg);
    }

    @Override // com.byazt.has.n
    public int v() {
        return qg(this.qg);
    }
}
