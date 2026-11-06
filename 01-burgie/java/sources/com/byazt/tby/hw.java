package com.byazt.tby;

import com.byazt.dd.fw;
import com.taptap.sdk.db.constant.Common;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 225, 13})
public class hw extends pr {
    public List<com.byazt.mj.x> aj;

    public hw(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
        super(hnVar, str, prVar);
        this.aj = new CopyOnWriteArrayList();
    }

    @Override // com.byazt.tby.pr
    public void pr() {
        Object obj;
        com.byazt.mj.hn hnVarPr;
        if (this.uc == null || this.uc.size() <= 0 || (obj = this.uc.get(Common.System.NAME)) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        com.byazt.mj.pr prVarQi = this.hn.qi();
        if (prVarQi != null && (hnVarPr = prVarQi.pr(strValueOf)) != null) {
            hnVarPr.pr(strValueOf);
        }
    }
}
