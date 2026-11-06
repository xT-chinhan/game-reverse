package com.byazt.ss;

import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1334, 26})
public class qg extends n {
    public List<com.byazt.vt.q> rv;

    public qg(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
        super(sVar, str, nVar);
        this.rv = new CopyOnWriteArrayList();
    }

    @Override // com.byazt.ss.n
    public void n() {
        Object obj;
        com.byazt.vt.s sVarN;
        if (this.w == null || this.w.size() <= 0 || (obj = this.w.get(TapEventParamConstants.PARAM_NAME)) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        com.byazt.vt.n nVarOj = this.s.oj();
        if (nVarOj == null || (sVarN = nVarOj.n(strValueOf)) == null) {
            return;
        }
        sVarN.n(strValueOf);
    }
}
