package com.byazt.sqs;

import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.h;
import com.byazt.pq.wm;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 707, 19})
public final class n implements a {
    public final wm n;

    public n(wm wmVar) {
        this.n = wmVar;
    }

    @Override // com.byazt.pq.a
    public bb n(a.n nVar) throws IOException {
        com.byazt.cri.x xVar = (com.byazt.cri.x) nVar;
        h hVarN = xVar.n();
        if (hVarN != null && hVarN.x != null) {
            hVarN.x.qg();
        }
        x xVarW = xVar.w();
        com.byazt.cri.s sVarN = xVarW.n(this.n, nVar, !hVarN.qg().equals(TapHttp.METHOD_GET));
        s sVarQg = xVarW.qg();
        if (hVarN != null && hVarN.x != null) {
            hVarN.x.s();
        }
        return xVar.n(hVarN, xVarW, sVarN, sVarQg);
    }
}
