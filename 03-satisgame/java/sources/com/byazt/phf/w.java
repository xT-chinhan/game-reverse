package com.byazt.phf;

import com.byazt.tbt.cy;
import com.byazt.tbt.rv;
import com.byazt.tbt.sz;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1735, 13})
public class w implements rv {
    @Override // com.byazt.tbt.rv
    public cy n(rv.n nVar) throws IOException {
        sz szVarN = nVar.n();
        l lVarN = szVarN == null ? null : x.n(szVarN.n());
        if (szVarN != null) {
            x.qg(szVarN.n());
        }
        if (lVarN == null) {
            return nVar.n(szVarN);
        }
        if (lVarN.n("networkFinal")) {
            throw new IOException("request_drop_intercept");
        }
        return nVar.n(szVarN);
    }
}
