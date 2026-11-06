package com.byazt.udb;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1064, 13})
public class w implements tj {
    public Context n;
    public n qg;
    public oa s;

    @Override // com.byazt.udb.tj
    public void qg(boolean z) {
    }

    public w(Context context, oa oaVar, n nVar) {
        this.n = context;
        this.qg = nVar;
        this.s = oaVar;
    }

    @Override // com.byazt.udb.tj
    public boolean n(final tj.n nVar) {
        this.s.x().rv();
        this.qg.n(new x() { // from class: com.byazt.udb.w.1
            @Override // com.byazt.udb.x
            public void n(View view, sz szVar) {
                if (nVar.s()) {
                    return;
                }
                k kVarQg = nVar.qg();
                if (kVarQg != null) {
                    kVarQg.n(w.this.qg, szVar);
                }
                nVar.n(true);
            }

            @Override // com.byazt.udb.x
            public void n(int i, String str) {
                k kVarQg = nVar.qg();
                if (kVarQg != null) {
                    kVarQg.a_(i);
                }
            }
        });
        return true;
    }

    public void n(s sVar) {
        this.qg.n(sVar);
    }
}
