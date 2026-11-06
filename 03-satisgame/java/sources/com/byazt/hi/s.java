package com.byazt.hi;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 8})
public abstract class s {
    public Context n;
    public tj.n q;
    public ViewGroup qg;
    public pk s;

    public abstract String n();

    public abstract void n(com.byazt.ys.n nVar);

    public void n(boolean z) {
    }

    public void n(Context context, ViewGroup viewGroup, pk pkVar) {
        this.n = context;
        this.qg = viewGroup;
        this.s = pkVar;
    }

    public void n(com.byazt.ia.q qVar, tj.n nVar) {
        com.byazt.hm.n.s(this.s, "splash_ad", n());
        this.qg.setVisibility(0);
        this.q = nVar;
    }

    public void qg() {
        tj.n nVar = this.q;
        if (nVar != null) {
            nVar.qg();
        }
    }
}
