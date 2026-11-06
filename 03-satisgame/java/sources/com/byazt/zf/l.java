package com.byazt.zf;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, 18})
public class l extends qg {
    public com.byazt.qn.qg qg;

    public l(com.byazt.nw.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.ua.qg
    public void qg(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        com.byazt.yn.n nVarN;
        this.qg = qgVar2;
        if (qgVar2 == null) {
            n(new com.byazt.mj.n("load ad fail adSlot is null"));
            return;
        }
        if (map == null || (nVarN = n(context.getApplicationContext())) == null) {
            return;
        }
        boolean z = qgVar != null && qgVar.n();
        com.byazt.zq.qg.n nVarX = com.byazt.mt.qg.n(this.qg, qgVar, false).x(this.qg.um());
        int iOu = this.qg.ou();
        int iWm = this.qg.wm();
        if (iOu > 0 && iWm > 0) {
            nVarX.n(iOu).qg(iWm);
        }
        Object obj = map.get("tt_ad_origin_type");
        if (obj != null) {
            int iIntValue = ((Integer) obj).intValue();
            if (iIntValue == 1) {
                n(nVarN, nVarX, z);
                return;
            } else if (iIntValue == 2) {
                qg(nVarN, nVarX, z);
                return;
            } else {
                n(new com.byazt.mj.n("渲染类型错误"));
                return;
            }
        }
        n(new com.byazt.mj.n("渲染类型错误"));
    }

    private void n(com.byazt.yn.n nVar, com.byazt.zq.qg.n nVar2, boolean z) {
        if (this.qg.sz() > 0.0f) {
            nVar2.n(this.qg.oa()).qg(this.qg.sz());
        } else {
            nVar2.n(this.qg.oa()).qg(0.0f);
        }
        new q().n(z, nVar, nVar2.n(), this);
    }

    private void qg(com.byazt.yn.n nVar, com.byazt.zq.qg.n nVar2, boolean z) {
        new s().n(z, nVar, nVar2.n(), this);
    }
}
