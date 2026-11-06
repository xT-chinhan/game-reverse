package com.byazt.ou;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.g;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 849, 18})
public class l extends n {
    public final com.byazt.li.qg w;

    public l(pk pkVar, com.byazt.rg.n nVar, g gVar, com.byazt.li.qg qgVar) {
        super(pkVar, nVar, gVar);
        this.w = qgVar;
    }

    @Override // com.byazt.ou.n
    public com.byazt.li.qg l() {
        com.byazt.li.qg qgVar = this.w;
        return qgVar != null ? qgVar : super.l();
    }

    public void n(View view) {
        ViewGroup viewGroupS;
        if (view == null || this.q == null || !com.byazt.rg.q.n(this.q.q()) || (viewGroupS = com.byazt.rg.q.s(view)) == null) {
            return;
        }
        qg(viewGroupS, viewGroupS);
    }
}
