package com.byazt.ez;

import android.app.Activity;
import com.byazt.aqe.tj;
import com.byazt.gct.dh;
import com.byazt.gct.pk;
import com.byazt.mr.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1378, 26})
public class qg extends n {
    public w qg;

    @Override // com.byazt.aqe.qg
    public String n() {
        return "恭喜您已经获得奖励，是否要继续观看视频，再得超值奖励";
    }

    public qg(Activity activity, pk pkVar) {
        super(activity, pkVar);
        this.qg = null;
    }

    @Override // com.byazt.ez.n, com.byazt.aqe.qg
    public com.byazt.aqe.qg.n n(final tj tjVar) {
        com.byazt.aqe.qg.n nVarN = super.n(tjVar);
        if (nVarN.s()) {
            return nVarN;
        }
        final w wVar = new w(this.fs);
        this.qg = wVar;
        wVar.l("tt_retain_gift").n(n()).s(dh.n(this.x, this.cp, this.d)).q("坚持退出");
        wVar.n(com.byazt.cb.qg.rv(this.fs));
        this.qg.n(new w.n() { // from class: com.byazt.ez.qg.1
            @Override // com.byazt.mr.w.n
            public void n() {
                tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n();
                }
            }

            @Override // com.byazt.mr.w.n
            public void qg() {
                wVar.dismiss();
                tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.qg();
                }
            }
        });
        this.qg.show();
        return new com.byazt.aqe.qg.n(true, 0, "", this.qg);
    }

    @Override // com.byazt.aqe.qg
    public boolean qg() {
        w wVar = this.qg;
        return wVar != null && wVar.isShowing();
    }

    @Override // com.byazt.aqe.qg
    public void s() {
        w wVar = this.qg;
        if (wVar != null) {
            wVar.dismiss();
        }
    }

    @Override // com.byazt.aqe.qg
    public void q() {
        w wVar = this.qg;
        if (wVar != null) {
            wVar.n();
        }
    }

    @Override // com.byazt.aqe.qg
    public void l() {
        w wVar = this.qg;
        if (wVar != null) {
            wVar.qg();
        }
    }
}
