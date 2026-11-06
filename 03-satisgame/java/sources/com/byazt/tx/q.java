package com.byazt.tx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.de.w;
import com.byazt.gct.g;
import com.byazt.gct.h;
import com.byazt.gct.pk;
import com.byazt.gct.rf;
import com.byazt.ou.x;
import com.byazt.wea.fs;
import com.byazt.wea.rv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1052, 5})
public class q {
    public List<x> l;
    public pk n;
    public Context q;
    public com.byazt.zq.qg qg;
    public com.byazt.rg.n s;

    public q(pk pkVar, com.byazt.rg.n nVar) {
        this.n = pkVar;
        this.s = nVar;
        this.l = new ArrayList();
        if (pkVar == null || !rf.qg(pkVar)) {
            return;
        }
        w.n(pkVar, String.valueOf(com.byazt.vgx.w.cy(pkVar)), com.byazt.vgx.w.d(pkVar), 3, com.byazt.de.x.n(pkVar));
        final int iW = h.w(this.n);
        w.n().n(com.byazt.de.x.n(pkVar), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.q.1
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof rv) {
                    ((rv) fsVar).rv = iW;
                }
            }
        });
        com.byazt.de.qg.n().n(com.byazt.de.x.n(pkVar), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.q.2
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.q) {
                    ((com.byazt.wea.q) fsVar).hd = iW;
                }
            }
        });
    }

    public q(pk pkVar, com.byazt.rg.n nVar, com.byazt.zq.qg qgVar, Context context) {
        this(pkVar, nVar);
        this.qg = qgVar;
        this.q = context;
    }

    public void n(ViewGroup viewGroup, View view) {
        final List<g> listN;
        qg(viewGroup, view);
        if (!rf.qg(this.n) || (listN = rf.n(this.n)) == null || listN.isEmpty()) {
            return;
        }
        if (listN.get(0) != null) {
            w.n().n(com.byazt.de.x.n(this.n), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.q.3
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof rv) {
                        rv rvVar = (rv) fsVar;
                        rvVar.fs = ((g) listN.get(0)).l();
                        rvVar.cp = ((g) listN.get(0)).q();
                    }
                }
            });
            com.byazt.de.qg.n().n(com.byazt.de.x.n(this.n), new com.byazt.bok.qg.n() { // from class: com.byazt.tx.q.4
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).cy = ((g) listN.get(0)).l();
                    }
                }
            });
        }
        w.qg(com.byazt.de.x.n(this.n));
        for (g gVar : listN) {
            if (gVar != null) {
                com.byazt.rg.s.n(this.n, gVar);
                x xVar = new x(this.n, this.s, gVar);
                xVar.n(this.qg);
                xVar.n(this.q);
                xVar.qg(viewGroup, gVar.q() == 0 ? viewGroup : view);
                this.l.add(xVar);
            }
        }
    }

    private void qg(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("overlay_tag".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("overlay_tag".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                }
            }
        }
    }

    public void n() {
        for (x xVar : this.l) {
            if (xVar != null) {
                xVar.n((com.byazt.zq.qg) null);
                xVar.n((Context) null);
                xVar.x();
            }
        }
        this.l.clear();
    }
}
