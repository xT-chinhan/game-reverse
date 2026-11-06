package com.byazt.ys;

import android.content.Context;
import android.view.View;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 122, 26})
public class qg extends l {
    public com.byazt.dj.s l;
    public final pk n;
    public int q;
    public final String qg;
    public final int s;

    public boolean n() {
        return false;
    }

    public qg(Context context, pk pkVar, String str, int i) {
        super(context);
        this.q = 1;
        this.n = pkVar;
        this.qg = str;
        this.s = i;
        l();
    }

    private void l() {
        com.byazt.dj.s sVarN = this.fs.n(this.n, this.w, this, n());
        this.l = sVarN;
        sVarN.n(this.x);
        ((com.byazt.fq.n) n(com.byazt.fq.n.class)).n(this.qg);
        ((com.byazt.zct.n) n(com.byazt.zct.n.class)).n(this.qg);
        ((com.byazt.zct.n) n(com.byazt.zct.n.class)).n(this.s);
        if (n()) {
            ((com.byazt.zct.n) n(com.byazt.zct.n.class)).q(true);
        }
    }

    public void n(int i) {
        this.q = i;
        if (this.x != null) {
            this.x.n(i);
        }
    }

    public void n(tj tjVar) {
        this.x = tjVar;
    }

    public tj qg() {
        return this.x;
    }

    public void n(View view) {
        this.x.qg(view);
    }

    public void qg(View view) {
        this.x.n(view);
    }

    public void qg(int i) {
        this.x.q(i);
    }

    public void s(int i) {
        this.x.s(i);
    }

    public void q(int i) {
        this.x.qg(i);
    }

    @Override // com.byazt.ys.l
    public void n(View view, tj tjVar) {
        if (pk.w(this.n)) {
            return;
        }
        ((com.byazt.zct.n) n(com.byazt.zct.n.class)).n(((com.byazt.fq.n) n(com.byazt.fq.n.class)).l());
        this.l.n(view);
        if (tjVar == null) {
            tjVar = new tj();
        }
        w();
        this.l.n(tjVar);
        this.l.qg();
        pk.x(this.n);
    }

    private void w() {
        com.byazt.vhv.qg qgVar;
        try {
            pk pkVar = this.n;
            if (pkVar == null || !nf.rv(pkVar)) {
                return;
            }
            com.byazt.pnm.w wVarXk = rv.qg().xk();
            if ((wVarXk == null || wVarXk.tj()) && (qgVar = (com.byazt.vhv.qg) com.byazt.ikv.qg.s(this.n.ih(), com.byazt.vhv.qg.class)) != null) {
                qgVar.l();
            }
        } catch (Throwable unused) {
        }
    }
}
