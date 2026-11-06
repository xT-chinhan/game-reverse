package com.byazt.ou;

import android.view.ViewGroup;
import com.byazt.gct.g;
import com.byazt.gct.h;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 849, 26})
public class qg extends n {
    public Runnable w;

    public qg(pk pkVar, com.byazt.rg.n nVar) {
        super(pkVar, nVar, h.tj(pkVar));
        this.s = new com.byazt.whi.n(pkVar, h.tj(pkVar));
    }

    public void n(Runnable runnable) {
        this.w = runnable;
    }

    @Override // com.byazt.ou.n
    public void n(g gVar) {
        super.n(gVar);
        if (this.s != null) {
            this.s.n(gVar);
        }
    }

    @Override // com.byazt.rg.qg
    public void s() {
        Runnable runnable = this.w;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.ou.n
    public void n(ViewGroup viewGroup) {
        if (this.s != null) {
            this.s.qg(null);
        }
    }
}
