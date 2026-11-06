package com.byazt.lbp;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 86})
public class cd implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "reward_dialog_callback", qg = "ALL")
    public com.byazt.aqe.tj n;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        com.byazt.aqe.tj tjVar = this.n;
        if (tjVar == null) {
            nVar.n(map2, (com.byazt.bds.n) null);
            return true;
        }
        tjVar.n();
        nVar.n(map2);
        return true;
    }
}
