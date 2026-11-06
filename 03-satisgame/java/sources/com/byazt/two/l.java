package com.byazt.two;

import com.byazt.tbt.cy;
import com.byazt.tbt.rv;
import com.byazt.tbt.sz;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 802, 18})
public class l implements rv {
    @Override // com.byazt.tbt.rv
    public cy n(rv.n nVar) throws IOException {
        IOException iOException;
        sz szVarN = nVar.n();
        if (n.qg == null) {
            return nVar.n(szVarN);
        }
        n.qg.fs();
        String strS = szVarN.s();
        String strN = n.qg.n(strS);
        if (strS != null && !strS.equals(strN)) {
            szVarN = szVarN.rv().qg(strN).qg();
        }
        x.n(szVarN.qg().toString());
        cy cyVarN = null;
        try {
            iOException = null;
            cyVarN = nVar.n(szVarN);
        } catch (Exception e) {
            if (e instanceof IOException) {
                iOException = (IOException) e;
            } else {
                iOException = new IOException(e);
            }
            n.qg.n(szVarN, e);
        }
        n.qg.n(szVarN, cyVarN);
        if (iOException == null) {
            return cyVarN;
        }
        throw iOException;
    }
}
