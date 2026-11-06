package com.byazt.xdp;

import android.view.View;
import com.byazt.aqe.tj;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.has.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1162, 13})
public class w extends s {
    public w(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, com.byazt.re.qg qgVar, com.byazt.re.l lVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, qgVar, lVar, z);
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void s(View view) {
        super.s(view);
        this.w.s("video_player");
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void qg(View view) {
        super.qg(view);
        if (this.w.nf() instanceof fs) {
            this.w.f();
        }
        this.w.ae();
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void n(View view) {
        super.n(view);
        if (n()) {
            return;
        }
        this.w.ri().n();
        if (this.w.nf().nf()) {
            qg();
        } else {
            s();
        }
    }

    private void qg() {
        tj tjVar = new tj() { // from class: com.byazt.xdp.w.1
            @Override // com.byazt.aqe.tj
            public void qg() {
                w.this.w.k();
                w.this.w.fi().postDelayed(new Runnable() { // from class: com.byazt.xdp.w.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.w.qg();
                    }
                }, 100L);
            }
        };
        int i = 2;
        int iL = this.w.l(2);
        if (this.qg.yj() == 7) {
            if (this.qg.vg() && !this.w.pe()) {
                i = 1;
            }
            iL = i;
        }
        if (iL == 1) {
            if (n(tjVar)) {
                return;
            }
            tjVar.qg();
            return;
        }
        this.w.s();
    }

    private void s() {
        tj tjVar = new tj() { // from class: com.byazt.xdp.w.2
            @Override // com.byazt.aqe.tj
            public void qg() {
                w.this.w.s();
            }
        };
        if (n(tjVar)) {
            return;
        }
        tjVar.qg();
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void w(View view) {
        super.w(view);
        n(view);
    }

    @Override // com.byazt.xdp.s, com.byazt.xdp.qg
    public void x(View view) {
        super.x(view);
        this.w.ci();
    }
}
