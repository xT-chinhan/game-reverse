package com.byazt.gv;

import com.anythink.core.api.ATAdConst;
import com.byazt.qp.q;
import com.byazt.tk.rv;
import com.byazt.vf.t;
import com.byazt.vyf.s;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 687, 26})
public class qg {
    public int n = 10000;
    public Runnable q;
    public int qg;
    public long s;

    public qg(int i) {
        this.qg = i;
    }

    public qg n(int i) {
        this.n = i <= 0 ? 10000 : i * 1000;
        return this;
    }

    public void n(final Runnable runnable) {
        this.s = System.currentTimeMillis();
        if (!n.w()) {
            qg(runnable);
            return;
        }
        if (s.cy().lh()) {
            qg(2);
            n();
        } else if (!n.n()) {
            qg(runnable);
        } else {
            rv.n().postDelayed(new Runnable() { // from class: com.byazt.gv.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    if (s.cy().lh()) {
                        qg.this.qg(2);
                        qg.this.n();
                    } else {
                        qg.this.qg(runnable);
                    }
                }
            }, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(Runnable runnable) {
        t tVar = (t) q.n(ATAdConst.KEY.M_S);
        if (tVar != null && tVar.qg(0, this.qg, true)) {
            qg(3);
            n();
        } else if (runnable != null) {
            qg(1);
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Runnable runnable = this.q;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        System.currentTimeMillis();
    }
}
