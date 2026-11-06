package com.byazt.tx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.de.w;
import com.byazt.de.x;
import com.byazt.gct.g;
import com.byazt.gct.h;
import com.byazt.gct.pk;
import com.byazt.rg.l;
import com.byazt.wea.fs;
import com.byazt.wea.rv;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1052, 26})
public class qg {
    public pk n;
    public g q;
    public com.byazt.ou.qg qg;
    public com.byazt.ou.s s;

    public qg(pk pkVar, com.byazt.rg.n nVar) {
        this.n = pkVar;
        if (h.qg(pkVar)) {
            this.qg = new com.byazt.ou.qg(this.n, nVar);
        } else if (h.q(this.n)) {
            this.s = new com.byazt.ou.s(this.n, nVar);
        }
        if (pkVar == null || !h.n(pkVar)) {
            return;
        }
        w.n(pkVar, String.valueOf(com.byazt.vgx.w.cy(pkVar)), com.byazt.vgx.w.d(pkVar), h.qg(pkVar) ? 1 : 2, x.n(pkVar));
        final int iW = h.w(this.n);
        w.n().n(x.n(pkVar), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.qg.1
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof rv) {
                    ((rv) fsVar).rv = iW;
                }
            }
        });
        com.byazt.de.qg.n().n(x.n(pkVar), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.qg.2
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.q) {
                    ((com.byazt.wea.q) fsVar).hd = iW;
                }
            }
        });
    }

    public qg(pk pkVar, com.byazt.rg.n nVar, com.byazt.zq.qg qgVar, Context context) {
        this(pkVar, nVar);
        com.byazt.ou.qg qgVar2 = this.qg;
        if (qgVar2 != null) {
            qgVar2.n(qgVar);
            this.qg.n(context);
        }
    }

    public void n() {
        com.byazt.ou.qg qgVar;
        if (h.qg(this.n)) {
            g gVarN = n(h.oa(this.n));
            this.q = gVarN;
            if (gVarN == null || (qgVar = this.qg) == null) {
                return;
            }
            qgVar.n(gVarN);
        }
    }

    public void n(final ViewGroup viewGroup, final View view) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new Runnable() { // from class: com.byazt.tx.qg.3
            @Override // java.lang.Runnable
            public void run() {
                qg.this.q(viewGroup, view);
                if (h.qg(qg.this.n)) {
                    qg.this.qg(viewGroup, view);
                } else if (h.q(qg.this.n)) {
                    qg.this.s(viewGroup, view);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(ViewGroup viewGroup, View view) {
        if (this.q == null) {
            n();
        }
        final g gVar = this.q;
        if (gVar == null) {
            return;
        }
        w.n().n(x.n(this.n), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.qg.4
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof rv) {
                    rv rvVar = (rv) fsVar;
                    rvVar.fs = gVar.l();
                    rvVar.cp = gVar.q();
                }
            }
        });
        com.byazt.de.qg.n().n(x.n(this.n), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.qg.5
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.q) {
                    ((com.byazt.wea.q) fsVar).cy = gVar.l();
                }
            }
        });
        w.qg(x.n(this.n));
        com.byazt.rg.s.n(this.n, gVar);
        if (h.oa(this.n)) {
            n(gVar);
        }
        boolean z = gVar.q() == 0;
        com.byazt.ou.qg qgVar = this.qg;
        if (qgVar != null) {
            if (z) {
                view = viewGroup;
            }
            qgVar.qg(viewGroup, view);
        }
    }

    private g n(boolean z) {
        if (!z) {
            return h.tj(this.n);
        }
        g gVarN = com.byazt.rg.fs.n().n(this.n);
        if (gVarN != null) {
            return gVarN;
        }
        List<g> listCp = h.cp(this.n);
        if (listCp.isEmpty()) {
            return null;
        }
        return listCp.get(0);
    }

    private void n(g gVar) {
        final String strL = gVar.l();
        final int iW = h.w(this.n);
        com.byazt.ou.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n(new Runnable() { // from class: com.byazt.tx.qg.6
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.rg.fs.n().n(iW, strL);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ViewGroup viewGroup, View view) {
        final h.n nVarRv = h.rv(this.n);
        if (nVarRv == null) {
            return;
        }
        w.n().n(x.n(this.n), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.qg.7
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof rv) {
                    rv rvVar = (rv) fsVar;
                    rvVar.fs = nVarRv.l();
                    rvVar.cp = nVarRv.q();
                }
            }
        });
        com.byazt.de.qg.n().n(x.n(this.n), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.qg.8
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.q) {
                    ((com.byazt.wea.q) fsVar).cy = nVarRv.l();
                }
            }
        });
        w.qg(x.n(this.n));
        com.byazt.rg.s.n(this.n, nVarRv);
        boolean z = nVarRv.q() == 0;
        com.byazt.ou.s sVar = this.s;
        if (sVar != null) {
            if (z) {
                view = viewGroup;
            }
            sVar.qg(viewGroup, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("easy_play_tag".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("easy_play_tag".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                }
            }
        }
    }

    public l qg() {
        com.byazt.ou.s sVar;
        com.byazt.ou.qg qgVar;
        if (h.qg(this.n) && (qgVar = this.qg) != null) {
            return qgVar.n();
        }
        if (h.q(this.n) && (sVar = this.s) != null) {
            return sVar.n();
        }
        return new l() { // from class: com.byazt.tx.qg.9
            @Override // com.byazt.rg.l
            public void fs() {
            }

            @Override // com.byazt.rg.l
            public void l() {
            }

            @Override // com.byazt.rg.l
            public void n() {
            }

            @Override // com.byazt.rg.l
            public void n(int i) {
            }

            @Override // com.byazt.rg.l
            public void n(int i, long j) {
            }

            @Override // com.byazt.rg.l
            public void n(long j, long j2) {
            }

            @Override // com.byazt.rg.l
            public void n(boolean z) {
            }

            @Override // com.byazt.rg.l
            public void q() {
            }

            @Override // com.byazt.rg.l
            public void qg() {
            }

            @Override // com.byazt.rg.l
            public void qg(boolean z) {
            }

            @Override // com.byazt.rg.l
            public void s() {
            }

            @Override // com.byazt.rg.l
            public void w() {
            }

            @Override // com.byazt.rg.l
            public void x() {
            }
        };
    }

    public void n(com.byazt.dc.qg qgVar, int i) {
        com.byazt.ou.s sVar = this.s;
        if (sVar != null) {
            sVar.n(qgVar, i);
        }
        com.byazt.ou.qg qgVar2 = this.qg;
        if (qgVar2 != null) {
            qgVar2.n(qgVar, i);
        }
    }

    public void s() {
        com.byazt.ou.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.x();
        }
        com.byazt.ou.s sVar = this.s;
        if (sVar != null) {
            sVar.q();
        }
    }
}
