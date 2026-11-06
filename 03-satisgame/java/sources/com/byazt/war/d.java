package com.byazt.war;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 113})
public class d extends n {
    @Override // com.byazt.war.rv
    public String n() {
        return "raw_cache";
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        byte[] bArrN = sVar.py().qg(sVar.ou()).n(sVar.w());
        if (bArrN == null) {
            if (sVar.hd()) {
                sVar.n(new oa());
                return;
            } else {
                sVar.n(new w());
                return;
            }
        }
        sVar.n(new qg(bArrN, null));
    }
}
