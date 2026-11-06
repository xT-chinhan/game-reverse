package com.byazt.xdp;

import android.view.View;
import com.byazt.aqe.tj;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1162, 5})
public class q extends s {
    public q(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, com.byazt.re.qg qgVar, com.byazt.re.l lVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, qgVar, lVar, z);
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void s(View view) {
        super.s(view);
        this.w.s(this.q.f());
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void qg(View view) {
        super.qg(view);
        this.w.f();
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void n(View view) {
        super.n(view);
        if (n()) {
            return;
        }
        this.w.ri().qg();
        if (this.q.df()) {
            this.w.qg();
        } else if (this.w.nf().nf()) {
            qg();
        } else {
            s();
        }
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void w(View view) {
        super.w(view);
        n(view);
    }

    private void qg() {
        tj tjVar = new tj() { // from class: com.byazt.xdp.q.1
            @Override // com.byazt.aqe.tj
            public void qg() {
                q.this.w.qg();
            }
        };
        if (n(tjVar)) {
            this.x--;
        } else {
            tjVar.qg();
        }
    }

    private void s() {
        this.w.qg();
    }

    @Override // com.byazt.xdp.s
    public boolean n(tj tjVar) {
        if (this.s != null) {
            return this.w.qg(this.s, tjVar);
        }
        return this.w.qg(this.qg, tjVar);
    }
}
