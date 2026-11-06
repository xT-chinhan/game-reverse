package com.byazt.xdp;

import android.view.View;
import com.byazt.aqe.tj;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.ep.cp;
import com.byazt.gct.cd;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1162, 18})
public class l extends s {
    public l(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, com.byazt.re.qg qgVar, com.byazt.re.l lVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, qgVar, lVar, z);
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void s(View view) {
        super.s(view);
        this.w.s("playable");
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void qg(View view) {
        super.qg(view);
        if (cd.q(this.qg)) {
            this.w.ae();
        } else {
            this.w.f();
        }
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void n(View view) {
        super.n(view);
        if (n()) {
            return;
        }
        this.w.ri().n();
        if (cd.oa(this.qg) || cp.l(this.qg) || cp.q(this.qg)) {
            this.w.tj();
            return;
        }
        tj tjVar = new tj() { // from class: com.byazt.xdp.l.1
            @Override // com.byazt.aqe.tj
            public void qg() {
                l.this.w.k();
                l.this.w.qg();
            }
        };
        if (n(tjVar)) {
            this.x--;
        } else {
            tjVar.qg();
        }
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void w(View view) {
        super.w(view);
        if (cp.l(this.qg) || cp.q(this.qg)) {
            this.w.tj();
        } else {
            n();
        }
    }
}
