package com.byazt.ck;

import android.content.Context;
import android.view.View;
import com.byazt.ap.w;
import com.byazt.fb.l;
import com.byazt.gl.q;
import com.byazt.np.cp;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1900, 8})
public class s implements l {
    public final com.byazt.pch.n n;
    public boolean q;
    public final w qg;
    public cp s;

    public s(Context context, com.byazt.pch.n nVar, w wVar, boolean z) {
        this.n = nVar;
        this.qg = wVar;
        this.q = z;
        if (nVar != null) {
            this.s = new cp(context);
        }
    }

    @Override // com.byazt.fb.l
    public void n() {
        final com.byazt.he.qg qgVarTj;
        com.byazt.qn.qg qgVar = new com.byazt.qn.qg(1, this.n.lh(), this.n.an());
        qgVar.n(this.q);
        com.byazt.pch.qg qgVarUr = this.n.ur();
        if (qgVarUr != null && (qgVarTj = qgVarUr.tj()) != null) {
            this.s.n(new q() { // from class: com.byazt.ck.s.1
                @Override // com.byazt.gl.q
                public View n(com.byazt.gl.s sVar) {
                    if (sVar != null) {
                        return qgVarTj.n(new com.byazt.zj.s(sVar));
                    }
                    return null;
                }
            });
        }
        this.s.n(qgVar, new com.byazt.gl.qg() { // from class: com.byazt.ck.s.2
            @Override // com.byazt.gl.qg
            public void n(com.byazt.mj.n nVar) {
                if (s.this.qg != null) {
                    s.this.qg.n(nVar.n, nVar.qg);
                }
            }

            @Override // com.byazt.gl.qg
            public void n() {
                if (s.this.qg != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new n(s.this.s));
                    s.this.qg.n(arrayList);
                }
            }
        });
    }
}
