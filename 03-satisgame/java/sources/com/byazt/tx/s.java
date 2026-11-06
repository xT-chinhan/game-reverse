package com.byazt.tx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.g;
import com.byazt.gct.pk;
import com.byazt.gct.t;
import com.byazt.ou.fs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1052, 8})
public class s {
    public Context l;
    public final pk n;
    public com.byazt.zq.qg q;
    public final com.byazt.rg.n qg;
    public final List<com.byazt.ou.n> s;

    public s(pk pkVar, com.byazt.rg.n nVar) {
        this.n = pkVar;
        this.qg = nVar;
        this.s = new ArrayList();
    }

    public s(pk pkVar, com.byazt.rg.n nVar, com.byazt.zq.qg qgVar, Context context) {
        this(pkVar, nVar);
        this.q = qgVar;
        this.l = context;
    }

    public void n(ViewGroup viewGroup, View view) {
        List<g> listQ;
        qg(viewGroup, view);
        if (!t.qg(this.n) || (listQ = t.q(this.n)) == null || listQ.isEmpty()) {
            return;
        }
        for (g gVar : listQ) {
            if (gVar != null) {
                com.byazt.rg.s.n(this.n, gVar);
                com.byazt.ou.q qVar = new com.byazt.ou.q(this.n, this.qg, gVar);
                qVar.n(this.q);
                qVar.n(this.l);
                qVar.qg(viewGroup, gVar.q() == 0 ? viewGroup : view);
                this.s.add(qVar);
            }
        }
    }

    public fs n() {
        g gVarS = t.s(this.n);
        if (gVarS == null) {
            return null;
        }
        com.byazt.rg.s.n(this.n, gVarS);
        fs fsVar = new fs(this.n, this.qg, gVarS);
        fsVar.n(this.q);
        fsVar.n(this.l);
        this.s.add(fsVar);
        return fsVar;
    }

    private void qg(ViewGroup viewGroup, View view) {
        n(viewGroup);
        if (view instanceof ViewGroup) {
            n((ViewGroup) view);
        }
    }

    private void n(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("effects_tag".equals(childAt.getTag())) {
                viewGroup.removeView(childAt);
            }
        }
    }

    public void qg() {
        for (com.byazt.ou.n nVar : this.s) {
            if (nVar != null) {
                nVar.n((com.byazt.zq.qg) null);
                nVar.n((Context) null);
                nVar.x();
            }
        }
        this.s.clear();
    }
}
